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
 * Identity for a Google Compute Engine zone operation.
 */
public final class ZoneOperationId extends ZoneResourceId implements OperationId  {

  private static final String REGEX = ZoneResourceId.REGEX + "operations/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 4910670262094017392L;

  private final String operation;

  private ZoneOperationId(String project, String zone, String operation) {
    super(project, zone);
    this.operation = checkNotNull(operation);
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
    return obj instanceof ZoneOperationId
        && baseEquals((ZoneOperationId) obj)
        && Objects.equals(operation, ((ZoneOperationId) obj).operation);
  }

  @Override
  ZoneOperationId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return ZoneOperationId.of(projectId, zone(), operation);
  }

  /**
   * Returns a zone operation identity given the zone identity and the operation name.
   */
  public static ZoneOperationId of(ZoneId zoneId, String operation) {
    return new ZoneOperationId(zoneId.project(), zoneId.zone(), operation);
  }

  /**
   * Returns a zone operation identity given the zone and operation names.
   */
  public static ZoneOperationId of(String zone, String operation) {
    return new ZoneOperationId(null, zone, operation);
  }

  /**
   * Returns a zone operation identity given project, zone and operation names.
   */
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
