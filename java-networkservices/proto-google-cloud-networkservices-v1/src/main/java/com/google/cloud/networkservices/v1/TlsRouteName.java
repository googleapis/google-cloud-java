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
public class TlsRouteName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TLS_ROUTE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tlsRoutes/{tls_route}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String tlsRoute;

  @Deprecated
  protected TlsRouteName() {
    project = null;
    location = null;
    tlsRoute = null;
  }

  private TlsRouteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tlsRoute = Preconditions.checkNotNull(builder.getTlsRoute());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTlsRoute() {
    return tlsRoute;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TlsRouteName of(String project, String location, String tlsRoute) {
    return newBuilder().setProject(project).setLocation(location).setTlsRoute(tlsRoute).build();
  }

  public static String format(String project, String location, String tlsRoute) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTlsRoute(tlsRoute)
        .build()
        .toString();
  }

  public static TlsRouteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TLS_ROUTE.validatedMatch(
            formattedString, "TlsRouteName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("tls_route"));
  }

  public static List<TlsRouteName> parseList(List<String> formattedStrings) {
    List<TlsRouteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TlsRouteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TlsRouteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TLS_ROUTE.matches(formattedString);
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
          if (tlsRoute != null) {
            fieldMapBuilder.put("tls_route", tlsRoute);
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
    return PROJECT_LOCATION_TLS_ROUTE.instantiate(
        "project", project, "location", location, "tls_route", tlsRoute);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TlsRouteName that = ((TlsRouteName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.tlsRoute, that.tlsRoute);
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
    h ^= Objects.hashCode(tlsRoute);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/tlsRoutes/{tls_route}. */
  public static class Builder {
    private String project;
    private String location;
    private String tlsRoute;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTlsRoute() {
      return tlsRoute;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTlsRoute(String tlsRoute) {
      this.tlsRoute = tlsRoute;
      return this;
    }

    private Builder(TlsRouteName tlsRouteName) {
      this.project = tlsRouteName.project;
      this.location = tlsRouteName.location;
      this.tlsRoute = tlsRouteName.tlsRoute;
    }

    public TlsRouteName build() {
      return new TlsRouteName(this);
    }
  }
}
