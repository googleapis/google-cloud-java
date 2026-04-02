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
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ProtobufResultSet;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import io.grpc.Metadata;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.opentelemetry.api.trace.Span;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadWriteTransactionTest {

  private enum CommitBehavior {
    SUCCEED,
    FAIL,
    ABORT
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
          throw SpannerExceptionFactory.newSpannerException(
              ErrorCode.ABORTED, "commit aborted", createAbortedExceptionWithMinimalRetry());
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
      return commitResponse == null ? null : commitResponse.getCommitTimestamp();
    }

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

  private ReadWriteTransaction createSubject() {
    return createSubject(CommitBehavior.SUCCEED, false);
  }

  private ReadWriteTransaction createSubject(CommitBehavior commitBehavior) {
    return createSubject(commitBehavior, false);
  }

  private ReadWriteTransaction createSubject(
      final CommitBehavior commitBehavior, boolean withRetry) {
    DatabaseClient client = mock(DatabaseClient.class);
    when(client.transactionManager())
        .thenAnswer(
            invocation -> {
              TransactionContext txContext = mock(TransactionContext.class);
              when(txContext.executeQuery(any(Statement.class))).thenReturn(mock(ResultSet.class));
              ResultSet rsWithStats = mock(ResultSet.class);
              when(rsWithStats.getStats()).thenReturn(ResultSetStats.getDefaultInstance());
              when(txContext.analyzeQuery(any(Statement.class), any(QueryAnalyzeMode.class)))
                  .thenReturn(rsWithStats);
              when(txContext.executeUpdate(any(Statement.class))).thenReturn(1L);
              return new SimpleTransactionManager(txContext, commitBehavior);
            });
    return ReadWriteTransaction.newBuilder()
        .setDatabaseClient(client)
        .setRetryAbortsInternally(withRetry)
        .setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED)
        .setSavepointSupport(SavepointSupport.FAIL_AFTER_ROLLBACK)
        .setTransactionRetryListeners(Collections.emptyList())
        .withStatementExecutor(new StatementExecutor())
        .setSpan(Span.getInvalid())
        .build();
  }

  @Test
  public void testExecuteDdl() {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);

    ReadWriteTransaction transaction = createSubject();
    try {
      transaction.executeDdlAsync(CallType.SYNC, statement);
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testRunBatch() {
    ReadWriteTransaction subject = createSubject();
    try {
      subject.runBatchAsync(CallType.SYNC);
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testAbortBatch() {
    ReadWriteTransaction subject = createSubject();
    try {
      subject.abortBatch();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testExecuteQuery() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    ResultSet rs =
        get(transaction.executeQueryAsync(CallType.SYNC, parsedStatement, AnalyzeMode.NONE));
    assertThat(rs, is(notNullValue()));
    assertThat(rs.getStats(), is(nullValue()));
  }

  @Test
  public void testPlanQuery() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    ResultSet rs =
        get(transaction.executeQueryAsync(CallType.SYNC, parsedStatement, AnalyzeMode.PLAN));
    assertThat(rs, is(notNullValue()));
    while (rs.next()) {
      // do nothing
    }
    assertThat(rs.getStats(), is(notNullValue()));
  }

  @Test
  public void testProfileQuery() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    ResultSet rs =
        get(transaction.executeQueryAsync(CallType.SYNC, parsedStatement, AnalyzeMode.PROFILE));
    assertThat(rs, is(notNullValue()));
    while (rs.next()) {
      // do nothing
    }
    assertThat(rs.getStats(), is(notNullValue()));
  }

  @Test
  public void testExecuteUpdate() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.UPDATE);
    when(parsedStatement.isUpdate()).thenReturn(true);
    Statement statement = Statement.of("UPDATE FOO SET BAR=1 WHERE ID=2");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    assertThat(get(transaction.executeUpdateAsync(CallType.SYNC, parsedStatement)), is(1L));
  }

  @Test
  public void testExecuteQueryWithDmlReturningWithoutRetry() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.UPDATE);
    when(parsedStatement.isUpdate()).thenReturn(true);
    when(parsedStatement.hasReturningClause()).thenReturn(true);
    Statement statement = Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'x') THEN RETURN *");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject(/* commitBehavior= */ CommitBehavior.SUCCEED);
    ResultSet rs =
        get(transaction.executeQueryAsync(CallType.SYNC, parsedStatement, AnalyzeMode.NONE));
    assertThat(rs, is(notNullValue()));
  }

  @Test
  public void testGetCommitTimestampBeforeCommit() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.UPDATE);
    when(parsedStatement.isUpdate()).thenReturn(true);
    Statement statement = Statement.of("UPDATE FOO SET BAR=1 WHERE ID=2");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    assertThat(get(transaction.executeUpdateAsync(CallType.SYNC, parsedStatement)), is(1L));
    try {
      transaction.getCommitTimestamp();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testGetCommitTimestampAfterCommit() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.UPDATE);
    when(parsedStatement.isUpdate()).thenReturn(true);
    Statement statement = Statement.of("UPDATE FOO SET BAR=1 WHERE ID=2");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    assertThat(get(transaction.executeUpdateAsync(CallType.SYNC, parsedStatement)), is(1L));
    get(transaction.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));

    assertThat(transaction.getCommitTimestamp(), is(notNullValue()));
  }

  @Test
  public void testGetReadTimestamp() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    assertThat(
        get(transaction.executeQueryAsync(CallType.SYNC, parsedStatement, AnalyzeMode.NONE)),
        is(notNullValue()));
    try {
      transaction.getReadTimestamp();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testState() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.QUERY);
    when(parsedStatement.isQuery()).thenReturn(true);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    assertThat(
        get(transaction.executeQueryAsync(CallType.SYNC, parsedStatement, AnalyzeMode.NONE)),
        is(notNullValue()));
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));

    get(transaction.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMITTED)));
    assertThat(transaction.isActive(), is(false));

    // start a new transaction
    transaction = createSubject();
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    get(transaction.rollbackAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.ROLLED_BACK)));
    assertThat(transaction.isActive(), is(false));

    // start a new transaction that will fail on commit
    transaction = createSubject(CommitBehavior.FAIL);
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    try {
      get(transaction.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));
    } catch (SpannerException e) {
      // ignore
    }
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMIT_FAILED)));
    assertThat(transaction.isActive(), is(false));

    // start a new transaction that will abort on commit
    transaction = createSubject(CommitBehavior.ABORT);
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    try {
      get(transaction.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));
    } catch (AbortedException e) {
      // ignore
    }
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMIT_FAILED)));
    assertThat(transaction.isActive(), is(false));

    // Start a new transaction that will abort on commit, but with internal retry enabled, so it
    // will in the end succeed.
    transaction = createSubject(CommitBehavior.ABORT, true);
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.STARTED)));
    assertThat(transaction.isActive(), is(true));
    get(transaction.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));
    assertThat(
        transaction.getState(),
        is(equalTo(com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState.COMMITTED)));
    assertThat(transaction.isActive(), is(false));
  }

  @Test
  public void testIsReadOnly() {
    assertThat(createSubject().isReadOnly(), is(false));
  }

  private enum RetryResults {
    SAME,
    DIFFERENT
  }

  @Test
  public void testRetry() {
    for (RetryResults results : RetryResults.values()) {
      String sql1 = "UPDATE FOO SET BAR=1 WHERE BAZ>=100 AND BAZ<200";
      String sql2 = "UPDATE FOO SET BAR=2 WHERE BAZ>=200 AND BAZ<300";
      DatabaseClient client = mock(DatabaseClient.class);
      ParsedStatement update1 = mock(ParsedStatement.class);
      when(update1.getType()).thenReturn(StatementType.UPDATE);
      when(update1.isUpdate()).thenReturn(true);
      when(update1.getStatement()).thenReturn(Statement.of(sql1));
      ParsedStatement update2 = mock(ParsedStatement.class);
      when(update2.getType()).thenReturn(StatementType.UPDATE);
      when(update2.isUpdate()).thenReturn(true);
      when(update2.getStatement()).thenReturn(Statement.of(sql2));

      TransactionManager txManager = mock(TransactionManager.class);
      TransactionContext txContext1 = mock(TransactionContext.class);
      when(txManager.begin()).thenReturn(txContext1);
      when(txManager.getState()).thenReturn(null, TransactionState.STARTED);
      when(client.transactionManager()).thenReturn(txManager);
      when(txContext1.executeUpdate(Statement.of(sql1))).thenReturn(90L);
      when(txContext1.executeUpdate(Statement.of(sql2))).thenReturn(80L);

      TransactionContext txContext2 = mock(TransactionContext.class);
      when(txManager.resetForRetry()).thenReturn(txContext2);
      when(client.transactionManager()).thenReturn(txManager);
      if (results == RetryResults.SAME) {
        when(txContext2.executeUpdate(Statement.of(sql1))).thenReturn(90L);
        when(txContext2.executeUpdate(Statement.of(sql2))).thenReturn(80L);
      } else if (results == RetryResults.DIFFERENT) {
        when(txContext2.executeUpdate(Statement.of(sql1))).thenReturn(90L);
        when(txContext2.executeUpdate(Statement.of(sql2))).thenReturn(90L);
      }

      // first abort, then do nothing
      doThrow(
              SpannerExceptionFactory.newSpannerException(
                  ErrorCode.ABORTED, "commit aborted", createAbortedExceptionWithMinimalRetry()))
          .doNothing()
          .when(txManager)
          .commit();

      ReadWriteTransaction subject =
          ReadWriteTransaction.newBuilder()
              .setRetryAbortsInternally(true)
              .setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED)
              .setSavepointSupport(SavepointSupport.FAIL_AFTER_ROLLBACK)
              .setTransactionRetryListeners(Collections.emptyList())
              .setDatabaseClient(client)
              .withStatementExecutor(new StatementExecutor())
              .setSpan(Span.getInvalid())
              .build();
      subject.executeUpdateAsync(CallType.SYNC, update1);
      subject.executeUpdateAsync(CallType.SYNC, update2);
      boolean expectedException = false;
      try {
        get(subject.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));
      } catch (SpannerException e) {
        if (results == RetryResults.DIFFERENT && e.getErrorCode() == ErrorCode.ABORTED) {
          // expected
          expectedException = true;
        } else {
          throw e;
        }
      }
      assertThat(expectedException, is(results == RetryResults.DIFFERENT));
    }
  }

  @Test
  public void testChecksumResultSet() {
    DatabaseClient client = mock(DatabaseClient.class);
    ReadWriteTransaction transaction =
        ReadWriteTransaction.newBuilder()
            .setRetryAbortsInternally(true)
            .setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED)
            .setSavepointSupport(SavepointSupport.FAIL_AFTER_ROLLBACK)
            .setTransactionRetryListeners(Collections.emptyList())
            .setDatabaseClient(client)
            .withStatementExecutor(new StatementExecutor())
            .setSpan(Span.getInvalid())
            .build();
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);

    String arrayJson =
        "[{\"color\":\"red\",\"value\":\"#f00\"},{\"color\":\"green\",\"value\":\"#0f0\"},{\"color\":\"blue\",\"value\":\"#00f\"},{\"color\":\"cyan\",\"value\":\"#0ff\"},{\"color\":\"magenta\",\"value\":\"#f0f\"},{\"color\":\"yellow\",\"value\":\"#ff0\"},{\"color\":\"black\",\"value\":\"#000\"}]";
    String emptyArrayJson = "[]";
    String simpleJson = "{\"color\":\"red\",\"value\":\"#f00\"}";
    SingerInfo protoMessageVal =
        SingerInfo.newBuilder()
            .setSingerId(111)
            .setNationality("COUNTRY1")
            .setGenre(Genre.FOLK)
            .build();
    ProtocolMessageEnum protoEnumVal = Genre.ROCK;
    ProtobufResultSet delegate1 =
        (ProtobufResultSet)
            ResultSets.forRows(
                Type.struct(
                    StructField.of("ID", Type.int64()),
                    StructField.of("NAME", Type.string()),
                    StructField.of("AMOUNT", Type.numeric()),
                    StructField.of("JSON", Type.json()),
                    StructField.of(
                        "PROTO", Type.proto(protoMessageVal.getDescriptorForType().getFullName())),
                    StructField.of(
                        "PROTOENUM",
                        Type.protoEnum(protoEnumVal.getDescriptorForType().getFullName()))),
                Arrays.asList(
                    Struct.newBuilder()
                        .set("ID")
                        .to(1L)
                        .set("NAME")
                        .to("TEST 1")
                        .set("AMOUNT")
                        .to(BigDecimal.valueOf(550, 2))
                        .set("JSON")
                        .to(Value.json(simpleJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(protoEnumVal)
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(2L)
                        .set("NAME")
                        .to("TEST 2")
                        .set("AMOUNT")
                        .to(BigDecimal.valueOf(750, 2))
                        .set("JSON")
                        .to(Value.json(arrayJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(Genre.JAZZ)
                        .build()));
    ChecksumResultSet rs1 =
        transaction.createChecksumResultSet(delegate1, parsedStatement, AnalyzeMode.NONE);
    ProtobufResultSet delegate2 =
        (ProtobufResultSet)
            ResultSets.forRows(
                Type.struct(
                    StructField.of("ID", Type.int64()),
                    StructField.of("NAME", Type.string()),
                    StructField.of("AMOUNT", Type.numeric()),
                    StructField.of("JSON", Type.json()),
                    StructField.of(
                        "PROTO", Type.proto(protoMessageVal.getDescriptorForType().getFullName())),
                    StructField.of(
                        "PROTOENUM",
                        Type.protoEnum(protoEnumVal.getDescriptorForType().getFullName()))),
                Arrays.asList(
                    Struct.newBuilder()
                        .set("ID")
                        .to(1L)
                        .set("NAME")
                        .to("TEST 1")
                        .set("AMOUNT")
                        .to(new BigDecimal("5.50"))
                        .set("JSON")
                        .to(Value.json(simpleJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(protoEnumVal)
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(2L)
                        .set("NAME")
                        .to("TEST 2")
                        .set("AMOUNT")
                        .to(new BigDecimal("7.50"))
                        .set("JSON")
                        .to(Value.json(arrayJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(Genre.JAZZ)
                        .build()));
    ChecksumResultSet rs2 =
        transaction.createChecksumResultSet(delegate2, parsedStatement, AnalyzeMode.NONE);
    // rs1 and rs2 are equal, rs3 contains the same rows, but in a different order
    ProtobufResultSet delegate3 =
        (ProtobufResultSet)
            ResultSets.forRows(
                Type.struct(
                    StructField.of("ID", Type.int64()),
                    StructField.of("NAME", Type.string()),
                    StructField.of("AMOUNT", Type.numeric()),
                    StructField.of("JSON", Type.json()),
                    StructField.of(
                        "PROTO", Type.proto(protoMessageVal.getDescriptorForType().getFullName())),
                    StructField.of(
                        "PROTOENUM",
                        Type.protoEnum(protoEnumVal.getDescriptorForType().getFullName()))),
                Arrays.asList(
                    Struct.newBuilder()
                        .set("ID")
                        .to(2L)
                        .set("NAME")
                        .to("TEST 2")
                        .set("AMOUNT")
                        .to(new BigDecimal("7.50"))
                        .set("JSON")
                        .to(Value.json(arrayJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(Genre.JAZZ)
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(1L)
                        .set("NAME")
                        .to("TEST 1")
                        .set("AMOUNT")
                        .to(new BigDecimal("5.50"))
                        .set("JSON")
                        .to(Value.json(simpleJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(protoEnumVal)
                        .build()));
    ChecksumResultSet rs3 =
        transaction.createChecksumResultSet(delegate3, parsedStatement, AnalyzeMode.NONE);

    // rs4 contains the same rows as rs1 and rs2, but also an additional row
    ProtobufResultSet delegate4 =
        (ProtobufResultSet)
            ResultSets.forRows(
                Type.struct(
                    StructField.of("ID", Type.int64()),
                    StructField.of("NAME", Type.string()),
                    StructField.of("AMOUNT", Type.numeric()),
                    StructField.of("JSON", Type.json()),
                    StructField.of(
                        "PROTO", Type.proto(protoMessageVal.getDescriptorForType().getFullName())),
                    StructField.of(
                        "PROTOENUM",
                        Type.protoEnum(protoEnumVal.getDescriptorForType().getFullName()))),
                Arrays.asList(
                    Struct.newBuilder()
                        .set("ID")
                        .to(1L)
                        .set("NAME")
                        .to("TEST 1")
                        .set("AMOUNT")
                        .to(new BigDecimal("5.50"))
                        .set("JSON")
                        .to(Value.json(simpleJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(protoEnumVal)
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(2L)
                        .set("NAME")
                        .to("TEST 2")
                        .set("AMOUNT")
                        .to(new BigDecimal("7.50"))
                        .set("JSON")
                        .to(Value.json(arrayJson))
                        .set("PROTO")
                        .to(protoMessageVal)
                        .set("PROTOENUM")
                        .to(Genre.JAZZ)
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(3L)
                        .set("NAME")
                        .to("TEST 3")
                        .set("AMOUNT")
                        .to(new BigDecimal("9.99"))
                        .set("JSON")
                        .to(Value.json(emptyArrayJson))
                        .set("PROTO")
                        .to(null, SingerInfo.getDescriptor())
                        .set("PROTOENUM")
                        .to(Genre.POP)
                        .build()));
    ChecksumResultSet rs4 =
        transaction.createChecksumResultSet(delegate4, parsedStatement, AnalyzeMode.NONE);

    assertThat(rs1.getChecksum(), is(equalTo(rs2.getChecksum())));
    while (rs1.next() && rs2.next() && rs3.next() && rs4.next()) {
      assertThat(rs1.getChecksum(), is(equalTo(rs2.getChecksum())));
      assertThat(rs1.getChecksum(), is(not(equalTo(rs3.getChecksum()))));
      assertThat(rs1.getChecksum(), is(equalTo(rs4.getChecksum())));
    }
    assertThat(rs1.getChecksum(), is(equalTo(rs2.getChecksum())));
    assertThat(rs1.getChecksum(), is(not(equalTo(rs3.getChecksum()))));
    // rs4 contains one more row than rs1, but the last row of rs4 hasn't been consumed yet
    assertThat(rs1.getChecksum(), is(equalTo(rs4.getChecksum())));
    assertThat(rs4.next(), is(true));
    assertThat(rs1.getChecksum(), is(not(equalTo(rs4.getChecksum()))));
  }

  @Test
  public void testChecksumResultSetWithArray() {
    DatabaseClient client = mock(DatabaseClient.class);
    ReadWriteTransaction transaction =
        ReadWriteTransaction.newBuilder()
            .setRetryAbortsInternally(true)
            .setIsolationLevel(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED)
            .setSavepointSupport(SavepointSupport.FAIL_AFTER_ROLLBACK)
            .setTransactionRetryListeners(Collections.emptyList())
            .setDatabaseClient(client)
            .withStatementExecutor(new StatementExecutor())
            .setSpan(Span.getInvalid())
            .build();
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    Statement statement = Statement.of("SELECT * FROM FOO");
    when(parsedStatement.getStatement()).thenReturn(statement);
    ProtobufResultSet delegate1 =
        (ProtobufResultSet)
            ResultSets.forRows(
                Type.struct(
                    StructField.of("ID", Type.int64()),
                    StructField.of("PRICES", Type.array(Type.int64()))),
                Arrays.asList(
                    Struct.newBuilder()
                        .set("ID")
                        .to(1L)
                        .set("PRICES")
                        .toInt64Array(new long[] {1L, 2L})
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(2L)
                        .set("PRICES")
                        .toInt64Array(new long[] {3L, 4L})
                        .build()));
    ChecksumResultSet rs1 =
        transaction.createChecksumResultSet(delegate1, parsedStatement, AnalyzeMode.NONE);
    ProtobufResultSet delegate2 =
        (ProtobufResultSet)
            ResultSets.forRows(
                Type.struct(
                    StructField.of("ID", Type.int64()),
                    StructField.of("PRICES", Type.array(Type.int64()))),
                Arrays.asList(
                    Struct.newBuilder()
                        .set("ID")
                        .to(1L)
                        .set("PRICES")
                        .toInt64Array(new long[] {1L, 2L})
                        .build(),
                    Struct.newBuilder()
                        .set("ID")
                        .to(2L)
                        .set("PRICES")
                        .toInt64Array(new long[] {3L, 5L})
                        .build()));
    ChecksumResultSet rs2 =
        transaction.createChecksumResultSet(delegate2, parsedStatement, AnalyzeMode.NONE);

    rs1.next();
    rs2.next();
    assertThat(rs1.getChecksum(), is(equalTo(rs2.getChecksum())));
    rs1.next();
    rs2.next();
    assertThat(rs1.getChecksum(), is(not(equalTo(rs2.getChecksum()))));
  }

  @Test
  public void testGetCommitResponseBeforeCommit() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.UPDATE);
    when(parsedStatement.isUpdate()).thenReturn(true);
    Statement statement = Statement.of("UPDATE FOO SET BAR=1 WHERE ID=2");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    get(transaction.executeUpdateAsync(CallType.SYNC, parsedStatement));
    try {
      transaction.getCommitResponse();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
    assertNull(transaction.getCommitResponseOrNull());
  }

  @Test
  public void testGetCommitResponseAfterCommit() {
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.getType()).thenReturn(StatementType.UPDATE);
    when(parsedStatement.isUpdate()).thenReturn(true);
    Statement statement = Statement.of("UPDATE FOO SET BAR=1 WHERE ID=2");
    when(parsedStatement.getStatement()).thenReturn(statement);

    ReadWriteTransaction transaction = createSubject();
    get(transaction.executeUpdateAsync(CallType.SYNC, parsedStatement));
    get(transaction.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE));

    assertNotNull(transaction.getCommitResponse());
    assertNotNull(transaction.getCommitResponseOrNull());
  }

  private static StatusRuntimeException createAbortedExceptionWithMinimalRetry() {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setNanos(1).setSeconds(0L))
            .build();
    trailers.put(key, retryInfo);
    return io.grpc.Status.ABORTED.asRuntimeException(trailers);
  }
}
