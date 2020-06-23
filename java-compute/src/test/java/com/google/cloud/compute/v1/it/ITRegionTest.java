/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.Region;
import com.google.cloud.compute.v1.RegionClient;
import com.google.cloud.compute.v1.RegionSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITRegionTest extends BaseTest {
  private static final String STATUS = "UP";

  private static RegionClient regionClient;

  @BeforeClass
  public static void setUp() throws IOException {
    RegionSettings regionSettings =
        RegionSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionClient = RegionClient.create(regionSettings);
  }

  @AfterClass
  public static void tearDown() {
    regionClient.close();
  }

  @Test
  public void getRegionTest() {
    Region region = regionClient.getRegion(PROJECT_REGION_NAME);
    assertThat(region).isNotNull();
    assertThat(region.getName()).isEqualTo(REGION);
    assertThat(region.getSelfLink()).isEqualTo(REGION_LINK);
    assertThat(region.getStatus()).isEqualTo(STATUS);
  }

  @Test
  public void listRegionsTest() {
    List<Region> regions = Lists.newArrayList(regionClient.listRegions(PROJECT_NAME).iterateAll());
    assertThat(regions).isNotNull();
    assertThat(regions.size()).isGreaterThan(0);
    assertThat(regions.contains(null)).isFalse();
    for (Region region : regions) {
      if (REGION.equals(region.getName())) {
        assertThat(region.getName()).isEqualTo(REGION);
        assertThat(region.getSelfLink()).isEqualTo(REGION_LINK);
        assertThat(region.getStatus()).isEqualTo(STATUS);
      }
    }
  }
}
