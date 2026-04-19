/*
 * Copyright 2026, Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
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

package com.google.auth.oauth2;

import com.google.api.client.util.Clock;
import com.google.api.core.InternalApi;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import javax.annotation.Nullable;

/**
 * Manages the lifecycle of Regional Access Boundaries (RAB) for a credential.
 *
 * <p>This class handles caching, asynchronous refreshing, and cooldown logic to ensure that API
 * requests are not blocked by lookup failures and that the lookup service is not overwhelmed.
 */
@InternalApi
final class RegionalAccessBoundaryManager {

  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(RegionalAccessBoundaryManager.class);

  static final long INITIAL_COOLDOWN_MILLIS = 15 * 60 * 1000L; // 15 minutes
  static final long MAX_COOLDOWN_MILLIS = 6 * 60 * 60 * 1000L; // 6 hours

  /**
   * The default maximum elapsed time in milliseconds for retrying Regional Access Boundary lookup
   * requests.
   */
  private static final int DEFAULT_MAX_RETRY_ELAPSED_TIME_MILLIS = 60000;

  /**
   * cachedRAB uses AtomicReference to provide thread-safe, lock-free access to the cached data for
   * high-concurrency request threads.
   */
  private final AtomicReference<RegionalAccessBoundary> cachedRAB = new AtomicReference<>();

  /**
   * refreshFuture acts as an atomic gate for request de-duplication. If a future is present, it
   * indicates a background refresh is already in progress. It also provides a handle for
   * observability and unit testing to track the background task's lifecycle.
   */
  private final AtomicReference<SettableFuture<RegionalAccessBoundary>> refreshFuture =
      new AtomicReference<>();

  private final AtomicReference<CooldownState> cooldownState =
      new AtomicReference<>(new CooldownState(0, INITIAL_COOLDOWN_MILLIS));

  private final transient Clock clock;
  private final int maxRetryElapsedTimeMillis;

  /**
   * Creates a new RegionalAccessBoundaryManager with the default retry timeout of 60 seconds.
   *
   * @param clock The clock to use for cooldown and expiration checks.
   */
  RegionalAccessBoundaryManager(Clock clock) {
    this(clock, DEFAULT_MAX_RETRY_ELAPSED_TIME_MILLIS);
  }

  @VisibleForTesting
  RegionalAccessBoundaryManager(Clock clock, int maxRetryElapsedTimeMillis) {
    this.clock = clock != null ? clock : Clock.SYSTEM;
    this.maxRetryElapsedTimeMillis = maxRetryElapsedTimeMillis;
  }

  /**
   * Returns the currently cached RegionalAccessBoundary, or null if none is available or if it has
   * expired.
   *
   * @return The cached RAB, or null.
   */
  @Nullable
  RegionalAccessBoundary getCachedRAB() {
    RegionalAccessBoundary rab = cachedRAB.get();
    if (rab != null && !rab.isExpired()) {
      return rab;
    }
    return null;
  }

