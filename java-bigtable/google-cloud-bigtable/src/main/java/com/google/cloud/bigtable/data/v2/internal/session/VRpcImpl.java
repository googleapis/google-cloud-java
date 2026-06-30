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
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.util.Durations;
import io.grpc.Status;
import java.util.concurrent.TimeUnit;
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
    STARTING,
    STARTED,
    CANCELLED,
    CLOSED
  }

  private final VRpcSessionApi session;
  private final VRpcDescriptor<OpenReqT, ReqT, RespT> desc;
  final long rpcId;
  private VRpcListener<RespT> listener;
  private PeerInfo peerInfo;

  private final Object lock = new Object();

  @GuardedBy("lock")
  private State state = State.NEW;

  @GuardedBy("lock")
  private Status cancelStatus = null;

  public VRpcImpl(
      VRpcSessionApi session,
      VRpcDescriptor<OpenReqT, ReqT, RespT> desc,
      long rpcId,
      PeerInfo peerInfo) {
    this.session = session;
    this.desc = desc;
    this.rpcId = rpcId;
    this.peerInfo = peerInfo;
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    this.listener = listener;

    Status status = null;
    VirtualRpcRequest request = null;

    synchronized (lock) {
      if (state == State.CANCELLED) {
        state = State.CLOSED;
        status = cancelStatus;
      } else if (state != State.NEW) {
        status = Status.INTERNAL.withDescription("VRpc already started in state: " + state);
      } else if (ctx.getOperationInfo().getDeadline().timeRemaining(TimeUnit.MICROSECONDS)
          < TimeUnit.MILLISECONDS.toMicros(1)) {
        // Don't send RPCs that don't have any hope of succeeding
        state = State.CLOSED;
        status =
            Status.DEADLINE_EXCEEDED.withDescription("Remaining deadline is too short to send RPC");
      } else {
        state = State.STARTING;
        Metadata vRpcMetadata =
            Metadata.newBuilder()
                .setAttemptNumber(ctx.getOperationInfo().getAttemptNumber())
                .setTraceparent(ctx.getTraceParent())
                .build();
        ctx.getTracer().onRequestSent(peerInfo);
        request =
            VirtualRpcRequest.newBuilder()
                .setRpcId(rpcId)
                .setMetadata(vRpcMetadata)
                .setDeadline(
                    Durations.fromNanos(
                        ctx.getOperationInfo().getDeadline().timeRemaining(TimeUnit.NANOSECONDS)))
                .setPayload(desc.encode(req))
                .build();
      }
    }

    if (status != null) {
      listener.onClose(VRpcResult.createRejectedError(status));
      return;
    }

    Status startRpcStatus = session.startRpc(this, request);

    if (startRpcStatus.isOk()) {
      boolean shouldCancelSession = false;
      Status localCancel = null;
      synchronized (lock) {
        if (state == State.STARTING) {
          state = State.STARTED;
        } else if (state == State.CANCELLED) {
          shouldCancelSession = true;
          localCancel = cancelStatus;
        }
      }
      if (shouldCancelSession) {
        session.cancelRpc(rpcId, localCancel.getDescription(), localCancel.getCause());
      }
    } else {
      VRpcResult result;
      synchronized (lock) {
        if (state == State.CANCELLED) {
          result = VRpcResult.createRejectedError(cancelStatus);
        } else {
          result = VRpcResult.createUncommitedError(startRpcStatus);
        }
        state = State.CLOSED;
      }
      listener.onClose(result);
    }
  }

  void handleSessionClose(VRpcResult result) {
    synchronized (lock) {
      if (state == State.CLOSED) {
        return;
      }
      state = State.CLOSED;
    }

    listener.onClose(result);
  }

  void handleResponse(VirtualRpcResponse response) {
    synchronized (lock) {
      if (state != State.STARTED && state != State.STARTING) {
        // This can happen if the call was cancelled just before the response arrived.
        // Silently ignore it.
        return;
      }
      state = State.CLOSED;
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
    synchronized (lock) {
      if (state == State.CLOSED) {
        return;
      }
      state = State.CLOSED;
    }

    listener.onClose(result);
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    boolean isRealCall = false;
    synchronized (lock) {
      if (state == State.NEW || state == State.STARTING) {
        state = State.CANCELLED;
        Status status = Status.CANCELLED;
        if (message != null) {
          status = status.withDescription(message);
        }
        if (cause != null) {
          status = status.withCause(cause);
        }
        cancelStatus = status;
        return;
      } else if (state == State.STARTED) {
        isRealCall = true;
      }
      // ignore closed vRPCs
    }
    if (isRealCall) {
      session.cancelRpc(rpcId, message, cause);
    }
  }

  @Override
  public void requestNext() {
    throw new UnsupportedOperationException("streamed RPCs are not supported yet");
  }
}
