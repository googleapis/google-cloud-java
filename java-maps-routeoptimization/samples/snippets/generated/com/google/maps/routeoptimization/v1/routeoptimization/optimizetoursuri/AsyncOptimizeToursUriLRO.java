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

package com.google.maps.routeoptimization.v1.samples;

// [START routeoptimization_v1_generated_RouteOptimization_OptimizeToursUri_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.maps.routeoptimization.v1.OptimizeToursUriMetadata;
import com.google.maps.routeoptimization.v1.OptimizeToursUriRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursUriResponse;
import com.google.maps.routeoptimization.v1.RouteOptimizationClient;
import com.google.maps.routeoptimization.v1.Uri;

public class AsyncOptimizeToursUriLRO {

  public static void main(String[] args) throws Exception {
    asyncOptimizeToursUriLRO();
  }

  public static void asyncOptimizeToursUriLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
      OptimizeToursUriRequest request =
          OptimizeToursUriRequest.newBuilder()
              .setParent("parent-995424086")
              .setInput(Uri.newBuilder().build())
              .setOutput(Uri.newBuilder().build())
              .build();
      OperationFuture<OptimizeToursUriResponse, OptimizeToursUriMetadata> future =
          routeOptimizationClient.optimizeToursUriOperationCallable().futureCall(request);
      // Do something.
      OptimizeToursUriResponse response = future.get();
    }
  }
}
// [END routeoptimization_v1_generated_RouteOptimization_OptimizeToursUri_LRO_async]
