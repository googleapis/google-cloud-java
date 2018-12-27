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

/** Identity for a Google Compute Engine subnetwork. */
public final class SubnetworkId extends ResourceId {

  static final Function<String, SubnetworkId> FROM_URL_FUNCTION =
      new Function<String, SubnetworkId>() {
        @Override
        public SubnetworkId apply(String pb) {
          return SubnetworkId.fromUrl(pb);
        }
      };
  static final Function<SubnetworkId, String> TO_URL_FUNCTION =
      new Function<SubnetworkId, String>() {
        @Override
        public String apply(SubnetworkId zoneId) {
          return zoneId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "regions/([^/]+)/subnetworks/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -5451054513760540282L;

  private final String region;
  private final String subnetwork;

  private SubnetworkId(String project, String region, String subnetwork) {
    super(project);
    this.region = checkNotNull(region);
    this.subnetwork = checkNotNull(subnetwork);
  }

  /** Returns the name of the region this subnetwork belongs to. */
  public String getRegion() {
    return region;
  }

  /** Returns the identity of the region this subnetwork belongs to. */
  public RegionId getRegionId() {
    return RegionId.of(getProject(), region);
  }

  /**
   * Returns the name of the subnetwork. The name must be 1-63 characters long and comply with
   * RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getSubnetwork() {
    return subnetwork;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/regions/" + region + "/subnetworks/" + subnetwork;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("region", region).add("subnetwork", subnetwork);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), region, subnetwork);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof SubnetworkId)) {
      return false;
    }
    SubnetworkId other = (SubnetworkId) obj;
    return baseEquals(other)
        && Objects.equals(region, other.region)
        && Objects.equals(subnetwork, other.subnetwork);
  }

  @Override
  SubnetworkId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return SubnetworkId.of(projectId, getRegion(), subnetwork);
  }

  /**
   * Returns a subnetwork identity given the region identity and the subnetwork name. The subnetwork
   * name must be 1-63 characters long and comply with RFC1035. Specifically, the name must match
   * the regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must
   * be a lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static SubnetworkId of(RegionId regionId, String subnetwork) {
    return new SubnetworkId(regionId.getProject(), regionId.getRegion(), subnetwork);
  }

  /**
   * Returns a subnetwork identity given the region and subnetwork names. The subnetwork name must
   * be 1-63 characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static SubnetworkId of(String region, String subnetwork) {
    return new SubnetworkId(null, region, subnetwork);
  }

  /**
   * Returns a subnetwork identity given project, region and subnetwork names. The subnetwork name
   * must be 1-63 characters long and comply with RFC1035. Specifically, the name must match the
   * regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static SubnetworkId of(String project, String region, String subnetwork) {
    return new SubnetworkId(project, region, subnetwork);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a subnetwork URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static SubnetworkId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid subnetwork URL");
    }
    return SubnetworkId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
