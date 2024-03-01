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

package com.google.cloud.networkconnectivity.v1;

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
public class HubRouteName implements ResourceName {
  private static final PathTemplate PROJECT_HUB_ROUTE_TABLE_ROUTE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/global/hubs/{hub}/routeTables/{route_table}/routes/{route}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String hub;
  private final String routeTable;
  private final String route;

  @Deprecated
  protected HubRouteName() {
    project = null;
    hub = null;
    routeTable = null;
    route = null;
  }

  private HubRouteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    hub = Preconditions.checkNotNull(builder.getHub());
    routeTable = Preconditions.checkNotNull(builder.getRouteTable());
    route = Preconditions.checkNotNull(builder.getRoute());
  }

  public String getProject() {
    return project;
  }

  public String getHub() {
    return hub;
  }

  public String getRouteTable() {
    return routeTable;
  }

  public String getRoute() {
    return route;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HubRouteName of(String project, String hub, String routeTable, String route) {
    return newBuilder()
        .setProject(project)
        .setHub(hub)
        .setRouteTable(routeTable)
        .setRoute(route)
        .build();
  }

  public static String format(String project, String hub, String routeTable, String route) {
    return newBuilder()
        .setProject(project)
        .setHub(hub)
        .setRouteTable(routeTable)
        .setRoute(route)
        .build()
        .toString();
  }

  public static HubRouteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_HUB_ROUTE_TABLE_ROUTE.validatedMatch(
            formattedString, "HubRouteName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("hub"),
        matchMap.get("route_table"),
        matchMap.get("route"));
  }

  public static List<HubRouteName> parseList(List<String> formattedStrings) {
    List<HubRouteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HubRouteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HubRouteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_HUB_ROUTE_TABLE_ROUTE.matches(formattedString);
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
          if (hub != null) {
            fieldMapBuilder.put("hub", hub);
          }
          if (routeTable != null) {
            fieldMapBuilder.put("route_table", routeTable);
          }
          if (route != null) {
            fieldMapBuilder.put("route", route);
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
    return PROJECT_HUB_ROUTE_TABLE_ROUTE.instantiate(
        "project", project, "hub", hub, "route_table", routeTable, "route", route);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      HubRouteName that = ((HubRouteName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.hub, that.hub)
          && Objects.equals(this.routeTable, that.routeTable)
          && Objects.equals(this.route, that.route);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(hub);
    h *= 1000003;
    h ^= Objects.hashCode(routeTable);
    h *= 1000003;
    h ^= Objects.hashCode(route);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/global/hubs/{hub}/routeTables/{route_table}/routes/{route}.
   */
  public static class Builder {
    private String project;
    private String hub;
    private String routeTable;
    private String route;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getHub() {
      return hub;
    }

    public String getRouteTable() {
      return routeTable;
    }

    public String getRoute() {
      return route;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setHub(String hub) {
      this.hub = hub;
      return this;
    }

    public Builder setRouteTable(String routeTable) {
      this.routeTable = routeTable;
      return this;
    }

    public Builder setRoute(String route) {
      this.route = route;
      return this;
    }

    private Builder(HubRouteName hubRouteName) {
      this.project = hubRouteName.project;
      this.hub = hubRouteName.hub;
      this.routeTable = hubRouteName.routeTable;
      this.route = hubRouteName.route;
    }

    public HubRouteName build() {
      return new HubRouteName(this);
    }
  }
}
