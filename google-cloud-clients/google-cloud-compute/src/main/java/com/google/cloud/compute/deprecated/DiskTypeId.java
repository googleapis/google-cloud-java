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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Identity for a Google Compute Engine disk type.
 */
public final class DiskTypeId extends ResourceId {

  static final Function<String, DiskTypeId> FROM_URL_FUNCTION = new Function<String, DiskTypeId>() {
    @Override
    public DiskTypeId apply(String pb) {
      return DiskTypeId.fromUrl(pb);
    }
  };
  static final Function<DiskTypeId, String> TO_URL_FUNCTION = new Function<DiskTypeId, String>() {
    @Override
    public String apply(DiskTypeId diskTypeId) {
      return diskTypeId.getSelfLink();
    }
  };

  private static final String REGEX = ResourceId.REGEX + "regions/([^/]+)/diskTypes/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 7337881474103686219L;

  private final String region;
  private final String type;

  private DiskTypeId(String project, String region, String type) {
    super(project);
    this.region = checkNotNull(region);
    this.type = checkNotNull(type);
  }

  /**
   * Returns the name of the disk type.
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the name of the region this disk type belongs to.
   */
  public String getZone() {
    return region;
  }

  /**
   * Returns the identity of the region this disk type belongs to.
   */
  public ZoneId getZoneId() {
    return ZoneId.of(getProject(), region);
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/regions/" + region + "/diskTypes/" + type;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("region", region).add("type", type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.baseHashCode(), region, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof DiskTypeId)) {
      return false;
    }
    DiskTypeId other = (DiskTypeId) obj;
    return baseEquals(other)
        && Objects.equals(region, other.region)
        && Objects.equals(type, other.type);
  }

  @Override
  DiskTypeId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return DiskTypeId.of(projectId, region, type);
  }

  /**
   * Returns a disk type identity given the region identity and the disk type name.
   */
  public static DiskTypeId of(ZoneId zoneId, String type) {
    return new DiskTypeId(zoneId.getProject(), zoneId.getZone(), type);
  }

  /**
   * Returns a disk type identity given the region and disk type names.
   */
  public static DiskTypeId of(String region, String type) {
    return of(ZoneId.of(null, region), type);
  }

  /**
   * Returns a disk type identity given project disk, region and disk type names.
   */
  public static DiskTypeId of(String project, String region, String type) {
    return of(ZoneId.of(project, region), type);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a disk type URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static DiskTypeId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid disk type URL");
    }
    return DiskTypeId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
