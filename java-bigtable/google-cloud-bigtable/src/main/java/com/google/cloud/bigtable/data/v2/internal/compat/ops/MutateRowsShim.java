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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenTableRequest.Permission;
import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class MutateRowsShim implements UnaryShim<BulkMutation, Void> {

  private final SessionPoolMap<TableId, TableAsync> tables;
  private final SessionPoolMap<AuthorizedViewId, AuthorizedViewAsync> authViews;

  public MutateRowsShim(Client client) {
    tables =
        new SessionPoolMap<>(
            k -> client.openTableAsync(k.getTableId(), Permission.PERMISSION_WRITE));
    authViews =
        new SessionPoolMap<>(
            k ->
                client.openAuthorizedViewAsync(
                    k.getTableId(),
                    k.getAuthorizedViewId(),
                    OpenAuthorizedViewRequest.Permission.PERMISSION_WRITE));
  }

  @Override
  public void close() throws IOException {
    tables.invalidateAll();
    authViews.invalidateAll();
  }

  @Override
  public boolean supports(BulkMutation request) {
    // TODO: enable when server side changes is rolled out
    return false;
  }

  @Override
  public CompletableFuture<Void> call(BulkMutation request, Deadline deadline) {
    TargetId targetId = request.getTargetId();

    SessionMutateRowsRequest innerReq = request.toSessionProto();

    if (targetId instanceof TableId) {
      return tables.apply(
          (TableId) targetId, t -> t.mutateRows(innerReq, deadline).thenApply(r -> null));
    }
    if (targetId instanceof AuthorizedViewId) {
      return authViews.apply(
          (AuthorizedViewId) targetId, v -> v.mutateRows(innerReq, deadline).thenApply(r -> null));
    }

    CompletableFuture<Void> f = new CompletableFuture<>();
    f.completeExceptionally(
        new UnsupportedOperationException("Unsupported targetId type: " + targetId));
    return f;
  }
}
