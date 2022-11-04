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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnknownException;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.v1.ConnectionWorkerPool.Settings;
import com.google.cloud.bigquery.storage.v1.StorageError.StorageErrorCode;
import com.google.cloud.bigquery.storage.v1.StreamWriter.SingleConnectionOrConnectionPool.Kind;
import com.google.common.base.Strings;
import com.google.protobuf.Any;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class StreamWriterTest {
  private static final Logger log = Logger.getLogger(StreamWriterTest.class.getName());
  private static final String TEST_STREAM_1 = "projects/p/datasets/d1/tables/t1/streams/s1";
  private static final String TEST_STREAM_2 = "projects/p/datasets/d2/tables/t2/streams/s2";
  private static final String TEST_TRACE_ID = "DATAFLOW:job_id";
  private FakeScheduledExecutorService fakeExecutor;
  private FakeBigQueryWrite testBigQueryWrite;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteClient client;

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(testBigQueryWrite));
    serviceHelper.start();
    fakeExecutor = new FakeScheduledExecutorService();
    testBigQueryWrite.setExecutor(fakeExecutor);
    client =
        BigQueryWriteClient.create(
            BigQueryWriteSettings.newBuilder()
                .setCredentialsProvider(NoCredentialsProvider.create())
                .setTransportChannelProvider(serviceHelper.createChannelProvider())
                .build());
    StreamWriter.cleanUp();
  }

  @After
  public void tearDown() throws Exception {
    log.info("tearDown called");
    client.close();
    serviceHelper.stop();
    StreamWriter.cleanUp();
  }

  private StreamWriter getMultiplexingTestStreamWriter() throws IOException {
    return StreamWriter.newBuilder(TEST_STREAM_1, client)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
        .setLocation("US")
        .setEnableConnectionPool(true)
        .build();
  }

  private StreamWriter getTestStreamWriter() throws IOException {
    return StreamWriter.newBuilder(TEST_STREAM_1, client)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
        .build();
  }

  private ProtoSchema createProtoSchema() {
    return createProtoSchema("foo");
  }

  private ProtoSchema createProtoSchema(String fieldName) {
    return ProtoSchema.newBuilder()
        .setProtoDescriptor(
            DescriptorProtos.DescriptorProto.newBuilder()
                .setName("Message")
                .addField(
                    DescriptorProtos.FieldDescriptorProto.newBuilder()
                        .setName(fieldName)
                        .setType(DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING)
                        .setNumber(1)
                        .build())
                .build())
        .build();
  }

  private ProtoRows createProtoRows(String[] messages) {
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    for (String message : messages) {
      FooType foo = FooType.newBuilder().setFoo(message).build();
      rowsBuilder.addSerializedRows(foo.toByteString());
    }
    return rowsBuilder.build();
  }

  private AppendRowsResponse createAppendResponse(long offset) {
    return AppendRowsResponse.newBuilder()
        .setAppendResult(
            AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(offset)).build())
        .build();
  }

  private AppendRowsResponse createAppendResponseWithError(Status.Code code, String message) {
    return AppendRowsResponse.newBuilder()
        .setError(com.google.rpc.Status.newBuilder().setCode(code.value()).setMessage(message))
        .build();
  }

  private ApiFuture<AppendRowsResponse> sendTestMessage(StreamWriter writer, String[] messages) {
    return writer.append(createProtoRows(messages));
  }

  private ApiFuture<AppendRowsResponse> sendTestMessage(
      StreamWriter writer, String[] messages, long offset) {
    return writer.append(createProtoRows(messages), offset);
  }

  private static <T extends Throwable> T assertFutureException(
      Class<T> expectedThrowable, final Future<?> future) {
    return assertThrows(
        expectedThrowable,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            try {
              future.get();
            } catch (ExecutionException ex) {
              // Future wraps exception with ExecutionException. So unwrapper it here.
              throw ex.getCause();
            }
          }
        });
  }

  private void verifyAppendIsBlocked(final StreamWriter writer) throws Exception {
    Thread appendThread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                sendTestMessage(writer, new String[] {"A"});
              }
            });
    // Start a separate thread to append and verify that it is still alive after 2 seoncds.
    appendThread.start();
    TimeUnit.SECONDS.sleep(2);
    assertTrue(appendThread.isAlive());
    appendThread.interrupt();
  }

  private void verifyAppendRequests(long appendCount) {
    assertEquals(appendCount, testBigQueryWrite.getAppendRequests().size());
    for (int i = 0; i < appendCount; i++) {
      AppendRowsRequest serverRequest = testBigQueryWrite.getAppendRequests().get(i);
      assertTrue(serverRequest.getProtoRows().getRows().getSerializedRowsCount() > 0);
      assertEquals(i, serverRequest.getOffset().getValue());
      if (i == 0) {
        // First request received by server should have schema and stream name.
        assertTrue(serverRequest.getProtoRows().hasWriterSchema());
        assertEquals(serverRequest.getWriteStream(), TEST_STREAM_1);
        assertEquals(serverRequest.getTraceId(), TEST_TRACE_ID);
      } else {
        // Following request should not have schema and stream name.
        assertFalse(serverRequest.getProtoRows().hasWriterSchema());
        assertEquals(serverRequest.getWriteStream(), "");
        assertEquals(serverRequest.getTraceId(), "");
      }
    }
  }

  public void testBuildBigQueryWriteClientInWriter() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setChannelProvider(serviceHelper.createChannelProvider())
            .setWriterSchema(createProtoSchema())
            .build();

    testBigQueryWrite.addResponse(createAppendResponse(0));
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    writer.close();
  }

  @Test
  public void testAppendSuccess() throws Exception {
    StreamWriter writer = getTestStreamWriter();

    long appendCount = 100;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }

    verifyAppendRequests(appendCount);

    writer.close();
  }

  @Test
  public void testNoSchema() throws Exception {
    StatusRuntimeException ex =
        assertThrows(
            StatusRuntimeException.class,
            new ThrowingRunnable() {
              @Override
              public void run() throws Throwable {
                StreamWriter.newBuilder(TEST_STREAM_1, client).build();
              }
            });
    assertEquals(ex.getStatus().getCode(), Status.INVALID_ARGUMENT.getCode());
    assertTrue(ex.getStatus().getDescription().contains("Writer schema must be provided"));
  }

  @Test
  public void testInvalidTraceId() throws Exception {
    assertThrows(
        IllegalArgumentException.class,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            StreamWriter.newBuilder(TEST_STREAM_1).setTraceId("abc");
          }
        });
    assertThrows(
        IllegalArgumentException.class,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            StreamWriter.newBuilder(TEST_STREAM_1).setTraceId("abc:");
          }
        });
    assertThrows(
        IllegalArgumentException.class,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            StreamWriter.newBuilder(TEST_STREAM_1).setTraceId(":abc");
          }
        });
  }

  @Test
  public void testAppendSuccessAndConnectionError() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addException(Status.INTERNAL.asException());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    ApiException actualError = assertFutureException(ApiException.class, appendFuture2);
    assertEquals(Code.INTERNAL, actualError.getStatusCode().getCode());

    writer.close();
  }

  @Test
  public void testAppendSuccessAndInStreamError() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(
        createAppendResponseWithError(Status.INVALID_ARGUMENT.getCode(), "test message"));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"C"});

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    StatusRuntimeException actualError =
        assertFutureException(StatusRuntimeException.class, appendFuture2);
    assertEquals(Status.Code.INVALID_ARGUMENT, actualError.getStatus().getCode());
    assertEquals("test message", actualError.getStatus().getDescription());
    assertEquals(1, appendFuture3.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendFailedSchemaError() throws Exception {
    StreamWriter writer = getTestStreamWriter();

    StorageError storageError =
        StorageError.newBuilder()
            .setCode(StorageErrorCode.SCHEMA_MISMATCH_EXTRA_FIELDS)
            .setEntity("foobar")
            .build();
    com.google.rpc.Status statusProto =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.INVALID_ARGUMENT.getHttpStatusCode())
            .addDetails(Any.pack(storageError))
            .build();

    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(AppendRowsResponse.newBuilder().setError(statusProto).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer, new String[] {"C"});

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    Exceptions.SchemaMismatchedException actualError =
        assertFutureException(Exceptions.SchemaMismatchedException.class, appendFuture2);
    assertEquals("foobar", actualError.getStreamName());
    assertEquals(1, appendFuture3.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendFailRandomException() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    // Trigger a non-StatusRuntimeException for append operation (although grpc API should not
    // return anything other than StatusRuntimeException)
    IllegalArgumentException illegalArgumentException =
        new IllegalArgumentException("Illegal argument");
    testBigQueryWrite.addException(illegalArgumentException);
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    UnknownException actualError = assertFutureException(UnknownException.class, appendFuture1);
    assertEquals(Code.UNKNOWN, actualError.getStatusCode().getCode());

    writer.close();
  }

  @Test
  public void longIdleBetweenAppends() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());

    // Sleep to create a long idle between appends.
    TimeUnit.SECONDS.sleep(3);

    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendAfterUserClose() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    testBigQueryWrite.addResponse(createAppendResponse(0));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    writer.close();
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertTrue(appendFuture2.isDone());
    StatusRuntimeException actualError =
        assertFutureException(StatusRuntimeException.class, appendFuture2);
    assertEquals(Status.Code.FAILED_PRECONDITION, actualError.getStatus().getCode());
  }

  @Test
  public void testAppendAfterServerClose() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    testBigQueryWrite.addException(Status.INTERNAL.asException());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiException error1 = assertFutureException(ApiException.class, appendFuture1);
    assertEquals(Code.INTERNAL, error1.getStatusCode().getCode());

    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"});
    assertTrue(appendFuture2.isDone());
    StatusRuntimeException error2 =
        assertFutureException(StatusRuntimeException.class, appendFuture2);
    assertEquals(Status.Code.FAILED_PRECONDITION, error2.getStatus().getCode());

    writer.close();
  }

  @Test
  public void userCloseWhileRequestInflight() throws Exception {
    final StreamWriter writer = getTestStreamWriter();
    // Server will sleep 2 seconds before sending back the response.
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(2));
    testBigQueryWrite.addResponse(createAppendResponse(0));

    // Send a request and close the stream in separate thread while the request is inflight.
    final ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    Thread closeThread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                writer.close();
              }
            });
    closeThread.start();

    // Due to the sleep on server, the append won't finish within 1 second even though stream
    // is being closed.
    assertThrows(
        TimeoutException.class,
        new ThrowingRunnable() {
          @Override
          public void run() throws Throwable {
            appendFuture1.get(1, TimeUnit.SECONDS);
          }
        });

    // Within 2 seconds, the request should be done and stream should be closed.
    closeThread.join(2000);
    assertTrue(appendFuture1.isDone());
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
  }

  @Test
  public void serverCloseWhileRequestsInflight() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    // Server will sleep 2 seconds before closing the connection.
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(2));
    testBigQueryWrite.addException(Status.INTERNAL.asException());

    // Send 10 requests, so that there are 10 inflight requests.
    int appendCount = 10;
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}));
    }

    // Server close should properly handle all inflight requests.
    for (int i = 0; i < appendCount; i++) {
      ApiException actualError = assertFutureException(ApiException.class, futures.get(i));
      assertEquals(Code.INTERNAL, actualError.getStatusCode().getCode());
    }

    writer.close();
  }

  @Test
  public void testZeroMaxInflightRequests() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setMaxInflightRequests(0)
            .build();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    verifyAppendIsBlocked(writer);
    writer.close();
  }

  @Test
  public void testZeroMaxInflightBytes() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setMaxInflightBytes(0)
            .build();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    verifyAppendIsBlocked(writer);
    writer.close();
  }

  @Test
  public void testOneMaxInflightRequests() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setMaxInflightRequests(1)
            .build();
    // Server will sleep 1 second before every response.
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(1));
    testBigQueryWrite.addResponse(createAppendResponse(0));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    assertTrue(writer.getInflightWaitSeconds() >= 1);
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    writer.close();
  }

  @Test
  public void testOneMaxInflightRequests_MultiplexingCase() throws Exception {
    ConnectionWorkerPool.setOptions(Settings.builder().setMaxConnectionsPerRegion(2).build());
    StreamWriter writer1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setLocation("US")
            .setEnableConnectionPool(true)
            .setMaxInflightRequests(1)
            .build();
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_2, client)
            .setWriterSchema(createProtoSchema())
            .setMaxInflightRequests(1)
            .setEnableConnectionPool(true)
            .setMaxInflightRequests(1)
            .setLocation("US")
            .build();

    // Server will sleep 1 second before every response.
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(1));
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer1, new String[] {"A"});
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer2, new String[] {"A"});

    assertTrue(writer1.getInflightWaitSeconds() >= 1);
    assertTrue(writer2.getInflightWaitSeconds() >= 1);
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());
    writer1.close();
    writer2.close();
  }

  @Test
  public void testProtoSchemaPiping_nonMultiplexingCase() throws Exception {
    ProtoSchema protoSchema = createProtoSchema();
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(protoSchema)
            .setMaxInflightBytes(1)
            .build();
    long appendCount = 5;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }
    assertEquals(appendCount, testBigQueryWrite.getAppendRequests().size());
    for (int i = 0; i < appendCount; i++) {
      AppendRowsRequest appendRowsRequest = testBigQueryWrite.getAppendRequests().get(i);
      assertEquals(i, appendRowsRequest.getOffset().getValue());
      if (i == 0) {
        appendRowsRequest.getProtoRows().getWriterSchema().equals(protoSchema);
        assertEquals(appendRowsRequest.getWriteStream(), TEST_STREAM_1);
      } else {
        appendRowsRequest.getProtoRows().getWriterSchema().equals(ProtoSchema.getDefaultInstance());
      }
    }
    writer.close();
  }

  @Test
  public void testProtoSchemaPiping_multiplexingCase() throws Exception {
    // Use the shared connection mode.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());
    ProtoSchema schema1 = createProtoSchema("Schema1");
    ProtoSchema schema2 = createProtoSchema("Schema2");
    StreamWriter writer1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(schema1)
            .setLocation("US")
            .setEnableConnectionPool(true)
            .setMaxInflightRequests(1)
            .build();
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_2, client)
            .setWriterSchema(schema2)
            .setMaxInflightRequests(1)
            .setEnableConnectionPool(true)
            .setLocation("US")
            .build();

    long appendCountPerStream = 5;
    for (int i = 0; i < appendCountPerStream * 4; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    // In total insert append `appendCountPerStream` * 4 requests.
    // We insert using the pattern of streamWriter1, streamWriter1, streamWriter2, streamWriter2
    for (int i = 0; i < appendCountPerStream; i++) {
      futures.add(writer1.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4));
      futures.add(writer1.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4 + 1));
      futures.add(writer2.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4 + 2));
      futures.add(writer2.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4 + 3));
    }

    for (int i = 0; i < appendCountPerStream * 4; i++) {
      AppendRowsRequest appendRowsRequest = testBigQueryWrite.getAppendRequests().get(i);
      assertEquals(i, appendRowsRequest.getOffset().getValue());
      if (i % 4 == 0) {
        assertEquals(appendRowsRequest.getProtoRows().getWriterSchema(), schema1);
        assertEquals(appendRowsRequest.getWriteStream(), TEST_STREAM_1);
      } else if (i % 4 == 1) {
        assertEquals(
            appendRowsRequest.getProtoRows().getWriterSchema(), ProtoSchema.getDefaultInstance());
        // Before entering multiplexing (i == 1) case, the write stream won't be populated.
        if (i == 1) {
          assertEquals(appendRowsRequest.getWriteStream(), "");
        } else {
          assertEquals(appendRowsRequest.getWriteStream(), TEST_STREAM_1);
        }
      } else if (i % 4 == 2) {
        assertEquals(appendRowsRequest.getProtoRows().getWriterSchema(), schema2);
        assertEquals(appendRowsRequest.getWriteStream(), TEST_STREAM_2);
      } else {
        assertEquals(
            appendRowsRequest.getProtoRows().getWriterSchema(), ProtoSchema.getDefaultInstance());
        assertEquals(appendRowsRequest.getWriteStream(), TEST_STREAM_2);
      }
    }

    writer1.close();
    writer2.close();
  }

  @Test
  public void testAppendsWithTinyMaxInflightBytes() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setMaxInflightBytes(1)
            .build();
    // Server will sleep 100ms before every response.
    testBigQueryWrite.setResponseSleep(Duration.ofMillis(100));
    long appendCount = 10;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    long appendStartTimeMs = System.currentTimeMillis();
    for (int i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }
    long appendElapsedMs = System.currentTimeMillis() - appendStartTimeMs;
    assertTrue(appendElapsedMs >= 1000);

    for (int i = 0; i < appendCount; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }
    assertEquals(appendCount, testBigQueryWrite.getAppendRequests().size());
    for (int i = 0; i < appendCount; i++) {
      assertEquals(i, testBigQueryWrite.getAppendRequests().get(i).getOffset().getValue());
    }
    writer.close();
  }

  @Test
  public void testAppendsWithTinyMaxInflightBytesThrow() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setMaxInflightBytes(1)
            .setLimitExceededBehavior(FlowController.LimitExceededBehavior.ThrowException)
            .build();
    Exceptions.InflightBytesLimitExceededException ex =
        assertThrows(
            Exceptions.InflightBytesLimitExceededException.class,
            new ThrowingRunnable() {
              @Override
              public void run() throws Throwable {
                writer.append(createProtoRows(new String[] {String.valueOf(10)}), -1);
              }
            });
    assertEquals(ex.getStatus().getCode(), Status.RESOURCE_EXHAUSTED.getCode());
    assertTrue(
        ex.getStatus()
            .getDescription()
            .contains(
                "Exceeds client side inflight buffer, consider add more buffer or open more connections"));

    assertEquals(ex.getWriterId(), writer.getWriterId());
    assertEquals(1, ex.getCurrentLimit());
    writer.close();
  }

  @Test
  public void testLimitBehaviorIgnoreNotAccepted() throws Exception {
    StatusRuntimeException ex =
        assertThrows(
            StatusRuntimeException.class,
            new ThrowingRunnable() {
              @Override
              public void run() throws Throwable {
                StreamWriter writer =
                    StreamWriter.newBuilder(TEST_STREAM_1, client)
                        .setWriterSchema(createProtoSchema())
                        .setMaxInflightBytes(1)
                        .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Ignore)
                        .build();
              }
            });
    assertEquals(ex.getStatus().getCode(), Status.INVALID_ARGUMENT.getCode());
    assertTrue(
        ex.getStatus()
            .getDescription()
            .contains("LimitExceededBehavior.Ignore is not supported on StreamWriter."));
  }

  @Test
  public void testMessageTooLarge() throws Exception {
    StreamWriter writer = getTestStreamWriter();

    String oversized = Strings.repeat("a", (int) (StreamWriter.getApiMaxRequestBytes() + 1));
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {oversized});
    assertTrue(appendFuture1.isDone());
    StatusRuntimeException actualError =
        assertFutureException(StatusRuntimeException.class, appendFuture1);
    assertEquals(Status.Code.INVALID_ARGUMENT, actualError.getStatus().getCode());
    assertTrue(actualError.getStatus().getDescription().contains("MessageSize is too large"));

    writer.close();
  }

  @Test
  public void testAppendWithResetSuccess() throws Exception {
    try (StreamWriter writer = getTestStreamWriter()) {
      testBigQueryWrite.setCloseEveryNAppends(113);
      long appendCount = 10000;
      for (long i = 0; i < appendCount; i++) {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
      List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
      for (long i = 0; i < appendCount; i++) {
        futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}, i));
      }
      for (int i = 0; i < appendCount; i++) {
        assertEquals(futures.get(i).get().getAppendResult().getOffset().getValue(), (long) i);
      }
      assertTrue(testBigQueryWrite.getConnectionCount() >= (int) (appendCount / 113.0));
    }
  }

  // This test is setup for the server to force a retry after all records are sent. Ensure the
  // records are resent, even if no new records are appeneded.
  @Test
  public void testRetryAfterAllRecordsInflight() throws Exception {
    try (StreamWriter writer = getTestStreamWriter()) {
      testBigQueryWrite.setCloseEveryNAppends(2);
      testBigQueryWrite.setTimesToClose(1);
      testBigQueryWrite.addResponse(createAppendResponse(0));
      testBigQueryWrite.addResponse(createAppendResponse(1));

      ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"}, 0);
      ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"B"}, 1);
      TimeUnit.SECONDS.sleep(1);
      assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
      assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());
    }
  }

  @Test
  public void testWriterClosedStream() throws Exception {
    try (StreamWriter writer = getTestStreamWriter()) {
      // Writer is closed without any traffic.
      TimeUnit.SECONDS.sleep(1);
    }
  }

  @Test
  public void testWriterAlreadyClosedException() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    writer.close();
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"}, 0);
    Exceptions.StreamWriterClosedException actualError =
        assertFutureException(Exceptions.StreamWriterClosedException.class, appendFuture1);
    // The basic StatusRuntimeException API is not changed.
    assertTrue(actualError instanceof StatusRuntimeException);
    assertEquals(Status.Code.FAILED_PRECONDITION, actualError.getStatus().getCode());
    assertTrue(actualError.getStatus().getDescription().contains("Connection is already closed"));
    assertEquals(actualError.getWriterId(), writer.getWriterId());
    assertEquals(actualError.getStreamName(), writer.getStreamName());
  }

  @Test
  public void testWriterClosedException() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    testBigQueryWrite.addException(Status.INTERNAL.asException());
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"}, 0);
    try {
      appendFuture1.get();
    } catch (Exception e) {
    }
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"A"}, 0);
    Exceptions.StreamWriterClosedException actualError =
        assertFutureException(Exceptions.StreamWriterClosedException.class, appendFuture2);
    // The basic StatusRuntimeException API is not changed.
    assertTrue(actualError instanceof StatusRuntimeException);
    assertEquals(Status.Code.FAILED_PRECONDITION, actualError.getStatus().getCode());
    assertTrue(actualError.getStatus().getDescription().contains("Connection is closed"));
    assertEquals(actualError.getWriterId(), writer.getWriterId());
    assertEquals(actualError.getStreamName(), writer.getStreamName());
  }

  @Test
  public void testWriterId()
      throws Descriptors.DescriptorValidationException, IOException, InterruptedException {
    StreamWriter writer1 = getTestStreamWriter();
    Assert.assertFalse(writer1.getWriterId().isEmpty());
    StreamWriter writer2 = getTestStreamWriter();
    Assert.assertFalse(writer2.getWriterId().isEmpty());
    Assert.assertNotEquals(writer1.getWriterId(), writer2.getWriterId());
  }

  @Test
  public void testInitialization_operationKind() throws Exception {
    try (StreamWriter streamWriter = getMultiplexingTestStreamWriter()) {
      Assert.assertEquals(streamWriter.getConnectionOperationType(), Kind.CONNECTION_WORKER_POOL);
    }
    try (StreamWriter streamWriter = getTestStreamWriter()) {
      Assert.assertEquals(streamWriter.getConnectionOperationType(), Kind.CONNECTION_WORKER);
    }
  }

  @Test
  public void testExtractDatasetName() throws Exception {
    Assert.assertEquals(
        StreamWriter.extractDatasetAndProjectName(
            "projects/project1/datasets/dataset2/tables/something"),
        "projects/project1/datasets/dataset2/");

    IllegalStateException ex =
        assertThrows(
            IllegalStateException.class,
            () -> {
              StreamWriter.extractDatasetAndProjectName(
                  "wrong/projects/project1/wrong/datasets/dataset2/tables/something");
            });
    Assert.assertTrue(ex.getMessage().contains("The passed in stream name does not match"));
  }

  // Timeout to ensure close() doesn't wait for done callback timeout.
  @Test(timeout = 10000)
  public void testCloseDisconnectedStream() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setChannelProvider(serviceHelper.createChannelProvider())
            .setWriterSchema(createProtoSchema())
            .build();

    testBigQueryWrite.addResponse(createAppendResponse(0));
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    serviceHelper.stop();
    // Ensure closing the writer after disconnect succeeds.
    writer.close();
  }
}
