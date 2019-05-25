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

public class ZoneIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone";

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testOf() {
    ZoneId zoneId = ZoneId.of(PROJECT, ZONE);
    assertEquals(PROJECT, zoneId.getProject());
    assertEquals(ZONE, zoneId.getZone());
    assertEquals(URL, zoneId.getSelfLink());
    zoneId = ZoneId.of(ZONE);
    assertNull(zoneId.getProject());
    assertEquals(ZONE, zoneId.getZone());
  }

  @Test
  public void testToAndFromUrl() {
    ZoneId zoneId = ZoneId.of(PROJECT, ZONE);
    compareZoneId(zoneId, ZoneId.fromUrl(zoneId.getSelfLink()));
  }

  @Test
  public void testSetProjectId() {
    ZoneId zoneId = ZoneId.of(PROJECT, ZONE);
    assertSame(zoneId, zoneId.setProjectId(PROJECT));
    compareZoneId(zoneId, ZoneId.of(ZONE).setProjectId(PROJECT));
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("notMatchingUrl is not a valid zone URL");
    ZoneId.fromUrl("notMatchingUrl");
  }

  @Test
  public void testMatchesUrl() {
    assertTrue(ZoneId.matchesUrl(ZoneId.of(PROJECT, ZONE).getSelfLink()));
    assertFalse(ZoneId.matchesUrl("notMatchingUrl"));
  }

  private void compareZoneId(ZoneId expected, ZoneId value) {
    assertEquals(expected, value);
    assertEquals(expected.getProject(), expected.getProject());
    assertEquals(expected.getZone(), expected.getZone());
    assertEquals(expected.getSelfLink(), expected.getSelfLink());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
