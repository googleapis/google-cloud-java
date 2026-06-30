/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networkconnectivity.v1beta.samples;

// [START networkconnectivity_v1beta_generated_HubService_DeleteGatewayAdvertisedRoute_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRouteName;
import com.google.cloud.networkconnectivity.v1beta.HubServiceClient;
import com.google.longrunning.Operation;

public class AsyncDeleteGatewayAdvertisedRoute {

  public static void main(String[] args) throws Exception {
    asyncDeleteGatewayAdvertisedRoute();
  }

  public static void asyncDeleteGatewayAdvertisedRoute() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      DeleteGatewayAdvertisedRouteRequest request =
          DeleteGatewayAdvertisedRouteRequest.newBuilder()
              .setName(
                  GatewayAdvertisedRouteName.of(
                          "[PROJECT]", "[LOCATION]", "[SPOKE]", "[GATEWAY_ADVERTISED_ROUTE]")
                      .toString())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          hubServiceClient.deleteGatewayAdvertisedRouteCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END networkconnectivity_v1beta_generated_HubService_DeleteGatewayAdvertisedRoute_async]
