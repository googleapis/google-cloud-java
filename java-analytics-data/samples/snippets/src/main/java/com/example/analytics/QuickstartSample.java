/*
 * Copyright 2020 Google LLC
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

/* This application demonstrates the usage of the Analytics Data API using
 service account credentials. For more information on service accounts, see
 https://cloud.google.com/iam/docs/understanding-service-accounts

 The following document provides instructions on setting service account
 credentials for your application:
 https://cloud.google.com/docs/authentication/production

 In a nutshell, you need to:

 1. Create a service account and download the key JSON file.
 https://cloud.google.com/docs/authentication/production#creating_a_service_account

 2. Provide service account credentials using one of the following options:
 - set the GOOGLE_APPLICATION_CREDENTIALS environment variable, the API
 client will use the value of this variable to find the service account key
 JSON file.

 https://cloud.google.com/docs/authentication/production#setting_the_environment_variable

 OR

 - manually pass the path to the service account key JSON file to the API client
 by specifying the keyFilename parameter in the constructor.
 https://cloud.google.com/docs/authentication/production#passing_the_path_to_the_service_account_key_in_code

 To run this sample using Maven:
   cd java-analytics-data/samples/snippets
   mvn compile
   mvn exec:java -Dexec.mainClass="QuickstartSample"
 */

// [START analytics_data_quickstart]

import com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient;
import com.google.analytics.data.v1alpha.DateRange;
import com.google.analytics.data.v1alpha.Dimension;
import com.google.analytics.data.v1alpha.Entity;
import com.google.analytics.data.v1alpha.Metric;
import com.google.analytics.data.v1alpha.Row;
import com.google.analytics.data.v1alpha.RunReportRequest;
import com.google.analytics.data.v1alpha.RunReportResponse;

public class QuickstartSample {

  // This is an example snippet that calls the Google Analytics Data API and runs a simple report
  // on the provided GA4 property id.
  static void sampleRunReport(String ga4PropertyId) throws Exception {
    // Instantiates a client using default credentials.
    // See https://cloud.google.com/docs/authentication/production for more information
    // about managing credentials.
    try (AlphaAnalyticsDataClient analyticsData = AlphaAnalyticsDataClient.create()) {
      RunReportRequest request = RunReportRequest.newBuilder()
          .setEntity(Entity.newBuilder().setPropertyId(ga4PropertyId))
          .addDimensions(
              Dimension.newBuilder().setName("city"))
          .addMetrics(Metric.newBuilder().setName("activeUsers"))
          .addDateRanges(
              DateRange.newBuilder().setStartDate("2020-03-31").setEndDate("today")).build();

      // Make the request
      RunReportResponse response = analyticsData.runReport(request);

      System.out.println("Report result:");
      for (Row row : response.getRowsList()) {
        System.out.printf("%s, %s%n", row.getDimensionValues(0).getValue(),
            row.getMetricValues(0).getValue());
      }
    }
  }

  public static void main(String... args) throws Exception {
    // TODO(developer): Replace this variable with your GA4 property ID before running the sample.
    String ga4PropertyId = "GA4 PROPERTY ID";
    sampleRunReport(ga4PropertyId);
  }
}

// [END analytics_data_quickstart]
