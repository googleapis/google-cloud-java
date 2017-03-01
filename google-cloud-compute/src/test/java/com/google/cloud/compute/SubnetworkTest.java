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

import org.junit.Test;

public class SubnetworkTest {

  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final SubnetworkId SUBNETWORK_ID = SubnetworkId.of("project", "region", "network");
  private static final String GATEWAY_ADDRESS = "192.168.1.1";
  private static final NetworkId NETWORK_ID = NetworkId.of("project", "network");
  private static final String IP_RANGE = "192.168.0.0/16";

  private final Compute serviceMockReturnsOptions = createStrictMock(Compute.class);
  private final ComputeOptions mockOptions = createMock(ComputeOptions.class);
  private Compute compute;
  private Subnetwork subnetwork;
  private Subnetwork expectedSubnetwork;

  private void initializeExpectedSubnetwork(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedSubnetwork =
        new Subnetwork.Builder(serviceMockReturnsOptions, SUBNETWORK_ID, NETWORK_ID, IP_RANGE)
            .setGeneratedId(GENERATED_ID)
            .setCreationTimestamp(CREATION_TIMESTAMP)
            .description(DESCRIPTION)
            .setGatewayAddress(GATEWAY_ADDRESS)
            .build();
    compute = createStrictMock(Compute.class);
  }

  private void initializeSubnetwork() {
    subnetwork =
        new Subnetwork.Builder(compute, SUBNETWORK_ID, NETWORK_ID, IP_RANGE)
            .setGeneratedId(GENERATED_ID)
            .setCreationTimestamp(CREATION_TIMESTAMP)
            .description(DESCRIPTION)
            .setGatewayAddress(GATEWAY_ADDRESS)
            .build();
  }

  @Test
  public void testToBuilder() {
    initializeExpectedSubnetwork(8);
    compareSubnetwork(expectedSubnetwork, expectedSubnetwork.toBuilder().build());
    Subnetwork newSubnetwork = expectedSubnetwork.toBuilder().description("newDescription").build();
    assertEquals("newDescription", newSubnetwork.getDescription());
    newSubnetwork = newSubnetwork.toBuilder().description("description").build();
    compareSubnetwork(expectedSubnetwork, newSubnetwork);
  }

  @Test
  public void testToBuilderIncomplete() {
    initializeExpectedSubnetwork(5);
    SubnetworkInfo subnetworkInfo = SubnetworkInfo.of(SUBNETWORK_ID, NETWORK_ID, IP_RANGE);
    Subnetwork subnetwork =
        new Subnetwork(serviceMockReturnsOptions, new SubnetworkInfo.BuilderImpl(subnetworkInfo));
    compareSubnetwork(subnetwork, subnetwork.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedSubnetwork(1);
    assertEquals(GENERATED_ID, expectedSubnetwork.getGeneratedId());
    assertEquals(SUBNETWORK_ID, expectedSubnetwork.getSubnetworkId());
    assertEquals(CREATION_TIMESTAMP, expectedSubnetwork.getCreationTimestamp());
    assertEquals(DESCRIPTION, expectedSubnetwork.getDescription());
    assertEquals(GATEWAY_ADDRESS, expectedSubnetwork.getGatewayAddress());
    assertEquals(NETWORK_ID, expectedSubnetwork.getNetwork());
    assertEquals(IP_RANGE, expectedSubnetwork.getIpRange());
    assertSame(serviceMockReturnsOptions, expectedSubnetwork.getCompute());
  }

  @Test
  public void testBuilderDeprecated() {
    initializeExpectedSubnetwork(1);
    assertEquals(GENERATED_ID, expectedSubnetwork.generatedId());
    assertEquals(SUBNETWORK_ID, expectedSubnetwork.subnetworkId());
    assertEquals(CREATION_TIMESTAMP, expectedSubnetwork.creationTimestamp());
    assertEquals(DESCRIPTION, expectedSubnetwork.description());
    assertEquals(GATEWAY_ADDRESS, expectedSubnetwork.gatewayAddress());
    assertEquals(NETWORK_ID, expectedSubnetwork.network());
    assertEquals(IP_RANGE, expectedSubnetwork.ipRange());
    assertSame(serviceMockReturnsOptions, expectedSubnetwork.compute());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedSubnetwork(8);
    compareSubnetwork(expectedSubnetwork,
        Subnetwork.fromPb(serviceMockReturnsOptions, expectedSubnetwork.toPb()));
    Subnetwork subnetwork =
        new Subnetwork.Builder(serviceMockReturnsOptions, SUBNETWORK_ID, NETWORK_ID, IP_RANGE)
            .build();
    compareSubnetwork(subnetwork, Subnetwork.fromPb(serviceMockReturnsOptions, subnetwork.toPb()));
  }

  @Test
  public void testDeleteOperation() {
    initializeExpectedSubnetwork(2);
    expect(compute.getOptions()).andReturn(mockOptions);
    Operation operation = new Operation.Builder(serviceMockReturnsOptions)
        .setOperationId(GlobalOperationId.of("project", "op"))
        .build();
    expect(compute.deleteSubnetwork(SUBNETWORK_ID)).andReturn(operation);
    replay(compute);
    initializeSubnetwork();
    assertSame(operation, subnetwork.delete());
  }

  @Test
  public void testDeleteNull() {
    initializeExpectedSubnetwork(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.deleteSubnetwork(SUBNETWORK_ID)).andReturn(null);
    replay(compute);
    initializeSubnetwork();
    assertNull(subnetwork.delete());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedSubnetwork(1);
    Compute.SubnetworkOption[] expectedOptions = {Compute.SubnetworkOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSubnetwork(SUBNETWORK_ID, expectedOptions))
        .andReturn(expectedSubnetwork);
    replay(compute);
    initializeSubnetwork();
    assertTrue(subnetwork.exists());
    verify(compute);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedSubnetwork(1);
    Compute.SubnetworkOption[] expectedOptions = {Compute.SubnetworkOption.fields()};
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSubnetwork(SUBNETWORK_ID, expectedOptions)).andReturn(null);
    replay(compute);
    initializeSubnetwork();
    assertFalse(subnetwork.exists());
    verify(compute);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedSubnetwork(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSubnetwork(SUBNETWORK_ID)).andReturn(expectedSubnetwork);
    replay(compute);
    initializeSubnetwork();
    Subnetwork updatedSubnetwork = subnetwork.reload();
    compareSubnetwork(expectedSubnetwork, updatedSubnetwork);
    verify(compute);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedSubnetwork(1);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSubnetwork(SUBNETWORK_ID)).andReturn(null);
    replay(compute);
    initializeSubnetwork();
    assertNull(subnetwork.reload());
    verify(compute);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedSubnetwork(3);
    expect(compute.getOptions()).andReturn(mockOptions);
    expect(compute.getSubnetwork(SUBNETWORK_ID, Compute.SubnetworkOption.fields()))
        .andReturn(expectedSubnetwork);
    replay(compute);
    initializeSubnetwork();
    Subnetwork updatedSubnetwork = subnetwork.reload(Compute.SubnetworkOption.fields());
    compareSubnetwork(expectedSubnetwork, updatedSubnetwork);
    verify(compute);
  }

  public void compareSubnetwork(Subnetwork expected, Subnetwork value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompute().getOptions(), value.getCompute().getOptions());
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
