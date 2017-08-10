/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery.it;

import static com.google.cloud.bigquery.JobStatus.State.DONE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.paging.Page;
import com.google.cloud.WaitForOption;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetField;
import com.google.cloud.bigquery.BigQuery.DatasetOption;
import com.google.cloud.bigquery.BigQuery.JobField;
import com.google.cloud.bigquery.BigQuery.JobListOption;
import com.google.cloud.bigquery.BigQuery.JobOption;
import com.google.cloud.bigquery.BigQuery.TableField;
import com.google.cloud.bigquery.BigQuery.TableOption;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.ExtractJobConfiguration;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.QueryRequest;
import com.google.cloud.bigquery.QueryResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TimePartitioning;
import com.google.cloud.bigquery.TimePartitioning.Type;
import com.google.cloud.bigquery.ViewDefinition;
import com.google.cloud.bigquery.WriteChannelConfiguration;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITBigQueryTest {

  private static final byte[] BYTES = {0xD, 0xE, 0xA, 0xD};
  private static final String BYTES_BASE64 = BaseEncoding.base64().encode(BYTES);
  private static final Logger LOG = Logger.getLogger(ITBigQueryTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String DESCRIPTION = "Test dataset";
  private static final String OTHER_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final Map<String, String> LABELS = ImmutableMap.of(
      "example-label1", "example-value1",
      "example-label2", "example-value2");
  private static final Field TIMESTAMP_FIELD_SCHEMA =
      Field.newBuilder("TimestampField", Field.Type.timestamp())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("TimestampDescription")
          .build();
  private static final Field STRING_FIELD_SCHEMA =
      Field.newBuilder("StringField", Field.Type.string())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("StringDescription")
          .build();
  private static final Field INTEGER_ARRAY_FIELD_SCHEMA =
      Field.newBuilder("IntegerArrayField", Field.Type.integer())
          .setMode(Field.Mode.REPEATED)
          .setDescription("IntegerArrayDescription")
          .build();
  private static final Field BOOLEAN_FIELD_SCHEMA =
      Field.newBuilder("BooleanField", Field.Type.bool())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BooleanDescription")
          .build();
  private static final Field BYTES_FIELD_SCHEMA =
      Field.newBuilder("BytesField", Field.Type.bytes())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("BytesDescription")
          .build();
  private static final Field RECORD_FIELD_SCHEMA =
      Field.newBuilder("RecordField", Field.Type.record(TIMESTAMP_FIELD_SCHEMA,
          STRING_FIELD_SCHEMA, INTEGER_ARRAY_FIELD_SCHEMA, BOOLEAN_FIELD_SCHEMA,
          BYTES_FIELD_SCHEMA))
          .setMode(Field.Mode.REQUIRED)
          .setDescription("RecordDescription")
          .build();
  private static final Field INTEGER_FIELD_SCHEMA =
      Field.newBuilder("IntegerField", Field.Type.integer())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("IntegerDescription")
          .build();
  private static final Field FLOAT_FIELD_SCHEMA =
      Field.newBuilder("FloatField", Field.Type.floatingPoint())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FloatDescription")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(TIMESTAMP_FIELD_SCHEMA, STRING_FIELD_SCHEMA,
      INTEGER_ARRAY_FIELD_SCHEMA, BOOLEAN_FIELD_SCHEMA, BYTES_FIELD_SCHEMA, RECORD_FIELD_SCHEMA,
      INTEGER_FIELD_SCHEMA, FLOAT_FIELD_SCHEMA);
  private static final Schema SIMPLE_SCHEMA = Schema.of(STRING_FIELD_SCHEMA);
  private static final Schema QUERY_RESULT_SCHEMA = Schema.newBuilder()
      .addField(Field.newBuilder("TimestampField", Field.Type.timestamp())
          .setMode(Field.Mode.NULLABLE)
          .build())
      .addField(Field.newBuilder("StringField", Field.Type.string())
          .setMode(Field.Mode.NULLABLE)
          .build())
      .addField(Field.newBuilder("BooleanField", Field.Type.bool())
          .setMode(Field.Mode.NULLABLE)
          .build())
      .build();
  private static final String LOAD_FILE = "load.csv";
  private static final String JSON_LOAD_FILE = "load.json";
  private static final String EXTRACT_FILE = "extract.csv";
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final TableId TABLE_ID = TableId.of(DATASET, "testing_table");
  private static final String CSV_CONTENT = "StringValue1\nStringValue2\n";
  private static final String JSON_CONTENT = "{"
      + "  \"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
      + "  \"StringField\": \"stringValue\","
      + "  \"IntegerArrayField\": [\"0\", \"1\"],"
      + "  \"BooleanField\": \"false\","
      + "  \"BytesField\": \"" + BYTES_BASE64 + "\","
      + "  \"RecordField\": {"
      + "    \"TimestampField\": \"1969-07-20 20:18:04 UTC\","
      + "    \"StringField\": null,"
      + "    \"IntegerArrayField\": [\"1\",\"0\"],"
      + "    \"BooleanField\": \"true\","
      + "    \"BytesField\": \"" + BYTES_BASE64 + "\""
      + "  },"
      + "  \"IntegerField\": \"3\","
      + "  \"FloatField\": \"1.2\""
      + "}\n"
      + "{"
      + "  \"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
      + "  \"StringField\": \"stringValue\","
      + "  \"IntegerArrayField\": [\"0\", \"1\"],"
      + "  \"BooleanField\": \"false\","
      + "  \"BytesField\": \"" + BYTES_BASE64 + "\","
      + "  \"RecordField\": {"
      + "    \"TimestampField\": \"1969-07-20 20:18:04 UTC\","
      + "    \"StringField\": null,"
      + "    \"IntegerArrayField\": [\"1\",\"0\"],"
      + "    \"BooleanField\": \"true\","
      + "    \"BytesField\": \"" + BYTES_BASE64 + "\""
      + "  },"
      + "  \"IntegerField\": \"3\","
      + "  \"FloatField\": \"1.2\""
      + "}";

  private static final Set<String> PUBLIC_DATASETS = ImmutableSet.of("github_repos", "hacker_news",
      "noaa_gsod", "samples", "usa_names");

  private static BigQuery bigquery;
  private static Storage storage;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() throws InterruptedException, TimeoutException {
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    RemoteStorageHelper storageHelper = RemoteStorageHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    storage = storageHelper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
    storage.create(BlobInfo.newBuilder(BUCKET, LOAD_FILE).setContentType("text/plain").build(),
        CSV_CONTENT.getBytes(StandardCharsets.UTF_8));
    storage.create(BlobInfo.newBuilder(BUCKET, JSON_LOAD_FILE)
            .setContentType("application/json")
            .build(),
        JSON_CONTENT.getBytes(StandardCharsets.UTF_8));
    DatasetInfo info = DatasetInfo.newBuilder(DATASET)
        .setDescription(DESCRIPTION)
        .setLabels(LABELS)
        .build();
    bigquery.create(info);
    LoadJobConfiguration configuration = LoadJobConfiguration.newBuilder(
            TABLE_ID, "gs://" + BUCKET + "/" + JSON_LOAD_FILE, FormatOptions.json())
        .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
        .setSchema(TABLE_SCHEMA)
        .build();
    Job job = bigquery.create(JobInfo.of(configuration));
    job = job.waitFor();
    assertNull(job.getStatus().getError());
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
    }
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 10, TimeUnit.SECONDS);
      if (!wasDeleted && LOG.isLoggable(Level.WARNING)) {
        LOG.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void testListDatasets() {
    Page<Dataset> datasets = bigquery.listDatasets("bigquery-public-data");
    Iterator<Dataset> iterator = datasets.iterateAll().iterator();
    Set<String> datasetNames = new HashSet<>();
    while (iterator.hasNext()) {
      datasetNames.add(iterator.next().getDatasetId().getDataset());
    }
    for (String type : PUBLIC_DATASETS) {
      assertTrue(datasetNames.contains(type));
    }
  }

  @Test
  public void testGetDataset() {
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(DATASET, dataset.getDatasetId().getDataset());
    assertEquals(DESCRIPTION, dataset.getDescription());
    assertEquals(LABELS, dataset.getLabels());
    assertNotNull(dataset.getAcl());
    assertNotNull(dataset.getEtag());
    assertNotNull(dataset.getGeneratedId());
    assertNotNull(dataset.getLastModified());
    assertNotNull(dataset.getSelfLink());
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    Dataset dataset = bigquery.getDataset(DATASET,
        DatasetOption.fields(DatasetField.CREATION_TIME, DatasetField.LABELS));
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(DATASET, dataset.getDatasetId().getDataset());
    assertEquals(LABELS, dataset.getLabels());
    assertNotNull(dataset.getCreationTime());
    assertNull(dataset.getDescription());
    assertNull(dataset.getDefaultTableLifetime());
    assertNull(dataset.getAcl());
    assertNull(dataset.getEtag());
    assertNull(dataset.getFriendlyName());
    assertNull(dataset.getGeneratedId());
    assertNull(dataset.getLastModified());
    assertNull(dataset.getLocation());
    assertNull(dataset.getSelfLink());
  }

  @Test
  public void testUpdateDataset() {
    Dataset dataset = bigquery.create(DatasetInfo.newBuilder(OTHER_DATASET)
        .setDescription("Some Description")
        .build());
    assertNotNull(dataset);
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(OTHER_DATASET, dataset.getDatasetId().getDataset());
    assertEquals("Some Description", dataset.getDescription());
    Dataset updatedDataset =
        bigquery.update(dataset.toBuilder().setDescription("Updated Description").build());
    assertEquals("Updated Description", updatedDataset.getDescription());
    assertTrue(dataset.delete());
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    Dataset dataset = bigquery.create(DatasetInfo.newBuilder(OTHER_DATASET)
        .setDescription("Some Description")
        .build());
    assertNotNull(dataset);
    assertEquals(bigquery.getOptions().getProjectId(), dataset.getDatasetId().getProject());
    assertEquals(OTHER_DATASET, dataset.getDatasetId().getDataset());
    assertEquals("Some Description", dataset.getDescription());
    Dataset updatedDataset =
        bigquery.update(dataset.toBuilder().setDescription("Updated Description").build(),
            DatasetOption.fields(DatasetField.DESCRIPTION));
    assertEquals("Updated Description", updatedDataset.getDescription());
    assertNull(updatedDataset.getCreationTime());
    assertNull(updatedDataset.getDefaultTableLifetime());
    assertNull(updatedDataset.getAcl());
    assertNull(updatedDataset.getEtag());
    assertNull(updatedDataset.getFriendlyName());
    assertNull(updatedDataset.getGeneratedId());
    assertNull(updatedDataset.getLastModified());
    assertNull(updatedDataset.getLocation());
    assertNull(updatedDataset.getSelfLink());
    assertTrue(dataset.delete());
  }

  @Test
  public void testGetNonExistingTable() {
    assertNull(bigquery.getTable(DATASET, "test_get_non_existing_table"));
  }

  @Test
  public void testCreateAndGetTable() {
    String tableName = "test_create_and_get_table";
    TableId tableId = TableId.of(DATASET, tableName);
    TimePartitioning partitioning = TimePartitioning.of(Type.DAY);
    StandardTableDefinition tableDefinition = StandardTableDefinition.newBuilder()
        .setSchema(TABLE_SCHEMA)
        .setTimePartitioning(partitioning)
        .build();
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertTrue(remoteTable.getDefinition() instanceof StandardTableDefinition);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(TableDefinition.Type.TABLE, remoteTable.getDefinition().getType());
    assertEquals(TABLE_SCHEMA, remoteTable.getDefinition().getSchema());
    assertNotNull(remoteTable.getCreationTime());
    assertNotNull(remoteTable.getLastModifiedTime());
    assertNotNull(remoteTable.<StandardTableDefinition>getDefinition().getNumBytes());
    assertNotNull(remoteTable.<StandardTableDefinition>getDefinition().getNumRows());
    assertEquals(partitioning,
        remoteTable.<StandardTableDefinition>getDefinition().getTimePartitioning());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateAndGetTableWithSelectedField() {
    String tableName = "test_create_and_get_selected_fields_table";
    TableId tableId = TableId.of(DATASET, tableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName,
        TableOption.fields(TableField.CREATION_TIME));
    assertNotNull(remoteTable);
    assertTrue(remoteTable.getDefinition() instanceof StandardTableDefinition);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(TableDefinition.Type.TABLE, remoteTable.getDefinition().getType());
    assertNotNull(remoteTable.getCreationTime());
    assertNull(remoteTable.getDefinition().getSchema());
    assertNull(remoteTable.getLastModifiedTime());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getNumBytes());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getNumRows());
    assertNull(remoteTable.<StandardTableDefinition>getDefinition().getTimePartitioning());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateExternalTable() throws InterruptedException {
    String tableName = "test_create_external_table";
    TableId tableId = TableId.of(DATASET, tableName);
    ExternalTableDefinition externalTableDefinition = ExternalTableDefinition.of(
        "gs://" + BUCKET + "/" + JSON_LOAD_FILE, TABLE_SCHEMA, FormatOptions.json());
    TableInfo tableInfo = TableInfo.of(tableId, externalTableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertTrue(remoteTable.getDefinition() instanceof ExternalTableDefinition);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertEquals(TABLE_SCHEMA, remoteTable.getDefinition().getSchema());
    QueryRequest request = QueryRequest.newBuilder(
        "SELECT TimestampField, StringField, IntegerArrayField, BooleanField FROM " + DATASET + "."
            + tableName)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobCompleted()) {
      response = bigquery.getQueryResults(response.getJobId());
      Thread.sleep(1000);
    }
    long integerValue = 0;
    int rowCount = 0;
    for (List<FieldValue> row : response.getResult().getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(integerValue, integerCell.getLongValue());
      assertEquals(false, booleanCell.getBooleanValue());
      integerValue = ~integerValue & 0x1;
      rowCount++;
    }
    assertEquals(4, rowCount);
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateViewTable() throws InterruptedException {
    String tableName = "test_create_view_table";
    TableId tableId = TableId.of(DATASET, tableName);
    ViewDefinition viewDefinition =
        ViewDefinition.of("SELECT TimestampField, StringField, BooleanField FROM " + DATASET + "."
            + TABLE_ID.getTable());
    TableInfo tableInfo = TableInfo.of(tableId, viewDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(tableName, createdTable.getTableId().getTable());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertEquals(createdTable.getTableId(), remoteTable.getTableId());
    assertTrue(remoteTable.getDefinition() instanceof ViewDefinition);
    Schema expectedSchema = Schema.newBuilder()
        .addField(
            Field.newBuilder("TimestampField", Field.Type.timestamp())
                .setMode(Field.Mode.NULLABLE)
                .build())
        .addField(
            Field.newBuilder("StringField", Field.Type.string())
                .setMode(Field.Mode.NULLABLE)
                .build())
        .addField(
            Field.newBuilder("BooleanField", Field.Type.bool())
                .setMode(Field.Mode.NULLABLE)
                .build())
        .build();
    assertEquals(expectedSchema, remoteTable.getDefinition().getSchema());
    QueryRequest request = QueryRequest.newBuilder("SELECT * FROM " + tableName)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobCompleted()) {
      response = bigquery.getQueryResults(response.getJobId());
      Thread.sleep(1000);
    }
    int rowCount = 0;
    for (List<FieldValue> row : response.getResult().getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testListTables() {
    String tableName = "test_list_tables";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    Page<Table> tables = bigquery.listTables(DATASET);
    boolean found = false;
    Iterator<Table> tableIterator = tables.getValues().iterator();
    while (tableIterator.hasNext() && !found) {
      if (tableIterator.next().getTableId().equals(createdTable.getTableId())) {
        found = true;
      }
    }
    assertTrue(found);
    assertTrue(createdTable.delete());
  }

  @Test
  public void testUpdateTable() {
    String tableName = "test_update_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    Table updatedTable =
        bigquery.update(tableInfo.toBuilder().setDescription("newDescription").build());
    assertEquals(DATASET, updatedTable.getTableId().getDataset());
    assertEquals(tableName, updatedTable.getTableId().getTable());
    assertEquals(TABLE_SCHEMA, updatedTable.getDefinition().getSchema());
    assertEquals("newDescription", updatedTable.getDescription());
    assertTrue(updatedTable.delete());
  }

  @Test
  public void testUpdateTableWithSelectedFields() {
    String tableName = "test_update_with_selected_fields_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    Table updatedTable = bigquery.update(tableInfo.toBuilder().setDescription("newDescr").build(),
        TableOption.fields(TableField.DESCRIPTION));
    assertTrue(updatedTable.getDefinition() instanceof StandardTableDefinition);
    assertEquals(DATASET, updatedTable.getTableId().getDataset());
    assertEquals(tableName, updatedTable.getTableId().getTable());
    assertEquals("newDescr", updatedTable.getDescription());
    assertNull(updatedTable.getDefinition().getSchema());
    assertNull(updatedTable.getLastModifiedTime());
    assertNull(updatedTable.<StandardTableDefinition>getDefinition().getNumBytes());
    assertNull(updatedTable.<StandardTableDefinition>getDefinition().getNumRows());
    assertTrue(createdTable.delete());
  }

  @Test
  public void testUpdateNonExistingTable() {
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, "test_update_non_existing_table"),
        StandardTableDefinition.of(SIMPLE_SCHEMA));
    try {
      bigquery.update(tableInfo);
      fail("BigQueryException was expected");
    } catch (BigQueryException e) {
      BigQueryError error = e.getError();
      assertNotNull(error);
      assertEquals("notFound", error.getReason());
      assertNotNull(error.getMessage());
    }
  }

  @Test
  public void testDeleteNonExistingTable() {
    assertFalse(bigquery.delete(DATASET, "test_delete_non_existing_table"));
  }

  @Test
  public void testInsertAll() throws IOException {
    String tableName = "test_insert_all_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
    builder1.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder1.put("StringField", "stringValue");
    builder1.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder1.put("BooleanField", false);
    builder1.put("BytesField", BYTES_BASE64);
    builder1.put("RecordField", ImmutableMap.of(
        "TimestampField", "1969-07-20 20:18:04 UTC",
        "IntegerArrayField", ImmutableList.of(1, 0),
        "BooleanField", true,
        "BytesField", BYTES_BASE64));
    builder1.put("IntegerField", 5);
    builder1.put("FloatField", 1.2);
    ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
    builder2.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder2.put("StringField", "stringValue");
    builder2.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder2.put("BooleanField", false);
    builder2.put("BytesField", BYTES_BASE64);
    builder2.put("RecordField", ImmutableMap.of(
        "TimestampField", "1969-07-20 20:18:04 UTC",
        "IntegerArrayField", ImmutableList.of(1, 0),
        "BooleanField", true,
        "BytesField", BYTES_BASE64));
    builder2.put("IntegerField", 5);
    builder2.put("FloatField", 1.2);
    InsertAllRequest request = InsertAllRequest.newBuilder(tableInfo.getTableId())
        .addRow(builder1.build())
        .addRow(builder2.build())
        .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
  }

  @Test
  public void testInsertAllWithSuffix() throws InterruptedException {
    String tableName = "test_insert_all_with_suffix_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
    builder1.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder1.put("StringField", "stringValue");
    builder1.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder1.put("BooleanField", false);
    builder1.put("BytesField", BYTES_BASE64);
    builder1.put("RecordField", ImmutableMap.of(
        "TimestampField", "1969-07-20 20:18:04 UTC",
        "IntegerArrayField", ImmutableList.of(1, 0),
        "BooleanField", true,
        "BytesField", BYTES_BASE64));
    builder1.put("IntegerField", 5);
    builder1.put("FloatField", 1.2);
    ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
    builder2.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder2.put("StringField", "stringValue");
    builder2.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder2.put("BooleanField", false);
    builder2.put("BytesField", BYTES_BASE64);
    builder2.put("RecordField", ImmutableMap.of(
        "TimestampField", "1969-07-20 20:18:04 UTC",
        "IntegerArrayField", ImmutableList.of(1, 0),
        "BooleanField", true,
        "BytesField", BYTES_BASE64));
    builder2.put("IntegerField", 5);
    builder2.put("FloatField", 1.2);
    InsertAllRequest request = InsertAllRequest.newBuilder(tableInfo.getTableId())
        .addRow(builder1.build())
        .addRow(builder2.build())
        .setTemplateSuffix("_suffix")
        .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.getInsertErrors().size());
    String newTableName = tableName + "_suffix";
    Table suffixTable = bigquery.getTable(DATASET, newTableName, TableOption.fields());
    // wait until the new table is created. If the table is never created the test will time-out
    while (suffixTable == null) {
      Thread.sleep(1000L);
      suffixTable = bigquery.getTable(DATASET, newTableName, TableOption.fields());
    }
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
    assertTrue(suffixTable.delete());
  }

  @Test
  public void testInsertAllWithErrors() {
    String tableName = "test_insert_all_with_errors_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
    builder1.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder1.put("StringField", "stringValue");
    builder1.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder1.put("BooleanField", false);
    builder1.put("BytesField", BYTES_BASE64);
    builder1.put("RecordField", ImmutableMap.of(
        "TimestampField", "1969-07-20 20:18:04 UTC",
        "IntegerArrayField", ImmutableList.of(1, 0),
        "BooleanField", true,
        "BytesField", BYTES_BASE64));
    builder1.put("IntegerField", 5);
    builder1.put("FloatField", 1.2);
    ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
    builder2.put("TimestampField", "invalidDate");
    builder2.put("StringField", "stringValue");
    builder2.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder2.put("BooleanField", false);
    builder2.put("BytesField", BYTES_BASE64);
    builder2.put("RecordField", ImmutableMap.of(
        "TimestampField", "1969-07-20 20:18:04 UTC",
        "IntegerArrayField", ImmutableList.of(1, 0),
        "BooleanField", true,
        "BytesField", BYTES_BASE64));
    builder2.put("IntegerField", 5);
    builder2.put("FloatField", 1.2);
    ImmutableMap.Builder<String, Object> builder3 = ImmutableMap.builder();
    builder3.put("TimestampField", "2014-08-19 07:41:35.220 -05:00");
    builder3.put("StringField", "stringValue");
    builder3.put("IntegerArrayField", ImmutableList.of(0, 1));
    builder3.put("BooleanField", false);
    builder3.put("BytesField", BYTES_BASE64);
    InsertAllRequest request = InsertAllRequest.newBuilder(tableInfo.getTableId())
        .addRow(builder1.build())
        .addRow(builder2.build())
        .addRow(builder3.build())
        .setSkipInvalidRows(true)
        .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertTrue(response.hasErrors());
    assertEquals(2, response.getInsertErrors().size());
    assertNotNull(response.getErrorsFor(1L));
    assertNotNull(response.getErrorsFor(2L));
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
  }

  @Test
  public void testListAllTableData() {
    Page<List<FieldValue>> rows = bigquery.listTableData(TABLE_ID);
    int rowCount = 0;
    for (List<FieldValue> row : rows.getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerArrayCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      FieldValue bytesCell = row.get(4);
      FieldValue recordCell = row.get(5);
      FieldValue integerCell = row.get(6);
      FieldValue floatCell = row.get(7);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.REPEATED, integerArrayCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, bytesCell.getAttribute());
      assertEquals(FieldValue.Attribute.RECORD, recordCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, floatCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(0, integerArrayCell.getRepeatedValue().get(0).getLongValue());
      assertEquals(1, integerArrayCell.getRepeatedValue().get(1).getLongValue());
      assertEquals(false, booleanCell.getBooleanValue());
      assertArrayEquals(BYTES, bytesCell.getBytesValue());
      assertEquals(-14182916000000L, recordCell.getRecordValue().get(0).getTimestampValue());
      assertTrue(recordCell.getRecordValue().get(1).isNull());
      assertEquals(1, recordCell.getRecordValue().get(2).getRepeatedValue().get(0).getLongValue());
      assertEquals(0, recordCell.getRecordValue().get(2).getRepeatedValue().get(1).getLongValue());
      assertEquals(true, recordCell.getRecordValue().get(3).getBooleanValue());
      assertEquals(3, integerCell.getLongValue());
      assertEquals(1.2, floatCell.getDoubleValue(), 0.0001);
      rowCount++;
    }
    assertEquals(2, rowCount);
  }

  private QueryResponse queryAndWaitForResponse(QueryRequest request) throws InterruptedException {
    QueryResponse response = bigquery.query(request);
    while (!response.jobCompleted()) {
      Thread.sleep(1000);
      response = bigquery.getQueryResults(response.getJobId());
    }
    return response;
  }

  @Test
  public void testQuery() throws InterruptedException {
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.getTable())
        .toString();
    QueryRequest request = QueryRequest.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .build();
    QueryResponse response = queryAndWaitForResponse(request);
    assertEquals(QUERY_RESULT_SCHEMA, response.getResult().getSchema());
    int rowCount = 0;
    for (List<FieldValue> row : response.getResult().getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    Job queryJob = bigquery.getJob(response.getJobId());
    JobStatistics.QueryStatistics statistics = queryJob.getStatistics();
    assertNotNull(statistics.getQueryPlan());
  }

  @Test
  public void testPositionalQueryParameters() throws InterruptedException {
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.getTable())
        .append(" WHERE StringField = ?")
        .append(" AND TimestampField > ?")
        .append(" AND IntegerField IN UNNEST(?)")
        .append(" AND IntegerField < ?")
        .append(" AND FloatField > ?")
        .toString();
    QueryParameterValue stringParameter = QueryParameterValue.string("stringValue");
    QueryParameterValue timestampParameter =
        QueryParameterValue.timestamp("2014-01-01 07:00:00.000000+00:00");
    QueryParameterValue intArrayParameter =
        QueryParameterValue.array(new Integer[] {3, 4}, Integer.class);
    QueryParameterValue int64Parameter = QueryParameterValue.int64(5);
    QueryParameterValue float64Parameter = QueryParameterValue.float64(0.5);
    QueryRequest request = QueryRequest.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .setUseLegacySql(false)
        .addPositionalParameter(stringParameter)
        .addPositionalParameter(timestampParameter)
        .addPositionalParameter(intArrayParameter)
        .addPositionalParameter(int64Parameter)
        .addPositionalParameter(float64Parameter)
        .build();
    QueryResponse response = queryAndWaitForResponse(request);
    assertEquals(QUERY_RESULT_SCHEMA, response.getResult().getSchema());
    assertEquals(2, Iterables.size(response.getResult().getValues()));
  }

  @Test
  public void testNamedQueryParameters() throws InterruptedException {
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.getTable())
        .append(" WHERE StringField = @stringParam")
        .append(" AND IntegerField IN UNNEST(@integerList)")
        .toString();
    QueryParameterValue stringParameter = QueryParameterValue.string("stringValue");
    QueryParameterValue intArrayParameter =
            QueryParameterValue.array(new Integer[]{3, 4}, Integer.class);
    QueryRequest request = QueryRequest.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .setUseLegacySql(false)
        .addNamedParameter("stringParam", stringParameter)
        .addNamedParameter("integerList", intArrayParameter)
        .build();
    QueryResponse response = queryAndWaitForResponse(request);
    assertEquals(QUERY_RESULT_SCHEMA, response.getResult().getSchema());
    assertEquals(2, Iterables.size(response.getResult().getValues()));
  }

  @Test
  public void testBytesParameter() throws Exception {
    String query = new StringBuilder()
        .append("SELECT BYTE_LENGTH(@p) AS length")
        .toString();
    QueryParameterValue bytesParameter = QueryParameterValue.bytes(new byte[] { 1, 3 });
    QueryRequest request = QueryRequest.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setMaxWaitTime(60000L)
        .setPageSize(1000L)
        .setUseLegacySql(false)
        .addNamedParameter("p", bytesParameter)
        .build();
    QueryResponse response = queryAndWaitForResponse(request);
    int rowCount = 0;
    for (List<FieldValue> row : response.getResult().getValues()) {
      rowCount++;
      assertEquals(2, row.get(0).getLongValue());
    }
    assertEquals(1, rowCount);
  }

  @Test
  public void testListJobs() {
    Page<Job> jobs = bigquery.listJobs();
    for (Job job : jobs.getValues()) {
      assertNotNull(job.getJobId());
      assertNotNull(job.getStatistics());
      assertNotNull(job.getStatus());
      assertNotNull(job.getUserEmail());
      assertNotNull(job.getGeneratedId());
    }
  }

  @Test
  public void testListJobsWithSelectedFields() {
    Page<Job> jobs = bigquery.listJobs(JobListOption.fields(JobField.USER_EMAIL));
    for (Job job : jobs.getValues()) {
      assertNotNull(job.getJobId());
      assertNotNull(job.getStatus());
      assertNotNull(job.getUserEmail());
      assertNull(job.getStatistics());
      assertNull(job.getGeneratedId());
    }
  }

  @Test
  public void testCreateAndGetJob() throws InterruptedException, TimeoutException {
    String sourceTableName = "test_create_and_get_job_source_table";
    String destinationTableName = "test_create_and_get_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(sourceTableName, createdTable.getTableId().getTable());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration copyJobConfiguration =
        CopyJobConfiguration.of(destinationTable, sourceTable);
    Job createdJob = bigquery.create(JobInfo.of(copyJobConfiguration));
    Job remoteJob = bigquery.getJob(createdJob.getJobId());
    assertEquals(createdJob.getJobId(), remoteJob.getJobId());
    CopyJobConfiguration createdConfiguration = createdJob.getConfiguration();
    CopyJobConfiguration remoteConfiguration = remoteJob.getConfiguration();
    assertEquals(createdConfiguration.getSourceTables(), remoteConfiguration.getSourceTables());
    assertEquals(createdConfiguration.getDestinationTable(),
        remoteConfiguration.getDestinationTable());
    assertEquals(createdConfiguration.getCreateDisposition(),
        remoteConfiguration.getCreateDisposition());
    assertEquals(createdConfiguration.getWriteDisposition(),
        remoteConfiguration.getWriteDisposition());
    assertNotNull(remoteJob.getEtag());
    assertNotNull(remoteJob.getStatistics());
    assertNotNull(remoteJob.getStatus());
    assertEquals(createdJob.getSelfLink(), remoteJob.getSelfLink());
    assertEquals(createdJob.getUserEmail(), remoteJob.getUserEmail());
    assertTrue(createdTable.delete());

    Job completedJob =
        remoteJob.waitFor(
            WaitForOption.checkEvery(1, TimeUnit.SECONDS),
            WaitForOption.timeout(1, TimeUnit.MINUTES));
    assertNotNull(completedJob);
    assertNull(completedJob.getStatus().getError());
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testCreateAndGetJobWithSelectedFields() throws InterruptedException, TimeoutException {
    String sourceTableName = "test_create_and_get_job_with_selected_fields_source_table";
    String destinationTableName = "test_create_and_get_job_with_selected_fields_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(sourceTableName, createdTable.getTableId().getTable());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, sourceTable);
    Job createdJob = bigquery.create(JobInfo.of(configuration), JobOption.fields(JobField.ETAG));
    CopyJobConfiguration createdConfiguration = createdJob.getConfiguration();
    assertNotNull(createdJob.getJobId());
    assertNotNull(createdConfiguration.getSourceTables());
    assertNotNull(createdConfiguration.getDestinationTable());
    assertNotNull(createdJob.getEtag());
    assertNull(createdJob.getStatistics());
    assertNull(createdJob.getStatus());
    assertNull(createdJob.getSelfLink());
    assertNull(createdJob.getUserEmail());
    Job remoteJob = bigquery.getJob(createdJob.getJobId(), JobOption.fields(JobField.ETAG));
    CopyJobConfiguration remoteConfiguration = remoteJob.getConfiguration();
    assertEquals(createdJob.getJobId(), remoteJob.getJobId());
    assertEquals(createdConfiguration.getSourceTables(), remoteConfiguration.getSourceTables());
    assertEquals(createdConfiguration.getDestinationTable(),
        remoteConfiguration.getDestinationTable());
    assertEquals(createdConfiguration.getCreateDisposition(),
        remoteConfiguration.getCreateDisposition());
    assertEquals(createdConfiguration.getWriteDisposition(),
        remoteConfiguration.getWriteDisposition());
    assertNotNull(remoteJob.getEtag());
    assertNull(remoteJob.getStatistics());
    assertNull(remoteJob.getStatus());
    assertNull(remoteJob.getSelfLink());
    assertNull(remoteJob.getUserEmail());
    assertTrue(createdTable.delete());

    Job completedJob =
        remoteJob.waitFor(
            WaitForOption.checkEvery(1, TimeUnit.SECONDS),
            WaitForOption.timeout(1, TimeUnit.MINUTES));
    assertNotNull(completedJob);
    assertNull(completedJob.getStatus().getError());
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testCopyJob() throws InterruptedException, TimeoutException {
    String sourceTableName = "test_copy_job_source_table";
    String destinationTableName = "test_copy_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.getTableId().getDataset());
    assertEquals(sourceTableName, createdTable.getTableId().getTable());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, sourceTable);
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());
    Table remoteTable = bigquery.getTable(DATASET, destinationTableName);
    assertNotNull(remoteTable);
    assertEquals(destinationTable.getDataset(), remoteTable.getTableId().getDataset());
    assertEquals(destinationTableName, remoteTable.getTableId().getTable());
    assertEquals(TABLE_SCHEMA, remoteTable.getDefinition().getSchema());
    assertTrue(createdTable.delete());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testQueryJob() throws InterruptedException, TimeoutException {
    String tableName = "test_query_job_table";
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.getTable())
        .toString();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobConfiguration configuration = QueryJobConfiguration.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setDestinationTable(destinationTable)
        .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());

    QueryResponse response = bigquery.getQueryResults(remoteJob.getJobId());
    while (!response.jobCompleted()) {
      Thread.sleep(1000);
      response = bigquery.getQueryResults(response.getJobId());
    }
    assertFalse(response.hasErrors());
    assertEquals(QUERY_RESULT_SCHEMA, response.getResult().getSchema());
    int rowCount = 0;
    for (List<FieldValue> row : response.getResult().getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(false, booleanCell.getBooleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(bigquery.delete(DATASET, tableName));
    Job queryJob = bigquery.getJob(remoteJob.getJobId());
    JobStatistics.QueryStatistics statistics = queryJob.getStatistics();
    assertNotNull(statistics.getQueryPlan());
  }

  @Test
  public void testQueryJobWithDryRun() throws InterruptedException, TimeoutException {
    String tableName = "test_query_job_table";
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.getTable())
        .toString();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobConfiguration configuration = QueryJobConfiguration.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setDestinationTable(destinationTable)
        .setDryRun(true)
        .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    System.out.println("job (dryrun): " + remoteJob);
    assertNull(remoteJob.getJobId().getJob());
    assertEquals(DONE, remoteJob.getStatus().getState());
    assertNotNull(remoteJob.getConfiguration());
  }

  @Test
  public void testExtractJob() throws InterruptedException, TimeoutException {
    String tableName = "test_export_job_table";
    TableId destinationTable = TableId.of(DATASET, tableName);
    LoadJobConfiguration configuration =
        LoadJobConfiguration.newBuilder(destinationTable, "gs://" + BUCKET + "/" + LOAD_FILE)
            .setSchema(SIMPLE_SCHEMA)
            .build();
    Job remoteLoadJob = bigquery.create(JobInfo.of(configuration));
    remoteLoadJob = remoteLoadJob.waitFor();
    assertNull(remoteLoadJob.getStatus().getError());

    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.newBuilder(destinationTable, "gs://" + BUCKET + "/" + EXTRACT_FILE)
            .setPrintHeader(false)
            .build();
    Job remoteExtractJob = bigquery.create(JobInfo.of(extractConfiguration));
    remoteExtractJob = remoteExtractJob.waitFor();
    assertNull(remoteExtractJob.getStatus().getError());
    assertEquals(CSV_CONTENT,
        new String(storage.readAllBytes(BUCKET, EXTRACT_FILE), StandardCharsets.UTF_8));
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testCancelJob() throws InterruptedException, TimeoutException {
    String destinationTableName = "test_cancel_query_job_table";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.getTable();
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    QueryJobConfiguration configuration = QueryJobConfiguration.newBuilder(query)
        .setDefaultDataset(DatasetId.of(DATASET))
        .setDestinationTable(destinationTable)
        .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    assertTrue(remoteJob.cancel());
    remoteJob = remoteJob.waitFor();
    assertNull(remoteJob.getStatus().getError());
  }

  @Test
  public void testCancelNonExistingJob() {
    assertFalse(bigquery.cancel("test_cancel_non_existing_job"));
  }

  @Test
  public void testInsertFromFile() throws InterruptedException, IOException, TimeoutException {
    String destinationTableName = "test_insert_from_file_table";
    TableId tableId = TableId.of(DATASET, destinationTableName);
    WriteChannelConfiguration configuration = WriteChannelConfiguration.newBuilder(tableId)
        .setFormatOptions(FormatOptions.json())
        .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
        .setSchema(TABLE_SCHEMA)
        .build();
    TableDataWriteChannel channel = bigquery.writer(configuration);
    try {
      // A zero byte write should not throw an exception.
      assertEquals(0, channel.write(ByteBuffer.wrap("".getBytes(StandardCharsets.UTF_8))));
    } finally {
      // Force the channel to flush by calling `close`.
      channel.close();
    }
    channel = bigquery.writer(configuration);
    try {
      channel.write(ByteBuffer.wrap(JSON_CONTENT.getBytes(StandardCharsets.UTF_8)));
    } finally {
      channel.close();
    }
    Job job = channel.getJob().waitFor();
    LoadStatistics statistics = job.getStatistics();
    assertEquals(1L, statistics.getInputFiles().longValue());
    assertEquals(2L, statistics.getOutputRows().longValue());
    LoadJobConfiguration jobConfiguration = job.getConfiguration();
    assertEquals(TABLE_SCHEMA, jobConfiguration.getSchema());
    assertNull(jobConfiguration.getSourceUris());
    assertNull(job.getStatus().getError());
    Page<List<FieldValue>> rows = bigquery.listTableData(tableId);
    int rowCount = 0;
    for (List<FieldValue> row : rows.getValues()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerArrayCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      FieldValue bytesCell = row.get(4);
      FieldValue recordCell = row.get(5);
      FieldValue integerCell = row.get(6);
      FieldValue floatCell = row.get(7);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.getAttribute());
      assertEquals(FieldValue.Attribute.REPEATED, integerArrayCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, bytesCell.getAttribute());
      assertEquals(FieldValue.Attribute.RECORD, recordCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.getAttribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, floatCell.getAttribute());
      assertEquals(1408452095220000L, timestampCell.getTimestampValue());
      assertEquals("stringValue", stringCell.getStringValue());
      assertEquals(0, integerArrayCell.getRepeatedValue().get(0).getLongValue());
      assertEquals(1, integerArrayCell.getRepeatedValue().get(1).getLongValue());
      assertEquals(false, booleanCell.getBooleanValue());
      assertArrayEquals(BYTES, bytesCell.getBytesValue());
      assertEquals(-14182916000000L, recordCell.getRecordValue().get(0).getTimestampValue());
      assertTrue(recordCell.getRecordValue().get(1).isNull());
      assertEquals(1, recordCell.getRecordValue().get(2).getRepeatedValue().get(0).getLongValue());
      assertEquals(0, recordCell.getRecordValue().get(2).getRepeatedValue().get(1).getLongValue());
      assertEquals(true, recordCell.getRecordValue().get(3).getBooleanValue());
      assertEquals(3, integerCell.getLongValue());
      assertEquals(1.2, floatCell.getDoubleValue(), 0.0001);
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }
}
