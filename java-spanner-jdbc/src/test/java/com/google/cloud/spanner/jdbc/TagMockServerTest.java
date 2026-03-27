/*
 * Copyright 2023 Google LLC
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
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TagMockServerTest extends AbstractMockServerTest {
  private static final String SELECT_RANDOM_SQL = SELECT_RANDOM_STATEMENT.getSql();

  private static final String INSERT_SQL = INSERT_STATEMENT.getSql();

  @Parameter public Dialect dialect;

  private Dialect currentDialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Before
  public void setupDialect() {
    if (this.dialect != currentDialect) {
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(this.dialect));
      this.currentDialect = dialect;
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  private String getVariablePrefix() {
    return dialect == Dialect.POSTGRESQL ? "spanner." : "";
  }

  private String createUrl() {
    return String.format(
        "jdbc:cloudspanner://localhost:%d/projects/%s/instances/%s/databases/%s?usePlainText=true;autoCommit=false",
        getPort(), "proj", "inst", "db" + (dialect == Dialect.POSTGRESQL ? "pg" : ""));
  }

  @Override
  protected Connection createJdbcConnection() throws SQLException {
    return DriverManager.getConnection(createUrl());
  }

  @Test
  public void testStatementTagForQuery() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .createStatement()
          .execute(String.format("set %sstatement_tag='my-tag'", getVariablePrefix()));
      try (ResultSet resultSet = connection.createStatement().executeQuery(SELECT_RANDOM_SQL)) {
        assertTrue(resultSet.next());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("my-tag", request.getRequestOptions().getRequestTag());

      // Verify that the tag is cleared after having been used.
      mockSpanner.clearRequests();
      try (ResultSet resultSet = connection.createStatement().executeQuery(SELECT_RANDOM_SQL)) {
        assertTrue(resultSet.next());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("", request.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testTransactionTagForQuery() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .createStatement()
          .execute(String.format("set %stransaction_tag='my-tag'", getVariablePrefix()));
      try (ResultSet resultSet = connection.createStatement().executeQuery(SELECT_RANDOM_SQL)) {
        assertTrue(resultSet.next());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("my-tag", request.getRequestOptions().getTransactionTag());

      // Verify that the tag is used for the entire transaction.
      mockSpanner.clearRequests();
      try (ResultSet resultSet = connection.createStatement().executeQuery(SELECT_RANDOM_SQL)) {
        assertTrue(resultSet.next());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("my-tag", request.getRequestOptions().getTransactionTag());

      // Verify that committing the transaction will remove the transaction tag.
      connection.commit();

      mockSpanner.clearRequests();
      try (ResultSet resultSet = connection.createStatement().executeQuery(SELECT_RANDOM_SQL)) {
        assertTrue(resultSet.next());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
      assertEquals("", request.getRequestOptions().getTransactionTag());
    }
  }

  @Test
  public void testStatementTagForBatchDml() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .createStatement()
          .execute(String.format("set %sstatement_tag='my-tag'", getVariablePrefix()));

      try (Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_SQL);
        statement.addBatch(INSERT_SQL);
        assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      ExecuteBatchDmlRequest request =
          mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertEquals("my-tag", request.getRequestOptions().getRequestTag());

      // Verify that the tag is cleared after having been used.
      mockSpanner.clearRequests();
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_SQL);
        statement.addBatch(INSERT_SQL);
        assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      request = mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertEquals("", request.getRequestOptions().getRequestTag());
    }
  }

  @Test
  public void testTransactionTagForBatchDml() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .createStatement()
          .execute(String.format("set %stransaction_tag='my-tag'", getVariablePrefix()));

      try (Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_SQL);
        statement.addBatch(INSERT_SQL);
        assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      ExecuteBatchDmlRequest request =
          mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertEquals("my-tag", request.getRequestOptions().getTransactionTag());

      // Verify that the tag is used for the entire transaction.
      mockSpanner.clearRequests();
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_SQL);
        statement.addBatch(INSERT_SQL);
        assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      request = mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertEquals("my-tag", request.getRequestOptions().getTransactionTag());

      // Verify that committing the transaction will remove the transaction tag.
      connection.commit();
      mockSpanner.clearRequests();
      try (Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_SQL);
        statement.addBatch(INSERT_SQL);
        assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
      }
      assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
      request = mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
      assertEquals("", request.getRequestOptions().getTransactionTag());
    }
  }

  @Test
  public void testStatementTagInHint() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  dialect == Dialect.POSTGRESQL
                      ? "/*@statement_tag='test-tag'*/SELECT 1"
                      : "@{statement_tag='test-tag'}SELECT 1")) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(1));
        assertFalse(resultSet.next());
      }
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    ExecuteSqlRequest request = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).get(0);
    assertEquals("test-tag", request.getRequestOptions().getRequestTag());
  }
}
