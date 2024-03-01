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

package com.google.cloud.edgecontainer.v1.samples;

// [START edgecontainer_v1_generated_EdgeContainer_CreateVpnConnection_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.edgecontainer.v1.CreateVpnConnectionRequest;
import com.google.cloud.edgecontainer.v1.EdgeContainerClient;
import com.google.cloud.edgecontainer.v1.LocationName;
import com.google.cloud.edgecontainer.v1.VpnConnection;
import com.google.longrunning.Operation;

public class AsyncCreateVpnConnection {

  public static void main(String[] args) throws Exception {
    asyncCreateVpnConnection();
  }

  public static void asyncCreateVpnConnection() throws Exception {
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
      ApiFuture<Operation> future =
          edgeContainerClient.createVpnConnectionCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END edgecontainer_v1_generated_EdgeContainer_CreateVpnConnection_async]
