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
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmulatorEnv implements TestEnv {
  private static final InstanceName INSTANCE_NAME =
      InstanceName.of("fake-project", "fake-instance");
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
                .setParent(INSTANCE_NAME.toString())
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
  public TableName getTableName() {
    return TableName.of(INSTANCE_NAME.getProject(), INSTANCE_NAME.getInstance(), TABLE_ID);
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
