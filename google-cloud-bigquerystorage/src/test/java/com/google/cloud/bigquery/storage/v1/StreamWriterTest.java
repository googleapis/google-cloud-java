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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.client.util.Sleeper;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnknownException;
import com.google.auth.oauth2.UserCredentials;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.MissingValueInterpretation;
import com.google.cloud.bigquery.storage.v1.ConnectionWorkerPool.Settings;
import com.google.cloud.bigquery.storage.v1.Exceptions.StreamWriterClosedException;
import com.google.cloud.bigquery.storage.v1.StorageError.StorageErrorCode;
import com.google.cloud.bigquery.storage.v1.StreamWriter.SingleConnectionOrConnectionPool.Kind;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Any;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;
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
  private static final String TEST_STREAM_1 = "projects/p/datasets/d1/tables/t1/streams/_default";
  private static final String TEST_STREAM_2 = "projects/p/datasets/d2/tables/t2/streams/_default";
  private static final String TEST_STREAM_3 = "projects/p/datasets/d3/tables/t3/streams/_default";
  private static final String TEST_STREAM_SHORTEN = "projects/p/datasets/d2/tables/t2/_default";
  private static final String EXPLICIT_STREAM = "projects/p/datasets/d1/tables/t1/streams/s1";
  private static final String TEST_TRACE_ID = "DATAFLOW:job_id";
  private static final int MAX_RETRY_NUM_ATTEMPTS = 3;
  private static final long INITIAL_RETRY_MILLIS = 500;
  private static final double RETRY_MULTIPLIER = 1.3;
  private static final int MAX_RETRY_DELAY_MINUTES = 5;
  private static final RetrySettings retrySettings =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(INITIAL_RETRY_MILLIS))
          .setRetryDelayMultiplier(RETRY_MULTIPLIER)
          .setMaxAttempts(MAX_RETRY_NUM_ATTEMPTS)
          .setMaxRetryDelay(org.threeten.bp.Duration.ofMinutes(MAX_RETRY_DELAY_MINUTES))
          .build();
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
  private final TableSchema TABLE_SCHEMA = TableSchema.newBuilder().addFields(0, FOO).build();
  private final ProtoSchema PROTO_SCHEMA =
      ProtoSchemaConverter.convert(
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(TABLE_SCHEMA));

  private final TableSchema UPDATED_TABLE_SCHEMA =
      TableSchema.newBuilder().addFields(0, FOO).addFields(1, BAR).build();
  private final ProtoSchema UPDATED_PROTO_SCHEMA =
      ProtoSchemaConverter.convert(
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(
              UPDATED_TABLE_SCHEMA));

  public StreamWriterTest() throws DescriptorValidationException {}

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    StreamWriter.setMaxRequestCallbackWaitTime(java.time.Duration.ofSeconds(10000));
    ConnectionWorker.setMaxInflightQueueWaitTime(300000);
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
        .setMaxRetryDuration(java.time.Duration.ofSeconds(5))
        .build();
  }

  private StreamWriter getTestStreamWriter() throws IOException {
    return StreamWriter.newBuilder(TEST_STREAM_1, client)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
        .setMaxRetryDuration(java.time.Duration.ofSeconds(5))
        .build();
  }

  private StreamWriter getTestStreamWriterRetryEnabled() throws IOException {
    return StreamWriter.newBuilder(TEST_STREAM_1, client)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
        .setMaxRetryDuration(java.time.Duration.ofSeconds(5))
        .setRetrySettings(retrySettings)
        .build();
  }

  private StreamWriter getTestStreamWriterExclusiveRetryEnabled() throws IOException {
    return StreamWriter.newBuilder(EXPLICIT_STREAM, client)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
        .setMaxRetryDuration(java.time.Duration.ofSeconds(5))
        .setRetrySettings(retrySettings)
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
        assertEquals(TEST_STREAM_1, serverRequest.getWriteStream());
        assertEquals("java-streamwriter " + TEST_TRACE_ID, serverRequest.getTraceId());
      } else {
        // Following request should not have schema and stream name.
        assertFalse(serverRequest.getProtoRows().hasWriterSchema());
        assertEquals("", serverRequest.getWriteStream());
        assertEquals("", serverRequest.getTraceId());
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

  /* DummyResponseSupplierWillFailThenSucceed is used to mock repeated failures, such as retriable
   * in-stream errors.  This Supplier will fail up to totalFailCount with status failStatus.  Once
   * totalFailCount is reached, then the provided Response will be returned instead.
   */
  private static class DummyResponseSupplierWillFailThenSucceed
      implements Supplier<FakeBigQueryWriteImpl.Response> {

    private final int totalFailCount;
    private int failCount;
    private final com.google.rpc.Status failStatus;
    private final FakeBigQueryWriteImpl.Response response;

    DummyResponseSupplierWillFailThenSucceed(
        FakeBigQueryWriteImpl.Response response,
        int totalFailCount,
        com.google.rpc.Status failStatus) {
      this.totalFailCount = totalFailCount;
      this.response = response;
      this.failStatus = failStatus;
      this.failCount = 0;
    }

    @Override
    public FakeBigQueryWriteImpl.Response get() {
      if (failCount >= totalFailCount) {
        return response;
      }
      failCount++;
      return new FakeBigQueryWriteImpl.Response(
          AppendRowsResponse.newBuilder().setError(this.failStatus).build());
    }
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
  public void testAppendSuccess_RetryDirectlyInCallback() throws Exception {
    // Set a relatively small in flight request counts.
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setTraceId(TEST_TRACE_ID)
            .setMaxRetryDuration(java.time.Duration.ofSeconds(5))
            .setMaxInflightRequests(5)
            .build();

    // Fail the first request, in the request callback of the first request we will insert another
    // 10 requests. Those requests can't be processed until the previous request callback has
    // been finished.
    long appendCount = 20;
    for (int i = 0; i < appendCount; i++) {
      if (i == 0) {
        testBigQueryWrite.addResponse(
            createAppendResponseWithError(Status.INVALID_ARGUMENT.getCode(), "test message"));
      }
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    // We will trigger 10 more requests in the request callback of the following request.
    ProtoRows protoRows = createProtoRows(new String[] {String.valueOf(-1)});
    ApiFuture<AppendRowsResponse> future = writer.append(protoRows, -1);
    ApiFutures.addCallback(
        future, new AppendCompleteCallback(writer, protoRows), MoreExecutors.directExecutor());

    StatusRuntimeException actualError =
        assertFutureException(StatusRuntimeException.class, future);

    Sleeper.DEFAULT.sleep(1000);
    writer.close();
  }

  static class AppendCompleteCallback implements ApiFutureCallback<AppendRowsResponse> {

    private final StreamWriter mainStreamWriter;
    private final ProtoRows protoRows;
    private int retryCount = 0;

    public AppendCompleteCallback(StreamWriter mainStreamWriter, ProtoRows protoRows) {
      this.mainStreamWriter = mainStreamWriter;
      this.protoRows = protoRows;
    }

    public void onSuccess(AppendRowsResponse response) {
      // Donothing
    }

    public void onFailure(Throwable throwable) {
      for (int i = 0; i < 10; i++) {
        this.mainStreamWriter.append(protoRows);
      }
    }
  }

  @Test
  public void testUpdatedSchemaFetch_multiplexing() throws Exception {
    testUpdatedSchemaFetch(/*enableMultiplexing=*/ true);
  }

  @Test
  public void testUpdatedSchemaFetch_nonMultiplexing() throws Exception {
    testUpdatedSchemaFetch(/*enableMultiplexing=*/ false);
  }

  private void testUpdatedSchemaFetch(boolean enableMultiplexing)
      throws IOException, ExecutionException, InterruptedException {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setChannelProvider(serviceHelper.createChannelProvider())
            .setWriterSchema(PROTO_SCHEMA)
            .setEnableConnectionPool(enableMultiplexing)
            .setLocation("us")
            .build();
    testBigQueryWrite.addResponse(
        AppendRowsResponse.newBuilder()
            .setAppendResult(
                AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(0)).build())
            .setUpdatedSchema(UPDATED_TABLE_SCHEMA)
            .setWriteStream(TEST_STREAM_1)
            .build());

    assertEquals(writer.getUpdatedSchema(), null);
    AppendRowsResponse response =
        writer.append(createProtoRows(new String[] {String.valueOf(0)}), 0).get();
    assertEquals(writer.getUpdatedSchema(), UPDATED_TABLE_SCHEMA);

    // Create another writer, although it's the same stream name but the time stamp is newer, thus
    // the old updated schema won't get returned.
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_1)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setChannelProvider(serviceHelper.createChannelProvider())
            .setWriterSchema(PROTO_SCHEMA)
            .setEnableConnectionPool(enableMultiplexing)
            .setLocation("us")
            .build();
    assertEquals(writer2.getUpdatedSchema(), null);
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
  public void testEnableConnectionPoolOnExplicitStream() throws Exception {
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            new ThrowingRunnable() {
              @Override
              public void run() throws Throwable {
                StreamWriter.newBuilder(EXPLICIT_STREAM, client)
                    .setEnableConnectionPool(true)
                    .build();
              }
            });
    assertTrue(ex.getMessage().contains("Trying to enable connection pool in non-default stream."));
  }

  @Test
  public void testShortenStreamNameAllowed() throws Exception {
    // no exception is thrown.
    StreamWriter.newBuilder(TEST_STREAM_SHORTEN, client)
        .setEnableConnectionPool(true)
        .setLocation("us")
        .build();
  }

  @Test
  public void testAppendSuccessAndConnectionError() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setTraceId(TEST_TRACE_ID)
            // Retry expire immediately.
            .setMaxRetryDuration(java.time.Duration.ofMillis(1L))
            .build();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addException(Status.INTERNAL.asException());
    testBigQueryWrite.addException(Status.INTERNAL.asException());
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
            .setCode(Code.INVALID_ARGUMENT.ordinal())
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
    testBigQueryWrite.addException(Status.INVALID_ARGUMENT.asException());

    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ApiException error1 = assertFutureException(ApiException.class, appendFuture1);
    assertEquals(Code.INVALID_ARGUMENT, error1.getStatusCode().getCode());

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
    testBigQueryWrite.addException(Status.INVALID_ARGUMENT.asException());

    // Send 10 requests, so that there are 10 inflight requests.
    int appendCount = 10;
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}));
    }

    // Server close should properly handle all inflight requests.
    for (int i = 0; i < appendCount; i++) {
      if (i == 0) {
        ApiException actualError = assertFutureException(ApiException.class, futures.get(i));
        assertEquals(Code.INVALID_ARGUMENT, actualError.getStatusCode().getCode());
      } else {
        assertFutureException(StreamWriterClosedException.class, futures.get(i));
      }
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
      assertEquals(
          appendRowsRequest.getDefaultMissingValueInterpretation(),
          MissingValueInterpretation.MISSING_VALUE_INTERPRETATION_UNSPECIFIED);
    }

    writer1.close();
    writer2.close();
  }

  @Test
  public void testFixedCredentialProvider_nullProvider() throws Exception {
    // Use the shared connection mode.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());
    ProtoSchema schema1 = createProtoSchema("Schema1");
    ProtoSchema schema2 = createProtoSchema("Schema2");
    CredentialsProvider credentialsProvider1 = FixedCredentialsProvider.create(null);
    CredentialsProvider credentialsProvider2 = FixedCredentialsProvider.create(null);
    StreamWriter writer1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(schema1)
            .setLocation("US")
            .setEnableConnectionPool(true)
            .setMaxInflightRequests(1)
            .setCredentialsProvider(credentialsProvider1)
            .build();
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_2, client)
            .setWriterSchema(schema2)
            .setMaxInflightRequests(1)
            .setEnableConnectionPool(true)
            .setCredentialsProvider(credentialsProvider2)
            .setLocation("US")
            .build();
    // Null credential provided belong to the same connection pool.
    assertEquals(writer1.getTestOnlyConnectionPoolMap().size(), 1);
  }

  @Test
  public void testFixedCredentialProvider_twoCredentialsSplitPool() throws Exception {
    // Use the shared connection mode.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());
    ProtoSchema schema1 = createProtoSchema("Schema1");
    ProtoSchema schema2 = createProtoSchema("Schema2");
    UserCredentials userCredentials1 =
        UserCredentials.newBuilder()
            .setClientId("CLIENT_ID_1")
            .setClientSecret("CLIENT_SECRET_1")
            .setRefreshToken("REFRESH_TOKEN_1")
            .build();
    CredentialsProvider credentialsProvider1 = FixedCredentialsProvider.create(userCredentials1);
    UserCredentials userCredentials2 =
        UserCredentials.newBuilder()
            .setClientId("CLIENT_ID_2")
            .setClientSecret("CLIENT_SECRET_2")
            .setRefreshToken("REFRESH_TOKEN_2")
            .build();
    CredentialsProvider credentialsProvider2 = FixedCredentialsProvider.create(userCredentials2);
    StreamWriter writer1 =
        StreamWriter.newBuilder(TEST_STREAM_1)
            .setWriterSchema(schema1)
            .setLocation("US")
            .setEnableConnectionPool(true)
            .setMaxInflightRequests(1)
            .setCredentialsProvider(credentialsProvider1)
            .build();
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_2)
            .setWriterSchema(schema2)
            .setMaxInflightRequests(1)
            .setEnableConnectionPool(true)
            .setLocation("US")
            .setCredentialsProvider(credentialsProvider2)
            .build();
    assertEquals(writer1.getTestOnlyConnectionPoolMap().size(), 2);
  }

  @Test
  public void testFixedCredentialProvider_twoProviderSameCredentialSharePool() throws Exception {
    // Use the shared connection mode.
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(1).build());
    ProtoSchema schema1 = createProtoSchema("Schema1");
    ProtoSchema schema2 = createProtoSchema("Schema2");
    UserCredentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId("CLIENT_ID_1")
            .setClientSecret("CLIENT_SECRET_1")
            .setRefreshToken("REFRESH_TOKEN_1")
            .build();
    CredentialsProvider credentialsProvider1 = FixedCredentialsProvider.create(userCredentials);
    CredentialsProvider credentialsProvider2 = FixedCredentialsProvider.create(userCredentials);
    StreamWriter writer1 =
        StreamWriter.newBuilder(TEST_STREAM_1)
            .setWriterSchema(schema1)
            .setLocation("US")
            .setEnableConnectionPool(true)
            .setMaxInflightRequests(1)
            .setCredentialsProvider(credentialsProvider1)
            .build();
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_2)
            .setWriterSchema(schema2)
            .setMaxInflightRequests(1)
            .setEnableConnectionPool(true)
            .setLocation("US")
            .setCredentialsProvider(credentialsProvider2)
            .build();
    assertEquals(writer1.getTestOnlyConnectionPoolMap().size(), 1);
  }

  @Test
  public void testDefaultValueInterpretation_multiplexingCase() throws Exception {
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
            .setDefaultMissingValueInterpretation(MissingValueInterpretation.DEFAULT_VALUE)
            .build();
    StreamWriter writer2 =
        StreamWriter.newBuilder(TEST_STREAM_2, client)
            .setWriterSchema(schema2)
            .setMaxInflightRequests(1)
            .setEnableConnectionPool(true)
            .setLocation("US")
            .setDefaultMissingValueInterpretation(MissingValueInterpretation.NULL_VALUE)
            .build();

    long appendCountPerStream = 5;
    for (int i = 0; i < appendCountPerStream * 4; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    // In total insert append `appendCountPerStream` * 4 requests.
    // We insert using the pattern of streamWriter1, streamWriter1, streamWriter2, streamWriter2
    for (int i = 0; i < appendCountPerStream; i++) {
      ApiFuture<AppendRowsResponse> appendFuture1 =
          writer1.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4);
      ApiFuture<AppendRowsResponse> appendFuture2 =
          writer1.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4 + 1);
      ApiFuture<AppendRowsResponse> appendFuture3 =
          writer2.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4 + 2);
      ApiFuture<AppendRowsResponse> appendFuture4 =
          writer2.append(createProtoRows(new String[] {String.valueOf(i)}), i * 4 + 3);
      appendFuture1.get();
      appendFuture2.get();
      appendFuture3.get();
      appendFuture4.get();
    }

    for (int i = 0; i < appendCountPerStream * 4; i++) {
      AppendRowsRequest appendRowsRequest = testBigQueryWrite.getAppendRequests().get(i);
      assertEquals(i, appendRowsRequest.getOffset().getValue());
      if (i % 4 <= 1) {
        assertEquals(
            appendRowsRequest.getDefaultMissingValueInterpretation(),
            MissingValueInterpretation.DEFAULT_VALUE);
      } else {
        assertEquals(
            appendRowsRequest.getDefaultMissingValueInterpretation(),
            MissingValueInterpretation.NULL_VALUE);
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

    // There is an oppotunity to allow 20MB requests.
    String oversized = Strings.repeat("a", (int) (StreamWriter.getApiMaxRequestBytes() * 2 + 1));
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {oversized});
    assertTrue(appendFuture1.isDone());
    StatusRuntimeException actualError =
        assertFutureException(StatusRuntimeException.class, appendFuture1);
    assertEquals(Status.Code.INVALID_ARGUMENT, actualError.getStatus().getCode());
    assertTrue(actualError.getStatus().getDescription().contains("MessageSize is too large"));

    writer.close();
  }

  @Test
  public void testWrongCompressionType() throws Exception {
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> {
              StreamWriter.newBuilder(TEST_STREAM_1, client).setCompressorName("not-gzip").build();
            });
    assertTrue(
        ex.getMessage()
            .contains(
                "Compression of type \"not-gzip\" isn't supported, only \"gzip\" compression is supported."));
  }

  @Test
  public void testThrowExceptionWhileWithinAppendLoop_MaxWaitTimeExceed() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    StreamWriter.setMaxRequestCallbackWaitTime(java.time.Duration.ofSeconds(1));
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client).setWriterSchema(schema1).build();
    testBigQueryWrite.setResponseSleep(org.threeten.bp.Duration.ofSeconds(3));

    long appendCount = 10;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    // In total insert 5 requests,
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount; i++) {
      int finalI = i;
      ExecutionException ex =
          assertThrows(
              ExecutionException.class,
              () -> futures.get(finalI).get().getAppendResult().getOffset().getValue());
      if (i == 0) {
        assertThat(ex.getCause()).hasMessageThat().contains("Request has waited in inflight queue");
        assertThat(ex.getCause())
            .isInstanceOf(Exceptions.MaximumRequestCallbackWaitTimeExceededException.class);
      } else {
        assertThat(ex.getCause())
            .hasMessageThat()
            .contains("Connection is aborted due to an unrecoverable");
      }
    }
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

  @Test
  public void testAppendWithResetNeverSuccess() throws Exception {
    try (StreamWriter writer = getTestStreamWriter()) {
      testBigQueryWrite.setCloseForeverAfter(1);
      long appendCount = 100;
      for (long i = 0; i < appendCount; i++) {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
      List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
      for (long i = 0; i < appendCount; i++) {
        futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}, i));
      }
      // first request succeeded.
      assertEquals(futures.get(0).get().getAppendResult().getOffset().getValue(), 0);
      // after 5 seconds, the requests will bail out.
      for (int i = 1; i < appendCount; i++) {
        if (i == 1) {
          assertFutureException(AbortedException.class, futures.get(i));
        } else {
          assertFutureException(StreamWriterClosedException.class, futures.get(i));
        }
      }
    }
  }

  @Test
  public void testAppendWithResetNeverSuccessWithMultiplexing() throws Exception {
    try (StreamWriter writer = getMultiplexingTestStreamWriter()) {
      testBigQueryWrite.setCloseForeverAfter(1);
      long appendCount = 100;
      for (long i = 0; i < appendCount; i++) {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
      List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
      for (long i = 0; i < appendCount; i++) {
        futures.add(sendTestMessage(writer, new String[] {String.valueOf(i)}, i));
      }
      // first request succeeded.
      assertEquals(futures.get(0).get().getAppendResult().getOffset().getValue(), 0);
      // after 5 seconds, the requests will bail out.
      for (int i = 1; i < appendCount; i++) {
        if (i == 1) {
          assertFutureException(AbortedException.class, futures.get(i));
        } else {
          assertFutureException(StreamWriterClosedException.class, futures.get(i));
        }
      }
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
    assertTrue(actualError.getStatus().getDescription().contains("User closed StreamWriter"));
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

  @Test
  public void testRetryInUnrecoverableStatus_MultiplexingCase() throws Exception {
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(4).build());
    ConnectionWorkerPool.enableTestingLogic();

    // Setup: create three stream writers, two of them are writing to the same stream.
    // Those four stream writers should be assigned to the same connection.
    // 1. Submit three requests at first to trigger connection retry limitation.
    // 2. At this point the connection should be entering a unrecoverable state.
    // 3. Further submit requests to those stream writers would trigger connection reassignment.
    StreamWriter writer1 = getMultiplexingStreamWriter(TEST_STREAM_1);
    StreamWriter writer2 = getMultiplexingStreamWriter(TEST_STREAM_2);
    StreamWriter writer3 = getMultiplexingStreamWriter(TEST_STREAM_3);
    StreamWriter writer4 = getMultiplexingStreamWriter(TEST_STREAM_3);

    testBigQueryWrite.setCloseForeverAfter(2);
    testBigQueryWrite.setTimesToClose(1);
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    // Connection will be failed after triggering the third append.
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer1, new String[] {"A"}, 0);
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer2, new String[] {"B"}, 1);
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer3, new String[] {"C"}, 2);
    TimeUnit.SECONDS.sleep(1);
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertThrows(
        ExecutionException.class,
        () -> {
          assertEquals(2, appendFuture3.get().getAppendResult().getOffset().getValue());
        });
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getTotalConnectionCount(), 1);
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getCreateConnectionCount(), 1);

    // Insert another request to the writer attached to closed connection would create another
    // connection.

    testBigQueryWrite.setCloseForeverAfter(0);
    testBigQueryWrite.addResponse(createAppendResponse(4));
    testBigQueryWrite.addResponse(createAppendResponse(5));
    testBigQueryWrite.addResponse(createAppendResponse(6));
    ApiFuture<AppendRowsResponse> appendFuture4 = sendTestMessage(writer4, new String[] {"A"}, 2);
    ApiFuture<AppendRowsResponse> appendFuture5 = sendTestMessage(writer1, new String[] {"A"}, 3);
    ApiFuture<AppendRowsResponse> appendFuture6 = sendTestMessage(writer2, new String[] {"B"}, 4);
    assertEquals(4, appendFuture4.get().getAppendResult().getOffset().getValue());
    assertEquals(5, appendFuture5.get().getAppendResult().getOffset().getValue());
    assertEquals(6, appendFuture6.get().getAppendResult().getOffset().getValue());
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getTotalConnectionCount(), 1);
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getCreateConnectionCount(), 2);

    writer1.close();
    writer2.close();
    writer3.close();
    writer4.close();
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getTotalConnectionCount(), 0);
  }

  @Test
  public void testCloseWhileInUnrecoverableState() throws Exception {
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMinConnectionsPerRegion(1).setMaxConnectionsPerRegion(4).build());
    ConnectionWorkerPool.enableTestingLogic();

    // Setup: create three stream writers
    // 1. Submit three requests at first to trigger connection retry limitation.
    // 2. Submit request to writer3 to trigger reassignment
    // 3. Close the previous two writers would be succesful
    StreamWriter writer1 = getMultiplexingStreamWriter(TEST_STREAM_1);
    StreamWriter writer2 = getMultiplexingStreamWriter(TEST_STREAM_2);
    StreamWriter writer3 = getMultiplexingStreamWriter(TEST_STREAM_3);

    testBigQueryWrite.setCloseForeverAfter(2);
    testBigQueryWrite.setTimesToClose(1);
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    // Connection will be failed after triggering the third append.
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer1, new String[] {"A"}, 0);
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer2, new String[] {"B"}, 1);
    ApiFuture<AppendRowsResponse> appendFuture3 = sendTestMessage(writer3, new String[] {"C"}, 2);
    TimeUnit.SECONDS.sleep(1);
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertThrows(
        ExecutionException.class,
        () -> {
          assertEquals(2, appendFuture3.get().getAppendResult().getOffset().getValue());
        });
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getTotalConnectionCount(), 1);
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getCreateConnectionCount(), 1);

    writer1.close();
    writer2.close();
    // We will still be left with one request
    assertEquals(writer1.getTestOnlyConnectionWorkerPool().getCreateConnectionCount(), 1);
  }

  public StreamWriter getMultiplexingStreamWriter(String streamName) throws IOException {
    return StreamWriter.newBuilder(streamName, client)
        .setWriterSchema(createProtoSchema())
        .setEnableConnectionPool(true)
        .setMaxInflightRequests(10)
        .setLocation("US")
        .setMaxRetryDuration(java.time.Duration.ofMillis(100))
        .setRetrySettings(retrySettings)
        .build();
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

  @Test
  public void testSetAndGetMissingValueInterpretationMap() throws Exception {
    StreamWriter writer = getTestStreamWriter();
    Map<String, AppendRowsRequest.MissingValueInterpretation> missingValueMap = new HashMap();
    missingValueMap.put("col1", AppendRowsRequest.MissingValueInterpretation.NULL_VALUE);
    missingValueMap.put("col3", AppendRowsRequest.MissingValueInterpretation.DEFAULT_VALUE);
    writer.setMissingValueInterpretationMap(missingValueMap);
    assertEquals(missingValueMap, writer.getMissingValueInterpretationMap());
  }

  @Test
  public void testAppendWithMissingValueMap() throws Exception {
    StreamWriter writer = getTestStreamWriter();

    long appendCount = 2;
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(1));

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    // The first append doesn't use a missing value map.
    futures.add(writer.append(createProtoRows(new String[] {String.valueOf(0)}), 0));

    // The second append uses a missing value map.
    Map<String, AppendRowsRequest.MissingValueInterpretation> missingValueMap = new HashMap();
    missingValueMap.put("col1", AppendRowsRequest.MissingValueInterpretation.NULL_VALUE);
    missingValueMap.put("col3", AppendRowsRequest.MissingValueInterpretation.DEFAULT_VALUE);
    writer.setMissingValueInterpretationMap(missingValueMap);
    futures.add(writer.append(createProtoRows(new String[] {String.valueOf(1)}), 1));

    for (int i = 0; i < appendCount; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }

    // Ensure that the AppendRowsRequest for the first append operation does not have a missing
    // value map, and that the second AppendRowsRequest has the missing value map provided in the
    // second append.
    verifyAppendRequests(appendCount);
    AppendRowsRequest request1 = testBigQueryWrite.getAppendRequests().get(0);
    AppendRowsRequest request2 = testBigQueryWrite.getAppendRequests().get(1);
    assertTrue(request1.getMissingValueInterpretations().isEmpty());
    assertEquals(request2.getMissingValueInterpretations(), missingValueMap);

    writer.close();
  }

  @Test(timeout = 10000)
  public void testStreamWriterUserCloseMultiplexing() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();

    writer.close();
    assertTrue(writer.isClosed());
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture1.get();
            });
    assertEquals(
        Status.Code.FAILED_PRECONDITION,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
    assertTrue(writer.isUserClosed());
  }

  @Test(timeout = 10000)
  public void testStreamWriterUserCloseNoMultiplexing() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client).setWriterSchema(createProtoSchema()).build();

    writer.close();
    assertTrue(writer.isClosed());
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture1.get();
            });
    assertEquals(
        Status.Code.FAILED_PRECONDITION,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
    assertTrue(writer.isUserClosed());
  }

  @Test(timeout = 10000)
  public void testStreamWriterPermanentErrorMultiplexing() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(createProtoSchema())
            .setEnableConnectionPool(true)
            .setLocation("us")
            .build();
    testBigQueryWrite.setCloseForeverAfter(1);
    // Permenant errror.
    testBigQueryWrite.setFailedStatus(Status.INVALID_ARGUMENT);
    testBigQueryWrite.addResponse(createAppendResponse(0));
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    appendFuture1.get();
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"A"});
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture2.get();
            });
    assertTrue(ex.getCause() instanceof InvalidArgumentException);
    assertFalse(writer.isClosed());
    assertFalse(writer.isUserClosed());
  }

  @Test(timeout = 10000)
  public void testStreamWriterPermanentErrorNoMultiplexing() throws Exception {
    StreamWriter writer =
        StreamWriter.newBuilder(TEST_STREAM_1, client).setWriterSchema(createProtoSchema()).build();
    testBigQueryWrite.setCloseForeverAfter(1);
    // Permenant errror.
    testBigQueryWrite.setFailedStatus(Status.INVALID_ARGUMENT);
    testBigQueryWrite.addResponse(createAppendResponse(0));
    ApiFuture<AppendRowsResponse> appendFuture1 = sendTestMessage(writer, new String[] {"A"});
    appendFuture1.get();
    ApiFuture<AppendRowsResponse> appendFuture2 = sendTestMessage(writer, new String[] {"A"});
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture2.get();
            });
    assertTrue(writer.isClosed());
    assertTrue(ex.getCause() instanceof InvalidArgumentException);
    assertFalse(writer.isUserClosed());
  }

  @Test(timeout = 10000)
  public void testBuilderDefaultSetting() throws Exception {
    StreamWriter.Builder writerBuilder = StreamWriter.newBuilder(TEST_STREAM_1);
    BigQueryWriteSettings writeSettings = StreamWriter.getBigQueryWriteSettings(writerBuilder);
    assertEquals(
        BigQueryWriteSettings.defaultExecutorProviderBuilder().build().toString(),
        writeSettings.getBackgroundExecutorProvider().toString());
    assertEquals(
        BigQueryWriteSettings.defaultCredentialsProviderBuilder().build().toString(),
        writeSettings.getCredentialsProvider().toString());
    assertTrue(
        writeSettings.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider);
    assertTrue(
        ((InstantiatingGrpcChannelProvider) writeSettings.getTransportChannelProvider())
            .getKeepAliveWithoutCalls());
    assertEquals(
        ((InstantiatingGrpcChannelProvider) writeSettings.getTransportChannelProvider())
            .getKeepAliveTimeout(),
        org.threeten.bp.Duration.ofMinutes(1));
    assertEquals(
        ((InstantiatingGrpcChannelProvider) writeSettings.getTransportChannelProvider())
            .getKeepAliveTime(),
        org.threeten.bp.Duration.ofMinutes(1));
    assertEquals(
        BigQueryWriteSettings.getDefaultEndpoint(), writeSettings.getEndpoint().toString());
  }

  @Test(timeout = 10000)
  public void testBuilderExplicitSetting() throws Exception {
    // Client has special seetings.
    BigQueryWriteSettings clientSettings =
        BigQueryWriteSettings.newBuilder()
            .setEndpoint("xxx:345")
            .setBackgroundExecutorProvider(
                InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(4).build())
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    BigQueryWriteClient client = BigQueryWriteClient.create(clientSettings);
    StreamWriter.Builder writerWithClient = StreamWriter.newBuilder(TEST_STREAM_1, client);
    BigQueryWriteSettings writerSettings = StreamWriter.getBigQueryWriteSettings(writerWithClient);
    assertEquals("xxx:345", writerSettings.getEndpoint());
    assertTrue(
        writerSettings.getBackgroundExecutorProvider() instanceof InstantiatingExecutorProvider);
    assertEquals(
        4,
        ((InstantiatingExecutorProvider) writerSettings.getBackgroundExecutorProvider())
            .getExecutorThreadCount());

    // Explicit setting on StreamWriter is respected.
    StreamWriter.Builder writerWithClientWithOverrides =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setEndpoint("yyy:345")
            .setExecutorProvider(
                InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(14).build())
            .setChannelProvider(
                BigQueryWriteSettings.defaultGrpcTransportProviderBuilder()
                    .setKeepAliveTimeout(Duration.ofSeconds(500))
                    .build())
            .setCredentialsProvider(
                BigQueryWriteSettings.defaultCredentialsProviderBuilder()
                    .setScopesToApply(Arrays.asList("A", "B"))
                    .build());
    BigQueryWriteSettings writerSettings2 =
        StreamWriter.getBigQueryWriteSettings(writerWithClientWithOverrides);
    assertEquals("yyy:345", writerSettings2.getEndpoint());
    assertTrue(
        writerSettings2.getBackgroundExecutorProvider() instanceof InstantiatingExecutorProvider);
    assertEquals(
        14,
        ((InstantiatingExecutorProvider) writerSettings2.getBackgroundExecutorProvider())
            .getExecutorThreadCount());
    assertTrue(
        writerSettings2.getTransportChannelProvider() instanceof InstantiatingGrpcChannelProvider);
    assertEquals(
        Duration.ofSeconds(500),
        ((InstantiatingGrpcChannelProvider) writerSettings2.getTransportChannelProvider())
            .getKeepAliveTimeout());
    assertTrue(writerSettings2.getCredentialsProvider() instanceof GoogleCredentialsProvider);
    assertEquals(
        2,
        ((GoogleCredentialsProvider) writerSettings2.getCredentialsProvider())
            .getScopesToApply()
            .size());
  }

  @Test
  public void testAppendSuccessAndInternalErrorRetrySuccess() throws Exception {
    StreamWriter writer = getTestStreamWriterRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(0));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));
    ApiFuture<AppendRowsResponse> appendFuture3 =
        writer.append(createProtoRows(new String[] {"C"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(0, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertEquals(0, appendFuture3.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendSuccessAndInternalQuotaErrorRetrySuccess() throws Exception {
    StreamWriter writer = getTestStreamWriterRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(createAppendResponse(0));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));
    ApiFuture<AppendRowsResponse> appendFuture3 =
        writer.append(createProtoRows(new String[] {"C"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(0, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertEquals(0, appendFuture3.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testInternalQuotaError_MaxWaitTimeExceed_RetrySuccess() throws Exception {
    // In order for the test to succeed, the given request must complete successfully even after all
    // the retries. The fake server is configured to fail 3 times with a quota error. This means the
    // client will perform retry with exponential backoff. The fake server injects 1 second of delay
    // for each response. In addition, the exponential backoff injects a couple of seconds of delay.
    // This yields an overall delay of about 5 seconds before the request succeeds. If the request
    // send timestamp was being set only once, this would eventually exceed the 4 second timeout
    // limit, and throw an exception. With the current behavior, the request send timestamp is reset
    // each time a retry is performed, so we never exceed the 4 second timeout limit.
    StreamWriter.setMaxRequestCallbackWaitTime(java.time.Duration.ofSeconds(4));
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(1));
    StreamWriter writer = getTestStreamWriterRetryEnabled();
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(0));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    writer.close();
  }

  @Test
  public void testAppendSuccessAndInternalErrorRetrySuccessExclusive() throws Exception {
    // Ensure we return an error from the fake server when a retry is in progress
    testBigQueryWrite.setReturnErrorDuringExclusiveStreamRetry(true);
    // Ensure messages will be in the inflight queue
    testBigQueryWrite.setVerifyOffset(true);
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(
        new DummyResponseSupplierWillFailThenSucceed(
            new FakeBigQueryWriteImpl.Response(createAppendResponse(1)),
            /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS,
            com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build()));
    testBigQueryWrite.addResponse(createAppendResponse(2));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}), 0);
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}), 1);
    ApiFuture<AppendRowsResponse> appendFuture3 =
        writer.append(createProtoRows(new String[] {"C"}), 2);

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());
    assertEquals(2, appendFuture3.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendSuccessAndInternalErrorRetryNoOffsetSuccessExclusive() throws Exception {
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendSuccessAndQuotaErrorRetryNoOffsetSuccessExclusive() throws Exception {
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testExclusiveAppendSuccessAndInternalErrorRetrySuccess() throws Exception {
    // Ensure we return an error from the fake server when a retry is in progress
    testBigQueryWrite.setReturnErrorDuringExclusiveStreamRetry(true);
    // Ensure messages will be in the inflight queue
    testBigQueryWrite.setVerifyOffset(true);
    // fakeBigQueryWrite.setResponseSleep(Duration.ofSeconds(3));
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    long appendCount = 20;
    for (long i = 0; i < appendCount; i++) {
      // Add a retriable error every 3 messages
      if (i % 3 == 0) {
        testBigQueryWrite.addResponse(
            new DummyResponseSupplierWillFailThenSucceed(
                new FakeBigQueryWriteImpl.Response(createAppendResponse(i)),
                /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS,
                com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build()));
      } else {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (long i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount; i++) {
      assertThat(futures.get(i).get().getAppendResult().getOffset().getValue()).isEqualTo((long) i);
    }
  }

  @Test
  public void testExclusiveAppendSuccessAndQuotaErrorRetrySuccess() throws Exception {
    // Ensure we return an error from the fake server when a retry is in progress
    testBigQueryWrite.setReturnErrorDuringExclusiveStreamRetry(true);
    // Ensure messages will be in the inflight queue
    testBigQueryWrite.setVerifyOffset(true);
    // fakeBigQueryWrite.setResponseSleep(Duration.ofSeconds(3));
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    long appendCount = 20;
    for (long i = 0; i < appendCount; i++) {
      // Add a retriable error every 3 messages
      if (i % 3 == 0) {
        testBigQueryWrite.addResponse(
            new DummyResponseSupplierWillFailThenSucceed(
                new FakeBigQueryWriteImpl.Response(createAppendResponse(i)),
                /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS,
                com.google.rpc.Status.newBuilder()
                    .setCode(Code.RESOURCE_EXHAUSTED.ordinal())
                    .build()));
      } else {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
    }

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (long i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount; i++) {
      assertThat(futures.get(i).get().getAppendResult().getOffset().getValue()).isEqualTo((long) i);
    }
  }

  @Test
  public void testAppendSuccessAndQuotaErrorRetrySuccessExclusive() throws Exception {
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addResponse(
        new DummyResponseSupplierWillFailThenSucceed(
            new FakeBigQueryWriteImpl.Response(createAppendResponse(1)),
            /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS,
            com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build()));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}), 0);
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}), 1);

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    assertEquals(1, appendFuture2.get().getAppendResult().getOffset().getValue());

    writer.close();
  }

  @Test
  public void testAppendSuccessAndInternalErrorMaxRetryNumAttempts() throws Exception {
    StreamWriter writer = getTestStreamWriterRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture2.get();
            });
    assertEquals(
        Status.Code.INTERNAL, ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
  }

  @Test
  public void testAppendSuccessAndQuotaErrorMaxRetryNumAttempts() throws Exception {
    StreamWriter writer = getTestStreamWriterRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture2.get();
            });
    assertEquals(
        Status.Code.RESOURCE_EXHAUSTED,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
  }

  @Test
  public void testExclusiveAppendSuccessAndInternalErrorRetryMaxRetry() throws Exception {
    testBigQueryWrite.setReturnErrorDuringExclusiveStreamRetry(true);
    // Ensure messages will be in the inflight queue
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(1));
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();

    int appendCount = 10;
    for (long i = 0; i < appendCount - 1; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    testBigQueryWrite.addResponse(
        new DummyResponseSupplierWillFailThenSucceed(
            new FakeBigQueryWriteImpl.Response(createAppendResponse(appendCount)),
            /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS + 1,
            com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build()));

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (long i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount - 1; i++) {
      assertThat(futures.get(i).get().getAppendResult().getOffset().getValue()).isEqualTo((long) i);
    }
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              futures.get(appendCount - 1).get();
            });
    assertEquals(
        Status.Code.INTERNAL, ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
  }

  @Test
  public void testExclusiveAppendSuccessAndQuotaErrorRetryMaxRetry() throws Exception {
    testBigQueryWrite.setReturnErrorDuringExclusiveStreamRetry(true);
    // Ensure messages will be in the inflight queue
    testBigQueryWrite.setResponseSleep(Duration.ofSeconds(1));
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();

    int appendCount = 10;
    for (long i = 0; i < appendCount - 1; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    testBigQueryWrite.addResponse(
        new DummyResponseSupplierWillFailThenSucceed(
            new FakeBigQueryWriteImpl.Response(createAppendResponse(appendCount)),
            /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS + 1,
            com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build()));

    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (long i = 0; i < appendCount; i++) {
      futures.add(writer.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }

    for (int i = 0; i < appendCount - 1; i++) {
      assertThat(futures.get(i).get().getAppendResult().getOffset().getValue()).isEqualTo((long) i);
    }
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              futures.get(appendCount - 1).get();
            });
    assertEquals(
        Status.Code.RESOURCE_EXHAUSTED,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
  }

  @Test
  public void testExclusiveAppendQuotaErrorRetryExponentialBackoff() throws Exception {
    testBigQueryWrite.setReturnErrorDuringExclusiveStreamRetry(true);
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();

    testBigQueryWrite.addResponse(
        new DummyResponseSupplierWillFailThenSucceed(
            new FakeBigQueryWriteImpl.Response(createAppendResponse(0)),
            /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS + 1,
            com.google.rpc.Status.newBuilder().setCode(Code.RESOURCE_EXHAUSTED.ordinal()).build()));

    ApiFuture<AppendRowsResponse> future =
        writer.append(createProtoRows(new String[] {String.valueOf(0)}), 0);

    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              future.get();
            });
    assertEquals(
        Status.Code.RESOURCE_EXHAUSTED,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());

    ArrayList<Instant> instants = testBigQueryWrite.getLatestRequestReceivedInstants();
    Instant previousInstant = instants.get(0);
    // Include initial attempt
    assertEquals(instants.size(), MAX_RETRY_NUM_ATTEMPTS + 1);
    double minExpectedDelay = INITIAL_RETRY_MILLIS * 0.95;
    for (int i = 1; i < instants.size(); i++) {
      Instant currentInstant = instants.get(i);
      double differenceInMillis =
          java.time.Duration.between(previousInstant, currentInstant).toMillis();
      assertThat(differenceInMillis).isAtLeast((double) INITIAL_RETRY_MILLIS);
      assertThat(differenceInMillis).isGreaterThan(minExpectedDelay);
      minExpectedDelay = minExpectedDelay * RETRY_MULTIPLIER;
      previousInstant = currentInstant;
    }
  }

  @Test
  public void testAppendInternalErrorRetryExponentialBackoff() throws Exception {
    StreamWriter writer = getTestStreamWriterRetryEnabled();

    testBigQueryWrite.addResponse(
        new DummyResponseSupplierWillFailThenSucceed(
            new FakeBigQueryWriteImpl.Response(createAppendResponse(0)),
            /* totalFailCount= */ MAX_RETRY_NUM_ATTEMPTS + 1,
            com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL.ordinal()).build()));

    ApiFuture<AppendRowsResponse> future =
        writer.append(createProtoRows(new String[] {String.valueOf(0)}), 0);

    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              future.get();
            });
    assertEquals(
        Status.Code.INTERNAL, ((StatusRuntimeException) ex.getCause()).getStatus().getCode());

    ArrayList<Instant> instants = testBigQueryWrite.getLatestRequestReceivedInstants();
    Instant previousInstant = instants.get(0);
    // Include initial attempt
    assertEquals(instants.size(), MAX_RETRY_NUM_ATTEMPTS + 1);
    double minExpectedDelay = INITIAL_RETRY_MILLIS * 0.95;
    for (int i = 1; i < instants.size(); i++) {
      Instant currentInstant = instants.get(i);
      double differenceInMillis =
          java.time.Duration.between(previousInstant, currentInstant).toMillis();
      assertThat(differenceInMillis).isAtLeast((double) INITIAL_RETRY_MILLIS);
      assertThat(differenceInMillis).isGreaterThan(minExpectedDelay);
      minExpectedDelay = minExpectedDelay * RETRY_MULTIPLIER;
      previousInstant = currentInstant;
    }
  }

  @Test
  public void testAppendSuccessAndNonRetryableError() throws Exception {
    StreamWriter writer = getTestStreamWriterRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INVALID_ARGUMENT.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}));
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}));

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture2.get();
            });
    assertEquals(
        Status.Code.INVALID_ARGUMENT,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
  }

  @Test
  public void testExclusiveAppendSuccessAndNonRetryableError() throws Exception {
    StreamWriter writer = getTestStreamWriterExclusiveRetryEnabled();
    testBigQueryWrite.addResponse(createAppendResponse(0));
    testBigQueryWrite.addStatusException(
        com.google.rpc.Status.newBuilder().setCode(Code.INVALID_ARGUMENT.ordinal()).build());
    testBigQueryWrite.addResponse(createAppendResponse(1));

    ApiFuture<AppendRowsResponse> appendFuture1 =
        writer.append(createProtoRows(new String[] {"A"}), 0);
    ApiFuture<AppendRowsResponse> appendFuture2 =
        writer.append(createProtoRows(new String[] {"B"}), 1);

    assertEquals(0, appendFuture1.get().getAppendResult().getOffset().getValue());
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () -> {
              appendFuture2.get();
            });
    assertEquals(
        Status.Code.INVALID_ARGUMENT,
        ((StatusRuntimeException) ex.getCause()).getStatus().getCode());
  }

  @Test
  public void testGetDefaultStreamName() {
    TableName tableName = TableName.of("projectId", "datasetId", "tableId");

    String actualDefaultName = StreamWriter.getDefaultStreamName(tableName);

    assertEquals(
        "projects/projectId/datasets/datasetId/tables/tableId/_default", actualDefaultName);
  }
}
