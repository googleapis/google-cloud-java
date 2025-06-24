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

// [START developerconnect_v1_generated_InsightsConfigService_CreateInsightsConfig_sync]
import com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.InsightsConfig;
import com.google.cloud.developerconnect.v1.InsightsConfigServiceClient;
import com.google.cloud.developerconnect.v1.LocationName;

public class SyncCreateInsightsConfig {

  public static void main(String[] args) throws Exception {
    syncCreateInsightsConfig();
  }

  public static void syncCreateInsightsConfig() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (InsightsConfigServiceClient insightsConfigServiceClient =
        InsightsConfigServiceClient.create()) {
      CreateInsightsConfigRequest request =
          CreateInsightsConfigRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setInsightsConfigId("insightsConfigId774395128")
              .setInsightsConfig(InsightsConfig.newBuilder().build())
              .setValidateOnly(true)
              .build();
      InsightsConfig response =
          insightsConfigServiceClient.createInsightsConfigAsync(request).get();
    }
  }
}
// [END developerconnect_v1_generated_InsightsConfigService_CreateInsightsConfig_sync]
