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

package com.google.cloud.advisorynotifications.v1.samples;

// [START advisorynotifications_v1_generated_AdvisoryNotificationsService_GetSettings_sync]
import com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient;
import com.google.cloud.advisorynotifications.v1.GetSettingsRequest;
import com.google.cloud.advisorynotifications.v1.Settings;
import com.google.cloud.advisorynotifications.v1.SettingsName;

public class SyncGetSettings {

  public static void main(String[] args) throws Exception {
    syncGetSettings();
  }

  public static void syncGetSettings() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AdvisoryNotificationsServiceClient advisoryNotificationsServiceClient =
        AdvisoryNotificationsServiceClient.create()) {
      GetSettingsRequest request =
          GetSettingsRequest.newBuilder()
              .setName(
                  SettingsName.ofOrganizationLocationName("[ORGANIZATION]", "[LOCATION]")
                      .toString())
              .build();
      Settings response = advisoryNotificationsServiceClient.getSettings(request);
    }
  }
}
// [END advisorynotifications_v1_generated_AdvisoryNotificationsService_GetSettings_sync]
