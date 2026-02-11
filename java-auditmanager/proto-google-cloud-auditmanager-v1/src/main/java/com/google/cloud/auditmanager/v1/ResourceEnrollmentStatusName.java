/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.auditmanager.v1;

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
public class ResourceEnrollmentStatusName implements ResourceName {
  private static final PathTemplate FOLDER_LOCATION_RESOURCE_ENROLLMENT_STATUS =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}");
  private static final PathTemplate PROJECT_LOCATION_RESOURCE_ENROLLMENT_STATUS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}");
  private static final PathTemplate ORGANIZATION_LOCATION_RESOURCE_ENROLLMENT_STATUS =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String folder;
  private final String location;
  private final String resourceEnrollmentStatus;
  private final String project;
  private final String organization;

  @Deprecated
  protected ResourceEnrollmentStatusName() {
    folder = null;
    location = null;
    resourceEnrollmentStatus = null;
    project = null;
    organization = null;
  }

  private ResourceEnrollmentStatusName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    resourceEnrollmentStatus = Preconditions.checkNotNull(builder.getResourceEnrollmentStatus());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_RESOURCE_ENROLLMENT_STATUS;
  }

  private ResourceEnrollmentStatusName(ProjectLocationResourceEnrollmentStatusBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    resourceEnrollmentStatus = Preconditions.checkNotNull(builder.getResourceEnrollmentStatus());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_RESOURCE_ENROLLMENT_STATUS;
  }

  private ResourceEnrollmentStatusName(
      OrganizationLocationResourceEnrollmentStatusBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    resourceEnrollmentStatus = Preconditions.checkNotNull(builder.getResourceEnrollmentStatus());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_RESOURCE_ENROLLMENT_STATUS;
  }

  public String getFolder() {
    return folder;
  }

  public String getLocation() {
    return location;
  }

  public String getResourceEnrollmentStatus() {
    return resourceEnrollmentStatus;
  }

  public String getProject() {
    return project;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newFolderLocationResourceEnrollmentStatusBuilder() {
    return new Builder();
  }

  public static ProjectLocationResourceEnrollmentStatusBuilder
      newProjectLocationResourceEnrollmentStatusBuilder() {
    return new ProjectLocationResourceEnrollmentStatusBuilder();
  }

  public static OrganizationLocationResourceEnrollmentStatusBuilder
      newOrganizationLocationResourceEnrollmentStatusBuilder() {
    return new OrganizationLocationResourceEnrollmentStatusBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ResourceEnrollmentStatusName of(
      String folder, String location, String resourceEnrollmentStatus) {
    return newBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build();
  }

  public static ResourceEnrollmentStatusName ofFolderLocationResourceEnrollmentStatusName(
      String folder, String location, String resourceEnrollmentStatus) {
    return newBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build();
  }

  public static ResourceEnrollmentStatusName ofProjectLocationResourceEnrollmentStatusName(
      String project, String location, String resourceEnrollmentStatus) {
    return newProjectLocationResourceEnrollmentStatusBuilder()
        .setProject(project)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build();
  }

  public static ResourceEnrollmentStatusName ofOrganizationLocationResourceEnrollmentStatusName(
      String organization, String location, String resourceEnrollmentStatus) {
    return newOrganizationLocationResourceEnrollmentStatusBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build();
  }

  public static String format(String folder, String location, String resourceEnrollmentStatus) {
    return newBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build()
        .toString();
  }

  public static String formatFolderLocationResourceEnrollmentStatusName(
      String folder, String location, String resourceEnrollmentStatus) {
    return newBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build()
        .toString();
  }

  public static String formatProjectLocationResourceEnrollmentStatusName(
      String project, String location, String resourceEnrollmentStatus) {
    return newProjectLocationResourceEnrollmentStatusBuilder()
        .setProject(project)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationResourceEnrollmentStatusName(
      String organization, String location, String resourceEnrollmentStatus) {
    return newOrganizationLocationResourceEnrollmentStatusBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setResourceEnrollmentStatus(resourceEnrollmentStatus)
        .build()
        .toString();
  }

  public static ResourceEnrollmentStatusName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (FOLDER_LOCATION_RESOURCE_ENROLLMENT_STATUS.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_RESOURCE_ENROLLMENT_STATUS.match(formattedString);
      return ofFolderLocationResourceEnrollmentStatusName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("resource_enrollment_status"));
    } else if (PROJECT_LOCATION_RESOURCE_ENROLLMENT_STATUS.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_RESOURCE_ENROLLMENT_STATUS.match(formattedString);
      return ofProjectLocationResourceEnrollmentStatusName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("resource_enrollment_status"));
    } else if (ORGANIZATION_LOCATION_RESOURCE_ENROLLMENT_STATUS.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_RESOURCE_ENROLLMENT_STATUS.match(formattedString);
      return ofOrganizationLocationResourceEnrollmentStatusName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("resource_enrollment_status"));
    }
    throw new ValidationException(
        "ResourceEnrollmentStatusName.parse: formattedString not in valid format");
  }

  public static List<ResourceEnrollmentStatusName> parseList(List<String> formattedStrings) {
    List<ResourceEnrollmentStatusName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ResourceEnrollmentStatusName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ResourceEnrollmentStatusName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return FOLDER_LOCATION_RESOURCE_ENROLLMENT_STATUS.matches(formattedString)
        || PROJECT_LOCATION_RESOURCE_ENROLLMENT_STATUS.matches(formattedString)
        || ORGANIZATION_LOCATION_RESOURCE_ENROLLMENT_STATUS.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (resourceEnrollmentStatus != null) {
            fieldMapBuilder.put("resource_enrollment_status", resourceEnrollmentStatus);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
      ResourceEnrollmentStatusName that = ((ResourceEnrollmentStatusName) o);
      return Objects.equals(this.folder, that.folder)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.resourceEnrollmentStatus, that.resourceEnrollmentStatus)
          && Objects.equals(this.project, that.project)
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(resourceEnrollmentStatus);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}.
   */
  public static class Builder {
    private String folder;
    private String location;
    private String resourceEnrollmentStatus;

    protected Builder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getResourceEnrollmentStatus() {
      return resourceEnrollmentStatus;
    }

    public Builder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setResourceEnrollmentStatus(String resourceEnrollmentStatus) {
      this.resourceEnrollmentStatus = resourceEnrollmentStatus;
      return this;
    }

    private Builder(ResourceEnrollmentStatusName resourceEnrollmentStatusName) {
      Preconditions.checkArgument(
          Objects.equals(
              resourceEnrollmentStatusName.pathTemplate,
              FOLDER_LOCATION_RESOURCE_ENROLLMENT_STATUS),
          "toBuilder is only supported when ResourceEnrollmentStatusName has the pattern of"
              + " folders/{folder}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}");
      this.folder = resourceEnrollmentStatusName.folder;
      this.location = resourceEnrollmentStatusName.location;
      this.resourceEnrollmentStatus = resourceEnrollmentStatusName.resourceEnrollmentStatus;
    }

    public ResourceEnrollmentStatusName build() {
      return new ResourceEnrollmentStatusName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}.
   */
  public static class ProjectLocationResourceEnrollmentStatusBuilder {
    private String project;
    private String location;
    private String resourceEnrollmentStatus;

    protected ProjectLocationResourceEnrollmentStatusBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getResourceEnrollmentStatus() {
      return resourceEnrollmentStatus;
    }

    public ProjectLocationResourceEnrollmentStatusBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationResourceEnrollmentStatusBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationResourceEnrollmentStatusBuilder setResourceEnrollmentStatus(
        String resourceEnrollmentStatus) {
      this.resourceEnrollmentStatus = resourceEnrollmentStatus;
      return this;
    }

    public ResourceEnrollmentStatusName build() {
      return new ResourceEnrollmentStatusName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/resourceEnrollmentStatuses/{resource_enrollment_status}.
   */
  public static class OrganizationLocationResourceEnrollmentStatusBuilder {
    private String organization;
    private String location;
    private String resourceEnrollmentStatus;

    protected OrganizationLocationResourceEnrollmentStatusBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getResourceEnrollmentStatus() {
      return resourceEnrollmentStatus;
    }

    public OrganizationLocationResourceEnrollmentStatusBuilder setOrganization(
        String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationResourceEnrollmentStatusBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationResourceEnrollmentStatusBuilder setResourceEnrollmentStatus(
        String resourceEnrollmentStatus) {
      this.resourceEnrollmentStatus = resourceEnrollmentStatus;
      return this;
    }

    public ResourceEnrollmentStatusName build() {
      return new ResourceEnrollmentStatusName(this);
    }
  }
}
