/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.workstations.v1beta;

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
public class WorkstationConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/workstationClusters/{workstation_cluster}/workstationConfigs/{workstation_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workstationCluster;
  private final String workstationConfig;

  @Deprecated
  protected WorkstationConfigName() {
    project = null;
    location = null;
    workstationCluster = null;
    workstationConfig = null;
  }

  private WorkstationConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workstationCluster = Preconditions.checkNotNull(builder.getWorkstationCluster());
    workstationConfig = Preconditions.checkNotNull(builder.getWorkstationConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getWorkstationCluster() {
    return workstationCluster;
  }

  public String getWorkstationConfig() {
    return workstationConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkstationConfigName of(
      String project, String location, String workstationCluster, String workstationConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkstationCluster(workstationCluster)
        .setWorkstationConfig(workstationConfig)
        .build();
  }

  public static String format(
      String project, String location, String workstationCluster, String workstationConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkstationCluster(workstationCluster)
        .setWorkstationConfig(workstationConfig)
        .build()
        .toString();
  }

  public static WorkstationConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG.validatedMatch(
            formattedString, "WorkstationConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("workstation_cluster"),
        matchMap.get("workstation_config"));
  }

  public static List<WorkstationConfigName> parseList(List<String> formattedStrings) {
    List<WorkstationConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkstationConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkstationConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (workstationCluster != null) {
            fieldMapBuilder.put("workstation_cluster", workstationCluster);
          }
          if (workstationConfig != null) {
            fieldMapBuilder.put("workstation_config", workstationConfig);
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
    return PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG.instantiate(
        "project",
        project,
        "location",
        location,
        "workstation_cluster",
        workstationCluster,
        "workstation_config",
        workstationConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WorkstationConfigName that = ((WorkstationConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workstationCluster, that.workstationCluster)
          && Objects.equals(this.workstationConfig, that.workstationConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(workstationCluster);
    h *= 1000003;
    h ^= Objects.hashCode(workstationConfig);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/workstationClusters/{workstation_cluster}/workstationConfigs/{workstation_config}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String workstationCluster;
    private String workstationConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getWorkstationCluster() {
      return workstationCluster;
    }

    public String getWorkstationConfig() {
      return workstationConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setWorkstationCluster(String workstationCluster) {
      this.workstationCluster = workstationCluster;
      return this;
    }

    public Builder setWorkstationConfig(String workstationConfig) {
      this.workstationConfig = workstationConfig;
      return this;
    }

    private Builder(WorkstationConfigName workstationConfigName) {
      this.project = workstationConfigName.project;
      this.location = workstationConfigName.location;
      this.workstationCluster = workstationConfigName.workstationCluster;
      this.workstationConfig = workstationConfigName.workstationConfig;
    }

    public WorkstationConfigName build() {
      return new WorkstationConfigName(this);
    }
  }
}
