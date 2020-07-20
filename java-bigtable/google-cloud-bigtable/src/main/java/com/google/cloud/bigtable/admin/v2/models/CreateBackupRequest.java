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
import com.google.protobuf.util.Timestamps;
import javax.annotation.Nonnull;
import org.threeten.bp.Instant;

/** Fluent wrapper for {@link com.google.bigtable.admin.v2.CreateBackupRequest} */
public final class CreateBackupRequest {
  private final com.google.bigtable.admin.v2.CreateBackupRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.CreateBackupRequest.newBuilder();
  private final String clusterId;
  private String sourceTableId;

  public static CreateBackupRequest of(String clusterId, String backupId) {
    CreateBackupRequest request = new CreateBackupRequest(clusterId, backupId);
    return request;
  }

  private CreateBackupRequest(String clusterId, String backupId) {
    Preconditions.checkNotNull(clusterId);
    Preconditions.checkNotNull(backupId);

    requestBuilder.setBackupId(backupId);
    this.clusterId = clusterId;
    this.sourceTableId = null;
  }

  public CreateBackupRequest setSourceTableId(String sourceTableId) {
    Preconditions.checkNotNull(sourceTableId);
    this.sourceTableId = sourceTableId;
    return this;
  }

  public CreateBackupRequest setExpireTime(Instant expireTime) {
    Preconditions.checkNotNull(expireTime);
    requestBuilder
        .getBackupBuilder()
        .setExpireTime(Timestamps.fromMillis(expireTime.toEpochMilli()));
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
    CreateBackupRequest that = (CreateBackupRequest) o;
    return Objects.equal(requestBuilder.getBackupId(), that.requestBuilder.getBackupId())
        && Objects.equal(clusterId, that.clusterId)
        && Objects.equal(sourceTableId, that.sourceTableId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.getBackupId(), clusterId, sourceTableId);
  }

  @InternalApi
  public com.google.bigtable.admin.v2.CreateBackupRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    Preconditions.checkNotNull(projectId);
    Preconditions.checkNotNull(instanceId);

    requestBuilder
        .getBackupBuilder()
        .setSourceTable(NameUtil.formatTableName(projectId, instanceId, sourceTableId));
    return requestBuilder
        .setParent(NameUtil.formatClusterName(projectId, instanceId, clusterId))
        .build();
  }
}
