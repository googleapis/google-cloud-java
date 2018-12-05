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

public class TableAdmin {

  public static void main(String... args) {

    final String GCLOUD_PROJECT = args[0];
    final String INSTANCE_ID = args[1];
    final String TABLE_ID = "table";

    if (args.length < 2) {
      System.out.println("Missing required project id or instance id");
      return;
    }

    try {
      // Create the settings to configure a bigtable admin client
      BigtableTableAdminSettings adminSettings = BigtableTableAdminSettings.newBuilder()
          .setInstanceName(
              com.google.bigtable.admin.v2.InstanceName.of(GCLOUD_PROJECT, INSTANCE_ID)).build();

      // Create bigtable admin client
      BigtableTableAdminClient adminClient = BigtableTableAdminClient.create(adminSettings);

      // Check if table exists, create table if does not exist
      createTable(adminClient, TABLE_ID);

      // List all tables in current instance
      listAllTables(adminClient);

      // Print table metadata
      getTableMeta(adminClient, TABLE_ID);

      // Create column family with max age GC rule
      maxAgeRule(adminClient, TABLE_ID, "cf1");

      // Create column family with max versions GC rule
      maxVersionsRule(adminClient, TABLE_ID, "cf2");

      // Create column family with union GC rule
      unionRule(adminClient, TABLE_ID, "cf3");

      // Create column family with intersection GC rule
      intersectionRule(adminClient, TABLE_ID, "cf4");

      // Create column family with nested GC rule
      nestedRule(adminClient, TABLE_ID, "cf5");

      // List column families for given table
      listColumnFamilies(adminClient, TABLE_ID);

      // Modify column family cf1's GC rule
      modifyColumnFamilyRule(adminClient, TABLE_ID, "cf1");

      // Print updated column family cf1's rule
      printModifiedColumnFamily(adminClient, TABLE_ID, "cf1");

      // Delete column family cf2
      deleteColumnFamily(adminClient, TABLE_ID, "cf2");

      // Delete table
      deleteTable(adminClient, TABLE_ID);

    } catch (IOException ex) {
      System.out.println("Exception while running BigtableTableAdmin: " + ex.getMessage());
    }
  }

  public static Table createTable(BigtableTableAdminClient adminClient, String TABLE_ID) {
    // [START bigtable_create_table]
    // Check if table exists
    Table table = null;
    if (!adminClient.exists(TABLE_ID)) {
      // Create table if does not exist
      System.out.println("Table does not exist. Creating table: " + TABLE_ID);
      // Creating table
      try {
        CreateTableRequest createTableRequest = CreateTableRequest.of(TABLE_ID).addFamily("cf");
        table = adminClient.createTable(createTableRequest);
        System.out.printf("Table: %s created successfully\n", table.getId());
      } catch (Exception ex) {
        System.out.println("Error creating table: " + ex.getMessage());
      }
    } else {
      System.out.println("Table exists");
      table = adminClient.getTable(TABLE_ID);
    }
    // [END bigtable_create_table]
    return table;
  }

  public static List<String> listAllTables(BigtableTableAdminClient adminClient) {
    System.out.println("\nListing tables in current instance:");
    // [START bigtable_list_tables]
    // List tables in current instance
    List<String> listTables = null;
    try {
      listTables = adminClient.listTables();
      for (String tableName : listTables) {
        System.out.println(tableName);
      }
    } catch (Exception ex) {
      System.out.println("Error listing tables in current instance: " + ex.getMessage());
    }
    // [END bigtable_list_tables]
    return listTables;
  }

  public static Table getTableMeta(BigtableTableAdminClient adminClient, String TABLE_ID) {
    System.out.println("\nPrinting table metadata:");
    // [START bigtable_get_table_metadata]
    // Get table metadata, and apply a view to the table fields
    Table table = null;
    try {
      table = adminClient.getTable(TABLE_ID);
      System.out.println("Table: " + table.getId());
      Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
      for (ColumnFamily columnFamily : columnFamilies) {
        printColumnFamily(columnFamily);
      }
    } catch (Exception ex) {
      System.out.println("Error retrieving table metadata: " + ex.getMessage());
    }
    // [END bigtable_get_table_metadata]
    return table;
  }

