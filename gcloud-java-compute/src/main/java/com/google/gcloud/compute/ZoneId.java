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

import com.google.common.base.Function;
import com.google.common.base.MoreObjects.ToStringHelper;

import java.util.Objects;

/**
 * A Google Compute Engine zone identity.
 */
public final class ZoneId extends ResourceId {

  static final Function<String, ZoneId> FROM_URL_FUNCTION = new Function<String, ZoneId>() {
    @Override
    public ZoneId apply(String pb) {
      return ZoneId.fromUrl(pb);
    }
  };
  static final Function<ZoneId, String> TO_URL_FUNCTION = new Function<ZoneId, String>() {
    @Override
    public String apply(ZoneId zoneId) {
      return zoneId.toUrl();
    }
  };

  private static final long serialVersionUID = -7635391994812946733L;

  private final String zone;

  private ZoneId(String project, String zone) {
    super(project);
    this.zone = checkNotNull(zone);
  }

  /**
   * Returns the name of the zone.
   */
  public final String zone() {
    return zone;
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
    return obj instanceof ZoneId && baseEquals((ZoneId) obj);
  }

  @Override
  ZoneId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return ZoneId.of(projectId, zone);
  }

  /**
   * Returns a new zone identity given project and zone names.
   */
  public static ZoneId of(String project, String zone) {
    return new ZoneId(project, zone);
  }

  /**
   * Returns a new zone identity given zone name.
   */
  public static ZoneId of(String zone) {
    return ZoneId.of(null, zone);
  }

  /**
   * Returns a new zone identity given a zone URL.
   */
  static ZoneId fromUrl(String url) {
    int projectsIndex = url.indexOf("/projects/");
    int zonesIndex = url.indexOf("/zones/");
    String project = url.substring(projectsIndex + 10, zonesIndex);
    String zone = url.substring(zonesIndex + 7, url.length());
    return ZoneId.of(project, zone);
  }
}
