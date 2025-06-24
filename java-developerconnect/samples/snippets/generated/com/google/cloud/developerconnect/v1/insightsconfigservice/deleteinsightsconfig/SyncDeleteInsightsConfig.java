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

package com.google.cloud.developerconnect.v1.samples;

// [START developerconnect_v1_generated_InsightsConfigService_DeleteInsightsConfig_sync]
import com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.InsightsConfigName;
import com.google.cloud.developerconnect.v1.InsightsConfigServiceClient;
import com.google.protobuf.Empty;

public class SyncDeleteInsightsConfig {

  public static void main(String[] args) throws Exception {
    syncDeleteInsightsConfig();
  }

  public static void syncDeleteInsightsConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (InsightsConfigServiceClient insightsConfigServiceClient =
        InsightsConfigServiceClient.create()) {
      DeleteInsightsConfigRequest request =
          DeleteInsightsConfigRequest.newBuilder()
              .setName(
                  InsightsConfigName.of("[PROJECT]", "[LOCATION]", "[INSIGHTS_CONFIG]").toString())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .setEtag("etag3123477")
              .build();
      insightsConfigServiceClient.deleteInsightsConfigAsync(request).get();
    }
  }
}
// [END developerconnect_v1_generated_InsightsConfigService_DeleteInsightsConfig_sync]
