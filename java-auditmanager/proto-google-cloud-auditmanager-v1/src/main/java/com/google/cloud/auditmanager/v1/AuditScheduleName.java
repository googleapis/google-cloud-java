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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class AuditScheduleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUDIT_SCHEDULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/auditSchedules/{audit_schedule}");
  private static final PathTemplate FOLDER_LOCATION_AUDIT_SCHEDULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/auditSchedules/{audit_schedule}");
  private static final PathTemplate ORGANIZATION_LOCATION_AUDIT_SCHEDULE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/auditSchedules/{audit_schedule}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String auditSchedule;
  private final String folder;
  private final String organization;

  @Deprecated
  protected AuditScheduleName() {
    project = null;
    location = null;
    auditSchedule = null;
    folder = null;
    organization = null;
  }

  private AuditScheduleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    auditSchedule = Preconditions.checkNotNull(builder.getAuditSchedule());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_AUDIT_SCHEDULE;
  }

  private AuditScheduleName(FolderLocationAuditScheduleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    auditSchedule = Preconditions.checkNotNull(builder.getAuditSchedule());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_AUDIT_SCHEDULE;
  }

  private AuditScheduleName(OrganizationLocationAuditScheduleBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    auditSchedule = Preconditions.checkNotNull(builder.getAuditSchedule());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_AUDIT_SCHEDULE;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAuditSchedule() {
    return auditSchedule;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationAuditScheduleBuilder() {
    return new Builder();
  }

  public static FolderLocationAuditScheduleBuilder newFolderLocationAuditScheduleBuilder() {
    return new FolderLocationAuditScheduleBuilder();
  }

  public static OrganizationLocationAuditScheduleBuilder
      newOrganizationLocationAuditScheduleBuilder() {
    return new OrganizationLocationAuditScheduleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AuditScheduleName of(String project, String location, String auditSchedule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build();
  }

  public static AuditScheduleName ofProjectLocationAuditScheduleName(
      String project, String location, String auditSchedule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build();
  }

  public static AuditScheduleName ofFolderLocationAuditScheduleName(
      String folder, String location, String auditSchedule) {
    return newFolderLocationAuditScheduleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build();
  }

  public static AuditScheduleName ofOrganizationLocationAuditScheduleName(
      String organization, String location, String auditSchedule) {
    return newOrganizationLocationAuditScheduleBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build();
  }

  public static String format(String project, String location, String auditSchedule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build()
        .toString();
  }

  public static String formatProjectLocationAuditScheduleName(
      String project, String location, String auditSchedule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build()
        .toString();
  }

  public static String formatFolderLocationAuditScheduleName(
      String folder, String location, String auditSchedule) {
    return newFolderLocationAuditScheduleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationAuditScheduleName(
      String organization, String location, String auditSchedule) {
    return newOrganizationLocationAuditScheduleBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAuditSchedule(auditSchedule)
        .build()
        .toString();
  }

  public static @Nullable AuditScheduleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_AUDIT_SCHEDULE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_AUDIT_SCHEDULE.match(formattedString);
      return ofProjectLocationAuditScheduleName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("audit_schedule"));
    } else if (FOLDER_LOCATION_AUDIT_SCHEDULE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_AUDIT_SCHEDULE.match(formattedString);
      return ofFolderLocationAuditScheduleName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("audit_schedule"));
    } else if (ORGANIZATION_LOCATION_AUDIT_SCHEDULE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_AUDIT_SCHEDULE.match(formattedString);
      return ofOrganizationLocationAuditScheduleName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("audit_schedule"));
    }
    throw new ValidationException("AuditScheduleName.parse: formattedString not in valid format");
  }

  public static List<AuditScheduleName> parseList(List<String> formattedStrings) {
    List<AuditScheduleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AuditScheduleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AuditScheduleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUDIT_SCHEDULE.matches(formattedString)
        || FOLDER_LOCATION_AUDIT_SCHEDULE.matches(formattedString)
        || ORGANIZATION_LOCATION_AUDIT_SCHEDULE.matches(formattedString);
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
          if (auditSchedule != null) {
            fieldMapBuilder.put("audit_schedule", auditSchedule);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AuditScheduleName that = ((AuditScheduleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.auditSchedule, that.auditSchedule)
          && Objects.equals(this.folder, that.folder)
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
    h ^= Objects.hashCode(auditSchedule);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/auditSchedules/{audit_schedule}. */
  public static class Builder {
    private String project;
    private String location;
    private String auditSchedule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAuditSchedule() {
      return auditSchedule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAuditSchedule(String auditSchedule) {
      this.auditSchedule = auditSchedule;
      return this;
    }

    private Builder(AuditScheduleName auditScheduleName) {
      Preconditions.checkArgument(
          Objects.equals(auditScheduleName.pathTemplate, PROJECT_LOCATION_AUDIT_SCHEDULE),
          "toBuilder is only supported when AuditScheduleName has the pattern of"
              + " projects/{project}/locations/{location}/auditSchedules/{audit_schedule}");
      this.project = auditScheduleName.project;
      this.location = auditScheduleName.location;
      this.auditSchedule = auditScheduleName.auditSchedule;
    }

    public AuditScheduleName build() {
      return new AuditScheduleName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/auditSchedules/{audit_schedule}. */
  public static class FolderLocationAuditScheduleBuilder {
    private String folder;
    private String location;
    private String auditSchedule;

    protected FolderLocationAuditScheduleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getAuditSchedule() {
      return auditSchedule;
    }

    public FolderLocationAuditScheduleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationAuditScheduleBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationAuditScheduleBuilder setAuditSchedule(String auditSchedule) {
      this.auditSchedule = auditSchedule;
      return this;
    }

    public AuditScheduleName build() {
      return new AuditScheduleName(this);
    }
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/auditSchedules/{audit_schedule}.
   */
  public static class OrganizationLocationAuditScheduleBuilder {
    private String organization;
    private String location;
    private String auditSchedule;

    protected OrganizationLocationAuditScheduleBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getAuditSchedule() {
      return auditSchedule;
    }

    public OrganizationLocationAuditScheduleBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationAuditScheduleBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationAuditScheduleBuilder setAuditSchedule(String auditSchedule) {
      this.auditSchedule = auditSchedule;
      return this;
    }

    public AuditScheduleName build() {
      return new AuditScheduleName(this);
    }
  }
}
