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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_AdBreakService_GetAdBreak_async]
import com.google.ads.admanager.v1.AdBreak;
import com.google.ads.admanager.v1.AdBreakName;
import com.google.ads.admanager.v1.AdBreakServiceClient;
import com.google.ads.admanager.v1.GetAdBreakRequest;
import com.google.api.core.ApiFuture;

public class AsyncGetAdBreak {

  public static void main(String[] args) throws Exception {
    asyncGetAdBreak();
  }

  public static void asyncGetAdBreak() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdBreakServiceClient adBreakServiceClient = AdBreakServiceClient.create()) {
      GetAdBreakRequest request =
          GetAdBreakRequest.newBuilder()
              .setName(AdBreakName.of("[NETWORK_CODE]", "[ASSET_KEY]", "[AD_BREAK]").toString())
              .build();
      ApiFuture<AdBreak> future = adBreakServiceClient.getAdBreakCallable().futureCall(request);
      // Do something.
      AdBreak response = future.get();
    }
  }
}
// [END admanager_v1_generated_AdBreakService_GetAdBreak_async]
