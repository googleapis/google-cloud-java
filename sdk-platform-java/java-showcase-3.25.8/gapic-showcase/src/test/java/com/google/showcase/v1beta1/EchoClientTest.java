/*
 * Copyright 2025 Google LLC
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

package com.google.showcase.v1beta1;

import static com.google.showcase.v1beta1.EchoClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandLegacyMappedPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class EchoClientTest {
  private static MockEcho mockEcho;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private EchoClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockEcho = new MockEcho();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockEcho, mockLocations, mockIAMPolicy));
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
    EchoSettings settings =
        EchoSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = EchoClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void echoTest() throws Exception {
    EchoResponse expectedResponse =
        EchoResponse.newBuilder()
            .setContent("content951530617")
            .setSeverity(Severity.forNumber(0))
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();
    mockEcho.addResponse(expectedResponse);

    EchoRequest request =
        EchoRequest.newBuilder()
            .setSeverity(Severity.forNumber(0))
            .setHeader("header-1221270899")
            .setOtherHeader("otherHeader-2026585667")
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();

    EchoResponse actualResponse = client.echo(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EchoRequest actualRequest = ((EchoRequest) actualRequests.get(0));

    Assert.assertEquals(request.getContent(), actualRequest.getContent());
    Assert.assertEquals(request.getError(), actualRequest.getError());
    Assert.assertEquals(request.getSeverity(), actualRequest.getSeverity());
    Assert.assertEquals(request.getHeader(), actualRequest.getHeader());
    Assert.assertEquals(request.getOtherHeader(), actualRequest.getOtherHeader());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertEquals(request.getOtherRequestId(), actualRequest.getOtherRequestId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void echoExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      EchoRequest request =
          EchoRequest.newBuilder()
              .setSeverity(Severity.forNumber(0))
              .setHeader("header-1221270899")
              .setOtherHeader("otherHeader-2026585667")
              .setRequestId("requestId693933066")
              .setOtherRequestId("otherRequestId1248995034")
              .build();
      client.echo(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void echoErrorDetailsTest() throws Exception {
    EchoErrorDetailsResponse expectedResponse =
        EchoErrorDetailsResponse.newBuilder()
            .setSingleDetail(EchoErrorDetailsResponse.SingleDetail.newBuilder().build())
            .setMultipleDetails(EchoErrorDetailsResponse.MultipleDetails.newBuilder().build())
            .build();
    mockEcho.addResponse(expectedResponse);

    EchoErrorDetailsRequest request =
        EchoErrorDetailsRequest.newBuilder()
            .setSingleDetailText("singleDetailText1774380934")
            .addAllMultiDetailText(new ArrayList<String>())
            .build();

    EchoErrorDetailsResponse actualResponse = client.echoErrorDetails(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EchoErrorDetailsRequest actualRequest = ((EchoErrorDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSingleDetailText(), actualRequest.getSingleDetailText());
    Assert.assertEquals(request.getMultiDetailTextList(), actualRequest.getMultiDetailTextList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void echoErrorDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      EchoErrorDetailsRequest request =
          EchoErrorDetailsRequest.newBuilder()
              .setSingleDetailText("singleDetailText1774380934")
              .addAllMultiDetailText(new ArrayList<String>())
              .build();
      client.echoErrorDetails(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void failEchoWithDetailsTest() throws Exception {
    FailEchoWithDetailsResponse expectedResponse = FailEchoWithDetailsResponse.newBuilder().build();
    mockEcho.addResponse(expectedResponse);

    FailEchoWithDetailsRequest request =
        FailEchoWithDetailsRequest.newBuilder().setMessage("message954925063").build();

    FailEchoWithDetailsResponse actualResponse = client.failEchoWithDetails(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FailEchoWithDetailsRequest actualRequest = ((FailEchoWithDetailsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getMessage(), actualRequest.getMessage());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void failEchoWithDetailsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      FailEchoWithDetailsRequest request =
          FailEchoWithDetailsRequest.newBuilder().setMessage("message954925063").build();
      client.failEchoWithDetails(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void expandTest() throws Exception {
    EchoResponse expectedResponse =
        EchoResponse.newBuilder()
            .setContent("content951530617")
            .setSeverity(Severity.forNumber(0))
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();
    mockEcho.addResponse(expectedResponse);
    ExpandRequest request =
        ExpandRequest.newBuilder()
            .setContent("content951530617")
            .setError(Status.newBuilder().build())
            .setStreamWaitTime(Duration.newBuilder().build())
            .build();

    MockStreamObserver<EchoResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ExpandRequest, EchoResponse> callable = client.expandCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<EchoResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void expandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);
    ExpandRequest request =
        ExpandRequest.newBuilder()
            .setContent("content951530617")
            .setError(Status.newBuilder().build())
            .setStreamWaitTime(Duration.newBuilder().build())
            .build();

    MockStreamObserver<EchoResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ExpandRequest, EchoResponse> callable = client.expandCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<EchoResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void collectTest() throws Exception {
    EchoResponse expectedResponse =
        EchoResponse.newBuilder()
            .setContent("content951530617")
            .setSeverity(Severity.forNumber(0))
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();
    mockEcho.addResponse(expectedResponse);
    EchoRequest request =
        EchoRequest.newBuilder()
            .setSeverity(Severity.forNumber(0))
            .setHeader("header-1221270899")
            .setOtherHeader("otherHeader-2026585667")
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();

    MockStreamObserver<EchoResponse> responseObserver = new MockStreamObserver<>();

    ClientStreamingCallable<EchoRequest, EchoResponse> callable = client.collectCallable();
    ApiStreamObserver<EchoRequest> requestObserver = callable.clientStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<EchoResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void collectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);
    EchoRequest request =
        EchoRequest.newBuilder()
            .setSeverity(Severity.forNumber(0))
            .setHeader("header-1221270899")
            .setOtherHeader("otherHeader-2026585667")
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();

    MockStreamObserver<EchoResponse> responseObserver = new MockStreamObserver<>();

    ClientStreamingCallable<EchoRequest, EchoResponse> callable = client.collectCallable();
    ApiStreamObserver<EchoRequest> requestObserver = callable.clientStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<EchoResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void chatTest() throws Exception {
    EchoResponse expectedResponse =
        EchoResponse.newBuilder()
            .setContent("content951530617")
            .setSeverity(Severity.forNumber(0))
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();
    mockEcho.addResponse(expectedResponse);
    EchoRequest request =
        EchoRequest.newBuilder()
            .setSeverity(Severity.forNumber(0))
            .setHeader("header-1221270899")
            .setOtherHeader("otherHeader-2026585667")
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();

    MockStreamObserver<EchoResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<EchoRequest, EchoResponse> callable = client.chatCallable();
    ApiStreamObserver<EchoRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<EchoResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void chatExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);
    EchoRequest request =
        EchoRequest.newBuilder()
            .setSeverity(Severity.forNumber(0))
            .setHeader("header-1221270899")
            .setOtherHeader("otherHeader-2026585667")
            .setRequestId("requestId693933066")
            .setOtherRequestId("otherRequestId1248995034")
            .build();

    MockStreamObserver<EchoResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<EchoRequest, EchoResponse> callable = client.chatCallable();
    ApiStreamObserver<EchoRequest> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<EchoResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void pagedExpandTest() throws Exception {
    EchoResponse responsesElement = EchoResponse.newBuilder().build();
    PagedExpandResponse expectedResponse =
        PagedExpandResponse.newBuilder()
            .setNextPageToken("")
            .addAllResponses(Arrays.asList(responsesElement))
            .build();
    mockEcho.addResponse(expectedResponse);

    PagedExpandRequest request =
        PagedExpandRequest.newBuilder()
            .setContent("content951530617")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    PagedExpandPagedResponse pagedListResponse = client.pagedExpand(request);

    List<EchoResponse> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResponsesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PagedExpandRequest actualRequest = ((PagedExpandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getContent(), actualRequest.getContent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pagedExpandExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      PagedExpandRequest request =
          PagedExpandRequest.newBuilder()
              .setContent("content951530617")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.pagedExpand(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pagedExpandLegacyTest() throws Exception {
    PagedExpandResponse expectedResponse =
        PagedExpandResponse.newBuilder()
            .addAllResponses(new ArrayList<EchoResponse>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockEcho.addResponse(expectedResponse);

    PagedExpandLegacyRequest request =
        PagedExpandLegacyRequest.newBuilder()
            .setContent("content951530617")
            .setMaxResults(1128457243)
            .setPageToken("pageToken873572522")
            .build();

    PagedExpandResponse actualResponse = client.pagedExpandLegacy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PagedExpandLegacyRequest actualRequest = ((PagedExpandLegacyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getContent(), actualRequest.getContent());
    Assert.assertEquals(request.getMaxResults(), actualRequest.getMaxResults());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pagedExpandLegacyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      PagedExpandLegacyRequest request =
          PagedExpandLegacyRequest.newBuilder()
              .setContent("content951530617")
              .setMaxResults(1128457243)
              .setPageToken("pageToken873572522")
              .build();
      client.pagedExpandLegacy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pagedExpandLegacyMappedTest() throws Exception {
    PagedExpandResponseList responsesElement = PagedExpandResponseList.newBuilder().build();
    PagedExpandLegacyMappedResponse expectedResponse =
        PagedExpandLegacyMappedResponse.newBuilder()
            .setNextPageToken("")
            .putAllAlphabetized(Collections.singletonMap("alphabetized", responsesElement))
            .build();
    mockEcho.addResponse(expectedResponse);

    PagedExpandRequest request =
        PagedExpandRequest.newBuilder()
            .setContent("content951530617")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    PagedExpandLegacyMappedPagedResponse pagedListResponse =
        client.pagedExpandLegacyMapped(request);

    List<Map.Entry<String, PagedExpandResponseList>> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getAlphabetizedMap().entrySet().iterator().next(), resources.get(0));

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PagedExpandRequest actualRequest = ((PagedExpandRequest) actualRequests.get(0));

    Assert.assertEquals(request.getContent(), actualRequest.getContent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pagedExpandLegacyMappedExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      PagedExpandRequest request =
          PagedExpandRequest.newBuilder()
              .setContent("content951530617")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.pagedExpandLegacyMapped(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void waitTest() throws Exception {
    WaitResponse expectedResponse =
        WaitResponse.newBuilder().setContent("content951530617").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("waitTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockEcho.addResponse(resultOperation);

    WaitRequest request = WaitRequest.newBuilder().build();

    WaitResponse actualResponse = client.waitAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    WaitRequest actualRequest = ((WaitRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEndTime(), actualRequest.getEndTime());
    Assert.assertEquals(request.getTtl(), actualRequest.getTtl());
    Assert.assertEquals(request.getError(), actualRequest.getError());
    Assert.assertEquals(request.getSuccess(), actualRequest.getSuccess());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void waitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      WaitRequest request = WaitRequest.newBuilder().build();
      client.waitAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void blockTest() throws Exception {
    BlockResponse expectedResponse =
        BlockResponse.newBuilder().setContent("content951530617").build();
    mockEcho.addResponse(expectedResponse);

    BlockRequest request =
        BlockRequest.newBuilder().setResponseDelay(Duration.newBuilder().build()).build();

    BlockResponse actualResponse = client.block(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockEcho.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BlockRequest actualRequest = ((BlockRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResponseDelay(), actualRequest.getResponseDelay());
    Assert.assertEquals(request.getError(), actualRequest.getError());
    Assert.assertEquals(request.getSuccess(), actualRequest.getSuccess());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void blockExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockEcho.addException(exception);

    try {
      BlockRequest request =
          BlockRequest.newBuilder().setResponseDelay(Duration.newBuilder().build()).build();
      client.block(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(BlurbName.ofRoomBlurbName("[ROOM]", "[BLURB]").toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
