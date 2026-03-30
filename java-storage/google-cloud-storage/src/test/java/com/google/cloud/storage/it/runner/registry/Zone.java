/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Zone {
  private static final Logger LOGGER = LoggerFactory.getLogger(Zone.class);

  private final String region;
  private final String zone;

  private Zone(String region, String zone) {
    this.zone = zone;
    this.region = region;
  }

  public String getRegion() {
    return region;
  }

  public String getZone() {
    return zone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Zone)) {
      return false;
    }
    Zone zone1 = (Zone) o;
    return Objects.equals(zone, zone1.zone) && Objects.equals(region, zone1.region);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone, region);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("region", region).add("zone", zone).toString();
  }

  public static Zone parse(String s) {
    String z = s;
    int idx = z.lastIndexOf('/');
    if (idx > -1) {
      z = z.substring(idx + 1);
    }
    String r = "";
    int idx2 = z.lastIndexOf('-');
    if (idx2 > -1) {
      r = z.substring(0, idx2);
    }
    return new Zone(r, z);
  }

  static final class ZoneShim implements ManagedLifecycle {

    private Zone zone;

    @Override
    public Zone get() {
      return zone;
    }

    @Override
    public void start() {
      try {
        zone = MetadataService.zone().orElseGet(() -> parse("us-east1-c"));
        LOGGER.info("Resolved zone = {}", zone);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void stop() {}
  }
}
