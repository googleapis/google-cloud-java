/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigquery.storage.v1alpha2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.storage.test.Test.AllSupportedTypes;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsRequest;
import com.google.common.collect.Sets;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class DirectWriterTest {
  private static final Logger LOG = Logger.getLogger(DirectWriterTest.class.getName());

  private static final String TEST_TABLE = "projects/p/datasets/d/tables/t";
  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";
  private static final String TEST_STREAM_2 = "projects/p/datasets/d/tables/t/streams/s2";

  private static MockBigQueryWrite mockBigQueryWrite;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteClient client;
  private LocalChannelProvider channelProvider;

  private final Table.TableFieldSchema FOO =
      Table.TableFieldSchema.newBuilder()
          .setType(Table.TableFieldSchema.Type.STRING)
          .setMode(Table.TableFieldSchema.Mode.NULLABLE)
          .setName("foo")
          .build();
  private final Table.TableSchema TABLE_SCHEMA =
      Table.TableSchema.newBuilder().addFields(0, FOO).build();

  @Mock private static SchemaCompatibility schemaCheck;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryWrite = new MockBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryWrite));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    BigQueryWriteSettings settings =
        BigQueryWriteSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigQueryWriteClient.create(settings);
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  /** Response mocks for create a new writer */
  void WriterCreationResponseMock(String testStreamName, Set<Long> responseOffsets) {
    // Response from CreateWriteStream
    Stream.WriteStream expectedResponse =
        Stream.WriteStream.newBuilder().setName(testStreamName).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    // Response from GetWriteStream
    Instant time = Instant.now();
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    Stream.WriteStream expectedResponse2 =
        Stream.WriteStream.newBuilder()
            .setName(testStreamName)
            .setType(Stream.WriteStream.Type.COMMITTED)
            .setCreateTime(timestamp)
            .build();
    mockBigQueryWrite.addResponse(expectedResponse2);

    for (Long offset : responseOffsets) {
      Storage.AppendRowsResponse response =
          Storage.AppendRowsResponse.newBuilder().setOffset(offset).build();
      mockBigQueryWrite.addResponse(response);
    }
  }

  /** Response mocks for create a new writer */
  void JsonWriterCreationResponseMock(String testStreamName, Set<Long> responseOffsets) {
    // Response from CreateWriteStream
    Stream.WriteStream expectedResponse =
        Stream.WriteStream.newBuilder()
            .setName(testStreamName)
            .setTableSchema(TABLE_SCHEMA)
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    // Response from GetWriteStream
    Instant time = Instant.now();
    Timestamp timestamp =
        Timestamp.newBuilder().setSeconds(time.getEpochSecond()).setNanos(time.getNano()).build();
    Stream.WriteStream expectedResponse2 =
        Stream.WriteStream.newBuilder()
            .setName(testStreamName)
            .setType(Stream.WriteStream.Type.COMMITTED)
            .setCreateTime(timestamp)
            .build();
    mockBigQueryWrite.addResponse(expectedResponse2);

    for (Long offset : responseOffsets) {
      Storage.AppendRowsResponse response =
          Storage.AppendRowsResponse.newBuilder().setOffset(offset).build();
      mockBigQueryWrite.addResponse(response);
    }
  }

  @Test
  public void testJsonWriteSuccess() throws Exception {
    DirectWriter.testSetStub(client, 10, schemaCheck);
    FooType m1 = FooType.newBuilder().setFoo("m1").build();
    FooType m2 = FooType.newBuilder().setFoo("m2").build();
    JSONObject m1_json = new JSONObject();
    m1_json.put("foo", "m1");
    JSONObject m2_json = new JSONObject();
    m2_json.put("foo", "m2");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(m1_json);
    jsonArr.put(m2_json);

    JSONArray jsonArr2 = new JSONArray();
    jsonArr2.put(m1_json);

    JsonWriterCreationResponseMock(TEST_STREAM, Sets.newHashSet(Long.valueOf(0L)));
    ApiFuture<Long> ret = DirectWriter.append(TEST_TABLE, jsonArr);
    assertEquals(Long.valueOf(0L), ret.get());
    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(3, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getParent());
    assertEquals(
        Stream.WriteStream.Type.COMMITTED,
        ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getWriteStream().getType());
    assertEquals(TEST_STREAM, ((Storage.GetWriteStreamRequest) actualRequests.get(1)).getName());
    assertEquals(
        m1.toByteString(),
        ((AppendRowsRequest) actualRequests.get(2)).getProtoRows().getRows().getSerializedRows(0));
    assertEquals(
        m2.toByteString(),
        ((AppendRowsRequest) actualRequests.get(2)).getProtoRows().getRows().getSerializedRows(1));

    Storage.AppendRowsResponse response =
        Storage.AppendRowsResponse.newBuilder().setOffset(2).build();
    mockBigQueryWrite.addResponse(response);

    ret = DirectWriter.append(TEST_TABLE, jsonArr2);
    assertEquals(Long.valueOf(2L), ret.get());
    assertEquals(
        m1.toByteString(),
        ((AppendRowsRequest) actualRequests.get(3)).getProtoRows().getRows().getSerializedRows(0));
    DirectWriter.clearCache();
  }

  @Test
  public void testProtobufWriteSuccess() throws Exception {
    DirectWriter.testSetStub(client, 10, schemaCheck);
    FooType m1 = FooType.newBuilder().setFoo("m1").build();
    FooType m2 = FooType.newBuilder().setFoo("m2").build();

    WriterCreationResponseMock(TEST_STREAM, Sets.newHashSet(Long.valueOf(0L)));
    ApiFuture<Long> ret = DirectWriter.<FooType>append(TEST_TABLE, Arrays.asList(m1, m2));
    verify(schemaCheck).check(TEST_TABLE, FooType.getDescriptor());
    assertEquals(Long.valueOf(0L), ret.get());
    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(3, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getParent());
    assertEquals(
        Stream.WriteStream.Type.COMMITTED,
        ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getWriteStream().getType());
    assertEquals(TEST_STREAM, ((Storage.GetWriteStreamRequest) actualRequests.get(1)).getName());

    Storage.AppendRowsRequest.ProtoData.Builder dataBuilder =
        Storage.AppendRowsRequest.ProtoData.newBuilder();
    dataBuilder.setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()));
    dataBuilder.setRows(
        ProtoBufProto.ProtoRows.newBuilder()
            .addSerializedRows(m1.toByteString())
            .addSerializedRows(m2.toByteString())
            .build());
    Storage.AppendRowsRequest expectRequest =
        Storage.AppendRowsRequest.newBuilder()
            .setWriteStream(TEST_STREAM)
            .setProtoRows(dataBuilder.build())
            .build();
    assertEquals(expectRequest.toString(), actualRequests.get(2).toString());

    Storage.AppendRowsResponse response =
        Storage.AppendRowsResponse.newBuilder().setOffset(2).build();
    mockBigQueryWrite.addResponse(response);
    // Append again, write stream name and schema are cleared.
    ret = DirectWriter.<FooType>append(TEST_TABLE, Arrays.asList(m1));
    assertEquals(Long.valueOf(2L), ret.get());
    dataBuilder = Storage.AppendRowsRequest.ProtoData.newBuilder();
    dataBuilder.setRows(
        ProtoBufProto.ProtoRows.newBuilder().addSerializedRows(m1.toByteString()).build());
    expectRequest =
        Storage.AppendRowsRequest.newBuilder().setProtoRows(dataBuilder.build()).build();
    assertEquals(expectRequest.toString(), actualRequests.get(3).toString());

    // Write with a different schema.
    WriterCreationResponseMock(TEST_STREAM_2, Sets.newHashSet(Long.valueOf(0L)));
    AllSupportedTypes m3 = AllSupportedTypes.newBuilder().setStringValue("s").build();
    ret = DirectWriter.<AllSupportedTypes>append(TEST_TABLE, Arrays.asList(m3));
    verify(schemaCheck).check(TEST_TABLE, AllSupportedTypes.getDescriptor());
    assertEquals(Long.valueOf(0L), ret.get());
    dataBuilder = Storage.AppendRowsRequest.ProtoData.newBuilder();
    dataBuilder.setWriterSchema(ProtoSchemaConverter.convert(AllSupportedTypes.getDescriptor()));
    dataBuilder.setRows(
        ProtoBufProto.ProtoRows.newBuilder().addSerializedRows(m3.toByteString()).build());
    expectRequest =
        Storage.AppendRowsRequest.newBuilder()
            .setWriteStream(TEST_STREAM_2)
            .setProtoRows(dataBuilder.build())
            .build();
    Assert.assertEquals(7, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(4)).getParent());
    assertEquals(
        Stream.WriteStream.Type.COMMITTED,
        ((Storage.CreateWriteStreamRequest) actualRequests.get(4)).getWriteStream().getType());
    assertEquals(TEST_STREAM_2, ((Storage.GetWriteStreamRequest) actualRequests.get(5)).getName());
    assertEquals(expectRequest.toString(), actualRequests.get(6).toString());

    DirectWriter.clearCache();
  }

  @Test
  public void testWriteBadTableName() throws Exception {
    DirectWriter.testSetStub(client, 10, schemaCheck);
    FooType m1 = FooType.newBuilder().setFoo("m1").build();
    FooType m2 = FooType.newBuilder().setFoo("m2").build();

    try {
      ApiFuture<Long> ret = DirectWriter.<FooType>append("abc", Arrays.asList(m1, m2));
      fail("should fail");
    } catch (IllegalArgumentException expected) {
      assertEquals("Invalid table name: abc", expected.getMessage());
    }

    DirectWriter.clearCache();
  }

  @Test
  public void testJsonWriteBadTableName() throws Exception {
    DirectWriter.testSetStub(client, 10, schemaCheck);
    JSONObject m1_json = new JSONObject();
    m1_json.put("foo", "m1");
    JSONObject m2_json = new JSONObject();
    m2_json.put("foo", "m2");
    final JSONArray jsonArr = new JSONArray();
    jsonArr.put(m1_json);
    jsonArr.put(m2_json);

    try {
      ApiFuture<Long> ret = DirectWriter.append("abc", jsonArr);
      fail("should fail");
    } catch (IllegalArgumentException expected) {
      assertEquals("Invalid table name: abc", expected.getMessage());
    }

    DirectWriter.clearCache();
  }

  @Test
  public void testConcurrentAccess() throws Exception {
    DirectWriter.testSetStub(client, 2, schemaCheck);
    final FooType m1 = FooType.newBuilder().setFoo("m1").build();
    final FooType m2 = FooType.newBuilder().setFoo("m2").build();
    final Set<Long> expectedOffset =
        Sets.newHashSet(
            Long.valueOf(0L),
            Long.valueOf(2L),
            Long.valueOf(4L),
            Long.valueOf(6L),
            Long.valueOf(8L));
    // Make sure getting the same table writer in multiple thread only cause create to be called
    // once.
    WriterCreationResponseMock(TEST_STREAM, expectedOffset);
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 5; i++) {
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              try {
                ApiFuture<Long> result =
                    DirectWriter.<FooType>append(TEST_TABLE, Arrays.asList(m1, m2));
                synchronized (expectedOffset) {
                  assertTrue(expectedOffset.remove(result.get()));
                }
              } catch (Exception e) {
                fail(e.toString());
              }
            }
          });
    }
    executor.shutdown();
    try {
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      LOG.info(e.toString());
    }
    DirectWriter.clearCache();
  }

  @Test
  public void testJsonConcurrentAccess() throws Exception {
    DirectWriter.testSetStub(client, 2, schemaCheck);
    FooType m1 = FooType.newBuilder().setFoo("m1").build();
    FooType m2 = FooType.newBuilder().setFoo("m2").build();
    JSONObject m1_json = new JSONObject();
    m1_json.put("foo", "m1");
    JSONObject m2_json = new JSONObject();
    m2_json.put("foo", "m2");
    final JSONArray jsonArr = new JSONArray();
    jsonArr.put(m1_json);
    jsonArr.put(m2_json);

    final Set<Long> expectedOffset =
        Sets.newHashSet(
            Long.valueOf(0L),
            Long.valueOf(2L),
            Long.valueOf(4L),
            Long.valueOf(6L),
            Long.valueOf(8L));
    // Make sure getting the same table writer in multiple thread only cause create to be called
    // once.
    JsonWriterCreationResponseMock(TEST_STREAM, expectedOffset);
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 5; i++) {
      executor.execute(
          new Runnable() {
            @Override
            public void run() {
              try {
                ApiFuture<Long> result = DirectWriter.append(TEST_TABLE, jsonArr);
                synchronized (expectedOffset) {
                  assertTrue(expectedOffset.remove(result.get()));
                }
              } catch (Exception e) {
                fail(e.toString());
              }
            }
          });
    }
    executor.shutdown();
    try {
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      LOG.info(e.toString());
    }
    DirectWriter.clearCache();
  }

  @Test
  public void testJsonProtobufWrite() throws Exception {
    DirectWriter.testSetStub(client, 10, schemaCheck);
    FooType m1 = FooType.newBuilder().setFoo("m1").build();
    FooType m2 = FooType.newBuilder().setFoo("m2").build();
    JSONObject m1_json = new JSONObject();
    m1_json.put("foo", "m1");
    JSONObject m2_json = new JSONObject();
    m2_json.put("foo", "m2");
    JSONArray jsonArr = new JSONArray();
    jsonArr.put(m1_json);
    jsonArr.put(m2_json);

    JSONArray jsonArr2 = new JSONArray();
    jsonArr2.put(m1_json);

    WriterCreationResponseMock(TEST_STREAM, Sets.newHashSet(Long.valueOf(0L)));

    ApiFuture<Long> ret = DirectWriter.<FooType>append(TEST_TABLE, Arrays.asList(m1, m2));
    verify(schemaCheck).check(TEST_TABLE, FooType.getDescriptor());
    assertEquals(Long.valueOf(0L), ret.get());
    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(3, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getParent());
    assertEquals(
        Stream.WriteStream.Type.COMMITTED,
        ((Storage.CreateWriteStreamRequest) actualRequests.get(0)).getWriteStream().getType());
    assertEquals(TEST_STREAM, ((Storage.GetWriteStreamRequest) actualRequests.get(1)).getName());

    Storage.AppendRowsRequest.ProtoData.Builder dataBuilder =
        Storage.AppendRowsRequest.ProtoData.newBuilder();
    dataBuilder.setWriterSchema(ProtoSchemaConverter.convert(FooType.getDescriptor()));
    dataBuilder.setRows(
        ProtoBufProto.ProtoRows.newBuilder()
            .addSerializedRows(m1.toByteString())
            .addSerializedRows(m2.toByteString())
            .build());
    Storage.AppendRowsRequest expectRequest =
        Storage.AppendRowsRequest.newBuilder()
            .setWriteStream(TEST_STREAM)
            .setProtoRows(dataBuilder.build())
            .build();
    assertEquals(expectRequest.toString(), actualRequests.get(2).toString());

    JsonWriterCreationResponseMock(TEST_STREAM, Sets.newHashSet(Long.valueOf(0L)));
    ret = DirectWriter.append(TEST_TABLE, jsonArr);
    assertEquals(Long.valueOf(0L), ret.get());
    actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(6, actualRequests.size());
    assertEquals(
        TEST_TABLE, ((Storage.CreateWriteStreamRequest) actualRequests.get(3)).getParent());
    assertEquals(
        Stream.WriteStream.Type.COMMITTED,
        ((Storage.CreateWriteStreamRequest) actualRequests.get(3)).getWriteStream().getType());
    assertEquals(TEST_STREAM, ((Storage.GetWriteStreamRequest) actualRequests.get(4)).getName());
    assertEquals(
        m1.toByteString(),
        ((AppendRowsRequest) actualRequests.get(5)).getProtoRows().getRows().getSerializedRows(0));
    assertEquals(
        m2.toByteString(),
        ((AppendRowsRequest) actualRequests.get(5)).getProtoRows().getRows().getSerializedRows(1));

    DirectWriter.clearCache();
  }
}
