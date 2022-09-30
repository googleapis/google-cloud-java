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
cohort specification in a report.

See
https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/runReport#body.request_body.FIELDS.cohort_spec
for more information.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.RunReportWithCohortsSample"
 */

// [START analyticsdata_run_report_with_cohorts]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.Cohort;
import com.google.analytics.data.v1beta.CohortSpec;
import com.google.analytics.data.v1beta.CohortsRange;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;

public class RunReportWithCohortsSample {

  public static void main(String... args) throws Exception {
    /**
     * TODO(developer): Replace this variable with your Google Analytics 4 property ID before
     * running the sample.
     */
    String propertyId = "YOUR-GA4-PROPERTY-ID";
    sampleRunReportWithCohorts(propertyId);
  }

  // Runs a report on a cohort of users whose first session happened on the
  // same week. The number of active users and user retention rate is calculated
  // for the cohort using WEEKLY granularity.
  static void sampleRunReportWithCohorts(String propertyId) throws Exception {
    // Using a default constructor instructs the client to use the credentials
    // specified in GOOGLE_APPLICATION_CREDENTIALS environment variable.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("cohort"))
              .addDimensions(Dimension.newBuilder().setName("cohortNthWeek"))
              .addMetrics(Metric.newBuilder().setName("cohortActiveUsers"))
              .addMetrics(
                  Metric.newBuilder()
                      .setName("cohortRetentionRate")
                      .setExpression("cohortActiveUsers/cohortTotalUsers"))
              .setCohortSpec(
                  CohortSpec.newBuilder()
                      .addCohorts(
                          Cohort.newBuilder()
                              .setDimension("firstSessionDate")
                              .setName("cohort")
                              .setDateRange(
                                  DateRange.newBuilder()
                                      .setStartDate("2021-01-03")
                                      .setEndDate("2021-01-09")))
                      .setCohortsRange(
                          CohortsRange.newBuilder()
                              .setStartOffset(0)
                              .setEndOffset(4)
                              .setGranularity(CohortsRange.Granularity.WEEKLY)))
              .build();

      // Make the request.
      RunReportResponse response = analyticsData.runReport(request);
      RunReportSample.printRunResponseResponse(response);
    }
  }
}
// [END analyticsdata_run_report_with_cohorts]
