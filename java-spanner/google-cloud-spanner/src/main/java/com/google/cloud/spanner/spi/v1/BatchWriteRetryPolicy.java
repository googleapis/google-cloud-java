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

import com.google.api.core.ApiClock;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.cloud.spanner.IsRetryableInternalError;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.DoubleSupplier;
import org.jspecify.annotations.Nullable;

/**
 * Pure retryability, backoff, {@link RetryInfo} extraction, and timeout budgeting policy for {@link
 * BatchWriteResumingServerStreamingCallable}.
 */
final class BatchWriteRetryPolicy {

  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  private final RetrySettings retrySettings;
  private final ImmutableSet<Code> retryableCodes;
  private final ApiClock clock;
  private final DoubleSupplier jitterRandom;

  BatchWriteRetryPolicy(
      RetrySettings retrySettings,
      Set<Code> retryableCodes,
      ApiClock clock,
      DoubleSupplier jitterRandom) {
    this.retrySettings =
        Preconditions.checkNotNull(retrySettings, "retrySettings must not be null");
    this.retryableCodes =
        ImmutableSet.copyOf(
            Preconditions.checkNotNull(retryableCodes, "retryableCodes must not be null"));
    this.clock = Preconditions.checkNotNull(clock, "clock must not be null");
    this.jitterRandom = Preconditions.checkNotNull(jitterRandom, "jitterRandom must not be null");
  }

  enum Action {
    RETRY,
    PERMANENT_FAILURE,
    RETRIES_EXHAUSTED,
    CANCELLED
  }

  static final class RetryDecision {
    final Action action;
    final Duration delay;
    final @Nullable Throwable terminalError;

    private RetryDecision(Action action, Duration delay, @Nullable Throwable terminalError) {
      this.action = action;
      this.delay = delay;
      this.terminalError = terminalError;
    }

    static RetryDecision retry(Duration delay) {
      return new RetryDecision(
          Action.RETRY, Preconditions.checkNotNull(delay, "delay must not be null"), null);
    }

    static RetryDecision permanentFailure(Throwable error) {
      return new RetryDecision(Action.PERMANENT_FAILURE, Duration.ZERO, error);
    }

    static RetryDecision retriesExhausted(Throwable error) {
      return new RetryDecision(Action.RETRIES_EXHAUSTED, Duration.ZERO, error);
    }

    static RetryDecision cancelled(Throwable error) {
      return new RetryDecision(Action.CANCELLED, Duration.ZERO, error);
    }
  }

  RetryDecision evaluate(
      Throwable error,
      int completedAttempts,
      long operationStartNanos,
      Context grpcContext,
      @Nullable Deadline callOptionsDeadline) {
    if (grpcContext.isCancelled()) {
      ApiException cancelError = createContextCancellationException(grpcContext);
      if (cancelError.getStatusCode().getCode() == Code.DEADLINE_EXCEEDED) {
        return RetryDecision.permanentFailure(cancelError);
      }
      return RetryDecision.cancelled(cancelError);
    }
    if (!isRetryable(error)) {
      return RetryDecision.permanentFailure(error);
    }

    // maxAttempts == 1 disables retries; maxAttempts == 0 means unlimited (GAX convention).
    int maxAttempts = retrySettings.getMaxAttempts();
    if (maxAttempts > 0 && completedAttempts >= maxAttempts) {
      return RetryDecision.retriesExhausted(error);
    }

    Duration delay = computeNextRetryDelay(error, completedAttempts);
    ApiException deadlineExceeded =
        checkDeadlineExceeded(operationStartNanos, grpcContext, callOptionsDeadline, delay, error);
    if (deadlineExceeded != null) {
      return RetryDecision.retriesExhausted(deadlineExceeded);
    }

    return RetryDecision.retry(delay);
  }

