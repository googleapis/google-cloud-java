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
public class GatewayRouteViewName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GATEWAY_ROUTE_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/gateways/{gateway}/routeViews/{route_view}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String gateway;
  private final String routeView;

  @Deprecated
  protected GatewayRouteViewName() {
    project = null;
    location = null;
    gateway = null;
    routeView = null;
  }

  private GatewayRouteViewName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    gateway = Preconditions.checkNotNull(builder.getGateway());
    routeView = Preconditions.checkNotNull(builder.getRouteView());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGateway() {
    return gateway;
  }

  public String getRouteView() {
    return routeView;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GatewayRouteViewName of(
      String project, String location, String gateway, String routeView) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGateway(gateway)
        .setRouteView(routeView)
        .build();
  }

  public static String format(String project, String location, String gateway, String routeView) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGateway(gateway)
        .setRouteView(routeView)
        .build()
        .toString();
  }

  public static GatewayRouteViewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GATEWAY_ROUTE_VIEW.validatedMatch(
            formattedString, "GatewayRouteViewName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("gateway"),
        matchMap.get("route_view"));
  }

  public static List<GatewayRouteViewName> parseList(List<String> formattedStrings) {
    List<GatewayRouteViewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GatewayRouteViewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GatewayRouteViewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GATEWAY_ROUTE_VIEW.matches(formattedString);
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
          if (gateway != null) {
            fieldMapBuilder.put("gateway", gateway);
          }
          if (routeView != null) {
            fieldMapBuilder.put("route_view", routeView);
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
    return PROJECT_LOCATION_GATEWAY_ROUTE_VIEW.instantiate(
        "project", project, "location", location, "gateway", gateway, "route_view", routeView);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GatewayRouteViewName that = ((GatewayRouteViewName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.gateway, that.gateway)
          && Objects.equals(this.routeView, that.routeView);
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
    h ^= Objects.hashCode(gateway);
    h *= 1000003;
    h ^= Objects.hashCode(routeView);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/gateways/{gateway}/routeViews/{route_view}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String gateway;
    private String routeView;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGateway() {
      return gateway;
    }

    public String getRouteView() {
      return routeView;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGateway(String gateway) {
      this.gateway = gateway;
      return this;
    }

    public Builder setRouteView(String routeView) {
      this.routeView = routeView;
      return this;
    }

    private Builder(GatewayRouteViewName gatewayRouteViewName) {
      this.project = gatewayRouteViewName.project;
      this.location = gatewayRouteViewName.location;
      this.gateway = gatewayRouteViewName.gateway;
      this.routeView = gatewayRouteViewName.routeView;
    }

    public GatewayRouteViewName build() {
      return new GatewayRouteViewName(this);
    }
  }
}
