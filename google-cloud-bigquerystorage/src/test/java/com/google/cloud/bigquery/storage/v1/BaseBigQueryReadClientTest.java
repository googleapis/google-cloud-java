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

package com.google.cloud.bigquery.storage.v1;

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
public class BaseBigQueryReadClientTest {
  private static MockBigQueryRead mockBigQueryRead;
  private static MockServiceHelper mockServiceHelper;
  private BaseBigQueryReadClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBigQueryRead = new MockBigQueryRead();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigQueryRead));
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
  public void createReadSessionTest() throws Exception {
    ReadSession expectedResponse =
        ReadSession.newBuilder()
            .setName(ReadSessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .setTable(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .setTableModifiers(ReadSession.TableModifiers.newBuilder().build())
            .setReadOptions(ReadSession.TableReadOptions.newBuilder().build())
            .addAllStreams(new ArrayList<ReadStream>())
            .build();
    mockBigQueryRead.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    ReadSession readSession = ReadSession.newBuilder().build();
    int maxStreamCount = 940837515;

    ReadSession actualResponse = client.createReadSession(parent, readSession, maxStreamCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = ((CreateReadSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(readSession, actualRequest.getReadSession());
    Assert.assertEquals(maxStreamCount, actualRequest.getMaxStreamCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReadSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      ReadSession readSession = ReadSession.newBuilder().build();
      int maxStreamCount = 940837515;
      client.createReadSession(parent, readSession, maxStreamCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReadSessionTest2() throws Exception {
    ReadSession expectedResponse =
        ReadSession.newBuilder()
            .setName(ReadSessionName.of("[PROJECT]", "[LOCATION]", "[SESSION]").toString())
            .setExpireTime(Timestamp.newBuilder().build())
            .setTable(TableName.of("[PROJECT]", "[DATASET]", "[TABLE]").toString())
            .setTableModifiers(ReadSession.TableModifiers.newBuilder().build())
            .setReadOptions(ReadSession.TableReadOptions.newBuilder().build())
            .addAllStreams(new ArrayList<ReadStream>())
            .build();
    mockBigQueryRead.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ReadSession readSession = ReadSession.newBuilder().build();
    int maxStreamCount = 940837515;

    ReadSession actualResponse = client.createReadSession(parent, readSession, maxStreamCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = ((CreateReadSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(readSession, actualRequest.getReadSession());
    Assert.assertEquals(maxStreamCount, actualRequest.getMaxStreamCount());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReadSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);

    try {
      String parent = "parent-995424086";
      ReadSession readSession = ReadSession.newBuilder().build();
      int maxStreamCount = 940837515;
      client.createReadSession(parent, readSession, maxStreamCount);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readRowsTest() throws Exception {
    ReadRowsResponse expectedResponse =
        ReadRowsResponse.newBuilder()
            .setRowCount(1340416618)
            .setStats(StreamStats.newBuilder().build())
            .setThrottleState(ThrottleState.newBuilder().build())
            .build();
    mockBigQueryRead.addResponse(expectedResponse);
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder()
            .setReadStream(
                ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]").toString())
            .setOffset(-1019779949)
            .build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder()
            .setReadStream(
                ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]").toString())
            .setOffset(-1019779949)
            .build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void splitReadStreamTest() throws Exception {
    SplitReadStreamResponse expectedResponse =
        SplitReadStreamResponse.newBuilder()
            .setPrimaryStream(ReadStream.newBuilder().build())
            .setRemainderStream(ReadStream.newBuilder().build())
            .build();
    mockBigQueryRead.addResponse(expectedResponse);

    SplitReadStreamRequest request =
        SplitReadStreamRequest.newBuilder()
            .setName(
                ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]").toString())
            .setFraction(-1653751294)
            .build();

    SplitReadStreamResponse actualResponse = client.splitReadStream(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SplitReadStreamRequest actualRequest = ((SplitReadStreamRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFraction(), actualRequest.getFraction(), 0.0001);
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void splitReadStreamExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigQueryRead.addException(exception);

    try {
      SplitReadStreamRequest request =
          SplitReadStreamRequest.newBuilder()
              .setName(
                  ReadStreamName.of("[PROJECT]", "[LOCATION]", "[SESSION]", "[STREAM]").toString())
              .setFraction(-1653751294)
              .build();
      client.splitReadStream(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
