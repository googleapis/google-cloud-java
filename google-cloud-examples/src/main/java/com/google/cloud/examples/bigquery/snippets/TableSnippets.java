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

import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery.JobField;
import com.google.cloud.bigquery.BigQuery.JobOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * Example of inserting rows into a table.
   */
  // [TARGET insert(Iterable<InsertAllRequest.RowToInsert>)]
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
  // [TARGET insert(Iterable<InsertAllRequest.RowToInsert>, boolean, boolean)]
  // [VARIABLE "rowId1"]
  // [VARIABLE "rowId2"]
  public InsertAllResponse insertWithParams(String rowId1, String rowId2) {
    // [START insertWithParams]
    List<RowToInsert> rows = new ArrayList<>();
    Map<String, Object> row1 = new HashMap<>();
    row1.put("stringField", "value1");
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
  // [TARGET list(BigQuery.TableDataListOption...)]
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
  // [TARGET copy(String, String, BigQuery.JobOption...)]
  // [VARIABLE "my_dataset"]
  // [VARIABLE "my_destination_table"]
  public Job copy(String datasetName, String tableName) {
    // [START copy]
    Job job = table.copy(datasetName, tableName);
    // do something with job
    // [END copy]
    return job;
  }

  /**
   * Example copying a table to a destination table referenced by table ID.
   */
  // [TARGET copy(TableId, JobOption...)]
  public Job copy(TableId destinationTable) throws BigQueryException {
    // [START copy-tableid]
    // Only copy the Status and User Email fields.
    JobOption options = JobOption.fields(JobField.STATUS, JobField.USER_EMAIL);
    Job job = table.copy(destinationTable, options);
    // do something with job
    // [END copy-tableid]
    return job;
  }
}