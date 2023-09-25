/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.migrationcenter.v1;

import com.google.api.pathtemplate.PathTemplate;
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
public class ReportName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPORT_CONFIG_REPORT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reportConfigs/{report_config}/reports/{report}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reportConfig;
  private final String report;

  @Deprecated
  protected ReportName() {
    project = null;
    location = null;
    reportConfig = null;
    report = null;
  }

  private ReportName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reportConfig = Preconditions.checkNotNull(builder.getReportConfig());
    report = Preconditions.checkNotNull(builder.getReport());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getReportConfig() {
    return reportConfig;
  }

  public String getReport() {
    return report;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportName of(String project, String location, String reportConfig, String report) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReportConfig(reportConfig)
        .setReport(report)
        .build();
  }

  public static String format(String project, String location, String reportConfig, String report) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReportConfig(reportConfig)
        .setReport(report)
        .build()
        .toString();
  }

  public static ReportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPORT_CONFIG_REPORT.validatedMatch(
            formattedString, "ReportName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("report_config"),
        matchMap.get("report"));
  }

  public static List<ReportName> parseList(List<String> formattedStrings) {
    List<ReportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPORT_CONFIG_REPORT.matches(formattedString);
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
          if (reportConfig != null) {
            fieldMapBuilder.put("report_config", reportConfig);
          }
          if (report != null) {
            fieldMapBuilder.put("report", report);
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
    return PROJECT_LOCATION_REPORT_CONFIG_REPORT.instantiate(
        "project", project, "location", location, "report_config", reportConfig, "report", report);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReportName that = ((ReportName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reportConfig, that.reportConfig)
          && Objects.equals(this.report, that.report);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(reportConfig);
    h *= 1000003;
    h ^= Objects.hashCode(report);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reportConfigs/{report_config}/reports/{report}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String reportConfig;
    private String report;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReportConfig() {
      return reportConfig;
    }

    public String getReport() {
      return report;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReportConfig(String reportConfig) {
      this.reportConfig = reportConfig;
      return this;
    }

    public Builder setReport(String report) {
      this.report = report;
      return this;
    }

    private Builder(ReportName reportName) {
      this.project = reportName.project;
      this.location = reportName.location;
      this.reportConfig = reportName.reportConfig;
      this.report = reportName.report;
    }

    public ReportName build() {
      return new ReportName(this);
    }
  }
}
