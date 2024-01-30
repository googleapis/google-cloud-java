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
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.v1.ConnectionWorkerPool.Settings;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class ConnectionWorkerPoolTest {

  private FakeBigQueryWrite testBigQueryWrite;
  private FakeScheduledExecutorService fakeExecutor;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteSettings clientSettings;

  private static final String TEST_TRACE_ID = "DATAFLOW:job_id";
  private static final String TEST_STREAM_1 = "projects/p1/datasets/d1/tables/t1/streams/_default";
  private static final String TEST_STREAM_2 = "projects/p1/datasets/d1/tables/t2/streams/_default";
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

  @Before
  public void setUp() throws Exception {
    testBigQueryWrite = new FakeBigQueryWrite();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(testBigQueryWrite));
    serviceHelper.start();
    fakeExecutor = new FakeScheduledExecutorService();
    testBigQueryWrite.setExecutor(fakeExecutor);
    clientSettings =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
            .build();
    ConnectionWorker.Load.setOverwhelmedCountsThreshold(0.5);
    ConnectionWorker.Load.setOverwhelmedBytesThreshold(0.6);
  }

  @Test
  public void testSingleTableConnection_noOverwhelmedConnection() throws Exception {
    // Set the max requests count to a large value so we will not scaling up.
    testSendRequestsToMultiTable(
        /*requestToSend=*/ 100,
        /*maxRequests=*/ 100000,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 1,
        /*tableCount=*/ 1);
  }

  @Test
  public void testSingleTableConnections_overwhelmed() throws Exception {
    // A connection will be considered overwhelmed when the requests count reach 5 (max 10).
    testSendRequestsToMultiTable(
        /*requestToSend=*/ 100,
        /*maxRequests=*/ 10,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 8,
        /*tableCount=*/ 1);
  }

  @Test
  public void testMultiTableConnection_noOverwhelmedConnection() throws Exception {
    // Set the max requests count to a large value so we will not scaling up.
    // All tables will share the two connections (2 becasue we set the min connections to be 2).
    testSendRequestsToMultiTable(
        /*requestToSend=*/ 100,
        /*maxRequests=*/ 100000,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 2,
        /*tableCount=*/ 4);
  }

  @Test
  public void testMultiTableConnections_overwhelmed_reachingMaximum() throws Exception {
    // A connection will be considered overwhelmed when the requests count reach 5 (max 10).
    testSendRequestsToMultiTable(
        /*requestToSend=*/ 100,
        /*maxRequests=*/ 10,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 8,
        /*tableCount=*/ 4);
  }

  @Test
  public void testMultiTableConnections_overwhelmed_overTotalLimit() throws Exception {
    // A connection will be considered overwhelmed when the requests count reach 5 (max 10).
    testSendRequestsToMultiTable(
        /*requestToSend=*/ 200,
        /*maxRequests=*/ 10,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 8,
        /*tableCount=*/ 10);
  }

  @Test
  public void testMultiTableConnections_overwhelmed_notReachingMaximum() throws Exception {
    // A connection will be considered overwhelmed when the requests count reach 5 (max 10).
    testSendRequestsToMultiTable(
        /*requestToSend=*/ 20,
        /*maxRequests=*/ 10,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 4,
        /*tableCount=*/ 4);
  }

  private void testSendRequestsToMultiTable(
      int requestToSend,
      int maxRequests,
      int maxConnections,
      int expectedConnectionCount,
      int tableCount)
      throws IOException, ExecutionException, InterruptedException {
    ConnectionWorkerPool.setOptions(
        Settings.builder()
            .setMinConnectionsPerRegion(2)
            .setMaxConnectionsPerRegion(maxConnections)
            .build());
    ConnectionWorkerPool connectionWorkerPool =
        createConnectionWorkerPool(
            maxRequests, /*maxBytes=*/ 100000, java.time.Duration.ofSeconds(5));

    // Sets the sleep time to simulate requests stuck in connection.
    testBigQueryWrite.setResponseSleep(Duration.ofMillis(50L));

    // Try append 100 requests.
    long appendCount = requestToSend;
    for (long i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();

    // Create one stream writer per table.
    List<StreamWriter> streamWriterList = new ArrayList<>();
    for (int i = 0; i < tableCount; i++) {
      streamWriterList.add(
          getTestStreamWriter(
              String.format("projects/p1/datasets/d1/tables/t%s/streams/_default", i)));
    }

    for (long i = 0; i < appendCount; i++) {
      // Round robinly insert requests to different tables.
      futures.add(
          sendFooStringTestMessage(
              streamWriterList.get((int) (i % streamWriterList.size())),
              connectionWorkerPool,
              new String[] {String.valueOf(i)},
              i));
    }

    for (int i = 0; i < appendCount; i++) {
      AppendRowsResponse response = futures.get(i).get();
      assertThat(response.getAppendResult().getOffset().getValue()).isEqualTo(i);
    }
    // At the end we should scale up to 8 connections.
    assertThat(connectionWorkerPool.getCreateConnectionCount()).isEqualTo(expectedConnectionCount);

    assertThat(testBigQueryWrite.getAppendRequests().size()).isEqualTo(appendCount);
    // The request order server received is no longer guaranteed,
    HashSet<Long> offsets = new HashSet<>();
    for (int i = 0; i < appendCount; i++) {
      AppendRowsRequest serverRequest = testBigQueryWrite.getAppendRequests().get(i);
      assertThat(serverRequest.getProtoRows().getRows().getSerializedRowsCount()).isGreaterThan(0);
      offsets.add(serverRequest.getOffset().getValue());
    }
    assertThat(offsets.size()).isEqualTo(appendCount);
  }

  @Test
  public void testMultiStreamClosed_multiplexingEnabled() throws Exception {
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMaxConnectionsPerRegion(10).setMinConnectionsPerRegion(5).build());
    ConnectionWorkerPool connectionWorkerPool =
        createConnectionWorkerPool(
            /*maxRequests=*/ 3, /*maxBytes=*/ 1000, java.time.Duration.ofSeconds(5));

    // Sets the sleep time to simulate requests stuck in connection.
    testBigQueryWrite.setResponseSleep(Duration.ofMillis(50L));
    StreamWriter writeStream1 = getTestStreamWriter(TEST_STREAM_1);
    StreamWriter writeStream2 = getTestStreamWriter(TEST_STREAM_2);

    // Try append 20 requests, at the end we should have 2 requests per connection.
    long appendCount = 20;
    for (long i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }
    List<ApiFuture<?>> futures = new ArrayList<>();

    // We will start inserting to two tables interferely.
    // The final status of each connection queue will be
    // (s1 is the request coming from writeStream 1, etc):
    // c1: [s1, s1], c2: [s2, s2], c3: [s1, s1], c4: [s2, s2]
    // c5 - c10: [s1, s2]
    for (int i = 0; i < appendCount; i++) {
      StreamWriter writeStream = i % 2 == 0 ? writeStream1 : writeStream2;
      futures.add(
          sendFooStringTestMessage(
              writeStream, connectionWorkerPool, new String[] {String.valueOf(i)}, i));
    }

    for (ApiFuture<?> future : futures) {
      future.get();
    }
    // At the end we should scale up to 10 connections.
    assertThat(connectionWorkerPool.getCreateConnectionCount()).isEqualTo(10);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(10);

    // Start testing calling close on each stream.
    // When we close the first stream, only the connection that only serve stream 1 will be closed.
    // for which c1 and c3 are closed.
    connectionWorkerPool.close(writeStream1);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(8);

    // The next time we call close, every connection will be closed.
    connectionWorkerPool.close(writeStream2);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(0);
  }

  @Test
  public void testMultiStreamAppend_appendWhileClosing() throws Exception {
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMaxConnectionsPerRegion(10).setMinConnectionsPerRegion(5).build());
    ConnectionWorkerPool connectionWorkerPool =
        createConnectionWorkerPool(
            /*maxRequests=*/ 3, /*maxBytes=*/ 100000, java.time.Duration.ofSeconds(5));

    // Sets the sleep time to simulate requests stuck in connection.
    testBigQueryWrite.setResponseSleep(Duration.ofMillis(50L));
    StreamWriter writeStream1 = getTestStreamWriter(TEST_STREAM_1);
    StreamWriter writeStream2 = getTestStreamWriter(TEST_STREAM_2);

    // Try append 10 requests, at the end we should have 2 requests per connection, and 5
    // connections created.
    long appendCount = 10;
    for (long i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }
    List<ApiFuture<?>> futures = new ArrayList<>();

    // 1. We will start inserting to two tables interferely.
    // The final status of each connection queue will be
    // (s1 is the request coming from writeStream 1, etc):
    // c1: [s1, s1], c2: [s2, s2], c3: [s1, s1], c4: [s2, s2], c5: [s1, s2]
    for (int i = 0; i < appendCount; i++) {
      StreamWriter writeStream = i % 2 == 0 ? writeStream1 : writeStream2;
      futures.add(
          sendFooStringTestMessage(
              writeStream, connectionWorkerPool, new String[] {String.valueOf(i)}, i));
    }
    assertThat(connectionWorkerPool.getCreateConnectionCount()).isEqualTo(5);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(5);

    // 2. Close one of the stream, after this close, since we will wait for the waiting queue to be
    // drained in c1 and c3, at the same time the other queue should also be drained.
    connectionWorkerPool.close(writeStream1);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(3);
    // Sleep 1 second to make sure every message is drained.
    Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

    // 3. Insert another batch of messages, since every connection has no in flight messages
    // we should be able to reuse the previous 5 connections.
    for (int i = 0; i < appendCount; i++) {
      StreamWriter writeStream = i % 2 == 0 ? writeStream1 : writeStream2;
      futures.add(
          sendFooStringTestMessage(
              writeStream, connectionWorkerPool, new String[] {String.valueOf(i)}, i));
    }
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(5);
    for (ApiFuture<?> future : futures) {
      future.get();
    }

    // 4. Close write stream 1. Two connections associated with it will be closed.
    connectionWorkerPool.close(writeStream1);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(3);

    // 5. Close write stream 2, all should be closed.
    connectionWorkerPool.close(writeStream2);
    assertThat(connectionWorkerPool.getTotalConnectionCount()).isEqualTo(0);
  }

  @Test
  public void testCloseWhileAppending_noDeadlockHappen() throws Exception {
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMaxConnectionsPerRegion(10).setMinConnectionsPerRegion(5).build());
    ConnectionWorkerPool connectionWorkerPool =
        createConnectionWorkerPool(
            /*maxRequests=*/ 1500, /*maxBytes=*/ 100000, java.time.Duration.ofSeconds(5));

    // Sets the sleep time to simulate requests stuck in connection.
    testBigQueryWrite.setResponseSleep(Duration.ofMillis(20L));
    StreamWriter writeStream1 = getTestStreamWriter(TEST_STREAM_1);

    ListeningExecutorService threadPool =
        MoreExecutors.listeningDecorator(
            Executors.newCachedThreadPool(
                new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .setNameFormat("AsyncStreamReadThread")
                    .build()));

    long appendCount = 10;
    for (long i = 0; i < appendCount; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }
    List<Future<?>> futures = new ArrayList<>();

    for (int i = 0; i < 500; i++) {
      futures.add(
          threadPool.submit(
              () -> {
                sendFooStringTestMessage(
                    writeStream1, connectionWorkerPool, new String[] {String.valueOf(0)}, 0);
              }));
    }
    connectionWorkerPool.close(writeStream1);
    for (int i = 0; i < 500; i++) {
      futures.get(i).get();
    }
  }

  private class DummySupplierWillFailNTimesThenSucceed
      implements Supplier<FakeBigQueryWriteImpl.Response> {
    private int failCount;
    private final Status.Code errorCode;
    private final String errorMessage;
    private final int successOffset;

    DummySupplierWillFailNTimesThenSucceed(
        int failCount, Status.Code errorCode, String errorMessage, int successOffset) {
      this.failCount = failCount;
      this.errorCode = errorCode;
      this.errorMessage = errorMessage;
      this.successOffset = successOffset;
    }

    @Override
    public FakeBigQueryWriteImpl.Response get() {
      if (failCount <= 0) {
        return new FakeBigQueryWriteImpl.Response(createAppendResponse(successOffset));
      }
      failCount--;
      return new FakeBigQueryWriteImpl.Response(
          createAppendResponseWithError(errorCode, errorMessage));
    }
  }

  @Test
  public void testAppendWithRetry() throws Exception {
    ConnectionWorkerPool connectionWorkerPool =
        createConnectionWorkerPool(
            /*maxRequests=*/ 1500, /*maxBytes=*/ 100000, java.time.Duration.ofSeconds(5));

    StreamWriter writeStream1 = getTestStreamWriter(TEST_STREAM_1);

    // Simulate the maximum allowable failures, followed by success.
    testBigQueryWrite.addResponse(
        new DummySupplierWillFailNTimesThenSucceed(
            MAX_RETRY_NUM_ATTEMPTS, Status.RESOURCE_EXHAUSTED.getCode(), "test quota error A", 0));
    testBigQueryWrite.addResponse(
        new DummySupplierWillFailNTimesThenSucceed(
            MAX_RETRY_NUM_ATTEMPTS - 1,
            Status.RESOURCE_EXHAUSTED.getCode(),
            "test quota error B",
            1));
    testBigQueryWrite.addResponse(createAppendResponse(2));

    List<Future<?>> futures = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      futures.add(
          sendFooStringTestMessage(
              writeStream1, connectionWorkerPool, new String[] {String.valueOf(i)}, i));
    }
    for (int i = 0; i < 3; i++) {
      futures.get(i).get();
    }
    connectionWorkerPool.close(writeStream1);
  }

  @Test
  public void testToTableName() {
    assertThat(ConnectionWorkerPool.toTableName("projects/p/datasets/d/tables/t/streams/s"))
        .isEqualTo("projects/p/datasets/d/tables/t");

    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class, () -> ConnectionWorkerPool.toTableName("projects/p/"));
  }

  @Test
  public void testCloseExternalClient()
      throws IOException, InterruptedException, ExecutionException {
    StreamWriter.clearConnectionPool();
    // Try append 100 requests.
    long appendCount = 100L;
    // testBigQueryWrite is used to
    for (long i = 0; i < appendCount * 2; i++) {
      testBigQueryWrite.addResponse(createAppendResponse(i));
    }
    testBigQueryWrite.addResponse(WriteStream.newBuilder().setLocation("us").build());
    List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
    BigQueryWriteClient externalClient =
        BigQueryWriteClient.create(
            BigQueryWriteSettings.newBuilder()
                .setCredentialsProvider(NoCredentialsProvider.create())
                .setTransportChannelProvider(serviceHelper.createChannelProvider())
                .build());
    // Create some stream writers.
    List<StreamWriter> streamWriterList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      streamWriterList.add(
          StreamWriter.newBuilder(
                  String.format("projects/p1/datasets/d1/tables/t%s/streams/_default", i),
                  externalClient)
              .setEnableConnectionPool(true)
              .setWriterSchema(createProtoSchema())
              .setTraceId(TEST_TRACE_ID)
              .setLocation("us")
              .setRetrySettings(retrySettings)
              .build());
    }

    for (long i = 0; i < appendCount; i++) {
      StreamWriter sw = streamWriterList.get((int) (i % streamWriterList.size()));
      // Round robinly insert requests to different tables.
      futures.add(sw.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }
    externalClient.close();
    externalClient.awaitTermination(1, TimeUnit.MINUTES);
    // Send more requests, the connections should still work.
    for (long i = appendCount; i < appendCount * 2; i++) {
      StreamWriter sw = streamWriterList.get((int) (i % streamWriterList.size()));
      futures.add(sw.append(createProtoRows(new String[] {String.valueOf(i)}), i));
    }
    for (int i = 0; i < appendCount * 2; i++) {
      AppendRowsResponse response = futures.get(i).get();
      assertThat(response.getAppendResult().getOffset().getValue()).isEqualTo(i);
    }
    assertThat(testBigQueryWrite.getAppendRequests().size()).isEqualTo(appendCount * 2);
    for (int i = 0; i < streamWriterList.size(); i++) {
      streamWriterList.get(i).close();
    }
    StreamWriter.clearConnectionPool();
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

  private StreamWriter getTestStreamWriter(String streamName) throws IOException {
    return StreamWriter.newBuilder(streamName)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
        .setLocation("us")
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setChannelProvider(serviceHelper.createChannelProvider())
        .build();
  }

  private ProtoSchema createProtoSchema() {
    return ProtoSchema.newBuilder()
        .setProtoDescriptor(
            DescriptorProtos.DescriptorProto.newBuilder()
                .setName("Message")
                .addField(
                    DescriptorProtos.FieldDescriptorProto.newBuilder()
                        .setName("foo")
                        .setType(DescriptorProtos.FieldDescriptorProto.Type.TYPE_STRING)
                        .setNumber(1)
                        .build())
                .build())
        .build();
  }

  private ApiFuture<AppendRowsResponse> sendFooStringTestMessage(
      StreamWriter writeStream,
      ConnectionWorkerPool connectionWorkerPool,
      String[] messages,
      long offset) {
    return connectionWorkerPool.append(writeStream, createProtoRows(messages), offset);
  }

  private ProtoRows createProtoRows(String[] messages) {
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    for (String message : messages) {
      FooType foo = FooType.newBuilder().setFoo(message).build();
      rowsBuilder.addSerializedRows(foo.toByteString());
    }
    return rowsBuilder.build();
  }

  ConnectionWorkerPool createConnectionWorkerPool(
      long maxRequests, long maxBytes, java.time.Duration maxRetryDuration) {
    ConnectionWorkerPool.enableTestingLogic();
    return new ConnectionWorkerPool(
        maxRequests,
        maxBytes,
        maxRetryDuration,
        FlowController.LimitExceededBehavior.Block,
        TEST_TRACE_ID,
        null,
        clientSettings,
        retrySettings);
  }
}
