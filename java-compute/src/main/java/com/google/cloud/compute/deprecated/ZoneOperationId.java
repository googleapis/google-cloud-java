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

/** Identity for a Google Compute Engine zone operation. */
public final class ZoneOperationId extends OperationId {

  private static final String REGEX = ResourceId.REGEX + "zones/([^/]+)/operations/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 4910670262094017392L;

  private final String zone;

  private ZoneOperationId(String project, String zone, String operation) {
    super(project, operation);
    this.zone = checkNotNull(zone);
  }

  @Override
  public Type getType() {
    return Type.ZONE;
  }

  /** Returns the name of the zone this operation belongs to. */
  public String getZone() {
    return zone;
  }

  /** Returns the identity of the zone this address belongs to. */
  public ZoneId getZoneId() {
    return ZoneId.of(getProject(), zone);
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/zones/" + zone + "/operations/" + getOperation();
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("zone", zone);
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
    if (!(obj instanceof ZoneOperationId)) {
      return false;
    }
    ZoneOperationId other = (ZoneOperationId) obj;
    return baseEquals(other) && Objects.equals(zone, other.zone);
  }

  @Override
  ZoneOperationId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return ZoneOperationId.of(projectId, zone, getOperation());
  }

  /** Returns a zone operation identity given the zone identity and the operation name. */
  public static ZoneOperationId of(ZoneId zoneId, String operation) {
    return new ZoneOperationId(zoneId.getProject(), zoneId.getZone(), operation);
  }

  /** Returns a zone operation identity given the zone and operation names. */
  public static ZoneOperationId of(String zone, String operation) {
    return new ZoneOperationId(null, zone, operation);
  }

  /** Returns a zone operation identity given project, zone and operation names. */
  public static ZoneOperationId of(String project, String zone, String operation) {
    return new ZoneOperationId(project, zone, operation);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a zone operation
   * URL. Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static ZoneOperationId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid zone operation URL");
    }
    return ZoneOperationId.of(matcher.group(1), matcher.group(2), matcher.group(3));
  }
}
