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

package com.google.cloud.spanner;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.ProtocolBufferParsingException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import java.time.Duration;
import java.util.function.DoubleSupplier;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Shared internal retry delay sanitization, exponential backoff, and budget enforcement utilities
 * for Cloud Spanner streaming RPCs.
 */
@InternalApi
@NullMarked
public final class StreamingRetryHelper {

  /** Default upper bound for retry delays when {@code maxRetryDelayDuration} is unset. */
  static final Duration DEFAULT_MAX_RETRY_DELAY = Duration.ofSeconds(32L);

  private static final int NANOS_PER_MILLI = 1_000_000;
  private static final Metadata.Key<RetryInfo> KEY_RETRY_INFO =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  private StreamingRetryHelper() {}

  /**
   * Returns {@code true} if {@code completedAttempts} has reached or exceeded {@link
   * RetrySettings#getMaxAttempts()} when a positive attempt limit is configured. A configured
   * {@code maxAttempts} of zero means unlimited retries (GAX convention); {@code 1} disables
   * retries.
   */
  public static boolean isMaxAttemptsExhausted(RetrySettings retrySettings, int completedAttempts) {
    Preconditions.checkNotNull(retrySettings, "retrySettings must not be null");
    int maxAttempts = retrySettings.getMaxAttempts();
    return maxAttempts > 0 && completedAttempts >= maxAttempts;
  }

  /**
   * Returns {@code true} if retrying after {@code proposedDelay} would reach or exceed {@link
   * RetrySettings#getTotalTimeoutDuration()} given {@code elapsedNanos} since the retry sequence
   * started. A non-positive total timeout means no total timeout is enforced.
   */
  public static boolean isTotalTimeoutExceeded(
      RetrySettings retrySettings, long elapsedNanos, @Nullable Duration proposedDelay) {
    Preconditions.checkNotNull(retrySettings, "retrySettings must not be null");
    Duration totalTimeout = retrySettings.getTotalTimeoutDuration();
    if (!isPositive(totalTimeout)) {
      return false;
    }
    Duration elapsed = Duration.ofNanos(Math.max(0L, elapsedNanos));
    if (elapsed.compareTo(totalTimeout) >= 0) {
      return true;
    }
    Duration effectiveDelay =
        proposedDelay != null && !proposedDelay.isNegative() ? proposedDelay : Duration.ZERO;
    return totalTimeout.minus(elapsed).compareTo(effectiveDelay) <= 0;
  }

  /**
   * Extracts a validated protobuf {@link com.google.protobuf.Duration} from {@code RetryInfo}
   * attached to {@code error} or {@code apiException}, returning {@code null} when absent or
   * malformed.
   *
   * <p>Uses two independent exception-guarded lookups so that malformed {@code ErrorDetails}
   * (including corrupt {@code Any} payloads inside {@code grpc-status-details-bin}) still falls
   * through to a valid {@code google.rpc.retryinfo-bin} trailer.
   */
  static com.google.protobuf.@Nullable Duration extractRawServerRetryDelay(
      @Nullable Throwable error, @Nullable ApiException apiException) {
    try {
      ErrorDetails details = SpannerExceptionFactory.extractErrorDetails(error, apiException);
      if (details != null) {
        com.google.protobuf.Duration protoDelay =
            extractValidatedProtoDelay(details.getRetryInfo());
        if (protoDelay != null) {
          return protoDelay;
        }
      }
    } catch (ProtocolBufferParsingException
        | IllegalArgumentException
        | ArithmeticException ignored) {
      // Fall through to raw gRPC trailers if ErrorDetails is malformed or out of range.
    }

    if (error == null) {
      return null;
    }
    try {
      Metadata trailers = Status.trailersFromThrowable(error);
      if (trailers != null) {
        com.google.protobuf.Duration protoDelay =
            extractValidatedProtoDelay(trailers.get(KEY_RETRY_INFO));
        if (protoDelay != null) {
          return protoDelay;
        }
      }
    } catch (IllegalArgumentException | ArithmeticException ignored) {
      // Ignore corrupted or out-of-range RetryInfo trailers.
    }
    return null;
  }

  /**
   * Extracts a positive server-supplied retry delay of at least 1 millisecond from {@code error},
   * returning {@code null} when absent, malformed, non-positive, or sub-millisecond.
   */
  @VisibleForTesting
  public static @Nullable Duration extractServerRetryDelay(@Nullable Throwable error) {
    com.google.protobuf.Duration rawDelay = extractRawServerRetryDelay(error, null);
    if (rawDelay != null
        && (rawDelay.getSeconds() > 0L
            || (rawDelay.getSeconds() == 0L && rawDelay.getNanos() >= NANOS_PER_MILLI))) {
      return Duration.ofSeconds(rawDelay.getSeconds(), rawDelay.getNanos());
    }
    return null;
  }

