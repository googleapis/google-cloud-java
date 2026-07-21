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

import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import javax.annotation.Nullable;

/**
 * Entry point for a single user-facing operation that may translate into one or more {@link VRpc}
 * attempts.
 *
 * <p>{@code VOperation} sits above the {@code VRpc} chain. It owns the per-op {@link
 * VRpc.VRpcCallContext} and the gRPC {@link io.grpc.Context} cancellation listener, so downstream
 * middleware only deals with the chain itself.
 */
public interface VOperation<ReqT, RespT> {

  /** Start the operation. Results are delivered to {@code listener}. */
  void start(ReqT req, VRpcListener<RespT> listener);

  /** Cancel a started operation. Best effort. */
  void cancel(@Nullable String message, @Nullable Throwable cause);
}
