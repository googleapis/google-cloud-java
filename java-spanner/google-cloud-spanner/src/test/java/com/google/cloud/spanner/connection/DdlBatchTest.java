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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState;
import com.google.common.io.ByteStreams;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.grpc.Status;
import io.opentelemetry.api.trace.Span;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatcher;

@RunWith(JUnit4.class)
public class DdlBatchTest {

  private DdlClient createDefaultMockDdlClient() {
    return createDefaultMockDdlClient(false, 0L);
  }

  private DdlClient createDefaultMockDdlClient(boolean exceptionOnGetResult) {
    return createDefaultMockDdlClient(exceptionOnGetResult, 0L);
  }

  private DdlClient createDefaultMockDdlClient(long waitForMillis) {
    return createDefaultMockDdlClient(false, waitForMillis);
  }

  private DdlClient createDefaultMockDdlClient(
      boolean exceptionOnGetResult, final long waitForMillis) {
    try {
      DdlClient ddlClient = mock(DdlClient.class);
      @SuppressWarnings("unchecked")
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> operation =
          mock(OperationFuture.class);
      if (waitForMillis > 0L) {
        when(operation.get())
            .thenAnswer(
                invocation -> {
                  Thread.sleep(waitForMillis);
                  return null;
                });
      } else if (exceptionOnGetResult) {
        when(operation.get())
            .thenThrow(
                SpannerExceptionFactory.newSpannerException(
                    ErrorCode.UNKNOWN, "ddl statement failed"));
      } else {
        when(operation.get()).thenReturn(null);
      }
      UpdateDatabaseDdlMetadata.Builder metadataBuilder = UpdateDatabaseDdlMetadata.newBuilder();
      if (!exceptionOnGetResult) {
        metadataBuilder.addCommitTimestamps(
            Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L));
      }
      ApiFuture<UpdateDatabaseDdlMetadata> metadataFuture =
          ApiFutures.immediateFuture(metadataBuilder.build());
      when(operation.getMetadata()).thenReturn(metadataFuture);
      when(ddlClient.executeDdl(anyString(), any())).thenReturn(operation);
      when(ddlClient.executeDdl(anyList(), any())).thenReturn(operation);
      doCallRealMethod()
          .when(ddlClient)
          .runWithRetryForMissingDefaultSequenceKind(any(), any(), any(), any());
      return ddlClient;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private DdlBatch createSubject() {
    return createSubject(createDefaultMockDdlClient());
  }

  private DdlBatch createSubject(DdlClient ddlClient) {
    return createSubject(ddlClient, mock(DatabaseClient.class));
  }

  private DdlBatch createSubject(DdlClient ddlClient, DatabaseClient dbClient) {
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    return DdlBatch.newBuilder()
        .setDdlClient(ddlClient)
        .setDatabaseClient(dbClient)
        .withStatementExecutor(new StatementExecutor())
        .setSpan(Span.getInvalid())
        .setConnectionState(new ConnectionState(new HashMap<>()))
        .build();
  }

  @Test
  public void testExecuteQuery() {
    DdlBatch batch = createSubject();
    try {
      batch.executeQueryAsync(CallType.SYNC, mock(ParsedStatement.class), AnalyzeMode.NONE);
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testExecuteCreateDatabase() {
    DdlBatch batch = createSubject();
    assertThrows(
        IllegalArgumentException.class,
        () ->
            batch.executeDdlAsync(
                CallType.SYNC,
                AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
                    .parse(Statement.of("CREATE DATABASE foo"))));
  }

  @Test
  public void testExecuteUpdate() {
    DdlBatch batch = createSubject();
    try {
      batch.executeUpdateAsync(CallType.SYNC, mock(ParsedStatement.class));
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testExecuteBatchUpdate() {
    DdlBatch batch = createSubject();
    try {
      batch.executeBatchUpdateAsync(
          CallType.SYNC, Collections.singleton(mock(ParsedStatement.class)));
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testGetCommitTimestamp() {
    DdlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    try {
      batch.getCommitTimestamp();
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testGetCommitResponse() {
    DdlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    try {
      batch.getCommitResponse();
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
    assertNull(batch.getCommitResponseOrNull());
  }

  @Test
  public void testGetReadTimestamp() {
    DdlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    try {
      batch.getReadTimestamp();
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testWriteIterable() {
    DdlBatch batch = createSubject();
    try {
      batch.writeAsync(
          CallType.SYNC, Collections.singletonList(Mutation.newInsertBuilder("foo").build()));
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testIsReadOnly() {
    DdlBatch batch = createSubject();
    assertThat(batch.isReadOnly(), is(false));
  }

  @Test
  public void testGetStateAndIsActive() {
    DdlBatch batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    get(batch.runBatchAsync(CallType.SYNC));
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    assertThat(batch.isActive(), is(false));

    batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    batch.abortBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.ABORTED));
    assertThat(batch.isActive(), is(false));

    DdlClient client = mock(DdlClient.class);
    SpannerException exception =
        SpannerExceptionFactory.newSpannerException(ErrorCode.FAILED_PRECONDITION, "test");
    doThrow(exception).when(client).executeDdl(anyList(), isNull());
    doCallRealMethod()
        .when(client)
        .runWithRetryForMissingDefaultSequenceKind(any(), any(), any(), any());
    batch = createSubject(client);
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSql()).thenReturn("CREATE TABLE FOO");
    when(statement.getType()).thenReturn(StatementType.DDL);
    batch.executeDdlAsync(CallType.SYNC, statement);
    try {
      get(batch.runBatchAsync(CallType.SYNC));
      fail("Missing expected exception");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode(), is(equalTo(ErrorCode.FAILED_PRECONDITION)));
    }
    assertThat(batch.getState(), is(UnitOfWorkState.RUN_FAILED));
    assertThat(batch.isActive(), is(false));
  }

  private static IsListOfStringsWithSize isEmptyListOfStrings() {
    return new IsListOfStringsWithSize(0);
  }

  private static IsListOfStringsWithSize isListOfStringsWithSize(int size) {
    return new IsListOfStringsWithSize(size);
  }

  private static class IsListOfStringsWithSize implements ArgumentMatcher<List<String>> {
    private final int size;

    private IsListOfStringsWithSize(int size) {
      this.size = size;
    }

    @Override
    public boolean matches(List<String> list) {
      return list.size() == size;
    }
  }

  @Test
  public void testRunBatch() {
    DdlClient client = createDefaultMockDdlClient();
    DdlBatch batch = createSubject(client);
    get(batch.runBatchAsync(CallType.SYNC));
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    verify(client, never()).executeDdl(anyString(), isNull());
    verify(client, never()).executeDdl(argThat(isEmptyListOfStrings()), isNull());

    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSql()).thenReturn("CREATE TABLE FOO");

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    get(batch.runBatchAsync(CallType.SYNC));
    verify(client).executeDdl(argThat(isListOfStringsWithSize(1)), isNull());

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.executeDdlAsync(CallType.SYNC, statement);
    get(batch.runBatchAsync(CallType.SYNC));
    verify(client).executeDdl(argThat(isListOfStringsWithSize(2)), isNull());
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    boolean exception = false;
    try {
      get(batch.runBatchAsync(CallType.SYNC));
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    exception = false;
    try {
      batch.executeDdlAsync(CallType.SYNC, statement);
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));
    exception = false;
    try {
      batch.executeDdlAsync(CallType.SYNC, statement);
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));

    client = createDefaultMockDdlClient(true);
    batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.executeDdlAsync(CallType.SYNC, statement);
    exception = false;
    try {
      get(batch.runBatchAsync(CallType.SYNC));
    } catch (SpannerException e) {
      exception = true;
    }
    assertThat(exception, is(true));
    assertThat(batch.getState(), is(UnitOfWorkState.RUN_FAILED));
    verify(client).executeDdl(argThat(isListOfStringsWithSize(2)), isNull());

    // verify when protoDescriptors is null
    client = createDefaultMockDdlClient();
    DatabaseClient dbClient = mock(DatabaseClient.class);
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    batch =
        DdlBatch.newBuilder()
            .setDdlClient(client)
            .setDatabaseClient(dbClient)
            .withStatementExecutor(new StatementExecutor())
            .setSpan(Span.getInvalid())
            .setProtoDescriptors(null)
            .setConnectionState(new ConnectionState(new HashMap<>()))
            .build();
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.executeDdlAsync(CallType.SYNC, statement);
    get(batch.runBatchAsync(CallType.SYNC));
    verify(client).executeDdl(argThat(isListOfStringsWithSize(2)), isNull());

    // verify when protoDescriptors is not null
    byte[] protoDescriptors;
    try {
      InputStream in =
          DdlBatchTest.class
              .getClassLoader()
              .getResourceAsStream("com/google/cloud/spanner/descriptors.pb");
      assertNotNull(in);
      protoDescriptors = ByteStreams.toByteArray(in);
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }
    client = createDefaultMockDdlClient();
    batch =
        DdlBatch.newBuilder()
            .setDdlClient(client)
            .setDatabaseClient(dbClient)
            .withStatementExecutor(new StatementExecutor())
            .setSpan(Span.getInvalid())
            .setProtoDescriptors(protoDescriptors)
            .setConnectionState(new ConnectionState(new HashMap<>()))
            .build();
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.executeDdlAsync(CallType.SYNC, statement);
    get(batch.runBatchAsync(CallType.SYNC));
    verify(client).executeDdl(argThat(isListOfStringsWithSize(2)), any(byte[].class));
  }

  @Test
  public void testUpdateCount() throws InterruptedException, ExecutionException {
    DdlClient client = mock(DdlClient.class);
    UpdateDatabaseDdlMetadata metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(
                Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L - 1L))
            .addCommitTimestamps(
                Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L))
            .addAllStatements(Arrays.asList("CREATE TABLE FOO", "CREATE TABLE BAR"))
            .build();
    ApiFuture<UpdateDatabaseDdlMetadata> metadataFuture = ApiFutures.immediateFuture(metadata);
    @SuppressWarnings("unchecked")
    OperationFuture<Void, UpdateDatabaseDdlMetadata> operationFuture = mock(OperationFuture.class);
    when(operationFuture.get()).thenReturn(null);
    when(operationFuture.getMetadata()).thenReturn(metadataFuture);
    when(client.executeDdl(argThat(isListOfStringsWithSize(2)), isNull()))
        .thenReturn(operationFuture);
    DatabaseClient dbClient = mock(DatabaseClient.class);
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    DdlBatch batch =
        DdlBatch.newBuilder()
            .withStatementExecutor(new StatementExecutor())
            .setDdlClient(client)
            .setDatabaseClient(dbClient)
            .setSpan(Span.getInvalid())
            .setConnectionState(new ConnectionState(new HashMap<>()))
            .build();
    batch.executeDdlAsync(
        CallType.SYNC,
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .parse(Statement.of("CREATE TABLE FOO")));
    batch.executeDdlAsync(
        CallType.SYNC,
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .parse(Statement.of("CREATE TABLE BAR")));
    long[] updateCounts = get(batch.runBatchAsync(CallType.SYNC));
    assertThat(updateCounts.length, is(equalTo(2)));
    assertThat(updateCounts[0], is(equalTo(1L)));
    assertThat(updateCounts[1], is(equalTo(1L)));
  }

  @Test
  public void testFailedUpdateCount() throws InterruptedException, ExecutionException {
    DdlClient client = mock(DdlClient.class);
    UpdateDatabaseDdlMetadata metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(
                Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L - 1L))
            .addAllStatements(Arrays.asList("CREATE TABLE FOO", "CREATE TABLE INVALID_TABLE"))
            .build();
    ApiFuture<UpdateDatabaseDdlMetadata> metadataFuture = ApiFutures.immediateFuture(metadata);
    @SuppressWarnings("unchecked")
    OperationFuture<Void, UpdateDatabaseDdlMetadata> operationFuture = mock(OperationFuture.class);
    when(operationFuture.get())
        .thenThrow(
            new ExecutionException(
                "ddl statement failed", Status.INVALID_ARGUMENT.asRuntimeException()));
    when(operationFuture.getMetadata()).thenReturn(metadataFuture);
    doCallRealMethod()
        .when(client)
        .runWithRetryForMissingDefaultSequenceKind(any(), any(), any(), any());
    when(client.executeDdl(argThat(isListOfStringsWithSize(2)), isNull()))
        .thenReturn(operationFuture);
    DatabaseClient dbClient = mock(DatabaseClient.class);
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    DdlBatch batch =
        DdlBatch.newBuilder()
            .withStatementExecutor(new StatementExecutor())
            .setDdlClient(client)
            .setDatabaseClient(dbClient)
            .setSpan(Span.getInvalid())
            .setConnectionState(new ConnectionState(new HashMap<>()))
            .build();
    batch.executeDdlAsync(
        CallType.SYNC,
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .parse(Statement.of("CREATE TABLE FOO")));
    batch.executeDdlAsync(
        CallType.SYNC,
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .parse(Statement.of("CREATE TABLE INVALID_TABLE")));
    try {
      get(batch.runBatchAsync(CallType.SYNC));
      fail("missing expected exception");
    } catch (SpannerBatchUpdateException e) {
      assertThat(e.getUpdateCounts().length, is(equalTo(2)));
      assertThat(e.getUpdateCounts()[0], is(equalTo(1L)));
      assertThat(e.getUpdateCounts()[1], is(equalTo(0L)));
    }
  }

  @Test
  public void testFailedAfterFirstStatement() throws InterruptedException, ExecutionException {
    DdlClient client = mock(DdlClient.class);
    doCallRealMethod()
        .when(client)
        .runWithRetryForMissingDefaultSequenceKind(any(), any(), any(), any());
    UpdateDatabaseDdlMetadata metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(
                Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000L - 1L))
            .addAllStatements(Arrays.asList("CREATE TABLE FOO", "CREATE TABLE INVALID_TABLE"))
            .build();
    ApiFuture<UpdateDatabaseDdlMetadata> metadataFuture = ApiFutures.immediateFuture(metadata);
    @SuppressWarnings("unchecked")
    OperationFuture<Void, UpdateDatabaseDdlMetadata> operationFuture = mock(OperationFuture.class);
    when(operationFuture.get())
        .thenThrow(
            new ExecutionException(
                "ddl statement failed", Status.INVALID_ARGUMENT.asRuntimeException()));
    when(operationFuture.getMetadata()).thenReturn(metadataFuture);
    when(client.executeDdl(argThat(isListOfStringsWithSize(2)), isNull()))
        .thenReturn(operationFuture);
    DatabaseClient dbClient = mock(DatabaseClient.class);
    when(dbClient.getDialect()).thenReturn(Dialect.GOOGLE_STANDARD_SQL);
    DdlBatch batch =
        DdlBatch.newBuilder()
            .withStatementExecutor(new StatementExecutor())
            .setDdlClient(client)
            .setDatabaseClient(dbClient)
            .setSpan(Span.getInvalid())
            .setConnectionState(new ConnectionState(new HashMap<>()))
            .build();
    batch.executeDdlAsync(
        CallType.SYNC,
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .parse(Statement.of("CREATE TABLE FOO")));
    batch.executeDdlAsync(
        CallType.SYNC,
        AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
            .parse(Statement.of("CREATE TABLE INVALID_TABLE")));
    try {
      get(batch.runBatchAsync(CallType.SYNC));
      fail("missing expected exception");
    } catch (SpannerBatchUpdateException e) {
      assertThat(e.getUpdateCounts().length, is(equalTo(2)));
      assertThat(e.getUpdateCounts()[0], is(equalTo(1L)));
      assertThat(e.getUpdateCounts()[1], is(equalTo(0L)));
    }
  }

  @Test
  public void testAbort() {
    DdlClient client = createDefaultMockDdlClient();
    DdlBatch batch = createSubject(client);
    batch.abortBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.ABORTED));
    verify(client, never()).executeDdl(anyString(), isNull());
    verify(client, never()).executeDdl(anyList(), isNull());

    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSql()).thenReturn("CREATE TABLE FOO");

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.abortBatch();
    verify(client, never()).executeDdl(anyList(), isNull());

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.abortBatch();
    verify(client, never()).executeDdl(anyList(), isNull());

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.executeDdlAsync(CallType.SYNC, statement);
    batch.abortBatch();
    verify(client, never()).executeDdl(anyList(), isNull());
    boolean exception = false;
    try {
      get(batch.runBatchAsync(CallType.SYNC));
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));
    verify(client, never()).executeDdl(anyList(), isNull());
  }

