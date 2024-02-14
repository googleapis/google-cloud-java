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

package com.google.cloud.orchestration.airflow.service.v1beta1;

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
public class UserWorkloadsConfigMapName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_CONFIG_MAP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/environments/{environment}/userWorkloadsConfigMaps/{user_workloads_config_map}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String environment;
  private final String userWorkloadsConfigMap;

  @Deprecated
  protected UserWorkloadsConfigMapName() {
    project = null;
    location = null;
    environment = null;
    userWorkloadsConfigMap = null;
  }

  private UserWorkloadsConfigMapName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    userWorkloadsConfigMap = Preconditions.checkNotNull(builder.getUserWorkloadsConfigMap());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getEnvironment() {
    return environment;
  }

  public String getUserWorkloadsConfigMap() {
    return userWorkloadsConfigMap;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserWorkloadsConfigMapName of(
      String project, String location, String environment, String userWorkloadsConfigMap) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .setUserWorkloadsConfigMap(userWorkloadsConfigMap)
        .build();
  }

  public static String format(
      String project, String location, String environment, String userWorkloadsConfigMap) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .setUserWorkloadsConfigMap(userWorkloadsConfigMap)
        .build()
        .toString();
  }

  public static UserWorkloadsConfigMapName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_CONFIG_MAP.validatedMatch(
            formattedString,
            "UserWorkloadsConfigMapName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("environment"),
        matchMap.get("user_workloads_config_map"));
  }

  public static List<UserWorkloadsConfigMapName> parseList(List<String> formattedStrings) {
    List<UserWorkloadsConfigMapName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UserWorkloadsConfigMapName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserWorkloadsConfigMapName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_CONFIG_MAP.matches(formattedString);
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
          if (environment != null) {
            fieldMapBuilder.put("environment", environment);
          }
          if (userWorkloadsConfigMap != null) {
            fieldMapBuilder.put("user_workloads_config_map", userWorkloadsConfigMap);
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
    return PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_CONFIG_MAP.instantiate(
        "project",
        project,
        "location",
        location,
        "environment",
        environment,
        "user_workloads_config_map",
        userWorkloadsConfigMap);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserWorkloadsConfigMapName that = ((UserWorkloadsConfigMapName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.environment, that.environment)
          && Objects.equals(this.userWorkloadsConfigMap, that.userWorkloadsConfigMap);
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
    h ^= Objects.hashCode(environment);
    h *= 1000003;
    h ^= Objects.hashCode(userWorkloadsConfigMap);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/environments/{environment}/userWorkloadsConfigMaps/{user_workloads_config_map}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String environment;
    private String userWorkloadsConfigMap;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEnvironment() {
      return environment;
    }

    public String getUserWorkloadsConfigMap() {
      return userWorkloadsConfigMap;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public Builder setUserWorkloadsConfigMap(String userWorkloadsConfigMap) {
      this.userWorkloadsConfigMap = userWorkloadsConfigMap;
      return this;
    }

    private Builder(UserWorkloadsConfigMapName userWorkloadsConfigMapName) {
      this.project = userWorkloadsConfigMapName.project;
      this.location = userWorkloadsConfigMapName.location;
      this.environment = userWorkloadsConfigMapName.environment;
      this.userWorkloadsConfigMap = userWorkloadsConfigMapName.userWorkloadsConfigMap;
    }

    public UserWorkloadsConfigMapName build() {
      return new UserWorkloadsConfigMapName(this);
    }
  }
}
