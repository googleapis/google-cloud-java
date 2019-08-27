/*
 * Copyright 2019 Google LLC
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
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import java.io.IOException;

/**
 * Test environment that uses an existing bigtable table in the directpath environment.
 *
 * <p>The test environment can be accessed via both, CFE and direct path. The transport is
 * controlled via the environment variable {@code GOOGLE_CLOUD_ENABLE_DIRECT_PATH}. Which contains
 * comma delimited list of service names that should be accessed via direct path.
 *
 * <p>The target table must have a pre-existing family {@code cf}. The target table is configured
 * via the system properties:
 *
 * <ul>
 *   <li>{@code bigtable.project}
 *   <li>{@code bigtable.instance}
 *   <li>{@code bigtable.table}
 * </ul>
 */
public class DirectPathEnv extends AbstractTestEnv {
  // TODO(igorbernstein): move direct path conditional logic to gax
  private static final String DIRECT_PATH_ENV_VAR = "GOOGLE_CLOUD_ENABLE_DIRECT_PATH";
  private static final String DIRECT_PATH_END_POINT =
      "testdirectpath-bigtable.sandbox.googleapis.com:443";

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String TABLE_PROPERTY_NAME = "bigtable.table";

  private final boolean directPathEnabled;
  private final String projectId;
  private final String instanceId;
  private final String tableId;

  private BigtableDataClient dataClient;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableInstanceAdminClient instanceAdminClient;

  static DirectPathEnv create() {
    return new DirectPathEnv(
        isDirectPathEnabled(),
        getRequiredProperty(PROJECT_PROPERTY_NAME),
        getRequiredProperty(INSTANCE_PROPERTY_NAME),
        getRequiredProperty(TABLE_PROPERTY_NAME));
  }

  private DirectPathEnv(
      boolean directPathEnabled, String projectId, String instanceId, String tableId) {
    this.directPathEnabled = directPathEnabled;
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.tableId = tableId;
  }

  @Override
  void start() throws IOException {
    BigtableDataSettings.Builder settingsBuilder =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId);

    // Direct path test environment uses a different endpoint.
    settingsBuilder.stubSettings().setEndpoint(DIRECT_PATH_END_POINT);

    // TODO(igorbernstein): move direct path conditional logic to gax
    // Direct path environment can be accessed via CFE or direct path. When using direct path,
    // disable connection pooling.
    if (directPathEnabled) {
      settingsBuilder
          .stubSettings()
          .setTransportChannelProvider(
              EnhancedBigtableStubSettings.defaultGrpcTransportProviderBuilder()
                  .setPoolSize(1)
                  .build());
    }

    dataClient = BigtableDataClient.create(settingsBuilder.build());
    tableAdminClient = BigtableTableAdminClient.create(projectId, instanceId);
    instanceAdminClient = BigtableInstanceAdminClient.create(projectId);
  }

  @Override
  void stop() throws Exception {
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

  private static String getRequiredProperty(String prop) {
    String value = System.getProperty(prop);
    if (value == null || value.isEmpty()) {
      throw new RuntimeException("Missing system property: " + prop);
    }
    return value;
  }

  // TODO(igorbernstein): move direct path conditional logic to gax
  private static boolean isDirectPathEnabled() {
    String whiteList = System.getenv(DIRECT_PATH_ENV_VAR);
    if (whiteList == null) {
      return false;
    }

    for (String service : whiteList.split(",")) {
      if (!service.isEmpty() && DIRECT_PATH_END_POINT.contains(service)) {
        return true;
      }
    }
    return false;
  }
}
