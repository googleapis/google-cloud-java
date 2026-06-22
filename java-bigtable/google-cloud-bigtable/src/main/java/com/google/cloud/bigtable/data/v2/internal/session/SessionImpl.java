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

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.CloseSessionRequest.CloseSessionReason;
import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.HeartbeatResponse;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.SessionParametersResponse;
import com.google.bigtable.v2.SessionRefreshConfig;
import com.google.bigtable.v2.SessionRequest;
import com.google.bigtable.v2.SessionResponse;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.bigtable.v2.VirtualRpcRequest;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.channels.SessionStream;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.SessionTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcImpl.VRpcSessionApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import com.google.protobuf.util.Durations;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Wraps a Bidi ClientCall and layers session semantics on top. */
@VisibleForTesting
public class SessionImpl implements Session, VRpcSessionApi {
  private static final Logger DEFAULT_LOGGER = Logger.getLogger(SessionImpl.class.getName());
  private Logger logger = DEFAULT_LOGGER;

  private static final SessionParametersResponse DEFAULT_SESSION_PARAMS =
      SessionParametersResponse.newBuilder().setKeepAlive(Durations.fromMillis(100)).build();

  static final Duration HEARTBEAT_CHECK_INTERVAL =
      Duration.ofMillis(Durations.toMillis(DEFAULT_SESSION_PARAMS.getKeepAlive()));

  @VisibleForTesting
  // A time in the future to skip heartbeat checks when there's no active vRPCs on the session
  static final Duration FUTURE_TIME = Duration.ofMinutes(30);

  private static final CloseSessionRequest MISSED_HEARTBEAT_CLOSE_REQUEST =
      CloseSessionRequest.newBuilder()
          .setReason(CloseSessionReason.CLOSE_SESSION_REASON_MISSED_HEARTBEAT)
          .setDescription("missed heartbeat")
          .build();

  private final Clock clock;
  private final BigtableTimer timer;
  // Serializes all session state mutations. Stream callbacks and the heartbeat tick dispatch
  // onto it; every handler below runs inside a syncContext task.
  private final SynchronizationContext sessionSyncContext;

  private final SessionTracer tracer;
  private final DebugTagTracer debugTagTracer;

  private final SessionInfo info;

  private final SessionStream stream;

  private volatile SessionState state = SessionState.NEW;

  private volatile Instant lastStateChangedAt;

  // All fields below are owned by sessionSyncContext: every writer runs inside a
  // sessionSyncContext task, and the in-class readers do too (handlers, scheduled heartbeat
  // tick). They lost their volatile / lock guards when synchronized(lock) was removed;
  // SyncContext serialization is what makes plain reads/writes safe.
  //
  // External callers of getOpenParams / isOpenParamsUpdated / getNextHeartbeat must therefore
  // either run on sessionSyncContext themselves (e.g. via a Session.Listener callback, which is
  // dispatched from inside the context) or accept a possibly-stale snapshot. There are no
  // off-context production readers today.
  private Listener sessionListener;

  private OpenParams openParams;

  private boolean openParamsUpdated;

  @Nullable private CloseSessionRequest closeReason = null;

  private final AtomicLong nextRpcId = new AtomicLong(1);

  // TODO: replace with a map when implementing multiplexing
  private VRpcImpl<?, ?, ?> currentRpc = null;

  private VRpcResult currentCancel = null;

  private SessionParametersResponse sessionParameters = DEFAULT_SESSION_PARAMS;

  private Duration heartbeatInterval =
      Duration.ofMillis(Durations.toMillis(sessionParameters.getKeepAlive()));

  private Instant nextHeartbeat;

  // Handle for the in-flight heartbeat tick (one outstanding at a time). Cancelled on terminal
  // transitions so the wheel doesn't carry a no-op entry until the next fire.
  @Nullable private BigtableTimer.Timeout heartbeatTimeout;

  // Set by the global SyncContext handler when an uncaught exception triggers an abort. Read on
  // re-entry to break out instead of looping. Only accessed inside sessionSyncContext.
  private boolean isAborting = false;

