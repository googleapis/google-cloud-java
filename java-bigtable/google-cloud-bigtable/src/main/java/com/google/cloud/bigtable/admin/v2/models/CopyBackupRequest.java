/*
 * Copyright 2022 Google LLC
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
import com.google.protobuf.util.Timestamps;
import javax.annotation.Nonnull;
import org.threeten.bp.Instant;

/** Build CopyBackupRequest for {@link com.google.bigtable.admin.v2.CopyBackupRequest}. */
public final class CopyBackupRequest {
  private final com.google.bigtable.admin.v2.CopyBackupRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.CopyBackupRequest.newBuilder();
  private final String sourceBackupId;
  private final String sourceClusterId;
  private String sourceInstanceId;
  private String sourceProjectId;

  private String destClusterId;

  /**
   * Create a {@link CopyBackupRequest} object. It assumes the source backup is located in the same
   * instance and project as the destination backup, which is where the BigtableTableAdminClient is
   * created in. use setSourceInstance("[INSTANCE]") if the source backup is located in a different
   * instance. use setSourceInstance("[PROJECT]", "[INSTANCE]") if the source backup is located in a
   * different project.
   */
  public static CopyBackupRequest of(String sourceClusterId, String sourceBackupId) {
    CopyBackupRequest request = new CopyBackupRequest(sourceClusterId, sourceBackupId);
    return request;
  }

  private CopyBackupRequest(@Nonnull String sourceClusterId, @Nonnull String sourceBackupId) {
    Preconditions.checkNotNull(sourceClusterId);
    Preconditions.checkNotNull(sourceBackupId);
    this.sourceClusterId = sourceClusterId;
    this.sourceBackupId = sourceBackupId;
  }

  public CopyBackupRequest setSourceInstance(String instanceId) {
    Preconditions.checkNotNull(instanceId);
    this.sourceInstanceId = instanceId;
    return this;
  }

  public CopyBackupRequest setSourceInstance(String projectId, String instanceId) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);
    this.sourceProjectId = projectId;
    this.sourceInstanceId = instanceId;
    return this;
  }

  public CopyBackupRequest setDestination(String clusterId, String backupId) {
    Preconditions.checkNotNull(backupId);
    Preconditions.checkNotNull(clusterId);
    requestBuilder.setBackupId(backupId);
    this.destClusterId = clusterId;
    return this;
  }

  public CopyBackupRequest setExpireTime(Instant expireTime) {
    Preconditions.checkNotNull(expireTime);
    requestBuilder.setExpireTime(Timestamps.fromMillis(expireTime.toEpochMilli()));
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
    CopyBackupRequest that = (CopyBackupRequest) o;
    return Objects.equal(requestBuilder.getBackupId(), that.requestBuilder.getBackupId())
        && Objects.equal(sourceBackupId, that.sourceBackupId)
        && Objects.equal(sourceClusterId, that.sourceClusterId)
        && Objects.equal(sourceInstanceId, that.sourceInstanceId)
        && Objects.equal(sourceProjectId, that.sourceProjectId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        requestBuilder.getBackupId(),
        sourceBackupId,
        sourceClusterId,
        sourceInstanceId,
        sourceProjectId);
  }

  @InternalApi
  public com.google.bigtable.admin.v2.CopyBackupRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);

    return requestBuilder
        .setParent(NameUtil.formatClusterName(projectId, instanceId, destClusterId))
        .setSourceBackup(
            NameUtil.formatBackupName(
                sourceProjectId == null ? projectId : sourceProjectId,
                sourceInstanceId == null ? instanceId : sourceInstanceId,
                sourceClusterId,
                sourceBackupId))
        .build();
  }
}
