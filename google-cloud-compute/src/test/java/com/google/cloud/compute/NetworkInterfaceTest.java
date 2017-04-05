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

import com.google.cloud.compute.NetworkInterface.AccessConfig;
import com.google.common.collect.ImmutableList;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class NetworkInterfaceTest {

  private static final String NAME = "networkInterface";
  private static final NetworkId NETWORK = NetworkId.of("project", "network");
  private static final String NETWORK_IP = "192.168.1.1";
  private static final SubnetworkId SUBNETWORK = SubnetworkId.of("project", "region", "subnetwork");
  private static final AccessConfig ACCESS_CONFIG =
      AccessConfig.newBuilder()
          .setName("accessConfig")
          .setNatIp("192.168.1.1")
          .setType(AccessConfig.Type.ONE_TO_ONE_NAT)
          .build();
  private static final List<AccessConfig> ACCESS_CONFIGURATIONS =
      ImmutableList.of(ACCESS_CONFIG);
  private static final NetworkInterface NETWORK_INTERFACE = NetworkInterface.newBuilder(NETWORK)
          .setName(NAME)
          .setNetworkIp(NETWORK_IP)
          .setSubnetwork(SUBNETWORK)
          .setAccessConfigurations(ACCESS_CONFIGURATIONS)
          .build();

  @Test
  public void testAccessConfigToBuilder() {
    AccessConfig accessConfig =
        ACCESS_CONFIG.toBuilder().setName("newName").build();
    assertEquals("newName", accessConfig.getName());
    compareAccessConfig(ACCESS_CONFIG, accessConfig.toBuilder().setName("accessConfig").build());
  }

  @Test
  public void testAccessConfigToBuilderIncomplete() {
    AccessConfig accessConfig = AccessConfig.of();
    compareAccessConfig(accessConfig, accessConfig.toBuilder().build());
  }

  @Test
  public void testToBuilder() {
    compareNetworkInterface(NETWORK_INTERFACE, NETWORK_INTERFACE.toBuilder().build());
    NetworkInterface networkInterface =
        NETWORK_INTERFACE.toBuilder().setName("newInterface").build();
    assertEquals("newInterface", networkInterface.getName());
    networkInterface = networkInterface.toBuilder().setName(NAME).build();
    compareNetworkInterface(NETWORK_INTERFACE, networkInterface);
  }

  @Test
  public void testToBuilderIncomplete() {
    NetworkInterface networkInterface = NetworkInterface.of(NETWORK);
    assertEquals(networkInterface, networkInterface.toBuilder().build());
    networkInterface = NetworkInterface.of(NETWORK.getNetwork());
    assertEquals(networkInterface, networkInterface.toBuilder().build());
  }

  @Test
  public void testAccessConfigBuilder() {
    assertEquals("accessConfig", ACCESS_CONFIG.getName());
    assertEquals("192.168.1.1", ACCESS_CONFIG.getNatIp());
    assertEquals(AccessConfig.Type.ONE_TO_ONE_NAT, ACCESS_CONFIG.getType());
  }

  @Test
  public void testBuilder() {
    assertEquals(NAME, NETWORK_INTERFACE.getName());
    assertEquals(NETWORK, NETWORK_INTERFACE.getNetwork());
    assertEquals(NETWORK_IP, NETWORK_INTERFACE.getNetworkIp());
    assertEquals(SUBNETWORK, NETWORK_INTERFACE.getSubnetwork());
    assertEquals(ACCESS_CONFIGURATIONS, NETWORK_INTERFACE.getAccessConfigurations());
    NetworkInterface networkInterface = NetworkInterface.newBuilder("network")
        .setName(NAME)
        .setNetworkIp(NETWORK_IP)
        .setSubnetwork(SUBNETWORK)
        .setAccessConfigurations(ACCESS_CONFIG)
        .build();
    assertEquals(NAME, networkInterface.getName());
    assertEquals(NetworkId.of("network"), networkInterface.getNetwork());
    assertEquals(NETWORK_IP, networkInterface.getNetworkIp());
    assertEquals(SUBNETWORK, networkInterface.getSubnetwork());
    assertEquals(ACCESS_CONFIGURATIONS, networkInterface.getAccessConfigurations());
  }

  @Test
  public void testAccessConfigOf() {
    AccessConfig accessConfig = AccessConfig.of("192.168.1.1");
    assertNull(accessConfig.getName());
    assertEquals("192.168.1.1", accessConfig.getNatIp());
    assertNull(accessConfig.getType());
    accessConfig = AccessConfig.of();
    assertNull(accessConfig.getName());
    assertNull(accessConfig.getNatIp());
    assertNull(accessConfig.getType());
  }

  @Test
  public void testOf() {
    NetworkInterface networkInterface = NetworkInterface.of(NETWORK);
    assertNull(networkInterface.getName());
    assertEquals(NETWORK, networkInterface.getNetwork());
    assertNull(networkInterface.getNetworkIp());
    assertNull(networkInterface.getSubnetwork());
    networkInterface = NetworkInterface.of(NETWORK.getNetwork());
    assertNull(networkInterface.getName());
    assertNull(networkInterface.getNetwork().getProject());
    assertEquals(NETWORK.getNetwork(), networkInterface.getNetwork().getNetwork());
    assertNull(networkInterface.getNetworkIp());
    assertNull(networkInterface.getSubnetwork());
  }

  @Test
  public void testAccessConfigToAndFromPb() {
    AccessConfig accessConfig =
        AccessConfig.fromPb(ACCESS_CONFIG.toPb());
    compareAccessConfig(ACCESS_CONFIG, accessConfig);
    accessConfig = AccessConfig.of();
    compareAccessConfig(accessConfig, AccessConfig.fromPb(accessConfig.toPb()));
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
        .setNetwork(NetworkId.of("network"))
        .setSubnetwork(SubnetworkId.of("region", "subnetwork"))
        .build();
    compareNetworkInterface(NETWORK_INTERFACE, networkInterface.setProjectId("project"));
  }

  public void compareAccessConfig(AccessConfig expected, AccessConfig value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getNatIp(), value.getNatIp());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
  }

  public void compareNetworkInterface(NetworkInterface expected, NetworkInterface value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getNetwork(), value.getNetwork());
    assertEquals(expected.getNetworkIp(), value.getNetworkIp());
    assertEquals(expected.getSubnetwork(), value.getSubnetwork());
    assertEquals(expected.getAccessConfigurations(), value.getAccessConfigurations());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
