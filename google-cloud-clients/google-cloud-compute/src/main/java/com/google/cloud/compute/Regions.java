/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration of Regions.
 *
 * @see <a href="https://cloud.google.com/compute/docs/regions-zones/">Regions and Zones</a>
 */
public enum Regions {
  ASIA_EAST1("asia-east1", new String[] {"asia-east1-a", "asia-east1-b", "asia-east1-c"}),
  ASIA_EAST2("asia-east2", new String[] {"asia-east2-a", "asia-east2-b", "asia-east2-c"}),
  ASIA_NORTHEAST1(
      "asia-northeast1",
      new String[] {"asia-northeast1-a", "asia-northeast1-b", "asia-northeast1-c"}),
  ASIA_SOUTH1("asia-south1", new String[] {"asia-south1-a", "asia-south1-b", "asia-south1-c"}),
  ASIA_SOUTHEAST1(
      "asia-southeast1",
      new String[] {"asia-southeast1-a", "asia-southeast1-b", "asia-southeast1-c"}),
  AUSTRALIA_SOUTHEAST1(
      "australia-southeast1",
      new String[] {"australia-southeast1-a", "australia-southeast1-b", "australia-southeast1-c"}),
  EUROPE_NORTH1(
      "europe-north1", new String[] {"europe-north1-a", "europe-north1-b", "europe-north1-c"}),
  EUROPE_WEST1("europe-west1", new String[] {"europe-west1-b", "europe-west1-c", "europe-west1-d"}),
  EUROPE_WEST2("europe-west2", new String[] {"europe-west2-a", "europe-west2-b", "europe-west2-c"}),
  EUROPE_WEST3("europe-west3", new String[] {"europe-west3-a", "europe-west3-b", "europe-west3-c"}),
  EUROPE_WEST4("europe-west4", new String[] {"europe-west4-a", "europe-west4-b", "europe-west4-c"}),
  NORTHAMERICA_NORTHEAST1(
      "northamerica-northeast1",
      new String[] {
        "northamerica-northeast1-a", "northamerica-northeast1-b", "northamerica-northeast1-c"
      }),
  SOUTHAMERICA_EAST1(
      "southamerica-east1",
      new String[] {"southamerica-east1-a", "southamerica-east1-b", "southamerica-east1-c"}),
  US_CENTRAL1(
      "us-central1",
      new String[] {"us-central1-a", "us-central1-b", "us-central1-c", "us-central1-f"}),
  US_EAST1("us-east1", new String[] {"us-east1-b", "us-east1-c", "us-east1-d"}),
  US_EAST4("us-east4", new String[] {"us-east4-a", "us-east4-b", "us-east4-c"}),
  US_WEST1("us-west1", new String[] {"us-west1-a", "us-west1-b", "us-west1-c"}),
  US_WEST2("us-west2", new String[] {"us-west2-a", "us-west2-b", "us-west2-c"});

  private static final Map<String, Regions> REGIONS = new HashMap<>();

  static {
    for (Regions region : Regions.values()) {
      REGIONS.put(region.name, region);
    }
  }

  private final String name;
  private final String[] zones;

  private Regions(String name, String[] zones) {
    this.name = name;
    this.zones = zones;
  }

  /** The name of this region. */
  public String getName() {
    return name;
  }

  /** The zones of this region. */
  public String[] getZones() {
    return zones;
  }

  /**
   * Returns a Regions enum corresponding to the given region name.
   *
   * @param regionName The name of the region.
   * @return Regions enum representing the given region name, or a null if there is no Regions enum
   *     that is representing the given region name.
   */
  public static Regions fromName(String regionName) {
    return REGIONS.get(regionName);
  }
}
