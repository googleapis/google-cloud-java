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

package com.google.cloud.deploy.v1.samples;

// [START deploy_v1_generated_clouddeployclient_createrollout_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.deploy.v1.CloudDeployClient;
import com.google.cloud.deploy.v1.CreateRolloutRequest;
import com.google.cloud.deploy.v1.OperationMetadata;
import com.google.cloud.deploy.v1.ReleaseName;
import com.google.cloud.deploy.v1.Rollout;

public class AsyncCreateRolloutLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateRolloutLRO();
  }

  public static void asyncCreateRolloutLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
      CreateRolloutRequest request =
          CreateRolloutRequest.newBuilder()
              .setParent(
                  ReleaseName.of("[PROJECT]", "[LOCATION]", "[DELIVERY_PIPELINE]", "[RELEASE]")
                      .toString())
              .setRolloutId("rolloutId551248556")
              .setRollout(Rollout.newBuilder().build())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .build();
      OperationFuture<Rollout, OperationMetadata> future =
          cloudDeployClient.createRolloutOperationCallable().futureCall(request);
      // Do something.
      Rollout response = future.get();
    }
  }
}
// [END deploy_v1_generated_clouddeployclient_createrollout_lro_async]
