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

package com.google.cloud.apihub.v1.samples;

// [START apihub_v1_generated_Provisioning_CreateApiHubInstance_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.apihub.v1.ApiHubInstance;
import com.google.cloud.apihub.v1.CreateApiHubInstanceRequest;
import com.google.cloud.apihub.v1.LocationName;
import com.google.cloud.apihub.v1.OperationMetadata;
import com.google.cloud.apihub.v1.ProvisioningClient;

public class AsyncCreateApiHubInstanceLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateApiHubInstanceLRO();
  }

  public static void asyncCreateApiHubInstanceLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProvisioningClient provisioningClient = ProvisioningClient.create()) {
      CreateApiHubInstanceRequest request =
          CreateApiHubInstanceRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setApiHubInstanceId("apiHubInstanceId-1318600853")
              .setApiHubInstance(ApiHubInstance.newBuilder().build())
              .build();
      OperationFuture<ApiHubInstance, OperationMetadata> future =
          provisioningClient.createApiHubInstanceOperationCallable().futureCall(request);
      // Do something.
      ApiHubInstance response = future.get();
    }
  }
}
// [END apihub_v1_generated_Provisioning_CreateApiHubInstance_LRO_async]
