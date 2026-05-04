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

package com.google.analytics.data.v1alpha.samples;

// [START analyticsdata_v1alpha_generated_AlphaAnalyticsData_RunReport_sync]
import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1alpha.CohortSpec;
import com.google.analytics.data.v1alpha.Comparison;
import com.google.analytics.data.v1alpha.ConversionSpec;
import com.google.analytics.data.v1alpha.DateRange;
import com.google.analytics.data.v1alpha.Dimension;
import com.google.analytics.data.v1alpha.FilterExpression;
import com.google.analytics.data.v1alpha.Metric;
import com.google.analytics.data.v1alpha.MetricAggregation;
import com.google.analytics.data.v1alpha.OrderBy;
import com.google.analytics.data.v1alpha.RunReportRequest;
import com.google.analytics.data.v1alpha.RunReportResponse;
import java.util.ArrayList;

public class SyncRunReport {

  public static void main(String[] args) throws Exception {
    syncRunReport();
  }

  public static void syncRunReport() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("property-993141291")
              .addAllDimensions(new ArrayList<Dimension>())
              .addAllMetrics(new ArrayList<Metric>())
              .addAllDateRanges(new ArrayList<DateRange>())
              .setDimensionFilter(FilterExpression.newBuilder().build())
              .setMetricFilter(FilterExpression.newBuilder().build())
              .setOffset(-1019779949)
              .setLimit(102976443)
              .addAllMetricAggregations(new ArrayList<MetricAggregation>())
              .addAllOrderBys(new ArrayList<OrderBy>())
              .setCurrencyCode("currencyCode1004773790")
              .setCohortSpec(CohortSpec.newBuilder().build())
              .setKeepEmptyRows(true)
              .setReturnPropertyQuota(true)
              .addAllComparisons(new ArrayList<Comparison>())
              .setConversionSpec(ConversionSpec.newBuilder().build())
              .build();
      RunReportResponse response = alphaAnalyticsDataClient.runReport(request);
    }
  }
}
// [END analyticsdata_v1alpha_generated_AlphaAnalyticsData_RunReport_sync]
