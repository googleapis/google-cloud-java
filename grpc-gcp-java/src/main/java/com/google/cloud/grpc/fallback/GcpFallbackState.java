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
 * Shared thread-safe state container for coordinated pool-wide failover, recovery, and background
 * tasks.
 *
 * <p>All channels in a pool share this state instance and its background executor service,
 * consolidating probing and error evaluation threads across the entire channel pool.
 */
public class GcpFallbackState {
  private final AtomicLong primarySuccesses = new AtomicLong(0);
  private final AtomicLong primaryFailures = new AtomicLong(0);
  private final AtomicLong fallbackSuccesses = new AtomicLong(0);
  private final AtomicLong fallbackFailures = new AtomicLong(0);
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
  public GcpFallbackState(ScheduledExecutorService execService) {
    this.execService = execService;
    this.ownsExecutor = true;
  }

  public AtomicLong getPrimarySuccesses() {
    return primarySuccesses;
  }

  public AtomicLong getPrimaryFailures() {
    return primaryFailures;
  }

  public AtomicLong getFallbackSuccesses() {
    return fallbackSuccesses;
  }

  public AtomicLong getFallbackFailures() {
    return fallbackFailures;
  }

  public AtomicBoolean getInFallbackMode() {
    return inFallbackMode;
  }

  /**
   * Retrieves or lazily initializes the background executor service.
   *
   * @param options optional fallback channel configuration options.
   * @return the active ScheduledExecutorService.
   */
  public synchronized ScheduledExecutorService getOrCreateExecutorService(
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
  public synchronized ScheduledFuture<?> scheduleTask(
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
  public synchronized void startPeriodicEvaluation(GcpFallbackChannelOptions options) {
    if (options == null
        || !options.isEnableFallback()
        || options.getPeriod() == null
        || options.getPeriod().toMillis() <= 0) {
      return;
    }
    if (evaluationStarted.compareAndSet(false, true)) {
      ScheduledExecutorService executor = getOrCreateExecutorService(options);
      if (executor == null || executor.isShutdown()) {
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
  public void checkErrorRates(
      GcpFallbackChannelOptions options, GcpFallbackOpenTelemetry openTelemetry) {
    long successes = primarySuccesses.getAndSet(0);
    long failures = primaryFailures.getAndSet(0);
    float errRate = 0f;
    if (failures + successes > 0) {
      errRate = (float) failures / (failures + successes);
    }
    if (openTelemetry != null && openTelemetry.getModule() != null) {
      openTelemetry.getModule().reportErrorRate(options.getPrimaryChannelName(), errRate);
    }

    if (!inFallbackMode.get() && options.isEnableFallback()) {
      if (failures >= options.getMinFailedCalls() && errRate >= options.getErrorRateThreshold()) {
        inFallbackMode.set(true);
        if (openTelemetry != null && openTelemetry.getModule() != null) {
          openTelemetry
              .getModule()
              .reportFallback(options.getPrimaryChannelName(), options.getFallbackChannelName());
        }
      }
    }

    successes = fallbackSuccesses.getAndSet(0);
    failures = fallbackFailures.getAndSet(0);
    errRate = 0f;
    if (failures + successes > 0) {
      errRate = (float) failures / (failures + successes);
    }
    if (openTelemetry != null && openTelemetry.getModule() != null) {
      openTelemetry.getModule().reportErrorRate(options.getFallbackChannelName(), errRate);
      openTelemetry
          .getModule()
          .reportCurrentChannel(options.getPrimaryChannelName(), !inFallbackMode.get());
      openTelemetry
          .getModule()
          .reportCurrentChannel(options.getFallbackChannelName(), inFallbackMode.get());
    }
  }

  /** Stops any running scheduled evaluation. */
  public synchronized void stopPeriodicEvaluation() {
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
