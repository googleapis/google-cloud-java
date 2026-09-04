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
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
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

  private final AtomicBoolean localInFallbackMode = new AtomicBoolean(false);
  private final AtomicLong localProbeSuccesses = new AtomicLong(0);
  private final AtomicLong localFirstPrimaryProbeSuccessNanos = new AtomicLong(0);
  private final java.util.concurrent.locks.ReentrantLock stateLock =
      new java.util.concurrent.locks.ReentrantLock();

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
          execService != null
              ? new GcpFallbackState(execService)
              : new GcpFallbackState();
      this.ownsFallbackState = true;
    }
    this.execService = fallbackState.getOrCreateExecutorService(options);
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
          execService != null
              ? new GcpFallbackState(execService)
              : new GcpFallbackState();
      this.ownsFallbackState = true;
    }
    this.execService = fallbackState.getOrCreateExecutorService(options);
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

  private void syncFallbackModeState(boolean globalFallback) {
    if (globalFallback) {
      if (!localInFallbackMode.get()) {
        stateLock.lock();
        try {
          if (localInFallbackMode.compareAndSet(false, true)) {
            localProbeSuccesses.set(0);
            localFirstPrimaryProbeSuccessNanos.set(0);
          }
        } finally {
          stateLock.unlock();
        }
      }
    } else if (!options.isEnablePerChannelRecovery()) {
      if (localInFallbackMode.get()) {
        stateLock.lock();
        try {
          if (localInFallbackMode.compareAndSet(true, false)) {
            localProbeSuccesses.set(0);
            localFirstPrimaryProbeSuccessNanos.set(0);
          }
        } finally {
          stateLock.unlock();
        }
      }
    }
  }

  public boolean isInFallbackMode() {
    boolean globalFallback = fallbackState.getInFallbackMode().get();
    syncFallbackModeState(globalFallback);
    if (options.isEnablePerChannelRecovery()) {
      return (localInFallbackMode.get() && fallbackChannel != null) || primaryChannel == null;
    }
    return (globalFallback && fallbackChannel != null) || primaryChannel == null;
  }

  @VisibleForTesting
  GcpFallbackState getFallbackState() {
    return fallbackState;
  }

  @VisibleForTesting
  AtomicBoolean getLocalInFallbackMode() {
    return localInFallbackMode;
  }

  @VisibleForTesting
  AtomicLong getLocalProbeSuccesses() {
    return localProbeSuccesses;
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
  }

  private void checkErrorRates() {
    fallbackState.checkErrorRates(options, openTelemetry);
  }

  private void processPrimaryStatusCode(Status.Code statusCode) {
    if (options.getErroneousStates().contains(statusCode)) {
      fallbackState.getPrimaryFailures().incrementAndGet();
    } else {
      fallbackState.getPrimarySuccesses().incrementAndGet();
    }
    openTelemetry.getModule().reportStatus(options.getPrimaryChannelName(), statusCode);
  }

  private void processFallbackStatusCode(Status.Code statusCode) {
    if (options.getErroneousStates().contains(statusCode)) {
      fallbackState.getFallbackFailures().incrementAndGet();
    } else {
      fallbackState.getFallbackSuccesses().incrementAndGet();
    }
    openTelemetry.getModule().reportStatus(options.getFallbackChannelName(), statusCode);
  }

  private void probePrimary() {
    boolean globalFallback = fallbackState.getInFallbackMode().get();
    syncFallbackModeState(globalFallback);
    boolean inFallback =
        options.isEnablePerChannelRecovery()
            ? localInFallbackMode.get()
            : globalFallback;
    if (!inFallback && primaryChannel != null) {
      return;
    }
    String result = "";
    if (primaryDelegateChannel == null) {
      result = INIT_FAILURE_REASON;
    } else {
      result = options.getPrimaryProbingFunction().apply(primaryDelegateChannel);
    }
    if ("OK".equals(result)) {
      stateLock.lock();
      try {
        if (localInFallbackMode.get()) {
          long nowNanos = System.nanoTime();
          long firstSuccessNanos =
              localFirstPrimaryProbeSuccessNanos.updateAndGet(prev -> prev == 0 ? nowNanos : prev);
          long primaryProbeSuccessCount = localProbeSuccesses.incrementAndGet();

          boolean durationSatisfied = true;
          if (options.getMinPrimaryProbeSuccessDuration() != null
              && !options.getMinPrimaryProbeSuccessDuration().isZero()
              && !options.getMinPrimaryProbeSuccessDuration().isNegative()) {
            long elapsedNanos = nowNanos - firstSuccessNanos;
            durationSatisfied =
                elapsedNanos >= options.getMinPrimaryProbeSuccessDuration().toNanos();
          }

          if (options.isEnableRecovery()
              && primaryProbeSuccessCount >= options.getMinPrimaryProbeSuccessCount()
              && durationSatisfied) {
            fallbackState.getInFallbackMode().set(false);
            localInFallbackMode.set(false);
            localProbeSuccesses.set(0);
            localFirstPrimaryProbeSuccessNanos.set(0);
          }
        }
      } finally {
        stateLock.unlock();
      }
    } else {
      stateLock.lock();
      try {
        localInFallbackMode.set(true);
        localProbeSuccesses.set(0);
        localFirstPrimaryProbeSuccessNanos.set(0);
      } finally {
        stateLock.unlock();
      }
    }
    // Report metric based on result.
    openTelemetry.getModule().reportProbeResult(options.getPrimaryChannelName(), result);
  }

  private void probeFallback() {
    String result = "";
    if (fallbackDelegateChannel == null) {
      result = INIT_FAILURE_REASON;
    } else {
      result = options.getFallbackProbingFunction().apply(fallbackDelegateChannel);
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
  public io.grpc.ConnectivityState getState(boolean requestConnection) {
    if (isInFallbackMode()) {
      if (fallbackDelegateChannel != null) {
        return fallbackDelegateChannel.getState(requestConnection);
      }
      return io.grpc.ConnectivityState.SHUTDOWN;
    }

    if (primaryDelegateChannel != null) {
      return primaryDelegateChannel.getState(requestConnection);
    }
    return io.grpc.ConnectivityState.SHUTDOWN;
  }

  @Override
  public void notifyWhenStateChanged(io.grpc.ConnectivityState source, Runnable callback) {
    if (isInFallbackMode()) {
      if (fallbackDelegateChannel != null) {
        fallbackDelegateChannel.notifyWhenStateChanged(source, callback);
      }
    } else {
      if (primaryDelegateChannel != null) {
        primaryDelegateChannel.notifyWhenStateChanged(source, callback);
      }
    }
  }

  @Override
  public ManagedChannel shutdown() {
    if (primaryProbeFuture != null) {
      primaryProbeFuture.cancel(false);
    }
    if (fallbackProbeFuture != null) {
      fallbackProbeFuture.cancel(false);
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
    if (primaryProbeFuture != null) {
      primaryProbeFuture.cancel(true);
    }
    if (fallbackProbeFuture != null) {
      fallbackProbeFuture.cancel(true);
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

    return execService.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    if (primaryDelegateChannel != null && !primaryDelegateChannel.isTerminated()) {
      return false;
    }

    if (fallbackDelegateChannel != null && !fallbackDelegateChannel.isTerminated()) {
      return false;
    }

    return execService.isTerminated();
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

    return execService.awaitTermination(awaitTimeNanos, NANOSECONDS);
  }
}
