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
a realtime report.

See https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runRealtimeReport
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunRealtimeReportSample"
 */

// [START analyticsdata_run_realtime_report]

import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.DimensionHeader;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.MetricHeader;
import com.google.analytics.data.v1beta.Row;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;

public class RunRealtimeReportSample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace with your Google Analytics 4 property ID before running the sample.
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunRealtimeReport(propertyId);
  }

  // Runs a realtime report on a Google Analytics 4 property.
  static void sampleRunRealtimeReport(String propertyId) throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunRealtimeReportRequest request =
          RunRealtimeReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("country"))
              .addMetrics(Metric.newBuilder().setName("activeUsers"))
              .build();

      // Make the request.
      RunRealtimeReportResponse response = analyticsData.runRealtimeReport(request);
      printRunRealtimeReportResponse(response);
    }
  }

  // Prints results of a runRealReport call.
  static void printRunRealtimeReportResponse(RunRealtimeReportResponse response) {
    // [START analyticsdata_print_run_realtime_report_response_header]
    System.out.printf("%s rows received%n", response.getRowsList().size());

    for (DimensionHeader header : response.getDimensionHeadersList()) {
      System.out.printf("Dimension header name: %s%n", header.getName());
    }

    for (MetricHeader header : response.getMetricHeadersList()) {
      System.out.printf("Metric header name: %s (%s)%n", header.getName(), header.getType());
    }
    // [END analyticsdata_print_run_realtime_report_response_header]

    // [START analyticsdata_print_run_realtime_report_response_rows]
    System.out.println("Report result:");
    for (Row row : response.getRowsList()) {
      System.out.printf(
          "%s, %s%n", row.getDimensionValues(0).getValue(), row.getMetricValues(0).getValue());
    }
    // [END analyticsdata_print_run_realtime_report_response_rows]
  }
}
// [END analyticsdata_run_realtime_report]
