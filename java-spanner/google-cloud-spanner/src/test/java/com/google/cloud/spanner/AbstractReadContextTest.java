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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.XGoogSpannerRequestId.NoopRequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.DirectedReadOptions.IncludeReplicas;
import com.google.spanner.v1.DirectedReadOptions.ReplicaSelection;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ReadRequest.LockHint;
import com.google.spanner.v1.ReadRequest.OrderBy;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.RequestOptions.Priority;
import com.google.spanner.v1.SessionName;
import com.google.spanner.v1.TransactionOptions;
import com.google.spanner.v1.TransactionSelector;
import io.opencensus.trace.Tracing;
import io.opentelemetry.api.OpenTelemetry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.google.cloud.spanner.SpannerExceptionFactory;

@RunWith(Parameterized.class)
public class AbstractReadContextTest {
  private static final DirectedReadOptions DIRECTED_READ_OPTIONS =
      DirectedReadOptions.newBuilder()
          .setIncludeReplicas(
              IncludeReplicas.newBuilder()
                  .addReplicaSelections(
                      ReplicaSelection.newBuilder().setLocation("us-west1").build()))
          .build();

  @Parameter(0)
  public QueryOptions defaultQueryOptions;

  @Parameters(name = "SpannerOptions.DefaultQueryOptions = {0}")
  public static Collection<Object[]> parameters() {
    List<Object[]> params = new ArrayList<>();
    params.add(new Object[] {QueryOptions.getDefaultInstance()});
    params.add(
        new Object[] {
          QueryOptions.newBuilder()
              .setOptimizerVersion("some-version")
              .setOptimizerStatisticsPackage("some-package")
              .build()
        });
    return params;
  }

  class TestReadContextBuilder
      extends AbstractReadContext.Builder<TestReadContextBuilder, TestReadContext> {
    @Override
    TestReadContext build() {
      return new TestReadContext(this);
    }
  }

  class TestReadContextWithTagBuilder
      extends AbstractReadContext.Builder<TestReadContextWithTagBuilder, TestReadContextWithTag> {
    @Override
    TestReadContextWithTag build() {
      return new TestReadContextWithTag(this);
    }
  }

  private class TestReadContext extends AbstractReadContext {
    TestReadContext(TestReadContextBuilder builder) {
      super(builder);
    }

    @Override
    TransactionSelector getTransactionSelector() {
      return TransactionSelector.getDefaultInstance();
    }

    @Override
    Map<SpannerRpc.Option, ?> getTransactionChannelHint() {
      return null;
    }
  }

  private final class TestReadContextWithTag extends AbstractReadContext {
    TestReadContextWithTag(TestReadContextWithTagBuilder builder) {
      super(builder);
    }

    @Override
    TransactionSelector getTransactionSelector() {
      return TransactionSelector.getDefaultInstance();
    }

    @Override
    Map<Option, ?> getTransactionChannelHint() {
      return null;
    }

    String getTransactionTag() {
      return "app=spanner,env=test";
    }
  }

  private TestReadContext context;

  @Before
  public void setup() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    TestReadContextBuilder builder = new TestReadContextBuilder();
    context =
        builder
            .setSession(session)
            .setRpc(mock(SpannerRpc.class))
            .setDefaultQueryOptions(defaultQueryOptions)
            .setExecutorProvider(mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
            .build();
  }

  @Test
  public void executeSqlRequestBuilderWithoutQueryOptions() {
    ExecuteSqlRequest request =
        context
            .getExecuteSqlRequestBuilder(
                Statement.of("SELECT FOO FROM BAR"),
                QueryMode.NORMAL,
                Options.fromQueryOptions(),
                true)
            .build();
    assertThat(request.getSql()).isEqualTo("SELECT FOO FROM BAR");
    assertThat(request.getQueryOptions()).isEqualTo(defaultQueryOptions);
  }

