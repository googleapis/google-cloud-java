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

package com.google.cloud.bigtable.data.v2.internal.session;

import static com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason.CLOSE_SESSION_REASON_MISSED_HEARTBEAT;

import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.Session.SessionState;
import com.google.common.annotations.VisibleForTesting;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * A data structure to track sessions through their lifecycle transitions.
 *
 * <p>Each session will be wrapped in a SessionHandle to track per Session state.
 *
 * <p>This class is not thread safe and requires external synchronization.
 */
@NotThreadSafe
class SessionList {
  private static final Logger LOG = Logger.getLogger(SessionList.class.getName());

  static final Duration SESSION_LIST_PRUNE_INTERVAL = Duration.ofMinutes(10);

  // List of afes that have sessions that are ready now.
  private final List<AfeHandle> afesWithReadySessions = new ArrayList<>();
  // A map of all recently used Afes with possibly empty sessions
  private final Map<AfeId, AfeHandle> afeHandles = new HashMap<>();
  // All the sessions being tracked by this SessionList including:
  // - ones that are in use
  // - starting sessions
  // - closing sessions
  private final Set<SessionHandle> allSessions = new HashSet<>();
  private final Set<SessionHandle> inUseSessions = new HashSet<>();

  private final CloseSessionRequest missedHeartbeatCloseRequest =
      CloseSessionRequest.newBuilder()
          .setReason(CLOSE_SESSION_REASON_MISSED_HEARTBEAT)
          .setDescription("missed heartbeat")
          .build();

  // pool level statistics across all  the afes
  private final PoolStats poolStats = new PoolStats();

  /** Entrypoint for a session's lifecycle */
  SessionHandle newHandle(Session session) {
    SessionHandle h = new SessionHandle(session);
    allSessions.add(h);
    poolStats.startingCount++;
    poolStats.expectedCapacity++;
    return h;
  }

  /** Get {@link PoolStats} */
  PoolStats getStats() {
    return poolStats;
  }

  Set<SessionHandle> getAllSessions() {
    return allSessions;
  }

  List<AfeHandle> getAfesWithReadySessions() {
    return Collections.unmodifiableList(afesWithReadySessions);
  }

  /**
   * Gets the next ready session from the afe. This will be called when a vrpc is about to be
   * started, it is called by the {@link Picker}.
   */
  public Optional<SessionHandle> checkoutSession(AfeHandle afeHandle) {
    Optional<SessionHandle> maybeHandle = Optional.ofNullable(afeHandle.sessions.poll());

    maybeHandle.ifPresent(
        handle -> {
          poolStats.readyCount--;
          poolStats.inUseCount++;

          if (handle.afe.get().sessions.isEmpty()) {
            afesWithReadySessions.remove(afeHandle);
          }
        });

    return maybeHandle;
  }

  /** Closes all the sessions with this reason. */
  void close(CloseSessionRequest req) {
    // Notify all sessions to close and have the callbacks clean up the rest of the state
    for (SessionHandle s : allSessions) {
      s.getSession().close(req);
    }
  }

  void prune() {
    Instant now = Instant.now();
    Instant horizon = now.minus(SESSION_LIST_PRUNE_INTERVAL);

    Iterator<Entry<AfeId, AfeHandle>> it = afeHandles.entrySet().iterator();
    while (it.hasNext()) {
      Entry<AfeId, AfeHandle> e = it.next();
      AfeHandle handle = e.getValue();
      if (handle.refCount > 0) {
        continue;
      }
      if (handle.lastConnected.isBefore(horizon)) {
        continue;
      }
      it.remove();
    }
  }

  void checkHeartbeat(Clock clock) {
    Instant now = clock.instant();
    inUseSessions.forEach(
        handle -> {
          if (now.isAfter(handle.getSession().getNextHeartbeat())) {
            LOG.log(
                Level.WARNING,
                "Missed heartbeat for {0}, forcing session close",
                handle.getSession().getLogName());
            handle.getSession().forceClose(missedHeartbeatCloseRequest);
          }
        });
  }

