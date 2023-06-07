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

package com.google.cloud.edgecontainer.v1.samples;

// [START edgecontainer_v1_generated_EdgeContainer_CreateVpnConnection_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.EdgeContainerClient;
import com.google.cloud.edgecontainer.v1.LocationName;
import com.google.cloud.edgecontainer.v1.OperationMetadata;
import com.google.cloud.edgecontainer.v1.VpnConnection;

public class AsyncCreateVpnConnectionLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateVpnConnectionLRO();
  }

  public static void asyncCreateVpnConnectionLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (EdgeContainerClient edgeContainerClient = EdgeContainerClient.create()) {
      CreateVpnConnectionRequest request =
          CreateVpnConnectionRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setVpnConnectionId("vpnConnectionId887330733")
              .setVpnConnection(VpnConnection.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<VpnConnection, OperationMetadata> future =
          edgeContainerClient.createVpnConnectionOperationCallable().futureCall(request);
      // Do something.
      VpnConnection response = future.get();
    }
  }
}
// [END edgecontainer_v1_generated_EdgeContainer_CreateVpnConnection_LRO_async]
