/*
 * Copyright 2018 Google LLC.  All Rights Reserved.
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
package com.google.cloud.examples.bigtable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloWorldTest {

  private static final String PROJECT_ID = "test-project"; // Replace with your project ID
  private static final String INSTANCE_ID = "test-instance"; // Replace with your instance ID
  private static final String TABLE_ID = "test-table" + System.currentTimeMillis();
  private static final String COLUMN_FAMILY_ID = "test-cf";
  private static final String COLUMN_QUALIFIER = "test-greeting";
  private static final String ROW_KEY_PREFIX = "test-rowKey";
  private static BigtableDataSettings settings;
  private static BigtableDataClient dataClient;
  private static BigtableTableAdminSettings adminSettings;
  private static BigtableTableAdminClient adminClient;

  @BeforeClass
  public static void beforeClass() throws IOException {
    settings =
        BigtableDataSettings.newBuilder().setInstanceName(InstanceName.of(PROJECT_ID, INSTANCE_ID))
            .build();
    dataClient = BigtableDataClient.create(settings);
    adminSettings = BigtableTableAdminSettings.newBuilder()
        .setInstanceName(com.google.bigtable.admin.v2.InstanceName.of(PROJECT_ID, INSTANCE_ID))
        .build();
    adminClient = BigtableTableAdminClient.create(adminSettings);
    if (!adminClient.exists(TABLE_ID)) {
      adminClient.createTable(CreateTableRequest.of(TABLE_ID).addFamily(COLUMN_FAMILY_ID));
    }
  }

  @AfterClass
  public static void afterClass() throws Exception {
    adminClient.deleteTable(TABLE_ID);
    dataClient.close();
    adminClient.close();
  }

  @Test
  public void testCreateAndDeleteTable() {
    // Create table
    Table table = TableAdmin.createTable(adminClient, "fake-table");
    assertNotNull(table);

    // Delete table
    TableAdmin.deleteTable(adminClient, "fake-table");
    assertTrue(!adminClient.exists("fake-table"));
  }

  @Test
  public void testWriteToAndReadFromTable() {
    // Write to table
    RowMutation rowMutation = HelloWorld
        .writeToTable(dataClient, TABLE_ID, ROW_KEY_PREFIX, COLUMN_FAMILY_ID, COLUMN_QUALIFIER);
    assertNotNull(rowMutation);

    // Read a single row
    Row row = HelloWorld.readSingleRow(dataClient, TABLE_ID, ROW_KEY_PREFIX);
    assertNotNull(row);
  }

  @Test
  public void testReadTable() {
    // Read whole table
    ServerStream<Row> stream = HelloWorld.readTable(dataClient, TABLE_ID);
    assertNotNull(stream);
  }
}
