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
public class WorkloadIdentityPoolProviderName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL_WORKLOAD_IDENTITY_POOL_PROVIDER =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/workloadIdentityPools/{workload_identity_pool}/providers/{workload_identity_pool_provider}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workloadIdentityPool;
  private final String workloadIdentityPoolProvider;

  @Deprecated
  protected WorkloadIdentityPoolProviderName() {
    project = null;
    location = null;
    workloadIdentityPool = null;
    workloadIdentityPoolProvider = null;
  }

  private WorkloadIdentityPoolProviderName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workloadIdentityPool = Preconditions.checkNotNull(builder.getWorkloadIdentityPool());
    workloadIdentityPoolProvider =
        Preconditions.checkNotNull(builder.getWorkloadIdentityPoolProvider());
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

  public String getWorkloadIdentityPoolProvider() {
    return workloadIdentityPoolProvider;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkloadIdentityPoolProviderName of(
      String project,
      String location,
      String workloadIdentityPool,
      String workloadIdentityPoolProvider) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkloadIdentityPool(workloadIdentityPool)
        .setWorkloadIdentityPoolProvider(workloadIdentityPoolProvider)
        .build();
  }

  public static String format(
      String project,
      String location,
      String workloadIdentityPool,
      String workloadIdentityPoolProvider) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkloadIdentityPool(workloadIdentityPool)
        .setWorkloadIdentityPoolProvider(workloadIdentityPoolProvider)
        .build()
        .toString();
  }

  public static WorkloadIdentityPoolProviderName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL_WORKLOAD_IDENTITY_POOL_PROVIDER.validatedMatch(
            formattedString,
            "WorkloadIdentityPoolProviderName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("workload_identity_pool"),
        matchMap.get("workload_identity_pool_provider"));
  }

  public static List<WorkloadIdentityPoolProviderName> parseList(List<String> formattedStrings) {
    List<WorkloadIdentityPoolProviderName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkloadIdentityPoolProviderName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkloadIdentityPoolProviderName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL_WORKLOAD_IDENTITY_POOL_PROVIDER.matches(
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
          if (workloadIdentityPool != null) {
            fieldMapBuilder.put("workload_identity_pool", workloadIdentityPool);
          }
          if (workloadIdentityPoolProvider != null) {
            fieldMapBuilder.put("workload_identity_pool_provider", workloadIdentityPoolProvider);
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
    return PROJECT_LOCATION_WORKLOAD_IDENTITY_POOL_WORKLOAD_IDENTITY_POOL_PROVIDER.instantiate(
        "project",
        project,
        "location",
        location,
        "workload_identity_pool",
        workloadIdentityPool,
        "workload_identity_pool_provider",
        workloadIdentityPoolProvider);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WorkloadIdentityPoolProviderName that = ((WorkloadIdentityPoolProviderName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workloadIdentityPool, that.workloadIdentityPool)
          && Objects.equals(this.workloadIdentityPoolProvider, that.workloadIdentityPoolProvider);
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
    h *= 1000003;
    h ^= Objects.hashCode(workloadIdentityPoolProvider);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/workloadIdentityPools/{workload_identity_pool}/providers/{workload_identity_pool_provider}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String workloadIdentityPool;
    private String workloadIdentityPoolProvider;

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

    public String getWorkloadIdentityPoolProvider() {
      return workloadIdentityPoolProvider;
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

    public Builder setWorkloadIdentityPoolProvider(String workloadIdentityPoolProvider) {
      this.workloadIdentityPoolProvider = workloadIdentityPoolProvider;
      return this;
    }

    private Builder(WorkloadIdentityPoolProviderName workloadIdentityPoolProviderName) {
      this.project = workloadIdentityPoolProviderName.project;
      this.location = workloadIdentityPoolProviderName.location;
      this.workloadIdentityPool = workloadIdentityPoolProviderName.workloadIdentityPool;
      this.workloadIdentityPoolProvider =
          workloadIdentityPoolProviderName.workloadIdentityPoolProvider;
    }

    public WorkloadIdentityPoolProviderName build() {
      return new WorkloadIdentityPoolProviderName(this);
    }
  }
}
