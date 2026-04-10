/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manages the lifecycle of location-aware routing endpoints including background probing, traffic
 * tracking, and idle eviction.
 *
 * <p>This manager is the only component that proactively creates routed replica endpoints. It:
 *
 * <ul>
 *   <li>Starts managing endpoints after they receive real routed traffic or are explicitly
 *       registered.
 *   <li>Periodically checks channel state and uses {@code getState(true)} to warm up IDLE channels
 *       without sending application RPCs.
 *   <li>Tracks real traffic per endpoint.
 *   <li>Evicts endpoints that have had no real traffic for the configured idle duration, or that
 *       are in TRANSIENT_FAILURE state.
 *   <li>Reprobes endpoints when they are needed again after eviction.
 * </ul>
 */
@InternalApi
class EndpointLifecycleManager {

  private static final Logger logger = Logger.getLogger(EndpointLifecycleManager.class.getName());

  /** Default probe interval: 60 seconds. Keeps channels from drifting into IDLE. */
  @VisibleForTesting static final long DEFAULT_PROBE_INTERVAL_SECONDS = 60;

  /** Default idle eviction threshold: 30 minutes without real traffic. */
  @VisibleForTesting static final Duration DEFAULT_IDLE_EVICTION_DURATION = Duration.ofMinutes(30);

  /** Interval for checking idle eviction: every 5 minutes. */
  private static final long EVICTION_CHECK_INTERVAL_SECONDS = 300;

  /**
   * Maximum consecutive TRANSIENT_FAILURE probes before evicting an endpoint. Gives the channel
   * time to recover from transient network issues before we tear it down and recreate.
   */
  private static final int MAX_TRANSIENT_FAILURE_COUNT = 3;

  private enum EvictionReason {
    TRANSIENT_FAILURE,
    SHUTDOWN,
    IDLE,
    STALE
  }

  /** Per-endpoint lifecycle state. */
  static final class EndpointState {
    final String address;
    volatile Instant lastProbeAt;
    volatile Instant lastRealTrafficAt;
    volatile Instant lastReadyAt;
    volatile int consecutiveTransientFailures;

    // Guarded by synchronizing on this EndpointState instance.
    ScheduledFuture<?> probeFuture;

    EndpointState(String address, Instant now) {
      this.address = address;
      this.lastRealTrafficAt = now;
      this.lastProbeAt = null;
      this.lastReadyAt = null;
      this.consecutiveTransientFailures = 0;
    }
  }

  private final ChannelEndpointCache endpointCache;
  private final Map<String, EndpointState> endpoints = new ConcurrentHashMap<>();
  private final Set<String> transientFailureEvictedAddresses = ConcurrentHashMap.newKeySet();

  private final ScheduledExecutorService scheduler;
  private final AtomicBoolean isShutdown = new AtomicBoolean(false);
  private final long probeIntervalSeconds;
  private final Duration idleEvictionDuration;
  private final Clock clock;
  private final String defaultEndpointAddress;

  private ScheduledFuture<?> evictionFuture;

  EndpointLifecycleManager(ChannelEndpointCache endpointCache) {
    this(
        endpointCache,
        DEFAULT_PROBE_INTERVAL_SECONDS,
        DEFAULT_IDLE_EVICTION_DURATION,
        Clock.systemUTC());
  }

  @VisibleForTesting
  EndpointLifecycleManager(
      ChannelEndpointCache endpointCache,
      long probeIntervalSeconds,
      Duration idleEvictionDuration,
      Clock clock) {
    this.endpointCache = endpointCache;
    this.probeIntervalSeconds = probeIntervalSeconds;
    this.idleEvictionDuration = idleEvictionDuration;
    this.clock = clock;
    this.defaultEndpointAddress = endpointCache.defaultChannel().getAddress();
    this.scheduler =
        java.util.concurrent.Executors.newScheduledThreadPool(
            2,
            r -> {
              Thread t = new Thread(r, "spanner-endpoint-lifecycle");
              t.setDaemon(true);
              return t;
            });

    // Start periodic eviction checks.
    this.evictionFuture =
        scheduler.scheduleAtFixedRate(
            this::checkIdleEviction,
            EVICTION_CHECK_INTERVAL_SECONDS,
            EVICTION_CHECK_INTERVAL_SECONDS,
            TimeUnit.SECONDS);
  }

  private void markTransientFailureEvicted(String address) {
    transientFailureEvictedAddresses.add(address);
  }

  private void clearTransientFailureEvictionMarker(String address) {
    transientFailureEvictedAddresses.remove(address);
  }

  private void submitLifecycleTask(String description, Runnable task) {
    try {
      scheduler.submit(task);
    } catch (RejectedExecutionException e) {
      logger.log(
          Level.FINE,
          String.format(
              "Skipping lifecycle task '%s': lifecycle manager is shutting down", description),
          e);
    }
  }

