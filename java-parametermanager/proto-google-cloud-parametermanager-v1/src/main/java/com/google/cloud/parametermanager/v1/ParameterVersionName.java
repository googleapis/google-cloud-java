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

package com.google.cloud.parametermanager.v1;

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
public class ParameterVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PARAMETER_PARAMETER_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/parameters/{parameter}/versions/{parameter_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String parameter;
  private final String parameterVersion;

  @Deprecated
  protected ParameterVersionName() {
    project = null;
    location = null;
    parameter = null;
    parameterVersion = null;
  }

  private ParameterVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    parameter = Preconditions.checkNotNull(builder.getParameter());
    parameterVersion = Preconditions.checkNotNull(builder.getParameterVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getParameter() {
    return parameter;
  }

  public String getParameterVersion() {
    return parameterVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ParameterVersionName of(
      String project, String location, String parameter, String parameterVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setParameter(parameter)
        .setParameterVersion(parameterVersion)
        .build();
  }

  public static String format(
      String project, String location, String parameter, String parameterVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setParameter(parameter)
        .setParameterVersion(parameterVersion)
        .build()
        .toString();
  }

  public static ParameterVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PARAMETER_PARAMETER_VERSION.validatedMatch(
            formattedString, "ParameterVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("parameter"),
        matchMap.get("parameter_version"));
  }

  public static List<ParameterVersionName> parseList(List<String> formattedStrings) {
    List<ParameterVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ParameterVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ParameterVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PARAMETER_PARAMETER_VERSION.matches(formattedString);
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
          if (parameter != null) {
            fieldMapBuilder.put("parameter", parameter);
          }
          if (parameterVersion != null) {
            fieldMapBuilder.put("parameter_version", parameterVersion);
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
    return PROJECT_LOCATION_PARAMETER_PARAMETER_VERSION.instantiate(
        "project",
        project,
        "location",
        location,
        "parameter",
        parameter,
        "parameter_version",
        parameterVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ParameterVersionName that = ((ParameterVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.parameter, that.parameter)
          && Objects.equals(this.parameterVersion, that.parameterVersion);
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
    h ^= Objects.hashCode(parameter);
    h *= 1000003;
    h ^= Objects.hashCode(parameterVersion);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/parameters/{parameter}/versions/{parameter_version}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String parameter;
    private String parameterVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getParameter() {
      return parameter;
    }

    public String getParameterVersion() {
      return parameterVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setParameter(String parameter) {
      this.parameter = parameter;
      return this;
    }

    public Builder setParameterVersion(String parameterVersion) {
      this.parameterVersion = parameterVersion;
      return this;
    }

    private Builder(ParameterVersionName parameterVersionName) {
      this.project = parameterVersionName.project;
      this.location = parameterVersionName.location;
      this.parameter = parameterVersionName.parameter;
      this.parameterVersion = parameterVersionName.parameterVersion;
    }

    public ParameterVersionName build() {
      return new ParameterVersionName(this);
    }
  }
}
