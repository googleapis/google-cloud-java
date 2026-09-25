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

/**
 * Strategy for resuming a (potentially streaming) vRPC after a retryable failure.
 *
 * <p>{@link RetryingVRpc} owns one instance per operation. As each response is delivered it is fed
 * to {@link #onResponse}, so the strategy can accumulate whatever it needs to narrow the request on
 * a subsequent attempt. On the retry path {@link RetryingVRpc} calls {@link #getResumeRequest} with
 * the <em>original</em> request and re-sends whatever it returns.
 *
 * <p>Implementations are stateful and are only ever touched from the op executor, so they need no
 * synchronization.
 *
 * @param <ReqT> the request type
 * @param <RespT> the response type
 */
public interface VRpcResumptionStrategy<ReqT, RespT> {

  /**
   * Record progress from a delivered response. Called once per {@code onMessage}, before the
   * response is forwarded to the user listener.
   */
  void onResponse(RespT response);

  /**
   * Build the request to send on the next attempt, given the immutable {@code originalRequest}.
   *
   * <p>Returning {@code originalRequest} means "resume from scratch" (nothing has been delivered
   * yet). Returning {@code null} means the operation is already fully satisfied and the retry
   * should instead complete successfully without issuing another attempt.
   */
  @Nullable
  ReqT getResumeRequest(ReqT originalRequest);

  /**
   * No-op strategy for unary (or otherwise non-resumable) vRPCs: it records nothing and always
   * re-sends the original request unchanged, preserving the pre-streaming retry behavior. Callers
   * that build a specific operation pick the strategy explicitly (e.g. {@code TableBase} uses this
   * for point reads/writes and a read-rows strategy for streaming reads).
   */
  static <ReqT, RespT> VRpcResumptionStrategy<ReqT, RespT> noOp() {
    return new VRpcResumptionStrategy<ReqT, RespT>() {
      @Override
      public void onResponse(RespT response) {}

      @Override
      public ReqT getResumeRequest(ReqT originalRequest) {
        return originalRequest;
      }
    };
  }
}
