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

import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Context;
import io.grpc.Deadline;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * A {@link VRpc} decorator that propagates gRPC {@link Context} cancellation to the underlying
 * VRpc.
 */
public class CancellableVRpc<ReqT, RespT> extends ForwardingVRpc<ReqT, RespT> {
  private final Context context;
  private final Context.CancellationListener cancellationListener;

  public CancellableVRpc(VRpc<ReqT, RespT> delegate, Context context) {
    super(delegate);
    this.context = context;
    this.cancellationListener =
        (c) -> {
          boolean deadlineExceeded =
              Optional.ofNullable(c.getDeadline()).map(Deadline::isExpired).orElse(false);
          deadlineExceeded = deadlineExceeded && c.cancellationCause() instanceof TimeoutException;
          // Let VRpc machinery handle deadline exceeded
          if (!deadlineExceeded) {
            delegate.cancel("gRPC context cancelled", c.cancellationCause());
          }
        };
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    context.addListener(cancellationListener, MoreExecutors.directExecutor());
    super.start(
        req, ctx, new CancellationCleanupListener<>(listener, context, cancellationListener));
  }

  private static class CancellationCleanupListener<RespT> extends ForwardListener<RespT> {
    private final Context context;
    private final Context.CancellationListener cancellationListener;

    private CancellationCleanupListener(
        VRpcListener<RespT> delegate,
        Context context,
        Context.CancellationListener cancellationListener) {
      super(delegate);
      this.context = context;
      this.cancellationListener = cancellationListener;
    }

    @Override
    public void onClose(VRpcResult result) {
      context.removeListener(cancellationListener);
      super.onClose(result);
    }
  }
}
