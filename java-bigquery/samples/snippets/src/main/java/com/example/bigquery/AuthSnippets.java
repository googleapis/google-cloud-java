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

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Examples for authenticating to Google BigQuery.
 *
 * <p>See: https://cloud.google.com/bigquery/authentication
 */
public class AuthSnippets {

  // [START bigquery_client_default_credentials]
  public static void implicit() {
    // Instantiate a client. If you don't specify credentials when constructing a client, the
    // client library will look for credentials in the environment, such as the
    // GOOGLE_APPLICATION_CREDENTIALS environment variable.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    // Use the client.
    System.out.println("Datasets:");
    for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
      System.out.printf("%s%n", dataset.getDatasetId().getDataset());
    }
  }
  // [END bigquery_client_default_credentials]

  // [START bigquery_client_json_credentials]
  public static void explicit() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    File credentialsPath = new File("path/to/your/service_account.json");

    // Load credentials from JSON key file. If you can't set the GOOGLE_APPLICATION_CREDENTIALS
    // environment variable, you can explicitly load the credentials file to construct the
    // credentials.
    GoogleCredentials credentials;
    try (FileInputStream serviceAccountStream = new FileInputStream(credentialsPath)) {
      credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
    }

    // Instantiate a client.
    BigQuery bigquery =
        BigQueryOptions.newBuilder()
            .setCredentials(credentials)
            .setProjectId(projectId)
            .build()
            .getService();

    // Use the client.
    System.out.println("Datasets:");
    for (Dataset dataset : bigquery.listDatasets().iterateAll()) {
      System.out.printf("%s%n", dataset.getDatasetId().getDataset());
    }
  }
  // [END bigquery_client_json_credentials]

  public static void main(String... args) throws IOException {
    boolean validArgs = args.length == 1;
    String sample = "explicit";
    if (validArgs) {
      sample = args[0];
      if (!sample.equals("explicit") && !sample.equals("implicit")) {
        validArgs = false;
      }
    }

    if (!validArgs) {
      System.err.println("Expected auth type argument: implict|explict");
      System.exit(1);
    }

    if (sample.equals("implicit")) {
      implicit();
    } else {
      explicit();
    }
  }
}
