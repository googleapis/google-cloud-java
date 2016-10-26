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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.After;
import org.junit.Test;

import java.util.List;

public class AddressTest {

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

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Address globalForwardingAddress;
  private Address instanceAddress;
  private Address regionForwardingAddress;
  private Address address;

  private void initializeExpectedAddress(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    instanceAddress = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID)
        .setAddress(ADDRESS)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setGeneratedId(GENERATED_ID)
        .setStatus(STATUS)
        .setUsage(INSTANCE_USAGE)
        .build();
    globalForwardingAddress = new Address.Builder(serviceMockReturnsOptions, GLOBAL_ADDRESS_ID)
        .setAddress(ADDRESS)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setGeneratedId(GENERATED_ID)
        .setStatus(STATUS)
        .setUsage(GLOBAL_FORWARDING_USAGE)
        .build();
    regionForwardingAddress = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID)
        .setAddress(ADDRESS)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setGeneratedId(GENERATED_ID)
        .setStatus(STATUS)
        .setUsage(REGION_FORWARDING_USAGE)
        .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeAddress() {
    address = new Address.Builder(compute, REGION_ADDRESS_ID)
        .setAddress(ADDRESS)
        .setCreationTimestamp(CREATION_TIMESTAMP)
        .setDescription(DESCRIPTION)
        .setGeneratedId(GENERATED_ID)
        .setStatus(STATUS)
        .setUsage(REGION_FORWARDING_USAGE)
        .build();
  }

  @After
  public void tearDown() throws Exception {
    verify(serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedAddress(6);
    assertEquals(ADDRESS, instanceAddress.getAddress());
    assertEquals(CREATION_TIMESTAMP, instanceAddress.getCreationTimestamp());
    assertEquals(DESCRIPTION, instanceAddress.getDescription());
    assertEquals(GENERATED_ID, instanceAddress.getGeneratedId());
    assertEquals(REGION_ADDRESS_ID, instanceAddress.getAddressId());
    assertEquals(STATUS, instanceAddress.getStatus());
    assertEquals(INSTANCE_USAGE, instanceAddress.getUsage());
    assertSame(serviceMockReturnsOptions, instanceAddress.getCompute());
    assertEquals(ADDRESS, regionForwardingAddress.getAddress());
    assertEquals(CREATION_TIMESTAMP, regionForwardingAddress.getCreationTimestamp());
    assertEquals(DESCRIPTION, regionForwardingAddress.getDescription());
    assertEquals(GENERATED_ID, regionForwardingAddress.getGeneratedId());
    assertEquals(REGION_ADDRESS_ID, regionForwardingAddress.getAddressId());
    assertEquals(STATUS, regionForwardingAddress.getStatus());
    assertEquals(REGION_FORWARDING_USAGE, regionForwardingAddress.getUsage());
    assertSame(serviceMockReturnsOptions, regionForwardingAddress.getCompute());
    assertEquals(ADDRESS, globalForwardingAddress.getAddress());
    assertEquals(CREATION_TIMESTAMP, globalForwardingAddress.getCreationTimestamp());
    assertEquals(DESCRIPTION, globalForwardingAddress.getDescription());
    assertEquals(GENERATED_ID, globalForwardingAddress.getGeneratedId());
    assertEquals(GLOBAL_ADDRESS_ID, globalForwardingAddress.getAddressId());
    assertEquals(STATUS, globalForwardingAddress.getStatus());
    assertEquals(GLOBAL_FORWARDING_USAGE, globalForwardingAddress.getUsage());
    assertSame(serviceMockReturnsOptions, globalForwardingAddress.getCompute());
    Address address = new Address.Builder(serviceMockReturnsOptions, GLOBAL_ADDRESS_ID).build();
    assertEquals(GLOBAL_ADDRESS_ID, address.getAddressId());
    assertSame(serviceMockReturnsOptions, address.getCompute());
    assertNull(address.getAddress());
    assertNull(address.getCreationTimestamp());
    assertNull(address.getDescription());
    assertNull(address.getGeneratedId());
    assertNull(address.getStatus());
    assertNull(address.getUsage());
    address = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID).build();
    assertEquals(REGION_ADDRESS_ID, address.getAddressId());
    assertSame(serviceMockReturnsOptions, address.getCompute());
    assertNull(address.getAddress());
    assertNull(address.getCreationTimestamp());
    assertNull(address.getDescription());
    assertNull(address.getGeneratedId());
    assertNull(address.getStatus());
    assertNull(address.getUsage());
    address = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID)
        .setAddressId(GLOBAL_ADDRESS_ID)
        .build();
    assertEquals(GLOBAL_ADDRESS_ID, address.getAddressId());
    assertSame(serviceMockReturnsOptions, address.getCompute());
    assertNull(address.getAddress());
    assertNull(address.getCreationTimestamp());
    assertNull(address.getDescription());
    assertNull(address.getGeneratedId());
    assertNull(address.getStatus());
    assertNull(address.getUsage());
  }

  @Test
  public void testBuilderDeprecated() {
    initializeExpectedAddress(6);
    assertEquals(ADDRESS, instanceAddress.address());
    assertEquals(CREATION_TIMESTAMP, instanceAddress.creationTimestamp());
    assertEquals(DESCRIPTION, instanceAddress.description());
    assertEquals(GENERATED_ID, instanceAddress.generatedId());
    assertEquals(REGION_ADDRESS_ID, instanceAddress.addressId());
    assertEquals(STATUS, instanceAddress.status());
    assertEquals(INSTANCE_USAGE, instanceAddress.usage());
    assertSame(serviceMockReturnsOptions, instanceAddress.compute());
    assertEquals(ADDRESS, regionForwardingAddress.address());
    assertEquals(CREATION_TIMESTAMP, regionForwardingAddress.creationTimestamp());
    assertEquals(DESCRIPTION, regionForwardingAddress.description());
    assertEquals(GENERATED_ID, regionForwardingAddress.generatedId());
    assertEquals(REGION_ADDRESS_ID, regionForwardingAddress.addressId());
    assertEquals(STATUS, regionForwardingAddress.status());
    assertEquals(REGION_FORWARDING_USAGE, regionForwardingAddress.usage());
    assertSame(serviceMockReturnsOptions, regionForwardingAddress.compute());
    assertEquals(ADDRESS, globalForwardingAddress.address());
    assertEquals(CREATION_TIMESTAMP, globalForwardingAddress.creationTimestamp());
    assertEquals(DESCRIPTION, globalForwardingAddress.description());
    assertEquals(GENERATED_ID, globalForwardingAddress.generatedId());
    assertEquals(GLOBAL_ADDRESS_ID, globalForwardingAddress.addressId());
    assertEquals(STATUS, globalForwardingAddress.status());
    assertEquals(GLOBAL_FORWARDING_USAGE, globalForwardingAddress.usage());
    assertSame(serviceMockReturnsOptions, globalForwardingAddress.compute());
    Address address = new Address.Builder(serviceMockReturnsOptions, GLOBAL_ADDRESS_ID).build();
    assertEquals(GLOBAL_ADDRESS_ID, address.addressId());
    assertSame(serviceMockReturnsOptions, address.compute());
    assertNull(address.address());
    assertNull(address.creationTimestamp());
    assertNull(address.description());
    assertNull(address.generatedId());
    assertNull(address.status());
    assertNull(address.usage());
    address = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID).build();
    assertEquals(REGION_ADDRESS_ID, address.addressId());
    assertSame(serviceMockReturnsOptions, address.compute());
    assertNull(address.address());
    assertNull(address.creationTimestamp());
    assertNull(address.description());
    assertNull(address.generatedId());
    assertNull(address.status());
    assertNull(address.usage());
    address = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID)
        .addressId(GLOBAL_ADDRESS_ID)
        .build();
    assertEquals(GLOBAL_ADDRESS_ID, address.addressId());
    assertSame(serviceMockReturnsOptions, address.compute());
    assertNull(address.address());
    assertNull(address.creationTimestamp());
    assertNull(address.description());
    assertNull(address.generatedId());
    assertNull(address.status());
    assertNull(address.usage());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedAddress(16);
    compareAddress(instanceAddress, instanceAddress.toBuilder().build());
    compareAddress(globalForwardingAddress, globalForwardingAddress.toBuilder().build());
    compareAddress(regionForwardingAddress, regionForwardingAddress.toBuilder().build());
    Address newAddress = instanceAddress.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", newAddress.getDescription());
    newAddress = newAddress.toBuilder().setDescription("description").build();
    compareAddress(instanceAddress, newAddress);
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedAddress(20);
    compareAddress(globalForwardingAddress,
        Address.fromPb(serviceMockReturnsOptions, globalForwardingAddress.toPb()));
    compareAddress(regionForwardingAddress,
        Address.fromPb(serviceMockReturnsOptions, regionForwardingAddress.toPb()));
    compareAddress(instanceAddress,
        Address.fromPb(serviceMockReturnsOptions, instanceAddress.toPb()));
    Address address = new Address.Builder(serviceMockReturnsOptions, GLOBAL_ADDRESS_ID).build();
    compareAddress(address, Address.fromPb(serviceMockReturnsOptions, address.toPb()));
    address = new Address.Builder(serviceMockReturnsOptions, REGION_ADDRESS_ID).build();
    compareAddress(address, Address.fromPb(serviceMockReturnsOptions, address.toPb()));
  }

  @Test
  public void testDeleteOperation() {
    initializeExpectedAddress(4);
    expect(compute.options()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    expect(compute.deleteAddress(REGION_ADDRESS_ID)).andReturn(operation);
    replay(compute);
    initializeAddress();
    assertSame(operation, address.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedAddress(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.deleteAddress(REGION_ADDRESS_ID)).andReturn(null);
    replay(compute);
    initializeAddress();
    assertNull(address.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedAddress(3);
    Compute.AddressOption[] expectedOptions = {Compute.AddressOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getAddress(REGION_ADDRESS_ID, expectedOptions)).andReturn(regionForwardingAddress);
    replay(compute);
    initializeAddress();
    assertTrue(address.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedAddress(3);
    Compute.AddressOption[] expectedOptions = {Compute.AddressOption.fields()};
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getAddress(REGION_ADDRESS_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeAddress();
    assertFalse(address.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedAddress(5);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getAddress(REGION_ADDRESS_ID)).andReturn(regionForwardingAddress);
    replay(compute);
    initializeAddress();
    Address updatedAddress = address.reload();
    compareAddress(regionForwardingAddress, updatedAddress);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedAddress(3);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getAddress(REGION_ADDRESS_ID)).andReturn(null);
    replay(compute);
    initializeAddress();
    assertNull(address.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedAddress(5);
    expect(compute.options()).andReturn(mockOptions);
    expect(compute.getAddress(REGION_ADDRESS_ID, Compute.AddressOption.fields()))
        .andReturn(regionForwardingAddress);
    replay(compute);
    initializeAddress();
    Address updatedAddress = address.reload(Compute.AddressOption.fields());
    compareAddress(regionForwardingAddress, updatedAddress);
    verify(compute);
  }

  private void compareAddress(Address expected, Address value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompute().options(), value.getCompute().options());
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
