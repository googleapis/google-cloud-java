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

package com.google.analytics.admin.v1alpha;

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
public class ReportingDataAnnotationName implements ResourceName {
  private static final PathTemplate PROPERTY_REPORTING_DATA_ANNOTATION =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/reportingDataAnnotations/{reporting_data_annotation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String reportingDataAnnotation;

  @Deprecated
  protected ReportingDataAnnotationName() {
    property = null;
    reportingDataAnnotation = null;
  }

  private ReportingDataAnnotationName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    reportingDataAnnotation = Preconditions.checkNotNull(builder.getReportingDataAnnotation());
  }

  public String getProperty() {
    return property;
  }

  public String getReportingDataAnnotation() {
    return reportingDataAnnotation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportingDataAnnotationName of(String property, String reportingDataAnnotation) {
    return newBuilder()
        .setProperty(property)
        .setReportingDataAnnotation(reportingDataAnnotation)
        .build();
  }

  public static String format(String property, String reportingDataAnnotation) {
    return newBuilder()
        .setProperty(property)
        .setReportingDataAnnotation(reportingDataAnnotation)
        .build()
        .toString();
  }

  public static ReportingDataAnnotationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_REPORTING_DATA_ANNOTATION.validatedMatch(
            formattedString,
            "ReportingDataAnnotationName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("reporting_data_annotation"));
  }

  public static List<ReportingDataAnnotationName> parseList(List<String> formattedStrings) {
    List<ReportingDataAnnotationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportingDataAnnotationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportingDataAnnotationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_REPORTING_DATA_ANNOTATION.matches(formattedString);
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
          if (reportingDataAnnotation != null) {
            fieldMapBuilder.put("reporting_data_annotation", reportingDataAnnotation);
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
    return PROPERTY_REPORTING_DATA_ANNOTATION.instantiate(
        "property", property, "reporting_data_annotation", reportingDataAnnotation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReportingDataAnnotationName that = ((ReportingDataAnnotationName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.reportingDataAnnotation, that.reportingDataAnnotation);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(reportingDataAnnotation);
    return h;
  }

  /** Builder for properties/{property}/reportingDataAnnotations/{reporting_data_annotation}. */
  public static class Builder {
    private String property;
    private String reportingDataAnnotation;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getReportingDataAnnotation() {
      return reportingDataAnnotation;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setReportingDataAnnotation(String reportingDataAnnotation) {
      this.reportingDataAnnotation = reportingDataAnnotation;
      return this;
    }

    private Builder(ReportingDataAnnotationName reportingDataAnnotationName) {
      this.property = reportingDataAnnotationName.property;
      this.reportingDataAnnotation = reportingDataAnnotationName.reportingDataAnnotation;
    }

    public ReportingDataAnnotationName build() {
      return new ReportingDataAnnotationName(this);
    }
  }
}
