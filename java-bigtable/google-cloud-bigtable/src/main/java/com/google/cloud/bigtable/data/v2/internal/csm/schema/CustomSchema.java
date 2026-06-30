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
import io.opentelemetry.api.common.Attributes;

/** Placeholder schema for exporting custom metrics */
public class CustomSchema extends Schema {
  private CustomSchema() {
    super("custom_schema", ImmutableList.of());
  }

  public static final CustomSchema INSTANCE = new CustomSchema();

  @Override
  public ProjectName extractProjectName(Attributes attrs, EnvInfo envInfo, ClientInfo clientInfo) {
    return ProjectName.of(clientInfo.getInstanceName().getProjectId());
  }
}
