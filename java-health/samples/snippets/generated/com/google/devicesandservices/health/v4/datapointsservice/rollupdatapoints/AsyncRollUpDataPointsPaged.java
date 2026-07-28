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

// [START health_v4_generated_DataPointsService_RollUpDataPoints_Paged_async]
import com.google.common.base.Strings;
import com.google.devicesandservices.health.v4.DataPointsServiceClient;
import com.google.devicesandservices.health.v4.DataTypeName;
import com.google.devicesandservices.health.v4.RollUpDataPointsRequest;
import com.google.devicesandservices.health.v4.RollUpDataPointsResponse;
import com.google.devicesandservices.health.v4.RollupDataPoint;
import com.google.protobuf.Duration;
import com.google.type.Interval;

public class AsyncRollUpDataPointsPaged {

  public static void main(String[] args) throws Exception {
    asyncRollUpDataPointsPaged();
  }

  public static void asyncRollUpDataPointsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DataPointsServiceClient dataPointsServiceClient = DataPointsServiceClient.create()) {
      RollUpDataPointsRequest request =
          RollUpDataPointsRequest.newBuilder()
              .setParent(DataTypeName.of("[USER]", "[DATA_TYPE]").toString())
              .setRange(Interval.newBuilder().build())
              .setWindowSize(Duration.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setDataSourceFamily("dataSourceFamily586548265")
              .build();
      while (true) {
        RollUpDataPointsResponse response =
            dataPointsServiceClient.rollUpDataPointsCallable().call(request);
        for (RollupDataPoint element : response.getRollupDataPointsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END health_v4_generated_DataPointsService_RollUpDataPoints_Paged_async]
