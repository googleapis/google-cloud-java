/*
 * Copyright 2020 Google LLC
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

package com.google.privacy.dlp.v2;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class StoredInfoTypeName implements ResourceName {

  @Deprecated
  protected StoredInfoTypeName() {}

  private static final PathTemplate ORGANIZATION_STORED_INFO_TYPE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/storedInfoTypes/{stored_info_type}");
  private static final PathTemplate PROJECT_STORED_INFO_TYPE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/storedInfoTypes/{stored_info_type}");
  private static final PathTemplate ORGANIZATION_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/storedInfoTypes/{stored_info_type}");
  private static final PathTemplate PROJECT_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/storedInfoTypes/{stored_info_type}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String organization;
  private String storedInfoType;
  private String project;
  private String location;

  public String getOrganization() {
    return organization;
  }

  public String getStoredInfoType() {
    return storedInfoType;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  private StoredInfoTypeName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    storedInfoType = Preconditions.checkNotNull(builder.getStoredInfoType());
    pathTemplate = ORGANIZATION_STORED_INFO_TYPE_PATH_TEMPLATE;
  }

  private StoredInfoTypeName(ProjectStoredInfoTypeBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    storedInfoType = Preconditions.checkNotNull(builder.getStoredInfoType());
    pathTemplate = PROJECT_STORED_INFO_TYPE_PATH_TEMPLATE;
  }

  private StoredInfoTypeName(OrganizationLocationStoredInfoTypeBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    storedInfoType = Preconditions.checkNotNull(builder.getStoredInfoType());
    pathTemplate = ORGANIZATION_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE;
  }

  private StoredInfoTypeName(ProjectLocationStoredInfoTypeBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    storedInfoType = Preconditions.checkNotNull(builder.getStoredInfoType());
    pathTemplate = PROJECT_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationStoredInfoTypeBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectStoredInfoTypeBuilder newProjectStoredInfoTypeBuilder() {
    return new ProjectStoredInfoTypeBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationStoredInfoTypeBuilder
      newOrganizationLocationStoredInfoTypeBuilder() {
    return new OrganizationLocationStoredInfoTypeBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationStoredInfoTypeBuilder newProjectLocationStoredInfoTypeBuilder() {
    return new ProjectLocationStoredInfoTypeBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static StoredInfoTypeName of(String organization, String storedInfoType) {
    return newOrganizationStoredInfoTypeBuilder()
        .setOrganization(organization)
        .setStoredInfoType(storedInfoType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static StoredInfoTypeName ofOrganizationStoredInfoTypeName(
      String organization, String storedInfoType) {
    return newOrganizationStoredInfoTypeBuilder()
        .setOrganization(organization)
        .setStoredInfoType(storedInfoType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static StoredInfoTypeName ofProjectStoredInfoTypeName(
      String project, String storedInfoType) {
    return newProjectStoredInfoTypeBuilder()
        .setProject(project)
        .setStoredInfoType(storedInfoType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static StoredInfoTypeName ofOrganizationLocationStoredInfoTypeName(
      String organization, String location, String storedInfoType) {
    return newOrganizationLocationStoredInfoTypeBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setStoredInfoType(storedInfoType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static StoredInfoTypeName ofProjectLocationStoredInfoTypeName(
      String project, String location, String storedInfoType) {
    return newProjectLocationStoredInfoTypeBuilder()
        .setProject(project)
        .setLocation(location)
        .setStoredInfoType(storedInfoType)
        .build();
  }

  public static String format(String organization, String storedInfoType) {
    return newBuilder()
        .setOrganization(organization)
        .setStoredInfoType(storedInfoType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationStoredInfoTypeName(
      String organization, String storedInfoType) {
    return newBuilder()
        .setOrganization(organization)
        .setStoredInfoType(storedInfoType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectStoredInfoTypeName(String project, String storedInfoType) {
    return newProjectStoredInfoTypeBuilder()
        .setProject(project)
        .setStoredInfoType(storedInfoType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationStoredInfoTypeName(
      String organization, String location, String storedInfoType) {
    return newOrganizationLocationStoredInfoTypeBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setStoredInfoType(storedInfoType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationStoredInfoTypeName(
      String project, String location, String storedInfoType) {
    return newProjectLocationStoredInfoTypeBuilder()
        .setProject(project)
        .setLocation(location)
        .setStoredInfoType(storedInfoType)
        .build()
        .toString();
  }

  public static StoredInfoTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_STORED_INFO_TYPE_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationStoredInfoTypeName(
          matchMap.get("organization"), matchMap.get("stored_info_type"));
    } else if (PROJECT_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_STORED_INFO_TYPE_PATH_TEMPLATE.match(formattedString);
      return ofProjectStoredInfoTypeName(matchMap.get("project"), matchMap.get("stored_info_type"));
    } else if (ORGANIZATION_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationLocationStoredInfoTypeName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("stored_info_type"));
    } else if (PROJECT_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationStoredInfoTypeName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("stored_info_type"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)
        || ORGANIZATION_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_STORED_INFO_TYPE_PATH_TEMPLATE.matches(formattedString);
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
          if (storedInfoType != null) {
            fieldMapBuilder.put("stored_info_type", storedInfoType);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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

  /** Builder for organizations/{organization}/storedInfoTypes/{stored_info_type}. */
  public static class Builder {

    private String organization;
    private String storedInfoType;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getStoredInfoType() {
      return storedInfoType;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setStoredInfoType(String storedInfoType) {
      this.storedInfoType = storedInfoType;
      return this;
    }

    private Builder(StoredInfoTypeName storedInfoTypeName) {
      Preconditions.checkArgument(
          storedInfoTypeName.pathTemplate == ORGANIZATION_STORED_INFO_TYPE_PATH_TEMPLATE,
          "toBuilder is only supported when StoredInfoTypeName has the pattern of "
              + "organizations/{organization}/storedInfoTypes/{stored_info_type}.");
      organization = storedInfoTypeName.organization;
      storedInfoType = storedInfoTypeName.storedInfoType;
    }

    public StoredInfoTypeName build() {
      return new StoredInfoTypeName(this);
    }
  }

  /** Builder for projects/{project}/storedInfoTypes/{stored_info_type}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectStoredInfoTypeBuilder {

    private String project;
    private String storedInfoType;

    private ProjectStoredInfoTypeBuilder() {}

    public String getProject() {
      return project;
    }

    public String getStoredInfoType() {
      return storedInfoType;
    }

    public ProjectStoredInfoTypeBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectStoredInfoTypeBuilder setStoredInfoType(String storedInfoType) {
      this.storedInfoType = storedInfoType;
      return this;
    }

    public StoredInfoTypeName build() {
      return new StoredInfoTypeName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/storedInfoTypes/{stored_info_type}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationStoredInfoTypeBuilder {

    private String organization;
    private String location;
    private String storedInfoType;

    private OrganizationLocationStoredInfoTypeBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getStoredInfoType() {
      return storedInfoType;
    }

    public OrganizationLocationStoredInfoTypeBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationStoredInfoTypeBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationStoredInfoTypeBuilder setStoredInfoType(String storedInfoType) {
      this.storedInfoType = storedInfoType;
      return this;
    }

    public StoredInfoTypeName build() {
      return new StoredInfoTypeName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/storedInfoTypes/{stored_info_type}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationStoredInfoTypeBuilder {

    private String project;
    private String location;
    private String storedInfoType;

    private ProjectLocationStoredInfoTypeBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getStoredInfoType() {
      return storedInfoType;
    }

    public ProjectLocationStoredInfoTypeBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationStoredInfoTypeBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationStoredInfoTypeBuilder setStoredInfoType(String storedInfoType) {
      this.storedInfoType = storedInfoType;
      return this;
    }

    public StoredInfoTypeName build() {
      return new StoredInfoTypeName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      StoredInfoTypeName that = (StoredInfoTypeName) o;
      return (Objects.equals(this.organization, that.organization))
          && (Objects.equals(this.storedInfoType, that.storedInfoType))
          && (Objects.equals(this.project, that.project))
          && (Objects.equals(this.location, that.location));
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
    h ^= Objects.hashCode(storedInfoType);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }
}
