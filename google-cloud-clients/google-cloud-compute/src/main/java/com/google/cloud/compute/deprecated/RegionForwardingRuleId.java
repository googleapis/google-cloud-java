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

/** Identity for a Google Compute Engine region's forwarding rule. */
public final class RegionForwardingRuleId extends ForwardingRuleId {

  static final Function<String, RegionForwardingRuleId> FROM_URL_FUNCTION =
      new Function<String, RegionForwardingRuleId>() {
        @Override
        public RegionForwardingRuleId apply(String pb) {
          return RegionForwardingRuleId.fromUrl(pb);
        }
      };
  static final Function<RegionForwardingRuleId, String> TO_URL_FUNCTION =
      new Function<RegionForwardingRuleId, String>() {
        @Override
        public String apply(RegionForwardingRuleId forwardingRuleId) {
          return forwardingRuleId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "regions/([^/]+)/forwardingRules/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 7885327931402904667L;

  private final String region;

  private RegionForwardingRuleId(String project, String region, String rule) {
    super(project, rule);
    this.region = checkNotNull(region);
  }

  @Override
  public Type getType() {
    return Type.REGION;
  }

  /** Returns the name of the region this forwarding rule belongs to. */
  public String getRegion() {
    return region;
  }

  /** Returns the identity of the region this forwarding rule belongs to. */
  public RegionId getRegionId() {
    return RegionId.of(getProject(), region);
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/regions/" + region + "/forwardingRules/" + getRule();
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
    if (!(obj instanceof RegionForwardingRuleId)) {
      return false;
    }
    RegionForwardingRuleId other = (RegionForwardingRuleId) obj;
    return baseEquals(other) && Objects.equals(region, other.region);
  }

  @Override
  RegionForwardingRuleId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return RegionForwardingRuleId.of(projectId, region, getRule());
  }

  /**
   * Returns a region forwarding rule identity given the region identity and the rule name. The
   * forwarding rule name must be 1-63 characters long and comply with RFC1035. Specifically, the
   * name must match the regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static RegionForwardingRuleId of(RegionId regionId, String rule) {
    return new RegionForwardingRuleId(regionId.getProject(), regionId.getRegion(), rule);
  }

  /**
   * Returns a region forwarding rule identity given the region and rule names. The forwarding rule
   * name must be 1-63 characters long and comply with RFC1035. Specifically, the name must match
   * the regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must
   * be a lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static RegionForwardingRuleId of(String region, String rule) {
    return new RegionForwardingRuleId(null, region, rule);
  }

  /**
   * Returns a region forwarding rule identity given project, region and rule names. The forwarding
   * rule name must be 1-63 characters long and comply with RFC1035. Specifically, the name must
   * match the regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character
   * must be a lowercase letter, and all following characters must be a dash, lowercase letter, or
   * digit, except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static RegionForwardingRuleId of(String project, String region, String rule) {
    return new RegionForwardingRuleId(project, region, rule);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a region forwarding
   * rule URL. Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static RegionForwardingRuleId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid region forwarding rule URL");
    }
    return RegionForwardingRuleId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
