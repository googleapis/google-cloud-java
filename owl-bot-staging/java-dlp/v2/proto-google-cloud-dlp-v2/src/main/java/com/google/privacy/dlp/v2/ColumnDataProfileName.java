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
public class ColumnDataProfileName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_COLUMN_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/columnDataProfiles/{column_data_profile}");
  private static final PathTemplate PROJECT_LOCATION_COLUMN_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/columnDataProfiles/{column_data_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String columnDataProfile;
  private final String project;

  @Deprecated
  protected ColumnDataProfileName() {
    organization = null;
    location = null;
    columnDataProfile = null;
    project = null;
  }

  private ColumnDataProfileName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    columnDataProfile = Preconditions.checkNotNull(builder.getColumnDataProfile());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_COLUMN_DATA_PROFILE;
  }

  private ColumnDataProfileName(ProjectLocationColumnDataProfileBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    columnDataProfile = Preconditions.checkNotNull(builder.getColumnDataProfile());
    organization = null;
    pathTemplate = PROJECT_LOCATION_COLUMN_DATA_PROFILE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getColumnDataProfile() {
    return columnDataProfile;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationColumnDataProfileBuilder() {
    return new Builder();
  }

  public static ProjectLocationColumnDataProfileBuilder
      newProjectLocationColumnDataProfileBuilder() {
    return new ProjectLocationColumnDataProfileBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ColumnDataProfileName of(
      String organization, String location, String columnDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setColumnDataProfile(columnDataProfile)
        .build();
  }

  public static ColumnDataProfileName ofOrganizationLocationColumnDataProfileName(
      String organization, String location, String columnDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setColumnDataProfile(columnDataProfile)
        .build();
  }

  public static ColumnDataProfileName ofProjectLocationColumnDataProfileName(
      String project, String location, String columnDataProfile) {
    return newProjectLocationColumnDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setColumnDataProfile(columnDataProfile)
        .build();
  }

  public static String format(String organization, String location, String columnDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setColumnDataProfile(columnDataProfile)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationColumnDataProfileName(
      String organization, String location, String columnDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setColumnDataProfile(columnDataProfile)
        .build()
        .toString();
  }

  public static String formatProjectLocationColumnDataProfileName(
      String project, String location, String columnDataProfile) {
    return newProjectLocationColumnDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setColumnDataProfile(columnDataProfile)
        .build()
        .toString();
  }

  public static ColumnDataProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_COLUMN_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_COLUMN_DATA_PROFILE.match(formattedString);
      return ofOrganizationLocationColumnDataProfileName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("column_data_profile"));
    } else if (PROJECT_LOCATION_COLUMN_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_COLUMN_DATA_PROFILE.match(formattedString);
      return ofProjectLocationColumnDataProfileName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("column_data_profile"));
    }
    throw new ValidationException(
        "ColumnDataProfileName.parse: formattedString not in valid format");
  }

  public static List<ColumnDataProfileName> parseList(List<String> formattedStrings) {
    List<ColumnDataProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ColumnDataProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ColumnDataProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_COLUMN_DATA_PROFILE.matches(formattedString)
        || PROJECT_LOCATION_COLUMN_DATA_PROFILE.matches(formattedString);
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
          if (columnDataProfile != null) {
            fieldMapBuilder.put("column_data_profile", columnDataProfile);
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
      ColumnDataProfileName that = ((ColumnDataProfileName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.columnDataProfile, that.columnDataProfile)
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
    h ^= Objects.hashCode(columnDataProfile);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/columnDataProfiles/{column_data_profile}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String columnDataProfile;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getColumnDataProfile() {
      return columnDataProfile;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setColumnDataProfile(String columnDataProfile) {
      this.columnDataProfile = columnDataProfile;
      return this;
    }

    private Builder(ColumnDataProfileName columnDataProfileName) {
      Preconditions.checkArgument(
          Objects.equals(
              columnDataProfileName.pathTemplate, ORGANIZATION_LOCATION_COLUMN_DATA_PROFILE),
          "toBuilder is only supported when ColumnDataProfileName has the pattern of organizations/{organization}/locations/{location}/columnDataProfiles/{column_data_profile}");
      this.organization = columnDataProfileName.organization;
      this.location = columnDataProfileName.location;
      this.columnDataProfile = columnDataProfileName.columnDataProfile;
    }

    public ColumnDataProfileName build() {
      return new ColumnDataProfileName(this);
    }
  }

  /**
   * Builder for projects/{project}/locations/{location}/columnDataProfiles/{column_data_profile}.
   */
  public static class ProjectLocationColumnDataProfileBuilder {
    private String project;
    private String location;
    private String columnDataProfile;

    protected ProjectLocationColumnDataProfileBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getColumnDataProfile() {
      return columnDataProfile;
    }

    public ProjectLocationColumnDataProfileBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationColumnDataProfileBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationColumnDataProfileBuilder setColumnDataProfile(String columnDataProfile) {
      this.columnDataProfile = columnDataProfile;
      return this;
    }

    public ColumnDataProfileName build() {
      return new ColumnDataProfileName(this);
    }
  }
}
