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

package com.google.cloud.config.v1.samples;

// [START config_v1_generated_Config_LockDeployment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.config.v1.ConfigClient;
import com.google.cloud.config.v1.DeploymentName;
import com.google.cloud.config.v1.LockDeploymentRequest;
import com.google.longrunning.Operation;

public class AsyncLockDeployment {

  public static void main(String[] args) throws Exception {
    asyncLockDeployment();
  }

  public static void asyncLockDeployment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfigClient configClient = ConfigClient.create()) {
      LockDeploymentRequest request =
          LockDeploymentRequest.newBuilder()
              .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
              .build();
      ApiFuture<Operation> future = configClient.lockDeploymentCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END config_v1_generated_Config_LockDeployment_async]
