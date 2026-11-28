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

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongSupplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class GcpFallbackChannel extends ManagedChannel {
  private static final Logger logger = Logger.getLogger(GcpFallbackChannel.class.getName());
  static final String INIT_FAILURE_REASON = "init failure";
  private final GcpFallbackChannelOptions options;
  // Primary channel that was provided in constructor.
  @Nullable private final ManagedChannel primaryDelegateChannel;
  // Fallback channel that was provided in constructor.
  @Nullable private final ManagedChannel fallbackDelegateChannel;
  // Wrapped primary channel to be used for RPCs.
  private final Channel primaryChannel;
  // Wrapped fallback channel to be used for RPCs.
  private final Channel fallbackChannel;
  private final GcpFallbackState fallbackState;
  private final boolean ownsFallbackState;
  private final GcpFallbackOpenTelemetry openTelemetry;
  private LongSupplier nanoTimeSupplier = System::nanoTime;

  private volatile boolean channelInFallback = false;
  private long channelFallbackEpoch = 0;
  private long primaryProbeSuccesses = 0;
  private long firstPrimaryProbeSuccessNanos = 0;
  private final Set<Runnable> stateChangeCallbacks = new HashSet<>();
  private volatile boolean isShutdown = false;

  private final ScheduledExecutorService execService;
  private volatile ScheduledFuture<?> primaryProbeFuture = null;
  private volatile ScheduledFuture<?> fallbackProbeFuture = null;

  public GcpFallbackChannel(
      GcpFallbackChannelOptions options,
      ManagedChannel primaryChannel,
      ManagedChannel fallbackChannel) {
    this(options, primaryChannel, fallbackChannel, null);
  }

  public GcpFallbackChannel(
      GcpFallbackChannelOptions options,
      ManagedChannelBuilder<?> primaryChannelBuilder,
      ManagedChannelBuilder<?> fallbackChannelBuilder) {
    this(options, primaryChannelBuilder, fallbackChannelBuilder, null);
  }

  @VisibleForTesting
  GcpFallbackChannel(
      GcpFallbackChannelOptions options,
      ManagedChannelBuilder<?> primaryChannelBuilder,
      ManagedChannelBuilder<?> fallbackChannelBuilder,
      ScheduledExecutorService execService) {
    checkNotNull(options);
    checkNotNull(primaryChannelBuilder);
    checkNotNull(fallbackChannelBuilder);
    this.options = options;
    if (options.getSharedState() != null) {
      this.fallbackState = options.getSharedState();
      this.ownsFallbackState = false;
    } else {
      this.fallbackState =
          execService != null ? new GcpFallbackState(execService) : new GcpFallbackState();
      this.ownsFallbackState = true;
    }
    if (options.getGcpOpenTelemetry() != null) {
      this.openTelemetry = options.getGcpOpenTelemetry();
    } else {
      this.openTelemetry = GcpFallbackOpenTelemetry.newBuilder().build();
    }
    ManagedChannel primaryChannel = null;
    try {
      primaryChannel = primaryChannelBuilder.build();
    } catch (Exception e) {
      logger.warning(
          String.format(
              "Primary channel initialization failed: %s. Will use fallback channel.",
              e.getMessage()));
    }
    primaryDelegateChannel = primaryChannel;

    ManagedChannel fallbackChannel = null;
    try {
      fallbackChannel = fallbackChannelBuilder.build();
    } catch (Exception e) {
      if (primaryChannel == null) {
        throw new RuntimeException(
            "Both primary and fallback channels initialization failed: " + e.getMessage(), e);
      }

      logger.warning(
          String.format(
              "Fallback channel initialization failed: %s. Will use only the primary channel.",
              e.getMessage()));
    }
    fallbackDelegateChannel = fallbackChannel;

    if (primaryDelegateChannel != null) {
      this.primaryChannel =
          ClientInterceptors.intercept(
              primaryDelegateChannel, new MonitoringInterceptor(this::processPrimaryStatusCode));
    } else {
      this.primaryChannel = null;
    }

    if (fallbackDelegateChannel != null) {
      this.fallbackChannel =
          ClientInterceptors.intercept(
              fallbackDelegateChannel, new MonitoringInterceptor(this::processFallbackStatusCode));
    } else {
      this.fallbackChannel = null;
    }

    this.execService = fallbackState.getOrCreateExecutorService(options, execService);
    init();
  }

  @VisibleForTesting
  GcpFallbackChannel(
      GcpFallbackChannelOptions options,
      ManagedChannel primaryChannel,
      ManagedChannel fallbackChannel,
      ScheduledExecutorService execService) {
    checkNotNull(options);
    checkNotNull(primaryChannel);
    checkNotNull(fallbackChannel);
    this.options = options;
    if (options.getSharedState() != null) {
      this.fallbackState = options.getSharedState();
      this.ownsFallbackState = false;
    } else {
      this.fallbackState =
          execService != null ? new GcpFallbackState(execService) : new GcpFallbackState();
      this.ownsFallbackState = true;
    }
    this.execService = fallbackState.getOrCreateExecutorService(options, execService);
    if (options.getGcpOpenTelemetry() != null) {
      this.openTelemetry = options.getGcpOpenTelemetry();
    } else {
      this.openTelemetry = GcpFallbackOpenTelemetry.newBuilder().build();
    }
    primaryDelegateChannel = primaryChannel;
    fallbackDelegateChannel = fallbackChannel;
    ClientInterceptor primaryMonitorInterceptor =
        new MonitoringInterceptor(this::processPrimaryStatusCode);
    this.primaryChannel =
        ClientInterceptors.intercept(primaryDelegateChannel, primaryMonitorInterceptor);
    ClientInterceptor fallbackMonitorInterceptor =
        new MonitoringInterceptor(this::processFallbackStatusCode);
    this.fallbackChannel =
        ClientInterceptors.intercept(fallbackDelegateChannel, fallbackMonitorInterceptor);
    init();
  }

  public boolean isInFallbackMode() {
    return (channelInFallback && fallbackChannel != null) || primaryChannel == null;
  }

  @VisibleForTesting
  GcpFallbackState getFallbackState() {
    return fallbackState;
  }

  @VisibleForTesting
  synchronized long getPrimaryProbeSuccesses() {
    return primaryProbeSuccesses;
  }

  @VisibleForTesting
  synchronized void setNanoTimeSupplier(LongSupplier nanoTimeSupplier) {
    this.nanoTimeSupplier = checkNotNull(nanoTimeSupplier);
  }

  private synchronized void registerStateChangeCallback(Runnable callback) {
    if (!isShutdown) {
      stateChangeCallbacks.add(callback);
    }
  }

  private synchronized void unregisterStateChangeCallback(Runnable callback) {
    stateChangeCallbacks.remove(callback);
  }

  private List<Runnable> snapshotAndClearCallbacks() {
    List<Runnable> callbacks = new ArrayList<>(stateChangeCallbacks);
    stateChangeCallbacks.clear();
    return callbacks;
  }

  static void runStateChangeCallbacks(@Nullable List<Runnable> callbacks) {
    if (callbacks == null) {
      return;
    }
    for (Runnable callback : callbacks) {
      try {
        callback.run();
      } catch (Throwable e) {
        logger.log(Level.WARNING, "State change callback failed unexpectedly", e);
      }
    }
  }

  /**
   * Transitions this channel into fallback mode for the given {@code epoch} and returns any pending
   * state-change callbacks to be invoked by the caller outside locks. Returns {@code null} if this
   * channel did not transition (already in fallback mode, shut down, or has no fallback channel).
   */
  @Nullable
  List<Runnable> markFallbackMode(long epoch) {
    if (fallbackChannel == null) {
      return null;
    }
    synchronized (this) {
      if (isShutdown) {
        return null;
      }
      channelFallbackEpoch = epoch;
      primaryProbeSuccesses = 0;
      firstPrimaryProbeSuccessNanos = 0;
      if (channelInFallback) {
        return null;
      }
      channelInFallback = true;
      return snapshotAndClearCallbacks();
    }
  }

  @VisibleForTesting
  void recordPrimaryProbeResult(boolean success) {
    long currentEpoch;
    synchronized (this) {
      currentEpoch = channelFallbackEpoch;
    }
    recordPrimaryProbeResult(success, currentEpoch);
  }

  /**
   * Records the result of a primary probe that started in fallback episode {@code probeEpoch}. A
   * success is ignored if a newer pool-wide fallback episode began while the probe was in flight.
   */
  private void recordPrimaryProbeResult(boolean success, long probeEpoch) {
    if (!options.isEnableRecovery() || fallbackChannel == null || primaryDelegateChannel == null) {
      return;
    }
    boolean recovered = false;
    long recoveredEpoch = 0;
    List<Runnable> callbacks = null;
    synchronized (this) {
      if (isShutdown || !channelInFallback) {
        return;
      }
      if (!success) {
        primaryProbeSuccesses = 0;
        firstPrimaryProbeSuccessNanos = 0;
        return;
      }
      if (probeEpoch != channelFallbackEpoch) {
        return;
      }
      long nowNanos = nanoTimeSupplier.getAsLong();
      primaryProbeSuccesses++;
      if (primaryProbeSuccesses == 1) {
        firstPrimaryProbeSuccessNanos = nowNanos;
      }

      Duration minDuration = options.getMinPrimaryProbeSuccessDuration();
      boolean durationSatisfied =
          minDuration == null
              || minDuration.toNanos() <= 0
              || (nowNanos - firstPrimaryProbeSuccessNanos) >= minDuration.toNanos();

      if (primaryProbeSuccesses >= options.getMinPrimaryProbeSuccessCount() && durationSatisfied) {
        primaryProbeSuccesses = 0;
        firstPrimaryProbeSuccessNanos = 0;
        channelInFallback = false;
        recoveredEpoch = channelFallbackEpoch;
        callbacks = snapshotAndClearCallbacks();
        recovered = true;
      }
    }
    if (recovered) {
      boolean poolRecovered = fallbackState.onChannelRecovered(this, recoveredEpoch);
      runStateChangeCallbacks(callbacks);
      if (poolRecovered) {
        openTelemetry
            .getModule()
            .reportFallback(options.getFallbackChannelName(), options.getPrimaryChannelName());
      }
    }
  }

  private void init() {
    if (options.getPrimaryProbingFunction() != null) {
      this.primaryProbeFuture =
          fallbackState.scheduleTask(
              this::probePrimary,
              options.getPrimaryProbingInterval().toMillis(),
              options.getPrimaryProbingInterval().toMillis(),
              MILLISECONDS);
    }

    if (options.getFallbackProbingFunction() != null) {
      this.fallbackProbeFuture =
          fallbackState.scheduleTask(
              this::probeFallback,
              options.getFallbackProbingInterval().toMillis(),
              options.getFallbackProbingInterval().toMillis(),
              MILLISECONDS);
    }

    fallbackState.startPeriodicEvaluation(options);
    if (this.fallbackChannel != null && this.primaryChannel != null) {
      fallbackState.registerChannel(this);
    }
  }

  private void processPrimaryStatusCode(Status.Code statusCode) {
    if (!isInFallbackMode()) {
      if (options.getErroneousStates().contains(statusCode)) {
        fallbackState.getPrimaryFailures().increment();
      } else {
        fallbackState.getPrimarySuccesses().increment();
      }
    }
    openTelemetry.getModule().reportStatus(options.getPrimaryChannelName(), statusCode);
  }

  private void processFallbackStatusCode(Status.Code statusCode) {
    if (options.getErroneousStates().contains(statusCode)) {
      fallbackState.getFallbackFailures().increment();
    } else {
      fallbackState.getFallbackSuccesses().increment();
    }
    openTelemetry.getModule().reportStatus(options.getFallbackChannelName(), statusCode);
  }

  private void probePrimary() {
    long probeEpoch;
    synchronized (this) {
      if (isShutdown || !isInFallbackMode()) {
        return;
      }
      probeEpoch = channelFallbackEpoch;
    }
    String result = "";
    if (primaryDelegateChannel == null) {
      result = INIT_FAILURE_REASON;
    } else {
      try {
        result = options.getPrimaryProbingFunction().apply(primaryDelegateChannel);
      } catch (Exception e) {
        result = e.getClass().getSimpleName();
      }
    }
    recordPrimaryProbeResult("".equals(result), probeEpoch);
    // Report metric based on result.
    openTelemetry.getModule().reportProbeResult(options.getPrimaryChannelName(), result);
  }

  private void probeFallback() {
    if (isShutdown) {
      return;
    }
    String result = "";
    if (fallbackDelegateChannel == null) {
      result = INIT_FAILURE_REASON;
    } else {
      try {
        result = options.getFallbackProbingFunction().apply(fallbackDelegateChannel);
      } catch (Exception e) {
        result = e.getClass().getSimpleName();
      }
    }
    // Report metric based on result.
    openTelemetry.getModule().reportProbeResult(options.getFallbackChannelName(), result);
  }

  @Override
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
      MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
    if (isInFallbackMode()) {
      return fallbackChannel.newCall(methodDescriptor, callOptions);
    }

    return primaryChannel.newCall(methodDescriptor, callOptions);
  }

  @Override
  public String authority() {
    if (isInFallbackMode()) {
      return fallbackChannel.authority();
    }

    return primaryChannel.authority();
  }

  @Override
  public ConnectivityState getState(boolean requestConnection) {
    if (isInFallbackMode()) {
      if (fallbackDelegateChannel != null) {
        return fallbackDelegateChannel.getState(requestConnection);
      }
      return ConnectivityState.SHUTDOWN;
    }

    if (primaryDelegateChannel != null) {
      return primaryDelegateChannel.getState(requestConnection);
    }
    return ConnectivityState.SHUTDOWN;
  }

  @Override
  public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
    boolean initialFallbackMode = isInFallbackMode();
    ManagedChannel delegate =
        initialFallbackMode ? fallbackDelegateChannel : primaryDelegateChannel;
    AtomicReference<Runnable> callbackRef = new AtomicReference<>(callback);
    Runnable once =
        () -> {
          Runnable cb = callbackRef.getAndSet(null);
          if (cb != null) {
            cb.run();
          }
        };
    if (delegate != null) {
      if (source != ConnectivityState.SHUTDOWN) {
        registerStateChangeCallback(once);
        if (isInFallbackMode() != initialFallbackMode) {
          unregisterStateChangeCallback(once);
          once.run();
          return;
        }
      }
      delegate.notifyWhenStateChanged(
          source,
          () -> {
            unregisterStateChangeCallback(once);
            once.run();
          });
    } else if (source != ConnectivityState.SHUTDOWN) {
      once.run();
    }
  }

  @Override
  public ManagedChannel shutdown() {
    synchronized (this) {
      isShutdown = true;
      stateChangeCallbacks.clear();
    }
    if (primaryProbeFuture != null) {
      primaryProbeFuture.cancel(false);
    }
    if (fallbackProbeFuture != null) {
      fallbackProbeFuture.cancel(false);
    }
    if (!ownsFallbackState) {
      fallbackState.unregisterChannel(this);
    }
    if (primaryDelegateChannel != null) {
      primaryDelegateChannel.shutdown();
    }
    if (fallbackDelegateChannel != null) {
      fallbackDelegateChannel.shutdown();
    }
    if (ownsFallbackState) {
      fallbackState.shutdown();
    }
    return this;
  }

  @Override
  public ManagedChannel shutdownNow() {
    synchronized (this) {
      isShutdown = true;
      stateChangeCallbacks.clear();
    }
    if (primaryProbeFuture != null) {
      primaryProbeFuture.cancel(true);
    }
    if (fallbackProbeFuture != null) {
      fallbackProbeFuture.cancel(true);
    }
    if (!ownsFallbackState) {
      fallbackState.unregisterChannel(this);
    }
    if (primaryDelegateChannel != null) {
      primaryDelegateChannel.shutdownNow();
    }
    if (fallbackDelegateChannel != null) {
      fallbackDelegateChannel.shutdownNow();
    }
    if (ownsFallbackState) {
      fallbackState.shutdownNow();
    }
    return this;
  }

  @Override
  public boolean isShutdown() {
    if (primaryDelegateChannel != null && !primaryDelegateChannel.isShutdown()) {
      return false;
    }

    if (fallbackDelegateChannel != null && !fallbackDelegateChannel.isShutdown()) {
      return false;
    }

    if (ownsFallbackState && fallbackState.ownsExecutor() && execService != null) {
      return execService.isShutdown();
    }
    return true;
  }

  @Override
  public boolean isTerminated() {
    if (primaryDelegateChannel != null && !primaryDelegateChannel.isTerminated()) {
      return false;
    }

    if (fallbackDelegateChannel != null && !fallbackDelegateChannel.isTerminated()) {
      return false;
    }

    if (ownsFallbackState && fallbackState.ownsExecutor() && execService != null) {
      return execService.isTerminated();
    }
    return true;
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    long endTimeNanos = System.nanoTime() + unit.toNanos(timeout);
    if (primaryDelegateChannel != null) {
      boolean terminated = primaryDelegateChannel.awaitTermination(timeout, unit);
      if (!terminated) {
        return false;
      }
    }

    long awaitTimeNanos = endTimeNanos - System.nanoTime();
    if (fallbackDelegateChannel != null) {
      boolean terminated = fallbackDelegateChannel.awaitTermination(awaitTimeNanos, NANOSECONDS);
      if (!terminated) {
        return false;
      }
      awaitTimeNanos = endTimeNanos - System.nanoTime();
    }

    if (ownsFallbackState && fallbackState.ownsExecutor() && execService != null) {
      return execService.awaitTermination(awaitTimeNanos, NANOSECONDS);
    }
    return true;
  }
}
