/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

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
public class DeploymentResourcePoolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DEPLOYMENT_RESOURCE_POOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String deploymentResourcePool;

  @Deprecated
  protected DeploymentResourcePoolName() {
    project = null;
    location = null;
    deploymentResourcePool = null;
  }

  private DeploymentResourcePoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    deploymentResourcePool = Preconditions.checkNotNull(builder.getDeploymentResourcePool());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDeploymentResourcePool() {
    return deploymentResourcePool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeploymentResourcePoolName of(
      String project, String location, String deploymentResourcePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeploymentResourcePool(deploymentResourcePool)
        .build();
  }

  public static String format(String project, String location, String deploymentResourcePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeploymentResourcePool(deploymentResourcePool)
        .build()
        .toString();
  }

  public static DeploymentResourcePoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DEPLOYMENT_RESOURCE_POOL.validatedMatch(
            formattedString,
            "DeploymentResourcePoolName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("deployment_resource_pool"));
  }

  public static List<DeploymentResourcePoolName> parseList(List<String> formattedStrings) {
    List<DeploymentResourcePoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeploymentResourcePoolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeploymentResourcePoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DEPLOYMENT_RESOURCE_POOL.matches(formattedString);
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
          if (deploymentResourcePool != null) {
            fieldMapBuilder.put("deployment_resource_pool", deploymentResourcePool);
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
    return PROJECT_LOCATION_DEPLOYMENT_RESOURCE_POOL.instantiate(
        "project",
        project,
        "location",
        location,
        "deployment_resource_pool",
        deploymentResourcePool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DeploymentResourcePoolName that = ((DeploymentResourcePoolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.deploymentResourcePool, that.deploymentResourcePool);
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
    h ^= Objects.hashCode(deploymentResourcePool);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/deploymentResourcePools/{deployment_resource_pool}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String deploymentResourcePool;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDeploymentResourcePool() {
      return deploymentResourcePool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDeploymentResourcePool(String deploymentResourcePool) {
      this.deploymentResourcePool = deploymentResourcePool;
      return this;
    }

    private Builder(DeploymentResourcePoolName deploymentResourcePoolName) {
      this.project = deploymentResourcePoolName.project;
      this.location = deploymentResourcePoolName.location;
      this.deploymentResourcePool = deploymentResourcePoolName.deploymentResourcePool;
    }

    public DeploymentResourcePoolName build() {
      return new DeploymentResourcePoolName(this);
    }
  }
}
