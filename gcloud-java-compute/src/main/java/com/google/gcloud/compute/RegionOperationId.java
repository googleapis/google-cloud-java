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

import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Identity for a Google Compute Engine region's operation.
 */
public final class RegionOperationId extends RegionResourceId implements OperationId {

  private static final String REGEX = RegionResourceId.REGEX + "operations/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 5816161906501886782L;

  private final String operation;

  private RegionOperationId(String project, String region, String operation) {
    super(project, region);
    this.operation = checkNotNull(operation);
  }

  @Override
  public Type type() {
    return Type.REGION;
  }

  @Override
  public String operation() {
    return operation;
  }

  @Override
  public String selfLink() {
    return super.selfLink() + "/operations/" + operation;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("operation", operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), operation);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof RegionOperationId
        && baseEquals((RegionOperationId) obj)
        && Objects.equals(operation, ((RegionOperationId) obj).operation);
  }

  @Override
  RegionOperationId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return RegionOperationId.of(projectId, region(), operation);
  }

  /**
   * Returns a region operation identity given the region identity and the operation name.
   */
  public static RegionOperationId of(RegionId regionId, String operation) {
    return new RegionOperationId(regionId.project(), regionId.region(), operation);
  }

  /**
   * Returns a region operation identity given the region and operation names.
   */
  public static RegionOperationId of(String region, String operation) {
    return new RegionOperationId(null, region, operation);
  }

  /**
   * Returns a region operation identity given project, region and operation names.
   */
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
