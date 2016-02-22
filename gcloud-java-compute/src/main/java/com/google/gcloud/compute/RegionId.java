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
 * A Google Compute Engine region identity.
 */
public final class RegionId extends ResourceId {

  private static final long serialVersionUID = 5569092266957249294L;

  private final String region;

  private RegionId(String project, String region) {
    super(project);
    this.region = checkNotNull(region);
  }

  private RegionId(RegionId regionId) {
    super(regionId.project());
    this.region = checkNotNull(regionId.region());
  }

  /**
   * Returns the name of the region.
   */
  public final String region() {
    return region;
  }

  @Override
  public String toUrl() {
    return super.toUrl() + "/regions/" + region;
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
    return obj instanceof RegionId && baseEquals((RegionId) obj);
  }

  @Override
  RegionId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return RegionId.of(projectId, region);
  }

  /**
   * Returns a new region identity given project and region names.
   */
  public static RegionId of(String project, String region) {
    return new RegionId(project, region);
  }

  /**
   * Returns a new region identity given region name.
   */
  public static RegionId of(String region) {
    return RegionId.of(null, region);
  }

  /**
   * Returns a new region identity given a region URL.
   */
  static RegionId fromUrl(String url) {
    int projectsIndex = url.indexOf("/projects/");
    int regionsIndex = url.indexOf("/regions/");
    String project = url.substring(projectsIndex + 10, regionsIndex);
    String region = url.substring(regionsIndex + 9, url.length());
    return RegionId.of(project, region);
  }
}
