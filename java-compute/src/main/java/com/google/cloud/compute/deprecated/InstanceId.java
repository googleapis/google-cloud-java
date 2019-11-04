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

/** Identity for a Google Compute Engine virtual machine instance. */
public final class InstanceId extends ResourceId {

  static final Function<String, InstanceId> FROM_URL_FUNCTION =
      new Function<String, InstanceId>() {
        @Override
        public InstanceId apply(String pb) {
          return InstanceId.fromUrl(pb);
        }
      };
  static final Function<InstanceId, String> TO_URL_FUNCTION =
      new Function<InstanceId, String>() {
        @Override
        public String apply(InstanceId instanceId) {
          return instanceId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "zones/([^/]+)/instances/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -2787043125223159922L;

  private final String zone;
  private final String instance;

  private InstanceId(String project, String zone, String instance) {
    super(project);
    this.zone = checkNotNull(zone);
    this.instance = checkNotNull(instance);
  }

  /**
   * Returns the name of the instance. The name must be 1-63 characters long and comply with
   * RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getInstance() {
    return instance;
  }

  /** Returns the name of the zone this instance belongs to. */
  public String getZone() {
    return zone;
  }

  /** Returns the identity of the zone this instance belongs to. */
  public ZoneId getZoneId() {
    return ZoneId.of(getProject(), zone);
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/zones/" + zone + "/instances/" + instance;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("zone", zone).add("instance", instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.baseHashCode(), zone, instance);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof InstanceId)) {
      return false;
    }
    InstanceId other = (InstanceId) obj;
    return baseEquals(other)
        && Objects.equals(zone, other.zone)
        && Objects.equals(instance, other.instance);
  }

  @Override
  InstanceId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return InstanceId.of(projectId, zone, instance);
  }

  /**
   * Returns an instance identity given the zone identity and the instance name. The instance name
   * must be 1-63 characters long and comply with RFC1035. Specifically, the name must match the
   * regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static InstanceId of(ZoneId zoneId, String instance) {
    return new InstanceId(zoneId.getProject(), zoneId.getZone(), instance);
  }

  /**
   * Returns an instance identity given the zone and instance names. The instance name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static InstanceId of(String zone, String instance) {
    return new InstanceId(null, zone, instance);
  }

  /**
   * Returns an instance identity given project, zone and instance names. The instance name must be
   * 1-63 characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static InstanceId of(String project, String zone, String instance) {
    return new InstanceId(project, zone, instance);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of an instance URL.
   * Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static InstanceId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid instance URL");
    }
    return InstanceId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
