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
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableAdminTest {

  private static final String GCLOUD_PROJECT = "test-project"; // Replace with your project ID
  private static final String INSTANCE_ID = "test-instance"; // Replace with your instance ID
  private static final String TABLE_ID = "test-table" + System.currentTimeMillis();
  private static BigtableTableAdminSettings adminSettings;
  private static BigtableTableAdminClient adminClient;

  @BeforeClass
  public static void beforeClass() throws IOException {
    adminSettings = BigtableTableAdminSettings.newBuilder()
        .setInstanceName(com.google.bigtable.admin.v2.InstanceName.of(GCLOUD_PROJECT, INSTANCE_ID))
        .build();
    adminClient = BigtableTableAdminClient.create(adminSettings);
    if (!adminClient.exists(TABLE_ID)) {
      adminClient.createTable(CreateTableRequest.of(TABLE_ID).addFamily("cf"));
    }
  }

  @AfterClass
  public static void afterClass() {
    adminClient.deleteTable(TABLE_ID);
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
  public void testListAllTables() {
    // List all tables in instance
    List<String> tables = TableAdmin.listAllTables(adminClient);
    assertTrue(tables.size() > 0);
  }

  @Test
  public void testGetTableMeta() {
    // Get table meta
    Table table = TableAdmin.getTableMeta(adminClient, TABLE_ID);
    assertNotNull(table);
  }

  @Test
  public void testCreateMaxAgeRuleAndModifyAndPrintColumnFamily() {
    // Max age rule
    Table table = TableAdmin.maxAgeRule(adminClient, TABLE_ID, "cf1");
    assertNotNull(table);

    // Modify cf1
    table = TableAdmin.modifyColumnFamilyRule(adminClient, TABLE_ID, "cf1");
    assertNotNull(table);

    // Print modified cf1
    ColumnFamily columnFamily = TableAdmin.printModifiedColumnFamily(adminClient, TABLE_ID, "cf1");
    assertNotNull(columnFamily);
  }

  @Test
  public void testCreateMaxVersionsRuleAndDeleteColumnFamily() {
    // Max versions rule
    Table table = TableAdmin.maxVersionsRule(adminClient, TABLE_ID, "cf2");
    assertNotNull(table);

    // Delete cf2
    table = TableAdmin.deleteColumnFamily(adminClient, TABLE_ID, "cf2");
    assertNotNull(table);
  }

  @Test
  public void testCreateUnionRule() {
    // Union rule
    Table table = TableAdmin.unionRule(adminClient, TABLE_ID, "cf3");
    assertNotNull(table);
  }

  @Test
  public void testCreateIntersectionRule() {
    // Intersection rule
    Table table = TableAdmin.intersectionRule(adminClient, TABLE_ID, "cf4");
    assertNotNull(table);
  }

  @Test
  public void testCreateNestedRule() {
    // Nested rule
    Table table = TableAdmin.nestedRule(adminClient, TABLE_ID, "cf5");
    assertNotNull(table);
  }

  @Test
  public void testListColumnFamilies() {
    // List column families
    Collection<ColumnFamily> columnFamilies = TableAdmin.listColumnFamilies(adminClient, TABLE_ID);
    assertTrue(columnFamilies.size() > 0);
  }
}
