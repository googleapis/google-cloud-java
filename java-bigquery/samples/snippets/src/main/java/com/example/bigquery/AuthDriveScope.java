/*
 * Copyright 2026 Google LLC
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

package com.example.bigquery;

// [START bigquery_auth_drive_scope]
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;

public class AuthDriveScope {

  public static void main(String[] args) throws IOException {
    setAuthDriveScope();
  }

  public static void setAuthDriveScope() throws IOException {
    // Create credentials with Drive & BigQuery API scopes.
    // Both APIs must be enabled for your project before running this code.
    GoogleCredentials credentials =
        ServiceAccountCredentials.getApplicationDefault()
            .createScoped(
                ImmutableSet.of(
                    "https://www.googleapis.com/auth/bigquery",
                    "https://www.googleapis.com/auth/drive"));

    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery =
          BigQueryOptions.newBuilder().setCredentials(credentials).build().getService();

      // Use the client.
      System.out.println("Auth succeeded with multiple scopes. Datasets:");
      for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
        System.out.printf("Dataset: %s%n", dataset.getDatasetId().getDataset());
      }
    } catch (BigQueryException e) {
      System.out.println("Auth failed due to error: \n" + e.toString());
    }
  }
}
// [END bigquery_auth_drive_scope]
