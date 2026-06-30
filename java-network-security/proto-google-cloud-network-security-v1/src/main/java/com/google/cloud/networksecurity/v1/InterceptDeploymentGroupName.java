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
public class InterceptDeploymentGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INTERCEPT_DEPLOYMENT_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/interceptDeploymentGroups/{intercept_deployment_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String interceptDeploymentGroup;

  @Deprecated
  protected InterceptDeploymentGroupName() {
    project = null;
    location = null;
    interceptDeploymentGroup = null;
  }

  private InterceptDeploymentGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    interceptDeploymentGroup = Preconditions.checkNotNull(builder.getInterceptDeploymentGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInterceptDeploymentGroup() {
    return interceptDeploymentGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InterceptDeploymentGroupName of(
      String project, String location, String interceptDeploymentGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInterceptDeploymentGroup(interceptDeploymentGroup)
        .build();
  }

  public static String format(String project, String location, String interceptDeploymentGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInterceptDeploymentGroup(interceptDeploymentGroup)
        .build()
        .toString();
  }

  public static InterceptDeploymentGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INTERCEPT_DEPLOYMENT_GROUP.validatedMatch(
            formattedString,
            "InterceptDeploymentGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("intercept_deployment_group"));
  }

  public static List<InterceptDeploymentGroupName> parseList(List<String> formattedStrings) {
    List<InterceptDeploymentGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InterceptDeploymentGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InterceptDeploymentGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INTERCEPT_DEPLOYMENT_GROUP.matches(formattedString);
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
          if (interceptDeploymentGroup != null) {
            fieldMapBuilder.put("intercept_deployment_group", interceptDeploymentGroup);
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
    return PROJECT_LOCATION_INTERCEPT_DEPLOYMENT_GROUP.instantiate(
        "project",
        project,
        "location",
        location,
        "intercept_deployment_group",
        interceptDeploymentGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      InterceptDeploymentGroupName that = ((InterceptDeploymentGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.interceptDeploymentGroup, that.interceptDeploymentGroup);
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
    h ^= Objects.hashCode(interceptDeploymentGroup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/interceptDeploymentGroups/{intercept_deployment_group}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String interceptDeploymentGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInterceptDeploymentGroup() {
      return interceptDeploymentGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInterceptDeploymentGroup(String interceptDeploymentGroup) {
      this.interceptDeploymentGroup = interceptDeploymentGroup;
      return this;
    }

    private Builder(InterceptDeploymentGroupName interceptDeploymentGroupName) {
      this.project = interceptDeploymentGroupName.project;
      this.location = interceptDeploymentGroupName.location;
      this.interceptDeploymentGroup = interceptDeploymentGroupName.interceptDeploymentGroup;
    }

    public InterceptDeploymentGroupName build() {
      return new InterceptDeploymentGroupName(this);
    }
  }
}
