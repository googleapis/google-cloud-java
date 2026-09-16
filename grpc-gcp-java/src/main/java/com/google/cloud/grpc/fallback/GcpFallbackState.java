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

package com.google.cloud.grpc.fallback;

import com.google.cloud.grpc.GcpThreadFactory;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Shared state that coordinates failover across a pool of channels. All channels in a pool share
 * this instance and its background executor, so probing and error rate evaluation run once for the
 * whole pool.
 *
 * targetFallbackMode: whether channels should route to the fallback channel.
 * generation: incremented on every pool-wide transition. A channel re-reads targetFallbackMode when
 * generation advances past the value it last saw.
 * inFallbackMode: whether all traffic is on the fallback channel. Gates error rate evaluation.
 *
 * Failover: the primary error rate crossing the threshold sets targetFallbackMode and increments
 * generation. All channels switch to the fallback channel.
 *
 * Recovery, per-channel disabled: the first channel whose probes succeed clears targetFallbackMode
 * and increments generation. The whole pool returns to the primary channel.
 *
 * Recovery, per-channel enabled: a recovering channel updates only its own state, leaving
 * targetFallbackMode and generation unchanged. Other channels stay on the fallback channel until
 * their own probes succeed. inFallbackMode and targetFallbackMode diverge until then.
 *
 * A shared instance passed to setSharedState must be shut down by the caller. A state a channel
 * created for itself is shut down with that channel.
 */
public class GcpFallbackState {
  private final AtomicLong primarySuccesses = new AtomicLong(0);
  private final AtomicLong primaryFailures = new AtomicLong(0);
  private final AtomicLong fallbackSuccesses = new AtomicLong(0);
  private final AtomicLong fallbackFailures = new AtomicLong(0);
  private final AtomicLong generation = new AtomicLong(0);
  private final AtomicBoolean targetFallbackMode = new AtomicBoolean(false);
  private final AtomicBoolean inFallbackMode = new AtomicBoolean(false);
  private final AtomicBoolean evaluationStarted = new AtomicBoolean(false);

  private ScheduledExecutorService execService = null;
  private boolean ownsExecutor = false;
  private volatile ScheduledFuture<?> scheduledEvaluationFuture = null;

  public GcpFallbackState() {}

  /**
   * Constructs a fallback state with an explicit executor service for testing.
   *
   * @param execService the executor service to use.
   */
  @VisibleForTesting
  GcpFallbackState(ScheduledExecutorService execService) {
    this.execService = execService;
    this.ownsExecutor = true;
  }

  AtomicLong getPrimarySuccesses() {
    return primarySuccesses;
  }

  AtomicLong getPrimaryFailures() {
    return primaryFailures;
  }

  AtomicLong getFallbackSuccesses() {
    return fallbackSuccesses;
  }

  AtomicLong getFallbackFailures() {
    return fallbackFailures;
  }

  /**
   * Returns whether periodic error-rate evaluation is armed, i.e. whether any traffic is currently
   * reaching the primary channel.
   *
   * <p>This is <em>not</em> "are the pool's channels routing to the fallback channel". Under
   * per-channel recovery this returns {@code false} as soon as the first channel recovers, while
   * other channels may still be in fallback. To ask whether a specific channel is in fallback, call
   * {@link GcpFallbackChannel#isInFallbackMode()} on that channel.
   */
  boolean isInFallbackMode() {
    return inFallbackMode.get();
  }

  long getGeneration() {
    return generation.get();
  }

  boolean getTargetFallbackMode() {
    return targetFallbackMode.get();
  }

  /** Bumps the generation counter with a directive to target fallback mode. */
  synchronized void triggerFallback() {
    inFallbackMode.set(true);
    targetFallbackMode.set(true);
    generation.incrementAndGet();
  }

  /**
   * Records channel recovery by clearing primary error counts and updating fallback mode.
   *
   * @param expectedGen the generation at which the recovery probe started.
   * @param perChannelRecovery whether recovery is scoped per channel rather than pool-wide.
   * @return the resulting pool generation, or -1 if the pool generation changed concurrently.
   */
  synchronized long recordRecovery(long expectedGen, boolean perChannelRecovery) {
    if (generation.get() != expectedGen) {
      return -1;
    }
    if (inFallbackMode.get()) {
      primaryFailures.set(0);
      primarySuccesses.set(0);
      inFallbackMode.set(false);
    }
    if (!perChannelRecovery && targetFallbackMode.compareAndSet(true, false)) {
      generation.incrementAndGet();
    }
    return generation.get();
  }

  /**
   * Retrieves or lazily initializes the background executor service.
   *
   * @param options optional fallback channel configuration options.
   * @return the active ScheduledExecutorService.
   */
  synchronized ScheduledExecutorService getOrCreateExecutorService(
      GcpFallbackChannelOptions options) {
    if (this.execService != null) {
      return this.execService;
    }
    if (options != null && options.getSharedExecutorService() != null) {
      this.execService = options.getSharedExecutorService();
      this.ownsExecutor = false;
    } else {
      this.execService =
          Executors.newScheduledThreadPool(
              3, GcpThreadFactory.newThreadFactory("gcp-fallback-state-%d"));
      this.ownsExecutor = true;
    }
    return this.execService;
  }

