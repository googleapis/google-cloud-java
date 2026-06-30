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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.cloud.spanner.connection.RandomResultSetGenerator;
import com.google.cloud.spanner.connection.SavepointSupport;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcAbortedDueToConcurrentModificationException;
import com.google.common.base.Strings;
import com.google.protobuf.AbstractMessage;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SavepointMockServerTest extends AbstractMockServerTest {
  private static Dialect currentDialect;

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Before
  public void setupDialect() {
    // Only reset the dialect result when it has actually changed. This prevents the SpannerPool
    // from being closed after each test, which again makes the test slower.
    if (!Objects.equals(this.dialect, currentDialect)) {
      currentDialect = this.dialect;
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(this.dialect));
      SpannerPool.closeSpannerPool();
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
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
  public void testCreateSavepoint() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setSavepoint("s1");

      if (dialect == Dialect.POSTGRESQL) {
        // PostgreSQL allows multiple savepoints with the same name.
        connection.setSavepoint("s1");
      } else {
        assertThrows(SQLException.class, () -> connection.setSavepoint("s1"));
      }

      // Test invalid identifiers.
      assertThrows(SQLException.class, () -> connection.setSavepoint(null));
      assertThrows(SQLException.class, () -> connection.setSavepoint(""));
      assertThrows(SQLException.class, () -> connection.setSavepoint("1"));
      assertThrows(SQLException.class, () -> connection.setSavepoint("-foo"));
      assertThrows(SQLException.class, () -> connection.setSavepoint(Strings.repeat("t", 129)));
    }
  }

  @Test
  public void testCreateSavepointWhenDisabled() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.DISABLED);
      assertThrows(SQLException.class, () -> connection.setSavepoint("s1"));
    }
  }

  @Test
  public void testReleaseSavepoint() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      Savepoint s1 = connection.setSavepoint("s1");
      connection.releaseSavepoint(s1);
      assertThrows(SQLException.class, () -> connection.releaseSavepoint(s1));

      Savepoint s1_2 = connection.setSavepoint("s1");
      Savepoint s2 = connection.setSavepoint("s2");
      connection.releaseSavepoint(s1_2);
      // Releasing a savepoint also removes all savepoints after it.
      assertThrows(SQLException.class, () -> connection.releaseSavepoint(s2));

      if (dialect == Dialect.POSTGRESQL) {
        // PostgreSQL allows multiple savepoints with the same name.
        Savepoint savepoint1 = connection.setSavepoint("s1");
        Savepoint savepoint2 = connection.setSavepoint("s2");
        Savepoint savepoint1_2 = connection.setSavepoint("s1");
        connection.releaseSavepoint(savepoint1_2);
        connection.releaseSavepoint(savepoint2);
        connection.releaseSavepoint(savepoint1);
        assertThrows(SQLException.class, () -> connection.releaseSavepoint(savepoint1));
      }
    }
  }

  @Test
  public void testRollbackToSavepoint() throws SQLException {
    for (SavepointSupport savepointSupport :
        new SavepointSupport[] {SavepointSupport.ENABLED, SavepointSupport.FAIL_AFTER_ROLLBACK}) {
      try (Connection connection = createJdbcConnection()) {
        connection.unwrap(CloudSpannerJdbcConnection.class).setSavepointSupport(savepointSupport);

        Savepoint s1 = connection.setSavepoint("s1");
        connection.rollback(s1);
        // Rolling back to a savepoint does not remove it, so we can roll back multiple times to the
        // same savepoint.
        connection.rollback(s1);

        Savepoint s2 = connection.setSavepoint("s2");
        connection.rollback(s1);
        // Rolling back to a savepoint removes all savepoints after it.
        assertThrows(SQLException.class, () -> connection.rollback(s2));

        if (dialect == Dialect.POSTGRESQL) {
          // PostgreSQL allows multiple savepoints with the same name.
          Savepoint savepoint2 = connection.setSavepoint("s2");
          Savepoint savepoint1 = connection.setSavepoint("s1");
          connection.rollback(savepoint1);
          connection.rollback(savepoint2);
          connection.rollback(savepoint1);
          connection.rollback(savepoint1);
          connection.releaseSavepoint(savepoint1);
          assertThrows(SQLException.class, () -> connection.rollback(savepoint1));
        }
      }
    }
  }

  @Test
  public void testSavepointInAutoCommit() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection.setAutoCommit(true);
      assertThrows(SQLException.class, () -> connection.setSavepoint("s1"));

      // Starting a 'manual' transaction in autocommit mode should enable savepoints.
      connection.createStatement().execute("begin transaction");
      Savepoint s1 = connection.setSavepoint("s1");
      connection.releaseSavepoint(s1);
    }
  }

  @Test
  public void testRollbackToSavepointInReadOnlyTransaction() throws SQLException {
    for (SavepointSupport savepointSupport :
        new SavepointSupport[] {SavepointSupport.ENABLED, SavepointSupport.FAIL_AFTER_ROLLBACK}) {
      try (Connection connection = createJdbcConnection()) {
        connection.unwrap(CloudSpannerJdbcConnection.class).setSavepointSupport(savepointSupport);
        connection.setReadOnly(true);

        // Read-only transactions also support savepoints, but they do not do anything. This feature
        // is here purely for compatibility.
        Savepoint s1 = connection.setSavepoint("s1");
        try (ResultSet resultSet =
            connection.createStatement().executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
          int count = 0;
          while (resultSet.next()) {
            count++;
          }
          assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
        }

        connection.rollback(s1);
        try (ResultSet resultSet =
            connection.createStatement().executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
          int count = 0;
          while (resultSet.next()) {
            count++;
          }
          assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
        }
        // Committing a read-only transaction is necessary to mark the end of the transaction.
        // It is a no-op on Cloud Spanner.
        connection.commit();

        assertEquals(1, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        BeginTransactionRequest beginRequest =
            mockSpanner.getRequestsOfType(BeginTransactionRequest.class).get(0);
        assertTrue(beginRequest.getOptions().hasReadOnly());
        assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      }
      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testRollbackToSavepointInReadWriteTransaction() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.ENABLED);

      Savepoint s1 = connection.setSavepoint("s1");
      try (ResultSet resultSet =
          connection.createStatement().executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
      }

      connection.rollback(s1);
      try (ResultSet resultSet =
          connection.createStatement().executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
      }
      connection.commit();

      // Read/write transactions are started with inlined Begin transaction options.
      assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));

      List<AbstractMessage> requests =
          mockSpanner.getRequests().stream()
              .filter(
                  request ->
                      request instanceof ExecuteSqlRequest
                          || request instanceof RollbackRequest
                          || request instanceof CommitRequest)
              .collect(Collectors.toList());
      assertEquals(4, requests.size());
      int index = 0;
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(RollbackRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(CommitRequest.class, requests.get(index++).getClass());
    }
  }

  @Test
  public void testRollbackToSavepointWithDmlStatements() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.ENABLED);

      // First do a query that is included in the transaction.
      try (ResultSet resultSet =
          connection.createStatement().executeQuery(SELECT_RANDOM_STATEMENT.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
      }
      // Set a savepoint and execute a couple of DML statements.
      Savepoint s1 = connection.setSavepoint("s1");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      Savepoint s2 = connection.setSavepoint("s2");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      // Rollback the last DML statement and commit.
      connection.rollback(s2);

      connection.commit();

      // Read/write transactions are started with inlined Begin transaction options.
      assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(5, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));

      List<AbstractMessage> requests =
          mockSpanner.getRequests().stream()
              .filter(
                  request ->
                      request instanceof ExecuteSqlRequest
                          || request instanceof RollbackRequest
                          || request instanceof CommitRequest)
              .collect(Collectors.toList());
      assertEquals(7, requests.size());
      int index = 0;
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(RollbackRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(CommitRequest.class, requests.get(index++).getClass());
    }
  }

  @Test
  public void testRollbackToSavepointFails() throws SQLException {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.ENABLED);

      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      // Set a savepoint and execute a couple of DML statements.
      Savepoint s1 = connection.setSavepoint("s1");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      // Change the result of the initial query.
      mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
      // Rollback to before the DML statements.
      // This will succeed as long as we don't execute any further statements.
      connection.rollback(s1);

      // Trying to commit the transaction or execute any other statements on the transaction will
      // fail.
      assertThrows(JdbcAbortedDueToConcurrentModificationException.class, connection::commit);

      // Read/write transactions are started with inlined Begin transaction options.
      assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
      assertEquals(2, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(4, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));

      List<AbstractMessage> requests =
          mockSpanner.getRequests().stream()
              .filter(
                  request ->
                      request instanceof ExecuteSqlRequest
                          || request instanceof RollbackRequest
                          || request instanceof CommitRequest)
              .collect(Collectors.toList());
      assertEquals(6, requests.size());
      int index = 0;
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(RollbackRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(RollbackRequest.class, requests.get(index++).getClass());
    }
  }

  @Test
  public void testRollbackToSavepointWithFailAfterRollback() throws SQLException {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.FAIL_AFTER_ROLLBACK);

      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      // Set a savepoint and execute a couple of DML statements.
      Savepoint s1 = connection.setSavepoint("s1");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      // Rollback to before the DML statements.
      // This will succeed as long as we don't execute any further statements.
      connection.rollback(s1);

      // Trying to commit the transaction or execute any other statements on the transaction will
      // fail with an FAILED_PRECONDITION error, as using a transaction after a rollback to
      // savepoint has been disabled.
      SQLException exception = assertThrows(SQLException.class, connection::commit);
      assertEquals(
          ErrorCode.FAILED_PRECONDITION.getGrpcStatusCode().value(), exception.getErrorCode());
      assertEquals(
          "FAILED_PRECONDITION: Using a read/write transaction after rolling back to a "
              + "savepoint is not supported with SavepointSupport=FAIL_AFTER_ROLLBACK",
          exception.getMessage());
    }
  }

  @Test
  public void testRollbackToSavepointSucceedsWithRollback() throws SQLException {
    for (SavepointSupport savepointSupport :
        new SavepointSupport[] {SavepointSupport.ENABLED, SavepointSupport.FAIL_AFTER_ROLLBACK}) {
      Statement statement = Statement.of("select * from foo where bar=true");
      int numRows = 10;
      RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
      mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
      try (Connection connection = createJdbcConnection()) {
        connection.unwrap(CloudSpannerJdbcConnection.class).setSavepointSupport(savepointSupport);

        try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
          int count = 0;
          while (resultSet.next()) {
            count++;
          }
          assertEquals(numRows, count);
        }
        // Change the result of the initial query and set a savepoint.
        Savepoint s1 = connection.setSavepoint("s1");
        mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
        // This will succeed as long as we don't execute any further statements.
        connection.rollback(s1);

        // Rolling back the transaction should now be a no-op, as it has already been rolled back.
        connection.rollback();

        // Read/write transactions are started with inlined Begin transaction options.
        assertEquals(0, mockSpanner.countRequestsOfType(BeginTransactionRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
        assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
        assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      }
      mockSpanner.clearRequests();
    }
  }

  @Test
  public void testMultipleRollbacksWithChangedResults() throws SQLException {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createJdbcConnection()) {
      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      Savepoint s1 = connection.setSavepoint("s1");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      Savepoint s2 = connection.setSavepoint("s2");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());

      // Change the result of the initial query to make sure that any retry will fail.
      mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
      // This will succeed as long as we don't execute any further statements.
      connection.rollback(s2);
      // Rolling back one further should also work.
      connection.rollback(s1);

      // Rolling back the transaction should now be a no-op, as it has already been rolled back.
      connection.rollback();

      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }

  @Test
  public void testMultipleRollbacks() throws SQLException {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.ENABLED);

      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      Savepoint s1 = connection.setSavepoint("s1");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      Savepoint s2 = connection.setSavepoint("s2");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());

      // First roll back one step and then one more.
      connection.rollback(s2);
      connection.rollback(s1);

      // This will only commit the SELECT query.
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(4, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));

      List<AbstractMessage> requests =
          mockSpanner.getRequests().stream()
              .filter(
                  request ->
                      request instanceof ExecuteSqlRequest
                          || request instanceof RollbackRequest
                          || request instanceof CommitRequest)
              .collect(Collectors.toList());
      assertEquals(6, requests.size());
      int index = 0;
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(RollbackRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(CommitRequest.class, requests.get(index++).getClass());
    }
  }

  @Test
  public void testRollbackMutations() throws SQLException {
    try (Connection con = createJdbcConnection()) {
      CloudSpannerJdbcConnection connection = con.unwrap(CloudSpannerJdbcConnection.class);
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      connection.bufferedWrite(Mutation.newInsertBuilder("foo1").build());
      Savepoint s1 = connection.setSavepoint("s1");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      connection.bufferedWrite(Mutation.newInsertBuilder("foo2").build());
      connection.setSavepoint("s2");
      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      connection.bufferedWrite(Mutation.newInsertBuilder("foo3").build());

      connection.rollback(s1);

      // This will only commit the first mutation.
      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      CommitRequest commitRequest = mockSpanner.getRequestsOfType(CommitRequest.class).get(0);
      assertEquals(1, commitRequest.getMutationsCount());
      assertEquals("foo1", commitRequest.getMutations(0).getInsert().getTable());
    }
  }

  @Test
  public void testRollbackBatchDml() throws SQLException {
    try (Connection connection = createJdbcConnection()) {
      connection
          .unwrap(CloudSpannerJdbcConnection.class)
          .setSavepointSupport(SavepointSupport.ENABLED);

      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      Savepoint s1 = connection.setSavepoint("s1");
      try (java.sql.Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_STATEMENT.getSql());
        statement.addBatch(INSERT_STATEMENT.getSql());
        statement.executeBatch();
      }
      Savepoint s2 = connection.setSavepoint("s2");

      connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql());
      Savepoint s3 = connection.setSavepoint("s3");
      try (java.sql.Statement statement = connection.createStatement()) {
        statement.addBatch(INSERT_STATEMENT.getSql());
        statement.addBatch(INSERT_STATEMENT.getSql());
        statement.executeBatch();
      }
      connection.setSavepoint("s4");

      connection.rollback(s2);

      connection.commit();

      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));

      List<AbstractMessage> requests =
          mockSpanner.getRequests().stream()
              .filter(
                  request ->
                      request instanceof ExecuteSqlRequest
                          || request instanceof RollbackRequest
                          || request instanceof CommitRequest
                          || request instanceof ExecuteBatchDmlRequest)
              .collect(Collectors.toList());
      assertEquals(8, requests.size());
      int index = 0;
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteBatchDmlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteBatchDmlRequest.class, requests.get(index++).getClass());
      assertEquals(RollbackRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteSqlRequest.class, requests.get(index++).getClass());
      assertEquals(ExecuteBatchDmlRequest.class, requests.get(index++).getClass());
      assertEquals(CommitRequest.class, requests.get(index++).getClass());
    }
  }

  @Test
  public void testRollbackToSavepointWithoutInternalRetries() throws SQLException {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createJdbcConnection()) {
      connection.unwrap(CloudSpannerJdbcConnection.class).setRetryAbortsInternally(false);

      Savepoint s1 = connection.setSavepoint("s1");
      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      // This should work.
      connection.rollback(s1);
      // Resuming after a rollback is not supported without internal retries enabled.
      assertThrows(
          SQLException.class,
          () -> connection.createStatement().executeUpdate(INSERT_STATEMENT.getSql()));
    }
  }

  @Test
  public void testRollbackToSavepointWithoutInternalRetriesInReadOnlyTransaction()
      throws SQLException {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createJdbcConnection()) {
      connection.unwrap(CloudSpannerJdbcConnection.class).setRetryAbortsInternally(false);
      connection.setReadOnly(true);

      Savepoint s1 = connection.setSavepoint("s1");
      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }

      // Both rolling back and resuming after a rollback are supported in a read-only transaction,
      // even if internal retries have been disabled.
      connection.rollback(s1);
      try (ResultSet resultSet = connection.createStatement().executeQuery(statement.getSql())) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
    }
  }
}
