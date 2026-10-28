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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.bigtable.v2.SessionMutateRowsResponse.RateLimitInfo;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.api.UnaryResponseFuture;
import com.google.cloud.bigtable.data.v2.internal.api.VRpcException;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.MutateRowsRetryingVRpcTest.ManualTimer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.common.base.Ticker;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import io.grpc.Deadline;
import io.grpc.Status;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(30)
class SessionMutateRowsRateLimiterTest {

  private FakeTicker ticker;
  private SessionMutateRowsRateLimiter limiter;
  private VRpcTracer tracer;

  @BeforeEach
  void setUp() {
    ticker = new FakeTicker();
    limiter = new SessionMutateRowsRateLimiter(SessionMutateRowsRateLimiter.DEFAULT_QPS, ticker);
    tracer = mock(VRpcTracer.class);
  }

  @Test
  void initialState_startsDisabledAtDefaultQpsWithZeroDelay() {
    assertThat(limiter.isEnabled()).isFalse();
    assertThat(limiter.getRate()).isEqualTo(10.0);
    assertThat(limiter.tryAcquireDelay(Duration.ofMillis(1))).hasValue(Duration.ZERO);
  }

  @Test
  void validRateLimitInfo_enablesLimiterUpdatesRateAndRecordsMetrics() {
    SessionMutateRowsResponse response =
        responseWithRateLimitInfo(/* factor= */ 0.8, /* periodSeconds= */ 10);

    limiter.onResponse(response, tracer);

    assertThat(limiter.isEnabled()).isTrue();
    assertThat(limiter.getRate()).isWithin(0.001).of(8.0);
    verify(tracer).recordBatchWriteFlowControlTargetQps(8.0);
    verify(tracer).recordBatchWriteFlowControlFactor(0.8, Status.Code.OK, true);
  }

