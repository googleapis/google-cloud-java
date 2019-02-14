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

public class OperationIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String REGION = "region";
  private static final String NAME = "op";
  private static final String GLOBAL_URL =
      "https://www.googleapis.com/compute/v1/projects/project/global/operations/op";
  private static final String ZONE_URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone/operations/op";
  private static final String REGION_URL =
      "https://www.googleapis.com/compute/v1/projects/project/regions/region/operations/op";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    GlobalOperationId operationId = GlobalOperationId.of(PROJECT, NAME);
    assertEquals(OperationId.Type.GLOBAL, operationId.getType());
    assertEquals(PROJECT, operationId.getProject());
    assertEquals(NAME, operationId.getOperation());
    assertEquals(GLOBAL_URL, operationId.getSelfLink());
    operationId = GlobalOperationId.of(NAME);
    assertEquals(OperationId.Type.GLOBAL, operationId.getType());
    assertNull(operationId.getProject());
    assertEquals(NAME, operationId.getOperation());
    ZoneOperationId zoneOperationId = ZoneOperationId.of(PROJECT, ZONE, NAME);
    assertEquals(OperationId.Type.ZONE, zoneOperationId.getType());
    assertEquals(PROJECT, zoneOperationId.getProject());
    assertEquals(ZONE, zoneOperationId.getZone());
    assertEquals(NAME, zoneOperationId.getOperation());
    assertEquals(ZONE_URL, zoneOperationId.getSelfLink());
    zoneOperationId = ZoneOperationId.of(ZONE, NAME);
    assertEquals(OperationId.Type.ZONE, zoneOperationId.getType());
    assertNull(zoneOperationId.getProject());
    assertEquals(ZONE, zoneOperationId.getZone());
    assertEquals(NAME, zoneOperationId.getOperation());
    zoneOperationId = ZoneOperationId.of(ZoneId.of(PROJECT, ZONE), NAME);
    assertEquals(OperationId.Type.ZONE, zoneOperationId.getType());
    assertEquals(PROJECT, zoneOperationId.getProject());
    assertEquals(ZONE, zoneOperationId.getZone());
    assertEquals(NAME, zoneOperationId.getOperation());
    RegionOperationId regionOperationId = RegionOperationId.of(PROJECT, REGION, NAME);
    assertEquals(OperationId.Type.REGION, regionOperationId.getType());
    assertEquals(PROJECT, regionOperationId.getProject());
    assertEquals(REGION, regionOperationId.getRegion());
    assertEquals(NAME, regionOperationId.getOperation());
    assertEquals(REGION_URL, regionOperationId.getSelfLink());
    regionOperationId = RegionOperationId.of(REGION, NAME);
    assertEquals(OperationId.Type.REGION, regionOperationId.getType());
    assertNull(regionOperationId.getProject());
    assertEquals(REGION, regionOperationId.getRegion());
    assertEquals(NAME, regionOperationId.getOperation());
    regionOperationId = RegionOperationId.of(RegionId.of(PROJECT, REGION), NAME);
    assertEquals(OperationId.Type.REGION, regionOperationId.getType());
    assertEquals(PROJECT, regionOperationId.getProject());
    assertEquals(REGION, regionOperationId.getRegion());
    assertEquals(NAME, regionOperationId.getOperation());
  }

  @Test
  public void testToAndFromUrlGlobal() {
    GlobalOperationId operationId = GlobalOperationId.of(PROJECT, NAME);
    compareOperationId(operationId, GlobalOperationId.fromUrl(operationId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid global operation URL");
    GlobalOperationId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testToAndFromUrlRegion() {
    RegionOperationId regionOperationId = RegionOperationId.of(PROJECT, REGION, NAME);
    compareRegionOperationId(
        regionOperationId, RegionOperationId.fromUrl(regionOperationId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid region operation URL");
    RegionOperationId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testToAndFromUrlZone() {
    ZoneOperationId zoneOperationId = ZoneOperationId.of(PROJECT, ZONE, NAME);
    compareZoneOperationId(zoneOperationId, ZoneOperationId.fromUrl(zoneOperationId.getSelfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid zone operation URL");
    ZoneOperationId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testSetProjectId() {
    GlobalOperationId operationId = GlobalOperationId.of(PROJECT, NAME);
    assertSame(operationId, operationId.setProjectId(PROJECT));
    compareOperationId(operationId, GlobalOperationId.of(NAME).setProjectId(PROJECT));
    ZoneOperationId zoneOperationId = ZoneOperationId.of(PROJECT, ZONE, NAME);
    assertSame(zoneOperationId, zoneOperationId.setProjectId(PROJECT));
    compareZoneOperationId(zoneOperationId, ZoneOperationId.of(ZONE, NAME).setProjectId(PROJECT));
    RegionOperationId regionOperationId = RegionOperationId.of(PROJECT, REGION, NAME);
    assertSame(regionOperationId, regionOperationId.setProjectId(PROJECT));
    compareRegionOperationId(
        regionOperationId, RegionOperationId.of(REGION, NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(GlobalOperationId.matchesUrl(GlobalOperationId.of(PROJECT, NAME).getSelfLink()));
    assertFalse(GlobalOperationId.matchesUrl("notMatchingUrl"));
    assertTrue(
        RegionOperationId.matchesUrl(RegionOperationId.of(PROJECT, REGION, NAME).getSelfLink()));
    assertFalse(RegionOperationId.matchesUrl("notMatchingUrl"));
    assertTrue(ZoneOperationId.matchesUrl(ZoneOperationId.of(PROJECT, REGION, NAME).getSelfLink()));
    assertFalse(ZoneOperationId.matchesUrl("notMatchingUrl"));
  }

  private void compareOperationId(GlobalOperationId expected, GlobalOperationId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getOperation(), expected.getOperation());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }

  private void compareZoneOperationId(ZoneOperationId expected, ZoneOperationId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getZone(), expected.getZone());
    assertEquals(expected.getOperation(), expected.getOperation());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }

  private void compareRegionOperationId(RegionOperationId expected, RegionOperationId value) {
    assertEquals(expected, value);
    assertEquals(expected.getType(), value.getType());
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getRegion(), expected.getRegion());
    assertEquals(expected.getOperation(), expected.getOperation());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
