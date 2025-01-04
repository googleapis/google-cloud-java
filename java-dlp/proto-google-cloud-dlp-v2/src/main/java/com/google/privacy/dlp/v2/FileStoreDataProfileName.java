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
public class FileStoreDataProfileName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_FILE_STORE_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/fileStoreDataProfiles/{file_store_data_profile}");
  private static final PathTemplate PROJECT_LOCATION_FILE_STORE_DATA_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/fileStoreDataProfiles/{file_store_data_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String fileStoreDataProfile;
  private final String project;

  @Deprecated
  protected FileStoreDataProfileName() {
    organization = null;
    location = null;
    fileStoreDataProfile = null;
    project = null;
  }

  private FileStoreDataProfileName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    fileStoreDataProfile = Preconditions.checkNotNull(builder.getFileStoreDataProfile());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_FILE_STORE_DATA_PROFILE;
  }

  private FileStoreDataProfileName(ProjectLocationFileStoreDataProfileBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    fileStoreDataProfile = Preconditions.checkNotNull(builder.getFileStoreDataProfile());
    organization = null;
    pathTemplate = PROJECT_LOCATION_FILE_STORE_DATA_PROFILE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getFileStoreDataProfile() {
    return fileStoreDataProfile;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationFileStoreDataProfileBuilder() {
    return new Builder();
  }

  public static ProjectLocationFileStoreDataProfileBuilder
      newProjectLocationFileStoreDataProfileBuilder() {
    return new ProjectLocationFileStoreDataProfileBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FileStoreDataProfileName of(
      String organization, String location, String fileStoreDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFileStoreDataProfile(fileStoreDataProfile)
        .build();
  }

  public static FileStoreDataProfileName ofOrganizationLocationFileStoreDataProfileName(
      String organization, String location, String fileStoreDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFileStoreDataProfile(fileStoreDataProfile)
        .build();
  }

  public static FileStoreDataProfileName ofProjectLocationFileStoreDataProfileName(
      String project, String location, String fileStoreDataProfile) {
    return newProjectLocationFileStoreDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setFileStoreDataProfile(fileStoreDataProfile)
        .build();
  }

  public static String format(String organization, String location, String fileStoreDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFileStoreDataProfile(fileStoreDataProfile)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFileStoreDataProfileName(
      String organization, String location, String fileStoreDataProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFileStoreDataProfile(fileStoreDataProfile)
        .build()
        .toString();
  }

  public static String formatProjectLocationFileStoreDataProfileName(
      String project, String location, String fileStoreDataProfile) {
    return newProjectLocationFileStoreDataProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setFileStoreDataProfile(fileStoreDataProfile)
        .build()
        .toString();
  }

  public static FileStoreDataProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_FILE_STORE_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_FILE_STORE_DATA_PROFILE.match(formattedString);
      return ofOrganizationLocationFileStoreDataProfileName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("file_store_data_profile"));
    } else if (PROJECT_LOCATION_FILE_STORE_DATA_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_FILE_STORE_DATA_PROFILE.match(formattedString);
      return ofProjectLocationFileStoreDataProfileName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("file_store_data_profile"));
    }
    throw new ValidationException(
        "FileStoreDataProfileName.parse: formattedString not in valid format");
  }

  public static List<FileStoreDataProfileName> parseList(List<String> formattedStrings) {
    List<FileStoreDataProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FileStoreDataProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FileStoreDataProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_FILE_STORE_DATA_PROFILE.matches(formattedString)
        || PROJECT_LOCATION_FILE_STORE_DATA_PROFILE.matches(formattedString);
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
          if (fileStoreDataProfile != null) {
            fieldMapBuilder.put("file_store_data_profile", fileStoreDataProfile);
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
      FileStoreDataProfileName that = ((FileStoreDataProfileName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.fileStoreDataProfile, that.fileStoreDataProfile)
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
    h ^= Objects.hashCode(fileStoreDataProfile);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/fileStoreDataProfiles/{file_store_data_profile}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String fileStoreDataProfile;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFileStoreDataProfile() {
      return fileStoreDataProfile;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFileStoreDataProfile(String fileStoreDataProfile) {
      this.fileStoreDataProfile = fileStoreDataProfile;
      return this;
    }

    private Builder(FileStoreDataProfileName fileStoreDataProfileName) {
      Preconditions.checkArgument(
          Objects.equals(
              fileStoreDataProfileName.pathTemplate, ORGANIZATION_LOCATION_FILE_STORE_DATA_PROFILE),
          "toBuilder is only supported when FileStoreDataProfileName has the pattern of organizations/{organization}/locations/{location}/fileStoreDataProfiles/{file_store_data_profile}");
      this.organization = fileStoreDataProfileName.organization;
      this.location = fileStoreDataProfileName.location;
      this.fileStoreDataProfile = fileStoreDataProfileName.fileStoreDataProfile;
    }

    public FileStoreDataProfileName build() {
      return new FileStoreDataProfileName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/fileStoreDataProfiles/{file_store_data_profile}.
   */
  public static class ProjectLocationFileStoreDataProfileBuilder {
    private String project;
    private String location;
    private String fileStoreDataProfile;

    protected ProjectLocationFileStoreDataProfileBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFileStoreDataProfile() {
      return fileStoreDataProfile;
    }

    public ProjectLocationFileStoreDataProfileBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationFileStoreDataProfileBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationFileStoreDataProfileBuilder setFileStoreDataProfile(
        String fileStoreDataProfile) {
      this.fileStoreDataProfile = fileStoreDataProfile;
      return this;
    }

    public FileStoreDataProfileName build() {
      return new FileStoreDataProfileName(this);
    }
  }
}
