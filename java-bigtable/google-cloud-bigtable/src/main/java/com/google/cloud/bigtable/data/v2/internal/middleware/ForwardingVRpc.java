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

import javax.annotation.Nullable;

/** Simple helper to delegate all calls to another {@link VRpc}. */
public class ForwardingVRpc<ReqT, RespT> implements VRpc<ReqT, RespT> {
  private final VRpc<ReqT, RespT> delegate;

  public ForwardingVRpc(VRpc<ReqT, RespT> delegate) {
    this.delegate = delegate;
  }

  @Override
  public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
    delegate.start(req, ctx, listener);
  }

  @Override
  public void cancel(@Nullable String message, @Nullable Throwable cause) {
    delegate.cancel(message, cause);
  }

  @Override
  public void requestNext() {
    delegate.requestNext();
  }

  public static class ForwardListener<RespT> implements VRpc.VRpcListener<RespT> {
    private final VRpc.VRpcListener<RespT> delegate;

    public ForwardListener(VRpcListener<RespT> delegate) {
      this.delegate = delegate;
    }

    @Override
    public void onMessage(RespT msg) {
      delegate.onMessage(msg);
    }

    @Override
    public void onClose(VRpcResult result) {
      delegate.onClose(result);
    }
  }
}
