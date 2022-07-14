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

// [START monitoring_create_metric]
import com.google.api.LabelDescriptor;
import com.google.api.MetricDescriptor;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.CreateMetricDescriptorRequest;
import com.google.monitoring.v3.ProjectName;
import java.io.IOException;

// Sample to create metric descriptor
public class CreateMetricDescriptor {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String type = "metric-descriptor-type";
    String metricType = "custom.googleapis.com/" + type;
    createMetricDescriptor(projectId, metricType);
  }

  public static void createMetricDescriptor(String projectId, String metricType)
      throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      ProjectName name = ProjectName.of(projectId);

      // Define a metric type and its schema
      MetricDescriptor descriptor =
          MetricDescriptor.newBuilder()
              .setType(metricType)
              .addLabels(
                  LabelDescriptor.newBuilder()
                      .setKey("store_id")
                      .setValueType(LabelDescriptor.ValueType.STRING))
              .setDescription("This is a simple example of a custom metric.")
              .setMetricKind(MetricDescriptor.MetricKind.GAUGE)
              .setValueType(MetricDescriptor.ValueType.DOUBLE)
              .build();

      // Construct CreateMetricDescriptor request
      CreateMetricDescriptorRequest request =
          CreateMetricDescriptorRequest.newBuilder()
              .setName(name.toString())
              .setMetricDescriptor(descriptor)
              .build();

      // Send the request to create the metric descriptor
      MetricDescriptor metricDescriptor = metricServiceClient.createMetricDescriptor(request);

      // Process the response
      System.out.println("metric descriptor created successfully: " + metricDescriptor.getName());
    }
  }
}
// [END monitoring_create_metric]
