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
  private final AtomicLong generation = new AtomicLong(0);
  private final AtomicBoolean inFallbackMode = new AtomicBoolean(false);
  private final AtomicBoolean evaluationStarted = new AtomicBoolean(false);
  private final Set<Runnable> stateChangeCallbacks = ConcurrentHashMap.newKeySet();

  private ScheduledExecutorService execService = null;
  private boolean ownsExecutor = false;
  private boolean isShutdown = false;
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

  synchronized void registerStateChangeCallback(Runnable callback) {
    if (!isShutdown) {
      stateChangeCallbacks.add(callback);
    }
  }

  synchronized void unregisterStateChangeCallback(Runnable callback) {
    stateChangeCallbacks.remove(callback);
  }

  private void triggerStateChangeCallbacks() {
    List<Runnable> callbacks;
    synchronized (this) {
      callbacks = new ArrayList<>(stateChangeCallbacks);
      stateChangeCallbacks.clear();
    }
    for (Runnable callback : callbacks) {
      try {
        callback.run();
      } catch (Exception e) {
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

  /** Returns whether the pool is currently in fallback mode. */
  boolean isInFallbackMode() {
    return inFallbackMode.get();
  }

  long getGeneration() {
    return generation.get();
  }

  /** Bumps the generation counter and transitions the pool to fallback mode. */
  void triggerFallback() {
    boolean changed = false;
    synchronized (this) {
      if (!inFallbackMode.get()) {
        generation.incrementAndGet();
        inFallbackMode.set(true);
        changed = true;
      }
    }
    if (changed) {
      triggerStateChangeCallbacks();
    }
  }

  /**
   * Records pool recovery by clearing primary error counts and updating fallback mode.
   *
   * @param expectedGen the generation at which the recovery probe started.
   * @return the resulting pool generation, or -1 if the pool generation changed concurrently.
   */
  long recordRecovery(long expectedGen) {
    boolean changed = false;
    long currentGen;
    synchronized (this) {
      if (generation.get() != expectedGen) {
        return -1;
      }
      if (inFallbackMode.get()) {
        primaryFailures.set(0);
        primarySuccesses.set(0);
        generation.incrementAndGet();
        inFallbackMode.set(false);
        changed = true;
      }
      currentGen = generation.get();
    }
    if (changed) {
      triggerStateChangeCallbacks();
    }
    return currentGen;
  }

  /**
   * Retrieves or lazily initializes the background executor service.
   *
   * @param options optional fallback channel configuration options.
   * @return the active ScheduledExecutorService.
   */
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

  /** Schedules a periodic task (e.g., probe) on the shared background executor service. */
  synchronized ScheduledFuture<?> scheduleTask(
      Runnable command, long initialDelay, long period, TimeUnit unit) {
    if (isShutdown || this.execService == null || this.execService.isShutdown()) {
      return null;
    }
    return this.execService.scheduleAtFixedRate(
        () -> {
          try {
            command.run();
          } catch (Exception e) {
          }
        },
        initialDelay,
        period,
        unit);
  }

  /**
   * Starts the periodic error rate evaluation loop exactly once across all channels sharing this
   * state. Channels sharing this state should use consistent evaluation options, as the first
   * channel to start evaluation configures the shared loop.
   *
   * @param options the fallback channel configuration options.
   */
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

  /**
   * Evaluates error rates across all channels sharing this state and updates fallback mode.
   *
   * @param options the fallback channel configuration options.
   * @param openTelemetry telemetry module for recording error metrics.
   */
  void checkErrorRates(GcpFallbackChannelOptions options, GcpFallbackOpenTelemetry openTelemetry) {
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
          generation.incrementAndGet();
          inFallbackMode.set(true);
          fallbackTriggered = true;
        }
      }
      currentInFallback = inFallbackMode.get();
    }

    if (fallbackTriggered) {
      triggerStateChangeCallbacks();
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
