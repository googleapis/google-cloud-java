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
import javax.annotation.Nonnull;

/**
 * Parameters for creating a new Cloud Bigtable {@link AuthorizedView}, which represents subsets of
 * a particular table.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * CreateAuthorizedViewRequest request =
 *     CreateAuthorizedViewRequest.of("my-table", "my-new-authorized-view")
 *         .setAuthorizedViewType(
 *             SubsetView.create()
 *                 .addRowPrefix("row#")
 *                 .addFamilySubsets(
 *                     "my-family", FamilySubsets.create().addQualifier("column")));
 * }</pre>
 *
 * @see AuthorizedView for more details.
 */
public final class CreateAuthorizedViewRequest {
  private final String tableId;
  private final com.google.bigtable.admin.v2.CreateAuthorizedViewRequest.Builder requestBuilder =
      com.google.bigtable.admin.v2.CreateAuthorizedViewRequest.newBuilder();

  public static CreateAuthorizedViewRequest of(
      @Nonnull String tableId, @Nonnull String authorizedViewId) {
    return new CreateAuthorizedViewRequest(tableId, authorizedViewId);
  }

  private CreateAuthorizedViewRequest(@Nonnull String tableId, @Nonnull String authorizedViewId) {
    Preconditions.checkNotNull(tableId, "tableId must be set");
    Preconditions.checkNotNull(authorizedViewId, "authorizedViewId must be set");

    this.tableId = tableId;
    requestBuilder.setAuthorizedViewId(authorizedViewId);
  }

  /** Configures if the authorized view is deletion protected. */
  public CreateAuthorizedViewRequest setDeletionProtection(boolean deletionProtection) {
    requestBuilder.getAuthorizedViewBuilder().setDeletionProtection(deletionProtection);
    return this;
  }

  /**
   * Sets the implementation for this authorized view.
   *
   * @see AuthorizedViewType for details.
   */
  public CreateAuthorizedViewRequest setAuthorizedViewType(
      @Nonnull AuthorizedViewType authorizedViewType) {
    Preconditions.checkNotNull(authorizedViewType, "authorizedViewType must be set");

    if (authorizedViewType instanceof SubsetView) {
      requestBuilder
          .getAuthorizedViewBuilder()
          .setSubsetView(((SubsetView) authorizedViewType).toProto());
    } else {
      throw new IllegalArgumentException("Unknown authorizedViewType: " + authorizedViewType);
    }

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
    CreateAuthorizedViewRequest that = (CreateAuthorizedViewRequest) o;
    return Objects.equal(requestBuilder.build(), that.requestBuilder.build())
        && Objects.equal(tableId, that.tableId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(requestBuilder.build(), tableId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.CreateAuthorizedViewRequest toProto(
      @Nonnull String projectId, @Nonnull String instanceId) {
    return requestBuilder
        .setParent(NameUtil.formatTableName(projectId, instanceId, tableId))
        .build();
  }
}
