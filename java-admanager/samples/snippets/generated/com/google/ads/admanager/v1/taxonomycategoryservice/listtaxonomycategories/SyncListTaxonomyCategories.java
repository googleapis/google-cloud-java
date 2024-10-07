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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_TaxonomyCategoryService_ListTaxonomyCategories_sync]
import com.google.ads.admanager.v1.ListTaxonomyCategoriesRequest;
import com.google.ads.admanager.v1.NetworkName;
import com.google.ads.admanager.v1.TaxonomyCategory;
import com.google.ads.admanager.v1.TaxonomyCategoryServiceClient;

public class SyncListTaxonomyCategories {

  public static void main(String[] args) throws Exception {
    syncListTaxonomyCategories();
  }

  public static void syncListTaxonomyCategories() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TaxonomyCategoryServiceClient taxonomyCategoryServiceClient =
        TaxonomyCategoryServiceClient.create()) {
      ListTaxonomyCategoriesRequest request =
          ListTaxonomyCategoriesRequest.newBuilder()
              .setParent(NetworkName.of("[NETWORK_CODE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .setSkip(3532159)
              .build();
      for (TaxonomyCategory element :
          taxonomyCategoryServiceClient.listTaxonomyCategories(request).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END admanager_v1_generated_TaxonomyCategoryService_ListTaxonomyCategories_sync]
