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
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class BaseBigQueryStorageClientTest {
  private static MockBigQueryStorage mockBigQueryStorage;
  private static MockServiceHelper mockServiceHelper;
  private BaseBigQueryStorageClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryStorage = new MockBigQueryStorage();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryStorage));
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
    BaseBigQueryStorageSettings settings =
        BaseBigQueryStorageSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BaseBigQueryStorageClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createReadSessionTest() throws Exception {
    Storage.ReadSession expectedResponse = Storage.ReadSession.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    TableReferenceProto.TableReference tableReference =
        TableReferenceProto.TableReference.newBuilder().build();
    ProjectName parent = ProjectName.of("[PROJECT]");
    int requestedStreams = 1017221410;

    Storage.ReadSession actualResponse =
        client.createReadSession(tableReference, parent, requestedStreams);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Storage.CreateReadSessionRequest actualRequest =
        ((Storage.CreateReadSessionRequest) actualRequests.get(0));

    Assert.assertEquals(tableReference, actualRequest.getTableReference());
    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReadSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      TableReferenceProto.TableReference tableReference =
          TableReferenceProto.TableReference.newBuilder().build();
      ProjectName parent = ProjectName.of("[PROJECT]");
      int requestedStreams = 1017221410;
      client.createReadSession(tableReference, parent, requestedStreams);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReadSessionTest2() throws Exception {
    Storage.ReadSession expectedResponse = Storage.ReadSession.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    TableReferenceProto.TableReference tableReference =
        TableReferenceProto.TableReference.newBuilder().build();
    String parent = "parent-995424086";
    int requestedStreams = 1017221410;

    Storage.ReadSession actualResponse =
        client.createReadSession(tableReference, parent, requestedStreams);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Storage.CreateReadSessionRequest actualRequest =
        ((Storage.CreateReadSessionRequest) actualRequests.get(0));

    Assert.assertEquals(tableReference, actualRequest.getTableReference());
    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReadSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      TableReferenceProto.TableReference tableReference =
          TableReferenceProto.TableReference.newBuilder().build();
      String parent = "parent-995424086";
      int requestedStreams = 1017221410;
      client.createReadSession(tableReference, parent, requestedStreams);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readRowsTest() throws Exception {
    Storage.ReadRowsResponse expectedResponse = Storage.ReadRowsResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);
    Storage.ReadRowsRequest request = Storage.ReadRowsRequest.newBuilder().build();

    MockStreamObserver<Storage.ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<Storage.ReadRowsRequest, Storage.ReadRowsResponse> callable =
        client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<Storage.ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);
    Storage.ReadRowsRequest request = Storage.ReadRowsRequest.newBuilder().build();

    MockStreamObserver<Storage.ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<Storage.ReadRowsRequest, Storage.ReadRowsResponse> callable =
        client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<Storage.ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchCreateReadSessionStreamsTest() throws Exception {
    Storage.BatchCreateReadSessionStreamsResponse expectedResponse =
        Storage.BatchCreateReadSessionStreamsResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Storage.ReadSession session = Storage.ReadSession.newBuilder().build();
    int requestedStreams = 1017221410;

    Storage.BatchCreateReadSessionStreamsResponse actualResponse =
        client.batchCreateReadSessionStreams(session, requestedStreams);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Storage.BatchCreateReadSessionStreamsRequest actualRequest =
        ((Storage.BatchCreateReadSessionStreamsRequest) actualRequests.get(0));

    Assert.assertEquals(session, actualRequest.getSession());
    Assert.assertEquals(requestedStreams, actualRequest.getRequestedStreams());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateReadSessionStreamsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      Storage.ReadSession session = Storage.ReadSession.newBuilder().build();
      int requestedStreams = 1017221410;
      client.batchCreateReadSessionStreams(session, requestedStreams);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void finalizeStreamTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Storage.Stream stream = Storage.Stream.newBuilder().build();

    client.finalizeStream(stream);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Storage.FinalizeStreamRequest actualRequest =
        ((Storage.FinalizeStreamRequest) actualRequests.get(0));

    Assert.assertEquals(stream, actualRequest.getStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void finalizeStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      Storage.Stream stream = Storage.Stream.newBuilder().build();
      client.finalizeStream(stream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void splitReadStreamTest() throws Exception {
    Storage.SplitReadStreamResponse expectedResponse =
        Storage.SplitReadStreamResponse.newBuilder().build();
    mockBigQueryStorage.addResponse(expectedResponse);

    Storage.Stream originalStream = Storage.Stream.newBuilder().build();

    Storage.SplitReadStreamResponse actualResponse = client.splitReadStream(originalStream);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryStorage.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    Storage.SplitReadStreamRequest actualRequest =
        ((Storage.SplitReadStreamRequest) actualRequests.get(0));

    Assert.assertEquals(originalStream, actualRequest.getOriginalStream());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void splitReadStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryStorage.addException(exception);

    try {
      Storage.Stream originalStream = Storage.Stream.newBuilder().build();
      client.splitReadStream(originalStream);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
