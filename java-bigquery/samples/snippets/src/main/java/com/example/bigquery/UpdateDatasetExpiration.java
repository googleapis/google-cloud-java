/*
 * Copyright 2019 Google LLC
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

// [START bigquery_update_dataset_expiration]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import java.util.concurrent.TimeUnit;

public class UpdateDatasetExpiration {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    // Update dataset expiration to one day
    Long newExpiration = TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
    updateDatasetExpiration(datasetName, newExpiration);
  }

  public static void updateDatasetExpiration(String datasetName, Long newExpiration) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Dataset dataset = bigquery.getDataset(datasetName);
      bigquery.update(dataset.toBuilder().setDefaultTableLifetime(newExpiration).build());
      System.out.println("Dataset description updated successfully to " + newExpiration);
    } catch (BigQueryException e) {
      System.out.println("Dataset expiration was not updated \n" + e.toString());
    }
  }
}
// [END bigquery_update_dataset_expiration]
