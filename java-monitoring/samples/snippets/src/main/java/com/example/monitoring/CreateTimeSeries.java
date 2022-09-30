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

// [START monitoring_write_time_series]
import com.google.api.Metric;
import com.google.api.MonitoredResource;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.util.Timestamps;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Sample to create time series
public class CreateTimeSeries {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    createTimeSeries(projectId);
  }

  public static void createTimeSeries(String projectId) throws ApiException, IOException {
    // Instantiates a client
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      // Prepares an individual data point
      TimeInterval interval =
          TimeInterval.newBuilder()
              .setEndTime(Timestamps.fromMillis(System.currentTimeMillis()))
              .build();
      TypedValue value = TypedValue.newBuilder().setDoubleValue(123.45).build();
      Point point = Point.newBuilder().setInterval(interval).setValue(value).build();

      List<Point> pointList = new ArrayList<>();
      pointList.add(point);

      // Prepares the metric descriptor
      Map<String, String> metricLabels = new HashMap<>();
      Metric metric =
          Metric.newBuilder()
              .setType("custom.googleapis.com/my_metric")
              .putAllLabels(metricLabels)
              .build();

      // Prepares the monitored resource descriptor
      Map<String, String> resourceLabels = new HashMap<>();
      resourceLabels.put("instance_id", "1234567890123456789");
      resourceLabels.put("zone", "us-central1-f");

      MonitoredResource resource =
          MonitoredResource.newBuilder()
              .setType("gce_instance")
              .putAllLabels(resourceLabels)
              .build();

      // Prepares the time series request
      TimeSeries timeSeries =
          TimeSeries.newBuilder()
              .setMetric(metric)
              .setResource(resource)
              .addAllPoints(pointList)
              .build();

      List<TimeSeries> timeSeriesList = new ArrayList<>();
      timeSeriesList.add(timeSeries);

      CreateTimeSeriesRequest request =
          CreateTimeSeriesRequest.newBuilder()
              .setName(ProjectName.of(projectId).toString())
              .addAllTimeSeries(timeSeriesList)
              .build();

      // Writes time series data
      metricServiceClient.createTimeSeries(request);
      System.out.println("Done writing time series value");
    }
  }
}
// [END monitoring_write_time_series]
