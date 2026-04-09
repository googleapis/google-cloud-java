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

import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.VirtualRpcRequest;
import com.google.bigtable.v2.VirtualRpcRequest.Metadata;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.util.Durations;
import io.grpc.Status;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * This class is the intermediary between a user and a {@link SessionImpl}.
 *
 * <ul>
 *   <li>{@link #start(MessageLite, VRpcCallContext, VRpcListener)} must be the first method called
 *       by the user
 *   <li>{@link #cancel(String, Throwable)} and {@link #requestNext()} can be called by any thread
 *   <li>{@link #requestNext()} can only be called after {@link
 *       com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener#onMessage} is
 *       invoked with a {@link VirtualRpcResponse} indicating that there is more data.
 *   <li>All {@code handle*} methods are expected to be called sequentially by {@link SessionImpl}
 * </ul>
 *
 * <p>The expectation is that all happens-before state transitions are conducted via the {@link
 * SessionImpl}/gRPC's executor and no synchronization has to occur here.
 */
class VRpcImpl<OpenReqT extends Message, ReqT extends MessageLite, RespT extends MessageLite>
    implements VRpc<ReqT, RespT> {
  private static final Logger DEFAULT_LOGGER = Logger.getLogger(VRpcImpl.class.getName());
  private Logger logger = DEFAULT_LOGGER;

  // Narrow view of SessionImpl
  interface VRpcSessionApi {
    Status startRpc(VRpcImpl<?, ?, ?> rpc, VirtualRpcRequest payload);

    void cancelRpc(long rpcId, @Nullable String message, @Nullable Throwable cause);
  }

  private enum State {
    NEW,
    STARTED,
    CLOSED
  }

  private final VRpcSessionApi session;
  private final VRpcDescriptor<OpenReqT, ReqT, RespT> desc;
  final long rpcId;
  private VRpcListener<RespT> listener;
  private PeerInfo peerInfo;

  private AtomicReference<State> state;

  public VRpcImpl(
      VRpcSessionApi session,
      VRpcDescriptor<OpenReqT, ReqT, RespT> desc,
      long rpcId,
      PeerInfo peerInfo) {
    this.session = session;
    this.desc = desc;
    this.rpcId = rpcId;
    this.state = new AtomicReference<>(State.NEW);
    this.peerInfo = peerInfo;
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    this.listener = listener;

    Status status;
    boolean retryable = true;

    if (state.get() != State.NEW) {
      status = Status.INTERNAL.withDescription("VRpc already started in state: " + state.get());
      retryable = false;
    } else if (ctx.getOperationInfo().getDeadline().timeRemaining(TimeUnit.MICROSECONDS)
        < TimeUnit.MILLISECONDS.toMicros(1)) {
      // Don't send RPCs that don't have any hope of succeeding
      status =
          Status.DEADLINE_EXCEEDED.withDescription("Remaining deadline is too short to send RPC");
      retryable = false;
    } else {
      state.set(State.STARTED);
      Metadata vRpcMetadata =
          Metadata.newBuilder()
              .setAttemptNumber(ctx.getOperationInfo().getAttemptNumber())
              .setTraceparent(ctx.getTraceParent())
              .build();
      ctx.getTracer().onRequestSent(peerInfo);
      status =
          session.startRpc(
              this,
              VirtualRpcRequest.newBuilder()
                  .setRpcId(rpcId)
                  .setMetadata(vRpcMetadata)
                  .setDeadline(
                      Durations.fromNanos(
                          ctx.getOperationInfo().getDeadline().timeRemaining(TimeUnit.NANOSECONDS)))
                  .setPayload(desc.encode(req))
                  .build());
      // if status is not OK, the session might not be ready and the vRPC can be retried on a
      // different session
    }

    if (!status.isOk()) {
      if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
        return;
      }
      // TODO: loop through the session executor
      if (retryable) {
        listener.onClose(VRpcResult.createUncommitedError(status));
      } else {
        listener.onClose(VRpcResult.createRejectedError(status));
      }
    }
  }

  void handleSessionClose(VRpcResult result) {
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      logger.warning("tried to close a vRPC after it was already closed state: " + state.get());
      return;
    }

    listener.onClose(result);
  }

  void handleResponse(VirtualRpcResponse response) {
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      // This can happen if the call was cancelled just before the response arrived.
      // Silently ignore it.
      return;
    }
    // TODO: handle streaming

    RespT resp;
    try {
      resp = desc.decode(response.getPayload());
    } catch (Throwable e) {
      // TODO: notify Session to cancel the vRPC
      // Right now, vrpc streaming & cancellation is not supported, so notifying SessionImpl is
      // unnecessary. In the future handleResponse will need to notify that Session that the user
      // was already notified of the error and no further notifications should be delivered
      VRpcResult result =
          VRpcResult.createLocalTransportError(
              Status.INTERNAL.withDescription("Failed to decode VRpc payload").withCause(e));
      listener.onClose(result);
      return;
    }

    try {
      listener.onMessage(resp);
    } catch (Throwable e) {
      VRpcResult result = VRpcResult.createUserError(e);
      listener.onClose(result);
      return;
    }

    listener.onClose(VRpcResult.createServerOk(response));
  }

  void handleError(VRpcResult result) {
    if (state.getAndSet(State.CLOSED) == State.CLOSED) {
      return;
    }

    listener.onClose(result);
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    session.cancelRpc(rpcId, message, cause);
  }

  @Override
  public void requestNext() {
    throw new UnsupportedOperationException("streamed RPCs are not supported yet");
  }
}
