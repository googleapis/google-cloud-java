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

package com.google.cloud.deploy.v1.samples;

// [START clouddeploy_v1_generated_CloudDeploy_GetAutomation_sync]
import com.google.cloud.deploy.v1.Automation;
import com.google.cloud.deploy.v1.AutomationName;
import com.google.cloud.deploy.v1.CloudDeployClient;
import com.google.cloud.deploy.v1.GetAutomationRequest;

public class SyncGetAutomation {

  public static void main(String[] args) throws Exception {
    syncGetAutomation();
  }

  public static void syncGetAutomation() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
      GetAutomationRequest request =
          GetAutomationRequest.newBuilder()
              .setName(
                  AutomationName.of(
                          "[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[AUTOMATION]")
                      .toString())
              .build();
      Automation response = cloudDeployClient.getAutomation(request);
    }
  }
}
// [END clouddeploy_v1_generated_CloudDeploy_GetAutomation_sync]
