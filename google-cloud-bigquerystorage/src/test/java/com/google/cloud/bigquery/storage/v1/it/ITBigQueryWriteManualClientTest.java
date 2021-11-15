/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.*;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.storage.test.Test.*;
import com.google.cloud.bigquery.storage.v1.*;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;

/** Integration tests for BigQuery Write API. */
public class ITBigQueryWriteManualClientTest {
  private static final Logger LOG =
      Logger.getLogger(ITBigQueryWriteManualClientTest.class.getName());
  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String DATASET_EU = RemoteBigQueryHelper.generateDatasetName();
  private static final String TABLE = "testtable";
  private static final String TABLE2 = "complicatedtable";
  private static final String DESCRIPTION = "BigQuery Write Java manual client test dataset";

  private static BigQueryWriteClient client;
  private static TableInfo tableInfo;
  private static TableInfo tableInfo2;
  private static TableInfo tableInfoEU;
  private static String tableId;
  private static String tableId2;
  private static String tableIdEU;
  private static BigQuery bigquery;

  @BeforeClass
  public static void beforeClass() throws IOException {
    client = BigQueryWriteClient.create();

    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(/* datasetId = */ DATASET).setDescription(DESCRIPTION).build();
    bigquery.create(datasetInfo);
    LOG.info("Created test dataset: " + DATASET);
    tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, TABLE),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder("foo", LegacySQLTypeName.STRING)
                            .setMode(Field.Mode.NULLABLE)
                            .build())))
            .build();
    com.google.cloud.bigquery.Field.Builder innerTypeFieldBuilder =
        com.google.cloud.bigquery.Field.newBuilder(
            "inner_type",
            LegacySQLTypeName.RECORD,
            com.google.cloud.bigquery.Field.newBuilder("value", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.REPEATED)
                .build());

    tableInfo2 =
        TableInfo.newBuilder(
                TableId.of(DATASET, TABLE2),
                StandardTableDefinition.of(
                    Schema.of(
                        Field.newBuilder(
                                "nested_repeated_type",
                                LegacySQLTypeName.RECORD,
                                innerTypeFieldBuilder.setMode(Field.Mode.REPEATED).build())
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        innerTypeFieldBuilder.setMode(Field.Mode.NULLABLE).build())))
            .build();
    bigquery.create(tableInfo);
    bigquery.create(tableInfo2);
    tableId =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            ServiceOptions.getDefaultProjectId(), DATASET, TABLE);
    tableId2 =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            ServiceOptions.getDefaultProjectId(), DATASET, TABLE2);
    DatasetInfo datasetInfoEU =
        DatasetInfo.newBuilder(/* datasetId = */ DATASET_EU)
            .setLocation("EU")
            .setDescription(DESCRIPTION)
            .build();
    bigquery.create(datasetInfoEU);
    tableInfoEU =
        TableInfo.newBuilder(
                TableId.of(DATASET_EU, TABLE),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder("foo", LegacySQLTypeName.STRING)
                            .build())))
            .build();
    tableIdEU =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            ServiceOptions.getDefaultProjectId(), DATASET_EU, TABLE);
    bigquery.create(tableInfoEU);
  }

  @AfterClass
  public static void afterClass() {
    if (client != null) {
      client.close();
    }

    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, DATASET);
      LOG.info("Deleted test dataset: " + DATASET);
    }
  }

  ProtoRows CreateProtoRows(String[] messages) {
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (String message : messages) {
      FooType foo = FooType.newBuilder().setFoo(message).build();
      rows.addSerializedRows(foo.toByteString());
    }
    return rows.build();
  }

  ProtoRows CreateProtoRowsMultipleColumns(String[] messages) {
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (String message : messages) {
      UpdatedFooType foo = UpdatedFooType.newBuilder().setFoo(message).setBar(message).build();
      rows.addSerializedRows(foo.toByteString());
    }
    return rows.build();
  }

  ProtoRows CreateProtoRowsComplex(String[] messages) {
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (String message : messages) {
      ComplicateType foo =
          ComplicateType.newBuilder()
              .setInnerType(InnerType.newBuilder().addValue(message).addValue(message).build())
              .build();
      rows.addSerializedRows(foo.toByteString());
    }
    return rows.build();
  }

  @Test
  public void testBatchWriteWithCommittedStreamEU()
      throws IOException, InterruptedException, ExecutionException {
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableIdEU)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .build();
    LOG.info("Sending one message");

    ApiFuture<AppendRowsResponse> response =
        streamWriter.append(CreateProtoRows(new String[] {"aaa"}), 0);
    assertEquals(0, response.get().getAppendResult().getOffset().getValue());

    LOG.info("Sending two more messages");
    ApiFuture<AppendRowsResponse> response1 =
        streamWriter.append(CreateProtoRows(new String[] {"bbb", "ccc"}), 1);
    ApiFuture<AppendRowsResponse> response2 =
        streamWriter.append(CreateProtoRows(new String[] {"ddd"}), 3);
    assertEquals(1, response1.get().getAppendResult().getOffset().getValue());
    assertEquals(3, response2.get().getAppendResult().getOffset().getValue());

    TableResult result =
        bigquery.listTableData(
            tableInfoEU.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
    Iterator<FieldValueList> iter = result.getValues().iterator();
    assertEquals("aaa", iter.next().get(0).getStringValue());
    assertEquals("bbb", iter.next().get(0).getStringValue());
    assertEquals("ccc", iter.next().get(0).getStringValue());
    assertEquals("ddd", iter.next().get(0).getStringValue());
    assertEquals(false, iter.hasNext());
  }

  @Test
  public void testJsonStreamWriterCommittedStream()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "JsonTable";
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, tableName),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_str", StandardSQLTypeName.STRING)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_numerics", StandardSQLTypeName.NUMERIC)
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_datetime", StandardSQLTypeName.DATETIME)
                            .build())))
            .build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(parent.toString())
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema()).build()) {
      LOG.info("Sending one message");
      JSONObject row1 = new JSONObject();
      row1.put("test_str", "aaa");
      row1.put(
          "test_numerics",
          new JSONArray(
              new byte[][] {
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("123.4"))
                    .toByteArray(),
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("-9000000"))
                    .toByteArray()
              }));
      row1.put(
          "test_datetime",
          CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.of(2020, 10, 1, 12, 0)));
      JSONArray jsonArr1 = new JSONArray(new JSONObject[] {row1});

      ApiFuture<AppendRowsResponse> response1 = jsonStreamWriter.append(jsonArr1, -1);

      assertEquals(0, response1.get().getAppendResult().getOffset().getValue());

      JSONObject row2 = new JSONObject();
      row1.put("test_str", "bbb");
      JSONObject row3 = new JSONObject();
      row2.put("test_str", "ccc");
      JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(row1);
      jsonArr2.put(row2);

      JSONObject row4 = new JSONObject();
      row4.put("test_str", "ddd");
      JSONArray jsonArr3 = new JSONArray();
      jsonArr3.put(row4);

      LOG.info("Sending two more messages");
      ApiFuture<AppendRowsResponse> response2 = jsonStreamWriter.append(jsonArr2, -1);
      LOG.info("Sending one more message");
      ApiFuture<AppendRowsResponse> response3 = jsonStreamWriter.append(jsonArr3, -1);
      assertEquals(1, response2.get().getAppendResult().getOffset().getValue());
      assertEquals(3, response3.get().getAppendResult().getOffset().getValue());

      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      FieldValueList currentRow = iter.next();
      assertEquals("aaa", currentRow.get(0).getStringValue());
      assertEquals("-9000000", currentRow.get(1).getRepeatedValue().get(1).getStringValue());
      assertEquals("2020-10-01T12:00:00", currentRow.get(2).getStringValue());
      assertEquals("bbb", iter.next().get(0).getStringValue());
      assertEquals("ccc", iter.next().get(0).getStringValue());
      assertEquals("ddd", iter.next().get(0).getStringValue());
      assertEquals(false, iter.hasNext());
    }
  }

  @Test
  public void testJsonStreamWriterWithDefaultStream()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "JsonTableDefaultStream";
    TableFieldSchema TEST_STRING =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_str")
            .build();
    TableFieldSchema TEST_NUMERIC =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.NUMERIC)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("test_numerics")
            .build();
    TableFieldSchema TEST_DATE =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.DATETIME)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test_datetime")
            .build();
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(0, TEST_STRING)
            .addFields(1, TEST_DATE)
            .addFields(2, TEST_NUMERIC)
            .build();
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, tableName),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_str", StandardSQLTypeName.STRING)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_numerics", StandardSQLTypeName.NUMERIC)
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_datetime", StandardSQLTypeName.DATETIME)
                            .build())))
            .build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(parent.toString(), tableSchema).build()) {
      LOG.info("Sending one message");
      JSONObject row1 = new JSONObject();
      row1.put("test_str", "aaa");
      row1.put(
          "test_numerics",
          new JSONArray(
              new byte[][] {
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("123.4"))
                    .toByteArray(),
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("-9000000"))
                    .toByteArray()
              }));
      row1.put(
          "test_datetime",
          CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.of(2020, 10, 1, 12, 0)));
      JSONArray jsonArr1 = new JSONArray(new JSONObject[] {row1});

      ApiFuture<AppendRowsResponse> response1 = jsonStreamWriter.append(jsonArr1, -1);

      assertEquals(0, response1.get().getAppendResult().getOffset().getValue());

      JSONObject row2 = new JSONObject();
      row1.put("test_str", "bbb");
      JSONObject row3 = new JSONObject();
      row2.put("test_str", "ccc");
      JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(row1);
      jsonArr2.put(row2);

      JSONObject row4 = new JSONObject();
      row4.put("test_str", "ddd");
      JSONArray jsonArr3 = new JSONArray();
      jsonArr3.put(row4);

      LOG.info("Sending two more messages");
      ApiFuture<AppendRowsResponse> response2 = jsonStreamWriter.append(jsonArr2, -1);
      LOG.info("Sending one more message");
      ApiFuture<AppendRowsResponse> response3 = jsonStreamWriter.append(jsonArr3, -1);
      Assert.assertFalse(response2.get().getAppendResult().hasOffset());
      Assert.assertFalse(response3.get().getAppendResult().hasOffset());

      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      FieldValueList currentRow = iter.next();
      assertEquals("aaa", currentRow.get(0).getStringValue());
      assertEquals("-9000000", currentRow.get(1).getRepeatedValue().get(1).getStringValue());
      assertEquals("2020-10-01T12:00:00", currentRow.get(2).getStringValue());
      assertEquals("bbb", iter.next().get(0).getStringValue());
      assertEquals("ccc", iter.next().get(0).getStringValue());
      assertEquals("ddd", iter.next().get(0).getStringValue());
      assertEquals(false, iter.hasNext());
    }
  }

  @Test
  public void testComplicateSchemaWithPendingStream()
      throws IOException, InterruptedException, ExecutionException {
    LOG.info("Create a write stream");
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableId2)
                .setWriteStream(WriteStream.newBuilder().setType(WriteStream.Type.PENDING).build())
                .build());
    FinalizeWriteStreamResponse finalizeResponse = FinalizeWriteStreamResponse.getDefaultInstance();
    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(ComplicateType.getDescriptor()))
            .build()) {
      LOG.info("Sending two messages");
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRowsComplex(new String[] {"aaa"}), 0L);
      assertEquals(0, response.get().getAppendResult().getOffset().getValue());

      ApiFuture<AppendRowsResponse> response2 =
          streamWriter.append(CreateProtoRowsComplex(new String[] {"bbb"}), 1L);
      assertEquals(1, response2.get().getAppendResult().getOffset().getValue());

      // Nothing showed up since rows are not committed.
      TableResult result =
          bigquery.listTableData(
              tableInfo2.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      assertEquals(false, iter.hasNext());

      LOG.info("Finalize a write stream");
      finalizeResponse =
          client.finalizeWriteStream(
              FinalizeWriteStreamRequest.newBuilder().setName(writeStream.getName()).build());

      ApiFuture<AppendRowsResponse> response3 =
          streamWriter.append(CreateProtoRows(new String[] {"ccc"}), 2L);
      try {
        response3.get();
        Assert.fail("Append to finalized stream should fail.");
      } catch (Exception expected) {
        LOG.info("Got exception: " + expected.toString());
      }
    }
    assertEquals(2, finalizeResponse.getRowCount());
    LOG.info("Commit a write stream");
    BatchCommitWriteStreamsResponse batchCommitWriteStreamsResponse =
        client.batchCommitWriteStreams(
            BatchCommitWriteStreamsRequest.newBuilder()
                .setParent(tableId2)
                .addWriteStreams(writeStream.getName())
                .build());
    assertEquals(true, batchCommitWriteStreamsResponse.hasCommitTime());
    TableResult queryResult =
        bigquery.query(
            QueryJobConfiguration.newBuilder("SELECT * from " + DATASET + '.' + TABLE2).build());
    Iterator<FieldValueList> queryIter = queryResult.getValues().iterator();
    assertTrue(queryIter.hasNext());
    assertEquals(
        "[FieldValue{attribute=REPEATED, value=[FieldValue{attribute=PRIMITIVE, value=aaa}, FieldValue{attribute=PRIMITIVE, value=aaa}]}]",
        queryIter.next().get(1).getRepeatedValue().toString());
    assertEquals(
        "[FieldValue{attribute=REPEATED, value=[FieldValue{attribute=PRIMITIVE, value=bbb}, FieldValue{attribute=PRIMITIVE, value=bbb}]}]",
        queryIter.next().get(1).getRepeatedValue().toString());
    assertFalse(queryIter.hasNext());
  }

  @Test
  public void testStreamError() throws IOException, InterruptedException, ExecutionException {
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableId)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .build()) {
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRows(new String[] {"aaa"}), -1L);
      assertEquals(0L, response.get().getAppendResult().getOffset().getValue());
      // Send in a bogus stream name should cause in connection error.
      ApiFuture<AppendRowsResponse> response2 =
          streamWriter.append(CreateProtoRows(new String[] {"aaa"}), 100L);
      try {
        response2.get();
        Assert.fail("Should fail");
      } catch (ExecutionException e) {
        assertThat(e.getCause().getMessage())
            .contains("OUT_OF_RANGE: The offset is beyond stream, expected offset 1, received 100");
      }
      // We can keep sending requests on the same stream.
      ApiFuture<AppendRowsResponse> response3 =
          streamWriter.append(CreateProtoRows(new String[] {"aaa"}), -1L);
      assertEquals(1L, response3.get().getAppendResult().getOffset().getValue());
    } finally {
    }
  }

  @Test
  public void testStreamSchemaMisMatchError() throws IOException, InterruptedException {
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableId)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());

    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(UpdatedFooType.getDescriptor()))
            .build()) {
      // Create a proto row that has extra fields than the table schema defined which should trigger
      // the SCHEMA_MISMATCH_EXTRA_FIELDS error
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 0);
      try {
        response.get();
        Assert.fail("Should fail");
      } catch (ExecutionException e) {
        // TODO(stephwang): update test case when toStroageException is updated
        assertThat(e.getCause().getMessage())
            .contains(
                "io.grpc.StatusRuntimeException: INVALID_ARGUMENT: Input schema has more fields than BigQuery schema");
      }
    }
  }

  @Test
  public void testStreamFinalizedError()
      throws IOException, InterruptedException, ExecutionException {
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableId)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(UpdatedFooType.getDescriptor()))
            .build()) {
      // Finalize the stream in order to trigger STREAM_FINALIZED error
      client.finalizeWriteStream(
          FinalizeWriteStreamRequest.newBuilder().setName(writeStream.getName()).build());
      // Try to append to a finalized stream
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 0);
      try {
        response.get();
        Assert.fail("Should fail");
      } catch (ExecutionException e) {
        //   //TODO(stephwang): update test case when toStroageException is updated
        assertThat(e.getCause().getMessage())
            .contains(
                "io.grpc.StatusRuntimeException: INVALID_ARGUMENT: Stream has been finalized and cannot be appended");
      }
    }
  }

  @Test
  public void testStreamReconnect() throws IOException, InterruptedException, ExecutionException {
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableId)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .build()) {
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRows(new String[] {"aaa"}), 0L);
      assertEquals(0L, response.get().getAppendResult().getOffset().getValue());
    }

    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .build()) {
      // Currently there is a bug that reconnection must wait 5 seconds to get the real row count.
      Thread.sleep(5000L);
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRows(new String[] {"bbb"}), 1L);
      assertEquals(1L, response.get().getAppendResult().getOffset().getValue());
    }
  }
}
