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
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.storage.test.JsonTest.ComplexRoot;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.test.Test.UpdatedFooType;
import com.google.cloud.bigquery.storage.test.Test.UpdatedFooType2;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.*;
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

@RunWith(JUnit4.class)
public class JsonStreamWriterTest {
  private static final Logger LOG = Logger.getLogger(JsonStreamWriterTest.class.getName());
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
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
        .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
        .setCredentialsProvider(NoCredentialsProvider.create());
  }

  @Test
  public void testTwoParamNewBuilder_nullSchema() {
    try {
      getTestJsonStreamWriterBuilder(null, TABLE_SCHEMA);
      Assert.fail("expected NullPointerException");
    } catch (NullPointerException e) {
      assertEquals(e.getMessage(), "StreamName is null.");
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

      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());

      ApiFuture<AppendRowsResponse> appendFuture =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);

      assertEquals(0L, appendFuture.get().getOffset());
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
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());

      ApiFuture<AppendRowsResponse> appendFuture =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);

      assertEquals(0L, appendFuture.get().getOffset());
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
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(1).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(3).build());
      ApiFuture<AppendRowsResponse> appendFuture;
      for (int i = 0; i < 4; i++) {
        appendFuture = writer.append(jsonArr, -1, /* allowUnknownFields */ false);

        assertEquals((long) i, appendFuture.get().getOffset());
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
            .build();
    JSONObject complex_lvl2 = new JSONObject();
    complex_lvl2.put("test_int", 3);

    JSONObject complex_lvl1 = new JSONObject();
    complex_lvl1.put("test_int", 2);
    complex_lvl1.put("complex_lvl2", complex_lvl2);

    JSONObject json = new JSONObject();
    json.put("test_int", 1);
    json.put("test_string", new JSONArray(new String[] {"a", "b", "c"}));
    json.put("test_bytes", "hello");
    json.put("test_bool", true);
    json.put("test_DOUBLe", new JSONArray(new Double[] {1.1, 2.2, 3.3, 4.4}));
    json.put("test_date", 1);
    json.put("complex_lvl1", complex_lvl1);
    json.put("complex_lvl2", complex_lvl2);
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(json);

    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, COMPLEX_TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());
      ApiFuture<AppendRowsResponse> appendFuture =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);

      assertEquals(0L, appendFuture.get().getOffset());
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
  public void testAppendMultipleSchemaUpdate() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      // Add fake resposne for FakeBigQueryWrite, first response has updated schema.
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setOffset(0)
              .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
              .build());
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setOffset(1)
              .setUpdatedSchema(UPDATED_TABLE_SCHEMA_2)
              .build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2).build());
      // First append
      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);

      ApiFuture<AppendRowsResponse> appendFuture1 =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);

      int millis = 0;
      while (millis <= 10000) {
        if (writer.getDescriptor().getFields().size() == 2) {
          break;
        }
        Thread.sleep(100);
        millis += 100;
      }
      assertTrue(writer.getDescriptor().getFields().size() == 2);
      assertEquals(0L, appendFuture1.get().getOffset());
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
          FooType.newBuilder().setFoo("allen").build().toByteString());

      // Second append with updated schema.
      JSONObject updatedFoo = new JSONObject();
      updatedFoo.put("foo", "allen");
      updatedFoo.put("bar", "allen2");
      JSONArray updatedJsonArr = new JSONArray();
      updatedJsonArr.put(updatedFoo);

      ApiFuture<AppendRowsResponse> appendFuture2 =
          writer.append(updatedJsonArr, -1, /* allowUnknownFields */ false);

      millis = 0;
      while (millis <= 10000) {
        if (writer.getDescriptor().getFields().size() == 3) {
          break;
        }
        Thread.sleep(100);
        millis += 100;
      }
      assertTrue(writer.getDescriptor().getFields().size() == 3);
      assertEquals(1L, appendFuture2.get().getOffset());
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
          UpdatedFooType.newBuilder().setFoo("allen").setBar("allen2").build().toByteString());

      // Third append with updated schema.
      JSONObject updatedFoo2 = new JSONObject();
      updatedFoo2.put("foo", "allen");
      updatedFoo2.put("bar", "allen2");
      updatedFoo2.put("baz", "allen3");
      JSONArray updatedJsonArr2 = new JSONArray();
      updatedJsonArr2.put(updatedFoo2);

      ApiFuture<AppendRowsResponse> appendFuture3 =
          writer.append(updatedJsonArr2, -1, /* allowUnknownFields */ false);

      assertEquals(2L, appendFuture3.get().getOffset());
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
              .get(2)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          UpdatedFooType2.newBuilder()
              .setFoo("allen")
              .setBar("allen2")
              .setBaz("allen3")
              .build()
              .toByteString());
      // // Check if writer schemas were added in for both connections.
      assertTrue(testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
      assertTrue(testBigQueryWrite.getAppendRequests().get(1).getProtoRows().hasWriterSchema());
      assertTrue(testBigQueryWrite.getAppendRequests().get(2).getProtoRows().hasWriterSchema());
    }
  }

  @Test
  // This might be a bug but it is the current behavior. Investigate.
  public void testAppendAlreadyExists_doesNotThrowxception()
      throws DescriptorValidationException, IOException, InterruptedException, ExecutionException {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setError(com.google.rpc.Status.newBuilder().setCode(6).build())
              .build());
      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      ApiFuture<AppendRowsResponse> appendFuture =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
      appendFuture.get();
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
      ApiFuture<AppendRowsResponse> appendFuture =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
      try {
        appendFuture.get();
        Assert.fail("expected ExecutionException");
      } catch (ExecutionException ex) {
        assertEquals(ex.getCause().getMessage(), "OUT_OF_RANGE: ");
      }
    }
  }

  @Test
  public void testAppendOutOfRangeAndUpdateSchema() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA).build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setError(com.google.rpc.Status.newBuilder().setCode(11).build())
              .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
              .build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(0).build());

      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);
      ApiFuture<AppendRowsResponse> appendFuture =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
      try {
        appendFuture.get();
        Assert.fail("expected ExecutionException");
      } catch (ExecutionException ex) {
        assertEquals(ex.getCause().getMessage(), "OUT_OF_RANGE: ");
        int millis = 0;
        while (millis <= 10000) {
          if (writer.getDescriptor().getFields().size() == 2) {
            break;
          }
          Thread.sleep(100);
          millis += 100;
        }
        assertTrue(writer.getDescriptor().getFields().size() == 2);
      }

      JSONObject updatedFoo = new JSONObject();
      updatedFoo.put("foo", "allen");
      updatedFoo.put("bar", "allen2");
      JSONArray updatedJsonArr = new JSONArray();
      updatedJsonArr.put(updatedFoo);

      ApiFuture<AppendRowsResponse> appendFuture2 =
          writer.append(updatedJsonArr, -1, /* allowUnknownFields */ false);

      assertEquals(0L, appendFuture2.get().getOffset());
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
          UpdatedFooType.newBuilder().setFoo("allen").setBar("allen2").build().toByteString());

      // Check if writer schemas were added in for both connections.
      assertTrue(testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
      assertTrue(testBigQueryWrite.getAppendRequests().get(1).getProtoRows().hasWriterSchema());
    }
  }

  @Test
  public void testSchemaUpdateWithNonemptyBatch() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .build())
            .build()) {
      testBigQueryWrite.addResponse(
          AppendRowsResponse.newBuilder()
              .setOffset(0)
              .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
              .build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(2).build());
      testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset(3).build());
      // First append
      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);

      ApiFuture<AppendRowsResponse> appendFuture1 =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
      ApiFuture<AppendRowsResponse> appendFuture2 =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
      ApiFuture<AppendRowsResponse> appendFuture3 =
          writer.append(jsonArr, -1, /* allowUnknownFields */ false);

      assertEquals(0L, appendFuture1.get().getOffset());
      assertEquals(1L, appendFuture2.get().getOffset());
      assertEquals(
          2,
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
          FooType.newBuilder().setFoo("allen").build().toByteString());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(0)
              .getProtoRows()
              .getRows()
              .getSerializedRows(1),
          FooType.newBuilder().setFoo("allen").build().toByteString());

      assertEquals(2L, appendFuture3.get().getOffset());
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
          FooType.newBuilder().setFoo("allen").build().toByteString());

      int millis = 0;
      while (millis <= 10000) {
        if (writer.getDescriptor().getFields().size() == 2) {
          break;
        }
        Thread.sleep(100);
        millis += 100;
      }
      assertTrue(writer.getDescriptor().getFields().size() == 2);

      // Second append with updated schema.
      JSONObject updatedFoo = new JSONObject();
      updatedFoo.put("foo", "allen");
      updatedFoo.put("bar", "allen2");
      JSONArray updatedJsonArr = new JSONArray();
      updatedJsonArr.put(updatedFoo);

      ApiFuture<AppendRowsResponse> appendFuture4 =
          writer.append(updatedJsonArr, -1, /* allowUnknownFields */ false);

      assertEquals(3L, appendFuture4.get().getOffset());
      assertEquals(
          1,
          testBigQueryWrite
              .getAppendRequests()
              .get(2)
              .getProtoRows()
              .getRows()
              .getSerializedRowsCount());
      assertEquals(
          testBigQueryWrite
              .getAppendRequests()
              .get(2)
              .getProtoRows()
              .getRows()
              .getSerializedRows(0),
          UpdatedFooType.newBuilder().setFoo("allen").setBar("allen2").build().toByteString());

      assertTrue(testBigQueryWrite.getAppendRequests().get(0).getProtoRows().hasWriterSchema());
      assertTrue(
          testBigQueryWrite.getAppendRequests().get(1).getProtoRows().hasWriterSchema()
              || testBigQueryWrite.getAppendRequests().get(2).getProtoRows().hasWriterSchema());
    }
  }

  @Test
  public void testMultiThreadAppendNoSchemaUpdate() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .build())
            .build()) {

      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      final JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);

      final Collection<Long> offsetSets = Collections.synchronizedCollection(new HashSet<Long>());
      int thread_nums = 5;
      Thread[] thread_arr = new Thread[thread_nums];
      for (int i = 0; i < thread_nums; i++) {
        testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset((long) i).build());
        offsetSets.add((long) i);
        Thread t =
            new Thread(
                new Runnable() {
                  public void run() {
                    try {
                      ApiFuture<AppendRowsResponse> appendFuture =
                          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
                      AppendRowsResponse response = appendFuture.get();
                      offsetSets.remove(response.getOffset());
                    } catch (Exception e) {
                      LOG.severe("Thread execution failed: " + e.getMessage());
                    }
                  }
                });
        thread_arr[i] = t;
        t.start();
      }

      for (int i = 0; i < thread_nums; i++) {
        thread_arr[i].join();
      }
      assertTrue(offsetSets.size() == 0);
      for (int i = 0; i < thread_nums; i++) {
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
            FooType.newBuilder().setFoo("allen").build().toByteString());
      }
    }
  }

  @Test
  public void testMultiThreadAppendWithSchemaUpdate() throws Exception {
    try (JsonStreamWriter writer =
        getTestJsonStreamWriterBuilder(TEST_STREAM, TABLE_SCHEMA)
            .setBatchingSettings(
                StreamWriter.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .build())
            .build()) {
      JSONObject foo = new JSONObject();
      foo.put("foo", "allen");
      final JSONArray jsonArr = new JSONArray();
      jsonArr.put(foo);

      final Collection<Long> offsetSets = Collections.synchronizedCollection(new HashSet<Long>());
      int numberThreads = 5;
      Thread[] thread_arr = new Thread[numberThreads];
      for (int i = 0; i < numberThreads; i++) {
        if (i == 2) {
          testBigQueryWrite.addResponse(
              AppendRowsResponse.newBuilder()
                  .setOffset((long) i)
                  .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
                  .build());
        } else {
          testBigQueryWrite.addResponse(
              AppendRowsResponse.newBuilder().setOffset((long) i).build());
        }

        offsetSets.add((long) i);
        Thread t =
            new Thread(
                new Runnable() {
                  public void run() {
                    try {
                      ApiFuture<AppendRowsResponse> appendFuture =
                          writer.append(jsonArr, -1, /* allowUnknownFields */ false);
                      AppendRowsResponse response = appendFuture.get();
                      offsetSets.remove(response.getOffset());
                    } catch (Exception e) {
                      LOG.severe("Thread execution failed: " + e.getMessage());
                    }
                  }
                });
        thread_arr[i] = t;
        t.start();
      }

      for (int i = 0; i < numberThreads; i++) {
        thread_arr[i].join();
      }
      assertTrue(offsetSets.size() == 0);
      for (int i = 0; i < numberThreads; i++) {
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
            FooType.newBuilder().setFoo("allen").build().toByteString());
      }

      int millis = 0;
      while (millis <= 10000) {
        if (writer.getDescriptor().getFields().size() == 2) {
          break;
        }
        Thread.sleep(100);
        millis += 100;
      }
      assertEquals(2, writer.getDescriptor().getFields().size());

      foo.put("bar", "allen2");
      final JSONArray jsonArr2 = new JSONArray();
      jsonArr2.put(foo);

      for (int i = numberThreads; i < numberThreads + 5; i++) {
        testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setOffset((long) i).build());
        offsetSets.add((long) i);
        Thread t =
            new Thread(
                new Runnable() {
                  public void run() {
                    try {
                      ApiFuture<AppendRowsResponse> appendFuture =
                          writer.append(jsonArr2, -1, /* allowUnknownFields */ false);
                      AppendRowsResponse response = appendFuture.get();
                      offsetSets.remove(response.getOffset());
                    } catch (Exception e) {
                      LOG.severe("Thread execution failed: " + e.getMessage());
                    }
                  }
                });
        thread_arr[i - 5] = t;
        t.start();
      }

      for (int i = 0; i < numberThreads; i++) {
        thread_arr[i].join();
      }
      assertTrue(offsetSets.size() == 0);
      for (int i = 0; i < numberThreads; i++) {
        assertEquals(
            1,
            testBigQueryWrite
                .getAppendRequests()
                .get(i + 5)
                .getProtoRows()
                .getRows()
                .getSerializedRowsCount());
        assertEquals(
            testBigQueryWrite
                .getAppendRequests()
                .get(i + 5)
                .getProtoRows()
                .getRows()
                .getSerializedRows(0),
            UpdatedFooType.newBuilder().setFoo("allen").setBar("allen2").build().toByteString());
      }
    }
  }
}
