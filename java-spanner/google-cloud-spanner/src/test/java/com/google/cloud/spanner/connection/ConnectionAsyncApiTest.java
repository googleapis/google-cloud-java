/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ForceCloseSpannerFunction;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerApiFutures;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ConnectionOptions.Builder;
import com.google.cloud.spanner.connection.SpannerPool.CheckAndCloseSpannersMode;
import com.google.cloud.spanner.connection.StatementExecutor.StatementExecutorType;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionAsyncApiTest extends AbstractMockServerTest {
  private static ExecutorService executor = Executors.newSingleThreadExecutor();
  private static final Function<Connection, Void> AUTOCOMMIT =
      input -> {
        input.setAutocommit(true);
        return null;
      };
  private static final Function<Connection, Void> READ_ONLY =
      input -> {
        input.setReadOnly(true);
        return null;
      };
  private static final Function<Connection, Void> READ_WRITE = input -> null;

  @AfterClass
  public static void stopExecutor() {
    executor.shutdown();
  }

  @Before
  public void setup() {
    try (Connection connection = createConnection()) {
      connection.getDialect();
    }
  }

  @Override
  protected Builder configureConnectionOptions(Builder builder) {
    return builder.setStatementExecutorType(StatementExecutorType.PLATFORM_THREAD);
  }

  @After
  public void reset() {
    mockSpanner.removeAllExecutionTimes();
    executor.shutdownNow();
    executor = Executors.newSingleThreadExecutor();
  }

  @Test
  public void testExecuteQueryAsyncAutocommit() {
    testExecuteQueryAsync(AUTOCOMMIT);
  }

  @Test
  public void testExecuteQueryAsyncAutocommitIsNonBlocking() {
    testExecuteQueryAsyncIsNonBlocking(AUTOCOMMIT);
  }

  @Test
  public void testExecuteQueryAsStatementAsyncAutocommit() {
    testExecuteQueryAsync(AUTOCOMMIT, true);
  }

  @Test
  public void testExecuteQueryAutocommit() {
    testExecuteQuery(AUTOCOMMIT);
  }

  @Test
  public void testExecuteUpdateAsyncAutocommit() {
    testExecuteUpdateAsync(AUTOCOMMIT);
  }

  @Test
  public void testExecuteUpdateAsyncAutocommitIsNonBlocking() {
    testExecuteUpdateAsyncIsNonBlocking(AUTOCOMMIT);
  }

  @Test
  public void testExecuteUpdateAsStatementAsyncAutocommit() {
    testExecuteUpdateAsync(AUTOCOMMIT, true);
  }

  @Test
  public void testExecuteUpdateAutocommit() {
    testExecuteUpdate(AUTOCOMMIT);
  }

  @Test
  public void testExecuteBatchUpdateAsyncAutocommit() {
    testExecuteBatchUpdateAsync(AUTOCOMMIT);
  }

  @Test
  public void testExecuteBatchUpdateAsyncAutocommitIsNonBlocking() {
    testExecuteBatchUpdateAsyncIsNonBlocking(AUTOCOMMIT);
  }

  @Test
  public void testExecuteBatchUpdateAutocommit() {
    testExecuteBatchUpdate(AUTOCOMMIT);
  }

  @Test
  public void testWriteAsyncAutocommit() {
    testWriteAsync(AUTOCOMMIT);
  }

  @Test
  public void testWriteAutocommit() {
    testWrite(AUTOCOMMIT);
  }

  @Test
  public void testExecuteQueryAsyncReadOnly() {
    testExecuteQueryAsync(READ_ONLY);
  }

  @Test
  public void testExecuteQueryAsyncReadOnlyIsNonBlocking() {
    testExecuteQueryAsyncIsNonBlocking(READ_ONLY);
  }

  @Test
  public void testExecuteQueryAsStatementAsyncReadOnly() {
    testExecuteQueryAsync(READ_ONLY, true);
  }

  @Test
  public void testExecuteQueryReadOnly() {
    testExecuteQuery(READ_ONLY);
  }

  @Test
  public void testExecuteQueryAsyncReadWrite() {
    testExecuteQueryAsync(READ_WRITE);
  }

  @Test
  public void testExecuteQueryAsyncReadWriteIsNonBlocking() {
    testExecuteQueryAsyncIsNonBlocking(READ_WRITE);
  }

  @Test
  public void testExecuteQueryAsStatementAsyncReadWrite() {
    testExecuteQueryAsync(READ_WRITE, true);
  }

  @Test
  public void testExecuteQueryReadWrite() {
    testExecuteQuery(READ_WRITE);
  }

  @Test
  public void testExecuteUpdateAsyncReadWrite() {
    testExecuteUpdateAsync(READ_WRITE);
  }

  @Test
  public void testExecuteUpdateAsyncReadWriteIsNonBlocking() {
    testExecuteUpdateAsyncIsNonBlocking(READ_WRITE);
  }

  @Test
  public void testExecuteUpdateAsStatementAsyncReadWrite() {
    testExecuteUpdateAsync(READ_WRITE, true);
  }

  @Test
  public void testExecuteUpdateReadWrite() {
    testExecuteUpdate(READ_WRITE);
  }

  @Test
  public void testExecuteBatchUpdateAsyncReadWrite() {
    testExecuteBatchUpdateAsync(READ_WRITE);
  }

  @Test
  public void testExecuteBatchUpdateAsyncReadWriteIsNonBlocking() {
    testExecuteBatchUpdateAsyncIsNonBlocking(READ_WRITE);
  }

  @Test
  public void testExecuteBatchUpdateReadWrite() {
    testExecuteBatchUpdate(READ_WRITE);
  }

  @Test
  public void testBufferedWriteReadWrite() {
    testBufferedWrite(READ_WRITE);
  }

  @Test
  public void testReadWriteMultipleAsyncStatements() {
    try (Connection connection = createConnection()) {
      assertThat(connection.isAutocommit()).isFalse();
      ApiFuture<Long> update1 = connection.executeUpdateAsync(INSERT_STATEMENT);
      ApiFuture<Long> update2 = connection.executeUpdateAsync(INSERT_STATEMENT);
      ApiFuture<long[]> batch =
          connection.executeBatchUpdateAsync(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      final SettableApiFuture<Integer> rowCount = SettableApiFuture.create();
      try (AsyncResultSet rs = connection.executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
        rs.setCallback(
            executor,
            new ReadyCallback() {
              int count = 0;

              @Override
              public CallbackResponse cursorReady(AsyncResultSet resultSet) {
                try {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        rowCount.set(count);
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        count++;
                    }
                  }
                } catch (SpannerException e) {
                  rowCount.setException(e);
                  return CallbackResponse.DONE;
                }
              }
            });
      }
      ApiFuture<Void> commit = connection.commitAsync();
      assertThat(get(update1)).isEqualTo(UPDATE_COUNT);
      assertThat(get(update2)).isEqualTo(UPDATE_COUNT);
      assertThat(get(batch)).asList().containsExactly(1L, 1L);
      assertThat(get(rowCount)).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertNull(get(commit));

      // Get the last commit request.
      CommitRequest commitRequest =
          mockSpanner.getRequestsOfType(CommitRequest.class).stream()
              .reduce((first, second) -> second)
              .get();
      // Verify the order of the statements on the server.
      List<? extends AbstractMessage> requests =
          Lists.newArrayList(
              Collections2.filter(
                  mockSpanner.getRequests(),
                  input ->
                      (input instanceof ExecuteSqlRequest
                              && ((ExecuteSqlRequest) input)
                                  .getSession()
                                  .equals(commitRequest.getSession()))
                          || (input instanceof ExecuteBatchDmlRequest
                              && ((ExecuteBatchDmlRequest) input)
                                  .getSession()
                                  .equals(commitRequest.getSession()))));
      assertThat(requests).hasSize(4);
      assertThat(requests.get(0)).isInstanceOf(ExecuteSqlRequest.class);
      assertThat(((ExecuteSqlRequest) requests.get(0)).getSeqno()).isEqualTo(1L);
      assertThat(requests.get(1)).isInstanceOf(ExecuteSqlRequest.class);
      assertThat(((ExecuteSqlRequest) requests.get(1)).getSeqno()).isEqualTo(2L);
      assertThat(requests.get(2)).isInstanceOf(ExecuteBatchDmlRequest.class);
      assertThat(((ExecuteBatchDmlRequest) requests.get(2)).getSeqno()).isEqualTo(3L);
      assertThat(requests.get(3)).isInstanceOf(ExecuteSqlRequest.class);
      assertThat(((ExecuteSqlRequest) requests.get(3)).getSeqno()).isEqualTo(4L);
    }
  }

  @Test
  public void testAutocommitRunBatch() {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.execute(Statement.of("START BATCH DML"));
      connection.execute(INSERT_STATEMENT);
      connection.execute(INSERT_STATEMENT);
      StatementResult res = connection.execute(Statement.of("RUN BATCH"));
      assertThat(res.getResultType()).isEqualTo(ResultType.RESULT_SET);
      try (ResultSet rs = res.getResultSet()) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLongList(0)).containsExactly(1L, 1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  @Test
  public void testDmlBatchUpdateCount() {
    Arrays.asList(Dialect.POSTGRESQL, Dialect.GOOGLE_STANDARD_SQL)
        .forEach(
            dialect -> {
              String prefix = dialect == Dialect.POSTGRESQL ? "spanner." : "";
              mockSpanner.putStatementResult(
                  MockSpannerServiceImpl.StatementResult.detectDialectResult(dialect));
              SpannerPool.closeSpannerPool();
              try {
                try (Connection connection = createConnection()) {
                  connection.execute(
                      Statement.of("set local " + prefix + "batch_dml_update_count = 1"));
                  connection.execute(Statement.of("START BATCH DML"));
                  List<Statement> statements = Arrays.asList(INSERT_STATEMENT, INSERT_STATEMENT);
                  long[] updateCounts = connection.executeBatchUpdate(statements);
                  assertThat(updateCounts).asList().containsExactly(1L, 1L);
                  connection.execute(Statement.of("RUN BATCH"));
                  connection.commit();

                  connection.execute(Statement.of("START BATCH DML"));
                  statements = Arrays.asList(INSERT_STATEMENT, INSERT_STATEMENT);
                  updateCounts = connection.executeBatchUpdate(statements);
                  assertThat(updateCounts).asList().containsExactly(-1L, -1L);
                  connection.execute(Statement.of("RUN BATCH"));
                  connection.commit();
                }
              } finally {
                SpannerPool.closeSpannerPool();
                mockSpanner.putStatementResult(
                    MockSpannerServiceImpl.StatementResult.detectDialectResult(
                        Dialect.GOOGLE_STANDARD_SQL));
              }
            });
  }

  @Test
  public void testAutocommitRunBatchAsync() {
    try (Connection connection = createConnection()) {
      connection.executeAsync(Statement.of("SET AUTOCOMMIT = TRUE"));
      connection.executeAsync(Statement.of("START BATCH DML"));
      connection.executeAsync(INSERT_STATEMENT);
      connection.executeAsync(INSERT_STATEMENT);
      ApiFuture<long[]> res = connection.runBatchAsync();
      assertThat(get(res)).asList().containsExactly(1L, 1L);
    }
  }

  @Test
  public void testExecuteDdlAsync() {
    try (Connection connection = createConnection()) {
      connection.executeAsync(Statement.of("SET AUTOCOMMIT = TRUE"));
      connection.executeAsync(Statement.of("START BATCH DDL"));
      connection.executeAsync(Statement.of("CREATE TABLE FOO (ID INT64) PRIMARY KEY (ID)"));
      connection.executeAsync(Statement.of("ABORT BATCH"));
    }
  }

  @Test
  public void testExecuteInvalidStatementAsync() {
    try (Connection connection = createConnection()) {
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  connection.executeAsync(
                      Statement.of("UPSERT INTO FOO (ID, VAL) VALUES (1, 'foo')")));
      assertEquals(ErrorCode.INVALID_ARGUMENT, e.getErrorCode());
    }
  }

  @Test
  public void testExecuteClientSideQueryAsync() {
    try (Connection connection = createConnection()) {
      connection.executeAsync(Statement.of("SET AUTOCOMMIT = TRUE"));
      final SettableApiFuture<Boolean> autocommit = SettableApiFuture.create();
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SHOW VARIABLE AUTOCOMMIT"))) {
        rs.setCallback(
            executor,
            resultSet -> {
              while (true) {
                switch (resultSet.tryNext()) {
                  case DONE:
                    return CallbackResponse.DONE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case OK:
                    autocommit.set(resultSet.getBoolean("AUTOCOMMIT"));
                }
              }
            });
      }
      assertThat(get(autocommit)).isTrue();
    }
  }

  @Test
  public void testExecuteInvalidQueryAsync() {
    try (Connection connection = createConnection()) {
      try {
        connection.executeQueryAsync(INSERT_STATEMENT);
        fail("Missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      }
    }
  }

  @Test
  public void testExecuteInvalidUpdateAsync() {
    try (Connection connection = createConnection()) {
      try {
        connection.executeUpdateAsync(SELECT_RANDOM_STATEMENT);
        fail("Missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      }
    }
  }

  @Test
  public void testExecuteInvalidBatchUpdateAsync() {
    try (Connection connection = createConnection()) {
      try {
        connection.executeBatchUpdateAsync(
            ImmutableList.of(INSERT_STATEMENT, SELECT_RANDOM_STATEMENT));
        fail("Missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.INVALID_ARGUMENT);
      }
    }
  }

  @Test
  public void testRunEmptyBatchAsync() {
    try (Connection connection = createConnection()) {
      connection.startBatchDml();
      assertThat(get(connection.runBatchAsync())).isEqualTo(new long[0]);
    }
  }

  private void testExecuteQueryAsync(Function<Connection, Void> connectionConfigurator) {
    testExecuteQueryAsync(connectionConfigurator, false);
  }

  private void testExecuteQueryAsync(
      Function<Connection, Void> connectionConfigurator, boolean executeAsStatement) {
    ApiFuture<Void> res;
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        final AtomicInteger rowCount = new AtomicInteger();
        final AtomicBoolean receivedTimeout = new AtomicBoolean();
        if (timeout) {
          mockSpanner.setExecuteStreamingSqlExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        try (AsyncResultSet rs =
            executeAsStatement
                ? connection.executeAsync(SELECT_RANDOM_STATEMENT).getResultSetAsync()
                : connection.executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
          res =
              rs.setCallback(
                  executor,
                  resultSet -> {
                    try {
                      while (true) {
                        switch (resultSet.tryNext()) {
                          case OK:
                            rowCount.incrementAndGet();
                            break;
                          case DONE:
                            return CallbackResponse.DONE;
                          case NOT_READY:
                            return CallbackResponse.CONTINUE;
                        }
                      }
                    } catch (SpannerException e) {
                      receivedTimeout.set(e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED);
                      throw e;
                    }
                  });
        }
        try {
          SpannerApiFutures.get(res);
          assertThat(rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
          if (connection.isReadOnly() || !connection.isInTransaction()) {
            assertThat(connection.getReadTimestamp()).isNotNull();
          }
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(e.getSuppressed()).hasLength(1);
          assertThat(e.getSuppressed()[0].getMessage()).contains(SELECT_RANDOM_STATEMENT.getSql());
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          assertThat(timeout).isTrue();
          assertThat(receivedTimeout.get()).isTrue();
          // Start a new transaction if a timeout occurred on a read/write transaction, as that will
          // invalidate that transaction.
          if (!connection.isReadOnly() && connection.isInTransaction()) {
            connection.clearStatementTimeout();
            connection.rollback();
          }
        }
      }
    }
  }

  private void testExecuteQuery(Function<Connection, Void> connectionConfigurator) {
    long rowCount = 0L;
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setExecuteStreamingSqlExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        try (ResultSet rs = connection.executeQuery(SELECT_RANDOM_STATEMENT)) {
          while (rs.next()) {
            rowCount++;
          }
          assertThat(rowCount).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
          if (connection.isReadOnly() || !connection.isInTransaction()) {
            assertThat(connection.getReadTimestamp()).isNotNull();
          }
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          // Start a new transaction if a timeout occurred on a read/write transaction, as that will
          // invalidate that transaction.
          if (!connection.isReadOnly() && connection.isInTransaction()) {
            connection.clearStatementTimeout();
            connection.rollback();
          }
        }
      }
    }
  }

  private void testExecuteUpdateAsync(Function<Connection, Void> connectionConfigurator) {
    testExecuteUpdateAsync(connectionConfigurator, false);
  }

  private void testExecuteUpdateAsync(
      Function<Connection, Void> connectionConfigurator, boolean executeAsStatement) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setExecuteSqlExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        ApiFuture<Long> updateCount =
            executeAsStatement
                ? connection.executeAsync(INSERT_STATEMENT).getUpdateCountAsync()
                : connection.executeUpdateAsync(INSERT_STATEMENT);
        try {
          assertThat(get(updateCount)).isEqualTo(1L);
          if (connection.isInTransaction()) {
            connection.commitAsync();
          }
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          // Start a new transaction if a timeout occurred on a read/write transaction, as that will
          // invalidate that transaction.
          if (!connection.isReadOnly() && connection.isInTransaction()) {
            connection.clearStatementTimeout();
            connection.rollback();
          }
        }
      }
    }
  }

  private void testExecuteUpdate(Function<Connection, Void> connectionConfigurator) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setExecuteSqlExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        try {
          long updateCount = connection.executeUpdate(INSERT_STATEMENT);
          assertThat(updateCount).isEqualTo(1L);
          if (connection.isInTransaction()) {
            connection.commit();
          }
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          // Start a new transaction if a timeout occurred on a read/write transaction, as that will
          // invalidate that transaction.
          if (!connection.isReadOnly() && connection.isInTransaction()) {
            connection.clearStatementTimeout();
            connection.rollback();
          }
        }
      }
    }
  }

  private void testExecuteBatchUpdateAsync(Function<Connection, Void> connectionConfigurator) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setExecuteBatchDmlExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        ApiFuture<long[]> updateCounts =
            connection.executeBatchUpdateAsync(
                ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
        try {
          assertThat(get(updateCounts)).asList().containsExactly(1L, 1L);
          if (connection.isInTransaction()) {
            connection.commitAsync();
          }
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          // Start a new transaction if a timeout occurred on a read/write transaction, as that will
          // invalidate that transaction.
          if (!connection.isReadOnly() && connection.isInTransaction()) {
            connection.clearStatementTimeout();
            connection.rollback();
          }
        }
      }
    }
  }

  private void testExecuteBatchUpdate(Function<Connection, Void> connectionConfigurator) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setExecuteBatchDmlExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        try {
          long[] updateCounts =
              connection.executeBatchUpdate(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
          assertThat(updateCounts).asList().containsExactly(1L, 1L);
          if (connection.isInTransaction()) {
            connection.commit();
          }
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          assertThat(timeout).isTrue();
          // Start a new transaction if a timeout occurred on a read/write transaction, as that will
          // invalidate that transaction.
          if (!connection.isReadOnly() && connection.isInTransaction()) {
            connection.clearStatementTimeout();
            connection.rollback();
          }
        }
      }
    }
    // Close the Spanner pool to prevent requests from this test from interfering with other tests.
    SpannerPool.INSTANCE.checkAndCloseSpanners(
        CheckAndCloseSpannersMode.ERROR,
        new ForceCloseSpannerFunction(100L, TimeUnit.MILLISECONDS));
  }

  private void testWriteAsync(Function<Connection, Void> connectionConfigurator) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setCommitExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        ApiFuture<Void> fut =
            connection.writeAsync(
                ImmutableList.of(
                    Mutation.newInsertBuilder("foo").build(),
                    Mutation.newInsertBuilder("bar").build()));
        try {
          assertThat(get(fut)).isNull();
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
        }
      }
    }
  }

  private void testWrite(Function<Connection, Void> connectionConfigurator) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setCommitExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        try {
          connection.write(
              ImmutableList.of(
                  Mutation.newInsertBuilder("foo").build(),
                  Mutation.newInsertBuilder("bar").build()));
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
        }
      }
    }
  }

  private void testBufferedWrite(Function<Connection, Void> connectionConfigurator) {
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      for (boolean timeout : new boolean[] {true, false}) {
        if (timeout) {
          mockSpanner.setCommitExecutionTime(
              SimulatedExecutionTime.ofMinimumAndRandomTime(1000, 0));
          connection.setStatementTimeout(1L, TimeUnit.NANOSECONDS);
        } else {
          mockSpanner.removeAllExecutionTimes();
          connection.clearStatementTimeout();
        }
        try {
          connection.bufferedWrite(
              ImmutableList.of(
                  Mutation.newInsertBuilder("foo").build(),
                  Mutation.newInsertBuilder("bar").build()));
          connection.commitAsync();
          assertThat(connection.getCommitTimestamp()).isNotNull();
          assertThat(timeout).isFalse();
        } catch (SpannerException e) {
          assertThat(timeout).isTrue();
          assertThat(e.getErrorCode()).isEqualTo(ErrorCode.DEADLINE_EXCEEDED);
          connection.clearStatementTimeout();
          connection.rollbackAsync();
        }
      }
    }
  }

  private void testExecuteQueryAsyncIsNonBlocking(
      Function<Connection, Void> connectionConfigurator) {
    ApiFuture<Void> res;
    final AtomicInteger rowCount = new AtomicInteger();
    mockSpanner.freeze();
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      try (AsyncResultSet rs = connection.executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
        res =
            rs.setCallback(
                executor,
                resultSet -> {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case OK:
                        rowCount.incrementAndGet();
                        break;
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                    }
                  }
                });
        mockSpanner.unfreeze();
      }
      SpannerApiFutures.get(res);
      assertThat(rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
    }
  }

  private void testExecuteUpdateAsyncIsNonBlocking(
      Function<Connection, Void> connectionConfigurator) {
    mockSpanner.freeze();
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      ApiFuture<Long> updateCount = connection.executeUpdateAsync(INSERT_STATEMENT);
      if (connection.isInTransaction()) {
        connection.commitAsync();
      }
      mockSpanner.unfreeze();
      assertThat(get(updateCount)).isEqualTo(1L);
      assertThat(connection.getCommitTimestamp()).isNotNull();
    }
  }

  private void testExecuteBatchUpdateAsyncIsNonBlocking(
      Function<Connection, Void> connectionConfigurator) {
    mockSpanner.freeze();
    try (Connection connection = createConnection()) {
      connectionConfigurator.apply(connection);
      ApiFuture<long[]> updateCounts =
          connection.executeBatchUpdateAsync(ImmutableList.of(INSERT_STATEMENT, INSERT_STATEMENT));
      if (connection.isInTransaction()) {
        connection.commitAsync();
      }
      mockSpanner.unfreeze();
      assertThat(get(updateCounts)).asList().containsExactly(1L, 1L);
      assertThat(connection.getCommitTimestamp()).isNotNull();
    }
  }
}
