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
metric aggregations in a report.

See https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport#body.request_body.FIELDS.metric_aggregations
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunReportWithAggregationsSample"
 */

// [START analyticsdata_run_report_with_aggregations]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.MetricAggregation;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
import java.util.ArrayList;

public class RunReportWithAggregationsSample {

  public static void main(String... args) throws Exception {
    /**
     * TODO(developer): Replace this variable with your Google Analytics 4 property ID before
     * running the sample.
     */
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunReportWithAggregations(propertyId);
  }

  // Runs a report which includes total, maximum and minimum values for each metric.
  static void sampleRunReportWithAggregations(String propertyId) throws Exception {
    // Using a default constructor instructs the client to use the credentials
    // specified in GOOGLE_APPLICATION_CREDENTIALS environment variable.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("country"))
              .addMetrics(Metric.newBuilder().setName("sessions"))
              .addDateRanges(DateRange.newBuilder().setStartDate("365daysAgo").setEndDate("today"))
              .addAllMetricAggregations(
                  new ArrayList<MetricAggregation>() {
                    {
                      add(MetricAggregation.TOTAL);
                      add(MetricAggregation.MAXIMUM);
                      add(MetricAggregation.MINIMUM);
                    }
                  })
              .build();

      // Make the request.
      RunReportResponse response = analyticsData.runReport(request);
      RunReportSample.printRunResponseResponse(response);
    }
  }
}
// [END analyticsdata_run_report_with_aggregations]
