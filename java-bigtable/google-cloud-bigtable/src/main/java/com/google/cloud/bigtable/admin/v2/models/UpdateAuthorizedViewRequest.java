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
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView.AuthorizedViewType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import javax.annotation.Nonnull;

/**
 * Parameters for updating an existing Cloud Bigtable {@link AuthorizedView}.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * AuthorizedView existingAuthorizedView = client.getAuthorizedView("my-table", "my-authorized-view");
 * UpdateAuthorizedViewRequest request =
 *     UpdateAuthorizedViewRequest.of(existingAuthorizedView).setDeletionProtection(true);
 * }</pre>
 *
 * @see AuthorizedView for more details.
 */
public final class UpdateAuthorizedViewRequest {
  private final com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.Builder requestBuilder;
  private final String tableId;
  private final String authorizedViewId;

  /** Builds a new update request using an existing authorized view. */
  public static UpdateAuthorizedViewRequest of(@Nonnull AuthorizedView authorizedView) {
    return new UpdateAuthorizedViewRequest(
        authorizedView.getTableId(),
        authorizedView.getId(),
        com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.newBuilder()
            .setAuthorizedView(authorizedView.toProto()));
  }

  /** Builds a new update authorized view request. */
  public static UpdateAuthorizedViewRequest of(
      @Nonnull String tableId, @Nonnull String authorizedViewId) {
    return new UpdateAuthorizedViewRequest(
        tableId,
        authorizedViewId,
        com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.newBuilder());
  }

  private UpdateAuthorizedViewRequest(
      @Nonnull String tableId,
      @Nonnull String authorizedViewId,
      @Nonnull com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest.Builder requestBuilder) {
    Preconditions.checkNotNull(tableId, "tableId must be set");
    Preconditions.checkNotNull(authorizedViewId, "authorizedViewId must be set");
    Preconditions.checkNotNull(requestBuilder, "proto builder must be set");

    this.tableId = tableId;
    this.authorizedViewId = authorizedViewId;
    this.requestBuilder = requestBuilder;
  }

  /** Changes the deletion protection of an existing authorized view. */
  public UpdateAuthorizedViewRequest setDeletionProtection(boolean deletionProtection) {
    requestBuilder.getAuthorizedViewBuilder().setDeletionProtection(deletionProtection);
    updateFieldMask(com.google.bigtable.admin.v2.AuthorizedView.DELETION_PROTECTION_FIELD_NUMBER);
    return this;
  }

  /**
   * Updates the implementation for this authorized view.
   *
   * @see AuthorizedViewType for details.
   */
  public UpdateAuthorizedViewRequest setAuthorizedViewType(
      @Nonnull AuthorizedViewType authorizedViewType) {
    Preconditions.checkNotNull(authorizedViewType, "authorizedViewType must be set");

    if (authorizedViewType instanceof SubsetView) {
      requestBuilder
          .getAuthorizedViewBuilder()
          .setSubsetView(((SubsetView) authorizedViewType).toProto());
      updateFieldMask(com.google.bigtable.admin.v2.AuthorizedView.SUBSET_VIEW_FIELD_NUMBER);
    } else {
      throw new IllegalArgumentException("Unknown authorizedViewType: " + authorizedViewType);
    }

    return this;
  }

  /**
   * Configures if safety warnings should be disabled. If set, then updates that making the
   * authorized view more restrictive are allowed.
   */
  @SuppressWarnings("WeakerAccess")
  public UpdateAuthorizedViewRequest setIgnoreWarnings(boolean value) {
    requestBuilder.setIgnoreWarnings(value);
    return this;
  }

  private void updateFieldMask(int fieldNumber) {
    FieldMask newMask =
        FieldMaskUtil.fromFieldNumbers(
            com.google.bigtable.admin.v2.AuthorizedView.class, fieldNumber);
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
    UpdateAuthorizedViewRequest that = (UpdateAuthorizedViewRequest) o;
    return Objects.equal(requestBuilder.build(), that.requestBuilder.build())
        && Objects.equal(tableId, that.tableId)
        && Objects.equal(authorizedViewId, that.authorizedViewId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.build(), tableId, authorizedViewId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.UpdateAuthorizedViewRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    requestBuilder
        .getAuthorizedViewBuilder()
        .setName(
            NameUtil.formatAuthorizedViewName(projectId, instanceId, tableId, authorizedViewId));
    return requestBuilder.build();
  }
}
