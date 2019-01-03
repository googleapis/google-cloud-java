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

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.cloud.bigtable.data.v2.models.Row;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITHelloWorld {

  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String TABLE_PREFIX = "table";
  private static String tableId;
  private static BigtableDataClient dataClient;
  private static BigtableTableAdminClient adminClient;
  private static InstanceName instanceName;
  private HelloWorld helloWorld;

  @BeforeClass
  public static void beforeClass() throws IOException {
    String targetInstance = System.getProperty(INSTANCE_PROPERTY_NAME);
    if (targetInstance == null) {
      dataClient = null;
      adminClient = null;
      return;
    }
    instanceName = InstanceName.parse(targetInstance);
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder().setInstanceName(instanceName).build();
    dataClient = BigtableDataClient.create(settings);
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setInstanceName(com.google.bigtable.admin.v2.InstanceName.parse(targetInstance))
            .build();
    adminClient = BigtableTableAdminClient.create(adminSettings);
  }

  @AfterClass
  public static void afterClass() throws Exception {
    garbageCollect();
    dataClient.close();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    if (adminClient == null || dataClient == null) {
      throw new AssumptionViolatedException(
          INSTANCE_PROPERTY_NAME + " property is not set, skipping integration tests.");
    }
    tableId = generateTableId();
    helloWorld = new HelloWorld(instanceName.getProject(), instanceName.getInstance(), tableId);
    adminClient.createTable(CreateTableRequest.of(tableId).addFamily("cf1"));
  }

  @After
  public void after() {
    if (adminClient.exists(tableId)) {
      adminClient.deleteTable(tableId);
    }
  }

  @Test
  public void testCreateAndDeleteTable() throws IOException {
    // Create table
    String fakeTable = generateTableId();
    HelloWorld testHelloWorld =
        new HelloWorld(instanceName.getProject(), instanceName.getInstance(), fakeTable);
    testHelloWorld.createTable();
    assertTrue(adminClient.exists(fakeTable));

    // Delete table
    testHelloWorld.deleteTable();
    assertTrue(!adminClient.exists(fakeTable));
  }

  @Test
  public void testWriteToTable() {
    // Write to table
    helloWorld.writeToTable();
    Row row = dataClient.readRow(tableId, "rowKey0");
    assertNotNull(row);
  }

  // TODO: add test for helloWorld.readSingleRow()
  // TODO: add test for helloWorld.readTable()

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
    for (String tableId : adminClient.listTables()) {
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
      adminClient.deleteTable(tableId);
    }
  }
}
