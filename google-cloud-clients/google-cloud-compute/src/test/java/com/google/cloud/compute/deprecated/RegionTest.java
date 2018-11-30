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

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class RegionTest {

  private static final RegionId REGION_ID = RegionId.of("project", "region");
  private static final String GENERATED_ID = "42";
  private static final Long CREATION_TIMESTAMP = 1453293540000L;
  private static final String DESCRIPTION = "description";
  private static final Region.Status STATUS = Region.Status.DOWN;
  private static final ZoneId ZONE_ID1 = ZoneId.of("project", "zone1");
  private static final ZoneId ZONE_ID2 = ZoneId.of("project", "zone2");
  private static final List<ZoneId> ZONES = ImmutableList.of(ZONE_ID1, ZONE_ID2);
  private static final Region.Quota QUOTA1 = new Region.Quota("METRIC1", 2, 1);
  private static final Region.Quota QUOTA2 = new Region.Quota("METRIC2", 4, 3);
  private static final List<Region.Quota> QUOTAS = ImmutableList.of(QUOTA1, QUOTA2);
  private static final DeprecationStatus<RegionId> DEPRECATION_STATUS =
      DeprecationStatus.of(DeprecationStatus.Status.DELETED, REGION_ID);
  private static final Region REGION =
      Region.builder()
          .setRegionId(REGION_ID)
          .setGeneratedId(GENERATED_ID)
          .setCreationTimestamp(CREATION_TIMESTAMP)
          .setDescription(DESCRIPTION)
          .setStatus(STATUS)
          .setZones(ZONES)
          .setQuotas(QUOTAS)
          .setDeprecationStatus(DEPRECATION_STATUS)
          .build();

  @Test
  public void testBuilder() {
    assertEquals(REGION_ID, REGION.getRegionId());
    assertEquals(GENERATED_ID, REGION.getGeneratedId());
    assertEquals(CREATION_TIMESTAMP, REGION.getCreationTimestamp());
    assertEquals(DESCRIPTION, REGION.getDescription());
    assertEquals(STATUS, REGION.getStatus());
    assertEquals(ZONES, REGION.getZones());
    assertEquals(QUOTAS, REGION.getQuotas());
    assertEquals(DEPRECATION_STATUS, REGION.getDeprecationStatus());
  }

  @Test
  public void testToAndFromPb() {
    Region region = Region.fromPb(REGION.toPb());
    compareRegions(REGION, region);
    assertEquals(REGION_ID.getProject(), region.getRegionId().getProject());
    assertEquals(REGION_ID.getRegion(), region.getRegionId().getRegion());
    region = Region.builder().setRegionId(REGION_ID).build();
    compareRegions(region, Region.fromPb(region.toPb()));
  }

  private void compareRegions(Region expected, Region value) {
    assertEquals(expected, value);
    assertEquals(expected.getRegionId(), value.getRegionId());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getCreationTimestamp(), value.getCreationTimestamp());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getZones(), value.getZones());
    assertEquals(expected.getQuotas(), value.getQuotas());
    assertEquals(expected.getDeprecationStatus(), value.getDeprecationStatus());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
