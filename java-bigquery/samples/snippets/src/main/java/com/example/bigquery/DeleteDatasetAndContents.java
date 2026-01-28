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

// [START bigquery_delete_dataset_and_contents]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;

// Sample to delete dataset with contents.
public class DeleteDatasetAndContents {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    deleteDatasetAndContents(projectId, datasetName);
  }

  public static void deleteDatasetAndContents(String projectId, String datasetName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      DatasetId datasetId = DatasetId.of(projectId, datasetName);
      // Use the force parameter to delete a dataset and its contents
      boolean success = bigquery.delete(datasetId, BigQuery.DatasetDeleteOption.deleteContents());
      if (success) {
        System.out.println("Dataset deleted with contents successfully");
      } else {
        System.out.println("Dataset was not found");
      }
    } catch (BigQueryException e) {
      System.out.println("Dataset was not deleted with contents. \n" + e.toString());
    }
  }
}
// [END bigquery_delete_dataset_and_contents]
