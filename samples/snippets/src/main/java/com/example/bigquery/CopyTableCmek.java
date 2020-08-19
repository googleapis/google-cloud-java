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

// [START bigquery_copy_table_cmek]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.EncryptionConfiguration;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.TableId;

// Sample to copy a cmek table
public class CopyTableCmek {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String destinationDatasetName = "MY_DESTINATION_DATASET_NAME";
    String destinationTableId = "MY_DESTINATION_TABLE_NAME";
    String sourceDatasetName = "MY_SOURCE_DATASET_NAME";
    String sourceTableId = "MY_SOURCE_TABLE_NAME";
    String kmsKeyName = "MY_KMS_KEY_NAME";
    EncryptionConfiguration encryption =
        EncryptionConfiguration.newBuilder().setKmsKeyName(kmsKeyName).build();
    copyTableCmek(
        sourceDatasetName, sourceTableId, destinationDatasetName, destinationTableId, encryption);
  }

  public static void copyTableCmek(
      String sourceDatasetName,
      String sourceTableId,
      String destinationDatasetName,
      String destinationTableId,
      EncryptionConfiguration encryption) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId sourceTable = TableId.of(sourceDatasetName, sourceTableId);
      TableId destinationTable = TableId.of(destinationDatasetName, destinationTableId);

      // For more information on CopyJobConfiguration see:
      // https://googleapis.dev/java/google-cloud-clients/latest/com/google/cloud/bigquery/JobConfiguration.html
      CopyJobConfiguration configuration =
          CopyJobConfiguration.newBuilder(destinationTable, sourceTable)
              .setDestinationEncryptionConfiguration(encryption)
              .build();

      // For more information on Job see:
      // https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/bigquery/package-summary.html
      Job job = bigquery.create(JobInfo.of(configuration));

      // Blocks until this job completes its execution, either failing or succeeding.
      Job completedJob = job.waitFor();
      if (completedJob == null) {
        System.out.println("Job not executed since it no longer exists.");
        return;
      } else if (completedJob.getStatus().getError() != null) {
        System.out.println(
            "BigQuery was unable to copy table due to an error: \n" + job.getStatus().getError());
        return;
      }
      System.out.println("Table cmek copied successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Table cmek copying job was interrupted. \n" + e.toString());
    }
  }
}
// [END bigquery_copy_table_cmek]
