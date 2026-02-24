/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.schema;

import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.ProjectName;
import io.opentelemetry.api.common.Attributes;

/**
 * The attributes for this schema are partially populated during the record phase and finalized
 * during the export phase with {@link EnvInfo}. This is necessary because resolving {@link EnvInfo}
 * is slow and should not happen during client startup.
 */
public final class GrpcClientSchema extends Schema {
  // Unlike the normal ClientSchema, the bigtable resource ids must be injected during export time
  private static final DeferredAttr BIGTABLE_PROJECT_ID =
      DeferredAttr.fromClientInfo("project_id", ci -> ci.getInstanceName().getProject());
  private static final DeferredAttr INSTANCE_ID =
      DeferredAttr.fromClientInfo("instance", ci -> ci.getInstanceName().getInstance());
  private static final DeferredAttr APP_PROFILE_ID =
      DeferredAttr.fromClientInfo("app_profile", ClientInfo::getAppProfileId);
  private static final DeferredAttr CLIENT_NAME =
      DeferredAttr.fromClientInfo("client_name", ClientInfo::getClientName);

  private static final DeferredAttr CLIENT_PROJECT =
      DeferredAttr.fromEnv("client_project", EnvInfo::getProject);
  private static final DeferredAttr CLIENT_REGION =
      DeferredAttr.fromEnv("region", EnvInfo::getRegion);
  private static final DeferredAttr CLOUD_PLATFORM =
      DeferredAttr.fromEnv("cloud_platform", EnvInfo::getPlatform);
  private static final DeferredAttr HOST_ID = DeferredAttr.fromEnv("host_id", EnvInfo::getHostId);
  private static final DeferredAttr HOST_NAME =
      DeferredAttr.fromEnv("host_name", EnvInfo::getHostName);
  private static final DeferredAttr UUID = DeferredAttr.fromEnv("uuid", EnvInfo::getUid);

  // Must come after all other static members
  public static final GrpcClientSchema INSTANCE = new GrpcClientSchema();

  private GrpcClientSchema() {
    super(
        "bigtable_client",
        ImmutableList.of(),
        ImmutableList.of(
            BIGTABLE_PROJECT_ID,
            INSTANCE_ID,
            APP_PROFILE_ID,
            CLIENT_NAME,
            // Same as ClientSchema
            CLIENT_PROJECT,
            CLIENT_REGION,
            CLOUD_PLATFORM,
            HOST_ID,
            HOST_NAME,
            UUID));
  }

  @Override
  public ProjectName extractProjectName(
      Attributes ignored, EnvInfo ignored2, ClientInfo clientInfo) {
    return ProjectName.of(clientInfo.getInstanceName().getProject());
  }
}
