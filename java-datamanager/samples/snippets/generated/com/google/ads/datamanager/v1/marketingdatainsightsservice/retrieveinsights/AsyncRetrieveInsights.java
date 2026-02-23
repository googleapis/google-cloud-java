/*
 * Copyright 2026 Google LLC
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

package com.google.ads.datamanager.v1.samples;

// [START datamanager_v1_generated_MarketingDataInsightsService_RetrieveInsights_async]
import com.google.ads.datamanager.v1.Baseline;
import com.google.ads.datamanager.v1.MarketingDataInsightsServiceClient;
import com.google.ads.datamanager.v1.RetrieveInsightsRequest;
import com.google.ads.datamanager.v1.RetrieveInsightsResponse;
import com.google.api.core.ApiFuture;

public class AsyncRetrieveInsights {

  public static void main(String[] args) throws Exception {
    asyncRetrieveInsights();
  }

  public static void asyncRetrieveInsights() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MarketingDataInsightsServiceClient marketingDataInsightsServiceClient =
        MarketingDataInsightsServiceClient.create()) {
      RetrieveInsightsRequest request =
          RetrieveInsightsRequest.newBuilder()
              .setParent("parent-995424086")
              .setBaseline(Baseline.newBuilder().build())
              .setUserListId("userListId1381604868")
              .build();
      ApiFuture<RetrieveInsightsResponse> future =
          marketingDataInsightsServiceClient.retrieveInsightsCallable().futureCall(request);
      // Do something.
      RetrieveInsightsResponse response = future.get();
    }
  }
}
// [END datamanager_v1_generated_MarketingDataInsightsService_RetrieveInsights_async]
