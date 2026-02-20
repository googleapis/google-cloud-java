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

package com.google.cloud.developerconnect.v1;

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
public class DeploymentEventName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSIGHTS_CONFIG_DEPLOYMENT_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/insightsConfigs/{insights_config}/deploymentEvents/{deployment_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String insightsConfig;
  private final String deploymentEvent;

  @Deprecated
  protected DeploymentEventName() {
    project = null;
    location = null;
    insightsConfig = null;
    deploymentEvent = null;
  }

  private DeploymentEventName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightsConfig = Preconditions.checkNotNull(builder.getInsightsConfig());
    deploymentEvent = Preconditions.checkNotNull(builder.getDeploymentEvent());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInsightsConfig() {
    return insightsConfig;
  }

  public String getDeploymentEvent() {
    return deploymentEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeploymentEventName of(
      String project, String location, String insightsConfig, String deploymentEvent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightsConfig(insightsConfig)
        .setDeploymentEvent(deploymentEvent)
        .build();
  }

  public static String format(
      String project, String location, String insightsConfig, String deploymentEvent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightsConfig(insightsConfig)
        .setDeploymentEvent(deploymentEvent)
        .build()
        .toString();
  }

  public static DeploymentEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSIGHTS_CONFIG_DEPLOYMENT_EVENT.validatedMatch(
            formattedString, "DeploymentEventName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("insights_config"),
        matchMap.get("deployment_event"));
  }

  public static List<DeploymentEventName> parseList(List<String> formattedStrings) {
    List<DeploymentEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeploymentEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeploymentEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSIGHTS_CONFIG_DEPLOYMENT_EVENT.matches(formattedString);
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
          if (insightsConfig != null) {
            fieldMapBuilder.put("insights_config", insightsConfig);
          }
          if (deploymentEvent != null) {
            fieldMapBuilder.put("deployment_event", deploymentEvent);
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
    return PROJECT_LOCATION_INSIGHTS_CONFIG_DEPLOYMENT_EVENT.instantiate(
        "project",
        project,
        "location",
        location,
        "insights_config",
        insightsConfig,
        "deployment_event",
        deploymentEvent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DeploymentEventName that = ((DeploymentEventName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.insightsConfig, that.insightsConfig)
          && Objects.equals(this.deploymentEvent, that.deploymentEvent);
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
    h ^= Objects.hashCode(insightsConfig);
    h *= 1000003;
    h ^= Objects.hashCode(deploymentEvent);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/insightsConfigs/{insights_config}/deploymentEvents/{deployment_event}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String insightsConfig;
    private String deploymentEvent;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightsConfig() {
      return insightsConfig;
    }

    public String getDeploymentEvent() {
      return deploymentEvent;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInsightsConfig(String insightsConfig) {
      this.insightsConfig = insightsConfig;
      return this;
    }

    public Builder setDeploymentEvent(String deploymentEvent) {
      this.deploymentEvent = deploymentEvent;
      return this;
    }

    private Builder(DeploymentEventName deploymentEventName) {
      this.project = deploymentEventName.project;
      this.location = deploymentEventName.location;
      this.insightsConfig = deploymentEventName.insightsConfig;
      this.deploymentEvent = deploymentEventName.deploymentEvent;
    }

    public DeploymentEventName build() {
      return new DeploymentEventName(this);
    }
  }
}
