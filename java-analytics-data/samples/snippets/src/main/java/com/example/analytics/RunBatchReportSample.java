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

/* Google Analytics Data API sample application demonstrating the batch creation
of multiple reports.

See
https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/batchRunReports
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunBatchReportSample"
 */

// [START analyticsdata_run_batch_report]

import com.google.analytics.data.v1beta.BatchRunReportsRequest;
import com.google.analytics.data.v1beta.BatchRunReportsResponse;
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;

public class RunBatchReportSample {

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace with your Google Analytics 4 property ID before running the sample.
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunBatchReport(propertyId);
  }

  // Runs a batch report on a Google Analytics 4 property.
  static void sampleRunBatchReport(String propertyId) throws Exception {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {

      BatchRunReportsRequest request =
          BatchRunReportsRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addRequests(
                  RunReportRequest.newBuilder()
                      .addDimensions(Dimension.newBuilder().setName("country"))
                      .addDimensions(Dimension.newBuilder().setName("region"))
                      .addDimensions(Dimension.newBuilder().setName("city"))
                      .addMetrics(Metric.newBuilder().setName("activeUsers"))
                      .addDateRanges(
                          DateRange.newBuilder()
                              .setStartDate("2021-01-03")
                              .setEndDate("2021-01-09")))
              .addRequests(
                  RunReportRequest.newBuilder()
                      .addDimensions(Dimension.newBuilder().setName("browser"))
                      .addMetrics(Metric.newBuilder().setName("activeUsers"))
                      .addDateRanges(
                          DateRange.newBuilder()
                              .setStartDate("2021-01-01")
                              .setEndDate("2021-01-31")))
              .build();

      // Make the request.
      BatchRunReportsResponse response = analyticsData.batchRunReports(request);

      // Prints the response using a method in RunReportSample.java
      System.out.println("Batch report results:");
      for (RunReportResponse report : response.getReportsList()) {
        RunReportSample.printRunResponseResponse(report);
      }
    }
  }
}
// [END analyticsdata_run_batch_report]
