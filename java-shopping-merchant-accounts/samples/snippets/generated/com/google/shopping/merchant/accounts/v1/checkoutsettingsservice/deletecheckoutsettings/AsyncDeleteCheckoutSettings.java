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

package com.google.shopping.merchant.accounts.v1.samples;

// [START merchantapi_v1_generated_CheckoutSettingsService_DeleteCheckoutSettings_async]
import com.google.api.core.ApiFuture;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.CheckoutSettingsName;
import com.google.shopping.merchant.accounts.v1.CheckoutSettingsServiceClient;
import com.google.shopping.merchant.accounts.v1.DeleteCheckoutSettingsRequest;

public class AsyncDeleteCheckoutSettings {

  public static void main(String[] args) throws Exception {
    asyncDeleteCheckoutSettings();
  }

  public static void asyncDeleteCheckoutSettings() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CheckoutSettingsServiceClient checkoutSettingsServiceClient =
        CheckoutSettingsServiceClient.create()) {
      DeleteCheckoutSettingsRequest request =
          DeleteCheckoutSettingsRequest.newBuilder()
              .setName(CheckoutSettingsName.of("[ACCOUNT]", "[PROGRAM]").toString())
              .build();
      ApiFuture<Empty> future =
          checkoutSettingsServiceClient.deleteCheckoutSettingsCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END merchantapi_v1_generated_CheckoutSettingsService_DeleteCheckoutSettings_async]
