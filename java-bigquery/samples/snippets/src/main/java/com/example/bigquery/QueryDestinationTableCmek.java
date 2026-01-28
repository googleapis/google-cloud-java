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

// [START bigquery_query_destination_table_cmek]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.EncryptionConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

// Sample to query on destination table with encryption key
public class QueryDestinationTableCmek {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String kmsKeyName = "MY_KMS_KEY_NAME";
    String query =
        String.format("SELECT stringField, booleanField FROM %s.%s", datasetName, tableName);
    EncryptionConfiguration encryption =
        EncryptionConfiguration.newBuilder().setKmsKeyName(kmsKeyName).build();
    queryDestinationTableCmek(query, encryption);
  }

  public static void queryDestinationTableCmek(String query, EncryptionConfiguration encryption) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      QueryJobConfiguration config =
          QueryJobConfiguration.newBuilder(query)
              // Set the encryption key to use for the destination.
              .setDestinationEncryptionConfiguration(encryption)
              .build();

      TableResult results = bigquery.query(config);

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));
      System.out.println("Query performed successfully with encryption key.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_destination_table_cmek]
