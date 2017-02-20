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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Objects;

/** Returns id of a Cloud Spanner instance config. */
public final class InstanceConfigId {
  private static final PathTemplate NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instanceConfigs/{instanceconfig}");

  private final String project;
  private final String instanceConfig;

  InstanceConfigId(String project, String instanceConfig) {
    this.project = project;
    this.instanceConfig = instanceConfig;
  }

  /** Returns project of this instane config. */
  public String getProject() {
    return project;
  }

  /** Returns id of this instance config. */
  public String getInstanceConfig() {
    return instanceConfig;
  }

  /** Returns the name of the instance config. */
  public String getName() {
    return String.format("projects/%s/instanceConfigs/%s", project, instanceConfig);
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, instanceConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstanceConfigId that = (InstanceConfigId) o;
    return that.project.equals(project) && that.instanceConfig.equals(instanceConfig);
  }

  @Override
  public String toString() {
    return getName();
  }

  /**
   * Creates an {@code InstanceConfigId} from the name of the instance config.
   *
   * @param name the instance config name of the form {@code
   *     projects/PROJECT_ID/instanceConfigs/INSTANCE_CONFIG_ID}
   * @throws IllegalArgumentException if {@code instanceName} does not conform to the expected
   * pattern.
   */
  static InstanceConfigId of(String name) {
    ImmutableMap<String, String> parts = NAME_TEMPLATE.match(name);
    Preconditions.checkArgument(
        parts != null, "Name should confirm to pattern %s: %s", NAME_TEMPLATE, name);
    return new InstanceConfigId(parts.get("project"), parts.get("instanceconfig"));
  }

  /**
   * Creates an {@code InstanceConfigId} given project and instance config IDs.
   */
  public static InstanceConfigId of(String project, String instanceConfig) {
    return new InstanceConfigId(project, instanceConfig);
  }
}
