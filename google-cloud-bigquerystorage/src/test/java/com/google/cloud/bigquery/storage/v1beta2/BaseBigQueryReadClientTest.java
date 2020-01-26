/*
 * Copyright 2019 Google LLC
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
    String name = "name3373707";
    String table = "table110115790";
    ReadSession expectedResponse = ReadSession.newBuilder().setName(name).setTable(table).build();
    mockBigQueryRead.addResponse(expectedResponse);

    String parent = "parent-995424086";
    ReadSession readSession = ReadSession.newBuilder().build();
    int maxStreamCount = 940837515;

    ReadSession actualResponse = client.createReadSession(parent, readSession, maxStreamCount);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigQueryRead.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReadSessionRequest actualRequest = (CreateReadSessionRequest) actualRequests.get(0);

    Assert.assertEquals(parent, actualRequest.getParent());
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
      String parent = "parent-995424086";
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
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

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
    ReadRowsRequest request = ReadRowsRequest.newBuilder().build();

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
}
