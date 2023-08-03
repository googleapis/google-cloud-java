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

package com.google.analytics.data.v1alpha.samples;

// [START analyticsdata_v1alpha_generated_AlphaAnalyticsData_CreateAudienceList_LRO_async]
import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1alpha.AudienceList;
import com.google.analytics.data.v1alpha.AudienceListMetadata;
import com.google.analytics.data.v1alpha.CreateAudienceListRequest;
import com.google.analytics.data.v1alpha.PropertyName;
import com.google.api.gax.longrunning.OperationFuture;

public class AsyncCreateAudienceListLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateAudienceListLRO();
  }

  public static void asyncCreateAudienceListLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
      CreateAudienceListRequest request =
          CreateAudienceListRequest.newBuilder()
              .setParent(PropertyName.of("[PROPERTYID]").toString())
              .setAudienceList(AudienceList.newBuilder().build())
              .build();
      OperationFuture<AudienceList, AudienceListMetadata> future =
          alphaAnalyticsDataClient.createAudienceListOperationCallable().futureCall(request);
      // Do something.
      AudienceList response = future.get();
    }
  }
}
// [END analyticsdata_v1alpha_generated_AlphaAnalyticsData_CreateAudienceList_LRO_async]