  /**
   * Records that real (non-probe) traffic was routed to an endpoint. This refreshes the idle
   * eviction timer for this endpoint.
   */
  void recordRealTraffic(String address) {
    if (isShutdown.get() || address == null || defaultEndpointAddress.equals(address)) {
      return;
    }
    Instant now = clock.instant();
    boolean[] created = {false};
    EndpointState state =
        endpoints.computeIfAbsent(
            address,
            addr -> {
              created[0] = true;
              logger.log(
                  Level.FINE, "Registering routed endpoint for lifecycle management: {0}", addr);
              return new EndpointState(addr, now);
            });
    state.lastRealTrafficAt = now;
    if (created[0]) {
      submitLifecycleTask("startProbing", () -> startProbing(address));
    }
  }

  /** Creates an endpoint and starts probing. Runs on the scheduler thread. */
  private void createAndStartProbing(String address) {
    if (isShutdown.get() || !endpoints.containsKey(address)) {
      return;
    }
    try {
      endpointCache.get(address);
      logger.log(Level.FINE, "Background endpoint creation completed for: {0}", address);

      // If the endpoint was evicted between the containsKey check above and channel creation,
      // the channel would leak in the endpoint cache without lifecycle tracking. Clean it up.
      if (!endpoints.containsKey(address)) {
        logger.log(
            Level.FINE,
            "Endpoint {0} was evicted during channel creation, cleaning up leaked channel",
            address);
        endpointCache.evict(address);
        return;
      }

      startProbing(address);
    } catch (Exception e) {
      logger.log(
          Level.FINE, "Failed to create endpoint for address: " + address + ", will retry", e);
      // Schedule a retry after one probe interval, but only if still managed.
      if (!isShutdown.get() && endpoints.containsKey(address)) {
        scheduler.schedule(
            () -> createAndStartProbing(address), probeIntervalSeconds, TimeUnit.SECONDS);
      }
    }
  }

  /** Starts periodic probing for an endpoint. */
  private void startProbing(String address) {
    EndpointState state = endpoints.get(address);
    if (state == null || isShutdown.get()) {
      return;
    }

    synchronized (state) {
      // Re-check after acquiring lock — state may have been evicted concurrently.
      if (!endpoints.containsKey(address)) {
        return;
      }

      // Cancel any existing probe schedule.
      if (state.probeFuture != null) {
        state.probeFuture.cancel(false);
      }

      state.probeFuture =
          scheduler.scheduleAtFixedRate(
              () -> probe(address), 0, probeIntervalSeconds, TimeUnit.SECONDS);
    }
    logger.log(
        Level.FINE,
        "Prober started for endpoint {0} with interval {1}s",
        new Object[] {address, probeIntervalSeconds});
  }

  /** Stops probing for an endpoint. */
  private void stopProbing(String address) {
    EndpointState state = endpoints.get(address);
    if (state == null) {
      return;
    }
    synchronized (state) {
      if (state.probeFuture != null) {
        state.probeFuture.cancel(false);
        state.probeFuture = null;
        logger.log(Level.FINE, "Prober stopped for endpoint: {0}", address);
      }
    }
  }

  /**
   * Probes the endpoint by checking channel connectivity state and warming up IDLE channels.
   *
   * <p>Uses {@code getState(true)} to request a connection attempt on IDLE channels instead of
   * sending a GetSession RPC. This is lighter weight and avoids routing application-level RPCs
   * through the endpoint's channel pool.
   *
   * <p>If the channel is in TRANSIENT_FAILURE, increments a consecutive failure counter. After
   * {@link #MAX_TRANSIENT_FAILURE_COUNT} consecutive failures, the endpoint is evicted and shut
   * down so it can be recreated fresh when needed again.
   *
   * <p>All exceptions are caught to prevent {@link ScheduledExecutorService} from cancelling future
   * runs of this task.
   */
  private void probe(String address) {
    try {
      if (isShutdown.get()) {
        return;
      }

      ChannelEndpoint endpoint = endpointCache.getIfPresent(address);
      if (endpoint == null) {
        logger.log(Level.FINE, "Probe skipped for {0}: endpoint not in cache", address);
        return;
      }

      EndpointState state = endpoints.get(address);
      if (state == null) {
        return;
      }

      ManagedChannel channel = endpoint.getChannel();
      state.lastProbeAt = clock.instant();

      // getState(false) reads current state without triggering a connection.
      ConnectivityState channelState = channel.getState(false);
      logger.log(
          Level.FINE, "Probe for {0}: channel state is {1}", new Object[] {address, channelState});

      switch (channelState) {
        case READY:
          state.lastReadyAt = clock.instant();
          state.consecutiveTransientFailures = 0;
          clearTransientFailureEvictionMarker(address);
          break;

        case IDLE:
          // Warm up the channel by requesting a connection attempt.
          logger.log(
              Level.FINE, "Probe for {0}: channel IDLE, requesting connection (warmup)", address);
          channel.getState(true);
          state.consecutiveTransientFailures = 0;
          break;

        case CONNECTING:
          state.consecutiveTransientFailures = 0;
          break;

        case TRANSIENT_FAILURE:
          state.consecutiveTransientFailures++;
          logger.log(
              Level.FINE,
              "Probe for {0}: channel in TRANSIENT_FAILURE ({1}/{2})",
              new Object[] {
                address, state.consecutiveTransientFailures, MAX_TRANSIENT_FAILURE_COUNT
              });
          if (state.consecutiveTransientFailures >= MAX_TRANSIENT_FAILURE_COUNT) {
            logger.log(
                Level.FINE,
                "Evicting endpoint {0}: {1} consecutive TRANSIENT_FAILURE probes",
                new Object[] {address, state.consecutiveTransientFailures});
            evictEndpoint(address, EvictionReason.TRANSIENT_FAILURE);
          }
          break;

        case SHUTDOWN:
          logger.log(Level.FINE, "Probe for {0}: channel SHUTDOWN, evicting endpoint", address);
          evictEndpoint(address, EvictionReason.SHUTDOWN);
          break;

        default:
          break;
      }
    } catch (Exception e) {
      logger.log(Level.FINE, "Probe failed for endpoint " + address, e);
    }
  }

