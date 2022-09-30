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

package com.google.cloud.vmmigration.v1;

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
public class DatacenterConnectorName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SOURCE_DATACENTER_CONNECTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sources/{source}/datacenterConnectors/{datacenter_connector}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String source;
  private final String datacenterConnector;

  @Deprecated
  protected DatacenterConnectorName() {
    project = null;
    location = null;
    source = null;
    datacenterConnector = null;
  }

  private DatacenterConnectorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    source = Preconditions.checkNotNull(builder.getSource());
    datacenterConnector = Preconditions.checkNotNull(builder.getDatacenterConnector());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSource() {
    return source;
  }

  public String getDatacenterConnector() {
    return datacenterConnector;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DatacenterConnectorName of(
      String project, String location, String source, String datacenterConnector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setDatacenterConnector(datacenterConnector)
        .build();
  }

  public static String format(
      String project, String location, String source, String datacenterConnector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSource(source)
        .setDatacenterConnector(datacenterConnector)
        .build()
        .toString();
  }

  public static DatacenterConnectorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SOURCE_DATACENTER_CONNECTOR.validatedMatch(
            formattedString, "DatacenterConnectorName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("source"),
        matchMap.get("datacenter_connector"));
  }

  public static List<DatacenterConnectorName> parseList(List<String> formattedStrings) {
    List<DatacenterConnectorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DatacenterConnectorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DatacenterConnectorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SOURCE_DATACENTER_CONNECTOR.matches(formattedString);
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
          if (source != null) {
            fieldMapBuilder.put("source", source);
          }
          if (datacenterConnector != null) {
            fieldMapBuilder.put("datacenter_connector", datacenterConnector);
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
    return PROJECT_LOCATION_SOURCE_DATACENTER_CONNECTOR.instantiate(
        "project",
        project,
        "location",
        location,
        "source",
        source,
        "datacenter_connector",
        datacenterConnector);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DatacenterConnectorName that = ((DatacenterConnectorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.source, that.source)
          && Objects.equals(this.datacenterConnector, that.datacenterConnector);
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
    h ^= Objects.hashCode(source);
    h *= 1000003;
    h ^= Objects.hashCode(datacenterConnector);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/sources/{source}/datacenterConnectors/{datacenter_connector}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String source;
    private String datacenterConnector;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSource() {
      return source;
    }

    public String getDatacenterConnector() {
      return datacenterConnector;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    public Builder setDatacenterConnector(String datacenterConnector) {
      this.datacenterConnector = datacenterConnector;
      return this;
    }

    private Builder(DatacenterConnectorName datacenterConnectorName) {
      this.project = datacenterConnectorName.project;
      this.location = datacenterConnectorName.location;
      this.source = datacenterConnectorName.source;
      this.datacenterConnector = datacenterConnectorName.datacenterConnector;
    }

    public DatacenterConnectorName build() {
      return new DatacenterConnectorName(this);
    }
  }
}
