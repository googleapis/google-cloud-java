/*
 * Copyright 2022 Google LLC
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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.storage.test.Test.ComplicateType;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.test.Test.InnerType;
import com.google.cloud.bigquery.storage.v1.ConnectionWorker.Load;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Int64Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionWorkerTest {
  private static final Logger log = Logger.getLogger(StreamWriter.class.getName());
  private static final String TEST_STREAM_1 = "projects/p1/datasets/d1/tables/t1/streams/s1";
  private static final String TEST_STREAM_2 = "projects/p2/datasets/d2/tables/t2/streams/s2";
  private static final String TEST_TRACE_ID = "DATAFLOW:job_id";
  private static final RetrySettings retrySettings =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(org.threeten.bp.Duration.ofMillis(500))
          .setRetryDelayMultiplier(1.1)
          .setMaxAttempts(3)
          .setMaxRetryDelay(org.threeten.bp.Duration.ofMinutes(5))
          .build();

  private FakeBigQueryWrite testBigQueryWrite;
  private FakeScheduledExecutorService fakeExecutor;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteClient client;

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    ConnectionWorker.setMaxInflightQueueWaitTime(300000);
    ConnectionWorker.setMaxInflightRequestWaitTime(Duration.ofMinutes(10));
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
  }

  @Test
  public void testMultiplexedAppendSuccess() throws Exception {
    try (ConnectionWorker connectionWorker = createConnectionWorker()) {
      long appendCount = 20;
      for (long i = 0; i < appendCount; i++) {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
      List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
      StreamWriter sw1 =
          StreamWriter.newBuilder(TEST_STREAM_1, client)
              .setWriterSchema(createProtoSchema("foo"))
              .setLocation("us")
              .build();
      StreamWriter sw2 =
          StreamWriter.newBuilder(TEST_STREAM_2, client)
              .setWriterSchema(createProtoSchema("complicate"))
              .setLocation("us")
              .build();
      // We do a pattern of:
      // send to stream1, string1
      // send to stream1, string2
      // send to stream2, string3
      // send to stream2, string4
      // send to stream1, string5
      // ...
      for (long i = 0; i < appendCount; i++) {
        switch ((int) i % 4) {
          case 0:
          case 1:
            ProtoRows rows = createFooProtoRows(new String[] {String.valueOf(i)});
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    sw1,
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          case 2:
          case 3:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    sw2,
                    createComplicateTypeProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          default: // fall out
            break;
        }
      }
      // In the real world the response won't contain offset for default stream, but we use offset
      // here just to test response.
      for (int i = 0; i < appendCount; i++) {
        Int64Value offset = futures.get(i).get().getAppendResult().getOffset();
        assertThat(offset).isEqualTo(Int64Value.of(i));
      }
      assertThat(testBigQueryWrite.getAppendRequests().size()).isEqualTo(appendCount);
      for (int i = 0; i < appendCount; i++) {
        AppendRowsRequest serverRequest = testBigQueryWrite.getAppendRequests().get(i);
        assertThat(serverRequest.getProtoRows().getRows().getSerializedRowsCount())
            .isGreaterThan(0);
        assertThat(serverRequest.getOffset().getValue()).isEqualTo(i);

        // We will get the request as the pattern of:
        // (writer_stream: t1, schema: t1)
        // (writer_stream: _, schema: _)
        // (writer_stream: t2, schema: t2) -> multiplexing entered.
        // (writer_stream: t2, schema: _)
        // (writer_stream: t1, schema: t1)
        // (writer_stream: t1, schema: _)
        switch (i % 4) {
          case 0:
            assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_1);
            assertThat(
                    serverRequest.getProtoRows().getWriterSchema().getProtoDescriptor().getName())
                .isEqualTo("foo");
            break;
          case 1:
            // The write stream is empty until we enter multiplexing.
            if (i == 1) {
              assertThat(serverRequest.getWriteStream()).isEmpty();
            } else {
              assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_1);
            }
            // Schema is empty if not at the first request after table switch.
            assertThat(serverRequest.getProtoRows().hasWriterSchema()).isFalse();
            break;
          case 2:
            // Stream name is always populated after multiplexing.
            assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_2);
            // Schema is populated after table switch.
            assertThat(
                    serverRequest.getProtoRows().getWriterSchema().getProtoDescriptor().getName())
                .isEqualTo("complicate");
            break;
          case 3:
            // Schema is empty if not at the first request after table switch.
            assertThat(serverRequest.getProtoRows().hasWriterSchema()).isFalse();
            // Stream name is always populated after multiplexing.
            assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_2);
            break;
          default: // fall out
            break;
        }
      }

      assertThat(connectionWorker.getLoad().destinationCount()).isEqualTo(2);
      assertThat(connectionWorker.getLoad().inFlightRequestsBytes()).isEqualTo(0);
    }
  }

  @Test
  public void testAppendInSameStream_switchSchema() throws Exception {
    try (ConnectionWorker connectionWorker = createConnectionWorker()) {
      long appendCount = 20;
      for (long i = 0; i < appendCount; i++) {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
      List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();

      // Schema1 and schema2 are the same content, but different instance.
      ProtoSchema schema1 = createProtoSchema("foo");
      ProtoSchema schema2 = createProtoSchema("foo");
      // Schema3 is a different schema
      ProtoSchema schema3 = createProtoSchema("bar");

      // We do a pattern of:
      // send to stream1, schema1
      // send to stream1, schema2
      // send to stream1, schema3
      // send to stream1, schema3
      // send to stream1, schema1
      // ...
      StreamWriter sw1 =
          StreamWriter.newBuilder(TEST_STREAM_1, client)
              .setLocation("us")
              .setWriterSchema(schema1)
              .build();
      StreamWriter sw2 =
          StreamWriter.newBuilder(TEST_STREAM_1, client)
              .setLocation("us")
              .setWriterSchema(schema2)
              .build();
      StreamWriter sw3 =
          StreamWriter.newBuilder(TEST_STREAM_1, client)
              .setLocation("us")
              .setWriterSchema(schema3)
              .build();
      for (long i = 0; i < appendCount; i++) {
        switch ((int) i % 4) {
          case 0:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    sw1,
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          case 1:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    sw2,
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          case 2:
          case 3:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    sw3,
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          default: // fall out
            break;
        }
      }
      // In the real world the response won't contain offset for default stream, but we use offset
      // here just to test response.
      for (int i = 0; i < appendCount; i++) {
        Int64Value offset = futures.get(i).get().getAppendResult().getOffset();
        assertThat(offset).isEqualTo(Int64Value.of(i));
      }
      assertThat(testBigQueryWrite.getAppendRequests().size()).isEqualTo(appendCount);
      for (int i = 0; i < appendCount; i++) {
        AppendRowsRequest serverRequest = testBigQueryWrite.getAppendRequests().get(i);
        assertThat(serverRequest.getProtoRows().getRows().getSerializedRowsCount())
            .isGreaterThan(0);
        assertThat(serverRequest.getOffset().getValue()).isEqualTo(i);

        // We will get the request as the pattern of:
        // (writer_stream: t1, schema: schema1)
        // (writer_stream: _, schema: _)
        // (writer_stream: t1, schema: schema3)
        // (writer_stream: t1, schema: _)
        // (writer_stream: t1, schema: schema1)
        // (writer_stream: t1, schema: _)
        switch (i % 4) {
          case 0:
            if (i == 0) {
              assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_1);
            }
            assertThat(
                    serverRequest.getProtoRows().getWriterSchema().getProtoDescriptor().getName())
                .isEqualTo("foo");
            break;
          case 1:
            if (i == 1) {
              assertThat(serverRequest.getWriteStream()).isEmpty();
            } else {
              assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_1);
            }
            // Schema is empty if not at the first request after table switch.
            assertThat(serverRequest.getProtoRows().hasWriterSchema()).isFalse();
            break;
          case 2:
            assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_1);
            // Schema is populated after table switch.
            assertThat(
                    serverRequest.getProtoRows().getWriterSchema().getProtoDescriptor().getName())
                .isEqualTo("bar");
            break;
          case 3:
            assertThat(serverRequest.getWriteStream()).isEqualTo(TEST_STREAM_1);
            // Schema is empty if not at the first request after table switch.
            assertThat(serverRequest.getProtoRows().hasWriterSchema()).isFalse();
            break;
          default: // fall out
            break;
        }
      }

      assertThat(connectionWorker.getLoad().destinationCount()).isEqualTo(1);
      assertThat(connectionWorker.getLoad().inFlightRequestsBytes()).isEqualTo(0);
    }
  }

  @Test
  public void testAppendButInflightQueueFull() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    StreamWriter sw1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setLocation("us")
            .setWriterSchema(schema1)
            .build();
    ConnectionWorker connectionWorker =
        new ConnectionWorker(
            TEST_STREAM_1,
            "us",
            createProtoSchema("foo"),
            6,
            100000,
            Duration.ofSeconds(100),
            FlowController.LimitExceededBehavior.Block,
            TEST_TRACE_ID,
            null,
            client.getSettings(),
            retrySettings);
    testBigQueryWrite.setResponseSleep(org.threeten.bp.Duration.ofSeconds(1));
    ConnectionWorker.setMaxInflightQueueWaitTime(500);

    long appendCount = 6;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    // In total insert 6 requests, since the max queue size is 5 we will stuck at the 6th request.
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      long startTime = System.currentTimeMillis();
      // At the last request we wait more than 500 millisecond for inflight quota.
      if (i == 5) {
        assertThrows(
            StatusRuntimeException.class,
            () -> {
              sendTestMessage(
                  connectionWorker, sw1, createFooProtoRows(new String[] {String.valueOf(5)}), 5);
            });
        long timeDiff = System.currentTimeMillis() - startTime;
        assertEquals(connectionWorker.getLoad().inFlightRequestsCount(), 5);
        assertTrue(timeDiff > 500);
      } else {
        futures.add(
            sendTestMessage(
                connectionWorker, sw1, createFooProtoRows(new String[] {String.valueOf(i)}), i));
        assertEquals(connectionWorker.getLoad().inFlightRequestsCount(), i + 1);
      }
    }

    for (int i = 0; i < appendCount - 1; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }
  }

  @Test
  public void testThrowExceptionWhileWithinAppendLoop() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    StreamWriter sw1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setLocation("us")
            .setWriterSchema(schema1)
            .build();
    ConnectionWorker connectionWorker =
        new ConnectionWorker(
            TEST_STREAM_1,
            "us",
            createProtoSchema("foo"),
            100000,
            100000,
            Duration.ofSeconds(100),
            FlowController.LimitExceededBehavior.Block,
            TEST_TRACE_ID,
            null,
            client.getSettings(),
            retrySettings);
    testBigQueryWrite.setResponseSleep(org.threeten.bp.Duration.ofSeconds(1));
    ConnectionWorker.setMaxInflightQueueWaitTime(500);

    long appendCount = 10;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }
    connectionWorker.setTestOnlyRunTimeExceptionInAppendLoop(
        new RuntimeException("Any exception can happen."));
    // Sleep 1 second before erroring out.
    connectionWorker.setTestOnlyAppendLoopSleepTime(1000L);

    // In total insert 5 requests,
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(
          sendTestMessage(
              connectionWorker, sw1, createFooProtoRows(new String[] {String.valueOf(i)}), i));
      assertEquals(connectionWorker.getLoad().inFlightRequestsCount(), i + 1);
    }

    for (int i = 0; i < appendCount; i++) {
      int finalI = i;
      ExecutionException ex =
          assertThrows(
              ExecutionException.class,
              () -> futures.get(finalI).get().getAppendResult().getOffset().getValue());
      if (i == 0) {
        assertThat(ex.getCause()).hasMessageThat().contains("Any exception can happen.");
      } else {
        assertThat(ex.getCause()).hasMessageThat().contains("Connection is aborted due to ");
      }
    }

    // The future append will directly fail.
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () ->
                sendTestMessage(
                        connectionWorker,
                        sw1,
                        createFooProtoRows(new String[] {String.valueOf(100)}),
                        100)
                    .get());
    assertThat(ex.getCause()).hasMessageThat().contains("Any exception can happen.");
  }

  @Test
  public void testLocationMismatch() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    StreamWriter sw1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client)
            .setWriterSchema(schema1)
            .setLocation("eu")
            .build();
    ConnectionWorker connectionWorker =
        new ConnectionWorker(
            TEST_STREAM_1,
            "us",
            createProtoSchema("foo"),
            100000,
            100000,
            Duration.ofSeconds(100),
            FlowController.LimitExceededBehavior.Block,
            TEST_TRACE_ID,
            null,
            client.getSettings(),
            retrySettings);
    StatusRuntimeException ex =
        assertThrows(
            StatusRuntimeException.class,
            () ->
                sendTestMessage(
                    connectionWorker,
                    sw1,
                    createFooProtoRows(new String[] {String.valueOf(0)}),
                    0));
    assertEquals(
        "INVALID_ARGUMENT: StreamWriter with location eu is scheduled to use a connection with location us",
        ex.getMessage());
  }

  @Test
  public void testStreamNameMismatch() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    StreamWriter sw1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client).setWriterSchema(schema1).build();
    ConnectionWorker connectionWorker =
        new ConnectionWorker(
            TEST_STREAM_2,
            null,
            createProtoSchema("foo"),
            100000,
            100000,
            Duration.ofSeconds(100),
            FlowController.LimitExceededBehavior.Block,
            TEST_TRACE_ID,
            null,
            client.getSettings(),
            retrySettings);
    StatusRuntimeException ex =
        assertThrows(
            StatusRuntimeException.class,
            () ->
                sendTestMessage(
                    connectionWorker,
                    sw1,
                    createFooProtoRows(new String[] {String.valueOf(0)}),
                    0));
    assertEquals(
        "INVALID_ARGUMENT: StreamWriter with stream name projects/p1/datasets/d1/tables/t1/streams/s1 is scheduled to use a connection with stream name projects/p2/datasets/d2/tables/t2/streams/s2",
        ex.getMessage());
  }

  @Test
  public void testExponentialBackoff() throws Exception {
    assertThat(ConnectionWorker.calculateSleepTimeMilli(0)).isEqualTo(50);
    assertThat(ConnectionWorker.calculateSleepTimeMilli(5)).isEqualTo(1600);
    assertThat(ConnectionWorker.calculateSleepTimeMilli(100)).isEqualTo(60000);
  }

  private AppendRowsResponse createAppendResponse(long offset) {
    return AppendRowsResponse.newBuilder()
        .setAppendResult(
            AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(offset)).build())
        .build();
  }

  private ConnectionWorker createConnectionWorker() throws IOException {
    // By default use only the first table as table reference.
    return createConnectionWorker(
        TEST_STREAM_1, TEST_TRACE_ID, 100, 1000, java.time.Duration.ofSeconds(5));
  }

  private ConnectionWorker createConnectionWorker(
      String streamName,
      String traceId,
      long maxRequests,
      long maxBytes,
      java.time.Duration maxRetryDuration)
      throws IOException {
    return new ConnectionWorker(
        streamName,
        "us",
        createProtoSchema("foo"),
        maxRequests,
        maxBytes,
        maxRetryDuration,
        FlowController.LimitExceededBehavior.Block,
        TEST_TRACE_ID,
        null,
        client.getSettings(),
        retrySettings);
  }

  private ProtoSchema createProtoSchema(String protoName) {
    return ProtoSchema.newBuilder()
        .setProtoDescriptor(
            DescriptorProtos.DescriptorProto.newBuilder()
                .setName(protoName)
                .addField(
                    DescriptorProtos.FieldDescriptorProto.newBuilder()
                        .setName("foo")
                        .setType(DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING)
                        .setNumber(1)
                        .build())
                .build())
        .build();
  }

  private ApiFuture<AppendRowsResponse> sendTestMessage(
      ConnectionWorker connectionWorker,
      StreamWriter streamWriter,
      ProtoRows protoRows,
      long offset) {
    return connectionWorker.append(streamWriter, protoRows, offset);
  }

  private ProtoRows createFooProtoRows(String[] messages) {
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    for (String message : messages) {
      FooType foo = FooType.newBuilder().setFoo(message).build();
      rowsBuilder.addSerializedRows(foo.toByteString());
    }
    return rowsBuilder.build();
  }

  private ProtoRows createComplicateTypeProtoRows(String[] messages) {
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    for (String message : messages) {
      ComplicateType complicateType =
          ComplicateType.newBuilder()
              .setInnerType(InnerType.newBuilder().addValue(message))
              .build();
      rowsBuilder.addSerializedRows(complicateType.toByteString());
    }
    return rowsBuilder.build();
  }

  @Test
  public void testLoadCompare_compareLoad() {
    // In flight bytes bucket is split as per 1024 requests per bucket.
    // When in flight bytes is in lower bucket, even destination count is higher and request count
    // is higher, the load is still smaller.
    Load load1 = ConnectionWorker.Load.create(1000, 2000, 100, 1000, 10);
    Load load2 = ConnectionWorker.Load.create(2000, 1000, 10, 1000, 10);
    assertThat(Load.LOAD_COMPARATOR.compare(load1, load2)).isLessThan(0);

    // In flight bytes in the same bucke of request bytes will compare request count.
    Load load3 = ConnectionWorker.Load.create(1, 300, 10, 0, 10);
    Load load4 = ConnectionWorker.Load.create(10, 1, 10, 0, 10);
    assertThat(Load.LOAD_COMPARATOR.compare(load3, load4)).isGreaterThan(0);

    // In flight request and bytes in the same bucket will compare the destination count.
    Load load5 = ConnectionWorker.Load.create(200, 1, 10, 1000, 10);
    Load load6 = ConnectionWorker.Load.create(100, 10, 10, 1000, 10);
    assertThat(Load.LOAD_COMPARATOR.compare(load5, load6) == 0).isTrue();
  }

  @Test
  public void testLoadIsOverWhelmed() {
    // Only in flight request is considered in current overwhelmed calculation.
    Load load1 = ConnectionWorker.Load.create(60, 10, 100, 90, 100);
    assertThat(load1.isOverwhelmed()).isTrue();

    Load load2 = ConnectionWorker.Load.create(1, 1, 100, 100, 100);
    assertThat(load2.isOverwhelmed()).isFalse();
  }

  @Test
  public void testThrowExceptionWhileWithinAppendLoop_MaxWaitTimeExceed() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    ConnectionWorker.setMaxInflightRequestWaitTime(Duration.ofSeconds(1));
    StreamWriter sw1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client).setWriterSchema(schema1).build();
    ConnectionWorker connectionWorker =
        new ConnectionWorker(
            TEST_STREAM_1,
            null,
            createProtoSchema("foo"),
            100000,
            100000,
            Duration.ofSeconds(100),
            FlowController.LimitExceededBehavior.Block,
            TEST_TRACE_ID,
            null,
            client.getSettings(),
            retrySettings);
    org.threeten.bp.Duration durationSleep = org.threeten.bp.Duration.ofSeconds(2);
    testBigQueryWrite.setResponseSleep(durationSleep);

    long appendCount = 2;
    for (int i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    // In total insert 'appendCount' requests,
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(
          sendTestMessage(
              connectionWorker, sw1, createFooProtoRows(new String[] {String.valueOf(i)}), i));
      assertEquals(connectionWorker.getLoad().inFlightRequestsCount(), i + 1);
    }

    for (int i = 0; i < appendCount; i++) {
      int finalI = i;
      ExecutionException ex =
          assertThrows(
              ExecutionException.class,
              () -> futures.get(finalI).get().getAppendResult().getOffset().getValue());
      if (i == 0) {
        assertThat(ex.getCause()).hasMessageThat().contains("Request has waited in inflight queue");
      } else {
        assertThat(ex.getCause()).hasMessageThat().contains("Connection is aborted due to ");
      }
    }

    // The future append will directly fail.
    ExecutionException ex =
        assertThrows(
            ExecutionException.class,
            () ->
                sendTestMessage(
                        connectionWorker,
                        sw1,
                        createFooProtoRows(new String[] {String.valueOf(100)}),
                        100)
                    .get());
    assertThat(ex.getCause()).hasMessageThat().contains("Request has waited in inflight queue");

    // Verify we can shutdown normally within the expected time.
    long startCloseTime = System.currentTimeMillis();
    connectionWorker.close();
    long timeDiff = System.currentTimeMillis() - startCloseTime;
    assertTrue(
        "timeDiff: "
            + timeDiff
            + " is more than total durationSleep: "
            + (appendCount * durationSleep.toMillis()),
        timeDiff <= (appendCount * durationSleep.toMillis()));
    assertTrue(connectionWorker.isUserClosed());
  }

  @Test
  public void testLongTimeIdleWontFail() throws Exception {
    ProtoSchema schema1 = createProtoSchema("foo");
    ConnectionWorker.setMaxInflightRequestWaitTime(Duration.ofSeconds(1));
    StreamWriter sw1 =
        StreamWriter.newBuilder(TEST_STREAM_1, client).setWriterSchema(schema1).build();
    ConnectionWorker connectionWorker =
        new ConnectionWorker(
            TEST_STREAM_1,
            null,
            createProtoSchema("foo"),
            100000,
            100000,
            Duration.ofSeconds(100),
            FlowController.LimitExceededBehavior.Block,
            TEST_TRACE_ID,
            null,
            client.getSettings(),
            retrySettings);

    long appendCount = 10;
    for (int i = 0; i < appendCount * 2; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }

    // In total insert 5 requests,
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    for (int i = 0; i < appendCount; i++) {
      futures.add(
          sendTestMessage(
              connectionWorker, sw1, createFooProtoRows(new String[] {String.valueOf(i)}), i));
    }
    // Sleep 2 seconds to make sure request queue is empty.
    Thread.sleep(2000);
    assertEquals(connectionWorker.getLoad().inFlightRequestsCount(), 0);
    for (int i = 0; i < appendCount; i++) {
      futures.add(
          sendTestMessage(
              connectionWorker,
              sw1,
              createFooProtoRows(new String[] {String.valueOf(i)}),
              i + appendCount));
    }
    for (int i = 0; i < appendCount * 2; i++) {
      assertEquals(i, futures.get(i).get().getAppendResult().getOffset().getValue());
    }
  }

  @Test
  public void testLocationName() throws Exception {
    assertEquals(
        "projects/p1/locations/us", ConnectionWorker.getRoutingHeader(TEST_STREAM_1, "us"));
  }
}
