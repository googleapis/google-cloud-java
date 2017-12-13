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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.QueryResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.JobStatus;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.io.Resources;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class ITBigQuerySnippets {

  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String OTHER_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String QUERY =
      "SELECT unique(corpus) FROM [bigquery-public-data:samples.shakespeare]";
  private static final String QUERY_WITH_PARAMETERS =
      "SELECT distinct(corpus) FROM `bigquery-public-data.samples.shakespeare` where word_count > @wordCount";
  private static final Function<Job, JobId> TO_JOB_ID_FUNCTION = new Function<Job, JobId>() {
    @Override
    public JobId apply(Job job) {
      return job.getJobId();
    }
  };
  private static final Function<Table, TableId> TO_TABLE_ID_FUNCTION =
      new Function<Table, TableId>() {
        @Override
        public TableId apply(Table table) {
          return table.getTableId();
        }
      };
  private static final Function<Dataset, DatasetId> TO_DATASET_ID_FUNCTION =
      new Function<Dataset, DatasetId>() {
        @Override
        public DatasetId apply(Dataset dataset) {
          return dataset.getDatasetId();
        }
      };

  private static BigQuery bigquery;
  private static BigQuerySnippets bigquerySnippets;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    bigquery = RemoteBigQueryHelper.create().getOptions().getService();
    bigquerySnippets = new BigQuerySnippets(bigquery);
    bigquery.create(DatasetInfo.newBuilder(DATASET).build());
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    bigquery.delete(DATASET, DatasetDeleteOption.deleteContents());
    bigquery.delete(OTHER_DATASET, DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testCreateGetAndDeleteTable() throws InterruptedException {
    String tableName = "test_create_get_delete";
    String fieldName = "aField";
    Table table = bigquerySnippets.createTable(DATASET, tableName, fieldName);
    assertNotNull(table);
    TableId tableId = TableId.of(bigquery.getOptions().getProjectId(), DATASET, tableName);
    assertEquals(tableId,
        bigquerySnippets.getTable(tableId.getDataset(), tableId.getTable()).getTableId());
    assertNotNull(bigquerySnippets.updateTable(DATASET, tableName, "new friendly name"));
    assertEquals("new friendly name", bigquerySnippets.getTableFromId(
        tableId.getProject(), tableId.getDataset(), tableId.getTable()).getFriendlyName());
    Set<TableId> tables = Sets.newHashSet(
        Iterators.transform(bigquerySnippets.listTables(DATASET).iterateAll().iterator(),
        TO_TABLE_ID_FUNCTION));
    while (!tables.contains(tableId)) {
      Thread.sleep(500);
      tables = Sets.newHashSet(
          Iterators.transform(bigquerySnippets.listTables(DATASET).iterateAll().iterator(),
              TO_TABLE_ID_FUNCTION));
    }
    tables = Sets.newHashSet(Iterators.transform(
        bigquerySnippets.listTablesFromId(tableId.getProject(), DATASET).iterateAll().iterator(),
        TO_TABLE_ID_FUNCTION));
    while (!tables.contains(tableId)) {
      Thread.sleep(500);
      tables = Sets.newHashSet(Iterators.transform(
          bigquerySnippets.listTablesFromId(tableId.getProject(), DATASET).iterateAll().iterator(),
          TO_TABLE_ID_FUNCTION));
    }
    assertTrue(bigquerySnippets.deleteTable(DATASET, tableName));
    assertFalse(bigquerySnippets.deleteTableFromId(tableId.getProject(), DATASET, tableName));
  }

  @Test
  public void testCreateGetAndDeleteDataset() throws InterruptedException {
    DatasetId datasetId = DatasetId.of(bigquery.getOptions().getProjectId(), OTHER_DATASET);
    Dataset dataset = bigquerySnippets.createDataset(OTHER_DATASET);
    assertNotNull(dataset);
    assertEquals(datasetId, bigquerySnippets.getDataset(OTHER_DATASET).getDatasetId());
    assertNotNull(bigquerySnippets.updateDataset(OTHER_DATASET, "new friendly name"));
    assertEquals("new friendly name",
        bigquerySnippets.getDatasetFromId(datasetId.getProject(), OTHER_DATASET).getFriendlyName());
    Set<DatasetId> datasets = Sets.newHashSet(
        Iterators.transform(bigquerySnippets.listDatasets().iterateAll().iterator(),
            TO_DATASET_ID_FUNCTION));
    while (!datasets.contains(datasetId)) {
      Thread.sleep(500);
      datasets = Sets.newHashSet(
          Iterators.transform(bigquerySnippets.listDatasets().iterateAll().iterator(),
              TO_DATASET_ID_FUNCTION));
    }
    datasets = Sets.newHashSet(
        Iterators.transform(bigquerySnippets.listDatasets(datasetId.getProject()).iterateAll().iterator(),
            TO_DATASET_ID_FUNCTION));
    while (!datasets.contains(datasetId)) {
      Thread.sleep(500);
      datasets = Sets.newHashSet(
          Iterators.transform(bigquerySnippets.listDatasets(datasetId.getProject()).iterateAll().iterator(),
              TO_DATASET_ID_FUNCTION));
    }
    assertTrue(bigquerySnippets.deleteDataset(OTHER_DATASET));
    assertFalse(bigquerySnippets.deleteDatasetFromId(datasetId.getProject(), OTHER_DATASET));
  }

  @Test
  public void testWriteAndListTableData()
      throws IOException, InterruptedException, TimeoutException, URISyntaxException {
    // Create table
    String tableName = "test_write_and_list_table_data";
    String fieldName = "string_field";
    assertNotNull(bigquerySnippets.createTable(DATASET, tableName, fieldName));
    // Add rows from string
    long outputRows =
        bigquerySnippets.writeToTable(DATASET, tableName, "StringValue1\nStringValue2\n");
    assertEquals(2L, outputRows);
    // Add rows from file
    Path csvPath =
        Paths.get(Resources.getResource("bigquery/test_write_and_list_table_data.csv").toURI());
    outputRows = bigquerySnippets.writeFileToTable(DATASET, tableName, csvPath);
    assertEquals(2L, outputRows);
    // List all rows
    Page<FieldValueList> listPage = bigquerySnippets.listTableData(DATASET, tableName);
    Iterator<FieldValueList> rowIterator = listPage.getValues().iterator();
    assertEquals("StringValue1", rowIterator.next().get(0).getStringValue());
    assertEquals("StringValue2", rowIterator.next().get(0).getStringValue());
    assertEquals("StringValue3", rowIterator.next().get(0).getStringValue());
    assertEquals("StringValue4", rowIterator.next().get(0).getStringValue());
    assertTrue(bigquerySnippets.deleteTable(DATASET, tableName));
  }

  @Test
  public void testInsertAllAndListTableData() throws IOException, InterruptedException {
    String tableName = "test_insert_all_and_list_table_data";
    String fieldName1 = "booleanField";
    String fieldName2 = "bytesField";
    String fieldName3 = "recordField";
    String fieldName4 = "stringField";
    TableId tableId = TableId.of(DATASET, tableName);
    Schema schema =
        Schema.of(
            Field.of(fieldName1, LegacySQLTypeName.BOOLEAN),
            Field.of(fieldName2, LegacySQLTypeName.BYTES),
            Field.of(fieldName3, LegacySQLTypeName.RECORD,
                Field.of(fieldName4, LegacySQLTypeName.STRING)));
    TableInfo table = TableInfo.of(tableId, StandardTableDefinition.of(schema));
    assertNotNull(bigquery.create(table));
    InsertAllResponse response = bigquerySnippets.insertAll(DATASET, tableName);
    assertFalse(response.hasErrors());
    assertTrue(response.getInsertErrors().isEmpty());
    Page<FieldValueList> listPage = bigquerySnippets.listTableDataFromId(DATASET, tableName);
    while (Iterators.size(listPage.iterateAll().iterator()) < 1) {
      Thread.sleep(500);
      listPage = bigquerySnippets.listTableDataFromId(DATASET, tableName);
    }
    FieldValueList row = listPage.getValues().iterator().next();
    assertEquals(true, row.get(0).getBooleanValue());
    assertArrayEquals(new byte[]{0xA, 0xD, 0xD, 0xE, 0xD}, row.get(1).getBytesValue());
    assertEquals("Hello, World!", row.get(2).getRecordValue().get(0).getStringValue());
    assertTrue(bigquerySnippets.deleteTable(DATASET, tableName));
  }

  @Test
  public void testJob() throws ExecutionException, InterruptedException {
    Job job1 = bigquerySnippets.createJob(QUERY);
    Job job2 = bigquerySnippets.createJob(QUERY);
    assertNotNull(job1);
    assertNotNull(job2);
    assertEquals(job1.getJobId(), bigquerySnippets.getJob(job1.getJobId().getJob()).getJobId());
    assertEquals(job2.getJobId(),
        bigquerySnippets.getJobFromId(job2.getJobId().getJob()).getJobId());
    Set<JobId> jobs = Sets.newHashSet(Iterators.transform(bigquerySnippets.listJobs().iterateAll().iterator(),
        TO_JOB_ID_FUNCTION));
    while (!jobs.contains(job1.getJobId()) || !jobs.contains(job2.getJobId())) {
      Thread.sleep(500);
      jobs = Sets.newHashSet(Iterators.transform(bigquerySnippets.listJobs().iterateAll().iterator(),
          TO_JOB_ID_FUNCTION));
    }
    assertTrue(bigquerySnippets.cancelJob(job1.getJobId().getJob()));
    assertTrue(bigquerySnippets.cancelJobFromId(job2.getJobId().getJob()));
  }

  @Test
  public void testRunQuery() throws InterruptedException {
    bigquerySnippets.runQuery(QUERY);
  }

  @Test
  public void testRunQueryWithParameters() throws InterruptedException {
    bigquerySnippets.runQueryWithParameters(QUERY_WITH_PARAMETERS);
  }
}
