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

package com.google.iam.v1beta;

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
public class WorkloadIdentityPoolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/workloadIdentityPools/{workload_identity_pool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workloadIdentityPool;

  @Deprecated
  protected WorkloadIdentityPoolName() {
    project = null;
    location = null;
    workloadIdentityPool = null;
  }

  private WorkloadIdentityPoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workloadIdentityPool = Preconditions.checkNotNull(builder.getWorkloadIdentityPool());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getWorkloadIdentityPool() {
    return workloadIdentityPool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkloadIdentityPoolName of(
      String project, String location, String workloadIdentityPool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkloadIdentityPool(workloadIdentityPool)
        .build();
  }

  public static String format(String project, String location, String workloadIdentityPool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkloadIdentityPool(workloadIdentityPool)
        .build()
        .toString();
  }

  public static WorkloadIdentityPoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL.validatedMatch(
            formattedString, "WorkloadIdentityPoolName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("workload_identity_pool"));
  }

  public static List<WorkloadIdentityPoolName> parseList(List<String> formattedStrings) {
    List<WorkloadIdentityPoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkloadIdentityPoolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkloadIdentityPoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL.matches(formattedString);
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
          if (workloadIdentityPool != null) {
            fieldMapBuilder.put("workload_identity_pool", workloadIdentityPool);
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
    return PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL.instantiate(
        "project", project, "location", location, "workload_identity_pool", workloadIdentityPool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WorkloadIdentityPoolName that = ((WorkloadIdentityPoolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workloadIdentityPool, that.workloadIdentityPool);
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
    h ^= Objects.hashCode(workloadIdentityPool);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/workloadIdentityPools/{workload_identity_pool}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String workloadIdentityPool;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getWorkloadIdentityPool() {
      return workloadIdentityPool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setWorkloadIdentityPool(String workloadIdentityPool) {
      this.workloadIdentityPool = workloadIdentityPool;
      return this;
    }

    private Builder(WorkloadIdentityPoolName workloadIdentityPoolName) {
      this.project = workloadIdentityPoolName.project;
      this.location = workloadIdentityPoolName.location;
      this.workloadIdentityPool = workloadIdentityPoolName.workloadIdentityPool;
    }

    public WorkloadIdentityPoolName build() {
      return new WorkloadIdentityPoolName(this);
    }
  }
}
