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

package com.google.cloud.privatecatalog.v1beta1.samples;

// [START privatecatalog_v1beta1_generated_privatecatalogclient_searchproducts_paged_async]
import com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient;
import com.google.cloud.privatecatalog.v1beta1.Product;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse;
import com.google.common.base.Strings;

public class AsyncSearchProductsPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchProductsPaged();
  }

  public static void asyncSearchProductsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PrivateCatalogClient privateCatalogClient = PrivateCatalogClient.create()) {
      SearchProductsRequest request =
          SearchProductsRequest.newBuilder()
              .setResource("resource-341064690")
              .setQuery("query107944136")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        SearchProductsResponse response =
            privateCatalogClient.searchProductsCallable().call(request);
        for (Product element : response.getProductsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END privatecatalog_v1beta1_generated_privatecatalogclient_searchproducts_paged_async]
