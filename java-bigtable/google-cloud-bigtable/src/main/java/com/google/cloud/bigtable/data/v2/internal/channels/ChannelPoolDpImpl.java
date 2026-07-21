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

package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionClientConfiguration.ChannelPoolConfiguration;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ticker;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * Dynamically-sized channel pool that spreads sessions across AFEs and supports multi-tenant
 * factory usage.
 *
 * <p>Accounting is anchored on sessions rather than channels:
 *
 * <ul>
 *   <li>{@code sessionsPerAfeId} tracks how many active sessions each AFE holds globally.
 *   <li>{@code routeObservations} maps {@code (channelId, tenantKey) → lastObservedAfeId},
 *       populated on every {@code onBeforeSessionStart}. Used to place new sessions on the channel
 *       most likely to route to the desired AFE for a given tenant.
 * </ul>
 *
 * <p>Channels have a two-state lifecycle: ACTIVE (eligible for new sessions) and DRAINING (no new
 * sessions; shut down when numOutstanding reaches 0).
 *
 * <p>Placement logic for each new stream:
 *
 * <ol>
 *   <li>Capacity mode: find the AFE with the smallest session count below {@code softMaxPerGroup}.
 *       <ul>
 *         <li>3a. Preferred: pick the ACTIVE channel whose last observed route for this tenant was
 *             that AFE, choosing the least-loaded.
 *         <li>3b. Unobserved-tenant fallback: pick any ACTIVE channel with capacity (least-loaded).
 *             RLS may route to the target AFE or somewhere else; {@code routeObservations} will
 *             be updated on {@code onBeforeSessionStart} for future placements.
 *       </ul>
 *   <li>Diversity mode (all known AFEs at cap, or none known): prefer an ACTIVE channel with fewer
 *       than {@code softMaxPerGroup / 2} streams; otherwise add a new channel and absorb whatever
 *       AFE it lands on.
 * </ol>
 */
public class ChannelPoolDpImpl implements ChannelPool {
  private static final Logger LOGGER = Logger.getLogger(ChannelPoolDpImpl.class.getName());
  private static final String DEFAULT_LOG_NAME = "pool";
  private static final AtomicInteger INDEX = new AtomicInteger();

  // TODO: Move to client configuration.
  private static final int CONSECUTIVE_OPEN_SESSION_FAILURE_THRESHOLD = 5;
  private static final Duration INITIAL_RECYCLE_BACKOFF = Duration.ofMillis(1);
  private static final Duration MAX_RECYCLE_BACKOFF = Duration.ofMinutes(1);
  // Preserves the existing desiredGroups = ceil(totalStreams / softMaxPerGroup * 2) factor, which
  // keeps extra channels around at low load for AFE diversity.
  private static final double HEADROOM = 2.0;

  private final String poolLogId;

  @VisibleForTesting volatile int minGroups;
  @VisibleForTesting volatile int maxGroups;
  @VisibleForTesting volatile int softMaxPerGroup;

  private final Clock clock;
  private final Supplier<ManagedChannel> channelSupplier;
  private final ScheduledExecutorService executor;

  private final DebugTagTracer debugTagTracer;

  /** Flat list of all channels (ACTIVE + DRAINING). */
  @GuardedBy("this")
  private final List<ChannelWrapper> channels = new ArrayList<>();

  /**
   * Per-(channel, tenant) observation of the last AFE seen on {@code onBeforeSessionStart}.
   * Self-healing: updated on every session open, so stale entries from ~1hr AFE drift are
   * corrected automatically.
   */
  @GuardedBy("this")
  private final Map<RouteKey, AfeId> routeObservations = new HashMap<>();

  private final AtomicLong nextChannelId = new AtomicLong();

  @GuardedBy("this")
  private int totalStreams = 0;

  @GuardedBy("this")
  private final Multiset<AfeId> sessionsPerAfeId = HashMultiset.create();

  private ScheduledFuture<?> serviceFuture = null;

  @GuardedBy("this")
  private boolean closed = false;

  private final Ticker ticker;

  @GuardedBy("this")
  private long lastRecycleNano = 0;

  @GuardedBy("this")
  private Duration recycleBackoff = INITIAL_RECYCLE_BACKOFF;

  public ChannelPoolDpImpl(
      Supplier<ManagedChannel> channelSupplier,
      ChannelPoolConfiguration config,
      DebugTagTracer debugTagTracer,
      ScheduledExecutorService executor) {
    this(
        channelSupplier,
        config,
        DEFAULT_LOG_NAME,
        debugTagTracer,
        executor,
        Clock.systemUTC(),
        Ticker.systemTicker());
  }

