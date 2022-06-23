/*
 * Copyright 2022 Google LLC
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

package com.example.analytics;

/* Google Analytics Data API sample application demonstrating the creation of
a pivot report.

See
https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runPivotReport
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunPivotReportSample"
 */

// [START analyticsdata_run_pivot_report]

import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.DimensionValue;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.MetricValue;
import com.google.analytics.data.v1beta.OrderBy;
import com.google.analytics.data.v1beta.Pivot;
import com.google.analytics.data.v1beta.Row;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;

public class RunPivotReportSample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace with your Google Analytics 4 property ID before running the sample.
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunPivotReport(propertyId);
  }

  // Runs a pivot query to build a report of session counts by country, pivoted by the browser
  // dimension
  static void sampleRunPivotReport(String propertyId) throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunPivotReportRequest request =
          RunPivotReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDateRanges(
                  DateRange.newBuilder().setStartDate("2021-01-01").setEndDate("2021-01-30"))
              .addPivots(
                  Pivot.newBuilder()
                      .addFieldNames("country")
                      .setLimit(250)
                      .addOrderBys(
                          OrderBy.newBuilder()
                              .setDimension(
                                  OrderBy.DimensionOrderBy.newBuilder()
                                      .setDimensionName("country"))))
              .addPivots(
                  Pivot.newBuilder()
                      .addFieldNames("browser")
                      .setOffset(3)
                      .setLimit(3)
                      .addOrderBys(
                          OrderBy.newBuilder()
                              .setMetric(
                                  OrderBy.MetricOrderBy.newBuilder().setMetricName("sessions"))
                              .setDesc(true)))
              .addMetrics(Metric.newBuilder().setName("sessions"))
              .addDimensions(Dimension.newBuilder().setName("country"))
              .addDimensions(Dimension.newBuilder().setName("browser"))
              .build();

      // Make the request.
      RunPivotReportResponse response = analyticsData.runPivotReport(request);
      printRunPivotReportResponse(response);
    }
  }

  // Prints results of a runPivotReport call.
  static void printRunPivotReportResponse(RunPivotReportResponse response) {
    // [START analyticsdata_print_run_pivot_report_response]
    System.out.println("Report result:");
    for (Row row : response.getRowsList()) {
      for (DimensionValue dimensionValue : row.getDimensionValuesList()) {
        System.out.println(dimensionValue.getValue());
      }
      for (MetricValue metricValue : row.getMetricValuesList()) {
        System.out.println(metricValue.getValue());
      }
    }
    // [END analyticsdata_print_run_pivot_report_response]
  }
}
// [END analyticsdata_run_pivot_report]
