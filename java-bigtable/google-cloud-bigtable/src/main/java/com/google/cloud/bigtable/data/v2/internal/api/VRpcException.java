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

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

// TODO: capture caller stack - this will be mostly created by a gRPC response threads, which loses
// the caller stacktrace, which isnt helpful
public class VRpcException extends StatusRuntimeException {
  private final VRpcResult result;

  public static VRpcException create(VRpcResult result) {
    if (result.getStatus().isOk()) {
      return new VRpcException(
          Status.INTERNAL.withDescription("Unexpected OK status used for an exception"), result);
    }
    return new VRpcException(result);
  }

  private VRpcException(Status overridenStatus, VRpcResult result) {
    super(overridenStatus);
    this.result = result;
  }

  private VRpcException(VRpcResult result) {
    super(result.getStatus());
    this.result = result;
  }

  public VRpcResult getResult() {
    return result;
  }
}