  /**
   * Returns a non-retryable {@link Status.Code#DEADLINE_EXCEEDED} {@link ApiException} if {@code
   * totalTimeout}, {@code grpcContext} deadline, or {@code callOptionsDeadline} is already expired
   * or would be exceeded after sleeping {@code additionalDelay}; otherwise returns {@code null}.
   */
  @Nullable ApiException checkDeadlineExceeded(
      long operationStartNanos,
      Context grpcContext,
      @Nullable Deadline callOptionsDeadline,
      Duration additionalDelay,
      @Nullable Throwable cause) {
    Duration effectiveDelay =
        additionalDelay != null && !additionalDelay.isNegative() ? additionalDelay : Duration.ZERO;
    Duration totalTimeout = retrySettings.getTotalTimeoutDuration();
    if (isPositive(totalTimeout)) {
      Duration elapsed = Duration.ofNanos(Math.max(0L, clock.nanoTime() - operationStartNanos));
      if (elapsed.compareTo(totalTimeout) >= 0
          || totalTimeout.minus(elapsed).compareTo(effectiveDelay) <= 0) {
        return ApiExceptionFactory.createException(
            "BatchWrite total timeout exceeded while retrying",
            cause,
            GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
            /* retryable= */ false);
      }
    }

    long additionalDelayNanos = toSaturatedNanos(effectiveDelay);
    Deadline contextDeadline = grpcContext.getDeadline();
    if (contextDeadline != null
        && contextDeadline.timeRemaining(TimeUnit.NANOSECONDS) <= additionalDelayNanos) {
      return ApiExceptionFactory.createException(
          "BatchWrite context deadline exceeded while retrying",
          cause,
          GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
          /* retryable= */ false);
    }

    if (callOptionsDeadline != null
        && callOptionsDeadline.timeRemaining(TimeUnit.NANOSECONDS) <= additionalDelayNanos) {
      return ApiExceptionFactory.createException(
          "BatchWrite call deadline exceeded while retrying",
          cause,
          GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED),
          /* retryable= */ false);
    }

