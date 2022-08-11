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

package com.google.cloud.recommendationengine.v1beta1.samples;

// [START recommendationengine_v1beta1_generated_catalogserviceclient_listcatalogitems_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.recommendationengine.v1beta1.CatalogItem;
import com.google.cloud.recommendationengine.v1beta1.CatalogName;
import com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest;

public class AsyncListCatalogItems {

  public static void main(String[] args) throws Exception {
    asyncListCatalogItems();
  }

  public static void asyncListCatalogItems() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      ListCatalogItemsRequest request =
          ListCatalogItemsRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      ApiFuture<CatalogItem> future =
          catalogServiceClient.listCatalogItemsPagedCallable().futureCall(request);
      // Do something.
      for (CatalogItem element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END recommendationengine_v1beta1_generated_catalogserviceclient_listcatalogitems_async]
