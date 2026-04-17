/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.config.v1.samples;

// [START config_v1_generated_Config_GetDeploymentGroupRevision_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.config.v1.ConfigClient;
import com.google.cloud.config.v1.DeploymentGroupRevision;
import com.google.cloud.config.v1.DeploymentGroupRevisionName;
import com.google.cloud.config.v1.GetDeploymentGroupRevisionRequest;

public class AsyncGetDeploymentGroupRevision {

  public static void main(String[] args) throws Exception {
    asyncGetDeploymentGroupRevision();
  }

  public static void asyncGetDeploymentGroupRevision() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfigClient configClient = ConfigClient.create()) {
      GetDeploymentGroupRevisionRequest request =
          GetDeploymentGroupRevisionRequest.newBuilder()
              .setName(
                  DeploymentGroupRevisionName.of(
                          "[PROJECT]", "[LOCATION]", "[DEPLOYMENT_GROUP]", "[REVISION]")
                      .toString())
              .build();
      ApiFuture<DeploymentGroupRevision> future =
          configClient.getDeploymentGroupRevisionCallable().futureCall(request);
      // Do something.
      DeploymentGroupRevision response = future.get();
    }
  }
}
// [END config_v1_generated_Config_GetDeploymentGroupRevision_async]
