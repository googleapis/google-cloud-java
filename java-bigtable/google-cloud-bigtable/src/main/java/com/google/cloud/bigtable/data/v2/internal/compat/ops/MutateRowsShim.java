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

import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.util.concurrent.CompletableFuture;

public class MutateRowsShim implements UnaryShim<BulkMutation, Void> {

  private final SessionPoolMap sessionMap;

  public MutateRowsShim(SessionPoolMap sessionMap) {
    this.sessionMap = sessionMap;
  }

  @Override
  public void close() {}

  @Override
  public boolean supports(BulkMutation request) {
    TargetId targetId = request.getTargetId();
    SessionPool<?> pool;
    if (targetId instanceof TableId) {
      pool = sessionMap.get((TableId) targetId, SessionKey.Permission.WRITE).getSessionPool();
    } else if (targetId instanceof AuthorizedViewId) {
      pool =
          sessionMap.get((AuthorizedViewId) targetId, SessionKey.Permission.WRITE).getSessionPool();
    } else {
      return false;
    }
    return UnaryShim.shouldRouteToSession(pool);
  }

  @Override
  public CompletableFuture<Void> call(BulkMutation request, Deadline deadline) {
    TargetId targetId = request.getTargetId();

    SessionMutateRowsRequest innerReq = request.toSessionProto();

    if (targetId instanceof TableId) {
      return sessionMap.apply(
          (TableId) targetId,
          SessionKey.Permission.WRITE,
          t -> t.mutateRows(innerReq, deadline).thenApply(r -> null));
    }
    if (targetId instanceof AuthorizedViewId) {
      return sessionMap.apply(
          (AuthorizedViewId) targetId,
          SessionKey.Permission.WRITE,
          v -> v.mutateRows(innerReq, deadline).thenApply(r -> null));
    }

    CompletableFuture<Void> f = new CompletableFuture<>();
    f.completeExceptionally(
        new UnsupportedOperationException("Unsupported targetId type: " + targetId));
    return f;
  }
}
