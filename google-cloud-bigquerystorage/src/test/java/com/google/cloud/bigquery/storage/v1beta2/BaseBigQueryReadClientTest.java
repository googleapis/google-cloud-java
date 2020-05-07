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
package com.google.cloud.bigquery.storage.v1beta2;

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
public class BaseBigQueryReadClientTest {
  private static MockBigQueryRead mockBigQueryRead;
  private static MockServiceHelper serviceHelper;
  private BaseBigQueryReadClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryRead = new MockBigQueryRead();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryRead));
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
    BaseBigQueryReadSettings settings =
        BaseBigQueryReadSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BaseBigQueryReadClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void createReadSessionTest() {
    ReadSessionName name = ReadSessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]");
    TableName table = TableName.of("[PROJECT]", "[DATASET]", "[TABLE]");
    ReadSession expectedResponse =
        ReadSession.newBuilder().setName(name.toString()).setTable(table.toString()).build();
    mockBigQueryRead.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ReadSession readSession = ReadSession.newBuilder().build();
    int maxStreamCount = 940837515;

    ReadSession actualResponse = client.createReadSession(parent, readSession, maxStreamCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = (CreateReadSessionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, ProjectName.parse(actualRequest.getParent()));
    Assert.assertEquals(readSession, actualRequest.getReadSession());
    Assert.assertEquals(maxStreamCount, actualRequest.getMaxStreamCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createReadSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      ReadSession readSession = ReadSession.newBuilder().build();
      int maxStreamCount = 940837515;

      client.createReadSession(parent, readSession, maxStreamCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsTest() throws Exception {
    long rowCount = 1340416618L;
    ReadRowsResponse expectedResponse = ReadRowsResponse.newBuilder().setRowCount(rowCount).build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadStreamName readStream =
        ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]");
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder().setReadStream(readStream.toString()).build();

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
    mockBigQueryRead.addException(exception);
    ReadStreamName readStream =
        ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]");
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder().setReadStream(readStream.toString()).build();

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
  public void splitReadStreamTest() {
    SplitReadStreamResponse expectedResponse = SplitReadStreamResponse.newBuilder().build();
    mockBigQueryRead.addResponse(expectedResponse);

    ReadStreamName name = ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]");
    SplitReadStreamRequest request =
        SplitReadStreamRequest.newBuilder().setName(name.toString()).build();

    SplitReadStreamResponse actualResponse = client.splitReadStream(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SplitReadStreamRequest actualRequest = (SplitReadStreamRequest) actualRequests.get(0);

    Assert.assertEquals(name, ReadStreamName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void splitReadStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);

    try {
      ReadStreamName name = ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]");
      SplitReadStreamRequest request =
          SplitReadStreamRequest.newBuilder().setName(name.toString()).build();

      client.splitReadStream(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
