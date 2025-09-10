/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.gaxx.grpc;

import com.google.api.core.ApiFuture;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.cloud.bigtable.data.v2.stub.BigtableChannelPrimer;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPool.Entry;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/** Class that manages the health checking in the BigtableChannelPool */
class ChannelPoolHealthChecker {

  private static final Logger logger = Logger.getLogger(ChannelPoolHealthChecker.class.getName());

  // Configuration constants
  // Window_Duration is the duration over which we keep probe results
  private static final Duration WINDOW_DURATION = Duration.ofMinutes(5);
  // Interval at which we probe channel health
  private static final Duration PROBE_INTERVAL = Duration.ofSeconds(30);
  // Timeout deadline for a probe
  @VisibleForTesting static final Duration PROBE_DEADLINE = Duration.ofMillis(500);
  // Minimum interval between new idle channel evictions
  private static final Duration MIN_EVICTION_INTERVAL = Duration.ofMinutes(10);
  // Minimum number of probes that must be sent to a channel before it will be considered for
  // eviction
  private static final int MIN_PROBES_FOR_EVALUATION = 4;
  // Percentage of probes that must fail for a channel to be considered unhealthy
  private static final int SINGLE_CHANNEL_FAILURE_PERCENT_THRESHOLD = 60;
  // "Circuitbreaker" - If this or a higher percentage of channels in a pool are bad, we will not
  // evict any channels
  private static final int POOLWIDE_BAD_CHANNEL_CIRCUITBREAKER_PERCENT = 70;

  /** Inner class to represent the result of a single probe. */
  @AutoValue
  abstract static class ProbeResult {
    abstract Instant startTime();

    abstract boolean isSuccessful();

    static ProbeResult create(Instant startTime, boolean success) {
      return new AutoValue_ChannelPoolHealthChecker_ProbeResult(startTime, success);
    }
  }

  private final Supplier<ImmutableList<Entry>> entrySupplier;
  private volatile Instant lastEviction;
  private final ScheduledExecutorService executor;

  private final ChannelPrimer channelPrimer;

  private ScheduledFuture<?> probeTaskScheduledFuture;
  private ScheduledFuture<?> detectAndRemoveTaskScheduledFuture;

  private final Clock clock;

  /** Constructor for the pool health checker. */
  public ChannelPoolHealthChecker(
      Supplier<ImmutableList<Entry>> entrySupplier,
      ChannelPrimer channelPrimer,
      ScheduledExecutorService executor,
      Clock clock) {
    this.entrySupplier = entrySupplier;
    this.lastEviction = Instant.MIN;
    this.channelPrimer = channelPrimer;
    this.executor = executor;
    this.clock = clock;
  }

  void start() {
    if (!(channelPrimer instanceof BigtableChannelPrimer)) {
      logger.log(
          Level.WARNING,
          "Provided channelPrimer not an instance of BigtableChannelPrimer, not checking channel health.");
      return;
    }

    Duration initialDelayProbe =
        Duration.ofMillis(ThreadLocalRandom.current().nextLong(PROBE_INTERVAL.toMillis()));
    this.probeTaskScheduledFuture =
        executor.scheduleAtFixedRate(
            this::runProbes,
            initialDelayProbe.toMillis(),
            PROBE_INTERVAL.toMillis(),
            TimeUnit.MILLISECONDS);
    Duration initialDelayDetect =
        Duration.ofMillis(ThreadLocalRandom.current().nextLong(PROBE_INTERVAL.toMillis()));
    this.detectAndRemoveTaskScheduledFuture =
        executor.scheduleAtFixedRate(
            this::detectAndRemoveOutlierEntries,
            initialDelayDetect.toMillis(),
            PROBE_INTERVAL.toMillis(),
            TimeUnit.MILLISECONDS);
  }

  /** Stop running health checking */
  public void stop() {
    if (probeTaskScheduledFuture != null) {
      probeTaskScheduledFuture.cancel(false);
    }
    if (detectAndRemoveTaskScheduledFuture != null) {
      detectAndRemoveTaskScheduledFuture.cancel(false);
    }
  }

