/*
 * Copyright 2019 Google LLC.  All Rights Reserved.
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

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.GCRules;
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
 * <pre>
 *   creates table
 *   lists all tables
 *   gets table metadata
 *   creates DurationRule
 *   creates VersionRule
 *   creates UnionRule
 *   creates IntersectionRule
 *   creates nested rule
 *   lists column families
 *   modifies column family rule
 *   prints modified column family
 *   deletes column family
 *   deletes table
 * </pre>
 */
public class TableAdmin {

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

    TableAdmin tableAdmin = new TableAdmin(projectId, instanceId, "test-table");
    tableAdmin.run();
  }

  public TableAdmin(String projectId, String instanceId, String tableId) throws IOException {
    this.tableId = tableId;

    // [START connecting_to_bigtable]
    // Creates the settings to configure a bigtable table admin client.
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setInstanceName(com.google.bigtable.admin.v2.InstanceName.of(projectId, instanceId))
            .build();

    // Creates a bigtable table admin client.
    adminClient = BigtableTableAdminClient.create(adminSettings);
    // [END connecting_to_bigtable]
  }

  public void run() {
    createTable();
    listAllTables();
    getTableMeta();
    maxAgeRule();
    maxVersionsRule();
    unionRule();
    intersectionRule();
    nestedRule();
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
      List<String> listTables = adminClient.listTables();
      for (String tableName : listTables) {
        System.out.println(tableName);
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
        printColumnFamily(columnFamily);
      }
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to retrieve table metadata for a non-existent table: " + e.getMessage());
    }
    // [END bigtable_get_table_metadata]
  }

  /** Demonstrates how to create a new instance of the DurationRule. */
  public void maxAgeRule() {
    System.out.printf("%nCreating column family %s with max age GC rule%n", COLUMN_FAMILY_1);
    // [START bigtable_create_family_gc_max_age]
    // Creates a column family with GC policy : maximum age
    // where age = current time minus cell timestamp

    // Defines the GC rule to retain data with max age of 5 days.
    GCRules.DurationRule maxAgeRule1 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);

    // Creates column family with given GC rule.
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest1 =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_1, maxAgeRule1);
      adminClient.modifyFamilies(columnFamiliesRequest1);
      System.out.println("Created column family: " + COLUMN_FAMILY_1);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_max_age]
  }

  /** Demonstrates how to create a new instance of the VersionRule. */
  public void maxVersionsRule() {
    System.out.printf("%nCreating column family %s with max versions GC rule%n", COLUMN_FAMILY_2);
    // [START bigtable_create_family_gc_max_versions]
    // Creates a column family with GC policy : most recent N versions
    // where 1 = most recent version

    // Defines the GC policy to retain only the most recent 2 versions.
    GCRules.VersionRule versionRule1 = GCRules.GCRULES.maxVersions(2);

    // Creates column family with given GC rule.
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest2 =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_2, versionRule1);
      adminClient.modifyFamilies(columnFamiliesRequest2);
      System.out.println("Created column family: " + COLUMN_FAMILY_2);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_max_versions]
  }

  /** Demonstrates how to create a new instance of the UnionRule. */
  public void unionRule() {
    System.out.printf("%nCreating column family %s with union GC rule%n", COLUMN_FAMILY_3);
    // [START bigtable_create_family_gc_union]
    // Creates a column family with GC policy to drop data that matches at least one condition.

    // Defines a GC rule to drop cells older than 5 days OR not the most recent version.
    GCRules.DurationRule maxAgeRule2 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    GCRules.VersionRule versionRule2 = GCRules.GCRULES.maxVersions(1);
    // Add rules to union rule list
    GCRules.UnionRule unionRule1 = GCRules.GCRULES.union().rule(maxAgeRule2).rule(versionRule2);

    // Creates column family with given GC rule.
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest3 =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_3, unionRule1);
      adminClient.modifyFamilies(columnFamiliesRequest3);
      System.out.println("Created column family: " + COLUMN_FAMILY_3);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_union]
  }

  /** Demonstrates how to create a new instance of the IntersectionRule. */
  public void intersectionRule() {
    System.out.printf("%nCreating column family %s with intersection GC rule%n", COLUMN_FAMILY_4);
    // [START bigtable_create_family_gc_intersection]
    // Creates a column family with GC policy to drop data that matches all conditions.

    // Defines a GC rule to drop cells older than 5 days AND older than the most recent 2 versions.
    GCRules.DurationRule maxAgeRule3 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    GCRules.VersionRule versionRule3 = GCRules.GCRULES.maxVersions(2);
    GCRules.IntersectionRule intersectionRule1 =
        GCRules.GCRULES.intersection().rule(maxAgeRule3).rule(versionRule3);

    // Creates column family with given GC rule.
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest4 =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_4, intersectionRule1);
      adminClient.modifyFamilies(columnFamiliesRequest4);
      System.out.println("Created column family: " + COLUMN_FAMILY_4);
    } catch (AlreadyExistsException e) {
      System.err.println(
          "Failed to create column family with rule, already exists: " + e.getMessage());
    }
    // [END bigtable_create_family_gc_intersection]
  }

  /** Demonstrates how to create a nested rule using the IntersectionRule and UnionRule. */
  public void nestedRule() {
    System.out.printf("%nCreating column family %s with a nested GC rule%n", COLUMN_FAMILY_5);
    // [START bigtable_create_family_gc_nested]
    // Creates a nested GC rule:
    // Drop cells that are either older than the 10 recent versions
    // OR
    // Drop cells that are older than a month AND older than the 2 recent versions
    GCRules.VersionRule versionRule4 = GCRules.GCRULES.maxVersions(10);
    GCRules.DurationRule maxAgeRule4 = GCRules.GCRULES.maxAge(30, TimeUnit.DAYS);
    GCRules.VersionRule versionRule5 = GCRules.GCRULES.maxVersions(2);
    GCRules.IntersectionRule intersectionRule2 =
        GCRules.GCRULES.intersection().rule(maxAgeRule4).rule(versionRule5);
    GCRules.UnionRule unionRule2 =
        GCRules.GCRULES.union().rule(intersectionRule2).rule(versionRule4);

    // Creates column family with given GC rule.
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest5 =
          ModifyColumnFamiliesRequest.of(tableId).addFamily(COLUMN_FAMILY_5, unionRule2);
      adminClient.modifyFamilies(columnFamiliesRequest5);
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
        printColumnFamily(columnFamily);
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
    GCRules.VersionRule versionRule6 = GCRules.GCRULES.maxVersions(1);
    try {
      // Updates column family with given GC rule.
      ModifyColumnFamiliesRequest updateRequest =
          ModifyColumnFamiliesRequest.of(tableId).updateFamily(COLUMN_FAMILY_1, versionRule6);
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
          printColumnFamily(columnFamily);
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

  private static void printColumnFamily(ColumnFamily columnFamily) {
    System.out.printf(
        "Column family: %s%nMetadata: %s%n",
        columnFamily.getId(), columnFamily.getGCRule().toString());
  }
}
