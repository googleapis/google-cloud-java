/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.spanner.admin.instance.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class InstanceConfigName implements ResourceName {
  private static final PathTemplate PROJECT_INSTANCE_CONFIG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/instanceConfigs/{instance_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instanceConfig;

  @Deprecated
  protected InstanceConfigName() {
    project = null;
    instanceConfig = null;
  }

  private InstanceConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instanceConfig = Preconditions.checkNotNull(builder.getInstanceConfig());
  }

  public String getProject() {
    return project;
  }

  public String getInstanceConfig() {
    return instanceConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InstanceConfigName of(String project, String instanceConfig) {
    return newBuilder().setProject(project).setInstanceConfig(instanceConfig).build();
  }

  public static String format(String project, String instanceConfig) {
    return newBuilder().setProject(project).setInstanceConfig(instanceConfig).build().toString();
  }

  public static InstanceConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTANCE_CONFIG.validatedMatch(
            formattedString, "InstanceConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("instance_config"));
  }

  public static List<InstanceConfigName> parseList(List<String> formattedStrings) {
    List<InstanceConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InstanceConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InstanceConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INSTANCE_CONFIG.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (instanceConfig != null) {
            fieldMapBuilder.put("instance_config", instanceConfig);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROJECT_INSTANCE_CONFIG.instantiate(
        "project", project, "instance_config", instanceConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      InstanceConfigName that = ((InstanceConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instanceConfig, that.instanceConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(instanceConfig);
    return h;
  }

  /** Builder for projects/{project}/instanceConfigs/{instance_config}. */
  public static class Builder {
    private String project;
    private String instanceConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstanceConfig() {
      return instanceConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstanceConfig(String instanceConfig) {
      this.instanceConfig = instanceConfig;
      return this;
    }

    private Builder(InstanceConfigName instanceConfigName) {
      this.project = instanceConfigName.project;
      this.instanceConfig = instanceConfigName.instanceConfig;
    }

    public InstanceConfigName build() {
      return new InstanceConfigName(this);
    }
  }
}
