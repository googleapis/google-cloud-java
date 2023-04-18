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
public class ReportConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPORT_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reportConfigs/{report_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reportConfig;

  @Deprecated
  protected ReportConfigName() {
    project = null;
    location = null;
    reportConfig = null;
  }

  private ReportConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reportConfig = Preconditions.checkNotNull(builder.getReportConfig());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportConfigName of(String project, String location, String reportConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReportConfig(reportConfig)
        .build();
  }

  public static String format(String project, String location, String reportConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReportConfig(reportConfig)
        .build()
        .toString();
  }

  public static ReportConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPORT_CONFIG.validatedMatch(
            formattedString, "ReportConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("report_config"));
  }

  public static List<ReportConfigName> parseList(List<String> formattedStrings) {
    List<ReportConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPORT_CONFIG.matches(formattedString);
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
    return PROJECT_LOCATION_REPORT_CONFIG.instantiate(
        "project", project, "location", location, "report_config", reportConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ReportConfigName that = ((ReportConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reportConfig, that.reportConfig);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/reportConfigs/{report_config}. */
  public static class Builder {
    private String project;
    private String location;
    private String reportConfig;

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

    private Builder(ReportConfigName reportConfigName) {
      this.project = reportConfigName.project;
      this.location = reportConfigName.location;
      this.reportConfig = reportConfigName.reportConfig;
    }

    public ReportConfigName build() {
      return new ReportConfigName(this);
    }
  }
}
