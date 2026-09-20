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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Shared thread-safe state that coordinates failover, recovery, and periodic error evaluation
 * across a pool of GcpFallbackChannel instances.
 */
public class GcpFallbackState {
  private final AtomicLong primarySuccesses = new AtomicLong(0);
  private final AtomicLong primaryFailures = new AtomicLong(0);
  private final AtomicLong fallbackSuccesses = new AtomicLong(0);
  private final AtomicLong fallbackFailures = new AtomicLong(0);
  private final AtomicLong primaryProbeSuccesses = new AtomicLong(0);
  private final AtomicLong firstPrimaryProbeSuccessNanos = new AtomicLong(0);
  private final AtomicLong generation = new AtomicLong(0);
  private final AtomicBoolean inFallbackMode = new AtomicBoolean(false);
  private final AtomicBoolean evaluationStarted = new AtomicBoolean(false);
  private final Set<Runnable> stateChangeCallbacks = ConcurrentHashMap.newKeySet();

  private ScheduledExecutorService execService = null;
  private boolean ownsExecutor = false;
  private boolean isShutdown = false;
  private volatile ScheduledFuture<?> scheduledEvaluationFuture = null;

  public GcpFallbackState() {}

  @VisibleForTesting
  GcpFallbackState(ScheduledExecutorService execService) {
    this.execService = execService;
    this.ownsExecutor = true;
  }

  synchronized void registerStateChangeCallback(Runnable callback) {
    if (!isShutdown) {
      stateChangeCallbacks.add(callback);
    }
  }

  synchronized void unregisterStateChangeCallback(Runnable callback) {
    stateChangeCallbacks.remove(callback);
  }

