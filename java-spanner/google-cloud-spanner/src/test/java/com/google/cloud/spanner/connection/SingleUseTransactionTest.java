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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTOCOMMIT_DML_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.READONLY;
import static com.google.cloud.spanner.connection.ConnectionProperties.READ_ONLY_STALENESS;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.cloud.spanner.connection.StatementExecutor.StatementTimeout;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.v1.ResultSetStats;
import io.opentelemetry.api.trace.Span;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class SingleUseTransactionTest {
  private static final String VALID_QUERY = "SELECT * FROM FOO";
  private static final String INVALID_QUERY = "SELECT * FROM BAR";
  private static final String SLOW_QUERY = "SELECT * FROM SLOW_TABLE";
  private static final String VALID_UPDATE = "UPDATE FOO SET BAR=1";
  private static final String INVALID_UPDATE = "UPDATE BAR SET FOO=1";
  private static final String SLOW_UPDATE = "UPDATE SLOW_TABLE SET FOO=1";
  private static final String VALID_DDL = "CREATE TABLE FOO";
  private static final long VALID_UPDATE_COUNT = 99L;

  private final StatementExecutor executor = new StatementExecutor();

  private enum CommitBehavior {
    SUCCEED,
    FAIL,
    ABORT
  }

  /** Creates a {@link StatementTimeout} that will never timeout. */
  static StatementTimeout nullTimeout() {
    return new StatementTimeout();
  }

  /** Creates a {@link StatementTimeout} with the given duration. */
  static StatementTimeout timeout(long timeout, TimeUnit unit) {
    Preconditions.checkArgument(timeout > 0L);
    Preconditions.checkArgument(StatementTimeout.isValidTimeoutUnit(unit));
    StatementTimeout res = new StatementTimeout();
    res.setTimeoutValue(timeout, unit);
    return res;
  }

  private static class SimpleTransactionManager implements TransactionManager {
    private TransactionState state;
    private CommitResponse commitResponse;
    private TransactionContext txContext;
    private CommitBehavior commitBehavior;

    private SimpleTransactionManager(TransactionContext txContext, CommitBehavior commitBehavior) {
      this.txContext = txContext;
      this.commitBehavior = commitBehavior;
    }

    @Override
    public TransactionContext begin() {
      state = TransactionState.STARTED;
      return txContext;
    }

    @Override
    public TransactionContext begin(AbortedException exception) {
      return begin();
    }

    @Override
    public void commit() {
      switch (commitBehavior) {
        case SUCCEED:
          commitResponse = new CommitResponse(Timestamp.ofTimeSecondsAndNanos(1, 1));
          state = TransactionState.COMMITTED;
          break;
        case FAIL:
          state = TransactionState.COMMIT_FAILED;
          throw SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "commit failed");
        case ABORT:
          state = TransactionState.COMMIT_FAILED;
          commitBehavior = CommitBehavior.SUCCEED;
          throw SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "commit aborted");
        default:
          throw new IllegalStateException();
      }
    }

    @Override
    public void rollback() {
      state = TransactionState.ROLLED_BACK;
    }

    @Override
    public TransactionContext resetForRetry() {
      return txContext;
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
    public TransactionState getState() {
      return state;
    }

    @Override
    public void close() {
      if (state != TransactionState.COMMITTED) {
        state = TransactionState.ROLLED_BACK;
      }
    }
  }

  private static final class SimpleReadOnlyTransaction
      implements com.google.cloud.spanner.ReadOnlyTransaction {
    private Timestamp readTimestamp = null;
    private final TimestampBound staleness;

    private SimpleReadOnlyTransaction(TimestampBound staleness) {
      this.staleness = staleness;
    }

    @Override
    public ResultSet read(
        String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return null;
    }

    @Override
    public ResultSet readUsingIndex(
        String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return null;
    }

    @Override
    public Struct readRow(String table, Key key, Iterable<String> columns) {
      return null;
    }

    @Override
    public Struct readRowUsingIndex(String table, String index, Key key, Iterable<String> columns) {
      return null;
    }

    @Override
    public ResultSet executeQuery(Statement statement, QueryOption... options) {
      if (statement.equals(Statement.of(VALID_QUERY))) {
        if (readTimestamp == null) {
          switch (staleness.getMode()) {
            case STRONG:
              readTimestamp = Timestamp.now();
              break;
            case READ_TIMESTAMP:
              readTimestamp = staleness.getReadTimestamp();
              break;
            case MIN_READ_TIMESTAMP:
              readTimestamp = staleness.getMinReadTimestamp();
              break;
            case EXACT_STALENESS:
              Calendar cal = Calendar.getInstance();
              cal.add(
                  Calendar.MILLISECOND, (int) -staleness.getExactStaleness(TimeUnit.MILLISECONDS));
              readTimestamp = Timestamp.of(cal.getTime());
              break;
            case MAX_STALENESS:
              cal = Calendar.getInstance();
              cal.add(
                  Calendar.MILLISECOND, (int) -staleness.getMaxStaleness(TimeUnit.MILLISECONDS));
              readTimestamp = Timestamp.of(cal.getTime());
              break;
            default:
              throw new IllegalStateException();
          }
        }
        return mock(ResultSet.class);
      } else if (statement.equals(Statement.of(SLOW_QUERY))) {
        try {
          Thread.sleep(10L);
        } catch (InterruptedException e) {
          // ignore
        }
        readTimestamp = Timestamp.now();
        return mock(ResultSet.class);
      } else if (statement.equals(Statement.of(INVALID_QUERY))) {
        throw SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "invalid query");
      } else {
        throw new IllegalArgumentException();
      }
    }

    @Override
    public ResultSet analyzeQuery(Statement statement, QueryAnalyzeMode queryMode) {
      ResultSet rs = executeQuery(statement);
      when(rs.getStats()).thenReturn(ResultSetStats.getDefaultInstance());
      return rs;
    }

    @Override
    public void close() {}

    @Override
    public Timestamp getReadTimestamp() {
      return readTimestamp;
    }

    @Override
    public AsyncResultSet readAsync(
        String table, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return null;
    }

    @Override
    public AsyncResultSet readUsingIndexAsync(
        String table, String index, KeySet keys, Iterable<String> columns, ReadOption... options) {
      return null;
    }

    @Override
    public ApiFuture<Struct> readRowAsync(String table, Key key, Iterable<String> columns) {
      return null;
    }

    @Override
    public ApiFuture<Struct> readRowUsingIndexAsync(
        String table, String index, Key key, Iterable<String> columns) {
      return null;
    }

    @Override
    public AsyncResultSet executeQueryAsync(Statement statement, QueryOption... options) {
      return null;
    }
  }

  private DdlClient createDefaultMockDdlClient() {
    try {
      DdlClient ddlClient = mock(DdlClient.class);
      @SuppressWarnings("unchecked")
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> operation =
          mock(OperationFuture.class);
      when(operation.get()).thenReturn(null);
      when(ddlClient.executeDdl(anyString(), any())).thenCallRealMethod();
      when(ddlClient.executeDdl(anyList(), any())).thenReturn(operation);
      doCallRealMethod()
          .when(ddlClient)
          .runWithRetryForMissingDefaultSequenceKind(any(), any(), any(), any());
      return ddlClient;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private SingleUseTransaction createSubject() {
    return createSubject(
        createDefaultMockDdlClient(),
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        0L,
        null);
  }

  private SingleUseTransaction createSubject(AutocommitDmlMode dmlMode) {
    return createSubject(
        createDefaultMockDdlClient(),
        false,
        TimestampBound.strong(),
        dmlMode,
        CommitBehavior.SUCCEED,
        0L,
        null);
  }

  private SingleUseTransaction createSubject(CommitBehavior commitBehavior) {
    return createSubject(
        createDefaultMockDdlClient(),
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        commitBehavior,
        0L,
        null);
  }

  private SingleUseTransaction createDdlSubject(DdlClient ddlClient) {
    return createSubject(
        ddlClient,
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        0L,
        null);
  }

  private SingleUseTransaction createProtoDescriptorsSubject(
      DdlClient ddlClient, byte[] protoDescriptors) {
    return createSubject(
        ddlClient,
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        0L,
        protoDescriptors);
  }

  private SingleUseTransaction createReadOnlySubject(TimestampBound staleness) {
    return createSubject(
        createDefaultMockDdlClient(),
        true,
        staleness,
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        0L,
        null);
  }

  private SingleUseTransaction createSubject(
      DdlClient ddlClient,
      boolean readOnly,
      TimestampBound staleness,
      AutocommitDmlMode dmlMode,
      final CommitBehavior commitBehavior,
      long timeout,
      byte[] protoDescriptors) {
    DatabaseClient dbClient = mock(DatabaseClient.class);
    com.google.cloud.spanner.ReadOnlyTransaction singleUse =
        new SimpleReadOnlyTransaction(staleness);
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    when(dbClient.singleUseReadOnlyTransaction(staleness)).thenReturn(singleUse);

    final TransactionContext txContext = mock(TransactionContext.class);
    when(txContext.executeUpdate(Statement.of(VALID_UPDATE))).thenReturn(VALID_UPDATE_COUNT);
    when(txContext.executeUpdate(Statement.of(VALID_UPDATE), Options.lastStatement()))
        .thenReturn(VALID_UPDATE_COUNT);
    when(txContext.executeUpdate(Statement.of(SLOW_UPDATE)))
        .thenAnswer(
            invocation -> {
              Thread.sleep(1000L);
              return VALID_UPDATE_COUNT;
            });
    when(txContext.executeUpdate(Statement.of(INVALID_UPDATE)))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "invalid update"));
    when(txContext.executeUpdate(Statement.of(INVALID_UPDATE), Options.lastStatement()))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "invalid update"));
    SimpleTransactionManager txManager = new SimpleTransactionManager(txContext, commitBehavior);
    when(dbClient.transactionManager()).thenReturn(txManager);

    when(dbClient.executePartitionedUpdate(Statement.of(VALID_UPDATE)))
        .thenReturn(VALID_UPDATE_COUNT);
    when(dbClient.executePartitionedUpdate(Statement.of(INVALID_UPDATE)))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "invalid update"));

    ConnectionState connectionState = new ConnectionState(new HashMap<>());
    connectionState.setValue(AUTOCOMMIT_DML_MODE, dmlMode, Context.STARTUP, false);
    connectionState.setValue(READONLY, readOnly, Context.STARTUP, false);
    connectionState.setValue(READ_ONLY_STALENESS, staleness, Context.STARTUP, false);

    when(dbClient.readWriteTransaction())
        .thenAnswer(
            new Answer<TransactionRunner>() {
              @Override
              public TransactionRunner answer(InvocationOnMock invocation) {
                return new TransactionRunner() {
                  private CommitResponse commitResponse;

                  @Override
                  public <T> T run(TransactionCallable<T> callable) {
                    if (commitBehavior == CommitBehavior.SUCCEED) {
                      T res;
                      try {
                        res = callable.run(txContext);
                      } catch (Exception e) {
                        throw SpannerExceptionFactory.newSpannerException(e);
                      }
                      commitResponse = new CommitResponse(Timestamp.ofTimeSecondsAndNanos(1, 1));
                      return res;
                    } else if (commitBehavior == CommitBehavior.FAIL) {
                      throw SpannerExceptionFactory.newSpannerException(
                          ErrorCode.UNKNOWN, "commit failed");
                    } else {
                      throw SpannerExceptionFactory.newSpannerException(
                          ErrorCode.ABORTED, "commit aborted");
                    }
                  }

                  @Override
                  public Timestamp getCommitTimestamp() {
                    if (commitResponse == null) {
                      throw new IllegalStateException("no commit timestamp");
                    }
                    return commitResponse.getCommitTimestamp();
                  }

                  public CommitResponse getCommitResponse() {
                    if (commitResponse == null) {
                      throw new IllegalStateException("no commit response");
                    }
                    return commitResponse;
                  }

                  @Override
                  public TransactionRunner allowNestedTransaction() {
                    return this;
                  }
                };
              }
            });

    return SingleUseTransaction.newBuilder()
        .setDatabaseClient(dbClient)
        .setBatchClient(mock(BatchClient.class))
        .setDdlClient(ddlClient)
        .setConnectionState(connectionState)
        .setStatementTimeout(
            timeout == 0L ? nullTimeout() : timeout(timeout, TimeUnit.MILLISECONDS))
        .withStatementExecutor(executor)
        .setSpan(Span.getInvalid())
        .setProtoDescriptors(protoDescriptors)
        .build();
  }

  private ParsedStatement createParsedDdl(String sql) {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of(sql));
    when(statement.getSql()).thenReturn(sql);
    return statement;
  }

  private ParsedStatement createParsedQuery(String sql) {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.QUERY);
    when(statement.isQuery()).thenReturn(true);
    when(statement.getStatement()).thenReturn(Statement.of(sql));
    return statement;
  }

  private ParsedStatement createParsedUpdate(String sql) {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.UPDATE);
    when(statement.isUpdate()).thenReturn(true);
    when(statement.getStatement()).thenReturn(Statement.of(sql));
    return statement;
  }

  private List<TimestampBound> getTestTimestampBounds() {
    return Arrays.asList(
        TimestampBound.strong(),
        TimestampBound.ofReadTimestamp(Timestamp.now()),
        TimestampBound.ofMinReadTimestamp(Timestamp.now()),
        TimestampBound.ofExactStaleness(1L, TimeUnit.SECONDS),
        TimestampBound.ofMaxStaleness(100L, TimeUnit.MILLISECONDS));
  }

  @Test
  public void testCommit() {
    SingleUseTransaction subject = createSubject();
    try {
      subject.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE);
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testRollback() {
    SingleUseTransaction subject = createSubject();
    try {
      subject.rollbackAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE);
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testRunBatch() {
    SingleUseTransaction subject = createSubject();
    try {
      subject.runBatchAsync(CallType.SYNC);
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testAbortBatch() {
    SingleUseTransaction subject = createSubject();
    try {
      subject.abortBatch();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testExecuteDdl() {
    String sql = "CREATE TABLE FOO";
    ParsedStatement ddl = createParsedDdl(sql);
    DdlClient ddlClient = createDefaultMockDdlClient();
    SingleUseTransaction subject = createDdlSubject(ddlClient);
    get(subject.executeDdlAsync(CallType.SYNC, ddl));
    verify(ddlClient).executeDdl(sql, null);
  }

  @Test
  public void testExecuteDdlWithProtoDescriptors() {
    String sql = "CREATE TABLE FOO";
    ParsedStatement ddl = createParsedDdl(sql);
    DdlClient ddlClient = createDefaultMockDdlClient();
    // verify when protoDescriptors value is null
    SingleUseTransaction subject = createProtoDescriptorsSubject(ddlClient, null);
    get(subject.executeDdlAsync(CallType.SYNC, ddl));
    verify(ddlClient).executeDdl(sql, null);

    // verify when protoDescriptors value is not null
    byte[] protoDescriptors;
    try {
      InputStream in =
          SingleUseTransactionTest.class
              .getClassLoader()
              .getResourceAsStream("com/google/cloud/spanner/descriptors.pb");
      assertNotNull(in);
      protoDescriptors = ByteStreams.toByteArray(in);
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
    subject = createProtoDescriptorsSubject(ddlClient, protoDescriptors);
    get(subject.executeDdlAsync(CallType.SYNC, ddl));
    verify(ddlClient).executeDdl(sql, protoDescriptors);
  }

  @Test
  public void testExecuteCreateDatabase() {
    String sql = "CREATE DATABASE FOO";
    ParsedStatement ddl = createParsedDdl(sql);
    DdlClient ddlClient = createDefaultMockDdlClient();
    when(ddlClient.executeCreateDatabase(sql, Dialect.GOOGLE_STANDARD_SQL))
        .thenReturn(mock(OperationFuture.class));

    SingleUseTransaction singleUseTransaction = createDdlSubject(ddlClient);
    get(singleUseTransaction.executeDdlAsync(CallType.SYNC, ddl));
    verify(ddlClient).executeCreateDatabase(sql, Dialect.GOOGLE_STANDARD_SQL);
  }

  @Test
  public void testExecuteQuery() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      for (AnalyzeMode analyzeMode : AnalyzeMode.values()) {
        SingleUseTransaction subject = createReadOnlySubject(staleness);
        ResultSet rs =
            get(
                subject.executeQueryAsync(
                    CallType.SYNC, createParsedQuery(VALID_QUERY), analyzeMode));
        assertThat(rs).isNotNull();
        assertThat(subject.getReadTimestamp()).isNotNull();
        assertThat(subject.getState())
            .isEqualTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMITTED);
        while (rs.next()) {
          // just loop to the end to get stats
        }
        if (analyzeMode == AnalyzeMode.NONE) {
          assertThat(rs.getStats()).isNull();
        } else {
          assertThat(rs.getStats()).isNotNull();
        }
      }
    }
    for (TimestampBound staleness : getTestTimestampBounds()) {
      SingleUseTransaction subject = createReadOnlySubject(staleness);
      try {
        get(
            subject.executeQueryAsync(
                CallType.SYNC, createParsedQuery(INVALID_QUERY), AnalyzeMode.NONE));
        fail("missing expected exception");
      } catch (SpannerException e) {
        assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      }
      assertThat(subject.getState())
          .isEqualTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMIT_FAILED);
    }
  }

  @Test
  public void testExecuteQueryWithOptionsTest() {
    String sql = "SELECT * FROM FOO";
    QueryOption option = Options.prefetchChunks(10000);
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of(sql);
    when(parsedStatement.getStatement()).thenReturn(statement);
    DatabaseClient client = mock(DatabaseClient.class);
    com.google.cloud.spanner.ReadOnlyTransaction tx =
        mock(com.google.cloud.spanner.ReadOnlyTransaction.class);
    when(tx.executeQuery(Statement.of(sql), option)).thenReturn(mock(ResultSet.class));
    when(client.singleUseReadOnlyTransaction(TimestampBound.strong())).thenReturn(tx);

    ConnectionState connectionState = new ConnectionState(new HashMap<>());
    connectionState.setValue(
        AUTOCOMMIT_DML_MODE, AutocommitDmlMode.TRANSACTIONAL, Context.STARTUP, false);
    connectionState.setValue(READ_ONLY_STALENESS, TimestampBound.strong(), Context.STARTUP, false);

    SingleUseTransaction transaction =
        SingleUseTransaction.newBuilder()
            .setDatabaseClient(client)
            .setBatchClient(mock(BatchClient.class))
            .setDdlClient(mock(DdlClient.class))
            .setConnectionState(connectionState)
            .withStatementExecutor(executor)
            .setSpan(Span.getInvalid())
            .build();
    assertThat(
            get(
                transaction.executeQueryAsync(
                    CallType.SYNC, parsedStatement, AnalyzeMode.NONE, option)))
        .isNotNull();
  }

  @Test
  public void testExecuteUpdate_Transactional_Valid() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject();
    long updateCount = get(subject.executeUpdateAsync(CallType.SYNC, update));
    assertThat(updateCount).isEqualTo(VALID_UPDATE_COUNT);
    assertThat(subject.getCommitTimestamp()).isNotNull();
    assertThat(subject.getState())
        .isEqualTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMITTED);
  }

  @Test
  public void testExecuteUpdate_Transactional_Invalid() {
    ParsedStatement update = createParsedUpdate(INVALID_UPDATE);
    SingleUseTransaction subject = createSubject();
    try {
      get(subject.executeUpdateAsync(CallType.SYNC, update));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage()).contains("invalid update");
    }
  }

  @Test
  public void testExecuteUpdate_Transactional_Valid_FailedCommit() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject(CommitBehavior.FAIL);
    try {
      get(subject.executeUpdateAsync(CallType.SYNC, update));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage()).contains("commit failed");
    }
  }

  @Test
  public void testExecuteUpdate_Partitioned_Valid() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
    long updateCount = get(subject.executeUpdateAsync(CallType.SYNC, update));
    assertThat(updateCount).isEqualTo(VALID_UPDATE_COUNT);
    assertThat(subject.getState())
        .isEqualTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMITTED);
  }

  @Test
  public void testExecuteUpdate_Partitioned_Invalid() {
    ParsedStatement update = createParsedUpdate(INVALID_UPDATE);
    SingleUseTransaction subject = createSubject(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
    try {
      get(subject.executeUpdateAsync(CallType.SYNC, update));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage()).contains("invalid update");
    }
  }

  @Test
  public void testWriteIterable() {
    SingleUseTransaction subject = createSubject();
    Mutation mutation = Mutation.newInsertBuilder("FOO").build();
    get(subject.writeAsync(CallType.SYNC, Arrays.asList(mutation, mutation)));
    assertThat(subject.getCommitTimestamp()).isNotNull();
    assertThat(subject.getState())
        .isEqualTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMITTED);
  }

  @Test
  public void testWriteIterableFail() {
    SingleUseTransaction subject = createSubject(CommitBehavior.FAIL);
    Mutation mutation = Mutation.newInsertBuilder("FOO").build();
    try {
      get(subject.writeAsync(CallType.SYNC, Arrays.asList(mutation, mutation)));
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
      assertThat(e.getMessage()).contains("commit failed");
    }
  }

  @Test
  public void testMultiUse() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      SingleUseTransaction subject = createReadOnlySubject(staleness);
      ResultSet rs =
          get(
              subject.executeQueryAsync(
                  CallType.SYNC, createParsedQuery(VALID_QUERY), AnalyzeMode.NONE));
      assertThat(rs).isNotNull();
      assertThat(subject.getReadTimestamp()).isNotNull();
      try {
        get(
            subject.executeQueryAsync(
                CallType.SYNC, createParsedQuery(VALID_QUERY), AnalyzeMode.NONE));
        fail("missing expected exception");
      } catch (IllegalStateException e) {
        // Expected exception
      }
    }

    String sql = "CREATE TABLE FOO";
    ParsedStatement ddl = createParsedDdl(sql);
    DdlClient ddlClient = createDefaultMockDdlClient();
    SingleUseTransaction subject = createDdlSubject(ddlClient);
    get(subject.executeDdlAsync(CallType.SYNC, ddl));
    verify(ddlClient).executeDdl(sql, null);
    try {
      get(subject.executeDdlAsync(CallType.SYNC, ddl));
      fail("missing expected exception");
    } catch (IllegalStateException e) {
      // Expected exception
    }

    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    subject = createSubject();
    long updateCount = get(subject.executeUpdateAsync(CallType.SYNC, update));
    assertThat(updateCount).isEqualTo(VALID_UPDATE_COUNT);
    assertThat(subject.getCommitTimestamp()).isNotNull();
    try {
      get(subject.executeUpdateAsync(CallType.SYNC, update));
      fail("missing expected exception");
    } catch (IllegalStateException e) {
      // Expected exception
    }

    subject = createSubject();
    get(
        subject.writeAsync(
            CallType.SYNC, Collections.singleton(Mutation.newInsertBuilder("FOO").build())));
    assertThat(subject.getCommitTimestamp()).isNotNull();
    try {
      get(
          subject.writeAsync(
              CallType.SYNC, Collections.singleton(Mutation.newInsertBuilder("FOO").build())));
      fail("missing expected exception");
    } catch (IllegalStateException e) {
      // Expected exception
    }

    subject = createSubject();
    Mutation mutation = Mutation.newInsertBuilder("FOO").build();
    get(subject.writeAsync(CallType.SYNC, Arrays.asList(mutation, mutation)));
    assertThat(subject.getCommitTimestamp()).isNotNull();
    try {
      get(subject.writeAsync(CallType.SYNC, Arrays.asList(mutation, mutation)));
      fail("missing expected exception");
    } catch (IllegalStateException e) {
      // Expected exception
    }
  }

  @Test
  public void testGetCommitResponseAfterUpdate() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction transaction = createSubject();
    get(transaction.executeUpdateAsync(CallType.SYNC, update));
    assertNotNull(transaction.getCommitResponse());
    assertNotNull(transaction.getCommitResponseOrNull());
  }

  @Test
  public void testGetCommitResponseAfterQuery() {
    ParsedStatement query = createParsedQuery(VALID_QUERY);
    SingleUseTransaction transaction = createSubject();
    get(transaction.executeQueryAsync(CallType.SYNC, query, AnalyzeMode.NONE));
    try {
      transaction.getCommitResponse();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
    assertNull(transaction.getCommitResponseOrNull());
  }

  @Test
  public void testGetCommitResponseAfterDdl() {
    ParsedStatement ddl = createParsedDdl(VALID_DDL);
    SingleUseTransaction transaction = createSubject();
    get(transaction.executeDdlAsync(CallType.SYNC, ddl));
    try {
      transaction.getCommitResponse();
      fail("missing expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
    assertNull(transaction.getCommitResponseOrNull());
  }
}
