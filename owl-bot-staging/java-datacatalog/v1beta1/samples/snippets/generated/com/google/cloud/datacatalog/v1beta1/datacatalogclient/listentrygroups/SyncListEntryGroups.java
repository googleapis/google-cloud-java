/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datacatalog.v1beta1.samples;

// [START datacatalog_v1beta1_generated_datacatalogclient_listentrygroups_sync]
import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.EntryGroup;
import com.google.cloud.datacatalog.v1beta1.EntryGroupName;
import com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest;

public class SyncListEntryGroups {

  public static void main(String[] args) throws Exception {
    syncListEntryGroups();
  }

  public static void syncListEntryGroups() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      ListEntryGroupsRequest request =
          ListEntryGroupsRequest.newBuilder()
              .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (EntryGroup element : dataCatalogClient.listEntryGroups(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END datacatalog_v1beta1_generated_datacatalogclient_listentrygroups_sync]
