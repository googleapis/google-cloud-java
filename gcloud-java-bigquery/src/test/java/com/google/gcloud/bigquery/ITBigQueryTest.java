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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.Page;
import com.google.gcloud.bigquery.BigQuery.DatasetOption;
import com.google.gcloud.bigquery.BigQuery.JobListOption;
import com.google.gcloud.bigquery.BigQuery.JobOption;
import com.google.gcloud.bigquery.BigQuery.TableOption;
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
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITBigQueryTest {

  private static final Logger log = Logger.getLogger(ITBigQueryTest.class.getName());
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
  public static void beforeClass() throws IOException, InterruptedException {
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
    LoadJobInfo job = LoadJobInfo.builder(TABLE_ID, "gs://" + BUCKET + "/" + JSON_LOAD_FILE)
        .createDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
        .schema(TABLE_SCHEMA)
        .formatOptions(FormatOptions.json())
        .build();
    job = bigquery.create(job);
    while (job.status().state() != JobStatus.State.DONE) {
      Thread.sleep(1000);
      job = bigquery.getJob(job.jobId());
    }
    assertNull(job.status().error());
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
    }
    if (storage != null && !RemoteGcsHelper.forceDelete(storage, BUCKET, 10, TimeUnit.SECONDS)) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void testGetDataset() {
    DatasetInfo dataset = bigquery.getDataset(DATASET);
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(DATASET, dataset.datasetId().dataset());
    assertEquals(DESCRIPTION, dataset.description());
    assertNotNull(dataset.acl());
    assertNotNull(dataset.etag());
    assertNotNull(dataset.id());
    assertNotNull(dataset.lastModified());
    assertNotNull(dataset.selfLink());
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    DatasetInfo dataset = bigquery.getDataset(DATASET,
        DatasetOption.fields(BigQuery.DatasetField.CREATION_TIME));
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(DATASET, dataset.datasetId().dataset());
    assertNotNull(dataset.creationTime());
    assertNull(dataset.description());
    assertNull(dataset.defaultTableLifetime());
    assertNull(dataset.acl());
    assertNull(dataset.etag());
    assertNull(dataset.friendlyName());
    assertNull(dataset.id());
    assertNull(dataset.lastModified());
    assertNull(dataset.location());
    assertNull(dataset.selfLink());
  }

  @Test
  public void testUpdateDataset() {
    DatasetInfo dataset = bigquery.create(DatasetInfo.builder(OTHER_DATASET)
        .description("Some Description")
        .build());
    assertNotNull(dataset);
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(OTHER_DATASET, dataset.datasetId().dataset());
    assertEquals("Some Description", dataset.description());
    DatasetInfo updatedDataset =
        bigquery.update(dataset.toBuilder().description("Updated Description").build());
    assertEquals("Updated Description", updatedDataset.description());
    assertTrue(bigquery.delete(OTHER_DATASET));
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    DatasetInfo dataset = bigquery.create(DatasetInfo.builder(OTHER_DATASET)
        .description("Some Description")
        .build());
    assertNotNull(dataset);
    assertEquals(bigquery.options().projectId(), dataset.datasetId().project());
    assertEquals(OTHER_DATASET, dataset.datasetId().dataset());
    assertEquals("Some Description", dataset.description());
    DatasetInfo updatedDataset =
        bigquery.update(dataset.toBuilder().description("Updated Description").build(),
            DatasetOption.fields(BigQuery.DatasetField.DESCRIPTION));
    assertEquals("Updated Description", updatedDataset.description());
    assertNull(updatedDataset.creationTime());
    assertNull(updatedDataset.defaultTableLifetime());
    assertNull(updatedDataset.acl());
    assertNull(updatedDataset.etag());
    assertNull(updatedDataset.friendlyName());
    assertNull(updatedDataset.id());
    assertNull(updatedDataset.lastModified());
    assertNull(updatedDataset.location());
    assertNull(updatedDataset.selfLink());
    assertTrue(bigquery.delete(OTHER_DATASET));
  }

  @Test
  public void testCreateAndGetTable() {
    String tableName = "test_create_and_get_table";
    TableId tableId = TableId.of(DATASET, tableName);
    BaseTableInfo createdTableInfo = bigquery.create(TableInfo.of(tableId, TABLE_SCHEMA));
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(tableName, createdTableInfo.tableId().table());
    BaseTableInfo remoteTableInfo = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTableInfo);
    assertTrue(remoteTableInfo instanceof TableInfo);
    assertEquals(createdTableInfo.tableId(), remoteTableInfo.tableId());
    assertEquals(BaseTableInfo.Type.TABLE, remoteTableInfo.type());
    assertEquals(TABLE_SCHEMA, remoteTableInfo.schema());
    assertNotNull(remoteTableInfo.creationTime());
    assertNotNull(remoteTableInfo.lastModifiedTime());
    assertNotNull(remoteTableInfo.numBytes());
    assertNotNull(remoteTableInfo.numRows());
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testCreateAndGetTableWithSelectedField() {
    String tableName = "test_create_and_get_selected_fields_table";
    TableId tableId = TableId.of(DATASET, tableName);
    BaseTableInfo createdTableInfo = bigquery.create(TableInfo.of(tableId, TABLE_SCHEMA));
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(tableName, createdTableInfo.tableId().table());
    BaseTableInfo remoteTableInfo = bigquery.getTable(DATASET, tableName,
        TableOption.fields(BigQuery.TableField.CREATION_TIME));
    assertNotNull(remoteTableInfo);
    assertTrue(remoteTableInfo instanceof TableInfo);
    assertEquals(createdTableInfo.tableId(), remoteTableInfo.tableId());
    assertEquals(BaseTableInfo.Type.TABLE, remoteTableInfo.type());
    assertNotNull(remoteTableInfo.creationTime());
    assertNull(remoteTableInfo.schema());
    assertNull(remoteTableInfo.lastModifiedTime());
    assertNull(remoteTableInfo.numBytes());
    assertNull(remoteTableInfo.numRows());
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testCreateExternalTable() throws InterruptedException {
    String tableName = "test_create_external_table";
    TableId tableId = TableId.of(DATASET, tableName);
    ExternalDataConfiguration externalDataConfiguration = ExternalDataConfiguration.of(
        "gs://" + BUCKET + "/" + JSON_LOAD_FILE, TABLE_SCHEMA, FormatOptions.json());
    BaseTableInfo tableInfo = ExternalTableInfo.of(tableId, externalDataConfiguration);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(tableName, createdTableInfo.tableId().table());
    BaseTableInfo remoteTableInfo = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTableInfo);
    assertTrue(remoteTableInfo instanceof ExternalTableInfo);
    assertEquals(createdTableInfo.tableId(), remoteTableInfo.tableId());
    assertEquals(TABLE_SCHEMA, remoteTableInfo.schema());
    QueryRequest request = QueryRequest.builder(
        "SELECT TimestampField, StringField, IntegerField, BooleanField FROM " + DATASET + "."
            + tableName)
        .defaultDataset(DatasetId.of(DATASET))
        .maxWaitTime(60000L)
        .maxResults(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobComplete()) {
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
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testCreateViewTable() throws InterruptedException {
    String tableName = "test_create_view_table";
    TableId tableId = TableId.of(DATASET, tableName);
    BaseTableInfo tableInfo = ViewInfo.of(tableId,
        "SELECT TimestampField, StringField, BooleanField FROM " + DATASET + "."
            + TABLE_ID.table());
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(tableName, createdTableInfo.tableId().table());
    BaseTableInfo remoteTableInfo = bigquery.getTable(DATASET, tableName);
    assertNotNull(remoteTableInfo);
    assertEquals(createdTableInfo.tableId(), remoteTableInfo.tableId());
    assertTrue(remoteTableInfo instanceof ViewInfo);
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
    assertEquals(expectedSchema, remoteTableInfo.schema());
    QueryRequest request = QueryRequest.builder("SELECT * FROM " + tableName)
        .defaultDataset(DatasetId.of(DATASET))
        .maxWaitTime(60000L)
        .maxResults(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobComplete()) {
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
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testListTables() {
    String tableName = "test_list_tables";
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), TABLE_SCHEMA);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    Page<BaseTableInfo> tables = bigquery.listTables(DATASET);
    boolean found = false;
    Iterator<BaseTableInfo> tableIterator = tables.values().iterator();
    while (tableIterator.hasNext() && !found) {
      if (tableIterator.next().tableId().equals(createdTableInfo.tableId())) {
        found = true;
      }
    }
    assertTrue(found);
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testUdpateTable() {
    String tableName = "test_update_table";
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), TABLE_SCHEMA);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    BaseTableInfo updatedTableInfo = bigquery.update(tableInfo.toBuilder()
        .description("newDescription").build());
    assertEquals(DATASET, updatedTableInfo.tableId().dataset());
    assertEquals(tableName, updatedTableInfo.tableId().table());
    assertEquals(TABLE_SCHEMA, updatedTableInfo.schema());
    assertEquals("newDescription", updatedTableInfo.description());
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testUdpateTableWithSelectedFields() {
    String tableName = "test_update_with_selected_fields_table";
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), TABLE_SCHEMA);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    BaseTableInfo updatedTableInfo = bigquery.update(tableInfo.toBuilder().description("newDescr")
        .build(), TableOption.fields(BigQuery.TableField.DESCRIPTION));
    assertTrue(updatedTableInfo instanceof TableInfo);
    assertEquals(DATASET, updatedTableInfo.tableId().dataset());
    assertEquals(tableName, updatedTableInfo.tableId().table());
    assertEquals("newDescr", updatedTableInfo.description());
    assertNull(updatedTableInfo.schema());
    assertNull(updatedTableInfo.lastModifiedTime());
    assertNull(updatedTableInfo.numBytes());
    assertNull(updatedTableInfo.numRows());
    assertTrue(bigquery.delete(DATASET, tableName));
  }

  @Test
  public void testInsertAll() {
    String tableName = "test_insert_all_table";
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), TABLE_SCHEMA);
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
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), TABLE_SCHEMA);
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
    BaseTableInfo suffixTable = bigquery.getTable(DATASET, newTableName, TableOption.fields());
    // wait until the new table is created. If the table is never created the test will time-out
    while (suffixTable == null) {
      Thread.sleep(1000L);
      suffixTable = bigquery.getTable(DATASET, newTableName, TableOption.fields());
    }
    assertTrue(bigquery.delete(TableId.of(DATASET, tableName)));
    assertTrue(bigquery.delete(TableId.of(DATASET, newTableName)));
  }

  @Test
  public void testInsertAllWithErrors() {
    String tableName = "test_insert_all_with_errors_table";
    BaseTableInfo tableInfo = TableInfo.of(TableId.of(DATASET, tableName), TABLE_SCHEMA);
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
        .maxResults(1000L)
        .build();
    QueryResponse response = bigquery.query(request);
    while (!response.jobComplete()) {
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
    QueryJobInfo queryJob = bigquery.getJob(response.jobId());
    assertNotNull(queryJob.statistics().queryPlan());
  }

  @Test
  public void testListJobs() {
    Page<JobInfo> jobs = bigquery.listJobs();
    for (JobInfo job : jobs.values()) {
      assertNotNull(job.jobId());
      assertNotNull(job.statistics());
      assertNotNull(job.status());
      assertNotNull(job.userEmail());
      assertNotNull(job.id());
    }
  }

  @Test
  public void testListJobsWithSelectedFields() {
    Page<JobInfo> jobs = bigquery.listJobs(JobListOption.fields(BigQuery.JobField.USER_EMAIL));
    for (JobInfo job : jobs.values()) {
      assertNotNull(job.jobId());
      assertNotNull(job.status());
      assertNotNull(job.userEmail());
      assertNull(job.statistics());
      assertNull(job.id());
    }
  }

  @Test
  public void testCreateAndGetJob() throws InterruptedException {
    String sourceTableName = "test_create_and_get_job_source_table";
    String destinationTableName = "test_create_and_get_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    BaseTableInfo tableInfo = TableInfo.of(sourceTable, SIMPLE_SCHEMA);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(sourceTableName, createdTableInfo.tableId().table());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobInfo job = CopyJobInfo.of(destinationTable, sourceTable);
    CopyJobInfo createdJob = bigquery.create(job);
    CopyJobInfo remoteJob = bigquery.getJob(createdJob.jobId());
    assertEquals(createdJob.jobId(), remoteJob.jobId());
    assertEquals(createdJob.sourceTables(), remoteJob.sourceTables());
    assertEquals(createdJob.destinationTable(), remoteJob.destinationTable());
    assertEquals(createdJob.createDisposition(), remoteJob.createDisposition());
    assertEquals(createdJob.writeDisposition(), remoteJob.writeDisposition());
    assertNotNull(remoteJob.etag());
    assertNotNull(remoteJob.statistics());
    assertNotNull(remoteJob.status());
    assertEquals(createdJob.selfLink(), remoteJob.selfLink());
    assertEquals(createdJob.userEmail(), remoteJob.userEmail());
    assertTrue(bigquery.delete(DATASET, sourceTableName));
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testCreateAndGetJobWithSelectedFields() throws InterruptedException {
    String sourceTableName = "test_create_and_get_job_with_selected_fields_source_table";
    String destinationTableName = "test_create_and_get_job_with_selected_fields_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    BaseTableInfo tableInfo = TableInfo.of(sourceTable, SIMPLE_SCHEMA);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(sourceTableName, createdTableInfo.tableId().table());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobInfo job = CopyJobInfo.of(destinationTable, sourceTable);
    CopyJobInfo createdJob = bigquery.create(job, JobOption.fields(BigQuery.JobField.ETAG));
    assertNotNull(createdJob.jobId());
    assertNotNull(createdJob.sourceTables());
    assertNotNull(createdJob.destinationTable());
    assertNotNull(createdJob.etag());
    assertNull(createdJob.statistics());
    assertNull(createdJob.status());
    assertNull(createdJob.selfLink());
    assertNull(createdJob.userEmail());
    CopyJobInfo remoteJob = bigquery.getJob(createdJob.jobId(),
        JobOption.fields(BigQuery.JobField.ETAG));
    assertEquals(createdJob.jobId(), remoteJob.jobId());
    assertEquals(createdJob.sourceTables(), remoteJob.sourceTables());
    assertEquals(createdJob.destinationTable(), remoteJob.destinationTable());
    assertEquals(createdJob.createDisposition(), remoteJob.createDisposition());
    assertEquals(createdJob.writeDisposition(), remoteJob.writeDisposition());
    assertNotNull(remoteJob.etag());
    assertNull(remoteJob.statistics());
    assertNull(remoteJob.status());
    assertNull(remoteJob.selfLink());
    assertNull(remoteJob.userEmail());
    assertTrue(bigquery.delete(DATASET, sourceTableName));
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testCopyJob() throws InterruptedException {
    String sourceTableName = "test_copy_job_source_table";
    String destinationTableName = "test_copy_job_destination_table";
    TableId sourceTable = TableId.of(DATASET, sourceTableName);
    BaseTableInfo tableInfo = TableInfo.of(sourceTable, SIMPLE_SCHEMA);
    BaseTableInfo createdTableInfo = bigquery.create(tableInfo);
    assertNotNull(createdTableInfo);
    assertEquals(DATASET, createdTableInfo.tableId().dataset());
    assertEquals(sourceTableName, createdTableInfo.tableId().table());
    TableId destinationTable = TableId.of(DATASET, destinationTableName);
    CopyJobInfo job = CopyJobInfo.of(destinationTable, sourceTable);
    CopyJobInfo remoteJob = bigquery.create(job);
    while (remoteJob.status().state() != JobStatus.State.DONE) {
      Thread.sleep(1000);
      remoteJob = bigquery.getJob(remoteJob.jobId());
    }
    assertNull(remoteJob.status().error());
    BaseTableInfo remoteTableInfo = bigquery.getTable(DATASET, destinationTableName);
    assertNotNull(remoteTableInfo);
    assertEquals(destinationTable.dataset(), remoteTableInfo.tableId().dataset());
    assertEquals(destinationTableName, remoteTableInfo.tableId().table());
    assertEquals(SIMPLE_SCHEMA, remoteTableInfo.schema());
    assertTrue(bigquery.delete(DATASET, sourceTableName));
    assertTrue(bigquery.delete(DATASET, destinationTableName));
  }

  @Test
  public void testQueryJob() throws InterruptedException {
    String tableName = "test_query_job_table";
    String query = new StringBuilder()
        .append("SELECT TimestampField, StringField, BooleanField FROM ")
        .append(TABLE_ID.table())
        .toString();
    TableId destinationTable = TableId.of(DATASET, tableName);
    QueryJobInfo job = QueryJobInfo.builder(query)
        .defaultDataset(DatasetId.of(DATASET))
        .destinationTable(destinationTable)
        .build();
    QueryJobInfo remoteJob = bigquery.create(job);
    while (remoteJob.status().state() != JobStatus.State.DONE) {
      Thread.sleep(1000);
      remoteJob = bigquery.getJob(remoteJob.jobId());
    }
    assertNull(remoteJob.status().error());

    QueryResponse response = bigquery.getQueryResults(remoteJob.jobId());
    while (!response.jobComplete()) {
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
    QueryJobInfo queryJob = bigquery.getJob(remoteJob.jobId());
    assertNotNull(queryJob.statistics().queryPlan());
  }

  @Test
  public void testExtractJob() throws InterruptedException {
    String tableName = "test_export_job_table";
    TableId destinationTable = TableId.of(DATASET, tableName);
    LoadJobInfo remoteLoadJob = bigquery.create(
        LoadJobInfo.builder(destinationTable, "gs://" + BUCKET + "/" + LOAD_FILE)
            .schema(SIMPLE_SCHEMA)
            .build());
    while (remoteLoadJob.status().state() != JobStatus.State.DONE) {
      Thread.sleep(1000);
      remoteLoadJob = bigquery.getJob(remoteLoadJob.jobId());
    }
    assertNull(remoteLoadJob.status().error());

    ExtractJobInfo extractJob =
        ExtractJobInfo.builder(destinationTable, "gs://" + BUCKET + "/" + EXTRACT_FILE)
          .printHeader(false)
          .build();
    ExtractJobInfo remoteExtractJob = bigquery.create(extractJob);
    while (remoteExtractJob.status().state() != JobStatus.State.DONE) {
      Thread.sleep(1000);
      remoteExtractJob = bigquery.getJob(remoteExtractJob.jobId());
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
    QueryJobInfo job = QueryJobInfo.builder(query)
        .defaultDataset(DatasetId.of(DATASET))
        .destinationTable(destinationTable)
        .build();
    JobInfo remoteJob = bigquery.create(job);
    assertTrue(bigquery.cancel(remoteJob.jobId()));
    while (remoteJob.status().state() != JobStatus.State.DONE) {
      Thread.sleep(1000);
      remoteJob = bigquery.getJob(remoteJob.jobId());
    }
    assertNull(remoteJob.status().error());
  }
}
