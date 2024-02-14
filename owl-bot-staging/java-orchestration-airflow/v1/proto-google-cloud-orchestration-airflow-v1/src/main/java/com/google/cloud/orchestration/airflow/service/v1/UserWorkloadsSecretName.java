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

package com.google.cloud.orchestration.airflow.service.v1;

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
public class UserWorkloadsSecretName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_SECRET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/environments/{environment}/userWorkloadsSecrets/{user_workloads_secret}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String environment;
  private final String userWorkloadsSecret;

  @Deprecated
  protected UserWorkloadsSecretName() {
    project = null;
    location = null;
    environment = null;
    userWorkloadsSecret = null;
  }

  private UserWorkloadsSecretName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    userWorkloadsSecret = Preconditions.checkNotNull(builder.getUserWorkloadsSecret());
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

  public String getUserWorkloadsSecret() {
    return userWorkloadsSecret;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserWorkloadsSecretName of(
      String project, String location, String environment, String userWorkloadsSecret) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .setUserWorkloadsSecret(userWorkloadsSecret)
        .build();
  }

  public static String format(
      String project, String location, String environment, String userWorkloadsSecret) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .setUserWorkloadsSecret(userWorkloadsSecret)
        .build()
        .toString();
  }

  public static UserWorkloadsSecretName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_SECRET.validatedMatch(
            formattedString, "UserWorkloadsSecretName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("environment"),
        matchMap.get("user_workloads_secret"));
  }

  public static List<UserWorkloadsSecretName> parseList(List<String> formattedStrings) {
    List<UserWorkloadsSecretName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UserWorkloadsSecretName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserWorkloadsSecretName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_SECRET.matches(formattedString);
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
          if (userWorkloadsSecret != null) {
            fieldMapBuilder.put("user_workloads_secret", userWorkloadsSecret);
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
    return PROJECT_LOCATION_ENVIRONMENT_USER_WORKLOADS_SECRET.instantiate(
        "project",
        project,
        "location",
        location,
        "environment",
        environment,
        "user_workloads_secret",
        userWorkloadsSecret);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserWorkloadsSecretName that = ((UserWorkloadsSecretName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.environment, that.environment)
          && Objects.equals(this.userWorkloadsSecret, that.userWorkloadsSecret);
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
    h ^= Objects.hashCode(userWorkloadsSecret);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/environments/{environment}/userWorkloadsSecrets/{user_workloads_secret}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String environment;
    private String userWorkloadsSecret;

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

    public String getUserWorkloadsSecret() {
      return userWorkloadsSecret;
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

    public Builder setUserWorkloadsSecret(String userWorkloadsSecret) {
      this.userWorkloadsSecret = userWorkloadsSecret;
      return this;
    }

    private Builder(UserWorkloadsSecretName userWorkloadsSecretName) {
      this.project = userWorkloadsSecretName.project;
      this.location = userWorkloadsSecretName.location;
      this.environment = userWorkloadsSecretName.environment;
      this.userWorkloadsSecret = userWorkloadsSecretName.userWorkloadsSecret;
    }

    public UserWorkloadsSecretName build() {
      return new UserWorkloadsSecretName(this);
    }
  }
}
