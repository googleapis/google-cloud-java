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
 * This file is referenced in BigQuery's javadoc. Any change to this file should be reflected in
 * BigQuery's javadoc.
 */

package com.google.cloud.examples.bigquery.snippets;

import com.google.api.client.util.Charsets;
import com.google.api.services.bigquery.model.JobStatistics;
import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.JobListOption;
import com.google.cloud.bigquery.BigQuery.TableDataListOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobConfiguration;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryRequest;
import com.google.cloud.bigquery.QueryResponse;
import com.google.cloud.bigquery.QueryResult;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeoutException;

/**
 * This class contains a number of snippets for the {@link BigQuery} interface.
 */
public class BigQuerySnippets {

  private final BigQuery bigquery;

  public BigQuerySnippets(BigQuery bigquery) {
    this.bigquery = bigquery;
  }

  /**
   * Example of creating a dataset.
   */
  // [TARGET create(DatasetInfo, DatasetOption...)]
  // [VARIABLE "my_dataset_name"]
  public Dataset createDataset(String datasetName) {
    // [START createDataset]
    Dataset dataset = null;
    DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
    try {
      // the dataset was created
      dataset = bigquery.create(datasetInfo);
    } catch (BigQueryException e) {
      // the dataset was not created
    }
    // [END createDataset]
    return dataset;
  }

  /**
   * Example of updating a dataset by changing its friendly name.
   */
  // [TARGET update(DatasetInfo, DatasetOption...)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "some_new_friendly_name"]
  public Dataset updateDataset(String datasetName, String newFriendlyName) {
    // [START updateDataset]
    Dataset oldDataset = bigquery.getDataset(datasetName);
    DatasetInfo datasetInfo = oldDataset.toBuilder().setFriendlyName(newFriendlyName).build();
    Dataset newDataset = bigquery.update(datasetInfo);
    // [END updateDataset]
    return newDataset;
  }

  /**
   * Example of updating a table by changing its friendly name.
   */
  // [TARGET update(TableInfo, TableOption...)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  // [VARIABLE "new_friendly_name"]
  public Table updateTable(String datasetName, String tableName, String newFriendlyName) {
    // [START updateTable]
    Table oldTable = bigquery.getTable(datasetName, tableName);
    TableInfo tableInfo = oldTable.toBuilder().setFriendlyName(newFriendlyName).build();
    Table newTable = bigquery.update(tableInfo);
    // [END updateTable]
    return newTable;
  }

  /**
   * Example of listing datasets, specifying the page size.
   */
  // [TARGET listDatasets(DatasetListOption...)]
  public Page<Dataset> listDatasets() {
    // [START listDatasets]
    Page<Dataset> datasets = bigquery.listDatasets(DatasetListOption.pageSize(100));
    Iterator<Dataset> datasetIterator = datasets.iterateAll();
    while (datasetIterator.hasNext()) {
      Dataset dataset = datasetIterator.next();
      // do something with the dataset
    }
    // [END listDatasets]
    return datasets;
  }

  /**
   * Example of listing datasets in a project, specifying the page size.
   */
  // [TARGET listDatasets(String, DatasetListOption...)]
  // [VARIABLE "my_project_id"]
  public Page<Dataset> listDatasets(String projectId) {
    // [START listDatasets]
    Page<Dataset> datasets = bigquery.listDatasets(projectId, DatasetListOption.pageSize(100));
    Iterator<Dataset> datasetIterator = datasets.iterateAll();
    while (datasetIterator.hasNext()) {
      Dataset dataset = datasetIterator.next();
      // do something with the dataset
    }
    // [END listDatasets]
    return datasets;
  }

  /**
   * Example of deleting a dataset from its id, even if non-empty.
   */
  // [TARGET delete(String, DatasetDeleteOption...)]
  // [VARIABLE "my_dataset_name"]
  public Boolean deleteDataset(String datasetName) {
    // [START deleteDataset]
    Boolean deleted = bigquery.delete(datasetName, DatasetDeleteOption.deleteContents());
    if (deleted) {
      // the dataset was deleted
    } else {
      // the dataset was not found
    }
    // [END deleteDataset]
    return deleted;
  }

  /**
   * Example of deleting a dataset, even if non-empty.
   */
  // [TARGET delete(DatasetId, DatasetDeleteOption...)]
  // [VARIABLE "my_project_id"]
  // [VARIABLE "my_dataset_name"]
  public Boolean deleteDatasetFromId(String projectId, String datasetName) {
    // [START deleteDatasetFromId]
    DatasetId datasetId = DatasetId.of(projectId, datasetName);
    Boolean deleted = bigquery.delete(datasetId, DatasetDeleteOption.deleteContents());
    if (deleted) {
      // the dataset was deleted
    } else {
      // the dataset was not found
    }
    // [END deleteDatasetFromId]
    return deleted;
  }