  @Test
  public void executeSqlRequestBuilderWithQueryOptions() {
    ExecuteSqlRequest request =
        context
            .getExecuteSqlRequestBuilder(
                Statement.newBuilder("SELECT FOO FROM BAR")
                    .withQueryOptions(
                        QueryOptions.newBuilder()
                            .setOptimizerVersion("2.0")
                            .setOptimizerStatisticsPackage("custom-package")
                            .build())
                    .build(),
                QueryMode.NORMAL,
                Options.fromQueryOptions(),
                true)
            .build();
    assertThat(request.getSql()).isEqualTo("SELECT FOO FROM BAR");
    assertThat(request.getQueryOptions().getOptimizerVersion()).isEqualTo("2.0");
    assertThat(request.getQueryOptions().getOptimizerStatisticsPackage())
        .isEqualTo("custom-package");
  }

  @Test
  public void testBuildRequestOptions() {
    RequestOptions requestOptions = context.buildRequestOptions(Options.fromQueryOptions());
    assertEquals(RequestOptions.Priority.PRIORITY_UNSPECIFIED, requestOptions.getPriority());
  }

  @Test
  public void testBuildRequestOptionsWithPriority() {
    RequestOptions requestOptionsHighPriority =
        context.buildRequestOptions(Options.fromQueryOptions(Options.priority(RpcPriority.HIGH)));
    assertEquals(RequestOptions.Priority.PRIORITY_HIGH, requestOptionsHighPriority.getPriority());

    RequestOptions requestOptionsMediumPriority =
        context.buildRequestOptions(Options.fromQueryOptions(Options.priority(RpcPriority.MEDIUM)));
    assertEquals(
        RequestOptions.Priority.PRIORITY_MEDIUM, requestOptionsMediumPriority.getPriority());

    RequestOptions requestOptionsLowPriority =
        context.buildRequestOptions(Options.fromQueryOptions(Options.priority(RpcPriority.LOW)));
    assertEquals(RequestOptions.Priority.PRIORITY_LOW, requestOptionsLowPriority.getPriority());
  }

  @Test
  public void getChannelHintOptionsPrefersSessionHintWhenGrpcGcpDisabled() {
    Map<SpannerRpc.Option, ?> sessionHint =
        SessionClient.optionMap(SessionClient.SessionOption.channelHint(7L));

    Map<SpannerRpc.Option, ?> result =
        AbstractReadContext.getChannelHintOptions(sessionHint, 11L, false);

    assertThat(result).isSameInstanceAs(sessionHint);
    assertEquals(Long.valueOf(7L), Option.CHANNEL_HINT.getLong(result));
  }

  @Test
  public void getChannelHintOptionsUsesChannelIdAffinityWhenGrpcGcpEnabled() {
    Map<SpannerRpc.Option, ?> sessionHint =
        SessionClient.optionMap(SessionClient.SessionOption.channelHint(7L));

    Map<SpannerRpc.Option, ?> result =
        AbstractReadContext.getChannelHintOptions(sessionHint, 11L, true);

    assertThat(result).isNotSameInstanceAs(sessionHint);
    assertThat(result).containsKey(Option.CHANNEL_ID_AFFINITY);
    assertThat(result).doesNotContainKey(Option.CHANNEL_HINT);
  }

  @Test
  public void testGetExecuteSqlRequestBuilderWithPriority() {
    ExecuteSqlRequest.Builder request =
        context.getExecuteSqlRequestBuilder(
            Statement.of("SELECT * FROM FOO"),
            QueryMode.NORMAL,
            Options.fromQueryOptions(Options.priority(RpcPriority.MEDIUM)),
            false);
    assertEquals(Priority.PRIORITY_MEDIUM, request.getRequestOptions().getPriority());
  }

  @Test
  public void testGetExecuteSqlRequestBuilderWithDataBoost() {
    ExecuteSqlRequest.Builder request =
        context.getExecuteSqlRequestBuilder(
            Statement.of("SELECT * FROM FOO"),
            QueryMode.NORMAL,
            Options.fromQueryOptions(Options.dataBoostEnabled(true)),
            false);
    assertTrue(request.getDataBoostEnabled());
  }

