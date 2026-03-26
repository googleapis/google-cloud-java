/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.jdbc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlTimeoutException;
import com.google.rpc.Code;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/** Tests setting a statement timeout. */
@RunWith(Parameterized.class)
public class JdbcStatementTimeoutTest extends AbstractMockServerTest {

  @Parameter public boolean useVirtualThreads;

  @Parameters(name = "useVirtualThreads = {0}")
  public static Object[] data() {
    return new Boolean[] {false, true};
  }

  @Override
  protected String getBaseUrl() {
    return super.getBaseUrl() + ";useVirtualThreads=" + this.useVirtualThreads;
  }

  @After
  public void resetExecutionTimes() {
    mockSpanner.removeAllExecutionTimes();
  }

  @Test
  public void testExecuteTimeout() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      try (Statement statement = connection.createStatement()) {
        // First verify that execute does not time out by default.
        assertFalse(statement.execute(INSERT_STATEMENT.getSql()));
        int result = statement.getUpdateCount();
        assertEquals(1, result);

        // Simulate that executeSql takes 2 seconds and set a statement timeout of 1 second.
        mockSpanner.setExecuteSqlExecutionTime(
            SimulatedExecutionTime.ofMinimumAndRandomTime(2000, 0));
        ((JdbcStatement) statement).setQueryTimeout(Duration.ofMillis(5L));
        assertThrows(
            JdbcSqlTimeoutException.class, () -> statement.execute(INSERT_STATEMENT.getSql()));
      }
    }
  }

  @Test
  public void testExecuteQueryTimeout() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      try (Statement statement = connection.createStatement()) {
        // First verify that executeQuery does not time out by default.
        try (ResultSet resultSet = statement.executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
          int count = 0;
          while (resultSet.next()) {
            count++;
          }
          assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
        }

        // Simulate that executeStreamingSql takes 2 seconds and set a statement timeout of 1
        // second.
        mockSpanner.setExecuteStreamingSqlExecutionTime(
            SimulatedExecutionTime.ofMinimumAndRandomTime(2000, 0));
        ((JdbcStatement) statement).setQueryTimeout(Duration.ofMillis(5L));
        assertThrows(
            JdbcSqlTimeoutException.class,
            () -> statement.executeQuery(SELECT_RANDOM_STATEMENT.getSql()));
      }
    }
  }

  @Test
  public void testExecuteUpdateTimeout() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      try (Statement statement = connection.createStatement()) {
        // First verify that executeUpdate does not time out by default.
        assertEquals(1, statement.executeUpdate(INSERT_STATEMENT.getSql()));

        // Simulate that executeSql takes 2 seconds and set a statement timeout of 1 second.
        mockSpanner.setExecuteSqlExecutionTime(
            SimulatedExecutionTime.ofMinimumAndRandomTime(2000, 0));
        ((JdbcStatement) statement).setQueryTimeout(Duration.ofMillis(5L));
        assertThrows(
            JdbcSqlTimeoutException.class,
            () -> statement.executeUpdate(INSERT_STATEMENT.getSql()));
      }
    }
  }

  @Test
  public void testExecuteBatchTimeout() throws SQLException {
    try (java.sql.Connection connection = createJdbcConnection()) {
      try (Statement statement = connection.createStatement()) {
        // First verify that batch dml does not time out by default.
        statement.addBatch(INSERT_STATEMENT.getSql());
        int[] result = statement.executeBatch();
        assertArrayEquals(new int[] {1}, result);

        // Simulate that executeBatchDml takes 2 seconds and set a statement timeout of 1 second.
        mockSpanner.setExecuteBatchDmlExecutionTime(
            SimulatedExecutionTime.ofMinimumAndRandomTime(2000, 0));
        ((JdbcStatement) statement).setQueryTimeout(Duration.ofMillis(5L));
        statement.addBatch(INSERT_STATEMENT.getSql());
        assertThrows(JdbcSqlTimeoutException.class, statement::executeBatch);
      }
    }
  }

  @Test
  public void testCancel() throws Exception {
    ExecutorService service = Executors.newSingleThreadExecutor();
    String sql = INSERT_STATEMENT.getSql();

    try (java.sql.Connection connection = createJdbcConnection();
        Statement statement = connection.createStatement()) {
      mockSpanner.freeze();
      Future<Void> future =
          service.submit(
              () -> {
                // Wait until the request has landed on the server and then cancel the statement.
                mockSpanner.waitForRequestsToContain(
                    message ->
                        message instanceof ExecuteSqlRequest
                            && ((ExecuteSqlRequest) message).getSql().equals(sql),
                    5000L);
                statement.cancel();
                return null;
              });
      JdbcSqlExceptionImpl exception =
          assertThrows(JdbcSqlExceptionImpl.class, () -> statement.execute(sql));
      assertEquals(Code.CANCELLED, exception.getCode());
      assertNull(future.get());
    } finally {
      mockSpanner.unfreeze();
      service.shutdown();
    }
  }
}
