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

// [START monitoring_list_resources]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.ListMonitoredResourceDescriptorsRequest;
import com.google.monitoring.v3.ProjectName;
import java.io.IOException;

// Sample to list monitored resources
public class MonitoredResourcesList {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    listMonitoredResources(projectId);
  }

  public static void listMonitoredResources(String projectId) throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      ProjectName name = ProjectName.of(projectId);

      // Construct ListMonitoredResourceDescriptors request
      ListMonitoredResourceDescriptorsRequest request =
          ListMonitoredResourceDescriptorsRequest.newBuilder().setName(name.toString()).build();

      // Send the request to list the MonitoredResource descriptor
      MetricServiceClient.ListMonitoredResourceDescriptorsPagedResponse response =
          metricServiceClient.listMonitoredResourceDescriptors(request);

      // Process the response
      System.out.println("Listing monitored resource descriptors: ");
      response
          .iterateAll()
          .forEach(
              metricDescriptor ->
                  System.out.format(
                      "success! monitored resources type %s %n", metricDescriptor.getType()));
    }
  }
}
// [END monitoring_list_resources]
