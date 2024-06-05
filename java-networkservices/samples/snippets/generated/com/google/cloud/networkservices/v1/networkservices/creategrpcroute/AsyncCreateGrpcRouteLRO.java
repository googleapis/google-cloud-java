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

// [START networkservices_v1_generated_NetworkServices_CreateGrpcRoute_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.networkservices.v1.CreateGrpcRouteRequest;
import com.google.cloud.networkservices.v1.GrpcRoute;
import com.google.cloud.networkservices.v1.LocationName;
import com.google.cloud.networkservices.v1.NetworkServicesClient;
import com.google.cloud.networkservices.v1.OperationMetadata;

public class AsyncCreateGrpcRouteLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateGrpcRouteLRO();
  }

  public static void asyncCreateGrpcRouteLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
      CreateGrpcRouteRequest request =
          CreateGrpcRouteRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setGrpcRouteId("grpcRouteId1888295750")
              .setGrpcRoute(GrpcRoute.newBuilder().build())
              .build();
      OperationFuture<GrpcRoute, OperationMetadata> future =
          networkServicesClient.createGrpcRouteOperationCallable().futureCall(request);
      // Do something.
      GrpcRoute response = future.get();
    }
  }
}
// [END networkservices_v1_generated_NetworkServices_CreateGrpcRoute_LRO_async]
