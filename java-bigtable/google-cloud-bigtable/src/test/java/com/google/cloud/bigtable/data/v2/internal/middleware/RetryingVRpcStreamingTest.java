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

import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SessionReadRowsRequest;
import com.google.bigtable.v2.SessionReadRowsResponse;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.api.SessionReadRowsResumptionStrategy;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.cloud.bigtable.data.v2.internal.session.HashedWheelTimer;
import com.google.protobuf.ByteString;
import io.grpc.Deadline;
import io.grpc.Status;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Focused tests for the streaming/resumption behavior of {@link RetryingVRpc}. Instead of a real
 * session, each attempt is a scripted {@link FakeAttempt} injected through the attempt supplier, so
 * the state machine (demand gating, resume-now vs. parked-in-Idle, request narrowing) can be
 * exercised deterministically on a direct executor.
 */
public class RetryingVRpcStreamingTest {

  private static final VRpcTracer TRACER = NoopMetrics.NoopVrpcTracer.INSTANCE;

  private BigtableTimer timer;

  // Requests that each started attempt was invoked with, in order. Shared with every FakeAttempt.
  private final List<SessionReadRowsRequest> startedRequests = new ArrayList<>();
  // Attempts handed out by the supplier, oldest first.
  private final Deque<FakeAttempt> attemptQueue = new ArrayDeque<>();

  private final Supplier<VRpc<SessionReadRowsRequest, SessionReadRowsResponse>> attemptFactory =
      () -> attemptQueue.remove();

  @BeforeEach
  void setUp() {
    timer = new HashedWheelTimer("retrying-vrpc-streaming-test");
  }

  @AfterEach
  void tearDown() {
    timer.stop();
  }

  @Test
  void multipleBatchesThenServerOk_singleAttempt() {
    FakeAttempt attempt =
        addAttempt(
            l -> l.onMessage(response("a", "b")),
            l -> l.onMessage(response("c")),
            l -> {
              l.onMessage(response("d"));
              l.onClose(serverOk());
            });

    CollectingListener listener = new CollectingListener();
    VRpcCallContext ctx = newContext();
    RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> retrying = newRetrying();

    retrying.start(request(range("a", "z"), 0), ctx, listener);
    requestNext(retrying, ctx);
    requestNext(retrying, ctx);

    assertThat(listener.messages)
        .containsExactly(response("a", "b"), response("c"), response("d"))
        .inOrder();
    assertThat(listener.close).isNotNull();
    assertThat(listener.close.getStatus().isOk()).isTrue();
    assertThat(startedRequests).hasSize(1);
    assertThat(attempt.cancelled).isFalse();
  }

  @Test
  void midStreamRetry_resumesWithNarrowedRequest() {
    addAttempt(l -> l.onMessage(response("a", "b", "c")), l -> l.onClose(transportError()));
    addAttempt(
        l -> l.onMessage(response("d")),
        l -> {
          l.onMessage(response("e"));
          l.onClose(serverOk());
        });

    CollectingListener listener = new CollectingListener();
    VRpcCallContext ctx = newContext();
    RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> retrying = newRetrying();

    retrying.start(request(range("a", "z"), 10), ctx, listener);
    // Triggers the transport error; demand is outstanding, so the retry resumes immediately and its
    // implicit first response ("d") is delivered.
    requestNext(retrying, ctx);
    requestNext(retrying, ctx);

    assertThat(listener.messages)
        .containsExactly(response("a", "b", "c"), response("d"), response("e"))
        .inOrder();
    assertThat(listener.close).isNotNull();
    assertThat(listener.close.getStatus().isOk()).isTrue();

    assertThat(startedRequests).hasSize(2);
    // Resume excludes everything through "c" and shrinks the limit by the 3 rows already delivered.
    RowSet expectedRows =
        RowSet.newBuilder()
            .addRowRanges(RowRange.newBuilder().setStartKeyOpen(bs("c")).setEndKeyOpen(bs("z")))
            .build();
    assertThat(startedRequests.get(1).getRows()).isEqualTo(expectedRows);
    assertThat(startedRequests.get(1).getRowsLimit()).isEqualTo(7);
  }

  @Test
  void parkedFailure_suspendsUntilRequestNext() {
    FakeAttempt first = addAttempt(l -> l.onMessage(response("a", "b")));
    addAttempt(
        l -> {
          l.onMessage(response("c"));
          l.onClose(serverOk());
        });

    CollectingListener listener = new CollectingListener();
    VRpcCallContext ctx = newContext();
    RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> retrying = newRetrying();

    retrying.start(request(range("a", "z"), 0), ctx, listener);
    assertThat(listener.messages).containsExactly(response("a", "b"));

    // A transport failure arrives while no response is demanded (outstanding == 0). The retry must
    // park rather than push an unsolicited response.
    first.deliverSpontaneous(transportError());
    assertThat(listener.close).isNull();
    assertThat(startedRequests).hasSize(1);

    // Demand resumes the deferred attempt with a request narrowed past "b".
    requestNext(retrying, ctx);

    assertThat(listener.messages).containsExactly(response("a", "b"), response("c")).inOrder();
    assertThat(listener.close).isNotNull();
    assertThat(listener.close.getStatus().isOk()).isTrue();

    assertThat(startedRequests).hasSize(2);
    assertThat(startedRequests.get(1).getRows().getRowRanges(0).getStartKeyOpen())
        .isEqualTo(bs("b"));
  }

