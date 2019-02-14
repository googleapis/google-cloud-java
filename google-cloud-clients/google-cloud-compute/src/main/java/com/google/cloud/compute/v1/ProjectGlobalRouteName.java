/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectGlobalRouteName implements ResourceName {
  private final String project;
  private final String route;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/global/routes/{route}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalRouteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    route = Preconditions.checkNotNull(builder.getRoute());
  }

  public static ProjectGlobalRouteName of(String project, String route) {
    return newBuilder().setProject(project).setRoute(route).build();
  }

  public static String format(String project, String route) {
    return of(project, route).toString();
  }

  public String getProject() {
    return project;
  }

  public String getRoute() {
    return route;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("route", route);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalRouteName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalRouteName>() {
      public ProjectGlobalRouteName parse(String formattedString) {
        return ProjectGlobalRouteName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalRouteName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectGlobalRouteName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("route"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String project;
    private String route;

    public String getProject() {
      return project;
    }

    public String getRoute() {
      return route;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRoute(String route) {
      this.route = route;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalRouteName projectGlobalRouteName) {
      project = projectGlobalRouteName.project;
      route = projectGlobalRouteName.route;
    }

    public ProjectGlobalRouteName build() {
      return new ProjectGlobalRouteName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "project", project,
            "route", route);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalRouteName) {
      ProjectGlobalRouteName that = (ProjectGlobalRouteName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.route, that.getRoute());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, route);
  }
}
