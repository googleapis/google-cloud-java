/*
 * Copyright 2018 Google Inc.
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

package com.example.bigquerydatatransfer;

// [START bigquerydatatransfer_quickstart]
// Imports the Google Cloud client library

import com.google.cloud.bigquery.datatransfer.v1.DataSource;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient;
import com.google.cloud.bigquery.datatransfer.v1.DataTransferServiceClient.ListDataSourcesPagedResponse;
import com.google.cloud.bigquery.datatransfer.v1.ListDataSourcesRequest;

public class QuickstartSample {
  /**
   * List available data sources for the BigQuery Data Transfer service.
   */
  public static void main(String... args) throws Exception {
    // Sets your Google Cloud Platform project ID.
    // String projectId = "YOUR_PROJECT_ID";
    String projectId = args[0];

    // Instantiate a client. If you don't specify credentials when constructing a client, the
    // client library will look for credentials in the environment, such as the
    // GOOGLE_APPLICATION_CREDENTIALS environment variable.
    try (DataTransferServiceClient client = DataTransferServiceClient.create()) {
      // Request the list of available data sources.
      String parent = String.format("projects/%s", projectId);
      ListDataSourcesRequest request =
          ListDataSourcesRequest.newBuilder()
              .setParent(parent)
              .build();
      ListDataSourcesPagedResponse response = client.listDataSources(request);

      // Print the results.
      System.out.println("Supported Data Sources:");
      for (DataSource dataSource : response.iterateAll()) {
        System.out.println(dataSource.getDisplayName());
        System.out.printf("\tID: %s%n", dataSource.getDataSourceId());
        System.out.printf("\tFull path: %s%n", dataSource.getName());
        System.out.printf("\tDescription: %s%n", dataSource.getDescription());
      }
    }
  }
}
// [END bigquerydatatransfer_quickstart]
