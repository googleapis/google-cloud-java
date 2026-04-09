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
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

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

  /*
   * This lock should be mostly uncontended - all access should be naturally interleaved. Contention
   * can only really happen when an unsolicited gRPC control message (ie GOAWAY) arrives at the same
   * time as newCall or cancel.
   * TODO: Contention will increase when multiplexing is implemented.
   */
  private final Object lock = new Object();

  private final Clock clock;

  private final SessionTracer tracer;
  private final DebugTagTracer debugTagTracer;

  private final SessionInfo info;

  @GuardedBy("lock")
  private final SessionStream stream;

  @GuardedBy("lock")
  private SessionState state = SessionState.NEW;

  @GuardedBy("lock")
  private Instant lastStateChangedAt;

  private Listener sessionListener;

  private volatile OpenParams openParams;

  private volatile boolean openParamsUpdated;

  @Nullable private CloseSessionRequest closeReason = null;

  @GuardedBy("lock")
  private long nextRpcId = 1;

  // TODO: replace with a map when implementing multiplexing
  @GuardedBy("lock")
  private VRpcImpl<?, ?, ?> currentRpc = null;

  @GuardedBy("lock")
  private VRpcResult currentCancel = null;

  private SessionParametersResponse sessionParameters = DEFAULT_SESSION_PARAMS;
  private Duration heartbeatInterval =
      Duration.ofMillis(Durations.toMillis(sessionParameters.getKeepAlive()));

  private volatile Instant nextHeartbeat;

  public SessionImpl(
      Metrics metrics, SessionPoolInfo poolInfo, long sessionNum, SessionStream stream) {
    this(metrics, Clock.systemUTC(), poolInfo, sessionNum, stream);
  }

  SessionImpl(
      Metrics metrics,
      Clock clock,
      SessionPoolInfo poolInfo,
      long sessionNum,
      SessionStream stream) {
    this.clock = clock;
    this.info = SessionInfo.create(poolInfo, sessionNum);
    this.stream = stream;
    this.tracer = metrics.newSessionTracer(poolInfo);
    this.debugTagTracer = metrics.getDebugTagTracer();
    this.nextHeartbeat = clock.instant().plus(FUTURE_TIME);
    this.openParamsUpdated = false;
  }

  @Override
  public SessionState getState() {
    synchronized (lock) {
      return state;
    }
  }

  @Override
  public Instant getLastStateChange() {
    synchronized (lock) {
      return lastStateChangedAt;
    }
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
    // This lock might not be necessary, its populated once on a gRPC callback which should
    // establish a happens before relationship. However access to the underlying stream is guarded
    // with errorprone, so sync block is required to get around the lint.
    // TODO: consider removing the sync block
    synchronized (lock) {
      return stream.getPeerInfo();
    }
  }

  @Override
  public String getLogName() {
    return info.getLogName();
  }

  @Override
  public void forceClose(CloseSessionRequest closeReason) {
    synchronized (lock) {
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
    }
  }

  @Override
  public void start(OpenSessionRequest req, Metadata headers, Listener sessionListener) {
    synchronized (lock) {
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
              dispatchResponseMessage(message);
            }

            @Override
            public void onClose(Status status, Metadata trailers) {
              dispatchStreamClosed(status, trailers);
            }
          },
          headers);

      stream.sendMessage(wrappedReq);
    }
  }

  @Override
  public void close(CloseSessionRequest req) {
    logger.fine(String.format("Closing session %s for reason: %s", info.getLogName(), req));

    synchronized (lock) {
      // Throw an exception because this is a bug and we dont have a listener
      debugTagTracer.checkPrecondition(
          state != SessionState.NEW,
          "session_close_wrong_state",
          "Session error: Caller tried to close session %s before starting it with the reason: %s",
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
    }
  }

  /** Wraps the flow of closing a session. */
  @GuardedBy("lock")
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

    synchronized (lock) {
      debugTagTracer.checkPrecondition(
          state != SessionState.NEW,
          "session_new_call_wrong_state",
          "Session error: newCall called before start");

      long rpcId = nextRpcId;
      nextRpcId = Math.incrementExact(nextRpcId);
      return new VRpcImpl<>(this, descriptor, rpcId, stream.getPeerInfo());
    }
  }

  @Override
  public Status startRpc(VRpcImpl<?, ?, ?> rpc, VirtualRpcRequest payload) {
    // start monitoring for heartbeat when the vrpc is started
    this.nextHeartbeat = clock.instant().plus(heartbeatInterval);

    synchronized (lock) {
      if (currentRpc != null) {
        return Status.INTERNAL.withDescription(
            "Session error: RPC multiplexing is not yet supported");
      }
      if (state != SessionState.READY) {
        return Status.INTERNAL.withDescription(
            "Session error: Session was not ready, state = " + state);
      }

      this.currentRpc = rpc;
      stream.sendMessage(SessionRequest.newBuilder().setVirtualRpc(payload).build());
      return Status.OK;
    }
  }

  @Override
  public void cancelRpc(long rpcId, @Nullable String message, @Nullable Throwable cause) {
    synchronized (lock) {
      if (currentRpc != null && rpcId == currentRpc.rpcId) {
        currentCancel =
            VRpcResult.createRejectedError(
                Status.CANCELLED.withDescription(message).withCause(cause));
      }
      // do nothing if the rpc is already finished
    }
  }

  // region SessionStream event handlers
  private void dispatchResponseMessage(SessionResponse message) {
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
    logger.fine(String.format("%s Session is ready", info.getLogName()));

    PeerInfo localPeerInfo;

    synchronized (lock) {
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
      localPeerInfo = stream.getPeerInfo();
      updateState(SessionState.READY);
    }
    tracer.onOpen(localPeerInfo);
    sessionListener.onReady(openSession);
  }

  private void handleSessionParamsResponse(SessionParametersResponse resp) {
    synchronized (lock) {
      if (state.phase >= SessionState.CLOSING.phase) {
        logger.fine(
            String.format("Stream was already %s when session params were received", state));
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
  }

  private void handleVRpcResponse(VirtualRpcResponse vrpc) {
    // TODO: when stream is supported this should be updated to the next expected time instead of
    // session life time
    this.nextHeartbeat = clock.instant().plus(FUTURE_TIME);
    VRpcImpl<?, ?, ?> localRpc;
    VRpcResult localCancel;

    boolean needsClose;

    synchronized (lock) {
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
      localCancel = currentCancel;
      currentCancel = null;
      localRpc = currentRpc;
      // TODO: handle multiplexing
      currentRpc = null;
      needsClose = (state == SessionState.CLOSING);
    }

    if (localCancel != null) {
      tracer.onVRpcClose(localCancel.getStatus().getCode());
      localRpc.handleError(localCancel);
    } else {
      tracer.onVRpcClose(Status.OK.getCode());
      localRpc.handleResponse(vrpc);
    }
    if (needsClose) {
      synchronized (lock) {
        if (state == SessionState.CLOSING) {
          startGracefulClose();
        }
      }
    }
  }

  private void handleHeartBeatResponse(HeartbeatResponse ignored) {
    this.nextHeartbeat = clock.instant().plus(heartbeatInterval);
  }

  private void handleSessionRefreshConfigResponse(SessionRefreshConfig config) {
    synchronized (lock) {
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
  }

  private void handleVRpcErrorResponse(ErrorResponse error) {
    // Skips the heartbeat check when there's no active vrpc on the session
    this.nextHeartbeat = clock.instant().plus(FUTURE_TIME);

    VRpcImpl<?, ?, ?> localRpc;
    boolean needsClose;
    VRpcResult localCancel;

    synchronized (lock) {
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
      localCancel = currentCancel;
      currentCancel = null;
      localRpc = currentRpc;
      currentRpc = null;
      needsClose = (state == SessionState.CLOSING);
    }

    if (localCancel != null) {
      tracer.onVRpcClose(localCancel.getStatus().getCode());
      localRpc.handleError(localCancel);
    } else {
      tracer.onVRpcClose(Status.fromCodeValue(error.getStatus().getCode()).getCode());
      localRpc.handleError(VRpcResult.createServerError(error));
    }
    if (needsClose) {
      synchronized (lock) {
        if (state == SessionState.CLOSING) {
          startGracefulClose();
        }
      }
    }
  }

  private void handleGoAwayResponse(GoAwayResponse goAwayResponse) {
    synchronized (lock) {
      if (state.phase >= SessionState.CLOSING.phase) {
        debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_go_away_ignored");
        logger.warning(
            String.format(
                "Session error: %s Ignoring goaway because session is %s",
                info.getLogName(), state));
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
    }
    sessionListener.onGoAway(goAwayResponse);
  }

  private void handleUnknownResponseMessage(SessionResponse message) {
    debugTagTracer.record(TelemetryConfiguration.Level.WARN, "session_unknown_response");
    logger.warning(String.format("%s Unknown control message: %s", info.getLogName(), message));
  }

  private void dispatchStreamClosed(Status status, Metadata trailers) {
    SessionState prevState;
    VRpcImpl<?, ?, ?> localVRpc;

    PeerInfo localPeerInfo;
    synchronized (lock) {
      prevState = state;

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

      localVRpc = currentRpc;
      localPeerInfo = stream.getPeerInfo();
      currentRpc = null;
      updateState(SessionState.CLOSED);
    }

    if (localVRpc != null) {
      try {
        localVRpc.handleSessionClose(VRpcResult.createRemoteTransportError(status, trailers));
      } catch (Throwable t) {
        logger.log(
            Level.WARNING,
            String.format(
                "Session error: %s Unhandled exception while notifying vRpc of session closure"
                    + " status %s",
                info.getLogName(), status),
            t);
      }
      tracer.onVRpcClose(Status.UNAVAILABLE.getCode());
    }
    tracer.onClose(localPeerInfo, closeReason.getReason(), status);
    sessionListener.onClose(prevState, status, trailers);
  }

  @GuardedBy("lock")
  private void updateState(SessionState newState) {
    this.state = newState;
    this.lastStateChangedAt = clock.instant();
  }

  private static String formatPeerInfo(PeerInfo peerInfo) {
    if (peerInfo == null) {
      return "null";
    }
    return TextFormat.printer().emittingSingleLine(true).printToString(peerInfo);
  }
  // endregion
}
