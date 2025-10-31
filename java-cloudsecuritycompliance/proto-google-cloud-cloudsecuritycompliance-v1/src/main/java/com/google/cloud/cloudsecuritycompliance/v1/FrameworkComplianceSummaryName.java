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

package com.google.cloud.cloudsecuritycompliance.v1;

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
public class FrameworkComplianceSummaryName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}");
  private static final PathTemplate FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}");
  private static final PathTemplate ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String frameworkComplianceSummary;
  private final String folder;
  private final String organization;

  @Deprecated
  protected FrameworkComplianceSummaryName() {
    project = null;
    location = null;
    frameworkComplianceSummary = null;
    folder = null;
    organization = null;
  }

  private FrameworkComplianceSummaryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceSummary =
        Preconditions.checkNotNull(builder.getFrameworkComplianceSummary());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY;
  }

  private FrameworkComplianceSummaryName(FolderLocationFrameworkComplianceSummaryBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceSummary =
        Preconditions.checkNotNull(builder.getFrameworkComplianceSummary());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY;
  }

  private FrameworkComplianceSummaryName(
      OrganizationLocationFrameworkComplianceSummaryBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceSummary =
        Preconditions.checkNotNull(builder.getFrameworkComplianceSummary());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFrameworkComplianceSummary() {
    return frameworkComplianceSummary;
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

  public static Builder newProjectLocationFrameworkComplianceSummaryBuilder() {
    return new Builder();
  }

  public static FolderLocationFrameworkComplianceSummaryBuilder
      newFolderLocationFrameworkComplianceSummaryBuilder() {
    return new FolderLocationFrameworkComplianceSummaryBuilder();
  }

  public static OrganizationLocationFrameworkComplianceSummaryBuilder
      newOrganizationLocationFrameworkComplianceSummaryBuilder() {
    return new OrganizationLocationFrameworkComplianceSummaryBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FrameworkComplianceSummaryName of(
      String project, String location, String frameworkComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build();
  }

  public static FrameworkComplianceSummaryName ofProjectLocationFrameworkComplianceSummaryName(
      String project, String location, String frameworkComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build();
  }

  public static FrameworkComplianceSummaryName ofFolderLocationFrameworkComplianceSummaryName(
      String folder, String location, String frameworkComplianceSummary) {
    return newFolderLocationFrameworkComplianceSummaryBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build();
  }

  public static FrameworkComplianceSummaryName ofOrganizationLocationFrameworkComplianceSummaryName(
      String organization, String location, String frameworkComplianceSummary) {
    return newOrganizationLocationFrameworkComplianceSummaryBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build();
  }

  public static String format(String project, String location, String frameworkComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build()
        .toString();
  }

  public static String formatProjectLocationFrameworkComplianceSummaryName(
      String project, String location, String frameworkComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build()
        .toString();
  }

  public static String formatFolderLocationFrameworkComplianceSummaryName(
      String folder, String location, String frameworkComplianceSummary) {
    return newFolderLocationFrameworkComplianceSummaryBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFrameworkComplianceSummaryName(
      String organization, String location, String frameworkComplianceSummary) {
    return newOrganizationLocationFrameworkComplianceSummaryBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkComplianceSummary(frameworkComplianceSummary)
        .build()
        .toString();
  }

  public static FrameworkComplianceSummaryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.match(formattedString);
      return ofProjectLocationFrameworkComplianceSummaryName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_summary"));
    } else if (FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.match(formattedString);
      return ofFolderLocationFrameworkComplianceSummaryName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_summary"));
    } else if (ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.match(formattedString);
      return ofOrganizationLocationFrameworkComplianceSummaryName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_summary"));
    }
    throw new ValidationException(
        "FrameworkComplianceSummaryName.parse: formattedString not in valid format");
  }

  public static List<FrameworkComplianceSummaryName> parseList(List<String> formattedStrings) {
    List<FrameworkComplianceSummaryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FrameworkComplianceSummaryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FrameworkComplianceSummaryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.matches(formattedString)
        || FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.matches(formattedString)
        || ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY.matches(formattedString);
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
          if (frameworkComplianceSummary != null) {
            fieldMapBuilder.put("framework_compliance_summary", frameworkComplianceSummary);
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
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FrameworkComplianceSummaryName that = ((FrameworkComplianceSummaryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.frameworkComplianceSummary, that.frameworkComplianceSummary)
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
    h ^= Objects.hashCode(frameworkComplianceSummary);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String frameworkComplianceSummary;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceSummary() {
      return frameworkComplianceSummary;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFrameworkComplianceSummary(String frameworkComplianceSummary) {
      this.frameworkComplianceSummary = frameworkComplianceSummary;
      return this;
    }

    private Builder(FrameworkComplianceSummaryName frameworkComplianceSummaryName) {
      Preconditions.checkArgument(
          Objects.equals(
              frameworkComplianceSummaryName.pathTemplate,
              PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_SUMMARY),
          "toBuilder is only supported when FrameworkComplianceSummaryName has the pattern of"
              + " projects/{project}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}");
      this.project = frameworkComplianceSummaryName.project;
      this.location = frameworkComplianceSummaryName.location;
      this.frameworkComplianceSummary = frameworkComplianceSummaryName.frameworkComplianceSummary;
    }

    public FrameworkComplianceSummaryName build() {
      return new FrameworkComplianceSummaryName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}.
   */
  public static class FolderLocationFrameworkComplianceSummaryBuilder {
    private String folder;
    private String location;
    private String frameworkComplianceSummary;

    protected FolderLocationFrameworkComplianceSummaryBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceSummary() {
      return frameworkComplianceSummary;
    }

    public FolderLocationFrameworkComplianceSummaryBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationFrameworkComplianceSummaryBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationFrameworkComplianceSummaryBuilder setFrameworkComplianceSummary(
        String frameworkComplianceSummary) {
      this.frameworkComplianceSummary = frameworkComplianceSummary;
      return this;
    }

    public FrameworkComplianceSummaryName build() {
      return new FrameworkComplianceSummaryName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/frameworkComplianceSummaries/{framework_compliance_summary}.
   */
  public static class OrganizationLocationFrameworkComplianceSummaryBuilder {
    private String organization;
    private String location;
    private String frameworkComplianceSummary;

    protected OrganizationLocationFrameworkComplianceSummaryBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceSummary() {
      return frameworkComplianceSummary;
    }

    public OrganizationLocationFrameworkComplianceSummaryBuilder setOrganization(
        String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationFrameworkComplianceSummaryBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationFrameworkComplianceSummaryBuilder setFrameworkComplianceSummary(
        String frameworkComplianceSummary) {
      this.frameworkComplianceSummary = frameworkComplianceSummary;
      return this;
    }

    public FrameworkComplianceSummaryName build() {
      return new FrameworkComplianceSummaryName(this);
    }
  }
}
