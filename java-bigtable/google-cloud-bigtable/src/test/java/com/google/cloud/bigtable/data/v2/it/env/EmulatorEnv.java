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
package com.google.cloud.bigtable.data.v2.it.env;

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.emulator.v2.Emulator;

public class EmulatorEnv implements TestEnv {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "default-table";
  private static final String FAMILY_ID = "cf";

  private Emulator emulator;
  private BigtableTableAdminClient tableAdminClient;
  private BigtableDataClient dataClient;

  @Override
  public void start() throws Exception {
    emulator = Emulator.createBundled();
    emulator.start();

    tableAdminClient =
        BigtableTableAdminClient.create(
            BigtableTableAdminSettings.newBuilderForEmulator(emulator.getPort())
                .setProjectId("fake-project")
                .setInstanceId("fake-instance")
                .build());
    dataClient =
        BigtableDataClient.create(
            BigtableDataSettings.newBuilderForEmulator(emulator.getPort())
                .setProjectId("fake-project")
                .setInstanceId("fake-instance")
                .build());

    tableAdminClient.createTable(CreateTableRequest.of(TABLE_ID).addFamily(FAMILY_ID));
  }

  @Override
  public void stop() throws Exception {
    tableAdminClient.close();
    dataClient.close();
    emulator.stop();
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
  public String getRowPrefix() {
    return "fake-";
  }

  @Override
  public BigtableDataClient getDataClient() {
    return dataClient;
  }

  @Override
  public String getFamilyId() {
    return FAMILY_ID;
  }
}
