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

package com.google.cloud.channel.v1;

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
  private static final PathTemplate ACCOUNT_REPORT =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/reports/{report}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String report;

  @Deprecated
  protected ReportName() {
    account = null;
    report = null;
  }

  private ReportName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    report = Preconditions.checkNotNull(builder.getReport());
  }

  public String getAccount() {
    return account;
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

  public static ReportName of(String account, String report) {
    return newBuilder().setAccount(account).setReport(report).build();
  }

  public static String format(String account, String report) {
    return newBuilder().setAccount(account).setReport(report).build().toString();
  }

  public static ReportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_REPORT.validatedMatch(
            formattedString, "ReportName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("report"));
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
    return ACCOUNT_REPORT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (account != null) {
            fieldMapBuilder.put("account", account);
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
    return ACCOUNT_REPORT.instantiate("account", account, "report", report);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ReportName that = ((ReportName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.report, that.report);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(report);
    return h;
  }

  /** Builder for accounts/{account}/reports/{report}. */
  public static class Builder {
    private String account;
    private String report;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getReport() {
      return report;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setReport(String report) {
      this.report = report;
      return this;
    }

    private Builder(ReportName reportName) {
      this.account = reportName.account;
      this.report = reportName.report;
    }

    public ReportName build() {
      return new ReportName(this);
    }
  }
}
