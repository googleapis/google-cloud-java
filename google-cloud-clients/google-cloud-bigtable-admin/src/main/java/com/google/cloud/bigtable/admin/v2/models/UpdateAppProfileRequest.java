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
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest.Builder;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.MultiClusterRoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.RoutingPolicy;
import com.google.cloud.bigtable.admin.v2.models.AppProfile.SingleClusterRoutingPolicy;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import javax.annotation.Nonnull;

public class UpdateAppProfileRequest {
  private final String instanceId;
  private final String appProfileId;

  private final com.google.bigtable.admin.v2.UpdateAppProfileRequest.Builder proto;

  public static UpdateAppProfileRequest of(@Nonnull String instanceId, @Nonnull String appProfileId) {
    return new UpdateAppProfileRequest(instanceId, appProfileId,
        com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder());
  }

  public static UpdateAppProfileRequest of(@Nonnull AppProfile appProfile) {
    return new UpdateAppProfileRequest(appProfile.getInstanceId(), appProfile.getId(),
        com.google.bigtable.admin.v2.UpdateAppProfileRequest.newBuilder()
          .setAppProfile(appProfile.getProto())
        );
  }

  private UpdateAppProfileRequest(@Nonnull String instanceId, @Nonnull String appProfileId, @Nonnull Builder builder) {
    Preconditions.checkNotNull(instanceId, "instanceId must be set");
    Preconditions.checkNotNull(appProfileId, "appProfileId must be set");
    Verify.verifyNotNull(builder);

    this.instanceId = instanceId;
    this.appProfileId = appProfileId;
    this.proto = builder;
  }

  public UpdateAppProfileRequest setIgnoreWarnings(boolean value) {
    proto.setIgnoreWarnings(value);
    return this;
  }

  public UpdateAppProfileRequest setDescription(@Nonnull String description) {
    Preconditions.checkNotNull(description);

    proto.getAppProfileBuilder().setDescription(description);
    updateFieldMask(com.google.bigtable.admin.v2.AppProfile.DESCRIPTION_FIELD_NUMBER);
    return this;
  }

  public UpdateAppProfileRequest setRoutingPolicy(RoutingPolicy routingPolicy) {
    Preconditions.checkNotNull(routingPolicy);

    if (routingPolicy instanceof MultiClusterRoutingPolicy) {
      proto.getAppProfileBuilder().setMultiClusterRoutingUseAny(((MultiClusterRoutingPolicy)routingPolicy).toProto());
      updateFieldMask(com.google.bigtable.admin.v2.AppProfile.MULTI_CLUSTER_ROUTING_USE_ANY_FIELD_NUMBER);
    } else if (routingPolicy instanceof SingleClusterRoutingPolicy) {
      proto.getAppProfileBuilder().setSingleClusterRouting(((SingleClusterRoutingPolicy)routingPolicy).toProto());
      updateFieldMask(com.google.bigtable.admin.v2.AppProfile.SINGLE_CLUSTER_ROUTING_FIELD_NUMBER);
    } else {
      throw new IllegalArgumentException("Unknown policy type: " + routingPolicy);
    }

    return this;
  }

  private void updateFieldMask(int fieldNumber) {
    FieldMask newMask = FieldMaskUtil.fromFieldNumbers(com.google.bigtable.admin.v2.AppProfile.class, fieldNumber);
    proto.setUpdateMask(FieldMaskUtil.union(proto.getUpdateMask(), newMask));
  }

  @InternalApi
  public com.google.bigtable.admin.v2.UpdateAppProfileRequest toProto(ProjectName projectName) {
    AppProfileName name = AppProfileName.of(projectName.getProject(), instanceId, appProfileId);

    proto.getAppProfileBuilder().setName(name.toString());

    return proto.build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateAppProfileRequest that = (UpdateAppProfileRequest) o;
    return Objects.equal(instanceId, that.instanceId) &&
        Objects.equal(appProfileId, that.appProfileId) &&
        Objects.equal(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(instanceId, appProfileId, proto);
  }
}