  @Test
  public void testGetReadRequestBuilderWithOrderBy() {
    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setTable("table110115790")
            .setIndex("index100346066")
            .addAllColumns(new ArrayList<String>())
            .setOrderByValue(2)
            .build();
    assertEquals(OrderBy.ORDER_BY_NO_ORDER, request.getOrderBy());
  }

  @Test
  public void testGetReadRequestBuilderWithLockHint() {
    ReadRequest request =
        ReadRequest.newBuilder()
            .setSession(
                SessionName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SESSION]").toString())
            .setTransaction(TransactionSelector.newBuilder().build())
            .setTable("table110115790")
            .setIndex("index100346066")
            .addAllColumns(new ArrayList<String>())
            .setLockHintValue(2)
            .build();
    assertEquals(LockHint.LOCK_HINT_EXCLUSIVE, request.getLockHint());
  }

  @Test
  public void testGetExecuteBatchDmlRequestBuilderWithPriority() {
    ExecuteBatchDmlRequest.Builder request =
        context.getExecuteBatchDmlRequestBuilder(
            Collections.singleton(Statement.of("SELECT * FROM FOO")),
            Options.fromQueryOptions(Options.priority(RpcPriority.LOW)));
    assertEquals(Priority.PRIORITY_LOW, request.getRequestOptions().getPriority());
  }

  @Test
  public void testExecuteSqlLastStatement() {
    assertFalse(
        context
            .getExecuteSqlRequestBuilder(
                Statement.of("insert into test (id) values (1)"),
                QueryMode.NORMAL,
                Options.fromUpdateOptions(),
                false)
            .getLastStatement());
    assertTrue(
        context
            .getExecuteSqlRequestBuilder(
                Statement.of("insert into test (id) values (1)"),
                QueryMode.NORMAL,
                Options.fromUpdateOptions(Options.lastStatement()),
                false)
            .getLastStatement());
  }

  @Test
  public void testExecuteBatchDmlLastStatement() {
    assertFalse(
        context
            .getExecuteBatchDmlRequestBuilder(
                Collections.singleton(Statement.of("insert into test (id) values (1)")),
                Options.fromUpdateOptions())
            .getLastStatements());
    assertTrue(
        context
            .getExecuteBatchDmlRequestBuilder(
                Collections.singleton(Statement.of("insert into test (id) values (1)")),
                Options.fromUpdateOptions(Options.lastStatement()))
            .getLastStatements());
  }

  public void executeSqlRequestBuilderWithRequestOptions() {
    ExecuteSqlRequest request =
        context
            .getExecuteSqlRequestBuilder(
                Statement.newBuilder("SELECT FOO FROM BAR").build(),
                QueryMode.NORMAL,
                Options.fromUpdateOptions(Options.tag("app=spanner,env=test,action=query")),
                false)
            .build();
    assertThat(request.getSql()).isEqualTo("SELECT FOO FROM BAR");
    assertThat(request.getRequestOptions().getRequestTag())
        .isEqualTo("app=spanner,env=test,action=query");
    assertThat(request.getRequestOptions().getTransactionTag()).isEmpty();
  }

  @Test
  public void executeSqlRequestBuilderWithRequestOptionsWithTxnTag() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    TestReadContextWithTagBuilder builder = new TestReadContextWithTagBuilder();
    TestReadContextWithTag contextWithTag =
        builder
            .setSession(session)
            .setRpc(mock(SpannerRpc.class))
            .setDefaultQueryOptions(defaultQueryOptions)
            .setExecutorProvider(mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
            .build();

    ExecuteSqlRequest request =
        contextWithTag
            .getExecuteSqlRequestBuilder(
                Statement.newBuilder("SELECT FOO FROM BAR").build(),
                QueryMode.NORMAL,
                Options.fromUpdateOptions(Options.tag("app=spanner,env=test,action=query")),
                false)
            .build();
    assertThat(request.getSql()).isEqualTo("SELECT FOO FROM BAR");
    assertThat(request.getRequestOptions().getRequestTag())
        .isEqualTo("app=spanner,env=test,action=query");
    assertThat(request.getRequestOptions().getTransactionTag()).isEqualTo("app=spanner,env=test");
  }

