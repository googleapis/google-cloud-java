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

// [START monitoring_get_resource]
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.MonitoredResourceDescriptorName;
import java.io.IOException;

// Sample to get monitored resource
public class GetMonitoredResource {

  public static void main(String[] args) throws ApiException, IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String resourceId = "your-resource-id";
    getMonitoredResource(projectId, resourceId);
  }

  public static void getMonitoredResource(String projectId, String resourceId)
      throws ApiException, IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests.
    try (MetricServiceClient metricServiceClient = MetricServiceClient.create()) {
      MonitoredResourceDescriptorName name =
          MonitoredResourceDescriptorName.of(projectId, resourceId);

      // Prepare get monitor resource descriptor
      MonitoredResourceDescriptor response =
          metricServiceClient.getMonitoredResourceDescriptor(name);
      System.out.println(response);
    }
  }
}
// [END monitoring_get_resource]