  /** Schedules a periodic task (e.g., probe) on the shared background executor service. */
  synchronized ScheduledFuture<?> scheduleTask(
      Runnable command, long initialDelay, long period, TimeUnit unit) {
    if (this.execService == null || this.execService.isShutdown()) {
      return null;
    }
    return this.execService.scheduleAtFixedRate(command, initialDelay, period, unit);
  }

  /**
   * Starts the periodic error rate evaluation loop exactly once across all channels sharing this
   * state.
   *
   * @param options the fallback channel configuration options.
   */
  synchronized void startPeriodicEvaluation(GcpFallbackChannelOptions options) {
    if (options == null
        || !options.isEnableFallback()
        || options.getPeriod() == null
        || options.getPeriod().toMillis() <= 0) {
      return;
    }
    if (evaluationStarted.compareAndSet(false, true)) {
      ScheduledExecutorService executor = getOrCreateExecutorService(options);
      if (executor == null || executor.isShutdown()) {
        evaluationStarted.set(false);
        return;
      }
      GcpFallbackOpenTelemetry openTelemetry =
          options.getGcpOpenTelemetry() != null
              ? options.getGcpOpenTelemetry()
              : GcpFallbackOpenTelemetry.newBuilder().build();

      scheduledEvaluationFuture =
          executor.scheduleAtFixedRate(
              () -> checkErrorRates(options, openTelemetry),
              options.getPeriod().toMillis(),
              options.getPeriod().toMillis(),
              TimeUnit.MILLISECONDS);
    }
  }

  /**
   * Evaluates error rates across all channels sharing this state and updates fallback mode.
   *
   * @param options the fallback channel configuration options.
   * @param openTelemetry telemetry module for recording error metrics.
   */
  void checkErrorRates(
      GcpFallbackChannelOptions options, GcpFallbackOpenTelemetry openTelemetry) {
    float primaryErrRate = 0f;
    boolean fallbackTriggered = false;
    boolean currentInFallback;
    synchronized (this) {
      boolean wasInFallback = inFallbackMode.get();
      long successes = primarySuccesses.getAndSet(0);
      long failures = primaryFailures.getAndSet(0);
      if (failures + successes > 0) {
        primaryErrRate = (float) failures / (failures + successes);
      }
      if (!wasInFallback && options.isEnableFallback()) {
        if (failures >= options.getMinFailedCalls()
            && primaryErrRate >= options.getErrorRateThreshold()) {
          triggerFallback();
          fallbackTriggered = true;
        }
      }
      currentInFallback = inFallbackMode.get();
    }

    if (openTelemetry != null && openTelemetry.getModule() != null) {
      openTelemetry.getModule().reportErrorRate(options.getPrimaryChannelName(), primaryErrRate);
      if (fallbackTriggered) {
        openTelemetry
            .getModule()
            .reportFallback(options.getPrimaryChannelName(), options.getFallbackChannelName());
      }
    }

    long fallbackSucc = fallbackSuccesses.getAndSet(0);
    long fallbackFail = fallbackFailures.getAndSet(0);
    float fallbackErrRate = 0f;
    if (fallbackFail + fallbackSucc > 0) {
      fallbackErrRate = (float) fallbackFail / (fallbackFail + fallbackSucc);
    }
    if (openTelemetry != null && openTelemetry.getModule() != null) {
      openTelemetry.getModule().reportErrorRate(options.getFallbackChannelName(), fallbackErrRate);
      openTelemetry
          .getModule()
          .reportCurrentChannel(options.getPrimaryChannelName(), !currentInFallback);
      openTelemetry
          .getModule()
          .reportCurrentChannel(options.getFallbackChannelName(), currentInFallback);
    }
  }

  /** Stops any running scheduled evaluation. */
  synchronized void stopPeriodicEvaluation() {
    if (scheduledEvaluationFuture != null) {
      scheduledEvaluationFuture.cancel(false);
      scheduledEvaluationFuture = null;
    }
    evaluationStarted.set(false);
  }

  /** Shuts down the state, cancelling evaluation and shutting down internal executor if owned. */
  public synchronized void shutdown() {
    stopPeriodicEvaluation();
    if (ownsExecutor && execService != null && !execService.isShutdown()) {
      execService.shutdown();
    }
  }

  /**
   * Shuts down the state immediately, cancelling evaluation and terminating internal executor if
   * owned.
   */
  public synchronized void shutdownNow() {
    stopPeriodicEvaluation();
    if (ownsExecutor && execService != null && !execService.isShutdown()) {
      execService.shutdownNow();
    }
  }
}
