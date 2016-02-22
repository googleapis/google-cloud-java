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

public class MachineTypeIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String TYPE = "type";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/machineTypes/type";

  @Test
  public void testOf() {
    MachineTypeId machineTypeId = MachineTypeId.of(PROJECT, ZONE, TYPE);
    assertEquals(PROJECT, machineTypeId.project());
    assertEquals(ZONE, machineTypeId.zone());
    assertEquals(TYPE, machineTypeId.machineType());
    assertEquals(URL, machineTypeId.toUrl());
    machineTypeId = MachineTypeId.of(ZONE, TYPE);
    assertNull(machineTypeId.project());
    assertEquals(ZONE, machineTypeId.zone());
    assertEquals(TYPE, machineTypeId.machineType());
  }

  @Test
  public void testToAndFromUrl() {
    MachineTypeId machineTypeId = MachineTypeId.of(PROJECT, ZONE, TYPE);
    compareMachineTypeId(machineTypeId, MachineTypeId.fromUrl(machineTypeId.toUrl()));
  }

  @Test
  public void testSetProjectId() {
    MachineTypeId machineTypeId = MachineTypeId.of(PROJECT, ZONE, TYPE);
    compareMachineTypeId(machineTypeId, MachineTypeId.of(ZONE, TYPE).setProjectId(PROJECT));
  }

  private void compareMachineTypeId(MachineTypeId expected, MachineTypeId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.zone(), expected.zone());
    assertEquals(expected.machineType(), expected.machineType());
    assertEquals(expected.toUrl(), expected.toUrl());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