  /**
   * Example of deleting a table.
   */
  // [TARGET delete(String, String)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public Boolean deleteTable(String datasetName, String tableName) {
    // [START deleteTable]
    Boolean deleted = bigquery.delete(datasetName, tableName);
    if (deleted) {
      // the table was deleted
    } else {
      // the table was not found
    }
    // [END deleteTable]
    return deleted;
  }

  /**
   * Example of deleting a table.
   */
  // [TARGET delete(TableId)]
  // [VARIABLE "my_project_id"]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public Boolean deleteTableFromId(String projectId, String datasetName, String tableName) {
    // [START deleteTableFromId]
    TableId tableId = TableId.of(projectId, datasetName, tableName);
    Boolean deleted = bigquery.delete(tableId);
    if (deleted) {
      // the table was deleted
    } else {
      // the table was not found
    }
    // [END deleteTableFromId]
    return deleted;
  }

  /**
   * Example of listing the tables in a dataset, specifying the page size.
   */
  // [TARGET listTables(String, TableListOption...)]
  // [VARIABLE "my_dataset_name"]
  public Page<Table> listTables(String datasetName) {
    // [START listTables]
    Page<Table> tables = bigquery.listTables(datasetName, TableListOption.pageSize(100));
    Iterator<Table> tableIterator = tables.iterateAll();
    while (tableIterator.hasNext()) {
      Table table = tableIterator.next();
      // do something with the table
    }
    // [END listTables]
    return tables;
  }


  /**
   * Example of listing the tables in a dataset.
   */
  // [TARGET listTables(DatasetId, TableListOption...)]
  // [VARIABLE "my_project_id"]
  // [VARIABLE "my_dataset_name"]
  public Page<Table> listTablesFromId(String projectId, String datasetName) {
    // [START listTablesFromId]
    DatasetId datasetId = DatasetId.of(projectId, datasetName);
    Page<Table> tables = bigquery.listTables(datasetId, TableListOption.pageSize(100));
    Iterator<Table> tableIterator = tables.iterateAll();
    while (tableIterator.hasNext()) {
      Table table = tableIterator.next();
      // do something with the table
    }
    // [END listTablesFromId]
    return tables;
  }

  /**
   * Example of getting a dataset.
   */
  // [TARGET getDataset(String, DatasetOption...)]
  // [VARIABLE "my_dataset"]
  public Dataset getDataset(String datasetName) {
    // [START getDataset]
    Dataset dataset = bigquery.getDataset(datasetName);
    // [END getDataset]
    return dataset;
  }

  /**
   * Example of getting a dataset.
   */
  // [TARGET getDataset(DatasetId, DatasetOption...)]
  // [VARIABLE "my_project_id"]
  // [VARIABLE "my_dataset_name"]
  public Dataset getDatasetFromId(String projectId, String datasetName) {
    // [START getDatasetFromId]
    DatasetId datasetId = DatasetId.of(projectId, datasetName);
    Dataset dataset = bigquery.getDataset(datasetId);
    // [END getDatasetFromId]
    return dataset;
  }

  /**
   * Example of getting a table.
   */
  // [TARGET getTable(String, String, TableOption...)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public Table getTable(String datasetName, String tableName) {
    // [START getTable]
    Table table = bigquery.getTable(datasetName, tableName);
    // [END getTable]
    return table;
  }

  /**
   * Example of getting a table.
   */
  // [TARGET getTable(TableId, TableOption...)]
  // [VARIABLE "my_project_id"]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public Table getTableFromId(String projectId, String datasetName, String tableName) {
    // [START getTableFromId]
    TableId tableId = TableId.of(projectId, datasetName, tableName);
    Table table = bigquery.getTable(tableId);
    // [END getTableFromId]
    return table;
  }

  /**
   * Example of creating a channel with which to write to a table.
   */
  // [TARGET writer(WriteChannelConfiguration)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  // [VARIABLE "StringValue1\nStringValue2\n"]
  public long writeToTable(String datasetName, String tableName, String csvData)
      throws IOException, InterruptedException, TimeoutException {
    // [START writeToTable]
    TableId tableId = TableId.of(datasetName, tableName);
    WriteChannelConfiguration writeChannelConfiguration =
        WriteChannelConfiguration.newBuilder(tableId)
            .setFormatOptions(FormatOptions.csv())
            .build();
    TableDataWriteChannel writer = bigquery.writer(writeChannelConfiguration);
      // Write data to writer
     try {
        writer.write(ByteBuffer.wrap(csvData.getBytes(Charsets.UTF_8)));
      } finally {
        writer.close();
      }
      // Get load job
      Job job = writer.getJob();
      job = job.waitFor();
      LoadStatistics stats = job.getStatistics();
      return stats.getOutputRows();
      // [END writeToTable]
    }

  /**
   * Example of writing a local file to a table.
   */
  // [TARGET writer(WriteChannelConfiguration)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  // [VARIABLE Files.newByteChannel(FileSystems.getDefault().getPath(".", "my-data.csv"))]
  public long writeFileToTable(String datasetName, String tableName, ReadableByteChannel csvReader)
      throws IOException, InterruptedException, TimeoutException {
    // [START writeFileToTable]
    TableId tableId = TableId.of(datasetName, tableName);
    WriteChannelConfiguration writeChannelConfiguration =
        WriteChannelConfiguration.newBuilder(tableId)
            .setFormatOptions(FormatOptions.csv())
            .build();
    TableDataWriteChannel writer = bigquery.writer(writeChannelConfiguration);
    // Write data to writer
    try {
      ByteStreams.copy(csvReader, writer);
    } finally {
      writer.close();
    }
    // Get load job
    Job job = writer.getJob();
    job = job.waitFor();
    LoadStatistics stats = job.getStatistics();
    return stats.getOutputRows();
    // [END writeFileToTable]
  }

  /**
   * Example of inserting rows into a table without running a load job.
   */
  // [TARGET insertAll(InsertAllRequest)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public InsertAllResponse insertAll(String datasetName, String tableName) {
    // [START insertAll]
    TableId tableId = TableId.of(datasetName, tableName);
    // Values of the row to insert
    Map<String, Object> rowContent = new HashMap<>();
    rowContent.put("booleanField", true);
    // Bytes are passed in base64
    rowContent.put("bytesField", "DQ4KDQ==");
    InsertAllResponse response = bigquery.insertAll(InsertAllRequest.newBuilder(tableId)
        .addRow("rowId", rowContent)
        // More rows can be added in the same RPC by invoking .addRow() on the builder
        .build());
    if (response.hasErrors()) {
      // If any of the insertions failed, this lets you inspect the errors
      for (Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
        // inspect row error
      }
    }
    // [END insertAll]
    return response;
  }

  /**
   * Example of creating a table.
   */
  // [TARGET create(TableInfo, TableOption...)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  // [VARIABLE "string_field"]
  public Table createTable(String datasetName, String tableName, String fieldName) {
    // [START createTable]
    TableId tableId = TableId.of(datasetName, tableName);
    // Table field definition
    Field field = Field.of(fieldName, Field.Type.string());
    // Table schema definition
    Schema schema = Schema.of(field);
    TableDefinition tableDefinition = StandardTableDefinition.of(schema);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
    Table table = bigquery.create(tableInfo);
    // [END createTable]
    return table;
  }

  /**
   * Example of listing table rows, specifying the page size.
   */
  // [TARGET listTableData(String, String, TableDataListOption...)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public Page<List<FieldValue>> listTableData(String datasetName, String tableName) {
    // [START listTableData]
    Page<List<FieldValue>> tableData =
        bigquery.listTableData(datasetName, tableName, TableDataListOption.pageSize(100));
    Iterator<List<FieldValue>> rowIterator = tableData.iterateAll();
    while (rowIterator.hasNext()) {
      List<FieldValue> row = rowIterator.next();
      // do something with the row
    }
    // [END listTableData]
    return tableData;
  }

  /**
   * Example of listing table rows, specifying the page size.
   */
  // [TARGET listTableData(TableId, TableDataListOption...)]
  // [VARIABLE "my_dataset_name"]
  // [VARIABLE "my_table_name"]
  public Page<List<FieldValue>> listTableDataFromId(String datasetName, String tableName) {
    // [START listTableDataFromId]
    TableId tableIdObject = TableId.of(datasetName, tableName);
    Page<List<FieldValue>> tableData =
        bigquery.listTableData(tableIdObject, TableDataListOption.pageSize(100));
    Iterator<List<FieldValue>> rowIterator = tableData.iterateAll();
    while (rowIterator.hasNext()) {
      List<FieldValue> row = rowIterator.next();
      // do something with the row
    }
    // [END listTableDataFromId]
    return tableData;
  }

  /**
   * Example of creating a query job.
   */
  // [TARGET create(JobInfo, JobOption...)]
  // [VARIABLE "SELECT field FROM my_dataset_name.my_table_name"]
  public Job createJob(String query) {
    // [START createJob]
    Job job = null;
    JobConfiguration jobConfiguration = QueryJobConfiguration.of(query);
    JobInfo jobInfo = JobInfo.of(jobConfiguration);
    try {
      job = bigquery.create(jobInfo);
    } catch (BigQueryException e) {
      // the job was not created
    }
    // [END createJob]
    return job;
  }

  /**
   * Example of listing jobs, specifying the page size.
   */
  // [TARGET listJobs(JobListOption...)]
  public Page<Job> listJobs() {
    // [START listJobs]
    Page<Job> jobs = bigquery.listJobs(JobListOption.pageSize(100));
    Iterator<Job> jobIterator = jobs.iterateAll();
    while (jobIterator.hasNext()) {
      Job job = jobIterator.next();
      // do something with the job
    }
    // [END listJobs]
    return jobs;
  }

  /**
   * Example of getting a job.
   */
  // [TARGET getJob(String, JobOption...)]
  // [VARIABLE "my_job_name"]
  public Job getJob(String jobName) {
    // [START getJob]
    Job job = bigquery.getJob(jobName);
    if (job == null) {
      // job was not found
    }
    // [END getJob]
    return job;
  }

  /**
   * Example of getting a job.
   */
  // [TARGET getJob(JobId, JobOption...)]
  // [VARIABLE "my_job_name"]
  public Job getJobFromId(String jobName) {
    // [START getJobFromId]
    JobId jobIdObject = JobId.of(jobName);
    Job job = bigquery.getJob(jobIdObject);
    if (job == null) {
      // job was not found
    }
    // [END getJobFromId]
    return job;
  }


  /**
   * Example of cancelling a job.
   */
  // [TARGET cancel(String)]
  // [VARIABLE "my_job_name"]
  public boolean cancelJob(String jobName) {
    // [START cancelJob]
    boolean success = bigquery.cancel(jobName);
    if (success) {
      // job was cancelled
    } else {
      // job was not found
    }
    // [END cancelJob]
    return success;
  }

  /**
   * Example of cancelling a job.
   */
  // [TARGET cancel(JobId)]
  // [VARIABLE "my_job_name"]
  public boolean cancelJobFromId(String jobName) {
    // [START cancelJobFromId]
    JobId jobId = JobId.of(jobName);
    boolean success = bigquery.cancel(jobId);
    if (success) {
      // job was cancelled
    } else {
      // job was not found
    }
    // [END cancelJobFromId]
    return success;
  }

  /**
   * Example of running a query.
   */
  // [TARGET query(QueryRequest)]
  // [VARIABLE "SELECT unique(corpus) FROM [bigquery-public-data:samples.shakespeare]"]
  public QueryResponse runQuery(String query) throws InterruptedException {
    // [START runQuery]
    QueryRequest request = QueryRequest.of(query);
    QueryResponse response = bigquery.query(request);
    // Wait for things to finish
    while (!response.jobCompleted()) {
      Thread.sleep(1000);
      response = bigquery.getQueryResults(response.getJobId());
    }
    if (response.hasErrors()) {
      // handle errors
    }
    QueryResult result = response.getResult();
    Iterator<List<FieldValue>> rowIterator = result.iterateAll();
    while (rowIterator.hasNext()) {
      List<FieldValue> row = rowIterator.next();
      // do something with the data
    }
    // [END runQuery]
    return response;
  }

  /**
   * Example of getting the results of query.
   */
  // [TARGET getQueryResults(JobId, QueryResultsOption...)]
  // [VARIABLE "SELECT unique(corpus) FROM [bigquery-public-data:samples.shakespeare]"]
  public QueryResponse queryResults(final String query) throws InterruptedException {
    // [START queryResults]
    QueryRequest request = QueryRequest.of(query);
    QueryResponse response = bigquery.query(request);
    // Wait for things to finish
    while (!response.jobCompleted()) {
      Thread.sleep(1000);
      response = bigquery.getQueryResults(response.getJobId());
    }
    if (response.hasErrors()) {
      // handle errors
    }
    QueryResult result = response.getResult();
    Iterator<List<FieldValue>> rowIterator = result.iterateAll();
    while (rowIterator.hasNext()) {
      List<FieldValue> row = rowIterator.next();
      // do something with the data
    }
    // [END queryResults]
    return response;
  }
}
