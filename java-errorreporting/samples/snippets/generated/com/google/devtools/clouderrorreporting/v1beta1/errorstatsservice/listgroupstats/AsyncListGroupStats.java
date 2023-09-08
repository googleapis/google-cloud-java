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

package com.google.devtools.clouderrorreporting.v1beta1.samples;

// [START clouderrorreporting_v1beta1_generated_ErrorStatsService_ListGroupStats_async]
import com.google.api.core.ApiFuture;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupOrder;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorStatsServiceClient;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.QueryTimeRange;
import com.google.devtools.clouderrorreporting.v1beta1.ServiceContextFilter;
import com.google.devtools.clouderrorreporting.v1beta1.TimedCountAlignment;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;

public class AsyncListGroupStats {

  public static void main(String[] args) throws Exception {
    asyncListGroupStats();
  }

  public static void asyncListGroupStats() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
      ListGroupStatsRequest request =
          ListGroupStatsRequest.newBuilder()
              .setProjectName(ProjectName.of("[PROJECT]").toString())
              .addAllGroupId(new ArrayList<String>())
              .setServiceFilter(ServiceContextFilter.newBuilder().build())
              .setTimeRange(QueryTimeRange.newBuilder().build())
              .setTimedCountDuration(Duration.newBuilder().build())
              .setAlignment(TimedCountAlignment.forNumber(0))
              .setAlignmentTime(Timestamp.newBuilder().build())
              .setOrder(ErrorGroupOrder.forNumber(0))
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<ErrorGroupStats> future =
          errorStatsServiceClient.listGroupStatsPagedCallable().futureCall(request);
      // Do something.
      for (ErrorGroupStats element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END clouderrorreporting_v1beta1_generated_ErrorStatsService_ListGroupStats_async]
