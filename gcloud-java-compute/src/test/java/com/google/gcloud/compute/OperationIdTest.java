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

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    GlobalOperationId operationId = GlobalOperationId.of(PROJECT, NAME);
    assertEquals(PROJECT, operationId.project());
    assertEquals(NAME, operationId.operation());
    assertEquals(GLOBAL_URL, operationId.selfLink());
    operationId = GlobalOperationId.of(NAME);
    assertNull(operationId.project());
    assertEquals(NAME, operationId.operation());
    ZoneOperationId zoneOperationId = ZoneOperationId.of(PROJECT, ZONE, NAME);
    assertEquals(PROJECT, zoneOperationId.project());
    assertEquals(ZONE, zoneOperationId.zone());
    assertEquals(NAME, zoneOperationId.operation());
    assertEquals(ZONE_URL, zoneOperationId.selfLink());
    zoneOperationId = ZoneOperationId.of(ZONE, NAME);
    assertNull(zoneOperationId.project());
    assertEquals(ZONE, zoneOperationId.zone());
    assertEquals(NAME, zoneOperationId.operation());
    RegionOperationId regionOperationId = RegionOperationId.of(PROJECT, REGION, NAME);
    assertEquals(PROJECT, regionOperationId.project());
    assertEquals(REGION, regionOperationId.region());
    assertEquals(NAME, regionOperationId.operation());
    assertEquals(REGION_URL, regionOperationId.selfLink());
    regionOperationId = RegionOperationId.of(REGION, NAME);
    assertNull(regionOperationId.project());
    assertEquals(REGION, regionOperationId.region());
    assertEquals(NAME, regionOperationId.operation());
  }

  @Test
  public void testToAndFromUrl() {
    GlobalOperationId operationId = GlobalOperationId.of(PROJECT, NAME);
    compareOperationId(operationId, GlobalOperationId.fromUrl(operationId.selfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid global operation URL");
    GlobalOperationId.fromUrl("notMatchingUrl");
    ZoneOperationId zoneOperationId = ZoneOperationId.of(PROJECT, ZONE, NAME);
    compareZoneOperationId(zoneOperationId, ZoneOperationId.fromUrl(zoneOperationId.selfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid zone operation URL");
    ZoneOperationId.fromUrl("notMatchingUrl");
    RegionOperationId regionOperationId = RegionOperationId.of(PROJECT, REGION, NAME);
    compareRegionOperationId(regionOperationId,
        RegionOperationId.fromUrl(regionOperationId.selfLink()));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid region operation URL");
    RegionOperationId.fromUrl("notMatchingUrl");
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
    compareRegionOperationId(regionOperationId,
        RegionOperationId.of(REGION, NAME).setProjectId(PROJECT));
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(GlobalOperationId.matchesUrl(GlobalOperationId.of(PROJECT, NAME).selfLink()));
    assertFalse(GlobalOperationId.matchesUrl("notMatchingUrl"));
    assertTrue(RegionOperationId.matchesUrl(RegionOperationId.of(PROJECT, REGION, NAME).selfLink()));
    assertFalse(RegionOperationId.matchesUrl("notMatchingUrl"));
    assertTrue(ZoneOperationId.matchesUrl(ZoneOperationId.of(PROJECT, REGION, NAME).selfLink()));
    assertFalse(ZoneOperationId.matchesUrl("notMatchingUrl"));
  }

  private void compareOperationId(GlobalOperationId expected, GlobalOperationId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.operation(), expected.operation());
    assertEquals(expected.selfLink(), expected.selfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }

  private void compareZoneOperationId(ZoneOperationId expected, ZoneOperationId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.zone(), expected.zone());
    assertEquals(expected.operation(), expected.operation());
    assertEquals(expected.selfLink(), expected.selfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }

  private void compareRegionOperationId(RegionOperationId expected, RegionOperationId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.region(), expected.region());
    assertEquals(expected.operation(), expected.operation());
    assertEquals(expected.selfLink(), expected.selfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
