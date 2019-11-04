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

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

/** Base class for Google Compute Engine resource identities. */
public abstract class ResourceId implements Serializable {

  static final String REGEX = ".*?projects/([^/]+)/";
  private static final String BASE_URL = "https://www.googleapis.com/compute/v1/projects/";
  private static final long serialVersionUID = -8028734746870421573L;

  private final String project;

  ResourceId(String project) {
    this.project = project;
  }

  /** Returns a fully qualified URL to the entity. */
  public String getSelfLink() {
    return BASE_URL + project;
  }

  /** Returns the name of the project. */
  public final String getProject() {
    return project;
  }

  MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this).add("project", project);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  int baseHashCode() {
    return Objects.hash(project);
  }

  boolean baseEquals(ResourceId resourceId) {
    return Objects.equals(project, resourceId.project);
  }

  abstract ResourceId setProjectId(String projectId);
}
