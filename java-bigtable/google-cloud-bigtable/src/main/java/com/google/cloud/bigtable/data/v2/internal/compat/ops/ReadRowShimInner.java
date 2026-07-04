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
import com.google.bigtable.v2.OpenMaterializedViewRequest;
import com.google.bigtable.v2.OpenTableRequest.Permission;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.MaterializedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.internal.compat.ShimImpl;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.MaterializedViewId;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.util.concurrent.CompletableFuture;

public class ReadRowShimInner implements UnaryShim<Query, SessionReadRowResponse> {
  private final SessionPoolMap<TableId, TableAsync> tables;
  private final SessionPoolMap<AuthorizedViewId, AuthorizedViewAsync> authViews;
  private final SessionPoolMap<MaterializedViewId, MaterializedViewAsync> matViews;

  public ReadRowShimInner(Client client) {
    tables =
        new SessionPoolMap<>(
            k -> client.openTableAsync(k.getTableId(), Permission.PERMISSION_READ));
    authViews =
        new SessionPoolMap<>(
            k ->
                client.openAuthorizedViewAsync(
                    k.getTableId(),
                    k.getAuthorizedViewId(),
                    OpenAuthorizedViewRequest.Permission.PERMISSION_READ));
    matViews =
        new SessionPoolMap<>(
            k ->
                client.openMaterializedViewAsync(
                    k.getMaterializedViewId(),
                    OpenMaterializedViewRequest.Permission.PERMISSION_READ));
  }

  @Override
  public void close() {
    tables.invalidateAll();
    authViews.invalidateAll();
    matViews.invalidateAll();
  }

  @Override
  public boolean supports(Query request) {
    TargetId targetId = request.getTargetId();
    SessionPool<?> pool;
    // TODO avoid double lookup
    if (targetId instanceof TableId) {
      pool = tables.get((TableId) targetId).getSessionPool();
    } else if (targetId instanceof AuthorizedViewId) {
      pool = authViews.get((AuthorizedViewId) targetId).getSessionPool();
    } else if (targetId instanceof MaterializedViewId) {
      pool = matViews.get((MaterializedViewId) targetId).getSessionPool();
    } else {
      return false;
    }
    // Currently this will only fallback in case RLS is misconfigured. If the AFE
    // pool is unavailable, it'll be controlled by ClientConfiguration.
    return pool.getConsecutiveUnimplementedFailures()
            < ShimImpl.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES
        || pool.hasSession();
  }

  @Override
  public CompletableFuture<SessionReadRowResponse> call(Query query, Deadline deadline) {
    TargetId targetId = query.getTargetId();

    SessionReadRowRequest innerReq = query.toSessionPointProto();

    if (targetId instanceof TableId) {
      return tables.apply((TableId) targetId, t -> t.readRow(innerReq, deadline));
    }
    if (targetId instanceof AuthorizedViewId) {
      return authViews.apply((AuthorizedViewId) targetId, v -> v.readRow(innerReq, deadline));
    }
    if (targetId instanceof MaterializedViewId) {
      return matViews.apply((MaterializedViewId) targetId, v -> v.readRow(innerReq, deadline));
    }

    CompletableFuture<SessionReadRowResponse> f = new CompletableFuture<>();
    f.completeExceptionally(
        new UnsupportedOperationException("Unsupported targetId type: " + targetId));
    return f;
  }
}
