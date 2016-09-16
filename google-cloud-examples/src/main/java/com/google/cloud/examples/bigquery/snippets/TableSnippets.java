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

package com.google.cloud.examples.bigquery.snippets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.cloud.Page;
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Table’s javadoc. Any change to this file should be reflected in
 * Table’s javadoc.
 */
public class TableSnippets {
  private final Table table;

  public TableSnippets(Table table) {
    this.table = table;
  }

  /**
   * Example of ensuring that a table exists.
   */
  // [TARGET exists()]
  public void checkExists() {
    // [START checkExists]
    if (!table.exists()) {
      throw new IllegalArgumentException("Table does not exist.");
    }
    // [END checkExists]
  }

  /**
   * Example of fetching a table's latest information, specifying particular table field options.
   */
  // [TARGET reload(TableOption...)]
  // [VARIABLE TableField.LAST_MODIFIED_TIME]
  // [VARIABLE TableField.NUM_ROWS]
  public Table reloadTableWithFields(TableField field1, TableField field2) {
    // [START reloadTableWithFields]
    Table reloaded = table.reload(TableOption.fields(field1, field2));
    // [END reloadTableWithFields]
    return reloaded;
  }

  /**
   * Example of updating a table's information, specifying particular table field options.
   */
  // [TARGET update(TableOption...)]
  // [VARIABLE TableField.LAST_MODIFIED_TIME]
  // [VARIABLE TableField.NUM_ROWS]
  public Table updateTableWithFields(TableField field1, TableField field2) {
    // [START updateTableWithFields]
    Table updated = table.update(TableOption.fields(field1, field2));
    // [END updateTableWithFields]
    return updated;
  }

  /**
   * Example of deleting a table.
   */
  // [TARGET delete()]
  public void delete() {
    // [START delete]
    table.delete();
    // [END delete]
  }

  /**
   * Example of inserting rows into a table.
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
   * Example of inserting rows into a table which ignores invalid rows.
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
   * Example of getting a paginated list of rows in a table.
   */
  // [TARGET list(TableDataListOption...)]
  public Page<List<FieldValue>> list() {
    // [START list]
    Page<List<FieldValue>> page = table.list(TableDataListOption.pageSize(100));
    // do something with page
    // [END list]
    return page;
  }

  /**
   * Example of copying a table to a destination table and dataset referenced by name.
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
          WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob != null && completedJob.status().error() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait.
    }

    // [END copy]
    return job;
  }

  /**
   * Example copying a table to a destination table referenced by table ID.
   */
  // [TARGET copy(TableId, JobOption...)]
  // [VARIABLE "my_dataset"]
  // [VARIABLE "copy_destination"]
  public Job copyTableId(String dataset, String tableName) throws BigQueryException {
    // [START copyTableId]
    TableId destinationId = TableId.of(dataset, tableName);
    JobOption options = JobOption.fields(JobField.STATUS, JobField.USER_EMAIL);

    Job job = table.copy(destinationId, options);

    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob != null && completedJob.status().error() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait.
    }
    // [END copyTableId]
    return job;
  }

  /**
   * Example extracting data to a list of Google Cloud Storage files.
   */
  // [TARGET extract(String, List, JobOption...)]
  // [VARIABLE "CSV"]
  // [VARIABLE "gs://myapp.appspot.com/PartitionA_*.csv"]
  // [VARIABLE "gs://myapp.appspot.com/PartitionB_*.csv"]
  public Job extractList(String format, String gcsUrl1, String gcsUrl2) {
    // [START extractList]
    List<String> destinationUris = new ArrayList<>();
    destinationUris.add(gcsUrl1);
    destinationUris.add(gcsUrl2);

    Job job = table.extract(format, destinationUris);

    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob != null && completedJob.status().error() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait.
    }
    // [END extractList]
    return job;
  }

  /**
   * Example extracting data to single Google Cloud Storage file.
   */
  // [TARGET extract(String, String, JobOption...)]
  // [VARIABLE "CSV"]
  // [VARIABLE "gs://myapp.appspot.com/filename.csv"]
  public Job extractSingle(String format, String gcsUrl) {
    // [START extractSingle]
    Job job = table.extract(format, gcsUrl);

    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob != null && completedJob.status().error() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait.
    }
    // [END extractSingle]
    return job;
  }

  /**
   * Example loading data from a list of Google Cloud Storage files.
   */
  // [TARGET load(FormatOptions, List, JobOption...)]
  // [VARIABLE "gs://myapp.appspot.com/PartitionA_000000000000.csv"]
  // [VARIABLE "gs://myapp.appspot.com/PartitionB_000000000000.csv"]
  public Job loadList(String gcsUrl1, String gcsUrl2) {
    // [START loadList]
    List<String> sourceUris = new ArrayList<>();
    sourceUris.add(gcsUrl1);
    sourceUris.add(gcsUrl2);

    Job job = table.load(FormatOptions.csv(), sourceUris);

    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob != null && completedJob.status().error() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait.
    }
    // [END loadList]
    return job;
  }

  /**
   * Example loading data from a single Google Cloud Storage file.
   */
  // [TARGET load(FormatOptions, String, JobOption...)]
  // [VARIABLE "gs://myapp.appspot.com/filename.csv"]
  public Job loadSingle(String sourceUri) {
    // [START loadSingle]
    Job job = table.load(FormatOptions.csv(), sourceUri);

    // Wait for the job to complete.
    try {
      Job completedJob = job.waitFor(WaitForOption.checkEvery(1, TimeUnit.SECONDS),
          WaitForOption.timeout(60, TimeUnit.SECONDS));
      if (completedJob != null && completedJob.status().error() == null) {
        // Job completed successfully.
      } else {
        // Handle error case.
      }
    } catch (InterruptedException | TimeoutException e) {
      // Handle interrupted wait.
    }
    // [END loadSingle]
    return job;
  }
}
