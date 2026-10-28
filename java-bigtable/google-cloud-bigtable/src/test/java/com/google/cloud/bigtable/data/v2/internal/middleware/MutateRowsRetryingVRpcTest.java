/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.middleware;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.bigtable.v2.SessionMutateRowsResponse.RateLimitInfo;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.api.UnaryResponseFuture;
import com.google.cloud.bigtable.data.v2.internal.api.VRpcException;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import com.google.rpc.RetryInfo;
import io.grpc.Deadline;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(30)
class MutateRowsRetryingVRpcTest {

  private ManualTimer timer;
  private ScriptedAttemptFactory attemptFactory;
  private VRpcTracer noopTracer;

  @BeforeEach
  void setUp() {
    timer = new ManualTimer();
    attemptFactory = new ScriptedAttemptFactory();
    noopTracer = NoopMetrics.NoopVrpcTracer.INSTANCE;
  }

  @Test
  void allEntriesSucceed_noRetryAndBalancedTracer() throws Exception {
    VRpcTracer tracer = mock(VRpcTracer.class);
    SessionMutateRowsResponse okResponse =
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.OK_VALUE, ""))
            .addEntries(respEntry(1, Code.OK_VALUE, ""))
            .build();
    attemptFactory.enqueueResponse(okResponse);

    MutateRowsRetryingVRpc retrying = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(idempotentReqEntry("k1"))
            .build();

    retrying.start(
        req, VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, tracer), future);

    assertThat(future.get()).isEqualTo(okResponse);
    assertThat(attemptFactory.requests).containsExactly(req);
    assertThat(timer.pendingCount()).isEqualTo(0);

    verify(tracer, times(1)).onOperationStart();
    verify(tracer, times(1)).onAttemptStart(req);
    verify(tracer, times(1)).onResponseReceived();
    verify(tracer, times(1)).onAttemptFinish(any());
    verify(tracer, times(1)).onOperationFinish(any());
  }

  @Test
  void partialTransientFailure_retriesOnlyFailedIdempotentEntriesAndRemapsOriginalIndices()
      throws Exception {
    RateLimitInfo latestRateLimit =
        RateLimitInfo.newBuilder().setFactor(0.9).setPeriod(Durations.fromSeconds(10)).build();

    // Attempt 1 (k0, k1, k2, k3):
    // 0 -> OK, 1 -> UNAVAILABLE (retry), 2 -> INVALID_ARGUMENT (permanent), 3 -> DEADLINE_EXCEEDED
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.OK_VALUE, ""))
            .addEntries(respEntry(1, Code.UNAVAILABLE_VALUE, "transient-1"))
            .addEntries(respEntry(2, Code.INVALID_ARGUMENT_VALUE, "bad-family"))
            .addEntries(respEntry(3, Code.DEADLINE_EXCEEDED_VALUE, "transient-3"))
            .build());

    // Attempt 2 (k1 at index 0, k3 at index 1):
    // 0 (k1) -> DEADLINE_EXCEEDED (retry again), 1 (k3) -> OK
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.DEADLINE_EXCEEDED_VALUE, "still-slow"))
            .addEntries(respEntry(1, Code.OK_VALUE, ""))
            .build());

    // Attempt 3 (k1 at index 0):
    // 0 (k1) -> OK, with RateLimitInfo
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.OK_VALUE, ""))
            .setRateLimitInfo(latestRateLimit)
            .build());

    MutateRowsRetryingVRpc retrying =
        new MutateRowsRetryingVRpc(
            attemptFactory::next,
            timer,
            MutateRowsRetryingVRpc.DEFAULT_RETRYABLE_ENTRY_CODES,
            Duration.ofMillis(10),
            2.0,
            Duration.ofSeconds(1));
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(idempotentReqEntry("k1"))
            .addEntries(idempotentReqEntry("k2"))
            .addEntries(idempotentReqEntry("k3"))
            .build();

    retrying.start(
        req, VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer), future);

    assertThat(future.isDone()).isFalse();
    assertThat(attemptFactory.requests).hasSize(1);
    assertThat(timer.lastScheduledDelayNanos()).isEqualTo(Duration.ofMillis(10).toNanos());

    // Fire backoff for Attempt 2
    timer.fireNext();
    assertThat(future.isDone()).isFalse();
    assertThat(attemptFactory.requests).hasSize(2);
    assertThat(rowKeysOf(attemptFactory.requests.get(1))).containsExactly("k1", "k3").inOrder();
    assertThat(timer.lastScheduledDelayNanos()).isEqualTo(Duration.ofMillis(20).toNanos());

    // Fire backoff for Attempt 3
    timer.fireNext();
    assertThat(future.isDone()).isTrue();
    assertThat(attemptFactory.requests).hasSize(3);
    assertThat(rowKeysOf(attemptFactory.requests.get(2))).containsExactly("k1");

    SessionMutateRowsResponse merged = future.get();
    assertThat(merged.getRateLimitInfo()).isEqualTo(latestRateLimit);
    assertThat(merged.getEntriesList())
        .containsExactly(
            respEntry(0, Code.OK_VALUE, ""),
            respEntry(1, Code.OK_VALUE, ""),
            respEntry(2, Code.INVALID_ARGUMENT_VALUE, "bad-family"),
            respEntry(3, Code.OK_VALUE, ""))
        .inOrder();
  }

  @Test
  void nonIdempotentEntries_notRetriedOnTransientEntryFailure() throws Exception {
    // 0: idempotent, 1: AddToCell (non-idempotent), 2: SetCell ts=-1 (non-idempotent)
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.UNAVAILABLE_VALUE, "transient-0"))
            .addEntries(respEntry(1, Code.UNAVAILABLE_VALUE, "transient-add"))
            .addEntries(respEntry(2, Code.UNAVAILABLE_VALUE, "transient-server-ts"))
            .build());
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder().addEntries(respEntry(0, Code.OK_VALUE, "")).build());

    MutateRowsRetryingVRpc retrying = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(nonIdempotentAddReqEntry("k1"))
            .addEntries(nonIdempotentServerTsReqEntry("k2"))
            .build();

    retrying.start(
        req,
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), false, noopTracer),
        future);

    timer.fireNext();

    assertThat(attemptFactory.requests).hasSize(2);
    assertThat(rowKeysOf(attemptFactory.requests.get(1))).containsExactly("k0");

    SessionMutateRowsResponse merged = future.get();
    assertThat(merged.getEntriesList())
        .containsExactly(
            respEntry(0, Code.OK_VALUE, ""),
            respEntry(1, Code.UNAVAILABLE_VALUE, "transient-add"),
            respEntry(2, Code.UNAVAILABLE_VALUE, "transient-server-ts"))
        .inOrder();
  }

  @Test
  void missingEntryInResponse_recordedAsPermanentInternalError() throws Exception {
    // Entry 1 is omitted by server; entry 2 has transient error and is retried.
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.OK_VALUE, ""))
            .addEntries(respEntry(2, Code.UNAVAILABLE_VALUE, "retry-2"))
            .build());
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder().addEntries(respEntry(0, Code.OK_VALUE, "")).build());

    MutateRowsRetryingVRpc retrying = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(idempotentReqEntry("k1"))
            .addEntries(idempotentReqEntry("k2"))
            .build();

    retrying.start(
        req, VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer), future);

    timer.fireNext();
    assertThat(rowKeysOf(attemptFactory.requests.get(1))).containsExactly("k2");

    SessionMutateRowsResponse merged = future.get();
    assertThat(merged.getEntriesList())
        .containsExactly(
            respEntry(0, Code.OK_VALUE, ""),
            respEntry(1, Code.INTERNAL_VALUE, "Missing entry response for entry 1"),
            respEntry(2, Code.OK_VALUE, ""))
        .inOrder();
  }

  @Test
  void wholeVRpcFailureAfterPartialProgress_preservesPriorOutcomes() throws Exception {
    // Attempt 1 resolves entry 0 (OK) and entry 1 (INVALID_ARGUMENT); entry 2 needs retry.
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.OK_VALUE, ""))
            .addEntries(respEntry(1, Code.INVALID_ARGUMENT_VALUE, "bad-arg"))
            .addEntries(respEntry(2, Code.UNAVAILABLE_VALUE, "retry-me"))
            .build());
    // Attempt 2 fails at the whole-vRPC level with non-retryable PERMISSION_DENIED.
    ErrorResponse serverError = errorResponse(Code.PERMISSION_DENIED_VALUE, "token revoked", null);
    attemptFactory.enqueueClose(VRpcResult.createServerError(serverError));

    MutateRowsRetryingVRpc retrying = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(idempotentReqEntry("k1"))
            .addEntries(idempotentReqEntry("k2"))
            .build();

    retrying.start(
        req, VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer), future);
    timer.fireNext();

    SessionMutateRowsResponse merged = future.get();
    assertThat(merged.getEntriesList())
        .containsExactly(
            respEntry(0, Code.OK_VALUE, ""),
            respEntry(1, Code.INVALID_ARGUMENT_VALUE, "bad-arg"),
            respEntry(2, Code.PERMISSION_DENIED_VALUE, "token revoked"))
        .inOrder();
  }

  @Test
  void wholeVRpcFailureOnInitialAttempt_retriesRetryInfoAndPropagatesNonRetryableError()
      throws Exception {
    ErrorResponse retryableServerError =
        errorResponse(
            Code.UNAVAILABLE_VALUE,
            "temporarily unavailable",
            RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(15)).build());
    attemptFactory.enqueueClose(VRpcResult.createServerError(retryableServerError));
    SessionMutateRowsResponse okResponse =
        SessionMutateRowsResponse.newBuilder().addEntries(respEntry(0, Code.OK_VALUE, "")).build();
    attemptFactory.enqueueResponse(okResponse);

    MutateRowsRetryingVRpc retrying = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder().addEntries(idempotentReqEntry("k0")).build();

    retrying.start(
        req, VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer), future);
    assertThat(timer.lastScheduledDelayNanos()).isEqualTo(Duration.ofMillis(15).toNanos());
    timer.fireNext();
    assertThat(future.get()).isEqualTo(okResponse);

    // Without RetryInfo on initial attempt, server error is not retried and propagates
    // VRpcException
    ScriptedAttemptFactory nonRetryFactory = new ScriptedAttemptFactory();
    ErrorResponse terminalError = errorResponse(Code.PERMISSION_DENIED_VALUE, "denied", null);
    nonRetryFactory.enqueueClose(VRpcResult.createServerError(terminalError));

    MutateRowsRetryingVRpc nonRetrying = new MutateRowsRetryingVRpc(nonRetryFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> failFuture = new UnaryResponseFuture<>();
    nonRetrying.start(
        req,
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer),
        failFuture);

    ExecutionException ex = assertThrows(ExecutionException.class, failFuture::get);
    assertThat(ex.getCause()).isInstanceOf(VRpcException.class);
    assertThat(((VRpcException) ex.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.PERMISSION_DENIED);
  }

  @Test
  void transportFailure_checksActiveEntriesIdempotency() throws Exception {
    SessionMutateRowsRequest mixedReq =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(nonIdempotentAddReqEntry("k1"))
            .build();

    // Case 1: Initial attempt has a non-idempotent entry active -> TRANSPORT_FAILURE is NOT retried
    ScriptedAttemptFactory factory1 = new ScriptedAttemptFactory();
    factory1.enqueueClose(
        VRpcResult.createLocalTransportError(Status.UNAVAILABLE.withDescription("rst")));
    MutateRowsRetryingVRpc retrying1 = new MutateRowsRetryingVRpc(factory1::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> f1 = new UnaryResponseFuture<>();
    retrying1.start(
        mixedReq,
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), false, noopTracer),
        f1);
    assertThrows(ExecutionException.class, f1::get);
    assertThat(factory1.requests).hasSize(1);

    // Case 2: Attempt 1 finishes non-idempotent k1 (OK) and leaves only idempotent k0 active;
    // Attempt 2 hits TRANSPORT_FAILURE -> safely retried on Attempt 3!
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.UNAVAILABLE_VALUE, "retry-k0"))
            .addEntries(respEntry(1, Code.OK_VALUE, ""))
            .build());
    attemptFactory.enqueueClose(
        VRpcResult.createLocalTransportError(Status.UNAVAILABLE.withDescription("rst")));
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder().addEntries(respEntry(0, Code.OK_VALUE, "")).build());

    MutateRowsRetryingVRpc retrying2 = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> f2 = new UnaryResponseFuture<>();
    retrying2.start(
        mixedReq,
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), false, noopTracer),
        f2);
    timer.fireNext();

    assertThat(attemptFactory.requests).hasSize(3);
    assertThat(f2.get().getEntriesList())
        .containsExactly(respEntry(0, Code.OK_VALUE, ""), respEntry(1, Code.OK_VALUE, ""))
        .inOrder();
  }

  @Test
  void deadlineExhausted_stopsPartialRetriesAndSurfacesTransientErrors() throws Exception {
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.OK_VALUE, ""))
            .addEntries(respEntry(1, Code.UNAVAILABLE_VALUE, "no-time-left"))
            .build());

    // Initial backoff (5s) exceeds 100ms deadline, so no retry is scheduled.
    MutateRowsRetryingVRpc retrying =
        new MutateRowsRetryingVRpc(
            attemptFactory::next,
            timer,
            MutateRowsRetryingVRpc.DEFAULT_RETRYABLE_ENTRY_CODES,
            Duration.ofSeconds(5),
            2.0,
            Duration.ofSeconds(10));
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder()
            .addEntries(idempotentReqEntry("k0"))
            .addEntries(idempotentReqEntry("k1"))
            .build();

    retrying.start(
        req,
        VRpcCallContext.create(Deadline.after(100, TimeUnit.MILLISECONDS), true, noopTracer),
        future);

    assertThat(attemptFactory.requests).hasSize(1);
    assertThat(timer.pendingCount()).isEqualTo(0);
    assertThat(future.get().getEntriesList())
        .containsExactly(
            respEntry(0, Code.OK_VALUE, ""), respEntry(1, Code.UNAVAILABLE_VALUE, "no-time-left"))
        .inOrder();
  }

  @Test
  void cancelAndTimerStopInScheduledState_transitionToCancelled() {
    attemptFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.UNAVAILABLE_VALUE, "retry"))
            .build());

    MutateRowsRetryingVRpc retrying = new MutateRowsRetryingVRpc(attemptFactory::next, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    SessionMutateRowsRequest req =
        SessionMutateRowsRequest.newBuilder().addEntries(idempotentReqEntry("k0")).build();

    retrying.start(
        req, VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer), future);
    assertThat(timer.pendingCount()).isEqualTo(1);

    retrying.cancel("caller cancelled", null);
    assertThat(retrying.isDone()).isTrue();
    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(((VRpcException) ex.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.CANCELLED);

    // Also verify timer.stop() drives a pending Scheduled retry to CANCELLED
    ManualTimer stopTimer = new ManualTimer();
    ScriptedAttemptFactory stopFactory = new ScriptedAttemptFactory();
    stopFactory.enqueueResponse(
        SessionMutateRowsResponse.newBuilder()
            .addEntries(respEntry(0, Code.UNAVAILABLE_VALUE, "retry"))
            .build());
    MutateRowsRetryingVRpc stopRetrying = new MutateRowsRetryingVRpc(stopFactory::next, stopTimer);
    UnaryResponseFuture<SessionMutateRowsResponse> stopFuture = new UnaryResponseFuture<>();
    stopRetrying.start(
        req,
        VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, noopTracer),
        stopFuture);

    stopTimer.stop();
    assertThat(stopRetrying.isDone()).isTrue();
    ExecutionException stopEx = assertThrows(ExecutionException.class, stopFuture::get);
    assertThat(((VRpcException) stopEx.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.CANCELLED);
  }

  private static SessionMutateRowsRequest.Entry idempotentReqEntry(String rowKey) {
    return SessionMutateRowsRequest.Entry.newBuilder()
        .setKey(ByteString.copyFromUtf8(rowKey))
        .addMutations(
            Mutation.newBuilder()
                .setSetCell(Mutation.SetCell.newBuilder().setTimestampMicros(1000L)))
        .build();
  }

  private static SessionMutateRowsRequest.Entry nonIdempotentAddReqEntry(String rowKey) {
    return SessionMutateRowsRequest.Entry.newBuilder()
        .setKey(ByteString.copyFromUtf8(rowKey))
        .addMutations(Mutation.newBuilder().setAddToCell(Mutation.AddToCell.getDefaultInstance()))
        .build();
  }

  private static SessionMutateRowsRequest.Entry nonIdempotentServerTsReqEntry(String rowKey) {
    return SessionMutateRowsRequest.Entry.newBuilder()
        .setKey(ByteString.copyFromUtf8(rowKey))
        .addMutations(
            Mutation.newBuilder().setSetCell(Mutation.SetCell.newBuilder().setTimestampMicros(-1L)))
        .build();
  }

  private static SessionMutateRowsResponse.Entry respEntry(int index, int code, String message) {
    SessionMutateRowsResponse.Entry.Builder builder =
        SessionMutateRowsResponse.Entry.newBuilder().setIndex(index);
    builder.getStatusBuilder().setCode(code).setMessage(message);
    return builder.build();
  }

  private static ErrorResponse errorResponse(
      int code, String message, @Nullable RetryInfo retryInfo) {
    ErrorResponse.Builder builder = ErrorResponse.newBuilder();
    builder.getStatusBuilder().setCode(code).setMessage(message);
    if (retryInfo != null) {
      builder.setRetryInfo(retryInfo);
    }
    return builder.build();
  }

  private static List<String> rowKeysOf(SessionMutateRowsRequest req) {
    List<String> keys = new ArrayList<>(req.getEntriesCount());
    for (SessionMutateRowsRequest.Entry entry : req.getEntriesList()) {
      keys.add(entry.getKey().toStringUtf8());
    }
    return keys;
  }

  static final class ScriptedAttemptFactory {
    final List<SessionMutateRowsRequest> requests = new ArrayList<>();
    private final Deque<
            BiConsumer<SessionMutateRowsRequest, VRpcListener<SessionMutateRowsResponse>>>
        actions = new ArrayDeque<>();

    void enqueueResponse(SessionMutateRowsResponse response) {
      actions.addLast(
          (req, listener) -> {
            listener.onMessage(response);
            listener.onClose(VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));
          });
    }

    void enqueueClose(VRpcResult result) {
      actions.addLast((req, listener) -> listener.onClose(result));
    }

    VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> next() {
      BiConsumer<SessionMutateRowsRequest, VRpcListener<SessionMutateRowsResponse>> action =
          actions.removeFirst();
      return new VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse>() {
        private boolean done = false;

        @Override
        public void start(
            SessionMutateRowsRequest req,
            VRpcCallContext ctx,
            VRpcListener<SessionMutateRowsResponse> listener) {
          requests.add(req);
          done = true;
          ctx.getExecutor().execute(() -> action.accept(req, listener));
        }

        @Override
        public void cancel(@Nullable String message, @Nullable Throwable cause) {
          done = true;
        }

        @Override
        public boolean isDone() {
          return done;
        }

        @Override
        public void requestNext() {
          throw new UnsupportedOperationException();
        }
      };
    }
  }

  static final class ManualTimer implements BigtableTimer {
    private final Deque<ManualTimeout> scheduled = new ArrayDeque<>();
    private final Set<Runnable> stopHooks = new LinkedHashSet<>();
    private boolean stopped = false;
    private long lastDelayNanos = 0L;

    @Override
    public BigtableTimer.Timeout newTimeout(
        Runnable task, Executor executor, long delay, TimeUnit unit) {
      if (stopped) {
        throw new IllegalStateException("Timer is stopped");
      }
      lastDelayNanos = unit.toNanos(delay);
      ManualTimeout timeout = new ManualTimeout(task, executor);
      scheduled.addLast(timeout);
      return timeout;
    }

    @Override
    public void stop() {
      if (stopped) {
        return;
      }
      stopped = true;
      scheduled.clear();
      List<Runnable> hooks = new ArrayList<>(stopHooks);
      stopHooks.clear();
      for (Runnable hook : hooks) {
        hook.run();
      }
    }

    @Override
    public Registration onStop(Runnable hook) {
      if (stopped) {
        hook.run();
        return () -> {};
      }
      stopHooks.add(hook);
      return () -> stopHooks.remove(hook);
    }

    int pendingCount() {
      return (int) scheduled.stream().filter(t -> !t.cancelled).count();
    }

    long lastScheduledDelayNanos() {
      return lastDelayNanos;
    }

    void fireNext() {
      while (!scheduled.isEmpty()) {
        ManualTimeout next = scheduled.removeFirst();
        if (!next.cancelled) {
          next.executor.execute(next.task);
          return;
        }
      }
      throw new IllegalStateException("No pending timeout to fire");
    }

    private static final class ManualTimeout implements BigtableTimer.Timeout {
      private final Runnable task;
      private final Executor executor;
      private boolean cancelled = false;

      ManualTimeout(Runnable task, Executor executor) {
        this.task = task;
        this.executor = executor;
      }

      @Override
      public boolean cancel() {
        if (cancelled) {
          return false;
        }
        cancelled = true;
        return true;
      }

      @Override
      public boolean isCancelled() {
        return cancelled;
      }
    }
  }
}