  /**
   * Returns the effective upper bound for retry delays: {@link
   * RetrySettings#getMaxRetryDelayDuration()} when positive, or {@link #DEFAULT_MAX_RETRY_DELAY}
   * otherwise, floored at {@code minDelay}.
   */
  static Duration effectiveMaxRetryDelay(RetrySettings retrySettings, Duration minDelay) {
    Preconditions.checkNotNull(retrySettings, "retrySettings must not be null");
    Preconditions.checkNotNull(minDelay, "minDelay must not be null");
    Preconditions.checkArgument(!minDelay.isNegative(), "minDelay must not be negative");
    Duration configuredMax = retrySettings.getMaxRetryDelayDuration();
    Duration maxDelay = isPositive(configuredMax) ? configuredMax : DEFAULT_MAX_RETRY_DELAY;
    return maxDelay.compareTo(minDelay) < 0 ? minDelay : maxDelay;
  }

  /**
   * Computes the next retry delay by clamping any valid server-supplied {@code RetryInfo} delay
   * ({@code >= 1ms}) to {@link #effectiveMaxRetryDelay(RetrySettings, Duration)}, or falling back
   * to stateless exponential backoff with {@code [0.5x, 1.0x]} full-band jitter.
   *
   * <p>When {@code initialRetryDelayDuration} is non-positive, returns {@link Duration#ZERO} if
   * {@code minDelay} is zero (preserving explicit zero-delay configurations), or uses {@code
   * minDelay} as the initial interval otherwise so millisecond-sleeping callers cannot busy-spin.
   */
  public static Duration computeRetryDelay(
      RetrySettings retrySettings,
      @Nullable Throwable error,
      int completedAttempts,
      DoubleSupplier jitterRandom,
      Duration minDelay) {
    Preconditions.checkNotNull(jitterRandom, "jitterRandom must not be null");
    Duration effectiveMaxDelay = effectiveMaxRetryDelay(retrySettings, minDelay);
    Duration serverRetryDelay = extractServerRetryDelay(error);
    if (serverRetryDelay != null) {
      return serverRetryDelay.compareTo(effectiveMaxDelay) > 0
          ? effectiveMaxDelay
          : serverRetryDelay;
    }

    Duration initialDelay = retrySettings.getInitialRetryDelayDuration();
    if (!isPositive(initialDelay)) {
      if (minDelay.isZero()) {
        return Duration.ZERO;
      }
      initialDelay = minDelay;
    } else if (initialDelay.compareTo(minDelay) < 0) {
      initialDelay = minDelay;
    }

    double initialNanos = toNanosDouble(initialDelay);
    double maxNanos = toNanosDouble(effectiveMaxDelay);
    double multiplier = Math.max(1.0, retrySettings.getRetryDelayMultiplier());

    double unclamped = initialNanos * Math.pow(multiplier, Math.max(0, completedAttempts - 1));
    double capped = Math.min(maxNanos, unclamped);
    // [0.5x, 1.0x] full-band jitter so delay never exceeds effectiveMaxDelay.
    // initialDelay <= effectiveMaxDelay holds because RetrySettings.Builder rejects max < initial
    // and minDelay floors both values.
    double rawRandom = jitterRandom.getAsDouble();
    double clampedRandom =
        Double.isFinite(rawRandom) ? Math.min(1.0, Math.max(0.0, rawRandom)) : 1.0;
    double jitterFactor = 0.5 + (0.5 * clampedRandom);
    Duration backoffDelay = fromNanosDouble(capped * jitterFactor);
    return backoffDelay.compareTo(minDelay) < 0 ? minDelay : backoffDelay;
  }

  /**
   * Converts {@code duration} to positive milliseconds (floored at 1ms for positive sub-millisecond
   * durations and saturated at {@code maxMillis} on overflow), or returns {@code
   * nonPositiveDefaultMillis} when {@code duration} is null, zero, or negative.
   */
  public static long saturatedDurationMillis(
      @Nullable Duration duration, long nonPositiveDefaultMillis, long maxMillis) {
    if (!isPositive(duration)) {
      return nonPositiveDefaultMillis;
    }
    try {
      return Math.max(1L, Math.min(duration.toMillis(), maxMillis));
    } catch (ArithmeticException overflow) {
      return maxMillis;
    }
  }

  /** Converts {@code duration} to nanoseconds, saturating to {@code Long.MIN_VALUE}/{@code MAX}. */
  public static long toSaturatedNanos(Duration duration) {
    try {
      return duration.toNanos();
    } catch (ArithmeticException overflow) {
      return duration.isNegative() ? Long.MIN_VALUE : Long.MAX_VALUE;
    }
  }

  private static com.google.protobuf.@Nullable Duration extractValidatedProtoDelay(
      @Nullable RetryInfo retryInfo) {
    if (retryInfo != null && retryInfo.hasRetryDelay()) {
      com.google.protobuf.Duration protoDelay = retryInfo.getRetryDelay();
      Durations.checkValid(protoDelay);
      return protoDelay;
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
    if (nanos >= (double) Long.MAX_VALUE) {
      return Duration.ofNanos(Long.MAX_VALUE);
    }
    return Duration.ofNanos((long) nanos);
  }
}
