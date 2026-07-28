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

import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.common.base.Preconditions;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

public class UnaryResponseFuture<T> extends CompletableFuture<T> implements VRpcListener<T> {
  private static final Logger DEFAULT_LOGGER =
      Logger.getLogger(UnaryResponseFuture.class.getName());
  private Logger logger = DEFAULT_LOGGER;

  private T msg = null;
  private boolean hasMsg = false;

  @Override
  public void onMessage(T msg) {
    Preconditions.checkState(!hasMsg, "Unary rpc received duplicated message");
    hasMsg = true;
    this.msg = msg;
  }

  @Override
  public void onClose(VRpcResult result) {
    if (result.getStatus().isOk()) {
      if (!hasMsg) {
        completeExceptionally(
            new IllegalStateException("Unary rpc completed OK but missing result"));
      } else {
        complete(msg);
      }
    } else {
      if (!completeExceptionally(VRpcException.create(result))) {
        logger.warning("Unary rpc got error after it was resolved: " + result);
      }
    }
  }
}
