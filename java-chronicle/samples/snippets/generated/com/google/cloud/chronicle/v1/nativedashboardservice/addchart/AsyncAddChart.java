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

package com.google.cloud.chronicle.v1.samples;

// [START chronicle_v1_generated_NativeDashboardService_AddChart_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.chronicle.v1.AddChartRequest;
import com.google.cloud.chronicle.v1.AddChartResponse;
import com.google.cloud.chronicle.v1.DashboardChart;
import com.google.cloud.chronicle.v1.DashboardDefinition;
import com.google.cloud.chronicle.v1.DashboardQuery;
import com.google.cloud.chronicle.v1.NativeDashboardName;
import com.google.cloud.chronicle.v1.NativeDashboardServiceClient;

public class AsyncAddChart {

  public static void main(String[] args) throws Exception {
    asyncAddChart();
  }

  public static void asyncAddChart() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (NativeDashboardServiceClient nativeDashboardServiceClient =
        NativeDashboardServiceClient.create()) {
      AddChartRequest request =
          AddChartRequest.newBuilder()
              .setName(
                  NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
                      .toString())
              .setDashboardQuery(DashboardQuery.newBuilder().build())
              .setDashboardChart(DashboardChart.newBuilder().build())
              .setChartLayout(DashboardDefinition.ChartConfig.ChartLayout.newBuilder().build())
              .build();
      ApiFuture<AddChartResponse> future =
          nativeDashboardServiceClient.addChartCallable().futureCall(request);
      // Do something.
      AddChartResponse response = future.get();
    }
  }
}
// [END chronicle_v1_generated_NativeDashboardService_AddChart_async]
