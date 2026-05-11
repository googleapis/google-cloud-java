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
 * Parameters for updating an existing Cloud Bigtable {@link LogicalView}.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * LogicalView existingLogicalView = client.getLogicalView("my-table", "my-logical-view");
 * UpdateLogicalViewRequest request =
 *     UpdateLogicalViewRequest.of(existingLogicalView).setQuery(query);
 * }</pre>
 *
 * @see LogicalView for more details.
 */
public final class UpdateLogicalViewRequest {
  private final com.google.bigtable.admin.v2.UpdateLogicalViewRequest.Builder requestBuilder;
  private final String instanceId;
  private final String logicalViewId;

  /** Builds a new update request using an existing logical view. */
  public static UpdateLogicalViewRequest of(@Nonnull LogicalView logicalView) {
    return new UpdateLogicalViewRequest(
        logicalView.getId(),
        logicalView.getInstanceId(),
        com.google.bigtable.admin.v2.UpdateLogicalViewRequest.newBuilder()
            .setLogicalView(logicalView.toProto()));
  }

  /** Builds a new update logical view request. */
  public static UpdateLogicalViewRequest of(
      @Nonnull String instanceId, @Nonnull String logicalViewId) {
    return new UpdateLogicalViewRequest(
        logicalViewId,
        instanceId,
        com.google.bigtable.admin.v2.UpdateLogicalViewRequest.newBuilder());
  }

  private UpdateLogicalViewRequest(
      @Nonnull String logicalViewId,
      @Nonnull String instanceId,
      @Nonnull com.google.bigtable.admin.v2.UpdateLogicalViewRequest.Builder requestBuilder) {
    Preconditions.checkNotNull(instanceId, "instanceId must be set");
    Preconditions.checkNotNull(logicalViewId, "logicalViewId must be set");
    Preconditions.checkNotNull(requestBuilder, "proto builder must be set");

    this.instanceId = instanceId;
    this.logicalViewId = logicalViewId;
    this.requestBuilder = requestBuilder;
  }

  /** Changes the query of an existing logical view. */
  public UpdateLogicalViewRequest setQuery(String query) {
    requestBuilder.getLogicalViewBuilder().setQuery(query);
    updateFieldMask(com.google.bigtable.admin.v2.LogicalView.QUERY_FIELD_NUMBER);
    return this;
  }

  /** Changes the deletion protection of an existing logical view. */
  public UpdateLogicalViewRequest setDeletionProtection(boolean deletionProtection) {
    requestBuilder.getLogicalViewBuilder().setDeletionProtection(deletionProtection);
    updateFieldMask(com.google.bigtable.admin.v2.LogicalView.DELETION_PROTECTION_FIELD_NUMBER);
    return this;
  }

  private void updateFieldMask(int fieldNumber) {
    FieldMask newMask =
        FieldMaskUtil.fromFieldNumbers(com.google.bigtable.admin.v2.LogicalView.class, fieldNumber);
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
    UpdateLogicalViewRequest that = (UpdateLogicalViewRequest) o;
    return Objects.equal(requestBuilder.build(), that.requestBuilder.build())
        && Objects.equal(logicalViewId, that.logicalViewId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.build(), logicalViewId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.UpdateLogicalViewRequest toProto(@Nonnull String projectId) {
    requestBuilder
        .getLogicalViewBuilder()
        .setName(NameUtil.formatLogicalViewName(projectId, instanceId, logicalViewId));
    return requestBuilder.build();
  }
}
