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

// [START monitoring_list_descriptors]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.ListMetricDescriptorsRequest;
import com.google.monitoring.v3.ProjectName;
import java.io.IOException;

// Sample to list metric descriptor
public class ListMetricDescriptor {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    listMetricDescriptors(projectId);
  }

  public static void listMetricDescriptors(String projectId) throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      ProjectName name = ProjectName.of(projectId);

      // Construct ListMetricDescriptors request
      ListMetricDescriptorsRequest request =
          ListMetricDescriptorsRequest.newBuilder().setName(name.toString()).build();

      // Send the request to list the metric descriptor
      MetricServiceClient.ListMetricDescriptorsPagedResponse response =
          metricServiceClient.listMetricDescriptors(request);

      // Process the response
      response
          .iterateAll()
          .forEach(
              metricDescriptor ->
                  System.out.format(
                      "success! metric descriptor with name %s display name %s%n",
                      metricDescriptor.getName(), metricDescriptor.getDisplayName()));
    }
  }
}
// [END monitoring_list_descriptors]