  @Test
  public void testBuildRequestOptionsWithClientContext() {
    RequestOptions.ClientContext clientContext =
        RequestOptions.ClientContext.newBuilder()
            .putSecureContext(
                "key", com.google.protobuf.Value.newBuilder().setStringValue("value").build())
            .build();
    RequestOptions requestOptions =
        context.buildRequestOptions(Options.fromQueryOptions(Options.clientContext(clientContext)));
    assertEquals(clientContext, requestOptions.getClientContext());
  }

  @Test
  public void testGetExecuteSqlRequestBuilderWithDirectedReadOptions() {
    ExecuteSqlRequest.Builder request =
        context.getExecuteSqlRequestBuilder(
            Statement.of("SELECT * FROM FOO"),
            QueryMode.NORMAL,
            Options.fromQueryOptions(Options.directedRead(DIRECTED_READ_OPTIONS)),
            false);
    assertEquals(DIRECTED_READ_OPTIONS, request.getDirectedReadOptions());
  }

  private static ISpan createTestSpan() {
    if (SpannerOptions.getActiveTracingFramework()
        .equals(SpannerOptions.TracingFramework.OPEN_TELEMETRY)) {
      return new OpenTelemetrySpan(mock(io.opentelemetry.api.trace.Span.class));
    } else {
      return new OpenCensusSpan(io.opencensus.trace.BlankSpan.INSTANCE);
    }
  }

