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

/**
 * Identity for a Google Compute Engine machine type.
 */
public final class MachineTypeId extends ZoneResourceId {

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
          return machineTypeId.toUrl();
        }
      };

  static final String REGEX = ZoneResourceId.REGEX + "machineTypes/[^/]+";
  private static final long serialVersionUID = -5819598544478859608L;

  private final String machineType;

  private MachineTypeId(String project, String zone, String machineType) {
    super(project, zone);
    this.machineType = checkNotNull(machineType);
  }

  /**
   * Returns the name of the machine type.
   */
  public String machineType() {
    return machineType;
  }

  @Override
  public String toUrl() {
    return super.toUrl() + "/machineTypes/" + machineType;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("machineType", machineType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), machineType);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof MachineTypeId && baseEquals((MachineTypeId) obj);
  }

  @Override
  MachineTypeId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return MachineTypeId.of(projectId, zone(), machineType);
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
    return url.matches(REGEX);
  }

  static MachineTypeId fromUrl(String url) {
    if (!matchesUrl(url)) {
      throw new IllegalArgumentException(url + " is not a valid machine type URL");
    }
    int projectsIndex = url.indexOf("/projects/");
    int zonesIndex = url.indexOf("/zones/");
    int machineTypesIndex = url.indexOf("/machineTypes/");
    String project = url.substring(projectsIndex + 10, zonesIndex);
    String zone = url.substring(zonesIndex + 7, machineTypesIndex);
    String machineType = url.substring(machineTypesIndex + 14, url.length());
    return MachineTypeId.of(project, zone, machineType);
  }
}
