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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * The tests in this class do not need to be implemented for client libraries in other programming
 * languages, as all test cases are covered by the file ConnectionImplGeneratedSqlScriptTest.sql
 */
@RunWith(Enclosed.class)
public class ConnectionImplAutocommitReadOnlyTest {

  public static class ConnectionImplAutocommitReadOnlyNoActionsTest
      extends AbstractConnectionImplTest {
    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // there is no transaction
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // no query has been executed yet
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplAutocommitReadOnlyAfterSelectTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      // no call to next() on ResultSet
      log(SELECT + ";");
      connection.executeQuery(Statement.of(SELECT));
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // there is no transaction
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last statement was a query, next() has not yet been called, but as the connection api
      // returns a directly executed resultset, the read timestamp is already available
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplAutocommitReadOnlyAfterSelectAndResultSetNextTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log(SELECT + ";");
      connection.executeQuery(Statement.of(SELECT)).next();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // there is no transaction
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last statement was a query
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplAutocommitReadOnlyAfterBeginTransactionTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return false;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return false;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return false;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // connection is in read-only mode
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      // in a transaction, only exact allowed
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // no query executed yet
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplAutocommitReadOnlyAfterTemporaryTransactionTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      log(SELECT + ";");
      connection.execute(Statement.of(SELECT)).getResultSet().next();
      log("COMMIT;");
      connection.commit();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // no transaction
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      // readonly
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last action was a transaction that ended with a select query
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplAutocommitReadOnlyAfterSetReadOnlyMaxStalenessTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      TimestampBound staleness = TimestampBound.ofMaxStaleness(10L, TimeUnit.SECONDS);
      logWithNamespace(
          "SET %sREAD_ONLY_STALENESS='"
              + ReadOnlyStalenessUtil.timestampBoundToString(staleness)
              + "';");
      connection.setReadOnlyStaleness(staleness);
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // there is no transaction
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      // readonly
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // no query executed yet
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  /**
   * Verifies that autocommit read-only connections reject DML statements with GoogleSQL {@code THEN
   * RETURN} and PostgreSQL {@code RETURNING} clauses across all synchronous and asynchronous
   * execution entrypoints without issuing write RPCs or mutating transient connection state.
   */
  @RunWith(Parameterized.class)
  public static class ConnectionImplAutocommitReadOnlyDmlReturningTest {
    private static final ExecutorProvider ASYNC_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(1)
            .setThreadFactory(
                new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .setNameFormat("autocommit-readonly-dml-returning-test-%d")
                    .build())
            .build();

    @Parameter public Dialect dialect;

    @Parameters(name = "dialect = {0}")
    public static Object[] data() {
      return Dialect.values();
    }

    private List<String> dmlReturningStatements() {
      if (dialect == Dialect.POSTGRESQL) {
        return Arrays.asList(
            "INSERT INTO foo (id, name) VALUES (1, 'bar') RETURNING id",
            "UPDATE foo SET bar=1 WHERE id=1 RETURNING bar",
            "DELETE FROM foo WHERE id=1 RETURNING id");
      }
      return Arrays.asList(
          "INSERT INTO foo (id, name) VALUES (1, 'bar') THEN RETURN id",
          "UPDATE foo SET bar=1 WHERE id=1 THEN RETURN bar",
          "DELETE FROM foo WHERE id=1 THEN RETURN id");
    }

    /**
     * Creates an autocommit read-only {@link ConnectionImpl} backed by {@code dbClient} with a
     * stubbed {@code readWriteTransaction()} so any unguarded write execution succeeds rather than
     * failing with an unrelated mock null-pointer error.
     */
    private ConnectionImpl createAutocommitReadOnlyConnection(DatabaseClient dbClient) {
      Spanner spanner = mock(Spanner.class);
      when(spanner.getAsyncExecutorProvider()).thenReturn(ASYNC_EXECUTOR_PROVIDER);
      SpannerPool spannerPool = mock(SpannerPool.class);
      when(spannerPool.getSpanner(any(ConnectionOptions.class), any(ConnectionImpl.class)))
          .thenReturn(spanner);
      when(dbClient.getDialect()).thenReturn(dialect);
      when(dbClient.readWriteTransaction())
          .thenAnswer(
              invocation ->
                  new TransactionRunner() {
                    private CommitResponse commitResponse;

                    @Override
                    public <T> T run(TransactionCallable<T> callable) {
                      TransactionContext txContext = mock(TransactionContext.class);
                      ResultSet returningRs = mock(ResultSet.class);
                      when(returningRs.next()).thenReturn(true, false);
                      when(returningRs.getLong(0)).thenReturn(1L);
                      when(txContext.executeQuery(any(Statement.class), any()))
                          .thenReturn(returningRs);
                      try {
                        T result = callable.run(txContext);
                        commitResponse = new CommitResponse(Timestamp.ofTimeSecondsAndNanos(1, 1));
                        return result;
                      } catch (Exception e) {
                        throw SpannerExceptionFactory.newSpannerException(e);
                      }
                    }

                    @Override
                    public Timestamp getCommitTimestamp() {
                      return commitResponse.getCommitTimestamp();
                    }

                    @Override
                    public CommitResponse getCommitResponse() {
                      return commitResponse;
                    }

                    @Override
                    public TransactionRunner allowNestedTransaction() {
                      return this;
                    }
                  });

      ConnectionOptions options =
          ConnectionOptions.newBuilder()
              .setCredentials(NoCredentials.getInstance())
              .setUri(ConnectionImplTest.URI)
              .build();
      ConnectionImpl connection =
          new ConnectionImpl(
              options, spannerPool, mock(DdlClient.class), dbClient, mock(BatchClient.class));
      connection.setAutocommit(true);
      connection.setReadOnly(true);
      assertTrue(connection.isAutocommit());
      assertTrue(connection.isReadOnly());
      return connection;
    }

    @Test
    public void testExecuteDmlReturningRejectedInAutocommitReadOnly() {
      for (String sql : dmlReturningStatements()) {
        Statement stmt = Statement.of(sql);
        String expectedMessage =
            "DML statement with returning clause cannot be executed in read-only mode: " + sql;
        DatabaseClient dbClient = mock(DatabaseClient.class);
        try (ConnectionImpl connection = createAutocommitReadOnlyConnection(dbClient)) {
          connection.setStatementTag("autocommit-tag");

          SpannerException execEx =
              assertThrows(SpannerException.class, () -> connection.execute(stmt));
          assertEquals(ErrorCode.FAILED_PRECONDITION, execEx.getErrorCode());
          assertTrue(execEx.getMessage().contains(expectedMessage));
          assertEquals("autocommit-tag", connection.getStatementTag());

          SpannerException execAllowedTypesEx =
              assertThrows(
                  SpannerException.class,
                  () -> connection.execute(stmt, Collections.singleton(ResultType.RESULT_SET)));
          assertEquals(ErrorCode.FAILED_PRECONDITION, execAllowedTypesEx.getErrorCode());
          assertTrue(execAllowedTypesEx.getMessage().contains(expectedMessage));
          assertEquals("autocommit-tag", connection.getStatementTag());

          SpannerException execAsyncEx =
              assertThrows(SpannerException.class, () -> connection.executeAsync(stmt));
          assertEquals(ErrorCode.FAILED_PRECONDITION, execAsyncEx.getErrorCode());
          assertTrue(execAsyncEx.getMessage().contains(expectedMessage));
          assertEquals("autocommit-tag", connection.getStatementTag());
          assertFalse(connection.isTransactionStarted());

          verify(dbClient, never()).readWriteTransaction();
          verify(dbClient, never()).readWriteTransaction(any());
        }
      }
    }

    @Test
    public void testExecuteQueryAndAnalyzeQueryDmlReturningRejectedInAutocommitReadOnly() {
      for (String sql : dmlReturningStatements()) {
        Statement stmt = Statement.of(sql);
        String expectedMessage =
            "DML statement with returning clause cannot be executed in read-only mode: " + sql;
        DatabaseClient dbClient = mock(DatabaseClient.class);
        try (ConnectionImpl connection = createAutocommitReadOnlyConnection(dbClient)) {
          connection.setStatementTag("query-tag");

          SpannerException queryEx =
              assertThrows(SpannerException.class, () -> connection.executeQuery(stmt));
          assertEquals(ErrorCode.FAILED_PRECONDITION, queryEx.getErrorCode());
          assertTrue(queryEx.getMessage().contains(expectedMessage));
          assertEquals("query-tag", connection.getStatementTag());

          SpannerException queryAsyncEx =
              assertThrows(SpannerException.class, () -> connection.executeQueryAsync(stmt));
          assertEquals(ErrorCode.FAILED_PRECONDITION, queryAsyncEx.getErrorCode());
          assertTrue(queryAsyncEx.getMessage().contains(expectedMessage));
          assertEquals("query-tag", connection.getStatementTag());

          for (QueryAnalyzeMode analyzeMode : QueryAnalyzeMode.values()) {
            SpannerException analyzeEx =
                assertThrows(
                    SpannerException.class, () -> connection.analyzeQuery(stmt, analyzeMode));
            assertEquals(ErrorCode.FAILED_PRECONDITION, analyzeEx.getErrorCode());
            assertTrue(analyzeEx.getMessage().contains(expectedMessage));
            assertEquals("query-tag", connection.getStatementTag());
          }

          verify(dbClient, never()).readWriteTransaction();
          verify(dbClient, never()).readWriteTransaction(any());
        }
      }
    }
  }
}
