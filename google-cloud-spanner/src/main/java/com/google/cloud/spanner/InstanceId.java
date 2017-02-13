/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.api.gax.protobuf.PathTemplate;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/** Represents the resource name of a Cloud Spanner Instance. */
public final class InstanceId {
  private static final PathTemplate NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}");

  private final String project;
  private final String instance;

  InstanceId(String project, String instance) {
    this.project = project;
    this.instance = instance;
  }

  /** Returns the instance ID. */
  public String getInstance() {
    return instance;
  }

  /** Returns the ID of the project that owns this instance. */
  public String getProject() {
    return project;
  }

  /** Returns the name of the instance. */
  public String getName() {
    return String.format("projects/%s/instances/%s", project, instance);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(project, instance);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceId that = (InstanceId) o;
    return that.project.equals(project) && that.instance.equals(instance);
  }

  @Override
  public String toString() {
    return getName();
  }

  /**
   * Creates an {@code InstanceId} from the name of the instance.
   *
   * @param name the instance name of the form {@code
   *     projects/PROJECT_ID/instances/INSTANCE_ID}
   * @throws IllegalArgumentException if {@code instanceName} does not conform to the expected
   * pattern.
   */
  static InstanceId of(String name) {
    ImmutableMap<String, String> parts = NAME_TEMPLATE.match(name);
    Preconditions.checkArgument(
        parts != null, "Name should conform to pattern %s: %s", NAME_TEMPLATE, name);
    return of(parts.get("project"), parts.get("instance"));
  }

  /**
   * Creates an {@code InstanceId} given project and instance IDs.
   */
  public static InstanceId of(String project, String instance) {
    return new InstanceId(project, instance);
  }
}
