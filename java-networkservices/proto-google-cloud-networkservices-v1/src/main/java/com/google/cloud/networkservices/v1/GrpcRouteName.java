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

package com.google.cloud.networkservices.v1;

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
public class GrpcRouteName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GRPC_ROUTE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/grpcRoutes/{grpc_route}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String grpcRoute;

  @Deprecated
  protected GrpcRouteName() {
    project = null;
    location = null;
    grpcRoute = null;
  }

  private GrpcRouteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    grpcRoute = Preconditions.checkNotNull(builder.getGrpcRoute());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGrpcRoute() {
    return grpcRoute;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GrpcRouteName of(String project, String location, String grpcRoute) {
    return newBuilder().setProject(project).setLocation(location).setGrpcRoute(grpcRoute).build();
  }

  public static String format(String project, String location, String grpcRoute) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGrpcRoute(grpcRoute)
        .build()
        .toString();
  }

  public static GrpcRouteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GRPC_ROUTE.validatedMatch(
            formattedString, "GrpcRouteName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("grpc_route"));
  }

  public static List<GrpcRouteName> parseList(List<String> formattedStrings) {
    List<GrpcRouteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GrpcRouteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GrpcRouteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GRPC_ROUTE.matches(formattedString);
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
          if (grpcRoute != null) {
            fieldMapBuilder.put("grpc_route", grpcRoute);
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
    return PROJECT_LOCATION_GRPC_ROUTE.instantiate(
        "project", project, "location", location, "grpc_route", grpcRoute);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GrpcRouteName that = ((GrpcRouteName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.grpcRoute, that.grpcRoute);
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
    h ^= Objects.hashCode(grpcRoute);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/grpcRoutes/{grpc_route}. */
  public static class Builder {
    private String project;
    private String location;
    private String grpcRoute;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGrpcRoute() {
      return grpcRoute;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGrpcRoute(String grpcRoute) {
      this.grpcRoute = grpcRoute;
      return this;
    }

    private Builder(GrpcRouteName grpcRouteName) {
      this.project = grpcRouteName.project;
      this.location = grpcRouteName.location;
      this.grpcRoute = grpcRouteName.grpcRoute;
    }

    public GrpcRouteName build() {
      return new GrpcRouteName(this);
    }
  }
}
