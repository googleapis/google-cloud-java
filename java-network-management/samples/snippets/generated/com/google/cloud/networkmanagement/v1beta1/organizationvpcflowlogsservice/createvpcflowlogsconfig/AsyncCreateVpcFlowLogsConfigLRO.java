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

package com.google.cloud.networkmanagement.v1beta1.samples;

// [START networkmanagement_v1beta1_generated_OrganizationVpcFlowLogsService_CreateVpcFlowLogsConfig_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.LocationName;
import com.google.cloud.networkmanagement.v1beta1.OperationMetadata;
import com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient;
import com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig;
import com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfigName;

public class AsyncCreateVpcFlowLogsConfigLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateVpcFlowLogsConfigLRO();
  }

  public static void asyncCreateVpcFlowLogsConfigLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OrganizationVpcFlowLogsServiceClient organizationVpcFlowLogsServiceClient =
        OrganizationVpcFlowLogsServiceClient.create()) {
      CreateVpcFlowLogsConfigRequest request =
          CreateVpcFlowLogsConfigRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setVpcFlowLogsConfigId(
                  VpcFlowLogsConfigName.ofProjectLocationVpcFlowLogsConfigName(
                          "[PROJECT]", "[LOCATION]", "[VPC_FLOW_LOGS_CONFIG]")
                      .toString())
              .setVpcFlowLogsConfig(VpcFlowLogsConfig.newBuilder().build())
              .build();
      OperationFuture<VpcFlowLogsConfig, OperationMetadata> future =
          organizationVpcFlowLogsServiceClient
              .createVpcFlowLogsConfigOperationCallable()
              .futureCall(request);
      // Do something.
      VpcFlowLogsConfig response = future.get();
    }
  }
}
// [END networkmanagement_v1beta1_generated_OrganizationVpcFlowLogsService_CreateVpcFlowLogsConfig_LRO_async]