  @Test
  public void testCancel() {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSql()).thenReturn("CREATE TABLE FOO");

    DdlClient client = createDefaultMockDdlClient(10000L);
    final DdlBatch batch = createSubject(client);
    batch.executeDdlAsync(CallType.SYNC, statement);
    Executors.newSingleThreadScheduledExecutor()
        .schedule(batch::cancel, 100, TimeUnit.MILLISECONDS);
    try {
      get(batch.runBatchAsync(CallType.SYNC));
      fail("expected CANCELLED");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.CANCELLED, e.getErrorCode());
    }
  }

  @Test
  public void testCommit() {
    DdlBatch batch = createSubject();
    try {
      batch.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE);
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testRollback() {
    DdlBatch batch = createSubject();
    try {
      batch.rollbackAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE);
      fail("expected FAILED_PRECONDITION");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testExtractUpdateCounts() {
    DdlBatch batch = createSubject();
    UpdateDatabaseDdlMetadata metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(1000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(2000L).build())
            .addStatements("CREATE TABLE FOO")
            .addStatements("CREATE TABLE BAR")
            .addStatements("CREATE TABLE BAZ")
            .build();
    long[] updateCounts = batch.extractUpdateCounts(metadata);
    assertThat(updateCounts, is(equalTo(new long[] {1L, 1L, 0L})));

    metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(1000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(2000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(3000L).build())
            .addStatements("CREATE TABLE FOO")
            .addStatements("CREATE TABLE BAR")
            .addStatements("CREATE TABLE BAZ")
            .build();
    updateCounts = batch.extractUpdateCounts(metadata);
    assertThat(updateCounts, is(equalTo(new long[] {1L, 1L, 1L})));

    metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(1000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(2000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(3000L).build())
            .addStatements("CREATE TABLE FOO")
            .addStatements("CREATE TABLE BAR")
            .addStatements("CREATE TABLE BAZ")
            .build();
    updateCounts = batch.extractUpdateCounts(metadata);
    assertThat(updateCounts, is(equalTo(new long[] {1L, 1L, 1L})));

    // This is not something Cloud Spanner should return, but the method can handle it.
    metadata =
        UpdateDatabaseDdlMetadata.newBuilder()
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(1000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(2000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(3000L).build())
            .addCommitTimestamps(Timestamp.newBuilder().setSeconds(4000L).build())
            .addStatements("CREATE TABLE FOO")
            .addStatements("CREATE TABLE BAR")
            .addStatements("CREATE TABLE BAZ")
            .build();
    updateCounts = batch.extractUpdateCounts(metadata);
    assertThat(updateCounts, is(equalTo(new long[] {1L, 1L, 1L})));
  }
}
