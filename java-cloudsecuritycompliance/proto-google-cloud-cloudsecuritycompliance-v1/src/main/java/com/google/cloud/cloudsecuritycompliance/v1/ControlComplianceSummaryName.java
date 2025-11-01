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
public class ControlComplianceSummaryName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}");
  private static final PathTemplate
      FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY =
          PathTemplate.createWithoutUrlEncoding(
              "folders/{folder}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}");
  private static final PathTemplate
      ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY =
          PathTemplate.createWithoutUrlEncoding(
              "organizations/{organization}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String frameworkComplianceReport;
  private final String controlComplianceSummary;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ControlComplianceSummaryName() {
    project = null;
    location = null;
    frameworkComplianceReport = null;
    controlComplianceSummary = null;
    folder = null;
    organization = null;
  }

  private ControlComplianceSummaryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceReport = Preconditions.checkNotNull(builder.getFrameworkComplianceReport());
    controlComplianceSummary = Preconditions.checkNotNull(builder.getControlComplianceSummary());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY;
  }

  private ControlComplianceSummaryName(
      FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceReport = Preconditions.checkNotNull(builder.getFrameworkComplianceReport());
    controlComplianceSummary = Preconditions.checkNotNull(builder.getControlComplianceSummary());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY;
  }

  private ControlComplianceSummaryName(
      OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkComplianceReport = Preconditions.checkNotNull(builder.getFrameworkComplianceReport());
    controlComplianceSummary = Preconditions.checkNotNull(builder.getControlComplianceSummary());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY;
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

  public String getControlComplianceSummary() {
    return controlComplianceSummary;
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

  public static Builder
      newProjectLocationFrameworkComplianceReportControlComplianceSummaryBuilder() {
    return new Builder();
  }

  public static FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder
      newFolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder() {
    return new FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder();
  }

  public static OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder
      newOrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder() {
    return new OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ControlComplianceSummaryName of(
      String project,
      String location,
      String frameworkComplianceReport,
      String controlComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build();
  }

  public static ControlComplianceSummaryName
      ofProjectLocationFrameworkComplianceReportControlComplianceSummaryName(
          String project,
          String location,
          String frameworkComplianceReport,
          String controlComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build();
  }

  public static ControlComplianceSummaryName
      ofFolderLocationFrameworkComplianceReportControlComplianceSummaryName(
          String folder,
          String location,
          String frameworkComplianceReport,
          String controlComplianceSummary) {
    return newFolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build();
  }

  public static ControlComplianceSummaryName
      ofOrganizationLocationFrameworkComplianceReportControlComplianceSummaryName(
          String organization,
          String location,
          String frameworkComplianceReport,
          String controlComplianceSummary) {
    return newOrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build();
  }

  public static String format(
      String project,
      String location,
      String frameworkComplianceReport,
      String controlComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build()
        .toString();
  }

  public static String formatProjectLocationFrameworkComplianceReportControlComplianceSummaryName(
      String project,
      String location,
      String frameworkComplianceReport,
      String controlComplianceSummary) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build()
        .toString();
  }

  public static String formatFolderLocationFrameworkComplianceReportControlComplianceSummaryName(
      String folder,
      String location,
      String frameworkComplianceReport,
      String controlComplianceSummary) {
    return newFolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build()
        .toString();
  }

  public static String
      formatOrganizationLocationFrameworkComplianceReportControlComplianceSummaryName(
          String organization,
          String location,
          String frameworkComplianceReport,
          String controlComplianceSummary) {
    return newOrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkComplianceReport(frameworkComplianceReport)
        .setControlComplianceSummary(controlComplianceSummary)
        .build()
        .toString();
  }

  public static ControlComplianceSummaryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.matches(
        formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.match(
              formattedString);
      return ofProjectLocationFrameworkComplianceReportControlComplianceSummaryName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_report"),
          matchMap.get("control_compliance_summary"));
    } else if (FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.matches(
        formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.match(
              formattedString);
      return ofFolderLocationFrameworkComplianceReportControlComplianceSummaryName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_report"),
          matchMap.get("control_compliance_summary"));
    } else if (ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.matches(
        formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.match(
              formattedString);
      return ofOrganizationLocationFrameworkComplianceReportControlComplianceSummaryName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("framework_compliance_report"),
          matchMap.get("control_compliance_summary"));
    }
    throw new ValidationException(
        "ControlComplianceSummaryName.parse: formattedString not in valid format");
  }

  public static List<ControlComplianceSummaryName> parseList(List<String> formattedStrings) {
    List<ControlComplianceSummaryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ControlComplianceSummaryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ControlComplianceSummaryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.matches(
            formattedString)
        || FOLDER_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.matches(
            formattedString)
        || ORGANIZATION_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY.matches(
            formattedString);
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
          if (controlComplianceSummary != null) {
            fieldMapBuilder.put("control_compliance_summary", controlComplianceSummary);
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
      ControlComplianceSummaryName that = ((ControlComplianceSummaryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.frameworkComplianceReport, that.frameworkComplianceReport)
          && Objects.equals(this.controlComplianceSummary, that.controlComplianceSummary)
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
    h ^= Objects.hashCode(controlComplianceSummary);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String frameworkComplianceReport;
    private String controlComplianceSummary;

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

    public String getControlComplianceSummary() {
      return controlComplianceSummary;
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

    public Builder setControlComplianceSummary(String controlComplianceSummary) {
      this.controlComplianceSummary = controlComplianceSummary;
      return this;
    }

    private Builder(ControlComplianceSummaryName controlComplianceSummaryName) {
      Preconditions.checkArgument(
          Objects.equals(
              controlComplianceSummaryName.pathTemplate,
              PROJECT_LOCATION_FRAMEWORK_COMPLIANCE_REPORT_CONTROL_COMPLIANCE_SUMMARY),
          "toBuilder is only supported when ControlComplianceSummaryName has the pattern of"
              + " projects/{project}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}");
      this.project = controlComplianceSummaryName.project;
      this.location = controlComplianceSummaryName.location;
      this.frameworkComplianceReport = controlComplianceSummaryName.frameworkComplianceReport;
      this.controlComplianceSummary = controlComplianceSummaryName.controlComplianceSummary;
    }

    public ControlComplianceSummaryName build() {
      return new ControlComplianceSummaryName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}.
   */
  public static class FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder {
    private String folder;
    private String location;
    private String frameworkComplianceReport;
    private String controlComplianceSummary;

    protected FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceReport() {
      return frameworkComplianceReport;
    }

    public String getControlComplianceSummary() {
      return controlComplianceSummary;
    }

    public FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder setFolder(
        String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder
        setFrameworkComplianceReport(String frameworkComplianceReport) {
      this.frameworkComplianceReport = frameworkComplianceReport;
      return this;
    }

    public FolderLocationFrameworkComplianceReportControlComplianceSummaryBuilder
        setControlComplianceSummary(String controlComplianceSummary) {
      this.controlComplianceSummary = controlComplianceSummary;
      return this;
    }

    public ControlComplianceSummaryName build() {
      return new ControlComplianceSummaryName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/frameworkComplianceReports/{framework_compliance_report}/controlComplianceSummaries/{control_compliance_summary}.
   */
  public static class OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder {
    private String organization;
    private String location;
    private String frameworkComplianceReport;
    private String controlComplianceSummary;

    protected OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkComplianceReport() {
      return frameworkComplianceReport;
    }

    public String getControlComplianceSummary() {
      return controlComplianceSummary;
    }

    public OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder
        setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder
        setFrameworkComplianceReport(String frameworkComplianceReport) {
      this.frameworkComplianceReport = frameworkComplianceReport;
      return this;
    }

    public OrganizationLocationFrameworkComplianceReportControlComplianceSummaryBuilder
        setControlComplianceSummary(String controlComplianceSummary) {
      this.controlComplianceSummary = controlComplianceSummary;
      return this;
    }

    public ControlComplianceSummaryName build() {
      return new ControlComplianceSummaryName(this);
    }
  }
}
