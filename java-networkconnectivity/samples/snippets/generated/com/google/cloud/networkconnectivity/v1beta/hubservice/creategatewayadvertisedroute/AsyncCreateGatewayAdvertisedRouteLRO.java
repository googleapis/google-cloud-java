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

// [START networkconnectivity_v1beta_generated_HubService_CreateGatewayAdvertisedRoute_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest;
import com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute;
import com.google.cloud.networkconnectivity.v1beta.HubServiceClient;
import com.google.cloud.networkconnectivity.v1beta.OperationMetadata;
import com.google.cloud.networkconnectivity.v1beta.SpokeName;

public class AsyncCreateGatewayAdvertisedRouteLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateGatewayAdvertisedRouteLRO();
  }

  public static void asyncCreateGatewayAdvertisedRouteLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      CreateGatewayAdvertisedRouteRequest request =
          CreateGatewayAdvertisedRouteRequest.newBuilder()
              .setParent(SpokeName.of("[PROJECT]", "[LOCATION]", "[SPOKE]").toString())
              .setGatewayAdvertisedRouteId("gatewayAdvertisedRouteId1531070339")
              .setGatewayAdvertisedRoute(GatewayAdvertisedRoute.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<GatewayAdvertisedRoute, OperationMetadata> future =
          hubServiceClient.createGatewayAdvertisedRouteOperationCallable().futureCall(request);
      // Do something.
      GatewayAdvertisedRoute response = future.get();
    }
  }
}
// [END networkconnectivity_v1beta_generated_HubService_CreateGatewayAdvertisedRoute_LRO_async]
