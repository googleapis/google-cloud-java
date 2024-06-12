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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.*;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.storage.test.Test.*;
import com.google.cloud.bigquery.storage.test.TestOptional.*;
import com.google.cloud.bigquery.storage.v1.*;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.MissingValueInterpretation;
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializationError;
import com.google.cloud.bigquery.storage.v1.Exceptions.OffsetAlreadyExists;
import com.google.cloud.bigquery.storage.v1.Exceptions.OffsetOutOfRange;
import com.google.cloud.bigquery.storage.v1.Exceptions.SchemaMismatchedException;
import com.google.cloud.bigquery.storage.v1.Exceptions.StreamFinalizedException;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FieldDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import io.grpc.Status;
import io.grpc.Status.Code;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
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

  private static final String TEST_TRACE_ID = "DATAFLOW:job_id";

  private static final String DESCRIPTION = "BigQuery Write Java manual client test dataset";

  private static BigQueryWriteClient client;
  private static TableInfo tableInfo;
  private static TableInfo tableInfo2;

  private static TableInfo tableInfoEU;

  private static TableDefinition defaultValueTableDefinition;
  private static String tableId;
  private static String tableId2;

  private static String tableIdEU;
  private static BigQuery bigquery;

  public class StringWithSecondsNanos {
    public String foo;
    public long seconds;
    public int nanos;

    public StringWithSecondsNanos(String fooParam, long secondsParam, int nanosParam) {
      foo = fooParam;
      seconds = secondsParam;
      nanos = nanosParam;
    }
  }

  private static final HeaderProvider USER_AGENT_HEADER_PROVIDER =
      FixedHeaderProvider.create("User-Agent", "my_product_name/1.0 (GPN:Samples;test)");

  @BeforeClass
  public static void beforeClass() throws IOException {
    BigQueryWriteSettings settings =
        BigQueryWriteSettings.newBuilder().setHeaderProvider(USER_AGENT_HEADER_PROVIDER).build();
    client = BigQueryWriteClient.create(settings);

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

    defaultValueTableDefinition =
        StandardTableDefinition.of(
            Schema.of(
                com.google.cloud.bigquery.Field.newBuilder(
                        "foo_with_default", LegacySQLTypeName.STRING)
                    .setDefaultValueExpression("'default_value_for_test'")
                    .setMode(Field.Mode.NULLABLE)
                    .build(),
                com.google.cloud.bigquery.Field.newBuilder(
                        "bar_without_default", LegacySQLTypeName.STRING)
                    .setMode(Mode.NULLABLE)
                    .build(),
                com.google.cloud.bigquery.Field.newBuilder(
                        "date_with_default_to_current", LegacySQLTypeName.TIMESTAMP)
                    .setDefaultValueExpression("CURRENT_TIMESTAMP()")
                    .setMode(Mode.NULLABLE)
                    .build()));
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

  ProtoSchema CreateProtoSchemaWithColField() {
    return ProtoSchema.newBuilder()
        .setProtoDescriptor(
            DescriptorProto.newBuilder()
                .setName("testProto")
                .addField(
                    FieldDescriptorProto.newBuilder()
                        .setName("col1")
                        .setNumber(1)
                        .setType(FieldDescriptorProto.Type.TYPE_STRING)
                        .build())
                .build())
        .build();
  }

  ProtoRows CreateProtoOptionalRows(String[] messages) {
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (String message : messages) {
      FooOptionalType foo = FooOptionalType.newBuilder().setFoo(message).build();
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

  ProtoRows CreateProtoRowsMixed(StringWithSecondsNanos[] messages) {
    ProtoRows.Builder rows = ProtoRows.newBuilder();
    for (StringWithSecondsNanos message : messages) {
      FooTimestampType datum =
          FooTimestampType.newBuilder()
              .setFoo(message.foo)
              .setBar(
                  com.google.protobuf.Timestamp.newBuilder()
                      .setSeconds(message.seconds)
                      .setNanos(message.nanos)
                      .build())
              .build();
      rows.addSerializedRows(datum.toByteString());
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
  }

  @Test
  public void testProto3OptionalBatchWriteWithCommittedStream()
      throws IOException, InterruptedException, ExecutionException {
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(tableId)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    StreamWriter streamWriter =
        StreamWriter.newBuilder(writeStream.getName())
            .setWriterSchema(ProtoSchemaConverter.convert(FooOptionalType.getDescriptor()))
            .build();
    LOG.info("Sending one message");

    ApiFuture<AppendRowsResponse> response =
        streamWriter.append(CreateProtoOptionalRows(new String[] {"aaa"}), 0);
    assertEquals(0, response.get().getAppendResult().getOffset().getValue());

    LOG.info("Sending two more messages");
    ApiFuture<AppendRowsResponse> response1 =
        streamWriter.append(CreateProtoOptionalRows(new String[] {"bbb", "ccc"}), 1);
    ApiFuture<AppendRowsResponse> response2 =
        streamWriter.append(CreateProtoOptionalRows(new String[] {""}), 3);
    assertEquals(1, response1.get().getAppendResult().getOffset().getValue());
    assertEquals(3, response2.get().getAppendResult().getOffset().getValue());
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
  public void testRowErrors()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "TestBadRowsTable";
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, tableName),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "foo", StandardSQLTypeName.STRING)
                            .setMaxLength(10L)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "bar", StandardSQLTypeName.TIMESTAMP)
                            .build())))
            .build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    StreamWriter streamWriter =
        StreamWriter.newBuilder(parent.toString() + "/_default")
            .setWriterSchema(ProtoSchemaConverter.convert(FooTimestampType.getDescriptor()))
            .build();

    LOG.info("Sending three messages");
    StringWithSecondsNanos[] myBadList = {
      new StringWithSecondsNanos("aaabbbcccddd", 1663821424, 0),
      new StringWithSecondsNanos("bbb", Long.MIN_VALUE, 0),
      new StringWithSecondsNanos("cccdddeeefffggg", 1663621424, 0)
    };
    ApiFuture<AppendRowsResponse> futureResponse =
        streamWriter.append(CreateProtoRowsMixed(myBadList), -1);
    AppendRowsResponse actualResponse = null;
    try {
      actualResponse = futureResponse.get();
    } catch (Throwable t) {
      assertTrue(t instanceof ExecutionException);
      t = t.getCause();
      assertTrue(t instanceof AppendSerializationError);
      AppendSerializationError e = (AppendSerializationError) t;
      LOG.info("Found row errors on stream: " + e.getStreamName());
      assertEquals(
          "Field foo: STRING(10) has maximum length 10 but got a value with length 12 on field"
              + " foo.",
          e.getRowIndexToErrorMessage().get(0));
      assertEquals(
          "Timestamp field value is out of range: -9223372036854775808 on field bar.",
          e.getRowIndexToErrorMessage().get(1));
      assertEquals(
          "Field foo: STRING(10) has maximum length 10 but got a value with length 15 on field"
              + " foo.",
          e.getRowIndexToErrorMessage().get(2));
      for (Map.Entry<Integer, String> entry : e.getRowIndexToErrorMessage().entrySet()) {
        LOG.info("Bad row index: " + entry.getKey() + ", has problem: " + entry.getValue());
      }
    }
    assertEquals(null, actualResponse);

    LOG.info("Resending with three good messages");
    StringWithSecondsNanos[] myGoodList = {
      new StringWithSecondsNanos("aaa", 1664821424, 0),
      new StringWithSecondsNanos("bbb", 1663821424, 0),
      new StringWithSecondsNanos("ccc", 1664801424, 0)
    };
    ApiFuture<AppendRowsResponse> futureResponse1 =
        streamWriter.append(CreateProtoRowsMixed(myGoodList), -1);
    assertEquals(0, futureResponse1.get().getAppendResult().getOffset().getValue());

    TableResult result =
        bigquery.listTableData(tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
    Iterator<FieldValueList> iterDump = result.getValues().iterator();
    while (iterDump.hasNext()) {
      FieldValueList currentRow = iterDump.next();
      LOG.info("Table row contains " + currentRow.size() + " field values.");
      LOG.info("Table column has foo: " + currentRow.get(0).getStringValue());
      LOG.info("Table column has bar: " + currentRow.get(1).getTimestampValue());
    }

    Iterator<FieldValueList> iter = result.getValues().iterator();
    FieldValueList currentRow = iter.next();
    assertEquals("aaa", currentRow.get(0).getStringValue());
    assertEquals(1664821424000000L, currentRow.get(1).getTimestampValue());
    currentRow = iter.next();
    assertEquals("bbb", currentRow.get(0).getStringValue());
    assertEquals(1663821424000000L, currentRow.get(1).getTimestampValue());
    currentRow = iter.next();
    assertEquals("ccc", currentRow.get(0).getStringValue());
    assertEquals(1664801424000000L, currentRow.get(1).getTimestampValue());
    assertEquals(false, iter.hasNext());
  }

  @Test
  public void testJsonStreamWriterWithDefaultSchema()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "JsonTableDefaultSchema";
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
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_bytestring_repeated", StandardSQLTypeName.BYTES)
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_timestamp", StandardSQLTypeName.TIMESTAMP)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_json", StandardSQLTypeName.JSON)
                            .build())))
            .build();

    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);

    // Create JsonStreamWriter with newBuilder(streamOrTable, client)
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(parent.toString(), client)
            .setIgnoreUnknownFields(true)
            .build()) {
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
      row1.put("unknown_field", "a");
      row1.put(
          "test_datetime",
          CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.of(2020, 10, 1, 12, 0)));
      row1.put(
          "test_bytestring_repeated",
          new JSONArray(
              new byte[][] {
                ByteString.copyFromUtf8("a").toByteArray(),
                ByteString.copyFromUtf8("b").toByteArray()
              }));
      row1.put("test_timestamp", "2022-02-06 07:24:47.84");
      row1.put("test_json", "{}");
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

      JSONObject row5 = new JSONObject();
      // Add another ARRAY<BYTES> using a more idiomatic way
      JSONArray testArr = new JSONArray(); // create empty JSONArray
      testArr.put(0, ByteString.copyFromUtf8("a").toByteArray()); // insert 1st bytes array
      testArr.put(1, ByteString.copyFromUtf8("b").toByteArray()); // insert 2nd bytes array
      row5.put("test_bytestring_repeated", testArr);
      JSONArray jsonArr4 = new JSONArray();
      jsonArr4.put(row5);

      LOG.info("Sending three more messages");
      ApiFuture<AppendRowsResponse> response2 = jsonStreamWriter.append(jsonArr2, -1);
      LOG.info("Sending two more messages");
      ApiFuture<AppendRowsResponse> response3 = jsonStreamWriter.append(jsonArr3, -1);
      LOG.info("Sending one more message");
      ApiFuture<AppendRowsResponse> response4 = jsonStreamWriter.append(jsonArr4, -1);
      Assert.assertFalse(response2.get().getAppendResult().hasOffset());
      Assert.assertFalse(response3.get().getAppendResult().hasOffset());
      Assert.assertFalse(response4.get().getAppendResult().hasOffset());

      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      FieldValueList currentRow = iter.next();
      assertEquals("aaa", currentRow.get(0).getStringValue());
      assertEquals("-9000000", currentRow.get(1).getRepeatedValue().get(1).getStringValue());
      assertEquals("2020-10-01T12:00:00", currentRow.get(2).getStringValue());
      assertEquals(2, currentRow.get(3).getRepeatedValue().size());
      assertEquals("Yg==", currentRow.get(3).getRepeatedValue().get(1).getStringValue());
      assertEquals("bbb", iter.next().get(0).getStringValue());
      assertEquals("ccc", iter.next().get(0).getStringValue());
      assertEquals("ddd", iter.next().get(0).getStringValue());
      FieldValueList currentRow2 = iter.next();
      assertEquals("YQ==", currentRow2.get(3).getRepeatedValue().get(0).getStringValue());
      assertEquals("Yg==", currentRow2.get(3).getRepeatedValue().get(1).getStringValue());
      assertEquals(false, iter.hasNext());
    }
  }

  @Test
  public void testJsonStreamWriterWithDefaultSchemaNoTable() {
    String tableName = "JsonStreamWriterWithDefaultSchemaNoTable";
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);

    // Create JsonStreamWriter with newBuilder(streamOrTable, client)
    try {
      JsonStreamWriter jsonStreamWriter =
          JsonStreamWriter.newBuilder(parent.toString(), client)
              .setIgnoreUnknownFields(true)
              .build();
    } catch (Exception exception) {
      assertTrue(exception.getMessage().contains("it may not exist"));
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
    TableFieldSchema TEST_REPEATED_BYTESTRING =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.BYTES)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .setName("test_bytestring_repeated")
            .build();
    TableFieldSchema TEST_TIMESTAMP =
        TableFieldSchema.newBuilder()
            .setName("test_timeStamp")
            .setType(TableFieldSchema.Type.TIMESTAMP)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .build();
    TableSchema tableSchema =
        TableSchema.newBuilder()
            .addFields(0, TEST_STRING)
            .addFields(1, TEST_DATE)
            .addFields(2, TEST_NUMERIC)
            .addFields(3, TEST_REPEATED_BYTESTRING)
            .addFields(4, TEST_TIMESTAMP)
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
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_bytestring_repeated", StandardSQLTypeName.BYTES)
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test_timestamp", StandardSQLTypeName.TIMESTAMP)
                            .build())))
            .build();

    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(parent.toString(), tableSchema)
            .setIgnoreUnknownFields(true)
            .build()) {
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
      row1.put("unknown_field", "a");
      row1.put(
          "test_datetime",
          CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.of(2020, 10, 1, 12, 0)));
      row1.put(
          "test_bytestring_repeated",
          new JSONArray(
              new byte[][] {
                ByteString.copyFromUtf8("a").toByteArray(),
                ByteString.copyFromUtf8("b").toByteArray()
              }));
      row1.put("test_timestamp", "2022-02-06 07:24:47.84");
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

      JSONObject row5 = new JSONObject();
      // Add another ARRAY<BYTES> using a more idiomatic way
      JSONArray testArr = new JSONArray(); // create empty JSONArray
      testArr.put(0, ByteString.copyFromUtf8("a").toByteArray()); // insert 1st bytes array
      testArr.put(1, ByteString.copyFromUtf8("b").toByteArray()); // insert 2nd bytes array
      row5.put("test_bytestring_repeated", testArr);
      JSONArray jsonArr4 = new JSONArray();
      jsonArr4.put(row5);

      LOG.info("Sending three more messages");
      ApiFuture<AppendRowsResponse> response2 = jsonStreamWriter.append(jsonArr2, -1);
      LOG.info("Sending two more messages");
      ApiFuture<AppendRowsResponse> response3 = jsonStreamWriter.append(jsonArr3, -1);
      LOG.info("Sending one more message");
      ApiFuture<AppendRowsResponse> response4 = jsonStreamWriter.append(jsonArr4, -1);
      Assert.assertFalse(response2.get().getAppendResult().hasOffset());
      Assert.assertFalse(response3.get().getAppendResult().hasOffset());
      Assert.assertFalse(response4.get().getAppendResult().hasOffset());

      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();
      FieldValueList currentRow = iter.next();
      assertEquals("aaa", currentRow.get(0).getStringValue());
      assertEquals("-9000000", currentRow.get(1).getRepeatedValue().get(1).getStringValue());
      assertEquals("2020-10-01T12:00:00", currentRow.get(2).getStringValue());
      assertEquals(2, currentRow.get(3).getRepeatedValue().size());
      assertEquals("Yg==", currentRow.get(3).getRepeatedValue().get(1).getStringValue());
      assertEquals(
          Timestamp.valueOf("2022-02-06 07:24:47.84")
                  .toLocalDateTime()
                  .atZone(ZoneId.of("UTC"))
                  .toInstant()
                  .toEpochMilli()
              * 1000,
          currentRow.get(4).getTimestampValue()); // timestamp long of "2022-02-06 07:24:47.84"
      assertEquals("bbb", iter.next().get(0).getStringValue());
      assertEquals("ccc", iter.next().get(0).getStringValue());
      assertEquals("ddd", iter.next().get(0).getStringValue());
      FieldValueList currentRow2 = iter.next();
      assertEquals("YQ==", currentRow2.get(3).getRepeatedValue().get(0).getStringValue());
      assertEquals("Yg==", currentRow2.get(3).getRepeatedValue().get(1).getStringValue());
      assertEquals(false, iter.hasNext());
    }
  }

  @Test
  public void testJsonDefaultStreamOnTableWithDefaultValue_SchemaNotGiven()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException, ParseException {
    String tableName = "defaultStreamDefaultValue";
    String defaultTableId =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    tableInfo =
        TableInfo.newBuilder(TableId.of(DATASET, tableName), defaultValueTableDefinition).build();
    bigquery.create(tableInfo);
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(defaultTableId, client)
            .setDefaultMissingValueInterpretation(MissingValueInterpretation.DEFAULT_VALUE)
            .build()) {
      testJsonStreamWriterForDefaultValue(jsonStreamWriter);
    }
  }

  @Test
  public void testJsonExclusiveStreamOnTableWithDefaultValue_GiveTableSchema()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException, ParseException {
    String tableName = "exclusiveStreamDefaultValue";
    String exclusiveTableId =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    tableInfo =
        TableInfo.newBuilder(TableId.of(DATASET, tableName), defaultValueTableDefinition).build();
    bigquery.create(tableInfo);
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(exclusiveTableId)
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(exclusiveTableId, writeStream.getTableSchema())
            .setDefaultMissingValueInterpretation(MissingValueInterpretation.DEFAULT_VALUE)
            .build()) {
      testJsonStreamWriterForDefaultValue(jsonStreamWriter);
    }
  }

  private void testJsonStreamWriterForDefaultValue(JsonStreamWriter jsonStreamWriter)
      throws DescriptorValidationException, IOException, ExecutionException, InterruptedException,
          ParseException {
    // 1. row has both fields set.
    JSONArray jsonArr1 = new JSONArray();
    JSONObject row1 = new JSONObject();
    row1.put("foo_with_default", "aaa");
    row1.put("bar_without_default", "a");
    row1.put("date_with_default_to_current", "2022-02-02 01:02:03");
    jsonArr1.put(row1);
    // 2. row with the column with default value unset
    JSONObject row2 = new JSONObject();
    row2.put("bar_without_default", "a");
    jsonArr1.put(row2);
    // 3. both value not set
    JSONObject row3 = new JSONObject();
    jsonArr1.put(row3);

    // Start insertion and validation.
    ApiFuture<AppendRowsResponse> response1 = jsonStreamWriter.append(jsonArr1, -1);
    response1.get();
    TableResult result =
        bigquery.listTableData(tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
    Iterator<FieldValueList> iter = result.getValues().iterator();

    FieldValueList currentRow = iter.next();
    assertEquals("aaa", currentRow.get(0).getStringValue());
    assertEquals("a", currentRow.get(1).getStringValue());
    assertEquals(
        Timestamp.valueOf("2022-02-02 01:02:03")
            .toLocalDateTime()
            .atZone(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli(),
        Double.valueOf(currentRow.get(2).getStringValue()).longValue() * 1000);

    currentRow = iter.next();
    assertEquals("default_value_for_test", currentRow.get(0).getStringValue());
    assertFalse(currentRow.get(2).getStringValue().isEmpty());
    assertEquals("a", currentRow.get(1).getStringValue());
    // Check whether the recorded value is up to date enough.
    Instant parsedInstant =
        Instant.ofEpochSecond(Double.valueOf(currentRow.get(2).getStringValue()).longValue());
    assertTrue(parsedInstant.isAfter(Instant.now().minus(1, ChronoUnit.HOURS)));

    currentRow = iter.next();
    assertEquals("default_value_for_test", currentRow.get(0).getStringValue());
    assertEquals(null, currentRow.get(1).getValue());
    assertFalse(currentRow.get(2).getStringValue().isEmpty());
    // Check whether the recorded value is up to date enough.
    parsedInstant =
        Instant.ofEpochSecond(Double.valueOf(currentRow.get(2).getStringValue()).longValue());
    assertTrue(parsedInstant.isAfter(Instant.now().minus(1, ChronoUnit.HOURS)));

    assertEquals(false, iter.hasNext());
  }

  @Test
  public void testStreamWriterWithDefaultValue() throws ExecutionException, InterruptedException {
    String tableName = "streamWriterWithDefaultValue";
    String exclusiveTableId =
        String.format(
            "projects/%s/datasets/%s/tables/%s",
            ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    tableInfo =
        TableInfo.newBuilder(TableId.of(DATASET, tableName), defaultValueTableDefinition).build();
    bigquery.create(tableInfo);
    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(exclusiveTableId + "/_default")
            .setWriterSchema(
                ProtoSchemaConverter.convert(SimpleTypeForDefaultValue.getDescriptor()))
            .setDefaultMissingValueInterpretation(MissingValueInterpretation.DEFAULT_VALUE)
            .setEnableConnectionPool(true)
            .setTraceId(TEST_TRACE_ID)
            .build()) {
      // 1. row has both fields set.
      SimpleTypeForDefaultValue simpleTypeForDefaultValue1 =
          SimpleTypeForDefaultValue.newBuilder()
              .setFooWithDefault("foo_value")
              .setBarWithoutDefault("bar_value")
              .setDateWithDefaultToCurrent("2022-02-02 01:02:03")
              .build();

      // 2. row without any column set, expect default value to be filled
      SimpleTypeForDefaultValue simpleTypeForDefaultValue2 =
          SimpleTypeForDefaultValue.newBuilder().build();
      ProtoRows rows =
          ProtoRows.newBuilder()
              .addSerializedRows(simpleTypeForDefaultValue1.toByteString())
              .addSerializedRows(simpleTypeForDefaultValue2.toByteString())
              .build();

      // Start insertion and validation.
      ApiFuture<AppendRowsResponse> response1 = streamWriter.append(rows);
      response1.get();
      TableResult result =
          bigquery.listTableData(
              tableInfo.getTableId(), BigQuery.TableDataListOption.startIndex(0L));
      Iterator<FieldValueList> iter = result.getValues().iterator();

      FieldValueList currentRow = iter.next();
      assertEquals("foo_value", currentRow.get(0).getStringValue());
      assertEquals("bar_value", currentRow.get(1).getStringValue());
      assertEquals(
          Timestamp.valueOf("2022-02-02 01:02:03")
              .toLocalDateTime()
              .atZone(ZoneId.of("UTC"))
              .toInstant()
              .toEpochMilli(),
          Double.valueOf(currentRow.get(2).getStringValue()).longValue() * 1000);

      currentRow = iter.next();
      assertEquals("default_value_for_test", currentRow.get(0).getStringValue());
      assertEquals(null, currentRow.get(1).getValue());
      assertFalse(currentRow.get(2).getStringValue().isEmpty());
      // Check whether the recorded value is up to date enough.
      Instant parsedInstant =
          Instant.ofEpochSecond(Double.valueOf(currentRow.get(2).getStringValue()).longValue());
      assertTrue(parsedInstant.isAfter(Instant.now().minus(1, ChronoUnit.HOURS)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // This test runs about 1 min.
  @Test
  public void testJsonStreamWriterWithMessagesOver10M()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "TableLarge";
    TableId tableId = TableId.of(DATASET, tableName);
    Field col1 = Field.newBuilder("col1", StandardSQLTypeName.STRING).build();
    Schema schema = Schema.of(col1);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, StandardTableDefinition.of(schema)).build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);

    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(parent.toString())
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());
    int totalRequest = 10;
    int rowBatch = 40000;
    ArrayList<ApiFuture<AppendRowsResponse>> allResponses =
        new ArrayList<ApiFuture<AppendRowsResponse>>(totalRequest);
    // Sends a total of 30MB over the wire.
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(writeStream.getName(), writeStream.getTableSchema()).build()) {
      for (int k = 0; k < totalRequest; k++) {
        JSONObject row = new JSONObject();
        row.put("col1", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        JSONArray jsonArr = new JSONArray();
        // 3MB batch.
        for (int j = 0; j < rowBatch; j++) {
          jsonArr.put(row);
        }
        LOG.info("Appending: " + k + "/" + totalRequest);
        allResponses.add(jsonStreamWriter.append(jsonArr, k * rowBatch));
      }
    }
    LOG.info("Waiting for all responses to come back");
    for (int i = 0; i < totalRequest; i++) {
      try {
        Assert.assertEquals(
            allResponses.get(i).get().getAppendResult().getOffset().getValue(), i * rowBatch);
      } catch (ExecutionException ex) {
        Assert.fail("Unexpected error " + ex);
      }
    }
  }

  @Test
  public void testJsonStreamWriterSchemaUpdate()
      throws DescriptorValidationException, IOException, InterruptedException, ExecutionException {
    String tableName = "SchemaUpdateTestTable";
    TableId tableId = TableId.of(DATASET, tableName);
    Field col1 = Field.newBuilder("col1", StandardSQLTypeName.STRING).build();
    Schema originalSchema = Schema.of(col1);
    TableInfo tableInfo =
        TableInfo.newBuilder(tableId, StandardTableDefinition.of(originalSchema)).build();
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
        JsonStreamWriter.newBuilder(writeStream.getName(), client).build()) {
      // write the 1st row
      JSONObject foo = new JSONObject();
      foo.put("col1", "aaa");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      ApiFuture<AppendRowsResponse> response = jsonStreamWriter.append(jsonArr, 0);
      assertEquals(0, response.get().getAppendResult().getOffset().getValue());

      // update schema with a new column
      Field col2 = Field.newBuilder("col2", StandardSQLTypeName.STRING).build();
      Schema updatedSchema = Schema.of(ImmutableList.of(col1, col2));
      TableInfo updatedTableInfo =
          TableInfo.newBuilder(tableId, StandardTableDefinition.of(updatedSchema)).build();
      Table updatedTable = bigquery.update(updatedTableInfo);
      assertEquals(updatedSchema, updatedTable.getDefinition().getSchema());

      // continue writing rows until backend acknowledges schema update
      JSONObject foo2 = new JSONObject();
      foo2.put("col1", "bbb");
      JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(foo2);

      int next = 0;
      for (int i = 1; i < 100; i++) {
        ApiFuture<AppendRowsResponse> response2 = jsonStreamWriter.append(jsonArr2, i);
        assertEquals(i, response2.get().getAppendResult().getOffset().getValue());
        if (response2.get().hasUpdatedSchema()) {
          next = i;
          break;
        } else {
          Thread.sleep(1000);
        }
      }

      // write rows with updated schema.
      JSONObject updatedFoo = new JSONObject();
      updatedFoo.put("col1", "ccc");
      updatedFoo.put("col2", "ddd");
      JSONArray updatedJsonArr = new JSONArray();
      updatedJsonArr.put(updatedFoo);
      for (int i = 0; i < 10; i++) {
        ApiFuture<AppendRowsResponse> response3 =
            jsonStreamWriter.append(updatedJsonArr, next + 1 + i);
        assertEquals(next + 1 + i, response3.get().getAppendResult().getOffset().getValue());
      }

      // verify table data correctness
      Iterator<FieldValueList> rowsIter = bigquery.listTableData(tableId).getValues().iterator();
      // 1 row of aaa
      assertEquals("aaa", rowsIter.next().get(0).getStringValue());
      // a few rows of bbb
      for (int j = 1; j <= next; j++) {
        assertEquals("bbb", rowsIter.next().get(0).getStringValue());
      }
      // 10 rows of ccc, ddd
      for (int j = next + 1; j < next + 1 + 10; j++) {
        FieldValueList temp = rowsIter.next();
        assertEquals("ccc", temp.get(0).getStringValue());
        assertEquals("ddd", temp.get(1).getStringValue());
      }
      assertFalse(rowsIter.hasNext());
    }
  }

  @Test
  public void testJsonStreamWriterSchemaUpdateConcurrent()
      throws DescriptorValidationException, IOException, InterruptedException {
    // Create test table and test stream
    String tableName = "ConcurrentSchemaUpdateTestTable";
    TableId tableId = TableId.of(DATASET, tableName);
    Field col1 = Field.newBuilder("col1", StandardSQLTypeName.STRING).build();
    Schema originalSchema = Schema.of(col1);
    TableInfo tableInfo =
        TableInfo.newBuilder(tableId, StandardTableDefinition.of(originalSchema)).build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    WriteStream writeStream =
        client.createWriteStream(
            CreateWriteStreamRequest.newBuilder()
                .setParent(parent.toString())
                .setWriteStream(
                    WriteStream.newBuilder().setType(WriteStream.Type.COMMITTED).build())
                .build());

    // Create test JSON objects
    JSONObject foo = new JSONObject();
    foo.put("col1", "aaa");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    JSONObject foo2 = new JSONObject();
    foo2.put("col1", "bbb");
    JSONArray jsonArr2 = new JSONArray();
    jsonArr2.put(foo2);

    JSONObject updatedFoo = new JSONObject();
    updatedFoo.put("col1", "ccc");
    updatedFoo.put("col2", "ddd");
    JSONArray updatedJsonArr = new JSONArray();
    updatedJsonArr.put(updatedFoo);

    // Prepare updated schema
    Field col2 = Field.newBuilder("col2", StandardSQLTypeName.STRING).build();
    Schema updatedSchema = Schema.of(ImmutableList.of(col1, col2));
    TableInfo updatedTableInfo =
        TableInfo.newBuilder(tableId, StandardTableDefinition.of(updatedSchema)).build();

    // Start writing using the JsonWriter
    try (JsonStreamWriter jsonStreamWriter =
        JsonStreamWriter.newBuilder(writeStream.getName(), client).build()) {
      int numberOfThreads = 5;
      ExecutorService streamTaskExecutor = Executors.newFixedThreadPool(5);
      CountDownLatch latch = new CountDownLatch(numberOfThreads);
      // Used to verify data correctness
      AtomicInteger next = new AtomicInteger();

      // update TableSchema async
      Runnable updateTableSchemaTask =
          () -> {
            Table updatedTable = bigquery.update(updatedTableInfo);
            assertEquals(updatedSchema, updatedTable.getDefinition().getSchema());
          };
      streamTaskExecutor.execute(updateTableSchemaTask);

      // stream data async
      for (int i = 0; i < numberOfThreads; i++) {
        streamTaskExecutor.submit(
            () -> {
              // write 2 rows of aaa on each Thread
              for (int j = 0; j < 2; j++) {
                try {
                  jsonStreamWriter.append(jsonArr);
                  next.getAndIncrement();
                } catch (IOException | DescriptorValidationException e) {
                  e.printStackTrace();
                }
              }

              // write filler rows bbb until backend acknowledges schema update due to possible
              // delay
              for (int w = 0; w < 15; w++) {
                ApiFuture<AppendRowsResponse> response2 = null;
                try {
                  response2 = jsonStreamWriter.append(jsonArr2);
                  next.getAndIncrement();
                } catch (IOException | DescriptorValidationException e) {
                  LOG.severe("Issue with append " + e.getMessage());
                }
                try {
                  assert response2 != null;
                  if (response2.get().hasUpdatedSchema()) {
                    break;
                  } else {
                    Thread.sleep(1000);
                  }
                } catch (InterruptedException | ExecutionException e) {
                  LOG.severe("Issue with append " + e.getMessage());
                }
              }

              // write 5 rows of ccc,ddd on each Thread
              for (int m = 0; m < 5; m++) {
                try {
                  jsonStreamWriter.append(updatedJsonArr);
                  next.getAndIncrement();
                } catch (IOException | DescriptorValidationException e) {
                  LOG.severe("Issue with append " + e.getMessage());
                }
              }
              latch.countDown();
            });
      }
      latch.await();

      // verify that the last 5 rows streamed are ccc,ddd
      Iterator<FieldValueList> rowsIter = bigquery.listTableData(tableId).getValues().iterator();

      int position = 0;
      while (rowsIter.hasNext()) {
        FieldValueList row = rowsIter.next();
        position++;
        if (position > next.get() - 5) {
          assertEquals("ccc", row.get(0).getStringValue());
          assertEquals("ddd", row.get(1).getStringValue());
        }
      }
    }
  }

  @Test
  public void testJsonStreamWriterWithFlexibleColumnName()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "FlexibleColumnTable";
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, tableName),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test-str列", StandardSQLTypeName.STRING)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test-numerics列", StandardSQLTypeName.NUMERIC)
                            .setMode(Field.Mode.REPEATED)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test-datetime列", StandardSQLTypeName.DATETIME)
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
      row1.put("test-str列", "aaa");
      row1.put(
          "test-numerics列",
          new JSONArray(
              new byte[][] {
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("123.4"))
                    .toByteArray(),
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("-9000000"))
                    .toByteArray()
              }));
      row1.put(
          "test-datetime列",
          CivilTimeEncoder.encodePacked64DatetimeMicros(LocalDateTime.of(2020, 10, 1, 12, 0)));
      JSONArray jsonArr1 = new JSONArray(new JSONObject[] {row1});

      ApiFuture<AppendRowsResponse> response1 = jsonStreamWriter.append(jsonArr1, -1);

      assertEquals(0, response1.get().getAppendResult().getOffset().getValue());

      JSONObject row2 = new JSONObject();
      row2.put("test-str列", "bbb");
      JSONObject row3 = new JSONObject();
      row3.put("test-str列", "ccc");
      JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(row2);
      jsonArr2.put(row3);

      JSONObject row4 = new JSONObject();
      row4.put("test-str列", "ddd");
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
  public void testJsonStreamWriterWithNestedFlexibleColumnName()
      throws IOException, InterruptedException, ExecutionException,
          Descriptors.DescriptorValidationException {
    String tableName = "NestedFlexibleColumnTable";
    TableInfo tableInfo =
        TableInfo.newBuilder(
                TableId.of(DATASET, tableName),
                StandardTableDefinition.of(
                    Schema.of(
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test-str列", StandardSQLTypeName.STRING)
                            .build(),
                        com.google.cloud.bigquery.Field.newBuilder(
                                "test-record列",
                                StandardSQLTypeName.STRUCT,
                                com.google.cloud.bigquery.Field.of(
                                    "nested-str列", StandardSQLTypeName.STRING),
                                com.google.cloud.bigquery.Field.of(
                                    "nested-int列", StandardSQLTypeName.INT64))
                            .setMode(Field.Mode.REPEATED)
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
      row1.put("test-str列", "aaa");
      JSONObject record1 = new JSONObject();
      record1.put("nested-str列", "nested-str1");
      record1.put("nested-int列", 10);
      row1.put("test-record列", new JSONArray(new JSONObject[] {record1}));
      JSONArray jsonArr1 = new JSONArray(new JSONObject[] {row1});

      ApiFuture<AppendRowsResponse> response1 = jsonStreamWriter.append(jsonArr1, -1);

      assertEquals(0, response1.get().getAppendResult().getOffset().getValue());

      JSONObject row2 = new JSONObject();
      row2.put("test-str列", "bbb");
      JSONObject row3 = new JSONObject();
      row3.put("test-str列", "ccc");
      JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(row2);
      jsonArr2.put(row3);

      JSONObject row4 = new JSONObject();
      row4.put("test-str列", "ddd");
      JSONObject record2 = new JSONObject();
      record2.put("nested-str列", "nested-str2");
      record2.put("nested-int列", 20);
      row4.put("test-record列", new JSONArray(new JSONObject[] {record2}));
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
      FieldValueList currentRecord = currentRow.get(1).getRepeatedValue().get(0).getRecordValue();
      assertEquals("nested-str1", currentRecord.get(0).getStringValue());
      assertEquals("10", currentRecord.get(1).getStringValue());
      assertEquals("bbb", iter.next().get(0).getStringValue());
      assertEquals("ccc", iter.next().get(0).getStringValue());
      FieldValueList lastRow = iter.next();
      assertEquals("ddd", lastRow.get(0).getStringValue());
      FieldValueList lastRecord = lastRow.get(1).getRepeatedValue().get(0).getRecordValue();
      assertEquals("nested-str2", lastRecord.get(0).getStringValue());
      assertEquals("20", lastRecord.get(1).getStringValue());
      assertEquals(false, iter.hasNext());
    }
  }

  @Test
  public void testJsonStreamWriterSchemaUpdateWithFlexibleColumnName()
      throws DescriptorValidationException, IOException, InterruptedException, ExecutionException {
    String tableName = "SchemaUpdateFlexColumnTestTable";
    TableId tableId = TableId.of(DATASET, tableName);
    Field col1 = Field.newBuilder("col1-列", StandardSQLTypeName.STRING).build();
    Schema originalSchema = Schema.of(col1);
    TableInfo tableInfo =
        TableInfo.newBuilder(tableId, StandardTableDefinition.of(originalSchema)).build();
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
        JsonStreamWriter.newBuilder(writeStream.getName(), client).build()) {
      // write the 1st row
      JSONObject foo = new JSONObject();
      foo.put("col1-列", "aaa");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      ApiFuture<AppendRowsResponse> response = jsonStreamWriter.append(jsonArr, 0);
      assertEquals(0, response.get().getAppendResult().getOffset().getValue());

      // update schema with a new column
      Field col2 = Field.newBuilder("col2-列", StandardSQLTypeName.STRING).build();
      Schema updatedSchema = Schema.of(ImmutableList.of(col1, col2));
      TableInfo updatedTableInfo =
          TableInfo.newBuilder(tableId, StandardTableDefinition.of(updatedSchema)).build();
      Table updatedTable = bigquery.update(updatedTableInfo);
      assertEquals(updatedSchema, updatedTable.getDefinition().getSchema());

      // continue writing rows until backend acknowledges schema update
      JSONObject foo2 = new JSONObject();
      foo2.put("col1-列", "bbb");
      JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(foo2);

      int next = 0;
      for (int i = 1; i < 100; i++) {
        ApiFuture<AppendRowsResponse> response2 = jsonStreamWriter.append(jsonArr2, i);
        assertEquals(i, response2.get().getAppendResult().getOffset().getValue());
        if (response2.get().hasUpdatedSchema()) {
          next = i;
          break;
        } else {
          Thread.sleep(1000);
        }
      }

      // write rows with updated schema.
      JSONObject updatedFoo = new JSONObject();
      updatedFoo.put("col1-列", "ccc");
      updatedFoo.put("col2-列", "ddd");
      JSONArray updatedJsonArr = new JSONArray();
      updatedJsonArr.put(updatedFoo);
      for (int i = 0; i < 10; i++) {
        ApiFuture<AppendRowsResponse> response3 =
            jsonStreamWriter.append(updatedJsonArr, next + 1 + i);
        assertEquals(next + 1 + i, response3.get().getAppendResult().getOffset().getValue());
      }

      // verify table data correctness
      Iterator<FieldValueList> rowsIter = bigquery.listTableData(tableId).getValues().iterator();
      // 1 row of aaa
      assertEquals("aaa", rowsIter.next().get(0).getStringValue());
      // a few rows of bbb
      for (int j = 1; j <= next; j++) {
        assertEquals("bbb", rowsIter.next().get(0).getStringValue());
      }
      // 10 rows of ccc, ddd
      for (int j = next + 1; j < next + 1 + 10; j++) {
        FieldValueList temp = rowsIter.next();
        assertEquals("ccc", temp.get(0).getStringValue());
        assertEquals("ddd", temp.get(1).getStringValue());
      }
      assertFalse(rowsIter.hasNext());
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
        "[FieldValue{attribute=REPEATED, value=[FieldValue{attribute=PRIMITIVE, value=aaa},"
            + " FieldValue{attribute=PRIMITIVE, value=aaa}]}]",
        queryIter.next().get(1).getRepeatedValue().toString());
    assertEquals(
        "[FieldValue{attribute=REPEATED, value=[FieldValue{attribute=PRIMITIVE, value=bbb},"
            + " FieldValue{attribute=PRIMITIVE, value=bbb}]}]",
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
        assertEquals(Exceptions.SchemaMismatchedException.class, e.getCause().getClass());
        Exceptions.SchemaMismatchedException actualError = (SchemaMismatchedException) e.getCause();
        assertNotNull(actualError.getStreamName());
        // This verifies that the Beam connector can consume this custom exception's grpc StatusCode
        assertEquals(Code.INVALID_ARGUMENT, Status.fromThrowable(e.getCause()).getCode());
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
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .build()) {
      // Append once before finalizing the stream
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 0);
      response.get();
      // Finalize the stream in order to trigger STREAM_FINALIZED error
      client.finalizeWriteStream(
          FinalizeWriteStreamRequest.newBuilder().setName(writeStream.getName()).build());
      // Try to append to a finalized stream
      ApiFuture<AppendRowsResponse> response2 =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 1);
      try {
        response2.get();
        Assert.fail("Should fail");
      } catch (ExecutionException e) {
        assertEquals(Exceptions.StreamFinalizedException.class, e.getCause().getClass());
        Exceptions.StreamFinalizedException actualError = (StreamFinalizedException) e.getCause();
        assertNotNull(actualError.getStreamName());
        // This verifies that the Beam connector can consume this custom exception's grpc StatusCode
        assertEquals(Code.INVALID_ARGUMENT, Status.fromThrowable(e.getCause()).getCode());
        assertThat(e.getCause().getMessage()).contains("Stream has been finalized");
      }
    }
  }

  @Test
  public void testOffsetAlreadyExistsError()
      throws IOException, ExecutionException, InterruptedException {
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
      // Append once with correct offset
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 0);
      response.get();
      // Append again with the same offset
      ApiFuture<AppendRowsResponse> response2 =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 0);
      try {
        response2.get();
        Assert.fail("Should fail");
      } catch (ExecutionException e) {
        assertEquals(Exceptions.OffsetAlreadyExists.class, e.getCause().getClass());
        Exceptions.OffsetAlreadyExists actualError = (OffsetAlreadyExists) e.getCause();
        assertNotNull(actualError.getStreamName());
        assertEquals(1, actualError.getExpectedOffset());
        assertEquals(0, actualError.getActualOffset());
        assertEquals(Code.ALREADY_EXISTS, Status.fromThrowable(e.getCause()).getCode());
        assertThat(e.getCause().getMessage())
            .contains("The offset is within stream, expected offset 1, received 0");
      }
    }
  }

  @Test
  public void testOffsetOutOfRangeError() throws IOException, InterruptedException {
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
      // Append with an out of range offset
      ApiFuture<AppendRowsResponse> response =
          streamWriter.append(CreateProtoRowsMultipleColumns(new String[] {"a"}), /*offset=*/ 10);
      try {
        response.get();
        Assert.fail("Should fail");
      } catch (ExecutionException e) {
        assertEquals(Exceptions.OffsetOutOfRange.class, e.getCause().getClass());
        Exceptions.OffsetOutOfRange actualError = (OffsetOutOfRange) e.getCause();
        assertNotNull(actualError.getStreamName());
        assertEquals(0, actualError.getExpectedOffset());
        assertEquals(10, actualError.getActualOffset());
        assertEquals(Code.OUT_OF_RANGE, Status.fromThrowable(e.getCause()).getCode());
        assertThat(e.getCause().getMessage())
            .contains("The offset is beyond stream, expected offset 0, received 10");
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

  @Test
  public void testMultiplexingMixedLocation()
      throws IOException, InterruptedException, ExecutionException {
    ConnectionWorkerPool.setOptions(
        ConnectionWorkerPool.Settings.builder()
            .setMinConnectionsPerRegion(1)
            .setMaxConnectionsPerRegion(2)
            .build());
    String defaultStream1 =
        String.format(
            "projects/%s/datasets/%s/tables/%s/streams/_default",
            ServiceOptions.getDefaultProjectId(), DATASET, TABLE);
    String defaultStream2 =
        String.format(
            "projects/%s/datasets/%s/tables/%s/streams/_default",
            ServiceOptions.getDefaultProjectId(), DATASET, TABLE2);
    String defaultStream3 =
        String.format(
            "projects/%s/datasets/%s/tables/%s/streams/_default",
            ServiceOptions.getDefaultProjectId(), DATASET_EU, TABLE);

    StreamWriter streamWriter1 =
        StreamWriter.newBuilder(defaultStream1)
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .setEnableConnectionPool(true)
            .setTraceId(TEST_TRACE_ID)
            .build();
    StreamWriter streamWriter2 =
        StreamWriter.newBuilder(defaultStream2)
            .setWriterSchema(ProtoSchemaConverter.convert(ComplicateType.getDescriptor()))
            .setEnableConnectionPool(true)
            .setTraceId(TEST_TRACE_ID)
            .build();
    StreamWriter streamWriter3 =
        StreamWriter.newBuilder(defaultStream3)
            .setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()))
            .setEnableConnectionPool(true)
            .setTraceId(TEST_TRACE_ID)
            .build();
    ApiFuture<AppendRowsResponse> response1 =
        streamWriter1.append(CreateProtoRows(new String[] {"aaa"}));
    ApiFuture<AppendRowsResponse> response2 =
        streamWriter2.append(CreateProtoRowsComplex(new String[] {"aaa"}));
    ApiFuture<AppendRowsResponse> response3 =
        streamWriter3.append(CreateProtoRows(new String[] {"bbb"}));
    assertEquals(0L, response1.get().getAppendResult().getOffset().getValue());
    assertEquals(0L, response2.get().getAppendResult().getOffset().getValue());
    assertEquals(0L, response3.get().getAppendResult().getOffset().getValue());
    assertEquals("us", streamWriter1.getLocation());
    assertEquals("us", streamWriter2.getLocation());
    assertEquals("eu", streamWriter3.getLocation());
    streamWriter1.close();
    streamWriter2.close();
    streamWriter3.close();
  }

  @Test
  public void testLargeRequest() throws IOException, InterruptedException, ExecutionException {
    String tableName = "largeRequestTable";
    TableId tableId = TableId.of(DATASET, tableName);
    Field col1 = Field.newBuilder("col1", StandardSQLTypeName.STRING).build();
    Schema originalSchema = Schema.of(col1);
    TableInfo tableInfo =
        TableInfo.newBuilder(tableId, StandardTableDefinition.of(originalSchema)).build();
    bigquery.create(tableInfo);
    TableName parent = TableName.of(ServiceOptions.getDefaultProjectId(), DATASET, tableName);
    try (StreamWriter streamWriter =
        StreamWriter.newBuilder(parent.toString() + "/_default")
            .setWriterSchema(CreateProtoSchemaWithColField())
            .build()) {
      List<Integer> sizeSet = Arrays.asList(15 * 1024 * 1024, 1024);
      List<ApiFuture<AppendRowsResponse>> responseList =
          new ArrayList<ApiFuture<AppendRowsResponse>>();
      Random r = new Random();
      for (int i = 0; i < 50; i++) {
        int size = sizeSet.get(r.nextInt(2));
        LOG.info("Sending size: " + size);
        responseList.add(
            streamWriter.append(
                CreateProtoRows(
                    new String[] {
                      new String(new char[size]).replace('\u0000', (char) (r.nextInt(26) + 'a'))
                    })));
      }
      for (int i = 0; i < 50; i++) {
        assertFalse(responseList.get(i).get().hasError());
      }
      TableResult queryResult =
          bigquery.query(
              QueryJobConfiguration.newBuilder("SELECT count(*) from " + DATASET + '.' + tableName)
                  .build());
      Iterator<FieldValueList> queryIter = queryResult.getValues().iterator();
      assertTrue(queryIter.hasNext());
      assertEquals("50", queryIter.next().get(0).getStringValue());
    }
  }
}
