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
public class WorkstationClusterName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_WORKSTATION_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/workstationClusters/{workstation_cluster}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workstationCluster;

  @Deprecated
  protected WorkstationClusterName() {
    project = null;
    location = null;
    workstationCluster = null;
  }

  private WorkstationClusterName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workstationCluster = Preconditions.checkNotNull(builder.getWorkstationCluster());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkstationClusterName of(
      String project, String location, String workstationCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkstationCluster(workstationCluster)
        .build();
  }

  public static String format(String project, String location, String workstationCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkstationCluster(workstationCluster)
        .build()
        .toString();
  }

  public static WorkstationClusterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKSTATION_CLUSTER.validatedMatch(
            formattedString, "WorkstationClusterName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("workstation_cluster"));
  }

  public static List<WorkstationClusterName> parseList(List<String> formattedStrings) {
    List<WorkstationClusterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkstationClusterName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkstationClusterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKSTATION_CLUSTER.matches(formattedString);
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
    return PROJECT_LOCATION_WORKSTATION_CLUSTER.instantiate(
        "project", project, "location", location, "workstation_cluster", workstationCluster);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WorkstationClusterName that = ((WorkstationClusterName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workstationCluster, that.workstationCluster);
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
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/workstationClusters/{workstation_cluster}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String workstationCluster;

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

    private Builder(WorkstationClusterName workstationClusterName) {
      this.project = workstationClusterName.project;
      this.location = workstationClusterName.location;
      this.workstationCluster = workstationClusterName.workstationCluster;
    }

    public WorkstationClusterName build() {
      return new WorkstationClusterName(this);
    }
  }
}
