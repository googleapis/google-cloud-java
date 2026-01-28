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

// [START bigquery_label_table]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import java.util.HashMap;
import java.util.Map;

// Sample to adds a label to an existing table
public class LabelTable {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    labelTable(datasetName, tableName);
  }

  public static void labelTable(String datasetName, String tableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // This example table starts with existing label { color: 'green' }
      Table table = bigquery.getTable(TableId.of(datasetName, tableName));
      // Add label to table
      Map<String, String> labels = new HashMap<>();
      labels.put("color", "green");

      table.toBuilder().setLabels(labels).build().update();
      System.out.println("Label added successfully");
    } catch (BigQueryException e) {
      System.out.println("Label was not added. \n" + e.toString());
    }
  }
}
// [END bigquery_label_table]
