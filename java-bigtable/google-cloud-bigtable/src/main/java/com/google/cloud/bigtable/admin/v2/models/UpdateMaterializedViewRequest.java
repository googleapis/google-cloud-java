/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import javax.annotation.Nonnull;

/**
 * Parameters for updating an existing Cloud Bigtable {@link MaterializedView}.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * MaterializedView existingMaterializedView = client.getMaterializedView("my-table", "my-materialized-view");
 * UpdateMaterializedViewRequest request =
 *     UpdateMaterializedViewRequest.of(existingMaterializedView).setDeletionProtection(true);
 * }</pre>
 *
 * @see MaterializedView for more details.
 */
public final class UpdateMaterializedViewRequest {
  private final com.google.bigtable.admin.v2.UpdateMaterializedViewRequest.Builder requestBuilder;
  private final String instanceId;
  private final String materializedViewId;

  /** Builds a new update request using an existing materialized view. */
  public static UpdateMaterializedViewRequest of(@Nonnull MaterializedView materializedView) {
    return new UpdateMaterializedViewRequest(
        materializedView.getId(),
        materializedView.getInstanceId(),
        com.google.bigtable.admin.v2.UpdateMaterializedViewRequest.newBuilder()
            .setMaterializedView(materializedView.toProto()));
  }

  /** Builds a new update materialized view request. */
  public static UpdateMaterializedViewRequest of(
      @Nonnull String instanceId, @Nonnull String materializedViewId) {
    return new UpdateMaterializedViewRequest(
        materializedViewId,
        instanceId,
        com.google.bigtable.admin.v2.UpdateMaterializedViewRequest.newBuilder());
  }

  private UpdateMaterializedViewRequest(
      @Nonnull String materializedViewId,
      @Nonnull String instanceId,
      @Nonnull com.google.bigtable.admin.v2.UpdateMaterializedViewRequest.Builder requestBuilder) {
    Preconditions.checkNotNull(instanceId, "instanceId must be set");
    Preconditions.checkNotNull(materializedViewId, "materializedViewId must be set");
    Preconditions.checkNotNull(requestBuilder, "proto builder must be set");

    this.instanceId = instanceId;
    this.materializedViewId = materializedViewId;
    this.requestBuilder = requestBuilder;
  }

  /** Changes the deletion protection of an existing materialized view. */
  public UpdateMaterializedViewRequest setDeletionProtection(boolean deletionProtection) {
    requestBuilder.getMaterializedViewBuilder().setDeletionProtection(deletionProtection);
    updateFieldMask(com.google.bigtable.admin.v2.MaterializedView.DELETION_PROTECTION_FIELD_NUMBER);
    return this;
  }

  private void updateFieldMask(int fieldNumber) {
    FieldMask newMask =
        FieldMaskUtil.fromFieldNumbers(
            com.google.bigtable.admin.v2.MaterializedView.class, fieldNumber);
    requestBuilder.setUpdateMask(FieldMaskUtil.union(requestBuilder.getUpdateMask(), newMask));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMaterializedViewRequest that = (UpdateMaterializedViewRequest) o;
    return Objects.equal(requestBuilder.build(), that.requestBuilder.build())
        && Objects.equal(materializedViewId, that.materializedViewId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.build(), materializedViewId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.UpdateMaterializedViewRequest toProto(
      @Nonnull String projectId) {
    requestBuilder
        .getMaterializedViewBuilder()
        .setName(NameUtil.formatMaterializedViewName(projectId, instanceId, materializedViewId));
    return requestBuilder.build();
  }
}
