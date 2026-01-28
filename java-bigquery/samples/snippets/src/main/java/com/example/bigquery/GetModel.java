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

// [START bigquery_get_model]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Model;
import com.google.cloud.bigquery.ModelId;

public class GetModel {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String modelName = "MY_MODEL_ID";
    getModel(datasetName, modelName);
  }

  public static void getModel(String datasetName, String modelName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      ModelId modelId = ModelId.of(datasetName, modelName);
      Model model = bigquery.getModel(modelId);
      System.out.println("Model: " + model.getDescription());

      System.out.println("Successfully retrieved model");
    } catch (BigQueryException e) {
      System.out.println("Cannot retrieve model \n" + e.toString());
    }
  }
}
// [END bigquery_get_model]
