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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * Shared thread-safe state that coordinates failover, recovery, and periodic error evaluation
 * across a pool of GcpFallbackChannel instances.
 */
public class GcpFallbackState implements AutoCloseable {
  private final LongAdder primarySuccesses = new LongAdder();
  private final LongAdder primaryFailures = new LongAdder();
  private final LongAdder fallbackSuccesses = new LongAdder();
  private final LongAdder fallbackFailures = new LongAdder();
  private volatile boolean inFallbackMode = false;
  private long fallbackEpoch = 0;
  private final AtomicBoolean evaluationStarted = new AtomicBoolean(false);
  private final Set<GcpFallbackChannel> channels = new HashSet<>();

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

  LongAdder getPrimarySuccesses() {
    return primarySuccesses;
  }

  LongAdder getPrimaryFailures() {
    return primaryFailures;
  }

  LongAdder getFallbackSuccesses() {
    return fallbackSuccesses;
  }

  LongAdder getFallbackFailures() {
    return fallbackFailures;
  }

  boolean isInFallbackMode() {
    return inFallbackMode;
  }

  @VisibleForTesting
  synchronized long getFallbackEpoch() {
    return fallbackEpoch;
  }

  @VisibleForTesting
  synchronized int getRegisteredChannelCount() {
    return channels.size();
  }

  void registerChannel(GcpFallbackChannel channel) {
    List<Runnable> callbacks = null;
    synchronized (this) {
      if (!isShutdown) {
        channels.add(channel);
        if (inFallbackMode) {
          callbacks = channel.markFallbackMode(fallbackEpoch);
        }
      }
    }
    GcpFallbackChannel.runStateChangeCallbacks(callbacks);
  }

  synchronized void unregisterChannel(GcpFallbackChannel channel) {
    channels.remove(channel);
  }

  synchronized boolean onChannelRecovered(GcpFallbackChannel channel, long epoch) {
    if (epoch == fallbackEpoch && channels.contains(channel)) {
      return resetFallbackMode();
    }
    return false;
  }

  /** Must be called while holding {@code synchronized (this)}. */
  private boolean resetFallbackMode() {
    if (inFallbackMode) {
      inFallbackMode = false;
      // Clears the primary call counters when the first channel recovers so the post-recovery
      // error window starts fresh without resetting counters again when later channels recover.
      primaryFailures.reset();
      primarySuccesses.reset();
      return true;
    }
    return false;
  }

  /**
   * Transitions all registered channels into fallback mode under a new epoch and appends pending
   * state-change callbacks to {@code callbacksOut}. Must be called while holding {@code
   * synchronized (this)}.
   */
  private void markRegisteredChannelsFallback(List<Runnable> callbacksOut) {
    fallbackEpoch++;
    inFallbackMode = true;
    for (GcpFallbackChannel channel : channels) {
      List<Runnable> channelCallbacks = channel.markFallbackMode(fallbackEpoch);
      if (channelCallbacks != null) {
        callbacksOut.addAll(channelCallbacks);
      }
    }
  }

  /** Transitions the pool to fallback mode and notifies all registered channels. */
  boolean triggerFallback() {
    List<Runnable> callbacks = null;
    synchronized (this) {
      if (!inFallbackMode && !channels.isEmpty()) {
        callbacks = new ArrayList<>();
        markRegisteredChannelsFallback(callbacks);
      }
    }
    if (callbacks != null) {
      GcpFallbackChannel.runStateChangeCallbacks(callbacks);
      return true;
    }
    return false;
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
      ScheduledThreadPoolExecutor executor =
          new ScheduledThreadPoolExecutor(
              3, GcpThreadFactory.newThreadFactory("gcp-fallback-state-%d"));
      executor.setRemoveOnCancelPolicy(true);
      this.execService = executor;
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
    boolean switchedToFallback = false;
    List<Runnable> callbacks = null;
    synchronized (this) {
      long primarySuccessCount = primarySuccesses.sumThenReset();
      long primaryFailureCount = primaryFailures.sumThenReset();
      if (primaryFailureCount + primarySuccessCount > 0) {
        primaryErrorRate =
            (float) primaryFailureCount / (primaryFailureCount + primarySuccessCount);
      }
      boolean shouldTriggerFallback =
          !channels.isEmpty()
              && !inFallbackMode
              && options.isEnableFallback()
              && primaryFailureCount >= options.getMinFailedCalls()
              && primaryErrorRate >= options.getErrorRateThreshold();
      if (shouldTriggerFallback) {
        callbacks = new ArrayList<>();
        markRegisteredChannelsFallback(callbacks);
        switchedToFallback = true;
      }
    }
    GcpFallbackChannel.runStateChangeCallbacks(callbacks);
    boolean currentInFallback = inFallbackMode;

    long fallbackSuccessCount = fallbackSuccesses.sumThenReset();
    long fallbackFailureCount = fallbackFailures.sumThenReset();
    float fallbackErrorRate = 0f;
    if (fallbackFailureCount + fallbackSuccessCount > 0) {
      fallbackErrorRate =
          (float) fallbackFailureCount / (fallbackFailureCount + fallbackSuccessCount);
    }

    if (openTelemetry != null && openTelemetry.getModule() != null) {
      openTelemetry.getModule().reportErrorRate(options.getPrimaryChannelName(), primaryErrorRate);
      if (switchedToFallback) {
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
    channels.clear();
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
    channels.clear();
    stopPeriodicEvaluation();
    if (ownsExecutor && execService != null && !execService.isShutdown()) {
      execService.shutdownNow();
    }
  }

  @Override
  public void close() {
    shutdown();
  }
}