  public ChannelPoolDpImpl(
      Supplier<ManagedChannel> channelSupplier,
      ChannelPoolConfiguration config,
      String logName,
      DebugTagTracer debugTagTracer,
      ScheduledExecutorService executor) {
    this(
        channelSupplier,
        config,
        logName,
        debugTagTracer,
        executor,
        Clock.systemUTC(),
        Ticker.systemTicker());
  }

  public ChannelPoolDpImpl(
      Supplier<ManagedChannel> channelSupplier,
      ChannelPoolConfiguration config,
      String logName,
      DebugTagTracer debugTagTracer,
      ScheduledExecutorService executor,
      Clock clock) {
    this(channelSupplier, config, logName, debugTagTracer, executor, clock, Ticker.systemTicker());
  }

  public ChannelPoolDpImpl(
      Supplier<ManagedChannel> channelSupplier,
      ChannelPoolConfiguration config,
      String logName,
      DebugTagTracer debugTagTracer,
      ScheduledExecutorService executor,
      Clock clock,
      Ticker ticker) {
    this.poolLogId = String.format("%d-%s", INDEX.getAndIncrement(), logName);
    this.clock = clock;
    this.ticker = ticker;
    this.channelSupplier = channelSupplier;
    this.executor = executor;
    updateConfig(config);
    this.debugTagTracer = debugTagTracer;
  }

  @Override
  public void updateConfig(ChannelPoolConfiguration config) {
    this.minGroups = config.getMinServerCount();
    this.maxGroups = config.getMaxServerCount();
    this.softMaxPerGroup = config.getPerServerSessionCount();
  }

  @Override
  public synchronized void start() {
    serviceChannels();
    serviceFuture = executor.scheduleAtFixedRate(this::serviceChannels, 1, 1, TimeUnit.MINUTES);
  }

  @Override
  public synchronized void close() {
    closed = true;

    if (serviceFuture != null) {
      serviceFuture.cancel(false);
    }

    channels.forEach(cw -> cw.channel.shutdown());
  }

  @Override
  public synchronized SessionStream newStream(
      MethodDescriptor<SessionRequest, SessionResponse> desc, CallOptions callOptions) {
    if (closed) {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "channel_pool_new_stream_failed");
      return new FailingSessionStream(Status.UNAVAILABLE.withDescription("ChannelPool is closed"));
    }

    TenantKey tenant = callOptions.getOption(ChannelPoolOptions.TENANT_KEY_OPTION);

    // --- Capacity mode: find the least-loaded AFE that still has room ---
    AfeId targetAfe =
        sessionsPerAfeId.entrySet().stream()
            .filter(e -> e.getCount() < softMaxPerGroup)
            .min(Comparator.comparingInt(Multiset.Entry::getCount))
            .map(Multiset.Entry::getElement)
            .orElse(null);

    ChannelWrapper channelWrapper = null;

    if (targetAfe != null) {
      // 3a: prefer the ACTIVE channel that already routes this tenant to targetAfe.
      // For-loop avoids accessing the guarded routeObservations field inside a lambda.
      for (ChannelWrapper c : channels) {
        if (c.state == ChannelWrapper.State.ACTIVE
            && targetAfe.equals(routeObservations.get(new RouteKey(c.id, tenant)))) {
          if (channelWrapper == null || c.numOutstanding < channelWrapper.numOutstanding) {
            channelWrapper = c;
          }
        }
      }

      // 3b: no observed route for this tenant → any ACTIVE channel with capacity (least-loaded).
      if (channelWrapper == null) {
        channelWrapper =
            channels.stream()
                .filter(c -> c.state == ChannelWrapper.State.ACTIVE)
                .filter(c -> c.numOutstanding < softMaxPerGroup)
                .min(Comparator.comparingInt(c -> c.numOutstanding))
                .orElse(null);
      }
    }

    // --- Diversity mode: all AFEs at cap, or pool is empty ---
    if (channelWrapper == null) {
      // Reuse an ACTIVE channel that has plenty of headroom before spawning a new one.
      channelWrapper =
          channels.stream()
              .filter(c -> c.state == ChannelWrapper.State.ACTIVE)
              .filter(c -> c.numOutstanding < softMaxPerGroup / 2)
              .min(Comparator.comparingInt(c -> c.numOutstanding))
              .orElse(null);

      if (channelWrapper == null) {
        log(
            Level.FINE,
            "Couldn't find an existing channel with capacity, num outstanding streams: %d,"
                + " num channels: %d",
            totalStreams,
            channels.size());
        channelWrapper = addChannel();
      }
    }

    final ChannelWrapper fw = channelWrapper;
    fw.numOutstanding++;
    totalStreams++;

    ClientCall<SessionRequest, SessionResponse> innerCall =
        fw.channel.newCall(desc, callOptions);

