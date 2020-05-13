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
package com.google.cloud.bigquery.storage.v1alpha2;

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
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FlushRowsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FlushRowsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.GetWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Stream.WriteStream;
import com.google.protobuf.AbstractMessage;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class BigQueryWriteClientTest {
  private static MockBigQueryWrite mockBigQueryWrite;
  private static MockServiceHelper serviceHelper;
  private BigQueryWriteClient client;
  private LocalChannelProvider channelProvider;

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
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createWriteStreamTest() {
    WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
    String externalId = "externalId-1153075697";
    WriteStream expectedResponse =
        WriteStream.newBuilder().setName(name.toString()).setExternalId(externalId).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
    WriteStream writeStream = WriteStream.newBuilder().build();

    WriteStream actualResponse = client.createWriteStream(parent, writeStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateWriteStreamRequest actualRequest = (CreateWriteStreamRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TableName.parse(actualRequest.getParent()));
    Assert.assertEquals(writeStream, actualRequest.getWriteStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createWriteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
      WriteStream writeStream = WriteStream.newBuilder().build();

      client.createWriteStream(parent, writeStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void appendRowsTest() throws Exception {
    long offset = 1019779949L;
    AppendRowsResponse expectedResponse = AppendRowsResponse.newBuilder().setOffset(offset).build();
    mockBigQueryWrite.addResponse(expectedResponse);
    WriteStreamName writeStream =
        WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
    AppendRowsRequest request =
        AppendRowsRequest.newBuilder().setWriteStream(writeStream.toString()).build();

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
  @SuppressWarnings("all")
  public void appendRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);
    WriteStreamName writeStream =
        WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
    AppendRowsRequest request =
        AppendRowsRequest.newBuilder().setWriteStream(writeStream.toString()).build();

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
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getWriteStreamTest() {
    WriteStreamName name2 = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");
    String externalId = "externalId-1153075697";
    WriteStream expectedResponse =
        WriteStream.newBuilder().setName(name2.toString()).setExternalId(externalId).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

    WriteStream actualResponse = client.getWriteStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetWriteStreamRequest actualRequest = (GetWriteStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, WriteStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getWriteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

      client.getWriteStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void finalizeWriteStreamTest() {
    long rowCount = 1340416618L;
    FinalizeWriteStreamResponse expectedResponse =
        FinalizeWriteStreamResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

    FinalizeWriteStreamResponse actualResponse = client.finalizeWriteStream(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinalizeWriteStreamRequest actualRequest = (FinalizeWriteStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, WriteStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void finalizeWriteStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      WriteStreamName name = WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

      client.finalizeWriteStream(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCommitWriteStreamsTest() {
    BatchCommitWriteStreamsResponse expectedResponse =
        BatchCommitWriteStreamsResponse.newBuilder().build();
    mockBigQueryWrite.addResponse(expectedResponse);

    TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");

    BatchCommitWriteStreamsResponse actualResponse = client.batchCommitWriteStreams(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCommitWriteStreamsRequest actualRequest =
        (BatchCommitWriteStreamsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, TableName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCommitWriteStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      TableName parent = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");

      client.batchCommitWriteStreams(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void flushRowsTest() {
    long offset = 1019779949L;
    FlushRowsResponse expectedResponse = FlushRowsResponse.newBuilder().setOffset(offset).build();
    mockBigQueryWrite.addResponse(expectedResponse);

    WriteStreamName writeStream =
        WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

    FlushRowsResponse actualResponse = client.flushRows(writeStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryWrite.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FlushRowsRequest actualRequest = (FlushRowsRequest) actualRequests.get(0);

    Assert.assertEquals(writeStream, WriteStreamName.parse(actualRequest.getWriteStream()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void flushRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryWrite.addException(exception);

    try {
      WriteStreamName writeStream =
          WriteStreamName.of("[PROJECT]", "[DATASET]", "[TABLE]", "[STREAM]");

      client.flushRows(writeStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
