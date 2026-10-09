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
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.TableId;

/**
 * Shared PERMISSION_READ_WRITE session pools used by both {@link ReadModifyWriteRowShim} and {@link
 * CheckAndMutateRowShim}. Keeping a single pool per table unifies circuit-breaker tracking and
 * halves session connections when both RPCs are in use. Lifecycle is managed by {@link Client}:
 * pools are registered on creation and closed when the client closes.
 */
public class ReadWriteSessionPools {
  final SessionPoolMap<TableId, TableAsync> tables;
  final SessionPoolMap<AuthorizedViewId, AuthorizedViewAsync> authViews;

  public ReadWriteSessionPools(Client client) {
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
}