  @NotThreadSafe
  class SessionHandle {
    private final Session session;
    private boolean inExpectedCount = true;

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<AfeHandle> afe = Optional.empty();

    SessionHandle(Session session) {
      this.session = session;
    }

    Session getSession() {
      return session;
    }

    /** First transition in the happy path - server acknowledged the session */
    void onSessionStarted() {
      PeerInfo peerInfo = session.getPeerInfo();

      AfeHandle afeHandle =
          afeHandles.computeIfAbsent(AfeId.extract(peerInfo), (ignored) -> new AfeHandle());
      this.afe = Optional.of(afeHandle);
      afeHandle.sessions.add(this);
      afeHandle.refCount++;
      afeHandle.lastConnected = Instant.now();
      if (afeHandle.sessions.size() == 1) {
        afesWithReadySessions.add(afeHandle);
      }

      poolStats.startingCount--;
      poolStats.readyCount++;
    }

    void onVRpcStarted() {
      // Pool stats and AFE list are updated in SessionList#checkoutSession
      inUseSessions.add(this);
    }

    /**
     * The session is returned to the pool after use. This undoes what SessionList#checkoutSession
     */
    void onVRpcFinish(Duration elapsed, VRpcResult result) {
      // Guaranteed to be set - vrpc can only start after the session is ready
      AfeHandle afeHandle = this.afe.get();

      poolStats.inUseCount--;
      inUseSessions.remove(this);

      if (result.getStatus().isOk()) {
        afeHandle.updateLatency(elapsed, result.getBackendLatency());
      }

      if (session.getState() == SessionState.READY) {
        poolStats.readyCount++;
        afeHandle.sessions.add(this);
        afeHandle.lastConnected = Instant.now();

        // If this is the first session returned to the pool, transition the afe to ready list
        if (afeHandle.sessions.size() == 1) {
          afesWithReadySessions.add(afeHandle);
        }
      }
    }

    /**
     * Server started graceful refresh. The session is still available, but a replacement is being
     * searched for.
     */
    void onSessionClosing() {
      // The session could get a goaway before it started, which means it has not been
      // associated with an afe.
      // Also the session could get a goaway when its either idle or in use.
      boolean wasReady = false;

      // if afe is not present, the session has not started, so skip this
      if (afe.isPresent()) {
        wasReady = afe.get().sessions.remove(this);

        if (afe.get().sessions.isEmpty()) {
          afesWithReadySessions.remove(afe.get());
        }
      }

      if (wasReady) {
        poolStats.readyCount--;
      }
      // eagerly decrement expected count and make sure to avoid double counting in onSessionClosed
      poolStats.expectedCapacity--;
      inExpectedCount = false;
    }

    void onSessionClosed(SessionState prevState) {
      if (inExpectedCount) {
        poolStats.expectedCapacity--;
        inExpectedCount = false;
      }
      // only update counts after the session started and has an afe associated
      afe.ifPresent(afeHandle -> afeHandle.refCount--);

      // NOTE: don't need to update vRpc counters, onVRpcFinish will have been invoked already
      switch (prevState) {
        case NEW:
          throw new IllegalStateException("NEW session was closed");
        case STARTING:
          poolStats.startingCount--;
          break;
        case READY:
          {
            AfeHandle afeHandle = afe.get();
            // If the session was available & idle, then we need to remove it
            if (afeHandle.sessions.remove(this)) {
              poolStats.readyCount--;
              if (afeHandle.sessions.isEmpty()) {
                afesWithReadySessions.remove(afeHandle);
              }
            }
            break;
          }
        case CLOSING:
        case WAIT_SERVER_CLOSE:
          // noop
          break;
        case CLOSED:
          throw new IllegalStateException("double close");
      }

      allSessions.remove(this);
    }
  }

