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
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.SchemaBundle;
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
  private static BigtableTableAdminClient adminClient;
  private SchemaBundleExample schemaBundleExample;

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build();
    adminClient = BigtableTableAdminClient.create(adminSettings);
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
    adminClient.createTable(CreateTableRequest.of(tableId).addFamily(COLUMN_FAMILY));
  }

  @After
  public void after() {
    if (adminClient.exists(tableId)) {
      adminClient.deleteTable(tableId);
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
    SchemaBundle schemaBundle = adminClient.getSchemaBundle(tableId, schemaBundleId);
    assertEquals(schemaBundle.getId(), schemaBundleId);

    // Updates the schema bundle.
    schemaBundleExample.updateSchemaBundle();
    SchemaBundle updatedSchemaBundle = adminClient.getSchemaBundle(tableId, schemaBundleId);
    assertNotEquals(schemaBundle, updatedSchemaBundle);

    // Deletes the schema bundle.
    schemaBundleExample.deleteSchemaBundle();
    assertThrows(
        NotFoundException.class, () -> adminClient.getSchemaBundle(tableId, schemaBundleId));
  }

  @Test
  public void testGetSchemaBundle() {
    schemaBundleExample.createSchemaBundle();
    SchemaBundle schemaBundle = schemaBundleExample.getSchemaBundle();
    assertNotNull(schemaBundle);
    assertEquals(schemaBundle.getId(), schemaBundleId);
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
    for (String tableId : adminClient.listTables()) {
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
      adminClient.deleteTable(tableId);
    }
  }
}
