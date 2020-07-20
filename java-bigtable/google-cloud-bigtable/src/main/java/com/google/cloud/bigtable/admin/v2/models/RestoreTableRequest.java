/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/** Fluent wrapper for {@link com.google.bigtable.admin.v2.RestoreTableRequest} */
public final class RestoreTableRequest {
  private final com.google.bigtable.admin.v2.RestoreTableRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.RestoreTableRequest.newBuilder();
  private final String backupId;
  private final String clusterId;

  public static RestoreTableRequest of(String clusterId, String backupId) {
    RestoreTableRequest request = new RestoreTableRequest(clusterId, backupId);
    return request;
  }

  private RestoreTableRequest(String clusterId, String backupId) {
    Preconditions.checkNotNull(clusterId);
    Preconditions.checkNotNull(backupId);
    this.backupId = backupId;
    this.clusterId = clusterId;
  }

  public RestoreTableRequest setTableId(String tableId) {
    Preconditions.checkNotNull(tableId);
    requestBuilder.setTableId(tableId);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestoreTableRequest that = (RestoreTableRequest) o;
    return Objects.equal(requestBuilder.getTableId(), that.requestBuilder.getTableId())
        && Objects.equal(clusterId, that.clusterId)
        && Objects.equal(backupId, that.backupId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.getTableId(), clusterId, backupId);
  }

  @InternalApi
  public com.google.bigtable.admin.v2.RestoreTableRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);

    return requestBuilder
        .setParent(NameUtil.formatInstanceName(projectId, instanceId))
        .setBackup(NameUtil.formatBackupName(projectId, instanceId, clusterId, backupId))
        .build();
  }
}
