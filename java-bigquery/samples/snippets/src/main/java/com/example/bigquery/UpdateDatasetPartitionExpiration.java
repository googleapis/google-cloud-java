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

// [START bigquery_update_dataset_partition_expiration]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import java.util.concurrent.TimeUnit;

// Sample to update partition expiration on a dataset.
public class UpdateDatasetPartitionExpiration {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    // Set the default partition expiration (applies to new tables, only) in
    // milliseconds. This example sets the default expiration to 90 days.
    Long newExpiration = TimeUnit.MILLISECONDS.convert(90, TimeUnit.DAYS);
    updateDatasetPartitionExpiration(datasetName, newExpiration);
  }

  public static void updateDatasetPartitionExpiration(String datasetName, Long newExpiration) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Dataset dataset = bigquery.getDataset(datasetName);
      bigquery.update(dataset.toBuilder().setDefaultPartitionExpirationMs(newExpiration).build());
      System.out.println(
          "Dataset default partition expiration updated successfully to " + newExpiration);
    } catch (BigQueryException e) {
      System.out.println("Dataset partition expiration was not updated \n" + e.toString());
    }
  }
}
// [END bigquery_update_dataset_partition_expiration]
