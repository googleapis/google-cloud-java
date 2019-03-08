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

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine region's operation. */
public final class RegionOperationId extends OperationId {

  private static final String REGEX = ResourceId.REGEX + "regions/([^/]+)/operations/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 5816161906501886782L;

  private final String region;

  private RegionOperationId(String project, String region, String operation) {
    super(project, operation);
    this.region = checkNotNull(region);
  }

  @Override
  public Type getType() {
    return Type.REGION;
  }

  /** Returns the name of the region this operation belongs to. */
  public String getRegion() {
    return region;
  }

  /** Returns the identity of the region this operation belongs to. */
  public RegionId getRegionId() {
    return RegionId.of(getProject(), region);
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/regions/" + region + "/operations/" + getOperation();
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("region", region);
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
    if (!(obj instanceof RegionOperationId)) {
      return false;
    }
    RegionOperationId other = (RegionOperationId) obj;
    return baseEquals(other) && Objects.equals(region, other.region);
  }

  @Override
  RegionOperationId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return RegionOperationId.of(projectId, region, getOperation());
  }

  /** Returns a region operation identity given the region identity and the operation name. */
  public static RegionOperationId of(RegionId regionId, String operation) {
    return new RegionOperationId(regionId.getProject(), regionId.getRegion(), operation);
  }

  /** Returns a region operation identity given the region and operation names. */
  public static RegionOperationId of(String region, String operation) {
    return new RegionOperationId(null, region, operation);
  }

  /** Returns a region operation identity given project, region and operation names. */
  public static RegionOperationId of(String project, String region, String operation) {
    return new RegionOperationId(project, region, operation);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a region operation
   * URL. Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static RegionOperationId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid region operation URL");
    }
    return RegionOperationId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
