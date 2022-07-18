/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.apigateway.v1;

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
public class GatewayName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GATEWAY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/gateways/{gateway}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String gateway;

  @Deprecated
  protected GatewayName() {
    project = null;
    location = null;
    gateway = null;
  }

  private GatewayName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    gateway = Preconditions.checkNotNull(builder.getGateway());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GatewayName of(String project, String location, String gateway) {
    return newBuilder().setProject(project).setLocation(location).setGateway(gateway).build();
  }

  public static String format(String project, String location, String gateway) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGateway(gateway)
        .build()
        .toString();
  }

  public static GatewayName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GATEWAY.validatedMatch(
            formattedString, "GatewayName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("gateway"));
  }

  public static List<GatewayName> parseList(List<String> formattedStrings) {
    List<GatewayName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GatewayName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GatewayName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GATEWAY.matches(formattedString);
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
    return PROJECT_LOCATION_GATEWAY.instantiate(
        "project", project, "location", location, "gateway", gateway);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      GatewayName that = ((GatewayName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.gateway, that.gateway);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/gateways/{gateway}. */
  public static class Builder {
    private String project;
    private String location;
    private String gateway;

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

    private Builder(GatewayName gatewayName) {
      this.project = gatewayName.project;
      this.location = gatewayName.location;
      this.gateway = gatewayName.gateway;
    }

    public GatewayName build() {
      return new GatewayName(this);
    }
  }
}
