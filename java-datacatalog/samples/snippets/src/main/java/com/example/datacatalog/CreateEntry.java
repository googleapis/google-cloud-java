/*
 * Copyright 2020 Google LLC
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

// [START data_catalog_create_entry]
import com.google.cloud.datacatalog.v1.CreateEntryRequest;
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.EntryGroupName;
import java.io.IOException;

// Sample to create an entry
public class CreateEntry {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    String entryGroupId = "MY_ENTRY_GROUP_ID";
    String entryId = "MY_ENTRY_ID";
    EntryGroupName entryGroupName = EntryGroupName.of(projectId, location, entryGroupId);
    Entry entry = Entry.newBuilder().build();
    createEntry(entryGroupName, entryId, entry);
  }

  public static void createEntry(EntryGroupName entryGroupName, String entryId, Entry entry)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient client = DataCatalogClient.create()) {
      CreateEntryRequest request =
          CreateEntryRequest.newBuilder()
              .setParent(entryGroupName.toString())
              .setEntryId(entryId)
              .setEntry(entry)
              .build();
      client.createEntry(request);
      System.out.println("Entry created successfully");
    }
  }
}
// [END data_catalog_create_entry]
