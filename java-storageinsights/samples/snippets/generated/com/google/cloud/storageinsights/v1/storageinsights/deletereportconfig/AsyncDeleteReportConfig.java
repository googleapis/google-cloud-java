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

package com.google.cloud.storageinsights.v1.samples;

// [START storageinsights_v1_generated_StorageInsights_DeleteReportConfig_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.storageinsights.v1.DeleteReportConfigRequest;
import com.google.cloud.storageinsights.v1.ReportConfigName;
import com.google.cloud.storageinsights.v1.StorageInsightsClient;
import com.google.protobuf.Empty;

public class AsyncDeleteReportConfig {

  public static void main(String[] args) throws Exception {
    asyncDeleteReportConfig();
  }

  public static void asyncDeleteReportConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageInsightsClient storageInsightsClient = StorageInsightsClient.create()) {
      DeleteReportConfigRequest request =
          DeleteReportConfigRequest.newBuilder()
              .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
              .setForce(true)
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Empty> future =
          storageInsightsClient.deleteReportConfigCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END storageinsights_v1_generated_StorageInsights_DeleteReportConfig_async]
