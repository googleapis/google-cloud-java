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

import com.google.cloud.compute.deprecated.AddressInfo.GlobalForwardingUsage;
import com.google.cloud.compute.deprecated.AddressInfo.RegionForwardingUsage;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class AddressInfoTest {

  private static final String ADDRESS = "192.168.1.1";
  private static final Long CREATION_TIMESTAMP = 1452602400000L;
  private static final String DESCRIPTION = "description";
  private static final String GENERATED_ID = "42";
  private static final GlobalAddressId GLOBAL_ADDRESS_ID = GlobalAddressId.of("project", "address");
  private static final RegionAddressId REGION_ADDRESS_ID =
      RegionAddressId.of("project", "region", "address");
  private static final AddressInfo.Status STATUS = AddressInfo.Status.RESERVED;
  private static final List<GlobalForwardingRuleId> GLOBAL_FORWARDING_RULES =
      ImmutableList.of(
          GlobalForwardingRuleId.of("project", "forwardingRule1"),
          GlobalForwardingRuleId.of("project", "forwardingRule2"));
  private static final List<RegionForwardingRuleId> REGION_FORWARDING_RULES =
      ImmutableList.of(
          RegionForwardingRuleId.of("project", "region", "forwardingRule1"),
          RegionForwardingRuleId.of("project", "region", "forwardingRule2"));
  private static final AddressInfo.InstanceUsage INSTANCE_USAGE =
      new AddressInfo.InstanceUsage(InstanceId.of("project", "zone", "instance1"));
  private static final GlobalForwardingUsage GLOBAL_FORWARDING_USAGE =
      new GlobalForwardingUsage(GLOBAL_FORWARDING_RULES);
  private static final RegionForwardingUsage REGION_FORWARDING_USAGE =
      new RegionForwardingUsage(REGION_FORWARDING_RULES);
  private static final AddressInfo INSTANCE_ADDRESS_INFO =
      AddressInfo.newBuilder(REGION_ADDRESS_ID)
          .setAddress(ADDRESS)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setGeneratedId(GENERATED_ID)
          .setStatus(STATUS)
          .setUsage(INSTANCE_USAGE)
          .build();
  private static final AddressInfo GLOBAL_FORWARDING_ADDRESS_INFO =
      AddressInfo.newBuilder(GLOBAL_ADDRESS_ID)
          .setAddress(ADDRESS)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setGeneratedId(GENERATED_ID)
          .setStatus(STATUS)
          .setUsage(GLOBAL_FORWARDING_USAGE)
          .build();
  private static final AddressInfo REGION_FORWARDING_ADDRESS_INFO =
      AddressInfo.newBuilder(REGION_ADDRESS_ID)
          .setAddress(ADDRESS)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setGeneratedId(GENERATED_ID)
          .setStatus(STATUS)
          .setUsage(REGION_FORWARDING_USAGE)
          .build();

  @Test
  public void testToBuilder() {
    compareAddressInfo(INSTANCE_ADDRESS_INFO, INSTANCE_ADDRESS_INFO.toBuilder().build());
    AddressInfo addressInfo =
        INSTANCE_ADDRESS_INFO
            .toBuilder()
            .setAddress("192.168.1.2")
            .setDescription("description2")
            .build();
    assertEquals("description2", addressInfo.getDescription());
    assertEquals("192.168.1.2", addressInfo.getAddress());
    addressInfo =
        addressInfo.toBuilder().setAddress("192.168.1.1").setDescription("description").build();
    compareAddressInfo(INSTANCE_ADDRESS_INFO, addressInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    AddressInfo addressInfo = AddressInfo.newBuilder(GLOBAL_ADDRESS_ID).build();
    assertEquals(addressInfo, addressInfo.toBuilder().build());
    addressInfo = AddressInfo.newBuilder(REGION_ADDRESS_ID).build();
    assertEquals(addressInfo, addressInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ADDRESS, INSTANCE_ADDRESS_INFO.getAddress());
    assertEquals(CREATION_TIMESTAMP, INSTANCE_ADDRESS_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, INSTANCE_ADDRESS_INFO.getDescription());
    assertEquals(GENERATED_ID, INSTANCE_ADDRESS_INFO.getGeneratedId());
    assertEquals(REGION_ADDRESS_ID, INSTANCE_ADDRESS_INFO.getAddressId());
    assertEquals(STATUS, INSTANCE_ADDRESS_INFO.getStatus());
    assertEquals(INSTANCE_USAGE, INSTANCE_ADDRESS_INFO.getUsage());
    assertEquals(
        INSTANCE_USAGE.getInstance(),
        INSTANCE_ADDRESS_INFO.<AddressInfo.InstanceUsage>getUsage().getInstance());
    assertEquals(ADDRESS, REGION_FORWARDING_ADDRESS_INFO.getAddress());
    assertEquals(CREATION_TIMESTAMP, REGION_FORWARDING_ADDRESS_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, REGION_FORWARDING_ADDRESS_INFO.getDescription());
    assertEquals(GENERATED_ID, REGION_FORWARDING_ADDRESS_INFO.getGeneratedId());
    assertEquals(REGION_ADDRESS_ID, REGION_FORWARDING_ADDRESS_INFO.getAddressId());
    assertEquals(STATUS, REGION_FORWARDING_ADDRESS_INFO.getStatus());
    assertEquals(REGION_FORWARDING_USAGE, REGION_FORWARDING_ADDRESS_INFO.getUsage());
    assertEquals(
        REGION_FORWARDING_RULES,
        REGION_FORWARDING_ADDRESS_INFO.<RegionForwardingUsage>getUsage().getForwardingRules());
    assertEquals(ADDRESS, GLOBAL_FORWARDING_ADDRESS_INFO.getAddress());
    assertEquals(CREATION_TIMESTAMP, GLOBAL_FORWARDING_ADDRESS_INFO.getCreationTimestamp());
    assertEquals(DESCRIPTION, GLOBAL_FORWARDING_ADDRESS_INFO.getDescription());
    assertEquals(GENERATED_ID, GLOBAL_FORWARDING_ADDRESS_INFO.getGeneratedId());
    assertEquals(GLOBAL_ADDRESS_ID, GLOBAL_FORWARDING_ADDRESS_INFO.getAddressId());
    assertEquals(STATUS, GLOBAL_FORWARDING_ADDRESS_INFO.getStatus());
    assertEquals(GLOBAL_FORWARDING_USAGE, GLOBAL_FORWARDING_ADDRESS_INFO.getUsage());
    assertEquals(
        GLOBAL_FORWARDING_RULES,
        GLOBAL_FORWARDING_ADDRESS_INFO.<GlobalForwardingUsage>getUsage().getForwardingRules());
  }

  @Test
  public void testOf() {
    AddressInfo addressInfo = AddressInfo.of("address");
    assertEquals(GlobalAddressId.of("address"), addressInfo.getAddressId());
    assertNull(addressInfo.getAddress());
    assertNull(addressInfo.getCreationTimestamp());
    assertNull(addressInfo.getDescription());
    assertNull(addressInfo.getGeneratedId());
    assertNull(addressInfo.getStatus());
    assertNull(addressInfo.getUsage());
    addressInfo = AddressInfo.of(GLOBAL_ADDRESS_ID);
    assertEquals(GLOBAL_ADDRESS_ID, addressInfo.getAddressId());
    assertNull(addressInfo.getAddress());
    assertNull(addressInfo.getCreationTimestamp());
    assertNull(addressInfo.getDescription());
    assertNull(addressInfo.getGeneratedId());
    assertNull(addressInfo.getStatus());
    assertNull(addressInfo.getUsage());
    addressInfo = AddressInfo.of("region", "address");
    assertEquals(RegionAddressId.of("region", "address"), addressInfo.getAddressId());
    assertNull(addressInfo.getAddress());
    assertNull(addressInfo.getCreationTimestamp());
    assertNull(addressInfo.getDescription());
    assertNull(addressInfo.getGeneratedId());
    assertNull(addressInfo.getStatus());
    assertNull(addressInfo.getUsage());
    addressInfo = AddressInfo.of(RegionId.of("region"), "address");
    assertEquals(RegionAddressId.of("region", "address"), addressInfo.getAddressId());
    assertNull(addressInfo.getAddress());
    assertNull(addressInfo.getCreationTimestamp());
    assertNull(addressInfo.getDescription());
    assertNull(addressInfo.getGeneratedId());
    assertNull(addressInfo.getStatus());
    assertNull(addressInfo.getUsage());
  }

  @Test
  public void testToPbAndFromPb() {
    compareAddressInfo(INSTANCE_ADDRESS_INFO, AddressInfo.fromPb(INSTANCE_ADDRESS_INFO.toPb()));
    compareAddressInfo(
        REGION_FORWARDING_ADDRESS_INFO, AddressInfo.fromPb(REGION_FORWARDING_ADDRESS_INFO.toPb()));
    compareAddressInfo(
        GLOBAL_FORWARDING_ADDRESS_INFO, AddressInfo.fromPb(GLOBAL_FORWARDING_ADDRESS_INFO.toPb()));
    AddressInfo addressInfo = AddressInfo.newBuilder(GLOBAL_ADDRESS_ID).build();
    compareAddressInfo(addressInfo, AddressInfo.fromPb(addressInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    AddressInfo addressInfo =
        GLOBAL_FORWARDING_ADDRESS_INFO
            .toBuilder()
            .setAddressId(GlobalAddressId.of(GLOBAL_ADDRESS_ID.getAddress()))
            .build();
    compareAddressInfo(GLOBAL_FORWARDING_ADDRESS_INFO, addressInfo.setProjectId("project"));
  }

  private void compareAddressInfo(AddressInfo expected, AddressInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getAddress(), value.getAddress());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getAddressId(), value.getAddressId());
    assertEquals(expected.getUsage(), value.getUsage());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
