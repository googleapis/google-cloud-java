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
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.emulator.v2.Emulator;
import com.google.common.base.Strings;
import java.io.IOException;
import java.nio.file.Paths;

public class EmulatorEnv extends AbstractTestEnv {
  private static final String EMULATOR_OVERRIDE_PROPERTY_NAME = "bigtable.emulator-path";

  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "default-table";

  private Emulator emulator;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableDataClient dataClient;

  private BigtableDataSettings dataSettings;

  public static EmulatorEnv createBundled() {
    return new EmulatorEnv();
  }

  private EmulatorEnv() {}

  @Override
  void start() throws Exception {
    String overridePath = System.getProperty(EMULATOR_OVERRIDE_PROPERTY_NAME);
    if (!Strings.isNullOrEmpty(overridePath)) {
      emulator = Emulator.createFromPath(Paths.get(overridePath));
    } else {
      emulator = Emulator.createBundled();
    }
    emulator.start();

    dataSettings =
        BigtableDataSettings.newBuilderForEmulator(emulator.getPort())
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .build();

    dataClient = BigtableDataClient.create(dataSettings);

    tableAdminClient =
        BigtableTableAdminClient.create(
            BigtableTableAdminSettings.newBuilderForEmulator(emulator.getPort())
                .setProjectId("fake-project")
                .setInstanceId("fake-instance")
                .build());

    tableAdminClient.createTable(CreateTableRequest.of(TABLE_ID).addFamily(getFamilyId()));
  }

  @Override
  void stop() {
    tableAdminClient.close();
    dataClient.close();
    emulator.stop();
  }

  @Override
  public BigtableDataSettings getDataClientSettings() {
    return dataSettings;
  }

  @Override
  public String getProjectId() {
    return PROJECT_ID;
  }

  @Override
  public String getInstanceId() {
    return INSTANCE_ID;
  }

  @Override
  public String getTableId() {
    return TABLE_ID;
  }

  @Override
  public BigtableDataClient getDataClient() {
    return dataClient;
  }

  @Override
  public BigtableDataClient getDataClientForInstance(String instanceId) throws IOException {
    throw new UnsupportedOperationException("Could not create a data client for another instance.");
  }

  @Override
  public BigtableTableAdminClient getTableAdminClient() {
    return tableAdminClient;
  }

  @Override
  public BigtableTableAdminClient getTableAdminClientForInstance(String instanceId)
      throws IOException {
    throw new UnsupportedOperationException("Could not create a table admin for another instance.");
  }

  @Override
  public BigtableInstanceAdminClient getInstanceAdminClient() {
    throw new UnsupportedOperationException("InstanceAdminClient is not supported with emulator");
  }

  @Override
  public boolean isInstanceAdminSupported() {
    return false;
  }
}
