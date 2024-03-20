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

// [START dataplex_v1_generated_CatalogService_CreateEntryGroup_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.dataplex.v1.CatalogServiceClient;
import com.google.cloud.dataplex.v1.CreateEntryGroupRequest;
import com.google.cloud.dataplex.v1.EntryGroup;
import com.google.cloud.dataplex.v1.LocationName;
import com.google.cloud.dataplex.v1.OperationMetadata;

public class AsyncCreateEntryGroupLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateEntryGroupLRO();
  }

  public static void asyncCreateEntryGroupLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      CreateEntryGroupRequest request =
          CreateEntryGroupRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setEntryGroupId("entryGroupId1228924712")
              .setEntryGroup(EntryGroup.newBuilder().build())
              .setValidateOnly(true)
              .build();
      OperationFuture<EntryGroup, OperationMetadata> future =
          catalogServiceClient.createEntryGroupOperationCallable().futureCall(request);
      // Do something.
      EntryGroup response = future.get();
    }
  }
}
// [END dataplex_v1_generated_CatalogService_CreateEntryGroup_LRO_async]
