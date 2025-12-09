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

package com.google.cloud.cloudsecuritycompliance.v1.samples;

// [START cloudsecuritycompliance_v1_generated_Deployment_DeleteFrameworkDeployment_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.cloudsecuritycompliance.v1.DeleteFrameworkDeploymentRequest;
import com.google.cloud.cloudsecuritycompliance.v1.DeploymentClient;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkDeploymentName;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
import com.google.protobuf.Empty;

public class AsyncDeleteFrameworkDeploymentLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteFrameworkDeploymentLRO();
  }

  public static void asyncDeleteFrameworkDeploymentLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeploymentClient deploymentClient = DeploymentClient.create()) {
      DeleteFrameworkDeploymentRequest request =
          DeleteFrameworkDeploymentRequest.newBuilder()
              .setName(
                  FrameworkDeploymentName.of(
                          "[ORGANIZATION]", "[LOCATION]", "[FRAMEWORK_DEPLOYMENT]")
                      .toString())
              .setEtag("etag3123477")
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          deploymentClient.deleteFrameworkDeploymentOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END cloudsecuritycompliance_v1_generated_Deployment_DeleteFrameworkDeployment_LRO_async]
