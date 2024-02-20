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

package com.google.cloud.securitycentermanagement.v1.samples;

// [START securitycentermanagement_v1_generated_SecurityCenterManagement_GetEffectiveEventThreatDetectionCustomModule_sync]
import com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModuleName;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient;

public class SyncGetEffectiveEventThreatDetectionCustomModule {

  public static void main(String[] args) throws Exception {
    syncGetEffectiveEventThreatDetectionCustomModule();
  }

  public static void syncGetEffectiveEventThreatDetectionCustomModule() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecurityCenterManagementClient securityCenterManagementClient =
        SecurityCenterManagementClient.create()) {
      GetEffectiveEventThreatDetectionCustomModuleRequest request =
          GetEffectiveEventThreatDetectionCustomModuleRequest.newBuilder()
              .setName(
                  EffectiveEventThreatDetectionCustomModuleName
                      .ofProjectLocationEffectiveEventThreatDetectionCustomModuleName(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[EFFECTIVE_EVENT_THREAT_DETECTION_CUSTOM_MODULE]")
                      .toString())
              .build();
      EffectiveEventThreatDetectionCustomModule response =
          securityCenterManagementClient.getEffectiveEventThreatDetectionCustomModule(request);
    }
  }
}
// [END securitycentermanagement_v1_generated_SecurityCenterManagement_GetEffectiveEventThreatDetectionCustomModule_sync]