  /** Runs probes on all the channels in the pool. */
  @VisibleForTesting
  void runProbes() {
    Preconditions.checkState(
        channelPrimer instanceof BigtableChannelPrimer,
        "Health checking can only be enabled with BigtableChannelPrimer, found %s",
        channelPrimer);
    BigtableChannelPrimer primer = (BigtableChannelPrimer) channelPrimer;

    for (Entry entry : this.entrySupplier.get()) {
      ApiFuture<PingAndWarmResponse> probeFuture =
          primer.sendPrimeRequestsAsync(entry.getManagedChannel());
      probeFuture.addListener(
          () -> onComplete(entry, clock.instant(), probeFuture), MoreExecutors.directExecutor());
    }
  }

  /** Callback that will update Entry data on probe complete. */
  @VisibleForTesting
  void onComplete(Entry entry, Instant startTime, ApiFuture<PingAndWarmResponse> probeFuture) {
    boolean success;
    try {
      probeFuture.get(PROBE_DEADLINE.toMillis(), TimeUnit.MILLISECONDS);
      success = true;
    } catch (Exception e) {
      success = false;
      logger.log(Level.WARNING, "Probe failed", e);
    }
    addProbeResult(entry, ProbeResult.create(startTime, success));
  }

  @VisibleForTesting
  void addProbeResult(Entry entry, ProbeResult result) {
    entry.probeHistory.add(result);
    if (result.isSuccessful()) {
      entry.successfulProbesInWindow.incrementAndGet();
    } else {
      entry.failedProbesInWindow.incrementAndGet();
    }
    pruneHistory(entry);
  }

  @VisibleForTesting
  void pruneHistory(Entry entry) {
    Instant windowStart = clock.instant().minus(WINDOW_DURATION);
    while (!entry.probeHistory.isEmpty()
        && entry.probeHistory.peek().startTime().isBefore(windowStart)) {
      ProbeResult removedResult = entry.probeHistory.poll();
      if (removedResult.isSuccessful()) {
        entry.successfulProbesInWindow.decrementAndGet();
      } else {
        entry.failedProbesInWindow.decrementAndGet();
      }
    }
  }

  /** Checks if a single entry is currently healthy based on its probe history. */
  @VisibleForTesting
  boolean isEntryHealthy(Entry entry) {
    int failedProbes = entry.failedProbesInWindow.get();
    int totalProbes = failedProbes + entry.successfulProbesInWindow.get();

    if (totalProbes < MIN_PROBES_FOR_EVALUATION) {
      return true; // Not enough data, assume healthy.
    }

    double failureRate = ((double) failedProbes / totalProbes) * 100.0;
    return failureRate < SINGLE_CHANNEL_FAILURE_PERCENT_THRESHOLD;
  }

  /**
   * Finds a channel that is an outlier in terms of health.
   *
   * @return the entry to be evicted. Returns null if nothing to evict.
   */
  @Nullable
  @VisibleForTesting
  Entry findOutlierEntry() {
    List<Entry> unhealthyEntries =
        this.entrySupplier.get().stream()
            .filter(entry -> !isEntryHealthy(entry))
            .collect(Collectors.toList());

    int poolSize = this.entrySupplier.get().size();
    if (unhealthyEntries.isEmpty() || poolSize == 0) {
      return null;
    }

    // If more than CIRCUITBREAKER_PERCENT of channels are unhealthy we won't evict
    double unhealthyPercent = (double) unhealthyEntries.size() / poolSize * 100.0;
    if (unhealthyPercent >= POOLWIDE_BAD_CHANNEL_CIRCUITBREAKER_PERCENT) {
      return null;
    }

    return unhealthyEntries.stream()
        .max(Comparator.comparingInt(entry -> entry.failedProbesInWindow.get()))
        .orElse(null);
  }

  /** Periodically detects and removes outlier channels from the pool. */
  @VisibleForTesting
  void detectAndRemoveOutlierEntries() {
    if (clock.instant().isBefore(lastEviction.plus(MIN_EVICTION_INTERVAL))) {
      // Primitive but effective rate-limiting.
      return;
    }
    Entry outlier = findOutlierEntry();
    if (outlier != null) {
      this.lastEviction = clock.instant();
      outlier.failedProbesInWindow.set(0);
      outlier.successfulProbesInWindow.set(0);
      outlier.probeHistory.clear();
      outlier.getManagedChannel().enterIdle();
    }
  }
}
