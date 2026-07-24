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

import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.LoadBalancingOptions;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.api.Util;
import com.google.cloud.bigtable.data.v2.internal.channels.ChannelPool;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.ForwardingVRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.Session.Listener;
import com.google.cloud.bigtable.data.v2.internal.session.Session.OpenParams;
import com.google.cloud.bigtable.data.v2.internal.session.Session.SessionState;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.SessionHandle;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor.SessionDescriptor;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.StatusProto;
import io.opentelemetry.context.Scope;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class SessionPoolImpl<OpenReqT extends Message> implements SessionPool<OpenReqT> {
  private static final Logger DEFAULT_LOGGER = Logger.getLogger(SessionPoolImpl.class.getName());
  private Logger logger = DEFAULT_LOGGER;

  private enum PoolState {
    NEW,
    STARTED,
    CLOSED
  }

  private static final int PROTOCOL_VERSION = 0;

  // Pool-wide lock. Replaces the previous `synchronized (this)` monitor. Kept as an explicit
  // ReentrantLock so the request-serving hot path can acquire it with a bounded timeout
  // (tryLock) instead of blocking forever. In production we observed a pool whose monitor had
  // no owner but many waiters (an orphaned monitor, e.g. after a thread died mid-critical-section
  // during native-thread OOM): every incoming RPC probe (hasSession/newCall) blocked on it
  // permanently, which piled up threads and shed 100% of traffic. With a ReentrantLock, a wedged
  // pool degrades to a bounded fast-fail on the request path rather than an unbounded hang.
  //
  // Reentrancy note: several internal callbacks (createSession, onSessionGoAway, ...) acquire the
  // lock while an outer critical section already holds it. ReentrantLock preserves the reentrant
  // semantics the old `synchronized` relied on.
  private final ReentrantLock poolLock = new ReentrantLock();

  // How long the request-serving hot path (hasSession/newCall/PendingVRpc.start) waits to acquire
  // the pool lock before giving up and degrading. Healthy critical sections are microseconds long,
  // so this is only ever exhausted when the pool is wedged; keeping it bounded turns a permanent
  // hang into a recoverable fast-fail.
  private static final long HOT_PATH_LOCK_TIMEOUT_MILLIS = 1000;

  private final Metrics metrics;
  private final FeatureFlags featureFlags;
  private final SessionPoolInfo info;
  private long sessionNum = 0;
  private final SessionFactory factory;
  private final SessionDescriptor<OpenReqT> descriptor;

  // Set once by start(), and read by both user & grpc threads
  private volatile OpenParams openParams;

  @GuardedBy("poolLock")
  private PoolState poolState = PoolState.NEW;

  @VisibleForTesting
  @GuardedBy("poolLock")
  final SessionList sessions;

  @GuardedBy("poolLock")
  private final DynamicPicker picker;

  @GuardedBy("poolLock")
  private final PoolSizer poolSizer;

  // TODO: we need to close pendingVRpcs when deadline expires
  @GuardedBy("poolLock")
  private final Deque<PendingVRpc<?, ?>> pendingRpcs = new ArrayDeque<>();

  private final Watchdog watchdog;

  // Shared by every SessionImpl, PendingVRpc, Watchdog, AFE pruner, and retry-create-session in
  // this pool. One tick thread per Client (owned by Client); O(1) insert / O(1) cancel.
  private final BigtableTimer timer;

  // Executor for timer-scheduled pool maintenance bodies (AFE prune, retry-create-session,
  // deadline monitor, watchdog tick). The timer's tick thread hands work here so it doesn't
  // run pool-lock-holding work inline.
  private final Executor backgroundExecutor;

  @GuardedBy("poolLock")
  private int consecutiveFailures = 0;

  /**
   * When the client fallback to a non-session AFE session creation will return unimplemented
   * errors. In which case the requests should fallback to classic client instead of waiting for an
   * available session.
   */
  private volatile int consecutiveUnimplementedFailures = 0;

  // Self-rescheduling AFE-prune chain. Set by scheduleNextAfePrune; cancelled by close.
  @GuardedBy("poolLock")
  @Nullable
  private BigtableTimer.Timeout afeListPruneTimeout;

  @GuardedBy("poolLock")
  private boolean closed = false;

  // Completed when this pool has been close()d AND every session has reached the CLOSED terminal
  // state. Drives Client.close()'s drain barrier so that listener.onClose tasks finish queueing
  // onto userCallbackExecutor before that executor is shut down.
  private final CompletableFuture<Void> drainedFuture = new CompletableFuture<>();

  @GuardedBy("poolLock")
  private BigtableTimer.Timeout retryCreateSessionFuture = null;

  // TODO: get the max from ClientConfiguration
  @GuardedBy("poolLock")
  private final SessionCreationBudget budget;

  private final ClientConfigurationManager configManager;
  private final ClientConfigurationManager.ListenerHandle configListenerHandle;

  private final DebugTagTracer debugTagTracer;

  // @SuppressWarnings("GuardedBy"): error-prone flags writes to @GuardedBy("poolLock") fields
  // (sessions, picker, poolSizer, pendingRpcs, budget, retryCreateSessionFuture) inside the
  // constructor without holding the monitor. This is safe because the object is not yet published
  // to other threads — no external reference exists until the constructor returns.
  @SuppressWarnings("GuardedBy")
  public SessionPoolImpl(
      Metrics metrics,
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ClientConfigurationManager configManager,
      ChannelPool channelPool,
      CallOptions callOptions,
      SessionDescriptor<OpenReqT> sessionDescriptor,
      String name,
      BigtableTimer timer,
      Executor backgroundExecutor) {
    this(
        metrics,
        featureFlags,
        clientInfo,
        configManager,
        channelPool,
        callOptions,
        sessionDescriptor,
        name,
        timer,
        backgroundExecutor,
        createInitialBudget(configManager.getClientConfiguration()));
  }

  // @SuppressWarnings("GuardedBy"): same rationale as the public constructor above.
  @SuppressWarnings("GuardedBy")
  @VisibleForTesting
  SessionPoolImpl(
      Metrics metrics,
      FeatureFlags featureFlags,
      ClientInfo clientInfo,
      ClientConfigurationManager configManager,
      ChannelPool channelPool,
      CallOptions callOptions,
      SessionDescriptor<OpenReqT> sessionDescriptor,
      String name,
      BigtableTimer timer,
      Executor backgroundExecutor,
      SessionCreationBudget budget) {
    this.metrics = metrics;
    this.featureFlags = featureFlags;
    this.info = SessionPoolInfo.create(clientInfo, sessionDescriptor, name);
    this.factory =
        new SessionFactory(channelPool, sessionDescriptor.getMethodDescriptor(), callOptions);
    this.descriptor = sessionDescriptor;
    // Timer is owned by the caller (typically Client) and shared across pools — do NOT stop it
    // in close().
    this.timer = timer;
    this.backgroundExecutor = backgroundExecutor;

    sessions = new SessionList();
    LoadBalancingOptions lbOptions =
        configManager
            .getClientConfiguration()
            .getSessionConfiguration()
            .getSessionPoolConfiguration()
            .getLoadBalancingOptions();
    picker = new DynamicPicker(sessions, lbOptions);
    poolSizer =
        new PoolSizer(
            sessions.getStats(),
            pendingRpcs::size,
            configManager
                .getClientConfiguration()
                .getSessionConfiguration()
                .getSessionPoolConfiguration());

    debugTagTracer = metrics.getDebugTagTracer();

    // Watchdog checks for sessions in WAIT_SERVER_CLOSE state and runs every 5 minutes
    watchdog =
        new Watchdog(
            poolLock, timer, backgroundExecutor, Duration.ofMinutes(5), sessions, debugTagTracer);
    // Heartbeat monitoring is now done per-session via SessionImpl.scheduleHeartbeatCheck.
    scheduleNextAfePrune();

    this.budget = budget;

    this.configManager = configManager;
    this.configListenerHandle =
        configManager.addListener(
            clientConfig -> clientConfig.getSessionConfiguration().getSessionPoolConfiguration(),
            newConfig -> {
              poolLock.lock();
              try {
                budget.updateConfig(newConfig);
                poolSizer.updateConfig(newConfig);
                picker.updateConfig(newConfig);
              } finally {
                poolLock.unlock();
              }
            });
  }

  @GuardedBy("poolLock")
  private void scheduleNextAfePrune() {
    if (closed) {
      return;
    }
    afeListPruneTimeout =
        timer.newTimeout(
            this::runAfePruneAndReschedule,
            backgroundExecutor,
            SessionList.SESSION_LIST_PRUNE_INTERVAL.toMillis(),
            TimeUnit.MILLISECONDS);
  }

  private void runAfePruneAndReschedule() {
    poolLock.lock();
    try {
      try {
        if (closed) {
          return;
        }
        sessions.prune();
      } catch (Throwable t) {
        logger.log(Level.WARNING, "AFE prune tick threw; continuing", t);
      } finally {
        scheduleNextAfePrune();
      }
    } finally {
      poolLock.unlock();
    }
  }

  @Override
  public SessionPoolInfo getInfo() {
    return info;
  }

  @Override
  public void close(CloseSessionRequest req) {
    configListenerHandle.close();

    List<PendingVRpc<?, ?>> toCancel;
    poolLock.lock();
    try {
      if (poolState == PoolState.CLOSED) {
        logger.fine(String.format("Tried to close a closed SessionPool %s", info.getLogName()));
        return;
      }
      logger.fine(String.format("Closing session pool %s for reason %s", info.getLogName(), req));

      poolState = PoolState.CLOSED;
      closed = true;

      toCancel = new ArrayList<>(pendingRpcs);
      pendingRpcs.clear();
      if (afeListPruneTimeout != null) {
        afeListPruneTimeout.cancel();
        afeListPruneTimeout = null;
      }
      if (retryCreateSessionFuture != null) {
        retryCreateSessionFuture.cancel();
        retryCreateSessionFuture = null;
      }
      // Watchdog stays alive past close() so it can escalate any session that lingers in
      // WAIT_SERVER_CLOSE during shutdown. awaitTerminated() takes ownership of closing it.
      sessions.close(req);
      // If the pool had no sessions, drainedFuture would never be completed by onSessionClose.
      if (sessions.getAllSessions().isEmpty()) {
        drainedFuture.complete(null);
      }
    } finally {
      poolLock.unlock();
    }

    // cancelWithResult trampolines through ctx.getExecutor() — required because the public
    // cancel(String, Throwable) path asserts opExecutor affinity, but close() runs on the
    // caller thread.
    VRpcResult closeResult =
        VRpcResult.createRejectedError(
            Status.CANCELLED.withDescription("SessionPool closed: " + req));
    for (PendingVRpc<?, ?> pendingRpc : toCancel) {
      pendingRpc.cancelWithResult(closeResult);
    }
  }

  @Override
  public boolean awaitTerminated(Duration timeout) throws InterruptedException {
    try {
      drainedFuture.get(timeout.toNanos(), TimeUnit.NANOSECONDS);
      return true;
    } catch (TimeoutException e) {
      return false;
    } catch (ExecutionException e) {
      // drainedFuture is only completed via .complete(null), never .completeExceptionally —
      // a CancellationException would still be wrapped here. Treat as a bug.
      debugTagTracer.record(
          TelemetryConfiguration.Level.ERROR, "session_pool_drained_future_failed");
      throw new IllegalStateException("drainedFuture failed unexpectedly", e);
    } finally {
      // Close the watchdog on the way out — drained or timed out, its job is done.
      watchdog.close();
    }
  }

  @Override
  public void start(OpenReqT openReq, Metadata md) {
    poolLock.lock();
    try {
      Preconditions.checkState(poolState == PoolState.NEW);

      Metadata mergedMd = new Metadata();
      mergedMd.merge(md);
      mergedMd.merge(Util.composeMetadata(featureFlags, descriptor.extractHeaderParams(openReq)));

      openParams =
          OpenParams.create(
              mergedMd,
              OpenSessionRequest.newBuilder()
                  .setProtocolVersion(PROTOCOL_VERSION)
                  .setFlags(featureFlags)
                  .setConsecutiveFailedConnectionAttempts(
                      0) // will be updated each handshake attempt
                  .setRoutingCookie(ByteString.EMPTY) // set when each session is renegotiated
                  .setPayload(openReq.toByteString()) // will be set on start
                  .build());
      poolState = PoolState.STARTED; // TODO: maybe need a READY state as well?

      // Pre-start
      for (int i = poolSizer.getScaleDelta(); i > 0; i--) {
        createSession(openParams);
      }

      watchdog.start();
    } finally {
      poolLock.unlock();
    }
  }

  private static SessionCreationBudget createInitialBudget(
      ClientConfiguration clientConfiguration) {
    SessionClientConfiguration.SessionPoolConfiguration sessionPoolConfig =
        clientConfiguration.getSessionConfiguration().getSessionPoolConfiguration();
    // Always use the config from the server. The budget should only be 0 when the
    // session load is 0.
    return SessionCreationBudget.create(
        sessionPoolConfig.getNewSessionCreationBudget(),
        SessionUtil.toJavaDuration(sessionPoolConfig.getNewSessionCreationPenalty()));
  }

  private int getMaxConsecutiveFailures(ClientConfigurationManager configManager) {
    return configManager
        .getClientConfiguration()
        .getSessionConfiguration()
        .getSessionPoolConfiguration()
        .getConsecutiveSessionFailureThreshold();
  }

  @GuardedBy("poolLock")
  private void createSession(OpenParams openParams) {
    if (!budget.tryReserveSession()) {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_pool_no_budget");
      logger.fine(
          String.format(
              "Refusing to add a new session due to exhausted %s concurrent create session"
                  + " requests",
              budget.getMaxConcurrentRequest()));
      // Retry create session if we run out of budget. In the edge case where we get a new VRpc
      // after failing to create any sessions and exhausting all the budget, we'll retry session
      // creation once the budget becomes available so the VRpc still has a chance to succeed.
      maybeScheduleCreateSessionRetry();
      return;
    }

    // Explicit create session streams in a detached context
    // We don't want to propagate the rpc deadline nor the trace context
    Context prevContext = Context.ROOT.attach();
    try {
      try (Scope ignored = io.opentelemetry.context.Context.root().makeCurrent()) {

        SessionStream stream = factory.createNew();
        Session session = new SessionImpl(metrics, info, sessionNum++, stream, timer);
        SessionHandle handle = sessions.newHandle(session);

        Metadata localMd = new Metadata();
        localMd.merge(openParams.metadata());
        session.start(
            openParams.request(),
            localMd,
            new Listener() {
              @Override
              public void onReady(OpenSessionResponse msg) {
                SessionPoolImpl.this.onSessionReady(handle, msg);
              }

              @Override
              public void onGoAway(GoAwayResponse msg) {
                SessionPoolImpl.this.onSessionGoAway(handle, msg);
              }

              @Override
              public void onClose(SessionState prevState, Status status, Metadata trailers) {
                SessionPoolImpl.this.onSessionClose(handle, prevState, status, trailers);
              }
            });
      }
    } finally {
      Context.ROOT.detach(prevContext);
    }
  }

  @GuardedBy("poolLock")
  private void maybeScheduleCreateSessionRetry() {
    if (retryCreateSessionFuture != null) {
      return;
    }
    // This interval could be 0 or negative if nextAvailableBudget is now. In which case
    // we'll retry after 1 millisecond to avoid retrying in a busy loop.
    long retryIntervalMs =
        Duration.between(Instant.now(), budget.getNextAvailableBudget()).toMillis();
    if (retryIntervalMs < 1) {
      retryIntervalMs = 1;
    }
    retryCreateSessionFuture =
        timer.newTimeout(
            () -> {
              poolLock.lock();
              try {
                retryCreateSessionFuture = null;
                if (poolState != PoolState.CLOSED && poolSizer.getScaleDelta() > 0) {
                  createSession(openParams);
                }
              } finally {
                poolLock.unlock();
              }
            },
            backgroundExecutor,
            retryIntervalMs,
            TimeUnit.MILLISECONDS);
  }

  private void onSessionReady(SessionHandle handle, OpenSessionResponse ignored) {
    poolLock.lock();
    try {
      logger.log(
          Level.FINE,
          "Session {0} in state {1}",
          new Object[] {handle.getSession().getLogName(), handle.getSession().getState()});

      consecutiveFailures = 0;
      consecutiveUnimplementedFailures = 0;

      if (poolState != PoolState.STARTED) {
        logger.fine(
            String.format(
                "%s Session became ready after pool transitioned to %s, ignoring",
                handle.getSession().getLogName(), poolState));
        // The session will be closed as part of SessionList#close
        return;
      }
      handle.onSessionStarted();

      budget.onSessionCreationSuccess();

      // handle pending rpcs
      tryDrainPendingRpcs();
    } finally {
      poolLock.unlock();
    }
  }

  private void onVRpcComplete(SessionHandle handle, Duration elapsed, VRpcResult result) {
    poolLock.lock();
    try {
      handle.onVRpcFinish(elapsed, result);
      afterRelease(handle);
    } finally {
      poolLock.unlock();
    }
  }

  // Called when a pending vRPC was drained but cancelled before it attached to a real call.
  // Mirrors onVRpcComplete; the handle reports no latency because nothing ran on it.
  private void onPendingVRpcCancelled(SessionHandle handle) {
    poolLock.lock();
    try {
      handle.onPendingVRpcCancelled();
      afterRelease(handle);
    } finally {
      poolLock.unlock();
    }
  }

  @GuardedBy("poolLock")
  private void afterRelease(SessionHandle handle) {
    // pool is shutting down, dont try to drain vrpcs
    if (poolState != PoolState.STARTED) {
      return;
    }
    // Session is shutting down, don't try to drain vrpcs
    if (handle.getSession().getState() != SessionState.READY) {
      return;
    }
    tryDrainPendingRpcs();
  }

  private void onSessionGoAway(SessionHandle handle, GoAwayResponse msg) {
    poolLock.lock();
    try {
      handle.onSessionClosing();

      // If the session received refresh config or pool requires a replacement, keep the current
      // session and request a replacement.
      // TODO: remove the check on if the open params is updated. In the future, server should
      // broadcast session refresh config to all the sessions that needs reconnect and client
      // just need to recreate sessions when pool sizer requries a replacement.
      if (handle.getSession().isOpenParamsUpdated() || poolSizer.handleGoAway(msg)) {
        logger.fine(
            String.format(
                "Adding new session to replace a going away session %s",
                handle.getSession().getLogName()));
        createSession(handle.getSession().getOpenParams());
      }
    } finally {
      poolLock.unlock();
    }
  }

  private void onSessionClose(
      SessionHandle handle, SessionState prevState, Status status, Metadata trailers) {

    List<PendingVRpc<?, ?>> toBeClosed = new ArrayList<>();

    poolLock.lock();
    try {
      logger.fine(
          String.format("Removing closed session from pool %s", handle.getSession().getLogName()));

      handle.onSessionClosed(prevState);

      // If the pool is closed then there is nothing else to do
      // dont need to create a replacement session and pending vRpcs get cleaned up in close()
      if (poolState == PoolState.CLOSED) {
        // Signal awaitTerminated() once the last session has drained.
        if (sessions.getAllSessions().isEmpty()) {
          drainedFuture.complete(null);
        }
        return;
      }

      // Handle abnormal close. This can happen if the Session was aborted due to underlying stream
      // termination
      if (prevState != SessionState.WAIT_SERVER_CLOSE) {
        consecutiveFailures++;
        if (status.getCode() == Status.Code.UNIMPLEMENTED) {
          consecutiveUnimplementedFailures++;
        } else {
          consecutiveUnimplementedFailures = 0;
        }
        // TODO: decide if max consecutive failures should be capped per client
        if (consecutiveFailures >= getMaxConsecutiveFailures(configManager)) {
          toBeClosed = popClosableRpcs();
        }

        if (prevState == SessionState.STARTING) {
          budget.onSessionCreationFailure();
        }

        // TODO: backoff creating a new session when consecutive failures > max?
        if (poolSizer.handleSessionClose(StatusProto.fromStatusAndTrailers(status, trailers))) {
          logger.fine(
              String.format(
                  "Replacing abnormally closed session %s", handle.getSession().getLogName()));
          createSession(openParams.withIncrementedAttempts());
        }
      }
    } finally {
      poolLock.unlock();
    }

    if (!toBeClosed.isEmpty()) {
      // vRPCs failing with consecutive failures should fail
      VRpcResult result =
          VRpcResult.createRejectedError(
              Status.fromCode(status.getCode())
                  .withDescription(
                      String.format(
                          "Session failed with consecutive failures. Most recent server status: %s,"
                              + " metadata: %s.",
                          status, trailers)));
      for (PendingVRpc<?, ?> vrpc : toBeClosed) {
        try {
          vrpc.cancelWithResult(result);
        } catch (Throwable t) {
          logger.log(Level.WARNING, "Exception dispatching close to op executor", t);
        }
      }
    }
  }

  @GuardedBy("poolLock")
  private void tryDrainPendingRpcs() {
    while (!pendingRpcs.isEmpty()) {
      Optional<SessionHandle> handle = picker.pickSession();
      if (!handle.isPresent()) {
        break;
      }
      PendingVRpc<?, ?> rpc = pendingRpcs.removeFirst();
      rpc.drainTo(handle.get());
    }
  }

  @GuardedBy("poolLock")
  private List<PendingVRpc<?, ?>> popClosableRpcs() {
    List<PendingVRpc<?, ?>> toBeClosed = new ArrayList<>();
    Iterator<PendingVRpc<?, ?>> iter = pendingRpcs.iterator();
    while (iter.hasNext()) {
      PendingVRpc<?, ?> vrpc = iter.next();
      iter.remove();
      toBeClosed.add(vrpc);
    }
    return toBeClosed;
  }

  @Override
  // @SuppressWarnings("GuardedBy"): error-prone can't see that the guarded fields are only touched
  // inside the tryLock()-guarded region. Bounded acquisition on the request hot path; see poolLock.
  @SuppressWarnings("GuardedBy")
  public <ReqT extends Message, RespT extends Message> VRpc<ReqT, RespT> newCall(
      VRpcDescriptor<?, ReqT, RespT> desc) {
    if (!tryAcquireHotPathLock()) {
      // The pool lock is wedged. Degrade to a pending call instead of blocking the caller forever;
      // PendingVRpc.start() will re-attempt the bounded acquisition and fast-fail if still wedged.
      return new PendingVRpc<>(desc);
    }
    try {
      Optional<SessionHandle> handle = picker.pickSession();
      if (handle.isPresent()) {
        return newRealCall(desc, handle.get());
      }
      if (logger.isLoggable(Level.FINE)) {
        logger.fine(
            String.format(
                "%s Creating new rpc as pending, numPending: %d, %s",
                info.getLogName(), pendingRpcs.size(), sessions.getStats()));
      }
      return new PendingVRpc<>(desc);
    } finally {
      poolLock.unlock();
    }
  }

  // Acquire the pool lock with a bounded timeout for the request-serving hot path. Returns false if
  // the lock could not be acquired within HOT_PATH_LOCK_TIMEOUT_MILLIS (i.e. the pool is wedged) or
  // the caller was interrupted. Callers that get false MUST degrade instead of accessing guarded
  // state, and MUST NOT call poolLock.unlock().
  private boolean tryAcquireHotPathLock() {
    // Fast path: the uncontended lock is acquired immediately and, unlike the timed tryLock below,
    // WITHOUT throwing if the calling thread already has its interrupt flag set. This preserves the
    // old `synchronized` behavior for the common healthy case — a pre-existing interrupt (e.g. on a
    // reused worker thread) must not be mistaken for a wedged pool, which would spuriously shed
    // traffic and, via the interrupt re-assertion below, poison every later call on that thread.
    if (poolLock.tryLock()) {
      return true;
    }
    boolean locked = false;
    try {
      locked = poolLock.tryLock(HOT_PATH_LOCK_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      // Preserve interrupt status for the caller; treat as a failed (degraded) acquisition.
      Thread.currentThread().interrupt();
    }
    if (!locked) {
      debugTagTracer.record(TelemetryConfiguration.Level.ERROR, "session_pool_lock_timeout");
    }
    return locked;
  }

  private <ReqT extends Message, RespT extends Message> VRpc<ReqT, RespT> newRealCall(
      VRpcDescriptor<?, ReqT, RespT> desc, SessionHandle handle) {

    return new ForwardingVRpc<ReqT, RespT>(handle.getSession().newCall(desc)) {
      @Override
      public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
        final Stopwatch stopwatch = Stopwatch.createStarted();
        super.start(
            req,
            ctx,
            new ForwardListener<RespT>(listener) {
              @Override
              public void onClose(VRpcResult result) {
                SessionPoolImpl.this.onVRpcComplete(handle, stopwatch.elapsed(), result);
                super.onClose(result);
              }
            });
      }
    };
  }

  // Used in the shim layer for fallback decisions. Called on every RPC and we're ok with seeing
  // slightly outdated value.
  @Override
  public int getConsecutiveUnimplementedFailures() {
    return consecutiveUnimplementedFailures;
  }

  // Used in the shim layer for fallback decisions. Called on every RPC.
  @Override
  // @SuppressWarnings("GuardedBy"): sessions is only read inside the tryLock()-guarded region.
  @SuppressWarnings("GuardedBy")
  public boolean hasSession() {
    if (!tryAcquireHotPathLock()) {
      // Treat a wedged pool as "no session available" rather than blocking on the pool lock forever.
      // Note: the shim's routing OR (unimplementedFailures < MAX || hasSession()) means returning
      // false here does not by itself force the classic path; the wedge protection that matters is
      // newCall()/PendingVRpc.start() fast-failing with a retriable UNAVAILABLE.
      return false;
    }
    try {
      return sessions.getStats().getReadyCount() + sessions.getStats().getInUseCount() > 0;
    } finally {
      poolLock.unlock();
    }
  }

  class PendingVRpc<ReqT extends Message, RespT extends Message> implements VRpc<ReqT, RespT> {
    private final VRpcDescriptor<?, ReqT, RespT> desc;

    private ReqT req;
    private VRpcCallContext ctx;
    private VRpcListener<RespT> listener;

    private boolean isCancelled = false;
    private VRpc<ReqT, RespT> realCall;

    private BigtableTimer.Timeout deadlineMonitor;

    public PendingVRpc(VRpcDescriptor<?, ReqT, RespT> desc) {
      this.desc = desc;
    }

    @Override
    // @SuppressWarnings("GuardedBy"): guarded state is only touched inside the tryLock()-guarded
    // region. Bounded acquisition on the request hot path; see poolLock.
    @SuppressWarnings("GuardedBy")
    public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
      Preconditions.checkState(this.req == null, "request is already started");
      Preconditions.checkNotNull(req, "request can't be null");
      Preconditions.checkNotNull(ctx, "ctx can't be null");
      Preconditions.checkNotNull(listener, "listener can't be null");

      this.req = req;
      this.ctx = ctx;
      this.listener = listener;

      if (!tryAcquireHotPathLock()) {
        // The pool lock is wedged. Fast-fail this call with UNAVAILABLE (uncommitted, so it stays
        // retriable) instead of blocking the caller thread forever. Mark it terminal inside the
        // op-executor (which owns isCancelled) so a subsequent cancel() is a no-op rather than
        // delivering a second onClose.
        VRpcResult result =
            VRpcResult.createUncommitedError(
                Status.UNAVAILABLE.withCause(
                    new IllegalStateException("SessionPool lock unavailable (pool wedged)")));
        ctx.getExecutor()
            .execute(
                () -> {
                  if (isCancelled) return;
                  isCancelled = true;
                  listener.onClose(result);
                });
        return;
      }
      try {
        if (SessionPoolImpl.this.poolState != PoolState.STARTED) {
          VRpcResult result =
              VRpcResult.createUncommitedError(
                  Status.UNAVAILABLE.withCause(new IllegalStateException("SessionPool is closed")));
          ctx.getExecutor().execute(() -> listener.onClose(result));
          return;
        }
        // Only arm the deadline monitor after we've committed to queueing; otherwise the
        // fast-fail early return above would leak a timer that fires later and emits a phantom
        // tracer.onAttemptFinish on the Active state's stale listener.
        this.deadlineMonitor = monitorDeadline(ctx.getOperationInfo().getDeadline());
        pendingRpcs.add(this);

        if (logger.isLoggable(Level.FINE)) {
          logger.fine(
              String.format(
                  "starting pending call, numPending: %d, %s",
                  pendingRpcs.size(), sessions.getStats()));
        }

        if (poolSizer.handleNewCall()) {
          logger.fine(
              String.format("Adding session to handle incoming vrpc %s", info.getLogName()));
          createSession(openParams);
        }

        tryDrainPendingRpcs();
      } finally {
        poolLock.unlock();
      }
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      Status status = Status.CANCELLED;
      if (message != null) {
        status = status.withDescription(message);
      }
      if (cause != null) {
        status = status.withCause(cause);
      }
      cancel(status, false);
    }

    // cancel() and drainTo() are sequenced via ctx.getExecutor() (a per-op SerializingExecutor),
    // so isCancelled and realCall are owned exclusively by that executor — no pool lock needed.
    // @SuppressWarnings("GuardedBy"): pendingRpcs is only touched inside the tryLock()-guarded
    // region below.
    @SuppressWarnings("GuardedBy")
    private void cancel(Status status, boolean onlyCancelPendingCall) {
      // The eager removal is only an optimization to skip a wasted session pick in tryDrainPendingRpcs.
      // Use the bounded hot-path acquisition instead of a blocking lock(): this runs on a callback
      // (op-executor) thread, and an orphaned/wedged poolLock would otherwise park that thread forever
      // — the exact thread pile-up that wedged pods in production. If we can't get the lock, skip the
      // removal; drainTo()'s isCancelled guard is the correctness backstop (it releases the session
      // via onPendingVRpcCancelled instead of starting the real call). See poolLock.
      if (tryAcquireHotPathLock()) {
        try {
          pendingRpcs.remove(this); // eager removal; no-op if already drained
        } finally {
          poolLock.unlock();
        }
      }
      ctx.getExecutor()
          .execute(
              () -> {
                if (isCancelled) return;
                isCancelled = true;
                if (realCall != null) {
                  if (!onlyCancelPendingCall) {
                    realCall.cancel(status.getDescription(), status.getCause());
                  }
                } else {
                  listener.onClose(VRpcResult.createRejectedError(status));
                }
              });
    }

    void cancelWithResult(VRpcResult result) {
      ctx.getExecutor()
          .execute(
              () -> {
                if (isCancelled) return;
                isCancelled = true;
                listener.onClose(result);
              });
    }

    @Override
    public boolean isDone() {
      // realCall set in drainTo's lambda; once we hand off, it's the source of truth.
      // Pre-handoff, isCancelled tracks our own terminal state.
      return realCall != null ? realCall.isDone() : isCancelled;
    }

    @Override
    public void requestNext() {
      if (realCall != null) {
        realCall.requestNext();
        return;
      }
      throw new IllegalStateException("requestNext can't be called until data has been received");
    }

    private void drainTo(SessionHandle handle) {
      if (deadlineMonitor != null) {
        deadlineMonitor.cancel();
      }
      ctx.getExecutor()
          .execute(
              () -> {
                if (isCancelled) {
                  SessionPoolImpl.this.onPendingVRpcCancelled(handle);
                  return;
                }
                realCall = newRealCall(desc, handle);
                realCall.start(req, ctx, listener);
              });
    }

    private VRpcListener<RespT> getListener() {
      return listener;
    }

    private BigtableTimer.Timeout monitorDeadline(Deadline deadline) {
      // Body runs on backgroundExecutor (off the tick thread). onlyCancelPendingCall=true avoids
      // racing with a user cancel that already attached a real call.
      return timer.newTimeout(
          () ->
              cancel(
                  Status.DEADLINE_EXCEEDED.withDescription("Deadline exceeded waiting for session"),
                  true),
          backgroundExecutor,
          deadline.timeRemaining(TimeUnit.NANOSECONDS),
          TimeUnit.NANOSECONDS);
    }
  }

  static class Watchdog implements Runnable {
    private static final Logger LOG = Logger.getLogger(Watchdog.class.getName());

    private final Lock lock;
    private final BigtableTimer timer;
    private final Executor backgroundExecutor;
    private final Duration interval;
    private final SessionList sessions;
    private final Clock clock;
    private final DebugTagTracer debugTagTracer;

    // Guards currentTimeout and watchdogClosed. Self-contained — never composed with any external
    // lock.
    private final Object scheduleLock = new Object();

    @GuardedBy("scheduleLock")
    private BigtableTimer.Timeout currentTimeout;

    @GuardedBy("scheduleLock")
    private boolean watchdogClosed = false;

    // The `lock` parameter is the pool-wide lock (SessionPoolImpl.poolLock).
    public Watchdog(
        Lock lock,
        BigtableTimer timer,
        Executor backgroundExecutor,
        Duration interval,
        SessionList sessionList,
        DebugTagTracer debugTagTracer) {
      this(
          lock,
          timer,
          backgroundExecutor,
          interval,
          sessionList,
          debugTagTracer,
          Clock.systemUTC());
    }

    @VisibleForTesting
    Watchdog(
        Lock lock,
        BigtableTimer timer,
        Executor backgroundExecutor,
        Duration interval,
        SessionList sessionList,
        DebugTagTracer debugTagTracer,
        Clock clock) {
      this.lock = lock;
      this.timer = timer;
      this.backgroundExecutor = backgroundExecutor;
      this.interval = interval;
      this.sessions = sessionList;
      this.debugTagTracer = debugTagTracer;
      this.clock = clock;
    }

    public void start() {
      scheduleNext();
    }

    // Self-reschedule. Called once from start() and again at the end of each tick.
    private void scheduleNext() {
      synchronized (scheduleLock) {
        if (watchdogClosed) return;
        currentTimeout =
            timer.newTimeout(
                this::runAndReschedule,
                backgroundExecutor,
                interval.toMillis(),
                TimeUnit.MILLISECONDS);
      }
    }

    private void runAndReschedule() {
      try {
        run();
      } catch (Throwable t) {
        // Preserve the watchdog across body exceptions — unlike scheduleAtFixedRate, which silently
        // stops the schedule on the first exception, we keep going so a transient fault doesn't
        // permanently disable session leak detection.
        LOG.log(Level.WARNING, "Watchdog tick threw; continuing", t);
      } finally {
        scheduleNext();
      }
    }

    @Override
    public void run() {
      // Snapshot under the pool lock: getAllSessions() returns the live HashSet, and pool state
      // mutation (session create/close on another thread) during iteration would throw
      // ConcurrentModificationException. Most common trigger is a heartbeat-miss cascade that
      // churns sessions while the watchdog is walking the list.
      Set<SessionHandle> allSessions;
      lock.lock();
      try {
        allSessions = new HashSet<>(sessions.getAllSessions());
      } finally {
        lock.unlock();
      }

      for (SessionHandle handle : allSessions) {
        Session s = handle.getSession();

        if (s.getState() != SessionState.WAIT_SERVER_CLOSE) {
          continue;
        }

        Duration stateDuration = Duration.between(s.getLastStateChange(), Instant.now(clock));
        if (stateDuration.compareTo(interval) < 0) {
          continue;
        }

        debugTagTracer.record(TelemetryConfiguration.Level.WARN, "watchdog_close_session");
        LOG.fine(
            String.format(
                "Found session %s that lingered too long in WAIT_SERVER_CLOSE state, canceling"
                    + " session",
                handle.getSession().getLogName()));
        handle
            .getSession()
            .forceClose(
                CloseSessionRequest.newBuilder()
                    .setReason(CloseSessionReason.CLOSE_SESSION_REASON_ERROR)
                    .setDescription(
                        String.format(
                            "Watchdog found session %s in awaiting close for too long. Last"
                                + " activity was %s ago.",
                            handle.getSession().getLogName(),
                            Duration.between(
                                handle.getSession().getLastStateChange(), Instant.now(clock))))
                    .build());
      }
    }

    public void close() {
      synchronized (scheduleLock) {
        watchdogClosed = true;
        if (currentTimeout != null) {
          currentTimeout.cancel();
          currentTimeout = null;
        }
      }
    }
  }
}
