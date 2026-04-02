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

// [START bigquery_delete_label_dataset]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import java.util.HashMap;
import java.util.Map;

// Sample tp deletes a label on a dataset.
public class DeleteLabelDataset {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    deleteLabelDataset(datasetName);
  }

  public static void deleteLabelDataset(String datasetName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // This example dataset starts with existing label { color: 'green' }
      Dataset dataset = bigquery.getDataset(datasetName);
      // Add label to dataset
      Map<String, String> labels = new HashMap<>();
      labels.put("color", null);

      dataset.toBuilder().setLabels(labels).build().update();
      System.out.println("Dataset label deleted successfully");
    } catch (BigQueryException e) {
      System.out.println("Dataset label was not deleted. \n" + e.toString());
    }
  }
}
// [END bigquery_delete_label_dataset]
