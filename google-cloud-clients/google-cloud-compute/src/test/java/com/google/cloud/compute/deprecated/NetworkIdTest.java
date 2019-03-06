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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NetworkIdTest {

  private static final String PROJECT = "project";
  private static final String NETWORK = "network";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/global/networks/network";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    NetworkId networkId = NetworkId.of(PROJECT, NETWORK);
    assertEquals(PROJECT, networkId.getProject());
    assertEquals(NETWORK, networkId.getNetwork());
    assertEquals(URL, networkId.getSelfLink());
    networkId = NetworkId.of(NETWORK);
    assertNull(networkId.getProject());
    assertEquals(NETWORK, networkId.getNetwork());
  }

  @Test
  public void testToAndFromUrl() {
    NetworkId networkId = NetworkId.of(PROJECT, NETWORK);
    compareNetworkId(networkId, NetworkId.fromUrl(networkId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid network URL");
    NetworkId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    NetworkId networkId = NetworkId.of(PROJECT, NETWORK);
    assertSame(networkId, networkId.setProjectId(PROJECT));
    compareNetworkId(networkId, NetworkId.of(NETWORK).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(NetworkId.matchesUrl(NetworkId.of(PROJECT, NETWORK).getSelfLink()));
    assertFalse(NetworkId.matchesUrl("notMatchingUrl"));
  }

  private void compareNetworkId(NetworkId expected, NetworkId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getNetwork(), expected.getNetwork());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
