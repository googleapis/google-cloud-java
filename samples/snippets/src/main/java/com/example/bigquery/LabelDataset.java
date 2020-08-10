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

// [START bigquery_label_dataset]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import java.util.HashMap;
import java.util.Map;

// Sample to updates a label on dataset
public class LabelDataset {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    labelDataset(datasetName);
  }

  public static void labelDataset(String datasetName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // This example dataset starts with existing label { color: 'green' }
      Dataset dataset = bigquery.getDataset(datasetName);
      // Add label to dataset
      Map<String, String> labels = new HashMap<>();
      labels.put("color", "green");

      dataset.toBuilder().setLabels(labels).build().update();
      System.out.println("Label added successfully");
    } catch (BigQueryException e) {
      System.out.println("Label was not added. \n" + e.toString());
    }
  }
}
// [END bigquery_label_dataset]
