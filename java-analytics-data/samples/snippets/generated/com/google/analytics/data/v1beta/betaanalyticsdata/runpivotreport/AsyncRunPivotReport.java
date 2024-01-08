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

package com.google.analytics.data.v1beta.samples;

// [START analyticsdata_v1beta_generated_BetaAnalyticsData_RunPivotReport_async]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.CohortSpec;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.FilterExpression;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.Pivot;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;
import com.google.api.core.ApiFuture;
import java.util.ArrayList;

public class AsyncRunPivotReport {

  public static void main(String[] args) throws Exception {
    asyncRunPivotReport();
  }

  public static void asyncRunPivotReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
      RunPivotReportRequest request =
          RunPivotReportRequest.newBuilder()
              .setProperty("property-993141291")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .addAllDateRanges(new ArrayList<DateRange>())
              .addAllPivots(new ArrayList<Pivot>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setCurrencyCode("currencyCode1004773790")
              .setCohortSpec(CohortSpec.newBuilder().build())
              .setKeepEmptyRows(true)
              .setReturnPropertyQuota(true)
              .build();
      ApiFuture<RunPivotReportResponse> future =
          betaAnalyticsDataClient.runPivotReportCallable().futureCall(request);
      // Do something.
      RunPivotReportResponse response = future.get();
    }
  }
}
// [END analyticsdata_v1beta_generated_BetaAnalyticsData_RunPivotReport_async]
