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

// [START networkservices_v1_generated_NetworkServices_CreateGrpcRoute_StringGrpcrouteString_sync]
import com.google.cloud.networkservices.v1.GrpcRoute;
import com.google.cloud.networkservices.v1.LocationName;
import com.google.cloud.networkservices.v1.NetworkServicesClient;

public class SyncCreateGrpcRouteStringGrpcrouteString {

  public static void main(String[] args) throws Exception {
    syncCreateGrpcRouteStringGrpcrouteString();
  }

  public static void syncCreateGrpcRouteStringGrpcrouteString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
      String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
      GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
      String grpcRouteId = "grpcRouteId1888295750";
      GrpcRoute response =
          networkServicesClient.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
    }
  }
}
// [END networkservices_v1_generated_NetworkServices_CreateGrpcRoute_StringGrpcrouteString_sync]
