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

// [START datacatalog_create_entry_group_tag]

import com.google.api.gax.rpc.AlreadyExistsException;
import com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest;
import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.EntryGroup;
import com.google.cloud.datacatalog.v1beta1.LocationName;
import java.io.IOException;

public class CreateEntryGroup {

  public static void createEntryGroup() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String entryGroupId = "fileset_entry_group";
    createEntryGroup(projectId, entryGroupId);
  }

  // Create Entry Group.
  public static void createEntryGroup(String projectId, String entryGroupId) {
    // Currently, Data Catalog stores metadata in the us-central1 region.
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      // Construct the EntryGroup for the EntryGroup request.
      EntryGroup entryGroup =
          EntryGroup.newBuilder()
              .setDisplayName("My Fileset Entry Group")
              .setDescription("This Entry Group consists of ....")
              .build();

      // Construct the EntryGroup request to be sent by the client.
      CreateEntryGroupRequest entryGroupRequest =
          CreateEntryGroupRequest.newBuilder()
              .setParent(LocationName.of(projectId, location).toString())
              .setEntryGroupId(entryGroupId)
              .setEntryGroup(entryGroup)
              .build();

      // Use the client to send the API request.
      EntryGroup entryGroupResponse = dataCatalogClient.createEntryGroup(entryGroupRequest);
      System.out.printf("\nEntry Group created with name: %s\n", entryGroupResponse.getName());
    } catch (AlreadyExistsException | IOException e) {
      // AlreadyExistsException's are thrown if EntryGroup or Entry already exists.
      // IOException's are thrown when unable to create the DataCatalogClient,
      // for example an invalid Service Account path.
      System.out.println("Error in create entry process:\n" + e.toString());
    }
  }
}
// [END datacatalog_create_entry_group_tag]