/*
 * Copyright 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClientV2;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.TableId;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link HelloWorld} */
public class HelloWorldTest extends BigtableBaseTest {

  private static final String TABLE_PREFIX = "table";
  private static String tableId;
  private static BigtableDataClient dataClient;
  private static BigtableTableAdminClientV2 adminClient;
  private HelloWorld helloWorld;

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId).build();
    dataClient = BigtableDataClient.create(settings);
    BaseBigtableTableAdminSettings adminSettings =
        BaseBigtableTableAdminSettings.newBuilder().build();
    adminClient = BigtableTableAdminClientV2.create(adminSettings);
  }

  private static boolean exists(String tableId) {
    try {
      adminClient.getTable(
          com.google.bigtable.admin.v2.GetTableRequest.newBuilder()
              .setName("projects/" + projectId + "/instances/" + instanceId + "/tables/" + tableId)
              .build());
      return true;
    } catch (com.google.api.gax.rpc.NotFoundException e) {
      return false;
    }
  }

  @AfterClass
  public static void afterClass() throws Exception {
    garbageCollect();
    dataClient.close();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    tableId = generateTableId();
    helloWorld = new HelloWorld(projectId, instanceId, tableId);
    com.google.bigtable.admin.v2.CreateTableRequest request =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setParent("projects/" + projectId + "/instances/" + instanceId)
            .setTableId(tableId)
            .setTable(
                com.google.bigtable.admin.v2.Table.newBuilder()
                    .putColumnFamilies(
                        "cf1", com.google.bigtable.admin.v2.ColumnFamily.getDefaultInstance())
                    .build())
            .build();
    adminClient.createTable(request);
  }

  @After
  public void teardown() {
    if (exists(tableId)) {
      adminClient.deleteTable(
          "projects/" + projectId + "/instances/" + instanceId + "/tables/" + tableId);
    }
    helloWorld.close();
  }

  @Test
  public void testCreateAndDeleteTable() throws IOException {
    // Creates a table.
    String testTable = generateTableId();
    HelloWorld testHelloWorld = new HelloWorld(projectId, instanceId, testTable);
    testHelloWorld.createTable();
    assertTrue(exists(testTable));

    // Deletes a table.
    testHelloWorld.deleteTable();
    assertTrue(!exists(testTable));
    testHelloWorld.close();
  }

  @Test
  public void testWriteToTable() {
    // Writes to a table.
    assertNull(dataClient.readRow(TableId.of(tableId), "rowKey0"));
    helloWorld.writeToTable();
    assertNotNull(dataClient.readRow(TableId.of(tableId), "rowKey0"));
  }

  @Test
  public void testReads() {
    assertEquals(0, helloWorld.readTable().size());
    helloWorld.writeToTable();

    assertEquals(2, helloWorld.readSingleRow().getCells().size());
    assertEquals(1, helloWorld.readSpecificCells().size());
    assertEquals(3, helloWorld.readTable().size());
  }

  @Test
  public void testRunDoesNotFail() throws Exception {
    helloWorld.run();
  }

  private String generateTableId() {
    return String.format(
        "%s-%016x-%x", TABLE_PREFIX, System.currentTimeMillis(), new Random().nextLong());
  }

  private static void garbageCollect() {
    Pattern timestampPattern = Pattern.compile(TABLE_PREFIX + "-([0-9a-f]+)-([0-9a-f]+)");
    com.google.bigtable.admin.v2.ListTablesRequest request =
        com.google.bigtable.admin.v2.ListTablesRequest.newBuilder()
            .setParent("projects/" + projectId + "/instances/" + instanceId)
            .build();
    for (com.google.bigtable.admin.v2.Table table : adminClient.listTables(request).iterateAll()) {
      String tableId = table.getName().substring(table.getName().lastIndexOf("/") + 1);
      Matcher matcher = timestampPattern.matcher(tableId);
      if (!matcher.matches()) {
        continue;
      }
      String timestampStr = matcher.group(1);
      long timestamp = Long.parseLong(timestampStr, 16);
      if (System.currentTimeMillis() - timestamp < TimeUnit.MINUTES.toMillis(15)) {
        continue;
      }
      System.out.println("\nGarbage collecting orphaned table: " + tableId);
      adminClient.deleteTable(table.getName());
    }
  }
}
