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

import com.google.bigtable.v2.ResponseParams;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.Util;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.ProjectName;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import javax.annotation.Nullable;

public final class TableSchema extends Schema {
  // This implements the `bigtable_client_raw` resource defined in
  // bigtable_googleapis_com/metrics/resource_types.gcl

  public static final AttributeKey<String> BIGTABLE_PROJECT_ID_KEY =
      AttributeKey.stringKey("project_id");
  public static final AttributeKey<String> INSTANCE_ID_KEY = AttributeKey.stringKey("instance");
  public static final AttributeKey<String> TABLE_ID_KEY = AttributeKey.stringKey("table");
  public static final AttributeKey<String> CLUSTER_ID_KEY = AttributeKey.stringKey("cluster");
  public static final AttributeKey<String> ZONE_ID_KEY = AttributeKey.stringKey("zone");

  // Must come after all other static members
  public static final TableSchema INSTANCE = new TableSchema();

  public TableSchema() {
    super(
        "bigtable_client_raw",
        ImmutableList.of(
            BIGTABLE_PROJECT_ID_KEY, INSTANCE_ID_KEY, TABLE_ID_KEY, CLUSTER_ID_KEY, ZONE_ID_KEY));
  }

  @Override
  public ProjectName extractProjectName(Attributes attrs, EnvInfo envInfo, ClientInfo clientInfo) {
    return ProjectName.of(attrs.get(BIGTABLE_PROJECT_ID_KEY));
  }

  public AttributesBuilder createResourceAttrs(
      ClientInfo clientInfo, String tableId, @Nullable ResponseParams clusterInfo) {
    return Attributes.builder()
        .put(BIGTABLE_PROJECT_ID_KEY, clientInfo.getInstanceName().getProjectId())
        .put(INSTANCE_ID_KEY, clientInfo.getInstanceName().getInstanceId())
        .put(TABLE_ID_KEY, tableId)
        .put(CLUSTER_ID_KEY, Util.formatClusterIdMetricLabel(clusterInfo))
        .put(ZONE_ID_KEY, Util.formatZoneIdMetricLabel(clusterInfo));
  }
}
