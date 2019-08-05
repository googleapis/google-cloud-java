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
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseClient;
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
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.v1.ResultSetStats;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
  private static final long VALID_UPDATE_COUNT = 99L;

  @Rule public ExpectedException exception = ExpectedException.none();

  private final StatementExecutor executor = new StatementExecutor();

  private enum CommitBehavior {
    SUCCEED,
    FAIL,
    ABORT;
  }

  private static class SimpleTransactionManager implements TransactionManager {
    private TransactionState state;
    private Timestamp commitTimestamp;
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
    public void commit() {
      switch (commitBehavior) {
        case SUCCEED:
          commitTimestamp = Timestamp.now();
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
      return commitTimestamp;
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
  }

  private DdlClient createDefaultMockDdlClient() {
    try {
      DdlClient ddlClient = mock(DdlClient.class);
      @SuppressWarnings("unchecked")
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> operation =
          mock(OperationFuture.class);
      when(operation.get()).thenReturn(null);
      when(ddlClient.executeDdl(anyString())).thenCallRealMethod();
      when(ddlClient.executeDdl(anyListOf(String.class))).thenReturn(operation);
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
        0L);
  }

  private SingleUseTransaction createSubjectWithTimeout(long timeout) {
    return createSubject(
        createDefaultMockDdlClient(),
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        timeout);
  }

  private SingleUseTransaction createSubject(AutocommitDmlMode dmlMode) {
    return createSubject(
        createDefaultMockDdlClient(),
        false,
        TimestampBound.strong(),
        dmlMode,
        CommitBehavior.SUCCEED,
        0L);
  }

  private SingleUseTransaction createSubject(CommitBehavior commitBehavior) {
    return createSubject(
        createDefaultMockDdlClient(),
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        commitBehavior,
        0L);
  }

  private SingleUseTransaction createDdlSubject(DdlClient ddlClient) {
    return createSubject(
        ddlClient,
        false,
        TimestampBound.strong(),
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        0L);
  }

  private SingleUseTransaction createReadOnlySubject(TimestampBound staleness) {
    return createSubject(
        createDefaultMockDdlClient(),
        true,
        staleness,
        AutocommitDmlMode.TRANSACTIONAL,
        CommitBehavior.SUCCEED,
        0L);
  }

  private SingleUseTransaction createSubject(
      DdlClient ddlClient,
      boolean readOnly,
      TimestampBound staleness,
      AutocommitDmlMode dmlMode,
      final CommitBehavior commitBehavior,
      long timeout) {
    DatabaseClient dbClient = mock(DatabaseClient.class);
    com.google.cloud.spanner.ReadOnlyTransaction singleUse =
        new SimpleReadOnlyTransaction(staleness);
    when(dbClient.singleUseReadOnlyTransaction(staleness)).thenReturn(singleUse);

    TransactionContext txContext = mock(TransactionContext.class);
    when(txContext.executeUpdate(Statement.of(VALID_UPDATE))).thenReturn(VALID_UPDATE_COUNT);
    when(txContext.executeUpdate(Statement.of(SLOW_UPDATE)))
        .thenAnswer(
            new Answer<Long>() {
              @Override
              public Long answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(10L);
                return VALID_UPDATE_COUNT;
              }
            });
    when(txContext.executeUpdate(Statement.of(INVALID_UPDATE)))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "invalid update"));
    SimpleTransactionManager txManager = new SimpleTransactionManager(txContext, commitBehavior);
    when(dbClient.transactionManager()).thenReturn(txManager);

    when(dbClient.executePartitionedUpdate(Statement.of(VALID_UPDATE)))
        .thenReturn(VALID_UPDATE_COUNT);
    when(dbClient.executePartitionedUpdate(Statement.of(INVALID_UPDATE)))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "invalid update"));

    when(dbClient.readWriteTransaction())
        .thenAnswer(
            new Answer<TransactionRunner>() {
              @Override
              public TransactionRunner answer(InvocationOnMock invocation) throws Throwable {
                TransactionRunner runner =
                    new TransactionRunner() {
                      private Timestamp commitTimestamp;

                      @SuppressWarnings("unchecked")
                      @Override
                      public <T> T run(TransactionCallable<T> callable) {
                        if (commitBehavior == CommitBehavior.SUCCEED) {
                          this.commitTimestamp = Timestamp.now();
                          return (T) Long.valueOf(1L);
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
                        if (commitTimestamp == null) {
                          throw new IllegalStateException("no commit timestamp");
                        }
                        return commitTimestamp;
                      }

                      @Override
                      public TransactionRunner allowNestedTransaction() {
                        return this;
                      }
                    };
                return runner;
              }
            });

    return SingleUseTransaction.newBuilder()
        .setDatabaseClient(dbClient)
        .setDdlClient(ddlClient)
        .setAutocommitDmlMode(dmlMode)
        .setReadOnly(readOnly)
        .setReadOnlyStaleness(staleness)
        .setStatementTimeout(
            timeout == 0L
                ? StatementExecutor.StatementTimeout.nullTimeout()
                : StatementExecutor.StatementTimeout.of(timeout, TimeUnit.MILLISECONDS))
        .withStatementExecutor(executor)
        .build();
  }

  private ParsedStatement createParsedDdl(String sql) {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of(sql));
    when(statement.getSqlWithoutComments()).thenReturn(sql);
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
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.commit();
  }

  @Test
  public void testRollback() {
    SingleUseTransaction subject = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.rollback();
  }

  @Test
  public void testRunBatch() {
    SingleUseTransaction subject = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.runBatch();
  }

  @Test
  public void testAbortBatch() {
    SingleUseTransaction subject = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.abortBatch();
  }

  @Test
  public void testExecuteDdl() {
    String sql = "CREATE TABLE FOO";
    ParsedStatement ddl = createParsedDdl(sql);
    DdlClient ddlClient = createDefaultMockDdlClient();
    SingleUseTransaction subject = createDdlSubject(ddlClient);
    subject.executeDdl(ddl);
    verify(ddlClient).executeDdl(sql);
  }

  @Test
  public void testExecuteQuery() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      for (AnalyzeMode analyzeMode : AnalyzeMode.values()) {
        SingleUseTransaction subject = createReadOnlySubject(staleness);
        ResultSet rs = subject.executeQuery(createParsedQuery(VALID_QUERY), analyzeMode);
        assertThat(rs, is(notNullValue()));
        assertThat(subject.getReadTimestamp(), is(notNullValue()));
        assertThat(
            subject.getState(),
            is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED));
        while (rs.next()) {
          // just loop to the end to get stats
        }
        if (analyzeMode == AnalyzeMode.NONE) {
          assertThat(rs.getStats(), is(nullValue()));
        } else {
          assertThat(rs.getStats(), is(notNullValue()));
        }
      }
    }
    for (TimestampBound staleness : getTestTimestampBounds()) {
      SingleUseTransaction subject = createReadOnlySubject(staleness);
      boolean expectedException = false;
      try {
        subject.executeQuery(createParsedQuery(INVALID_QUERY), AnalyzeMode.NONE);
      } catch (SpannerException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      assertThat(
          subject.getState(),
          is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMIT_FAILED));
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

    SingleUseTransaction transaction =
        SingleUseTransaction.newBuilder()
            .setDatabaseClient(client)
            .setDdlClient(mock(DdlClient.class))
            .setAutocommitDmlMode(AutocommitDmlMode.TRANSACTIONAL)
            .withStatementExecutor(executor)
            .setReadOnlyStaleness(TimestampBound.strong())
            .build();
    assertThat(
        transaction.executeQuery(parsedStatement, AnalyzeMode.NONE, option), is(notNullValue()));
  }

  @Test
  public void testExecuteUpdate_Transactional_Valid() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject();
    long updateCount = subject.executeUpdate(update);
    assertThat(updateCount, is(equalTo(VALID_UPDATE_COUNT)));
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    assertThat(
        subject.getState(), is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED));
  }

  @Test
  public void testExecuteUpdate_Transactional_Invalid() {
    ParsedStatement update = createParsedUpdate(INVALID_UPDATE);
    SingleUseTransaction subject = createSubject();
    exception.expect(
        SpannerExceptionMatcher.matchCodeAndMessage(ErrorCode.UNKNOWN, "invalid update"));
    subject.executeUpdate(update);
  }

  @Test
  public void testExecuteUpdate_Transactional_Valid_FailedCommit() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject(CommitBehavior.FAIL);
    exception.expect(
        SpannerExceptionMatcher.matchCodeAndMessage(ErrorCode.UNKNOWN, "commit failed"));
    subject.executeUpdate(update);
  }

  @Test
  public void testExecuteUpdate_Transactional_Valid_AbortedCommit() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject(CommitBehavior.ABORT);
    // even though the transaction aborts at first, it will be retried and eventually succeed
    long updateCount = subject.executeUpdate(update);
    assertThat(updateCount, is(equalTo(VALID_UPDATE_COUNT)));
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    assertThat(
        subject.getState(), is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED));
  }

  @Test
  public void testExecuteUpdate_Partitioned_Valid() {
    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    SingleUseTransaction subject = createSubject(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
    long updateCount = subject.executeUpdate(update);
    assertThat(updateCount, is(equalTo(VALID_UPDATE_COUNT)));
    assertThat(
        subject.getState(), is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED));
  }

  @Test
  public void testExecuteUpdate_Partitioned_Invalid() {
    ParsedStatement update = createParsedUpdate(INVALID_UPDATE);
    SingleUseTransaction subject = createSubject(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
    exception.expect(
        SpannerExceptionMatcher.matchCodeAndMessage(ErrorCode.UNKNOWN, "invalid update"));
    subject.executeUpdate(update);
  }

  @Test
  public void testWrite() {
    SingleUseTransaction subject = createSubject();
    subject.write(Mutation.newInsertBuilder("FOO").build());
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    assertThat(
        subject.getState(), is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED));
  }

  @Test
  public void testWriteFail() {
    SingleUseTransaction subject = createSubject(CommitBehavior.FAIL);
    exception.expect(
        SpannerExceptionMatcher.matchCodeAndMessage(ErrorCode.UNKNOWN, "commit failed"));
    subject.write(Mutation.newInsertBuilder("FOO").build());
  }

  @Test
  public void testWriteIterable() {
    SingleUseTransaction subject = createSubject();
    Mutation mutation = Mutation.newInsertBuilder("FOO").build();
    subject.write(Arrays.asList(mutation, mutation));
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    assertThat(
        subject.getState(), is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMITTED));
  }

  @Test
  public void testWriteIterableFail() {
    SingleUseTransaction subject = createSubject(CommitBehavior.FAIL);
    Mutation mutation = Mutation.newInsertBuilder("FOO").build();
    exception.expect(
        SpannerExceptionMatcher.matchCodeAndMessage(ErrorCode.UNKNOWN, "commit failed"));
    subject.write(Arrays.asList(mutation, mutation));
  }

  @Test
  public void testMultiUse() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      SingleUseTransaction subject = createReadOnlySubject(staleness);
      ResultSet rs = subject.executeQuery(createParsedQuery(VALID_QUERY), AnalyzeMode.NONE);
      assertThat(rs, is(notNullValue()));
      assertThat(subject.getReadTimestamp(), is(notNullValue()));
      boolean expectedException = false;
      try {
        subject.executeQuery(createParsedQuery(VALID_QUERY), AnalyzeMode.NONE);
      } catch (IllegalStateException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
    }

    String sql = "CREATE TABLE FOO";
    ParsedStatement ddl = createParsedDdl(sql);
    DdlClient ddlClient = createDefaultMockDdlClient();
    SingleUseTransaction subject = createDdlSubject(ddlClient);
    subject.executeDdl(ddl);
    verify(ddlClient).executeDdl(sql);
    boolean expectedException = false;
    try {
      subject.executeDdl(ddl);
    } catch (IllegalStateException e) {
      expectedException = true;
    }
    assertThat(expectedException, is(true));

    ParsedStatement update = createParsedUpdate(VALID_UPDATE);
    subject = createSubject();
    long updateCount = subject.executeUpdate(update);
    assertThat(updateCount, is(equalTo(VALID_UPDATE_COUNT)));
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    expectedException = false;
    try {
      subject.executeUpdate(update);
    } catch (IllegalStateException e) {
      expectedException = true;
    }
    assertThat(expectedException, is(true));

    subject = createSubject();
    subject.write(Mutation.newInsertBuilder("FOO").build());
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    expectedException = false;
    try {
      subject.write(Mutation.newInsertBuilder("FOO").build());
    } catch (IllegalStateException e) {
      expectedException = true;
    }
    assertThat(expectedException, is(true));

    subject = createSubject();
    Mutation mutation = Mutation.newInsertBuilder("FOO").build();
    subject.write(Arrays.asList(mutation, mutation));
    assertThat(subject.getCommitTimestamp(), is(notNullValue()));
    expectedException = false;
    try {
      subject.write(Arrays.asList(mutation, mutation));
    } catch (IllegalStateException e) {
      expectedException = true;
    }
    assertThat(expectedException, is(true));
  }

  @Test
  public void testExecuteQueryWithTimeout() {
    SingleUseTransaction subject = createSubjectWithTimeout(1L);
    try {
      subject.executeQuery(createParsedQuery(SLOW_QUERY), AnalyzeMode.NONE);
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED) {
        throw e;
      }
    }
    assertThat(
        subject.getState(),
        is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMIT_FAILED));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.getReadTimestamp();
  }

  @Test
  public void testExecuteUpdateWithTimeout() {
    SingleUseTransaction subject = createSubjectWithTimeout(1L);
    boolean timeoutException = false;
    try {
      subject.executeUpdate(createParsedUpdate(SLOW_UPDATE));
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED) {
        throw e;
      }
      timeoutException = true;
    }
    assertThat(timeoutException, is(true));
    assertThat(
        subject.getState(),
        is(com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState.COMMIT_FAILED));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.getCommitTimestamp();
  }
}
