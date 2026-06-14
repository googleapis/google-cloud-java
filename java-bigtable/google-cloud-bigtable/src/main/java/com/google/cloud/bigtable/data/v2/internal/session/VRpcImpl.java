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
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DebugTagTracer;
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
    /**
     * Submit the vRPC for sending. Async: errors are delivered via {@link
     * VRpcImpl#handleError(VRpcResult)}, which dispatches onto {@code ctx.getExecutor()}.
     */
    void startRpc(VRpcImpl<?, ?, ?> rpc, VirtualRpcRequest payload);

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
  private VRpcCallContext ctx;
  private PeerInfo peerInfo;

  private AtomicReference<State> state;

  private final DebugTagTracer debugTagTracer;

  public VRpcImpl(
      VRpcSessionApi session,
      VRpcDescriptor<OpenReqT, ReqT, RespT> desc,
      long rpcId,
      PeerInfo peerInfo,
      DebugTagTracer debugTagTracer) {
    this.session = session;
    this.desc = desc;
    this.rpcId = rpcId;
    this.state = new AtomicReference<>(State.NEW);
    this.peerInfo = peerInfo;
    this.debugTagTracer = debugTagTracer;
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    if (!state.compareAndSet(State.NEW, State.STARTED)) {
      // Lost the CAS — a duplicate start. Dispatch to the local listener/ctx without touching
      // the shared fields, otherwise we'd corrupt the in-flight call owned by the CAS winner.
      VRpcResult result =
          VRpcResult.createRejectedError(
              Status.INTERNAL.withDescription("VRpc already started in state: " + state.get()));
      ctx.getExecutor().execute(() -> listener.onClose(result));
      return;
    }
    // Won the CAS — publish the fields.
    this.listener = listener;
    this.ctx = ctx;

    if (ctx.getOperationInfo().getDeadline().timeRemaining(TimeUnit.MICROSECONDS)
        < TimeUnit.MILLISECONDS.toMicros(1)) {
      state.set(State.CLOSED);
      VRpcResult result =
          VRpcResult.createRejectedError(
              Status.DEADLINE_EXCEEDED.withDescription(
                  "Remaining deadline is too short to send RPC"));
      ctx.getExecutor().execute(() -> listener.onClose(result));
      return;
    }

    Metadata vRpcMetadata =
        Metadata.newBuilder()
            .setAttemptNumber(ctx.getOperationInfo().getAttemptNumber())
            .setTraceparent(ctx.getTraceParent())
            .build();
    ctx.getTracer().onRequestSent(peerInfo);
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
    // Session delivers startRpc errors asynchronously via handleError() on ctx.getExecutor().
  }

  void handleSessionClose(VRpcResult result) {
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      logger.warning("tried to close a vRPC after it was already closed state: " + state.get());
      return;
    }
    ctx.getExecutor().execute(() -> listener.onClose(result));
  }

  void handleResponse(VirtualRpcResponse response) {
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      // This can happen if the call was cancelled just before the response arrived.
      // Silently ignore it.
      return;
    }
    // TODO: handle streaming

    // Decode + callback fan-out all run on the op executor: keeps the (potentially heavy) decode
    // off the session sync context, and gives every callback a single dispatcher.
    ctx.getExecutor()
        .execute(
            () -> {
              RespT resp;
              try {
                resp = desc.decode(response.getPayload());
              } catch (Throwable e) {
                // TODO: notify Session to cancel the vRPC
                listener.onClose(
                    VRpcResult.createLocalTransportError(
                        Status.INTERNAL
                            .withDescription("Failed to decode VRpc payload")
                            .withCause(e)));
                return;
              }
              try {
                listener.onMessage(resp);
              } catch (Throwable e) {
                listener.onClose(VRpcResult.createUserError(e));
                return;
              }
              listener.onClose(VRpcResult.createServerOk(response));
            });
  }

  void handleError(VRpcResult result) {
    // CAS STARTED -> CLOSED, matching handleResponse / handleSessionClose. The previous
    // getAndSet(CLOSED) would proceed from NEW and dereference null ctx/listener fields.
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      return;
    }
    ctx.getExecutor().execute(() -> listener.onClose(result));
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
