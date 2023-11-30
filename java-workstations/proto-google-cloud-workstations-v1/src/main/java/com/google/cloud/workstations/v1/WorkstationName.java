/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.workstations.v1;

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
public class WorkstationName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG_WORKSTATION =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/workstationClusters/{workstation_cluster}/workstationConfigs/{workstation_config}/workstations/{workstation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workstationCluster;
  private final String workstationConfig;
  private final String workstation;

  @Deprecated
  protected WorkstationName() {
    project = null;
    location = null;
    workstationCluster = null;
    workstationConfig = null;
    workstation = null;
  }

  private WorkstationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workstationCluster = Preconditions.checkNotNull(builder.getWorkstationCluster());
    workstationConfig = Preconditions.checkNotNull(builder.getWorkstationConfig());
    workstation = Preconditions.checkNotNull(builder.getWorkstation());
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

  public String getWorkstation() {
    return workstation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkstationName of(
      String project,
      String location,
      String workstationCluster,
      String workstationConfig,
      String workstation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkstationCluster(workstationCluster)
        .setWorkstationConfig(workstationConfig)
        .setWorkstation(workstation)
        .build();
  }

  public static String format(
      String project,
      String location,
      String workstationCluster,
      String workstationConfig,
      String workstation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkstationCluster(workstationCluster)
        .setWorkstationConfig(workstationConfig)
        .setWorkstation(workstation)
        .build()
        .toString();
  }

  public static WorkstationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG_WORKSTATION.validatedMatch(
            formattedString, "WorkstationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("workstation_cluster"),
        matchMap.get("workstation_config"),
        matchMap.get("workstation"));
  }

  public static List<WorkstationName> parseList(List<String> formattedStrings) {
    List<WorkstationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkstationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkstationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG_WORKSTATION.matches(
        formattedString);
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
          if (workstation != null) {
            fieldMapBuilder.put("workstation", workstation);
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
    return PROJECT_LOCATION_WORKSTATION_CLUSTER_WORKSTATION_CONFIG_WORKSTATION.instantiate(
        "project",
        project,
        "location",
        location,
        "workstation_cluster",
        workstationCluster,
        "workstation_config",
        workstationConfig,
        "workstation",
        workstation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WorkstationName that = ((WorkstationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workstationCluster, that.workstationCluster)
          && Objects.equals(this.workstationConfig, that.workstationConfig)
          && Objects.equals(this.workstation, that.workstation);
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
    h *= 1000003;
    h ^= Objects.hashCode(workstation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/workstationClusters/{workstation_cluster}/workstationConfigs/{workstation_config}/workstations/{workstation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String workstationCluster;
    private String workstationConfig;
    private String workstation;

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

    public String getWorkstation() {
      return workstation;
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

    public Builder setWorkstation(String workstation) {
      this.workstation = workstation;
      return this;
    }

    private Builder(WorkstationName workstationName) {
      this.project = workstationName.project;
      this.location = workstationName.location;
      this.workstationCluster = workstationName.workstationCluster;
      this.workstationConfig = workstationName.workstationConfig;
      this.workstation = workstationName.workstation;
    }

    public WorkstationName build() {
      return new WorkstationName(this);
    }
  }
}
