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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shared thread-safe state that coordinates failover, recovery, and periodic error evaluation
 * across a pool of GcpFallbackChannel instances.
 */
public class GcpFallbackState implements AutoCloseable {
  private static final Logger logger = Logger.getLogger(GcpFallbackState.class.getName());
  private final LongAdder primarySuccesses = new LongAdder();
  private final LongAdder primaryFailures = new LongAdder();
  private final LongAdder fallbackSuccesses = new LongAdder();
  private final LongAdder fallbackFailures = new LongAdder();
  private volatile boolean inFallbackMode = false;
  private long fallbackEpoch = 0;
  private long lastReportedRecoveryEpoch = 0;
  private final AtomicBoolean evaluationStarted = new AtomicBoolean(false);
  private final Set<GcpFallbackChannel> channels = new HashSet<>();

  private ScheduledExecutorService execService = null;
  private ScheduledExecutorService probeExecService = null;
  private boolean ownsExecutor = false;
  private boolean isShutdown = false;
  private volatile ScheduledFuture<?> scheduledEvaluationFuture = null;
  private GcpFallbackChannelOptions evaluationOptions = null;
  private GcpFallbackOpenTelemetry evaluationOpenTelemetry = null;

  public GcpFallbackState() {}

  @VisibleForTesting
  GcpFallbackState(ScheduledExecutorService execService) {
    this.execService = execService;
    this.probeExecService = execService;
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

  synchronized void registerChannel(GcpFallbackChannel channel) {
    if (!isShutdown) {
      channels.add(channel);
      if (inFallbackMode) {
        // Channel is still under construction, so it has no registered state-change callbacks.
        channel.markFallbackMode(fallbackEpoch);
      }
    }
  }

  synchronized void unregisterChannel(GcpFallbackChannel channel) {
    if (!channels.remove(channel)) {
      return;
    }
    if (!inFallbackMode && !channels.isEmpty() && allChannelsInFallback()) {
      // Restore shared fallback without bumping epoch so siblings keep probe progress.
      inFallbackMode = true;
    }
  }

  /** Must be called while holding {@code synchronized (this)}. */
  private boolean allChannelsInFallback() {
    for (GcpFallbackChannel ch : channels) {
      if (!ch.isInFallbackMode()) {
        return false;
      }
    }
    return true;
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
      rearmPeriodicEvaluation();
      if (lastReportedRecoveryEpoch != fallbackEpoch) {
        lastReportedRecoveryEpoch = fallbackEpoch;
        return true;
      }
    }
    return false;
  }

