/*
 * Copyright 2025 Google LLC
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

package com.google.maps.routeoptimization.v1.samples;

// [START routeoptimization_v1_generated_RouteOptimization_OptimizeToursLongRunning_sync]
import com.google.maps.routeoptimization.v1.InjectedSolutionConstraint;
import com.google.maps.routeoptimization.v1.OptimizeToursRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursResponse;
import com.google.maps.routeoptimization.v1.RouteOptimizationClient;
import com.google.maps.routeoptimization.v1.ShipmentModel;
import com.google.maps.routeoptimization.v1.ShipmentRoute;
import com.google.protobuf.Duration;
import java.util.ArrayList;

public class SyncOptimizeToursLongRunning {

  public static void main(String[] args) throws Exception {
    syncOptimizeToursLongRunning();
  }

  public static void syncOptimizeToursLongRunning() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
      OptimizeToursRequest request =
          OptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
              .setTimeout(Duration.newBuilder().build())
              .setModel(ShipmentModel.newBuilder().build())
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
              .setMaxValidationErrors(-1367418922)
              .setLabel("label102727412")
              .build();
      OptimizeToursResponse response =
          routeOptimizationClient.optimizeToursLongRunningAsync(request).get();
    }
  }
}
// [END routeoptimization_v1_generated_RouteOptimization_OptimizeToursLongRunning_sync]
