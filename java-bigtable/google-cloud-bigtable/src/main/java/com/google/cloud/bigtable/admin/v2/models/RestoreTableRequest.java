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
import javax.annotation.Nullable;

/** Fluent wrapper for {@link com.google.bigtable.admin.v2.RestoreTableRequest} */
public final class RestoreTableRequest {
  private final com.google.bigtable.admin.v2.RestoreTableRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.RestoreTableRequest.newBuilder();
  private final String sourceBackupId;
  private final String sourceClusterId;
  private final String sourceInstanceId;
  private final String sourceProjectId;

  /**
   * Create a {@link RestoreTableRequest} object. It assumes the source backup locates in the same
   * instance and project as the destination table. To restore a table from a backup in another
   * instance, use {@link #of(String, String, String) of} method. To restore a table from a backup
   * in another project, use {@link #of(String, String, String, String) of} method.
   */
  public static RestoreTableRequest of(String sourceClusterId, String sourceBackupId) {
    RestoreTableRequest request =
        new RestoreTableRequest(null, sourceClusterId, sourceBackupId, null);
    return request;
  }

  /**
   * Create a {@link RestoreTableRequest} object. The source backup could locate in the same or a
   * different instance but the same project as the destination table. To restore a table from a
   * backup in another project, use {@link #of(String, String, String, String) of} method.
   */
  public static RestoreTableRequest of(
      String sourceInstanceId, String sourceClusterId, String sourceBackupId) {
    RestoreTableRequest request =
        new RestoreTableRequest(sourceInstanceId, sourceClusterId, sourceBackupId, null);
    return request;
  }

  /**
   * Create a {@link RestoreTableRequest} object. The source backup could locate in the same or a
   * different instance and/or project.
   */
  public static RestoreTableRequest of(
      String sourceInstanceId,
      String sourceClusterId,
      String sourceBackupId,
      String sourceProjectId) {
    RestoreTableRequest request =
        new RestoreTableRequest(sourceInstanceId, sourceClusterId, sourceBackupId, sourceProjectId);
    return request;
  }

  private RestoreTableRequest(
      @Nullable String sourceInstanceId,
      @Nonnull String sourceClusterId,
      @Nonnull String sourceBackupId,
      @Nullable String sourceProjectId) {
    Preconditions.checkNotNull(sourceClusterId);
    Preconditions.checkNotNull(sourceBackupId);
    this.sourceBackupId = sourceBackupId;
    this.sourceInstanceId = sourceInstanceId;
    this.sourceClusterId = sourceClusterId;
    this.sourceProjectId = sourceProjectId;
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
        && Objects.equal(sourceInstanceId, that.sourceInstanceId)
        && Objects.equal(sourceClusterId, that.sourceClusterId)
        && Objects.equal(sourceBackupId, that.sourceBackupId)
        && Objects.equal(sourceProjectId, that.sourceProjectId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        requestBuilder.getTableId(),
        sourceInstanceId,
        sourceClusterId,
        sourceBackupId,
        sourceProjectId);
  }

  @InternalApi
  public com.google.bigtable.admin.v2.RestoreTableRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);

    return requestBuilder
        .setParent(NameUtil.formatInstanceName(projectId, instanceId))
        .setBackup(
            NameUtil.formatBackupName(
                sourceProjectId == null ? projectId : sourceProjectId,
                sourceInstanceId == null ? instanceId : sourceInstanceId,
                sourceClusterId,
                sourceBackupId))
        .build();
  }
}
