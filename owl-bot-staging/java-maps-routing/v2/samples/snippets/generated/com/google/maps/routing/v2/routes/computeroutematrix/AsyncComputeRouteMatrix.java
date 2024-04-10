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

package com.google.maps.routing.v2.samples;

// [START routes_v2_generated_Routes_ComputeRouteMatrix_async]
import com.google.api.gax.rpc.ServerStream;
import com.google.maps.routing.v2.ComputeRouteMatrixRequest;
import com.google.maps.routing.v2.RouteMatrixDestination;
import com.google.maps.routing.v2.RouteMatrixElement;
import com.google.maps.routing.v2.RouteMatrixOrigin;
import com.google.maps.routing.v2.RouteTravelMode;
import com.google.maps.routing.v2.RoutesClient;
import com.google.maps.routing.v2.RoutingPreference;
import com.google.maps.routing.v2.TrafficModel;
import com.google.maps.routing.v2.TransitPreferences;
import com.google.maps.routing.v2.Units;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncComputeRouteMatrix {

  public static void main(String[] args) throws Exception {
    asyncComputeRouteMatrix();
  }

  public static void asyncComputeRouteMatrix() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RoutesClient routesClient = RoutesClient.create()) {
      ComputeRouteMatrixRequest request =
          ComputeRouteMatrixRequest.newBuilder()
              .addAllOrigins(new ArrayList<RouteMatrixOrigin>())
              .addAllDestinations(new ArrayList<RouteMatrixDestination>())
              .setTravelMode(RouteTravelMode.forNumber(0))
              .setRoutingPreference(RoutingPreference.forNumber(0))
              .setDepartureTime(Timestamp.newBuilder().build())
              .setArrivalTime(Timestamp.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .setUnits(Units.forNumber(0))
              .addAllExtraComputations(new ArrayList<ComputeRouteMatrixRequest.ExtraComputation>())
              .setTrafficModel(TrafficModel.forNumber(0))
              .setTransitPreferences(TransitPreferences.newBuilder().build())
              .build();
      ServerStream<RouteMatrixElement> stream =
          routesClient.computeRouteMatrixCallable().call(request);
      for (RouteMatrixElement response : stream) {
        // Do something when a response is received.
      }
    }
  }
}
// [END routes_v2_generated_Routes_ComputeRouteMatrix_async]
