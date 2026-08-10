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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutation;

/**
 * Routes {@link BulkMutation}s that carry a single entry through a unary point-write callable,
 * letting them benefit from the same session-shim diversion as {@code MutateRow}. Bulk mutations
 * with more than one entry fall through to the classic {@code MutateRows} callable.
 *
 * <p>The point-write callable itself falls back to the {@code MutateRow} RPC when the session
 * diversion does not apply, while retaining the bulk operation's retry behavior, so the single
 * entry retries the same way it would have as part of a {@code MutateRows} call.
 */
@InternalApi
public class MaybePointWriteCallable extends UnaryCallable<BulkMutation, Void> {
  private final UnaryCallable<BulkMutation, Void> classic;
  private final UnaryCallable<RowMutation, Void> pointWriter;
  private final RequestContext requestContext;

  public MaybePointWriteCallable(
      UnaryCallable<BulkMutation, Void> classic,
      UnaryCallable<RowMutation, Void> pointWriter,
      RequestContext requestContext) {
    this.classic = classic;
    this.pointWriter = pointWriter;
    this.requestContext = requestContext;
  }

  @Override
  public ApiFuture<Void> futureCall(BulkMutation request, ApiCallContext context) {
    if (request.getEntryCount() != 1) {
      return classic.futureCall(request, context);
    }
    return pointWriter.futureCall(toRowMutation(request), context);
  }

  private RowMutation toRowMutation(BulkMutation request) {
    MutateRowsRequest proto = request.toProto(requestContext);
    MutateRowsRequest.Entry entry = proto.getEntries(0);
    MutateRowRequest mutateRowRequest =
        MutateRowRequest.newBuilder()
            .setAppProfileId(proto.getAppProfileId())
            .setTableName(proto.getTableName())
            .setAuthorizedViewName(proto.getAuthorizedViewName())
            .setRowKey(entry.getRowKey())
            .addAllMutations(entry.getMutationsList())
            .build();
    return RowMutation.fromProto(mutateRowRequest);
  }
}
