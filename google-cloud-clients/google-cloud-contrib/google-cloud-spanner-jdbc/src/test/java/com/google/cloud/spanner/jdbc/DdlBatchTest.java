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
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ConnectionImpl.InternalMetadataQuery;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import io.grpc.Status;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatcher;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class DdlBatchTest {

  @Rule public ExpectedException exception = ExpectedException.none();

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
                new Answer<Void>() {
                  @Override
                  public Void answer(InvocationOnMock invocation) throws Throwable {
                    Thread.sleep(waitForMillis);
                    return null;
                  }
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
      when(ddlClient.executeDdl(anyString())).thenReturn(operation);
      when(ddlClient.executeDdl(anyListOf(String.class))).thenReturn(operation);
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
    return DdlBatch.newBuilder()
        .setDdlClient(ddlClient)
        .setDatabaseClient(dbClient)
        .withStatementExecutor(new StatementExecutor())
        .build();
  }

  @Test
  public void testExecuteQuery() {
    DdlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.executeQuery(mock(ParsedStatement.class), AnalyzeMode.NONE);
  }

  @Test
  public void testExecuteMetadataQuery() {
    Statement statement = Statement.of("SELECT * FROM INFORMATION_SCHEMA.TABLES");
    ParsedStatement parsedStatement = mock(ParsedStatement.class);
    when(parsedStatement.isQuery()).thenReturn(true);
    when(parsedStatement.getStatement()).thenReturn(statement);
    DatabaseClient dbClient = mock(DatabaseClient.class);
    ReadContext singleUse = mock(ReadContext.class);
    ResultSet resultSet = mock(ResultSet.class);
    when(singleUse.executeQuery(statement)).thenReturn(resultSet);
    when(dbClient.singleUse()).thenReturn(singleUse);
    DdlBatch batch = createSubject(createDefaultMockDdlClient(), dbClient);
    assertThat(
        batch
            .executeQuery(parsedStatement, AnalyzeMode.NONE, InternalMetadataQuery.INSTANCE)
            .hashCode(),
        is(equalTo(resultSet.hashCode())));
  }

  @Test
  public void testExecuteUpdate() {
    DdlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.executeUpdate(mock(ParsedStatement.class));
  }

  @Test
  public void testGetCommitTimestamp() {
    DdlBatch batch = createSubject();
    batch.runBatch();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.getCommitTimestamp();
  }

  @Test
  public void testGetReadTimestamp() {
    DdlBatch batch = createSubject();
    batch.runBatch();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.getReadTimestamp();
  }

  @Test
  public void testWrite() {
    DdlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.write(Mutation.newInsertBuilder("foo").build());
  }

  @Test
  public void testWriteIterable() {
    DdlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.write(Arrays.asList(Mutation.newInsertBuilder("foo").build()));
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
    batch.runBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    assertThat(batch.isActive(), is(false));

    batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    batch.abortBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.ABORTED));
    assertThat(batch.isActive(), is(false));

    DdlClient client = mock(DdlClient.class);
    doThrow(SpannerException.class).when(client).executeDdl(anyListOf(String.class));
    batch = createSubject(client);
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSqlWithoutComments()).thenReturn("CREATE TABLE FOO");
    when(statement.getType()).thenReturn(StatementType.DDL);
    batch.executeDdl(statement);
    boolean exception = false;
    try {
      batch.runBatch();
    } catch (SpannerException e) {
      exception = true;
    }
    assertThat(exception, is(true));
    assertThat(batch.getState(), is(UnitOfWorkState.RUN_FAILED));
    assertThat(batch.isActive(), is(false));
  }

  private static IsListOfStringsWithSize isEmptyListOfStrings() {
    return new IsListOfStringsWithSize(0);
  }

  private static IsListOfStringsWithSize isListOfStringsWithSize(int size) {
    return new IsListOfStringsWithSize(size);
  }

  private static class IsListOfStringsWithSize extends ArgumentMatcher<List<String>> {
    private final int size;

    private IsListOfStringsWithSize(int size) {
      this.size = size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(Object list) {
      return ((List<String>) list).size() == size;
    }
  }

  @Test
  public void testRunBatch() {
    DdlClient client = createDefaultMockDdlClient();
    DdlBatch batch = createSubject(client);
    batch.runBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    verify(client, never()).executeDdl(anyString());
    verify(client, never()).executeDdl(argThat(isEmptyListOfStrings()));

    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSqlWithoutComments()).thenReturn("CREATE TABLE FOO");

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdl(statement);
    batch.runBatch();
    verify(client).executeDdl(argThat(isListOfStringsWithSize(1)));

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdl(statement);
    batch.executeDdl(statement);
    batch.runBatch();
    verify(client).executeDdl(argThat(isListOfStringsWithSize(2)));
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    boolean exception = false;
    try {
      batch.runBatch();
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
      batch.executeDdl(statement);
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));
    exception = false;
    try {
      batch.executeDdl(statement);
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));

    client = createDefaultMockDdlClient(true);
    batch = createSubject(client);
    batch.executeDdl(statement);
    batch.executeDdl(statement);
    exception = false;
    try {
      batch.runBatch();
    } catch (SpannerException e) {
      exception = true;
    }
    assertThat(exception, is(true));
    assertThat(batch.getState(), is(UnitOfWorkState.RUN_FAILED));
    verify(client).executeDdl(argThat(isListOfStringsWithSize(2)));
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
    when(client.executeDdl(argThat(isListOfStringsWithSize(2)))).thenReturn(operationFuture);
    DdlBatch batch =
        DdlBatch.newBuilder()
            .withStatementExecutor(new StatementExecutor())
            .setDdlClient(client)
            .setDatabaseClient(mock(DatabaseClient.class))
            .build();
    batch.executeDdl(StatementParser.INSTANCE.parse(Statement.of("CREATE TABLE FOO")));
    batch.executeDdl(StatementParser.INSTANCE.parse(Statement.of("CREATE TABLE BAR")));
    long[] updateCounts = batch.runBatch();
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
    when(client.executeDdl(argThat(isListOfStringsWithSize(2)))).thenReturn(operationFuture);
    DdlBatch batch =
        DdlBatch.newBuilder()
            .withStatementExecutor(new StatementExecutor())
            .setDdlClient(client)
            .setDatabaseClient(mock(DatabaseClient.class))
            .build();
    batch.executeDdl(StatementParser.INSTANCE.parse(Statement.of("CREATE TABLE FOO")));
    batch.executeDdl(StatementParser.INSTANCE.parse(Statement.of("CREATE TABLE INVALID_TABLE")));
    try {
      batch.runBatch();
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
    verify(client, never()).executeDdl(anyString());
    verify(client, never()).executeDdl(anyListOf(String.class));

    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSqlWithoutComments()).thenReturn("CREATE TABLE FOO");

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdl(statement);
    batch.abortBatch();
    verify(client, never()).executeDdl(anyListOf(String.class));

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdl(statement);
    batch.executeDdl(statement);
    batch.abortBatch();
    verify(client, never()).executeDdl(anyListOf(String.class));

    client = createDefaultMockDdlClient();
    batch = createSubject(client);
    batch.executeDdl(statement);
    batch.executeDdl(statement);
    batch.abortBatch();
    verify(client, never()).executeDdl(anyListOf(String.class));
    boolean exception = false;
    try {
      batch.runBatch();
    } catch (SpannerException e) {
      if (e.getErrorCode() != ErrorCode.FAILED_PRECONDITION) {
        throw e;
      }
      exception = true;
    }
    assertThat(exception, is(true));
    verify(client, never()).executeDdl(anyListOf(String.class));
  }

  @Test
  public void testCancel() {
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getType()).thenReturn(StatementType.DDL);
    when(statement.getStatement()).thenReturn(Statement.of("CREATE TABLE FOO"));
    when(statement.getSqlWithoutComments()).thenReturn("CREATE TABLE FOO");

    DdlClient client = createDefaultMockDdlClient(10000L);
    final DdlBatch batch = createSubject(client);
    batch.executeDdl(statement);
    Executors.newSingleThreadScheduledExecutor()
        .schedule(
            new Runnable() {
              @Override
              public void run() {
                batch.cancel();
              }
            },
            100,
            TimeUnit.MILLISECONDS);
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.CANCELLED));
    batch.runBatch();
  }

  @Test
  public void testCommit() {
    DdlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.commit();
  }

  @Test
  public void testRollback() {
    DdlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.rollback();
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
