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

package com.google.cloud.networkservices.v1.samples;

// [START networkservices_v1_generated_NetworkServices_CreateTcpRoute_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.networkservices.v1.CreateTcpRouteRequest;
import com.google.cloud.networkservices.v1.LocationName;
import com.google.cloud.networkservices.v1.NetworkServicesClient;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.TcpRoute;

public class AsyncCreateTcpRouteLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateTcpRouteLRO();
  }

  public static void asyncCreateTcpRouteLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
      CreateTcpRouteRequest request =
          CreateTcpRouteRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setTcpRouteId("tcpRouteId806467107")
              .setTcpRoute(TcpRoute.newBuilder().build())
              .build();
      OperationFuture<TcpRoute, OperationMetadata> future =
          networkServicesClient.createTcpRouteOperationCallable().futureCall(request);
      // Do something.
      TcpRoute response = future.get();
    }
  }
}
// [END networkservices_v1_generated_NetworkServices_CreateTcpRoute_LRO_async]
