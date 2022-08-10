/*
 * Copyright 2020 Google Inc.
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

// [START data_catalog_create_custom_entry]
import com.google.cloud.datacatalog.v1.ColumnSchema;
import com.google.cloud.datacatalog.v1.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.v1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.EntryGroup;
import com.google.cloud.datacatalog.v1.LocationName;
import com.google.cloud.datacatalog.v1.Schema;
import java.io.IOException;

// Sample to create custom entry
public class CreateCustomEntry {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project";
    String entryGroupId = "onprem_entry_group";
    String entryId = "onprem_entry_id";
    createCustomEntry(projectId, entryGroupId, entryId);
  }

  public static void createCustomEntry(String projectId, String entryGroupId, String entryId)
      throws IOException {
    // Currently, Data Catalog stores metadata in the us-central1 region.
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      // Construct the EntryGroup for the EntryGroup request.
      EntryGroup entryGroup =
          EntryGroup.newBuilder()
              .setDisplayName("My awesome Entry Group")
              .setDescription("This Entry Group represents an external system")
              .build();

      // Construct the EntryGroup request to be sent by the client.
      CreateEntryGroupRequest entryGroupRequest =
          CreateEntryGroupRequest.newBuilder()
              .setParent(LocationName.of(projectId, location).toString())
              .setEntryGroupId(entryGroupId)
              .setEntryGroup(entryGroup)
              .build();

      // Use the client to send the API request.
      EntryGroup createdEntryGroup = dataCatalogClient.createEntryGroup(entryGroupRequest);

      // Construct the Entry for the Entry request.
      Entry entry =
          Entry.newBuilder()
              .setUserSpecifiedSystem("onprem_data_system")
              .setUserSpecifiedType("onprem_data_asset")
              .setDisplayName("My awesome data asset")
              .setDescription("This data asset is managed by an external system.")
              .setLinkedResource("//my-onprem-server.com/dataAssets/my-awesome-data-asset")
              .setSchema(
                  Schema.newBuilder()
                      .addColumns(
                          ColumnSchema.newBuilder()
                              .setColumn("first_column")
                              .setDescription("This columns consists of ....")
                              .setMode("NULLABLE")
                              .setType("DOUBLE")
                              .build())
                      .addColumns(
                          ColumnSchema.newBuilder()
                              .setColumn("second_column")
                              .setDescription("This columns consists of ....")
                              .setMode("REQUIRED")
                              .setType("STRING")
                              .build())
                      .build())
              .build();

      // Construct the Entry request to be sent by the client.
      CreateEntryRequest entryRequest =
          CreateEntryRequest.newBuilder()
              .setParent(createdEntryGroup.getName())
              .setEntryId(entryId)
              .setEntry(entry)
              .build();

      // Use the client to send the API request.
      Entry createdEntry = dataCatalogClient.createEntry(entryRequest);
      System.out.printf("Custom entry created with name: %s", createdEntry.getName());
    }
  }
}
// [END data_catalog_create_custom_entry]
