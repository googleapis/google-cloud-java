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

// [START bigquery_undelete_table]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import org.threeten.bp.Instant;

// Sample to undeleting a table
public class UndeleteTable {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_TABLE";
    String recoverTableName = "MY_RECOVER_TABLE_TABLE";
    undeleteTable(datasetName, tableName, recoverTableName);
  }

  public static void undeleteTable(String datasetName, String tableName, String recoverTableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Record the current time.  We'll use this as the snapshot time
      // for recovering the table.
      long snapshotEpoch = Instant.now().toEpochMilli();

      // [START_EXCLUDE]
      // Due to very short lifecycle of the table, ensure we're not picking a time
      // prior to the table creation due to time drift between backend and client.
      Table table = bigquery.getTable(TableId.of(datasetName, tableName));
      Long createdEpoch = table.getCreationTime();
      if (createdEpoch > snapshotEpoch) {
        snapshotEpoch = createdEpoch;
      }
      // [END_EXCLUDE]

      // "Accidentally" delete the table.
      bigquery.delete(TableId.of(datasetName, tableName));

      // Construct the restore-from tableID using a snapshot decorator.
      String snapshotTableId = String.format("%s@%d", tableName, snapshotEpoch);

      // Construct and run a copy job.
      CopyJobConfiguration configuration =
          CopyJobConfiguration.newBuilder(
                  // Choose a new table ID for the recovered table data.
                  TableId.of(datasetName, recoverTableName),
                  TableId.of(datasetName, snapshotTableId))
              .build();

      Job job = bigquery.create(JobInfo.of(configuration));
      job = job.waitFor();
      if (job.isDone() && job.getStatus().getError() == null) {
        System.out.println("Undelete table recovered successfully.");
      } else {
        System.out.println(
            "BigQuery was unable to copy the table due to an error: \n"
                + job.getStatus().getError());
        return;
      }
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Table not found. \n" + e.toString());
    }
  }
}
// [END bigquery_undelete_table]
