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

import com.google.cloud.compute.v1.Zone;
import com.google.cloud.compute.v1.ZoneClient;
import com.google.cloud.compute.v1.ZoneSettings;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITZoneTest extends BaseTest {
  private static final String STATUS = "UP";

  private static ZoneClient zoneClient;

  @BeforeClass
  public static void setUp() throws IOException {
    ZoneSettings zoneSettings =
        ZoneSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    zoneClient = ZoneClient.create(zoneSettings);
  }

  @AfterClass
  public static void tearDown() {
    zoneClient.close();
  }

  @Test
  public void getZoneTest() {
    Zone zone = zoneClient.getZone(PROJECT_ZONE_NAME);
    assertThat(zone.getName()).isEqualTo(ZONE);
    assertThat(zone.getRegion()).isEqualTo(REGION_LINK);
    assertThat(zone.getSelfLink()).isEqualTo(ZONE_SELF_LINK);
    assertThat(zone.getStatus()).isEqualTo(STATUS);
    assertThat(zone.getDescription()).isEqualTo(ZONE);
  }

  @Test
  public void listZonesTest() {
    List<Zone> zones = Lists.newArrayList(zoneClient.listZones(PROJECT_NAME).iterateAll());
    for (Zone zone : zones) {
      if (ZONE.equals(zone.getName())) {
        assertThat(zone.getName()).isEqualTo(ZONE);
        assertThat(zone.getRegion()).isEqualTo(REGION_LINK);
        assertThat(zone.getSelfLink()).isEqualTo(ZONE_SELF_LINK);
        assertThat(zone.getStatus()).isEqualTo(STATUS);
        assertThat(zone.getDescription()).isEqualTo(ZONE);
      }
    }
  }
}
