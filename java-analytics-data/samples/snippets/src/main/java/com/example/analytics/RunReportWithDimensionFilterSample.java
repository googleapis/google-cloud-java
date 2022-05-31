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
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunReportWithDimensionFilterSample"
 */

// [START analyticsdata_run_report_with_dimension_filter]

import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.Filter;
import com.google.analytics.data.v1beta.FilterExpression;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;

public class RunReportWithDimensionFilterSample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace with your Google Analytics 4 property ID before running the sample.
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunReportWithDimensionFilter(propertyId);
  }

  // Runs a report using a dimension filter. The call returns a time series report of `eventCount`
  // when `eventName` is `first_open` for each date.
  // This sample uses relative date range values.
  // See https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/DateRange
  // for more information.
  static void sampleRunReportWithDimensionFilter(String propertyId) throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("date"))
              .addMetrics(Metric.newBuilder().setName("eventCount"))
              .addDateRanges(
                  DateRange.newBuilder().setStartDate("7daysAgo").setEndDate("yesterday"))
              .setDimensionFilter(
                  FilterExpression.newBuilder()
                      .setFilter(
                          Filter.newBuilder()
                              .setFieldName("eventName")
                              .setStringFilter(
                                  Filter.StringFilter.newBuilder().setValue("first_open"))))
              .build();

      // Make the request.
      RunReportResponse response = analyticsData.runReport(request);
      // Prints the response using a method in RunReportSample.java
      RunReportSample.printRunResponseResponse(response);
    }
  }
}
// [END analyticsdata_run_report_with_dimension_filter]
