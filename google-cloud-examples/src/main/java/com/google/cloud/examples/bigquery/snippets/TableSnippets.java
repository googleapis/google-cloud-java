/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Table’s javadoc. Any change to this file should be reflected in
 * Table’s javadoc.
 */

package com.google.cloud.examples.bigquery.snippets;

import com.google.api.gax.core.Page;
import com.google.cloud.WaitForOption;
import com.google.cloud.bigquery.BigQuery.JobField;
import com.google.cloud.bigquery.BigQuery.JobOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQuery.TableField;
import com.google.cloud.bigquery.BigQuery.TableOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * This class contains a number of snippets for the {@link Table} class.
 */
public class TableSnippets {

  private final Table table;

  public TableSnippets(Table table) {
    this.table = table;
  }

  /**
   * Example of checking if the table exists.
   */
  // [TARGET exists()]
  public boolean exists() {
    // [START exists]
    boolean exists = table.exists();
    if (exists) {
      // the table exists
    } else {
      // the table was not found
    }
    // [END exists]
    return exists;
  }

  /**
   * Example of fetching the table's latest information, specifying particular table fields to
   * get.
   */
  // [TARGET reload(TableOption...)]
  // [VARIABLE TableField.LAST_MODIFIED_TIME]
  // [VARIABLE TableField.NUM_ROWS]
  public Table reloadTableWithFields(TableField field1, TableField field2) {
    // [START reloadTableWithFields]
    Table latestTable = table.reload(TableOption.fields(field1, field2));
    if (latestTable == null) {
      // the table was not found
    }
    // [END reloadTableWithFields]
    return latestTable;
  }

  /**
   * Example of updating the table's information.
   */
  // [TARGET update(TableOption...)]
  public Table update() {
    // [START update]
    Table updatedTable = table.toBuilder().setDescription("new description").build().update();
    // [END update]
    return updatedTable;
  }

  /**
   * Example of deleting the table.
   */
  // [TARGET delete()]
  public boolean delete() {
    // [START delete]
    boolean deleted = table.delete();
    if (deleted) {
      // the table was deleted
    } else {
      // the table was not found
    }
    // [END delete]
    return deleted;
  }

  /**
   * Example of inserting rows into the table.
   */
  // [TARGET insert(Iterable)]
  // [VARIABLE "rowId1"]
  // [VARIABLE "rowId2"]
  public InsertAllResponse insert(String rowId1, String rowId2) {
    // [START insert]
    List<RowToInsert> rows = new ArrayList<>();
    Map<String, Object> row1 = new HashMap<>();
    row1.put("stringField", "value1");
    row1.put("booleanField", true);
    Map<String, Object> row2 = new HashMap<>();
    row2.put("stringField", "value2");
    row2.put("booleanField", false);
    rows.add(RowToInsert.of(rowId1, row1));
    rows.add(RowToInsert.of(rowId2, row2));
    InsertAllResponse response = table.insert(rows);
    // do something with response
    // [END insert]
    return response;
  }

  /**
   * Example of inserting rows into the table, ignoring invalid rows.
   */
  // [TARGET insert(Iterable, boolean, boolean)]
  // [VARIABLE "rowId1"]
  // [VARIABLE "rowId2"]
  public InsertAllResponse insertWithParams(String rowId1, String rowId2) {
    // [START insertWithParams]
    List<RowToInsert> rows = new ArrayList<>();
    Map<String, Object> row1 = new HashMap<>();
    row1.put("stringField", 1);
    row1.put("booleanField", true);
    Map<String, Object> row2 = new HashMap<>();
    row2.put("stringField", "value2");
    row2.put("booleanField", false);
    rows.add(RowToInsert.of(rowId1, row1));
    rows.add(RowToInsert.of(rowId2, row2));
    InsertAllResponse response = table.insert(rows, true, true);
    // do something with response
    // [END insertWithParams]
    return response;
  }

  /**
   * Example of listing rows in the table.
   */
  // [TARGET list(TableDataListOption...)]
  public Page<List<FieldValue>> list() {
    // [START list]
    Page<List<FieldValue>> page = table.list(TableDataListOption.pageSize(100));
    for (List<FieldValue> row : page.iterateAll()) {
      // do something with the row
    }
    // [END list]
    return page;
  }

