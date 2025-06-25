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

package com.google.cloud.configdelivery.v1beta;

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
public class RolloutName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FLEET_PACKAGE_ROLLOUT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/fleetPackages/{fleet_package}/rollouts/{rollout}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String fleetPackage;
  private final String rollout;

  @Deprecated
  protected RolloutName() {
    project = null;
    location = null;
    fleetPackage = null;
    rollout = null;
  }

  private RolloutName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    fleetPackage = Preconditions.checkNotNull(builder.getFleetPackage());
    rollout = Preconditions.checkNotNull(builder.getRollout());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFleetPackage() {
    return fleetPackage;
  }

  public String getRollout() {
    return rollout;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RolloutName of(
      String project, String location, String fleetPackage, String rollout) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFleetPackage(fleetPackage)
        .setRollout(rollout)
        .build();
  }

  public static String format(
      String project, String location, String fleetPackage, String rollout) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFleetPackage(fleetPackage)
        .setRollout(rollout)
        .build()
        .toString();
  }

  public static RolloutName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FLEET_PACKAGE_ROLLOUT.validatedMatch(
            formattedString, "RolloutName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("fleet_package"),
        matchMap.get("rollout"));
  }

  public static List<RolloutName> parseList(List<String> formattedStrings) {
    List<RolloutName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RolloutName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RolloutName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FLEET_PACKAGE_ROLLOUT.matches(formattedString);
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
          if (fleetPackage != null) {
            fieldMapBuilder.put("fleet_package", fleetPackage);
          }
          if (rollout != null) {
            fieldMapBuilder.put("rollout", rollout);
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
    return PROJECT_LOCATION_FLEET_PACKAGE_ROLLOUT.instantiate(
        "project",
        project,
        "location",
        location,
        "fleet_package",
        fleetPackage,
        "rollout",
        rollout);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RolloutName that = ((RolloutName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.fleetPackage, that.fleetPackage)
          && Objects.equals(this.rollout, that.rollout);
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
    h ^= Objects.hashCode(fleetPackage);
    h *= 1000003;
    h ^= Objects.hashCode(rollout);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/fleetPackages/{fleet_package}/rollouts/{rollout}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String fleetPackage;
    private String rollout;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFleetPackage() {
      return fleetPackage;
    }

    public String getRollout() {
      return rollout;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFleetPackage(String fleetPackage) {
      this.fleetPackage = fleetPackage;
      return this;
    }

    public Builder setRollout(String rollout) {
      this.rollout = rollout;
      return this;
    }

    private Builder(RolloutName rolloutName) {
      this.project = rolloutName.project;
      this.location = rolloutName.location;
      this.fleetPackage = rolloutName.fleetPackage;
      this.rollout = rolloutName.rollout;
    }

    public RolloutName build() {
      return new RolloutName(this);
    }
  }
}
