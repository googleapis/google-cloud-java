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

import com.google.bigtable.v2.SessionCheckAndMutateRowRequest;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import io.grpc.Deadline;
import java.util.concurrent.CompletableFuture;

public class CheckAndMutateRowShim implements UnaryShim<ConditionalRowMutation, Boolean> {

  private final SessionPoolMap sessionMap;

  public CheckAndMutateRowShim(SessionPoolMap sessionMap) {
    this.sessionMap = sessionMap;
  }

  @Override
  public void close() {}

  @Override
  public boolean supports(ConditionalRowMutation request) {
    TargetId targetId = request.getTargetId();
    SessionPool<?> pool;
    if (targetId instanceof TableId) {
      pool = sessionMap.get((TableId) targetId, SessionKey.Permission.READ_WRITE).getSessionPool();
    } else if (targetId instanceof AuthorizedViewId) {
      pool =
          sessionMap
              .get((AuthorizedViewId) targetId, SessionKey.Permission.READ_WRITE)
              .getSessionPool();
    } else {
      return false;
    }
    return UnaryShim.shouldRouteToSession(pool);
  }

  @Override
  public CompletableFuture<Boolean> call(ConditionalRowMutation request, Deadline deadline) {
    TargetId targetId = request.getTargetId();

    SessionCheckAndMutateRowRequest innerReq = request.toSessionProto();

    if (targetId instanceof TableId) {
      return sessionMap.apply(
          (TableId) targetId,
          SessionKey.Permission.READ_WRITE,
          t -> t.checkAndMutateRow(innerReq, deadline).thenApply(r -> r.getPredicateMatched()));
    }
    if (targetId instanceof AuthorizedViewId) {
      return sessionMap.apply(
          (AuthorizedViewId) targetId,
          SessionKey.Permission.READ_WRITE,
          v -> v.checkAndMutateRow(innerReq, deadline).thenApply(r -> r.getPredicateMatched()));
    }

    CompletableFuture<Boolean> f = new CompletableFuture<>();
    f.completeExceptionally(
        new UnsupportedOperationException("Unsupported targetId type: " + targetId));
    return f;
  }
}
