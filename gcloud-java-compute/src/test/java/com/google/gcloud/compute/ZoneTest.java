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

import com.google.common.collect.ImmutableList;
import com.google.gcloud.compute.Zone.MaintenanceWindow;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

public class ZoneTest {

  private static final ZoneId ZONE_ID = ZoneId.of("project", "zone");
  private static final RegionId REGION_ID = RegionId.of("project", "region");
  private static final BigInteger ID = BigInteger.valueOf(42L);
  private static final String CREATION_TIMESTAMP = "2016-01-20T04:39:00.210-08:00";
  private static final String DESCRIPTION = "description";
  private static final Zone.Status STATUS = Zone.Status.DOWN;
  private static final MaintenanceWindow WINDOW1 = new MaintenanceWindow("NAME1", "DESCRIPTION1",
      "2016-01-20T04:39:00.210-08:00", "2016-01-21T04:39:00.210-08:00");
  private static final MaintenanceWindow WINDOW2 = new MaintenanceWindow("NAME2", "DESCRIPTION2",
      "2016-01-21T04:39:00.210-08:00", "2016-01-22T04:39:00.210-08:00");
  private static final List<MaintenanceWindow> WINDOWS = ImmutableList.of(WINDOW1, WINDOW2);
  private static final String DELETED = "2016-01-20T04:39:00.210-08:00";
  private static final String DEPRECATED = "2016-01-20T04:37:00.210-08:00";
  private static final String OBSOLETE = "2016-01-20T04:38:00.210-08:00";
  private static final DeprecationStatus<ZoneId> DEPRECATION_STATUS = new DeprecationStatus<>(
      DELETED, DEPRECATED, OBSOLETE, ZONE_ID, DeprecationStatus.Status.DELETED);
  private static final Zone ZONE = Zone.builder()
      .zoneId(ZONE_ID)
      .id(ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .selfLink(ZONE_ID.toUrl())
      .status(STATUS)
      .maintenanceWindows(WINDOWS)
      .deprecationStatus(DEPRECATION_STATUS)
      .region(REGION_ID)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(REGION_ID, ZONE.region());
    assertEquals(ID, ZONE.id());
    assertEquals(CREATION_TIMESTAMP, ZONE.creationTimestamp());
    assertEquals(DESCRIPTION, ZONE.description());
    assertEquals(ZONE_ID.toUrl(), ZONE.selfLink());
    assertEquals(STATUS, ZONE.status());
    assertEquals(WINDOWS, ZONE.maintenanceWindows());
    assertEquals(REGION_ID, ZONE.region());
    assertEquals(DEPRECATION_STATUS, ZONE.deprecationStatus());
  }

  @Test
  public void testToAndFromPb() {
    com.google.api.services.compute.model.Zone zonePb = ZONE.toPb();
    assertEquals(REGION_ID.toUrl(), zonePb.getRegion());
    Zone zone = Zone.fromPb(zonePb);
    compareZones(ZONE, zone);
    assertEquals(ZONE_ID.project(), zone.zoneId().project());
    assertEquals(ZONE_ID.zone(), zone.zoneId().zone());
    zone = Zone.builder().zoneId(ZONE_ID).selfLink(ZONE_ID.toUrl()).build();
    compareZones(zone, Zone.fromPb(zone.toPb()));
  }

  private void compareZones(Zone expected, Zone value) {
    assertEquals(expected, value);
    assertEquals(expected.zoneId(), value.zoneId());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.maintenanceWindows(), value.maintenanceWindows());
    assertEquals(expected.region(), value.region());
    assertEquals(expected.deprecationStatus(), value.deprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
