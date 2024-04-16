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
public class TableDataProfileName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_TABLE_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/tableDataProfiles/{table_data_profile}");
  private static final PathTemplate PROJECT_LOCATION_TABLE_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tableDataProfiles/{table_data_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String tableDataProfile;
  private final String project;

  @Deprecated
  protected TableDataProfileName() {
    organization = null;
    location = null;
    tableDataProfile = null;
    project = null;
  }

  private TableDataProfileName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    tableDataProfile = Preconditions.checkNotNull(builder.getTableDataProfile());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_TABLE_DATA_PROFILE;
  }

  private TableDataProfileName(ProjectLocationTableDataProfileBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tableDataProfile = Preconditions.checkNotNull(builder.getTableDataProfile());
    organization = null;
    pathTemplate = PROJECT_LOCATION_TABLE_DATA_PROFILE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getTableDataProfile() {
    return tableDataProfile;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationTableDataProfileBuilder() {
    return new Builder();
  }

  public static ProjectLocationTableDataProfileBuilder newProjectLocationTableDataProfileBuilder() {
    return new ProjectLocationTableDataProfileBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TableDataProfileName of(
      String organization, String location, String tableDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setTableDataProfile(tableDataProfile)
        .build();
  }

  public static TableDataProfileName ofOrganizationLocationTableDataProfileName(
      String organization, String location, String tableDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setTableDataProfile(tableDataProfile)
        .build();
  }

  public static TableDataProfileName ofProjectLocationTableDataProfileName(
      String project, String location, String tableDataProfile) {
    return newProjectLocationTableDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setTableDataProfile(tableDataProfile)
        .build();
  }

  public static String format(String organization, String location, String tableDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setTableDataProfile(tableDataProfile)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationTableDataProfileName(
      String organization, String location, String tableDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setTableDataProfile(tableDataProfile)
        .build()
        .toString();
  }

  public static String formatProjectLocationTableDataProfileName(
      String project, String location, String tableDataProfile) {
    return newProjectLocationTableDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setTableDataProfile(tableDataProfile)
        .build()
        .toString();
  }

  public static TableDataProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_TABLE_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_TABLE_DATA_PROFILE.match(formattedString);
      return ofOrganizationLocationTableDataProfileName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("table_data_profile"));
    } else if (PROJECT_LOCATION_TABLE_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_TABLE_DATA_PROFILE.match(formattedString);
      return ofProjectLocationTableDataProfileName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("table_data_profile"));
    }
    throw new ValidationException(
        "TableDataProfileName.parse: formattedString not in valid format");
  }

  public static List<TableDataProfileName> parseList(List<String> formattedStrings) {
    List<TableDataProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TableDataProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TableDataProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_TABLE_DATA_PROFILE.matches(formattedString)
        || PROJECT_LOCATION_TABLE_DATA_PROFILE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (tableDataProfile != null) {
            fieldMapBuilder.put("table_data_profile", tableDataProfile);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
      TableDataProfileName that = ((TableDataProfileName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.tableDataProfile, that.tableDataProfile)
          && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(tableDataProfile);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/tableDataProfiles/{table_data_profile}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String tableDataProfile;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getTableDataProfile() {
      return tableDataProfile;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTableDataProfile(String tableDataProfile) {
      this.tableDataProfile = tableDataProfile;
      return this;
    }

    private Builder(TableDataProfileName tableDataProfileName) {
      Preconditions.checkArgument(
          Objects.equals(
              tableDataProfileName.pathTemplate, ORGANIZATION_LOCATION_TABLE_DATA_PROFILE),
          "toBuilder is only supported when TableDataProfileName has the pattern of organizations/{organization}/locations/{location}/tableDataProfiles/{table_data_profile}");
      this.organization = tableDataProfileName.organization;
      this.location = tableDataProfileName.location;
      this.tableDataProfile = tableDataProfileName.tableDataProfile;
    }

    public TableDataProfileName build() {
      return new TableDataProfileName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/tableDataProfiles/{table_data_profile}. */
  public static class ProjectLocationTableDataProfileBuilder {
    private String project;
    private String location;
    private String tableDataProfile;

    protected ProjectLocationTableDataProfileBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTableDataProfile() {
      return tableDataProfile;
    }

    public ProjectLocationTableDataProfileBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationTableDataProfileBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationTableDataProfileBuilder setTableDataProfile(String tableDataProfile) {
      this.tableDataProfile = tableDataProfile;
      return this;
    }

    public TableDataProfileName build() {
      return new TableDataProfileName(this);
    }
  }
}
