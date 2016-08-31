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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ZoneTest {

  private static final ZoneId ZONE_ID = ZoneId.of("project", "zone");
  private static final RegionId REGION_ID = RegionId.of("project", "region");
  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final Zone.Status STATUS = Zone.Status.DOWN;
  private static final DeprecationStatus<ZoneId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, ZONE_ID);
  private static final Zone ZONE = Zone.builder()
      .zoneId(ZONE_ID)
      .generatedId(GENERATED_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(STATUS)
      .deprecationStatus(DEPRECATION_STATUS)
      .region(REGION_ID)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(REGION_ID, ZONE.region());
    assertEquals(GENERATED_ID, ZONE.generatedId());
    assertEquals(CREATION_TIMESTAMP, ZONE.creationTimestamp());
    assertEquals(DESCRIPTION, ZONE.description());
    assertEquals(STATUS, ZONE.status());
    assertEquals(REGION_ID, ZONE.region());
    assertEquals(DEPRECATION_STATUS, ZONE.deprecationStatus());
  }

  @Test
  public void testToAndFromPb() {
    com.google.api.services.compute.model.Zone zonePb = ZONE.toPb();
    assertEquals(REGION_ID.selfLink(), zonePb.getRegion());
    Zone zone = Zone.fromPb(zonePb);
    compareZones(ZONE, zone);
    assertEquals(ZONE_ID.project(), zone.zoneId().project());
    assertEquals(ZONE_ID.zone(), zone.zoneId().zone());
    zone = Zone.builder().zoneId(ZONE_ID).build();
    compareZones(zone, Zone.fromPb(zone.toPb()));
  }

  private void compareZones(Zone expected, Zone value) {
    assertEquals(expected, value);
    assertEquals(expected.zoneId(), value.zoneId());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.region(), value.region());
    assertEquals(expected.deprecationStatus(), value.deprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
