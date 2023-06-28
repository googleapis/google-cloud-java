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

package com.google.maps.routing.v2.samples;

// [START routes_v2_generated_Routes_ComputeRoutes_async]
import com.google.api.core.ApiFuture;
import com.google.maps.routing.v2.ComputeRoutesRequest;
import com.google.maps.routing.v2.ComputeRoutesResponse;
import com.google.maps.routing.v2.PolylineEncoding;
import com.google.maps.routing.v2.PolylineQuality;
import com.google.maps.routing.v2.RouteModifiers;
import com.google.maps.routing.v2.RouteTravelMode;
import com.google.maps.routing.v2.RoutesClient;
import com.google.maps.routing.v2.RoutingPreference;
import com.google.maps.routing.v2.TrafficModel;
import com.google.maps.routing.v2.TransitPreferences;
import com.google.maps.routing.v2.Units;
import com.google.maps.routing.v2.Waypoint;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncComputeRoutes {

  public static void main(String[] args) throws Exception {
    asyncComputeRoutes();
  }

  public static void asyncComputeRoutes() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RoutesClient routesClient = RoutesClient.create()) {
      ComputeRoutesRequest request =
          ComputeRoutesRequest.newBuilder()
              .setOrigin(Waypoint.newBuilder().build())
              .setDestination(Waypoint.newBuilder().build())
              .addAllIntermediates(new ArrayList<Waypoint>())
              .setTravelMode(RouteTravelMode.forNumber(0))
              .setRoutingPreference(RoutingPreference.forNumber(0))
              .setPolylineQuality(PolylineQuality.forNumber(0))
              .setPolylineEncoding(PolylineEncoding.forNumber(0))
              .setDepartureTime(Timestamp.newBuilder().build())
              .setArrivalTime(Timestamp.newBuilder().build())
              .setComputeAlternativeRoutes(true)
              .setRouteModifiers(RouteModifiers.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setRegionCode("regionCode-1991004415")
              .setUnits(Units.forNumber(0))
              .setOptimizeWaypointOrder(true)
              .addAllRequestedReferenceRoutes(new ArrayList<ComputeRoutesRequest.ReferenceRoute>())
              .addAllExtraComputations(new ArrayList<ComputeRoutesRequest.ExtraComputation>())
              .setTrafficModel(TrafficModel.forNumber(0))
              .setTransitPreferences(TransitPreferences.newBuilder().build())
              .build();
      ApiFuture<ComputeRoutesResponse> future =
          routesClient.computeRoutesCallable().futureCall(request);
      // Do something.
      ComputeRoutesResponse response = future.get();
    }
  }
}
// [END routes_v2_generated_Routes_ComputeRoutes_async]
