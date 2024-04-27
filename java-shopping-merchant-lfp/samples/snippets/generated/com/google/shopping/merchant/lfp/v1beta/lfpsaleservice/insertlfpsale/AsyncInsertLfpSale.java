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

package com.google.shopping.merchant.lfp.v1beta.samples;

// [START merchantapi_v1beta_generated_LfpSaleService_InsertLfpSale_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.lfp.v1beta.InsertLfpSaleRequest;
import com.google.shopping.merchant.lfp.v1beta.LfpSale;
import com.google.shopping.merchant.lfp.v1beta.LfpSaleServiceClient;

public class AsyncInsertLfpSale {

  public static void main(String[] args) throws Exception {
    asyncInsertLfpSale();
  }

  public static void asyncInsertLfpSale() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create()) {
      InsertLfpSaleRequest request =
          InsertLfpSaleRequest.newBuilder()
              .setParent("parent-995424086")
              .setLfpSale(LfpSale.newBuilder().build())
              .build();
      ApiFuture<LfpSale> future = lfpSaleServiceClient.insertLfpSaleCallable().futureCall(request);
      // Do something.
      LfpSale response = future.get();
    }
  }
}
// [END merchantapi_v1beta_generated_LfpSaleService_InsertLfpSale_async]
