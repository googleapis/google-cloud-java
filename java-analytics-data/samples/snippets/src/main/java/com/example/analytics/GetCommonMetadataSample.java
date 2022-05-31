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

/* Google Analytics Data API sample application retrieving dimension and metrics
metadata.

See https://developers.google.com/analytics/devguides/reporting/data/v1/rest/v1beta/properties/getMetadata
for more information.

To run this sample using Maven:
  cd java-analytics-data/samples/snippets
  mvn compile
  mvn exec:java -Dexec.mainClass="com.example.analytics.GetCommonMetadataSample"
 */

// [START analyticsdata_get_common_metadata]

import com.google.analytics.data.v1beta.BetaAnalyticsDataClient;
import com.google.analytics.data.v1beta.DimensionMetadata;
import com.google.analytics.data.v1beta.GetMetadataRequest;
import com.google.analytics.data.v1beta.Metadata;
import com.google.analytics.data.v1beta.MetricMetadata;

public class GetCommonMetadataSample {

  public static void main(String... args) throws Exception {
    // Runs the sample.
    sampleGetCommonMetadata();
  }

  // Retrieves dimensions and metrics available for all Google Analytics 4 properties.
  static void sampleGetCommonMetadata() throws Exception {
    // Set the Property ID to 0 for dimensions and metrics common to all properties. In this special
    // mode, this method will not return custom dimensions and metrics.
    String propertyId = "0";
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BetaAnalyticsDataClient analyticsData = BetaAnalyticsDataClient.create()) {
      GetMetadataRequest request =
          GetMetadataRequest.newBuilder().setName("properties/" + propertyId + "/metadata").build();

      // Make the request.
      Metadata response = analyticsData.getMetadata(request);

      System.out.println("Dimensions and metrics available for all Google Analytics 4 properties:");
      printGetMetadataResponse(response);
    }
  }

  // Prints results of the getMetadata call.
  static void printGetMetadataResponse(Metadata response) {
    // [START analyticsdata_print_get_metadata_response]
    for (DimensionMetadata dimension : response.getDimensionsList()) {
      System.out.println("DIMENSION");
      System.out.printf(
          "%s (%s): %s%n",
          dimension.getApiName(), dimension.getUiName(), dimension.getDescription());
      System.out.printf("custom definition: %s%n", dimension.getCustomDefinition());
      if (dimension.getDeprecatedApiNamesList() != null
          && !dimension.getDeprecatedApiNamesList().isEmpty()) {
        System.out.printf("Deprecated API names: %s%n", dimension.getDeprecatedApiNamesList());
      }
      System.out.println();
    }
    for (MetricMetadata metric : response.getMetricsList()) {
      System.out.println("METRIC");
      System.out.printf(
          "%s (%s): %s%n", metric.getApiName(), metric.getUiName(), metric.getDescription());
      System.out.printf("custom definition: %s%n", metric.getCustomDefinition());
      System.out.printf("Type: %s%n", metric.getType());
      if (metric.getDeprecatedApiNamesList() != null
          && !metric.getDeprecatedApiNamesList().isEmpty()) {
        System.out.printf("Deprecated API names: %s%n", metric.getDeprecatedApiNamesList());
      }
      System.out.println();
    }
    // [END analyticsdata_print_get_metadata_response]
  }
}
// [END analyticsdata_get_common_metadata]
