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

package com.google.cloud.vision.v1p4beta1.samples;

// [START vision_v1p4beta1_generated_ProductSearch_CreateProductSet_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vision.v1p4beta1.CreateProductSetRequest;
import com.google.cloud.vision.v1p4beta1.LocationName;
import com.google.cloud.vision.v1p4beta1.ProductSearchClient;
import com.google.cloud.vision.v1p4beta1.ProductSet;

public class AsyncCreateProductSet {

  public static void main(String[] args) throws Exception {
    asyncCreateProductSet();
  }

  public static void asyncCreateProductSet() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      CreateProductSetRequest request =
          CreateProductSetRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setProductSet(ProductSet.newBuilder().build())
              .setProductSetId("productSetId1003042158")
              .build();
      ApiFuture<ProductSet> future =
          productSearchClient.createProductSetCallable().futureCall(request);
      // Do something.
      ProductSet response = future.get();
    }
  }
}
// [END vision_v1p4beta1_generated_ProductSearch_CreateProductSet_async]
