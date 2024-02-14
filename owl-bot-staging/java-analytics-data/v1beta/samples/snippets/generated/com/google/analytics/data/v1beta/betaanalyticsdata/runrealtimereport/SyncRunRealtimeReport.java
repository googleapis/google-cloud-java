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

package com.google.analytics.data.v1beta.samples;

// [START analyticsdata_v1beta_generated_BetaAnalyticsData_RunRealtimeReport_sync]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.FilterExpression;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.MetricAggregation;
import com.google.analytics.data.v1beta.MinuteRange;
import com.google.analytics.data.v1beta.OrderBy;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;
import java.util.ArrayList;

public class SyncRunRealtimeReport {

  public static void main(String[] args) throws Exception {
    syncRunRealtimeReport();
  }

  public static void syncRunRealtimeReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
      RunRealtimeReportRequest request =
          RunRealtimeReportRequest.newBuilder()
              .setProperty("property-993141291")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setLimit(102976443)
              .addAllMetricAggregations(new ArrayList<MetricAggregation>())
              .addAllOrderBys(new ArrayList<OrderBy>())
              .setReturnPropertyQuota(true)
              .addAllMinuteRanges(new ArrayList<MinuteRange>())
              .build();
      RunRealtimeReportResponse response = betaAnalyticsDataClient.runRealtimeReport(request);
    }
  }
}
// [END analyticsdata_v1beta_generated_BetaAnalyticsData_RunRealtimeReport_sync]
