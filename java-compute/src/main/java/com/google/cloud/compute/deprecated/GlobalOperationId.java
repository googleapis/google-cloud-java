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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Identity for a Google Compute Engine global operation. */
public final class GlobalOperationId extends OperationId {

  private static final String REGEX = ResourceId.REGEX + "global/operations/([^/]+)";
  private static final Pattern PATTERN = Pattern.compile(REGEX);
  private static final long serialVersionUID = 3945756772641577962L;

  private GlobalOperationId(String project, String operation) {
    super(project, operation);
  }

  @Override
  public Type getType() {
    return Type.GLOBAL;
  }

  @Override
  public String getSelfLink() {
    return super.getSelfLink() + "/global/operations/" + getOperation();
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof GlobalOperationId && baseEquals((GlobalOperationId) obj);
  }

  @Override
  GlobalOperationId setProjectId(String projectId) {
    if (getProject() != null) {
      return this;
    }
    return GlobalOperationId.of(projectId, getOperation());
  }

  /** Returns a global operation identity given the operation name. */
  public static GlobalOperationId of(String operation) {
    return new GlobalOperationId(null, operation);
  }

  /** Returns a global operation identity given project and operation names. */
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
