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
public class ReportJobName implements ResourceName {
  private static final PathTemplate ACCOUNT_REPORT_JOB =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/reportJobs/{report_job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String reportJob;

  @Deprecated
  protected ReportJobName() {
    account = null;
    reportJob = null;
  }

  private ReportJobName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    reportJob = Preconditions.checkNotNull(builder.getReportJob());
  }

  public String getAccount() {
    return account;
  }

  public String getReportJob() {
    return reportJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReportJobName of(String account, String reportJob) {
    return newBuilder().setAccount(account).setReportJob(reportJob).build();
  }

  public static String format(String account, String reportJob) {
    return newBuilder().setAccount(account).setReportJob(reportJob).build().toString();
  }

  public static ReportJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_REPORT_JOB.validatedMatch(
            formattedString, "ReportJobName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("report_job"));
  }

  public static List<ReportJobName> parseList(List<String> formattedStrings) {
    List<ReportJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReportJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReportJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_REPORT_JOB.matches(formattedString);
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
          if (reportJob != null) {
            fieldMapBuilder.put("report_job", reportJob);
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
    return ACCOUNT_REPORT_JOB.instantiate("account", account, "report_job", reportJob);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ReportJobName that = ((ReportJobName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.reportJob, that.reportJob);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(reportJob);
    return h;
  }

  /** Builder for accounts/{account}/reportJobs/{report_job}. */
  public static class Builder {
    private String account;
    private String reportJob;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getReportJob() {
      return reportJob;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setReportJob(String reportJob) {
      this.reportJob = reportJob;
      return this;
    }

    private Builder(ReportJobName reportJobName) {
      this.account = reportJobName.account;
      this.reportJob = reportJobName.reportJob;
    }

    public ReportJobName build() {
      return new ReportJobName(this);
    }
  }
}
