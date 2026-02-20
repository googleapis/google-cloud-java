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

package com.example.bigquery;

// [START bigquery_omni_create_dataset]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;

// Sample to create a aws dataset
public class CreateDatasetAws {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String location = "aws-us-east-1";
    createDatasetAws(projectId, datasetName, location);
  }

  public static void createDatasetAws(String projectId, String datasetName, String location) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      DatasetInfo datasetInfo =
          DatasetInfo.newBuilder(projectId, datasetName).setLocation(location).build();

      Dataset dataset = bigquery.create(datasetInfo);
      System.out.println(
          "Aws dataset created successfully :" + dataset.getDatasetId().getDataset());
    } catch (BigQueryException e) {
      System.out.println("Aws dataset was not created. \n" + e.toString());
    }
  }
}
// [END bigquery_omni_create_dataset]
