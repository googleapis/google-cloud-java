/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.datatransfer.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * AUTO-GENERATED DOCUMENTATION AND CLASS
 *
 * @deprecated This resource name class will be removed in the next major version.
 */
@javax.annotation.Generated("by GAPIC protoc plugin")
@Deprecated
public class LocationTransferConfigName extends TransferConfigName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/transferConfigs/{transfer_config}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String transferConfig;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTransferConfig() {
    return transferConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private LocationTransferConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    transferConfig = Preconditions.checkNotNull(builder.getTransferConfig());
  }

  public static LocationTransferConfigName of(
      String project, String location, String transferConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTransferConfig(transferConfig)
        .build();
  }

  public static String format(String project, String location, String transferConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTransferConfig(transferConfig)
        .build()
        .toString();
  }

  public static LocationTransferConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "LocationTransferConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("transfer_config"));
  }

  public static List<LocationTransferConfigName> parseList(List<String> formattedStrings) {
    List<LocationTransferConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LocationTransferConfigName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (LocationTransferConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("transferConfig", transferConfig);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "location", location, "transfer_config", transferConfig);
  }

  /** Builder for LocationTransferConfigName. */
  public static class Builder extends TransferConfigName.Builder {

    private String project;
    private String location;
    private String transferConfig;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTransferConfig() {
      return transferConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTransferConfig(String transferConfig) {
      this.transferConfig = transferConfig;
      return this;
    }

    private Builder() {}

    private Builder(LocationTransferConfigName locationTransferConfigName) {
      project = locationTransferConfigName.project;
      location = locationTransferConfigName.location;
      transferConfig = locationTransferConfigName.transferConfig;
    }

    public LocationTransferConfigName build() {
      return new LocationTransferConfigName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LocationTransferConfigName) {
      LocationTransferConfigName that = (LocationTransferConfigName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.transferConfig.equals(that.transferConfig));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= transferConfig.hashCode();
    return h;
  }
}
