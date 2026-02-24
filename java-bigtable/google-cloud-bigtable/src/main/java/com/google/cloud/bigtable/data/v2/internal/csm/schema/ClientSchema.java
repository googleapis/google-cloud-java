/*
 * Copyright 2026 Google LLC
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
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;

/**
 * The attributes for this schema are partially populated during the record phase and finalized
 * during the export phase with {@link EnvInfo}. This is necessary because resolving {@link EnvInfo}
 * is slow and should not happen during client startup.
 */
public final class ClientSchema extends Schema {
  // This implements the `bigtable_client` resource defined in
  // bigtable_googleapis_com/metrics/resource_types.gcl

  public static final AttributeKey<String> BIGTABLE_PROJECT_ID_KEY =
      AttributeKey.stringKey("project_id");
  // Resource labels passed during recording
  public static final AttributeKey<String> INSTANCE_ID_KEY = AttributeKey.stringKey("instance");
  public static final AttributeKey<String> APP_PROFILE_KEY = AttributeKey.stringKey("app_profile");
  public static final AttributeKey<String> CLIENT_NAME = AttributeKey.stringKey("client_name");

  // Resource labels injected during export
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
  public static final ClientSchema INSTANCE = new ClientSchema();

  public ClientSchema() {
    super(
        "bigtable_client",
        ImmutableList.of(BIGTABLE_PROJECT_ID_KEY, INSTANCE_ID_KEY, APP_PROFILE_KEY, CLIENT_NAME),
        ImmutableList.of(CLIENT_PROJECT, CLIENT_REGION, CLOUD_PLATFORM, HOST_ID, HOST_NAME, UUID));
  }

  @Override
  public ProjectName extractProjectName(Attributes attrs, EnvInfo envInfo, ClientInfo clientInfo) {
    return ProjectName.of(clientInfo.getInstanceName().getProject());
  }

  public AttributesBuilder createResourceAttrs(ClientInfo clientInfo) {
    return Attributes.builder()
        .put(BIGTABLE_PROJECT_ID_KEY, clientInfo.getInstanceName().getProject())
        .put(INSTANCE_ID_KEY, clientInfo.getInstanceName().getInstance())
        .put(APP_PROFILE_KEY, clientInfo.getAppProfileId())
        .put(CLIENT_NAME, clientInfo.getClientName());
  }
}
