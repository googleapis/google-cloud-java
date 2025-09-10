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
public class DestinationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MULTICLOUD_DATA_TRANSFER_CONFIG_DESTINATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/multicloudDataTransferConfigs/{multicloud_data_transfer_config}/destinations/{destination}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String multicloudDataTransferConfig;
  private final String destination;

  @Deprecated
  protected DestinationName() {
    project = null;
    location = null;
    multicloudDataTransferConfig = null;
    destination = null;
  }

  private DestinationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    multicloudDataTransferConfig =
        Preconditions.checkNotNull(builder.getMulticloudDataTransferConfig());
    destination = Preconditions.checkNotNull(builder.getDestination());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMulticloudDataTransferConfig() {
    return multicloudDataTransferConfig;
  }

  public String getDestination() {
    return destination;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DestinationName of(
      String project, String location, String multicloudDataTransferConfig, String destination) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMulticloudDataTransferConfig(multicloudDataTransferConfig)
        .setDestination(destination)
        .build();
  }

  public static String format(
      String project, String location, String multicloudDataTransferConfig, String destination) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMulticloudDataTransferConfig(multicloudDataTransferConfig)
        .setDestination(destination)
        .build()
        .toString();
  }

  public static DestinationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MULTICLOUD_DATA_TRANSFER_CONFIG_DESTINATION.validatedMatch(
            formattedString, "DestinationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("multicloud_data_transfer_config"),
        matchMap.get("destination"));
  }

  public static List<DestinationName> parseList(List<String> formattedStrings) {
    List<DestinationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DestinationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DestinationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MULTICLOUD_DATA_TRANSFER_CONFIG_DESTINATION.matches(formattedString);
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
          if (multicloudDataTransferConfig != null) {
            fieldMapBuilder.put("multicloud_data_transfer_config", multicloudDataTransferConfig);
          }
          if (destination != null) {
            fieldMapBuilder.put("destination", destination);
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
    return PROJECT_LOCATION_MULTICLOUD_DATA_TRANSFER_CONFIG_DESTINATION.instantiate(
        "project",
        project,
        "location",
        location,
        "multicloud_data_transfer_config",
        multicloudDataTransferConfig,
        "destination",
        destination);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DestinationName that = ((DestinationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.multicloudDataTransferConfig, that.multicloudDataTransferConfig)
          && Objects.equals(this.destination, that.destination);
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
    h ^= Objects.hashCode(multicloudDataTransferConfig);
    h *= 1000003;
    h ^= Objects.hashCode(destination);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/multicloudDataTransferConfigs/{multicloud_data_transfer_config}/destinations/{destination}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String multicloudDataTransferConfig;
    private String destination;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMulticloudDataTransferConfig() {
      return multicloudDataTransferConfig;
    }

    public String getDestination() {
      return destination;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMulticloudDataTransferConfig(String multicloudDataTransferConfig) {
      this.multicloudDataTransferConfig = multicloudDataTransferConfig;
      return this;
    }

    public Builder setDestination(String destination) {
      this.destination = destination;
      return this;
    }

    private Builder(DestinationName destinationName) {
      this.project = destinationName.project;
      this.location = destinationName.location;
      this.multicloudDataTransferConfig = destinationName.multicloudDataTransferConfig;
      this.destination = destinationName.destination;
    }

    public DestinationName build() {
      return new DestinationName(this);
    }
  }
}