  public static Table maxAgeRule(BigtableTableAdminClient adminClient, String TABLE_ID, String cf) {
    System.out.printf("\nCreating column family %s with max age GC rule:\n", cf);
    // [START bigtable_create_family_gc_max_age]
    // Create a column family with GC policy : maximum age
    // where age = current time minus cell timestamp

    // Define the GC rule to retain data with max age of 5 days
    GCRules.DurationRule maxAgeRule1 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);

    // Create column family with given GC rule
    Table table = null;
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest1 =
          ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily(cf, maxAgeRule1);
      table = adminClient.modifyFamilies(columnFamiliesRequest1);
      System.out.println("Created column family: " + cf);
    } catch (Exception ex) {
      System.out.println("Error creating column family: " + ex.getMessage());
    }
    // [END bigtable_create_family_gc_max_age]
    return table;
  }

  public static Table maxVersionsRule(BigtableTableAdminClient adminClient, String TABLE_ID,
      String cf) {
    System.out.printf("\nCreating column family %s with max versions GC rule:\n", cf);
    // [START bigtable_create_family_gc_max_versions]
    // Create a column family with GC policy : most recent N versions
    // where 1 = most recent version

    // Define the GC policy to retain only the most recent 2 versions
    GCRules.VersionRule versionRule1 = GCRules.GCRULES.maxVersions(2);

    // Create column family with given GC rule
    Table table = null;
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest2 =
          ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily(cf, versionRule1);
      table = adminClient.modifyFamilies(columnFamiliesRequest2);
      System.out.println("Created column family: " + cf);
    } catch (Exception ex) {
      System.out.println("Error creating column family: " + ex.getMessage());
    }
    // [END bigtable_create_family_gc_max_versions]
    return table;
  }

  public static Table unionRule(BigtableTableAdminClient adminClient, String TABLE_ID, String cf) {
    System.out.printf("\nCreating column family %s with union GC rule:\n", cf);
    // [START bigtable_create_family_gc_union]
    // Create a column family with GC policy to drop data that matches at least one condition.

    // Define a GC rule to drop cells older than 5 days OR not the most recent version
    GCRules.DurationRule maxAgeRule2 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    GCRules.VersionRule versionRule2 = GCRules.GCRULES.maxVersions(1);
    // Add rules to union rule list
    GCRules.UnionRule unionRule1 = GCRules.GCRULES.union().rule(maxAgeRule2).rule(versionRule2);

    // Create column family with given GC rule
    Table table = null;
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest3 =
          ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily(cf, unionRule1);
      table = adminClient.modifyFamilies(columnFamiliesRequest3);
      System.out.println("Created column family: " + cf);
    } catch (Exception ex) {
      System.out.println("Error creating column family: " + ex.getMessage());
    }
    // [END bigtable_create_family_gc_union]
    return table;
  }

  public static Table intersectionRule(BigtableTableAdminClient adminClient, String TABLE_ID,
      String cf) {
    System.out.printf("\nCreating column family %s with intersection GC rule:\n", cf);
    // [START bigtable_create_family_gc_intersection]
    // Create a column family with GC policy to drop data that matches all conditions

    // GC rule: Drop cells older than 5 days AND older than the most recent 2 versions
    GCRules.DurationRule maxAgeRule3 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
    GCRules.VersionRule versionRule3 = GCRules.GCRULES.maxVersions(2);
    GCRules.IntersectionRule intersectionRule1 =
        GCRules.GCRULES.intersection().rule(maxAgeRule3).rule(versionRule3);

    // Create column family with given GC rule
    Table table = null;
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest4 =
          ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily(cf, intersectionRule1);
      table = adminClient.modifyFamilies(columnFamiliesRequest4);
      System.out.println("Created column family: " + cf);
    } catch (Exception ex) {
      System.out.println("Error creating column family: " + ex.getMessage());
    }
    // [END bigtable_create_family_gc_intersection]
    return table;
  }

  public static Table nestedRule(BigtableTableAdminClient adminClient, String TABLE_ID, String cf) {
    System.out.printf("\nCreating column family %s with a nested GC rule:\n", cf);
    // [START bigtable_create_family_gc_nested]
    // Create a nested GC rule:
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

    // Create column family with given GC rule
    Table table = null;
    try {
      ModifyColumnFamiliesRequest columnFamiliesRequest5 =
          ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily(cf, unionRule2);
      table = adminClient.modifyFamilies(columnFamiliesRequest5);
      System.out.println("Created column family: " + cf);
    } catch (Exception ex) {
      System.out.println("Error creating column family: " + ex.getMessage());
    }
    // [END bigtable_create_family_gc_nested]
    return table;
  }

  public static Collection<ColumnFamily> listColumnFamilies(BigtableTableAdminClient adminClient,
      String TABLE_ID) {
    System.out.println("\nPrinting ID and GC Rule for all column families:");
    // [START bigtable_list_column_families]
    // List all families in the table with GC rules
    Collection<ColumnFamily> columnFamilies = null;
    try {
      Table table = adminClient.getTable(TABLE_ID);
      columnFamilies = table.getColumnFamilies();
      for (ColumnFamily columnFamily : columnFamilies) {
        printColumnFamily(columnFamily);
      }
    } catch (Exception ex) {
      System.out.println("Error retrieving families: " + ex.getMessage());
    }
    // [END bigtable_list_column_families]
    return columnFamilies;
  }

  public static Table modifyColumnFamilyRule(BigtableTableAdminClient adminClient, String TABLE_ID,
      String cf) {
    System.out.printf("\nUpdating column family %s GC rule:\n", cf);
    // [START bigtable_update_gc_rule]
    // Update the column family metadata to update the GC rule
    // Update a column family GC rule
    GCRules.VersionRule versionRule6 = GCRules.GCRULES.maxVersions(1);
    Table table = null;
    try {
      // Update column family with given GC rule
      ModifyColumnFamiliesRequest updateRequest =
          ModifyColumnFamiliesRequest.of(TABLE_ID).updateFamily(cf, versionRule6);
      table = adminClient.modifyFamilies(updateRequest);
      System.out.printf("Column family %s GC rule updated\n", cf);
    } catch (Exception ex) {
      System.out.printf("Error updating GC rule for %s: %s\n", cf, ex.getMessage());
    }
    // [END bigtable_update_gc_rule]
    return table;
  }

  public static ColumnFamily printModifiedColumnFamily(BigtableTableAdminClient adminClient,
      String TABLE_ID, String cf) {
    System.out.printf("\nPrint updated GC rule for column family: %s\n", cf);
    // [START bigtable_family_get_gc_rule]
    ColumnFamily colFamily = null;
    try {
      Table table = adminClient.getTable(TABLE_ID);
      Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
      for (ColumnFamily columnFamily : columnFamilies) {
        if (columnFamily.getId().equals(cf)) {
          printColumnFamily(columnFamily);
          colFamily = columnFamily;
        }
      }
    } catch (Exception ex) {
      System.out
          .printf("Error retrieving metadata for column family: %s\n%s\n", cf, ex.getMessage());
    }
    // [END bigtable_family_get_gc_rule]
    return colFamily;
  }

  public static Table deleteColumnFamily(BigtableTableAdminClient adminClient, String TABLE_ID,
      String cf) {
    System.out.println("\nDelete column family: " + cf);
    // [START bigtable_delete_family]
    // Delete a column family
    Table table = null;
    try {
      ModifyColumnFamiliesRequest deleted = ModifyColumnFamiliesRequest.of(TABLE_ID).dropFamily(cf);
      table = adminClient.modifyFamilies(deleted);
      System.out.printf("Column family %s deleted successfully\n", cf);
    } catch (Exception ex) {
      System.out.printf("Error deleting family: %s\n%s\n", cf, ex.getMessage());
    }
    // [END bigtable_delete_family]
    return table;
  }

  public static void deleteTable(BigtableTableAdminClient adminClient, String TABLE_ID) {
    // [START bigtable_delete_table]
    // Delete the entire table
    System.out.println("Delete table: " + TABLE_ID);
    try {
      adminClient.deleteTable(TABLE_ID);
      System.out.println("Table deleted: " + TABLE_ID);
    } catch (Exception ex) {
      System.out.printf("Error deleting table %s: %s\n", TABLE_ID, ex.getMessage());
    }
    // [END bigtable_delete_table]
  }

  private static void printColumnFamily(ColumnFamily columnFamily) {
    System.out.printf("Column family: %s\nMetadata: %s\n", columnFamily.getId(),
        columnFamily.getGCRule().toString());
  }
}
