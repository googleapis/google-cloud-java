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

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.v1.ConnectionWorkerPool.Settings;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Int64Value;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
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
  private BigQueryWriteClient client;

  private static final String TEST_TRACE_ID = "home:job1";
  private static final String TEST_STREAM_1 = "projects/p1/datasets/d1/tables/t1/streams/_default";
  private static final String TEST_STREAM_2 = "projects/p1/datasets/d1/tables/t2/streams/_default";

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
  }

  @Test
  public void testSingleTableConnection_noOverwhelmedConnection() throws Exception {
    // Set the max requests count to a large value so we will not scaling up.
    testSend100RequestsToMultiTable(
        /*maxRequests=*/ 100000,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 1,
        /*tableCount=*/ 1);
  }

  @Test
  public void testSingleTableConnections_overwhelmed() throws Exception {
    // A connection will be considered overwhelmed when the requests count reach 5 (max 10).
    testSend100RequestsToMultiTable(
        /*maxRequests=*/ 10,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 8,
        /*tableCount=*/ 1);
  }

  @Test
  public void testMultiTableConnection_noOverwhelmedConnection() throws Exception {
    // Set the max requests count to a large value so we will not scaling up.
    // All tables will share the two connections (2 becasue we set the min connections to be 2).
    testSend100RequestsToMultiTable(
        /*maxRequests=*/ 100000,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 2,
        /*tableCount=*/ 4);
  }

  @Test
  public void testMultiTableConnections_overwhelmed() throws Exception {
    // A connection will be considered overwhelmed when the requests count reach 5 (max 10).
    testSend100RequestsToMultiTable(
        /*maxRequests=*/ 10,
        /*maxConnections=*/ 8,
        /*expectedConnectionCount=*/ 8,
        /*tableCount=*/ 4);
  }

  private void testSend100RequestsToMultiTable(
      int maxRequests, int maxConnections, int expectedConnectionCount, int tableCount)
      throws IOException, ExecutionException, InterruptedException {
    ConnectionWorkerPool connectionWorkerPool =
        createConnectionWorkerPool(maxRequests, /*maxBytes=*/ 100000);
    ConnectionWorkerPool.setOptions(
        Settings.builder().setMaxConnectionsPerPool(maxConnections).build());

    // Sets the sleep time to simulate requests stuck in connection.
    testBigQueryWrite.setResponseSleep(Duration.ofMillis(50L));

    // Try append 100 requests.
    long appendCount = 100;
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

  private AppendRowsResponse createAppendResponse(long offset) {
    return AppendRowsResponse.newBuilder()
        .setAppendResult(
            AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(offset)).build())
        .build();
  }

  private StreamWriter getTestStreamWriter(String streamName) throws IOException {
    return StreamWriter.newBuilder(streamName, client)
        .setWriterSchema(createProtoSchema())
        .setTraceId(TEST_TRACE_ID)
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

  ConnectionWorkerPool createConnectionWorkerPool(long maxRequests, long maxBytes) {
    ConnectionWorkerPool.enableTestingLogic();
    return new ConnectionWorkerPool(
        maxRequests,
        maxBytes,
        FlowController.LimitExceededBehavior.Block,
        TEST_TRACE_ID,
        client,
        /*ownsBigQueryWriteClient=*/ false);
  }
}
