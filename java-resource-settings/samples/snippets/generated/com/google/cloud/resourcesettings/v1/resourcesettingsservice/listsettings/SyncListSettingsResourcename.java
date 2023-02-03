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

// [START resourcesettings_v1_generated_ResourceSettingsService_ListSettings_Resourcename_sync]
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient;
import com.google.cloud.resourcesettings.v1.Setting;
import java.util.HashMap;
import java.util.Map;

public class SyncListSettingsResourcename {

  public static void main(String[] args) throws Exception {
    syncListSettingsResourcename();
  }

  public static void syncListSettingsResourcename() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ResourceSettingsServiceClient resourceSettingsServiceClient =
        ResourceSettingsServiceClient.create()) {
      ResourceName parent =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("parent", "organizations/organization-8287");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "organizations/organization-8287";
            }
          };
      for (Setting element : resourceSettingsServiceClient.listSettings(parent).iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END resourcesettings_v1_generated_ResourceSettingsService_ListSettings_Resourcename_sync]
