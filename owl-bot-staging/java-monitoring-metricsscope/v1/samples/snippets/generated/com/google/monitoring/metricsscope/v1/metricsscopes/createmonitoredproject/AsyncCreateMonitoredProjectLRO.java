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

package com.google.monitoring.metricsscope.v1.samples;

// [START monitoring_v1_generated_MetricsScopes_CreateMonitoredProject_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.monitoring.metricsscope.v1.CreateMonitoredProjectRequest;
import com.google.monitoring.metricsscope.v1.MetricsScopeName;
import com.google.monitoring.metricsscope.v1.MetricsScopesClient;
import com.google.monitoring.metricsscope.v1.MonitoredProject;
import com.google.monitoring.metricsscope.v1.OperationMetadata;

public class AsyncCreateMonitoredProjectLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateMonitoredProjectLRO();
  }

  public static void asyncCreateMonitoredProjectLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MetricsScopesClient metricsScopesClient = MetricsScopesClient.create()) {
      CreateMonitoredProjectRequest request =
          CreateMonitoredProjectRequest.newBuilder()
              .setParent(MetricsScopeName.of("[METRICS_SCOPE]").toString())
              .setMonitoredProject(MonitoredProject.newBuilder().build())
              .build();
      OperationFuture<MonitoredProject, OperationMetadata> future =
          metricsScopesClient.createMonitoredProjectOperationCallable().futureCall(request);
      // Do something.
      MonitoredProject response = future.get();
    }
  }
}
// [END monitoring_v1_generated_MetricsScopes_CreateMonitoredProject_LRO_async]