  /** Simple counters for the sessions contained in this list. */
  @NotThreadSafe
  static class PoolStats {
    private int startingCount;
    private int readyCount;
    private int inUseCount;
    private int expectedCapacity;

    PoolStats() {
      reset();
    }

    void reset() {
      startingCount = 0;
      readyCount = 0;
      inUseCount = 0;
      expectedCapacity = 0;
    }

    /** Number of Sessions that are being prepped, but not ready for use. */
    int getStartingCount() {
      return startingCount;
    }

    /** Number of Sessions ready for immediate use. */
    int getReadyCount() {
      return readyCount;
    }

    /**
     * Number of Sessions that are in use and thus unavailable. This includes sessions that will not
     * be returned to the pool because they will be closed when the go idle.
     */
    int getInUseCount() {
      return inUseCount;
    }

    /**
     * Number of sessions should be usable in the short term future. Includes sessions that are
     * starting, idle and in used.
     */
    int getExpectedCapacity() {
      return expectedCapacity;
    }

    @VisibleForTesting
    TestHelper getTestHelper() {
      return new TestHelper();
    }

    @Override
    public String toString() {
      return String.format(
          "PoolStats{startingCount=%d, readyCount=%d, inUseCount=%d, expectedCapacity=%d}",
          startingCount, readyCount, inUseCount, expectedCapacity);
    }

    @VisibleForTesting
    class TestHelper {
      void setStartingCount(int n) {
        startingCount = n;
      }

      void setReadyCount(int n) {
        readyCount = n;
      }

      void setExpectedCapacity(int n) {
        expectedCapacity = n;
      }

      void setInUseCount(int n) {
        inUseCount = n;
      }
    }
  }

  /** Typesafe wrapper around the applicationFrontendId the server sent us */
  @AutoValue
  abstract static class AfeId {
    protected abstract long getId();

    static AfeId extract(PeerInfo peerInfo) {
      return new AutoValue_SessionList_AfeId(peerInfo.getApplicationFrontendId());
    }
  }

  static class AfeHandle {
    // All sessions in the queue are ready to be used
    @VisibleForTesting final Queue<SessionHandle> sessions;
    // Last time this afe was used. It will be consulted when we need to garbage collect
    // afe that have disappeared
    private Instant lastConnected = Instant.now();
    // Tracks number ready and inUse sessions, also used for garbage collection
    private int refCount = 0;

    private final PeakEwma transportLatency = new PeakEwma(Duration.of(500, ChronoUnit.MICROS));
    private final PeakEwma e2eLatency = new PeakEwma(Duration.ofMillis(1));

    public AfeHandle() {
      sessions = new ArrayDeque<>();
    }

    void updateLatency(Duration e2eLatency, Duration backendLatency) {
      this.transportLatency.update(e2eLatency.minus(backendLatency));
      this.e2eLatency.update(e2eLatency);
    }

    double getTransportCost() {
      return transportLatency.getCost();
    }

    double getE2eCost() {
      return e2eLatency.getCost();
    }

    int getNumOutstanding() {
      return refCount - sessions.size();
    }
  }

  static class PeakEwma {
    // Use the last 10s as a look back window
    private final double decayNs = TimeUnit.SECONDS.toNanos(10);
    private long timestamp = System.nanoTime();
    private double cost;

    public PeakEwma(Duration initialLatency) {
      this.cost = initialLatency.toNanos();
    }

    public double getCost() {
      return cost;
    }

    void update(Duration rtt) {
      if (rtt.compareTo(Duration.ZERO) <= 0) {
        LOG.warning("Ignoring latency<= 0: " + rtt);
        return;
      }

      long now = System.nanoTime();
      long rttNs = rtt.toNanos();

      if (cost < rttNs) {
        this.cost = rttNs;
      } else {
        long elapsed = Math.max(now - timestamp, 0);
        double decay = Math.exp(-elapsed / decayNs);
        double recency = 1.0 - decay;
        this.cost = cost * decay + rttNs * recency;
      }
      this.timestamp = now;
    }
  }
}
