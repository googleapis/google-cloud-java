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

package com.google.cloud.devicestreaming.v1;

import static com.google.cloud.devicestreaming.v1.DirectAccessServiceClient.ListDeviceSessionsPagedResponse;

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
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class DirectAccessServiceClientTest {
  private static MockDirectAccessService mockDirectAccessService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DirectAccessServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDirectAccessService = new MockDirectAccessService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDirectAccessService));
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
    DirectAccessServiceSettings settings =
        DirectAccessServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DirectAccessServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDeviceSessionTest() throws Exception {
    DeviceSession expectedResponse =
        DeviceSession.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .setDisplayName("displayName1714148973")
            .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
            .setInactivityTimeout(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActiveStartTime(Timestamp.newBuilder().build())
            .setAndroidDevice(AndroidDevice.newBuilder().build())
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    DeviceSession deviceSession = DeviceSession.newBuilder().build();
    String deviceSessionId = "deviceSessionId-544276325";

    DeviceSession actualResponse =
        client.createDeviceSession(parent, deviceSession, deviceSessionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceSessionRequest actualRequest = ((CreateDeviceSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deviceSession, actualRequest.getDeviceSession());
    Assert.assertEquals(deviceSessionId, actualRequest.getDeviceSessionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeviceSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      DeviceSession deviceSession = DeviceSession.newBuilder().build();
      String deviceSessionId = "deviceSessionId-544276325";
      client.createDeviceSession(parent, deviceSession, deviceSessionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeviceSessionTest2() throws Exception {
    DeviceSession expectedResponse =
        DeviceSession.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .setDisplayName("displayName1714148973")
            .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
            .setInactivityTimeout(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActiveStartTime(Timestamp.newBuilder().build())
            .setAndroidDevice(AndroidDevice.newBuilder().build())
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DeviceSession deviceSession = DeviceSession.newBuilder().build();
    String deviceSessionId = "deviceSessionId-544276325";

    DeviceSession actualResponse =
        client.createDeviceSession(parent, deviceSession, deviceSessionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceSessionRequest actualRequest = ((CreateDeviceSessionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deviceSession, actualRequest.getDeviceSession());
    Assert.assertEquals(deviceSessionId, actualRequest.getDeviceSessionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeviceSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      String parent = "parent-995424086";
      DeviceSession deviceSession = DeviceSession.newBuilder().build();
      String deviceSessionId = "deviceSessionId-544276325";
      client.createDeviceSession(parent, deviceSession, deviceSessionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceSessionsTest() throws Exception {
    DeviceSession responsesElement = DeviceSession.newBuilder().build();
    ListDeviceSessionsResponse expectedResponse =
        ListDeviceSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeviceSessions(Arrays.asList(responsesElement))
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDeviceSessionsPagedResponse pagedListResponse = client.listDeviceSessions(parent);

    List<DeviceSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceSessionsRequest actualRequest = ((ListDeviceSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listDeviceSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceSessionsTest2() throws Exception {
    DeviceSession responsesElement = DeviceSession.newBuilder().build();
    ListDeviceSessionsResponse expectedResponse =
        ListDeviceSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeviceSessions(Arrays.asList(responsesElement))
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeviceSessionsPagedResponse pagedListResponse = client.listDeviceSessions(parent);

    List<DeviceSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceSessionsRequest actualRequest = ((ListDeviceSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDeviceSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeviceSessionTest() throws Exception {
    DeviceSession expectedResponse =
        DeviceSession.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .setDisplayName("displayName1714148973")
            .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
            .setInactivityTimeout(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActiveStartTime(Timestamp.newBuilder().build())
            .setAndroidDevice(AndroidDevice.newBuilder().build())
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    DeviceSessionName name = DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]");

    DeviceSession actualResponse = client.getDeviceSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceSessionRequest actualRequest = ((GetDeviceSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeviceSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      DeviceSessionName name = DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]");
      client.getDeviceSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeviceSessionTest2() throws Exception {
    DeviceSession expectedResponse =
        DeviceSession.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .setDisplayName("displayName1714148973")
            .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
            .setInactivityTimeout(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActiveStartTime(Timestamp.newBuilder().build())
            .setAndroidDevice(AndroidDevice.newBuilder().build())
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    String name = "name3373707";

    DeviceSession actualResponse = client.getDeviceSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceSessionRequest actualRequest = ((GetDeviceSessionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeviceSessionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      String name = "name3373707";
      client.getDeviceSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelDeviceSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDirectAccessService.addResponse(expectedResponse);

    CancelDeviceSessionRequest request =
        CancelDeviceSessionRequest.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .build();

    client.cancelDeviceSession(request);

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelDeviceSessionRequest actualRequest = ((CancelDeviceSessionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelDeviceSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      CancelDeviceSessionRequest request =
          CancelDeviceSessionRequest.newBuilder()
              .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
              .build();
      client.cancelDeviceSession(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeviceSessionTest() throws Exception {
    DeviceSession expectedResponse =
        DeviceSession.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .setDisplayName("displayName1714148973")
            .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
            .setInactivityTimeout(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActiveStartTime(Timestamp.newBuilder().build())
            .setAndroidDevice(AndroidDevice.newBuilder().build())
            .build();
    mockDirectAccessService.addResponse(expectedResponse);

    DeviceSession deviceSession = DeviceSession.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeviceSession actualResponse = client.updateDeviceSession(deviceSession, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDirectAccessService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeviceSessionRequest actualRequest = ((UpdateDeviceSessionRequest) actualRequests.get(0));

    Assert.assertEquals(deviceSession, actualRequest.getDeviceSession());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDeviceSessionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);

    try {
      DeviceSession deviceSession = DeviceSession.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeviceSession(deviceSession, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void adbConnectTest() throws Exception {
    DeviceMessage expectedResponse = DeviceMessage.newBuilder().build();
    mockDirectAccessService.addResponse(expectedResponse);
    AdbMessage request = AdbMessage.newBuilder().build();

    MockStreamObserver<DeviceMessage> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<AdbMessage, DeviceMessage> callable = client.adbConnectCallable();
    ApiStreamObserver<AdbMessage> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<DeviceMessage> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void adbConnectExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDirectAccessService.addException(exception);
    AdbMessage request = AdbMessage.newBuilder().build();

    MockStreamObserver<DeviceMessage> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<AdbMessage, DeviceMessage> callable = client.adbConnectCallable();
    ApiStreamObserver<AdbMessage> requestObserver = callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<DeviceMessage> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
