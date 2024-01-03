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

package com.google.analytics.data.v1beta.samples;

// [START analyticsdata_v1beta_generated_BetaAnalyticsData_QueryAudienceExport_async]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.QueryAudienceExportRequest;
import com.google.analytics.data.v1beta.QueryAudienceExportResponse;
import com.google.api.core.ApiFuture;

public class AsyncQueryAudienceExport {

  public static void main(String[] args) throws Exception {
    asyncQueryAudienceExport();
  }

  public static void asyncQueryAudienceExport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
      QueryAudienceExportRequest request =
          QueryAudienceExportRequest.newBuilder()
              .setName("name3373707")
              .setOffset(-1019779949)
              .setLimit(102976443)
              .build();
      ApiFuture<QueryAudienceExportResponse> future =
          betaAnalyticsDataClient.queryAudienceExportCallable().futureCall(request);
      // Do something.
      QueryAudienceExportResponse response = future.get();
    }
  }
}
// [END analyticsdata_v1beta_generated_BetaAnalyticsData_QueryAudienceExport_async]
