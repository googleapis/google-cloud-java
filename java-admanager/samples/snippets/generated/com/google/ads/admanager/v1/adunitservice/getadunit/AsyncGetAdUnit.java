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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_AdUnitService_GetAdUnit_async]
import com.google.ads.admanager.v1.AdUnit;
import com.google.ads.admanager.v1.AdUnitName;
import com.google.ads.admanager.v1.AdUnitServiceClient;
import com.google.ads.admanager.v1.GetAdUnitRequest;
import com.google.api.core.ApiFuture;

public class AsyncGetAdUnit {

  public static void main(String[] args) throws Exception {
    asyncGetAdUnit();
  }

  public static void asyncGetAdUnit() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdUnitServiceClient adUnitServiceClient = AdUnitServiceClient.create()) {
      GetAdUnitRequest request =
          GetAdUnitRequest.newBuilder()
              .setName(AdUnitName.of("[NETWORK_CODE]", "[AD_UNIT]").toString())
              .build();
      ApiFuture<AdUnit> future = adUnitServiceClient.getAdUnitCallable().futureCall(request);
      // Do something.
      AdUnit response = future.get();
    }
  }
}
// [END admanager_v1_generated_AdUnitService_GetAdUnit_async]
