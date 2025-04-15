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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.devicestreaming.v1.stub.HttpJsonDirectAccessServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DirectAccessServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DirectAccessServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDirectAccessServiceStub.getMethodDescriptors(),
            DirectAccessServiceSettings.getDefaultEndpoint());
    DirectAccessServiceSettings settings =
        DirectAccessServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DirectAccessServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DirectAccessServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    DeviceSession deviceSession = DeviceSession.newBuilder().build();
    String deviceSessionId = "deviceSessionId-544276325";

    DeviceSession actualResponse =
        client.createDeviceSession(parent, deviceSession, deviceSessionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDeviceSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    DeviceSession deviceSession = DeviceSession.newBuilder().build();
    String deviceSessionId = "deviceSessionId-544276325";

    DeviceSession actualResponse =
        client.createDeviceSession(parent, deviceSession, deviceSessionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createDeviceSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListDeviceSessionsPagedResponse pagedListResponse = client.listDeviceSessions(parent);

    List<DeviceSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceSessionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeviceSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListDeviceSessionsPagedResponse pagedListResponse = client.listDeviceSessions(parent);

    List<DeviceSession> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceSessionsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDeviceSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
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
    mockService.addResponse(expectedResponse);

    DeviceSessionName name = DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]");

    DeviceSession actualResponse = client.getDeviceSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDeviceSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9853/deviceSessions/deviceSession-9853";

    DeviceSession actualResponse = client.getDeviceSession(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getDeviceSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9853/deviceSessions/deviceSession-9853";
      client.getDeviceSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelDeviceSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CancelDeviceSessionRequest request =
        CancelDeviceSessionRequest.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .build();

    client.cancelDeviceSession(request);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void cancelDeviceSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    DeviceSession deviceSession =
        DeviceSession.newBuilder()
            .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
            .setDisplayName("displayName1714148973")
            .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
            .setInactivityTimeout(Duration.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setActiveStartTime(Timestamp.newBuilder().build())
            .setAndroidDevice(AndroidDevice.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeviceSession actualResponse = client.updateDeviceSession(deviceSession, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateDeviceSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceSession deviceSession =
          DeviceSession.newBuilder()
              .setName(DeviceSessionName.of("[PROJECT]", "[DEVICE_SESSION]").toString())
              .setDisplayName("displayName1714148973")
              .addAllStateHistories(new ArrayList<DeviceSession.SessionStateEvent>())
              .setInactivityTimeout(Duration.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setActiveStartTime(Timestamp.newBuilder().build())
              .setAndroidDevice(AndroidDevice.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeviceSession(deviceSession, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void adbConnectUnsupportedMethodTest() throws Exception {
    // The adbConnect() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }
}
