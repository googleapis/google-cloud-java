/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.oracledatabase.v1;

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
public class ExadbVmClusterName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_EXADB_VM_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String exadbVmCluster;

  @Deprecated
  protected ExadbVmClusterName() {
    project = null;
    location = null;
    exadbVmCluster = null;
  }

  private ExadbVmClusterName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    exadbVmCluster = Preconditions.checkNotNull(builder.getExadbVmCluster());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getExadbVmCluster() {
    return exadbVmCluster;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExadbVmClusterName of(String project, String location, String exadbVmCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExadbVmCluster(exadbVmCluster)
        .build();
  }

  public static String format(String project, String location, String exadbVmCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExadbVmCluster(exadbVmCluster)
        .build()
        .toString();
  }

  public static ExadbVmClusterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_EXADB_VM_CLUSTER.validatedMatch(
            formattedString, "ExadbVmClusterName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("exadb_vm_cluster"));
  }

  public static List<ExadbVmClusterName> parseList(List<String> formattedStrings) {
    List<ExadbVmClusterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ExadbVmClusterName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExadbVmClusterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_EXADB_VM_CLUSTER.matches(formattedString);
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
          if (exadbVmCluster != null) {
            fieldMapBuilder.put("exadb_vm_cluster", exadbVmCluster);
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
    return PROJECT_LOCATION_EXADB_VM_CLUSTER.instantiate(
        "project", project, "location", location, "exadb_vm_cluster", exadbVmCluster);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExadbVmClusterName that = ((ExadbVmClusterName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.exadbVmCluster, that.exadbVmCluster);
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
    h ^= Objects.hashCode(exadbVmCluster);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/exadbVmClusters/{exadb_vm_cluster}. */
  public static class Builder {
    private String project;
    private String location;
    private String exadbVmCluster;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getExadbVmCluster() {
      return exadbVmCluster;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setExadbVmCluster(String exadbVmCluster) {
      this.exadbVmCluster = exadbVmCluster;
      return this;
    }

    private Builder(ExadbVmClusterName exadbVmClusterName) {
      this.project = exadbVmClusterName.project;
      this.location = exadbVmClusterName.location;
      this.exadbVmCluster = exadbVmClusterName.exadbVmCluster;
    }

    public ExadbVmClusterName build() {
      return new ExadbVmClusterName(this);
    }
  }
}
