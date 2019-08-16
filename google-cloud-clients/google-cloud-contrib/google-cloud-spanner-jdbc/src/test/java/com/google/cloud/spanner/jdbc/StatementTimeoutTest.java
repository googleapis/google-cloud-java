/*
 * Copyright 2019 Google LLC
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.cloud.spanner.jdbc.AbstractConnectionImplTest.ConnectionConsumer;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class StatementTimeoutTest {
  private static final String URI =
      "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";
  private static final String SLOW_SELECT = "SELECT foo FROM bar";
  private static final String INVALID_SELECT = "SELECT FROM bar"; // missing columns / *
  private static final String FAST_SELECT = "SELECT fast_column FROM fast_table";
  private static final String SLOW_DDL = "CREATE TABLE foo";
  private static final String FAST_DDL = "CREATE TABLE fast_table";
  private static final String SLOW_UPDATE = "UPDATE foo SET col1=1 WHERE id=2";
  private static final String FAST_UPDATE = "UPDATE fast_table SET foo=1 WHERE bar=2";

  /** Execution time for statements that have been defined as slow. */
  private static final long EXECUTION_TIME_SLOW_STATEMENT = 10_000L;
  /**
   * This timeout should be high enough that it will never be exceeded, even on a slow build
   * environment, but still significantly lower than the expected execution time of the slow
   * statements.
   */
  private static final long TIMEOUT_FOR_FAST_STATEMENTS = 1000L;

  /**
   * This timeout should be low enough that it will not make the test case unnecessarily slow, but
   * still high enough that it would normally not be exceeded for a statement that is executed
   * directly.
   */
  private static final long TIMEOUT_FOR_SLOW_STATEMENTS = 20L;
  /**
   * The number of milliseconds to wait before cancelling a query should be high enough to not cause
   * flakiness on a slow environment, but at the same time low enough that it does not slow down the
   * test case unnecessarily.
   */
  private static final int WAIT_BEFORE_CANCEL = 100;

  private enum CommitRollbackBehavior {
    FAST,
    SLOW_COMMIT,
    SLOW_ROLLBACK;
  }

  @Rule public ExpectedException expected = ExpectedException.none();

  private static final class DelayedQueryExecution implements Answer<ResultSet> {
    @Override
    public ResultSet answer(InvocationOnMock invocation) throws Throwable {
      Thread.sleep(EXECUTION_TIME_SLOW_STATEMENT);
      return mock(ResultSet.class);
    }
  }

  private DdlClient createDefaultMockDdlClient(final long waitForMillis) {
    try {
      DdlClient ddlClient = mock(DdlClient.class);
      UpdateDatabaseDdlMetadata metadata = UpdateDatabaseDdlMetadata.getDefaultInstance();
      ApiFuture<UpdateDatabaseDdlMetadata> futureMetadata = ApiFutures.immediateFuture(metadata);
      @SuppressWarnings("unchecked")
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> operation =
          mock(OperationFuture.class);
      if (waitForMillis > 0L) {
        when(operation.get())
            .thenAnswer(
                new Answer<Void>() {
                  @Override
                  public Void answer(InvocationOnMock invocation) throws Throwable {
                    Thread.sleep(waitForMillis);
                    return null;
                  }
                });
      } else {
        when(operation.get()).thenReturn(null);
      }
      when(operation.getMetadata()).thenReturn(futureMetadata);
      when(ddlClient.executeDdl(SLOW_DDL)).thenCallRealMethod();
      when(ddlClient.executeDdl(anyListOf(String.class))).thenReturn(operation);

      @SuppressWarnings("unchecked")
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> fastOperation =
          mock(OperationFuture.class);
      when(fastOperation.isDone()).thenReturn(true);
      when(fastOperation.get()).thenReturn(null);
      when(fastOperation.getMetadata()).thenReturn(futureMetadata);
      when(ddlClient.executeDdl(FAST_DDL)).thenReturn(fastOperation);
      when(ddlClient.executeDdl(Arrays.asList(FAST_DDL))).thenReturn(fastOperation);
      return ddlClient;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private ConnectionImpl createConnection(ConnectionOptions options) {
    return createConnection(options, CommitRollbackBehavior.FAST);
  }

  /**
   * Creates a connection on which the statements {@link StatementTimeoutTest#SLOW_SELECT} and
   * {@link StatementTimeoutTest#SLOW_DDL} will take at least 10,000 milliseconds
   */
  private ConnectionImpl createConnection(
      ConnectionOptions options, final CommitRollbackBehavior commitRollbackBehavior) {
    DatabaseClient dbClient = mock(DatabaseClient.class);
    Spanner spanner = mock(Spanner.class);
    SpannerPool spannerPool = mock(SpannerPool.class);
    when(spannerPool.getSpanner(any(ConnectionOptions.class), any(ConnectionImpl.class)))
        .thenReturn(spanner);
    DdlClient ddlClient = createDefaultMockDdlClient(EXECUTION_TIME_SLOW_STATEMENT);
    final ResultSet invalidResultSet = mock(ResultSet.class);
    when(invalidResultSet.next())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INVALID_ARGUMENT, "invalid query"));

    ReadOnlyTransaction singleUseReadOnlyTx = mock(ReadOnlyTransaction.class);
    when(singleUseReadOnlyTx.executeQuery(Statement.of(SLOW_SELECT)))
        .thenAnswer(new DelayedQueryExecution());
    when(singleUseReadOnlyTx.executeQuery(Statement.of(FAST_SELECT)))
        .thenReturn(mock(ResultSet.class));
    when(singleUseReadOnlyTx.executeQuery(Statement.of(INVALID_SELECT)))
        .thenReturn(invalidResultSet);
    when(dbClient.singleUseReadOnlyTransaction(Matchers.any(TimestampBound.class)))
        .thenReturn(singleUseReadOnlyTx);

    ReadOnlyTransaction readOnlyTx = mock(ReadOnlyTransaction.class);
    when(readOnlyTx.executeQuery(Statement.of(SLOW_SELECT)))
        .thenAnswer(new DelayedQueryExecution());
    when(readOnlyTx.executeQuery(Statement.of(FAST_SELECT))).thenReturn(mock(ResultSet.class));
    when(readOnlyTx.executeQuery(Statement.of(INVALID_SELECT))).thenReturn(invalidResultSet);
    when(dbClient.readOnlyTransaction(Matchers.any(TimestampBound.class))).thenReturn(readOnlyTx);

    when(dbClient.transactionManager())
        .thenAnswer(
            new Answer<TransactionManager>() {
              @Override
              public TransactionManager answer(InvocationOnMock invocation) throws Throwable {
                TransactionManager txManager = mock(TransactionManager.class);
                when(txManager.getState()).thenReturn(null, TransactionState.STARTED);
                when(txManager.begin())
                    .thenAnswer(
                        new Answer<TransactionContext>() {
                          @Override
                          public TransactionContext answer(InvocationOnMock invocation)
                              throws Throwable {
                            TransactionContext txContext = mock(TransactionContext.class);
                            when(txContext.executeQuery(Statement.of(SLOW_SELECT)))
                                .thenAnswer(new DelayedQueryExecution());
                            when(txContext.executeQuery(Statement.of(FAST_SELECT)))
                                .thenReturn(mock(ResultSet.class));
                            when(txContext.executeQuery(Statement.of(INVALID_SELECT)))
                                .thenReturn(invalidResultSet);
                            when(txContext.executeUpdate(Statement.of(SLOW_UPDATE)))
                                .thenAnswer(
                                    new Answer<Long>() {
                                      @Override
                                      public Long answer(InvocationOnMock invocation)
                                          throws Throwable {
                                        Thread.sleep(EXECUTION_TIME_SLOW_STATEMENT);
                                        return 1L;
                                      }
                                    });
                            when(txContext.executeUpdate(Statement.of(FAST_UPDATE))).thenReturn(1L);
                            return txContext;
                          }
                        });
                if (commitRollbackBehavior == CommitRollbackBehavior.SLOW_COMMIT) {
                  doAnswer(
                          new Answer<Void>() {
                            @Override
                            public Void answer(InvocationOnMock invocation) throws Throwable {
                              Thread.sleep(EXECUTION_TIME_SLOW_STATEMENT);
                              return null;
                            }
                          })
                      .when(txManager)
                      .commit();
                }
                if (commitRollbackBehavior == CommitRollbackBehavior.SLOW_ROLLBACK) {
                  doAnswer(
                          new Answer<Void>() {
                            @Override
                            public Void answer(InvocationOnMock invocation) throws Throwable {
                              Thread.sleep(EXECUTION_TIME_SLOW_STATEMENT);
                              return null;
                            }
                          })
                      .when(txManager)
                      .rollback();
                }

                return txManager;
              }
            });
    when(dbClient.executePartitionedUpdate(Statement.of(FAST_UPDATE))).thenReturn(1L);
    when(dbClient.executePartitionedUpdate(Statement.of(SLOW_UPDATE)))
        .thenAnswer(
            new Answer<Long>() {
              @Override
              public Long answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(EXECUTION_TIME_SLOW_STATEMENT);
                return 1L;
              }
            });
    return new ConnectionImpl(options, spannerPool, ddlClient, dbClient);
  }

  @Test
  public void testTimeoutExceptionReadOnlyAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testTimeoutExceptionReadOnlyAutocommitMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        try {
          connection.executeQuery(Statement.of(SLOW_SELECT));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testTimeoutExceptionReadOnlyTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testTimeoutExceptionReadOnlyTransactionMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        try {
          connection.executeQuery(Statement.of(SLOW_SELECT));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // do a rollback without any chance of a timeout
      connection.clearStatementTimeout();
      connection.rollback();
      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommitMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        try {
          connection.executeQuery(Statement.of(SLOW_SELECT));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommitSlowUpdate() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.execute(Statement.of(SLOW_UPDATE));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommitSlowUpdateMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);

      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        try {
          connection.execute(Statement.of(SLOW_UPDATE));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // try to do a new update that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.execute(Statement.of(FAST_UPDATE)).getUpdateCount(), is(equalTo(1L)));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommitSlowCommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build(),
            CommitRollbackBehavior.SLOW_COMMIT)) {
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      // First verify that the fast update does not timeout when in transactional mode (as it is the
      // commit that is slow).
      connection.setAutocommit(false);
      connection.execute(Statement.of(FAST_UPDATE));
      connection.rollback();

      // Then verify that the update does timeout when executed in autocommit mode, as the commit
      // gRPC call will be slow.
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      connection.setAutocommit(true);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.execute(Statement.of(FAST_UPDATE));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommitSlowCommitMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build(),
            CommitRollbackBehavior.SLOW_COMMIT)) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        try {
          connection.execute(Statement.of(FAST_UPDATE));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteAutocommitPartitioned() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      // first verify that the fast update does not timeout
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      connection.execute(Statement.of(FAST_UPDATE));

      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.execute(Statement.of(SLOW_UPDATE));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteTransactionMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      // Assert that multiple statements after each other will timeout the first time, and then
      // throw a SpannerException with code FAILED_PRECONDITION.
      boolean timedOut = false;
      for (int i = 0; i < 2; i++) {
        try {
          connection.executeQuery(Statement.of(SLOW_SELECT));
        } catch (SpannerException e) {
          if (i == 0) {
            assertThat(e.getErrorCode(), is(equalTo(ErrorCode.DEADLINE_EXCEEDED)));
            timedOut = true;
          } else {
            assertThat(e.getErrorCode(), is(equalTo(ErrorCode.FAILED_PRECONDITION)));
          }
        }
      }
      assertThat(timedOut, is(true));
      // do a rollback without any chance of a timeout
      connection.clearStatementTimeout();
      connection.rollback();
      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteTransactionalSlowCommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build(),
            CommitRollbackBehavior.SLOW_COMMIT)) {
      connection.setAutocommit(false);

      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      connection.executeQuery(Statement.of(FAST_SELECT));

      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.commit();
    }
  }

  @Test
  public void testTimeoutExceptionReadWriteTransactionalSlowRollback() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build(),
            CommitRollbackBehavior.SLOW_ROLLBACK)) {
      connection.setAutocommit(false);

      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      connection.executeQuery(Statement.of(FAST_SELECT));
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.rollback();
    }
  }

  private static final class ConnectionReadOnlyAutocommit implements ConnectionConsumer {
    @Override
    public void accept(Connection t) {
      t.setReadOnly(true);
    }
  }

  @Test
  public void testInterruptedExceptionReadOnlyAutocommit()
      throws InterruptedException, ExecutionException {
    testInterruptedException(new ConnectionReadOnlyAutocommit());
  }

  private static final class ConnectionReadOnlyTransactional implements ConnectionConsumer {
    @Override
    public void accept(Connection t) {
      t.setReadOnly(true);
      t.setAutocommit(false);
    }
  }

  @Test
  public void testInterruptedExceptionReadOnlyTransactional()
      throws InterruptedException, ExecutionException {
    testInterruptedException(new ConnectionReadOnlyTransactional());
  }

  private static final class ConnectionReadWriteAutocommit implements ConnectionConsumer {
    @Override
    public void accept(Connection t) {}
  }

  @Test
  public void testInterruptedExceptionReadWriteAutocommit()
      throws InterruptedException, ExecutionException {
    testInterruptedException(new ConnectionReadWriteAutocommit());
  }

  private static final class ConnectionReadWriteTransactional implements ConnectionConsumer {
    @Override
    public void accept(Connection t) {
      t.setAutocommit(false);
    }
  }

  @Test
  public void testInterruptedExceptionReadWriteTransactional()
      throws InterruptedException, ExecutionException {
    testInterruptedException(new ConnectionReadWriteTransactional());
  }

  private void testInterruptedException(final ConnectionConsumer consumer)
      throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<Boolean> future =
        executor.submit(
            new Callable<Boolean>() {
              @Override
              public Boolean call() throws Exception {
                try (Connection connection =
                    createConnection(
                        ConnectionOptions.newBuilder()
                            .setCredentials(NoCredentials.getInstance())
                            .setUri(URI)
                            .build())) {
                  consumer.accept(connection);
                  connection.setStatementTimeout(10000L, TimeUnit.MILLISECONDS);

                  connection.executeQuery(Statement.of(SLOW_SELECT));
                } catch (SpannerException e) {
                  if (e.getErrorCode() == ErrorCode.CANCELLED) {
                    return Boolean.TRUE;
                  } else {
                    return Boolean.FALSE;
                  }
                }
                return Boolean.FALSE;
              }
            });
    // wait a little bit to ensure that the task has started
    Thread.sleep(10L);
    executor.shutdownNow();
    assertThat(future.get(), is(true));
  }

  @Test
  public void testInvalidQueryReadOnlyAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setUri(URI)
                .setCredentials(NoCredentials.getInstance())
                .build())) {
      connection.setReadOnly(true);
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.INVALID_ARGUMENT));
      connection.executeQuery(Statement.of(INVALID_SELECT));
    }
  }

  @Test
  public void testInvalidQueryReadOnlyTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.INVALID_ARGUMENT));
      connection.executeQuery(Statement.of(INVALID_SELECT));
    }
  }

  @Test
  public void testInvalidQueryReadWriteAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.INVALID_ARGUMENT));
      connection.executeQuery(Statement.of(INVALID_SELECT));
    }
  }

  @Test
  public void testInvalidQueryReadWriteTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.INVALID_ARGUMENT));
      connection.executeQuery(Statement.of(INVALID_SELECT));
    }
  }

  @Test
  public void testCancelReadOnlyAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testCancelReadOnlyAutocommitMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      boolean cancelled = false;
      try {
        connection.executeQuery(Statement.of(SLOW_SELECT));
      } catch (SpannerException e) {
        cancelled = e.getErrorCode() == ErrorCode.CANCELLED;
      }
      assertThat(cancelled, is(true));

      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testCancelReadOnlyTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setAutocommit(false);
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testCancelReadOnlyTransactionalMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setReadOnly(true);
      connection.setAutocommit(false);
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      boolean cancelled = false;
      try {
        connection.executeQuery(Statement.of(SLOW_SELECT));
      } catch (SpannerException e) {
        cancelled = e.getErrorCode() == ErrorCode.CANCELLED;
      }
      assertThat(cancelled, is(true));

      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
      // rollback and do another fast query
      connection.rollback();
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testCancelReadWriteAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testCancelReadWriteAutocommitMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      boolean cancelled = false;
      try {
        connection.executeQuery(Statement.of(SLOW_SELECT));
      } catch (SpannerException e) {
        cancelled = e.getErrorCode() == ErrorCode.CANCELLED;
      }
      assertThat(cancelled, is(true));

      // try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testCancelReadWriteAutocommitSlowUpdate() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.execute(Statement.of(SLOW_UPDATE));
    }
  }

  @Test
  public void testCancelReadWriteAutocommitSlowCommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build(),
            CommitRollbackBehavior.SLOW_COMMIT)) {
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.execute(Statement.of(FAST_UPDATE));
    }
  }

  @Test
  public void testCancelReadWriteTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.executeQuery(Statement.of(SLOW_SELECT));
    }
  }

  @Test
  public void testCancelReadWriteTransactionalMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      boolean cancelled = false;
      try {
        connection.executeQuery(Statement.of(SLOW_SELECT));
      } catch (SpannerException e) {
        cancelled = e.getErrorCode() == ErrorCode.CANCELLED;
      }
      assertThat(cancelled, is(true));
      // Rollback the transaction as it is no longer usable.
      connection.rollback();

      // Try to do a new query that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.executeQuery(Statement.of(FAST_SELECT)), is(notNullValue()));
    }
  }

  @Test
  public void testCancelDdlBatch() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      connection.startBatchDdl();
      connection.execute(Statement.of(SLOW_DDL));
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.runBatch();
    }
  }

  @Test
  public void testCancelDdlAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      Executors.newSingleThreadScheduledExecutor()
          .schedule(
              new Runnable() {
                @Override
                public void run() {
                  connection.cancel();
                }
              },
              WAIT_BEFORE_CANCEL,
              TimeUnit.MILLISECONDS);

      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
      connection.execute(Statement.of(SLOW_DDL));
    }
  }

  @Test
  public void testTimeoutExceptionDdlAutocommit() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.execute(Statement.of(SLOW_DDL));
    }
  }

  @Test
  public void testTimeoutExceptionDdlAutocommitMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);

      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        try {
          connection.execute(Statement.of(SLOW_DDL));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // try to do a new DDL statement that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      assertThat(connection.execute(Statement.of(FAST_DDL)), is(notNullValue()));
    }
  }

  @Test
  public void testTimeoutExceptionDdlBatch() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      connection.startBatchDdl();
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);

      // the following statement will NOT timeout as the statement is only buffered locally
      connection.execute(Statement.of(SLOW_DDL));
      // the commit sends the statement to the server and should timeout
      expected.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      connection.runBatch();
    }
  }

  @Test
  public void testTimeoutExceptionDdlBatchMultipleStatements() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      connection.setStatementTimeout(TIMEOUT_FOR_SLOW_STATEMENTS, TimeUnit.MILLISECONDS);

      // assert that multiple statements after each other also time out
      for (int i = 0; i < 2; i++) {
        boolean timedOut = false;
        connection.startBatchDdl();
        connection.execute(Statement.of(SLOW_DDL));
        try {
          connection.runBatch();
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      // try to do a new DDL statement that is fast.
      connection.setStatementTimeout(TIMEOUT_FOR_FAST_STATEMENTS, TimeUnit.MILLISECONDS);
      connection.startBatchDdl();
      assertThat(connection.execute(Statement.of(FAST_DDL)), is(notNullValue()));
      connection.runBatch();
    }
  }

  @Test
  public void testTimeoutDifferentTimeUnits() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      for (TimeUnit unit : ReadOnlyStalenessUtil.SUPPORTED_UNITS) {
        connection.setStatementTimeout(1L, unit);
        boolean timedOut = false;
        try {
          connection.execute(Statement.of(SLOW_SELECT));
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
    }
  }
}
