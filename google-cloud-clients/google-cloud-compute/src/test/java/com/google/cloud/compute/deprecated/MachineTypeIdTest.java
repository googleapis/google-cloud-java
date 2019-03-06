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

public class MachineTypeIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String TYPE = "type";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/machineTypes/type";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    MachineTypeId machineTypeId = MachineTypeId.of(PROJECT, ZONE, TYPE);
    assertEquals(PROJECT, machineTypeId.getProject());
    assertEquals(ZONE, machineTypeId.getZone());
    assertEquals(TYPE, machineTypeId.getType());
    assertEquals(URL, machineTypeId.getSelfLink());
    machineTypeId = MachineTypeId.of(ZONE, TYPE);
    assertNull(machineTypeId.getProject());
    assertEquals(ZONE, machineTypeId.getZone());
    assertEquals(TYPE, machineTypeId.getType());
  }

  @Test
  public void testToAndFromUrl() {
    MachineTypeId machineTypeId = MachineTypeId.of(PROJECT, ZONE, TYPE);
    compareMachineTypeId(machineTypeId, MachineTypeId.fromUrl(machineTypeId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid machine type URL");
    MachineTypeId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    MachineTypeId machineTypeId = MachineTypeId.of(PROJECT, ZONE, TYPE);
    assertSame(machineTypeId, machineTypeId.setProjectId(PROJECT));
    compareMachineTypeId(machineTypeId, MachineTypeId.of(ZONE, TYPE).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(MachineTypeId.matchesUrl(MachineTypeId.of(PROJECT, ZONE, TYPE).getSelfLink()));
    assertFalse(MachineTypeId.matchesUrl("notMatchingUrl"));
  }

  private void compareMachineTypeId(MachineTypeId expected, MachineTypeId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getZone(), expected.getZone());
    assertEquals(expected.getType(), expected.getType());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
