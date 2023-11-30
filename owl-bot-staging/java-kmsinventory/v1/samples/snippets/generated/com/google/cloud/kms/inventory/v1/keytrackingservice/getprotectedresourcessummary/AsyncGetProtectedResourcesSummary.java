/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.kms.inventory.v1.samples;

// [START kmsinventory_v1_generated_KeyTrackingService_GetProtectedResourcesSummary_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest;
import com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient;
import com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary;
import com.google.cloud.kms.inventory.v1.ProtectedResourcesSummaryName;

public class AsyncGetProtectedResourcesSummary {

  public static void main(String[] args) throws Exception {
    asyncGetProtectedResourcesSummary();
  }

  public static void asyncGetProtectedResourcesSummary() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
      GetProtectedResourcesSummaryRequest request =
          GetProtectedResourcesSummaryRequest.newBuilder()
              .setName(
                  ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
                          "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .build();
      ApiFuture<ProtectedResourcesSummary> future =
          keyTrackingServiceClient.getProtectedResourcesSummaryCallable().futureCall(request);
      // Do something.
      ProtectedResourcesSummary response = future.get();
    }
  }
}
// [END kmsinventory_v1_generated_KeyTrackingService_GetProtectedResourcesSummary_async]
