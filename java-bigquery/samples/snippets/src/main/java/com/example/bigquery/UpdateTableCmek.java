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

// [START bigquery_update_table_cmek]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.EncryptionConfiguration;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

// Sample to update a cmek table
public class UpdateTableCmek {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String kmsKeyName = "MY_KEY_NAME";
    // Set a new encryption key to use for the destination.
    // i.e. projects/{project}/locations/{location}/keyRings/{key_ring}/cryptoKeys/{cryptoKey}
    EncryptionConfiguration encryption =
        EncryptionConfiguration.newBuilder().setKmsKeyName(kmsKeyName).build();
    updateTableCmek(datasetName, tableName, encryption);
  }

  public static void updateTableCmek(
      String datasetName, String tableName, EncryptionConfiguration encryption) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Table table = bigquery.getTable(TableId.of(datasetName, tableName));
      bigquery.update(table.toBuilder().setEncryptionConfiguration(encryption).build());
      System.out.println("Table cmek updated successfully");
    } catch (BigQueryException e) {
      System.out.println("Table cmek was not updated. \n" + e.toString());
    }
  }
}
// [END bigquery_update_table_cmek]
