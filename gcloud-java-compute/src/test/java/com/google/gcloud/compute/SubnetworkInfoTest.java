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

package com.google.gcloud.compute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SubnetworkInfoTest {

  private static final String ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final SubnetworkId SUBNETWORK_ID =
      SubnetworkId.of("project", "region", "subnetwork");
  private static final String GATEWAY_ADDRESS = "192.168.1.1";
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final String IP_CIDR_RANGE = "192.168.0.0/16";
  private static final SubnetworkInfo SUBNETWORK_INFO =
      SubnetworkInfo.builder(SUBNETWORK_ID, NETWORK_ID, IP_CIDR_RANGE)
          .id(ID)
          .creationTimestamp(CREATION_TIMESTAMP)
          .description(DESCRIPTION)
          .gatewayAddress(GATEWAY_ADDRESS)
          .build();

  @Test
  public void testToBuilder() {
    compareSubnetworkInfo(SUBNETWORK_INFO, SUBNETWORK_INFO.toBuilder().build());
    SubnetworkInfo subnetworkInfo =
        SUBNETWORK_INFO.toBuilder().description("newDescription").build();
    assertEquals("newDescription", subnetworkInfo.description());
    subnetworkInfo = subnetworkInfo.toBuilder().description("description").build();
    compareSubnetworkInfo(SUBNETWORK_INFO, subnetworkInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_CIDR_RANGE);
    assertEquals(subnetworkInfo, subnetworkInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ID, SUBNETWORK_INFO.id());
    assertEquals(SUBNETWORK_ID, SUBNETWORK_INFO.subnetworkId());
    assertEquals(CREATION_TIMESTAMP, SUBNETWORK_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, SUBNETWORK_INFO.description());
    assertEquals(GATEWAY_ADDRESS, SUBNETWORK_INFO.gatewayAddress());
    assertEquals(NETWORK_ID, SUBNETWORK_INFO.network());
    assertEquals(IP_CIDR_RANGE, SUBNETWORK_INFO.ipRange());
  }

  @Test
  public void testOf() {
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_CIDR_RANGE);
    assertNull(subnetworkInfo.id());
    assertEquals(SUBNETWORK_ID, subnetworkInfo.subnetworkId());
    assertNull(subnetworkInfo.creationTimestamp());
    assertNull(subnetworkInfo.description());
    assertNull(subnetworkInfo.gatewayAddress());
    assertEquals(NETWORK_ID, subnetworkInfo.network());
    assertEquals(IP_CIDR_RANGE, subnetworkInfo.ipRange());
  }

  @Test
  public void testToAndFromPb() {
    compareSubnetworkInfo(SUBNETWORK_INFO, SubnetworkInfo.fromPb(SUBNETWORK_INFO.toPb()));
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_CIDR_RANGE);
    compareSubnetworkInfo(subnetworkInfo, SubnetworkInfo.fromPb(subnetworkInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    SubnetworkInfo subnetworkInfo = SUBNETWORK_INFO.toBuilder()
        .subnetworkId(SubnetworkId.of("region", "subnetwork"))
        .network(NetworkId.of("network"))
        .build();
    compareSubnetworkInfo(SUBNETWORK_INFO, subnetworkInfo.setProjectId("project"));
  }

  public void compareSubnetworkInfo(SubnetworkInfo expected, SubnetworkInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.id(), value.id());
    assertEquals(expected.subnetworkId(), value.subnetworkId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.gatewayAddress(), value.gatewayAddress());
    assertEquals(expected.network(), value.network());
    assertEquals(expected.ipRange(), value.ipRange());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
