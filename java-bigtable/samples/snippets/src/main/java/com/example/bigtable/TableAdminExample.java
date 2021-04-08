/*
 * Copyright 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package com.example.bigtable;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.GCRules.DurationRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.IntersectionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.UnionRule;
import com.google.cloud.bigtable.admin.v2.models.GCRules.VersionRule;
import com.google.cloud.bigtable.admin.v2.models.ModifyColumnFamiliesRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * An example of using Google Cloud Bigtable.
 *
 * <p>This example demonstrates the usage of BigtableTableAdminClient to create, configure and
 * delete a Cloud Bigtable table.
 *
 * <ul>
 *   <li>creates table
 *   <li>lists all tables
 *   <li>gets table metadata
 *   <li>creates DurationRule
 *   <li>creates VersionRule
 *   <li>creates UnionRule
 *   <li>creates IntersectionRule
 *   <li>creates nested rule
 *   <li>lists column families
 *   <li>modifies column family rule
 *   <li>prints modified column family
 *   <li>deletes column family
 *   <li>deletes table
 * </ul>
 */
public class TableAdminExample {

  private static final String COLUMN_FAMILY_1 = "cf1";
  private static final String COLUMN_FAMILY_2 = "cf2";
  private static final String COLUMN_FAMILY_3 = "cf3";
  private static final String COLUMN_FAMILY_4 = "cf4";
  private static final String COLUMN_FAMILY_5 = "cf5";
  private final String tableId;
  private final BigtableTableAdminClient adminClient;

  public static void main(String[] args) throws IOException {

    if (args.length != 2) {
      System.out.println("Missing required project id or instance id");
      return;
    }
    String projectId = args[0];
    String instanceId = args[1];

    TableAdminExample tableAdmin = new TableAdminExample(projectId, instanceId, "test-table");
    tableAdmin.run();
  }

  public TableAdminExample(String projectId, String instanceId, String tableId) throws IOException {
    this.tableId = tableId;

    // Creates the settings to configure a bigtable table admin client.
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build();

    // Creates a bigtable table admin client.
    adminClient = BigtableTableAdminClient.create(adminSettings);
  }

  public void run() {
    createTable();
    listAllTables();
    getTableMeta();
    addFamilyWithMaxAgeRule();
    addFamilyWithMaxVersionsRule();
    addFamilyWithUnionRule();
    addFamilyWithIntersectionRule();
    addFamilyWithNestedRule();
    listColumnFamilies();
    modifyColumnFamilyRule();
    printModifiedColumnFamily();
    deleteColumnFamily();
    deleteTable();
    adminClient.close();
  }

  /** Demonstrates how to create a table with the specified configuration. */
  public void createTable() {
    // [START bigtable_create_table]
    // Checks if table exists, creates table if does not exist.
    if (!adminClient.exists(tableId)) {
      System.out.println("Table does not exist, creating table: " + tableId);
      CreateTableRequest createTableRequest = CreateTableRequest.of(tableId).addFamily("cf");
      Table table = adminClient.createTable(createTableRequest);
      System.out.printf("Table: %s created successfully%n", table.getId());
    }
    // [END bigtable_create_table]
  }

  /** Demonstrates how to list all tables within an instance. */
  public void listAllTables() {
    System.out.println("\nListing tables in current instance");
    // [START bigtable_list_tables]
    // Lists tables in the current instance.
    try {
      List<String> tableIds = adminClient.listTables();
      for (String tableId : tableIds) {
        System.out.println(tableId);
      }
    } catch (NotFoundException e) {
      System.err.println("Failed to list tables from a non-existent instance: " + e.getMessage());
    }
    // [END bigtable_list_tables]
  }

  /** Demonstrates how to get a table's metadata. */
  public void getTableMeta() {
    System.out.println("\nPrinting table metadata");
    // [START bigtable_get_table_metadata]
    // Gets table metadata, and applies a view to the table fields.
    try {
      Table table = adminClient.getTable(tableId);
      System.out.println("Table: " + table.getId());
      Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
      for (ColumnFamily columnFamily : columnFamilies) {
        System.out.printf(
            "Column family: %s%nGC Rule: %s%n",
            columnFamily.getId(), columnFamily.getGCRule().toString());
      }
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to retrieve table metadata for a non-existent table: " + e.getMessage());
    }
    // [END bigtable_get_table_metadata]
  }

