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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.cloud.bigtable.data.v2.models.Row;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloWorldTest {

  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static String tableId;
  private static final String columnFamily = "cf1";
  private static BigtableDataClient dataClient;
  private static BigtableTableAdminClient adminClient;
  private static HelloWorld helloWorld;
  private static InstanceName instanceName;

  @BeforeClass
  public static void beforeClass() throws IOException {
    String targetInstance = System.getProperty(INSTANCE_PROPERTY_NAME);
    instanceName = InstanceName.parse(targetInstance);
    if (targetInstance == null) {
      dataClient = null;
      adminClient = null;
      return;
    }
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
    adminClient.deleteTable(tableId);
    dataClient.close();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    if (adminClient == null || dataClient == null) {
      throw new AssumptionViolatedException(
          INSTANCE_PROPERTY_NAME + " property is not set, skipping integration tests.");
    }
    tableId = "test-table";
    helloWorld = new HelloWorld(instanceName.getProject(), instanceName.getInstance(), tableId);
    if (!adminClient.exists(tableId)) {
      adminClient.createTable(CreateTableRequest.of(tableId).addFamily(columnFamily));
    }
  }

  @Test
  public void testCreateAndDeleteTable() throws IOException {
    // Create table
    String fakeTable = "fake-table";
    HelloWorld testHelloWorld =
        new HelloWorld(instanceName.getProject(), instanceName.getInstance(), fakeTable);
    testHelloWorld.createTable();
    assertTrue(adminClient.exists(fakeTable));

    // Delete table
    testHelloWorld.deleteTable();
    assertTrue(!adminClient.exists(fakeTable));
  }

  @Test
  public void testWriteToAndReadFromTable() {
    // Write to table
    helloWorld.writeToTable();
    Row row = dataClient.readRow(tableId, "rowKey0");
    assertNotNull(row);

    // Read a single row
    OutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    helloWorld.readSingleRow();
    assertTrue(outputStream.toString().contains("Reading a single row by row key"));
    assertTrue(outputStream.toString().contains("Row: rowKey0"));
    assertTrue(
        outputStream
            .toString()
            .contains("Family: cf1    Qualifier: greeting    Value: Hello World!"));

    // Restore normal output
    System.setOut(new PrintStream(System.out));
  }

  @Test
  public void testReadTable() {
    // Read whole table
    OutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    helloWorld.readTable();
    assertTrue(
        outputStream.toString().contains("============= Reading the entire table ============="));

    // Restore normal output
    System.setOut(new PrintStream(System.out));
  }

  @Test
  public void testGarbageCollect() {
    boolean exceptionThrown = false;
    try {
      helloWorld.garbageCollect();
    } catch (Exception e) {
      exceptionThrown = true;
    }
    assertFalse(exceptionThrown);
  }
}
