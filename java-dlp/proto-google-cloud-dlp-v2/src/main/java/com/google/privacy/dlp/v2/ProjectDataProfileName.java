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
public class ProjectDataProfileName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_PROJECT_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/projectDataProfiles/{project_data_profile}");
  private static final PathTemplate PROJECT_LOCATION_PROJECT_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/projectDataProfiles/{project_data_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String projectDataProfile;
  private final String project;

  @Deprecated
  protected ProjectDataProfileName() {
    organization = null;
    location = null;
    projectDataProfile = null;
    project = null;
  }

  private ProjectDataProfileName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    projectDataProfile = Preconditions.checkNotNull(builder.getProjectDataProfile());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_PROJECT_DATA_PROFILE;
  }

  private ProjectDataProfileName(ProjectLocationProjectDataProfileBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    projectDataProfile = Preconditions.checkNotNull(builder.getProjectDataProfile());
    organization = null;
    pathTemplate = PROJECT_LOCATION_PROJECT_DATA_PROFILE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getProjectDataProfile() {
    return projectDataProfile;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationProjectDataProfileBuilder() {
    return new Builder();
  }

  public static ProjectLocationProjectDataProfileBuilder
      newProjectLocationProjectDataProfileBuilder() {
    return new ProjectLocationProjectDataProfileBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProjectDataProfileName of(
      String organization, String location, String projectDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setProjectDataProfile(projectDataProfile)
        .build();
  }

  public static ProjectDataProfileName ofOrganizationLocationProjectDataProfileName(
      String organization, String location, String projectDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setProjectDataProfile(projectDataProfile)
        .build();
  }

  public static ProjectDataProfileName ofProjectLocationProjectDataProfileName(
      String project, String location, String projectDataProfile) {
    return newProjectLocationProjectDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setProjectDataProfile(projectDataProfile)
        .build();
  }

  public static String format(String organization, String location, String projectDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setProjectDataProfile(projectDataProfile)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationProjectDataProfileName(
      String organization, String location, String projectDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setProjectDataProfile(projectDataProfile)
        .build()
        .toString();
  }

  public static String formatProjectLocationProjectDataProfileName(
      String project, String location, String projectDataProfile) {
    return newProjectLocationProjectDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setProjectDataProfile(projectDataProfile)
        .build()
        .toString();
  }

  public static ProjectDataProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_PROJECT_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_PROJECT_DATA_PROFILE.match(formattedString);
      return ofOrganizationLocationProjectDataProfileName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("project_data_profile"));
    } else if (PROJECT_LOCATION_PROJECT_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_PROJECT_DATA_PROFILE.match(formattedString);
      return ofProjectLocationProjectDataProfileName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("project_data_profile"));
    }
    throw new ValidationException(
        "ProjectDataProfileName.parse: formattedString not in valid format");
  }

  public static List<ProjectDataProfileName> parseList(List<String> formattedStrings) {
    List<ProjectDataProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectDataProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProjectDataProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_PROJECT_DATA_PROFILE.matches(formattedString)
        || PROJECT_LOCATION_PROJECT_DATA_PROFILE.matches(formattedString);
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
          if (projectDataProfile != null) {
            fieldMapBuilder.put("project_data_profile", projectDataProfile);
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
      ProjectDataProfileName that = ((ProjectDataProfileName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.projectDataProfile, that.projectDataProfile)
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
    h ^= Objects.hashCode(projectDataProfile);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/projectDataProfiles/{project_data_profile}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String projectDataProfile;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getProjectDataProfile() {
      return projectDataProfile;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setProjectDataProfile(String projectDataProfile) {
      this.projectDataProfile = projectDataProfile;
      return this;
    }

    private Builder(ProjectDataProfileName projectDataProfileName) {
      Preconditions.checkArgument(
          Objects.equals(
              projectDataProfileName.pathTemplate, ORGANIZATION_LOCATION_PROJECT_DATA_PROFILE),
          "toBuilder is only supported when ProjectDataProfileName has the pattern of organizations/{organization}/locations/{location}/projectDataProfiles/{project_data_profile}");
      this.organization = projectDataProfileName.organization;
      this.location = projectDataProfileName.location;
      this.projectDataProfile = projectDataProfileName.projectDataProfile;
    }

    public ProjectDataProfileName build() {
      return new ProjectDataProfileName(this);
    }
  }

  /**
   * Builder for projects/{project}/locations/{location}/projectDataProfiles/{project_data_profile}.
   */
  public static class ProjectLocationProjectDataProfileBuilder {
    private String project;
    private String location;
    private String projectDataProfile;

    protected ProjectLocationProjectDataProfileBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getProjectDataProfile() {
      return projectDataProfile;
    }

    public ProjectLocationProjectDataProfileBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationProjectDataProfileBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationProjectDataProfileBuilder setProjectDataProfile(
        String projectDataProfile) {
      this.projectDataProfile = projectDataProfile;
      return this;
    }

    public ProjectDataProfileName build() {
      return new ProjectDataProfileName(this);
    }
  }
}
