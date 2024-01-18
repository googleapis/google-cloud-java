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

package com.google.cloud.edgenetwork.v1.samples;

// [START edgenetwork_v1_generated_EdgeNetwork_UpdateSubnet_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.edgenetwork.v1.EdgeNetworkClient;
import com.google.cloud.edgenetwork.v1.OperationMetadata;
import com.google.cloud.edgenetwork.v1.Subnet;
import com.google.cloud.edgenetwork.v1.UpdateSubnetRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateSubnetLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateSubnetLRO();
  }

  public static void asyncUpdateSubnetLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EdgeNetworkClient edgeNetworkClient = EdgeNetworkClient.create()) {
      UpdateSubnetRequest request =
          UpdateSubnetRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setSubnet(Subnet.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Subnet, OperationMetadata> future =
          edgeNetworkClient.updateSubnetOperationCallable().futureCall(request);
      // Do something.
      Subnet response = future.get();
    }
  }
}
// [END edgenetwork_v1_generated_EdgeNetwork_UpdateSubnet_LRO_async]
