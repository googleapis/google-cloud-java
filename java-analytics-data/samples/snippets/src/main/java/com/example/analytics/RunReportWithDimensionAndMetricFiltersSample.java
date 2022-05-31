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

/* Google Analytics Data API sample application demonstrating the usage of
dimension and metric filters in a report.

See
https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport#body.request_body.FIELDS.dimension_filter
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
 mvn exec:java -Dexec.mainClass="com.example.analytics.RunReportWithDimensionAndMetricFiltersSample"
 */

// [START analyticsdata_run_report_with_dimension_and_metric_filters]

import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.Filter;
import com.google.analytics.data.v1beta.FilterExpression;
import com.google.analytics.data.v1beta.FilterExpressionList;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.NumericValue;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;

public class RunReportWithDimensionAndMetricFiltersSample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace with your Google Analytics 4 property ID before running the sample.
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunReportWithDimensionAndMetricFilters(propertyId);
  }

  // Runs a report using both metric and dimension filters. A dimension filter limits the report to
  // include only users who made an in-app purchase using Android platform. A metric filter
  // specifies that only users with session counts larger than 1,000 should be included.
  static void sampleRunReportWithDimensionAndMetricFilters(String propertyId) throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("city"))
              .addMetrics(Metric.newBuilder().setName("activeUsers"))
              .addDateRanges(DateRange.newBuilder().setStartDate("2020-03-31").setEndDate("today"))
              .setDimensionFilter(
                  FilterExpression.newBuilder()
                      .setAndGroup(
                          FilterExpressionList.newBuilder()
                              .addExpressions(
                                  FilterExpression.newBuilder()
                                      .setFilter(
                                          Filter.newBuilder()
                                              .setFieldName("platform")
                                              .setStringFilter(
                                                  Filter.StringFilter.newBuilder()
                                                      .setMatchType(
                                                          Filter.StringFilter.MatchType.EXACT)
                                                      .setValue("Android"))))
                              .addExpressions(
                                  FilterExpression.newBuilder()
                                      .setFilter(
                                          Filter.newBuilder()
                                              .setFieldName("eventName")
                                              .setStringFilter(
                                                  Filter.StringFilter.newBuilder()
                                                      .setMatchType(
                                                          Filter.StringFilter.MatchType.EXACT)
                                                      .setValue("in_app_purchase"))))))
              .setMetricFilter(
                  FilterExpression.newBuilder()
                      .setFilter(
                          Filter.newBuilder()
                              .setFieldName("sessions")
                              .setNumericFilter(
                                  Filter.NumericFilter.newBuilder()
                                      .setOperation(Filter.NumericFilter.Operation.GREATER_THAN)
                                      .setValue(NumericValue.newBuilder().setInt64Value(1000)))))
              .build();

      // Make the request.
      RunReportResponse response = analyticsData.runReport(request);
      // Prints the response using a method in RunReportSample.java
      RunReportSample.printRunResponseResponse(response);
    }
  }
}
// [END analyticsdata_run_report_with_dimension_and_metric_filters]
