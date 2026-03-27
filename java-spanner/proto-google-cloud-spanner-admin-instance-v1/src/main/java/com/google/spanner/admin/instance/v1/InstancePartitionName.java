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
public class InstancePartitionName implements ResourceName {
  private static final PathTemplate PROJECT_INSTANCE_INSTANCE_PARTITION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/instances/{instance}/instancePartitions/{instance_partition}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instance;
  private final String instancePartition;

  @Deprecated
  protected InstancePartitionName() {
    project = null;
    instance = null;
    instancePartition = null;
  }

  private InstancePartitionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    instancePartition = Preconditions.checkNotNull(builder.getInstancePartition());
  }

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getInstancePartition() {
    return instancePartition;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InstancePartitionName of(
      String project, String instance, String instancePartition) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setInstancePartition(instancePartition)
        .build();
  }

  public static String format(String project, String instance, String instancePartition) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setInstancePartition(instancePartition)
        .build()
        .toString();
  }

  public static InstancePartitionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTANCE_INSTANCE_PARTITION.validatedMatch(
            formattedString, "InstancePartitionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("instance"), matchMap.get("instance_partition"));
  }

  public static List<InstancePartitionName> parseList(List<String> formattedStrings) {
    List<InstancePartitionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InstancePartitionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InstancePartitionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INSTANCE_INSTANCE_PARTITION.matches(formattedString);
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
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (instancePartition != null) {
            fieldMapBuilder.put("instance_partition", instancePartition);
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
    return PROJECT_INSTANCE_INSTANCE_PARTITION.instantiate(
        "project", project, "instance", instance, "instance_partition", instancePartition);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      InstancePartitionName that = ((InstancePartitionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.instancePartition, that.instancePartition);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(instancePartition);
    return h;
  }

  /**
   * Builder for projects/{project}/instances/{instance}/instancePartitions/{instance_partition}.
   */
  public static class Builder {
    private String project;
    private String instance;
    private String instancePartition;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getInstancePartition() {
      return instancePartition;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setInstancePartition(String instancePartition) {
      this.instancePartition = instancePartition;
      return this;
    }

    private Builder(InstancePartitionName instancePartitionName) {
      this.project = instancePartitionName.project;
      this.instance = instancePartitionName.instance;
      this.instancePartition = instancePartitionName.instancePartition;
    }

    public InstancePartitionName build() {
      return new InstancePartitionName(this);
    }
  }
}
