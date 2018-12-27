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
  private static final Zone ZONE =
      Zone.builder()
          .setZoneId(ZONE_ID)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setStatus(STATUS)
          .setDeprecationStatus(DEPRECATION_STATUS)
          .setRegion(REGION_ID)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(REGION_ID, ZONE.getRegion());
    assertEquals(GENERATED_ID, ZONE.getGeneratedId());
    assertEquals(CREATION_TIMESTAMP, ZONE.getCreationTimestamp());
    assertEquals(DESCRIPTION, ZONE.getDescription());
    assertEquals(STATUS, ZONE.getStatus());
    assertEquals(REGION_ID, ZONE.getRegion());
    assertEquals(DEPRECATION_STATUS, ZONE.getDeprecationStatus());
  }

  @Test
  public void testToAndFromPb() {
    com.google.api.services.compute.model.Zone zonePb = ZONE.toPb();
    assertEquals(REGION_ID.getSelfLink(), zonePb.getRegion());
    Zone zone = Zone.fromPb(zonePb);
    compareZones(ZONE, zone);
    assertEquals(ZONE_ID.getProject(), zone.getZoneId().getProject());
    assertEquals(ZONE_ID.getZone(), zone.getZoneId().getZone());
    zone = Zone.builder().setZoneId(ZONE_ID).build();
    compareZones(zone, Zone.fromPb(zone.toPb()));
  }

  private void compareZones(Zone expected, Zone value) {
    assertEquals(expected, value);
    assertEquals(expected.getZoneId(), value.getZoneId());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getRegion(), value.getRegion());
    assertEquals(expected.getDeprecationStatus(), value.getDeprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
