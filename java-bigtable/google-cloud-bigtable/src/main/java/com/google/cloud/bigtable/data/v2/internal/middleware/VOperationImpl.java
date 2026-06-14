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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.ForwardingVRpc.ForwardListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Context;
import io.grpc.Deadline;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/**
 * The single edge between the user and the VRpc middleware chain. Trampolines all inbound user
 * calls onto opExecutor and owns the gRPC {@link Context} cancellation listener so that every
 * layer below is single-threaded on opExecutor.
 *
 * <p>Precondition: {@link #cancel} must not be called before {@link #start}.
 */
public class VOperationImpl<ReqT, RespT> implements VOperation<ReqT, RespT> {

  private final VRpc<ReqT, RespT> chain;
  private final Context grpcContext;
  private final Executor userCallbackExecutor;
  private final VRpcTracer tracer;
  private final Deadline deadline;
  private final boolean idempotent;
  private final Context.CancellationListener cancellationListener;

  // Written in start() on the caller thread before the listener is registered and before cancel()
  // is reachable from any external thread. Volatile for safe publication to those threads.
  private volatile OpExecutor opExecutor;

  public VOperationImpl(
      VRpc<ReqT, RespT> chain,
      Context grpcContext,
      Executor userCallbackExecutor,
      VRpcTracer tracer,
      Deadline deadline,
      boolean idempotent) {
    this.chain = chain;
    this.grpcContext = grpcContext;
    this.userCallbackExecutor = userCallbackExecutor;
    this.tracer = tracer;
    this.deadline = deadline;
    this.idempotent = idempotent;
    this.cancellationListener =
        (c) -> {
          boolean deadlineExceeded =
              Optional.ofNullable(c.getDeadline()).map(Deadline::isExpired).orElse(false);
          deadlineExceeded = deadlineExceeded && c.cancellationCause() instanceof TimeoutException;
          // Let VRpc machinery handle deadline exceeded
          if (!deadlineExceeded) {
            cancel("gRPC context cancelled", c.cancellationCause());
          }
        };
  }

  @Override
  public void start(ReqT req, VRpcListener<RespT> listener) {
    // Last-resort recovery: if any op-executor task throws (typically a user-installed tracer,
    // or a listener callback that escapes RetryingVRpc's existing per-state try/catches), drive
    // the chain to a terminal state so the caller's listener still receives an onClose. The
    // handler runs on the failed task's wrapper, so chain.cancel() — which calls
    // OpExecutor#throwIfNotInThisExecutor — passes. RetryingVRpc.cancel is idempotent
    // (isCancelling / currentState.isDone() guards), so a cascade of failures collapses to a
    // single Done.
    OpExecutor exec =
        new OpExecutor(
            MoreExecutors.newSequentialExecutor(userCallbackExecutor),
            t -> chain.cancel("Uncaught exception in op executor task", t));
    this.opExecutor = exec;
    VRpcCallContext ctx = VRpcCallContext.create(deadline, idempotent, tracer, exec);
    CleanupListener<RespT> wrapped =
        new CleanupListener<>(listener, grpcContext, cancellationListener);
    // Register the gRPC context listener BEFORE submitting chain.start. The submit queues the
    // task on the op executor; chain.cancel from this listener also queues. SequentialExecutor
    // preserves submission order, so a context-cancel fired during/before chain.start will be
    // processed after it.
    grpcContext.addListener(cancellationListener, MoreExecutors.directExecutor());
    exec.execute(() -> chain.start(req, ctx, wrapped));
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    opExecutor.execute(() -> chain.cancel(message, cause));
  }

  private static class CleanupListener<RespT> extends ForwardListener<RespT> {
    private final Context grpcContext;
    private final Context.CancellationListener cancellationListener;
    // Read by VOperationImpl.start on the caller thread after runInline returns. runInline runs
    // chain.start synchronously, so any sync onClose has completed (and this flag been set) by
    // the time start() reads it on the same thread — no synchronization needed.
    volatile boolean closed = false;

    CleanupListener(
        VRpcListener<RespT> delegate,
        Context grpcContext,
        Context.CancellationListener cancellationListener) {
      super(delegate);
      this.grpcContext = grpcContext;
      this.cancellationListener = cancellationListener;
    }

    @Override
    public void onClose(VRpcResult result) {
      closed = true;
      grpcContext.removeListener(cancellationListener);
      super.onClose(result);
    }
  }
}