    return null;
  }

  @Nullable Duration computeAttemptRpcTimeout(
      int zeroBasedAttemptNumber, @Nullable Duration explicitTimeout, long operationStartNanos) {
    Duration configuredRpcTimeout = retrySettings.getInitialRpcTimeoutDuration();
    Duration effectiveRpcTimeout = explicitTimeout;

    if (effectiveRpcTimeout == null && isPositive(configuredRpcTimeout)) {
      double multiplier = Math.max(1.0, retrySettings.getRpcTimeoutMultiplier());
      double scaledMillis =
          configuredRpcTimeout.toMillis() * Math.pow(multiplier, zeroBasedAttemptNumber);
      Duration maxRpcTimeout = retrySettings.getMaxRpcTimeoutDuration();
      long maxMillis = isPositive(maxRpcTimeout) ? maxRpcTimeout.toMillis() : Long.MAX_VALUE;
      effectiveRpcTimeout = Duration.ofMillis((long) Math.min(scaledMillis, maxMillis));
    }

    Duration totalTimeout = retrySettings.getTotalTimeoutDuration();
    if (isPositive(totalTimeout)) {
      long elapsedMillis =
          TimeUnit.NANOSECONDS.toMillis(Math.max(0L, clock.nanoTime() - operationStartNanos));
      long remainingMillis = Math.max(1L, totalTimeout.toMillis() - elapsedMillis);
      Duration remainingDuration = Duration.ofMillis(remainingMillis);
      if (effectiveRpcTimeout == null || remainingDuration.compareTo(effectiveRpcTimeout) < 0) {
        return remainingDuration;
      }
    }
    return effectiveRpcTimeout;
  }

  boolean isRetryable(Throwable error) {
    if (retryableCodes.isEmpty()) {
      return false;
    }
    if (error instanceof WatchdogTimeoutException) {
      // Idle watchdog timeouts indicate an abandoned consumer and must never be retried;
      // wait timeouts indicate a stalled server and are retryable.
      return ((WatchdogTimeoutException) error).isRetryable();
    }
    Code code = extractStatusCode(error);
    if (code != null && retryableCodes.contains(code)) {
      return true;
    }
    return error != null
        && error.getMessage() != null
        && retryableCodes.contains(Code.UNAVAILABLE)
        && IsRetryableInternalError.INSTANCE.apply(error);
  }

  Duration computeNextRetryDelay(Throwable error, int completedAttempts) {
    Duration serverRetryDelay = extractRetryDelay(error);
    if (serverRetryDelay != null) {
      return serverRetryDelay;
    }
    Duration initialDelay = retrySettings.getInitialRetryDelayDuration();
    if (!isPositive(initialDelay)) {
      return Duration.ZERO;
    }
    Duration maxDelay = retrySettings.getMaxRetryDelayDuration();
    Duration effectiveMaxDelay =
        maxDelay != null && maxDelay.compareTo(initialDelay) >= 0 ? maxDelay : initialDelay;

    double initialNanos = toNanosDouble(initialDelay);
    double maxNanos = toNanosDouble(effectiveMaxDelay);
    double multiplier = Math.max(1.0, retrySettings.getRetryDelayMultiplier());

    double unclamped = initialNanos * Math.pow(multiplier, Math.max(0, completedAttempts - 1));
    double capped = Math.min(maxNanos, unclamped);
    // Full-band jitter in [0.5 * capped, 1.0 * capped] so delay never exceeds maxRetryDelay.
    double jitterFactor = 0.5 + (0.5 * jitterRandom.getAsDouble());
    return fromNanosDouble(capped * jitterFactor);
  }

  long computeNextRetryDelayMillis(Throwable error, int completedAttempts) {
    return computeNextRetryDelay(error, completedAttempts).toMillis();
  }

  static @Nullable Code extractStatusCode(Throwable error) {
    if (error instanceof ApiException) {
      StatusCode statusCode = ((ApiException) error).getStatusCode();
      return statusCode != null ? statusCode.getCode() : null;
    }
    if (error instanceof StatusRuntimeException) {
      return GrpcStatusCode.of(((StatusRuntimeException) error).getStatus().getCode()).getCode();
    }
    if (error instanceof StatusException) {
      return GrpcStatusCode.of(((StatusException) error).getStatus().getCode()).getCode();
    }
    return null;
  }

  static @Nullable Duration extractRetryDelay(@Nullable Throwable error) {
    if (error instanceof ApiException) {
      try {
        ErrorDetails details = ((ApiException) error).getErrorDetails();
        if (details != null) {
          Duration delay = toNonNegativeDuration(details.getRetryInfo());
          if (delay != null) {
            return delay;
          }
        }
      } catch (IllegalArgumentException | ArithmeticException ignored) {
        // Fall through to trailers / exponential backoff if RetryInfo is malformed.
      }
    }
    if (error != null) {
      try {
        Metadata trailers = Status.trailersFromThrowable(error);
        if (trailers != null) {
          Duration delay = toNonNegativeDuration(trailers.get(KEY_RETRY_INFO));
          if (delay != null) {
            return delay;
          }
        }
      } catch (IllegalArgumentException | ArithmeticException ignored) {
        // Fall back to exponential backoff if RetryInfo trailer is corrupted or out of range.
      }
    }
    return null;
  }

  static long extractRetryDelayMillis(@Nullable Throwable error) {
    Duration delay = extractRetryDelay(error);
    return delay != null ? delay.toMillis() : -1L;
  }

  private static @Nullable Duration toNonNegativeDuration(@Nullable RetryInfo retryInfo) {
    if (retryInfo != null && retryInfo.hasRetryDelay()) {
      com.google.protobuf.Duration protoDelay = retryInfo.getRetryDelay();
      Durations.checkValid(protoDelay);
      if (protoDelay.getSeconds() >= 0L && protoDelay.getNanos() >= 0) {
        return Duration.ofSeconds(protoDelay.getSeconds(), protoDelay.getNanos());
      }
    }
    return null;
  }

  private static boolean isPositive(@Nullable Duration duration) {
    return duration != null && !duration.isZero() && !duration.isNegative();
  }

  private static double toNanosDouble(Duration duration) {
    return (duration.getSeconds() * 1_000_000_000.0) + duration.getNano();
  }

  private static Duration fromNanosDouble(double nanos) {
    if (nanos <= 0.0) {
      return Duration.ZERO;
    }
    if (nanos >= (double) Long.MAX_VALUE) {
      return Duration.ofNanos(Long.MAX_VALUE);
    }
    return Duration.ofNanos((long) nanos);
  }

  private static long toSaturatedNanos(Duration duration) {
    try {
      return duration.toNanos();
    } catch (ArithmeticException e) {
      return duration.isNegative() ? Long.MIN_VALUE : Long.MAX_VALUE;
    }
  }

  static ApiException createContextCancellationException(Context ctx) {
    Throwable cause = ctx.cancellationCause();
    Status.Code code = Status.Code.CANCELLED;
    if (cause instanceof TimeoutException) {
      code = Status.Code.DEADLINE_EXCEEDED;
    } else if (cause != null
        && Status.fromThrowable(cause).getCode() == Status.Code.DEADLINE_EXCEEDED) {
      code = Status.Code.DEADLINE_EXCEEDED;
    }
    String message =
        code == Status.Code.DEADLINE_EXCEEDED
            ? "BatchWrite stream deadline exceeded"
            : "BatchWrite stream cancelled by context";
    return ApiExceptionFactory.createException(
        message, cause, GrpcStatusCode.of(code), /* retryable= */ false);
  }
}
