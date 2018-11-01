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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class NetworkInfoTest {

  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final SubnetworkId SUBNETWORK1 = SubnetworkId.of("project", "region1", "network1");
  private static final SubnetworkId SUBNETWORK2 = SubnetworkId.of("project", "region2", "network2");
  private static final List<SubnetworkId> SUBNETWORKS = ImmutableList.of(SUBNETWORK1, SUBNETWORK2);
  private static final String GATEWAY_ADDRESS = "192.168.1.1";
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final String IP_RANGE = "192.168.0.0/16";
  private static final Boolean AUTO_CREATE_SUBNETWORKS = true;
  private static final StandardNetworkConfiguration NETWORK_CONFIGURATION =
      new StandardNetworkConfiguration(IP_RANGE, GATEWAY_ADDRESS);
  private static final SubnetNetworkConfiguration SUBNET_NETWORK_CONFIGURATION =
      new SubnetNetworkConfiguration(AUTO_CREATE_SUBNETWORKS, SUBNETWORKS);
  private static final NetworkInfo NETWORK_INFO =
      NetworkInfo.newBuilder(NETWORK_ID, NETWORK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .build();
  private static final NetworkInfo SUBNET_NETWORK_INFO =
      NetworkInfo.newBuilder(NETWORK_ID, SUBNET_NETWORK_CONFIGURATION)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .build();

  @Test
  public void testToBuilder() {
    compareNetworkInfo(NETWORK_INFO, NETWORK_INFO.toBuilder().build());
    NetworkInfo networkInfo = NETWORK_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", networkInfo.getDescription());
    networkInfo = networkInfo.toBuilder().setDescription("description").build();
    compareNetworkInfo(NETWORK_INFO, networkInfo);
    compareNetworkInfo(SUBNET_NETWORK_INFO, SUBNET_NETWORK_INFO.toBuilder().build());
    networkInfo = SUBNET_NETWORK_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", networkInfo.getDescription());
    networkInfo = networkInfo.toBuilder().setDescription("description").build();
    compareNetworkInfo(SUBNET_NETWORK_INFO, networkInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    NetworkInfo networkInfo = NetworkInfo.of(NETWORK_ID, NETWORK_CONFIGURATION);
    assertEquals(networkInfo, networkInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, NETWORK_INFO.getGeneratedId());
    assertEquals(NETWORK_ID, NETWORK_INFO.getNetworkId());
    assertEquals(CREATION_TIMESTAMP, NETWORK_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, NETWORK_INFO.getDescription());
    assertEquals(NETWORK_CONFIGURATION, NETWORK_INFO.getConfiguration());
    assertEquals(GENERATED_ID, SUBNET_NETWORK_INFO.getGeneratedId());
    assertEquals(NETWORK_ID, SUBNET_NETWORK_INFO.getNetworkId());
    assertEquals(CREATION_TIMESTAMP, SUBNET_NETWORK_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, SUBNET_NETWORK_INFO.getDescription());
    assertEquals(SUBNET_NETWORK_CONFIGURATION, SUBNET_NETWORK_INFO.getConfiguration());
  }

  @Test
  public void testOf() {
    NetworkInfo networkInfo = NetworkInfo.of(NETWORK_ID, NETWORK_CONFIGURATION);
    assertNull(networkInfo.getGeneratedId());
    assertEquals(NETWORK_ID, NETWORK_INFO.getNetworkId());
    assertEquals(NETWORK_CONFIGURATION, NETWORK_INFO.getConfiguration());
    assertNull(networkInfo.getCreationTimestamp());
    assertNull(networkInfo.getDescription());
  }

  @Test
  public void testToAndFromPb() {
    compareNetworkInfo(NETWORK_INFO, NetworkInfo.fromPb(NETWORK_INFO.toPb()));
    compareNetworkInfo(SUBNET_NETWORK_INFO, NetworkInfo.fromPb(SUBNET_NETWORK_INFO.toPb()));
    NetworkInfo networkInfo = NetworkInfo.of(NETWORK_ID, NETWORK_CONFIGURATION);
    compareNetworkInfo(networkInfo, NetworkInfo.fromPb(networkInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    NetworkInfo networkInfo = NETWORK_INFO.toBuilder()
        .setNetworkId(NetworkId.of("network"))
        .build();
    compareNetworkInfo(NETWORK_INFO, networkInfo.setProjectId("project"));
  }

  public void compareNetworkInfo(NetworkInfo expected, NetworkInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getNetworkId(), value.getNetworkId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getConfiguration(), value.getConfiguration());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
