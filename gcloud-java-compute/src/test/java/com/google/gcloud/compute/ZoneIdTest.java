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

public class ZoneIdTest {

  private static final String PROJECT = "project";
  private static final String ZONE = "zone";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/zones/zone";

  @Test
  public void testOf() {
    ZoneId zoneId = ZoneId.of(PROJECT, ZONE);
    assertEquals(PROJECT, zoneId.project());
    assertEquals(ZONE, zoneId.zone());
    assertEquals(URL, zoneId.toUrl());
    zoneId = ZoneId.of(ZONE);
    assertNull(zoneId.project());
    assertEquals(ZONE, zoneId.zone());
  }

  @Test
  public void testToAndFromUrl() {
    ZoneId zoneId = ZoneId.of(PROJECT, ZONE);
    compareZoneId(zoneId, ZoneId.fromUrl(zoneId.toUrl()));
  }

  @Test
  public void testSetProjectId() {
    ZoneId zoneId = ZoneId.of(PROJECT, ZONE);
    compareZoneId(zoneId, ZoneId.of(ZONE).setProjectId(PROJECT));
  }

  private void compareZoneId(ZoneId expected, ZoneId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.zone(), expected.zone());
    assertEquals(expected.toUrl(), expected.toUrl());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
