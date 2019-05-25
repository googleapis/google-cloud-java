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
import com.google.common.base.MoreObjects.ToStringHelper;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** A Google Compute Engine region identity. */
public final class RegionId extends ResourceId {

  static final Function<String, RegionId> FROM_URL_FUNCTION =
      new Function<String, RegionId>() {
        @Override
        public RegionId apply(String pb) {
          return RegionId.fromUrl(pb);
        }
      };
  static final Function<RegionId, String> TO_URL_FUNCTION =
      new Function<RegionId, String>() {
        @Override
        public String apply(RegionId regionId) {
          return regionId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "regions/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 5569092266957249294L;

  private final String region;

  private RegionId(String project, String region) {
    super(project);
    this.region = checkNotNull(region);
  }

  private RegionId(RegionId regionId) {
    super(regionId.getProject());
    this.region = checkNotNull(regionId.getRegion());
  }

  /** Returns the name of the region. */
  public String getRegion() {
    return region;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/regions/" + region;
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper().add("region", region);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), region);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof RegionId)) {
      return false;
    }
    RegionId other = (RegionId) obj;
    return baseEquals(other) && Objects.equals(region, other.region);
  }

  @Override
  RegionId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return RegionId.of(projectId, region);
  }

  /** Returns a new region identity given project and region names. */
  public static RegionId of(String project, String region) {
    return new RegionId(project, region);
  }

  /** Returns a new region identity given region name. */
  public static RegionId of(String region) {
    return RegionId.of(null, region);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a region URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static RegionId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid region URL");
    }
    return RegionId.of(matcher.group(1), matcher.group(2));
  }
}
