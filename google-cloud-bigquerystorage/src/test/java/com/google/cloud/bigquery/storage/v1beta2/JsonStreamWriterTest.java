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
package com.google.cloud.bigquery.storage.v1beta2;

import static org.junit.Assert.assertEquals;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.storage.test.JsonTest.ComplexRoot;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;

@RunWith(JUnit4.class)
public class JsonStreamWriterTest {
  private static final Logger LOG = Logger.getLogger(JsonStreamWriterTest.class.getName());
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
  private static final String TEST_TABLE = "projects/p/datasets/d/tables/t";
  private static final ExecutorProvider SINGLE_THREAD_EXECUTOR =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();
  private static LocalChannelProvider channelProvider;
  private FakeScheduledExecutorService fakeExecutor;
  private FakeBigQueryWrite testBigQueryWrite;
  private static MockServiceHelper serviceHelper;

  private final TableFieldSchema FOO =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRING)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("foo")
          .build();
  private final TableSchema TABLE_SCHEMA = TableSchema.newBuilder().addFields(0, FOO).build();

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
  private final TableSchema UPDATED_TABLE_SCHEMA =
      TableSchema.newBuilder().addFields(0, FOO).addFields(1, BAR).build();
  private final TableSchema UPDATED_TABLE_SCHEMA_2 =
      TableSchema.newBuilder().addFields(0, FOO).addFields(1, BAR).addFields(2, BAZ).build();

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
  private final TableFieldSchema TEST_BYTES =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BYTES)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .setName("test_bytes")
          .build();
  private final TableFieldSchema TEST_BOOL =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.BOOL)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_bool")
          .build();
  private final TableFieldSchema TEST_DOUBLE =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.DOUBLE)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_double")
          .build();
  private final TableFieldSchema TEST_DATE =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.DATE)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .setName("test_date")
          .build();
  private final TableFieldSchema COMPLEXLVL2 =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRUCT)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .addFields(0, TEST_INT)
          .setName("complex_lvl2")
          .build();
  private final TableFieldSchema COMPLEXLVL1 =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.STRUCT)
          .setMode(TableFieldSchema.Mode.REQUIRED)
          .addFields(0, TEST_INT)
          .addFields(1, COMPLEXLVL2)
          .setName("complex_lvl1")
          .build();
  private final TableFieldSchema TEST_NUMERIC =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_numeric")
          .build();
  private final TableFieldSchema TEST_NUMERIC_REPEATED =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.NUMERIC)
          .setMode(TableFieldSchema.Mode.REPEATED)
          .setName("test_numeric_repeated")
          .build();
  private final TableFieldSchema TEST_GEO =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.GEOGRAPHY)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_geo")
          .build();
  private final TableFieldSchema TEST_TIMESTAMP =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.TIMESTAMP)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_timestamp")
          .build();
  private final TableFieldSchema TEST_TIME =
      TableFieldSchema.newBuilder()
          .setType(TableFieldSchema.Type.TIME)
          .setMode(TableFieldSchema.Mode.NULLABLE)
          .setName("test_time")
          .build();
  private final TableSchema COMPLEX_TABLE_SCHEMA =
      TableSchema.newBuilder()
          .addFields(0, TEST_INT)
          .addFields(1, TEST_STRING)
          .addFields(2, TEST_BYTES)
          .addFields(3, TEST_BOOL)
          .addFields(4, TEST_DOUBLE)
          .addFields(5, TEST_DATE)
          .addFields(6, COMPLEXLVL1)
          .addFields(7, COMPLEXLVL2)
          .addFields(8, TEST_NUMERIC)
          .addFields(9, TEST_GEO)
          .addFields(10, TEST_TIMESTAMP)
          .addFields(11, TEST_TIME)
          .addFields(12, TEST_NUMERIC_REPEATED)
          .build();

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
    Instant time = Instant.now();
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    // Add enough GetWriteStream response.
    for (int i = 0; i < 4; i++) {
      testBigQueryWrite.addResponse(
          WriteStream.newBuilder().setName(TEST_STREAM).setCreateTime(timestamp).build());
    }
  }

  @After
  public void tearDown() throws Exception {
    serviceHelper.stop();
  }

  private JsonStreamWriter.Builder getTestJsonStreamWriterBuilder(
      String testStream, TableSchema BQTableSchema) {
    return JsonStreamWriter.newBuilder(testStream, BQTableSchema)
        .setChannelProvider(channelProvider)
        .setCredentialsProvider(NoCredentialsProvider.create());
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
  public void testSingleAppendComplexJson() throws Exception {
    ComplexRoot expectedProto =
        ComplexRoot.newBuilder()
            .setTestInt(1)
            .addTestString("a")
            .addTestString("b")
            .addTestString("c")
            .setTestBytes(ByteString.copyFrom("hello".getBytes()))
            .setTestBool(true)
            .addTestDouble(1.1)
            .addTestDouble(2.2)
            .addTestDouble(3.3)
            .addTestDouble(4.4)
            .setTestDate(1)
            .setComplexLvl1(
                com.google.cloud.bigquery.storage.test.JsonTest.ComplexLvl1.newBuilder()
                    .setTestInt(2)
                    .setComplexLvl2(
                        com.google.cloud.bigquery.storage.test.JsonTest.ComplexLvl2.newBuilder()
                            .setTestInt(3)
                            .build())
                    .build())
            .setComplexLvl2(
                com.google.cloud.bigquery.storage.test.JsonTest.ComplexLvl2.newBuilder()
                    .setTestInt(3)
                    .build())
            .setTestNumeric(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("1.23456")))
            .setTestGeo("POINT(1,1)")
            .setTestTimestamp(12345678)
            .setTestTime(CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(1, 0, 1)))
            .addTestNumericRepeated(
                BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0")))
            .addTestNumericRepeated(
                BigDecimalByteStringEncoder.encodeToNumericByteString(
                    new BigDecimal("99999999999999999999999999999.999999999")))
            .addTestNumericRepeated(
                BigDecimalByteStringEncoder.encodeToNumericByteString(
                    new BigDecimal("-99999999999999999999999999999.999999999")))
            .build();
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("test_int", 3);

    JSONObject complex_lvl1 = new JSONObject();
    complex_lvl1.put("test_int", 2);
    complex_lvl1.put("complex_lvl2", complex_lvl2);

    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("test_string", new JSONArray(new String[] {"a", "b", "c"}));
    json.put("test_bytes", ByteString.copyFrom("hello".getBytes()));
    json.put("test_bool", true);
    json.put("test_DOUBLe", new JSONArray(new Double[] {1.1, 2.2, 3.3, 4.4}));
    json.put("test_date", 1);
    json.put("complex_lvl1", complex_lvl1);
    json.put("complex_lvl2", complex_lvl2);
    json.put(
        "test_numeric",
        BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("1.23456")));
    json.put(
        "test_numeric_repeated",
        new JSONArray(
            new byte[][] {
              BigDecimalByteStringEncoder.encodeToNumericByteString(new BigDecimal("0"))
                  .toByteArray(),
              BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal("99999999999999999999999999999.999999999"))
                  .toByteArray(),
              BigDecimalByteStringEncoder.encodeToNumericByteString(
                      new BigDecimal("-99999999999999999999999999999.999999999"))
                  .toByteArray(),
            }));
    json.put("test_geo", "POINT(1,1)");
    json.put("test_timestamp", 12345678);
    json.put("test_time", CivilTimeEncoder.encodePacked64TimeMicros(LocalTime.of(1, 0, 1)));
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(json);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, COMPLEX_TABLE_SCHEMA).build()) {
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
  public void testCreateDefaultStream() throws Exception {
    Schema v2Schema =
        Schema.of(
            Field.newBuilder("foo", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.NULLABLE)
                .build());
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(TEST_TABLE, v2Schema)
            .setChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build()) {
      assertEquals("projects/p/datasets/d/tables/t/_default", writer.getStreamName());
    }
  }
}
