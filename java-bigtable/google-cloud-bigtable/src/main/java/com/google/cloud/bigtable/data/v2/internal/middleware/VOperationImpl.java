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
 * The single edge between the user and the VRpc middleware chain. Constructs the per-op {@link
 * VRpcCallContext} and owns the gRPC {@link Context} cancellation listener.
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
          // Let VRpc machinery handle deadline exceeded.
          if (!deadlineExceeded) {
            cancel("gRPC context cancelled", c.cancellationCause());
          }
        };
  }

  @Override
  public void start(ReqT req, VRpcListener<RespT> listener) {
    // Per-call SerializingExecutor over the shared user-callback pool. The handler is the
    // last-resort recovery: if any op-executor task throws (typically a user-installed tracer or
    // a listener callback escape), drive the chain to a terminal state so the caller's listener
    // still receives an onClose. RetryingVRpc.cancel is idempotent so cascades collapse safely.
    OpExecutor exec =
        new OpExecutor(
            MoreExecutors.newSequentialExecutor(userCallbackExecutor),
            t -> chain.cancel("Uncaught exception in op executor task", t));
    VRpcCallContext ctx = VRpcCallContext.create(deadline, idempotent, tracer, exec);
    grpcContext.addListener(cancellationListener, MoreExecutors.directExecutor());
    chain.start(req, ctx, new CleanupListener<>(listener, grpcContext, cancellationListener));
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    chain.cancel(message, cause);
  }

  private static class CleanupListener<RespT> extends ForwardListener<RespT> {
    private final Context grpcContext;
    private final Context.CancellationListener cancellationListener;

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
      grpcContext.removeListener(cancellationListener);
      super.onClose(result);
    }
  }
}
