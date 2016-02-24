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
 * Identity for a Google Compute Engine disk type.
 */
public final class DiskTypeId extends ZoneResourceId {

  static final Function<String, DiskTypeId> FROM_URL_FUNCTION = new Function<String, DiskTypeId>() {
    @Override
    public DiskTypeId apply(String pb) {
      return DiskTypeId.fromUrl(pb);
    }
  };
  static final Function<DiskTypeId, String> TO_URL_FUNCTION = new Function<DiskTypeId, String>() {
    @Override
    public String apply(DiskTypeId diskTypeId) {
      return diskTypeId.toUrl();
    }
  };

  static final String REGEX = ZoneResourceId.REGEX + "diskTypes/[^/]+";
  private static final long serialVersionUID = 7337881474103686219L;

  private final String diskType;

  private DiskTypeId(String project, String zone, String diskType) {
    super(project, zone);
    this.diskType = checkNotNull(diskType);
  }

  /**
   * Returns the name of the disk type resource. The name must be 1-63 characters long, and comply
   * with RFC1035. Specifically, the name must be 1-63 characters long and match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String diskType() {
    return diskType;
  }

  @Override
  public String toUrl() {
    return super.toUrl() + "/diskTypes/" + diskType;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("diskType", diskType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), diskType);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof DiskTypeId && baseEquals((DiskTypeId) obj);
  }

  @Override
  DiskTypeId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return DiskTypeId.of(projectId, zone(), diskType);
  }

  /**
   * Returns a disk type identity given the zone identity and the disk type name.
   */
  public static DiskTypeId of(ZoneId zoneId, String diskType) {
    return new DiskTypeId(zoneId.project(), zoneId.zone(), diskType);
  }

  /**
   * Returns a disk type identity given the zone and disk type names.
   */
  public static DiskTypeId of(String zone, String diskType) {
    return of(ZoneId.of(null, zone), diskType);
  }

  /**
   * Returns a disk type identity given project disk, zone and disk type names.
   */
  public static DiskTypeId of(String project, String zone, String diskType) {
    return of(ZoneId.of(project, zone), diskType);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a disk type URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return url.matches(REGEX);
  }

  static DiskTypeId fromUrl(String url) {
    if (!matchesUrl(url)) {
      throw new IllegalArgumentException(url + " is not a valid disk type URL");
    }
    int projectsIndex = url.indexOf("/projects/");
    int zonesIndex = url.indexOf("/zones/");
    int diskTypesIndex = url.indexOf("/diskTypes/");
    String project = url.substring(projectsIndex + 10, zonesIndex);
    String zone = url.substring(zonesIndex + 7, diskTypesIndex);
    String diskType = url.substring(diskTypesIndex + 11, url.length());
    return DiskTypeId.of(project, zone, diskType);
  }
}
