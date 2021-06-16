/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.bigtable.v2.ReadRowsRequest;
import org.threeten.bp.Duration;

/**
 * Specialization of ReadRows streams for point reads.
 *
 * <p>Under normal circumstances, the ReadRows RPC can't make any assumptions about deadlines. In
 * general case the end user can be issuing a full table scan. However, when dealing with point
 * reads, the client can make assumptions and promote the per row timeout to be a per attempt
 * timeout.
 *
 * <p>This callable will check if the request is a point read and promote the timeout to be a
 * deadline.
 */
@InternalApi
public class PointReadTimeoutCallable<RespT>
    extends ServerStreamingCallable<ReadRowsRequest, RespT> {
  private final ServerStreamingCallable<ReadRowsRequest, RespT> inner;

  public PointReadTimeoutCallable(ServerStreamingCallable<ReadRowsRequest, RespT> inner) {
    this.inner = inner;
  }

  @Override
  public void call(ReadRowsRequest request, ResponseObserver<RespT> observer, ApiCallContext ctx) {
    if (isPointRead(request)) {
      Duration streamWaitTimeout = ctx.getStreamWaitTimeout();
      if (ctx.getTimeout() == null && streamWaitTimeout != null) {
        ctx = ctx.withTimeout(streamWaitTimeout);
      }
    }
    inner.call(request, observer, ctx);
  }

  private boolean isPointRead(ReadRowsRequest request) {
    if (request.getRowsLimit() == 1) {
      return true;
    }
    if (!request.getRows().getRowRangesList().isEmpty()) {
      return false;
    }
    return request.getRows().getRowKeysCount() == 1;
  }
}
