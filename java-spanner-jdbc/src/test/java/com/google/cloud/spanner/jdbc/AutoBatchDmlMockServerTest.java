/*
 * Copyright 2024 Google LLC
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

import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AutoBatchDmlMockServerTest extends AbstractMockServerTest {
  private static final String NON_PARAMETERIZED_INSERT =
      "insert into foo (id, value) values (1, 'One')";
  private static final String NON_PARAMETERIZED_UPDATE = "update foo set value='Zero' where id=0";
  private static final String PARAMETERIZED_INSERT =
      "insert into foo (id, value) values (@p1, @p2)";
  private static final String PARAMETERIZED_UPDATE = "update foo set value=@p1 where id=@p2";

  @BeforeClass
  public static void setup() {
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.of(NON_PARAMETERIZED_INSERT), 1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.of(NON_PARAMETERIZED_UPDATE), 1L));

    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.newBuilder(PARAMETERIZED_INSERT)
                .bind("p1")
                .to(1L)
                .bind("p2")
                .to("One")
                .build(),
            1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.newBuilder(PARAMETERIZED_INSERT)
                .bind("p1")
                .to(2L)
                .bind("p2")
                .to("Two")
                .build(),
            1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.newBuilder(PARAMETERIZED_UPDATE)
                .bind("p2")
                .to(1L)
                .bind("p1")
                .to("One")
                .build(),
            1L));
    mockSpanner.putStatementResult(
        StatementResult.update(
            com.google.cloud.spanner.Statement.newBuilder(PARAMETERIZED_UPDATE)
                .bind("p2")
                .to(2L)
                .bind("p1")
                .to("Two")
                .build(),
            1L));
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @Test
  public void testStatementExecute() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (Statement statement = connection.createStatement()) {
        assertFalse(statement.execute(NON_PARAMETERIZED_INSERT));
        assertFalse(statement.execute(NON_PARAMETERIZED_UPDATE));
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testStatementExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (Statement statement = connection.createStatement()) {
        assertEquals(1, statement.executeUpdate(NON_PARAMETERIZED_INSERT));
        assertEquals(1, statement.executeUpdate(NON_PARAMETERIZED_UPDATE));
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testStatementBatch() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (Statement statement = connection.createStatement()) {
        repeat(
            () -> {
              statement.addBatch(NON_PARAMETERIZED_INSERT);
              statement.addBatch(NON_PARAMETERIZED_UPDATE);
              assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
            },
            2);
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testStatementCombination() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (Statement statement = connection.createStatement()) {
        statement.executeUpdate(NON_PARAMETERIZED_UPDATE);
        repeat(
            () -> {
              statement.addBatch(NON_PARAMETERIZED_INSERT);
              statement.addBatch(NON_PARAMETERIZED_UPDATE);
              assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
            },
            ThreadLocalRandom.current().nextInt(1, 5));
        repeat(
            () -> {
              statement.execute(NON_PARAMETERIZED_INSERT);
              statement.executeUpdate(NON_PARAMETERIZED_UPDATE);
            },
            ThreadLocalRandom.current().nextInt(1, 5));
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testPreparedStatementExecute() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_INSERT)) {
        statement.setLong(1, 1L);
        statement.setString(2, "One");
        assertFalse(statement.execute());
        statement.setLong(1, 2L);
        statement.setString(2, "Two");
        assertFalse(statement.execute());
      }
      try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_UPDATE)) {
        statement.setLong(2, 1L);
        statement.setString(1, "One");
        assertFalse(statement.execute());
        statement.setLong(2, 2L);
        statement.setString(1, "Two");
        assertFalse(statement.execute());
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testPreparedStatementExecuteUpdate() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_INSERT)) {
        statement.setLong(1, 1L);
        statement.setString(2, "One");
        assertEquals(1, statement.executeUpdate());
        statement.setLong(1, 2L);
        statement.setString(2, "Two");
        assertEquals(1, statement.executeUpdate());
      }
      try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_UPDATE)) {
        statement.setLong(2, 1L);
        statement.setString(1, "One");
        assertEquals(1, statement.executeUpdate());
        statement.setLong(2, 2L);
        statement.setString(1, "Two");
        assertEquals(1, statement.executeUpdate());
      }
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testPreparedStatementBatch() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      repeat(
          () -> {
            try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_INSERT)) {
              statement.setLong(1, 1L);
              statement.setString(2, "One");
              statement.addBatch();
              statement.setLong(1, 2L);
              statement.setString(2, "Two");
              statement.addBatch();
              statement.executeBatch();
            }
            try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_UPDATE)) {
              statement.setLong(2, 1L);
              statement.setString(1, "One");
              statement.addBatch();
              statement.setLong(2, 2L);
              statement.setString(1, "Two");
              statement.addBatch();
              statement.executeBatch();
            }
          },
          2);
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  @Test
  public void testPreparedStatementCombination() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(false);
      connection.unwrap(CloudSpannerJdbcConnection.class).setAutoBatchDml(true);

      try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_INSERT)) {
        statement.setLong(1, 1L);
        statement.setString(2, "One");
        assertFalse(statement.execute());
      }
      repeat(
          () -> {
            try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_INSERT)) {
              statement.setLong(1, 1L);
              statement.setString(2, "One");
              statement.addBatch();
              statement.setLong(1, 2L);
              statement.setString(2, "Two");
              statement.addBatch();
              assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
            }
            try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_UPDATE)) {
              statement.setLong(2, 1L);
              statement.setString(1, "One");
              statement.addBatch();
              statement.setLong(2, 2L);
              statement.setString(1, "Two");
              statement.addBatch();
              assertArrayEquals(new int[] {1, 1}, statement.executeBatch());
            }
          },
          ThreadLocalRandom.current().nextInt(1, 5));
      repeat(
          () -> {
            try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_INSERT)) {
              statement.setLong(1, 1L);
              statement.setString(2, "One");
              assertEquals(1, statement.executeUpdate());
            }
            try (PreparedStatement statement = connection.prepareStatement(PARAMETERIZED_UPDATE)) {
              statement.setLong(2, 2L);
              statement.setString(1, "Two");
              assertFalse(statement.execute());
            }
          },
          ThreadLocalRandom.current().nextInt(1, 5));
      connection.commit();
    }
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
  }

  interface SQLRunnable {
    void run() throws SQLException;
  }

  static void repeat(SQLRunnable runnable, int count) throws SQLException {
    for (int i = 0; i < count; i++) {
      runnable.run();
    }
  }
}
