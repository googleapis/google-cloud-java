/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.productregistry.v1.samples;

// [START cloudproductregistry_v1_generated_CloudProductRegistryReadService_ListLogicalProducts_sync]
import com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient;
import com.google.cloud.productregistry.v1.ListLogicalProductsRequest;
import com.google.cloud.productregistry.v1.LogicalProduct;

public class SyncListLogicalProducts {

  public static void main(String[] args) throws Exception {
    syncListLogicalProducts();
  }

  public static void syncListLogicalProducts() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudProductRegistryReadServiceClient cloudProductRegistryReadServiceClient =
        CloudProductRegistryReadServiceClient.create()) {
      ListLogicalProductsRequest request =
          ListLogicalProductsRequest.newBuilder()
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      for (LogicalProduct element :
          cloudProductRegistryReadServiceClient.listLogicalProducts(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END cloudproductregistry_v1_generated_CloudProductRegistryReadService_ListLogicalProducts_sync]
