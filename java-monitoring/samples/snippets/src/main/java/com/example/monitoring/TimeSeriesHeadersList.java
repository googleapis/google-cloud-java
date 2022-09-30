/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.monitoring;

// [START monitoring_read_time_series_fields]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.ListTimeSeriesRequest;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.protobuf.util.Timestamps;
import java.io.IOException;

// Sample to list time series with header
public class TimeSeriesHeadersList {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String filter = "your-metric-type-filter";
    listTimeSeriesHeaders(projectId, filter);
  }

  public static void listTimeSeriesHeaders(String projectId, String filter)
      throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      ProjectName projectName = ProjectName.of(projectId);

      // Restrict time to last 20 minutes
      long startMillis = System.currentTimeMillis() - ((60 * 20) * 1000);
      TimeInterval interval =
          TimeInterval.newBuilder()
              .setStartTime(Timestamps.fromMillis(startMillis))
              .setEndTime(Timestamps.fromMillis(System.currentTimeMillis()))
              .build();

      // Prepares the list time series request with headers
      ListTimeSeriesRequest request =
          ListTimeSeriesRequest.newBuilder()
              .setName(projectName.toString())
              .setFilter(filter)
              .setInterval(interval)
              .setView(ListTimeSeriesRequest.TimeSeriesView.HEADERS)
              .build();

      // Send the request to list the time series
      MetricServiceClient.ListTimeSeriesPagedResponse response =
          metricServiceClient.listTimeSeries(request);

      // Process the response
      System.out.println("Got timeseries headers: ");
      response.iterateAll().forEach(timeSeries -> System.out.println(timeSeries));
    }
  }
}
// [END monitoring_read_time_series_fields]