  /** Must be called while holding {@code synchronized (this)}. */
  private void rearmPeriodicEvaluation() {
    if (isShutdown || !evaluationStarted.get() || evaluationOptions == null) {
      return;
    }
    if (scheduledEvaluationFuture != null) {
      scheduledEvaluationFuture.cancel(false);
      scheduledEvaluationFuture = null;
    }
    final GcpFallbackChannelOptions options = evaluationOptions;
    final GcpFallbackOpenTelemetry openTelemetry = evaluationOpenTelemetry;
    long periodMillis = options.getPeriod().toMillis();
    try {
      scheduledEvaluationFuture =
          scheduleTask(
              () -> checkErrorRates(options, openTelemetry),
              periodMillis,
              periodMillis,
              TimeUnit.MILLISECONDS);
    } catch (RuntimeException e) {
      scheduledEvaluationFuture = null;
      evaluationStarted.set(false);
      logger.log(Level.WARNING, "Failed to re-arm periodic error rate evaluation", e);
    }
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
  @VisibleForTesting
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

  @VisibleForTesting
  synchronized ScheduledExecutorService getEvaluationExecutorService() {
    return execService;
  }

  @VisibleForTesting
  synchronized ScheduledExecutorService getProbeExecutorService() {
    return probeExecService;
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
      this.probeExecService = fallbackExecutor;
      this.ownsExecutor = false;
    } else if (options != null && options.getSharedExecutorService() != null) {
      this.execService = options.getSharedExecutorService();
      this.probeExecService = options.getSharedExecutorService();
      this.ownsExecutor = false;
    } else {
      ScheduledThreadPoolExecutor evalExecutor =
          new ScheduledThreadPoolExecutor(
              1, GcpThreadFactory.newThreadFactory("gcp-fallback-eval-%d"));
      evalExecutor.setRemoveOnCancelPolicy(true);
      ScheduledThreadPoolExecutor probeExecutor =
          new ScheduledThreadPoolExecutor(
              2, GcpThreadFactory.newThreadFactory("gcp-fallback-probe-%d"));
      probeExecutor.setRemoveOnCancelPolicy(true);
      this.execService = evalExecutor;
      this.probeExecService = probeExecutor;
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

  synchronized ScheduledFuture<?> scheduleProbeTask(
      Runnable command, long initialDelay, long delay, TimeUnit unit) {
    if (isShutdown || this.probeExecService == null || this.probeExecService.isShutdown()) {
      return null;
    }
    return this.probeExecService.scheduleWithFixedDelay(
        () -> {
          try {
            command.run();
          } catch (Throwable t) {
            logger.log(Level.WARNING, "Scheduled fallback probe task failed unexpectedly", t);
          }
        },
        initialDelay,
        delay,
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
        this.evaluationOptions = options;
        this.evaluationOpenTelemetry = openTelemetry;
        scheduledEvaluationFuture =
            scheduleTask(
                () -> checkErrorRates(options, openTelemetry),
                options.getPeriod().toMillis(),
                options.getPeriod().toMillis(),
                TimeUnit.MILLISECONDS);
      } catch (RuntimeException e) {
        this.evaluationOptions = null;
        this.evaluationOpenTelemetry = null;
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
    evaluationOptions = null;
    evaluationOpenTelemetry = null;
    evaluationStarted.set(false);
  }

  synchronized boolean areOwnedExecutorsShutdown() {
    if (!ownsExecutor) {
      return true;
    }
    if (execService != null && !execService.isShutdown()) {
      return false;
    }
    if (probeExecService != null
        && probeExecService != execService
        && !probeExecService.isShutdown()) {
      return false;
    }
    return true;
  }

  synchronized boolean areOwnedExecutorsTerminated() {
    if (!ownsExecutor) {
      return true;
    }
    if (execService != null && !execService.isTerminated()) {
      return false;
    }
    if (probeExecService != null
        && probeExecService != execService
        && !probeExecService.isTerminated()) {
      return false;
    }
    return true;
  }

  boolean awaitOwnedExecutorsTermination(long timeoutNanos) throws InterruptedException {
    ScheduledExecutorService evalExec;
    ScheduledExecutorService probeExec;
    synchronized (this) {
      if (!ownsExecutor) {
        return true;
      }
      evalExec = this.execService;
      probeExec = this.probeExecService;
    }
    long endTimeNanos = System.nanoTime() + timeoutNanos;
    if (evalExec != null && !evalExec.awaitTermination(timeoutNanos, TimeUnit.NANOSECONDS)) {
      return false;
    }
    if (probeExec != null && probeExec != evalExec) {
      long remainingNanos = endTimeNanos - System.nanoTime();
      return probeExec.awaitTermination(remainingNanos, TimeUnit.NANOSECONDS);
    }
    return true;
  }

  /** Shuts down the state, cancelling evaluation and shutting down internal executors if owned. */
  public synchronized void shutdown() {
    isShutdown = true;
    channels.clear();
    stopPeriodicEvaluation();
    if (ownsExecutor) {
      if (execService != null && !execService.isShutdown()) {
        execService.shutdown();
      }
      if (probeExecService != null
          && probeExecService != execService
          && !probeExecService.isShutdown()) {
        probeExecService.shutdown();
      }
    }
  }

  /**
   * Shuts down the state immediately, cancelling evaluation and terminating internal executors if
   * owned.
   */
  public synchronized void shutdownNow() {
    isShutdown = true;
    channels.clear();
    stopPeriodicEvaluation();
    if (ownsExecutor) {
      if (execService != null && !execService.isShutdown()) {
        execService.shutdownNow();
      }
      if (probeExecService != null
          && probeExecService != execService
          && !probeExecService.isShutdown()) {
        probeExecService.shutdownNow();
      }
    }
  }

  @Override
  public void close() {
    shutdown();
  }
}