  private void runStateChangeCallbacks(List<Runnable> callbacks) {
    if (callbacks == null) {
      return;
    }
    for (Runnable callback : callbacks) {
      try {
        callback.run();
      } catch (Throwable t) {
      }
    }
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

  @VisibleForTesting
  AtomicLong getPrimaryProbeSuccesses() {
    return primaryProbeSuccesses;
  }

  boolean isInFallbackMode() {
    return inFallbackMode.get();
  }

  long getGeneration() {
    return generation.get();
  }

  /** Bumps the generation counter and transitions the pool to fallback mode. */
  boolean triggerFallback() {
    boolean fallbackTriggered = false;
    List<Runnable> callbacks = null;
    synchronized (this) {
      if (!inFallbackMode.get()) {
        primaryProbeSuccesses.set(0);
        firstPrimaryProbeSuccessNanos.set(0);
        generation.incrementAndGet();
        inFallbackMode.set(true);
        fallbackTriggered = true;
        callbacks = new ArrayList<>(stateChangeCallbacks);
        stateChangeCallbacks.clear();
      }
    }
    if (fallbackTriggered) {
      runStateChangeCallbacks(callbacks);
    }
    return fallbackTriggered;
  }

  /** Bumps the generation counter and transitions the pool out of fallback mode. */
  boolean triggerRecovery(long expectedGeneration) {
    boolean recovered = false;
    List<Runnable> callbacks = null;
    synchronized (this) {
      if (generation.get() != expectedGeneration || !inFallbackMode.get()) {
        return false;
      }
      primaryFailures.set(0);
      primarySuccesses.set(0);
      primaryProbeSuccesses.set(0);
      firstPrimaryProbeSuccessNanos.set(0);
      generation.incrementAndGet();
      inFallbackMode.set(false);
      recovered = true;
      callbacks = new ArrayList<>(stateChangeCallbacks);
      stateChangeCallbacks.clear();
    }
    if (recovered) {
      runStateChangeCallbacks(callbacks);
    }
    return recovered;
  }

  /**
   * Records a primary probe result and recovers the pool if consecutive probe success count and
   * duration criteria are met.
   */
  void recordPrimaryProbeResult(
      boolean success, long expectedGeneration, GcpFallbackChannelOptions options) {
    if (!options.isEnableRecovery()) {
      return;
    }
    boolean shouldRecover = false;
    synchronized (this) {
      if (generation.get() != expectedGeneration || !inFallbackMode.get()) {
        return;
      }
      if (!success) {
        primaryProbeSuccesses.set(0);
        firstPrimaryProbeSuccessNanos.set(0);
        return;
      }
      long nowNanos = System.nanoTime();
      long firstSuccessNanos =
          firstPrimaryProbeSuccessNanos.updateAndGet(prev -> prev == 0 ? nowNanos : prev);
      long primaryProbeSuccessCount = primaryProbeSuccesses.incrementAndGet();

      boolean durationSatisfied = true;
      if (options.getMinPrimaryProbeSuccessDuration() != null
          && !options.getMinPrimaryProbeSuccessDuration().isZero()
          && !options.getMinPrimaryProbeSuccessDuration().isNegative()) {
        long elapsedNanos = nowNanos - firstSuccessNanos;
        durationSatisfied = elapsedNanos >= options.getMinPrimaryProbeSuccessDuration().toNanos();
      }

      if (primaryProbeSuccessCount >= options.getMinPrimaryProbeSuccessCount()
          && durationSatisfied) {
        shouldRecover = true;
      }
    }
    if (shouldRecover) {
      triggerRecovery(expectedGeneration);
    }
  }

  synchronized ScheduledExecutorService getOrCreateExecutorService(
      GcpFallbackChannelOptions options) {
    return getOrCreateExecutorService(options, null);
  }

  synchronized boolean ownsExecutor() {
    return ownsExecutor;
  }

  synchronized ScheduledExecutorService getOrCreateExecutorService(
      GcpFallbackChannelOptions options, ScheduledExecutorService fallbackExecutor) {
    if (isShutdown) {
      return this.execService;
    }
    if (this.execService != null) {
      return this.execService;
    }
    if (fallbackExecutor != null) {
      this.execService = fallbackExecutor;
      this.ownsExecutor = false;
    } else if (options != null && options.getSharedExecutorService() != null) {
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

  synchronized ScheduledFuture<?> scheduleTask(
      Runnable command, long initialDelay, long period, TimeUnit unit) {
    if (isShutdown || this.execService == null || this.execService.isShutdown()) {
      return null;
    }
    return this.execService.scheduleAtFixedRate(
        () -> {
          try {
            command.run();
          } catch (Throwable t) {
          }
        },
        initialDelay,
        period,
        unit);
  }

  /** Starts the periodic error rate evaluation loop once across all channels sharing this state. */
  synchronized void startPeriodicEvaluation(GcpFallbackChannelOptions options) {
    if (isShutdown
        || options == null
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

      try {
        scheduledEvaluationFuture =
            scheduleTask(
                () -> checkErrorRates(options, openTelemetry),
                options.getPeriod().toMillis(),
                options.getPeriod().toMillis(),
                TimeUnit.MILLISECONDS);
      } catch (RuntimeException e) {
        evaluationStarted.set(false);
        throw e;
      }
    }
  }

  /** Evaluates error rates across all channels sharing this state and updates fallback mode. */
  void checkErrorRates(GcpFallbackChannelOptions options, GcpFallbackOpenTelemetry openTelemetry) {
    float primaryErrorRate = 0f;
    boolean shouldTriggerFallback;
    synchronized (this) {
      long primarySuccessCount = primarySuccesses.getAndSet(0);
      long primaryFailureCount = primaryFailures.getAndSet(0);
      if (primaryFailureCount + primarySuccessCount > 0) {
        primaryErrorRate =
            (float) primaryFailureCount / (primaryFailureCount + primarySuccessCount);
      }
      shouldTriggerFallback =
          !inFallbackMode.get()
              && options.isEnableFallback()
              && primaryFailureCount >= options.getMinFailedCalls()
              && primaryErrorRate >= options.getErrorRateThreshold();
    }

    boolean fallbackTriggered = shouldTriggerFallback && triggerFallback();
    boolean currentInFallback = inFallbackMode.get();

    long fallbackSuccessCount = fallbackSuccesses.getAndSet(0);
    long fallbackFailureCount = fallbackFailures.getAndSet(0);
    float fallbackErrorRate = 0f;
    if (fallbackFailureCount + fallbackSuccessCount > 0) {
      fallbackErrorRate =
          (float) fallbackFailureCount / (fallbackFailureCount + fallbackSuccessCount);
    }

    if (openTelemetry != null && openTelemetry.getModule() != null) {
      openTelemetry.getModule().reportErrorRate(options.getPrimaryChannelName(), primaryErrorRate);
      if (fallbackTriggered) {
        openTelemetry
            .getModule()
            .reportFallback(options.getPrimaryChannelName(), options.getFallbackChannelName());
      }
      openTelemetry
          .getModule()
          .reportErrorRate(options.getFallbackChannelName(), fallbackErrorRate);
      openTelemetry
          .getModule()
          .reportCurrentChannel(options.getPrimaryChannelName(), !currentInFallback);
      openTelemetry
          .getModule()
          .reportCurrentChannel(options.getFallbackChannelName(), currentInFallback);
    }
  }

  synchronized void stopPeriodicEvaluation() {
    if (scheduledEvaluationFuture != null) {
      scheduledEvaluationFuture.cancel(false);
      scheduledEvaluationFuture = null;
    }
    evaluationStarted.set(false);
  }

  /** Shuts down the state, cancelling evaluation and shutting down internal executor if owned. */
  public synchronized void shutdown() {
    isShutdown = true;
    stateChangeCallbacks.clear();
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
    isShutdown = true;
    stateChangeCallbacks.clear();
    stopPeriodicEvaluation();
    if (ownsExecutor && execService != null && !execService.isShutdown()) {
      execService.shutdownNow();
    }
  }
}
