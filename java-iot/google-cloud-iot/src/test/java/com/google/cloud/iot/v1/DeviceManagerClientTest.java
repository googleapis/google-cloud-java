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

package com.google.cloud.iot.v1;

import static com.google.cloud.iot.v1.DeviceManagerClient.ListDeviceRegistriesPagedResponse;
import static com.google.cloud.iot.v1.DeviceManagerClient.ListDevicesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DeviceManagerClientTest {
  private static MockDeviceManager mockDeviceManager;
  private static MockServiceHelper mockServiceHelper;
  private DeviceManagerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDeviceManager = new MockDeviceManager();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDeviceManager));
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
    DeviceManagerSettings settings =
        DeviceManagerSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DeviceManagerClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockDeviceManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();

    DeviceRegistry actualResponse = client.createDeviceRegistry(parent, deviceRegistry);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceRegistryRequest actualRequest =
        ((CreateDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(deviceRegistry, actualRequest.getDeviceRegistry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();

    DeviceRegistry actualResponse = client.createDeviceRegistry(parent, deviceRegistry);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceRegistryRequest actualRequest =
        ((CreateDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(deviceRegistry, actualRequest.getDeviceRegistry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeviceRegistryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    DeviceRegistry actualResponse = client.getDeviceRegistry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceRegistryRequest actualRequest = ((GetDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";

    DeviceRegistry actualResponse = client.getDeviceRegistry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceRegistryRequest actualRequest = ((GetDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeviceRegistryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeviceRegistry actualResponse = client.updateDeviceRegistry(deviceRegistry, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeviceRegistryRequest actualRequest =
        ((UpdateDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(deviceRegistry, actualRequest.getDeviceRegistry());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
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
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    client.deleteDeviceRegistry(name);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeviceRegistryRequest actualRequest =
        ((DeleteDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDeviceRegistry(name);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeviceRegistryRequest actualRequest =
        ((DeleteDeviceRegistryRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeviceRegistryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeviceRegistriesPagedResponse pagedListResponse = client.listDeviceRegistries(parent);

    List<DeviceRegistry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceRegistriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceRegistriesRequest actualRequest =
        ((ListDeviceRegistriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceRegistriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDeviceRegistriesPagedResponse pagedListResponse = client.listDeviceRegistries(parent);

    List<DeviceRegistry> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceRegistriesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceRegistriesRequest actualRequest =
        ((ListDeviceRegistriesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceRegistriesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    Device device = Device.newBuilder().build();

    Device actualResponse = client.createDevice(parent, device);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceRequest actualRequest = ((CreateDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(device, actualRequest.getDevice());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Device device = Device.newBuilder().build();

    Device actualResponse = client.createDevice(parent, device);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceRequest actualRequest = ((CreateDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(device, actualRequest.getDevice());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDeviceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    Device actualResponse = client.getDevice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceRequest actualRequest = ((GetDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";

    Device actualResponse = client.getDevice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceRequest actualRequest = ((GetDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDeviceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    Device device = Device.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Device actualResponse = client.updateDevice(device, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeviceRequest actualRequest = ((UpdateDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(device, actualRequest.getDevice());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      Device device = Device.newBuilder().build();
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    client.deleteDevice(name);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeviceRequest actualRequest = ((DeleteDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDevice(name);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeviceRequest actualRequest = ((DeleteDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDeviceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    ListDevicesPagedResponse pagedListResponse = client.listDevices(parent);

    List<Device> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDevicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDevicesRequest actualRequest = ((ListDevicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDevicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDevicesPagedResponse pagedListResponse = client.listDevices(parent);

    List<Device> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDevicesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDevicesRequest actualRequest = ((ListDevicesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDevicesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.EMPTY;

    DeviceConfig actualResponse = client.modifyCloudToDeviceConfig(name, binaryData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyCloudToDeviceConfigRequest actualRequest =
        ((ModifyCloudToDeviceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyCloudToDeviceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";
    ByteString binaryData = ByteString.EMPTY;

    DeviceConfig actualResponse = client.modifyCloudToDeviceConfig(name, binaryData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyCloudToDeviceConfigRequest actualRequest =
        ((ModifyCloudToDeviceConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void modifyCloudToDeviceConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    ListDeviceConfigVersionsResponse actualResponse = client.listDeviceConfigVersions(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceConfigVersionsRequest actualRequest =
        ((ListDeviceConfigVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceConfigVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";

    ListDeviceConfigVersionsResponse actualResponse = client.listDeviceConfigVersions(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceConfigVersionsRequest actualRequest =
        ((ListDeviceConfigVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceConfigVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    ListDeviceStatesResponse actualResponse = client.listDeviceStates(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceStatesRequest actualRequest = ((ListDeviceStatesRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceStatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";

    ListDeviceStatesResponse actualResponse = client.listDeviceStates(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceStatesRequest actualRequest = ((ListDeviceStatesRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDeviceStatesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String resource = "resource-341064690";
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
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
            .setEtag(ByteString.EMPTY)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String resource = "resource-341064690";
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
    mockDeviceManager.addResponse(expectedResponse);

    ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      ResourceName resource = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockDeviceManager.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String resource = "resource-341064690";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.EMPTY;

    SendCommandToDeviceResponse actualResponse = client.sendCommandToDevice(name, binaryData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendCommandToDeviceRequest actualRequest = ((SendCommandToDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendCommandToDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";
    ByteString binaryData = ByteString.EMPTY;

    SendCommandToDeviceResponse actualResponse = client.sendCommandToDevice(name, binaryData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendCommandToDeviceRequest actualRequest = ((SendCommandToDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendCommandToDeviceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.EMPTY;
    String subfolder = "subfolder153561774";

    SendCommandToDeviceResponse actualResponse =
        client.sendCommandToDevice(name, binaryData, subfolder);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendCommandToDeviceRequest actualRequest = ((SendCommandToDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertEquals(subfolder, actualRequest.getSubfolder());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendCommandToDeviceExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String name = "name3373707";
    ByteString binaryData = ByteString.EMPTY;
    String subfolder = "subfolder153561774";

    SendCommandToDeviceResponse actualResponse =
        client.sendCommandToDevice(name, binaryData, subfolder);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendCommandToDeviceRequest actualRequest = ((SendCommandToDeviceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertEquals(subfolder, actualRequest.getSubfolder());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void sendCommandToDeviceExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String name = "name3373707";
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
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    BindDeviceToGatewayResponse actualResponse =
        client.bindDeviceToGateway(parent, gatewayId, deviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BindDeviceToGatewayRequest actualRequest = ((BindDeviceToGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertEquals(deviceId, actualRequest.getDeviceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bindDeviceToGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    BindDeviceToGatewayResponse actualResponse =
        client.bindDeviceToGateway(parent, gatewayId, deviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BindDeviceToGatewayRequest actualRequest = ((BindDeviceToGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertEquals(deviceId, actualRequest.getDeviceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bindDeviceToGatewayExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    UnbindDeviceFromGatewayResponse actualResponse =
        client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnbindDeviceFromGatewayRequest actualRequest =
        ((UnbindDeviceFromGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertEquals(deviceId, actualRequest.getDeviceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unbindDeviceFromGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

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
    mockDeviceManager.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String gatewayId = "gatewayId-1354641793";
    String deviceId = "deviceId1109191185";

    UnbindDeviceFromGatewayResponse actualResponse =
        client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnbindDeviceFromGatewayRequest actualRequest =
        ((UnbindDeviceFromGatewayRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertEquals(deviceId, actualRequest.getDeviceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void unbindDeviceFromGatewayExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      String parent = "parent-995424086";
      String gatewayId = "gatewayId-1354641793";
      String deviceId = "deviceId1109191185";
      client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
