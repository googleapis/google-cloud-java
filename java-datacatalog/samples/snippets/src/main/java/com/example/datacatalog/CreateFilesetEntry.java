/*
 * Copyright 2019 Google Inc.
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

package com.example.datacatalog;

// [START data_catalog_create_fileset]
import com.google.cloud.datacatalog.v1.ColumnSchema;
import com.google.cloud.datacatalog.v1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.EntryGroupName;
import com.google.cloud.datacatalog.v1.EntryType;
import com.google.cloud.datacatalog.v1.GcsFilesetSpec;
import com.google.cloud.datacatalog.v1.Schema;
import java.io.IOException;

// Sample to create file set entry
public class CreateFilesetEntry {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String entryGroupId = "fileset_entry_group";
    String entryId = "fileset_entry_id";
    createFilesetEntry(projectId, entryGroupId, entryId);
  }

  // Create Fileset Entry.
  public static void createFilesetEntry(String projectId, String entryGroupId, String entryId)
      throws IOException {
    // Currently, Data Catalog stores metadata in the us-central1 region.
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      // Construct the Entry for the Entry request.
      Entry entry =
          Entry.newBuilder()
              .setDisplayName("My Fileset")
              .setDescription("This fileset consists of ....")
              .setGcsFilesetSpec(
                  GcsFilesetSpec.newBuilder().addFilePatterns("gs://cloud-samples-data/*").build())
              .setSchema(
                  Schema.newBuilder()
                      .addColumns(
                          ColumnSchema.newBuilder()
                              .setColumn("first_name")
                              .setDescription("First name")
                              .setMode("REQUIRED")
                              .setType("STRING")
                              .build())
                      .addColumns(
                          ColumnSchema.newBuilder()
                              .setColumn("last_name")
                              .setDescription("Last name")
                              .setMode("REQUIRED")
                              .setType("STRING")
                              .build())
                      .addColumns(
                          ColumnSchema.newBuilder()
                              .setColumn("addresses")
                              .setDescription("Addresses")
                              .setMode("REPEATED")
                              .setType("RECORD")
                              .addSubcolumns(
                                  ColumnSchema.newBuilder()
                                      .setColumn("city")
                                      .setDescription("City")
                                      .setMode("NULLABLE")
                                      .setType("STRING")
                                      .build())
                              .addSubcolumns(
                                  ColumnSchema.newBuilder()
                                      .setColumn("state")
                                      .setDescription("State")
                                      .setMode("NULLABLE")
                                      .setType("STRING")
                                      .build())
                              .build())
                      .build())
              .setType(EntryType.FILESET)
              .build();

      // Construct the Entry request to be sent by the client.
      CreateEntryRequest entryRequest =
          CreateEntryRequest.newBuilder()
              .setParent(EntryGroupName.of(projectId, location, entryGroupId).toString())
              .setEntryId(entryId)
              .setEntry(entry)
              .build();

      // Use the client to send the API request.
      Entry entryCreated = dataCatalogClient.createEntry(entryRequest);
      System.out.printf("Entry created with name: %s", entryCreated.getName());
    }
  }
}
// [END data_catalog_create_fileset]
