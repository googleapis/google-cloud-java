/*
 * Copyright 2024 Google LLC
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

package com.google.analytics.data.v1alpha;

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
public class ReportTaskName implements ResourceName {
  private static final PathTemplate PROPERTY_REPORT_TASK =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/reportTasks/{report_task}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String reportTask;

  @Deprecated
  protected ReportTaskName() {
    property = null;
    reportTask = null;
  }

  private ReportTaskName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    reportTask = Preconditions.checkNotNull(builder.getReportTask());
  }

  public String getProperty() {
    return property;
  }

  public String getReportTask() {
    return reportTask;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportTaskName of(String property, String reportTask) {
    return newBuilder().setProperty(property).setReportTask(reportTask).build();
  }

  public static String format(String property, String reportTask) {
    return newBuilder().setProperty(property).setReportTask(reportTask).build().toString();
  }

  public static ReportTaskName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_REPORT_TASK.validatedMatch(
            formattedString, "ReportTaskName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("report_task"));
  }

  public static List<ReportTaskName> parseList(List<String> formattedStrings) {
    List<ReportTaskName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportTaskName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportTaskName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_REPORT_TASK.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (property != null) {
            fieldMapBuilder.put("property", property);
          }
          if (reportTask != null) {
            fieldMapBuilder.put("report_task", reportTask);
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
    return PROPERTY_REPORT_TASK.instantiate("property", property, "report_task", reportTask);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReportTaskName that = ((ReportTaskName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.reportTask, that.reportTask);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(reportTask);
    return h;
  }

  /** Builder for properties/{property}/reportTasks/{report_task}. */
  public static class Builder {
    private String property;
    private String reportTask;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getReportTask() {
      return reportTask;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setReportTask(String reportTask) {
      this.reportTask = reportTask;
      return this;
    }

    private Builder(ReportTaskName reportTaskName) {
      this.property = reportTaskName.property;
      this.reportTask = reportTaskName.reportTask;
    }

    public ReportTaskName build() {
      return new ReportTaskName(this);
    }
  }
}
