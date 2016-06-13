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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class RegionTest {

  private static final RegionId REGION_ID = RegionId.of("project", "region");
  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final Region.Status STATUS = Region.Status.DOWN;
  private static final ZoneId ZONE_ID1 = ZoneId.of("project", "zone1");
  private static final ZoneId ZONE_ID2 = ZoneId.of("project", "zone2");
  private static final List<ZoneId> ZONES = ImmutableList.of(ZONE_ID1, ZONE_ID2);
  private static final Region.Quota QUOTA1 =
      new Region.Quota("METRIC1", 2, 1);
  private static final Region.Quota QUOTA2 =
      new Region.Quota("METRIC2", 4, 3);
  private static final List<Region.Quota> QUOTAS = ImmutableList.of(QUOTA1, QUOTA2);
  private static final DeprecationStatus<RegionId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, REGION_ID);
  private static final Region REGION = Region.builder()
      .regionId(REGION_ID)
      .generatedId(GENERATED_ID)
      .creationTimestamp(CREATION_TIMESTAMP)
      .description(DESCRIPTION)
      .status(STATUS)
      .zones(ZONES)
      .quotas(QUOTAS)
      .deprecationStatus(DEPRECATION_STATUS)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(REGION_ID, REGION.regionId());
    assertEquals(GENERATED_ID, REGION.generatedId());
    assertEquals(CREATION_TIMESTAMP, REGION.creationTimestamp());
    assertEquals(DESCRIPTION, REGION.description());
    assertEquals(STATUS, REGION.status());
    assertEquals(ZONES, REGION.zones());
    assertEquals(QUOTAS, REGION.quotas());
    assertEquals(DEPRECATION_STATUS, REGION.deprecationStatus());
  }

  @Test
  public void testToAndFromPb() {
    Region region = Region.fromPb(REGION.toPb());
    compareRegions(REGION, region);
    assertEquals(REGION_ID.project(), region.regionId().project());
    assertEquals(REGION_ID.region(), region.regionId().region());
    region = Region.builder().regionId(REGION_ID).build();
    compareRegions(region, Region.fromPb(region.toPb()));
  }

  private void compareRegions(Region expected, Region value) {
    assertEquals(expected, value);
    assertEquals(expected.regionId(), value.regionId());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.creationTimestamp(), value.creationTimestamp());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.zones(), value.zones());
    assertEquals(expected.quotas(), value.quotas());
    assertEquals(expected.deprecationStatus(), value.deprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
