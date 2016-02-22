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

public class RegionIdTest {

  private static final String PROJECT = "project";
  private static final String REGION = "region";
  private static final String URL =
      "https://www.googleapis.com/compute/v1/projects/project/regions/region";

  @Test
  public void testOf() {
    RegionId regionId = RegionId.of(PROJECT, REGION);
    assertEquals(PROJECT, regionId.project());
    assertEquals(REGION, regionId.region());
    assertEquals(URL, regionId.toUrl());
    regionId = RegionId.of(REGION);
    assertNull(regionId.project());
    assertEquals(REGION, regionId.region());
  }

  @Test
  public void testToAndFromUrl() {
    RegionId regionId = RegionId.of(PROJECT, REGION);
    compareRegionId(regionId, RegionId.fromUrl(regionId.toUrl()));
  }

  @Test
  public void testSetProjectId() {
    RegionId regionId = RegionId.of(PROJECT, REGION);
    compareRegionId(regionId, RegionId.of(REGION).setProjectId(PROJECT));
  }

  private void compareRegionId(RegionId expected, RegionId value) {
    assertEquals(expected, value);
    assertEquals(expected.project(), expected.project());
    assertEquals(expected.region(), expected.region());
    assertEquals(expected.toUrl(), expected.toUrl());
    assertEquals(expected.hashCode(), expected.hashCode());
  }
}
