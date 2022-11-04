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
import com.google.cloud.bigquery.storage.test.Test.ComplicateType;
import com.google.cloud.bigquery.storage.test.Test.FooType;
import com.google.cloud.bigquery.storage.test.Test.InnerType;
import com.google.cloud.bigquery.storage.v1.ConnectionWorker.Load;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Int64Value;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionWorkerTest {
  private static final String TEST_STREAM_1 = "projects/p1/datasets/d1/tables/t1/streams/s1";
  private static final String TEST_STREAM_2 = "projects/p2/datasets/d2/tables/t2/streams/s2";
  private static final String TEST_TRACE_ID = "DATAFLOW:job_id";

  private FakeBigQueryWrite testBigQueryWrite;
  private FakeScheduledExecutorService fakeExecutor;
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
  }

  @Test
  public void testMultiplexedAppendSuccess() throws Exception {
    try (ConnectionWorker connectionWorker = createConnectionWorker()) {
      long appendCount = 20;
      for (long i = 0; i < appendCount; i++) {
        testBigQueryWrite.addResponse(createAppendResponse(i));
      }
      List<ApiFuture<AppendRowsResponse>> futures = new ArrayList<>();
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
                    TEST_STREAM_1,
                    createProtoSchema("foo"),
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          case 2:
          case 3:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    TEST_STREAM_2,
                    createProtoSchema("complicate"),
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
      for (long i = 0; i < appendCount; i++) {
        switch ((int) i % 4) {
          case 0:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    TEST_STREAM_1,
                    schema1,
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          case 1:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    TEST_STREAM_1,
                    schema2,
                    createFooProtoRows(new String[] {String.valueOf(i)}),
                    i));
            break;
          case 2:
          case 3:
            futures.add(
                sendTestMessage(
                    connectionWorker,
                    TEST_STREAM_1,
                    schema3,
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
        // (writer_stream: _, schema: schema3)
        // (writer_stream: _, schema: _)
        // (writer_stream: _, schema: schema1)
        // (writer_stream: _, schema: _)
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
            assertThat(serverRequest.getWriteStream()).isEmpty();
            // Schema is empty if not at the first request after table switch.
            assertThat(serverRequest.getProtoRows().hasWriterSchema()).isFalse();
            break;
          case 2:
            assertThat(serverRequest.getWriteStream()).isEmpty();
            // Schema is populated after table switch.
            assertThat(
                    serverRequest.getProtoRows().getWriterSchema().getProtoDescriptor().getName())
                .isEqualTo("bar");
            break;
          case 3:
            assertThat(serverRequest.getWriteStream()).isEmpty();
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

  private AppendRowsResponse createAppendResponse(long offset) {
    return AppendRowsResponse.newBuilder()
        .setAppendResult(
            AppendRowsResponse.AppendResult.newBuilder().setOffset(Int64Value.of(offset)).build())
        .build();
  }

  private ConnectionWorker createConnectionWorker() throws IOException {
    // By default use only the first table as table reference.
    return createConnectionWorker(TEST_STREAM_1, TEST_TRACE_ID, 100, 1000);
  }

  private ConnectionWorker createConnectionWorker(
      String streamName, String traceId, long maxRequests, long maxBytes) throws IOException {
    return new ConnectionWorker(
        streamName,
        createProtoSchema("foo"),
        maxRequests,
        maxBytes,
        FlowController.LimitExceededBehavior.Block,
        TEST_TRACE_ID,
        client,
        /*ownsBigQueryWriteClient=*/ false);
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
      String streamName,
      ProtoSchema protoSchema,
      ProtoRows protoRows,
      long offset) {
    return connectionWorker.append(streamName, protoSchema, protoRows, offset);
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
}
