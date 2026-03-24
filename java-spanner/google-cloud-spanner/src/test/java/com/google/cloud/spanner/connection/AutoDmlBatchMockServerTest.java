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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.RollbackRequest;
import io.grpc.Status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AutoDmlBatchMockServerTest extends AbstractMockServerTest {

  protected ITConnection createConnection() {
    return createConnection(";auto_batch_dml=true");
  }

  @Test
  public void testDmlInAutocommit_doesNotUseAutoBatching() {
    // auto_batch_dml does not have any effect in auto-commit mode, as there is no guarantee that
    // the application would ever call commit() or any other statement that would automatically
    // flush the batch.
    try (Connection connection = createConnection()) {
      assertTrue(connection.isAutoBatchDml());
      connection.setAutocommit(true);

      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
    }
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testQueryAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlWithReturningAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // DML with a THEN RETURN clause cannot be batched. This therefore flushes the batch and
      // executes the INSERT ... THEN RETURN statement as a separate ExecuteSqlRequest.
      try (ResultSet resultSet = connection.executeQuery(INSERT_RETURNING_STATEMENT)) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlWithReturningAfterDml_usingExecute() {
    try (Connection connection = createConnection()) {
      // Both execute(..) and executeUpdate(..) should trigger an auto-DML-batch, as long as the
      // statement is suited for that.
      connection.execute(INSERT_STATEMENT);
      connection.execute(INSERT_STATEMENT);
      // INSERT ... THEN RETURN is not suited for DML batching. This therefore automatically
      // flushes the DML batch and executes it as a separate request.
      StatementResult result = connection.execute(INSERT_RETURNING_STATEMENT);
      assertEquals(ResultType.RESULT_SET, result.getResultType());
      try (ResultSet resultSet = result.getResultSet()) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlAfterQuery() {
    try (Connection connection = createConnection()) {
      try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testCommitAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testRollbackAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.rollback();
    }

    // Rolling back the transaction in the middle of an auto-batch should abort the batch.
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
    // The rollback should be a no-op as there are no statements executed.
    assertEquals(0, mockSpanner.countRequestsOfType(RollbackRequest.class));
  }

  @Test
  public void testSetAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.execute(Statement.of("set auto_partition_mode=true"));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testSetBetweenDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // A SET ... statement does not auto-flush a DML batch.
      connection.execute(Statement.of("set auto_partition_mode=true"));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testShowAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.execute(Statement.of("show variable auto_partition_mode"));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testShowBetweenDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // A SHOW ... statement does not auto-flush a DML batch.
      connection.execute(Statement.of("show variable auto_partition_mode"));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testRunBatchInAutoBatch() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      // This flushes the current batch.
      assertArrayEquals(new long[] {1L, 1L}, connection.runBatch());

      // This starts a new batch.
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request1 =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request1.getStatementsCount());
    ExecuteBatchDmlRequest request2 =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(1);
    assertEquals(1, request2.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testStartBatchDmlInAutoBatch() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      // Explicitly starting a new batch when an auto-batch is already active is not supported.
      SpannerException exception = assertThrows(SpannerException.class, connection::startBatchDml);
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertEquals(
          "FAILED_PRECONDITION: Cannot start a DML batch when a batch is already active",
          exception.getMessage());

      // The above error does not invalidate the transaction, so we can still commit.
      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testStartBatchDdlInAutoBatch() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      // Explicitly starting a DDL batch when an auto-batch is already active is not supported.
      SpannerException exception = assertThrows(SpannerException.class, connection::startBatchDdl);
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertEquals(
          "FAILED_PRECONDITION: Cannot start a DDL batch when a batch is already active",
          exception.getMessage());

      // The above error does not invalidate the transaction, so we can still commit.
      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testExecuteDdlInAutoBatch() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      SpannerException exception =
          assertThrows(
              SpannerException.class, () -> connection.execute(Statement.of("CREATE TABLE foo")));
      assertEquals(ErrorCode.FAILED_PRECONDITION, exception.getErrorCode());
      assertEquals(
          "FAILED_PRECONDITION: DDL-statements are not allowed inside a read/write transaction.",
          exception.getMessage());

      // The above error does not invalidate the transaction, so we can still commit.
      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testSavepointBetweenDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // Setting a savepoint in the middle of an auto-DML-batch flushes the batch.
      connection.savepoint("s1");
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testRollbackToSavepointBetweenDml() {
    try (Connection connection = createConnection()) {
      connection.setSavepointSupport(SavepointSupport.ENABLED);

      connection.savepoint("s1");
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // Rolling back to a savepoint aborts the current batch.
      connection.rollbackToSavepoint("s1");
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    // We only get one batch, as the rollback to savepoint statement aborts the first part of the
    // batch.
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(1, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testReleaseSavepointBetweenDml() {
    try (Connection connection = createConnection()) {
      connection.savepoint("s1");
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // Releasing a savepoint during a batch also flushes the batch.
      connection.releaseSavepoint("s1");
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testAbortBatchAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.abortBatch();
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(1, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testExecuteBatchDmlAfterDml() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      // Executing a batch of DML statements should join the existing DML batch.
      assertArrayEquals(
          new long[] {1L, 1L},
          connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT)));

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(3, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testExecuteBatchDmlAndThenDml() {
    try (Connection connection = createConnection()) {
      // Executing a batch of DML statements should also initiate an auto-DML-batch.
      connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));

      // Executing a single DML statement should join the existing DML batch.
      connection.executeUpdate(INSERT_STATEMENT);

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(3, request.getStatementsCount());
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testAnalyzeUpdateInAutoDmlBatch() {
    try (Connection connection = createConnection()) {
      connection.executeUpdate(INSERT_STATEMENT);
      // Analyzing a DML statement does not flush the batch.
      connection.analyzeUpdateStatement(INSERT_STATEMENT, QueryAnalyzeMode.PLAN);
      connection.executeUpdate(INSERT_STATEMENT);

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    // The analyzeUpdateStatement(..) call is executed as a separate ExecuteSqlRequest.
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testQueryWithErrorAfterDml() {
    Statement invalidSelect = Statement.of("SELECT * FROM foo");
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            invalidSelect,
            Status.NOT_FOUND.withDescription("Table foo not found").asRuntimeException()));

    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      SpannerException exception =
          assertThrows(SpannerException.class, () -> connection.executeQuery(invalidSelect));
      assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testDmlWithErrorInBatch() {
    Statement invalidInsert = Statement.of("INSERT INTO foo (id) values (1)");
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.exception(
            invalidInsert,
            Status.NOT_FOUND.withDescription("Table foo not found").asRuntimeException()));

    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      // This statement is invalid and will eventually throw an exception. This does not happen
      // until the batch is flushed.
      assertEquals(1L, connection.executeUpdate(invalidInsert));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));

      // This SELECT statement flushes the batch and is the one that gets the exception, even
      // though the statement itself is valid.
      SpannerBatchUpdateException exception =
          assertThrows(
              SpannerBatchUpdateException.class, () -> connection.executeQuery(SELECT1_STATEMENT));
      assertEquals(ErrorCode.NOT_FOUND, exception.getErrorCode());
      // The batch exception contains the update count for the successful DML statements.
      assertArrayEquals(new long[] {1L}, exception.getUpdateCounts());

      connection.commit();
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(3, request.getStatementsCount());
    // The query is never executed, as the DML batch that is being flushed before the query is
    // executed fails.
    assertEquals(0, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testUpdateCount() {
    try (Connection connection = createConnection()) {

      // Setting a different update count is reflected in the update count that is returned by
      // an auto-batch.
      try {
        // Disable update count verification to prevent errors.
        connection.setAutoBatchDmlUpdateCountVerification(false);

        connection.setAutoBatchDmlUpdateCount(2L);
        assertEquals(2L, connection.executeUpdate(INSERT_STATEMENT));
        // The update count can be modified during the batch.
        connection.setAutoBatchDmlUpdateCount(3L);
        assertEquals(3L, connection.executeUpdate(INSERT_STATEMENT));

        connection.commit();

        // The auto-batch update count setting is not used for explicit batches.
        connection.startBatchDml();
        assertEquals(-1L, connection.executeUpdate(INSERT_STATEMENT));
        connection.runBatch();
        connection.commit();
      } finally {
        // TODO: Remove once a normal connection variable is used for this.
        System.clearProperty("spanner.auto_batch_dml_update_count");
        System.clearProperty("spanner.auto_batch_dml_update_count_verification");
      }
    }

    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testUpdateCountVerification_failsIfDifferent() {
    try (Connection connection = createConnection()) {
      try {
        assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
        // Set a different (expected) update count. This will cause the batch to fail, as the
        // actual update count will be 1.
        connection.setAutoBatchDmlUpdateCount(3L);
        assertEquals(3L, connection.executeUpdate(INSERT_STATEMENT));

        assertThrows(SpannerException.class, connection::commit);
      } finally {
        // TODO: Remove once a normal connection variable is used for this.
        System.clearProperty("spanner.auto_batch_dml_update_count");
      }
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    assertEquals(0, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testUpdateCountVerification_succeedsIfSame() {
    Statement statement1 = Statement.of("insert into foo (id, value) values (1, 'One')");
    Statement statement2 = Statement.of("insert into foo (id, value) values (2, 'Two')");
    Statement statement3 = Statement.of("insert into foo (id, value) values (3, 'Three')");
    Statement statement4 = Statement.of("insert into foo (id, value) values (4, 'Four')");
    Statement statement5 = Statement.of("insert into foo (id, value) values (5, 'Five')");
    mockSpanner.putStatementResult(MockSpannerServiceImpl.StatementResult.update(statement1, 1L));
    mockSpanner.putStatementResult(MockSpannerServiceImpl.StatementResult.update(statement2, 2L));
    mockSpanner.putStatementResult(MockSpannerServiceImpl.StatementResult.update(statement3, 3L));
    mockSpanner.putStatementResult(MockSpannerServiceImpl.StatementResult.update(statement4, 3L));
    mockSpanner.putStatementResult(MockSpannerServiceImpl.StatementResult.update(statement5, 4L));

    try (Connection connection = createConnection()) {
      try {
        connection.setAutoBatchDmlUpdateCount(1L);
        assertEquals(1L, connection.executeUpdate(statement1));

        connection.setAutoBatchDmlUpdateCount(2L);
        assertEquals(2L, connection.executeUpdate(statement2));

        connection.setAutoBatchDmlUpdateCount(3L);
        assertArrayEquals(
            new long[] {3L, 3L},
            connection.executeBatchUpdate(ImmutableList.of(statement3, statement4)));

        connection.setAutoBatchDmlUpdateCount(4L);
        assertEquals(4L, connection.executeUpdate(statement5));

        connection.commit();
      } finally {
        // TODO: Remove once a normal connection variable is used for this.
        System.clearProperty("spanner.auto_batch_dml_update_count");
      }
    }

    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(5, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testTransactionRetry() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }

      mockSpanner.abortNextStatement();
      connection.commit();
    }

    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(2, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testTransactionRetryFails() {
    try (Connection connection = createConnection()) {
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      try (ResultSet resultSet = connection.executeQuery(SELECT1_STATEMENT)) {
        assertTrue(resultSet.next());
        assertEquals(1L, resultSet.getLong(0));
        assertFalse(resultSet.next());
      }

      // Modify the update count that is returned by the insert statement. This will cause the
      // retry attempt to fail.
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(INSERT_STATEMENT, 2L));
      mockSpanner.abortNextStatement();
      assertThrows(AbortedDueToConcurrentModificationException.class, connection::commit);
    } finally {
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.update(INSERT_STATEMENT, 1L));
    }

    assertEquals(2, mockSpanner.countRequestsOfType(ExecuteBatchDmlRequest.class));
    ExecuteBatchDmlRequest request =
        mockSpanner.getRequestsOfType(ExecuteBatchDmlRequest.class).get(0);
    assertEquals(2, request.getStatementsCount());
    assertEquals(1, mockSpanner.countRequestsOfType(ExecuteSqlRequest.class));
    assertEquals(1, mockSpanner.countRequestsOfType(CommitRequest.class));
  }

  @Test
  public void testSqlStatements() {
    try (Connection connection = createConnection()) {
      for (boolean enable : new boolean[] {true, false}) {
        connection.execute(Statement.of("set auto_batch_dml = " + enable));
        try (ResultSet resultSet =
            connection.executeQuery(Statement.of("show variable auto_batch_dml"))) {
          assertTrue(resultSet.next());
          assertEquals(enable, resultSet.getBoolean("AUTO_BATCH_DML"));
          assertFalse(resultSet.next());
        }
      }
      for (boolean enable : new boolean[] {true, false}) {
        connection.execute(
            Statement.of("set auto_batch_dml_update_count_verification = " + enable));
        try (ResultSet resultSet =
            connection.executeQuery(
                Statement.of("show variable auto_batch_dml_update_count_verification"))) {
          assertTrue(resultSet.next());
          assertEquals(enable, resultSet.getBoolean("AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION"));
          assertFalse(resultSet.next());
        }
      }
      for (long updateCount : new long[] {0L, 5L, 100L}) {
        connection.execute(Statement.of("set auto_batch_dml_update_count = " + updateCount));
        try (ResultSet resultSet =
            connection.executeQuery(Statement.of("show variable auto_batch_dml_update_count"))) {
          assertTrue(resultSet.next());
          assertEquals(updateCount, resultSet.getLong("AUTO_BATCH_DML_UPDATE_COUNT"));
          assertFalse(resultSet.next());
        }
      }
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () -> connection.execute(Statement.of("set auto_batch_dml_update_count=-1")));
      assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
      assertEquals(
          "INVALID_ARGUMENT: Unknown value for AUTO_BATCH_DML_UPDATE_COUNT: -1",
          exception.getMessage());
    }
  }

  @Test
  public void testPostgreSQLStatements() {
    SpannerPool.closeSpannerPool();
    mockSpanner.putStatementResult(
        MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.POSTGRESQL));
    try {
      try (Connection connection = createConnection()) {
        for (boolean enable : new boolean[] {true, false}) {
          connection.execute(
              Statement.of("set spanner.auto_batch_dml to " + (enable ? "on" : "off")));
          try (ResultSet resultSet =
              connection.executeQuery(Statement.of("show variable spanner.auto_batch_dml"))) {
            assertTrue(resultSet.next());
            assertEquals(enable, resultSet.getBoolean("SPANNER.AUTO_BATCH_DML"));
            assertFalse(resultSet.next());
          }
        }
        for (boolean enable : new boolean[] {true, false}) {
          connection.execute(
              Statement.of("set spanner.auto_batch_dml_update_count_verification = " + enable));
          try (ResultSet resultSet =
              connection.executeQuery(
                  Statement.of("show spanner.auto_batch_dml_update_count_verification"))) {
            assertTrue(resultSet.next());
            assertEquals(
                enable, resultSet.getBoolean("SPANNER.AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION"));
            assertFalse(resultSet.next());
          }
        }
        for (long updateCount : new long[] {0L, 5L, 100L}) {
          connection.execute(
              Statement.of("set spanner.auto_batch_dml_update_count to " + updateCount));
          try (ResultSet resultSet =
              connection.executeQuery(Statement.of("show  spanner.auto_batch_dml_update_count"))) {
            assertTrue(resultSet.next());
            assertEquals(updateCount, resultSet.getLong("SPANNER.AUTO_BATCH_DML_UPDATE_COUNT"));
            assertFalse(resultSet.next());
          }
        }
        SpannerException exception =
            assertThrows(
                SpannerException.class,
                () ->
                    connection.execute(Statement.of("set spanner.auto_batch_dml_update_count=-1")));
        assertEquals(ErrorCode.INVALID_ARGUMENT, exception.getErrorCode());
        assertEquals(
            "INVALID_ARGUMENT: Unknown value for SPANNER.AUTO_BATCH_DML_UPDATE_COUNT: -1",
            exception.getMessage());
      }
    } finally {
      SpannerPool.closeSpannerPool();
      mockSpanner.putStatementResult(
          MockSpannerServiceImpl.StatementResult.detectDialectResult(Dialect.GOOGLE_STANDARD_SQL));
    }
  }
}
