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

package com.google.cloud.telcoautomation.v1alpha1;

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
public class HydratedDeploymentName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_ORCHESTRATION_CLUSTER_DEPLOYMENT_HYDRATED_DEPLOYMENT =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/orchestrationClusters/{orchestration_cluster}/deployments/{deployment}/hydratedDeployments/{hydrated_deployment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String orchestrationCluster;
  private final String deployment;
  private final String hydratedDeployment;

  @Deprecated
  protected HydratedDeploymentName() {
    project = null;
    location = null;
    orchestrationCluster = null;
    deployment = null;
    hydratedDeployment = null;
  }

  private HydratedDeploymentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    orchestrationCluster = Preconditions.checkNotNull(builder.getOrchestrationCluster());
    deployment = Preconditions.checkNotNull(builder.getDeployment());
    hydratedDeployment = Preconditions.checkNotNull(builder.getHydratedDeployment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getOrchestrationCluster() {
    return orchestrationCluster;
  }

  public String getDeployment() {
    return deployment;
  }

  public String getHydratedDeployment() {
    return hydratedDeployment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HydratedDeploymentName of(
      String project,
      String location,
      String orchestrationCluster,
      String deployment,
      String hydratedDeployment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOrchestrationCluster(orchestrationCluster)
        .setDeployment(deployment)
        .setHydratedDeployment(hydratedDeployment)
        .build();
  }

  public static String format(
      String project,
      String location,
      String orchestrationCluster,
      String deployment,
      String hydratedDeployment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOrchestrationCluster(orchestrationCluster)
        .setDeployment(deployment)
        .setHydratedDeployment(hydratedDeployment)
        .build()
        .toString();
  }

  public static HydratedDeploymentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ORCHESTRATION_CLUSTER_DEPLOYMENT_HYDRATED_DEPLOYMENT.validatedMatch(
            formattedString, "HydratedDeploymentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("orchestration_cluster"),
        matchMap.get("deployment"),
        matchMap.get("hydrated_deployment"));
  }

  public static List<HydratedDeploymentName> parseList(List<String> formattedStrings) {
    List<HydratedDeploymentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HydratedDeploymentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HydratedDeploymentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ORCHESTRATION_CLUSTER_DEPLOYMENT_HYDRATED_DEPLOYMENT.matches(
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
          if (orchestrationCluster != null) {
            fieldMapBuilder.put("orchestration_cluster", orchestrationCluster);
          }
          if (deployment != null) {
            fieldMapBuilder.put("deployment", deployment);
          }
          if (hydratedDeployment != null) {
            fieldMapBuilder.put("hydrated_deployment", hydratedDeployment);
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
    return PROJECT_LOCATION_ORCHESTRATION_CLUSTER_DEPLOYMENT_HYDRATED_DEPLOYMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "orchestration_cluster",
        orchestrationCluster,
        "deployment",
        deployment,
        "hydrated_deployment",
        hydratedDeployment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      HydratedDeploymentName that = ((HydratedDeploymentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.orchestrationCluster, that.orchestrationCluster)
          && Objects.equals(this.deployment, that.deployment)
          && Objects.equals(this.hydratedDeployment, that.hydratedDeployment);
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
    h ^= Objects.hashCode(orchestrationCluster);
    h *= 1000003;
    h ^= Objects.hashCode(deployment);
    h *= 1000003;
    h ^= Objects.hashCode(hydratedDeployment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/orchestrationClusters/{orchestration_cluster}/deployments/{deployment}/hydratedDeployments/{hydrated_deployment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String orchestrationCluster;
    private String deployment;
    private String hydratedDeployment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getOrchestrationCluster() {
      return orchestrationCluster;
    }

    public String getDeployment() {
      return deployment;
    }

    public String getHydratedDeployment() {
      return hydratedDeployment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOrchestrationCluster(String orchestrationCluster) {
      this.orchestrationCluster = orchestrationCluster;
      return this;
    }

    public Builder setDeployment(String deployment) {
      this.deployment = deployment;
      return this;
    }

    public Builder setHydratedDeployment(String hydratedDeployment) {
      this.hydratedDeployment = hydratedDeployment;
      return this;
    }

    private Builder(HydratedDeploymentName hydratedDeploymentName) {
      this.project = hydratedDeploymentName.project;
      this.location = hydratedDeploymentName.location;
      this.orchestrationCluster = hydratedDeploymentName.orchestrationCluster;
      this.deployment = hydratedDeploymentName.deployment;
      this.hydratedDeployment = hydratedDeploymentName.hydratedDeployment;
    }

    public HydratedDeploymentName build() {
      return new HydratedDeploymentName(this);
    }
  }
}
