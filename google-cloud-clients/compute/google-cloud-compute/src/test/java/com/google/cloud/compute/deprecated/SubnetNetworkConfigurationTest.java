/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class SubnetNetworkConfigurationTest {

  private static final Boolean AUTO_CREATE_SUBNETWORKS = true;
  private static final List<SubnetworkId> SUBNETWORKS =
      ImmutableList.of(
          SubnetworkId.of("project", "region", "subnetwork1"),
          SubnetworkId.of("project", "region", "subnetwork2"));
  private static final SubnetNetworkConfiguration NETWORK_CONFIGURATION =
      new SubnetNetworkConfiguration(AUTO_CREATE_SUBNETWORKS, SUBNETWORKS);

  @Test
  public void testConstructor() {
    assertEquals(AUTO_CREATE_SUBNETWORKS, NETWORK_CONFIGURATION.autoCreateSubnetworks());
    assertEquals(NetworkConfiguration.Type.SUBNET, NETWORK_CONFIGURATION.getType());
    assertEquals(SUBNETWORKS, NETWORK_CONFIGURATION.getSubnetworks());
    assertEquals(NetworkConfiguration.Type.SUBNET, NETWORK_CONFIGURATION.getType());
    SubnetNetworkConfiguration networkConfiguration =
        new SubnetNetworkConfiguration(AUTO_CREATE_SUBNETWORKS, null);
    assertEquals(NetworkConfiguration.Type.SUBNET, networkConfiguration.getType());
    assertEquals(AUTO_CREATE_SUBNETWORKS, networkConfiguration.autoCreateSubnetworks());
    assertNull(networkConfiguration.getSubnetworks());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(
        NetworkConfiguration.fromPb(NETWORK_CONFIGURATION.toPb())
            instanceof SubnetNetworkConfiguration);
    compareNetworkConfiguration(
        NETWORK_CONFIGURATION,
        NetworkConfiguration.<SubnetNetworkConfiguration>fromPb(NETWORK_CONFIGURATION.toPb()));
    SubnetNetworkConfiguration networkConfiguration =
        new SubnetNetworkConfiguration(AUTO_CREATE_SUBNETWORKS, null);
    assertTrue(
        NetworkConfiguration.fromPb(networkConfiguration.toPb())
            instanceof SubnetNetworkConfiguration);
    compareNetworkConfiguration(
        networkConfiguration,
        NetworkConfiguration.<SubnetNetworkConfiguration>fromPb(networkConfiguration.toPb()));
  }

  @Test
  public void testOf() {
    SubnetNetworkConfiguration configuration =
        SubnetNetworkConfiguration.of(AUTO_CREATE_SUBNETWORKS);
    assertEquals(AUTO_CREATE_SUBNETWORKS, configuration.autoCreateSubnetworks());
    assertNull(configuration.getSubnetworks());
    assertEquals(NetworkConfiguration.Type.SUBNET, configuration.getType());
  }

  private void compareNetworkConfiguration(
      SubnetNetworkConfiguration expected, SubnetNetworkConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.autoCreateSubnetworks(), value.autoCreateSubnetworks());
    assertEquals(expected.getSubnetworks(), value.getSubnetworks());
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
