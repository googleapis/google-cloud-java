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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.cloud.spanner.spi.v1.BatchWriteRetryPolicy.Action;
import com.google.cloud.spanner.spi.v1.BatchWriteRetryPolicy.RetryDecision;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link BatchWriteRetryPolicy}. */
@RunWith(JUnit4.class)
public class BatchWriteRetryPolicyTest {

  private static final Set<Code> DEFAULT_CODES =
      ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED);

  private static RetrySettings defaultSettings() {
    return RetrySettings.newBuilder()
        .setInitialRetryDelayDuration(Duration.ofMillis(100))
        .setRetryDelayMultiplier(2.0)
        .setMaxRetryDelayDuration(Duration.ofSeconds(10))
        .setMaxAttempts(5)
        .setInitialRpcTimeoutDuration(Duration.ofSeconds(30))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeoutDuration(Duration.ofSeconds(30))
        .setTotalTimeoutDuration(Duration.ofMinutes(5))
        .build();
  }

  private static ApiException apiException(Status.Code code, String msg) {
    return ApiExceptionFactory.createException(
        msg, null, GrpcStatusCode.of(code), /* retryable= */ false);
  }

  private static WatchdogTimeoutException watchdogTimeout(boolean retryable) {
    WatchdogTimeoutException ex = mock(WatchdogTimeoutException.class);
    when(ex.isRetryable()).thenReturn(retryable);
    when(ex.getStatusCode()).thenReturn(WatchdogTimeoutException.LOCAL_ABORTED_STATUS_CODE);
    return ex;
  }

  private static final class FakeClock implements ApiClock {
    private final AtomicLong nanos = new AtomicLong(1_000_000_000L);

    @Override
    public long nanoTime() {
      return nanos.get();
    }

    @Override
    public long millisTime() {
      return TimeUnit.NANOSECONDS.toMillis(nanos.get());
    }

    void advanceMillis(long millis) {
      nanos.addAndGet(TimeUnit.MILLISECONDS.toNanos(millis));
    }
  }

  @Test
  public void isRetryableCoversRetryableCodesInternalErrorsAndWatchdogTimeouts() {
    FakeClock clock = new FakeClock();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);

    assertTrue(policy.isRetryable(apiException(Status.Code.UNAVAILABLE, "transient")));
    assertTrue(policy.isRetryable(apiException(Status.Code.RESOURCE_EXHAUSTED, "throttled")));
    assertTrue(
        policy.isRetryable(
            apiException(Status.Code.INTERNAL, "HTTP/2 error code: INTERNAL_ERROR")));
    assertTrue(policy.isRetryable(watchdogTimeout(true)));

    assertFalse(policy.isRetryable(apiException(Status.Code.INVALID_ARGUMENT, "bad")));
    assertFalse(policy.isRetryable(apiException(Status.Code.INTERNAL, "unexpected bug")));
    assertFalse(policy.isRetryable(watchdogTimeout(false)));

    // Empty retryableCodes disables all retries including retryable INTERNAL and wait watchdog.
    BatchWriteRetryPolicy disabledPolicy =
        new BatchWriteRetryPolicy(defaultSettings(), Collections.emptySet(), clock, () -> 1.0);
    assertFalse(disabledPolicy.isRetryable(apiException(Status.Code.UNAVAILABLE, "transient")));
    assertFalse(
        disabledPolicy.isRetryable(
            apiException(Status.Code.INTERNAL, "HTTP/2 error code: INTERNAL_ERROR")));
    assertFalse(disabledPolicy.isRetryable(watchdogTimeout(true)));

    // maxAttempts == 1 disables all retries.
    BatchWriteRetryPolicy oneAttemptPolicy =
        new BatchWriteRetryPolicy(
            defaultSettings().toBuilder().setMaxAttempts(1).build(),
            DEFAULT_CODES,
            clock,
            () -> 1.0);
    assertFalse(oneAttemptPolicy.isRetryable(apiException(Status.Code.UNAVAILABLE, "transient")));
  }

  @Test
  public void backoffAppliesJitterAndCapsAtMaxRetryDelay() {
    FakeClock clock = new FakeClock();
    // jitterRandom = 0.0 -> factor 0.5; jitterRandom = 1.0 -> factor 1.0
    BatchWriteRetryPolicy minJitter =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 0.0);
    BatchWriteRetryPolicy maxJitter =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);

    Throwable err = apiException(Status.Code.UNAVAILABLE, "transient");
    assertEquals(50L, minJitter.computeNextRetryDelayMillis(err, 1));
    assertEquals(100L, maxJitter.computeNextRetryDelayMillis(err, 1));
    assertEquals(100L, minJitter.computeNextRetryDelayMillis(err, 2));
    assertEquals(200L, maxJitter.computeNextRetryDelayMillis(err, 2));
    // Attempt 10 would exceed 10s cap -> capped at 10_000ms * factor
    assertEquals(5_000L, minJitter.computeNextRetryDelayMillis(err, 10));
    assertEquals(10_000L, maxJitter.computeNextRetryDelayMillis(err, 10));
  }

  @Test
  public void retryInfoTrailerOverridesExponentialBackoffAndCorruptedTrailerFallsBack() {
    FakeClock clock = new FakeClock();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);

    Metadata trailers = new Metadata();
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    trailers.put(key, RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(345)).build());
    StatusRuntimeException withRetryInfo =
        Status.UNAVAILABLE.withDescription("retry later").asRuntimeException(trailers);

    assertEquals(345L, policy.computeNextRetryDelayMillis(withRetryInfo, 1));

    // Corrupted RetryInfo bytes must fall back to exponential backoff (100ms).
    Metadata badTrailers = new Metadata();
    badTrailers.put(
        Metadata.Key.of("google.rpc.retryinfo-bin", Metadata.BINARY_BYTE_MARSHALLER),
        new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
    StatusRuntimeException withBadTrailer =
        Status.UNAVAILABLE.withDescription("corrupt trailer").asRuntimeException(badTrailers);

    assertEquals(100L, policy.computeNextRetryDelayMillis(withBadTrailer, 1));
  }

  @Test
  public void evaluateEnforcesMaxAttemptsTotalTimeoutContextAndCallOptionsDeadlines() {
    FakeClock clock = new FakeClock();
    RetrySettings settings =
        defaultSettings().toBuilder()
            .setMaxAttempts(3)
            .setTotalTimeoutDuration(Duration.ofMillis(500))
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(settings, DEFAULT_CODES, clock, () -> 1.0);
    Throwable unavailable = apiException(Status.Code.UNAVAILABLE, "transient");
    long startNanos = clock.nanoTime();

    // Attempt 1 -> retry with 100ms delay
    RetryDecision d1 = policy.evaluate(unavailable, 1, startNanos, Context.ROOT, null);
    assertEquals(Action.RETRY, d1.action);
    assertEquals(100L, d1.delayMillis);

    // Attempt 3 == maxAttempts -> retries exhausted
    RetryDecision exhausted = policy.evaluate(unavailable, 3, startNanos, Context.ROOT, null);
    assertEquals(Action.RETRIES_EXHAUSTED, exhausted.action);
    assertEquals(unavailable, exhausted.terminalError);

    // Advance clock to 450ms elapsed; next delay 100ms exceeds remaining 50ms of 500ms totalTimeout
    clock.advanceMillis(450);
    RetryDecision totalTimeout = policy.evaluate(unavailable, 1, startNanos, Context.ROOT, null);
    assertEquals(Action.RETRIES_EXHAUSTED, totalTimeout.action);
    assertEquals(
        Code.DEADLINE_EXCEEDED,
        ((ApiException) totalTimeout.terminalError).getStatusCode().getCode());

    // CallOptions deadline shorter than delay fails immediately with DEADLINE_EXCEEDED
    FakeClock freshClock = new FakeClock();
    BatchWriteRetryPolicy freshPolicy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, freshClock, () -> 1.0);
    Deadline tightCallDeadline = Deadline.after(20, TimeUnit.MILLISECONDS);
    RetryDecision callDeadlineDecision =
        freshPolicy.evaluate(
            unavailable, 1, freshClock.nanoTime(), Context.ROOT, tightCallDeadline);
    assertEquals(Action.RETRIES_EXHAUSTED, callDeadlineDecision.action);
    assertEquals(
        Code.DEADLINE_EXCEEDED,
        ((ApiException) callDeadlineDecision.terminalError).getStatusCode().getCode());

    // Cancelled gRPC context -> CANCELLED; expired gRPC context -> PERMANENT_FAILURE
    // DEADLINE_EXCEEDED
    Context.CancellableContext cancelled = Context.ROOT.withCancellation();
    cancelled.cancel(null);
    try {
      RetryDecision cancelDecision =
          freshPolicy.evaluate(unavailable, 1, freshClock.nanoTime(), cancelled, null);
      assertEquals(Action.CANCELLED, cancelDecision.action);
      assertEquals(
          Code.CANCELLED, ((ApiException) cancelDecision.terminalError).getStatusCode().getCode());
    } finally {
      cancelled.close();
    }

    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    Context.CancellableContext expired =
        Context.ROOT.withDeadlineAfter(0, TimeUnit.MILLISECONDS, scheduler);
    try {
      RetryDecision deadlineDecision =
          freshPolicy.evaluate(unavailable, 1, freshClock.nanoTime(), expired, null);
      assertEquals(Action.PERMANENT_FAILURE, deadlineDecision.action);
      assertEquals(
          Code.DEADLINE_EXCEEDED,
          ((ApiException) deadlineDecision.terminalError).getStatusCode().getCode());
    } finally {
      expired.close();
      scheduler.shutdownNow();
    }
  }

  @Test
  public void computeAttemptRpcTimeoutClampsToRemainingTotalTimeout() {
    FakeClock clock = new FakeClock();
    RetrySettings settings =
        defaultSettings().toBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(25))
            .setTotalTimeoutDuration(Duration.ofSeconds(15))
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(settings, DEFAULT_CODES, clock, () -> 1.0);
    long startNanos = clock.nanoTime();

    // Attempt 0: min(10s, 15s) = 10s
    assertEquals(Duration.ofSeconds(10), policy.computeAttemptRpcTimeout(0, null, startNanos));
    // Explicit smaller timeout wins over configured RPC timeout
    assertEquals(
        Duration.ofSeconds(4),
        policy.computeAttemptRpcTimeout(0, Duration.ofSeconds(4), startNanos));
    // Attempt 1 after 12s elapsed: remaining totalTimeout is 3s < 20s scaled RPC timeout
    clock.advanceMillis(12_000);
    assertEquals(Duration.ofSeconds(3), policy.computeAttemptRpcTimeout(1, null, startNanos));

    // checkDeadlineExceeded returns null when within budget and DEADLINE_EXCEEDED once past budget
    assertNull(policy.checkDeadlineExceeded(startNanos, Context.ROOT, null, 0L, null));
    clock.advanceMillis(3_000);
    ApiException exceeded = policy.checkDeadlineExceeded(startNanos, Context.ROOT, null, 0L, null);
    assertNotNull(exceeded);
    assertEquals(Code.DEADLINE_EXCEEDED, exceeded.getStatusCode().getCode());
  }
}
