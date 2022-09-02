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

// [START retail_v2alpha_generated_productserviceclient_getproduct_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.retail.v2alpha.GetProductRequest;
import com.google.cloud.retail.v2alpha.Product;
import com.google.cloud.retail.v2alpha.ProductName;
import com.google.cloud.retail.v2alpha.ProductServiceClient;

public class AsyncGetProduct {

  public static void main(String[] args) throws Exception {
    asyncGetProduct();
  }

  public static void asyncGetProduct() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ProductServiceClient productServiceClient = ProductServiceClient.create()) {
      GetProductRequest request =
          GetProductRequest.newBuilder()
              .setName(
                  ProductName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]", "[PRODUCT]")
                      .toString())
              .build();
      ApiFuture<Product> future = productServiceClient.getProductCallable().futureCall(request);
      // Do something.
      Product response = future.get();
    }
  }
}
// [END retail_v2alpha_generated_productserviceclient_getproduct_async]