  public SessionImpl(
      Metrics metrics,
      SessionPoolInfo poolInfo,
      long sessionNum,
      SessionStream stream,
      BigtableTimer timer) {
    this(metrics, Clock.systemUTC(), poolInfo, sessionNum, stream, timer);
  }

  SessionImpl(
      Metrics metrics,
      Clock clock,
      SessionPoolInfo poolInfo,
      long sessionNum,
      SessionStream stream,
      BigtableTimer timer) {
    this.clock = clock;
    this.timer = timer;
    this.info = SessionInfo.create(poolInfo, sessionNum);
    this.stream = stream;
    this.tracer = metrics.newSessionTracer(poolInfo);
    this.debugTagTracer = metrics.getDebugTagTracer();
    this.nextHeartbeat = clock.instant().plus(FUTURE_TIME);
    this.openParamsUpdated = false;
    // On uncaught exception, drive the session through a clean terminal-close path so the pool
    // and the in-flight vRpc are always notified. notifyTerminalClose has local guards, and
    // isAborting prevents recursion if the abort path itself throws.
    this.sessionSyncContext =
        new SynchronizationContext((thread, e) -> abortFromUncaughtException(e));
  }

  private void abortFromUncaughtException(Throwable e) {
    if (isAborting) {
      logger.log(
          Level.WARNING,
          String.format(
              "Session error: %s Secondary uncaught exception during abort, ignoring",
              info.getLogName()),
          e);
      return;
    }
    isAborting = true;

    logger.log(
        Level.SEVERE,
        String.format(
            "Session error: %s Uncaught exception in session SyncContext in state %s, PeerInfo:"
                + " %s — aborting session",
            info.getLogName(), state, formatPeerInfo(safeGetPeerInfo())),
        e);

    if (state == SessionState.CLOSED) {
      return;
    }

    // Always overwrite closeReason: the abort is what actually happened, not whatever clean close
    // we may have been attempting. Fold the prior reason into the description for forensics so
    // downstream metrics (which bucket by reason) attribute this to ERROR rather than the
    // interrupted close.
    String prevDesc =
        (closeReason != null)
            ? " (was closing for: "
                + closeReason.getReason()
                + " — "
                + closeReason.getDescription()
                + ")"
            : "";
    closeReason =
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_ERROR)
            .setDescription("Uncaught exception in session SyncContext: " + e + prevDesc)
            .build();

    VRpcImpl<?, ?, ?> localRpc = currentRpc;
    currentRpc = null;
    SessionState prevState = state;
    updateState(SessionState.CLOSED);

    // Defensively tell the transport we're done. Safe on un-started streams via the try/catch.
    try {
      stream.forceClose("Session aborted due to uncaught exception", e);
    } catch (Throwable t) {
      logger.log(
          Level.WARNING,
          String.format(
              "Session error: %s Exception while force-closing stream during abort",
              info.getLogName()),
          t);
    }

