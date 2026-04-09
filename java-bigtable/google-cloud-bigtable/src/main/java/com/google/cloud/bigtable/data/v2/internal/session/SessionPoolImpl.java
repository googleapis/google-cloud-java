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
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
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

  private final Metrics metrics;
  private final FeatureFlags featureFlags;
  private final SessionPoolInfo info;
  private long sessionNum = 0;
  private final SessionFactory factory;
  private final SessionDescriptor<OpenReqT> descriptor;

  // Set once by start(), and read by both user & grpc threads
  private volatile OpenParams openParams;

  @GuardedBy("this")
  private PoolState poolState = PoolState.NEW;

  @VisibleForTesting
  @GuardedBy("this")
  final SessionList sessions;

  @GuardedBy("this")
  private final DynamicPicker picker;

  @GuardedBy("this")
  private final PoolSizer poolSizer;

  // TODO: we need to close pendingVRpcs when deadline expires
  @GuardedBy("this")
  private final Deque<PendingVRpc<?, ?>> pendingRpcs = new ArrayDeque<>();

  private final Watchdog watchdog;

  @GuardedBy("this")
  private int consecutiveFailures = 0;

  /**
   * When the client fallback to a non-session AFE session creation will return unimplemented
   * errors. In which case the requests should fallback to classic client instead of waiting for an
   * available session.
   */
  private volatile int consecutiveUnimplementedFailures = 0;

  private final ScheduledFuture<?> afeListPruneTask;

  private final ScheduledFuture<?> heartbeatMonitor;

  private final ScheduledExecutorService executorService;

  @GuardedBy("this")
  private ScheduledFuture<?> retryCreateSessionFuture = null;

  // TODO: get the max from ClientConfiguration
  @GuardedBy("this")
  private final SessionCreationBudget budget;

  private final ClientConfigurationManager configManager;
  private final ClientConfigurationManager.ListenerHandle configListenerHandle;

  private final DebugTagTracer debugTagTracer;

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
      ScheduledExecutorService executorService) {
    this(
        metrics,
        featureFlags,
        clientInfo,
        configManager,
        channelPool,
        callOptions,
        sessionDescriptor,
        name,
        executorService,
        createInitialBudget(configManager.getClientConfiguration()));
  }

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
      ScheduledExecutorService executorService,
      SessionCreationBudget budget) {
    this.metrics = metrics;
    this.featureFlags = featureFlags;
    this.info = SessionPoolInfo.create(clientInfo, sessionDescriptor, name);
    this.factory =
        new SessionFactory(channelPool, sessionDescriptor.getMethodDescriptor(), callOptions);
    this.descriptor = sessionDescriptor;
    this.executorService = executorService;

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
    watchdog = new Watchdog(this, executorService, Duration.ofMinutes(5), sessions, debugTagTracer);
    // Heartbeat monitor checks for sessions in READY state with active vRPCs and runs more
    // frequently
    heartbeatMonitor =
        executorService.scheduleAtFixedRate(
            () -> {
              synchronized (SessionPoolImpl.this) {
                sessions.checkHeartbeat(Clock.systemUTC());
              }
            },
            SessionImpl.HEARTBEAT_CHECK_INTERVAL.toMillis(),
            SessionImpl.HEARTBEAT_CHECK_INTERVAL.toMillis(),
            TimeUnit.MILLISECONDS);
    afeListPruneTask =
        executorService.scheduleAtFixedRate(
            () -> {
              synchronized (SessionPoolImpl.this) {
                sessions.prune();
              }
            },
            SessionList.SESSION_LIST_PRUNE_INTERVAL.toMillis(),
            SessionList.SESSION_LIST_PRUNE_INTERVAL.toMillis(),
            TimeUnit.MILLISECONDS);

    this.budget = budget;

    this.configManager = configManager;
    this.configListenerHandle =
        configManager.addListener(
            clientConfig -> clientConfig.getSessionConfiguration().getSessionPoolConfiguration(),
            newConfig -> {
              synchronized (SessionPoolImpl.this) {
                budget.updateConfig(newConfig);
                poolSizer.updateConfig(newConfig);
                picker.updateConfig(newConfig);
              }
            });
  }

  @Override
  public SessionPoolInfo getInfo() {
    return info;
  }

  @Override
  public void close(CloseSessionRequest req) {
    configListenerHandle.close();

    synchronized (this) {
      if (poolState == PoolState.CLOSED) {
        logger.fine(String.format("Tried to close a closed SessionPool %s", info.getLogName()));
        return;
      }
      logger.fine(String.format("Closing session pool %s for reason %s", info.getLogName(), req));

      poolState = PoolState.CLOSED;

      for (PendingVRpc<?, ?> pendingRpc : pendingRpcs) {
        pendingRpc.cancel("SessionPool closed: " + req, null);
      }
      afeListPruneTask.cancel(false);
      heartbeatMonitor.cancel(false);
      if (retryCreateSessionFuture != null) {
        retryCreateSessionFuture.cancel(false);
        retryCreateSessionFuture = null;
      }
      watchdog.close();
      sessions.close(req);
    }
  }

  @Override
  public synchronized void start(OpenReqT openReq, Metadata md) {
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
                .setConsecutiveFailedConnectionAttempts(0) // will be updated each handshake attempt
                .setRoutingCookie(ByteString.EMPTY) // set when each session is renegotiated
                .setPayload(openReq.toByteString()) // will be set on start
                .build());
    poolState = PoolState.STARTED; // TODO: maybe need a READY state as well?

    // Pre-start
    for (int i = poolSizer.getScaleDelta(); i > 0; i--) {
      createSession(openParams);
    }

    watchdog.start();
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

  private synchronized void createSession(OpenParams openParams) {
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
        Session session = new SessionImpl(metrics, info, sessionNum++, stream);
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

  @GuardedBy("this")
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
        executorService.schedule(
            () -> {
              synchronized (this) {
                retryCreateSessionFuture = null;
                if (poolState != PoolState.CLOSED && poolSizer.getScaleDelta() > 0) {
                  createSession(openParams);
                }
              }
            },
            retryIntervalMs,
            TimeUnit.MILLISECONDS);
  }

  private synchronized void onSessionReady(SessionHandle handle, OpenSessionResponse ignored) {
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
  }

  private synchronized void onVRpcComplete(
      SessionHandle handle, Duration elapsed, VRpcResult result) {
    handle.onVRpcFinish(elapsed, result);

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

  private synchronized void onSessionGoAway(SessionHandle handle, GoAwayResponse msg) {
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
  }

  private void onSessionClose(
      SessionHandle handle, SessionState prevState, Status status, Metadata trailers) {

    List<PendingVRpc<?, ?>> toBeClosed = new ArrayList<>();

    synchronized (this) {
      logger.fine(
          String.format("Removing closed session from pool %s", handle.getSession().getLogName()));

      handle.onSessionClosed(prevState);

      // If the pool is closed then there is nothing else to do
      // dont need to create a replacement session and pending vRpcs get cleaned up in close()
      if (poolState == PoolState.CLOSED) {
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
    }

    if (!toBeClosed.isEmpty()) {
      // vRPCs failing with consecutive failures should fail
      VRpcResult result =
          VRpcResult.createRejectedError(
              Status.UNAVAILABLE.withDescription(
                  String.format(
                      "Session failed with consecutive failures. Most recent server status: %s,"
                          + " metadata: %s.",
                      status, trailers)));
      for (PendingVRpc<?, ?> vrpc : toBeClosed) {
        try {
          vrpc.getListener().onClose(result);
        } catch (Throwable t) {
          logger.log(Level.WARNING, "Exception when closing request", t);
        }
      }
    }
  }

  @GuardedBy("this")
  private void tryDrainPendingRpcs() {
    while (!pendingRpcs.isEmpty()) {
      if (pendingRpcs.peek().isCancelled) {
        pendingRpcs.pop();
        continue;
      }
      Optional<SessionHandle> handle = picker.pickSession();
      if (!handle.isPresent()) {
        break;
      }
      handle.get().onVRpcStarted();
      PendingVRpc<?, ?> rpc = pendingRpcs.removeFirst();
      rpc.drainTo(handle.get());
    }
  }

  @GuardedBy("this")
  private List<PendingVRpc<?, ?>> popClosableRpcs() {
    List<PendingVRpc<?, ?>> toBeClosed = new ArrayList<>();
    Iterator<PendingVRpc<?, ?>> iter = pendingRpcs.iterator();
    while (iter.hasNext()) {
      PendingVRpc<?, ?> vrpc = iter.next();
      // vrpcs that have started on a session gets closed in SessionImpl. Do not double close.
      if (!vrpc.isCancelled && vrpc.realCall == null) {
        iter.remove();
        toBeClosed.add(vrpc);
      }
    }
    return toBeClosed;
  }

  @Override
  public synchronized <ReqT extends Message, RespT extends Message> VRpc<ReqT, RespT> newCall(
      VRpcDescriptor<?, ReqT, RespT> desc) {
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
  }

  @GuardedBy("this")
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
  public synchronized boolean hasSession() {
    return sessions.getStats().getReadyCount() + sessions.getStats().getInUseCount() > 0;
  }

  class PendingVRpc<ReqT extends Message, RespT extends Message> implements VRpc<ReqT, RespT> {
    private final VRpcDescriptor<?, ReqT, RespT> desc;

    private ReqT req;
    private VRpcCallContext ctx;
    private VRpcListener<RespT> listener;

    private boolean isCancelled = false;
    private VRpc<ReqT, RespT> realCall;

    private ScheduledFuture<?> deadlineMonitor;

    public PendingVRpc(VRpcDescriptor<?, ReqT, RespT> desc) {
      this.desc = desc;
    }

    @Override
    public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
      Preconditions.checkState(this.req == null, "request is already started");
      Preconditions.checkNotNull(req, "request can't be null");
      Preconditions.checkNotNull(ctx, "ctx can't be null");
      Preconditions.checkNotNull(listener, "listener can't be null");

      this.req = req;
      this.ctx = ctx;
      this.listener = listener;
      this.deadlineMonitor = monitorDeadline(executorService, ctx.getOperationInfo().getDeadline());

      synchronized (SessionPoolImpl.this) {
        if (SessionPoolImpl.this.poolState != PoolState.STARTED) {
          listener.onClose(
              VRpcResult.createUncommitedError(
                  Status.UNAVAILABLE.withCause(
                      new IllegalStateException("SessionPool is closed"))));
          return;
        }
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
      }
    }

    // It's safe to call cancel on a vrpc more than once. It'll be a noop after the initial
    // call. Cancelled vrpcs are removed from the pending vrpc queue the next time we
    // drain the queue.
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

    // Cancel could race with drainTo which sets the real call. Assign realCall to a NOOP_CALL
    // so if drainTo gets called at the same time, it'll just get swallowed and we're only calling
    // onClose once on the listener. The cancel could also come from deadline monitor when
    // the deadline expires. In this case if the real call is already set, we want to real call
    // to handle the deadline and return early.
    private void cancel(Status status, boolean onlyCancelPendingCall) {
      boolean delegateToRealCall = true;
      synchronized (SessionPoolImpl.this) {
        if (isCancelled) {
          return;
        }
        isCancelled = true;
        if (realCall == null) {
          this.realCall = NOOP_CALL;
          delegateToRealCall = false;
        } else if (onlyCancelPendingCall) {
          return;
        }
      }
      if (delegateToRealCall) {
        realCall.cancel(status.getDescription(), status.getCause());
      } else {
        listener.onClose(VRpcResult.createRejectedError(status));
      }
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
      synchronized (SessionPoolImpl.this) {
        if (realCall == null) {
          this.realCall = newRealCall(desc, handle);
        }
      }
      this.realCall.start(req, ctx, listener);
      if (deadlineMonitor != null) {
        deadlineMonitor.cancel(false);
      }
    }

    private VRpcListener<RespT> getListener() {
      return listener;
    }

    private ScheduledFuture<?> monitorDeadline(
        ScheduledExecutorService executorService, Deadline deadline) {
      return executorService.schedule(
          () ->
              // This could race with user cancel. Setting onlyCancelPendingCall to true
              // so that if the real call is set, this cancellation is going to be a noop.
              cancel(
                  Status.DEADLINE_EXCEEDED.withDescription("Deadline exceeded waiting for session"),
                  true),
          deadline.timeRemaining(TimeUnit.NANOSECONDS),
          TimeUnit.NANOSECONDS);
    }
  }

  static class Watchdog implements Runnable {
    private static final Logger LOG = Logger.getLogger(Watchdog.class.getName());

    private final Object lock;
    private final ScheduledExecutorService executor;
    private final Duration interval;
    private final SessionList sessions;
    private ScheduledFuture<?> future;
    private final Clock clock;
    private final DebugTagTracer debugTagTracer;

    // TODO: fix lock sharing
    public Watchdog(
        Object lock,
        ScheduledExecutorService executor,
        Duration interval,
        SessionList sessionList,
        DebugTagTracer debugTagTracer) {
      this(lock, executor, interval, sessionList, debugTagTracer, Clock.systemUTC());
    }

    @VisibleForTesting
    Watchdog(
        Object lock,
        ScheduledExecutorService executor,
        Duration interval,
        SessionList sessionList,
        DebugTagTracer debugTagTracer,
        Clock clock) {
      this.lock = lock;
      this.executor = executor;
      this.interval = interval;
      this.sessions = sessionList;
      this.debugTagTracer = debugTagTracer;
      this.clock = clock;
    }

    public void start() {
      future =
          executor.scheduleAtFixedRate(
              this, interval.toMillis(), interval.toMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public void run() {
      Set<SessionHandle> allSessions;
      synchronized (lock) {
        allSessions = sessions.getAllSessions();
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
      if (future != null) {
        future.cancel(false);
      }
    }
  }

  private static final VRpc NOOP_CALL =
      new VRpc() {
        @Override
        public void start(Object req, VRpcCallContext ctx, VRpcListener listener) {}

        @Override
        public void cancel(@Nullable String message, @Nullable Throwable cause) {}

        @Override
        public void requestNext() {}
      };
}
