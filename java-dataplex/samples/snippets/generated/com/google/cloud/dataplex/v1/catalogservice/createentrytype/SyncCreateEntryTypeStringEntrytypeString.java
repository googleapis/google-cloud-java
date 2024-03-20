/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.dataplex.v1.samples;

// [START dataplex_v1_generated_CatalogService_CreateEntryType_StringEntrytypeString_sync]
import com.google.cloud.dataplex.v1.CatalogServiceClient;
import com.google.cloud.dataplex.v1.EntryType;
import com.google.cloud.dataplex.v1.LocationName;

public class SyncCreateEntryTypeStringEntrytypeString {

  public static void main(String[] args) throws Exception {
    syncCreateEntryTypeStringEntrytypeString();
  }

  public static void syncCreateEntryTypeStringEntrytypeString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      EntryType entryType = EntryType.newBuilder().build();
      String entryTypeId = "entryTypeId-1105721081";
      EntryType response =
          catalogServiceClient.createEntryTypeAsync(parent, entryType, entryTypeId).get();
    }
  }
}
// [END dataplex_v1_generated_CatalogService_CreateEntryType_StringEntrytypeString_sync]
