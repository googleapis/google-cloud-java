/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.resourcesettings.v1.samples;

// [START resourcesettings_v1_generated_resourcesettingsserviceclient_updatesetting_sync]
import com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient;
import com.google.cloud.resourcesettings.v1.Setting;
import com.google.cloud.resourcesettings.v1.UpdateSettingRequest;

public class SyncUpdateSetting {

  public static void main(String[] args) throws Exception {
    syncUpdateSetting();
  }

  public static void syncUpdateSetting() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ResourceSettingsServiceClient resourceSettingsServiceClient =
        ResourceSettingsServiceClient.create()) {
      UpdateSettingRequest request =
          UpdateSettingRequest.newBuilder().setSetting(Setting.newBuilder().build()).build();
      Setting response = resourceSettingsServiceClient.updateSetting(request);
    }
  }
}
// [END resourcesettings_v1_generated_resourcesettingsserviceclient_updatesetting_sync]
