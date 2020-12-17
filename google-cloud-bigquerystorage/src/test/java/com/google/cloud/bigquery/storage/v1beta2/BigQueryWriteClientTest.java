/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BigQueryWriteClientTest {
  private static MockServiceHelper mockServiceHelper;
  private BigQueryWriteClient client;
  private LocalChannelProvider channelProvider;
  private static MockBigQueryWrite mockBigQueryWrite;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryWrite = new MockBigQueryWrite();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryWrite));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    BigQueryWriteSettings settings =
        BigQueryWriteSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigQueryWriteClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createWriteStreamTest() throws Exception {
    WriteStream expectedResponse =
        WriteStream.newBuilder()
            .setName(WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCommitTime(Timestamp.newBuilder().build())
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
    WriteStream writeStream = WriteStream.newBuilder().build();

    WriteStream actualResponse = client.createWriteStream(parent, writeStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWriteStreamRequest actualRequest = ((CreateWriteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(writeStream, actualRequest.getWriteStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWriteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
      WriteStream writeStream = WriteStream.newBuilder().build();
      client.createWriteStream(parent, writeStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createWriteStreamTest2() throws Exception {
    WriteStream expectedResponse =
        WriteStream.newBuilder()
            .setName(WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCommitTime(Timestamp.newBuilder().build())
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    String parent = "parent-995424086";
    WriteStream writeStream = WriteStream.newBuilder().build();

    WriteStream actualResponse = client.createWriteStream(parent, writeStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWriteStreamRequest actualRequest = ((CreateWriteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(writeStream, actualRequest.getWriteStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createWriteStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      String parent = "parent-995424086";
      WriteStream writeStream = WriteStream.newBuilder().build();
      client.createWriteStream(parent, writeStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void appendRowsTest() throws Exception {
    AppendRowsResponse expectedResponse =
        AppendRowsResponse.newBuilder().setUpdatedSchema(TableSchema.newBuilder().build()).build();
    mockBigQueryWrite.addResponse(expectedResponse);
    AppendRowsRequest request =
        AppendRowsRequest.newBuilder()
            .setWriteStream(
                WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
            .setOffset(Int64Value.newBuilder().build())
            .setTraceId("traceId-1067401920")
            .build();

    MockStreamObserver<AppendRowsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> callable =
        client.appendRowsCallable();
    ApiStreamObserver<AppendRowsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<AppendRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void appendRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);
    AppendRowsRequest request =
        AppendRowsRequest.newBuilder()
            .setWriteStream(
                WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
            .setOffset(Int64Value.newBuilder().build())
            .setTraceId("traceId-1067401920")
            .build();

    MockStreamObserver<AppendRowsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> callable =
        client.appendRowsCallable();
    ApiStreamObserver<AppendRowsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<AppendRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getWriteStreamTest() throws Exception {
    WriteStream expectedResponse =
        WriteStream.newBuilder()
            .setName(WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCommitTime(Timestamp.newBuilder().build())
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

    WriteStream actualResponse = client.getWriteStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWriteStreamRequest actualRequest = ((GetWriteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWriteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
      client.getWriteStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getWriteStreamTest2() throws Exception {
    WriteStream expectedResponse =
        WriteStream.newBuilder()
            .setName(WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCommitTime(Timestamp.newBuilder().build())
            .setTableSchema(TableSchema.newBuilder().build())
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    String name = "name3373707";

    WriteStream actualResponse = client.getWriteStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWriteStreamRequest actualRequest = ((GetWriteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getWriteStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      String name = "name3373707";
      client.getWriteStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void finalizeWriteStreamTest() throws Exception {
    FinalizeWriteStreamResponse expectedResponse =
        FinalizeWriteStreamResponse.newBuilder().setRowCount(1340416618).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

    FinalizeWriteStreamResponse actualResponse = client.finalizeWriteStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinalizeWriteStreamRequest actualRequest = ((FinalizeWriteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void finalizeWriteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
      client.finalizeWriteStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void finalizeWriteStreamTest2() throws Exception {
    FinalizeWriteStreamResponse expectedResponse =
        FinalizeWriteStreamResponse.newBuilder().setRowCount(1340416618).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    String name = "name3373707";

    FinalizeWriteStreamResponse actualResponse = client.finalizeWriteStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinalizeWriteStreamRequest actualRequest = ((FinalizeWriteStreamRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void finalizeWriteStreamExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      String name = "name3373707";
      client.finalizeWriteStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCommitWriteStreamsTest() throws Exception {
    BatchCommitWriteStreamsResponse expectedResponse =
        BatchCommitWriteStreamsResponse.newBuilder()
            .setCommitTime(Timestamp.newBuilder().build())
            .addAllStreamErrors(new ArrayList<StorageError>())
            .build();
    mockBigQueryWrite.addResponse(expectedResponse);

    String parent = "parent-995424086";

    BatchCommitWriteStreamsResponse actualResponse = client.batchCommitWriteStreams(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCommitWriteStreamsRequest actualRequest =
        ((BatchCommitWriteStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCommitWriteStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      String parent = "parent-995424086";
      client.batchCommitWriteStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void flushRowsTest() throws Exception {
    FlushRowsResponse expectedResponse =
        FlushRowsResponse.newBuilder().setOffset(-1019779949).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    WriteStreamName writeStream =
        WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

    FlushRowsResponse actualResponse = client.flushRows(writeStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FlushRowsRequest actualRequest = ((FlushRowsRequest) actualRequests.get(0));

    Assert.assertEquals(writeStream.toString(), actualRequest.getWriteStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void flushRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      WriteStreamName writeStream =
          WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
      client.flushRows(writeStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void flushRowsTest2() throws Exception {
    FlushRowsResponse expectedResponse =
        FlushRowsResponse.newBuilder().setOffset(-1019779949).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    String writeStream = "writeStream1412231231";

    FlushRowsResponse actualResponse = client.flushRows(writeStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FlushRowsRequest actualRequest = ((FlushRowsRequest) actualRequests.get(0));

    Assert.assertEquals(writeStream, actualRequest.getWriteStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void flushRowsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      String writeStream = "writeStream1412231231";
      client.flushRows(writeStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
