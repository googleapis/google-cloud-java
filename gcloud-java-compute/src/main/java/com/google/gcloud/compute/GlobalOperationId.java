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
 * Identity for a Google Compute Engine global operation.
 */
public class GlobalOperationId extends ResourceId implements OperationId {

  private static final String REGEX = ResourceId.REGEX + "global/operations/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 3945756772641577962L;

  private final String operation;

  private GlobalOperationId(String project, String operation) {
    super(project);
    this.operation = checkNotNull(operation);
  }

  @Override
  public Type type() {
    return Type.GLOBAL;
  }

  @Override
  public String operation() {
    return operation;
  }

  @Override
  public String selfLink() {
    return super.selfLink() + "/global/operations/" + operation;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("operation", operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), operation);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof GlobalOperationId
        && baseEquals((GlobalOperationId) obj)
        && Objects.equals(operation, ((GlobalOperationId) obj).operation);
  }

  @Override
  GlobalOperationId setProjectId(String projectId) {
    if (project() != null) {
      return this;
    }
    return GlobalOperationId.of(projectId, operation);
  }

  /**
   * Returns a global operation identity given the operation name.
   */
  public static GlobalOperationId of(String operation) {
    return new GlobalOperationId(null, operation);
  }

  /**
   * Returns a global operation identity given project and operation names.
   */
  public static GlobalOperationId of(String project, String operation) {
    return new GlobalOperationId(project, operation);
  }

  /**
   * Returns {@code true} if the provided string matches the expected format of a global operation
   * URL. Returns {@code false} otherwise.
   */
  static boolean matchesUrl(String url) {
    return PATTERN.matcher(url).matches();
  }

  static GlobalOperationId fromUrl(String url) {
    Matcher matcher = PATTERN.matcher(url);
    if (!matcher.matches()) {
      throw new IllegalArgumentException(url + " is not a valid global operation URL");
    }
    return GlobalOperationId.of(matcher.group(1), matcher.group(2));
  }
}
