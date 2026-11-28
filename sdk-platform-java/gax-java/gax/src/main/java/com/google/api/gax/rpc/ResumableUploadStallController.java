/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Comparators;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Tracks chunk transfer progress against a configured minimum transfer rate and computes dynamic
 * per-chunk and per-query {@link RetrySettings} deadlines for a single resumable upload session.
 */
@NullMarked
final class ResumableUploadStallController {
  private static final double BYTES_PER_MIB = 1024.0 * 1024.0;
  private static final Duration MIN_GLOBAL_REMAINING = Duration.ofMillis(1L);
  private static final Duration MIN_LOCAL_TIMEOUT = Duration.ofSeconds(1L);
  // 5s floor (capped by localTimeout) so tiny or 0-byte final chunks allow time for server
  // finalization.
  private static final Duration MIN_ATTEMPT_TIMEOUT = Duration.ofSeconds(5L);
  private static final Duration MAX_QUERY_ATTEMPT_TIMEOUT = Duration.ofMinutes(1L);

  private final ApiClock clock;
  private final double minimumRateBytesPerSec;
  private final Duration stallTimeout;
  private final @Nullable Duration globalDeadline;
  private final RetrySettings baseRetrySettings;

  private Duration lag = Duration.ZERO;
  private @Nullable Duration stallStartedAt = null;
  private Duration currentChunkStartTime = Duration.ZERO;
  private @Nullable Duration currentChunkDeadline = null;
  private boolean inChunkRecovery = false;
  private boolean deadlineTrimmedToGlobal = false;

  ResumableUploadStallController(
      ApiClock clock,
      double minimumRateMiBPerSec,
      Duration stallTimeout,
      @Nullable Duration globalDeadline,
      RetrySettings baseRetrySettings) {
    this.clock = clock;
    this.minimumRateBytesPerSec = minimumRateMiBPerSec * BYTES_PER_MIB;
    this.stallTimeout = stallTimeout;
    this.globalDeadline = globalDeadline;
    this.baseRetrySettings = baseRetrySettings;
  }

  /** Computes per-chunk RetrySettings (local deadline + 2x expected per-attempt timeout). */
  RetrySettings onStartChunk(long chunkBytes) {
    Duration now = nowDuration();
    Duration expectedDuration = expectedDuration(chunkBytes);
    Duration localTimeout;

    if (inChunkRecovery && currentChunkDeadline != null) {
      // Re-sending after queryStatus recovery with 0 bytes committed shares the original chunk
      // deadline.
      localTimeout =
          trimToGlobalDeadline(
              now, Comparators.max(MIN_LOCAL_TIMEOUT, currentChunkDeadline.minus(now)));
    } else {
      inChunkRecovery = false;
      deadlineTrimmedToGlobal = false;
      Duration rawLocalTimeout = expectedDuration.minus(lag).plus(stallTimeout);
      localTimeout = trimToGlobalDeadline(now, Comparators.max(MIN_LOCAL_TIMEOUT, rawLocalTimeout));
      currentChunkStartTime = now;
      currentChunkDeadline = now.plus(localTimeout);
    }

    Duration twoTimesExpected =
        Comparators.max(MIN_ATTEMPT_TIMEOUT, expectedDuration.multipliedBy(2L));
    Duration attemptTimeout = Comparators.min(localTimeout, twoTimesExpected);

    return baseRetrySettings.toBuilder()
        .setMaxAttempts(0)
        .setTotalTimeoutDuration(localTimeout)
        .setInitialRpcTimeoutDuration(attemptTimeout)
        .setMaxRpcTimeoutDuration(attemptTimeout)
        .setRpcTimeoutMultiplier(1.0)
        .build();
  }

  /**
   * Updates lag and stallStartedAt after chunk bytes are acknowledged; throws if stall timeout
   * expired.
   */
  void onChunkSuccess(long chunkBytes) {
    inChunkRecovery = false;
    deadlineTrimmedToGlobal = false;
    Duration now = nowDuration();
    Duration elapsed = Comparators.max(Duration.ZERO, now.minus(currentChunkStartTime));
    Duration expectedDuration = expectedDuration(chunkBytes);
    Duration currentLag = elapsed.minus(expectedDuration);

    lag = Comparators.max(Duration.ZERO, lag.plus(currentLag));
    if (!lag.isZero()) {
      if (stallStartedAt == null) {
        stallStartedAt = now;
      } else if (now.minus(stallStartedAt).compareTo(stallTimeout) > 0) {
        throw createStallOrGlobalTimeoutException(null);
      }
    } else {
      stallStartedAt = null;
    }
  }

