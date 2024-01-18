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

package com.google.cloud.beyondcorp.clientconnectorservices.v1.samples;

// [START beyondcorp_v1_generated_ClientConnectorServicesService_GetClientConnectorService_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorService;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServiceName;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.ClientConnectorServicesServiceClient;
import com.google.cloud.beyondcorp.clientconnectorservices.v1.GetClientConnectorServiceRequest;

public class AsyncGetClientConnectorService {

  public static void main(String[] args) throws Exception {
    asyncGetClientConnectorService();
  }

  public static void asyncGetClientConnectorService() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ClientConnectorServicesServiceClient clientConnectorServicesServiceClient =
        ClientConnectorServicesServiceClient.create()) {
      GetClientConnectorServiceRequest request =
          GetClientConnectorServiceRequest.newBuilder()
              .setName(
                  ClientConnectorServiceName.of(
                          "[PROJECT]", "[LOCATION]", "[CLIENT_CONNECTOR_SERVICE]")
                      .toString())
              .build();
      ApiFuture<ClientConnectorService> future =
          clientConnectorServicesServiceClient
              .getClientConnectorServiceCallable()
              .futureCall(request);
      // Do something.
      ClientConnectorService response = future.get();
    }
  }
}
// [END beyondcorp_v1_generated_ClientConnectorServicesService_GetClientConnectorService_async]
