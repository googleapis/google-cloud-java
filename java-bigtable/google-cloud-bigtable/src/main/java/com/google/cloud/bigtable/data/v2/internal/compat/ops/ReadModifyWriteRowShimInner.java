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
import com.google.bigtable.v2.SessionReadModifyWriteRowRequest;
import com.google.bigtable.v2.SessionReadModifyWriteRowResponse;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.util.concurrent.CompletableFuture;

public class ReadModifyWriteRowShimInner
    implements UnaryShim<ReadModifyWriteRow, SessionReadModifyWriteRowResponse> {

  private final SessionPoolMap<TableId, TableAsync> tables;
  private final SessionPoolMap<AuthorizedViewId, AuthorizedViewAsync> authViews;

  public ReadModifyWriteRowShimInner(Client client) {
    // ReadModifyWriteRow reads and modifies cells and returns the row, so it needs
    // read + write access on the session.
    tables =
        new SessionPoolMap<>(
            k -> client.openTableAsync(k.getTableId(), Permission.PERMISSION_READ_WRITE));
    authViews =
        new SessionPoolMap<>(
            k ->
                client.openAuthorizedViewAsync(
                    k.getTableId(),
                    k.getAuthorizedViewId(),
                    OpenAuthorizedViewRequest.Permission.PERMISSION_READ_WRITE));
  }

  @Override
  public void close() {
    tables.invalidateAll();
    authViews.invalidateAll();
  }

  @Override
  public boolean supports(ReadModifyWriteRow request) {
    // TODO: enable when server side changes is rolled out
    return false;
  }

  @Override
  public CompletableFuture<SessionReadModifyWriteRowResponse> call(
      ReadModifyWriteRow request, Deadline deadline) {
    TargetId targetId = request.getTargetId();
    SessionReadModifyWriteRowRequest innerReq = request.toSessionProto();

    if (targetId instanceof TableId) {
      return tables.apply((TableId) targetId, t -> t.readModifyWriteRow(innerReq, deadline));
    }
    if (targetId instanceof AuthorizedViewId) {
      return authViews.apply(
          (AuthorizedViewId) targetId, v -> v.readModifyWriteRow(innerReq, deadline));
    }

    CompletableFuture<SessionReadModifyWriteRowResponse> f = new CompletableFuture<>();
    f.completeExceptionally(
        new UnsupportedOperationException("Unsupported targetId type: " + targetId));
    return f;
  }
}
