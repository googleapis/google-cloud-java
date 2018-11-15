package com.google.cloud.examples.bigtable;

import com.google.bigtable.admin.v2.TableName;
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

  public static void main(String[] args) {

    String GCLOUD_PROJECT = System.getenv("GCLOUD_PROJECT");
    String INSTANCE_ID = System.getenv("INSTANCE_ID");
    String TABLE_ID = "TABLE_ID";

    if (GCLOUD_PROJECT.length() == 0 || INSTANCE_ID.length() == 0) {
      throw new Error("Environment variables must be set!");
    }

    try {
      BigtableTableAdminSettings adminSettings = BigtableTableAdminSettings.newBuilder()
          .setInstanceName(
              com.google.bigtable.admin.v2.InstanceName.of(GCLOUD_PROJECT, INSTANCE_ID)).build();

      BigtableTableAdminClient adminClient = BigtableTableAdminClient.create(adminSettings);

      // Check if table exists
      if (!adminClient.exists(TABLE_ID)) {
        // Create table if does not exist
        System.out.println("Table does not exist. Creating table " + TABLE_ID);
        // Creating table
        try {
          CreateTableRequest createTableRequest = CreateTableRequest.of(TABLE_ID);
          Table table = adminClient.createTable(createTableRequest);
          System.out.println("Table : " + table.getId() + "created successfully");
        } catch (Exception ex) {
          System.out.println("Error creating table: " + ex.getMessage());
        }
      } else {
        System.out.println("Table exists.");
      }

      System.out.println("\nListing tables in current project...");
      // [START bigtable_list_tables]
      // List tables in current instance
      try {
        List<TableName> listTables = adminClient.listTables();
        for (TableName tableName : listTables) {
          System.out.println(tableName.getTable());
        }
      } catch (Exception ex) {
        System.out.println("Error listing tables in current project: " + ex.getMessage());
      }
      // [END bigtable_list_tables]

      System.out.println("\nPrinting table metadata...");
      // [START bigtable_get_table_metadata]
      // Get table metadata, and apply a view to the table fields
      try {
        Table table = adminClient.getTable(TABLE_ID);
        Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
        for (ColumnFamily columnFamily : columnFamilies) {
          printColumnFamily(columnFamily);
        }
      } catch (Exception ex) {
        System.out.println("Error retrieving table metadata: " + ex.getMessage());
      }
      // [END bigtable_get_table_metadata]

      System.out.println("\nCreating column family cf1 with max age GC rule...");
      // [START bigtable_create_family_gc_max_age]
      // Create a column family with GC policy : maximum age
      // where age = current time minus cell timestamp

      // Define the GC rule to retain data with max age of 5 days
      GCRules.DurationRule maxAgeRule1 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);

      // Create column family with given GC rule
      try {
        ModifyColumnFamiliesRequest columnFamiliesRequest1 =
            ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily("cf1", maxAgeRule1);
        adminClient.modifyFamilies(columnFamiliesRequest1);
        System.out.println("Created column family cf1");
      } catch (Exception ex) {
        System.out.println("Error creating column family: " + ex.getMessage());
      }
      // [END bigtable_create_family_gc_max_age]

      System.out.println("\nCreating column family cf2 with max versions GC rule...");
      // [START bigtable_create_family_gc_max_versions]
      // Create a column family with GC policy : most recent N versions
      // where 1 = most recent version

      // Define the GC policy to retain only the most recent 2 versions
      GCRules.VersionRule versionRule1 = GCRules.GCRULES.maxVersions(2);

      // Create column family with given GC rule
      try {
        ModifyColumnFamiliesRequest columnFamiliesRequest2 =
            ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily("cf2", versionRule1);
        adminClient.modifyFamilies(columnFamiliesRequest2);
        System.out.println("Created column family cf2");
      } catch (Exception ex) {
        System.out.println("Error creating column family: " + ex.getMessage());
      }
      // [END bigtable_create_family_gc_max_versions]

      System.out.println("\nCreating column family cf3 with union GC rule...");
      // [START bigtable_create_family_gc_union]
      // Create a column family with GC policy to drop data that matches at least one condition.

      // Define a GC rule to drop cells older than 5 days OR not the most recent version
      GCRules.DurationRule maxAgeRule2 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
      GCRules.VersionRule versionRule2 = GCRules.GCRULES.maxVersions(1);
      // Add rules to union rule list
      GCRules.UnionRule unionRule1 = GCRules.GCRULES.union().rule(maxAgeRule2).rule(versionRule2);

      // Create column family with given GC rule
      try {
        ModifyColumnFamiliesRequest columnFamiliesRequest3 =
            ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily("cf3", unionRule1);
        adminClient.modifyFamilies(columnFamiliesRequest3);
        System.out.println("Created column family cf3");
      } catch (Exception ex) {
        System.out.println("Error creating column family: " + ex.getMessage());
      }
      // [END bigtable_create_family_gc_union]

      System.out.println("\nCreating column family cf4 with intersection GC rule...");
      // [START bigtable_create_family_gc_intersection]
      // Create a column family with GC policy to drop data that matches all conditions

      // GC rule: Drop cells older than 5 days AND older than the most recent 2 versions
      GCRules.DurationRule maxAgeRule3 = GCRules.GCRULES.maxAge(5, TimeUnit.DAYS);
      GCRules.VersionRule versionRule3 = GCRules.GCRULES.maxVersions(2);
      GCRules.IntersectionRule intersectionRule1 =
          GCRules.GCRULES.intersection().rule(maxAgeRule3).rule(versionRule3);

      // Create column family with given GC rule
      try {
        ModifyColumnFamiliesRequest columnFamiliesRequest4 =
            ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily("cf4", intersectionRule1);
        adminClient.modifyFamilies(columnFamiliesRequest4);
        System.out.println("Created column family cf4");
      } catch (Exception ex) {
        System.out.println("Error creating column family: " + ex.getMessage());
      }
      // [END bigtable_create_family_gc_intersection]

      System.out.println("\nCreating column family cf5 with a nested GC rule");
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
      try {
        ModifyColumnFamiliesRequest columnFamiliesRequest5 =
            ModifyColumnFamiliesRequest.of(TABLE_ID).addFamily("cf5", unionRule2);
        adminClient.modifyFamilies(columnFamiliesRequest5);
        System.out.println("Created column family cf5");
      } catch (Exception ex) {
        System.out.println("Error creating column family: " + ex.getMessage());
      }
      // [END bigtable_create_family_gc_nested]

      System.out.println("\nPrinting ID and GC Rule for all column families...");
      // [START bigtable_list_column_families]
      // List all families in the table with GC rules
      try {
        Table table = adminClient.getTable(TABLE_ID);
        Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
        for (ColumnFamily columnFamily : columnFamilies) {
          printColumnFamily(columnFamily);
        }
      } catch (Exception ex) {
        System.out.println("Error retrieving families: " + ex.getMessage());
      }
      // [END bigtable_list_column_families]

      System.out.println("\nUpdating column family cf1 GC rule...");
      // [START bigtable_update_gc_rule]
      // Update the column family metadata to update the GC rule

      // Update a column family GC rule
      GCRules.VersionRule versionRule6 = GCRules.GCRULES.maxVersions(1);
      try {
        // Update column family with given GC rule
        ModifyColumnFamiliesRequest updateRequest =
            ModifyColumnFamiliesRequest.of(TABLE_ID).updateFamily("cf1", versionRule6);
        adminClient.modifyFamilies(updateRequest);
      } catch (Exception ex) {
        System.out.println("Error updating GC rule for cf1: " + ex.getMessage());
      }
      // [END bigtable_update_gc_rule]

      System.out.println("\nPrint updated column family cf1 GC rule...");
      // [START bigtable_family_get_gc_rule]
      try {
        Table table = adminClient.getTable(TABLE_ID);
        Collection<ColumnFamily> columnFamilies = table.getColumnFamilies();
        for (ColumnFamily columnFamily : columnFamilies) {
          if (columnFamily.getId().equals("cf1")) {
            printColumnFamily(columnFamily);
          }
        }
      } catch (Exception ex) {
        System.out.println("Error retrieving family cf1 metadata:" + ex.getMessage());
      }
      // [END bigtable_family_get_gc_rule]

      System.out.println("\nDelete a column family cf2...");
      // [START bigtable_delete_family]
      // Delete a column family
      try {
        ModifyColumnFamiliesRequest deletecf2 =
            ModifyColumnFamiliesRequest.of(TABLE_ID).dropFamily("cf2");
        adminClient.modifyFamilies(deletecf2);
        System.out.println("cf2 deleted successfully\n");
      } catch (Exception ex) {
        System.out.println("Error deleting family cf2: " + ex.getMessage());
      }

      // [START bigtable_delete_table]
      // Delete the entire table
      System.out.println("Delete the table");
      try {
        adminClient.deleteTable(TABLE_ID);
        System.out.println("Table deleted: " + TABLE_ID);
      } catch (Exception ex) {
        System.out.println("Error deleting table " + TABLE_ID + ": " + ex.getMessage());
      }
      // [END bigtable_delete_table]
    } catch (IOException ex) {
      System.out.println("Error creating Bigtable Table Admin: " + ex.getMessage());
    }
  }

  private static void printColumnFamily(ColumnFamily columnFamily) {
    System.out.println(
        "Column family: " + columnFamily.getId() + "\nMetadata: " + columnFamily.getGCRule());
  }
}