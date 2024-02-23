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

package com.google.cloud.beyondcorp.clientgateways.v1.samples;

// [START beyondcorp_v1_generated_ClientGatewaysService_DeleteClientGateway_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewayName;
import com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewayOperationMetadata;
import com.google.cloud.beyondcorp.clientgateways.v1.ClientGatewaysServiceClient;
import com.google.cloud.beyondcorp.clientgateways.v1.DeleteClientGatewayRequest;
import com.google.protobuf.Empty;

public class AsyncDeleteClientGatewayLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteClientGatewayLRO();
  }

  public static void asyncDeleteClientGatewayLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ClientGatewaysServiceClient clientGatewaysServiceClient =
        ClientGatewaysServiceClient.create()) {
      DeleteClientGatewayRequest request =
          DeleteClientGatewayRequest.newBuilder()
              .setName(
                  ClientGatewayName.of("[PROJECT]", "[LOCATION]", "[CLIENT_GATEWAY]").toString())
              .setRequestId("requestId693933066")
              .setValidateOnly(true)
              .build();
      OperationFuture<Empty, ClientGatewayOperationMetadata> future =
          clientGatewaysServiceClient.deleteClientGatewayOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END beyondcorp_v1_generated_ClientGatewaysService_DeleteClientGateway_LRO_async]
