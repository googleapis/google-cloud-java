/*
 * Copyright 2025 Google LLC
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

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateSchemaBundleRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.SchemaBundle;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateSchemaBundleRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This example demonstrates the usage of BigtableTableAdminClient to create, configure and delete a
 * Cloud Bigtable schema bundle.
 *
 * <p>The example follows these steps:
 *
 * <ol>
 *   <li>Creates a Bigtable table.
 *   <li>Creates a schema bundle.
 *   <li>Updates a schema bundle.
 *   <li>Gets the schema bundle.
 *   <li>Lists all schema bundles for the table.
 *   <li>Deletes the schema bundle.
 *   <li>Deletes the table.
 * </ol>
 */
public class SchemaBundleExample {

  private static final String COLUMN_FAMILY = "cf";
  private static final String PROTO_FILE_PATH = "com/example/bigtable/descriptors.pb";
  private final String tableId;
  private final String schemaBundleId;
  private final BigtableTableAdminClient adminClient;

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Missing required project id or instance id");
      return;
    }
    String projectId = args[0];
    String instanceId = args[1];

    SchemaBundleExample example =
        new SchemaBundleExample(projectId, instanceId, "test-table", "test-schema-bundle");
    example.run();
  }

  public SchemaBundleExample(
      String projectId, String instanceId, String tableId, String schemaBundleId)
      throws IOException {
    this.tableId = tableId;
    this.schemaBundleId = schemaBundleId;

    // Creates the settings to configure a bigtable table admin client.
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build();

    // Creates a bigtable table admin client.
    adminClient = BigtableTableAdminClient.create(adminSettings);
  }

  public void close() {
    adminClient.close();
  }

  public void run() {
    createTable();
    createSchemaBundle();
    updateSchemaBundle();
    getSchemaBundle();
    listAllSchemaBundles();
    deleteSchemaBundle();
    deleteTable();
    close();
  }

  public void createTable() {
    // Checks if table exists, creates table if it does not exist.
    if (!adminClient.exists(tableId)) {
      System.out.println("Table does not exist, creating table: " + tableId);
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(tableId).addFamily(COLUMN_FAMILY);
      Table table = adminClient.createTable(createTableRequest);
      System.out.printf("Table: %s created successfully%n", table.getId());
    }
  }

  public void deleteTable() {
    // Deletes the entire table.
    System.out.println("\nDelete table: " + tableId);
    try {
      adminClient.deleteTable(tableId);
      System.out.printf("Table: %s deleted successfully%n", tableId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent table: " + e.getMessage());
    }
  }

  /** Demonstrates how to create a schema bundle under a table with the specified schema. */
  public void createSchemaBundle() {
    // Checks if the schema bundle exists, creates it if it does not exist.
    try {
      adminClient.getSchemaBundle(tableId, schemaBundleId);
    } catch (NotFoundException exception) {
      System.out.printf("%nCreating schema bundle %s in table %s%n", schemaBundleId, tableId);
      // [START bigtable_create_schema_bundle]
      try {
        InputStream in = getClass().getClassLoader().getResourceAsStream(PROTO_FILE_PATH);
        CreateSchemaBundleRequest request =
            CreateSchemaBundleRequest.of(tableId, schemaBundleId)
                .setProtoSchema(ByteString.readFrom(in));
        SchemaBundle schemaBundle = adminClient.createSchemaBundle(request);
        System.out.printf("Schema bundle: %s created successfully%n", schemaBundle.getId());
      } catch (NotFoundException e) {
        System.err.println(
            "Failed to create a schema bundle from a non-existent table: " + e.getMessage());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      // [END bigtable_create_schema_bundle]
    }
  }

  /** Demonstrates how to modify a schema bundle. */
  public void updateSchemaBundle() {
    System.out.printf("%nUpdating schema bundle %s in table %s%n", schemaBundleId, tableId);
    // [START bigtable_update_schema_bundle]
    try {
      InputStream in = getClass().getClassLoader().getResourceAsStream(PROTO_FILE_PATH);
      UpdateSchemaBundleRequest request =
          UpdateSchemaBundleRequest.of(tableId, schemaBundleId)
              .setProtoSchema(ByteString.readFrom(in));
      SchemaBundle schemaBundle = adminClient.updateSchemaBundle(request);
      System.out.printf("Schema bundle: %s updated successfully%n", schemaBundle.getId());
    } catch (NotFoundException e) {
      System.err.println("Failed to modify a non-existent schema bundle: " + e.getMessage());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // [END bigtable_update_schema_bundle]
  }

  /** Demonstrates how to get a schema bundle's definition. */
  public SchemaBundle getSchemaBundle() {
    System.out.printf("%nGetting schema bundle %s in table %s%n", schemaBundleId, tableId);
    // [START bigtable_get_schema_bundle]
    SchemaBundle schemaBundle = null;
    try {
      schemaBundle = adminClient.getSchemaBundle(tableId, schemaBundleId);
      // Deserialize and print the FileDescriptorSet
      DescriptorProtos.FileDescriptorSet fileDescriptorSet =
          DescriptorProtos.FileDescriptorSet.parseFrom(schemaBundle.getProtoSchema());

      System.out.println("--------- Deserialized FileDescriptorSet ---------");
      for (DescriptorProtos.FileDescriptorProto fileDescriptorProto :
          fileDescriptorSet.getFileList()) {
        System.out.println("File: " + fileDescriptorProto.getName());
        System.out.println("  Package: " + fileDescriptorProto.getPackage());
        for (DescriptorProtos.DescriptorProto messageType :
            fileDescriptorProto.getMessageTypeList()) {
          System.out.println("  Message: " + messageType.getName());
        }
      }
      System.out.println("--------------------------------------------------");
    } catch (InvalidProtocolBufferException e) {
      System.err.println("Failed to parse FileDescriptorSet: " + e.getMessage());
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to retrieve metadata from a non-existent schema bundle: " + e.getMessage());
    }
    // [END bigtable_get_schema_bundle]
    return schemaBundle;
  }

  /** Demonstrates how to list all schema bundles within a table. */
  public List<String> listAllSchemaBundles() {
    System.out.printf("%nListing schema bundles in table %s%n", tableId);
    // [START bigtable_list_schema_bundles]
    List<String> schemaBundleIds = new ArrayList<>();
    try {
      schemaBundleIds = adminClient.listSchemaBundles(tableId);
      for (String schemaBundleId : schemaBundleIds) {
        System.out.println(schemaBundleId);
      }
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to list schema bundles from a non-existent table: " + e.getMessage());
    }
    // [END bigtable_list_schema_bundles]
    return schemaBundleIds;
  }

  /** Demonstrates how to delete a schema bundle. */
  public void deleteSchemaBundle() {
    System.out.printf("%nDeleting schema bundle %s in table %s%n", schemaBundleId, tableId);
    // [START bigtable_delete_schema_bundle]
    try {
      adminClient.deleteSchemaBundle(tableId, schemaBundleId);
      System.out.printf("SchemaBundle: %s deleted successfully%n", schemaBundleId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent schema bundle: " + e.getMessage());
    }
    // [END bigtable_delete_schema_bundle]
  }
}
