/*
 * Copyright 2025 Google LLC
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClientV2;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SchemaBundleExampleTest extends BigtableBaseTest {

  private static final String TABLE_PREFIX = "table";
  private static final String SCHEMA_BUNDLE_PREFIX = "schema-bundle";
  private static final String COLUMN_FAMILY = "cf";
  private String tableId;
  private String schemaBundleId;
  private static BigtableTableAdminClientV2 adminClient;
  private SchemaBundleExample schemaBundleExample;

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    BaseBigtableTableAdminSettings adminSettings =
        BaseBigtableTableAdminSettings.newBuilder().build();
    adminClient = BigtableTableAdminClientV2.create(adminSettings);
  }

  private static boolean exists(String tableId) {
    try {
      adminClient.getTable(
          com.google.bigtable.admin.v2.GetTableRequest.newBuilder()
              .setName("projects/" + projectId + "/instances/" + instanceId + "/tables/" + tableId)
              .setView(com.google.bigtable.admin.v2.Table.View.NAME_ONLY)
              .build());
      return true;
    } catch (com.google.api.gax.rpc.NotFoundException e) {
      return false;
    }
  }

  @AfterClass
  public static void afterClass() {
    garbageCollect();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    tableId = generateResourceId(TABLE_PREFIX);
    schemaBundleId = generateResourceId(SCHEMA_BUNDLE_PREFIX);
    schemaBundleExample = new SchemaBundleExample(projectId, instanceId, tableId, schemaBundleId);
    com.google.bigtable.admin.v2.CreateTableRequest request =
        com.google.bigtable.admin.v2.CreateTableRequest.newBuilder()
            .setParent("projects/" + projectId + "/instances/" + instanceId)
            .setTableId(tableId)
            .setTable(
                com.google.bigtable.admin.v2.Table.newBuilder()
                    .putColumnFamilies(
                        COLUMN_FAMILY,
                        com.google.bigtable.admin.v2.ColumnFamily.getDefaultInstance())
                    .build())
            .build();
    adminClient.createTable(request);
  }

  @After
  public void after() {
    if (exists(tableId)) {
      adminClient.deleteTable(
          "projects/" + projectId + "/instances/" + instanceId + "/tables/" + tableId);
    }
    schemaBundleExample.close();
  }

  @Test
  public void testRunDoesNotFail() {
    schemaBundleExample.run();
  }

  @Test
  public void testSchemaBundleCreateUpdateDelete() throws IOException {
    // Creates a schema bundle.
    schemaBundleExample.createSchemaBundle();
    com.google.bigtable.admin.v2.SchemaBundle schemaBundle =
        adminClient.getSchemaBundle(
            "projects/"
                + projectId
                + "/instances/"
                + instanceId
                + "/tables/"
                + tableId
                + "/schemaBundles/"
                + schemaBundleId);
    String id = schemaBundle.getName().substring(schemaBundle.getName().lastIndexOf("/") + 1);
    assertEquals(id, schemaBundleId);

    // Updates the schema bundle.
    schemaBundleExample.updateSchemaBundle();
    com.google.bigtable.admin.v2.SchemaBundle updatedSchemaBundle =
        adminClient.getSchemaBundle(
            "projects/"
                + projectId
                + "/instances/"
                + instanceId
                + "/tables/"
                + tableId
                + "/schemaBundles/"
                + schemaBundleId);
    assertNotEquals(schemaBundle, updatedSchemaBundle);

    // Deletes the schema bundle.
    schemaBundleExample.deleteSchemaBundle();
    assertThrows(
        NotFoundException.class,
        () ->
            adminClient.getSchemaBundle(
                "projects/"
                    + projectId
                    + "/instances/"
                    + instanceId
                    + "/tables/"
                    + tableId
                    + "/schemaBundles/"
                    + schemaBundleId));
  }

  @Test
  public void testGetSchemaBundle() {
    schemaBundleExample.createSchemaBundle();
    com.google.bigtable.admin.v2.SchemaBundle schemaBundle = schemaBundleExample.getSchemaBundle();
    assertNotNull(schemaBundle);
    String id = schemaBundle.getName().substring(schemaBundle.getName().lastIndexOf("/") + 1);
    assertEquals(id, schemaBundleId);
  }

  @Test
  public void testListSchemaBundles() {
    schemaBundleExample.createSchemaBundle();
    List<String> schemaBundleIds = schemaBundleExample.listAllSchemaBundles();
    assertEquals(schemaBundleIds.size(), 1);
    assertEquals(schemaBundleIds.get(0), schemaBundleId);
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
      if (System.currentTimeMillis() - timestamp < TimeUnit.MINUTES.toMillis(10)) {
        continue;
      }
      System.out.println("\nGarbage collecting orphaned table: " + tableId);
      adminClient.deleteTable(table.getName());
    }
  }
}
