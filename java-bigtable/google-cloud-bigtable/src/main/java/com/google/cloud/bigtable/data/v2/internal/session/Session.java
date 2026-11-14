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

import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.GoAwayResponse;
import com.google.bigtable.v2.OpenSessionRequest;
import com.google.bigtable.v2.OpenSessionResponse;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.protobuf.Message;
import io.grpc.Metadata;
import io.grpc.Status;
import java.time.Instant;

/**
 * A Bigtable abstraction over a bidirectional {@link io.grpc.ClientCall} to treat it as a stateful
 * vRPC transport.
 */
public interface Session {
  /**
   * State transitions of Session, will happen in defined order:
   *
   * <ul>
   *   <li>{@link #NEW}: Initial state before {@link #start} is called.
   *   <li>{@link #STARTING}: Open handshake sent; bounded by {@code OPEN_SESSION_TIMEOUT}.
   *   <li>{@link #READY}: Open handshake completed; ready to serve vRPCs.
   *   <li>{@link #CLOSING}: Graceful close initiated (via {@link #close} or server {@code
   *       GoAwayResponse}) while an in-flight vRPC (including a client-cancelled one) is still on
   *       the wire waiting for the server's response before {@code CloseSessionRequest} can be
   *       sent. Bounded by server heartbeats ({@code checkHeartbeat}) and the server-enforced
   *       {@code VirtualRpcRequest.deadline}.
   *   <li>{@link #WAIT_SERVER_CLOSE}: No vRPC is in flight on the wire (so server heartbeats stop)
   *       and {@code CloseSessionRequest} + {@code halfClose()} have been sent; waiting for the
   *       server to close the stream. Bounded by {@code CLOSE_SESSION_TIMEOUT}.
   *   <li>{@link #CLOSED}: Terminal state; underlying stream is closed.
   * </ul>
   */
  enum SessionState {
    NEW(0),
    STARTING(1),
    READY(2),
    CLOSING(3),
    WAIT_SERVER_CLOSE(4),
    CLOSED(5);

    final int phase;

    SessionState(int phase) {
      this.phase = phase;
    }
  }

  @AutoValue
  abstract class OpenParams {
    abstract Metadata metadata();

    abstract OpenSessionRequest request();

    static OpenParams create(Metadata metadata, OpenSessionRequest request) {
      return new AutoValue_Session_OpenParams(metadata, request);
    }

    OpenParams withResetConsecutiveAttempt() {
      return new AutoValue_Session_OpenParams(
          metadata(), request().toBuilder().setConsecutiveFailedConnectionAttempts(0).build());
    }

    OpenParams withIncrementedAttempts() {
      return new AutoValue_Session_OpenParams(
          metadata(),
          request().toBuilder()
              .setConsecutiveFailedConnectionAttempts(
                  request().getConsecutiveFailedConnectionAttempts() + 1)
              .build());
    }
  }

  SessionState getState();

  OpenParams getOpenParams();

  boolean isOpenParamsUpdated();

  PeerInfo getPeerInfo();

  String getLogName();

  Instant getNextHeartbeat();

  /**
   * Start the session by sending the opening message.
   *
   * <p>This must be the first method called on the {@link Session}. It will try setup a session
   * using the req (for the server) and headers (for rls).
   */
  void start(OpenSessionRequest req, Metadata headers, Listener sessionListener);

  /**
   * Initiates a graceful close of the Session. Transitions the session to {@link
   * SessionState#CLOSING}, waits for any in-flight vRPC on the wire (including a client-cancelled
   * one) to receive its server response, and then sends {@link CloseSessionRequest} ({@link
   * SessionState#WAIT_SERVER_CLOSE}).
   */
  void close(CloseSessionRequest req);

  /** Immediately aborts the session stream and fails any in-flight vRPC. */
  void forceClose(CloseSessionRequest reason);

  /**
   * Start a new vRPC. This method can only be called after {@link
   * Listener#onReady(OpenSessionResponse)} has been notified.
   */
  <OpenReqT extends Message, ReqT extends Message, RespT extends Message> VRpc<ReqT, RespT> newCall(
      VRpcDescriptor<OpenReqT, ReqT, RespT> descriptor) throws IllegalStateException;

  /** Callback for Session lifecycyle transitions. Methods are called sequentially. */
  interface Listener {

    void onReady(OpenSessionResponse msg);

    void onGoAway(GoAwayResponse msg);

    void onClose(SessionState prevState, Status status, Metadata trailers);
  }
}
