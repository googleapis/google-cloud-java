/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.Any;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BatchWriteRequest;
import com.google.spanner.v1.BatchWriteRequest.MutationGroup;
import com.google.spanner.v1.BatchWriteResponse;
import com.google.spanner.v1.Mutation;
import com.google.spanner.v1.RequestOptions;
import com.google.spanner.v1.RequestOptions.Priority;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BatchWriteResumingServerStreamingCallableTest {

  private static final com.google.rpc.Status OK_STATUS =
      com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.OK_VALUE).build();
  private static final com.google.rpc.Status ABORTED_STATUS =
      com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.ABORTED_VALUE).build();
  private static final com.google.rpc.Status ALREADY_EXISTS_STATUS =
      com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.ALREADY_EXISTS_VALUE).build();

  private ScheduledExecutorService executor;
  private FakeClock clock;
  private RecordingTracer tracer;
  private ApiTracerFactory tracerFactory;

  @Before
  public void setUp() {
    executor = Executors.newScheduledThreadPool(2);
    clock = new FakeClock();
    tracer = new RecordingTracer();
    tracerFactory =
        new BaseApiTracerFactory() {
          @Override
          public ApiTracer newTracer(
              ApiTracer parent, SpanName spanName, OperationType operationType) {
            tracer.spanName = spanName;
            return tracer;
          }
        };
  }

  @After
  public void tearDown() {
    executor.shutdownNow();
  }

  private static MutationGroup mutationGroup(String id) {
    return MutationGroup.newBuilder()
        .addMutations(
            Mutation.newBuilder()
                .setInsert(
                    Mutation.Write.newBuilder()
                        .setTable("T")
                        .addColumns("K")
                        .addValues(
                            ListValue.newBuilder()
                                .addValues(Value.newBuilder().setStringValue(id).build())
                                .build())
                        .build())
                .build())
        .build();
  }

  private static BatchWriteRequest requestWithGroups(String... ids) {
    BatchWriteRequest.Builder builder =
        BatchWriteRequest.newBuilder()
            .setSession("projects/p/instances/i/databases/d/sessions/s1")
            .setRequestOptions(
                RequestOptions.newBuilder()
                    .setPriority(Priority.PRIORITY_HIGH)
                    .setTransactionTag("bw-tag")
                    .build())
            .setExcludeTxnFromChangeStreams(true);
    for (String id : ids) {
      builder.addMutationGroups(mutationGroup(id));
    }
    return builder.build();
  }

  private static BatchWriteResponse response(com.google.rpc.Status status, int... indexes) {
    BatchWriteResponse.Builder builder = BatchWriteResponse.newBuilder().setStatus(status);
    for (int idx : indexes) {
      builder.addIndexes(idx);
    }
    return builder.build();
  }

  private static ApiException apiException(Status.Code code, String msg, boolean retryable) {
    return ApiExceptionFactory.createException(msg, null, GrpcStatusCode.of(code), retryable);
  }

  private static RetrySettings fastRetrySettings(int maxAttempts) {
    return RetrySettings.newBuilder()
        .setInitialRetryDelayDuration(Duration.ofMillis(1))
        .setRetryDelayMultiplier(1.3)
        .setMaxRetryDelayDuration(Duration.ofMillis(5))
        .setMaxAttempts(maxAttempts)
        .setTotalTimeoutDuration(Duration.ofSeconds(30))
        .build();
  }

  private ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> wrapTraced(
      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner,
      RetrySettings retrySettings,
      Set<Code> retryableCodes,
      int numChannels,
      boolean grpcGcp) {
    return new BatchWriteResumingServerStreamingCallable(
        inner,
        retrySettings,
        retryableCodes,
        executor,
        clock,
        tracerFactory,
        numChannels,
        grpcGcp,
        () -> 1.0);
  }

  @Test
  public void emptyMutationGroupsShortCircuitsWithZeroRpcs() {
    AtomicInteger rpcCalls = new AtomicInteger();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            rpcCalls.incrementAndGet();
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            4,
            false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups(), GrpcCallContext.createDefault());
    List<BatchWriteResponse> responses = ImmutableList.copyOf(stream);

    assertThat(responses).isEmpty();
    assertEquals(0, rpcCalls.get());
    assertEquals(0, tracer.attemptsStarted.get());
  }

  @Test
  public void emptyServerStreamHelperCompletesImmediately() {
    ServerStream<BatchWriteResponse> stream =
        BatchWriteResumingServerStreamingCallable.emptyServerStream();
    assertThat(ImmutableList.copyOf(stream)).isEmpty();
  }

  @Test
  public void singleAttemptHappyPathWithOutOfOrderBatchedResponses() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 2, 0));
          obs.onResponse(response(OK_STATUS, 1));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            4,
            false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0", "g1", "g2"), GrpcCallContext.createDefault());
    List<BatchWriteResponse> responses = ImmutableList.copyOf(stream);

    assertThat(responses).hasSize(2);
    assertThat(responses.get(0).getIndexesList()).containsExactly(2, 0).inOrder();
    assertThat(responses.get(1).getIndexesList()).containsExactly(1);
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsStarted.get());
    assertEquals(1, tracer.attemptsSucceeded.get());
    assertEquals(1, tracer.operationSucceeded.get());
    assertEquals(SpanName.of("Spanner", "BatchWrite"), tracer.spanName);
  }

  @Test
  public void retriesMidStreamUnavailableAndTranslatesIndexesAcrossMultipleRetries() {
    ScriptedCallable inner = new ScriptedCallable();
    // Attempt 1: 4 groups [g0, g1, g2, g3]. Acks g1 (rel 1), fails UNAVAILABLE.
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 1));
          obs.onError(apiException(Status.Code.UNAVAILABLE, "reset 1", true));
        });
    // Attempt 2: remaining [g0, g2, g3]. Acks g3 (rel 2), fails RESOURCE_EXHAUSTED.
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 2));
          obs.onError(apiException(Status.Code.RESOURCE_EXHAUSTED, "throttled", true));
        });
    // Attempt 3: remaining [g0, g2]. Acks both (rel 1, rel 0) and completes.
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 1, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            4,
            false);

    BatchWriteRequest origReq = requestWithGroups("g0", "g1", "g2", "g3");
    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(callable.call(origReq, GrpcCallContext.createDefault()));

    assertThat(responses).hasSize(3);
    assertThat(responses.get(0).getIndexesList()).containsExactly(1);
    assertThat(responses.get(1).getIndexesList()).containsExactly(3);
    assertThat(responses.get(2).getIndexesList()).containsExactly(2, 0).inOrder();

    assertEquals(3, inner.requests.size());
    assertThat(inner.requests.get(0).getMutationGroupsList())
        .containsExactly(
            mutationGroup("g0"), mutationGroup("g1"), mutationGroup("g2"), mutationGroup("g3"))
        .inOrder();
    assertThat(inner.requests.get(1).getMutationGroupsList())
        .containsExactly(mutationGroup("g0"), mutationGroup("g2"), mutationGroup("g3"))
        .inOrder();
    assertThat(inner.requests.get(2).getMutationGroupsList())
        .containsExactly(mutationGroup("g0"), mutationGroup("g2"))
        .inOrder();
    // Metadata preserved across resumed requests.
    assertEquals(origReq.getRequestOptions(), inner.requests.get(2).getRequestOptions());
    assertTrue(inner.requests.get(2).getExcludeTxnFromChangeStreams());

    assertEquals(3, tracer.attemptsStarted.get());
    assertEquals(2, tracer.attemptsFailedDuration.get());
    assertEquals(1, tracer.attemptsSucceeded.get());
    assertEquals(1, tracer.operationSucceeded.get());
  }

  @Test
  public void nonOkTransactionLevelStatusIsAcknowledgedAndNeverResent() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(ABORTED_STATUS, 0));
          obs.onResponse(response(ALREADY_EXISTS_STATUS, 2));
          obs.onError(apiException(Status.Code.UNAVAILABLE, "dropped", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0", "g1", "g2"), GrpcCallContext.createDefault()));

    assertThat(responses).hasSize(3);
    assertEquals(ABORTED_STATUS, responses.get(0).getStatus());
    assertThat(responses.get(0).getIndexesList()).containsExactly(0);
    assertEquals(ALREADY_EXISTS_STATUS, responses.get(1).getStatus());
    assertThat(responses.get(1).getIndexesList()).containsExactly(2);
    assertEquals(OK_STATUS, responses.get(2).getStatus());
    assertThat(responses.get(2).getIndexesList()).containsExactly(1);

    // Only g1 was resent on attempt 2.
    assertEquals(2, inner.requests.size());
    assertThat(inner.requests.get(1).getMutationGroupsList()).containsExactly(mutationGroup("g1"));
  }

  @Test
  public void retriesRetryableInternalErrorsWhenUnavailableIsRetryable() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(
              apiException(
                  Status.Code.INTERNAL,
                  "Received unexpected EOS on DATA frame from server",
                  false));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.INTERNAL, "stream terminated by RST_STREAM", false));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault()));
    assertThat(responses).hasSize(1);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0);
    assertEquals(3, inner.requests.size());
  }

  @Test
  public void prematureStreamCloseTreatedAsRetryableUnavailable() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          // Closes cleanly without acknowledging index 1 or 2!
          obs.onComplete();
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0, 1));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0", "g1", "g2"), GrpcCallContext.createDefault()));

    assertThat(responses).hasSize(2);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0);
    assertThat(responses.get(1).getIndexesList()).containsExactly(1, 2).inOrder();
    assertEquals(2, inner.requests.size());
    assertThat(inner.requests.get(1).getMutationGroupsList())
        .containsExactly(mutationGroup("g1"), mutationGroup("g2"))
        .inOrder();
    assertEquals(1, tracer.attemptsFailedDuration.get());
    assertEquals(1, tracer.attemptsSucceeded.get());
  }

  @Test
  public void prematureStreamCloseFailsWhenRetriesExhausted() {
    ScriptedCallable inner = new ScriptedCallable();
    for (int i = 0; i < 3; i++) {
      inner.addScript(
          (req, obs, ctx) -> {
            obs.onStart(new NoopController());
            obs.onComplete();
          });
    }

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(3), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0", "g1"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.UNAVAILABLE, ex.getStatusCode().getCode());
    assertThat(ex.getMessage()).contains("prematurely");
    assertEquals(3, inner.requests.size());
    assertEquals(2, tracer.attemptsFailedDuration.get());
    assertEquals(1, tracer.attemptsRetriesExhausted.get());
    assertEquals(1, tracer.operationFailed.get());
  }

  @Test
  public void trailingErrorAfterAllGroupsAcknowledgedCompletesSuccessfully() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0, 1));
          obs.onError(apiException(Status.Code.UNAVAILABLE, "late drop", true));
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0", "g1"), GrpcCallContext.createDefault()));

    assertThat(responses).hasSize(1);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0, 1).inOrder();
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsSucceeded.get());
    assertEquals(1, tracer.operationSucceeded.get());
  }

  @Test
  public void outOfBoundsIndexFailsImmediatelyWithInternalAndDoesNotRetry() {
    for (int badIndex : new int[] {-1, 2, 10}) {
      tracer = new RecordingTracer();
      AtomicBoolean innerCancelled = new AtomicBoolean();
      ScriptedCallable inner = new ScriptedCallable();
      inner.addScript(
          (req, obs, ctx) -> {
            obs.onStart(
                new NoopController() {
                  @Override
                  public void cancel() {
                    innerCancelled.set(true);
                  }
                });
            obs.onResponse(response(OK_STATUS, 0, badIndex));
          });

      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
          wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

      ServerStream<BatchWriteResponse> stream =
          callable.call(requestWithGroups("g0", "g1"), GrpcCallContext.createDefault());
      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.INTERNAL, ex.getStatusCode().getCode());
      assertTrue(innerCancelled.get());
      assertEquals(1, inner.requests.size());
      assertEquals(1, tracer.attemptsPermanentFailure.get());
      assertEquals(1, tracer.operationFailed.get());
    }
  }

  @Test
  public void duplicateIndexesTranslatedAndDecrementedOnlyOnce() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0, 0));
          obs.onError(apiException(Status.Code.UNAVAILABLE, "dropped", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0", "g1"), GrpcCallContext.createDefault()));

    assertThat(responses).hasSize(2);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0, 0).inOrder();
    assertThat(responses.get(1).getIndexesList()).containsExactly(1);
    assertEquals(2, inner.requests.size());
    assertThat(inner.requests.get(1).getMutationGroupsList()).containsExactly(mutationGroup("g1"));
  }

  @Test
  public void nonRetryableErrorFailsImmediatelyWithoutRetry() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.PERMISSION_DENIED, "forbidden", false));
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            2,
            false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.PERMISSION_DENIED, ex.getStatusCode().getCode());
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsPermanentFailure.get());
    assertEquals(1, tracer.operationFailed.get());
  }

  @Test
  public void maxAttemptsOneDisablesRetries() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(1), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.UNAVAILABLE, ex.getStatusCode().getCode());
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsRetriesExhausted.get());
    assertEquals(0, tracer.attemptsPermanentFailure.get());
  }

  @Test
  public void emptyRetryableCodesDisablesRetriesIncludingRetryableInternal() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.INTERNAL, "stream terminated by RST_STREAM", false));
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), Collections.emptySet(), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.INTERNAL, ex.getStatusCode().getCode());
    assertEquals(1, inner.requests.size());
  }

  @Test
  public void retryInfoDelayIsHonoredOverExponentialBackoff() {
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setNanos(25_000_000).build())
            .build();
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(ImmutableList.of(Any.pack(retryInfo))).build();
    ApiException errWithRetryInfo =
        ApiExceptionFactory.createException(
            "throttled",
            null,
            GrpcStatusCode.of(Status.Code.RESOURCE_EXHAUSTED),
            true,
            errorDetails);

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(errWithRetryInfo);
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    RetrySettings slowBackoff =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(10))
            .setRetryDelayMultiplier(2.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(60))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofSeconds(30))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            slowBackoff,
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            2,
            false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault()));
    assertThat(responses).hasSize(1);
    assertThat(tracer.recordedRetryDelays).containsExactly(Duration.ofMillis(25));
  }

  @Test
  public void retryInfoFromGrpcTrailersIsHonored() {
    Metadata trailers = new Metadata();
    trailers.put(
        ProtoUtils.keyForProto(RetryInfo.getDefaultInstance()),
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setNanos(15_000_000).build())
            .build());
    ApiException errWithTrailer =
        ApiExceptionFactory.createException(
            "unavailable with trailer",
            Status.UNAVAILABLE.asRuntimeException(trailers),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            true);

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(errWithTrailer);
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    RetrySettings slowBackoff =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(10))
            .setRetryDelayMultiplier(2.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(60))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofSeconds(30))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, slowBackoff, ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault()));
    assertThat(responses).hasSize(1);
    assertThat(tracer.recordedRetryDelays).containsExactly(Duration.ofMillis(15));
  }

  @Test
  public void retryInfoExceedingTotalTimeoutFailsImmediatelyWithDeadlineExceeded() {
    RetryInfo largeRetryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setSeconds(5).build())
            .build();
    ErrorDetails errorDetails =
        ErrorDetails.builder()
            .setRawErrorMessages(ImmutableList.of(Any.pack(largeRetryInfo)))
            .build();
    ApiException errWithLargeDelay =
        ApiExceptionFactory.createException(
            "throttled",
            null,
            GrpcStatusCode.of(Status.Code.RESOURCE_EXHAUSTED),
            true,
            errorDetails);

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(errWithLargeDelay);
        });

    RetrySettings shortTotalTimeout =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(10))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(10))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofSeconds(1))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            shortTotalTimeout,
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            2,
            false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsRetriesExhausted.get());
  }

  @Test
  public void retryInfoExceedingContextDeadlineFailsImmediatelyWithDeadlineExceeded() {
    RetryInfo largeRetryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setSeconds(30).build())
            .build();
    ErrorDetails errorDetails =
        ErrorDetails.builder()
            .setRawErrorMessages(ImmutableList.of(Any.pack(largeRetryInfo)))
            .build();
    ApiException errWithLargeDelay =
        ApiExceptionFactory.createException(
            "throttled",
            null,
            GrpcStatusCode.of(Status.Code.RESOURCE_EXHAUSTED),
            true,
            errorDetails);

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(errWithLargeDelay);
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            2,
            false);

    Context.CancellableContext deadlineCtx =
        Context.current().withDeadlineAfter(5, TimeUnit.SECONDS, executor);
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = deadlineCtx.attach();
      try {
        stream = callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        deadlineCtx.detach(prev);
      }
      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
      assertEquals(1, inner.requests.size());
      assertEquals(1, tracer.attemptsRetriesExhausted.get());
    } finally {
      deadlineCtx.close();
    }
  }

  @Test
  public void callOptionsDeadlineExceededDuringBackoffFailsImmediatelyWithDeadlineExceeded() {
    RetryInfo largeRetryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setSeconds(60).build())
            .build();
    ErrorDetails errorDetails =
        ErrorDetails.builder()
            .setRawErrorMessages(ImmutableList.of(Any.pack(largeRetryInfo)))
            .build();
    ApiException errWithLargeDelay =
        ApiExceptionFactory.createException(
            "resource exhausted",
            null,
            GrpcStatusCode.of(Status.Code.RESOURCE_EXHAUSTED),
            true,
            errorDetails);

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(errWithLargeDelay);
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED),
            2,
            false);

    GrpcCallContext ctx =
        GrpcCallContext.createDefault()
            .withCallOptions(CallOptions.DEFAULT.withDeadlineAfter(5, TimeUnit.SECONDS));

    long startNanos = System.nanoTime();
    ServerStream<BatchWriteResponse> stream = callable.call(requestWithGroups("g0"), ctx);
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);

    assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
    assertThat(elapsedMillis).isLessThan(2000L);
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsRetriesExhausted.get());
    assertEquals(1, tracer.operationFailed.get());
  }

  @Test
  public void corruptedRetryInfoTrailerFallsBackToExponentialBackoff() {
    Metadata trailers = new Metadata();
    trailers.put(
        Metadata.Key.of("google.rpc.retryinfo-bin", Metadata.BINARY_BYTE_MARSHALLER),
        new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
    ApiException errWithCorruptedTrailer =
        ApiExceptionFactory.createException(
            "unavailable with corrupted trailer",
            Status.UNAVAILABLE.asRuntimeException(trailers),
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            true);

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(errWithCorruptedTrailer);
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(7))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(7))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofSeconds(30))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, retrySettings, ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault()));
    assertThat(responses).hasSize(1);
    assertThat(tracer.recordedRetryDelays).containsExactly(Duration.ofMillis(7));
  }

  @Test
  public void totalTimeoutExceededFailsWithDeadlineExceeded() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          clock.advanceMillis(500);
          obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
        });

    RetrySettings shortTimeout =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(600))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(600))
            .setMaxAttempts(10)
            .setTotalTimeoutDuration(Duration.ofMillis(1000))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, shortTimeout, ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsRetriesExhausted.get());
  }

  @Test
  public void lateBackoffWakeUpPastTotalTimeoutFailsWithoutSendingSpuriousRpc() {
    ApiException rootCause = apiException(Status.Code.UNAVAILABLE, "transient failure", true);
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          // Advance to 800ms of a 1000ms total timeout; 100ms backoff fits within budget when
          // scheduled, then scheduler jitter pushes elapsed time past 1000ms before wake-up.
          clock.advanceMillis(800);
          obs.onError(rootCause);
        });

    // ScheduledExecutorService wrapper that simulates 250ms of scheduler jitter during backoff.
    ScheduledExecutorService jitteryExecutor =
        new java.util.concurrent.ScheduledThreadPoolExecutor(1) {
          @Override
          public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            return super.schedule(
                () -> {
                  clock.advanceMillis(250);
                  command.run();
                },
                5L,
                TimeUnit.MILLISECONDS);
          }
        };

    try {
      RetrySettings retrySettings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100))
              .setRetryDelayMultiplier(1.0)
              .setMaxRetryDelayDuration(Duration.ofMillis(100))
              .setMaxAttempts(5)
              .setTotalTimeoutDuration(Duration.ofMillis(1000))
              .build();

      BatchWriteResumingServerStreamingCallable callable =
          new BatchWriteResumingServerStreamingCallable(
              inner,
              retrySettings,
              ImmutableSet.of(Code.UNAVAILABLE),
              jitteryExecutor,
              clock,
              tracerFactory,
              2,
              false,
              () -> 1.0);

      AtomicInteger resumeCallbacks = new AtomicInteger();
      AtomicReference<Throwable> completedError = new AtomicReference<>();
      GrpcCallContext ctx =
          GrpcCallContext.createDefault()
              .withCallOptions(
                  CallOptions.DEFAULT.withOption(
                      BatchWriteResumingServerStreamingCallable.LIFECYCLE_LISTENER_KEY,
                      new BatchWriteResumingServerStreamingCallable.StreamLifecycleListener() {
                        @Override
                        public void onResume(int oneBasedAttempt, int remainingMutationGroups) {
                          resumeCallbacks.incrementAndGet();
                        }

                        @Override
                        public void onComplete(Throwable error) {
                          completedError.set(error);
                        }
                      }));

      ServerStream<BatchWriteResponse> stream = callable.call(requestWithGroups("g0"), ctx);
      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));

      assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
      assertSame(rootCause, ex.getCause());
      assertEquals(1, inner.requests.size());
      assertEquals(0, resumeCallbacks.get());
      assertEquals(1, tracer.attemptsStarted.get());
      assertEquals(1, tracer.attemptsFailedDuration.get());
      assertEquals(0, tracer.attemptsPermanentFailure.get());
      assertEquals(1, tracer.operationFailed.get());
      assertSame(ex, completedError.get());
    } finally {
      jitteryExecutor.shutdownNow();
    }
  }

  @Test
  public void channelAffinityRotatesAcrossRetriesAndUpdatesRequestId() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "drop 1", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "drop 2", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 4, false);

    XGoogSpannerRequestId requestId = XGoogSpannerRequestId.of(1, 1, 1, 0);
    GrpcCallContext ctx =
        GrpcCallContext.createDefault()
            .withChannelAffinity(1)
            .withCallOptions(
                CallOptions.DEFAULT.withOption(REQUEST_ID_CALL_OPTIONS_KEY, requestId));

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(callable.call(requestWithGroups("g0"), ctx));
    assertThat(responses).hasSize(1);
    assertEquals(3, inner.contexts.size());

    int ch0 = ((GrpcCallContext) inner.contexts.get(0)).getChannelAffinity();
    int ch1 = ((GrpcCallContext) inner.contexts.get(1)).getChannelAffinity();
    int ch2 = ((GrpcCallContext) inner.contexts.get(2)).getChannelAffinity();
    assertEquals(1, ch0);
    assertEquals(2, ch1);
    assertEquals(3, ch2);
    assertNotEquals(ch0, ch1);
    assertNotEquals(ch1, ch2);
  }

  private static boolean isUseDifferentChannelFlagSet(GcpManagedChannel.ChannelAffinityRef ref) {
    try {
      java.lang.reflect.Field stateField =
          GcpManagedChannel.ChannelAffinityRef.class.getDeclaredField("state");
      stateField.setAccessible(true);
      AtomicInteger state = (AtomicInteger) stateField.get(ref);
      // USE_DIFFERENT_CHANNEL_ON_NEXT_CALL_MASK is the sign bit (Integer.MIN_VALUE).
      return state.get() < 0;
    } catch (ReflectiveOperationException e) {
      throw new AssertionError("Failed to inspect ChannelAffinityRef state", e);
    }
  }

  @Test
  public void grpcGcpChannelAffinityRefRotatedOnRetry() {
    List<Boolean> flagSetAtAttemptStart = new ArrayList<>();
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          GcpManagedChannel.ChannelAffinityRef ref =
              ((GrpcCallContext) ctx)
                  .getCallOptions()
                  .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
          flagSetAtAttemptStart.add(isUseDifferentChannelFlagSet(ref));
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "drop", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          GcpManagedChannel.ChannelAffinityRef ref =
              ((GrpcCallContext) ctx)
                  .getCallOptions()
                  .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
          flagSetAtAttemptStart.add(isUseDifferentChannelFlagSet(ref));
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 4, true);

    GcpManagedChannel.ChannelAffinityRef initialRef = new GcpManagedChannel.ChannelAffinityRef();
    GrpcCallContext ctx =
        GrpcCallContext.createDefault()
            .withCallOptions(
                CallOptions.DEFAULT.withOption(
                    GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY, initialRef));

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(callable.call(requestWithGroups("g0"), ctx));
    assertThat(responses).hasSize(1);
    GcpManagedChannel.ChannelAffinityRef attempt0Ref =
        ((GrpcCallContext) inner.contexts.get(0))
            .getCallOptions()
            .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
    GcpManagedChannel.ChannelAffinityRef attempt1Ref =
        ((GrpcCallContext) inner.contexts.get(1))
            .getCallOptions()
            .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
    assertSame(initialRef, attempt0Ref);
    assertSame(initialRef, attempt1Ref);
    assertThat(flagSetAtAttemptStart).containsExactly(false, true).inOrder();
  }

  @Test
  public void grpcGcpChannelAffinityRefCreatedAndRotatedWhenBaseContextHasNone() {
    List<Boolean> flagSetAtAttemptStart = new ArrayList<>();
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          GcpManagedChannel.ChannelAffinityRef ref =
              ((GrpcCallContext) ctx)
                  .getCallOptions()
                  .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
          assertThat(ref).isNotNull();
          flagSetAtAttemptStart.add(isUseDifferentChannelFlagSet(ref));
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "drop", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          GcpManagedChannel.ChannelAffinityRef ref =
              ((GrpcCallContext) ctx)
                  .getCallOptions()
                  .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
          assertThat(ref).isNotNull();
          flagSetAtAttemptStart.add(isUseDifferentChannelFlagSet(ref));
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 4, true);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault()));
    assertThat(responses).hasSize(1);
    GcpManagedChannel.ChannelAffinityRef attempt0Ref =
        ((GrpcCallContext) inner.contexts.get(0))
            .getCallOptions()
            .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
    GcpManagedChannel.ChannelAffinityRef attempt1Ref =
        ((GrpcCallContext) inner.contexts.get(1))
            .getCallOptions()
            .getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY);
    assertThat(attempt0Ref).isNotNull();
    assertSame(attempt0Ref, attempt1Ref);
    assertThat(flagSetAtAttemptStart).containsExactly(false, true).inOrder();
  }

  @Test
  public void manualFlowControlBackpressurePreservedAcrossRetries() {
    // Inner callable honors manual request(n) calls and only emits responses when requested.
    AtomicInteger attempt = new AtomicInteger();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> manualFlowCallable =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            int current = attempt.incrementAndGet();
            Queue<BatchWriteResponse> toEmit = new ArrayDeque<>();
            if (current == 1) {
              toEmit.add(response(OK_STATUS, 0));
            } else {
              toEmit.add(response(OK_STATUS, 0));
              toEmit.add(response(OK_STATUS, 1));
            }
            AtomicBoolean manual = new AtomicBoolean();
            obs.onStart(
                new StreamController() {
                  @Override
                  public void cancel() {}

                  @Override
                  public void disableAutoInboundFlowControl() {
                    manual.set(true);
                  }

                  @Override
                  public void request(int count) {
                    assertTrue("Expected manual flow control", manual.get());
                    for (int i = 0; i < count; i++) {
                      BatchWriteResponse next = toEmit.poll();
                      if (next != null) {
                        obs.onResponse(next);
                      }
                      if (toEmit.isEmpty()) {
                        if (current == 1) {
                          obs.onError(apiException(Status.Code.UNAVAILABLE, "mid-stream", true));
                        } else {
                          obs.onComplete();
                        }
                        break;
                      }
                    }
                  }
                });
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            manualFlowCallable, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0", "g1", "g2"), GrpcCallContext.createDefault());
    List<BatchWriteResponse> results = new ArrayList<>();
    for (BatchWriteResponse r : stream) {
      results.add(r);
    }

    assertThat(results).hasSize(3);
    assertThat(results.get(0).getIndexesList()).containsExactly(0);
    assertThat(results.get(1).getIndexesList()).containsExactly(1);
    assertThat(results.get(2).getIndexesList()).containsExactly(2);
    assertEquals(2, attempt.get());
  }

  @Test
  public void customManualFlowControlAccumulatesAndReappliesDemandAcrossReconnect()
      throws Exception {
    AtomicInteger attempt = new AtomicInteger();
    List<Integer> attempt1Requests = new CopyOnWriteArrayList<>();
    List<Integer> attempt2Requests = new CopyOnWriteArrayList<>();
    CountDownLatch attempt1Failed = new CountDownLatch(1);
    CountDownLatch allowAttempt2 = new CountDownLatch(1);
    CountDownLatch completed = new CountDownLatch(1);
    List<BatchWriteResponse> received = new CopyOnWriteArrayList<>();
    AtomicReference<Throwable> terminalError = new AtomicReference<>();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            int current = attempt.incrementAndGet();
            if (current == 1) {
              obs.onStart(
                  new StreamController() {
                    @Override
                    public void cancel() {}

                    @Override
                    public void disableAutoInboundFlowControl() {}

                    @Override
                    public void request(int count) {
                      attempt1Requests.add(count);
                      // Deliver only 1 response out of the requested 3, then fail mid-stream.
                      obs.onResponse(response(OK_STATUS, 0));
                      obs.onError(apiException(Status.Code.UNAVAILABLE, "mid-stream drop", true));
                      attempt1Failed.countDown();
                    }
                  });
            } else {
              try {
                assertTrue(allowAttempt2.await(5, TimeUnit.SECONDS));
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
              }
              Queue<BatchWriteResponse> remainingResponses = new ArrayDeque<>();
              remainingResponses.add(response(OK_STATUS, 0));
              remainingResponses.add(response(OK_STATUS, 1));
              remainingResponses.add(response(OK_STATUS, 2));
              remainingResponses.add(response(OK_STATUS, 3));
              obs.onStart(
                  new StreamController() {
                    @Override
                    public void cancel() {}

                    @Override
                    public void disableAutoInboundFlowControl() {}

                    @Override
                    public void request(int count) {
                      attempt2Requests.add(count);
                      for (int i = 0; i < count; i++) {
                        BatchWriteResponse next = remainingResponses.poll();
                        if (next != null) {
                          obs.onResponse(next);
                        }
                        if (remainingResponses.isEmpty()) {
                          obs.onComplete();
                          break;
                        }
                      }
                    }
                  });
            }
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    AtomicReference<StreamController> outerController = new AtomicReference<>();
    callable.call(
        requestWithGroups("g0", "g1", "g2", "g3", "g4"),
        new ResponseObserver<BatchWriteResponse>() {
          @Override
          public void onStart(StreamController controller) {
            outerController.set(controller);
            controller.disableAutoInboundFlowControl();
            // Request 3 initially; attempt 1 delivers 1 and fails -> remaining demand is 2.
            controller.request(3);
          }

          @Override
          public void onResponse(BatchWriteResponse response) {
            received.add(response);
          }

          @Override
          public void onError(Throwable t) {
            terminalError.set(t);
            completed.countDown();
          }

          @Override
          public void onComplete() {
            completed.countDown();
          }
        },
        GrpcCallContext.createDefault());

    assertTrue(attempt1Failed.await(5, TimeUnit.SECONDS));
    // Issue an additional request(2) while disconnected before attempt 2 starts.
    // Remaining demand (2) + additional request (2) = 4 must be re-applied to attempt 2.
    outerController.get().request(2);
    allowAttempt2.countDown();

    assertTrue(completed.await(5, TimeUnit.SECONDS));
    assertThat(terminalError.get()).isNull();
    assertThat(attempt1Requests).containsExactly(3);
    assertThat(attempt2Requests).containsExactly(4);
    assertThat(received).hasSize(5);
    assertThat(received.get(0).getIndexesList()).containsExactly(0);
    assertThat(received.get(1).getIndexesList()).containsExactly(1);
    assertThat(received.get(2).getIndexesList()).containsExactly(2);
    assertThat(received.get(3).getIndexesList()).containsExactly(3);
    assertThat(received.get(4).getIndexesList()).containsExactly(4);
  }

  @Test
  public void manualFlowControlClampsRequestIncrementAtMaxValue() {
    List<Integer> forwardedCounts = new CopyOnWriteArrayList<>();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            obs.onStart(
                new StreamController() {
                  @Override
                  public void cancel() {}

                  @Override
                  public void disableAutoInboundFlowControl() {}

                  @Override
                  public void request(int count) {
                    forwardedCounts.add(count);
                  }
                });
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    AtomicReference<StreamController> outerController = new AtomicReference<>();
    callable.call(
        requestWithGroups("g0"),
        new ResponseObserver<BatchWriteResponse>() {
          @Override
          public void onStart(StreamController controller) {
            outerController.set(controller);
            controller.disableAutoInboundFlowControl();
          }

          @Override
          public void onResponse(BatchWriteResponse response) {}

          @Override
          public void onError(Throwable t) {}

          @Override
          public void onComplete() {}
        },
        GrpcCallContext.createDefault());

    outerController.get().request(Integer.MAX_VALUE - 2);
    outerController.get().request(10); // Clamped to 2
    outerController.get().request(5); // Already at MAX_VALUE -> inc == 0, should not forward

    assertThat(forwardedCounts).containsExactly(Integer.MAX_VALUE - 2, 2).inOrder();
  }

  @Test
  public void earlyCancelDuringActiveStreamCancelsInnerAndRecordsCancelled() {
    AtomicBoolean innerCancelled = new AtomicBoolean();
    AtomicReference<ResponseObserver<BatchWriteResponse>> activeObs = new AtomicReference<>();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            activeObs.set(obs);
            obs.onStart(
                new StreamController() {
                  @Override
                  public void cancel() {
                    innerCancelled.set(true);
                    obs.onError(new CancellationException("cancelled"));
                  }

                  @Override
                  public void disableAutoInboundFlowControl() {}

                  @Override
                  public void request(int count) {
                    if (!innerCancelled.get()) {
                      obs.onResponse(response(OK_STATUS, 0));
                    }
                  }
                });
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0", "g1"), GrpcCallContext.createDefault());
    Iterator<BatchWriteResponse> it = stream.iterator();
    assertTrue(it.hasNext());
    assertThat(it.next().getIndexesList()).containsExactly(0);

    stream.cancel();
    assertFalse(it.hasNext());
    assertTrue(innerCancelled.get());
    assertEquals(1, tracer.attemptsCancelled.get());
    assertEquals(1, tracer.operationCancelled.get());
  }

  @Test
  public void earlyCancelDuringBackoffCancelsRetryTimerAndRecordsCancelled() throws Exception {
    CountDownLatch firstAttemptFailed = new CountDownLatch(1);
    AtomicInteger rpcCalls = new AtomicInteger();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            rpcCalls.incrementAndGet();
            obs.onStart(new NoopController());
            obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
            firstAttemptFailed.countDown();
          }
        };

    RetrySettings longBackoff =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(30))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(30))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofMinutes(5))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, longBackoff, ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    assertTrue(firstAttemptFailed.await(5, TimeUnit.SECONDS));

    stream.cancel();
    assertFalse(stream.iterator().hasNext());
    assertEquals(1, rpcCalls.get());
    assertEquals(1, tracer.attemptsFailedDuration.get());
    assertEquals(0, tracer.attemptsCancelled.get());
    assertEquals(1, tracer.operationCancelled.get());
  }

  @Test
  public void grpcContextCancellationCancelsDuringBackoff() throws Exception {
    CountDownLatch firstAttemptFailed = new CountDownLatch(1);
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            obs.onStart(new NoopController());
            obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
            firstAttemptFailed.countDown();
          }
        };

    RetrySettings longBackoff =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(30))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(30))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofMinutes(5))
            .build();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, longBackoff, ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    Context.CancellableContext cancellable = Context.current().withCancellation();
    ServerStream<BatchWriteResponse> stream;
    Context prev = cancellable.attach();
    try {
      stream = callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    } finally {
      cancellable.detach(prev);
    }

    assertTrue(firstAttemptFailed.await(5, TimeUnit.SECONDS));
    cancellable.cancel(null);

    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.CANCELLED, ex.getStatusCode().getCode());
    assertEquals(1, tracer.operationCancelled.get());
    assertEquals(0, tracer.operationFailed.get());
  }

  @Test
  public void cancelAllTerminatesActiveStreamAndPendingBackoffRetryTimers() throws Exception {
    AtomicBoolean activeInnerCancelled = new AtomicBoolean();
    CountDownLatch backoffScheduled = new CountDownLatch(1);
    AtomicInteger attemptCalls = new AtomicInteger();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            int callNum = attemptCalls.incrementAndGet();
            if (callNum == 1) {
              // Stream 1 stays open (simulates abandoned active gRPC stream).
              obs.onStart(
                  new StreamController() {
                    @Override
                    public void cancel() {
                      activeInnerCancelled.set(true);
                      obs.onError(apiException(Status.Code.CANCELLED, "cancelled", false));
                    }

                    @Override
                    public void disableAutoInboundFlowControl() {}

                    @Override
                    public void request(int count) {}
                  });
            } else {
              // Stream 2 fails transiently and enters a 30s backoff timer.
              obs.onStart(new NoopController());
              obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
              backoffScheduled.countDown();
            }
          }
        };

    RetrySettings longBackoff =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(30))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(30))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofMinutes(5))
            .build();

    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            longBackoff,
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0);

    // Start two streams and abandon them without reading or calling cancel().
    ServerStream<BatchWriteResponse> abandonedActive =
        resuming.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ServerStream<BatchWriteResponse> abandonedBackoff =
        resuming.call(requestWithGroups("g1"), GrpcCallContext.createDefault());

    assertTrue(backoffScheduled.await(5, TimeUnit.SECONDS));
    assertEquals(2, resuming.getActiveStreamCount());

    resuming.cancelAll();

    assertEquals(0, resuming.getActiveStreamCount());
    assertTrue(activeInnerCancelled.get());
    assertEquals(
        Code.CANCELLED,
        assertThrows(ApiException.class, () -> ImmutableList.copyOf(abandonedActive))
            .getStatusCode()
            .getCode());
    assertEquals(
        Code.CANCELLED,
        assertThrows(ApiException.class, () -> ImmutableList.copyOf(abandonedBackoff))
            .getStatusCode()
            .getCode());
    assertEquals(2, attemptCalls.get());
    assertEquals(1, tracer.attemptsCancelled.get());
    assertEquals(2, tracer.operationCancelled.get());
    assertEquals(0, tracer.operationFailed.get());
  }

  private static WatchdogTimeoutException watchdogTimeout(boolean retryable) {
    try {
      Constructor<WatchdogTimeoutException> ctor =
          WatchdogTimeoutException.class.getDeclaredConstructor(String.class, boolean.class);
      ctor.setAccessible(true);
      return ctor.newInstance(retryable ? "wait timeout" : "idle timeout", retryable);
    } catch (ReflectiveOperationException e) {
      throw new AssertionError("Failed to construct WatchdogTimeoutException", e);
    }
  }

  @Test
  public void watchdogIdleTimeoutIsNeverRetriedEvenWhenAbortedIsRetryable() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(watchdogTimeout(false));
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(
            inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE, Code.ABORTED), 2, false);

    ServerStream<BatchWriteResponse> stream =
        callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    WatchdogTimeoutException ex =
        assertThrows(WatchdogTimeoutException.class, () -> ImmutableList.copyOf(stream));
    assertFalse(ex.isRetryable());
    assertEquals(1, inner.requests.size());
    assertEquals(1, tracer.attemptsPermanentFailure.get());
    assertEquals(1, tracer.operationFailed.get());
  }

  @Test
  public void watchdogWaitTimeoutIsRetriedWhenRetriesEnabled() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(watchdogTimeout(true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(
            callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault()));
    assertThat(responses).hasSize(1);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0);
    assertEquals(2, inner.requests.size());
  }

  @Test
  public void rejectedExecutionDuringRetryScheduleTerminatesCleanly() {
    ScheduledExecutorService shutdownExecutor = Executors.newSingleThreadScheduledExecutor();
    shutdownExecutor.shutdownNow();

    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
        });

    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            shutdownExecutor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0);

    ServerStream<BatchWriteResponse> stream =
        resuming.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
    ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
    assertEquals(Code.CANCELLED, ex.getStatusCode().getCode());
    assertEquals(0, resuming.getActiveStreamCount());
    assertEquals(1, tracer.operationCancelled.get());
    assertEquals(0, tracer.operationFailed.get());
  }

  private static void startStreamAndCaptureWeakRefs(
      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable,
      ResponseObserver<BatchWriteResponse> outerObserver,
      List<WeakReference<?>> weakRefsOut) {
    MutationGroup g0 = mutationGroup("g0");
    MutationGroup g1 = mutationGroup("g1");
    BatchWriteRequest initial =
        BatchWriteRequest.newBuilder()
            .setSession("projects/p/instances/i/databases/d/sessions/s1")
            .setRequestOptions(
                RequestOptions.newBuilder()
                    .setPriority(Priority.PRIORITY_HIGH)
                    .setTransactionTag("gc-tag")
                    .build())
            .setExcludeTxnFromChangeStreams(true)
            .addMutationGroups(g0)
            .addMutationGroups(g1)
            .build();
    weakRefsOut.add(new WeakReference<>(initial));
    weakRefsOut.add(new WeakReference<>(g0));
    weakRefsOut.add(new WeakReference<>(g1));
    // Dispatch attempt 0 inside this helper frame so no strong reference to initial or g0 remains
    // on the test method's stack once this frame returns.
    callable.call(initial, outerObserver, GrpcCallContext.createDefault());
  }

  @Test
  public void acknowledgedMutationGroupsAreEligibleForGcMidStream() throws Exception {
    AtomicInteger attemptCalls = new AtomicInteger();
    AtomicReference<ResponseObserver<BatchWriteResponse>> attempt1Observer =
        new AtomicReference<>();
    AtomicReference<BatchWriteRequest> retryRequest = new AtomicReference<>();
    CountDownLatch completed = new CountDownLatch(1);
    List<BatchWriteResponse> received = new CopyOnWriteArrayList<>();
    AtomicReference<Throwable> terminalError = new AtomicReference<>();

    // Do not retain attempt 0's BatchWriteRequest in the inner callable so GC eligibility reflects
    // only what BatchWriteStreamCoordinator / BatchWriteResumptionState hold.
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            int attempt = attemptCalls.incrementAndGet();
            if (attempt == 1) {
              assertEquals(2, req.getMutationGroupsCount());
              attempt1Observer.set(obs);
              obs.onStart(new NoopController());
              // Acknowledge group 0 mid-stream while leaving the stream open with group 1 pending.
              obs.onResponse(response(OK_STATUS, 0));
            } else {
              retryRequest.set(req);
              obs.onStart(new NoopController());
              obs.onResponse(response(OK_STATUS, 0));
              obs.onComplete();
            }
          }
        };

    BatchWriteResumingServerStreamingCallable callable =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0);

    ResponseObserver<BatchWriteResponse> outerObserver =
        new ResponseObserver<BatchWriteResponse>() {
          @Override
          public void onStart(StreamController controller) {}

          @Override
          public void onResponse(BatchWriteResponse response) {
            received.add(response);
          }

          @Override
          public void onError(Throwable t) {
            terminalError.set(t);
            completed.countDown();
          }

          @Override
          public void onComplete() {
            completed.countDown();
          }
        };

    List<WeakReference<?>> weakRefs = new ArrayList<>();
    startStreamAndCaptureWeakRefs(callable, outerObserver, weakRefs);
    WeakReference<?> weakInitial = weakRefs.get(0);
    WeakReference<?> weakG0 = weakRefs.get(1);
    WeakReference<?> weakG1 = weakRefs.get(2);

    assertEquals(1, attemptCalls.get());
    assertThat(received).hasSize(1);
    assertThat(received.get(0).getIndexesList()).containsExactly(0);

    // Trigger GC while attempt 1 is still open: neither BatchWriteStreamCoordinator nor
    // BatchWriteResumptionState may strongly retain initialRequest or acknowledged group 0.
    for (int i = 0; i < 40 && (weakInitial.get() != null || weakG0.get() != null); i++) {
      System.gc();
      Thread.sleep(25);
    }
    assertThat(weakInitial.get()).isNull();
    assertThat(weakG0.get()).isNull();
    assertThat(weakG1.get()).isNotNull();

    // Fail attempt 1 mid-stream and verify attempt 2 resumes with only group 1 + template fields.
    attempt1Observer.get().onError(apiException(Status.Code.UNAVAILABLE, "mid-stream reset", true));
    assertTrue(completed.await(5, TimeUnit.SECONDS));
    assertThat(terminalError.get()).isNull();
    assertEquals(2, attemptCalls.get());
    assertEquals(0, callable.getActiveStreamCount());
    assertThat(received).hasSize(2);
    assertThat(received.get(1).getIndexesList()).containsExactly(1);

    BatchWriteRequest retryReq = retryRequest.get();
    assertThat(retryReq).isNotNull();
    assertEquals("projects/p/instances/i/databases/d/sessions/s1", retryReq.getSession());
    assertEquals(Priority.PRIORITY_HIGH, retryReq.getRequestOptions().getPriority());
    assertEquals("gc-tag", retryReq.getRequestOptions().getTransactionTag());
    assertTrue(retryReq.getExcludeTxnFromChangeStreams());
    assertEquals(1, retryReq.getMutationGroupsCount());
    assertEquals(mutationGroup("g1"), retryReq.getMutationGroups(0));
  }

  @Test
  public void perCallApiCallContextOverridesRetrySettingsRetryableCodesAndTimeout() {
    ScriptedCallable inner = new ScriptedCallable();
    // Attempt 1 & 2 fail with ABORTED (not in default retryable codes; attempt 3 exceeds default
    // maxAttempts=2), then attempt 3 succeeds.
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.ABORTED, "aborted 1", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.ABORTED, "aborted 2", true));
        });
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onResponse(response(OK_STATUS, 0));
          obs.onComplete();
        });

    RetrySettings defaultSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(10))
            .setRetryDelayMultiplier(2.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(30))
            .setMaxAttempts(2)
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(60))
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
            .setTotalTimeoutDuration(Duration.ofSeconds(60))
            .build();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, defaultSettings, ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    RetrySettings overrideSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofMillis(1))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofMillis(2))
            .setMaxAttempts(4)
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(30))
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(30))
            .setTotalTimeoutDuration(Duration.ofSeconds(20))
            .build();
    ApiCallContext perCallContext =
        GrpcCallContext.createDefault()
            .withRetrySettings(overrideSettings)
            .withRetryableCodes(ImmutableSet.of(Code.ABORTED))
            .withTimeoutDuration(Duration.ofSeconds(5));

    List<BatchWriteResponse> responses =
        ImmutableList.copyOf(callable.call(requestWithGroups("g0"), perCallContext));
    assertThat(responses).hasSize(1);
    assertThat(responses.get(0).getIndexesList()).containsExactly(0);
    assertEquals(3, inner.requests.size());
    for (ApiCallContext attemptCtx : inner.contexts) {
      assertEquals(Duration.ofSeconds(5), attemptCtx.getTimeoutDuration());
    }
    assertThat(tracer.recordedRetryDelays).hasSize(2);
    for (Duration delay : tracer.recordedRetryDelays) {
      assertTrue(
          "Expected override retry delay <= 2ms, got " + delay,
          delay.compareTo(Duration.ofMillis(2)) <= 0);
    }

    // Conversely, a code in defaultRetryableCodes (UNAVAILABLE) must NOT be retried when the
    // per-call override replaces retryableCodes with ABORTED only.
    ScriptedCallable inner2 = new ScriptedCallable();
    inner2.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "not in override", true));
        });
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable2 =
        wrapTraced(inner2, defaultSettings, ImmutableSet.of(Code.UNAVAILABLE), 2, false);
    ApiException ex =
        assertThrows(
            ApiException.class,
            () ->
                ImmutableList.copyOf(
                    callable2.call(
                        requestWithGroups("g0"),
                        GrpcCallContext.createDefault()
                            .withRetryableCodes(ImmutableSet.of(Code.ABORTED)))));
    assertEquals(Code.UNAVAILABLE, ex.getStatusCode().getCode());
    assertEquals(1, inner2.requests.size());
  }

  @Test
  public void
      grpcContextDeadlineExpiredMidStreamRecordsDeadlineExceededInAttemptAndOperationMetrics()
          throws Exception {
    CountDownLatch attemptStarted = new CountDownLatch(1);
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            obs.onStart(
                new StreamController() {
                  @Override
                  public void cancel() {
                    obs.onError(apiException(Status.Code.CANCELLED, "cancelled by grpc", false));
                  }

                  @Override
                  public void disableAutoInboundFlowControl() {}

                  @Override
                  public void request(int count) {}
                });
            attemptStarted.countDown();
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    Context.CancellableContext deadlineCtx =
        Context.current().withDeadlineAfter(30, TimeUnit.MILLISECONDS, executor);
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = deadlineCtx.attach();
      try {
        stream = callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        deadlineCtx.detach(prev);
      }
      assertTrue(attemptStarted.await(5, TimeUnit.SECONDS));

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
      assertEquals(1, tracer.attemptsStarted.get());
      assertEquals(0, tracer.attemptsCancelled.get());
      assertEquals(1, tracer.attemptsPermanentFailure.get());
      assertEquals(
          Code.DEADLINE_EXCEEDED,
          BatchWriteRetryPolicy.extractStatusCode(tracer.lastPermanentFailure.get()));
      assertEquals(0, tracer.operationCancelled.get());
      assertEquals(1, tracer.operationFailed.get());
      assertEquals(
          Code.DEADLINE_EXCEEDED,
          BatchWriteRetryPolicy.extractStatusCode(tracer.lastOperationFailure.get()));
    } finally {
      deadlineCtx.close();
    }
  }

  @Test
  public void preCancelledGrpcContextSkipsAttemptMetricsAndRecordsOperationCancelled() {
    ScriptedCallable inner = new ScriptedCallable();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    Context.CancellableContext cancelledCtx = Context.current().withCancellation();
    cancelledCtx.cancel(null);
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = cancelledCtx.attach();
      try {
        stream = callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        cancelledCtx.detach(prev);
      }

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.CANCELLED, ex.getStatusCode().getCode());
      assertEquals(0, inner.requests.size());
      assertEquals(0, tracer.attemptsStarted.get());
      assertEquals(0, tracer.attemptsCancelled.get());
      assertEquals(0, tracer.attemptsPermanentFailure.get());
      assertEquals(1, tracer.operationCancelled.get());
      assertEquals(0, tracer.operationFailed.get());
    } finally {
      cancelledCtx.close();
    }
  }

  @Test
  public void
      preExpiredGrpcContextDeadlineSkipsAttemptMetricsAndRecordsOperationDeadlineExceeded() {
    ScriptedCallable inner = new ScriptedCallable();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    Context.CancellableContext expiredCtx = Context.current().withCancellation();
    expiredCtx.cancel(new TimeoutException("deadline expired before start"));
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = expiredCtx.attach();
      try {
        stream = callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        expiredCtx.detach(prev);
      }

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
      assertEquals(0, inner.requests.size());
      assertEquals(0, tracer.attemptsStarted.get());
      assertEquals(0, tracer.attemptsCancelled.get());
      assertEquals(0, tracer.attemptsPermanentFailure.get());
      assertEquals(0, tracer.operationCancelled.get());
      assertEquals(1, tracer.operationFailed.get());
      assertEquals(
          Code.DEADLINE_EXCEEDED,
          BatchWriteRetryPolicy.extractStatusCode(tracer.lastOperationFailure.get()));
    } finally {
      expiredCtx.close();
    }
  }

  @Test
  public void grpcContextCancelledMidStreamRecordsCancelledAttemptAndOperationMetrics()
      throws Exception {
    CountDownLatch attemptStarted = new CountDownLatch(1);
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            obs.onStart(
                new StreamController() {
                  @Override
                  public void cancel() {
                    obs.onError(apiException(Status.Code.CANCELLED, "cancelled by grpc", false));
                  }

                  @Override
                  public void disableAutoInboundFlowControl() {}

                  @Override
                  public void request(int count) {}
                });
            attemptStarted.countDown();
          }
        };

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable =
        wrapTraced(inner, fastRetrySettings(5), ImmutableSet.of(Code.UNAVAILABLE), 2, false);

    Context.CancellableContext cancellableCtx = Context.current().withCancellation();
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = cancellableCtx.attach();
      try {
        stream = callable.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        cancellableCtx.detach(prev);
      }
      assertTrue(attemptStarted.await(5, TimeUnit.SECONDS));
      cancellableCtx.cancel(null);

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.CANCELLED, ex.getStatusCode().getCode());
      assertEquals(1, tracer.attemptsStarted.get());
      assertEquals(1, tracer.attemptsCancelled.get());
      assertEquals(0, tracer.attemptsPermanentFailure.get());
      assertEquals(1, tracer.operationCancelled.get());
      assertEquals(0, tracer.operationFailed.get());
    } finally {
      cancellableCtx.close();
    }
  }

  @Test
  public void cancelInsideOnStartDoesNotLeakActiveStreamOrSweepTimer() {
    ScriptedCallable inner = new ScriptedCallable();
    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0);

    List<Throwable> errors = new CopyOnWriteArrayList<>();
    AtomicBoolean completed = new AtomicBoolean(false);
    ResponseObserver<BatchWriteResponse> cancellingObserver =
        new ResponseObserver<BatchWriteResponse>() {
          @Override
          public void onStart(StreamController controller) {
            controller.cancel();
          }

          @Override
          public void onResponse(BatchWriteResponse response) {}

          @Override
          public void onError(Throwable t) {
            errors.add(t);
          }

          @Override
          public void onComplete() {
            completed.set(true);
          }
        };

    Context.CancellableContext cancellableCtx = Context.current().withCancellation();
    try {
      Context prev = cancellableCtx.attach();
      try {
        resuming.call(requestWithGroups("g0"), cancellingObserver, GrpcCallContext.createDefault());
      } finally {
        cancellableCtx.detach(prev);
      }

      assertEquals(0, inner.requests.size());
      assertEquals(0, resuming.getActiveStreamCount());
      assertEquals(0, resuming.getTrackedStreamRefCount());
      assertFalse(resuming.isSweepScheduled());
      assertFalse(completed.get());
      assertThat(errors).hasSize(1);
      assertThat(errors.get(0)).isInstanceOf(CancellationException.class);
      assertEquals(0, tracer.attemptsStarted.get());
      assertEquals(1, tracer.operationCancelled.get());
      assertEquals(0, tracer.operationFailed.get());

      // Cancelling the context afterward must not deliver a duplicate error.
      cancellableCtx.cancel(null);
      assertThat(errors).hasSize(1);
    } finally {
      cancellableCtx.close();
    }
  }

  @Test
  public void preCancelledGrpcContextOnServerStreamDoesNotLeakTrackedRefOrSweepTimer() {
    ScriptedCallable inner = new ScriptedCallable();
    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0);

    Context.CancellableContext cancelledCtx = Context.current().withCancellation();
    cancelledCtx.cancel(null);
    try {
      ServerStream<BatchWriteResponse> stream;
      Context prev = cancelledCtx.attach();
      try {
        stream = resuming.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        cancelledCtx.detach(prev);
      }

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.CANCELLED, ex.getStatusCode().getCode());
      assertEquals(0, inner.requests.size());
      assertEquals(0, resuming.getActiveStreamCount());
      assertEquals(0, resuming.getTrackedStreamRefCount());
      assertFalse(resuming.isSweepScheduled());
      assertEquals(0, tracer.attemptsStarted.get());
      assertEquals(1, tracer.operationCancelled.get());
      assertEquals(0, tracer.operationFailed.get());
    } finally {
      cancelledCtx.close();
    }
  }

  @Test
  public void cancelDuringRetryPolicyEvaluationRecordsAttemptAndOperationCancelledInOrder() {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
        });

    AtomicReference<StreamController> outerController = new AtomicReference<>();
    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> {
              // Simulate external cancellation racing inside retryPolicy.evaluate() before
              // attemptFailedDuration() has been called.
              outerController.get().cancel();
              return 1.0;
            });

    List<Throwable> errors = new CopyOnWriteArrayList<>();
    ResponseObserver<BatchWriteResponse> observer =
        new ResponseObserver<BatchWriteResponse>() {
          @Override
          public void onStart(StreamController controller) {
            outerController.set(controller);
          }

          @Override
          public void onResponse(BatchWriteResponse response) {}

          @Override
          public void onError(Throwable t) {
            errors.add(t);
          }

          @Override
          public void onComplete() {}
        };

    resuming.call(requestWithGroups("g0"), observer, GrpcCallContext.createDefault());

    assertEquals(1, inner.requests.size());
    assertEquals(0, resuming.getActiveStreamCount());
    assertThat(errors).hasSize(1);
    assertThat(errors.get(0)).isInstanceOf(CancellationException.class);
    assertThat(tracer.events)
        .containsExactly("attemptStarted", "attemptCancelled", "operationCancelled")
        .inOrder();
    assertEquals(0, tracer.attemptsFailedDuration.get());
    assertEquals(0, tracer.operationFailed.get());
  }

  @Test
  public void cancelDuringAttemptFailedDurationOrdersAttemptMetricBeforeOperationCancelled()
      throws Exception {
    ScriptedCallable inner = new ScriptedCallable();
    inner.addScript(
        (req, obs, ctx) -> {
          obs.onStart(new NoopController());
          obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
        });

    AtomicReference<StreamController> outerController = new AtomicReference<>();
    CountDownLatch cancelReturned = new CountDownLatch(1);
    AtomicReference<Throwable> cancelThreadFailure = new AtomicReference<>();
    RecordingTracer racingTracer =
        new RecordingTracer() {
          @Override
          public void attemptFailedDuration(Throwable error, Duration delay) {
            Thread cancelThread =
                new Thread(
                    () -> {
                      try {
                        outerController.get().cancel();
                      } catch (Throwable t) {
                        cancelThreadFailure.set(t);
                      } finally {
                        cancelReturned.countDown();
                      }
                    });
            cancelThread.start();
            try {
              assertTrue(cancelReturned.await(5, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
              throw new AssertionError(e);
            }
            // Record attemptFailedDuration AFTER the concurrent cancel() call has returned to prove
            // operationCancelled() could not overtake attemptFailedDuration().
            super.attemptFailedDuration(error, delay);
          }
        };
    ApiTracerFactory racingTracerFactory =
        new BaseApiTracerFactory() {
          @Override
          public ApiTracer newTracer(
              ApiTracer parent, SpanName spanName, OperationType operationType) {
            return racingTracer;
          }
        };

    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            racingTracerFactory,
            2,
            false,
            () -> 1.0);

    List<Throwable> errors = new CopyOnWriteArrayList<>();
    ResponseObserver<BatchWriteResponse> observer =
        new ResponseObserver<BatchWriteResponse>() {
          @Override
          public void onStart(StreamController controller) {
            outerController.set(controller);
          }

          @Override
          public void onResponse(BatchWriteResponse response) {}

          @Override
          public void onError(Throwable t) {
            errors.add(t);
          }

          @Override
          public void onComplete() {}
        };

    resuming.call(requestWithGroups("g0"), observer, GrpcCallContext.createDefault());

    assertThat(cancelThreadFailure.get()).isNull();
    assertEquals(1, inner.requests.size());
    assertEquals(0, resuming.getActiveStreamCount());
    assertThat(errors).hasSize(1);
    assertThat(errors.get(0)).isInstanceOf(CancellationException.class);
    assertThat(racingTracer.events)
        .containsExactly("attemptStarted", "attemptFailedDuration", "operationCancelled")
        .inOrder();
    assertEquals(0, racingTracer.attemptsCancelled.get());
    assertEquals(0, racingTracer.operationFailed.get());
  }

  @Test
  public void expiredNonCancelledGrpcContextDeadlinePreventsFirstAttemptDispatch() {
    ScriptedCallable inner = new ScriptedCallable();
    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0);

    // Schedule deadline cancellation 10 real seconds out, then advance FakeClock past the deadline
    // so grpcContext.getDeadline().isExpired() is true while grpcContext.isCancelled() is false.
    Deadline deadline = Deadline.after(10, TimeUnit.SECONDS, clock);
    Context.CancellableContext ctx = Context.current().withDeadline(deadline, executor);
    try {
      clock.advanceMillis(20_000);
      assertFalse(ctx.isCancelled());
      assertTrue(ctx.getDeadline().isExpired());

      ServerStream<BatchWriteResponse> stream;
      Context prev = ctx.attach();
      try {
        stream = resuming.call(requestWithGroups("g0"), GrpcCallContext.createDefault());
      } finally {
        ctx.detach(prev);
      }

      ApiException ex = assertThrows(ApiException.class, () -> ImmutableList.copyOf(stream));
      assertEquals(Code.DEADLINE_EXCEEDED, ex.getStatusCode().getCode());
      assertEquals(0, inner.requests.size());
      assertEquals(0, resuming.getActiveStreamCount());
      assertEquals(0, tracer.attemptsStarted.get());
      assertEquals(0, tracer.operationCancelled.get());
      assertEquals(1, tracer.operationFailed.get());
    } finally {
      ctx.close();
    }
  }

  private static void startAndAbandonStreams(
      BatchWriteResumingServerStreamingCallable resuming, int count) {
    for (int i = 0; i < count; i++) {
      resuming.call(requestWithGroups("g" + i), GrpcCallContext.createDefault());
    }
  }

  @Test
  public void abandonedServerStreamIsCancelledAndReclaimedAfterGcBeforeClientClose()
      throws Exception {
    CountDownLatch activeInnerCancelled = new CountDownLatch(1);
    CountDownLatch backoffScheduled = new CountDownLatch(1);
    AtomicInteger attemptCalls = new AtomicInteger();

    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            int callNum = attemptCalls.incrementAndGet();
            if (callNum == 1) {
              obs.onStart(
                  new StreamController() {
                    @Override
                    public void cancel() {
                      activeInnerCancelled.countDown();
                      obs.onError(apiException(Status.Code.CANCELLED, "abandoned", false));
                    }

                    @Override
                    public void disableAutoInboundFlowControl() {}

                    @Override
                    public void request(int count) {}
                  });
            } else {
              obs.onStart(new NoopController());
              obs.onError(apiException(Status.Code.UNAVAILABLE, "transient", true));
              backoffScheduled.countDown();
            }
          }
        };

    RetrySettings longBackoff =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofSeconds(30))
            .setRetryDelayMultiplier(1.0)
            .setMaxRetryDelayDuration(Duration.ofSeconds(30))
            .setMaxAttempts(5)
            .setTotalTimeoutDuration(Duration.ofMinutes(5))
            .build();

    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            longBackoff,
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0,
            10L);

    startAndAbandonStreams(resuming, 2);
    assertTrue(backoffScheduled.await(5, TimeUnit.SECONDS));
    assertEquals(2, resuming.getActiveStreamCount());

    // Force GC without calling cancel() or cancelAll() — abandoned streams must be cleaned up.
    for (int i = 0; i < 40 && resuming.getActiveStreamCount() > 0; i++) {
      System.gc();
      Thread.sleep(25);
    }

    assertTrue(activeInnerCancelled.await(2, TimeUnit.SECONDS));
    assertEquals(0, resuming.getActiveStreamCount());
    assertEquals(2, attemptCalls.get());
    assertEquals(1, tracer.attemptsCancelled.get());
    assertEquals(2, tracer.operationCancelled.get());
    assertEquals(0, tracer.operationFailed.get());
  }

  private static Iterator<BatchWriteResponse> startAndReturnOnlyIterator(
      ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> callable) {
    return callable.call(requestWithGroups("g0", "g1"), GrpcCallContext.createDefault()).iterator();
  }

  @Test
  public void iteratorHeldWithoutServerStreamIsNotFalselyCancelledByGc() throws Exception {
    AtomicReference<ResponseObserver<BatchWriteResponse>> innerObserverRef =
        new AtomicReference<>();
    ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> inner =
        new ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse>() {
          @Override
          public void call(
              BatchWriteRequest req, ResponseObserver<BatchWriteResponse> obs, ApiCallContext ctx) {
            innerObserverRef.set(obs);
            obs.onStart(new NoopController());
            obs.onResponse(response(OK_STATUS, 0));
          }
        };

    BatchWriteResumingServerStreamingCallable resuming =
        new BatchWriteResumingServerStreamingCallable(
            inner,
            fastRetrySettings(5),
            ImmutableSet.of(Code.UNAVAILABLE),
            executor,
            clock,
            tracerFactory,
            2,
            false,
            () -> 1.0,
            10L);

    Iterator<BatchWriteResponse> iterator = startAndReturnOnlyIterator(resuming);
    assertTrue(iterator.hasNext());
    assertThat(iterator.next().getIndexesList()).containsExactly(0);

    // ServerStream itself is unreachable, but iterator keeps QueuingResponseObserver alive.
    for (int i = 0; i < 10; i++) {
      System.gc();
      resuming.drainAbandonedStreams();
      Thread.sleep(10);
    }
    assertEquals(1, resuming.getActiveStreamCount());

    innerObserverRef.get().onResponse(response(OK_STATUS, 1));
    innerObserverRef.get().onComplete();

    assertTrue(iterator.hasNext());
    assertThat(iterator.next().getIndexesList()).containsExactly(1);
    assertFalse(iterator.hasNext());
    assertEquals(0, resuming.getActiveStreamCount());
    assertEquals(1, tracer.operationSucceeded.get());
  }

  @FunctionalInterface
  private interface StreamScript {
    void run(
        BatchWriteRequest request,
        ResponseObserver<BatchWriteResponse> observer,
        ApiCallContext context);
  }

  private final class ScriptedCallable
      extends ServerStreamingCallable<BatchWriteRequest, BatchWriteResponse> {
    private final Queue<StreamScript> scripts = new ArrayDeque<>();
    final List<BatchWriteRequest> requests = new CopyOnWriteArrayList<>();
    final List<ApiCallContext> contexts = new CopyOnWriteArrayList<>();

    void addScript(StreamScript script) {
      scripts.add(script);
    }

    @Override
    public void call(
        BatchWriteRequest request,
        ResponseObserver<BatchWriteResponse> responseObserver,
        ApiCallContext context) {
      requests.add(request);
      contexts.add(context);
      StreamScript script = scripts.poll();
      if (script == null) {
        throw new AssertionError("No script left for attempt #" + requests.size());
      }
      FlowControlledStreamBridge bridge = new FlowControlledStreamBridge(responseObserver);
      // Run the script to capture its controller and events, then deliver respecting flow control.
      script.run(request, bridge.scriptObserver(), context);
      bridge.start();
    }
  }

  /**
   * Bridges a synchronous test script onto a flow-control-respecting {@link ResponseObserver} so
   * {@link ServerStream}'s single-element buffer never overflows when a script emits multiple
   * responses.
   */
  private static final class FlowControlledStreamBridge {
    private final Object lock = new Object();
    private final ResponseObserver<BatchWriteResponse> downstream;
    private final Queue<BatchWriteResponse> responses = new ArrayDeque<>();
    private StreamController scriptController = new NoopController();
    private boolean completed;
    private Throwable error;
    private boolean autoFlowControl = true;
    private int demand;
    private boolean started;
    private boolean cancelled;
    private boolean terminated;

    FlowControlledStreamBridge(ResponseObserver<BatchWriteResponse> downstream) {
      this.downstream = downstream;
    }

    ResponseObserver<BatchWriteResponse> scriptObserver() {
      return new ResponseObserver<BatchWriteResponse>() {
        @Override
        public void onStart(StreamController controller) {
          scriptController = controller;
        }

        @Override
        public void onResponse(BatchWriteResponse response) {
          responses.add(response);
        }

        @Override
        public void onError(Throwable t) {
          error = t;
        }

        @Override
        public void onComplete() {
          completed = true;
        }
      };
    }

    void start() {
      downstream.onStart(
          new StreamController() {
            @Override
            public void cancel() {
              boolean shouldCancelScript;
              synchronized (lock) {
                shouldCancelScript = !cancelled && !terminated;
                cancelled = true;
                terminated = true;
              }
              if (shouldCancelScript) {
                scriptController.cancel();
                downstream.onError(apiException(Status.Code.CANCELLED, "cancelled", false));
              }
            }

            @Override
            public void disableAutoInboundFlowControl() {
              autoFlowControl = false;
            }

            @Override
            public void request(int count) {
              synchronized (lock) {
                demand += count;
              }
              drain();
            }
          });
      synchronized (lock) {
        started = true;
        if (autoFlowControl) {
          demand = Integer.MAX_VALUE;
        }
      }
      drain();
    }

    private void drain() {
      while (true) {
        BatchWriteResponse nextResponse = null;
        Throwable terminalError = null;
        boolean terminalComplete = false;
        synchronized (lock) {
          if (!started || terminated || cancelled) {
            return;
          }
          if (!responses.isEmpty()) {
            if (demand <= 0) {
              return;
            }
            demand--;
            nextResponse = responses.poll();
          } else if (error != null) {
            terminated = true;
            terminalError = error;
          } else if (completed) {
            terminated = true;
            terminalComplete = true;
          } else {
            return;
          }
        }
        if (nextResponse != null) {
          downstream.onResponse(nextResponse);
        } else if (terminalError != null) {
          downstream.onError(terminalError);
          return;
        } else if (terminalComplete) {
          downstream.onComplete();
          return;
        }
      }
    }
  }

  private static class NoopController implements StreamController {
    @Override
    public void cancel() {}

    @Override
    public void disableAutoInboundFlowControl() {}

    @Override
    public void request(int count) {}
  }

  private static final class FakeClock extends Deadline.Ticker implements ApiClock {
    private final AtomicLong nanos = new AtomicLong(1_000_000L);

    void advanceMillis(long millis) {
      nanos.addAndGet(TimeUnit.MILLISECONDS.toNanos(millis));
    }

    @Override
    public long nanoTime() {
      return nanos.get();
    }

    @Override
    public long millisTime() {
      return TimeUnit.NANOSECONDS.toMillis(nanos.get());
    }
  }

  private static class RecordingTracer extends BaseApiTracer {
    volatile SpanName spanName;
    final AtomicInteger attemptsStarted = new AtomicInteger();
    final AtomicInteger attemptsSucceeded = new AtomicInteger();
    final AtomicInteger attemptsFailedDuration = new AtomicInteger();
    final AtomicInteger attemptsRetriesExhausted = new AtomicInteger();
    final AtomicInteger attemptsPermanentFailure = new AtomicInteger();
    final AtomicInteger attemptsCancelled = new AtomicInteger();
    final AtomicInteger operationSucceeded = new AtomicInteger();
    final AtomicInteger operationFailed = new AtomicInteger();
    final AtomicInteger operationCancelled = new AtomicInteger();
    final AtomicReference<Throwable> lastPermanentFailure = new AtomicReference<>();
    final AtomicReference<Throwable> lastOperationFailure = new AtomicReference<>();
    final List<Duration> recordedRetryDelays = new CopyOnWriteArrayList<>();
    final List<String> events = new CopyOnWriteArrayList<>();

    @Override
    public void attemptStarted(Object request, int attemptNumber) {
      events.add("attemptStarted");
      attemptsStarted.incrementAndGet();
    }

    @Override
    public void attemptSucceeded() {
      events.add("attemptSucceeded");
      attemptsSucceeded.incrementAndGet();
    }

    @Override
    public void attemptFailedDuration(Throwable error, Duration delay) {
      events.add("attemptFailedDuration");
      attemptsFailedDuration.incrementAndGet();
      recordedRetryDelays.add(delay);
    }

    @Override
    public void attemptFailedRetriesExhausted(Throwable error) {
      events.add("attemptFailedRetriesExhausted");
      attemptsRetriesExhausted.incrementAndGet();
    }

    @Override
    public void attemptPermanentFailure(Throwable error) {
      events.add("attemptPermanentFailure");
      lastPermanentFailure.set(error);
      attemptsPermanentFailure.incrementAndGet();
    }

    @Override
    public void attemptCancelled() {
      events.add("attemptCancelled");
      attemptsCancelled.incrementAndGet();
    }

    @Override
    public void operationSucceeded() {
      events.add("operationSucceeded");
      operationSucceeded.incrementAndGet();
    }

    @Override
    public void operationFailed(Throwable error) {
      events.add("operationFailed");
      lastOperationFailure.set(error);
      operationFailed.incrementAndGet();
    }

    @Override
    public void operationCancelled() {
      events.add("operationCancelled");
      operationCancelled.incrementAndGet();
    }
  }
}
