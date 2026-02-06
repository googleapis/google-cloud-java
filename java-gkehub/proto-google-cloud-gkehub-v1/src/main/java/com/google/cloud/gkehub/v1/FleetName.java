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

package com.google.cloud.gkehub.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class FleetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FLEET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/fleets/{fleet}");
  private static final PathTemplate ORGANIZATION_LOCATION_FLEET =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/fleets/{fleet}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String fleet;
  private final String organization;

  @Deprecated
  protected FleetName() {
    project = null;
    location = null;
    fleet = null;
    organization = null;
  }

  private FleetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    fleet = Preconditions.checkNotNull(builder.getFleet());
    organization = null;
    pathTemplate = PROJECT_LOCATION_FLEET;
  }

  private FleetName(OrganizationLocationFleetBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    fleet = Preconditions.checkNotNull(builder.getFleet());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_FLEET;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFleet() {
    return fleet;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationFleetBuilder() {
    return new Builder();
  }

  public static OrganizationLocationFleetBuilder newOrganizationLocationFleetBuilder() {
    return new OrganizationLocationFleetBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FleetName of(String project, String location, String fleet) {
    return newBuilder().setProject(project).setLocation(location).setFleet(fleet).build();
  }

  public static FleetName ofProjectLocationFleetName(
      String project, String location, String fleet) {
    return newBuilder().setProject(project).setLocation(location).setFleet(fleet).build();
  }

  public static FleetName ofOrganizationLocationFleetName(
      String organization, String location, String fleet) {
    return newOrganizationLocationFleetBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFleet(fleet)
        .build();
  }

  public static String format(String project, String location, String fleet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFleet(fleet)
        .build()
        .toString();
  }

  public static String formatProjectLocationFleetName(
      String project, String location, String fleet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFleet(fleet)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFleetName(
      String organization, String location, String fleet) {
    return newOrganizationLocationFleetBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFleet(fleet)
        .build()
        .toString();
  }

  public static FleetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FLEET.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_FLEET.match(formattedString);
      return ofProjectLocationFleetName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("fleet"));
    } else if (ORGANIZATION_LOCATION_FLEET.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_FLEET.match(formattedString);
      return ofOrganizationLocationFleetName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("fleet"));
    }
    throw new ValidationException("FleetName.parse: formattedString not in valid format");
  }

  public static List<FleetName> parseList(List<String> formattedStrings) {
    List<FleetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FleetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FleetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FLEET.matches(formattedString)
        || ORGANIZATION_LOCATION_FLEET.matches(formattedString);
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
          if (fleet != null) {
            fieldMapBuilder.put("fleet", fleet);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FleetName that = ((FleetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.fleet, that.fleet)
          && Objects.equals(this.organization, that.organization);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(fleet);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/fleets/{fleet}. */
  public static class Builder {
    private String project;
    private String location;
    private String fleet;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFleet() {
      return fleet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFleet(String fleet) {
      this.fleet = fleet;
      return this;
    }

    private Builder(FleetName fleetName) {
      Preconditions.checkArgument(
          Objects.equals(fleetName.pathTemplate, PROJECT_LOCATION_FLEET),
          "toBuilder is only supported when FleetName has the pattern of"
              + " projects/{project}/locations/{location}/fleets/{fleet}");
      this.project = fleetName.project;
      this.location = fleetName.location;
      this.fleet = fleetName.fleet;
    }

    public FleetName build() {
      return new FleetName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/fleets/{fleet}. */
  public static class OrganizationLocationFleetBuilder {
    private String organization;
    private String location;
    private String fleet;

    protected OrganizationLocationFleetBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFleet() {
      return fleet;
    }

    public OrganizationLocationFleetBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationFleetBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationFleetBuilder setFleet(String fleet) {
      this.fleet = fleet;
      return this;
    }

    public FleetName build() {
      return new FleetName(this);
    }
  }
}
