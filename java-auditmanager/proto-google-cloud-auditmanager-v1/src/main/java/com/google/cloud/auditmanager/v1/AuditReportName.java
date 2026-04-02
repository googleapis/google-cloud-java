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
public class AuditReportName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUDIT_REPORT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/auditReports/{audit_report}");
  private static final PathTemplate FOLDER_LOCATION_AUDIT_REPORT =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/auditReports/{audit_report}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String auditReport;
  private final String folder;

  @Deprecated
  protected AuditReportName() {
    project = null;
    location = null;
    auditReport = null;
    folder = null;
  }

  private AuditReportName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    auditReport = Preconditions.checkNotNull(builder.getAuditReport());
    folder = null;
    pathTemplate = PROJECT_LOCATION_AUDIT_REPORT;
  }

  private AuditReportName(FolderLocationAuditReportBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    auditReport = Preconditions.checkNotNull(builder.getAuditReport());
    project = null;
    pathTemplate = FOLDER_LOCATION_AUDIT_REPORT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAuditReport() {
    return auditReport;
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationAuditReportBuilder() {
    return new Builder();
  }

  public static FolderLocationAuditReportBuilder newFolderLocationAuditReportBuilder() {
    return new FolderLocationAuditReportBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AuditReportName of(String project, String location, String auditReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditReport(auditReport)
        .build();
  }

  public static AuditReportName ofProjectLocationAuditReportName(
      String project, String location, String auditReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditReport(auditReport)
        .build();
  }

  public static AuditReportName ofFolderLocationAuditReportName(
      String folder, String location, String auditReport) {
    return newFolderLocationAuditReportBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setAuditReport(auditReport)
        .build();
  }

  public static String format(String project, String location, String auditReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditReport(auditReport)
        .build()
        .toString();
  }

  public static String formatProjectLocationAuditReportName(
      String project, String location, String auditReport) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAuditReport(auditReport)
        .build()
        .toString();
  }

  public static String formatFolderLocationAuditReportName(
      String folder, String location, String auditReport) {
    return newFolderLocationAuditReportBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setAuditReport(auditReport)
        .build()
        .toString();
  }

  public static AuditReportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_AUDIT_REPORT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_AUDIT_REPORT.match(formattedString);
      return ofProjectLocationAuditReportName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("audit_report"));
    } else if (FOLDER_LOCATION_AUDIT_REPORT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_AUDIT_REPORT.match(formattedString);
      return ofFolderLocationAuditReportName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("audit_report"));
    }
    throw new ValidationException("AuditReportName.parse: formattedString not in valid format");
  }

  public static List<AuditReportName> parseList(List<String> formattedStrings) {
    List<AuditReportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AuditReportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AuditReportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUDIT_REPORT.matches(formattedString)
        || FOLDER_LOCATION_AUDIT_REPORT.matches(formattedString);
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
          if (auditReport != null) {
            fieldMapBuilder.put("audit_report", auditReport);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
      AuditReportName that = ((AuditReportName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.auditReport, that.auditReport)
          && Objects.equals(this.folder, that.folder);
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
    h ^= Objects.hashCode(auditReport);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/auditReports/{audit_report}. */
  public static class Builder {
    private String project;
    private String location;
    private String auditReport;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAuditReport() {
      return auditReport;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAuditReport(String auditReport) {
      this.auditReport = auditReport;
      return this;
    }

    private Builder(AuditReportName auditReportName) {
      Preconditions.checkArgument(
          Objects.equals(auditReportName.pathTemplate, PROJECT_LOCATION_AUDIT_REPORT),
          "toBuilder is only supported when AuditReportName has the pattern of"
              + " projects/{project}/locations/{location}/auditReports/{audit_report}");
      this.project = auditReportName.project;
      this.location = auditReportName.location;
      this.auditReport = auditReportName.auditReport;
    }

    public AuditReportName build() {
      return new AuditReportName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/auditReports/{audit_report}. */
  public static class FolderLocationAuditReportBuilder {
    private String folder;
    private String location;
    private String auditReport;

    protected FolderLocationAuditReportBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getAuditReport() {
      return auditReport;
    }

    public FolderLocationAuditReportBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationAuditReportBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationAuditReportBuilder setAuditReport(String auditReport) {
      this.auditReport = auditReport;
      return this;
    }

    public AuditReportName build() {
      return new AuditReportName(this);
    }
  }
}
