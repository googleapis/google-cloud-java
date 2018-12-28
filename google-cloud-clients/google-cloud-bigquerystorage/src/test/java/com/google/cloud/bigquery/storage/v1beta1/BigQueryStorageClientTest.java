/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.cloud.bigquery.storage.v1beta1.TableReferenceProto.TableReference;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BigQueryStorageClientTest {
  private static MockBigQueryStorage mockBigQueryStorage;
  private static MockServiceHelper serviceHelper;
  private BigQueryStorageClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryStorage = new MockBigQueryStorage();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockBigQueryStorage));
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
    BigQueryStorageSettings settings =
        BigQueryStorageSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BigQueryStorageClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createReadSessionTest() {
    String name = "name3373707";
    ReadSession expectedResponse = ReadSession.newBuilder().setName(name).build();
    mockBigQueryStorage.addResponse(expectedResponse);

    TableReference tableReference = TableReference.newBuilder().build();
    String parent = "parent-995424086";
    int requestedStreams = 1017221410;

    ReadSession actualResponse = client.createReadSession(tableReference, parent, requestedStreams);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = (CreateReadSessionRequest) actualRequests.get(0);

    Assert.assertEquals(tableReference, actualRequest.getTableReference());
    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createReadSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      TableReference tableReference = TableReference.newBuilder().build();
      String parent = "parent-995424086";
      int requestedStreams = 1017221410;

      client.createReadSession(tableReference, parent, requestedStreams);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsTest() throws Exception {
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);
    StreamPosition readPosition = StreamPosition.newBuilder().build();
    ReadRowsRequest request = ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);
    StreamPosition readPosition = StreamPosition.newBuilder().build();
    ReadRowsRequest request = ReadRowsRequest.newBuilder().setReadPosition(readPosition).build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateReadSessionStreamsTest() {
    BatchCreateReadSessionStreamsResponse expectedResponse =
        BatchCreateReadSessionStreamsResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    ReadSession session = ReadSession.newBuilder().build();
    int requestedStreams = 1017221410;

    BatchCreateReadSessionStreamsResponse actualResponse =
        client.batchCreateReadSessionStreams(session, requestedStreams);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateReadSessionStreamsRequest actualRequest =
        (BatchCreateReadSessionStreamsRequest) actualRequests.get(0);

    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void batchCreateReadSessionStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      ReadSession session = ReadSession.newBuilder().build();
      int requestedStreams = 1017221410;

      client.batchCreateReadSessionStreams(session, requestedStreams);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void finalizeStreamTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Stream stream = Stream.newBuilder().build();

    client.finalizeStream(stream);

    List<GeneratedMessageV3> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FinalizeStreamRequest actualRequest = (FinalizeStreamRequest) actualRequests.get(0);

    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void finalizeStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      Stream stream = Stream.newBuilder().build();

      client.finalizeStream(stream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void splitReadStreamTest() {
    SplitReadStreamResponse expectedResponse = SplitReadStreamResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Stream originalStream = Stream.newBuilder().build();

    SplitReadStreamResponse actualResponse = client.splitReadStream(originalStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SplitReadStreamRequest actualRequest = (SplitReadStreamRequest) actualRequests.get(0);

    Assert.assertEquals(originalStream, actualRequest.getOriginalStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void splitReadStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      Stream originalStream = Stream.newBuilder().build();

      client.splitReadStream(originalStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
