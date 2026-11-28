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

import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.cloud.spanner.StreamingRetryHelper;
import com.google.cloud.spanner.spi.v1.BatchWriteRetryPolicy.Action;
import com.google.cloud.spanner.spi.v1.BatchWriteRetryPolicy.RetryDecision;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.Collections;
import java.util.EnumSet;
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
    try {
      Constructor<WatchdogTimeoutException> ctor =
          WatchdogTimeoutException.class.getDeclaredConstructor(String.class, boolean.class);
      ctor.setAccessible(true);
      return ctor.newInstance(retryable ? "wait timeout" : "idle timeout", retryable);
    } catch (ReflectiveOperationException e) {
      throw new AssertionError("Failed to construct WatchdogTimeoutException", e);
    }
  }

  private static final class FakeClock extends Deadline.Ticker implements ApiClock {
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
    assertTrue(policy.isRetryable(Status.UNAVAILABLE.withDescription("grpc").asRuntimeException()));
    assertTrue(policy.isRetryable(Status.RESOURCE_EXHAUSTED.withDescription("grpc").asException()));
    assertTrue(
        policy.isRetryable(
            apiException(Status.Code.INTERNAL, "HTTP/2 error code: INTERNAL_ERROR")));
    assertTrue(policy.isRetryable(watchdogTimeout(true)));

    assertFalse(policy.isRetryable(apiException(Status.Code.INVALID_ARGUMENT, "bad")));
    assertFalse(policy.isRetryable(Status.INVALID_ARGUMENT.asRuntimeException()));
    assertFalse(policy.isRetryable(Status.PERMISSION_DENIED.asException()));
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
    assertEquals(Duration.ofMillis(50), minJitter.computeNextRetryDelay(err, 1));
    assertEquals(Duration.ofMillis(100), maxJitter.computeNextRetryDelay(err, 1));
    assertEquals(Duration.ofMillis(100), minJitter.computeNextRetryDelay(err, 2));
    assertEquals(Duration.ofMillis(200), maxJitter.computeNextRetryDelay(err, 2));
    // Attempt 10 would exceed 10s cap -> capped at 10_000ms * factor
    assertEquals(Duration.ofSeconds(5), minJitter.computeNextRetryDelay(err, 10));
    assertEquals(Duration.ofSeconds(10), maxJitter.computeNextRetryDelay(err, 10));
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

    assertEquals(Duration.ofMillis(345), policy.computeNextRetryDelay(withRetryInfo, 1));

    // RetryInfo provided via ApiException.getErrorDetails() overrides exponential backoff.
    RetryInfo detailsRetryInfo =
        RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(678)).build();
    ApiException withErrorDetails =
        ApiExceptionFactory.createException(
            "retry via error details",
            null,
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            /* retryable= */ true,
            ErrorDetails.builder()
                .setRawErrorMessages(Collections.singletonList(Any.pack(detailsRetryInfo)))
                .build());
    assertEquals(Duration.ofMillis(678), policy.computeNextRetryDelay(withErrorDetails, 1));

    // Corrupted RetryInfo bytes must fall back to exponential backoff (100ms).
    Metadata badTrailers = new Metadata();
    badTrailers.put(
        Metadata.Key.of("google.rpc.retryinfo-bin", Metadata.BINARY_BYTE_MARSHALLER),
        new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
    StatusRuntimeException withBadTrailer =
        Status.UNAVAILABLE.withDescription("corrupt trailer").asRuntimeException(badTrailers);

    assertEquals(Duration.ofMillis(100), policy.computeNextRetryDelay(withBadTrailer, 1));

    // Negative RetryInfo duration must fall back to exponential backoff.
    Metadata negativeTrailers = new Metadata();
    negativeTrailers.put(
        key, RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(-500)).build());
    StatusRuntimeException withNegativeRetryInfo =
        Status.UNAVAILABLE.withDescription("negative delay").asRuntimeException(negativeTrailers);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(withNegativeRetryInfo));
    assertEquals(Duration.ofMillis(100), policy.computeNextRetryDelay(withNegativeRetryInfo, 1));

    // Mutating caller-supplied retryableCodes after construction must not affect the policy.
    Set<Code> mutableCodes = EnumSet.of(Code.UNAVAILABLE);
    BatchWriteRetryPolicy isolatedPolicy =
        new BatchWriteRetryPolicy(defaultSettings(), mutableCodes, clock, () -> 1.0);
    mutableCodes.clear();
    assertTrue(isolatedPolicy.isRetryable(apiException(Status.Code.UNAVAILABLE, "transient")));
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

    // Non-retryable error -> PERMANENT_FAILURE
    Throwable invalidArgument = apiException(Status.Code.INVALID_ARGUMENT, "bad");
    RetryDecision permanentFailure =
        policy.evaluate(invalidArgument, 1, startNanos, Context.ROOT, null);
    assertEquals(Action.PERMANENT_FAILURE, permanentFailure.action);
    assertEquals(invalidArgument, permanentFailure.terminalError);

    // maxAttempts == 0 means unlimited retries (GAX convention)
    BatchWriteRetryPolicy unlimitedPolicy =
        new BatchWriteRetryPolicy(
            defaultSettings().toBuilder().setMaxAttempts(0).build(),
            DEFAULT_CODES,
            clock,
            () -> 1.0);
    RetryDecision unlimitedDecision =
        unlimitedPolicy.evaluate(unavailable, 100, startNanos, Context.ROOT, null);
    assertEquals(Action.RETRY, unlimitedDecision.action);

    // Attempt 1 -> retry with 100ms delay
    RetryDecision d1 = policy.evaluate(unavailable, 1, startNanos, Context.ROOT, null);
    assertEquals(Action.RETRY, d1.action);
    assertEquals(Duration.ofMillis(100), d1.delay);

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

    // Deterministic CallOptions deadlines via FakeClock (Deadline.Ticker):
    // deadline larger than 100ms delay -> RETRY; deadline shorter than 100ms delay ->
    // RETRIES_EXHAUSTED with DEADLINE_EXCEEDED.
    FakeClock freshClock = new FakeClock();
    BatchWriteRetryPolicy freshPolicy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, freshClock, () -> 1.0);
    Deadline generousCallDeadline = Deadline.after(500, TimeUnit.MILLISECONDS, freshClock);
    RetryDecision generousCallDecision =
        freshPolicy.evaluate(
            unavailable, 1, freshClock.nanoTime(), Context.ROOT, generousCallDeadline);
    assertEquals(Action.RETRY, generousCallDecision.action);
    assertEquals(Duration.ofMillis(100), generousCallDecision.delay);

    Deadline tightCallDeadline = Deadline.after(20, TimeUnit.MILLISECONDS, freshClock);
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
    // Active (non-cancelled) grpcContext deadline shorter than 100ms retry delay ->
    // RETRIES_EXHAUSTED with DEADLINE_EXCEEDED. Schedule wall-clock cancellation far out (10s) and
    // advance FakeClock by 9980ms so 20ms deterministically remain without racing the scheduler.
    Context.CancellableContext tightContext =
        Context.ROOT.withDeadline(Deadline.after(10, TimeUnit.SECONDS, freshClock), scheduler);
    try {
      freshClock.advanceMillis(9_980);
      assertFalse(tightContext.isCancelled());
      RetryDecision tightContextDecision =
          freshPolicy.evaluate(unavailable, 1, freshClock.nanoTime(), tightContext, null);
      assertEquals(Action.RETRIES_EXHAUSTED, tightContextDecision.action);
      assertEquals(
          Code.DEADLINE_EXCEEDED,
          ((ApiException) tightContextDecision.terminalError).getStatusCode().getCode());
    } finally {
      tightContext.close();
    }

    Context.CancellableContext expired =
        Context.ROOT.withDeadline(Deadline.after(-1, TimeUnit.SECONDS, freshClock), scheduler);
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
  public void computeAttemptRpcTimeoutScalesCapsAndClampsToRemainingTotalTimeout() {
    FakeClock clock = new FakeClock();
    RetrySettings settings =
        defaultSettings().toBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofSeconds(10))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(25))
            .setTotalTimeoutDuration(Duration.ofSeconds(60))
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(settings, DEFAULT_CODES, clock, () -> 1.0);
    long startNanos = clock.nanoTime();

    // Attempt 0: initial 10s
    assertEquals(Duration.ofSeconds(10), policy.computeAttemptRpcTimeout(0, null, startNanos));
    // Attempt 1: 10s * 2.0 = 20s (verifies rpcTimeoutMultiplier)
    assertEquals(Duration.ofSeconds(20), policy.computeAttemptRpcTimeout(1, null, startNanos));
    // Attempt 2: min(10s * 4.0, 25s) = 25s (verifies maxRpcTimeoutDuration cap)
    assertEquals(Duration.ofSeconds(25), policy.computeAttemptRpcTimeout(2, null, startNanos));
    // Explicit smaller timeout wins over configured RPC timeout
    assertEquals(
        Duration.ofSeconds(4),
        policy.computeAttemptRpcTimeout(0, Duration.ofSeconds(4), startNanos));
    // Attempt 1 after 57s elapsed: remaining totalTimeout is 3s < 20s scaled RPC timeout
    clock.advanceMillis(57_000);
    assertEquals(Duration.ofSeconds(3), policy.computeAttemptRpcTimeout(1, null, startNanos));

    // checkDeadlineExceeded returns null when within budget and DEADLINE_EXCEEDED once past budget
    assertNull(policy.checkDeadlineExceeded(startNanos, Context.ROOT, null, Duration.ZERO, null));
    clock.advanceMillis(3_000);
    ApiException exceeded =
        policy.checkDeadlineExceeded(startNanos, Context.ROOT, null, Duration.ZERO, null);
    assertNotNull(exceeded);
    assertEquals(Code.DEADLINE_EXCEEDED, exceeded.getStatusCode().getCode());
  }

  @Test
  public void zeroInitialRetryDelayProducesZeroBackoff() {
    FakeClock clock = new FakeClock();
    RetrySettings zeroDelaySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ZERO)
            .setMaxRetryDelayDuration(Duration.ZERO)
            .setMaxAttempts(5)
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(zeroDelaySettings, DEFAULT_CODES, clock, () -> 1.0);
    Throwable unavailable = apiException(Status.Code.UNAVAILABLE, "transient");
    assertEquals(Duration.ZERO, policy.computeNextRetryDelay(unavailable, 1));
  }

  @Test
  public void retryInfoExceedingMaxRetryDelayIsClamped() {
    FakeClock clock = new FakeClock();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);
    Metadata trailers = new Metadata();
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    trailers.put(
        key,
        RetryInfo.newBuilder()
            .setRetryDelay(Durations.fromSeconds(TimeUnit.HOURS.toSeconds(3L)))
            .build());
    StatusRuntimeException threeHourError =
        Status.UNAVAILABLE.withDescription("slow down").asRuntimeException(trailers);

    assertEquals(Duration.ofSeconds(10), policy.computeNextRetryDelay(threeHourError, 1));
    RetryDecision decision =
        policy.evaluate(threeHourError, 1, clock.nanoTime(), Context.ROOT, null);
    assertEquals(Action.RETRY, decision.action);
    assertEquals(Duration.ofSeconds(10), decision.delay);
  }

  @Test
  public void retryInfoWithUnsetMaxRetryDelayIsClampedToDefaultCap() {
    FakeClock clock = new FakeClock();
    RetrySettings unsetMaxSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ZERO)
            .setMaxRetryDelayDuration(Duration.ZERO)
            .setMaxAttempts(5)
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(unsetMaxSettings, DEFAULT_CODES, clock, () -> 1.0);
    Metadata trailers = new Metadata();
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    trailers.put(
        key,
        RetryInfo.newBuilder()
            .setRetryDelay(Durations.fromSeconds(TimeUnit.HOURS.toSeconds(3L)))
            .build());
    StatusRuntimeException threeHourError =
        Status.UNAVAILABLE.withDescription("slow down").asRuntimeException(trailers);

    assertEquals(Duration.ofSeconds(32), policy.computeNextRetryDelay(threeHourError, 1));
  }

  @Test
  public void zeroAndSubMillisecondRetryInfoFallBackToBackoff() {
    FakeClock clock = new FakeClock();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

    Metadata zeroTrailers = new Metadata();
    zeroTrailers.put(key, RetryInfo.newBuilder().setRetryDelay(Durations.ZERO).build());
    StatusRuntimeException zeroError =
        Status.UNAVAILABLE.withDescription("zero delay").asRuntimeException(zeroTrailers);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(zeroError));
    assertEquals(Duration.ofMillis(100), policy.computeNextRetryDelay(zeroError, 1));

    Metadata subMsTrailers = new Metadata();
    subMsTrailers.put(
        key,
        RetryInfo.newBuilder()
            .setRetryDelay(com.google.protobuf.Duration.newBuilder().setNanos(500_000).build())
            .build());
    StatusRuntimeException subMsError =
        Status.UNAVAILABLE.withDescription("sub-ms delay").asRuntimeException(subMsTrailers);
    assertNull(StreamingRetryHelper.extractServerRetryDelay(subMsError));
    assertEquals(Duration.ofMillis(100), policy.computeNextRetryDelay(subMsError, 1));
  }

  @Test
  public void unsetInitialAndMaxRetryDelayPreservesZeroBackoff() {
    FakeClock clock = new FakeClock();
    RetrySettings unsetSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ZERO)
            .setRetryDelayMultiplier(10.0)
            .setMaxRetryDelayDuration(Duration.ZERO)
            .setMaxAttempts(10)
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(unsetSettings, DEFAULT_CODES, clock, () -> 1.0);
    Throwable unavailable = apiException(Status.Code.UNAVAILABLE, "transient");

    assertEquals(Duration.ZERO, policy.computeNextRetryDelay(unavailable, 1));
    assertEquals(Duration.ZERO, policy.computeNextRetryDelay(unavailable, 5));
  }

  @Test
  public void extractsRetryInfoFromGrpcStatusDetailsAndSurvivesCorruptAny() {
    FakeClock clock = new FakeClock();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);
    Metadata.Key<byte[]> detailsKey =
        Metadata.Key.of("grpc-status-details-bin", Metadata.BINARY_BYTE_MARSHALLER);
    Metadata.Key<RetryInfo> retryInfoKey = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

    // Valid grpc-status-details-bin on a wrapped cause chain.
    com.google.rpc.Status validStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
            .addDetails(
                Any.pack(RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(450L)).build()))
            .build();
    Metadata validDetails = new Metadata();
    validDetails.put(detailsKey, validStatus.toByteArray());
    Throwable wrappedStatus =
        new RuntimeException("outer", Status.UNAVAILABLE.asRuntimeException(validDetails));
    assertEquals(Duration.ofMillis(450), policy.computeNextRetryDelay(wrappedStatus, 1));

    // Corrupt Any RetryInfo inside grpc-status-details-bin falls back to backoff.
    Any corruptRetryInfoAny =
        Any.newBuilder()
            .setTypeUrl("type.googleapis.com/google.rpc.RetryInfo")
            .setValue(ByteString.copyFrom(new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF}))
            .build();
    com.google.rpc.Status corruptStatus =
        com.google.rpc.Status.newBuilder()
            .setCode(com.google.rpc.Code.UNAVAILABLE_VALUE)
            .addDetails(corruptRetryInfoAny)
            .build();
    Metadata corruptDetails = new Metadata();
    corruptDetails.put(detailsKey, corruptStatus.toByteArray());
    StatusRuntimeException corruptAnyError =
        Status.UNAVAILABLE.withDescription("corrupt any").asRuntimeException(corruptDetails);
    assertEquals(Duration.ofMillis(100), policy.computeNextRetryDelay(corruptAnyError, 1));

    // Corrupt ErrorDetails falls through to a valid google.rpc.retryinfo-bin trailer.
    Metadata mixedTrailers = new Metadata();
    mixedTrailers.put(detailsKey, corruptStatus.toByteArray());
    mixedTrailers.put(
        retryInfoKey, RetryInfo.newBuilder().setRetryDelay(Durations.fromMillis(450L)).build());
    StatusRuntimeException mixedError =
        Status.UNAVAILABLE.withDescription("mixed").asRuntimeException(mixedTrailers);
    assertEquals(Duration.ofMillis(450), policy.computeNextRetryDelay(mixedError, 1));
  }

  @Test
  public void computeAttemptRpcTimeoutHandlesOverflowAndSubMillisecond() {
    FakeClock clock = new FakeClock();
    RetrySettings overflowSettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofMillis(Long.MAX_VALUE))
            .setRpcTimeoutMultiplier(2.0)
            .setMaxRpcTimeoutDuration(Duration.ofSeconds(Long.MAX_VALUE))
            .setTotalTimeoutDuration(Duration.ofMillis(Long.MAX_VALUE))
            .build();
    BatchWriteRetryPolicy overflowPolicy =
        new BatchWriteRetryPolicy(overflowSettings, DEFAULT_CODES, clock, () -> 1.0);
    Duration overflowTimeout = overflowPolicy.computeAttemptRpcTimeout(1, null, clock.nanoTime());
    assertNotNull(overflowTimeout);
    assertTrue(overflowTimeout.toMillis() >= 1L);

    RetrySettings subMsSettings =
        RetrySettings.newBuilder()
            .setInitialRpcTimeoutDuration(Duration.ofNanos(500_000L))
            .setRpcTimeoutMultiplier(1.0)
            .setMaxRpcTimeoutDuration(Duration.ofNanos(500_000L))
            .setTotalTimeoutDuration(Duration.ofNanos(500_000L))
            .build();
    BatchWriteRetryPolicy subMsPolicy =
        new BatchWriteRetryPolicy(subMsSettings, DEFAULT_CODES, clock, () -> 1.0);
    assertEquals(
        Duration.ofMillis(1L), subMsPolicy.computeAttemptRpcTimeout(0, null, clock.nanoTime()));
  }

  @Test
  public void subMillisecondRetryDelayIsPreservedInDuration() {
    FakeClock clock = new FakeClock();
    RetrySettings subMsSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(Duration.ofNanos(1))
            .setMaxRetryDelayDuration(Duration.ofNanos(1))
            .setMaxAttempts(5)
            .build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(subMsSettings, DEFAULT_CODES, clock, () -> 1.0);
    Throwable unavailable = apiException(Status.Code.UNAVAILABLE, "transient");
    assertEquals(Duration.ofNanos(1), policy.computeNextRetryDelay(unavailable, 1));
    RetryDecision decision = policy.evaluate(unavailable, 1, clock.nanoTime(), Context.ROOT, null);
    assertEquals(Action.RETRY, decision.action);
    assertEquals(Duration.ofNanos(1), decision.delay);
  }

  @Test
  public void internalExceptionWithNullMessageIsNotRetryable() {
    FakeClock clock = new FakeClock();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(defaultSettings(), DEFAULT_CODES, clock, () -> 1.0);
    ApiException nullMessageInternal = apiException(Status.Code.INTERNAL, null);
    assertFalse(policy.isRetryable(nullMessageInternal));
  }

  @Test
  public void evaluateWithMaxAttemptsOneReturnsRetriesExhaustedForRetryableError() {
    FakeClock clock = new FakeClock();
    RetrySettings oneAttemptSettings = defaultSettings().toBuilder().setMaxAttempts(1).build();
    BatchWriteRetryPolicy policy =
        new BatchWriteRetryPolicy(oneAttemptSettings, DEFAULT_CODES, clock, () -> 1.0);
    Throwable unavailable = apiException(Status.Code.UNAVAILABLE, "transient");
    RetryDecision decision = policy.evaluate(unavailable, 1, clock.nanoTime(), Context.ROOT, null);
    assertEquals(Action.RETRIES_EXHAUSTED, decision.action);
    assertEquals(unavailable, decision.terminalError);

    // Non-retryable errors still classify as PERMANENT_FAILURE when maxAttempts == 1.
    Throwable invalidArgument = apiException(Status.Code.INVALID_ARGUMENT, "bad");
    RetryDecision permanent =
        policy.evaluate(invalidArgument, 1, clock.nanoTime(), Context.ROOT, null);
    assertEquals(Action.PERMANENT_FAILURE, permanent.action);
    assertEquals(invalidArgument, permanent.terminalError);
  }
}
