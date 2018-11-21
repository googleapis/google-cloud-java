/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DeviceManagerClientTest {
  private static MockDeviceManager mockDeviceManager;
  private static MockServiceHelper serviceHelper;
  private DeviceManagerClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDeviceManager = new MockDeviceManager();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockDeviceManager));
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
  @SuppressWarnings("all")
  public void createDeviceRegistryTest() {
    String id = "id3355";
    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder().setId(id).setName(name.toString()).build();
    mockDeviceManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();

    DeviceRegistry actualResponse = client.createDeviceRegistry(parent, deviceRegistry);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceRegistryRequest actualRequest = (CreateDeviceRegistryRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(deviceRegistry, actualRequest.getDeviceRegistry());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();

      client.createDeviceRegistry(parent, deviceRegistry);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDeviceRegistryTest() {
    String id = "id3355";
    RegistryName name2 = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder().setId(id).setName(name2.toString()).build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    DeviceRegistry actualResponse = client.getDeviceRegistry(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceRegistryRequest actualRequest = (GetDeviceRegistryRequest) actualRequests.get(0);

    Assert.assertEquals(name, RegistryName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

      client.getDeviceRegistry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeviceRegistryTest() {
    String id = "id3355";
    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    DeviceRegistry expectedResponse =
        DeviceRegistry.newBuilder().setId(id).setName(name.toString()).build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DeviceRegistry actualResponse = client.updateDeviceRegistry(deviceRegistry, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeviceRegistryRequest actualRequest = (UpdateDeviceRegistryRequest) actualRequests.get(0);

    Assert.assertEquals(deviceRegistry, actualRequest.getDeviceRegistry());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateDeviceRegistry(deviceRegistry, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDeviceRegistryTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    client.deleteDeviceRegistry(name);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeviceRegistryRequest actualRequest = (DeleteDeviceRegistryRequest) actualRequests.get(0);

    Assert.assertEquals(name, RegistryName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDeviceRegistryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName name = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

      client.deleteDeviceRegistry(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDeviceRegistriesTest() {
    String nextPageToken = "";
    DeviceRegistry deviceRegistriesElement = DeviceRegistry.newBuilder().build();
    List<DeviceRegistry> deviceRegistries = Arrays.asList(deviceRegistriesElement);
    ListDeviceRegistriesResponse expectedResponse =
        ListDeviceRegistriesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDeviceRegistries(deviceRegistries)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDeviceRegistriesPagedResponse pagedListResponse = client.listDeviceRegistries(parent);

    List<DeviceRegistry> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDeviceRegistriesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceRegistriesRequest actualRequest = (ListDeviceRegistriesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDeviceRegistriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listDeviceRegistries(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createDeviceTest() {
    String id = "id3355";
    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    long numId = 1034366860L;
    boolean blocked = true;
    Device expectedResponse =
        Device.newBuilder()
            .setId(id)
            .setName(name.toString())
            .setNumId(numId)
            .setBlocked(blocked)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    Device device = Device.newBuilder().build();

    Device actualResponse = client.createDevice(parent, device);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDeviceRequest actualRequest = (CreateDeviceRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegistryName.parse(actualRequest.getParent()));
    Assert.assertEquals(device, actualRequest.getDevice());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      Device device = Device.newBuilder().build();

      client.createDevice(parent, device);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getDeviceTest() {
    String id = "id3355";
    DeviceName name2 = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    long numId = 1034366860L;
    boolean blocked = true;
    Device expectedResponse =
        Device.newBuilder()
            .setId(id)
            .setName(name2.toString())
            .setNumId(numId)
            .setBlocked(blocked)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    Device actualResponse = client.getDevice(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDeviceRequest actualRequest = (GetDeviceRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeviceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

      client.getDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeviceTest() {
    String id = "id3355";
    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    long numId = 1034366860L;
    boolean blocked = true;
    Device expectedResponse =
        Device.newBuilder()
            .setId(id)
            .setName(name.toString())
            .setNumId(numId)
            .setBlocked(blocked)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    Device device = Device.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Device actualResponse = client.updateDevice(device, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDeviceRequest actualRequest = (UpdateDeviceRequest) actualRequests.get(0);

    Assert.assertEquals(device, actualRequest.getDevice());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      Device device = Device.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateDevice(device, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDeviceTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    client.deleteDevice(name);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDeviceRequest actualRequest = (DeleteDeviceRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeviceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

      client.deleteDevice(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDevicesTest() {
    String nextPageToken = "";
    Device devicesElement = Device.newBuilder().build();
    List<Device> devices = Arrays.asList(devicesElement);
    ListDevicesResponse expectedResponse =
        ListDevicesResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllDevices(devices)
            .build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    ListDevicesPagedResponse pagedListResponse = client.listDevices(parent);

    List<Device> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDevicesList().get(0), resources.get(0));

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDevicesRequest actualRequest = (ListDevicesRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegistryName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDevicesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

      client.listDevices(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void modifyCloudToDeviceConfigTest() {
    long version = 351608024L;
    ByteString binaryData2 = ByteString.copyFromUtf8("-37");
    DeviceConfig expectedResponse =
        DeviceConfig.newBuilder().setVersion(version).setBinaryData(binaryData2).build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.copyFromUtf8("40");

    DeviceConfig actualResponse = client.modifyCloudToDeviceConfig(name, binaryData);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ModifyCloudToDeviceConfigRequest actualRequest =
        (ModifyCloudToDeviceConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeviceName.parse(actualRequest.getName()));
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void modifyCloudToDeviceConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      ByteString binaryData = ByteString.copyFromUtf8("40");

      client.modifyCloudToDeviceConfig(name, binaryData);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDeviceConfigVersionsTest() {
    ListDeviceConfigVersionsResponse expectedResponse =
        ListDeviceConfigVersionsResponse.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    ListDeviceConfigVersionsResponse actualResponse = client.listDeviceConfigVersions(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceConfigVersionsRequest actualRequest =
        (ListDeviceConfigVersionsRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeviceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDeviceConfigVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

      client.listDeviceConfigVersions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listDeviceStatesTest() {
    ListDeviceStatesResponse expectedResponse = ListDeviceStatesResponse.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

    ListDeviceStatesResponse actualResponse = client.listDeviceStates(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDeviceStatesRequest actualRequest = (ListDeviceStatesRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeviceName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listDeviceStatesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");

      client.listDeviceStates(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");

      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(Objects.toString(resource), Objects.toString(actualRequest.getResource()));
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName resource = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void sendCommandToDeviceTest() {
    SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
    ByteString binaryData = ByteString.copyFromUtf8("40");
    String subfolder = "subfolder153561774";

    SendCommandToDeviceResponse actualResponse =
        client.sendCommandToDevice(name, binaryData, subfolder);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SendCommandToDeviceRequest actualRequest = (SendCommandToDeviceRequest) actualRequests.get(0);

    Assert.assertEquals(name, DeviceName.parse(actualRequest.getName()));
    Assert.assertEquals(binaryData, actualRequest.getBinaryData());
    Assert.assertEquals(subfolder, actualRequest.getSubfolder());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void sendCommandToDeviceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      DeviceName name = DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]");
      ByteString binaryData = ByteString.copyFromUtf8("40");
      String subfolder = "subfolder153561774";

      client.sendCommandToDevice(name, binaryData, subfolder);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void bindDeviceToGatewayTest() {
    BindDeviceToGatewayResponse expectedResponse = BindDeviceToGatewayResponse.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    String gatewayId = "gatewayId955798774";
    String deviceId = "deviceId25209764";

    BindDeviceToGatewayResponse actualResponse =
        client.bindDeviceToGateway(parent, gatewayId, deviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BindDeviceToGatewayRequest actualRequest = (BindDeviceToGatewayRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegistryName.parse(actualRequest.getParent()));
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertEquals(deviceId, actualRequest.getDeviceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void bindDeviceToGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      String gatewayId = "gatewayId955798774";
      String deviceId = "deviceId25209764";

      client.bindDeviceToGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void unbindDeviceFromGatewayTest() {
    UnbindDeviceFromGatewayResponse expectedResponse =
        UnbindDeviceFromGatewayResponse.newBuilder().build();
    mockDeviceManager.addResponse(expectedResponse);

    RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
    String gatewayId = "gatewayId955798774";
    String deviceId = "deviceId25209764";

    UnbindDeviceFromGatewayResponse actualResponse =
        client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDeviceManager.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UnbindDeviceFromGatewayRequest actualRequest =
        (UnbindDeviceFromGatewayRequest) actualRequests.get(0);

    Assert.assertEquals(parent, RegistryName.parse(actualRequest.getParent()));
    Assert.assertEquals(gatewayId, actualRequest.getGatewayId());
    Assert.assertEquals(deviceId, actualRequest.getDeviceId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void unbindDeviceFromGatewayExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDeviceManager.addException(exception);

    try {
      RegistryName parent = RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]");
      String gatewayId = "gatewayId955798774";
      String deviceId = "deviceId25209764";

      client.unbindDeviceFromGateway(parent, gatewayId, deviceId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
