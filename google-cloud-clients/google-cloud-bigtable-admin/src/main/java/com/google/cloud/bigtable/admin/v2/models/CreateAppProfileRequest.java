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
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.MultiClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.RoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

public class CreateAppProfileRequest {
  private final String instanceId;
  private final com.google.bigtable.admin.v2.CreateAppProfileRequest.Builder proto;

  public CreateAppProfileRequest of(String instanceId, String appProfileId) {
    return new CreateAppProfileRequest(instanceId, appProfileId);
  }

  private CreateAppProfileRequest(String instanceId, String appProfileId) {
    this.instanceId = instanceId;
    this.proto = com.google.bigtable.admin.v2.CreateAppProfileRequest.newBuilder();

    proto.setAppProfileId(appProfileId);
    proto.getAppProfileBuilder().setDescription(appProfileId);
  }

  public CreateAppProfileRequest setIgnoreWarnings(boolean value) {
    proto.setIgnoreWarnings(value);
    return this;
  }

  public CreateAppProfileRequest setDescription(@Nonnull String description) {
    proto.getAppProfileBuilder().setDescription(description);
    return this;
  }

  public CreateAppProfileRequest setRoutingPolicy(RoutingPolicy routingPolicy) {
    Preconditions.checkNotNull(routingPolicy);

    if (routingPolicy instanceof MultiClusterRoutingPolicy) {
      proto.getAppProfileBuilder().setMultiClusterRoutingUseAny(((MultiClusterRoutingPolicy)routingPolicy).toProto());
    } else if (routingPolicy instanceof SingleClusterRoutingPolicy) {
      proto.getAppProfileBuilder().setSingleClusterRouting(((SingleClusterRoutingPolicy)routingPolicy).toProto());
    } else {
      throw new IllegalArgumentException("Unknown policy type: " + routingPolicy);
    }

    return this;
  }

  @InternalApi
  public com.google.bigtable.admin.v2.CreateAppProfileRequest toProto(ProjectName projectName) {
    InstanceName name = InstanceName.of(projectName.getProject(), instanceId);

    return proto.setParent(name.toString()).build();
  }
}