  @Test
  void factorAndQpsBounds_areClamped() {
    // Factor 0.1 is clamped to MIN_FACTOR (0.7) -> 10.0 * 0.7 = 7.0
    limiter.onResponse(responseWithRateLimitInfo(0.1, 10), tracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(7.0);
    verify(tracer).recordBatchWriteFlowControlFactor(0.7, Status.Code.OK, true);

    // Advance past period; factor 5.0 is clamped to MAX_FACTOR (1.3) -> 7.0 * 1.3 = 9.1
    ticker.advance(Duration.ofSeconds(11));
    limiter.onResponse(responseWithRateLimitInfo(5.0, 10), tracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(9.1);
    verify(tracer).recordBatchWriteFlowControlFactor(1.3, Status.Code.OK, true);

    // Clamp to MIN_QPS (0.1)
    limiter.setRate(0.12);
    ticker.advance(Duration.ofSeconds(11));
    limiter.onResponse(responseWithRateLimitInfo(0.7, 10), tracer);
    assertThat(limiter.getRate()).isWithin(0.0001).of(SessionMutateRowsRateLimiter.MIN_QPS);

    // Clamp to MAX_QPS (100_000)
    limiter.setRate(90_000.0);
    ticker.advance(Duration.ofSeconds(11));
    limiter.onResponse(responseWithRateLimitInfo(1.3, 10), tracer);
    assertThat(limiter.getRate()).isWithin(0.1).of(SessionMutateRowsRateLimiter.MAX_QPS);
  }

  @Test
  void periodCooldown_blocksRateUpdateAndDisableWithinPeriodAndAllowsEnable() {
    // Apply initial update with 10s period: 10.0 * 0.8 = 8.0
    limiter.onResponse(responseWithRateLimitInfo(0.8, 10), tracer);
    assertThat(limiter.isEnabled()).isTrue();
    assertThat(limiter.getRate()).isWithin(0.001).of(8.0);

    // Within 10s period: another RateLimitInfo does NOT update QPS, records applied=false
    ticker.advance(Duration.ofSeconds(5));
    VRpcTracer secondTracer = mock(VRpcTracer.class);
    limiter.onResponse(responseWithRateLimitInfo(0.7, 10), secondTracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(8.0);
    verify(secondTracer).recordBatchWriteFlowControlFactor(0.7, Status.Code.OK, false);
    verify(secondTracer, never()).recordBatchWriteFlowControlTargetQps(8.0);

    // Within 10s period: missing RateLimitInfo does NOT disable limiter
    limiter.onResponse(SessionMutateRowsResponse.getDefaultInstance(), secondTracer);
    assertThat(limiter.isEnabled()).isTrue();

    // If manually disabled while still within period, valid RateLimitInfo re-enables immediately
    // without updating QPS
    limiter.setEnabled(false);
    limiter.onResponse(responseWithRateLimitInfo(0.7, 10), secondTracer);
    assertThat(limiter.isEnabled()).isTrue();
    assertThat(limiter.getRate()).isWithin(0.001).of(8.0);

    // After 10s period expires (> nextRateUpdateNanos), missing RateLimitInfo disables limiter
    ticker.advance(Duration.ofSeconds(6));
    limiter.onResponse(SessionMutateRowsResponse.getDefaultInstance(), secondTracer);
    assertThat(limiter.isEnabled()).isFalse();
    assertThat(limiter.getRate()).isWithin(0.001).of(8.0);
  }

  @Test
  void invalidRateLimitInfo_doesNotEnableOrUpdateRate() {
    // Factor == 0 -> invalid
    limiter.onResponse(responseWithRateLimitInfo(0.0, 10), tracer);
    assertThat(limiter.isEnabled()).isFalse();
    assertThat(limiter.getRate()).isEqualTo(10.0);

    // Period == 0 -> invalid
    limiter.onResponse(responseWithRateLimitInfo(0.8, 0), tracer);
    assertThat(limiter.isEnabled()).isFalse();
    assertThat(limiter.getRate()).isEqualTo(10.0);
  }

  @Test
  void overloadResults_reduceQpsByMinFactor() {
    // UNAVAILABLE -> 10.0 * 0.7 = 7.0
    limiter.onResult(VRpcResult.createLocalTransportError(Status.UNAVAILABLE), tracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(7.0);
    verify(tracer).recordBatchWriteFlowControlFactor(0.7, Status.Code.UNAVAILABLE, true);

    // DEADLINE_EXCEEDED after period -> 7.0 * 0.7 = 4.9
    ticker.advance(Duration.ofSeconds(11));
    limiter.onResult(VRpcResult.createRejectedError(Status.DEADLINE_EXCEEDED), tracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(4.9);
    verify(tracer).recordBatchWriteFlowControlFactor(0.7, Status.Code.DEADLINE_EXCEEDED, true);

    // RESOURCE_EXHAUSTED after period -> 4.9 * 0.7 = 3.43
    ticker.advance(Duration.ofSeconds(11));
    ErrorResponse.Builder exhausted = ErrorResponse.newBuilder();
    exhausted.getStatusBuilder().setCode(Code.RESOURCE_EXHAUSTED_VALUE);
    limiter.onResult(VRpcResult.createServerError(exhausted.build()), tracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(3.43);
    verify(tracer).recordBatchWriteFlowControlFactor(0.7, Status.Code.RESOURCE_EXHAUSTED, true);

    // Non-overload error (INVALID_ARGUMENT) does not change QPS
    ticker.advance(Duration.ofSeconds(11));
    ErrorResponse.Builder invalidArg = ErrorResponse.newBuilder();
    invalidArg.getStatusBuilder().setCode(Code.INVALID_ARGUMENT_VALUE);
    limiter.onResult(VRpcResult.createServerError(invalidArg.build()), tracer);
    assertThat(limiter.getRate()).isWithin(0.001).of(3.43);
  }

  @Test
  void tryAcquireDelay_reservesPermitsSmoothlyAndDoesNotConsumePermitWhenExceedingMaxWait() {
    SessionMutateRowsRateLimiter twoQpsLimiter = new SessionMutateRowsRateLimiter(2.0, ticker);
    twoQpsLimiter.setEnabled(true);

    // First call acquires immediately (0ms wait) and pushes nextFreeTicketNanos +500ms
    assertThat(twoQpsLimiter.tryAcquireDelay(Duration.ofSeconds(5))).hasValue(Duration.ZERO);

    // Second call immediately after gets 500ms delay and pushes nextFreeTicketNanos to +1000ms
    assertThat(twoQpsLimiter.tryAcquireDelay(Duration.ofSeconds(5)))
        .hasValue(Duration.ofMillis(500));

    // Third call with maxWait=400ms cannot wait 1000ms -> returns empty WITHOUT consuming a permit
    Optional<Duration> rejected = twoQpsLimiter.tryAcquireDelay(Duration.ofMillis(400));
    assertThat(rejected).isEmpty();

    // Subsequent call with maxWait=2s still sees 1000ms (proving rejected call burned no permit)
    assertThat(twoQpsLimiter.tryAcquireDelay(Duration.ofSeconds(2)))
        .hasValue(Duration.ofSeconds(1));
  }

  @Test
  void rateLimitingVRpc_schedulesThrottleOnTimerWithoutBlockingAndUpdatesLimiter()
      throws Exception {
    ManualTimer timer = new ManualTimer();
    SessionMutateRowsRateLimiter twoQpsLimiter = new SessionMutateRowsRateLimiter(2.0, ticker);
    twoQpsLimiter.setEnabled(true);
    // Reserve the immediate permit so the next call requires a 500ms throttle wait
    assertThat(twoQpsLimiter.tryAcquireDelay(Duration.ofSeconds(5))).hasValue(Duration.ZERO);

    AtomicBoolean delegateStarted = new AtomicBoolean(false);
    SessionMutateRowsResponse serverResp =
        responseWithRateLimitInfo(/* factor= */ 1.2, /* periodSeconds= */ 10);
    VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> delegate =
        new VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse>() {
          @Override
          public void start(
              SessionMutateRowsRequest req,
              VRpcCallContext ctx,
              VRpcListener<SessionMutateRowsResponse> listener) {
            delegateStarted.set(true);
            ctx.getExecutor()
                .execute(
                    () -> {
                      listener.onMessage(serverResp);
                      listener.onClose(
                          VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));
                    });
          }

          @Override
          public void cancel(@Nullable String message, @Nullable Throwable cause) {}

          @Override
          public boolean isDone() {
            return delegateStarted.get();
          }

          @Override
          public void requestNext() {}
        };

    RateLimitingVRpc rateLimitingVRpc = new RateLimitingVRpc(delegate, twoQpsLimiter, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    rateLimitingVRpc.start(
        SessionMutateRowsRequest.getDefaultInstance(),
        VRpcCallContext.create(Deadline.after(10, TimeUnit.SECONDS), true, tracer),
        future);

    // Must not start delegate until timer fires 500ms throttle timeout
    assertThat(delegateStarted.get()).isFalse();
    assertThat(timer.pendingCount()).isEqualTo(1);
    assertThat(timer.lastScheduledDelayNanos()).isEqualTo(Duration.ofMillis(500).toNanos());

    timer.fireNext();

    assertThat(delegateStarted.get()).isTrue();
    assertThat(future.get()).isEqualTo(serverResp);
    assertThat(twoQpsLimiter.getRate()).isWithin(0.001).of(2.4);
  }

  @Test
  void rateLimitingVRpc_failsFastWithDeadlineExceededWhenWaitExceedsRemainingDeadline() {
    ManualTimer timer = new ManualTimer();
    SessionMutateRowsRateLimiter oneQpsLimiter = new SessionMutateRowsRateLimiter(1.0, ticker);
    oneQpsLimiter.setEnabled(true);
    // Consume initial permit so next call needs 1000ms wait
    assertThat(oneQpsLimiter.tryAcquireDelay(Duration.ofSeconds(5))).hasValue(Duration.ZERO);

    AtomicBoolean delegateStarted = new AtomicBoolean(false);
    VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> delegate =
        noopDelegate(delegateStarted);

    RateLimitingVRpc rateLimitingVRpc = new RateLimitingVRpc(delegate, oneQpsLimiter, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    rateLimitingVRpc.start(
        SessionMutateRowsRequest.getDefaultInstance(),
        VRpcCallContext.create(
            Deadline.after(100, TimeUnit.MILLISECONDS), true, NoopMetrics.NoopVrpcTracer.INSTANCE),
        future);

    assertThat(delegateStarted.get()).isFalse();
    assertThat(timer.pendingCount()).isEqualTo(0);
    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(VRpcException.class);
    assertThat(((VRpcException) ex.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.DEADLINE_EXCEEDED);
  }

  @Test
  void rateLimitingVRpc_cancelAndTimerStopWhileThrottled_closesCancelledWithoutStartingDelegate() {
    ManualTimer timer = new ManualTimer();
    SessionMutateRowsRateLimiter oneQpsLimiter = new SessionMutateRowsRateLimiter(1.0, ticker);
    oneQpsLimiter.setEnabled(true);
    assertThat(oneQpsLimiter.tryAcquireDelay(Duration.ofSeconds(5))).hasValue(Duration.ZERO);

    AtomicBoolean delegateStarted = new AtomicBoolean(false);
    RateLimitingVRpc vRpc1 =
        new RateLimitingVRpc(noopDelegate(delegateStarted), oneQpsLimiter, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> f1 = new UnaryResponseFuture<>();
    vRpc1.start(
        SessionMutateRowsRequest.getDefaultInstance(),
        VRpcCallContext.create(
            Deadline.after(10, TimeUnit.SECONDS), true, NoopMetrics.NoopVrpcTracer.INSTANCE),
        f1);
    assertThat(timer.pendingCount()).isEqualTo(1);

    vRpc1.cancel("cancelled while throttled", null);
    assertThat(delegateStarted.get()).isFalse();
    assertThat(timer.pendingCount()).isEqualTo(0);
    ExecutionException ex1 = assertThrows(ExecutionException.class, f1::get);
    assertThat(((VRpcException) ex1.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.CANCELLED);

    // Also test timer.stop() while throttled
    RateLimitingVRpc vRpc2 =
        new RateLimitingVRpc(noopDelegate(delegateStarted), oneQpsLimiter, timer);
    UnaryResponseFuture<SessionMutateRowsResponse> f2 = new UnaryResponseFuture<>();
    vRpc2.start(
        SessionMutateRowsRequest.getDefaultInstance(),
        VRpcCallContext.create(
            Deadline.after(10, TimeUnit.SECONDS), true, NoopMetrics.NoopVrpcTracer.INSTANCE),
        f2);

    timer.stop();
    assertThat(delegateStarted.get()).isFalse();
    ExecutionException ex2 = assertThrows(ExecutionException.class, f2::get);
    assertThat(((VRpcException) ex2.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.CANCELLED);
  }

  private static SessionMutateRowsResponse responseWithRateLimitInfo(
      double factor, long periodSeconds) {
    return SessionMutateRowsResponse.newBuilder()
        .setRateLimitInfo(
            RateLimitInfo.newBuilder()
                .setFactor(factor)
                .setPeriod(Durations.fromSeconds(periodSeconds)))
        .build();
  }

  private static VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse> noopDelegate(
      AtomicBoolean started) {
    return new VRpc<SessionMutateRowsRequest, SessionMutateRowsResponse>() {
      @Override
      public void start(
          SessionMutateRowsRequest req,
          VRpcCallContext ctx,
          VRpcListener<SessionMutateRowsResponse> listener) {
        started.set(true);
      }

      @Override
      public void cancel(@Nullable String message, @Nullable Throwable cause) {}

      @Override
      public boolean isDone() {
        return false;
      }

      @Override
      public void requestNext() {}
    };
  }

  private static final class FakeTicker extends Ticker {
    private final AtomicLong nanos = new AtomicLong(1_000_000_000L);

    @Override
    public long read() {
      return nanos.get();
    }

    void advance(Duration duration) {
      nanos.addAndGet(duration.toNanos());
    }
  }
}
