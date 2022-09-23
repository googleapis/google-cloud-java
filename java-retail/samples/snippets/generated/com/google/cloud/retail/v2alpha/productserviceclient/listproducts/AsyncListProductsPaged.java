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

// [START retail_v2alpha_generated_productserviceclient_listproducts_paged_async]
import com.google.cloud.retail.v2alpha.BranchName;
import com.google.cloud.retail.v2alpha.ListProductsRequest;
import com.google.cloud.retail.v2alpha.ListProductsResponse;
import com.google.cloud.retail.v2alpha.Product;
import com.google.cloud.retail.v2alpha.ProductServiceClient;
import com.google.common.base.Strings;
import com.google.protobuf.FieldMask;

public class AsyncListProductsPaged {

  public static void main(String[] args) throws Exception {
    asyncListProductsPaged();
  }

  public static void asyncListProductsPaged() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
      ListProductsRequest request =
          ListProductsRequest.newBuilder()
              .setParent(
                  BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setReadMask(FieldMask.newBuilder().build())
              .setRequireTotalSize(true)
              .build();
      while (true) {
        ListProductsResponse response = productServiceClient.listProductsCallable().call(request);
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
// [END retail_v2alpha_generated_productserviceclient_listproducts_paged_async]
