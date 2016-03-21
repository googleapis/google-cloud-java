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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Identity for a Google Compute Engine machine type.
 */
public final class MachineTypeId extends ResourceId {

  static final Function<String, MachineTypeId> FROM_URL_FUNCTION =
      new Function<String, MachineTypeId>() {
        @Override
        public MachineTypeId apply(String pb) {
          return MachineTypeId.fromUrl(pb);
        }
      };
  static final Function<MachineTypeId, String> TO_URL_FUNCTION =
      new Function<MachineTypeId, String>() {
        @Override
        public String apply(MachineTypeId machineTypeId) {
          return machineTypeId.selfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "zones/([^/]+)/machineTypes/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -5819598544478859608L;

  private final String zone;
  private final String machineType;

  private MachineTypeId(String project, String zone, String machineType) {
    super(project);
    this.zone = checkNotNull(zone);
    this.machineType = checkNotNull(machineType);
  }

  /**
   * Returns the name of the machine type.
   */
  public String machineType() {
    return machineType;
  }

  /**
   * Returns the name of the zone this machine type belongs to.
   */
  public String zone() {
    return zone;
  }

  /**
   * Returns the identity of the zone this machine type belongs to.
   */
  public ZoneId zoneId() {
    return ZoneId.of(project(), zone);
  }

  @Override
  public String selfLink() {
    return super.selfLink() + "/zones/" + zone + "/machineTypes/" + machineType;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("zone", zone).add("machineType", machineType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), zone, machineType);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof MachineTypeId
        && baseEquals((MachineTypeId) obj)
        && Objects.equals(zone, ((MachineTypeId) obj).zone)
        && Objects.equals(machineType, ((MachineTypeId) obj).machineType);
  }

  @Override
  MachineTypeId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return MachineTypeId.of(projectId, zone, machineType);
  }

  /**
   * Returns a machine type identity given the zone and type names.
   */
  public static MachineTypeId of(String zone, String machineType) {
    return new MachineTypeId(null, zone, machineType);
  }

  /**
   * Returns a machine type identity given project, zone and type names.
   */
  public static MachineTypeId of(String project, String zone, String machineType) {
    return new MachineTypeId(project, zone, machineType);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a machine type URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static MachineTypeId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid machine type URL");
    }
    return MachineTypeId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