  /**
   * Triggers an asynchronous refresh of the RegionalAccessBoundary if it is not already being
   * refreshed and if the cooldown period is not active.
   *
   * <p>This method is entirely non-blocking for the calling thread. If a refresh is already in
   * progress or a cooldown is active, it returns immediately.
   *
   * @param transportFactory The HTTP transport factory to use for the lookup.
   * @param provider The provider used to retrieve the lookup endpoint URL.
   * @param accessToken The access token for authentication.
   */
  void triggerAsyncRefresh(
      final HttpTransportFactory transportFactory,
      final RegionalAccessBoundaryProvider provider,
      final AccessToken accessToken) {
    if (isCooldownActive()) {
      return;
    }

    RegionalAccessBoundary currentRab = cachedRAB.get();
    if (currentRab != null && !currentRab.shouldRefresh()) {
      return;
    }

    SettableFuture<RegionalAccessBoundary> future = SettableFuture.create();
    // Atomically check if a refresh is already running. If compareAndSet returns true,
    // this thread "won the race" and is responsible for starting the background task.
    // All other concurrent threads will return false and exit immediately.
    if (refreshFuture.compareAndSet(null, future)) {
      Runnable refreshTask =
          () -> {
            try {
              String url = provider.getRegionalAccessBoundaryUrl();
              RegionalAccessBoundary newRAB =
                  RegionalAccessBoundary.refresh(
                      transportFactory, url, accessToken, clock, maxRetryElapsedTimeMillis);
              cachedRAB.set(newRAB);
              resetCooldown();
              // Complete the future so monitors (like unit tests) know we are done.
              future.set(newRAB);
            } catch (Exception e) {
              handleRefreshFailure(e);
              future.setException(e);
            } finally {
              // Open the gate again for future refresh requests.
              refreshFuture.set(null);
            }
          };

      try {
        // We use new Thread() here instead of
        // CompletableFuture.runAsync() (which uses ForkJoinPool.commonPool()).
        // This avoids consuming CPU resources since
        // The common pool has a small, fixed number of threads designed for
        // CPU-bound tasks.
        Thread refreshThread = new Thread(refreshTask, "RAB-refresh-thread");
        refreshThread.setDaemon(true);
        refreshThread.start();
      } catch (Exception | Error e) {
        // If scheduling fails (e.g., RejectedExecutionException, OutOfMemoryError for threads),
        // the task's finally block will never execute. We must release the lock here.
        handleRefreshFailure(
            new Exception("Regional Access Boundary background refresh failed to schedule", e));
        future.setException(e);
        refreshFuture.set(null);
      }
    }
  }

  private void handleRefreshFailure(Exception e) {
    CooldownState currentCooldownState = cooldownState.get();
    CooldownState next;
    if (currentCooldownState.expiryTime == 0) {
      // In the first non-retryable failure, we set cooldown to currentTime + 15 mins.
      next =
          new CooldownState(
              clock.currentTimeMillis() + INITIAL_COOLDOWN_MILLIS, INITIAL_COOLDOWN_MILLIS);
    } else {
      // We attempted to exit cool-down but failed.
      // For each failed cooldown exit attempt, we double the cooldown time (till max 6 hrs).
      // This avoids overwhelming RAB lookup endpoint.
      long nextDuration = Math.min(currentCooldownState.durationMillis * 2, MAX_COOLDOWN_MILLIS);
      next = new CooldownState(clock.currentTimeMillis() + nextDuration, nextDuration);
    }

    // Atomically update the cooldown state. compareAndSet returns true only if the state
    // hasn't been changed by another thread in the meantime. This prevents multiple
    // concurrent failures from logging redundant messages or incorrectly calculating
    // the exponential backoff.
    if (cooldownState.compareAndSet(currentCooldownState, next)) {
      LoggingUtils.log(
          LOGGER_PROVIDER,
          Level.FINE,
          null,
          "Regional Access Boundary lookup failed; entering cooldown for "
              + (next.durationMillis / 60000)
              + "m. Error: "
              + e.getMessage());
    }
  }

  private void resetCooldown() {
    cooldownState.set(new CooldownState(0, INITIAL_COOLDOWN_MILLIS));
  }

  boolean isCooldownActive() {
    CooldownState state = cooldownState.get();
    if (state.expiryTime == 0) {
      return false;
    }
    return clock.currentTimeMillis() < state.expiryTime;
  }

  @VisibleForTesting
  long getCurrentCooldownMillis() {
    return cooldownState.get().durationMillis;
  }

  private static class CooldownState {
    /** The time (in milliseconds from epoch) when the current cooldown period expires. */
    final long expiryTime;

    /** The duration (in milliseconds) of the current cooldown period. */
    final long durationMillis;

    CooldownState(long expiryTime, long durationMillis) {
      this.expiryTime = expiryTime;
      this.durationMillis = durationMillis;
    }
  }
}
