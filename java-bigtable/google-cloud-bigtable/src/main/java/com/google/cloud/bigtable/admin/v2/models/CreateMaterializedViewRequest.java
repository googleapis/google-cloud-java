/*
 * Copyright 2018 Google LLC
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
import javax.annotation.Nonnull;

/**
 * Parameters for creating a new Cloud Bigtable materialized view.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * MaterializedView existingMaterializedView = ...;
 * CreateMaterializedViewRequest materializedViewRequest = CreateMaterializedViewRequest.of("my-instance", "my-new-materialized-view")
 *   .setQuery("...");
 * }</pre>
 *
 * @see MaterializedView for more details
 */
public final class CreateMaterializedViewRequest {
  private final String instanceId;
  private final com.google.bigtable.admin.v2.CreateMaterializedViewRequest.Builder proto;

  /** Builds a new request to create a new materialized view in the specified instance. */
  public static CreateMaterializedViewRequest of(String instanceId, String materializedViewId) {
    return new CreateMaterializedViewRequest(instanceId, materializedViewId);
  }

  private CreateMaterializedViewRequest(String instanceId, String materializedViewId) {
    this.instanceId = instanceId;
    this.proto = com.google.bigtable.admin.v2.CreateMaterializedViewRequest.newBuilder();

    proto.setMaterializedViewId(materializedViewId);
  }

  /** Configures if the materialized view is deletion protected. */
  @SuppressWarnings("WeakerAccess")
  public CreateMaterializedViewRequest setDeletionProtection(boolean value) {
    proto.getMaterializedViewBuilder().setDeletionProtection(value);
    return this;
  }

  /** Sets the query of the MaterializedView. */
  @SuppressWarnings("WeakerAccess")
  public CreateMaterializedViewRequest setQuery(@Nonnull String query) {
    proto.getMaterializedViewBuilder().setQuery(query);
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
    CreateMaterializedViewRequest that = (CreateMaterializedViewRequest) o;
    return Objects.equal(proto.build(), that.proto.build())
        && Objects.equal(instanceId, that.instanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto.build(), instanceId);
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.CreateMaterializedViewRequest toProto(String projectId) {
    String name = NameUtil.formatInstanceName(projectId, instanceId);

    return proto.setParent(name).build();
  }
}