  /**
   * Example of copying the table to a destination table.
   */
  // [TARGET copy(String, String, JobOption...)]
  // [VARIABLE "my_dataset"]
  // [VARIABLE "my_destination_table"]
  public Job copy(String datasetName, String tableName) {
    // [START copy]
    Job job = table.copy(datasetName, tableName);
    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(3, TimeUnit.MINUTES));
      if (completedJob != null && completedJob.getStatus().getError() == null) {
        // Job completed successfully
      } else {
        // Handle error case
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait
    }
    // [END copy]
    return job;
  }

  /**
   * Example copying the table to a destination table.
   */
  // [TARGET copy(TableId, JobOption...)]
  // [VARIABLE "my_dataset"]
  // [VARIABLE "my_destination_table"]
  public Job copyTableId(String dataset, String tableName) throws BigQueryException {
    // [START copyTableId]
    TableId destinationId = TableId.of(dataset, tableName);
    JobOption options = JobOption.fields(JobField.STATUS, JobField.USER_EMAIL);
    Job job = table.copy(destinationId, options);
    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(3, TimeUnit.MINUTES));
      if (completedJob != null && completedJob.getStatus().getError() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait
    }
    // [END copyTableId]
    return job;
  }

  /**
   * Example of partitioning data to a list of Google Cloud Storage files.
   */
  // [TARGET extract(String, List, JobOption...)]
  // [VARIABLE "CSV"]
  // [VARIABLE "gs://my_bucket/PartitionA_*.csv"]
  // [VARIABLE "gs://my_bucket/PartitionB_*.csv"]
  public Job extractList(String format, String gcsUrl1, String gcsUrl2) {
    // [START extractList]
    List<String> destinationUris = new ArrayList<>();
    destinationUris.add(gcsUrl1);
    destinationUris.add(gcsUrl2);
    Job job = table.extract(format, destinationUris);
    // Wait for the job to complete
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(3, TimeUnit.MINUTES));
      if (completedJob != null && completedJob.getStatus().getError() == null) {
        // Job completed successfully
      } else {
        // Handle error case
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait
    }
    // [END extractList]
    return job;
  }

  /**
   * Example extracting data to single Google Cloud Storage file.
   */
  // [TARGET extract(String, String, JobOption...)]
  // [VARIABLE "CSV"]
  // [VARIABLE "gs://my_bucket/filename.csv"]
  public Job extractSingle(String format, String gcsUrl) {
    // [START extractSingle]
    Job job = table.extract(format, gcsUrl);
    // Wait for the job to complete
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(3, TimeUnit.MINUTES));
      if (completedJob != null && completedJob.getStatus().getError() == null) {
        // Job completed successfully
      } else {
        // Handle error case
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait
    }
    // [END extractSingle]
    return job;
  }

  /**
   * Example loading data from a list of Google Cloud Storage files.
   */
  // [TARGET load(FormatOptions, List, JobOption...)]
  // [VARIABLE "gs://my_bucket/filename1.csv"]
  // [VARIABLE "gs://my_bucket/filename2.csv"]
  public Job loadList(String gcsUrl1, String gcsUrl2) {
    // [START loadList]
    List<String> sourceUris = new ArrayList<>();
    sourceUris.add(gcsUrl1);
    sourceUris.add(gcsUrl2);
    Job job = table.load(FormatOptions.csv(), sourceUris);
    // Wait for the job to complete
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(3, TimeUnit.MINUTES));
      if (completedJob != null && completedJob.getStatus().getError() == null) {
        // Job completed successfully
      } else {
        // Handle error case
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait
    }
    // [END loadList]
    return job;
  }

  /**
   * Example loading data from a single Google Cloud Storage file.
   */
  // [TARGET load(FormatOptions, String, JobOption...)]
  // [VARIABLE "gs://my_bucket/filename.csv"]
  public Job loadSingle(String sourceUri) {
    // [START loadSingle]
    Job job = table.load(FormatOptions.csv(), sourceUri);
    // Wait for the job to complete
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(3, TimeUnit.MINUTES));
      if (completedJob != null && completedJob.getStatus().getError() == null) {
        // Job completed successfully
      } else {
        // Handle error case
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait
    }
    // [END loadSingle]
    return job;
  }
}