  @Test
  public void testSynchronousStartFailureDoesNotInvokeOnErrorTwice() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    when(rpc.executeQuery(any(), any(), any(), any(), anyBoolean()))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION, "start failure"));
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    AtomicInteger onErrorCalls = new AtomicInteger();
    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(
                    new TraceWrapper(
                        Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false))
                .setSpan(createTestSpan())) {
          @Override
          public SpannerException onError(
              SpannerException exception, boolean withBeginTransaction, boolean lastStatement) {
            onErrorCalls.incrementAndGet();
            return super.onError(exception, withBeginTransaction, lastStatement);
          }
        };

    try (ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"))) {
      assertThrows(SpannerException.class, resultSet::next);
    }
    assertEquals(1, onErrorCalls.get());
  }

  @Test
  public void testCloseDuringStartStreamDoesNotInvokeOnDoneTwice() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    AtomicInteger onDoneCalls = new AtomicInteger();
    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(
                    new TraceWrapper(
                        Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false))
                .setSpan(createTestSpan())) {
          @Override
          public void onDone(boolean withBeginTransaction) {
            onDoneCalls.incrementAndGet();
            super.onDone(withBeginTransaction);
          }
        };

    try (ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"))) {
      when(rpc.executeQuery(any(), any(), any(), any(), anyBoolean()))
          .thenAnswer(
              invocation -> {
                resultSet.close();
                return mock(SpannerRpc.StreamingCall.class);
              });

      assertThrows(SpannerException.class, resultSet::next);
    }
    assertEquals(1, onDoneCalls.get());
  }

  @Test
  public void testCloseDuringStartStreamInvokesOnDoneOnlyOnceWithBeginTransaction() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    when(rpc.executeQuery(any(), any(), any(), any(), anyBoolean()))
        .thenReturn(mock(SpannerRpc.StreamingCall.class));
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    AtomicInteger onDoneCalls = new AtomicInteger();
    AtomicBoolean closedBeforeStreamStarted = new AtomicBoolean();
    AtomicReference<ResultSet> resultSetReference = new AtomicReference<>();
    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(
                    new TraceWrapper(
                        Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false))
                .setSpan(createTestSpan())) {
          @Override
          public void onDone(boolean withBeginTransaction) {
            onDoneCalls.incrementAndGet();
            super.onDone(withBeginTransaction);
          }

          @Override
          void onClosedBeforeStreamStarted(boolean withBeginTransaction) {
            closedBeforeStreamStarted.set(withBeginTransaction);
          }

          @Override
          TransactionSelector getTransactionSelector() {
            ResultSet currentResultSet = resultSetReference.get();
            if (currentResultSet != null) {
              currentResultSet.close();
            }
            return TransactionSelector.newBuilder()
                .setBegin(
                    TransactionOptions.newBuilder()
                        .setReadOnly(TransactionOptions.ReadOnly.getDefaultInstance()))
                .build();
          }
        };

    try (ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"))) {
      resultSetReference.set(resultSet);
      assertThrows(SpannerException.class, resultSet::next);
    }
    assertEquals(1, onDoneCalls.get());
    assertTrue(closedBeforeStreamStarted.get());
  }

  @Test(timeout = 10_000)
  public void testCloseDuringPrepareRequestWhichThrowsCallsOnDoneExactlyOnce() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    AtomicInteger onDoneCalls = new AtomicInteger();
    AtomicReference<ResultSet> resultSetReference = new AtomicReference<>();
    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(
                    new TraceWrapper(
                        Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false))
                .setSpan(createTestSpan())) {
          @Override
          public void onDone(boolean withBeginTransaction) {
            onDoneCalls.incrementAndGet();
            super.onDone(withBeginTransaction);
          }

          @Override
          TransactionSelector getTransactionSelector() {
            ResultSet currentResultSet = resultSetReference.get();
            if (currentResultSet != null) {
              currentResultSet.close();
            }
            throw new RuntimeException("simulated prepare failure");
          }
        };

    try (ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"))) {
      resultSetReference.set(resultSet);
      assertThrows(SpannerException.class, resultSet::next);
    }
    assertEquals(1, onDoneCalls.get());
    verify(rpc, never()).executeQuery(any(), any(), any(), any(), anyBoolean());
  }

  @Test(timeout = 10_000)
  public void testCloseDuringResetStreamAfterStartThrowsCallsOnDoneExactlyOnce() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    AtomicInteger onDoneCalls = new AtomicInteger();
    AtomicReference<ResultSet> resultSetReference = new AtomicReference<>();
    ISpan mockSpan = mock(ISpan.class);
    doAnswer(
            invocation -> {
              ResultSet currentResultSet = resultSetReference.get();
              if (currentResultSet != null) {
                currentResultSet.close();
              }
              return null;
            })
        .when(mockSpan)
        .addAnnotation(eq("Stream broken. Not safe to retry"), any(Throwable.class));

    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(any(), any(), any())).thenReturn(mockSpan);

    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(tracer)
                .setSpan(mockSpan)) {
          @Override
          public void onDone(boolean withBeginTransaction) {
            onDoneCalls.incrementAndGet();
            super.onDone(withBeginTransaction);
          }
        };

    when(rpc.executeQuery(any(), any(), any(), any(), anyBoolean()))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "simulated start failure"));

    try (ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"))) {
      resultSetReference.set(resultSet);
      assertThrows(SpannerException.class, resultSet::next);
    }
    assertEquals(1, onDoneCalls.get());
  }

  @Test(timeout = 10_000)
  public void testStartStreamThrowsConcurrentlyWithCloseFailsTransactionWithStartError()
      throws Exception {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    SettableApiFuture<ByteString> transactionIdFuture = SettableApiFuture.create();
    AtomicReference<ResultSet> resultSetReference = new AtomicReference<>();
    ISpan mockSpan = mock(ISpan.class);
    doAnswer(
            invocation -> {
              ResultSet currentResultSet = resultSetReference.get();
              if (currentResultSet != null) {
                currentResultSet.close();
              }
              return null;
            })
        .when(mockSpan)
        .addAnnotation(eq("Stream broken. Not safe to retry"), any(Throwable.class));

    TraceWrapper tracer = mock(TraceWrapper.class);
    when(tracer.spanBuilderWithExplicitParent(any(), any(), any())).thenReturn(mockSpan);

    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(tracer)
                .setSpan(mockSpan)) {
          @Override
          TransactionSelector getTransactionSelector() {
            return TransactionSelector.newBuilder()
                .setBegin(
                    TransactionOptions.newBuilder()
                        .setReadOnly(TransactionOptions.ReadOnly.getDefaultInstance()))
                .build();
          }

          @Override
          void onStartFailed(
              boolean withBeginTransaction, boolean lastStatement, Throwable throwable) {
            if (withBeginTransaction && !transactionIdFuture.isDone()) {
              transactionIdFuture.setException(throwable);
            }
          }

          @Override
          public void onDone(boolean withBeginTransaction) {
            if (withBeginTransaction && !transactionIdFuture.isDone()) {
              transactionIdFuture.setException(
                  SpannerExceptionFactory.newSpannerException(
                      ErrorCode.FAILED_PRECONDITION,
                      "Read-only transaction was closed before the transaction ID was returned by"
                          + " Cloud Spanner"));
            }
            super.onDone(withBeginTransaction);
          }
        };

    when(rpc.executeQuery(any(), any(), any(), any(), anyBoolean()))
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.INTERNAL, "simulated start failure"));

    try (ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"))) {
      resultSetReference.set(resultSet);
      assertThrows(SpannerException.class, resultSet::next);
    }

    ExecutionException executionException =
        assertThrows(ExecutionException.class, () -> transactionIdFuture.get(1, TimeUnit.SECONDS));
    assertTrue(executionException.getCause() instanceof SpannerException);
    SpannerException spannerException = (SpannerException) executionException.getCause();
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("simulated start failure"));
    verify(session).onReadDone();
  }

  @Test
  public void testCloseFreshResultSetBeforeNextPreventsRpcAndThrowsOnNext() {
    SessionImpl session = mock(SessionImpl.class);
    when(session.getName()).thenReturn("session-1");
    SpannerRpc rpc = mock(SpannerRpc.class);
    when(rpc.getExecuteQueryRetrySettings()).thenReturn(RetrySettings.newBuilder().build());
    when(rpc.getExecuteQueryRetryableCodes()).thenReturn(Collections.emptySet());
    SpannerImpl spanner = mock(SpannerImpl.class);
    SpannerOptions spannerOptions = mock(SpannerOptions.class);
    when(spanner.getOptions()).thenReturn(spannerOptions);
    when(session.getSpanner()).thenReturn(spanner);
    when(session.getRequestIdCreator()).thenReturn(NoopRequestIdCreator.INSTANCE);

    AtomicInteger onDoneCalls = new AtomicInteger();
    AtomicInteger onErrorCalls = new AtomicInteger();
    TestReadContext testContext =
        new TestReadContext(
            new TestReadContextBuilder()
                .setSession(session)
                .setRpc(rpc)
                .setDefaultQueryOptions(defaultQueryOptions)
                .setExecutorProvider(
                    mock(ExecutorProvider.class, withSettings().withoutAnnotations()))
                .setTracer(
                    new TraceWrapper(
                        Tracing.getTracer(), OpenTelemetry.noop().getTracer(""), false))
                .setSpan(createTestSpan())) {
          @Override
          public void onDone(boolean withBeginTransaction) {
            onDoneCalls.incrementAndGet();
            super.onDone(withBeginTransaction);
          }

          @Override
          public SpannerException onError(
              SpannerException error, boolean withBeginTransaction, boolean lastStatement) {
            onErrorCalls.incrementAndGet();
            return super.onError(error, withBeginTransaction, lastStatement);
          }
        };

    ResultSet resultSet = testContext.executeQuery(Statement.of("SELECT 1"));
    resultSet.close();

    SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
    assertEquals(ErrorCode.INTERNAL, exception.getErrorCode());
    verify(rpc, never()).executeQuery(any(), any(), any(), any(), anyBoolean());
    assertEquals(1, onDoneCalls.get());
    assertEquals(0, onErrorCalls.get());
  }
}
