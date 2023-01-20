/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.iot.v1;

import static com.google.cloud.iot.v1.DeviceManagerClient.ListDeviceRegistriesPagedResponse;
import static com.google.cloud.iot.v1.DeviceManagerClient.ListDevicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.iot.v1.stub.HttpJsonDeviceManagerStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DeviceManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DeviceManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDeviceManagerStub.getMethodDescriptors(),
            DeviceManagerSettings.getDefaultEndpoint());
    DeviceManagerSettings settings =
        DeviceManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DeviceManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeviceManagerClient.create(settings);
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
  public void createDeviceRegistryTest() throws Exception {
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder()
            .setId("id3355")
            .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
            .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
            .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
            .setMqttConfig(MqttConfig.newBuilder().build())
            .setHttpConfig(HttpConfig.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .addAllCredentials(new ArrayList<RegistryCredential>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();

    DeviceRegistry actualResponse = client.createDeviceRegistry(parent, deviceRegistry);
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
  public void createDeviceRegistryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
      client.createDeviceRegistry(parent, deviceRegistry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeviceRegistryTest2() throws Exception {
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder()
            .setId("id3355")
            .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
            .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
            .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
            .setMqttConfig(MqttConfig.newBuilder().build())
            .setHttpConfig(HttpConfig.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .addAllCredentials(new ArrayList<RegistryCredential>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();

    DeviceRegistry actualResponse = client.createDeviceRegistry(parent, deviceRegistry);
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
  public void createDeviceRegistryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
      client.createDeviceRegistry(parent, deviceRegistry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeviceRegistryTest() throws Exception {
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder()
            .setId("id3355")
            .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
            .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
            .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
            .setMqttConfig(MqttConfig.newBuilder().build())
            .setHttpConfig(HttpConfig.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .addAllCredentials(new ArrayList<RegistryCredential>())
            .build();
    mockService.addResponse(expectedResponse);

    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    DeviceRegistry actualResponse = client.getDeviceRegistry(name);
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
  public void getDeviceRegistryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      client.getDeviceRegistry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeviceRegistryTest2() throws Exception {
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder()
            .setId("id3355")
            .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
            .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
            .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
            .setMqttConfig(MqttConfig.newBuilder().build())
            .setHttpConfig(HttpConfig.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .addAllCredentials(new ArrayList<RegistryCredential>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5653/locations/location-5653/registries/registrie-5653";

    DeviceRegistry actualResponse = client.getDeviceRegistry(name);
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
  public void getDeviceRegistryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5653/locations/location-5653/registries/registrie-5653";
      client.getDeviceRegistry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeviceRegistryTest() throws Exception {
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder()
            .setId("id3355")
            .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
            .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
            .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
            .setMqttConfig(MqttConfig.newBuilder().build())
            .setHttpConfig(HttpConfig.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .addAllCredentials(new ArrayList<RegistryCredential>())
            .build();
    mockService.addResponse(expectedResponse);

    DeviceRegistry deviceRegistry =
        DeviceRegistry.newBuilder()
            .setId("id3355")
            .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
            .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
            .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
            .setMqttConfig(MqttConfig.newBuilder().build())
            .setHttpConfig(HttpConfig.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .addAllCredentials(new ArrayList<RegistryCredential>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeviceRegistry actualResponse = client.updateDeviceRegistry(deviceRegistry, updateMask);
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
  public void updateDeviceRegistryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceRegistry deviceRegistry =
          DeviceRegistry.newBuilder()
              .setId("id3355")
              .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
              .addAllEventNotificationConfigs(new ArrayList<EventNotificationConfig>())
              .setStateNotificationConfig(StateNotificationConfig.newBuilder().build())
              .setMqttConfig(MqttConfig.newBuilder().build())
              .setHttpConfig(HttpConfig.newBuilder().build())
              .setLogLevel(LogLevel.forNumber(0))
              .addAllCredentials(new ArrayList<RegistryCredential>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDeviceRegistry(deviceRegistry, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeviceRegistryTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    client.deleteDeviceRegistry(name);

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
  public void deleteDeviceRegistryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      client.deleteDeviceRegistry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeviceRegistryTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-5653/locations/location-5653/registries/registrie-5653";

    client.deleteDeviceRegistry(name);

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
  public void deleteDeviceRegistryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-5653/locations/location-5653/registries/registrie-5653";
      client.deleteDeviceRegistry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceRegistriesTest() throws Exception {
    DeviceRegistry responsesElement = DeviceRegistry.newBuilder().build();
    ListDeviceRegistriesResponse expectedResponse =
        ListDeviceRegistriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeviceRegistries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeviceRegistriesPagedResponse pagedListResponse = client.listDeviceRegistries(parent);

    List<DeviceRegistry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceRegistriesList().get(0), resources.get(0));

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
  public void listDeviceRegistriesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDeviceRegistries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceRegistriesTest2() throws Exception {
    DeviceRegistry responsesElement = DeviceRegistry.newBuilder().build();
    ListDeviceRegistriesResponse expectedResponse =
        ListDeviceRegistriesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDeviceRegistries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListDeviceRegistriesPagedResponse pagedListResponse = client.listDeviceRegistries(parent);

    List<DeviceRegistry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceRegistriesList().get(0), resources.get(0));

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
  public void listDeviceRegistriesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listDeviceRegistries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeviceTest() throws Exception {
    Device expectedResponse =
        Device.newBuilder()
            .setId("id3355")
            .setName(DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
            .setNumId(-1034366860)
            .addAllCredentials(new ArrayList<DeviceCredential>())
            .setLastHeartbeatTime(Timestamp.newBuilder().build())
            .setLastEventTime(Timestamp.newBuilder().build())
            .setLastStateTime(Timestamp.newBuilder().build())
            .setLastConfigAckTime(Timestamp.newBuilder().build())
            .setLastConfigSendTime(Timestamp.newBuilder().build())
            .setBlocked(true)
            .setLastErrorTime(Timestamp.newBuilder().build())
            .setLastErrorStatus(Status.newBuilder().build())
            .setConfig(DeviceConfig.newBuilder().build())
            .setState(DeviceState.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .putAllMetadata(new HashMap<String, String>())
            .setGatewayConfig(GatewayConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    Device device = Device.newBuilder().build();

    Device actualResponse = client.createDevice(parent, device);
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
  public void createDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      Device device = Device.newBuilder().build();
      client.createDevice(parent, device);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDeviceTest2() throws Exception {
    Device expectedResponse =
        Device.newBuilder()
            .setId("id3355")
            .setName(DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
            .setNumId(-1034366860)
            .addAllCredentials(new ArrayList<DeviceCredential>())
            .setLastHeartbeatTime(Timestamp.newBuilder().build())
            .setLastEventTime(Timestamp.newBuilder().build())
            .setLastStateTime(Timestamp.newBuilder().build())
            .setLastConfigAckTime(Timestamp.newBuilder().build())
            .setLastConfigSendTime(Timestamp.newBuilder().build())
            .setBlocked(true)
            .setLastErrorTime(Timestamp.newBuilder().build())
            .setLastErrorStatus(Status.newBuilder().build())
            .setConfig(DeviceConfig.newBuilder().build())
            .setState(DeviceState.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .putAllMetadata(new HashMap<String, String>())
            .setGatewayConfig(GatewayConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
    Device device = Device.newBuilder().build();

    Device actualResponse = client.createDevice(parent, device);
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
  public void createDeviceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
      Device device = Device.newBuilder().build();
      client.createDevice(parent, device);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeviceTest() throws Exception {
    Device expectedResponse =
        Device.newBuilder()
            .setId("id3355")
            .setName(DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
            .setNumId(-1034366860)
            .addAllCredentials(new ArrayList<DeviceCredential>())
            .setLastHeartbeatTime(Timestamp.newBuilder().build())
            .setLastEventTime(Timestamp.newBuilder().build())
            .setLastStateTime(Timestamp.newBuilder().build())
            .setLastConfigAckTime(Timestamp.newBuilder().build())
            .setLastConfigSendTime(Timestamp.newBuilder().build())
            .setBlocked(true)
            .setLastErrorTime(Timestamp.newBuilder().build())
            .setLastErrorStatus(Status.newBuilder().build())
            .setConfig(DeviceConfig.newBuilder().build())
            .setState(DeviceState.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .putAllMetadata(new HashMap<String, String>())
            .setGatewayConfig(GatewayConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    Device actualResponse = client.getDevice(name);
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
  public void getDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      client.getDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDeviceTest2() throws Exception {
    Device expectedResponse =
        Device.newBuilder()
            .setId("id3355")
            .setName(DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
            .setNumId(-1034366860)
            .addAllCredentials(new ArrayList<DeviceCredential>())
            .setLastHeartbeatTime(Timestamp.newBuilder().build())
            .setLastEventTime(Timestamp.newBuilder().build())
            .setLastStateTime(Timestamp.newBuilder().build())
            .setLastConfigAckTime(Timestamp.newBuilder().build())
            .setLastConfigSendTime(Timestamp.newBuilder().build())
            .setBlocked(true)
            .setLastErrorTime(Timestamp.newBuilder().build())
            .setLastErrorStatus(Status.newBuilder().build())
            .setConfig(DeviceConfig.newBuilder().build())
            .setState(DeviceState.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .putAllMetadata(new HashMap<String, String>())
            .setGatewayConfig(GatewayConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";

    Device actualResponse = client.getDevice(name);
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
  public void getDeviceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      client.getDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDeviceTest() throws Exception {
    Device expectedResponse =
        Device.newBuilder()
            .setId("id3355")
            .setName(DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
            .setNumId(-1034366860)
            .addAllCredentials(new ArrayList<DeviceCredential>())
            .setLastHeartbeatTime(Timestamp.newBuilder().build())
            .setLastEventTime(Timestamp.newBuilder().build())
            .setLastStateTime(Timestamp.newBuilder().build())
            .setLastConfigAckTime(Timestamp.newBuilder().build())
            .setLastConfigSendTime(Timestamp.newBuilder().build())
            .setBlocked(true)
            .setLastErrorTime(Timestamp.newBuilder().build())
            .setLastErrorStatus(Status.newBuilder().build())
            .setConfig(DeviceConfig.newBuilder().build())
            .setState(DeviceState.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .putAllMetadata(new HashMap<String, String>())
            .setGatewayConfig(GatewayConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Device device =
        Device.newBuilder()
            .setId("id3355")
            .setName(DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
            .setNumId(-1034366860)
            .addAllCredentials(new ArrayList<DeviceCredential>())
            .setLastHeartbeatTime(Timestamp.newBuilder().build())
            .setLastEventTime(Timestamp.newBuilder().build())
            .setLastStateTime(Timestamp.newBuilder().build())
            .setLastConfigAckTime(Timestamp.newBuilder().build())
            .setLastConfigSendTime(Timestamp.newBuilder().build())
            .setBlocked(true)
            .setLastErrorTime(Timestamp.newBuilder().build())
            .setLastErrorStatus(Status.newBuilder().build())
            .setConfig(DeviceConfig.newBuilder().build())
            .setState(DeviceState.newBuilder().build())
            .setLogLevel(LogLevel.forNumber(0))
            .putAllMetadata(new HashMap<String, String>())
            .setGatewayConfig(GatewayConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Device actualResponse = client.updateDevice(device, updateMask);
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
  public void updateDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Device device =
          Device.newBuilder()
              .setId("id3355")
              .setName(
                  DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
              .setNumId(-1034366860)
              .addAllCredentials(new ArrayList<DeviceCredential>())
              .setLastHeartbeatTime(Timestamp.newBuilder().build())
              .setLastEventTime(Timestamp.newBuilder().build())
              .setLastStateTime(Timestamp.newBuilder().build())
              .setLastConfigAckTime(Timestamp.newBuilder().build())
              .setLastConfigSendTime(Timestamp.newBuilder().build())
              .setBlocked(true)
              .setLastErrorTime(Timestamp.newBuilder().build())
              .setLastErrorStatus(Status.newBuilder().build())
              .setConfig(DeviceConfig.newBuilder().build())
              .setState(DeviceState.newBuilder().build())
              .setLogLevel(LogLevel.forNumber(0))
              .putAllMetadata(new HashMap<String, String>())
              .setGatewayConfig(GatewayConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDevice(device, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeviceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    client.deleteDevice(name);

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
  public void deleteDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      client.deleteDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDeviceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";

    client.deleteDevice(name);

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
  public void deleteDeviceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      client.deleteDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDevicesTest() throws Exception {
    Device responsesElement = Device.newBuilder().build();
    ListDevicesResponse expectedResponse =
        ListDevicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDevices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    ListDevicesPagedResponse pagedListResponse = client.listDevices(parent);

    List<Device> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDevicesList().get(0), resources.get(0));

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
  public void listDevicesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      client.listDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDevicesTest2() throws Exception {
    Device responsesElement = Device.newBuilder().build();
    ListDevicesResponse expectedResponse =
        ListDevicesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDevices(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";

    ListDevicesPagedResponse pagedListResponse = client.listDevices(parent);

    List<Device> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDevicesList().get(0), resources.get(0));

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
  public void listDevicesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
      client.listDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyCloudToDeviceConfigTest() throws Exception {
    DeviceConfig expectedResponse =
        DeviceConfig.newBuilder()
            .setVersion(351608024)
            .setCloudUpdateTime(Timestamp.newBuilder().build())
            .setDeviceAckTime(Timestamp.newBuilder().build())
            .setBinaryData(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.EMPTY;

    DeviceConfig actualResponse = client.modifyCloudToDeviceConfig(name, binaryData);
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
  public void modifyCloudToDeviceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      ByteString binaryData = ByteString.EMPTY;
      client.modifyCloudToDeviceConfig(name, binaryData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void modifyCloudToDeviceConfigTest2() throws Exception {
    DeviceConfig expectedResponse =
        DeviceConfig.newBuilder()
            .setVersion(351608024)
            .setCloudUpdateTime(Timestamp.newBuilder().build())
            .setDeviceAckTime(Timestamp.newBuilder().build())
            .setBinaryData(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
    ByteString binaryData = ByteString.EMPTY;

    DeviceConfig actualResponse = client.modifyCloudToDeviceConfig(name, binaryData);
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
  public void modifyCloudToDeviceConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      ByteString binaryData = ByteString.EMPTY;
      client.modifyCloudToDeviceConfig(name, binaryData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceConfigVersionsTest() throws Exception {
    ListDeviceConfigVersionsResponse expectedResponse =
        ListDeviceConfigVersionsResponse.newBuilder()
            .addAllDeviceConfigs(new ArrayList<DeviceConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    ListDeviceConfigVersionsResponse actualResponse = client.listDeviceConfigVersions(name);
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
  public void listDeviceConfigVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      client.listDeviceConfigVersions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceConfigVersionsTest2() throws Exception {
    ListDeviceConfigVersionsResponse expectedResponse =
        ListDeviceConfigVersionsResponse.newBuilder()
            .addAllDeviceConfigs(new ArrayList<DeviceConfig>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";

    ListDeviceConfigVersionsResponse actualResponse = client.listDeviceConfigVersions(name);
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
  public void listDeviceConfigVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      client.listDeviceConfigVersions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceStatesTest() throws Exception {
    ListDeviceStatesResponse expectedResponse =
        ListDeviceStatesResponse.newBuilder()
            .addAllDeviceStates(new ArrayList<DeviceState>())
            .build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    ListDeviceStatesResponse actualResponse = client.listDeviceStates(name);
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
  public void listDeviceStatesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      client.listDeviceStates(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDeviceStatesTest2() throws Exception {
    ListDeviceStatesResponse expectedResponse =
        ListDeviceStatesResponse.newBuilder()
            .addAllDeviceStates(new ArrayList<DeviceState>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";

    ListDeviceStatesResponse actualResponse = client.listDeviceStates(name);
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
  public void listDeviceStatesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      client.listDeviceStates(name);
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
    mockService.addResponse(expectedResponse);

    ResourceName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String resource = "projects/project-6248/locations/location-6248/registries/registrie-6248";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
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
  public void setIamPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "projects/project-6248/locations/location-6248/registries/registrie-6248";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
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
    mockService.addResponse(expectedResponse);

    ResourceName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    Policy actualResponse = client.getIamPolicy(resource);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String resource = "projects/project-6248/locations/location-6248/registries/registrie-6248";

    Policy actualResponse = client.getIamPolicy(resource);
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
  public void getIamPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "projects/project-6248/locations/location-6248/registries/registrie-6248";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    ResourceName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    String resource = "projects/project-6248/locations/location-6248/registries/registrie-6248";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
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
  public void testIamPermissionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "projects/project-6248/locations/location-6248/registries/registrie-6248";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendCommandToDeviceTest() throws Exception {
    SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.EMPTY;

    SendCommandToDeviceResponse actualResponse = client.sendCommandToDevice(name, binaryData);
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
  public void sendCommandToDeviceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      ByteString binaryData = ByteString.EMPTY;
      client.sendCommandToDevice(name, binaryData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendCommandToDeviceTest2() throws Exception {
    SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
    ByteString binaryData = ByteString.EMPTY;

    SendCommandToDeviceResponse actualResponse = client.sendCommandToDevice(name, binaryData);
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
  public void sendCommandToDeviceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      ByteString binaryData = ByteString.EMPTY;
      client.sendCommandToDevice(name, binaryData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendCommandToDeviceTest3() throws Exception {
    SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.EMPTY;
    String subfolder = "subfolder153561774";

    SendCommandToDeviceResponse actualResponse =
        client.sendCommandToDevice(name, binaryData, subfolder);
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
  public void sendCommandToDeviceExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      ByteString binaryData = ByteString.EMPTY;
      String subfolder = "subfolder153561774";
      client.sendCommandToDevice(name, binaryData, subfolder);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void sendCommandToDeviceTest4() throws Exception {
    SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
    ByteString binaryData = ByteString.EMPTY;
    String subfolder = "subfolder153561774";

    SendCommandToDeviceResponse actualResponse =
        client.sendCommandToDevice(name, binaryData, subfolder);
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
  public void sendCommandToDeviceExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6436/locations/location-6436/registries/registrie-6436/devices/device-6436";
      ByteString binaryData = ByteString.EMPTY;
      String subfolder = "subfolder153561774";
      client.sendCommandToDevice(name, binaryData, subfolder);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bindDeviceToGatewayTest() throws Exception {
    BindDeviceToGatewayResponse expectedResponse = BindDeviceToGatewayResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    BindDeviceToGatewayResponse actualResponse =
        client.bindDeviceToGateway(parent, gatewayId, deviceId);
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
  public void bindDeviceToGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      String gatewayId = "gatewayId-1354641793";
      String deviceId = "deviceId1109191185";
      client.bindDeviceToGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bindDeviceToGatewayTest2() throws Exception {
    BindDeviceToGatewayResponse expectedResponse = BindDeviceToGatewayResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    BindDeviceToGatewayResponse actualResponse =
        client.bindDeviceToGateway(parent, gatewayId, deviceId);
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
  public void bindDeviceToGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
      String gatewayId = "gatewayId-1354641793";
      String deviceId = "deviceId1109191185";
      client.bindDeviceToGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unbindDeviceFromGatewayTest() throws Exception {
    UnbindDeviceFromGatewayResponse expectedResponse =
        UnbindDeviceFromGatewayResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    UnbindDeviceFromGatewayResponse actualResponse =
        client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
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
  public void unbindDeviceFromGatewayExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      String gatewayId = "gatewayId-1354641793";
      String deviceId = "deviceId1109191185";
      client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void unbindDeviceFromGatewayTest2() throws Exception {
    UnbindDeviceFromGatewayResponse expectedResponse =
        UnbindDeviceFromGatewayResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    UnbindDeviceFromGatewayResponse actualResponse =
        client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
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
  public void unbindDeviceFromGatewayExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-6316/locations/location-6316/registries/registrie-6316";
      String gatewayId = "gatewayId-1354641793";
      String deviceId = "deviceId1109191185";
      client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