  /** Checks all managed endpoints for idle eviction. */
  @VisibleForTesting
  void checkIdleEviction() {
    if (isShutdown.get()) {
      return;
    }

    Instant now = clock.instant();
    List<String> toEvict = new ArrayList<>();

    for (Map.Entry<String, EndpointState> entry : endpoints.entrySet()) {
      String address = entry.getKey();
      EndpointState state = entry.getValue();

      // Never evict the default endpoint.
      if (defaultEndpointAddress.equals(address)) {
        continue;
      }

      Duration sinceLastRealTraffic = Duration.between(state.lastRealTrafficAt, now);
      if (sinceLastRealTraffic.compareTo(idleEvictionDuration) > 0) {
        toEvict.add(address);
      }
    }

    for (String address : toEvict) {
      evictEndpoint(address, EvictionReason.IDLE);
    }
  }

  /** Evicts an endpoint: stops probing, removes from tracking, shuts down the channel. */
  private void evictEndpoint(String address) {
    evictEndpoint(address, EvictionReason.STALE);
  }

  /** Evicts an endpoint and records whether it should still be reported as unhealthy. */
  private void evictEndpoint(String address, EvictionReason reason) {
    logger.log(Level.FINE, "Evicting endpoint {0}", address);

    stopProbing(address);
    endpoints.remove(address);
    if (reason == EvictionReason.TRANSIENT_FAILURE) {
      markTransientFailureEvicted(address);
    } else {
      clearTransientFailureEvictionMarker(address);
    }
    endpointCache.evict(address);
  }

  /**
   * Requests that an endpoint be registered for background probing. This is used when a routed
   * request needs an endpoint that is absent or not yet READY. The current request still falls back
   * to the default channel; probing prepares the endpoint for a later request.
   */
  void requestEndpointRecreation(String address) {
    if (isShutdown.get() || address == null || address.isEmpty()) {
      return;
    }
    if (defaultEndpointAddress.equals(address)) {
      return;
    }

    // Only recreate if not already managed.
    if (endpoints.containsKey(address)) {
      return;
    }

    logger.log(Level.FINE, "Recreating previously evicted endpoint for address: {0}", address);
    EndpointState state = new EndpointState(address, clock.instant());
    if (endpoints.putIfAbsent(address, state) == null) {
      // Schedule after putIfAbsent returns so the entry is visible to the scheduler thread.
      submitLifecycleTask("createAndStartProbing", () -> createAndStartProbing(address));
    }
  }

  /** Returns whether an endpoint is being actively managed. */
  boolean isManaged(String address) {
    return endpoints.containsKey(address);
  }

  boolean wasRecentlyEvictedTransientFailure(String address) {
    return transientFailureEvictedAddresses.contains(address);
  }

  /** Returns the endpoint state for testing. */
  @VisibleForTesting
  EndpointState getEndpointState(String address) {
    return endpoints.get(address);
  }

  /** Returns the number of managed endpoints. */
  @VisibleForTesting
  int managedEndpointCount() {
    return endpoints.size();
  }

  /** Shuts down the lifecycle manager and all probing. */
  void shutdown() {
    if (!isShutdown.compareAndSet(false, true)) {
      return;
    }

    logger.log(Level.FINE, "Shutting down endpoint lifecycle manager");

    if (evictionFuture != null) {
      evictionFuture.cancel(false);
    }

    for (EndpointState state : endpoints.values()) {
      synchronized (state) {
        if (state.probeFuture != null) {
          state.probeFuture.cancel(false);
        }
      }
    }
    endpoints.clear();
    transientFailureEvictedAddresses.clear();

    scheduler.shutdown();
    try {
      if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
        scheduler.shutdownNow();
      }
    } catch (InterruptedException e) {
      scheduler.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
}
