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
import java.util.ArrayDeque;
import java.util.Deque;
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
 *   <li>{@link #cancel(String, Throwable)} can be called by any thread
 *   <li>{@link #requestNext()} pulls the next response of a stream; it is only driven for streaming
 *       vRPCs (by {@link com.google.cloud.bigtable.data.v2.internal.middleware.VOperationImpl}) and
 *       only after the preceding response has been delivered. Unary vRPCs deliver their single
 *       response gated by {@code has_more=false} and complete without ever being asked to pull.
 *   <li>All {@code handle*} methods are expected to be called sequentially by {@link SessionImpl}
 * </ul>
 *
 * <p>A streaming vRPC is modeled as a server stream: each pull — the initial request or a continue
 * — yields exactly one response. Intermediate responses ({@code has_more=true}) keep the vRPC
 * STARTED so the buffer can drain and further continues can be sent; the terminal response ({@code
 * has_more=false}) completes it. Delivery to the listener is demand-gated (one per {@link
 * #requestNext()}), but the prefetch buffer is filled eagerly up to a byte budget.
 *
 * <p>Unary vRPCs take a separate fast path ({@link #handleUnaryResponse}) that never touches the
 * prefetch machinery: a single {@code has_more=false} response both delivers and completes the
 * call. The two paths are selected by {@link VRpcCallContext#getAutoFlowControl()} — the same flag
 * that decides whether {@link #requestNext()} is driven — so a bug in the streaming code cannot
 * affect unary calls.
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

    /**
     * Ask the session to pull the next response for a streaming vRPC (sends a {@code
     * ContinueVirtualRpcRequest}). Async: the response is delivered via {@link
     * VRpcImpl#handleResponse(VirtualRpcResponse)}.
     */
    void continueRpc(long rpcId);

    void cancelRpc(long rpcId, @Nullable String message, @Nullable Throwable cause);

    /**
     * The current server-advertised prefetch budget in bytes ({@code
     * softmax_streaming_prefetch_buffer_size}). Read live on every prefetch decision so a
     * mid-session update from a {@code SessionParametersResponse} takes effect immediately, rather
     * than being snapshotted once when the vRPC is created.
     */
    int getSoftmaxStreamingPrefetchBufferSize();
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

  // ---- Prefetch state. All fields below are confined to ctx.getExecutor() (the op executor) once
  // start() has run: handleResponse hands each frame to that executor before touching them. ----

  // Decoded-but-undelivered responses, oldest first. Delivery is demand-gated (one per requestNext)
  // even though the buffer is filled eagerly.
  private final Deque<Buffered<RespT>> prefetchBuffer = new ArrayDeque<>();
  private int bufferedBytes = 0;
  // Whether the layer above has asked for the next message and is waiting for it. Seeded true: the
  // first response is delivered implicitly (start() implicitly requests it), no requestNext needed.
  private boolean upstreamWantsNext = true;
  // Whether the server may still have more responses (last seen has_more). Set false on the
  // terminal response, after which no more continues are sent.
  private boolean serverHasMore = true;
  // Whether a pull (the initial request or a continue) is outstanding awaiting a response. Prevents
  // more than one in-flight pull at a time (maybeContinue() refuses to send while this is true).
  //
  // Over the life of a stream:
  //   1. start() sends the initial request -- the first pull -- and sets this true.
  //   2. onStreamResponse() sets it false when that pull's response arrives.
  //   3. maybeContinue() sets it true again as it sends the next continueRpc().
  //   4. steps 2-3 repeat, one pull at a time, until the terminal (has_more=false) response.
  // A response is always required to clear it, so at most one pull is ever in flight. On close
  // (closeExceptionally/handleError/handleSessionClose) it is left as-is: every reader is gated on
  // state != CLOSED, so a stale true is never observed.
  private boolean continueInFlight = false;
  // Set true by cancel(). Once set, the prefetch machinery stops: pump() delivers nothing more and
  // onStreamResponse() drops any late frame, so no response reaches the listener after cancel was
  // requested. The terminal onClose is still driven by the server's CANCELLED frame (see cancel()),
  // not by this flag.
  private boolean cancelRequested = false;
  // The has_more=false response, retained so the completing onClose carries its cluster/stats info.
  @Nullable private VirtualRpcResponse terminalResponse;

  private static final class Buffered<T> {
    final T message;
    final int bytes;

    Buffered(T message, int bytes) {
      this.message = message;
      this.bytes = bytes;
    }
  }

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
    // The initial request is the first outstanding pull; its response arrives via handleResponse.
    // start() runs on the op executor (VOperationImpl drives it), so touching prefetch state is
    // safe. Only the streaming path reads this; unary never touches the prefetch machinery.
    if (ctx.getAutoFlowControl()) {
      continueInFlight = true;
    }
    // Session delivers startRpc errors asynchronously via handleError() on ctx.getExecutor().
  }

  void handleSessionClose(VRpcResult result) {
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      logger.warning("tried to close a vRPC after it was already closed state: " + state.get());
      return;
    }
    ctx.getExecutor().execute(() -> listener.onClose(result));
  }

  /** Handle a response frame delivered by the session on its sync context. */
  void handleResponse(VirtualRpcResponse response) {
    // Gate on the same flag that decides whether anything drives requestNext (VOperationImpl).
    // Unary
    // ops take the fast path below; only demand-gated streaming ops enter the prefetch machinery,
    // so
    // a bug in onStreamResponse/pump/maybeContinue can never reach a unary call.
    if (!ctx.getAutoFlowControl()) {
      handleUnaryResponse(response);
      return;
    }
    // handle* methods run on the session sync context, which is single-threaded, so reading state
    // here is safe. A CLOSED state means an error/cancel already terminated the vRPC.
    if (state.get() != State.STARTED) {
      return;
    }
    boolean terminal = !response.getHasMore();
    // Decode + all buffer/listener manipulation happen on the op executor so the prefetch state is
    // single-threaded with requestNext(), and the (potentially heavy) decode stays off the session
    // sync context.
    ctx.getExecutor().execute(() -> onStreamResponse(response, terminal));
  }

  // Unary fast path: verbatim the pre-streaming logic. A unary vRPC receives exactly one response,
  // which is terminal, so this both claims the STARTED -> CLOSED transition and completes the call.
  // Kept isolated from the streaming prefetch machinery on purpose (see handleResponse).
  private void handleUnaryResponse(VirtualRpcResponse response) {
    if (!state.compareAndSet(State.STARTED, State.CLOSED)) {
      // This can happen if the call was cancelled just before the response arrived.
      // Silently ignore it.
      return;
    }
    // Decode + callback fan-out all run on the op executor: keeps the (potentially heavy) decode
    // off the session sync context, and gives every callback a single dispatcher.
    ctx.getExecutor()
        .execute(
            () -> {
              RespT resp;
              try {
                resp = desc.decode(response.getPayload());
              } catch (Throwable e) {
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

  // Runs on the op executor.
  private void onStreamResponse(VirtualRpcResponse response, boolean terminal) {
    if (state.get() == State.CLOSED) {
      // An error/cancel closed the vRPC while this response was in flight; drop it.
      return;
    }
    if (cancelRequested) {
      // A cancel was requested; drop this frame and don't pull more. The server's terminal
      // CANCELLED frame will drive the real onClose.
      return;
    }
    // The outstanding pull is satisfied.
    continueInFlight = false;

    RespT decoded;
    try {
      decoded = desc.decode(response.getPayload());
    } catch (Throwable e) {
      closeExceptionally(
          VRpcResult.createLocalTransportError(
              Status.INTERNAL.withDescription("Failed to decode VRpc payload").withCause(e)),
          "Failed to decode VRpc payload",
          e);
      return;
    }

    int bytes = response.getPayload().size();
    prefetchBuffer.addLast(new Buffered<>(decoded, bytes));
    bufferedBytes += bytes;
    if (terminal) {
      serverHasMore = false;
      terminalResponse = response;
    }
    pump();
  }

  // Deliver at most one buffered response to satisfy outstanding demand, complete the vRPC if the
  // last response has been drained, then top up the prefetch buffer. Runs on the op executor.
  private void pump() {
    if (state.get() == State.CLOSED || cancelRequested) {
      return;
    }

    if (upstreamWantsNext && !prefetchBuffer.isEmpty()) {
      Buffered<RespT> head = prefetchBuffer.pollFirst();
      bufferedBytes -= head.bytes;
      upstreamWantsNext = false;
      try {
        listener.onMessage(head.message);
      } catch (Throwable e) {
        closeExceptionally(VRpcResult.createUserError(e), "User callback threw", e);
        return;
      }
      // The terminal response is always the last one buffered, so an empty buffer after delivery
      // when the server has no more data means the vRPC is complete.
      if (!serverHasMore && prefetchBuffer.isEmpty()) {
        if (state.compareAndSet(State.STARTED, State.CLOSED)) {
          listener.onClose(VRpcResult.createServerOk(terminalResponse));
        }
        return;
      }
    }

    maybeContinue();
  }

  // Pull the next response if the server has more, no pull is already in flight, and we are still
  // under the byte budget.
  private void maybeContinue() {
    if (serverHasMore
        && !continueInFlight
        && bufferedBytes < session.getSoftmaxStreamingPrefetchBufferSize()) {
      continueInFlight = true;
      session.continueRpc(rpcId);
    }
  }

  // CAS to CLOSED (losing to a concurrent session-driven close is fine) and, if we win, cancel the
  // server-side vRPC and deliver the terminal error. Runs on the op executor.
  private void closeExceptionally(VRpcResult result, String message, Throwable cause) {
    if (state.compareAndSet(State.STARTED, State.CLOSED)) {
      session.cancelRpc(rpcId, message, cause);
      listener.onClose(result);
    }
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
    // Stop the client-side prefetch machinery the instant cancel is requested: drop the
    // speculatively-buffered responses and stop delivering/pulling (guards in pump() and
    // onStreamResponse() honor cancelRequested), so no response reaches the listener after cancel.
    // We deliberately do NOT close locally -- the terminal onClose is driven by the server's
    // CANCELLED frame (see SessionImpl.cancelRpc), which also clears the session's per-vRPC
    // bookkeeping. cancel() runs on the op executor (VOperationImpl trampolines it through the
    // chain), so touching the prefetch state here is safe. For a unary vRPC these fields are
    // unused,
    // so this is a harmless no-op beyond forwarding the cancel.
    cancelRequested = true;
    prefetchBuffer.clear();
    bufferedBytes = 0;
    session.cancelRpc(rpcId, message, cause);
  }

  @Override
  public boolean isDone() {
    return state.get() == State.CLOSED;
  }

  @Override
  public void requestNext() {
    // VOperationImpl only calls this from the op executor; the assertion guards against misuse and
    // keeps all prefetch state single-threaded.
    ctx.getExecutor().throwIfNotInThisExecutor();
    upstreamWantsNext = true;
    pump();
  }
}
