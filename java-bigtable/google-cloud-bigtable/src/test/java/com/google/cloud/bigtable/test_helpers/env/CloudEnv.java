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
package com.google.cloud.bigtable.test_helpers.env;

import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import javax.annotation.Nullable;

/**
 * Test environment that uses an existing bigtable table. The table must have a pre-existing family
 * {@code cf}. The target table is configured via the system properties:
 *
 * <ul>
 *   <li>{@code bigtable.project}
 *   <li>{@code bigtable.instance}
 *   <li>{@code bigtable.table}
 * </ul>
 */
class CloudEnv extends AbstractTestEnv {
  private static final String DATA_ENDPOINT_PROPERTY_NAME = "bigtable.data-endpoint";
  private static final String ADMIN_ENDPOINT_PROPERTY_NAME = "bigtable.admin-endpoint";

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String TABLE_PROPERTY_NAME = "bigtable.table";

  private final String projectId;
  private final String instanceId;
  private final String tableId;

  private final BigtableDataSettings.Builder dataSettings;
  private final BigtableTableAdminSettings.Builder tableAdminSettings;
  private final BigtableInstanceAdminSettings.Builder instanceAdminSettings;

  private BigtableDataClient dataClient;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableInstanceAdminClient instanceAdminClient;

  static CloudEnv fromSystemProperties() {
    return new CloudEnv(
        getOptionalProperty(DATA_ENDPOINT_PROPERTY_NAME, "bigtable.googleapis.com:443"),
        getOptionalProperty(ADMIN_ENDPOINT_PROPERTY_NAME, "bigtableadmin.googleapis.com:443"),
        getRequiredProperty(PROJECT_PROPERTY_NAME),
        getRequiredProperty(INSTANCE_PROPERTY_NAME),
        getRequiredProperty(TABLE_PROPERTY_NAME));
  }

  private CloudEnv(
      @Nullable String dataEndpoint,
      @Nullable String adminEndpoint,
      String projectId,
      String instanceId,
      String tableId) {
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.tableId = tableId;

    this.dataSettings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);
    if (dataEndpoint != null) {
      dataSettings.stubSettings().setEndpoint(dataEndpoint);
    }

    this.tableAdminSettings =
        BigtableTableAdminSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);
    if (adminEndpoint != null) {
      this.tableAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }

    this.instanceAdminSettings = BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId);
    if (adminEndpoint != null) {
      this.instanceAdminSettings.stubSettings().setEndpoint(adminEndpoint);
    }
  }

  @Override
  void start() throws IOException {
    dataClient = BigtableDataClient.create(dataSettings.build());
    tableAdminClient = BigtableTableAdminClient.create(tableAdminSettings.build());
    instanceAdminClient = BigtableInstanceAdminClient.create(instanceAdminSettings.build());
  }

  @Override
  void stop() {
    dataClient.close();
    tableAdminClient.close();
    instanceAdminClient.close();
  }

  @Override
  public BigtableDataClient getDataClient() {
    return dataClient;
  }

  @Override
  public BigtableTableAdminClient getTableAdminClient() {
    return tableAdminClient;
  }

  @Override
  public BigtableInstanceAdminClient getInstanceAdminClient() {
    return instanceAdminClient;
  }

  @Override
  public BigtableDataSettings getDataClientSettings() {
    return dataSettings.build();
  }

  @Override
  public String getProjectId() {
    return projectId;
  }

  @Override
  public String getInstanceId() {
    return instanceId;
  }

  @Override
  public String getTableId() {
    return tableId;
  }

  private static String getOptionalProperty(String prop, String defaultValue) {
    return MoreObjects.firstNonNull(System.getProperty(prop), defaultValue);
  }

  private static String getRequiredProperty(String prop) {
    String value = System.getProperty(prop);
    if (value == null || value.isEmpty()) {
      throw new RuntimeException("Missing system property: " + prop);
    }
    return value;
  }
}
