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

package com.google.cloud.retail.v2alpha.samples;

// [START retail_v2alpha_generated_catalogserviceclient_listcatalogs_paged_async]
import com.google.cloud.retail.v2alpha.Catalog;
import com.google.cloud.retail.v2alpha.CatalogServiceClient;
import com.google.cloud.retail.v2alpha.ListCatalogsRequest;
import com.google.cloud.retail.v2alpha.ListCatalogsResponse;
import com.google.cloud.retail.v2alpha.LocationName;
import com.google.common.base.Strings;

public class AsyncListCatalogsPaged {

  public static void main(String[] args) throws Exception {
    asyncListCatalogsPaged();
  }

  public static void asyncListCatalogsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
      ListCatalogsRequest request =
          ListCatalogsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListCatalogsResponse response = catalogServiceClient.listCatalogsCallable().call(request);
        for (Catalog element : response.getCatalogsList()) {
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
// [END retail_v2alpha_generated_catalogserviceclient_listcatalogs_paged_async]
