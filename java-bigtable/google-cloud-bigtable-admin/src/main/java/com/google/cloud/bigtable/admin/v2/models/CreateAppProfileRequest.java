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

/**
 * Parameters for creating a new Cloud Bigtable app profile.
 *
 * <p>An application profile, or app profile, stores settings that tell your Cloud Bigtable instance
 * how to handle incoming requests from an application. When one of your applications connects to a
 * Cloud Bigtable instance, it can specify an app profile, and Cloud Bigtable uses that app profile
 * for any requests that the application sends over that connection.
 *
 * <p>Sample code:
 *
 * <pre>{@code
 * AppProfile existingAppProfile = ...;
 * CreateAppProfileRequest appProfileRequest = CreateAppProfileRequest.of("my-instance", "my-new-app-profile")
 *   .setRoutingPolicy(SingleClusterRoutingPolicy.of("my-cluster"));
 * }</pre>
 *
 * @see AppProfile for more details
 */
public final class CreateAppProfileRequest {
  private final String instanceId;
  private final com.google.bigtable.admin.v2.CreateAppProfileRequest.Builder proto;

  /** Builds a new request to create a new app profile in the specified instance. */
  public static CreateAppProfileRequest of(String instanceId, String appProfileId) {
    return new CreateAppProfileRequest(instanceId, appProfileId);
  }

  private CreateAppProfileRequest(String instanceId, String appProfileId) {
    this.instanceId = instanceId;
    this.proto = com.google.bigtable.admin.v2.CreateAppProfileRequest.newBuilder();

    proto.setAppProfileId(appProfileId);
    proto.getAppProfileBuilder().setDescription(appProfileId);
  }

  /** Configures if safety warnings should be disabled. */
  @SuppressWarnings("WeakerAccess")
  public CreateAppProfileRequest setIgnoreWarnings(boolean value) {
    proto.setIgnoreWarnings(value);
    return this;
  }

  /** Sets the optional long form description of the use case for the AppProfile. */
  @SuppressWarnings("WeakerAccess")
  public CreateAppProfileRequest setDescription(@Nonnull String description) {
    proto.getAppProfileBuilder().setDescription(description);
    return this;
  }

  /** Sets the routing policy for all read/write requests that use this app profile. */
  @SuppressWarnings("WeakerAccess")
  public CreateAppProfileRequest setRoutingPolicy(RoutingPolicy routingPolicy) {
    Preconditions.checkNotNull(routingPolicy);

    if (routingPolicy instanceof MultiClusterRoutingPolicy) {
      proto
          .getAppProfileBuilder()
          .setMultiClusterRoutingUseAny(((MultiClusterRoutingPolicy) routingPolicy).toProto());
    } else if (routingPolicy instanceof SingleClusterRoutingPolicy) {
      proto
          .getAppProfileBuilder()
          .setSingleClusterRouting(((SingleClusterRoutingPolicy) routingPolicy).toProto());
    } else {
      throw new IllegalArgumentException("Unknown policy type: " + routingPolicy);
    }

    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.CreateAppProfileRequest toProto(ProjectName projectName) {
    InstanceName name = InstanceName.of(projectName.getProject(), instanceId);

    return proto.setParent(name.toString()).build();
  }
}