  /**
   * Credits bytes committed by the server during a failed chunk attempt once queryStatus reports
   * the server's committed offset. Does nothing on an initial resume() query (where no chunk has
   * been started yet, so currentChunkDeadline == null) or when zero bytes were committed.
   */
  void onRecoveryOffsetReceived(long committedBytesDelta) {
    if (currentChunkDeadline == null || committedBytesDelta <= 0L) {
      return;
    }
    onChunkSuccess(committedBytesDelta);
  }

  /**
   * Computes RetrySettings for queryStatus, enforcing that mid-upload recovery shares the active
   * chunk's remaining local deadline (or uses stallTimeout on an initial resume()).
   */
  RetrySettings onStartQuery(Duration recoveryBackoffDelay) {
    inChunkRecovery = (currentChunkDeadline != null);
    Duration now = nowDuration();
    Duration remaining;
    if (currentChunkDeadline != null) {
      remaining = currentChunkDeadline.minus(now);
    } else {
      deadlineTrimmedToGlobal = false;
      remaining = trimToGlobalDeadline(now, stallTimeout);
    }

    if (remaining.compareTo(recoveryBackoffDelay) <= 0) {
      throw createStallOrGlobalTimeoutException(null);
    }

    Duration queryLocalTimeout = remaining.minus(recoveryBackoffDelay);
    Duration queryAttemptTimeout = Comparators.min(queryLocalTimeout, MAX_QUERY_ATTEMPT_TIMEOUT);

    return baseRetrySettings.toBuilder()
        .setMaxAttempts(0)
        .setTotalTimeoutDuration(queryLocalTimeout)
        .setInitialRpcTimeoutDuration(queryAttemptTimeout)
        .setMaxRpcTimeoutDuration(queryAttemptTimeout)
        .setRpcTimeoutMultiplier(1.0)
        .build();
  }

  /**
   * Translates a terminal retryable/timeout error into a stall or global timeout
   * DeadlineExceededException. Because maxAttempts == 0 under stall control, any Category.TRANSIENT
   * error or DeadlineExceededException reaching here means the local deadline ran out (including
   * when ExponentialRetryAlgorithm stops before sleeping the final backoff). Non-retryable fatal
   * errors (e.g., 401/403/404) are returned unchanged.
   */
  Throwable translateException(Throwable t, ResumableUploadCommand command) {
    Category category = ResumableUploadErrorClassifier.classify(t, command);
    if (category != Category.TRANSIENT && !(t instanceof DeadlineExceededException)) {
      return t;
    }
    return createStallOrGlobalTimeoutException(t);
  }

  private Duration nowDuration() {
    return Duration.ofMillis(clock.millisTime());
  }

  private Duration expectedDuration(long chunkBytes) {
    long expectedMillis = Math.round((chunkBytes * 1000.0) / minimumRateBytesPerSec);
    return Duration.ofMillis(expectedMillis);
  }

  private Duration trimToGlobalDeadline(Duration now, Duration timeout) {
    if (globalDeadline == null) {
      return timeout;
    }
    Duration remainingGlobal = Comparators.max(MIN_GLOBAL_REMAINING, globalDeadline.minus(now));
    if (remainingGlobal.compareTo(timeout) <= 0) {
      deadlineTrimmedToGlobal = true;
      return remainingGlobal;
    }
    return timeout;
  }

  private DeadlineExceededException createStallOrGlobalTimeoutException(@Nullable Throwable cause) {
    String message = "Resumable upload stalled";
    if (deadlineTrimmedToGlobal
        || (globalDeadline != null && nowDuration().compareTo(globalDeadline) >= 0)) {
      message = "Resumable upload timed out";
    }
    Throwable rootCause = MoreObjects.firstNonNull(cause, new TimeoutException(message));
    return (DeadlineExceededException)
        ApiExceptionFactory.createException(message, rootCause, Code.DEADLINE_EXCEEDED, false);
  }
}
