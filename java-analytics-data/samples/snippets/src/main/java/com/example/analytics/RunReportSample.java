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

/* Google Analytics Data API sample application demonstrating the creation
of a basic report.

See
https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunReportSample"
 */

// [START analyticsdata_run_report]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.DimensionHeader;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.MetricHeader;
import com.google.analytics.data.v1beta.Row;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;

public class RunReportSample {

  public static void main(String... args) throws Exception {
    /**
     * TODO(developer): Replace this variable with your Google Analytics 4 property ID before
     * running the sample.
     */
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunReport(propertyId);
  }

  // Runs a report of active users grouped by country.
  static void sampleRunReport(String propertyId) throws Exception {

    // Using a default constructor instructs the client to use the credentials
    // specified in GOOGLE_APPLICATION_CREDENTIALS environment variable.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("country"))
              .addMetrics(Metric.newBuilder().setName("activeUsers"))
              .addDateRanges(
                  DateRange.newBuilder().setStartDate("2020-09-01").setEndDate("2020-09-15"))
              .build();

      // Make the request.
      RunReportResponse response = analyticsData.runReport(request);
      printRunResponseResponse(response);
    }
  }

  // Prints results of a runReport call.
  static void printRunResponseResponse(RunReportResponse response) {
    // [START analyticsdata_print_run_report_response_header]
    System.out.printf("%s rows received%n", response.getRowsList().size());

    for (DimensionHeader header : response.getDimensionHeadersList()) {
      System.out.printf("Dimension header name: %s%n", header.getName());
    }

    for (MetricHeader header : response.getMetricHeadersList()) {
      System.out.printf("Metric header name: %s (%s)%n", header.getName(), header.getType());
    }
    // [END analyticsdata_print_run_report_response_header]

    // [START analyticsdata_print_run_report_response_rows]
    System.out.println("Report result:");
    for (Row row : response.getRowsList()) {
      System.out.printf(
          "%s, %s%n", row.getDimensionValues(0).getValue(), row.getMetricValues(0).getValue());
    }
    // [END analyticsdata_print_run_report_response_rows]
  }
}
// [END analyticsdata_run_report]
