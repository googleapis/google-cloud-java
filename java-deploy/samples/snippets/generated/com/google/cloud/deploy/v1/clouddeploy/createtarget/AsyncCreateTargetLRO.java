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

// [START clouddeploy_v1_generated_CloudDeploy_CreateTarget_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.deploy.v1.CloudDeployClient;
import com.google.cloud.deploy.v1.CreateTargetRequest;
import com.google.cloud.deploy.v1.LocationName;
import com.google.cloud.deploy.v1.OperationMetadata;
import com.google.cloud.deploy.v1.Target;

public class AsyncCreateTargetLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateTargetLRO();
  }

  public static void asyncCreateTargetLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CloudDeployClient cloudDeployClient = CloudDeployClient.create()) {
      CreateTargetRequest request =
          CreateTargetRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setTargetId("targetId-441951604")
              .setTarget(Target.newBuilder().build())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .build();
      OperationFuture<Target, OperationMetadata> future =
          cloudDeployClient.createTargetOperationCallable().futureCall(request);
      // Do something.
      Target response = future.get();
    }
  }
}
// [END clouddeploy_v1_generated_CloudDeploy_CreateTarget_LRO_async]
