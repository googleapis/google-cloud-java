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

package com.google.gcloud.bigquery.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.Page;
import com.google.gcloud.WriteChannel;
import com.google.gcloud.bigquery.BigQuery;
import com.google.gcloud.bigquery.BigQuery.DatasetField;
import com.google.gcloud.bigquery.BigQuery.DatasetOption;
import com.google.gcloud.bigquery.BigQuery.JobField;
import com.google.gcloud.bigquery.BigQuery.JobListOption;
import com.google.gcloud.bigquery.BigQuery.JobOption;
import com.google.gcloud.bigquery.BigQuery.TableField;
import com.google.gcloud.bigquery.BigQuery.TableOption;
import com.google.gcloud.bigquery.BigQueryError;
import com.google.gcloud.bigquery.BigQueryException;
import com.google.gcloud.bigquery.CopyJobConfiguration;
import com.google.gcloud.bigquery.Dataset;
import com.google.gcloud.bigquery.DatasetId;
import com.google.gcloud.bigquery.DatasetInfo;
import com.google.gcloud.bigquery.ExternalTableDefinition;
import com.google.gcloud.bigquery.ExtractJobConfiguration;
import com.google.gcloud.bigquery.Field;
import com.google.gcloud.bigquery.FieldValue;
import com.google.gcloud.bigquery.FormatOptions;
import com.google.gcloud.bigquery.InsertAllRequest;
import com.google.gcloud.bigquery.InsertAllResponse;
import com.google.gcloud.bigquery.Job;
import com.google.gcloud.bigquery.JobInfo;
import com.google.gcloud.bigquery.JobStatistics;
import com.google.gcloud.bigquery.LoadJobConfiguration;
import com.google.gcloud.bigquery.QueryJobConfiguration;
import com.google.gcloud.bigquery.QueryRequest;
import com.google.gcloud.bigquery.QueryResponse;
import com.google.gcloud.bigquery.Schema;
import com.google.gcloud.bigquery.StandardTableDefinition;
import com.google.gcloud.bigquery.Table;
import com.google.gcloud.bigquery.TableDefinition;
import com.google.gcloud.bigquery.TableId;
import com.google.gcloud.bigquery.TableInfo;
import com.google.gcloud.bigquery.ViewDefinition;
import com.google.gcloud.bigquery.WriteChannelConfiguration;
import com.google.gcloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.gcloud.storage.BlobInfo;
import com.google.gcloud.storage.BucketInfo;
import com.google.gcloud.storage.Storage;
import com.google.gcloud.storage.testing.RemoteGcsHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITBigQueryTest {

  private static final Logger LOG = Logger.getLogger(ITBigQueryTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String DESCRIPTION = "Test dataset";
  private static final String OTHER_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final Field TIMESTAMP_FIELD_SCHEMA =
      Field.builder("TimestampField", Field.Type.timestamp())
          .mode(Field.Mode.NULLABLE)
          .description("TimestampDescription")
          .build();
  private static final Field STRING_FIELD_SCHEMA =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("StringDescription")
          .build();
  private static final Field INTEGER_FIELD_SCHEMA =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("IntegerDescription")
          .build();
  private static final Field BOOLEAN_FIELD_SCHEMA =
      Field.builder("BooleanField", Field.Type.bool())
          .mode(Field.Mode.NULLABLE)
          .description("BooleanDescription")
          .build();
  private static final Field RECORD_FIELD_SCHEMA =
      Field.builder("RecordField", Field.Type.record(TIMESTAMP_FIELD_SCHEMA,
          STRING_FIELD_SCHEMA, INTEGER_FIELD_SCHEMA, BOOLEAN_FIELD_SCHEMA))
          .mode(Field.Mode.REQUIRED)
          .description("RecordDescription")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(TIMESTAMP_FIELD_SCHEMA, STRING_FIELD_SCHEMA,
      INTEGER_FIELD_SCHEMA, BOOLEAN_FIELD_SCHEMA, RECORD_FIELD_SCHEMA);
  private static final Schema SIMPLE_SCHEMA = Schema.of(STRING_FIELD_SCHEMA);
  private static final Schema QUERY_RESULT_SCHEMA = Schema.builder()
      .addField(Field.builder("TimestampField", Field.Type.timestamp())
          .mode(Field.Mode.NULLABLE)
          .build())
      .addField(Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .build())
      .addField(Field.builder("BooleanField", Field.Type.bool())
          .mode(Field.Mode.NULLABLE)
          .build())
      .build();
  private static final String LOAD_FILE = "load.csv";
  private static final String JSON_LOAD_FILE = "load.json";
  private static final String EXTRACT_FILE = "extract.csv";
  private static final String BUCKET = RemoteGcsHelper.generateBucketName();
  private static final TableId TABLE_ID = TableId.of(DATASET, "testing_table");
  private static final String CSV_CONTENT = "StringValue1\nStringValue2\n";
  private static final String JSON_CONTENT = "{"
      + "\"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
      + "\"StringField\": \"stringValue\","
      + "\"IntegerField\": [\"0\", \"1\"],"
      + "\"BooleanField\": \"false\","
      + "\"RecordField\": {"
      + "\"TimestampField\": \"1969-07-20 20:18:04 UTC\","
      + "\"StringField\": null,"
      + "\"IntegerField\": [\"1\",\"0\"],"
      + "\"BooleanField\": \"true\""
      + "}"
      + "}\n"
      + "{"
      + "\"TimestampField\": \"2014-08-19 07:41:35.220 -05:00\","
      + "\"StringField\": \"stringValue\","
      + "\"IntegerField\": [\"0\", \"1\"],"
      + "\"BooleanField\": \"false\","
      + "\"RecordField\": {"
      + "\"TimestampField\": \"1969-07-20 20:18:04 UTC\","
      + "\"StringField\": null,"
      + "\"IntegerField\": [\"1\",\"0\"],"
      + "\"BooleanField\": \"true\""
      + "}"
      + "}";

  private static BigQuery bigquery;
  private static Storage storage;

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() throws InterruptedException {
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    RemoteGcsHelper gcsHelper = RemoteGcsHelper.create();
    bigquery = bigqueryHelper.options().service();
    storage = gcsHelper.options().service();
    storage.create(BucketInfo.of(BUCKET));
    storage.create(BlobInfo.builder(BUCKET, LOAD_FILE).contentType("text/plain").build(),
        CSV_CONTENT.getBytes(StandardCharsets.UTF_8));
    storage.create(BlobInfo.builder(BUCKET, JSON_LOAD_FILE).contentType("application/json").build(),
        JSON_CONTENT.getBytes(StandardCharsets.UTF_8));
    DatasetInfo info = DatasetInfo.builder(DATASET).description(DESCRIPTION).build();
    bigquery.create(info);
    LoadJobConfiguration configuration = LoadJobConfiguration.builder(
            TABLE_ID, "gs://" + BUCKET + "/" + JSON_LOAD_FILE, FormatOptions.json())
        .createDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
        .schema(TABLE_SCHEMA)
        .build();
    Job job = bigquery.create(JobInfo.of(configuration));
    while (!job.isDone()) {
      Thread.sleep(1000);
    }
    assertNull(job.status().error());
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
    }
    if (storage != null) {
      boolean wasDeleted = RemoteGcsHelper.forceDelete(storage, BUCKET, 10, TimeUnit.SECONDS);
      if (!wasDeleted && LOG.isLoggable(Level.WARNING)) {
        LOG.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void testGetDataset() {
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(DATASET, dataset.datasetId().dataset());
    assertEquals(DESCRIPTION, dataset.description());
    assertNotNull(dataset.acl());
    assertNotNull(dataset.etag());
    assertNotNull(dataset.generatedId());
    assertNotNull(dataset.lastModified());
    assertNotNull(dataset.selfLink());
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    Dataset dataset = bigquery.getDataset(DATASET,
        DatasetOption.fields(DatasetField.CREATION_TIME));
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(DATASET, dataset.datasetId().dataset());
    assertNotNull(dataset.creationTime());
    assertNull(dataset.description());
    assertNull(dataset.defaultTableLifetime());
    assertNull(dataset.acl());
    assertNull(dataset.etag());
    assertNull(dataset.friendlyName());
    assertNull(dataset.generatedId());
    assertNull(dataset.lastModified());
    assertNull(dataset.location());
    assertNull(dataset.selfLink());
  }

  @Test
  public void testUpdateDataset() {
    Dataset dataset = bigquery.create(DatasetInfo.builder(OTHER_DATASET)
        .description("Some Description")
        .build());
    assertNotNull(dataset);
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(OTHER_DATASET, dataset.datasetId().dataset());
    assertEquals("Some Description", dataset.description());
    Dataset updatedDataset =
        bigquery.update(dataset.toBuilder().description("Updated Description").build());
    assertEquals("Updated Description", updatedDataset.description());
    assertTrue(dataset.delete());
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    Dataset dataset = bigquery.create(DatasetInfo.builder(OTHER_DATASET)
        .description("Some Description")
        .build());
    assertNotNull(dataset);
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(OTHER_DATASET, dataset.datasetId().dataset());
    assertEquals("Some Description", dataset.description());
    Dataset updatedDataset =
        bigquery.update(dataset.toBuilder().description("Updated Description").build(),
            DatasetOption.fields(DatasetField.DESCRIPTION));
    assertEquals("Updated Description", updatedDataset.description());
    assertNull(updatedDataset.creationTime());
    assertNull(updatedDataset.defaultTableLifetime());
    assertNull(updatedDataset.acl());
    assertNull(updatedDataset.etag());
    assertNull(updatedDataset.friendlyName());
    assertNull(updatedDataset.generatedId());
    assertNull(updatedDataset.lastModified());
    assertNull(updatedDataset.location());
    assertNull(updatedDataset.selfLink());
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
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(tableName, createdTable.tableId().table());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertTrue(remoteTable.definition() instanceof StandardTableDefinition);
    assertEquals(createdTable.tableId(), remoteTable.tableId());
    assertEquals(TableDefinition.Type.TABLE, remoteTable.definition().type());
    assertEquals(TABLE_SCHEMA, remoteTable.definition().schema());
    assertNotNull(remoteTable.creationTime());
    assertNotNull(remoteTable.lastModifiedTime());
    assertNotNull(remoteTable.<StandardTableDefinition>definition().numBytes());
    assertNotNull(remoteTable.<StandardTableDefinition>definition().numRows());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testCreateAndGetTableWithSelectedField() {
    String tableName = "test_create_and_get_selected_fields_table";
    TableId tableId = TableId.of(DATASET, tableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    Table createdTable = bigquery.create(TableInfo.of(tableId, tableDefinition));
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(tableName, createdTable.tableId().table());
    Table remoteTable = bigquery.getTable(DATASET, tableName,
        TableOption.fields(TableField.CREATION_TIME));
    assertNotNull(remoteTable);
    assertTrue(remoteTable.definition() instanceof StandardTableDefinition);
    assertEquals(createdTable.tableId(), remoteTable.tableId());
    assertEquals(TableDefinition.Type.TABLE, remoteTable.definition().type());
    assertNotNull(remoteTable.creationTime());
    assertNull(remoteTable.definition().schema());
    assertNull(remoteTable.lastModifiedTime());
    assertNull(remoteTable.<StandardTableDefinition>definition().numBytes());
    assertNull(remoteTable.<StandardTableDefinition>definition().numRows());
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
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(tableName, createdTable.tableId().table());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertTrue(remoteTable.definition() instanceof ExternalTableDefinition);
    assertEquals(createdTable.tableId(), remoteTable.tableId());
    assertEquals(TABLE_SCHEMA, remoteTable.definition().schema());
    QueryRequest request = QueryRequest.builder(
        "SELECT TimestampField, StringField, IntegerField, BooleanField FROM " + DATASET + "."
            + tableName)
        .defaultDataset(DatasetId.of(DATASET))
        .maxWaitTime(60000L)
        .pageSize(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobCompleted()) {
      response = bigquery.getQueryResults(response.jobId());
      Thread.sleep(1000);
    }
    long integerValue = 0;
    int rowCount = 0;
    for (List<FieldValue> row : response.result().values()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, integerCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.attribute());
      assertEquals(1408452095220000L, timestampCell.timestampValue());
      assertEquals("stringValue", stringCell.stringValue());
      assertEquals(integerValue, integerCell.longValue());
      assertEquals(false, booleanCell.booleanValue());
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
            + TABLE_ID.table());
    TableInfo tableInfo = TableInfo.of(tableId, viewDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(tableName, createdTable.tableId().table());
    Table remoteTable = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTable);
    assertEquals(createdTable.tableId(), remoteTable.tableId());
    assertTrue(remoteTable.definition() instanceof ViewDefinition);
    Schema expectedSchema = Schema.builder()
        .addField(
            Field.builder("TimestampField", Field.Type.timestamp())
                .mode(Field.Mode.NULLABLE)
                .build())
        .addField(
            Field.builder("StringField", Field.Type.string())
                .mode(Field.Mode.NULLABLE)
                .build())
        .addField(
            Field.builder("BooleanField", Field.Type.bool())
                .mode(Field.Mode.NULLABLE)
                .build())
        .build();
    assertEquals(expectedSchema, remoteTable.definition().schema());
    QueryRequest request = QueryRequest.builder("SELECT * FROM " + tableName)
        .defaultDataset(DatasetId.of(DATASET))
        .maxWaitTime(60000L)
        .pageSize(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobCompleted()) {
      response = bigquery.getQueryResults(response.jobId());
      Thread.sleep(1000);
    }
    int rowCount = 0;
    for (List<FieldValue> row : response.result().values()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.attribute());
      assertEquals(1408452095220000L, timestampCell.timestampValue());
      assertEquals("stringValue", stringCell.stringValue());
      assertEquals(false, booleanCell.booleanValue());
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
    Iterator<Table> tableIterator = tables.values().iterator();
    while (tableIterator.hasNext() && !found) {
      if (tableIterator.next().tableId().equals(createdTable.tableId())) {
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
        bigquery.update(tableInfo.toBuilder().description("newDescription").build());
    assertEquals(DATASET, updatedTable.tableId().dataset());
    assertEquals(tableName, updatedTable.tableId().table());
    assertEquals(TABLE_SCHEMA, updatedTable.definition().schema());
    assertEquals("newDescription", updatedTable.description());
    assertTrue(updatedTable.delete());
  }

  @Test
  public void testUpdateTableWithSelectedFields() {
    String tableName = "test_update_with_selected_fields_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    Table updatedTable = bigquery.update(tableInfo.toBuilder().description("newDescr").build(),
        TableOption.fields(TableField.DESCRIPTION));
    assertTrue(updatedTable.definition() instanceof StandardTableDefinition);
    assertEquals(DATASET, updatedTable.tableId().dataset());
    assertEquals(tableName, updatedTable.tableId().table());
    assertEquals("newDescr", updatedTable.description());
    assertNull(updatedTable.definition().schema());
    assertNull(updatedTable.lastModifiedTime());
    assertNull(updatedTable.<StandardTableDefinition>definition().numBytes());
    assertNull(updatedTable.<StandardTableDefinition>definition().numRows());
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
      BigQueryError error = e.error();
      assertNotNull(error);
      assertEquals("notFound", error.reason());
      assertNotNull(error.message());
    }
  }

  @Test
  public void testDeleteNonExistingTable() {
    assertFalse(bigquery.delete(DATASET, "test_delete_non_existing_table"));
  }

  @Test
  public void testInsertAll() {
    String tableName = "test_insert_all_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    InsertAllRequest request = InsertAllRequest.builder(tableInfo.tableId())
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "2014-08-19 07:41:35.220 -05:00",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false,
            "RecordField", ImmutableMap.of(
                "TimestampField", "1969-07-20 20:18:04 UTC",
                "IntegerField", ImmutableList.of(1, 0),
                "BooleanField", true)))
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "2014-08-19 07:41:35.220 -05:00",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false,
            "RecordField", ImmutableMap.of(
                "TimestampField", "1969-07-20 20:18:04 UTC",
                "IntegerField", ImmutableList.of(1, 0),
                "BooleanField", true)))
        .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.insertErrors().size());
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
  }

  @Test
  public void testInsertAllWithSuffix() throws InterruptedException {
    String tableName = "test_insert_all_with_suffix_table";
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), tableDefinition);
    assertNotNull(bigquery.create(tableInfo));
    InsertAllRequest request = InsertAllRequest.builder(tableInfo.tableId())
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "2014-08-19 07:41:35.220 -05:00",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false,
            "RecordField", ImmutableMap.of(
                "TimestampField", "1969-07-20 20:18:04 UTC",
                "IntegerField", ImmutableList.of(1, 0),
                "BooleanField", true)))
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "2014-08-19 07:41:35.220 -05:00",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false,
            "RecordField", ImmutableMap.of(
                "TimestampField", "1969-07-20 20:18:04 UTC",
                "IntegerField", ImmutableList.of(1, 0),
                "BooleanField", true)))
        .templateSuffix("_suffix")
        .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertFalse(response.hasErrors());
    assertEquals(0, response.insertErrors().size());
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
    InsertAllRequest request = InsertAllRequest.builder(tableInfo.tableId())
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "2014-08-19 07:41:35.220 -05:00",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false,
            "RecordField", ImmutableMap.of(
                "TimestampField", "1969-07-20 20:18:04 UTC",
                "IntegerField", ImmutableList.of(1, 0),
                "BooleanField", true)))
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "invalidDate",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false,
            "RecordField", ImmutableMap.of(
                "TimestampField", "1969-07-20 20:18:04 UTC",
                "IntegerField", ImmutableList.of(1, 0),
                "BooleanField", true)))
        .addRow(ImmutableMap.<String, Object>of(
            "TimestampField", "1969-07-20 20:18:04 UTC",
            "StringField", "stringValue",
            "IntegerField", ImmutableList.of(0, 1),
            "BooleanField", false))
        .skipInvalidRows(true)
        .build();
    InsertAllResponse response = bigquery.insertAll(request);
    assertTrue(response.hasErrors());
    assertEquals(2, response.insertErrors().size());
    assertNotNull(response.errorsFor(1L));
    assertNotNull(response.errorsFor(2L));
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
  }

  @Test
  public void testListAllTableData() {
    Page<List<FieldValue>> rows = bigquery.listTableData(TABLE_ID);
    int rowCount = 0;
    for (List<FieldValue> row : rows.values()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      FieldValue recordCell = row.get(4);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.attribute());
      assertEquals(FieldValue.Attribute.REPEATED, integerCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.attribute());
      assertEquals(FieldValue.Attribute.RECORD, recordCell.attribute());
      assertEquals(1408452095220000L, timestampCell.timestampValue());
      assertEquals("stringValue", stringCell.stringValue());
      assertEquals(0, integerCell.repeatedValue().get(0).longValue());
      assertEquals(1, integerCell.repeatedValue().get(1).longValue());
      assertEquals(false, booleanCell.booleanValue());
      assertEquals(-14182916000000L, recordCell.recordValue().get(0).timestampValue());
      assertTrue(recordCell.recordValue().get(1).isNull());
      assertEquals(1, recordCell.recordValue().get(2).repeatedValue().get(0).longValue());
      assertEquals(0, recordCell.recordValue().get(2).repeatedValue().get(1).longValue());
      assertEquals(true, recordCell.recordValue().get(3).booleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
  }

  @Test
  public void testQuery() throws InterruptedException {
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.table())
        .toString();
    QueryRequest request = QueryRequest.builder(query)
        .defaultDataset(DatasetId.of(DATASET))
        .maxWaitTime(60000L)
        .pageSize(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobCompleted()) {
      Thread.sleep(1000);
      response = bigquery.getQueryResults(response.jobId());
    }
    assertEquals(QUERY_RESULT_SCHEMA, response.result().schema());
    int rowCount = 0;
    for (List<FieldValue> row : response.result().values()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.attribute());
      assertEquals(1408452095220000L, timestampCell.timestampValue());
      assertEquals("stringValue", stringCell.stringValue());
      assertEquals(false, booleanCell.booleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    Job queryJob = bigquery.getJob(response.jobId());
    JobStatistics.QueryStatistics statistics = queryJob.statistics();
    assertNotNull(statistics.queryPlan());
  }

  @Test
  public void testListJobs() {
    Page<Job> jobs = bigquery.listJobs();
    for (Job job : jobs.values()) {
      assertNotNull(job.jobId());
      assertNotNull(job.statistics());
      assertNotNull(job.status());
      assertNotNull(job.userEmail());
      assertNotNull(job.generatedId());
    }
  }

  @Test
  public void testListJobsWithSelectedFields() {
    Page<Job> jobs = bigquery.listJobs(JobListOption.fields(JobField.USER_EMAIL));
    for (Job job : jobs.values()) {
      assertNotNull(job.jobId());
      assertNotNull(job.status());
      assertNotNull(job.userEmail());
      assertNull(job.statistics());
      assertNull(job.generatedId());
    }
  }

  @Test
  public void testCreateAndGetJob() {
    String sourceTableName = "test_create_and_get_job_source_table";
    String destinationTableName = "test_create_and_get_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(sourceTableName, createdTable.tableId().table());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration copyJobConfiguration =
        CopyJobConfiguration.of(destinationTable, sourceTable);
    Job createdJob = bigquery.create(JobInfo.of(copyJobConfiguration));
    Job remoteJob = bigquery.getJob(createdJob.jobId());
    assertEquals(createdJob.jobId(), remoteJob.jobId());
    CopyJobConfiguration createdConfiguration = createdJob.configuration();
    CopyJobConfiguration remoteConfiguration = remoteJob.configuration();
    assertEquals(createdConfiguration.sourceTables(), remoteConfiguration.sourceTables());
    assertEquals(createdConfiguration.destinationTable(), remoteConfiguration.destinationTable());
    assertEquals(createdConfiguration.createDisposition(), remoteConfiguration.createDisposition());
    assertEquals(createdConfiguration.writeDisposition(), remoteConfiguration.writeDisposition());
    assertNotNull(remoteJob.etag());
    assertNotNull(remoteJob.statistics());
    assertNotNull(remoteJob.status());
    assertEquals(createdJob.selfLink(), remoteJob.selfLink());
    assertEquals(createdJob.userEmail(), remoteJob.userEmail());
    assertTrue(createdTable.delete());
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testCreateAndGetJobWithSelectedFields() {
    String sourceTableName = "test_create_and_get_job_with_selected_fields_source_table";
    String destinationTableName = "test_create_and_get_job_with_selected_fields_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(sourceTableName, createdTable.tableId().table());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, sourceTable);
    Job createdJob = bigquery.create(JobInfo.of(configuration), JobOption.fields(JobField.ETAG));
    CopyJobConfiguration createdConfiguration = createdJob.configuration();
    assertNotNull(createdJob.jobId());
    assertNotNull(createdConfiguration.sourceTables());
    assertNotNull(createdConfiguration.destinationTable());
    assertNotNull(createdJob.etag());
    assertNull(createdJob.statistics());
    assertNull(createdJob.status());
    assertNull(createdJob.selfLink());
    assertNull(createdJob.userEmail());
    Job remoteJob = bigquery.getJob(createdJob.jobId(), JobOption.fields(JobField.ETAG));
    CopyJobConfiguration remoteConfiguration = remoteJob.configuration();
    assertEquals(createdJob.jobId(), remoteJob.jobId());
    assertEquals(createdConfiguration.sourceTables(), remoteConfiguration.sourceTables());
    assertEquals(createdConfiguration.destinationTable(), remoteConfiguration.destinationTable());
    assertEquals(createdConfiguration.createDisposition(), remoteConfiguration.createDisposition());
    assertEquals(createdConfiguration.writeDisposition(), remoteConfiguration.writeDisposition());
    assertNotNull(remoteJob.etag());
    assertNull(remoteJob.statistics());
    assertNull(remoteJob.status());
    assertNull(remoteJob.selfLink());
    assertNull(remoteJob.userEmail());
    assertTrue(createdTable.delete());
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testCopyJob() throws InterruptedException {
    String sourceTableName = "test_copy_job_source_table";
    String destinationTableName = "test_copy_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    StandardTableDefinition tableDefinition = StandardTableDefinition.of(TABLE_SCHEMA);
    TableInfo tableInfo = TableInfo.of(sourceTable, tableDefinition);
    Table createdTable = bigquery.create(tableInfo);
    assertNotNull(createdTable);
    assertEquals(DATASET, createdTable.tableId().dataset());
    assertEquals(sourceTableName, createdTable.tableId().table());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobConfiguration configuration = CopyJobConfiguration.of(destinationTable, sourceTable);
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    while (!remoteJob.isDone()) {
      Thread.sleep(1000);
    }
    assertNull(remoteJob.status().error());
    Table remoteTable = bigquery.getTable(DATASET, destinationTableName);
    assertNotNull(remoteTable);
    assertEquals(destinationTable.dataset(), remoteTable.tableId().dataset());
    assertEquals(destinationTableName, remoteTable.tableId().table());
    assertEquals(TABLE_SCHEMA, remoteTable.definition().schema());
    assertTrue(createdTable.delete());
    assertTrue(remoteTable.delete());
  }

  @Test
  public void testQueryJob() throws InterruptedException {
    String tableName = "test_query_job_table";
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.table())
        .toString();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobConfiguration configuration = QueryJobConfiguration.builder(query)
        .defaultDataset(DatasetId.of(DATASET))
        .destinationTable(destinationTable)
        .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    while (!remoteJob.isDone()) {
      Thread.sleep(1000);
    }
    assertNull(remoteJob.status().error());

    QueryResponse response = bigquery.getQueryResults(remoteJob.jobId());
    while (!response.jobCompleted()) {
      Thread.sleep(1000);
      response = bigquery.getQueryResults(response.jobId());
    }
    assertFalse(response.hasErrors());
    assertEquals(QUERY_RESULT_SCHEMA, response.result().schema());
    int rowCount = 0;
    for (List<FieldValue> row : response.result().values()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue booleanCell = row.get(2);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.attribute());
      assertEquals(1408452095220000L, timestampCell.timestampValue());
      assertEquals("stringValue", stringCell.stringValue());
      assertEquals(false, booleanCell.booleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(bigquery.delete(DATASET, tableName));
    Job queryJob = bigquery.getJob(remoteJob.jobId());
    JobStatistics.QueryStatistics statistics = queryJob.statistics();
    assertNotNull(statistics.queryPlan());
  }

  @Test
  public void testExtractJob() throws InterruptedException {
    String tableName = "test_export_job_table";
    TableId destinationTable = TableId.of(DATASET, tableName);
    LoadJobConfiguration configuration =
        LoadJobConfiguration.builder(destinationTable, "gs://" + BUCKET + "/" + LOAD_FILE)
            .schema(SIMPLE_SCHEMA)
            .build();
    Job remoteLoadJob = bigquery.create(JobInfo.of(configuration));
    while (!remoteLoadJob.isDone()) {
      Thread.sleep(1000);
    }
    assertNull(remoteLoadJob.status().error());

    ExtractJobConfiguration extractConfiguration =
        ExtractJobConfiguration.builder(destinationTable, "gs://" + BUCKET + "/" + EXTRACT_FILE)
            .printHeader(false)
            .build();
    Job remoteExtractJob = bigquery.create(JobInfo.of(extractConfiguration));
    while (!remoteExtractJob.isDone()) {
      Thread.sleep(1000);
    }
    assertNull(remoteExtractJob.status().error());
    assertEquals(CSV_CONTENT,
        new String(storage.readAllBytes(BUCKET, EXTRACT_FILE), StandardCharsets.UTF_8));
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testCancelJob() throws InterruptedException {
    String destinationTableName = "test_cancel_query_job_table";
    String query = "SELECT TimestampField, StringField, BooleanField FROM " + TABLE_ID.table();
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    QueryJobConfiguration configuration = QueryJobConfiguration.builder(query)
        .defaultDataset(DatasetId.of(DATASET))
        .destinationTable(destinationTable)
        .build();
    Job remoteJob = bigquery.create(JobInfo.of(configuration));
    assertTrue(remoteJob.cancel());
    while (!remoteJob.isDone()) {
      Thread.sleep(1000);
    }
    assertNull(remoteJob.status().error());
  }

  @Test
  public void testCancelNonExistingJob() {
    assertFalse(bigquery.cancel("test_cancel_non_existing_job"));
  }

  @Test
  public void testInsertFromFile() throws InterruptedException {
    String destinationTableName = "test_insert_from_file_table";
    TableId tableId = TableId.of(DATASET, destinationTableName);
    WriteChannelConfiguration configuration = WriteChannelConfiguration.builder(tableId)
        .formatOptions(FormatOptions.json())
        .createDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
        .schema(TABLE_SCHEMA)
        .build();
    try (WriteChannel channel = bigquery.writer(configuration)) {
      channel.write(ByteBuffer.wrap(JSON_CONTENT.getBytes(StandardCharsets.UTF_8)));
    } catch (IOException e) {
      fail("IOException was not expected");
    }
    // wait until the new table is created. If the table is never created the test will time-out
    while (bigquery.getTable(tableId) == null) {
      Thread.sleep(1000L);
    }
    Page<List<FieldValue>> rows = bigquery.listTableData(tableId);
    int rowCount = 0;
    for (List<FieldValue> row : rows.values()) {
      FieldValue timestampCell = row.get(0);
      FieldValue stringCell = row.get(1);
      FieldValue integerCell = row.get(2);
      FieldValue booleanCell = row.get(3);
      FieldValue recordCell = row.get(4);
      assertEquals(FieldValue.Attribute.PRIMITIVE, timestampCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, stringCell.attribute());
      assertEquals(FieldValue.Attribute.REPEATED, integerCell.attribute());
      assertEquals(FieldValue.Attribute.PRIMITIVE, booleanCell.attribute());
      assertEquals(FieldValue.Attribute.RECORD, recordCell.attribute());
      assertEquals(1408452095220000L, timestampCell.timestampValue());
      assertEquals("stringValue", stringCell.stringValue());
      assertEquals(0, integerCell.repeatedValue().get(0).longValue());
      assertEquals(1, integerCell.repeatedValue().get(1).longValue());
      assertEquals(false, booleanCell.booleanValue());
      assertEquals(-14182916000000L, recordCell.recordValue().get(0).timestampValue());
      assertTrue(recordCell.recordValue().get(1).isNull());
      assertEquals(1, recordCell.recordValue().get(2).repeatedValue().get(0).longValue());
      assertEquals(0, recordCell.recordValue().get(2).repeatedValue().get(1).longValue());
      assertEquals(true, recordCell.recordValue().get(3).booleanValue());
      rowCount++;
    }
    assertEquals(2, rowCount);
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }
}
