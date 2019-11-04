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

/** A Google Compute Engine zone identity. */
public final class ZoneId extends ResourceId {

  static final Function<String, ZoneId> FROM_URL_FUNCTION =
      new Function<String, ZoneId>() {
        @Override
        public ZoneId apply(String pb) {
          return ZoneId.fromUrl(pb);
        }
      };
  static final Function<ZoneId, String> TO_URL_FUNCTION =
      new Function<ZoneId, String>() {
        @Override
        public String apply(ZoneId zoneId) {
          return zoneId.getSelfLink();
        }
      };

  private static final String REGEX = ResourceId.REGEX + "zones/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -7635391994812946733L;

  private final String zone;

  private ZoneId(String project, String zone) {
    super(project);
    this.zone = checkNotNull(zone);
  }

  /** Returns the name of the zone. */
  public String getZone() {
    return zone;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/zones/" + zone;
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper().add("zone", zone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), zone);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof ZoneId)) {
      return false;
    }
    ZoneId other = (ZoneId) obj;
    return baseEquals(other) && Objects.equals(zone, other.zone);
  }

  @Override
  ZoneId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return ZoneId.of(projectId, zone);
  }

  /** Returns a new zone identity given project and zone names. */
  public static ZoneId of(String project, String zone) {
    return new ZoneId(project, zone);
  }

  /** Returns a new zone identity given zone name. */
  public static ZoneId of(String zone) {
    return ZoneId.of(null, zone);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a zone URL. Returns
   * {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return url.matches(REGEX);
  }

  static ZoneId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid zone URL");
    }
    return ZoneId.of(matcher.group(1), matcher.group(2));
  }
}
