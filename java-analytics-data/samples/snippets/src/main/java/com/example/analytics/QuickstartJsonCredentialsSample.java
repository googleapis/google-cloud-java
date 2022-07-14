/*
 * Copyright 2021 Google LLC
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

/* Google Analytics Data API sample quickstart application.

This application demonstrates the usage of the Analytics Data API using
service account credentials from a JSON file downloaded from
the Google Cloud Console.

Before you start the application, please review the comments starting with
"TODO(developer)" and update the code to use correct values.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.QuickstartJsonCredentialsSample"
 */

// [START analyticsdata_json_credentials_quickstart]
import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.BetaAnalyticsDataSettings;
import com.google.analytics.data.v1beta.DateRange;
import com.google.analytics.data.v1beta.Dimension;
import com.google.analytics.data.v1beta.Metric;
import com.google.analytics.data.v1beta.Row;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;

public class QuickstartJsonCredentialsSample {

  public static void main(String... args) throws Exception {
    /**
     * TODO(developer): Replace this variable with your Google Analytics 4 property ID before
     * running the sample.
     */
    String propertyId = "YOUR-GA4-PROPERTY-ID";

    /**
     * TODO(developer): Replace this variable with a valid path to the credentials.json file for
     * your service account downloaded from the Cloud Console.
     */
    String credentialsJsonPath = "/path/to/credentials.json";
    sampleRunReport(propertyId, credentialsJsonPath);
  }

  // This is an example snippet that calls the Google Analytics Data API and runs a simple report
  // on the provided GA4 property id.
  static void sampleRunReport(String propertyId, String credentialsJsonPath) throws Exception {
    // [START analyticsdata_json_credentials_initialize]
    // Explicitly use service account credentials by specifying
    // the private key file.
    GoogleCredentials credentials =
        GoogleCredentials.fromStream(new FileInputStream(credentialsJsonPath));

    BetaAnalyticsDataSettings betaAnalyticsDataSettings =
        BetaAnalyticsDataSettings.newBuilder()
            .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
            .build();

    try (BetaAnalyticsDataClient analyticsData =
        BetaAnalyticsDataClient.create(betaAnalyticsDataSettings)) {
      // [END analyticsdata_json_credentials_initialize]

      // [START analyticsdata_json_credentials_run_report]
      RunReportRequest request =
          RunReportRequest.newBuilder()
              .setProperty("properties/" + propertyId)
              .addDimensions(Dimension.newBuilder().setName("city"))
              .addMetrics(Metric.newBuilder().setName("activeUsers"))
              .addDateRanges(DateRange.newBuilder().setStartDate("2020-03-31").setEndDate("today"))
              .build();

      // Make the request.
      RunReportResponse response = analyticsData.runReport(request);
      // [END analyticsdata_json_credentials_run_report]

      // [START analyticsdata_json_credentials_print_report]
      System.out.println("Report result:");
      // Iterate through every row of the API response.
      for (Row row : response.getRowsList()) {
        System.out.printf(
            "%s, %s%n", row.getDimensionValues(0).getValue(), row.getMetricValues(0).getValue());
      }
      // [END analyticsdata_json_credentials_print_report]
    }
  }
}
// [END analyticsdata_json_credentials_quickstart]
