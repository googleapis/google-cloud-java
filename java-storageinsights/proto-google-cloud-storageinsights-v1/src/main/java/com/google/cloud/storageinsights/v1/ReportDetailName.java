/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storageinsights.v1;

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
public class ReportDetailName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPORT_CONFIG_REPORT_DETAIL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reportConfigs/{report_config}/reportDetails/{report_detail}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reportConfig;
  private final String reportDetail;

  @Deprecated
  protected ReportDetailName() {
    project = null;
    location = null;
    reportConfig = null;
    reportDetail = null;
  }

  private ReportDetailName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reportConfig = Preconditions.checkNotNull(builder.getReportConfig());
    reportDetail = Preconditions.checkNotNull(builder.getReportDetail());
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

  public String getReportDetail() {
    return reportDetail;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportDetailName of(
      String project, String location, String reportConfig, String reportDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReportConfig(reportConfig)
        .setReportDetail(reportDetail)
        .build();
  }

  public static String format(
      String project, String location, String reportConfig, String reportDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReportConfig(reportConfig)
        .setReportDetail(reportDetail)
        .build()
        .toString();
  }

  public static ReportDetailName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPORT_CONFIG_REPORT_DETAIL.validatedMatch(
            formattedString, "ReportDetailName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("report_config"),
        matchMap.get("report_detail"));
  }

  public static List<ReportDetailName> parseList(List<String> formattedStrings) {
    List<ReportDetailName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportDetailName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportDetailName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPORT_CONFIG_REPORT_DETAIL.matches(formattedString);
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
          if (reportDetail != null) {
            fieldMapBuilder.put("report_detail", reportDetail);
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
    return PROJECT_LOCATION_REPORT_CONFIG_REPORT_DETAIL.instantiate(
        "project",
        project,
        "location",
        location,
        "report_config",
        reportConfig,
        "report_detail",
        reportDetail);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ReportDetailName that = ((ReportDetailName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reportConfig, that.reportConfig)
          && Objects.equals(this.reportDetail, that.reportDetail);
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
    h ^= Objects.hashCode(reportDetail);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reportConfigs/{report_config}/reportDetails/{report_detail}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String reportConfig;
    private String reportDetail;

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

    public String getReportDetail() {
      return reportDetail;
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

    public Builder setReportDetail(String reportDetail) {
      this.reportDetail = reportDetail;
      return this;
    }

    private Builder(ReportDetailName reportDetailName) {
      this.project = reportDetailName.project;
      this.location = reportDetailName.location;
      this.reportConfig = reportDetailName.reportConfig;
      this.reportDetail = reportDetailName.reportDetail;
    }

    public ReportDetailName build() {
      return new ReportDetailName(this);
    }
  }
}
