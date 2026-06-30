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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.AbstractMessage;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeoutException;
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

  // This test uses both platform threads and virtual threads (when available). We use specifically
  // this test for testing virtual threads, because it relies heavily on the internal checksum retry
  // strategy. This is the only significant calculation that is executed by the StatementExecutor
  // thread, meaning that this shows that using a virtual thread for those calculations also works.
  @Parameters(name = "dialect = {0}, useVirtualThreads = {1}")
  public static Collection<Object[]> data() {
    ImmutableList.Builder<Object[]> builder = ImmutableList.builder();
    for (Dialect dialect : Dialect.values()) {
      for (boolean useVirtualThreads : new boolean[] {true, false}) {
        builder.add(new Object[] {dialect, useVirtualThreads});
      }
    }
    return builder.build();
  }

  @Parameter(0)
  public Dialect dialect;

  @Parameter(1)
  public boolean useVirtualThreads;

  private Dialect currentDialect;

  @Before
  public void setupDialect() {
    if (currentDialect != dialect) {
      // Reset the dialect result.
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(StatementResult.detectDialectResult(dialect));
      currentDialect = dialect;
    }
  }

  @After
  public void clearRequests() {
    mockSpanner.clearRequests();
  }

  @SuppressWarnings("ClassEscapesDefinedScope")
  @Override
  public ITConnection createConnection() {
    return createConnection(
        ";useVirtualThreads="
            + useVirtualThreads
            + ";useVirtualGrpcTransportThreads="
            + useVirtualThreads);
  }

  @Test
  public void testCreateSavepoint() {
    try (Connection connection = createConnection()) {
      connection.savepoint("s1");

      if (dialect == Dialect.POSTGRESQL) {
        // PostgreSQL allows multiple savepoints with the same name.
        connection.savepoint("s1");
      } else {
        assertThrows(SpannerException.class, () -> connection.savepoint("s1"));
      }

      // Test invalid identifiers.
      assertThrows(SpannerException.class, () -> connection.savepoint(null));
      assertThrows(SpannerException.class, () -> connection.savepoint(""));
      assertThrows(SpannerException.class, () -> connection.savepoint("1"));
      assertThrows(SpannerException.class, () -> connection.savepoint("-foo"));
      assertThrows(SpannerException.class, () -> connection.savepoint(Strings.repeat("t", 129)));
    }
  }

  @Test
  public void testCreateSavepointWhenDisabled() {
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.DISABLED);
      assertThrows(SpannerException.class, () -> connection.savepoint("s1"));
    }
  }

  @Test
  public void testReleaseSavepoint() {
    try (Connection connection = createConnection()) {
      connection.savepoint("s1");
      connection.releaseSavepoint("s1");
      assertThrows(SpannerException.class, () -> connection.releaseSavepoint("s1"));

      connection.savepoint("s1");
      connection.savepoint("s2");
      connection.releaseSavepoint("s1");
      // Releasing a savepoint also removes all savepoints after it.
      assertThrows(SpannerException.class, () -> connection.releaseSavepoint("s2"));

      if (dialect == Dialect.POSTGRESQL) {
        // PostgreSQL allows multiple savepoints with the same name.
        connection.savepoint("s1");
        connection.savepoint("s2");
        connection.savepoint("s1");
        connection.releaseSavepoint("s1");
        connection.releaseSavepoint("s2");
        connection.releaseSavepoint("s1");
        assertThrows(SpannerException.class, () -> connection.releaseSavepoint("s1"));
      }
    }
  }

  @Test
  public void testRollbackToSavepoint() {
    for (SavepointSupport savepointSupport :
        new SavepointSupport[] {SavepointSupport.ENABLED, SavepointSupport.FAIL_AFTER_ROLLBACK}) {
      try (Connection connection = createConnection()) {
        connection.setSavepointSupport(savepointSupport);

        connection.savepoint("s1");
        connection.rollbackToSavepoint("s1");
        // Rolling back to a savepoint does not remove it, so we can roll back multiple times to the
        // same savepoint.
        connection.rollbackToSavepoint("s1");

        connection.savepoint("s2");
        connection.rollbackToSavepoint("s1");
        // Rolling back to a savepoint removes all savepoints after it.
        assertThrows(SpannerException.class, () -> connection.rollbackToSavepoint("s2"));

        if (dialect == Dialect.POSTGRESQL) {
          // PostgreSQL allows multiple savepoints with the same name.
          connection.savepoint("s2");
          connection.savepoint("s1");
          connection.rollbackToSavepoint("s1");
          connection.rollbackToSavepoint("s2");
          connection.rollbackToSavepoint("s1");
          connection.rollbackToSavepoint("s1");
          connection.releaseSavepoint("s1");
          assertThrows(SpannerException.class, () -> connection.rollbackToSavepoint("s1"));
        }
      }
    }
  }

  @Test
  public void testSavepointInAutoCommit() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      assertThrows(SpannerException.class, () -> connection.savepoint("s1"));

      // Starting a 'manual' transaction in autocommit mode should enable savepoints.
      connection.beginTransaction();
      connection.savepoint("s1");
      connection.releaseSavepoint("s1");
    }
  }

  @Test
  public void testRollbackToSavepointInReadOnlyTransaction() {
    for (SavepointSupport savepointSupport :
        new SavepointSupport[] {SavepointSupport.ENABLED, SavepointSupport.FAIL_AFTER_ROLLBACK}) {
      try (Connection connection = createConnection()) {
        connection.setSavepointSupport(savepointSupport);
        connection.setReadOnly(true);

        // Read-only transactions also support savepoints, but they do not do anything. This feature
        // is here purely for compatibility.
        connection.savepoint("s1");
        try (ResultSet resultSet = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
          int count = 0;
          while (resultSet.next()) {
            count++;
          }
          assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
        }

        connection.rollbackToSavepoint("s1");
        try (ResultSet resultSet = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
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
  public void testRollbackToSavepointInReadWriteTransaction() {
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      connection.savepoint("s1");
      try (ResultSet resultSet = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
      }

      connection.rollbackToSavepoint("s1");
      try (ResultSet resultSet = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
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
  public void testRollbackToSavepointWithDmlStatements() {
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      // First do a query that is included in the transaction.
      try (ResultSet resultSet = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(RANDOM_RESULT_SET_ROW_COUNT, count);
      }
      // Set a savepoint and execute a couple of DML statements.
      connection.savepoint("s1");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.savepoint("s2");
      connection.executeUpdate(INSERT_STATEMENT);
      // Rollback the last DML statement and commit.
      connection.rollbackToSavepoint("s2");

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
  public void testRollbackToSavepointFails() {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      // Set a savepoint and execute a couple of DML statements.
      connection.savepoint("s1");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.executeUpdate(INSERT_STATEMENT);
      // Change the result of the initial query.
      mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
      // Rollback to before the DML statements.
      // This will succeed as long as we don't execute any further statements.
      connection.rollbackToSavepoint("s1");

      // Trying to commit the transaction or execute any other statements on the transaction will
      // fail.
      assertThrows(AbortedDueToConcurrentModificationException.class, connection::commit);

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
  public void testRollbackToSavepointWithFailAfterRollback() {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.FAIL_AFTER_ROLLBACK);

      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      // Set a savepoint and execute a couple of DML statements.
      connection.savepoint("s1");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.executeUpdate(INSERT_STATEMENT);
      // Rollback to before the DML statements.
      // This will succeed as long as we don't execute any further statements.
      connection.rollbackToSavepoint("s1");

      // Trying to commit the transaction or execute any other statements on the transaction will
      // fail with an FAILED_PRECONDITION error, as using a transaction after a rollback to
      // savepoint has been disabled.
      SpannerException exception = assertThrows(SpannerException.class, connection::commit);
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertEquals(
          "FAILED_PRECONDITION: Using a read/write transaction after rolling back to a "
              + "savepoint is not supported with SavepointSupport=FAIL_AFTER_ROLLBACK",
          exception.getMessage());
    }
  }

  @Test
  public void testRollbackToSavepointSucceedsWithRollback() {
    for (SavepointSupport savepointSupport :
        new SavepointSupport[] {SavepointSupport.ENABLED, SavepointSupport.FAIL_AFTER_ROLLBACK}) {
      Statement statement = Statement.of("select * from foo where bar=true");
      int numRows = 10;
      RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
      mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
      try (Connection connection = createConnection()) {
        connection.setSavepointSupport(savepointSupport);

        try (ResultSet resultSet = connection.executeQuery(statement)) {
          int count = 0;
          while (resultSet.next()) {
            count++;
          }
          assertEquals(numRows, count);
        }
        // Change the result of the initial query and set a savepoint.
        connection.savepoint("s1");
        mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
        // This will succeed as long as we don't execute any further statements.
        connection.rollbackToSavepoint("s1");

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
  public void testMultipleRollbacksWithChangedResults() {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createConnection()) {
      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      connection.savepoint("s1");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.savepoint("s2");
      connection.executeUpdate(INSERT_STATEMENT);

      // Change the result of the initial query to make sure that any retry will fail.
      mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
      // This will succeed as long as we don't execute any further statements.
      connection.rollbackToSavepoint("s2");
      // Rolling back one further should also work.
      connection.rollbackToSavepoint("s1");

      // Rolling back the transaction should now be a no-op, as it has already been rolled back.
      connection.rollback();

      assertEquals(1, mockSpanner.countRequestsOfType(RollbackRequest.class));
      assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
      assertEquals(3, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    }
  }

  @Test
  public void testMultipleRollbacks() {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      connection.savepoint("s1");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.savepoint("s2");
      connection.executeUpdate(INSERT_STATEMENT);

      // First roll back one step and then one more.
      connection.rollbackToSavepoint("s2");
      connection.rollbackToSavepoint("s1");

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
  public void testRollbackMutations() {
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      connection.bufferedWrite(Mutation.newInsertBuilder("foo1").build());
      connection.savepoint("s1");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.bufferedWrite(Mutation.newInsertBuilder("foo2").build());
      connection.savepoint("s2");
      connection.executeUpdate(INSERT_STATEMENT);
      connection.bufferedWrite(Mutation.newInsertBuilder("foo3").build());

      connection.rollbackToSavepoint("s1");

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
  public void testRollbackBatchDml() {
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      connection.executeUpdate(INSERT_STATEMENT);
      connection.savepoint("s1");
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      connection.savepoint("s2");

      connection.executeUpdate(INSERT_STATEMENT);
      connection.savepoint("s3");
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      connection.savepoint("s4");

      connection.rollbackToSavepoint("s2");

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
  public void testRollbackToSavepointWithoutInternalRetries() {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createConnection()) {
      connection.setRetryAbortsInternally(false);

      connection.savepoint("s1");
      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
      // This should work.
      connection.rollbackToSavepoint("s1");
      // Resuming after a rollback is not supported without internal retries enabled.
      assertThrows(SpannerException.class, () -> connection.executeUpdate(INSERT_STATEMENT));
    }
  }

  @Test
  public void testRollbackToSavepointWithoutInternalRetriesInReadOnlyTransaction() {
    Statement statement = Statement.of("select * from foo where bar=true");
    int numRows = 10;
    RandomResultSetGenerator generator = new RandomResultSetGenerator(numRows);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));
    try (Connection connection = createConnection()) {
      connection.setRetryAbortsInternally(false);
      connection.setReadOnly(true);

      connection.savepoint("s1");
      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }

      // Both rolling back and resuming after a rollback are supported in a read-only transaction,
      // even if internal retries have been disabled.
      connection.rollbackToSavepoint("s1");
      try (ResultSet resultSet = connection.executeQuery(statement)) {
        int count = 0;
        while (resultSet.next()) {
          count++;
        }
        assertEquals(numRows, count);
      }
    }
  }

  @Test
  public void testKeepAlive() throws InterruptedException, TimeoutException {
    String keepAliveTag = "test_keep_alive_tag";
    System.setProperty("spanner.connection.keep_alive_interval_millis", "1");
    System.setProperty("spanner.connection.keep_alive_query_tag", keepAliveTag);
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);
      connection.setKeepTransactionAlive(true);
      // Start a transaction by executing a statement.
      connection.execute(INSERT_STATEMENT);
      // Verify that we get a keep-alive request.
      verifyHasKeepAliveRequest(keepAliveTag);
      // Set a savepoint, execute another statement, and rollback to the savepoint.
      // The keep-alive should not be sent after the transaction has been rolled back to the
      // savepoint.
      connection.savepoint("s1");
      connection.execute(INSERT_STATEMENT);
      connection.rollbackToSavepoint("s1");
      String keepAliveTagAfterRollback = "test_keep_alive_tag_after_rollback";
      System.setProperty("spanner.connection.keep_alive_query_tag", keepAliveTagAfterRollback);
      mockSpanner.waitForRequestsToContain(RollbackRequest.class, 1000L);
      mockSpanner.clearRequests();

      // Verify that we don't get any new keep-alive requests from this point.
      Thread.sleep(2L);
      assertEquals(0, countKeepAliveRequest(keepAliveTagAfterRollback));
      // Resume the transaction and verify that we get a keep-alive again.
      connection.execute(INSERT_STATEMENT);
      verifyHasKeepAliveRequest(keepAliveTagAfterRollback);
    } finally {
      System.clearProperty("spanner.connection.keep_alive_interval_millis");
      System.clearProperty("spanner.connection.keep_alive_query_tag");
    }
  }

  private void verifyHasKeepAliveRequest(String tag) throws InterruptedException, TimeoutException {
    mockSpanner.waitForRequestsToContain(
        r -> {
          if (!(r instanceof ExecuteSqlRequest)) {
            return false;
          }
          ExecuteSqlRequest request = (ExecuteSqlRequest) r;
          return request.getSql().equals("SELECT 1")
              && request.getRequestOptions().getRequestTag().equals(tag);
        },
        1000L);
  }

  private long countKeepAliveRequest(String tag) {
    return mockSpanner.getRequestsOfType(ExecuteSqlRequest.class).stream()
        .filter(
            request ->
                request.getSql().equals("SELECT 1")
                    && request.getRequestOptions().getRequestTag().equals(tag))
        .count();
  }
}
