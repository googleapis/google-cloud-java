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

package com.google.cloud.monitoring.v3.samples;

// [START monitoring_v3_generated_MetricService_ListTimeSeries_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.Aggregation;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;

public class AsyncListTimeSeries {

  public static void main(String[] args) throws Exception {
    asyncListTimeSeries();
  }

  public static void asyncListTimeSeries() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      ListTimeSeriesRequest request =
          ListTimeSeriesRequest.newBuilder()
              .setName(ProjectName.of("[PROJECT]").toString())
              .setFilter("filter-1274492040")
              .setInterval(TimeInterval.newBuilder().build())
              .setAggregation(Aggregation.newBuilder().build())
              .setSecondaryAggregation(Aggregation.newBuilder().build())
              .setOrderBy("orderBy-1207110587")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<TimeSeries> future =
          metricServiceClient.listTimeSeriesPagedCallable().futureCall(request);
      // Do something.
      for (TimeSeries element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END monitoring_v3_generated_MetricService_ListTimeSeries_async]
