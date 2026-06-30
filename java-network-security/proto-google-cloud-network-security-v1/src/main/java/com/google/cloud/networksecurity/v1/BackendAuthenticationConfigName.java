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

package com.google.cloud.networksecurity.v1;

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
public class BackendAuthenticationConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BACKEND_AUTHENTICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/backendAuthenticationConfigs/{backend_authentication_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String backendAuthenticationConfig;

  @Deprecated
  protected BackendAuthenticationConfigName() {
    project = null;
    location = null;
    backendAuthenticationConfig = null;
  }

  private BackendAuthenticationConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    backendAuthenticationConfig =
        Preconditions.checkNotNull(builder.getBackendAuthenticationConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBackendAuthenticationConfig() {
    return backendAuthenticationConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BackendAuthenticationConfigName of(
      String project, String location, String backendAuthenticationConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackendAuthenticationConfig(backendAuthenticationConfig)
        .build();
  }

  public static String format(String project, String location, String backendAuthenticationConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackendAuthenticationConfig(backendAuthenticationConfig)
        .build()
        .toString();
  }

  public static BackendAuthenticationConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_BACKEND_AUTHENTICATION_CONFIG.validatedMatch(
            formattedString,
            "BackendAuthenticationConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("backend_authentication_config"));
  }

  public static List<BackendAuthenticationConfigName> parseList(List<String> formattedStrings) {
    List<BackendAuthenticationConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BackendAuthenticationConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BackendAuthenticationConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BACKEND_AUTHENTICATION_CONFIG.matches(formattedString);
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
          if (backendAuthenticationConfig != null) {
            fieldMapBuilder.put("backend_authentication_config", backendAuthenticationConfig);
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
    return PROJECT_LOCATION_BACKEND_AUTHENTICATION_CONFIG.instantiate(
        "project",
        project,
        "location",
        location,
        "backend_authentication_config",
        backendAuthenticationConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BackendAuthenticationConfigName that = ((BackendAuthenticationConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.backendAuthenticationConfig, that.backendAuthenticationConfig);
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
    h ^= Objects.hashCode(backendAuthenticationConfig);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/backendAuthenticationConfigs/{backend_authentication_config}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String backendAuthenticationConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBackendAuthenticationConfig() {
      return backendAuthenticationConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBackendAuthenticationConfig(String backendAuthenticationConfig) {
      this.backendAuthenticationConfig = backendAuthenticationConfig;
      return this;
    }

    private Builder(BackendAuthenticationConfigName backendAuthenticationConfigName) {
      this.project = backendAuthenticationConfigName.project;
      this.location = backendAuthenticationConfigName.location;
      this.backendAuthenticationConfig =
          backendAuthenticationConfigName.backendAuthenticationConfig;
    }

    public BackendAuthenticationConfigName build() {
      return new BackendAuthenticationConfigName(this);
    }
  }
}
