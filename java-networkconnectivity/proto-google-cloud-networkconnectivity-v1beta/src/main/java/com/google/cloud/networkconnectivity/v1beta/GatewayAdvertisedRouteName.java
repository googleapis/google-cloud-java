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

package com.google.cloud.networkconnectivity.v1beta;

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
public class GatewayAdvertisedRouteName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SPOKE_GATEWAY_ADVERTISED_ROUTE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/spokes/{spoke}/gatewayAdvertisedRoutes/{gateway_advertised_route}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String spoke;
  private final String gatewayAdvertisedRoute;

  @Deprecated
  protected GatewayAdvertisedRouteName() {
    project = null;
    location = null;
    spoke = null;
    gatewayAdvertisedRoute = null;
  }

  private GatewayAdvertisedRouteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    spoke = Preconditions.checkNotNull(builder.getSpoke());
    gatewayAdvertisedRoute = Preconditions.checkNotNull(builder.getGatewayAdvertisedRoute());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSpoke() {
    return spoke;
  }

  public String getGatewayAdvertisedRoute() {
    return gatewayAdvertisedRoute;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GatewayAdvertisedRouteName of(
      String project, String location, String spoke, String gatewayAdvertisedRoute) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpoke(spoke)
        .setGatewayAdvertisedRoute(gatewayAdvertisedRoute)
        .build();
  }

  public static String format(
      String project, String location, String spoke, String gatewayAdvertisedRoute) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpoke(spoke)
        .setGatewayAdvertisedRoute(gatewayAdvertisedRoute)
        .build()
        .toString();
  }

  public static GatewayAdvertisedRouteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SPOKE_GATEWAY_ADVERTISED_ROUTE.validatedMatch(
            formattedString,
            "GatewayAdvertisedRouteName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("spoke"),
        matchMap.get("gateway_advertised_route"));
  }

  public static List<GatewayAdvertisedRouteName> parseList(List<String> formattedStrings) {
    List<GatewayAdvertisedRouteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GatewayAdvertisedRouteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GatewayAdvertisedRouteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SPOKE_GATEWAY_ADVERTISED_ROUTE.matches(formattedString);
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
          if (spoke != null) {
            fieldMapBuilder.put("spoke", spoke);
          }
          if (gatewayAdvertisedRoute != null) {
            fieldMapBuilder.put("gateway_advertised_route", gatewayAdvertisedRoute);
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
    return PROJECT_LOCATION_SPOKE_GATEWAY_ADVERTISED_ROUTE.instantiate(
        "project",
        project,
        "location",
        location,
        "spoke",
        spoke,
        "gateway_advertised_route",
        gatewayAdvertisedRoute);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GatewayAdvertisedRouteName that = ((GatewayAdvertisedRouteName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.spoke, that.spoke)
          && Objects.equals(this.gatewayAdvertisedRoute, that.gatewayAdvertisedRoute);
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
    h ^= Objects.hashCode(spoke);
    h *= 1000003;
    h ^= Objects.hashCode(gatewayAdvertisedRoute);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/spokes/{spoke}/gatewayAdvertisedRoutes/{gateway_advertised_route}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String spoke;
    private String gatewayAdvertisedRoute;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSpoke() {
      return spoke;
    }

    public String getGatewayAdvertisedRoute() {
      return gatewayAdvertisedRoute;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSpoke(String spoke) {
      this.spoke = spoke;
      return this;
    }

    public Builder setGatewayAdvertisedRoute(String gatewayAdvertisedRoute) {
      this.gatewayAdvertisedRoute = gatewayAdvertisedRoute;
      return this;
    }

    private Builder(GatewayAdvertisedRouteName gatewayAdvertisedRouteName) {
      this.project = gatewayAdvertisedRouteName.project;
      this.location = gatewayAdvertisedRouteName.location;
      this.spoke = gatewayAdvertisedRouteName.spoke;
      this.gatewayAdvertisedRoute = gatewayAdvertisedRouteName.gatewayAdvertisedRoute;
    }

    public GatewayAdvertisedRouteName build() {
      return new GatewayAdvertisedRouteName(this);
    }
  }
}