    return new SessionStreamImpl(innerCall) {
      // null until onBeforeSessionStart fires
      @Nullable AfeId afeId = null;

      @Override
      public void start(Listener responseListener, Metadata headers) {
        super.start(
            new ForwardingListener(responseListener) {
              @Override
              public void onBeforeSessionStart(PeerInfo peerInfo) {
                afeId = AfeId.extract(peerInfo);
                synchronized (ChannelPoolDpImpl.this) {
                  fw.consecutiveFailures = 0;
                  recycleBackoff = INITIAL_RECYCLE_BACKOFF;
                  sessionsPerAfeId.add(afeId);
                  if (!fw.channel.isShutdown()) {
                    routeObservations.put(new RouteKey(fw.id, tenant), afeId);
                  }
                  fw.lastUsedAt = Instant.now(clock);
                }
                super.onBeforeSessionStart(peerInfo);
              }

              @Override
              public void onClose(Status status, Metadata trailers) {
                synchronized (ChannelPoolDpImpl.this) {
                  if (afeId != null) {
                    sessionsPerAfeId.remove(afeId);
                  } else if (!status.isOk() && status.getCode() != Code.CANCELLED) {
                    fw.consecutiveFailures++;
                  }
                  releaseChannel(fw, status);
                }
                super.onClose(status, trailers);
              }
            },
            headers);
      }
    };
  }

  @GuardedBy("this")
  private ChannelWrapper addChannel() {
    debugTagTracer.checkPrecondition(
        !closed, "channel_pool_add_channel_failure", "Channel pool is closed");
    log(Level.FINE, "Adding a new channel");
    ChannelWrapper wrapped =
        new ChannelWrapper(nextChannelId.getAndIncrement(), channelSupplier.get(), clock);
    channels.add(wrapped);
    return wrapped;
  }

  /** Removes a channel from the pool and purges its route observations. */
  @GuardedBy("this")
  private void removeChannel(ChannelWrapper cw) {
    channels.remove(cw);
    final long id = cw.id;
    routeObservations.keySet().removeIf(k -> k.channelId == id);
    cw.channel.shutdown();
  }

  @GuardedBy("this")
  private void releaseChannel(ChannelWrapper channelWrapper, Status status) {
    totalStreams--;
    channelWrapper.numOutstanding--;
    channelWrapper.lastUsedAt = Instant.now(clock);

    // Draining channels: don't recycle (that would spawn a replacement, undoing the drain).
    // Just remove when they go quiet.
    if (channelWrapper.state == ChannelWrapper.State.DRAINING) {
      if (channelWrapper.numOutstanding == 0) {
        removeChannel(channelWrapper);
      }
      return;
    }

    if (shouldRecycleChannel(channelWrapper, status)) {
      recycleChannel(channelWrapper);
    }
  }

  private static boolean shouldRecycleChannel(ChannelWrapper channelWrapper, Status status) {
    if (status.getCode() == Code.UNIMPLEMENTED) {
      return true;
    }

    // TODO: replace this with a flag in the ErrorDetails
    if (status.getDescription() != null
        && status.getDescription().toLowerCase(Locale.ENGLISH).contains("server is draining")) {
      return true;
    }

    if (channelWrapper.consecutiveFailures >= CONSECUTIVE_OPEN_SESSION_FAILURE_THRESHOLD) {
      return true;
    }

    return false;
  }

  @GuardedBy("this")
  private void recycleChannel(ChannelWrapper channelWrapper) {
    if (channelWrapper.channel.isShutdown()) {
      // Channel is already recycled.
      return;
    }

    long nowNano = ticker.read();
    if (nowNano - lastRecycleNano < recycleBackoff.toNanos()) {
      return;
    }

    lastRecycleNano = nowNano;
    recycleBackoff = recycleBackoff.multipliedBy(2);
    if (recycleBackoff.compareTo(MAX_RECYCLE_BACKOFF) > 0) {
      recycleBackoff = MAX_RECYCLE_BACKOFF;
    }

    removeChannel(channelWrapper);
    addChannel();
  }

  @VisibleForTesting
  void serviceChannels() {
    try {
      serviceChannelsSafe();
    } catch (Exception e) {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "service_channel_failure");
      log(Level.WARNING, "Failed to service channels", e);
    }
  }

  private synchronized void serviceChannelsSafe() {
    log(Level.FINE, "Servicing channels");
    dumpState();

    int target = (int) Math.ceil((totalStreams * HEADROOM) / softMaxPerGroup);
    if (target > maxGroups) {
      target = maxGroups;
    } else if (target < minGroups) {
      target = minGroups;
    }

    int activeCount = (int) channels.stream().filter(c -> c.state == ChannelWrapper.State.ACTIVE).count();

    if (activeCount > target) {
      List<ChannelWrapper> candidates = pickDrainCandidates(activeCount - target);
      for (ChannelWrapper cw : candidates) {
        log(Level.FINE, "Draining channel (outstanding: %d)", cw.numOutstanding);
        cw.state = ChannelWrapper.State.DRAINING;
        if (cw.numOutstanding == 0) {
          removeChannel(cw);
        }
      }
    } else if (activeCount < target) {
      log(Level.FINE, "Adding %d channels to reach target %d", target - activeCount, target);
      for (int i = activeCount; i < target; i++) {
        addChannel();
      }
    }

    log(Level.FINE, "Done servicing channels");
    dumpState();
  }

  /**
   * Picks channels to drain, preferring idle channels (numOutstanding == 0) then by least-recently
   * used, then by oldest createdAt.
   */
  @GuardedBy("this")
  private List<ChannelWrapper> pickDrainCandidates(int count) {
    return channels.stream()
        .filter(c -> c.state == ChannelWrapper.State.ACTIVE)
        .sorted(
            Comparator.comparingInt((ChannelWrapper c) -> c.numOutstanding)
                .thenComparing(
                    c -> c.lastUsedAt == null ? Instant.MIN : c.lastUsedAt,
                    Comparator.naturalOrder())
                .thenComparing(c -> c.createdAt))
        .limit(count)
        .collect(Collectors.toList());
  }

  private void log(Level level, String msg, Throwable throwable) {
    LOGGER.log(level, String.format("[%s] %s", poolLogId, msg), throwable);
  }

  private void log(Level level, String format, Object... args) {
    LOGGER.log(level, String.format("[%s] %s", poolLogId, String.format(format, args)));
  }

  @GuardedBy("this")
  void dumpState() {
    if (!LOGGER.isLoggable(Level.FINE)) {
      return;
    }

    long activeCount = channels.stream().filter(c -> c.state == ChannelWrapper.State.ACTIVE).count();
    long drainingCount = channels.stream().filter(c -> c.state == ChannelWrapper.State.DRAINING).count();
    String s =
        sessionsPerAfeId.entrySet().stream()
            .sorted(Comparator.comparing(e -> e.getElement().toString()))
            .map(e -> String.format("%d", e.getCount()))
            .collect(Collectors.joining(", "));

    log(
        Level.FINE,
        "ChannelPool active: "
            + activeCount
            + ", draining: "
            + drainingCount
            + ", totalStreams: "
            + totalStreams
            + ", AFEs: "
            + sessionsPerAfeId.entrySet().size()
            + ", distribution: ["
            + s
            + "]");

    if (LOGGER.isLoggable(Level.FINEST)) {
      String afeToSessions =
          sessionsPerAfeId.entrySet().stream()
              .sorted(Comparator.comparing(e -> e.getElement().toString()))
              .map(e -> String.format("%s: %d", e.getElement(), e.getCount()))
              .collect(Collectors.joining("\n"));
      log(Level.FINEST, "ChannelPool session distribution:\n%s", afeToSessions);
    }
  }

  /**
   * Key for the route-observation map: the combination of a channel id and a tenant uniquely
   * determines the last observed AFE (RLS is stable per channel + tenant).
   */
  static final class RouteKey {
    final long channelId;
    final TenantKey tenantKey;

    RouteKey(long channelId, TenantKey tenantKey) {
      this.channelId = channelId;
      this.tenantKey = tenantKey;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof RouteKey)) return false;
      RouteKey other = (RouteKey) o;
      return channelId == other.channelId && Objects.equals(tenantKey, other.tenantKey);
    }

    @Override
    public int hashCode() {
      return Objects.hash(channelId, tenantKey);
    }
  }

  static class ChannelWrapper {
    enum State {
      ACTIVE,
      DRAINING
    }

    final long id;
    final ManagedChannel channel;
    final Instant createdAt;
    volatile State state = State.ACTIVE;
    int numOutstanding = 0;
    int consecutiveFailures = 0;
    Instant lastUsedAt;

    ChannelWrapper(long id, ManagedChannel channel, Clock clock) {
      this.id = id;
      this.channel = channel;
      this.createdAt = Instant.now(clock);
      this.lastUsedAt = this.createdAt;
    }
  }

  private static class AfeId {
    private final long id;

    static AfeId extract(PeerInfo peerInfo) {
      return new AfeId(peerInfo.getApplicationFrontendId());
    }

    private AfeId(long id) {
      this.id = id;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof AfeId)) {
        return false;
      }
      return id == ((AfeId) o).id;
    }

    @Override
    public int hashCode() {
      return com.google.common.base.Objects.hashCode(id);
    }

    @Override
    public String toString() {
      return Long.toString(id);
    }
  }
}
