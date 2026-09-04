/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1beta4;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
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
public class SqlDataServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockSqlDataService mockSqlDataService;
  private LocalChannelProvider channelProvider;
  private SqlDataServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSqlDataService = new MockSqlDataService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockSqlDataService, mockLocations));
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
    SqlDataServiceSettings settings =
        SqlDataServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SqlDataServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void streamSqlDataTest() throws Exception {
    StreamSqlDataResponse expectedResponse =
        StreamSqlDataResponse.newBuilder().setAck(Ack.newBuilder().build()).build();
    mockSqlDataService.addResponse(expectedResponse);
    StreamSqlDataRequest request =
        StreamSqlDataRequest.newBuilder()
            .setAck(Ack.newBuilder().build())
            .setInstanceId(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .build();

    MockStreamObserver<StreamSqlDataResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamSqlDataRequest, StreamSqlDataResponse> callable =
        client.streamSqlDataCallable();
    ApiStreamObserver<StreamSqlDataRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamSqlDataResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamSqlDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSqlDataService.addException(exception);
    StreamSqlDataRequest request =
        StreamSqlDataRequest.newBuilder()
            .setAck(Ack.newBuilder().build())
            .setInstanceId(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
            .build();

    MockStreamObserver<StreamSqlDataResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamSqlDataRequest, StreamSqlDataResponse> callable =
        client.streamSqlDataCallable();
    ApiStreamObserver<StreamSqlDataRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamSqlDataResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