  /** Demonstrates how to create a new instance of the DurationRule. */
  public void addFamilyWithMaxAgeRule() {
    System.out.printf("%nCreating column family %s with max age GC rule%n", COLUMN_FAMILY_1);
    // [START bigtable_create_family_gc_max_age]
    // Creates a column family with GC policy : maximum age
    // where age = current time minus cell timestamp

    // Defines the GC rule to retain data with max age of 5 days.
    DurationRule maxAgeRule = GCRULES.maxAge(5, TimeUnit.DAYS);

    // Creates column family with given GC rule.
    try {
      // ModifyColumnFamiliesRequest can be used both for adding and modifying families, here it is
      // being used to add a family
      ModifyColumnFamiliesRequest columnFamiliesRequest =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_1, maxAgeRule);
      adminClient.modifyFamilies(columnFamiliesRequest);
      System.out.println("Created column family: " + COLUMN_FAMILY_1);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_max_age]
  }

  /** Demonstrates how to create a new instance of the VersionRule. */
  public void addFamilyWithMaxVersionsRule() {
    System.out.printf("%nCreating column family %s with max versions GC rule%n", COLUMN_FAMILY_2);
    // [START bigtable_create_family_gc_max_versions]
    // Creates a column family with GC policy : most recent N versions
    // where 1 = most recent version

    // Defines the GC policy to retain only the most recent 2 versions.
    VersionRule versionRule = GCRULES.maxVersions(2);

    // Creates column family with given GC rule.
    try {
      // ModifyColumnFamiliesRequest can be used both for adding and modifying families, here it is
      // being used to add a family
      ModifyColumnFamiliesRequest columnFamiliesRequest =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_2, versionRule);
      adminClient.modifyFamilies(columnFamiliesRequest);
      System.out.println("Created column family: " + COLUMN_FAMILY_2);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_max_versions]
  }

  /** Demonstrates how to create a new instance of the UnionRule. */
  public void addFamilyWithUnionRule() {
    System.out.printf("%nCreating column family %s with union GC rule%n", COLUMN_FAMILY_3);
    // [START bigtable_create_family_gc_union]
    // Creates a column family with GC policy to drop data that matches at least one condition.

    // Defines a list of GC rules to drop cells older than 5 days OR not the most recent
    // version.
    UnionRule unionRule =
        GCRULES.union().rule(GCRULES.maxAge(5, TimeUnit.DAYS)).rule(GCRULES.maxVersions(1));

    // Creates column family with given GC rule.
    try {
      // ModifyColumnFamiliesRequest can be used both for adding and modifying families, here it is
      // being used to add a family
      ModifyColumnFamiliesRequest columnFamiliesRequest =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_3, unionRule);
      adminClient.modifyFamilies(columnFamiliesRequest);
      System.out.println("Created column family: " + COLUMN_FAMILY_3);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_union]
  }

  /** Demonstrates how to create a new instance of the IntersectionRule. */
  public void addFamilyWithIntersectionRule() {
    System.out.printf("%nCreating column family %s with intersection GC rule%n", COLUMN_FAMILY_4);
    // [START bigtable_create_family_gc_intersection]
    // Creates a column family with GC policy to drop data that matches all conditions.

    // Defines a GC rule to drop cells older than 5 days AND older than the most recent 2 versions.
    DurationRule maxAgeRule = GCRULES.maxAge(5, TimeUnit.DAYS);
    VersionRule versionRule = GCRULES.maxVersions(2);
    IntersectionRule intersectionRule = GCRULES.intersection().rule(maxAgeRule).rule(versionRule);

    // Creates column family with given GC rule.
    try {
      // ModifyColumnFamiliesRequest can be used both for adding and modifying families, here it is
      // being used to add a family
      ModifyColumnFamiliesRequest columnFamiliesRequest =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_4, intersectionRule);
      adminClient.modifyFamilies(columnFamiliesRequest);
      System.out.println("Created column family: " + COLUMN_FAMILY_4);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_intersection]
  }

  /** Demonstrates how to create a nested rule using the IntersectionRule and UnionRule. */
  public void addFamilyWithNestedRule() {
    System.out.printf("%nCreating column family %s with a nested GC rule%n", COLUMN_FAMILY_5);
    // [START bigtable_create_family_gc_nested]
    // Creates a nested GC rule:
    // Drop cells that are either older than the 10 recent versions
    // OR
    // Drop cells that are older than a month AND older than the 2 recent versions
    VersionRule versionRule1 = GCRULES.maxVersions(10);
    VersionRule versionRule2 = GCRULES.maxVersions(2);
    DurationRule maxAgeRule = GCRULES.maxAge(30, TimeUnit.DAYS);
    IntersectionRule intersectionRule = GCRULES.intersection().rule(maxAgeRule).rule(versionRule2);
    UnionRule unionRule = GCRULES.union().rule(intersectionRule).rule(versionRule1);

    // Creates column family with given GC rule.
    try {
      // ModifyColumnFamiliesRequest can be used both for adding and modifying families, here it is
      // being used to add a family
      ModifyColumnFamiliesRequest columnFamiliesRequest =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_5, unionRule);
      adminClient.modifyFamilies(columnFamiliesRequest);
      System.out.println("Created column family: " + COLUMN_FAMILY_5);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_nested]
  }

  /** Demonstrates how to list a table's column families. */
  public void listColumnFamilies() {
    System.out.println("\nPrinting ID and GC Rule for all column families");
    // [START bigtable_list_column_families]
    // Lists all families in the table with GC rules.
    try {
      Table table = adminClient.getTable(tableId);
      Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
      for (ColumnFamily columnFamily : columnFamilies) {
        System.out.printf(
            "Column family: %s%nGC Rule: %s%n",
            columnFamily.getId(), columnFamily.getGCRule().toString());
      }
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to list column families from a non-existent table: " + e.getMessage());
    }
    // [END bigtable_list_column_families]
  }

  /** Demonstrates how to modify a column family's rule. */
  public void modifyColumnFamilyRule() {
    System.out.printf("%nUpdating column family %s GC rule%n", COLUMN_FAMILY_1);
    // [START bigtable_update_gc_rule]
    // Updates the column family metadata to update the GC rule.
    // Updates a column family GC rule.
    VersionRule versionRule = GCRULES.maxVersions(1);
    try {
      // ModifyColumnFamiliesRequest can be used both for adding and modifying families, here it is
      // being used to modify a family
      // Updates column family with given GC rule.
      ModifyColumnFamiliesRequest updateRequest =
          ModifyColumnFamiliesRequest.of(tableId).updateFamily(COLUMN_FAMILY_1, versionRule);
      adminClient.modifyFamilies(updateRequest);
      System.out.printf("Column family %s GC rule updated%n", COLUMN_FAMILY_1);
    } catch (NotFoundException e) {
      System.err.println("Failed to modify a non-existent column family: " + e.getMessage());
    }
    // [END bigtable_update_gc_rule]
  }

  /** Demonstrates how to print the modified column family. */
  public void printModifiedColumnFamily() {
    System.out.printf("%nPrint updated GC rule for column family %s%n", COLUMN_FAMILY_1);
    // [START bigtable_family_get_gc_rule]
    try {
      Table table = adminClient.getTable(tableId);
      Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
      for (ColumnFamily columnFamily : columnFamilies) {
        if (columnFamily.getId().equals(COLUMN_FAMILY_1)) {
          System.out.printf(
              "Column family: %s%nGC Rule: %s%n",
              columnFamily.getId(), columnFamily.getGCRule().toString());
        }
      }
    } catch (NotFoundException e) {
      System.err.println("Failed to print a non-existent column family: " + e.getMessage());
    }
    // [END bigtable_family_get_gc_rule]
  }

  /** Demonstrates how to delete a column family. */
  public void deleteColumnFamily() {
    System.out.println("\nDelete column family: " + COLUMN_FAMILY_2);
    // [START bigtable_delete_family]
    // Deletes a column family.
    try {
      ModifyColumnFamiliesRequest deleted =
          ModifyColumnFamiliesRequest.of(tableId).dropFamily(COLUMN_FAMILY_2);
      adminClient.modifyFamilies(deleted);
      System.out.printf("Column family %s deleted successfully%n", COLUMN_FAMILY_2);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent column family: " + e.getMessage());
    }
    // [END bigtable_delete_family]
  }

  /** Demonstrates how to delete a table. */
  public void deleteTable() {
    // [START bigtable_delete_table]
    // Deletes the entire table.
    System.out.println("\nDelete table: " + tableId);
    try {
      adminClient.deleteTable(tableId);
      System.out.printf("Table: %s deleted successfully%n", tableId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent table: " + e.getMessage());
    }
    // [END bigtable_delete_table]
  }
}