  @Test
  void nonRetryableError_closesWithoutRetry() {
    addAttempt(l -> l.onClose(rejectedError()));

    CollectingListener listener = new CollectingListener();
    VRpcCallContext ctx = newContext();
    RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> retrying =
        newRetrying(VRpcResumptionStrategy.noOp());

    retrying.start(request(range("a", "z"), 0), ctx, listener);

    assertThat(listener.messages).isEmpty();
    assertThat(listener.close).isNotNull();
    assertThat(listener.close.getStatus().getCode()).isEqualTo(Status.Code.FAILED_PRECONDITION);
    assertThat(startedRequests).hasSize(1);
  }

  @Test
  void transportFailures_boundedAtThreeRetries() {
    // Four attempts that all fail in transport with no progress: attempts 0..2 retry, attempt 3 is
    // beyond the bound and closes the operation.
    for (int i = 0; i < 4; i++) {
      addAttempt(l -> l.onClose(transportError()));
    }

    CollectingListener listener = new CollectingListener();
    VRpcCallContext ctx = newContext();
    RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> retrying =
        newRetrying(VRpcResumptionStrategy.noOp());

    retrying.start(request(range("a", "z"), 0), ctx, listener);

    assertThat(startedRequests).hasSize(4);
    assertThat(listener.close).isNotNull();
    assertThat(listener.close.getStatus().getCode()).isEqualTo(Status.Code.UNAVAILABLE);
  }

  // --- helpers ---------------------------------------------------------------

  private RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> newRetrying() {
    return newRetrying(new SessionReadRowsResumptionStrategy());
  }

  private RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> newRetrying(
      VRpcResumptionStrategy<SessionReadRowsRequest, SessionReadRowsResponse> strategy) {
    return new RetryingVRpc<>(
        attemptFactory, timer, strategy, NoopMetrics.NoopDebugTracer.INSTANCE);
  }

  private static VRpcCallContext newContext() {
    return VRpcCallContext.create(Deadline.after(1, TimeUnit.MINUTES), true, TRACER);
  }

  private static void requestNext(
      RetryingVRpc<SessionReadRowsRequest, SessionReadRowsResponse> retrying, VRpcCallContext ctx) {
    ctx.getExecutor().execute(retrying::requestNext);
  }

  private FakeAttempt addAttempt(Step... steps) {
    FakeAttempt attempt = new FakeAttempt(Arrays.asList(steps), startedRequests);
    attemptQueue.add(attempt);
    return attempt;
  }

  private static VRpcResult transportError() {
    return VRpcResult.createLocalTransportError(
        Status.UNAVAILABLE.withDescription("fake transport"));
  }

  private static VRpcResult rejectedError() {
    return VRpcResult.createRejectedError(Status.FAILED_PRECONDITION.withDescription("no retry"));
  }

  private static VRpcResult serverOk() {
    return VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance());
  }

  private static ByteString bs(String s) {
    return ByteString.copyFromUtf8(s);
  }

  private static RowSet range(String startClosed, String endOpen) {
    return RowSet.newBuilder()
        .addRowRanges(
            RowRange.newBuilder().setStartKeyClosed(bs(startClosed)).setEndKeyOpen(bs(endOpen)))
        .build();
  }

  private static SessionReadRowsRequest request(RowSet rows, long rowsLimit) {
    SessionReadRowsRequest.Builder builder = SessionReadRowsRequest.newBuilder().setRows(rows);
    if (rowsLimit > 0) {
      builder.setRowsLimit(rowsLimit);
    }
    return builder.build();
  }

  private static SessionReadRowsResponse response(String... keys) {
    SessionReadRowsResponse.Builder builder = SessionReadRowsResponse.newBuilder();
    for (String key : keys) {
      builder.addRow(Row.newBuilder().setKey(bs(key)));
    }
    return builder.build();
  }

  /** A single scripted interaction with the fake attempt's listener. */
  private interface Step {
    void run(VRpcListener<SessionReadRowsResponse> listener);
  }

  /**
   * A scripted stand-in for one attempt-level {@link VRpc}. {@code start} runs step 0, and each
   * subsequent {@code requestNext} runs the next step. Every step is dispatched through the op
   * executor so it observes the same affinity guarantees a real attempt would.
   */
  private static final class FakeAttempt
      implements VRpc<SessionReadRowsRequest, SessionReadRowsResponse> {

    private final List<Step> steps;
    private final List<SessionReadRowsRequest> startedRequests;
    private int nextStep;
    private VRpcCallContext ctx;
    private VRpcListener<SessionReadRowsResponse> listener;
    private boolean cancelled;

    FakeAttempt(List<Step> steps, List<SessionReadRowsRequest> startedRequests) {
      this.steps = steps;
      this.startedRequests = startedRequests;
    }

    @Override
    public void start(
        SessionReadRowsRequest req,
        VRpcCallContext ctx,
        VRpcListener<SessionReadRowsResponse> listener) {
      this.ctx = ctx;
      this.listener = listener;
      startedRequests.add(req);
      advance();
    }

    @Override
    public void requestNext() {
      advance();
    }

    private void advance() {
      Step step = steps.get(nextStep++);
      ctx.getExecutor().execute(() -> step.run(listener));
    }

    /** Deliver a terminal result out of band, i.e. without a corresponding requestNext. */
    void deliverSpontaneous(VRpcResult result) {
      ctx.getExecutor().execute(() -> listener.onClose(result));
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      cancelled = true;
    }

    @Override
    public boolean isDone() {
      return false;
    }
  }

  private static final class CollectingListener implements VRpcListener<SessionReadRowsResponse> {
    final List<SessionReadRowsResponse> messages = new ArrayList<>();
    @Nullable VRpcResult close;

    @Override
    public void onMessage(SessionReadRowsResponse msg) {
      messages.add(msg);
    }

    @Override
    public void onClose(VRpcResult result) {
      close = result;
    }
  }
}
