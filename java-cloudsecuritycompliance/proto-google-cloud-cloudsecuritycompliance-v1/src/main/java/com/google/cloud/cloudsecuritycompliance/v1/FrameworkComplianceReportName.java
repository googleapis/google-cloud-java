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
public class FrameworkComplianceReportName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}");
  private static final PathTemplate FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}");
  private static final PathTemplate ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String frameworkComplianceReport;
  private final String folder;
  private final String organization;

  @Deprecated
  protected FrameworkComplianceReportName() {
    project = null;
    location = null;
    frameworkComplianceReport = null;
    folder = null;
    organization = null;
  }

  private FrameworkComplianceReportName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceReport = Preconditions.checkNotNull(builder.getFrameworkComplianceReport());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT;
  }

  private FrameworkComplianceReportName(FolderLocationFrameworkComplianceReportBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceReport = Preconditions.checkNotNull(builder.getFrameworkComplianceReport());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT;
  }

  private FrameworkComplianceReportName(
      OrganizationLocationFrameworkComplianceReportBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceReport = Preconditions.checkNotNull(builder.getFrameworkComplianceReport());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFrameworkComplianceReport() {
    return frameworkComplianceReport;
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

  public static Builder newProjectLocationFrameworkComplianceReportBuilder() {
    return new Builder();
  }

  public static FolderLocationFrameworkComplianceReportBuilder
      newFolderLocationFrameworkComplianceReportBuilder() {
    return new FolderLocationFrameworkComplianceReportBuilder();
  }

  public static OrganizationLocationFrameworkComplianceReportBuilder
      newOrganizationLocationFrameworkComplianceReportBuilder() {
    return new OrganizationLocationFrameworkComplianceReportBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FrameworkComplianceReportName of(
      String project, String location, String frameworkComplianceReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build();
  }

  public static FrameworkComplianceReportName ofProjectLocationFrameworkComplianceReportName(
      String project, String location, String frameworkComplianceReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build();
  }

  public static FrameworkComplianceReportName ofFolderLocationFrameworkComplianceReportName(
      String folder, String location, String frameworkComplianceReport) {
    return newFolderLocationFrameworkComplianceReportBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build();
  }

  public static FrameworkComplianceReportName ofOrganizationLocationFrameworkComplianceReportName(
      String organization, String location, String frameworkComplianceReport) {
    return newOrganizationLocationFrameworkComplianceReportBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build();
  }

  public static String format(String project, String location, String frameworkComplianceReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build()
        .toString();
  }

  public static String formatProjectLocationFrameworkComplianceReportName(
      String project, String location, String frameworkComplianceReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build()
        .toString();
  }

  public static String formatFolderLocationFrameworkComplianceReportName(
      String folder, String location, String frameworkComplianceReport) {
    return newFolderLocationFrameworkComplianceReportBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFrameworkComplianceReportName(
      String organization, String location, String frameworkComplianceReport) {
    return newOrganizationLocationFrameworkComplianceReportBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .build()
        .toString();
  }

  public static FrameworkComplianceReportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.match(formattedString);
      return ofProjectLocationFrameworkComplianceReportName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_report"));
    } else if (FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.match(formattedString);
      return ofFolderLocationFrameworkComplianceReportName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_report"));
    } else if (ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.match(formattedString);
      return ofOrganizationLocationFrameworkComplianceReportName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_report"));
    }
    throw new ValidationException(
        "FrameworkComplianceReportName.parse: formattedString not in valid format");
  }

  public static List<FrameworkComplianceReportName> parseList(List<String> formattedStrings) {
    List<FrameworkComplianceReportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FrameworkComplianceReportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FrameworkComplianceReportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.matches(formattedString)
        || FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.matches(formattedString)
        || ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT.matches(formattedString);
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
          if (frameworkComplianceReport != null) {
            fieldMapBuilder.put("framework_compliance_report", frameworkComplianceReport);
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
      FrameworkComplianceReportName that = ((FrameworkComplianceReportName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.frameworkComplianceReport, that.frameworkComplianceReport)
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
    h ^= Objects.hashCode(frameworkComplianceReport);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String frameworkComplianceReport;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceReport() {
      return frameworkComplianceReport;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFrameworkComplianceReport(String frameworkComplianceReport) {
      this.frameworkComplianceReport = frameworkComplianceReport;
      return this;
    }

    private Builder(FrameworkComplianceReportName frameworkComplianceReportName) {
      Preconditions.checkArgument(
          Objects.equals(
              frameworkComplianceReportName.pathTemplate,
              PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT),
          "toBuilder is only supported when FrameworkComplianceReportName has the pattern of"
              + " projects/{project}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}");
      this.project = frameworkComplianceReportName.project;
      this.location = frameworkComplianceReportName.location;
      this.frameworkComplianceReport = frameworkComplianceReportName.frameworkComplianceReport;
    }

    public FrameworkComplianceReportName build() {
      return new FrameworkComplianceReportName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}.
   */
  public static class FolderLocationFrameworkComplianceReportBuilder {
    private String folder;
    private String location;
    private String frameworkComplianceReport;

    protected FolderLocationFrameworkComplianceReportBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceReport() {
      return frameworkComplianceReport;
    }

    public FolderLocationFrameworkComplianceReportBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationFrameworkComplianceReportBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationFrameworkComplianceReportBuilder setFrameworkComplianceReport(
        String frameworkComplianceReport) {
      this.frameworkComplianceReport = frameworkComplianceReport;
      return this;
    }

    public FrameworkComplianceReportName build() {
      return new FrameworkComplianceReportName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}.
   */
  public static class OrganizationLocationFrameworkComplianceReportBuilder {
    private String organization;
    private String location;
    private String frameworkComplianceReport;

    protected OrganizationLocationFrameworkComplianceReportBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceReport() {
      return frameworkComplianceReport;
    }

    public OrganizationLocationFrameworkComplianceReportBuilder setOrganization(
        String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationFrameworkComplianceReportBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationFrameworkComplianceReportBuilder setFrameworkComplianceReport(
        String frameworkComplianceReport) {
      this.frameworkComplianceReport = frameworkComplianceReport;
      return this;
    }

    public FrameworkComplianceReportName build() {
      return new FrameworkComplianceReportName(this);
    }
  }
}
