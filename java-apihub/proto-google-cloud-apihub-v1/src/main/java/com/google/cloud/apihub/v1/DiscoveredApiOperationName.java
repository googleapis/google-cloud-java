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

package com.google.cloud.apihub.v1;

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
public class DiscoveredApiOperationName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_DISCOVERED_API_OBSERVATION_DISCOVERED_API_OPERATION =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}/discoveredApiOperations/{discovered_api_operation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String discoveredApiObservation;
  private final String discoveredApiOperation;

  @Deprecated
  protected DiscoveredApiOperationName() {
    project = null;
    location = null;
    discoveredApiObservation = null;
    discoveredApiOperation = null;
  }

  private DiscoveredApiOperationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    discoveredApiObservation = Preconditions.checkNotNull(builder.getDiscoveredApiObservation());
    discoveredApiOperation = Preconditions.checkNotNull(builder.getDiscoveredApiOperation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDiscoveredApiObservation() {
    return discoveredApiObservation;
  }

  public String getDiscoveredApiOperation() {
    return discoveredApiOperation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DiscoveredApiOperationName of(
      String project,
      String location,
      String discoveredApiObservation,
      String discoveredApiOperation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDiscoveredApiObservation(discoveredApiObservation)
        .setDiscoveredApiOperation(discoveredApiOperation)
        .build();
  }

  public static String format(
      String project,
      String location,
      String discoveredApiObservation,
      String discoveredApiOperation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDiscoveredApiObservation(discoveredApiObservation)
        .setDiscoveredApiOperation(discoveredApiOperation)
        .build()
        .toString();
  }

  public static DiscoveredApiOperationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DISCOVERED_API_OBSERVATION_DISCOVERED_API_OPERATION.validatedMatch(
            formattedString,
            "DiscoveredApiOperationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("discovered_api_observation"),
        matchMap.get("discovered_api_operation"));
  }

  public static List<DiscoveredApiOperationName> parseList(List<String> formattedStrings) {
    List<DiscoveredApiOperationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DiscoveredApiOperationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DiscoveredApiOperationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DISCOVERED_API_OBSERVATION_DISCOVERED_API_OPERATION.matches(
        formattedString);
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
          if (discoveredApiObservation != null) {
            fieldMapBuilder.put("discovered_api_observation", discoveredApiObservation);
          }
          if (discoveredApiOperation != null) {
            fieldMapBuilder.put("discovered_api_operation", discoveredApiOperation);
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
    return PROJECT_LOCATION_DISCOVERED_API_OBSERVATION_DISCOVERED_API_OPERATION.instantiate(
        "project",
        project,
        "location",
        location,
        "discovered_api_observation",
        discoveredApiObservation,
        "discovered_api_operation",
        discoveredApiOperation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DiscoveredApiOperationName that = ((DiscoveredApiOperationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.discoveredApiObservation, that.discoveredApiObservation)
          && Objects.equals(this.discoveredApiOperation, that.discoveredApiOperation);
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
    h ^= Objects.hashCode(discoveredApiObservation);
    h *= 1000003;
    h ^= Objects.hashCode(discoveredApiOperation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}/discoveredApiOperations/{discovered_api_operation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String discoveredApiObservation;
    private String discoveredApiOperation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDiscoveredApiObservation() {
      return discoveredApiObservation;
    }

    public String getDiscoveredApiOperation() {
      return discoveredApiOperation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDiscoveredApiObservation(String discoveredApiObservation) {
      this.discoveredApiObservation = discoveredApiObservation;
      return this;
    }

    public Builder setDiscoveredApiOperation(String discoveredApiOperation) {
      this.discoveredApiOperation = discoveredApiOperation;
      return this;
    }

    private Builder(DiscoveredApiOperationName discoveredApiOperationName) {
      this.project = discoveredApiOperationName.project;
      this.location = discoveredApiOperationName.location;
      this.discoveredApiObservation = discoveredApiOperationName.discoveredApiObservation;
      this.discoveredApiOperation = discoveredApiOperationName.discoveredApiOperation;
    }

    public DiscoveredApiOperationName build() {
      return new DiscoveredApiOperationName(this);
    }
  }
}
