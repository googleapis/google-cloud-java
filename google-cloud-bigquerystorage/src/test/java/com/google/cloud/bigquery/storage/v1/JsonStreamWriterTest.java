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
package com.google.cloud.bigquery.storage.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.client.util.Sleeper;
import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.storage.test.JsonTest;
import com.google.cloud.bigquery.storage.test.SchemaTest;
import com.google.cloud.bigquery.storage.test.Test.FlexibleType;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.test.Test.UpdatedFooType;
import com.google.cloud.bigquery.storage.v1.ConnectionWorkerPool.Settings;
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializtionError;
import com.google.cloud.bigquery.storage.v1.TableFieldSchema.Mode;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;

@RunWith(JUnit4.class)
public class JsonStreamWriterTest {
  private static final Logger LOG = Logger.getLogger(JsonStreamWriterTest.class.getName());
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
  private static final String TEST_STREAM_2 = "projects/p/datasets/d2/tables/t2/streams/s2";
  private static final String TEST_TABLE = "projects/p/datasets/d/tables/t";
  private static final ExecutorProvider SINGLE_THREAD_EXECUTOR =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();
  private static LocalChannelProvider channelProvider;
  private FakeScheduledExecutorService fakeExecutor;
  private FakeBigQueryWrite testBigQueryWrite;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteClient client;

