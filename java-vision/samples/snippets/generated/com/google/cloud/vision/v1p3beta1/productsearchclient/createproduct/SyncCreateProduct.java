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

package com.google.cloud.vision.v1p3beta1.samples;

// [START vision_v1p3beta1_generated_productsearchclient_createproduct_sync]
import com.google.cloud.vision.v1p3beta1.CreateProductRequest;
import com.google.cloud.vision.v1p3beta1.LocationName;
import com.google.cloud.vision.v1p3beta1.Product;
import com.google.cloud.vision.v1p3beta1.ProductSearchClient;

public class SyncCreateProduct {

  public static void main(String[] args) throws Exception {
    syncCreateProduct();
  }

  public static void syncCreateProduct() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ProductSearchClient productSearchClient = ProductSearchClient.create()) {
      CreateProductRequest request =
          CreateProductRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setProduct(Product.newBuilder().build())
              .setProductId("productId-1051830678")
              .build();
      Product response = productSearchClient.createProduct(request);
    }
  }
}
// [END vision_v1p3beta1_generated_productsearchclient_createproduct_sync]
