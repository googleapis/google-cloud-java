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

// [START data_catalog_update_entry]
import com.google.cloud.datacatalog.v1.DataCatalogClient;
import com.google.cloud.datacatalog.v1.Entry;
import com.google.cloud.datacatalog.v1.EntryName;
import com.google.cloud.datacatalog.v1.UpdateEntryRequest;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;

// Sample to update an entity
public class UpdateEntry {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    String entryGroupId = "MY_ENTRY_GROUP_ID";
    String entryId = "MY_ENTRY_ID";
    String description = "MY_DESCRIPTION";
    EntryName entryName = EntryName.of(projectId, location, entryGroupId, entryId);
    Entry entry =
        Entry.newBuilder().setName(entryName.toString()).setDescription(description).build();
    updateEntry(entry);
  }

  public static void updateEntry(Entry entry) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (DataCatalogClient client = DataCatalogClient.create()) {
      FieldMask fieldMask = FieldMaskUtil.fromString("description");
      UpdateEntryRequest request =
          UpdateEntryRequest.newBuilder().setEntry(entry).setUpdateMask(fieldMask).build();
      Entry entryUpdate = client.updateEntry(request);
      System.out.println("Entry updated successfully : " + entryUpdate.getDescription());
    }
  }
}
// [END data_catalog_update_entry]
