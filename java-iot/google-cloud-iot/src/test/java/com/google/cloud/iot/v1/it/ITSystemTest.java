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
package com.google.cloud.iot.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.ServiceOptions;
import com.google.cloud.iot.v1.Device;
import com.google.cloud.iot.v1.DeviceConfig;
import com.google.cloud.iot.v1.DeviceManagerClient;
import com.google.cloud.iot.v1.DeviceManagerClient.ListDeviceRegistriesPagedResponse;
import com.google.cloud.iot.v1.DeviceManagerClient.ListDevicesPagedResponse;
import com.google.cloud.iot.v1.DeviceName;
import com.google.cloud.iot.v1.DeviceRegistry;
import com.google.cloud.iot.v1.DeviceState;
import com.google.cloud.iot.v1.GatewayAuthMethod;
import com.google.cloud.iot.v1.GatewayConfig;
import com.google.cloud.iot.v1.HttpConfig;
import com.google.cloud.iot.v1.HttpState;
import com.google.cloud.iot.v1.ListDeviceConfigVersionsResponse;
import com.google.cloud.iot.v1.ListDeviceStatesResponse;
import com.google.cloud.iot.v1.LocationName;
import com.google.cloud.iot.v1.MqttConfig;
import com.google.cloud.iot.v1.MqttState;
import com.google.cloud.iot.v1.RegistryName;
import com.google.common.collect.Lists;
import com.google.iam.v1.Policy;
import com.google.protobuf.ByteString;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static DeviceManagerClient client;
  private static DeviceRegistry deviceRegistry;
  private static Device device;

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String LOCATION = "us-central1";
  private static final String REGISTRY_ID = "test" + UUID.randomUUID().toString().substring(0, 8);
  private static final RegistryName REGISTRY_NAME =
      RegistryName.of(PROJECT_ID, LOCATION, REGISTRY_ID);
  private static final LocationName PARENT = LocationName.of(PROJECT_ID, LOCATION);
  private static final MqttConfig MQTT_CONFIG =
      MqttConfig.newBuilder().setMqttEnabledState(MqttState.MQTT_ENABLED).build();
  private static final HttpConfig HTTP_CONFIG =
      HttpConfig.newBuilder().setHttpEnabledState(HttpState.HTTP_ENABLED).build();
  private static final DeviceRegistry DEVICE_REGISTRY =
      DeviceRegistry.newBuilder()
          .setId(REGISTRY_ID)
          .setMqttConfig(MQTT_CONFIG)
          .setHttpConfig(HTTP_CONFIG)
          .build();
  private static final String DEVICE_ID =
      "test-device-" + UUID.randomUUID().toString().substring(0, 8);
  private static final DeviceName DEVICE_NAME =
      DeviceName.of(PROJECT_ID, LOCATION, REGISTRY_ID, DEVICE_ID);
  private static final DeviceState DEVICE_STATE =
      DeviceState.newBuilder().setBinaryData(ByteString.EMPTY).build();
  private static final boolean BLOCKED = true;
  private static final GatewayConfig GATEWAY_CONFIG =
      GatewayConfig.newBuilder()
          .setGatewayAuthMethod(GatewayAuthMethod.ASSOCIATION_AND_DEVICE_AUTH_TOKEN)
          .build();
  private static final Device DEVICE =
      Device.newBuilder()
          .setId(DEVICE_ID)
          .setBlocked(BLOCKED)
          .setGatewayConfig(GATEWAY_CONFIG)
          .setState(DEVICE_STATE)
          .build();

  @BeforeClass
  public static void beforeTest() throws Exception {
    client = DeviceManagerClient.create();
    deviceRegistry = client.createDeviceRegistry(PARENT, DEVICE_REGISTRY);
    if (deviceRegistry != null) {
      RegistryName parent = RegistryName.of(PROJECT_ID, LOCATION, REGISTRY_ID);
      device = client.createDevice(parent, DEVICE);
    }
  }

  @AfterClass
  public static void afterTest() {
    if (device != null) {
      client.deleteDevice(DEVICE_NAME);
    }
    if (deviceRegistry != null) {
      client.deleteDeviceRegistry(REGISTRY_NAME);
    }
    client.close();
  }

  @Test
  public void getDeviceRegistryTest() {
    DeviceRegistry registry = client.getDeviceRegistry(REGISTRY_NAME);
    assertEquals(REGISTRY_ID, registry.getId());
    assertEquals(MQTT_CONFIG, registry.getMqttConfig());
    assertEquals(HTTP_CONFIG, registry.getHttpConfig());
  }

  @Test
  public void listDeviceRegistryTest() {
    ListDeviceRegistriesPagedResponse pagedListResponse = client.listDeviceRegistries(PARENT);
    List<DeviceRegistry> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    for (DeviceRegistry registry : resources) {
      if (registry.equals(REGISTRY_ID)) {
        assertEquals(REGISTRY_ID, registry.getId());
        assertEquals(MQTT_CONFIG, registry.getMqttConfig());
        assertEquals(HTTP_CONFIG, registry.getHttpConfig());
      }
    }
  }

  @Test
  public void getDeviceTest() {
    Device device = client.getDevice(DEVICE_NAME);
    assertEquals(DEVICE_ID, device.getId());
    assertEquals(BLOCKED, device.getBlocked());
    assertEquals(GATEWAY_CONFIG, device.getGatewayConfig());
  }

  @Test
  public void listDeviceTest() {
    ListDevicesPagedResponse listDevices = client.listDevices(REGISTRY_NAME);
    List<Device> devices = Lists.newArrayList(listDevices.iterateAll());
    assertEquals(1, devices.size());
    for (Device device : devices) {
      if (device.equals(DEVICE_ID)) {
        assertEquals(DEVICE_ID, device.getId());
        assertEquals(BLOCKED, device.getBlocked());
        assertEquals(GATEWAY_CONFIG, device.getGatewayConfig());
      }
    }
  }

  @Test
  public void listDeviceStatesTest() {
    ListDeviceStatesResponse deviceStates = client.listDeviceStates(DEVICE_NAME);
    List<DeviceState> devices = deviceStates.getDeviceStatesList();
    assertEquals(0, devices.size());
  }

  @Test
  public void listDeviceConfigVersionsTest() {
    ListDeviceConfigVersionsResponse deviceConfigVersions =
        client.listDeviceConfigVersions(DEVICE_NAME);
    List<DeviceConfig> devicesConfigs = deviceConfigVersions.getDeviceConfigsList();
    assertEquals(1, devicesConfigs.size());
    for (DeviceConfig devicesConfig : devicesConfigs) {
      assertEquals(1, devicesConfig.getVersion());
    }
  }

  @Test
  public void getIamPolicyTest() {
    Policy policy = client.getIamPolicy(REGISTRY_NAME);
    assertNotNull(policy);
    assertEquals(0, policy.getVersion());
  }
}
