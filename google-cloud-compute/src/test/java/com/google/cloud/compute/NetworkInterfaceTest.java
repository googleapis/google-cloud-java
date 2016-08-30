/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class NetworkInterfaceTest {

  private static final String NAME = "networkInterface";
  private static final NetworkId NETWORK = NetworkId.of("project", "network");
  private static final String NETWORK_IP = "192.168.1.1";
  private static final SubnetworkId SUBNETWORK = SubnetworkId.of("project", "region", "subnetwork");
  private static final NetworkInterface.AccessConfig ACCESS_CONFIG = NetworkInterface.AccessConfig.builder()
      .name("accessConfig")
      .natIp("192.168.1.1")
      .type(NetworkInterface.AccessConfig.Type.ONE_TO_ONE_NAT)
      .build();
  private static final List<NetworkInterface.AccessConfig> ACCESS_CONFIGURATIONS =
      ImmutableList.of(ACCESS_CONFIG);
  private static final NetworkInterface NETWORK_INTERFACE = NetworkInterface.builder(NETWORK)
          .name(NAME)
          .networkIp(NETWORK_IP)
          .subnetwork(SUBNETWORK)
          .accessConfigurations(ACCESS_CONFIGURATIONS)
          .build();

  @Test
  public void testAccessConfigToBuilder() {
    NetworkInterface.AccessConfig accessConfig = ACCESS_CONFIG.toBuilder().name("newName").build();
    assertEquals("newName", accessConfig.name());
    compareAccessConfig(ACCESS_CONFIG, accessConfig.toBuilder().name("accessConfig").build());
  }

  @Test
  public void testAccessConfigToBuilderIncomplete() {
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.of();
    compareAccessConfig(accessConfig, accessConfig.toBuilder().build());
  }

  @Test
  public void testToBuilder() {
    compareNetworkInterface(NETWORK_INTERFACE, NETWORK_INTERFACE.toBuilder().build());
    NetworkInterface networkInterface = NETWORK_INTERFACE.toBuilder().name("newInterface").build();
    assertEquals("newInterface", networkInterface.name());
    networkInterface = networkInterface.toBuilder().name(NAME).build();
    compareNetworkInterface(NETWORK_INTERFACE, networkInterface);
  }

  @Test
  public void testToBuilderIncomplete() {
    NetworkInterface networkInterface = NetworkInterface.of(NETWORK);
    assertEquals(networkInterface, networkInterface.toBuilder().build());
    networkInterface = NetworkInterface.of(NETWORK.network());
    assertEquals(networkInterface, networkInterface.toBuilder().build());
  }

  @Test
  public void testAccessConfigBuilder() {
    assertEquals("accessConfig", ACCESS_CONFIG.name());
    assertEquals("192.168.1.1", ACCESS_CONFIG.natIp());
    Assert.assertEquals(NetworkInterface.AccessConfig.Type.ONE_TO_ONE_NAT, ACCESS_CONFIG.type());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, NETWORK_INTERFACE.name());
    assertEquals(NETWORK, NETWORK_INTERFACE.network());
    assertEquals(NETWORK_IP, NETWORK_INTERFACE.networkIp());
    assertEquals(SUBNETWORK, NETWORK_INTERFACE.subnetwork());
    assertEquals(ACCESS_CONFIGURATIONS, NETWORK_INTERFACE.accessConfigurations());
    NetworkInterface networkInterface = NetworkInterface.builder("network")
        .name(NAME)
        .networkIp(NETWORK_IP)
        .subnetwork(SUBNETWORK)
        .accessConfigurations(ACCESS_CONFIG)
        .build();
    assertEquals(NAME, networkInterface.name());
    assertEquals(NetworkId.of("network"), networkInterface.network());
    assertEquals(NETWORK_IP, networkInterface.networkIp());
    assertEquals(SUBNETWORK, networkInterface.subnetwork());
    assertEquals(ACCESS_CONFIGURATIONS, networkInterface.accessConfigurations());
  }

  @Test
  public void testAccessConfigOf() {
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.of("192.168.1.1");
    assertNull(accessConfig.name());
    assertEquals("192.168.1.1", accessConfig.natIp());
    assertNull(accessConfig.type());
    accessConfig = NetworkInterface.AccessConfig.of();
    assertNull(accessConfig.name());
    assertNull(accessConfig.natIp());
    assertNull(accessConfig.type());
  }

  @Test
  public void testOf() {
    NetworkInterface networkInterface = NetworkInterface.of(NETWORK);
    assertNull(networkInterface.name());
    assertEquals(NETWORK, networkInterface.network());
    assertNull(networkInterface.networkIp());
    assertNull(networkInterface.subnetwork());
    networkInterface = NetworkInterface.of(NETWORK.network());
    assertNull(networkInterface.name());
    assertNull(networkInterface.network().project());
    assertEquals(NETWORK.network(), networkInterface.network().network());
    assertNull(networkInterface.networkIp());
    assertNull(networkInterface.subnetwork());
  }

  @Test
  public void testAccessConfigToAndFromPb() {
    NetworkInterface.AccessConfig accessConfig = NetworkInterface.AccessConfig.fromPb(ACCESS_CONFIG.toPb());
    compareAccessConfig(ACCESS_CONFIG, accessConfig);
    accessConfig = NetworkInterface.AccessConfig.of();
    compareAccessConfig(accessConfig, NetworkInterface.AccessConfig.fromPb(accessConfig.toPb()));
  }

  @Test
  public void testToAndFromPb() {
    NetworkInterface networkInterface = NetworkInterface.fromPb(NETWORK_INTERFACE.toPb());
    compareNetworkInterface(NETWORK_INTERFACE, networkInterface);
    networkInterface = NetworkInterface.of(NETWORK);
    compareNetworkInterface(networkInterface, NetworkInterface.fromPb(networkInterface.toPb()));
  }

  @Test
  public void testSetProjectId() {
    NetworkInterface networkInterface = NetworkInterface.of(NETWORK);
    compareNetworkInterface(networkInterface,
        NetworkInterface.of(NetworkId.of("network")).setProjectId("project"));
    networkInterface = NETWORK_INTERFACE.toBuilder()
        .network(NetworkId.of("network"))
        .subnetwork(SubnetworkId.of("region", "subnetwork"))
        .build();
    compareNetworkInterface(NETWORK_INTERFACE, networkInterface.setProjectId("project"));
  }

  public void compareAccessConfig(NetworkInterface.AccessConfig expected, NetworkInterface.AccessConfig value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.natIp(), value.natIp());
    assertEquals(expected.type(), value.type());
    assertEquals(expected.hashCode(), value.hashCode());
  }

  public void compareNetworkInterface(NetworkInterface expected, NetworkInterface value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.network(), value.network());
    assertEquals(expected.networkIp(), value.networkIp());
    assertEquals(expected.subnetwork(), value.subnetwork());
    assertEquals(expected.accessConfigurations(), value.accessConfigurations());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
