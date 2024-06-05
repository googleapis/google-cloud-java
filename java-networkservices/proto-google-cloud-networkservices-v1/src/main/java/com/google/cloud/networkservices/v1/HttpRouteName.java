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
public class HttpRouteName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_HTTP_ROUTE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/httpRoutes/{http_route}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String httpRoute;

  @Deprecated
  protected HttpRouteName() {
    project = null;
    location = null;
    httpRoute = null;
  }

  private HttpRouteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    httpRoute = Preconditions.checkNotNull(builder.getHttpRoute());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getHttpRoute() {
    return httpRoute;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HttpRouteName of(String project, String location, String httpRoute) {
    return newBuilder().setProject(project).setLocation(location).setHttpRoute(httpRoute).build();
  }

  public static String format(String project, String location, String httpRoute) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setHttpRoute(httpRoute)
        .build()
        .toString();
  }

  public static HttpRouteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_HTTP_ROUTE.validatedMatch(
            formattedString, "HttpRouteName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("http_route"));
  }

  public static List<HttpRouteName> parseList(List<String> formattedStrings) {
    List<HttpRouteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HttpRouteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HttpRouteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_HTTP_ROUTE.matches(formattedString);
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
          if (httpRoute != null) {
            fieldMapBuilder.put("http_route", httpRoute);
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
    return PROJECT_LOCATION_HTTP_ROUTE.instantiate(
        "project", project, "location", location, "http_route", httpRoute);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      HttpRouteName that = ((HttpRouteName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.httpRoute, that.httpRoute);
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
    h ^= Objects.hashCode(httpRoute);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/httpRoutes/{http_route}. */
  public static class Builder {
    private String project;
    private String location;
    private String httpRoute;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getHttpRoute() {
      return httpRoute;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setHttpRoute(String httpRoute) {
      this.httpRoute = httpRoute;
      return this;
    }

    private Builder(HttpRouteName httpRouteName) {
      this.project = httpRouteName.project;
      this.location = httpRouteName.location;
      this.httpRoute = httpRouteName.httpRoute;
    }

    public HttpRouteName build() {
      return new HttpRouteName(this);
    }
  }
}
