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

/** Identity for a Google Compute Engine disk. */
public final class DiskId extends ResourceId {

  private static final String REGEX = ResourceId.REGEX + "zones/([^/]+)/disks/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = -8761290740495870787L;

  private final String zone;
  private final String disk;

  private DiskId(String project, String zone, String disk) {
    super(project);
    this.zone = checkNotNull(zone);
    this.disk = checkNotNull(disk);
  }

  /** Returns the name of the zone this disk belongs to. */
  public String getZone() {
    return zone;
  }

  /** Returns the identity of the zone this disk belongs to. */
  public ZoneId getZoneId() {
    return ZoneId.of(getProject(), zone);
  }

  /**
   * Returns the name of the disk. The name must be 1-63 characters long and comply with RFC1035.
   * Specifically, the name must match the regular expression {@code [a-z]([-a-z0-9]*[a-z0-9])?}
   * which means the first character must be a lowercase letter, and all following characters must
   * be a dash, lowercase letter, or digit, except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public String getDisk() {
    return disk;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/zones/" + zone + "/disks/" + disk;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("zone", zone).add("disk", disk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.baseHashCode(), zone, disk);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof DiskId)) {
      return false;
    }
    DiskId other = (DiskId) obj;
    return baseEquals(other)
        && Objects.equals(zone, other.zone)
        && Objects.equals(disk, other.disk);
  }

  @Override
  DiskId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return DiskId.of(projectId, zone, disk);
  }

  /**
   * Returns a disk identity given the zone identity and the disk name. The disk name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static DiskId of(ZoneId zoneId, String disk) {
    return new DiskId(zoneId.getProject(), zoneId.getZone(), disk);
  }

  /**
   * Returns a disk identity given the zone and disk names. The disk name must be 1-63 characters
   * long and comply with RFC1035. Specifically, the name must match the regular expression {@code
   * [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a lowercase letter, and all
   * following characters must be a dash, lowercase letter, or digit, except the last character,
   * which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static DiskId of(String zone, String disk) {
    return new DiskId(null, zone, disk);
  }

  /**
   * Returns a disk identity given project, zone and disks names. The disk name must be 1-63
   * characters long and comply with RFC1035. Specifically, the name must match the regular
   * expression {@code [a-z]([-a-z0-9]*[a-z0-9])?} which means the first character must be a
   * lowercase letter, and all following characters must be a dash, lowercase letter, or digit,
   * except the last character, which cannot be a dash.
   *
   * @see <a href="https://www.ietf.org/rfc/rfc1035.txt">RFC1035</a>
   */
  public static DiskId of(String project, String zone, String disk) {
    return new DiskId(project, zone, disk);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a disk URL. Returns
   * {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static DiskId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid disk URL");
    }
    return DiskId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
