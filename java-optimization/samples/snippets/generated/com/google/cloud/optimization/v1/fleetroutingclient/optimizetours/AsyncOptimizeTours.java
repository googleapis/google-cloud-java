/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.optimization.v1.samples;

// [START optimization_v1_generated_fleetroutingclient_optimizetours_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.cloud.optimization.v1.InjectedSolutionConstraint;
import com.google.cloud.optimization.v1.OptimizeToursRequest;
import com.google.cloud.optimization.v1.OptimizeToursResponse;
import com.google.cloud.optimization.v1.ShipmentModel;
import com.google.cloud.optimization.v1.ShipmentRoute;
import com.google.protobuf.Duration;
import java.util.ArrayList;

public class AsyncOptimizeTours {

  public static void main(String[] args) throws Exception {
    asyncOptimizeTours();
  }

  public static void asyncOptimizeTours() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
      OptimizeToursRequest request =
          OptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
              .setTimeout(Duration.newBuilder().build())
              .setModel(ShipmentModel.newBuilder().build())
              .setMaxValidationErrors(-1367418922)
              .addAllInjectedFirstSolutionRoutes(new ArrayList<ShipmentRoute>())
              .setInjectedSolutionConstraint(InjectedSolutionConstraint.newBuilder().build())
              .addAllRefreshDetailsRoutes(new ArrayList<ShipmentRoute>())
              .setInterpretInjectedSolutionsUsingLabels(true)
              .setConsiderRoadTraffic(true)
              .setPopulatePolylines(true)
              .setPopulateTransitionPolylines(true)
              .setAllowLargeDeadlineDespiteInterruptionRisk(true)
              .setUseGeodesicDistances(true)
              .setGeodesicMetersPerSecond(-2129658905)
              .setLabel("label102727412")
              .setPopulateTravelStepPolylines(true)
              .build();
      ApiFuture<OptimizeToursResponse> future =
          fleetRoutingClient.optimizeToursCallable().futureCall(request);
      // Do something.
      OptimizeToursResponse response = future.get();
    }
  }
}
// [END optimization_v1_generated_fleetroutingclient_optimizetours_async]
