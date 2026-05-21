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
  /** State transitions of Session, will happen in defined order */
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

  Instant getLastStateChange();

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
   * Caller instructed close of the Session. Will immediately close the session and abort all
   * outstanding vRPCs.
   */
  void close(CloseSessionRequest req);

  /** Force close a session. */
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
