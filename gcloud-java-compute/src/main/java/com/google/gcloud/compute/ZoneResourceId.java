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

import com.google.common.base.MoreObjects.ToStringHelper;

import java.util.Objects;

/**
 * A base class for the identity of Google Compute Engine resources that live in a zone.
 */
public abstract class ZoneResourceId extends ResourceId {

  private static final long serialVersionUID = -6249546895344926888L;

  private final String zone;

  ZoneResourceId(String project, String zone) {
    super(project);
    this.zone = checkNotNull(zone);
  }

  ZoneResourceId(ZoneId zoneId) {
    super(zoneId.project());
    this.zone = checkNotNull(zoneId.zone());
  }

  /**
   * Returns the name of the zone this resource belongs to.
   */
  public final String zone() {
    return zone;
  }

  /**
   * Returns the identity of the zone this resource belongs to.
   */
  public final ZoneId zoneId() {
    return ZoneId.of(project(), zone);
  }

  @Override
  public String toUrl() {
    return super.toUrl() + "/zones/" + zone;
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
    return obj != null
        && obj.getClass().equals(ZoneResourceId.class)
        && baseEquals((RegionResourceId) obj);
  }
}
