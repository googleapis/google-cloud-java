/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.ErrorHandler.DefaultErrorHandler;
import com.google.cloud.spanner.SessionClient.SessionId;
import com.google.cloud.spanner.TransactionRunnerImpl.TransactionContextImpl;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.v1.stub.SpannerStubSettings;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionOptions;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Unit test for {@link com.google.cloud.spanner.TransactionRunnerImpl} */
@RunWith(JUnit4.class)
public class TransactionRunnerImplTest {
  private static final class TestExecutorFactory
      implements ExecutorFactory<ScheduledExecutorService> {
    @Override
    public ScheduledExecutorService get() {
      return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void release(ScheduledExecutorService exec) {
      exec.shutdown();
    }
  }

  @Mock private SpannerRpc rpc;
  @Mock private SessionImpl session;
  @Mock private TransactionRunnerImpl.TransactionContextImpl txn;
  private TransactionRunnerImpl transactionRunner;
  private boolean firstRun;
  private boolean usedInlinedBegin;
  private TraceWrapper tracer;
  private ISpan span;

  @BeforeClass
  public static void setupOpenTelemetry() {
    SpannerOptions.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();
  }

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    tracer = new TraceWrapper(Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false);
    firstRun = true;
    when(session.getErrorHandler()).thenReturn(DefaultErrorHandler.INSTANCE);
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any())).thenReturn(txn);
    when(session.getTracer()).thenReturn(tracer);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);
    when(rpc.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(rpc.executeQuery(Mockito.any(ExecuteSqlRequest.class), Mockito.anyMap(), eq(true)))
        .thenAnswer(
            invocation -> {
              ResultSet.Builder builder =
                  ResultSet.newBuilder()
                      .setStats(ResultSetStats.newBuilder().setRowCountExact(1L).build());
              ExecuteSqlRequest request = invocation.getArgument(0, ExecuteSqlRequest.class);
              if (request.getTransaction().hasBegin()
                  && request.getTransaction().getBegin().hasReadWrite()) {
                builder.setMetadata(
                    ResultSetMetadata.newBuilder()
                        .setTransaction(
                            Transaction.newBuilder().setId(ByteString.copyFromUtf8("test")))
                        .build());
                usedInlinedBegin = true;
              }
              return builder.build();
            });
    transactionRunner = new TransactionRunnerImpl(session);
    when(rpc.commitAsync(Mockito.any(CommitRequest.class), Mockito.anyMap()))
        .thenReturn(
            ApiFutures.immediateFuture(
                CommitResponse.newBuilder()
                    .setCommitTimestamp(Timestamp.getDefaultInstance())
                    .build()));
    when(rpc.getCommitRetrySettings())
        .thenReturn(SpannerStubSettings.newBuilder().commitSettings().getRetrySettings());
    when(rpc.rollbackAsync(Mockito.any(RollbackRequest.class), Mockito.anyMap()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    Span oTspan = mock(Span.class);
    span = new OpenTelemetrySpan(oTspan);
    when(oTspan.makeCurrent()).thenReturn(mock(Scope.class));
    transactionRunner.setSpan(span);
  }

  @Test
  public void testCommitWithClientContext() {
    RequestOptions.ClientContext clientContext =
        RequestOptions.ClientContext.newBuilder()
            .putSecureContext(
                "key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
            .build();
    when(session.getName()).thenReturn("projects/p/instances/i/databases/d/sessions/s");
    when(session.newTransaction(any(Options.class), any())).thenReturn(txn);
    Mockito.clearInvocations(session);
    transactionRunner =
        new TransactionRunnerImpl(
            session,
            Options.priority(Options.RpcPriority.HIGH),
            Options.tag("tag"),
            Options.clientContext(clientContext));
    transactionRunner.setSpan(span);

    transactionRunner.run(
        transaction -> {
          return null;
        });

    ArgumentCaptor<Options> optionsCaptor = ArgumentCaptor.forClass(Options.class);
    verify(session).newTransaction(optionsCaptor.capture(), any());
    Options capturedOptions = optionsCaptor.getValue();
    assertEquals(RequestOptions.Priority.PRIORITY_HIGH, capturedOptions.priority());
    assertEquals("tag", capturedOptions.tag());
    assertEquals(clientContext, capturedOptions.clientContext());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void usesPreparedTransaction() {
    SpannerOptions options = mock(SpannerOptions.class);
    when(options.getNumChannels()).thenReturn(4);
    when(options.getDefaultTransactionOptions())
        .thenReturn(TransactionOptions.getDefaultInstance());
    GrpcTransportOptions transportOptions = mock(GrpcTransportOptions.class);
    when(transportOptions.getExecutorFactory()).thenReturn(new TestExecutorFactory());
    when(options.getTransportOptions()).thenReturn(transportOptions);
    SessionPoolOptions sessionPoolOptions =
        SessionPoolOptions.newBuilder().setMinSessions(0).setIncStep(1).build();
    when(options.getSessionPoolOptions()).thenReturn(sessionPoolOptions);
    when(options.getSessionLabels()).thenReturn(Collections.emptyMap());
    when(options.getDatabaseRole()).thenReturn("role");
    when(options.getOpenTelemetry()).thenReturn(OpenTelemetry.noop());
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.asyncDeleteSession(Mockito.anyString(), Mockito.anyMap()))
        .thenReturn(ApiFutures.immediateFuture(Empty.getDefaultInstance()));
    when(rpc.batchCreateSessions(
            Mockito.anyString(),
            Mockito.eq(1),
            Mockito.anyString(),
            Mockito.anyMap(),
            Mockito.anyMap()))
        .thenAnswer(
            invocation ->
                Collections.singletonList(
                    Session.newBuilder()
                        .setName(invocation.getArguments()[0] + "/sessions/1")
                        .setCreateTime(
                            Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000))
                        .build()));
    when(rpc.createSession(
            Mockito.anyString(),
            Mockito.anyString(),
            Mockito.anyMap(),
            Mockito.eq(null),
            Mockito.eq(true)))
        .thenAnswer(
            invocation ->
                Session.newBuilder()
                    .setName(invocation.getArguments()[0] + "/sessions/1")
                    .setMultiplexed(true)
                    .setCreateTime(
                        com.google.protobuf.Timestamp.newBuilder()
                            .setSeconds(System.currentTimeMillis() * 1000))
                    .build());
    when(rpc.beginTransactionAsync(
            Mockito.any(BeginTransactionRequest.class), Mockito.anyMap(), eq(true)))
        .thenAnswer(
            invocation ->
                ApiFutures.immediateFuture(
                    Transaction.newBuilder()
                        .setId(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
                        .build()));
    when(rpc.commitAsync(Mockito.any(CommitRequest.class), Mockito.anyMap()))
        .thenAnswer(
            invocation ->
                ApiFutures.immediateFuture(
                    CommitResponse.newBuilder()
                        .setCommitTimestamp(
                            Timestamp.newBuilder().setSeconds(System.currentTimeMillis() * 1000))
                        .build()));
    when(rpc.getCommitRetrySettings())
        .thenReturn(SpannerStubSettings.newBuilder().commitSettings().getRetrySettings());
    DatabaseId db = DatabaseId.of("test", "test", "test");
    try (SpannerImpl spanner = new SpannerImpl(rpc, options)) {
      DatabaseClient client = spanner.getDatabaseClient(db);
      client.readWriteTransaction().run(transaction -> null);
      verify(rpc, times(1))
          .beginTransactionAsync(
              Mockito.any(BeginTransactionRequest.class), Mockito.anyMap(), eq(true));
    }
  }

  @Test
  public void commitSucceeds() {
    final AtomicInteger numCalls = new AtomicInteger(0);
    transactionRunner.run(
        transaction -> {
          numCalls.incrementAndGet();
          return null;
        });
    assertThat(numCalls.get()).isEqualTo(1);
    verify(txn, never()).ensureTxn();
    verify(txn).commit();
  }

  @Test
  public void runAbort() {
    when(txn.isAborted()).thenReturn(true);
    runTransaction(abortedWithRetryInfo());
    verify(txn).ensureTxn();
  }

  @Test
  public void commitAbort() {
    final SpannerException error =
        SpannerExceptionFactory.newSpannerException(abortedWithRetryInfo());
    doThrow(error).doNothing().when(txn).commit();
    final AtomicInteger numCalls = new AtomicInteger(0);
    transactionRunner.run(
        transaction -> {
          numCalls.incrementAndGet();
          return null;
        });
    assertThat(numCalls.get()).isEqualTo(2);
    // ensureTxn() is only called during retry.
    verify(txn).ensureTxn();
  }

  @Test
  public void commitFailsWithNonAbort() {
    final SpannerException error =
        SpannerExceptionFactory.newSpannerException(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, ""));
    doThrow(error).when(txn).commit();
    final AtomicInteger numCalls = new AtomicInteger(0);
    SpannerException e =
        assertThrows(
            SpannerException.class,
            () -> transactionRunner.run(transaction -> numCalls.incrementAndGet()));
    assertEquals(ErrorCode.UNKNOWN, e.getErrorCode());
    assertEquals(1, numCalls.get());
    verify(txn, never()).ensureTxn();
    verify(txn, times(1)).commit();
  }

  @Test
  public void runResourceExhaustedNoRetry() {
    assertThrows(
        SpannerException.class,
        () ->
            runTransaction(
                new StatusRuntimeException(
                    Status.fromCodeValue(Status.Code.RESOURCE_EXHAUSTED.value()))));
    verify(txn).rollback();
  }

  @Test
  public void batchDmlAborted() {
    long[] updateCount = batchDmlException(Code.ABORTED_VALUE);
    assertThat(updateCount.length).isEqualTo(2);
    assertThat(updateCount[0]).isEqualTo(1L);
    assertThat(updateCount[1]).isEqualTo(1L);
  }

  @Test
  public void batchDmlFailedPrecondition() {
    SpannerBatchUpdateException e =
        assertThrows(
            SpannerBatchUpdateException.class,
            () -> batchDmlException(Code.FAILED_PRECONDITION_VALUE));
    assertArrayEquals(new long[] {1L}, e.getUpdateCounts());
    assertEquals(Code.FAILED_PRECONDITION_VALUE, e.getCode());
  }

  @SuppressWarnings("unchecked")
  @Test
  public void inlineBegin() {
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions options = mock(SpannerOptions.class);
    when(options.getDefaultTransactionOptions())
        .thenReturn(TransactionOptions.getDefaultInstance());
    when(spanner.getRpc()).thenReturn(rpc);
    when(spanner.getDefaultQueryOptions(Mockito.any(DatabaseId.class)))
        .thenReturn(QueryOptions.getDefaultInstance());
    when(spanner.getOptions()).thenReturn(options);
    when(spanner.getTracer()).thenReturn(tracer);
    SessionPoolOptions sessionPoolOptions = SessionPoolOptions.newBuilder().build();
    when(options.getSessionPoolOptions()).thenReturn(sessionPoolOptions);

    SessionImpl session =
        new SessionImpl(
            spanner,
            new SessionReference(
                "projects/p/instances/i/databases/d/sessions/s", null, Collections.EMPTY_MAP)) {};
    session.setCurrentSpan(new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class)));
    TransactionRunnerImpl runner = new TransactionRunnerImpl(session);
    runner.setSpan(span);
    assertThat(usedInlinedBegin).isFalse();
    runner.run(
        transaction -> {
          transaction.executeUpdate(Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2"));
          return null;
        });
    verify(rpc, Mockito.never())
        .beginTransaction(Mockito.any(BeginTransactionRequest.class), Mockito.anyMap(), eq(true));
    verify(rpc, Mockito.never())
        .beginTransactionAsync(
            Mockito.any(BeginTransactionRequest.class), Mockito.anyMap(), eq(true));
    assertThat(usedInlinedBegin).isTrue();
  }

  @SuppressWarnings("unchecked")
  private long[] batchDmlException(int status) {
    Preconditions.checkArgument(status != Code.OK_VALUE);
    TransactionContextImpl transaction =
        TransactionContextImpl.newBuilder()
            .setSession(session)
            .setTransactionId(ByteString.copyFromUtf8(UUID.randomUUID().toString()))
            .setOptions(Options.fromTransactionOptions())
            .setRpc(rpc)
            .setTracer(session.getTracer())
            .setSpan(session.getTracer().getCurrentSpan())
            .build();
    when(session.newTransaction(eq(Options.fromTransactionOptions()), any()))
        .thenReturn(transaction);
    when(session.getName()).thenReturn(SessionId.of("p", "i", "d", "test").getName());
    TransactionRunnerImpl runner = new TransactionRunnerImpl(session);
    runner.setSpan(span);
    ExecuteBatchDmlResponse response1 =
        ExecuteBatchDmlResponse.newBuilder()
            .addResultSets(
                ResultSet.newBuilder()
                    .setStats(ResultSetStats.newBuilder().setRowCountExact(1L))
                    .build())
            .setStatus(com.google.rpc.Status.newBuilder().setCode(status).build())
            .build();
    ExecuteBatchDmlResponse response2 =
        ExecuteBatchDmlResponse.newBuilder()
            .addResultSets(
                ResultSet.newBuilder()
                    .setStats(ResultSetStats.newBuilder().setRowCountExact(1L))
                    .build())
            .addResultSets(
                ResultSet.newBuilder()
                    .setStats(ResultSetStats.newBuilder().setRowCountExact(1L))
                    .build())
            .setStatus(com.google.rpc.Status.newBuilder().setCode(Code.OK_VALUE).build())
            .build();
    when(rpc.executeBatchDml(Mockito.any(ExecuteBatchDmlRequest.class), Mockito.anyMap()))
        .thenReturn(response1, response2);
    CommitResponse commitResponse =
        CommitResponse.newBuilder().setCommitTimestamp(Timestamp.getDefaultInstance()).build();
    when(rpc.commitAsync(Mockito.any(CommitRequest.class), Mockito.anyMap()))
        .thenReturn(ApiFutures.immediateFuture(commitResponse));
    final Statement statement = Statement.of("UPDATE FOO SET BAR=1");
    final AtomicInteger numCalls = new AtomicInteger(0);
    long[] updateCount =
        runner.run(
            transaction1 -> {
              numCalls.incrementAndGet();
              return transaction1.batchUpdate(Arrays.asList(statement, statement));
            });
    if (status == Code.ABORTED_VALUE) {
      // Assert that the method ran twice because the first response aborted.
      assertThat(numCalls.get()).isEqualTo(2);
    }
    return updateCount;
  }

  private void runTransaction(final Exception exception) {
    transactionRunner.run(
        transaction -> {
          if (firstRun) {
            firstRun = false;
            throw SpannerExceptionFactory.newSpannerException(exception);
          }
          return null;
        });
  }

  private SpannerException abortedWithRetryInfo() {
    Status status = Status.fromCodeValue(Status.Code.ABORTED.value());
    return SpannerExceptionFactory.newSpannerException(
        ErrorCode.ABORTED, "test", new StatusRuntimeException(status, createRetryTrailers()));
  }

  private Metadata createRetryTrailers() {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setNanos(0).setSeconds(0L))
            .build();
    trailers.put(key, retryInfo);
    return trailers;
  }
}
