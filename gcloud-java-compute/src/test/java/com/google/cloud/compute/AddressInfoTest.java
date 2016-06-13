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
      ImmutableList.of(GlobalForwardingRuleId.of("project", "forwardingRule1"),
          GlobalForwardingRuleId.of("project", "forwardingRule2"));
  private static final List<RegionForwardingRuleId> REGION_FORWARDING_RULES =
      ImmutableList.of(RegionForwardingRuleId.of("project", "region", "forwardingRule1"),
          RegionForwardingRuleId.of("project", "region", "forwardingRule2"));
  private static final AddressInfo.InstanceUsage INSTANCE_USAGE =
      new AddressInfo.InstanceUsage(InstanceId.of("project", "zone", "instance1"));
  private static final AddressInfo.GlobalForwardingUsage GLOBAL_FORWARDING_USAGE =
      new AddressInfo.GlobalForwardingUsage(GLOBAL_FORWARDING_RULES);
  private static final AddressInfo.RegionForwardingUsage REGION_FORWARDING_USAGE =
      new AddressInfo.RegionForwardingUsage(REGION_FORWARDING_RULES);
  private static final AddressInfo INSTANCE_ADDRESS_INFO = AddressInfo.builder(REGION_ADDRESS_ID)
      .address(ADDRESS)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .generatedId(GENERATED_ID)
      .status(STATUS)
      .usage(INSTANCE_USAGE)
      .build();
  private static final AddressInfo GLOBAL_FORWARDING_ADDRESS_INFO =
      AddressInfo.builder(GLOBAL_ADDRESS_ID)
          .address(ADDRESS)
          .creationTimestamp(CREATION_TIMESTAMP)
          .description(DESCRIPTION)
          .generatedId(GENERATED_ID)
          .status(STATUS)
          .usage(GLOBAL_FORWARDING_USAGE)
          .build();
  private static final AddressInfo REGION_FORWARDING_ADDRESS_INFO =
      AddressInfo.builder(REGION_ADDRESS_ID)
          .address(ADDRESS)
          .creationTimestamp(CREATION_TIMESTAMP)
          .description(DESCRIPTION)
          .generatedId(GENERATED_ID)
          .status(STATUS)
          .usage(REGION_FORWARDING_USAGE)
          .build();

  @Test
  public void testToBuilder() {
    compareAddressInfo(INSTANCE_ADDRESS_INFO, INSTANCE_ADDRESS_INFO.toBuilder().build());
    AddressInfo addressInfo = INSTANCE_ADDRESS_INFO.toBuilder()
        .address("192.168.1.2")
        .description("description2")
        .build();
    assertEquals("description2", addressInfo.description());
    assertEquals("192.168.1.2", addressInfo.address());
    addressInfo = addressInfo.toBuilder()
        .address("192.168.1.1")
        .description("description")
        .build();
    compareAddressInfo(INSTANCE_ADDRESS_INFO, addressInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    AddressInfo addressInfo = AddressInfo.builder(GLOBAL_ADDRESS_ID).build();
    assertEquals(addressInfo, addressInfo.toBuilder().build());
    addressInfo = AddressInfo.builder(REGION_ADDRESS_ID).build();
    assertEquals(addressInfo, addressInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ADDRESS, INSTANCE_ADDRESS_INFO.address());
    assertEquals(CREATION_TIMESTAMP, INSTANCE_ADDRESS_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, INSTANCE_ADDRESS_INFO.description());
    assertEquals(GENERATED_ID, INSTANCE_ADDRESS_INFO.generatedId());
    assertEquals(REGION_ADDRESS_ID, INSTANCE_ADDRESS_INFO.addressId());
    assertEquals(STATUS, INSTANCE_ADDRESS_INFO.status());
    assertEquals(INSTANCE_USAGE, INSTANCE_ADDRESS_INFO.usage());
    Assert.assertEquals(INSTANCE_USAGE.instance(),
        INSTANCE_ADDRESS_INFO.<AddressInfo.InstanceUsage>usage().instance());
    assertEquals(ADDRESS, REGION_FORWARDING_ADDRESS_INFO.address());
    assertEquals(CREATION_TIMESTAMP, REGION_FORWARDING_ADDRESS_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, REGION_FORWARDING_ADDRESS_INFO.description());
    assertEquals(GENERATED_ID, REGION_FORWARDING_ADDRESS_INFO.generatedId());
    assertEquals(REGION_ADDRESS_ID, REGION_FORWARDING_ADDRESS_INFO.addressId());
    assertEquals(STATUS, REGION_FORWARDING_ADDRESS_INFO.status());
    assertEquals(REGION_FORWARDING_USAGE, REGION_FORWARDING_ADDRESS_INFO.usage());
    Assert.assertEquals(REGION_FORWARDING_RULES,
        REGION_FORWARDING_ADDRESS_INFO.<AddressInfo.RegionForwardingUsage>usage().forwardingRules());
    assertEquals(ADDRESS, GLOBAL_FORWARDING_ADDRESS_INFO.address());
    assertEquals(CREATION_TIMESTAMP, GLOBAL_FORWARDING_ADDRESS_INFO.creationTimestamp());
    assertEquals(DESCRIPTION, GLOBAL_FORWARDING_ADDRESS_INFO.description());
    assertEquals(GENERATED_ID, GLOBAL_FORWARDING_ADDRESS_INFO.generatedId());
    assertEquals(GLOBAL_ADDRESS_ID, GLOBAL_FORWARDING_ADDRESS_INFO.addressId());
    assertEquals(STATUS, GLOBAL_FORWARDING_ADDRESS_INFO.status());
    assertEquals(GLOBAL_FORWARDING_USAGE, GLOBAL_FORWARDING_ADDRESS_INFO.usage());
    Assert.assertEquals(GLOBAL_FORWARDING_RULES,
        GLOBAL_FORWARDING_ADDRESS_INFO.<AddressInfo.GlobalForwardingUsage>usage().forwardingRules());
  }

  @Test
  public void testOf() {
    AddressInfo addressInfo = AddressInfo.of("address");
    assertEquals(GlobalAddressId.of("address"), addressInfo.addressId());
    assertNull(addressInfo.address());
    assertNull(addressInfo.creationTimestamp());
    assertNull(addressInfo.description());
    assertNull(addressInfo.generatedId());
    assertNull(addressInfo.status());
    assertNull(addressInfo.usage());
    addressInfo = AddressInfo.of(GLOBAL_ADDRESS_ID);
    assertEquals(GLOBAL_ADDRESS_ID, addressInfo.addressId());
    assertNull(addressInfo.address());
    assertNull(addressInfo.creationTimestamp());
    assertNull(addressInfo.description());
    assertNull(addressInfo.generatedId());
    assertNull(addressInfo.status());
    assertNull(addressInfo.usage());
    addressInfo = AddressInfo.of("region", "address");
    assertEquals(RegionAddressId.of("region", "address"), addressInfo.addressId());
    assertNull(addressInfo.address());
    assertNull(addressInfo.creationTimestamp());
    assertNull(addressInfo.description());
    assertNull(addressInfo.generatedId());
    assertNull(addressInfo.status());
    assertNull(addressInfo.usage());
    addressInfo = AddressInfo.of(RegionId.of("region"), "address");
    assertEquals(RegionAddressId.of("region", "address"), addressInfo.addressId());
    assertNull(addressInfo.address());
    assertNull(addressInfo.creationTimestamp());
    assertNull(addressInfo.description());
    assertNull(addressInfo.generatedId());
    assertNull(addressInfo.status());
    assertNull(addressInfo.usage());
  }

  @Test
  public void testToPbAndFromPb() {
    compareAddressInfo(INSTANCE_ADDRESS_INFO, AddressInfo.fromPb(INSTANCE_ADDRESS_INFO.toPb()));
    compareAddressInfo(REGION_FORWARDING_ADDRESS_INFO,
        AddressInfo.fromPb(REGION_FORWARDING_ADDRESS_INFO.toPb()));
    compareAddressInfo(GLOBAL_FORWARDING_ADDRESS_INFO,
        AddressInfo.fromPb(GLOBAL_FORWARDING_ADDRESS_INFO.toPb()));
    AddressInfo addressInfo = AddressInfo.builder(GLOBAL_ADDRESS_ID).build();
    compareAddressInfo(addressInfo, AddressInfo.fromPb(addressInfo.toPb()));
  }

  @Test
  public void testSetProjectId() {
    AddressInfo addressInfo = GLOBAL_FORWARDING_ADDRESS_INFO.toBuilder()
        .addressId(GlobalAddressId.of(GLOBAL_ADDRESS_ID.address()))
        .build();
    compareAddressInfo(GLOBAL_FORWARDING_ADDRESS_INFO, addressInfo.setProjectId("project"));
  }

  private void compareAddressInfo(AddressInfo expected, AddressInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.address(), value.address());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.addressId(), value.addressId());
    assertEquals(expected.usage(), value.usage());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
