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

package com.google.cloud.aiplatform.v1beta1.samples;

// [START aiplatform_v1beta1_generated_ModelMonitoringService_SearchModelMonitoringAlerts_Paged_async]
import com.google.cloud.aiplatform.v1beta1.ModelMonitorName;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringAlert;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse;
import com.google.common.base.Strings;
import com.google.type.Interval;

public class AsyncSearchModelMonitoringAlertsPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchModelMonitoringAlertsPaged();
  }

  public static void asyncSearchModelMonitoringAlertsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ModelMonitoringServiceClient modelMonitoringServiceClient =
        ModelMonitoringServiceClient.create()) {
      SearchModelMonitoringAlertsRequest request =
          SearchModelMonitoringAlertsRequest.newBuilder()
              .setModelMonitor(
                  ModelMonitorName.of("[PROJECT]", "[LOCATION]", "[MODEL_MONITOR]").toString())
              .setModelMonitoringJob("modelMonitoringJob1196104108")
              .setAlertTimeInterval(Interval.newBuilder().build())
              .setStatsName("statsName-2073146422")
              .setObjectiveType("objectiveType1316845587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        SearchModelMonitoringAlertsResponse response =
            modelMonitoringServiceClient.searchModelMonitoringAlertsCallable().call(request);
        for (ModelMonitoringAlert element : response.getModelMonitoringAlertsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END aiplatform_v1beta1_generated_ModelMonitoringService_SearchModelMonitoringAlerts_Paged_async]
