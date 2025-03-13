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
 * Parameters for creating a new Cloud Bigtable logical view.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * LogicalView existingLogicalView = ...;
 * CreateLogicalViewRequest logicalViewRequest = CreateLogicalViewRequest.of("my-instance", "my-new-logical-view")
 *   .setQuery("...");
 * }</pre>
 *
 * @see LogicalView for more details
 */
public final class CreateLogicalViewRequest {
  private final String instanceId;
  private final com.google.bigtable.admin.v2.CreateLogicalViewRequest.Builder proto;

  /** Builds a new request to create a new logical view in the specified instance. */
  public static CreateLogicalViewRequest of(String instanceId, String logicalViewId) {
    return new CreateLogicalViewRequest(instanceId, logicalViewId);
  }

  private CreateLogicalViewRequest(String instanceId, String logicalViewId) {
    this.instanceId = instanceId;
    this.proto = com.google.bigtable.admin.v2.CreateLogicalViewRequest.newBuilder();

    proto.setLogicalViewId(logicalViewId);
  }

  /** Sets the query of the LogicalView. */
  @SuppressWarnings("WeakerAccess")
  public CreateLogicalViewRequest setQuery(@Nonnull String query) {
    proto.getLogicalViewBuilder().setQuery(query);
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
    CreateLogicalViewRequest that = (CreateLogicalViewRequest) o;
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
  public com.google.bigtable.admin.v2.CreateLogicalViewRequest toProto(String projectId) {
    String name = NameUtil.formatInstanceName(projectId, instanceId);

    return proto.setParent(name).build();
  }
}
