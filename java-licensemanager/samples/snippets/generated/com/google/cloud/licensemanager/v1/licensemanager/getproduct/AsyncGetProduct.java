/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.licensemanager.v1.samples;

// [START licensemanager_v1_generated_LicenseManager_GetProduct_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.licensemanager.v1.GetProductRequest;
import com.google.cloud.licensemanager.v1.LicenseManagerClient;
import com.google.cloud.licensemanager.v1.Product;
import com.google.cloud.licensemanager.v1.ProductName;

public class AsyncGetProduct {

  public static void main(String[] args) throws Exception {
    asyncGetProduct();
  }

  public static void asyncGetProduct() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LicenseManagerClient licenseManagerClient = LicenseManagerClient.create()) {
      GetProductRequest request =
          GetProductRequest.newBuilder()
              .setName(ProductName.of("[PROJECT]", "[LOCATION]", "[PRODUCT]").toString())
              .build();
      ApiFuture<Product> future = licenseManagerClient.getProductCallable().futureCall(request);
      // Do something.
      Product response = future.get();
    }
  }
}
// [END licensemanager_v1_generated_LicenseManager_GetProduct_async]