  private final TableFieldSchema FOO =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRING)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("foo")
          .build();
  private final TableFieldSchema BAR =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRING)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("bar")
          .build();
  private final TableFieldSchema BAZ =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRING)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("baz")
          .build();

  private final TableSchema TABLE_SCHEMA = TableSchema.newBuilder().addFields(0, FOO).build();
  private final TableSchema TABLE_SCHEMA_2 = TableSchema.newBuilder().addFields(0, BAZ).build();

  private final TableSchema UPDATED_TABLE_SCHEMA =
      TableSchema.newBuilder().addFields(0, FOO).addFields(1, BAR).build();
  private final TableSchema UPDATED_TABLE_SCHEMA_2 =
      TableSchema.newBuilder().addFields(0, FOO).addFields(1, BAR).addFields(2, BAZ).build();
  private final ProtoSchema PROTO_SCHEMA =
      ProtoSchemaConverter.convert(
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(TABLE_SCHEMA));
  private final ProtoSchema PROTO_SCHEMA_2 =
      ProtoSchemaConverter.convert(
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(TABLE_SCHEMA_2));
  private final ProtoSchema UPDATED_PROTO_SCHEMA =
      ProtoSchemaConverter.convert(
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(
              UPDATED_TABLE_SCHEMA));

  private final TableFieldSchema TEST_INT =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.INT64)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_int")
          .build();
  private final TableFieldSchema TEST_STRING =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRING)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_string")
          .build();

  public JsonStreamWriterTest() throws DescriptorValidationException {}

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(testBigQueryWrite));
    serviceHelper.start();
    channelProvider = serviceHelper.createChannelProvider();
    fakeExecutor = new FakeScheduledExecutorService();
    testBigQueryWrite.setExecutor(fakeExecutor);
    BigQueryWriteSettings settings =
        BigQueryWriteSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigQueryWriteClient.create(settings);
    Instant time = Instant.now();
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    StreamWriter.cleanUp();
  }

  @After
  public void tearDown() throws Exception {
    serviceHelper.stop();
  }

  private JsonStreamWriter.Builder getTestJsonStreamWriterBuilder(
      String testStream, TableSchema BQTableSchema) {
    return JsonStreamWriter.newBuilder(testStream, BQTableSchema, client)
        .setChannelProvider(channelProvider)
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setExecutorProvider(InstantiatingExecutorProvider.newBuilder().build());
  }

  @Test
  public void testTwoParamNewBuilder_nullSchema() {
    try {
      getTestJsonStreamWriterBuilder(null, TABLE_SCHEMA);
      Assert.fail("expected NullPointerException");
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), "StreamOrTableName is null.");
    }
  }

  @Test
  public void testTwoParamNewBuilder_nullStream() {
    try {
      getTestJsonStreamWriterBuilder(TEST_STREAM, null);
      Assert.fail("expected NullPointerException");
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), "TableSchema is null.");
    }
  }

  @Test
  public void testTwoParamNewBuilder()
      throws DescriptorValidationException, IOException, InterruptedException {
    JsonStreamWriter writer = getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build();
    assertEquals(TEST_STREAM, writer.getStreamName());
  }

  @Test
  public void testSingleAppendSimpleJson() throws Exception {
    FooType expectedProto = FooType.newBuilder().setFoo("allen").build();
    JSONObject foo = new JSONObject();
    foo.put("foo", "allen");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setTraceId("test:empty")
            .build()) {

      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
              .build());

      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      assertEquals(0L, appendFuture.get().getAppendResult().getOffset().getValue());
      appendFuture.get();
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          expectedProto.toByteString());
      assertEquals(
          testBigQueryWrite.getAppendRequests().get(0).getTraceId(), "JsonWriter_test:empty");
    }
  }

  @Test
  public void testFlexibleColumnAppend() throws Exception {
    TableFieldSchema field =
        TableFieldSchema.newBuilder()
            .setType(TableFieldSchema.Type.STRING)
            .setMode(TableFieldSchema.Mode.NULLABLE)
            .setName("test-列")
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, field).build();
    FlexibleType expectedProto = FlexibleType.newBuilder().setColDGVzdC3LiJc("allen").build();
    JSONObject flexible = new JSONObject();
    flexible.put("test-列", "allen");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(flexible);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, tableSchema).setTraceId("test:empty").build()) {

      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
              .build());

      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      assertEquals(0L, appendFuture.get().getAppendResult().getOffset().getValue());
      appendFuture.get();
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          expectedProto.toByteString());
      assertEquals(
          testBigQueryWrite.getAppendRequests().get(0).getTraceId(), "JsonWriter_test:empty");
    }
  }

  @Test
  public void testSpecialTypeAppend() throws Exception {
    TableFieldSchema field =
        TableFieldSchema.newBuilder()
            .setName("time")
            .setType(TableFieldSchema.Type.TIME)
            .setMode(TableFieldSchema.Mode.REPEATED)
            .build();
    TableSchema tableSchema = TableSchema.newBuilder().addFields(field).build();

    JsonTest.TestTime expectedProto =
        JsonTest.TestTime.newBuilder()
            .addTime(CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(1, 0, 1)))
            .build();
    JSONObject foo = new JSONObject();
    foo.put("time", new JSONArray(new String[] {"01:00:01"}));
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, tableSchema).build()) {

      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
              .build());

      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      assertEquals(0L, appendFuture.get().getAppendResult().getOffset().getValue());
      appendFuture.get();
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          expectedProto.toByteString());
    }
  }

  @Test
  public void testSingleAppendMultipleSimpleJson() throws Exception {
    FooType expectedProto = FooType.newBuilder().setFoo("allen").build();
    JSONObject foo = new JSONObject();
    foo.put("foo", "allen");
    JSONObject foo1 = new JSONObject();
    foo1.put("foo", "allen");
    JSONObject foo2 = new JSONObject();
    foo2.put("foo", "allen");
    JSONObject foo3 = new JSONObject();
    foo3.put("foo", "allen");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);
    jsonArr.put(foo1);
    jsonArr.put(foo2);
    jsonArr.put(foo3);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
              .build());

      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);

      assertEquals(0L, appendFuture.get().getAppendResult().getOffset().getValue());
      appendFuture.get();
      assertEquals(
          4,
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(testBigQueryWrite.getAppendRequests().get(0).getTraceId(), "JsonWriter:null");
      for (int i = 0; i < 4; i++) {
        assertEquals(
            testBigQueryWrite
                .getAppendRequests()
                .get(0)
                .getProtoRows()
                .getRows()
                .getSerializedRows(i),
            expectedProto.toByteString());
      }
    }
  }

  @Test
  public void testMultipleAppendSimpleJson() throws Exception {
    FooType expectedProto = FooType.newBuilder().setFoo("allen").build();
    JSONObject foo = new JSONObject();
    foo.put("foo", "allen");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
              .build());
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(1)).build())
              .build());
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(2)).build())
              .build());
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(3)).build())
              .build());
      ApiFuture<AppendRowsResponse> appendFuture;
      for (int i = 0; i < 4; i++) {
        appendFuture = writer.append(jsonArr);
        assertEquals((long) i, appendFuture.get().getAppendResult().getOffset().getValue());
        appendFuture.get();
        assertEquals(
            1,
            testBigQueryWrite
                .getAppendRequests()
                .get(i)
                .getProtoRows()
                .getRows()
                .getSerializedRowsCount());
        assertEquals(
            testBigQueryWrite
                .getAppendRequests()
                .get(i)
                .getProtoRows()
                .getRows()
                .getSerializedRows(0),
            expectedProto.toByteString());
      }
    }
  }

  @Test
  public void testAppendOutOfRangeException() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setError(com.google.rpc.Status.newBuilder().setCode(11).build())
              .build());
      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      try {
        appendFuture.get();
        Assert.fail("expected ExecutionException");
      } catch (ExecutionException ex) {
        assertEquals(ex.getCause().getMessage(), "OUT_OF_RANGE: ");
      }
    }
  }

  @Test
  public void testCreateDefaultStream_withNoSchemaPassedIn() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder().addFields(0, TEST_INT).addFields(1, TEST_STRING).build();
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder()
            .setName(TEST_STREAM)
            .setLocation("aa")
            .setTableSchema(tableSchema)
            .build());
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(TEST_TABLE, client)
            .setChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setExecutorProvider(InstantiatingExecutorProvider.newBuilder().build())
            .build()) {
      assertEquals("projects/p/datasets/d/tables/t/_default", writer.getStreamName());
      assertEquals("aa", writer.getLocation());
    }
  }

  @Test
  public void testCreateDefaultStream_withNoClientPassedIn() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder().addFields(0, TEST_INT).addFields(1, TEST_STRING).build();
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder()
            .setName(TEST_STREAM)
            .setLocation("aa")
            .setTableSchema(tableSchema)
            .build());
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(TEST_TABLE, tableSchema)
            .setChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setExecutorProvider(InstantiatingExecutorProvider.newBuilder().build())
            .setEnableConnectionPool(true)
            .build()) {
      assertEquals("projects/p/datasets/d/tables/t/_default", writer.getStreamName());
      assertEquals("aa", writer.getLocation());
    }
  }

  @Test
  public void testCreateDefaultStreamWrongLocation() throws Exception {
    TableSchema tableSchema =
        TableSchema.newBuilder().addFields(0, TEST_INT).addFields(1, TEST_STRING).build();
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder()
            .setName(TEST_STREAM)
            .setLocation("aa")
            .setTableSchema(tableSchema)
            .build());
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            new ThrowingRunnable() {
              @Override
              public void run() throws Throwable {
                JsonStreamWriter.newBuilder(TEST_TABLE, client)
                    .setChannelProvider(channelProvider)
                    .setCredentialsProvider(NoCredentialsProvider.create())
                    .setLocation("bb")
                    .build();
              }
            });
    assertEquals("Specified location bb does not match the system value aa", ex.getMessage());
  }

  @Test
  public void testSimpleSchemaUpdate() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setAppendResult(
                  AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
              .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
              .build());
      testBigQueryWrite.addResponse(createAppendResponse(1));
      testBigQueryWrite.addResponse(createAppendResponse(2));
      testBigQueryWrite.addResponse(createAppendResponse(3));
      // First append
      JSONObject foo = new JSONObject();
      foo.put("foo", "aaa");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);

      ApiFuture<AppendRowsResponse> appendFuture1 = writer.append(jsonArr);
      ApiFuture<AppendRowsResponse> appendFuture2 = writer.append(jsonArr);
      ApiFuture<AppendRowsResponse> appendFuture3 = writer.append(jsonArr);

      assertEquals(0L, appendFuture1.get().getAppendResult().getOffset().getValue());
      assertEquals(1L, appendFuture2.get().getAppendResult().getOffset().getValue());
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          FooType.newBuilder().setFoo("aaa").build().toByteString());

      assertEquals(2L, appendFuture3.get().getAppendResult().getOffset().getValue());
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(1)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(1)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          FooType.newBuilder().setFoo("aaa").build().toByteString());

      // Second append with updated schema.
      JSONObject updatedFoo = new JSONObject();
      updatedFoo.put("foo", "aaa");
      updatedFoo.put("bar", "bbb");
      JSONArray updatedJsonArr = new JSONArray();
      updatedJsonArr.put(updatedFoo);

      ApiFuture<AppendRowsResponse> appendFuture4 = writer.append(updatedJsonArr);

      assertEquals(3L, appendFuture4.get().getAppendResult().getOffset().getValue());
      assertEquals(4, testBigQueryWrite.getAppendRequests().size());
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(3)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(3)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          UpdatedFooType.newBuilder().setFoo("aaa").setBar("bbb").build().toByteString());

      assertTrue(testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
      assertTrue(
          testBigQueryWrite.getAppendRequests().get(2).getProtoRows().hasWriterSchema()
              || testBigQueryWrite.getAppendRequests().get(3).getProtoRows().hasWriterSchema());
    }
  }

  @Test
  public void testWithoutIgnoreUnknownFieldsUpdateImmeidateSuccess() throws Exception {
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_INT).build();
    TableSchema updatedSchema =
        TableSchema.newBuilder()
            .addFields(0, TEST_INT)
            .addFields(
                1,
                TableFieldSchema.newBuilder()
                    .setName("test_string")
                    .setType(TableFieldSchema.Type.STRING)
                    .setMode(Mode.NULLABLE))
            .build();
    // GetWriteStream is called once and the writer is fixed to accept unknown fields.
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(updatedSchema).build());
    testBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
            .build());
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, tableSchema).build()) {
      JSONObject foo = new JSONObject();
      foo.put("test_int", 10);
      JSONObject bar = new JSONObject();
      bar.put("test_string", "a");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      jsonArr.put(bar);
      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      appendFuture.get();
    }
  }

  @Test
  public void testWithoutIgnoreUnknownFieldsUpdateSecondSuccess() throws Exception {
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_INT).build();
    TableSchema updatedSchema =
        TableSchema.newBuilder()
            .addFields(0, TEST_INT)
            .addFields(
                1,
                TableFieldSchema.newBuilder()
                    .setName("test_string")
                    .setType(TableFieldSchema.Type.STRING)
                    .setMode(Mode.NULLABLE))
            .build();
    // GetWriteStream is called twice and got the updated schema
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(tableSchema).build());
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(updatedSchema).build());
    testBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
            .build());
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, tableSchema).build()) {
      JSONObject foo = new JSONObject();
      foo.put("test_int", 10);
      JSONObject bar = new JSONObject();
      bar.put("test_string", "a");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      jsonArr.put(bar);
      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      appendFuture.get();
    }
  }

  @Test
  public void testSchemaUpdateInMultiplexing_singleConnection() throws Exception {
    // Set min connection count to be 1 to force sharing connection.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());
    // The following two writers have different stream name and schema, but will share the same
    // connection .
    JsonStreamWriter writer1 =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();
    JsonStreamWriter writer2 =
        getTestJsonStreamWriterBuilder(TEST_STREAM_2, TABLE_SCHEMA_2)
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();

    testBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
            .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
            .setWriteStream(TEST_STREAM)
            .build());
    testBigQueryWrite.addResponse(createAppendResponse(1));
    testBigQueryWrite.addResponse(createAppendResponse(2));
    testBigQueryWrite.addResponse(createAppendResponse(3));
    // Append request with old schema for writer 1.
    JSONObject foo = new JSONObject();
    foo.put("foo", "aaa");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    // Append request with old schema for writer 2.
    JSONObject baz = new JSONObject();
    baz.put("baz", "bbb");
    JSONArray jsonArr2 = new JSONArray();
    jsonArr2.put(baz);

    // Append request with new schema.
    JSONObject updatedFoo = new JSONObject();
    updatedFoo.put("foo", "aaa");
    updatedFoo.put("bar", "bbb");
    JSONArray updatedJsonArr = new JSONArray();
    updatedJsonArr.put(updatedFoo);

    // This append will trigger new schema update.
    ApiFuture<AppendRowsResponse> appendFuture1 = writer1.append(jsonArr);
    // This append be put onto the same connection as the first one.
    ApiFuture<AppendRowsResponse> appendFuture2 = writer2.append(jsonArr2);

    // Sleep for a small period of time to make sure the updated schema is stored.
    Sleeper.DEFAULT.sleep(300);
    // Back to writer1 here, we are expected to use the updated schema already.
    // Both of the following append will be parsed correctly.
    ApiFuture<AppendRowsResponse> appendFuture3 = writer1.append(updatedJsonArr);
    ApiFuture<AppendRowsResponse> appendFuture4 = writer1.append(jsonArr);

    assertEquals(0L, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1L, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertEquals(2L, appendFuture3.get().getAppendResult().getOffset().getValue());
    assertEquals(3L, appendFuture4.get().getAppendResult().getOffset().getValue());

    // The 1st schema comes from writer1's initial schema
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(0).getProtoRows().getWriterSchema(),
        PROTO_SCHEMA);
    // The 2nd schema comes from writer2's initial schema
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(1).getProtoRows().getWriterSchema(),
        PROTO_SCHEMA_2);
    // The 3rd schema comes from writer1's updated schema
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(2).getProtoRows().getWriterSchema(),
        UPDATED_PROTO_SCHEMA);
    // The 4th schema should be empty as schema update is already done for writer 1.
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(3).getProtoRows().getWriterSchema(),
        ProtoSchema.getDefaultInstance());
    writer1.close();
    writer2.close();
  }

  @Test
  public void testSchemaUpdateInMultiplexing_multipleWriterForSameStreamName() throws Exception {
    // Set min connection count to be 1 to force sharing connection.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());

    // Create two writers writing to the same stream.
    JsonStreamWriter writer1 =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();
    JsonStreamWriter writer2 =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();

    // Trigger schema update in the second request.
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(1)).build())
            .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
            .setWriteStream(TEST_STREAM)
            .build());
    testBigQueryWrite.addResponse(createAppendResponse(2));
    testBigQueryWrite.addResponse(createAppendResponse(3));
    // Append request with old schema.
    JSONObject foo = new JSONObject();
    foo.put("foo", "aaa");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    // Append request with new schema.
    JSONObject updatedFoo = new JSONObject();
    updatedFoo.put("foo", "aaa");
    updatedFoo.put("bar", "bbb");
    JSONArray updatedJsonArr = new JSONArray();
    updatedJsonArr.put(updatedFoo);

    // Normal append, nothing happens
    ApiFuture<AppendRowsResponse> appendFuture1 = writer1.append(jsonArr);
    // This append triggers updated schema
    ApiFuture<AppendRowsResponse> appendFuture2 = writer2.append(jsonArr);

    // Sleep for a small period of time to make sure the updated schema is stored.
    Sleeper.DEFAULT.sleep(300);
    // From now on everyone should be able to use the new schema.
    ApiFuture<AppendRowsResponse> appendFuture3 = writer1.append(updatedJsonArr);
    ApiFuture<AppendRowsResponse> appendFuture4 = writer2.append(updatedJsonArr);

    assertEquals(0L, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1L, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertEquals(2L, appendFuture3.get().getAppendResult().getOffset().getValue());
    assertEquals(3L, appendFuture4.get().getAppendResult().getOffset().getValue());

    // The 1st schema comes from writer1's initial schema
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(0).getProtoRows().getWriterSchema(),
        PROTO_SCHEMA);
    // The 2nd append trigger no schema change.
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(1).getProtoRows().getWriterSchema(),
        ProtoSchema.getDefaultInstance());
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(2).getProtoRows().getWriterSchema(),
        UPDATED_PROTO_SCHEMA);
    // The next request after schema update will back to empty.
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(3).getProtoRows().getWriterSchema(),
        ProtoSchema.getDefaultInstance());
    writer1.close();
    writer2.close();
  }

  @Test
  public void testSchemaUpdateInMultiplexing_IgnoreUpdateIfTimeStampNewer() throws Exception {
    // Set min connection count to be 1 to force sharing connection.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());
    // The following two writers have different stream name and schema, but will share the same
    // connection .
    JsonStreamWriter writer1 =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();

    testBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
            .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
            .setWriteStream(TEST_STREAM)
            .build());
    testBigQueryWrite.addResponse(createAppendResponse(1));
    testBigQueryWrite.addResponse(createAppendResponse(2));
    testBigQueryWrite.addResponse(createAppendResponse(3));
    // Append request with old schema for writer 1.
    JSONObject foo = new JSONObject();
    foo.put("foo", "aaa");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    // Append request with old schema for writer 2.
    JSONObject baz = new JSONObject();
    baz.put("baz", "bbb");
    JSONArray jsonArr2 = new JSONArray();
    jsonArr2.put(baz);

    // Append request with new schema.
    JSONObject updatedFoo = new JSONObject();
    updatedFoo.put("foo", "aaa");
    updatedFoo.put("bar", "bbb");
    JSONArray updatedJsonArr = new JSONArray();
    updatedJsonArr.put(updatedFoo);

    // This append will trigger new schema update.
    ApiFuture<AppendRowsResponse> appendFuture1 = writer1.append(jsonArr);
    // Sleep for a small period of time to make sure the updated schema is stored.
    Sleeper.DEFAULT.sleep(300);
    // Write to writer 1 again, new schema should be used.
    // The following two append will succeeds.
    ApiFuture<AppendRowsResponse> appendFuture2 = writer1.append(updatedJsonArr);
    ApiFuture<AppendRowsResponse> appendFuture3 = writer1.append(jsonArr);

    // Second phase of the test: create another writer.
    // Expect the append went through without using the updated schema
    JsonStreamWriter writer2 =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA_2)
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();
    ApiFuture<AppendRowsResponse> appendFuture4 = writer2.append(jsonArr2);

    assertEquals(0L, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1L, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertEquals(2L, appendFuture3.get().getAppendResult().getOffset().getValue());
    assertEquals(3L, appendFuture4.get().getAppendResult().getOffset().getValue());

    // The 1st schema comes from writer1's initial schema
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(0).getProtoRows().getWriterSchema(),
        PROTO_SCHEMA);
    // The 2nd schema comes from updated schema
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(1).getProtoRows().getWriterSchema(),
        UPDATED_PROTO_SCHEMA);
    // No new schema.
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(2).getProtoRows().getWriterSchema(),
        ProtoSchema.getDefaultInstance());
    // The 4th schema come from the
    assertEquals(
        testBigQueryWrite.getAppendRequests().get(3).getProtoRows().getWriterSchema(),
        PROTO_SCHEMA_2);
    writer1.close();
    writer2.close();
  }

  @Test
  public void testWithoutIgnoreUnknownFieldsUpdateFail() throws Exception {
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_INT).build();
    // GetWriteStream is called once but failed to update to the right schema.
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(tableSchema).build());
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(tableSchema).build());
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, tableSchema).build()) {
      JSONObject foo = new JSONObject();
      foo.put("test_int", 10);
      JSONObject bar = new JSONObject();
      bar.put("test_unknown", 10);
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      jsonArr.put(bar);
      try {
        ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
        Assert.fail("expected ExecutionException");
      } catch (AppendSerializtionError ex) {
        assertEquals(
            "JSONObject has fields unknown to BigQuery: root.test_unknown.",
            ex.getRowIndexToErrorMessage().get(1));
        assertEquals(TEST_STREAM, ex.getStreamName());
      }
    }
  }

  @Test
  public void testWithIgnoreUnknownFields() throws Exception {
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_INT).build();
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(TEST_STREAM, tableSchema)
            .setChannelProvider(channelProvider)
            .setIgnoreUnknownFields(true)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setExecutorProvider(InstantiatingExecutorProvider.newBuilder().build())
            .build()) {
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      JSONObject foo = new JSONObject();
      foo.put("test_int", 10);
      JSONObject bar = new JSONObject();
      bar.put("test_unknown", 10);
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      jsonArr.put(bar);
      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      appendFuture.get();
    }
  }

  @Test
  public void testFlowControlSetting() throws Exception {
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_INT).build();
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(TEST_STREAM, tableSchema)
            .setChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setExecutorProvider(InstantiatingExecutorProvider.newBuilder().build())
            .setFlowControlSettings(
                FlowControlSettings.newBuilder()
                    .setLimitExceededBehavior(FlowController.LimitExceededBehavior.ThrowException)
                    .setMaxOutstandingRequestBytes(1L)
                    .build())
            .build()) {
      JSONObject foo = new JSONObject();
      foo.put("test_int", 10);
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      StatusRuntimeException ex =
          assertThrows(
              StatusRuntimeException.class,
              new ThrowingRunnable() {
                @Override
                public void run() throws Throwable {
                  writer.append(jsonArr);
                }
              });
      assertEquals(ex.getStatus().getCode(), Status.RESOURCE_EXHAUSTED.getCode());
      assertTrue(
          ex.getStatus()
              .getDescription()
              .contains(
                  "Exceeds client side inflight buffer, consider add more buffer or open more connections"));
    }
  }

  // This is to test the new addition didn't break previous settings, i.e., sets the inflight limit
  // without limit beahvior.
  @Test
  public void testFlowControlSettingNoLimitBehavior() throws Exception {
    TableSchema tableSchema = TableSchema.newBuilder().addFields(0, TEST_INT).build();
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(TEST_STREAM, tableSchema)
            .setChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setExecutorProvider(InstantiatingExecutorProvider.newBuilder().build())
            .setFlowControlSettings(
                FlowControlSettings.newBuilder().setMaxOutstandingRequestBytes(1L).build())
            .build()) {
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().build());
      JSONObject foo = new JSONObject();
      foo.put("test_int", 10);
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
      appendFuture.get();
    }
  }

  @Test
  public void testMultipleAppendSerializtionErrors()
      throws DescriptorValidationException, IOException, InterruptedException {
    FooType expectedProto = FooType.newBuilder().setFoo("allen").build();
    JSONObject foo = new JSONObject();
    // put a field which is not part of the expected schema
    foo.put("not_foo", "allen");
    JSONObject foo1 = new JSONObject();
    // put a vaild value into the field
    foo1.put("foo", "allen");
    JSONObject foo2 = new JSONObject();
    // put a number into a string field
    foo2.put("foo", 666);
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);
    jsonArr.put(foo1);
    jsonArr.put(foo2);
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(TABLE_SCHEMA).build());
    testBigQueryWrite.addResponse(
        WriteStream.newBuilder().setName(TEST_STREAM).setTableSchema(TABLE_SCHEMA).build());

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      try {
        ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
        Assert.fail("expected AppendSerializtionError");
      } catch (AppendSerializtionError appendSerializtionError) {
        Map<Integer, String> rowIndexToErrorMessage =
            appendSerializtionError.getRowIndexToErrorMessage();
        assertEquals(2, rowIndexToErrorMessage.size());
        assertEquals(
            "JSONObject has fields unknown to BigQuery: root.not_foo.",
            rowIndexToErrorMessage.get(0));
        assertEquals(
            "Field root.foo failed to convert to STRING. Error: JSONObject does not have a string field at root.foo.",
            rowIndexToErrorMessage.get(2));
      }
    }
  }

  @Test
  public void testBadStringToNumericRowError()
      throws DescriptorValidationException, IOException, InterruptedException {
    TableSchema TABLE_SCHEMA =
        TableSchema.newBuilder()
            .addFields(
                0,
                TableFieldSchema.newBuilder()
                    .setName("test_field_type")
                    .setType(TableFieldSchema.Type.NUMERIC)
                    .setMode(TableFieldSchema.Mode.NULLABLE)
                    .build())
            .build();
    SchemaTest.StringType expectedProto =
        SchemaTest.StringType.newBuilder().setTestFieldType("allen").build();
    JSONObject foo = new JSONObject();
    // put a field which is not part of the expected schema
    foo.put("test_field_type", "allen");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(foo);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      try {
        ApiFuture<AppendRowsResponse> appendFuture = writer.append(jsonArr);
        Assert.fail("expected AppendSerializtionError");
      } catch (AppendSerializtionError appendSerializtionError) {
        Map<Integer, String> rowIndexToErrorMessage =
            appendSerializtionError.getRowIndexToErrorMessage();
        assertEquals(1, rowIndexToErrorMessage.size());
        assertTrue(
            rowIndexToErrorMessage
                .get(0)
                .startsWith("Field root.test_field_type failed to convert to NUMERIC. Error:"));
      }
    }
  }

  @Test
  public void testWriterId()
      throws DescriptorValidationException, IOException, InterruptedException {
    JsonStreamWriter writer1 = getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build();
    Assert.assertFalse(writer1.getWriterId().isEmpty());
    JsonStreamWriter writer2 = getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build();
    Assert.assertFalse(writer2.getWriterId().isEmpty());
    Assert.assertNotEquals(writer1.getWriterId(), writer2.getWriterId());
  }

  private AppendRowsResponse createAppendResponse(long offset) {
    return AppendRowsResponse.newBuilder()
        .setAppendResult(
            AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(offset)).build())
        .build();
  }
}
