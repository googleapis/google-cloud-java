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

import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;

public class EmulatorEnv implements TestEnv {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "default-table";
  private static final String FAMILY_ID = "cf";

  private Emulator emulator;

  @Override
  public void start() throws Exception {
    emulator = Emulator.createGCloud();
    emulator.start();

    emulator
        .getTableAdminClient()
        .createTable(
            CreateTableRequest.newBuilder()
                .setParent(NameUtil.formatInstanceName(PROJECT_ID, INSTANCE_ID))
                .setTableId(TABLE_ID)
                .setTable(
                    Table.newBuilder()
                        .putColumnFamilies(FAMILY_ID, ColumnFamily.getDefaultInstance()))
                .build());
  }

  @Override
  public void stop() throws Exception {
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
    return emulator.getDataClient();
  }

  @Override
  public String getFamilyId() {
    return FAMILY_ID;
  }
}
