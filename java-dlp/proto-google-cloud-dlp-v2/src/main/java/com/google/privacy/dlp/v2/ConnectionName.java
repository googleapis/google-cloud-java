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

package com.google.privacy.dlp.v2;

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
public class ConnectionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONNECTION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/connections/{connection}");
  private static final PathTemplate ORGANIZATION_LOCATION_CONNECTION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/connections/{connection}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String connection;
  private final String organization;

  @Deprecated
  protected ConnectionName() {
    project = null;
    location = null;
    connection = null;
    organization = null;
  }

  private ConnectionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    connection = Preconditions.checkNotNull(builder.getConnection());
    organization = null;
    pathTemplate = PROJECT_LOCATION_CONNECTION;
  }

  private ConnectionName(OrganizationLocationConnectionBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    connection = Preconditions.checkNotNull(builder.getConnection());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_CONNECTION;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getConnection() {
    return connection;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationConnectionBuilder() {
    return new Builder();
  }

  public static OrganizationLocationConnectionBuilder newOrganizationLocationConnectionBuilder() {
    return new OrganizationLocationConnectionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConnectionName of(String project, String location, String connection) {
    return newBuilder().setProject(project).setLocation(location).setConnection(connection).build();
  }

  public static ConnectionName ofProjectLocationConnectionName(
      String project, String location, String connection) {
    return newBuilder().setProject(project).setLocation(location).setConnection(connection).build();
  }

  public static ConnectionName ofOrganizationLocationConnectionName(
      String organization, String location, String connection) {
    return newOrganizationLocationConnectionBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setConnection(connection)
        .build();
  }

  public static String format(String project, String location, String connection) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConnection(connection)
        .build()
        .toString();
  }

  public static String formatProjectLocationConnectionName(
      String project, String location, String connection) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConnection(connection)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationConnectionName(
      String organization, String location, String connection) {
    return newOrganizationLocationConnectionBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setConnection(connection)
        .build()
        .toString();
  }

  public static ConnectionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_CONNECTION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CONNECTION.match(formattedString);
      return ofProjectLocationConnectionName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("connection"));
    } else if (ORGANIZATION_LOCATION_CONNECTION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_CONNECTION.match(formattedString);
      return ofOrganizationLocationConnectionName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("connection"));
    }
    throw new ValidationException("ConnectionName.parse: formattedString not in valid format");
  }

  public static List<ConnectionName> parseList(List<String> formattedStrings) {
    List<ConnectionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConnectionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConnectionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONNECTION.matches(formattedString)
        || ORGANIZATION_LOCATION_CONNECTION.matches(formattedString);
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
          if (connection != null) {
            fieldMapBuilder.put("connection", connection);
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
      ConnectionName that = ((ConnectionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.connection, that.connection)
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
    h ^= Objects.hashCode(connection);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/connections/{connection}. */
  public static class Builder {
    private String project;
    private String location;
    private String connection;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConnection() {
      return connection;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setConnection(String connection) {
      this.connection = connection;
      return this;
    }

    private Builder(ConnectionName connectionName) {
      Preconditions.checkArgument(
          Objects.equals(connectionName.pathTemplate, PROJECT_LOCATION_CONNECTION),
          "toBuilder is only supported when ConnectionName has the pattern of projects/{project}/locations/{location}/connections/{connection}");
      this.project = connectionName.project;
      this.location = connectionName.location;
      this.connection = connectionName.connection;
    }

    public ConnectionName build() {
      return new ConnectionName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/connections/{connection}. */
  public static class OrganizationLocationConnectionBuilder {
    private String organization;
    private String location;
    private String connection;

    protected OrganizationLocationConnectionBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getConnection() {
      return connection;
    }

    public OrganizationLocationConnectionBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationConnectionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationConnectionBuilder setConnection(String connection) {
      this.connection = connection;
      return this;
    }

    public ConnectionName build() {
      return new ConnectionName(this);
    }
  }
}
