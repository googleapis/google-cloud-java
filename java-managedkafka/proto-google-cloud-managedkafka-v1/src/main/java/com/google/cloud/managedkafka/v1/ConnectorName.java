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

package com.google.cloud.managedkafka.v1;

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
public class ConnectorName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONNECT_CLUSTER_CONNECTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/connectClusters/{connect_cluster}/connectors/{connector}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String connectCluster;
  private final String connector;

  @Deprecated
  protected ConnectorName() {
    project = null;
    location = null;
    connectCluster = null;
    connector = null;
  }

  private ConnectorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    connectCluster = Preconditions.checkNotNull(builder.getConnectCluster());
    connector = Preconditions.checkNotNull(builder.getConnector());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getConnectCluster() {
    return connectCluster;
  }

  public String getConnector() {
    return connector;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConnectorName of(
      String project, String location, String connectCluster, String connector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConnectCluster(connectCluster)
        .setConnector(connector)
        .build();
  }

  public static String format(
      String project, String location, String connectCluster, String connector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConnectCluster(connectCluster)
        .setConnector(connector)
        .build()
        .toString();
  }

  public static ConnectorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CONNECT_CLUSTER_CONNECTOR.validatedMatch(
            formattedString, "ConnectorName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("connect_cluster"),
        matchMap.get("connector"));
  }

  public static List<ConnectorName> parseList(List<String> formattedStrings) {
    List<ConnectorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConnectorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConnectorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONNECT_CLUSTER_CONNECTOR.matches(formattedString);
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
          if (connectCluster != null) {
            fieldMapBuilder.put("connect_cluster", connectCluster);
          }
          if (connector != null) {
            fieldMapBuilder.put("connector", connector);
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
    return PROJECT_LOCATION_CONNECT_CLUSTER_CONNECTOR.instantiate(
        "project",
        project,
        "location",
        location,
        "connect_cluster",
        connectCluster,
        "connector",
        connector);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ConnectorName that = ((ConnectorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.connectCluster, that.connectCluster)
          && Objects.equals(this.connector, that.connector);
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
    h ^= Objects.hashCode(connectCluster);
    h *= 1000003;
    h ^= Objects.hashCode(connector);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/connectClusters/{connect_cluster}/connectors/{connector}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String connectCluster;
    private String connector;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConnectCluster() {
      return connectCluster;
    }

    public String getConnector() {
      return connector;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setConnectCluster(String connectCluster) {
      this.connectCluster = connectCluster;
      return this;
    }

    public Builder setConnector(String connector) {
      this.connector = connector;
      return this;
    }

    private Builder(ConnectorName connectorName) {
      this.project = connectorName.project;
      this.location = connectorName.location;
      this.connectCluster = connectorName.connectCluster;
      this.connector = connectorName.connector;
    }

    public ConnectorName build() {
      return new ConnectorName(this);
    }
  }
}