    notifyTerminalClose(
        Status.INTERNAL.withDescription("Session aborted").withCause(e),
        new Metadata(),
        localRpc,
        prevState);
  }

  @Override
  public SessionState getState() {
    return state;
  }

  @Override
  public Instant getLastStateChange() {
    return lastStateChangedAt;
  }

  @Override
  public OpenParams getOpenParams() {
    return openParams;
  }

  @Override
  public boolean isOpenParamsUpdated() {
    return openParamsUpdated;
  }

  @Override
  public Instant getNextHeartbeat() {
    return nextHeartbeat;
  }

  @Override
  public PeerInfo getPeerInfo() {
    return stream.getPeerInfo();
  }

  @Override
  public String getLogName() {
    return info.getLogName();
  }

  @Override
  public void forceClose(CloseSessionRequest closeReason) {
    sessionSyncContext.execute(
        () -> {
          debugTagTracer.checkPrecondition(
              state != SessionState.NEW,
              "session_force_close_wrong_state",
              "Tried to forceClose an unstarted session %s in state %s",
              info.getLogName(),
              state);

          if (state == SessionState.CLOSED) {
            return;
          }

          updateState(SessionState.WAIT_SERVER_CLOSE);
          this.closeReason = closeReason;

          // Not sending the CloseSessionRequest because cancel() will just drop it
          stream.forceClose(closeReason.getDescription(), null);
          // Listeners will be notified by dispatchStreamClosed
        });
  }

  @Override
  public void start(OpenSessionRequest req, Metadata headers, Listener sessionListener) {
    sessionSyncContext.execute(
        () -> {
          debugTagTracer.checkPrecondition(
              state == SessionState.NEW,
              "session_start_wrong_state",
              "Tried to start a started session, current state: %s",
              state);

          logger.fine(String.format("Starting session %s", info.getLogName()));
          tracer.onStart();

          updateState(SessionState.STARTING);
          openParams = OpenParams.create(headers, req);
          this.sessionListener = sessionListener;

          SessionRequest wrappedReq = SessionRequest.newBuilder().setOpenSession(req).build();
          stream.start(
              new SessionStream.Listener() {
                @Override
                public void onBeforeSessionStart(PeerInfo peerInfo) {}

                @Override
                public void onMessage(SessionResponse message) {
                  sessionSyncContext.execute(() -> dispatchResponseMessage(message));
                }

                @Override
                public void onClose(Status status, Metadata trailers) {
                  sessionSyncContext.execute(() -> dispatchStreamClosed(status, trailers));
                }
              },
              headers);

          stream.sendMessage(wrappedReq);
        });
  }

  @Override
  public void close(CloseSessionRequest req) {
    logger.fine(String.format("Closing session %s for reason: %s", info.getLogName(), req));

    sessionSyncContext.execute(
        () -> {
          // Throw an exception because this is a bug and we dont have a listener
          debugTagTracer.checkPrecondition(
              state != SessionState.NEW,
              "session_close_wrong_state",
              "Session error: Caller tried to close session %s before starting it with the reason:"
                  + " %s",
              info.getLogName(),
              req);

          // Multiple close is a no-op
          if (state.phase >= SessionState.CLOSING.phase) {
            logger.fine(
                String.format(
                    "Session error: Caller tried to close a session %s that is %s for reason: %s",
                    info.getLogName(), state, req));
            return;
          }

          closeReason = req;
          updateState(SessionState.CLOSING);

          if (currentRpc == null) {
            startGracefulClose();
          }
        });
  }

  /** Wraps the flow of closing a session. */
  private void startGracefulClose() {
    debugTagTracer.checkPrecondition(
        state == SessionState.CLOSING,
        "session_graceful_close_wrong_state",
        "Session error: %s tried to actuate session closing when not in the correct state. State:"
            + " %s",
        info.getLogName(),
        state);

    // TODO: send metrics
    updateState(SessionState.WAIT_SERVER_CLOSE);

    // Should never happen
    if (closeReason == null) {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_close_no_reason");
      logger.log(
          Level.WARNING,
          String.format("%s graceful shutdown started without a reason", info.getLogName()),
          new IllegalStateException("Tried to close a session without a reason"));
      // Synthesize a reason so that we let the server know of the problem instead
      closeReason =
          CloseSessionRequest.newBuilder()
              .setReason(CloseSessionReason.CLOSE_SESSION_REASON_ERROR)
              .setDescription("Started graceful shutdown close without a reason set")
              .build();
    }
    stream.sendMessage(SessionRequest.newBuilder().setCloseSession(closeReason).build());
    // TODO: remove this after the server is updated
    stream.halfClose();
  }

  @Override
  public <OpenReqT extends Message, ReqT extends Message, RespT extends Message>
      VRpc<ReqT, RespT> newCall(VRpcDescriptor<OpenReqT, ReqT, RespT> descriptor) {
    debugTagTracer.checkPrecondition(
        descriptor.getSessionDescriptor().getType() == info.getPoolInfo().getType(),
        "session_new_call_wrong_type",
        "wrong VRpc descriptor type");

    debugTagTracer.checkPrecondition(
        state != SessionState.NEW,
        "session_new_call_wrong_state",
        "Session error: newCall called before start");

    long rpcId = nextRpcId.getAndIncrement();
    return new VRpcImpl<>(this, descriptor, rpcId, stream.getPeerInfo(), debugTagTracer);
  }

  @Override
  public void startRpc(VRpcImpl<?, ?, ?> rpc, VirtualRpcRequest payload) {
    sessionSyncContext.execute(
        () -> {
          if (currentRpc != null) {
            rpc.handleError(
                VRpcResult.createUncommitedError(
                    Status.INTERNAL.withDescription(
                        "Session error: RPC multiplexing is not yet supported")));
            return;
          }
          if (state != SessionState.READY) {
            rpc.handleError(
                VRpcResult.createUncommitedError(
                    Status.INTERNAL.withDescription(
                        "Session error: Session was not ready, state = " + state)));
            return;
          }

          this.currentRpc = rpc;
          stream.sendMessage(SessionRequest.newBuilder().setVirtualRpc(payload).build());
          this.nextHeartbeat = clock.instant().plus(heartbeatInterval);
          // Arm the heartbeat check only while a vRPC is in flight. handleVRpcResponse /
          // handleVRpcErrorResponse cancel it on completion; updateState cancels on shutdown.
          scheduleHeartbeatCheck();
        });
  }

  @Override
  public void cancelRpc(long rpcId, @Nullable String message, @Nullable Throwable cause) {
    sessionSyncContext.execute(
        () -> {
          if (currentRpc != null && rpcId == currentRpc.rpcId) {
            currentCancel =
                VRpcResult.createRejectedError(
                    Status.CANCELLED.withDescription(message).withCause(cause));
          }
          // do nothing if the rpc is already finished
        });
  }

  private void scheduleHeartbeatCheck() {
    heartbeatTimeout =
        timer.newTimeout(
            () -> sessionSyncContext.execute(this::checkHeartbeat),
            HEARTBEAT_CHECK_INTERVAL.toMillis(),
            TimeUnit.MILLISECONDS);
  }

  private void cancelHeartbeatTimeout() {
    if (heartbeatTimeout != null) {
      heartbeatTimeout.cancel();
      heartbeatTimeout = null;
    }
  }

  // Runs on sessionSyncContext (dispatched from the wheel-timer tick body). Checks if the
  // heartbeat deadline has passed and force-closes on miss; otherwise re-schedules.
  private void checkHeartbeat() {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    if (state.phase >= SessionState.WAIT_SERVER_CLOSE.phase) {
      return;
    }
    if (clock.instant().isAfter(nextHeartbeat)) {
      logger.warning(
          String.format("Missed heartbeat for %s, forcing session close", info.getLogName()));
      forceClose(MISSED_HEARTBEAT_CLOSE_REQUEST);
      return;
    }
    scheduleHeartbeatCheck();
  }

  // region SessionStream event handlers
  private void dispatchResponseMessage(SessionResponse message) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    switch (message.getPayloadCase()) {
      case OPEN_SESSION:
        handleOpenSessionResponse(message.getOpenSession());
        break;
      case SESSION_PARAMETERS:
        handleSessionParamsResponse(message.getSessionParameters());
        break;
      case GO_AWAY:
        handleGoAwayResponse(message.getGoAway());
        break;
      case VIRTUAL_RPC:
        handleVRpcResponse(message.getVirtualRpc());
        break;
      case HEARTBEAT:
        handleHeartBeatResponse(message.getHeartbeat());
        break;
      case SESSION_REFRESH_CONFIG:
        handleSessionRefreshConfigResponse(message.getSessionRefreshConfig());
        break;
      case ERROR:
        handleVRpcErrorResponse(message.getError());
        break;
      case PAYLOAD_NOT_SET:
      default:
        handleUnknownResponseMessage(message);
    }
  }

  private void handleOpenSessionResponse(OpenSessionResponse openSession) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    logger.fine(String.format("%s Session is ready", info.getLogName()));

    debugTagTracer.checkPrecondition(
        state != SessionState.NEW,
        "session_open_wrong_state",
        "Got session open response before session started");
    debugTagTracer.checkPrecondition(
        state != SessionState.CLOSED,
        "session_open_wrong_state",
        "Got session open response after session was closed");

    if (state != SessionState.STARTING) {
      logger.fine(String.format("Stream was already %s when session open was received", state));
      return;
    }
    PeerInfo localPeerInfo = stream.getPeerInfo();
    updateState(SessionState.READY);
    tracer.onOpen(localPeerInfo);
    sessionListener.onReady(openSession);
  }

  private void handleSessionParamsResponse(SessionParametersResponse resp) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    if (state.phase >= SessionState.CLOSING.phase) {
      logger.fine(String.format("Stream was already %s when session params were received", state));
      return;
    }

    if (!sessionParameters.equals(resp)) {
      this.sessionParameters = resp;
      this.heartbeatInterval =
          Duration.ofMillis(Durations.toMillis(sessionParameters.getKeepAlive()));
      logger.log(
          Level.CONFIG,
          () ->
              String.format(
                  "%s session params changed: %s",
                  info.getLogName(),
                  TextFormat.printer().emittingSingleLine(true).printToString(resp)));
    }
  }

  private void handleVRpcResponse(VirtualRpcResponse vrpc) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    // TODO: when stream is supported this should be updated to the next expected time instead of
    // session life time
    this.nextHeartbeat = clock.instant().plus(FUTURE_TIME);

    if (state.phase > SessionState.CLOSING.phase) {
      debugTagTracer.record(
          TelemetryConfiguration.Level.WARN, "session_closed_discard_vrpc_response");
      logger.warning(
          String.format(
              "%s Discarding vRPC error because session is past the CLOSING phase with the"
                  + " reason: %s",
              info.getLogName(), closeReason));
      return;
    }

    debugTagTracer.checkPrecondition(
        state == SessionState.READY || state == SessionState.CLOSING,
        "session_vrpc_response_wrong_state",
        "Unexpected vRPC response when session is %s",
        state);
    debugTagTracer.checkPrecondition(
        currentRpc != null, "session_vrpc_null", "Got vRPC response but current vRPC is unset");
    debugTagTracer.checkPrecondition(
        currentRpc.rpcId == vrpc.getRpcId(),
        "session_vrpc_id_mismatch",
        "Got vRPC response for the wrong vRPC: expect: %s, actual: %s",
        currentRpc.rpcId,
        vrpc.getRpcId());

    // reset state of the current rpc
    VRpcImpl<?, ?, ?> rpc = currentRpc;
    VRpcResult cancel = currentCancel;
    // TODO: handle multiplexing
    currentRpc = null;
    currentCancel = null;
    // No active vRPC means no useful heartbeat deadline; drop the in-flight tick.
    cancelHeartbeatTimeout();

    if (cancel != null) {
      tracer.onVRpcClose(cancel.getStatus().getCode());
      rpc.handleError(cancel);
    } else {
      tracer.onVRpcClose(Status.OK.getCode());
      rpc.handleResponse(vrpc);
    }
    if (state == SessionState.CLOSING) {
      startGracefulClose();
    }
  }

  private void handleHeartBeatResponse(HeartbeatResponse ignored) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    this.nextHeartbeat = clock.instant().plus(heartbeatInterval);
  }

  private void handleSessionRefreshConfigResponse(SessionRefreshConfig config) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    Metadata grpcMetadata = new Metadata();
    config
        .getMetadataList()
        .forEach(
            entry ->
                grpcMetadata.put(
                    Metadata.Key.of(entry.getKey(), Metadata.ASCII_STRING_MARSHALLER),
                    entry.getValue().toStringUtf8()));
    openParams = OpenParams.create(grpcMetadata, config.getOptimizedOpenRequest());
    openParamsUpdated = true;
  }

  private void handleVRpcErrorResponse(ErrorResponse error) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    // Skips the heartbeat check when there's no active vrpc on the session
    this.nextHeartbeat = clock.instant().plus(FUTURE_TIME);

    if (state.phase > SessionState.CLOSING.phase) {
      debugTagTracer.record(
          TelemetryConfiguration.Level.WARN, "session_closed_discard_vrpc_response");
      logger.warning(
          String.format(
              "%s Discarding vRPC error because session is past the CLOSING phase with the"
                  + " reason: %s, error was: %s",
              info.getLogName(), closeReason, error));
      return;
    }

    debugTagTracer.checkPrecondition(
        state == SessionState.READY || state == SessionState.CLOSING,
        "session_vrpc_response_wrong_state",
        "Unexpected vRPC response when session is %s",
        state);

    debugTagTracer.checkPrecondition(
        currentRpc != null, "session_vrpc_null", "Got vRPC response but current vRPC is unset");
    debugTagTracer.checkPrecondition(
        currentRpc.rpcId == error.getRpcId(),
        "session_vrpc_id_mismatch",
        "Got vRPC response for the wrong vRPC: expect: %s, actual: %s",
        currentRpc.rpcId,
        error.getRpcId());

    // reset the state of the current rpc
    VRpcImpl<?, ?, ?> rpc = currentRpc;
    VRpcResult cancel = currentCancel;
    currentRpc = null;
    currentCancel = null;
    // No active vRPC means no useful heartbeat deadline; drop the in-flight tick.
    cancelHeartbeatTimeout();

    if (cancel != null) {
      tracer.onVRpcClose(cancel.getStatus().getCode());
      rpc.handleError(cancel);
    } else {
      tracer.onVRpcClose(Status.fromCodeValue(error.getStatus().getCode()).getCode());
      rpc.handleError(VRpcResult.createServerError(error));
    }
    if (state == SessionState.CLOSING) {
      startGracefulClose();
    }
  }

  private void handleGoAwayResponse(GoAwayResponse goAwayResponse) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    if (state.phase >= SessionState.CLOSING.phase) {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_go_away_ignored");
      logger.warning(
          String.format(
              "Session error: %s Ignoring goaway because session is %s", info.getLogName(), state));
      return;
    }

    debugTagTracer.checkPrecondition(
        state.phase >= SessionState.STARTING.phase,
        "session_go_away_wrong_state",
        "Unexpected goaway when session is %s",
        state);

    updateState(SessionState.CLOSING);
    closeReason =
        CloseSessionRequest.newBuilder()
            .setReason(CloseSessionReason.CLOSE_SESSION_REASON_GOAWAY)
            .setDescription(
                "Server sent GO_AWAY_" + goAwayResponse.getReason().toUpperCase(Locale.ENGLISH))
            .build();
    if (currentRpc == null) {
      startGracefulClose();
    }
    sessionListener.onGoAway(goAwayResponse);
  }

  private void handleUnknownResponseMessage(SessionResponse message) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_unknown_response");
    logger.warning(String.format("%s Unknown control message: %s", info.getLogName(), message));
  }

  private void dispatchStreamClosed(Status status, Metadata trailers) {
    sessionSyncContext.throwIfNotInThisSynchronizationContext();
    SessionState prevState = state;

    if (!status.isOk()) {
      String augmentedDescription =
          Optional.ofNullable(status.getDescription()).map(d -> d + ". ").orElse("")
              + "PeerInfo: "
              + formatPeerInfo(getPeerInfo());

      status = status.withDescription(augmentedDescription);
    }

    if (state == SessionState.WAIT_SERVER_CLOSE) {
      logger.fine(String.format("%s closed normally with status %s", info.getLogName(), status));
    } else {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_abnormal_close");
      // Unexpected path
      String msg =
          String.format(
              "Session error: %s session closed unexpectedly in state %s. Status: %s",
              info.getLogName(), state, status);
      logger.warning(msg);

      if (state == SessionState.CLOSED) {
        return;
      }

      closeReason =
          CloseSessionRequest.newBuilder()
              .setReason(CloseSessionReason.CLOSE_SESSION_REASON_ERROR)
              .setDescription("Unexpected session close with status: " + status.getCode())
              .build();
    }

    VRpcImpl<?, ?, ?> localVRpc = currentRpc;
    currentRpc = null;
    updateState(SessionState.CLOSED);

    notifyTerminalClose(status, trailers, localVRpc, prevState);
  }

  /**
   * Fan out terminal notifications to the in-flight vRpc, tracer, and session listener with local
   * guards so a throw in one notification does not suppress the others.
   *
   * <p>Caller contract: must have already transitioned to {@link SessionState#CLOSED} and captured
   * and cleared {@code currentRpc}. Callers should also set {@code closeReason}; if missing we
   * synthesize a fallback here rather than throw, since throwing from this fan-out aborts the
   * remaining notifications and (because the state is already CLOSED) defeats the
   * sessionSyncContext uncaught handler's cleanup.
   */
  private void notifyTerminalClose(
      Status status,
      Metadata trailers,
      @Nullable VRpcImpl<?, ?, ?> localRpc,
      SessionState prevState) {
    // Should never happen — matches the synthesizer in startGracefulClose.
    if (closeReason == null) {
      debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_close_no_reason");
      logger.log(
          Level.WARNING,
          String.format(
              "%s notifyTerminalClose reached without a closeReason; status=%s",
              info.getLogName(), status),
          new IllegalStateException("notifyTerminalClose without closeReason"));
      closeReason =
          CloseSessionRequest.newBuilder()
              .setReason(CloseSessionReason.CLOSE_SESSION_REASON_ERROR)
              .setDescription("notifyTerminalClose reached without closeReason; status=" + status)
              .build();
    }
    if (localRpc != null) {
      try {
        localRpc.handleSessionClose(VRpcResult.createRemoteTransportError(status, trailers));
      } catch (Throwable t) {
        logger.log(
            Level.WARNING,
            String.format(
                "Session error: %s Unhandled exception while notifying vRpc of session closure"
                    + " status %s",
                info.getLogName(), status),
            t);
      }
      try {
        tracer.onVRpcClose(Status.UNAVAILABLE.getCode());
      } catch (Throwable t) {
        logger.log(
            Level.WARNING,
            String.format(
                "Session error: %s Unhandled exception in tracer.onVRpcClose", info.getLogName()),
            t);
      }
    }
    try {
      tracer.onClose(safeGetPeerInfo(), closeReason.getReason(), status);
    } catch (Throwable t) {
      logger.log(
          Level.WARNING,
          String.format(
              "Session error: %s Unhandled exception in tracer.onClose", info.getLogName()),
          t);
    }
    if (sessionListener != null) {
      try {
        sessionListener.onClose(prevState, status, trailers);
      } catch (Throwable t) {
        logger.log(
            Level.WARNING,
            String.format(
                "Session error: %s Unhandled exception in sessionListener.onClose",
                info.getLogName()),
            t);
      }
    }
  }

  private PeerInfo safeGetPeerInfo() {
    try {
      return stream.getPeerInfo();
    } catch (Throwable t) {
      return SessionStream.DISCONNECTED_PEER_INFO;
    }
  }

  private void updateState(SessionState newState) {
    this.state = newState;
    this.lastStateChangedAt = clock.instant();
    // Once we're past READY, no further heartbeat checks are useful: checkHeartbeat short-circuits
    // on state.phase >= WAIT_SERVER_CLOSE. Cancel any pending tick to keep the wheel clean during
    // session churn.
    if (newState.phase >= SessionState.WAIT_SERVER_CLOSE.phase) {
      cancelHeartbeatTimeout();
    }
  }

  private static String formatPeerInfo(PeerInfo peerInfo) {
    if (peerInfo == null) {
      return "null";
    }
    return TextFormat.printer().emittingSingleLine(true).printToString(peerInfo);
  }
  // endregion
}
