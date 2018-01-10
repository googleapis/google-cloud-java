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

package com.google.cloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SubnetworkInfoTest {

  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final SubnetworkId SUBNETWORK_ID =
      SubnetworkId.of("project", "region", "subnetwork");
  private static final String GATEWAY_ADDRESS = "192.168.1.1";
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final String IP_RANGE = "192.168.0.0/16";
  private static final SubnetworkInfo SUBNETWORK_INFO =
      SubnetworkInfo.newBuilder(SUBNETWORK_ID, NETWORK_ID, IP_RANGE)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setGatewayAddress(GATEWAY_ADDRESS)
          .build();

  @Test
  public void testToBuilder() {
    compareSubnetworkInfo(SUBNETWORK_INFO, SUBNETWORK_INFO.toBuilder().build());
    SubnetworkInfo subnetworkInfo =
        SUBNETWORK_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", subnetworkInfo.getDescription());
    subnetworkInfo = subnetworkInfo.toBuilder().setDescription("description").build();
    compareSubnetworkInfo(SUBNETWORK_INFO, subnetworkInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_RANGE);
    assertEquals(subnetworkInfo, subnetworkInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(GENERATED_ID, SUBNETWORK_INFO.getGeneratedId());
    assertEquals(SUBNETWORK_ID, SUBNETWORK_INFO.getSubnetworkId());
    assertEquals(CREATION_TIMESTAMP, SUBNETWORK_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, SUBNETWORK_INFO.getDescription());
    assertEquals(GATEWAY_ADDRESS, SUBNETWORK_INFO.getGatewayAddress());
    assertEquals(NETWORK_ID, SUBNETWORK_INFO.getNetwork());
    assertEquals(IP_RANGE, SUBNETWORK_INFO.getIpRange());
  }

  @Test
  public void testOf() {
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_RANGE);
    assertNull(subnetworkInfo.getGeneratedId());
    assertEquals(SUBNETWORK_ID, subnetworkInfo.getSubnetworkId());
    assertNull(subnetworkInfo.getCreationTimestamp());
    assertNull(subnetworkInfo.getDescription());
    assertNull(subnetworkInfo.getGatewayAddress());
    assertEquals(NETWORK_ID, subnetworkInfo.getNetwork());
    assertEquals(IP_RANGE, subnetworkInfo.getIpRange());
  }

  @Test
  public void testToAndFromPb() {
    compareSubnetworkInfo(SUBNETWORK_INFO, SubnetworkInfo.fromPb(SUBNETWORK_INFO.toPb()));
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_RANGE);
    compareSubnetworkInfo(subnetworkInfo, SubnetworkInfo.fromPb(subnetworkInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    SubnetworkInfo subnetworkInfo = SUBNETWORK_INFO.toBuilder()
        .setSubnetworkId(SubnetworkId.of("region", "subnetwork"))
        .setNetwork(NetworkId.of("network"))
        .build();
    compareSubnetworkInfo(SUBNETWORK_INFO, subnetworkInfo.setProjectId("project"));
  }

  public void compareSubnetworkInfo(SubnetworkInfo expected, SubnetworkInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getSubnetworkId(), value.getSubnetworkId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getGatewayAddress(), value.getGatewayAddress());
    assertEquals(expected.getNetwork(), value.getNetwork());
    assertEquals(expected.getIpRange(), value.getIpRange());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
