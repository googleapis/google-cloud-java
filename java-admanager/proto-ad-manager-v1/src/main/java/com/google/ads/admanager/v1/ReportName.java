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

package com.google.ads.admanager.v1;

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
  private static final PathTemplate NETWORK_CODE_REPORT =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/reports/{report}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String report;

  @Deprecated
  protected ReportName() {
    networkCode = null;
    report = null;
  }

  private ReportName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    report = Preconditions.checkNotNull(builder.getReport());
  }

  public String getNetworkCode() {
    return networkCode;
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

  public static ReportName of(String networkCode, String report) {
    return newBuilder().setNetworkCode(networkCode).setReport(report).build();
  }

  public static String format(String networkCode, String report) {
    return newBuilder().setNetworkCode(networkCode).setReport(report).build().toString();
  }

  public static ReportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_REPORT.validatedMatch(
            formattedString, "ReportName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("report"));
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
    return NETWORK_CODE_REPORT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
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
    return NETWORK_CODE_REPORT.instantiate("network_code", networkCode, "report", report);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReportName that = ((ReportName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.report, that.report);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(report);
    return h;
  }

  /** Builder for networks/{network_code}/reports/{report}. */
  public static class Builder {
    private String networkCode;
    private String report;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getReport() {
      return report;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setReport(String report) {
      this.report = report;
      return this;
    }

    private Builder(ReportName reportName) {
      this.networkCode = reportName.networkCode;
      this.report = reportName.report;
    }

    public ReportName build() {
      return new ReportName(this);
    }
  }
}
