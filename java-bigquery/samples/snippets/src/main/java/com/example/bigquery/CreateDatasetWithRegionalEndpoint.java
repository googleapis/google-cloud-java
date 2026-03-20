/*
 * Copyright 2023 Google LLC
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

// [START bigquery_create_dataset_with_regional_endpoint]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;

public class CreateDatasetWithRegionalEndpoint {
  public static void createDatasetWithRegionalEndpoint() {
    BigQuery bigquery;
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      bigquery =
          BigQueryOptions.newBuilder()
              .setHost("https://us-east4-bigquery.googleapis.com/")
              .build()
              .getService();
      String datasetName = "MyRegionalDataset";

      DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();

      Dataset newDataset = bigquery.create(datasetInfo);
      System.out.println("Region of dataset: " + newDataset.getLocation());
      bigquery.delete("MyRegionalDataset");
    } catch (BigQueryException e) {
      System.out.println("Dataset was not created. \n" + e);
    }
  }
}
// [END bigquery_create_dataset_with_regional_endpoint]
