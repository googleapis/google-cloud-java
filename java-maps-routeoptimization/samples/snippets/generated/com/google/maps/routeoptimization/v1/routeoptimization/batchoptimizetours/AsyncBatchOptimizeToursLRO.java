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

package com.google.maps.routeoptimization.v1.samples;

// [START routeoptimization_v1_generated_RouteOptimization_BatchOptimizeTours_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursMetadata;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursResponse;
import com.google.maps.routeoptimization.v1.RouteOptimizationClient;
import java.util.ArrayList;

public class AsyncBatchOptimizeToursLRO {

  public static void main(String[] args) throws Exception {
    asyncBatchOptimizeToursLRO();
  }

  public static void asyncBatchOptimizeToursLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RouteOptimizationClient routeOptimizationClient = RouteOptimizationClient.create()) {
      BatchOptimizeToursRequest request =
          BatchOptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
              .build();
      OperationFuture<BatchOptimizeToursResponse, BatchOptimizeToursMetadata> future =
          routeOptimizationClient.batchOptimizeToursOperationCallable().futureCall(request);
      // Do something.
      BatchOptimizeToursResponse response = future.get();
    }
  }
}
// [END routeoptimization_v1_generated_RouteOptimization_BatchOptimizeTours_LRO_async]
