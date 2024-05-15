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

package com.google.cloud.visionai.v1.samples;

// [START visionai_v1_generated_StreamsService_CreateSeries_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.visionai.v1.ClusterName;
import com.google.cloud.visionai.v1.CreateSeriesRequest;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Series;
import com.google.cloud.visionai.v1.StreamsServiceClient;

public class AsyncCreateSeriesLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateSeriesLRO();
  }

  public static void asyncCreateSeriesLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StreamsServiceClient streamsServiceClient = StreamsServiceClient.create()) {
      CreateSeriesRequest request =
          CreateSeriesRequest.newBuilder()
              .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setSeriesId("seriesId1367098866")
              .setSeries(Series.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Series, OperationMetadata> future =
          streamsServiceClient.createSeriesOperationCallable().futureCall(request);
      // Do something.
      Series response = future.get();
    }
  }
}
// [END visionai_v1_generated_StreamsService_CreateSeries_LRO_async]
