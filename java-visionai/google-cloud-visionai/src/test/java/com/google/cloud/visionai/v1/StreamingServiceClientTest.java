/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1;

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
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
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
public class StreamingServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockStreamingService mockStreamingService;
  private LocalChannelProvider channelProvider;
  private StreamingServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockStreamingService = new MockStreamingService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockStreamingService, mockLocations, mockIAMPolicy));
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
    StreamingServiceSettings settings =
        StreamingServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StreamingServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void sendPacketsTest() throws Exception {
    SendPacketsResponse expectedResponse = SendPacketsResponse.newBuilder().build();
    mockStreamingService.addResponse(expectedResponse);
    SendPacketsRequest request = SendPacketsRequest.newBuilder().build();

    MockStreamObserver<SendPacketsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse> callable =
        client.sendPacketsCallable();
    ApiStreamObserver<SendPacketsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<SendPacketsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void sendPacketsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamingService.addException(exception);
    SendPacketsRequest request = SendPacketsRequest.newBuilder().build();

    MockStreamObserver<SendPacketsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse> callable =
        client.sendPacketsCallable();
    ApiStreamObserver<SendPacketsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<SendPacketsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void receivePacketsTest() throws Exception {
    ReceivePacketsResponse expectedResponse = ReceivePacketsResponse.newBuilder().build();
    mockStreamingService.addResponse(expectedResponse);
    ReceivePacketsRequest request = ReceivePacketsRequest.newBuilder().build();

    MockStreamObserver<ReceivePacketsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse> callable =
        client.receivePacketsCallable();
    ApiStreamObserver<ReceivePacketsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<ReceivePacketsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void receivePacketsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamingService.addException(exception);
    ReceivePacketsRequest request = ReceivePacketsRequest.newBuilder().build();

    MockStreamObserver<ReceivePacketsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse> callable =
        client.receivePacketsCallable();
    ApiStreamObserver<ReceivePacketsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<ReceivePacketsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void receiveEventsTest() throws Exception {
    ReceiveEventsResponse expectedResponse = ReceiveEventsResponse.newBuilder().build();
    mockStreamingService.addResponse(expectedResponse);
    ReceiveEventsRequest request = ReceiveEventsRequest.newBuilder().build();

    MockStreamObserver<ReceiveEventsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse> callable =
        client.receiveEventsCallable();
    ApiStreamObserver<ReceiveEventsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<ReceiveEventsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void receiveEventsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamingService.addException(exception);
    ReceiveEventsRequest request = ReceiveEventsRequest.newBuilder().build();

    MockStreamObserver<ReceiveEventsResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse> callable =
        client.receiveEventsCallable();
    ApiStreamObserver<ReceiveEventsRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<ReceiveEventsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void acquireLeaseTest() throws Exception {
    Lease expectedResponse =
        Lease.newBuilder()
            .setId("id3355")
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .setExpireTime(Timestamp.newBuilder().build())
            .setLeaseType(LeaseType.forNumber(0))
            .build();
    mockStreamingService.addResponse(expectedResponse);

    AcquireLeaseRequest request =
        AcquireLeaseRequest.newBuilder()
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .setTerm(Duration.newBuilder().build())
            .setLeaseType(LeaseType.forNumber(0))
            .build();

    Lease actualResponse = client.acquireLease(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AcquireLeaseRequest actualRequest = ((AcquireLeaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSeries(), actualRequest.getSeries());
    Assert.assertEquals(request.getOwner(), actualRequest.getOwner());
    Assert.assertEquals(request.getTerm(), actualRequest.getTerm());
    Assert.assertEquals(request.getLeaseType(), actualRequest.getLeaseType());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void acquireLeaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamingService.addException(exception);

    try {
      AcquireLeaseRequest request =
          AcquireLeaseRequest.newBuilder()
              .setSeries("series-905838985")
              .setOwner("owner106164915")
              .setTerm(Duration.newBuilder().build())
              .setLeaseType(LeaseType.forNumber(0))
              .build();
      client.acquireLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renewLeaseTest() throws Exception {
    Lease expectedResponse =
        Lease.newBuilder()
            .setId("id3355")
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .setExpireTime(Timestamp.newBuilder().build())
            .setLeaseType(LeaseType.forNumber(0))
            .build();
    mockStreamingService.addResponse(expectedResponse);

    RenewLeaseRequest request =
        RenewLeaseRequest.newBuilder()
            .setId("id3355")
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .setTerm(Duration.newBuilder().build())
            .build();

    Lease actualResponse = client.renewLease(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenewLeaseRequest actualRequest = ((RenewLeaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getId(), actualRequest.getId());
    Assert.assertEquals(request.getSeries(), actualRequest.getSeries());
    Assert.assertEquals(request.getOwner(), actualRequest.getOwner());
    Assert.assertEquals(request.getTerm(), actualRequest.getTerm());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void renewLeaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamingService.addException(exception);

    try {
      RenewLeaseRequest request =
          RenewLeaseRequest.newBuilder()
              .setId("id3355")
              .setSeries("series-905838985")
              .setOwner("owner106164915")
              .setTerm(Duration.newBuilder().build())
              .build();
      client.renewLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void releaseLeaseTest() throws Exception {
    ReleaseLeaseResponse expectedResponse = ReleaseLeaseResponse.newBuilder().build();
    mockStreamingService.addResponse(expectedResponse);

    ReleaseLeaseRequest request =
        ReleaseLeaseRequest.newBuilder()
            .setId("id3355")
            .setSeries("series-905838985")
            .setOwner("owner106164915")
            .build();

    ReleaseLeaseResponse actualResponse = client.releaseLease(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockStreamingService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReleaseLeaseRequest actualRequest = ((ReleaseLeaseRequest) actualRequests.get(0));

    Assert.assertEquals(request.getId(), actualRequest.getId());
    Assert.assertEquals(request.getSeries(), actualRequest.getSeries());
    Assert.assertEquals(request.getOwner(), actualRequest.getOwner());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void releaseLeaseExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockStreamingService.addException(exception);

    try {
      ReleaseLeaseRequest request =
          ReleaseLeaseRequest.newBuilder()
              .setId("id3355")
              .setSeries("series-905838985")
              .setOwner("owner106164915")
              .build();
      client.releaseLease(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
