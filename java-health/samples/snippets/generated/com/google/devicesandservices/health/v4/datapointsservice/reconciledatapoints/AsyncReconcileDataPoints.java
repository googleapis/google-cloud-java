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

package com.google.devicesandservices.health.v4.samples;

// [START health_v4_generated_DataPointsService_ReconcileDataPoints_async]
import com.google.api.core.ApiFuture;
import com.google.devicesandservices.health.v4.DataPointsServiceClient;
import com.google.devicesandservices.health.v4.ReconcileDataPointsRequest;
import com.google.devicesandservices.health.v4.ReconciledDataPoint;

public class AsyncReconcileDataPoints {

  public static void main(String[] args) throws Exception {
    asyncReconcileDataPoints();
  }

  public static void asyncReconcileDataPoints() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
      ReconcileDataPointsRequest request =
          ReconcileDataPointsRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setDataSourceFamily("dataSourceFamily586548265")
              .build();
      ApiFuture<ReconciledDataPoint> future =
          dataPointsServiceClient.reconcileDataPointsPagedCallable().futureCall(request);
      // Do something.
      for (ReconciledDataPoint element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END health_v4_generated_DataPointsService_ReconcileDataPoints_async]
