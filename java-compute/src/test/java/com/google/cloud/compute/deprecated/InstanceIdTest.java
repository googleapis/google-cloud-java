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

public class InstanceIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String NAME = "instance";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/instances/instance";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    InstanceId instanceId = InstanceId.of(PROJECT, ZONE, NAME);
    assertEquals(PROJECT, instanceId.getProject());
    assertEquals(ZONE, instanceId.getZone());
    assertEquals(NAME, instanceId.getInstance());
    assertEquals(URL, instanceId.getSelfLink());
    instanceId = InstanceId.of(ZoneId.of(PROJECT, ZONE), NAME);
    assertEquals(PROJECT, instanceId.getProject());
    assertEquals(ZONE, instanceId.getZone());
    assertEquals(NAME, instanceId.getInstance());
    assertEquals(URL, instanceId.getSelfLink());
    instanceId = InstanceId.of(ZONE, NAME);
    assertNull(instanceId.getProject());
    assertEquals(ZONE, instanceId.getZone());
    assertEquals(NAME, instanceId.getInstance());
  }

  @Test
  public void testToAndFromUrl() {
    InstanceId instanceId = InstanceId.of(PROJECT, ZONE, NAME);
    compareInstanceId(instanceId, InstanceId.fromUrl(instanceId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid instance URL");
    InstanceId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    InstanceId instanceId = InstanceId.of(PROJECT, ZONE, NAME);
    assertSame(instanceId, instanceId.setProjectId(PROJECT));
    compareInstanceId(instanceId, InstanceId.of(ZONE, NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(InstanceId.matchesUrl(InstanceId.of(PROJECT, ZONE, NAME).getSelfLink()));
    assertFalse(InstanceId.matchesUrl("notMatchingUrl"));
  }

  private void compareInstanceId(InstanceId expected, InstanceId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getZone(), expected.getZone());
    assertEquals(expected.getInstance(), expected.getInstance());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
