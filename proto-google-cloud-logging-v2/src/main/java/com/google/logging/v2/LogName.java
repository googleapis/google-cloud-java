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

package com.google.logging.v2;

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
public class LogName implements ResourceName {
  private static final PathTemplate PROJECT_LOG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/logs/{log}");
  private static final PathTemplate ORGANIZATION_LOG =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/logs/{log}");
  private static final PathTemplate FOLDER_LOG =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/logs/{log}");
  private static final PathTemplate BILLING_ACCOUNT_LOG =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/logs/{log}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String log;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected LogName() {
    project = null;
    log = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private LogName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    log = Preconditions.checkNotNull(builder.getLog());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT_LOG;
  }

  private LogName(OrganizationLogBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    log = Preconditions.checkNotNull(builder.getLog());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION_LOG;
  }

  private LogName(FolderLogBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    log = Preconditions.checkNotNull(builder.getLog());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER_LOG;
  }

  private LogName(BillingAccountLogBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    log = Preconditions.checkNotNull(builder.getLog());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT_LOG;
  }

  public String getProject() {
    return project;
  }

  public String getLog() {
    return log;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLogBuilder() {
    return new Builder();
  }

  public static OrganizationLogBuilder newOrganizationLogBuilder() {
    return new OrganizationLogBuilder();
  }

  public static FolderLogBuilder newFolderLogBuilder() {
    return new FolderLogBuilder();
  }

  public static BillingAccountLogBuilder newBillingAccountLogBuilder() {
    return new BillingAccountLogBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogName of(String project, String log) {
    return newBuilder().setProject(project).setLog(log).build();
  }

  public static LogName ofProjectLogName(String project, String log) {
    return newBuilder().setProject(project).setLog(log).build();
  }

  public static LogName ofOrganizationLogName(String organization, String log) {
    return newOrganizationLogBuilder().setOrganization(organization).setLog(log).build();
  }

  public static LogName ofFolderLogName(String folder, String log) {
    return newFolderLogBuilder().setFolder(folder).setLog(log).build();
  }

  public static LogName ofBillingAccountLogName(String billingAccount, String log) {
    return newBillingAccountLogBuilder().setBillingAccount(billingAccount).setLog(log).build();
  }

  public static String format(String project, String log) {
    return newBuilder().setProject(project).setLog(log).build().toString();
  }

  public static String formatProjectLogName(String project, String log) {
    return newBuilder().setProject(project).setLog(log).build().toString();
  }

  public static String formatOrganizationLogName(String organization, String log) {
    return newOrganizationLogBuilder().setOrganization(organization).setLog(log).build().toString();
  }

  public static String formatFolderLogName(String folder, String log) {
    return newFolderLogBuilder().setFolder(folder).setLog(log).build().toString();
  }

  public static String formatBillingAccountLogName(String billingAccount, String log) {
    return newBillingAccountLogBuilder()
        .setBillingAccount(billingAccount)
        .setLog(log)
        .build()
        .toString();
  }

  public static LogName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOG.match(formattedString);
      return ofProjectLogName(matchMap.get("project"), matchMap.get("log"));
    } else if (ORGANIZATION_LOG.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOG.match(formattedString);
      return ofOrganizationLogName(matchMap.get("organization"), matchMap.get("log"));
    } else if (FOLDER_LOG.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOG.match(formattedString);
      return ofFolderLogName(matchMap.get("folder"), matchMap.get("log"));
    } else if (BILLING_ACCOUNT_LOG.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT_LOG.match(formattedString);
      return ofBillingAccountLogName(matchMap.get("billing_account"), matchMap.get("log"));
    }
    throw new ValidationException("LogName.parse: formattedString not in valid format");
  }

  public static List<LogName> parseList(List<String> formattedStrings) {
    List<LogName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LogName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOG.matches(formattedString)
        || ORGANIZATION_LOG.matches(formattedString)
        || FOLDER_LOG.matches(formattedString)
        || BILLING_ACCOUNT_LOG.matches(formattedString);
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
          if (log != null) {
            fieldMapBuilder.put("log", log);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (billingAccount != null) {
            fieldMapBuilder.put("billing_account", billingAccount);
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
      LogName that = ((LogName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.log, that.log)
          && Objects.equals(this.organization, that.organization)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.billingAccount, that.billingAccount);
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
    h ^= Objects.hashCode(log);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/logs/{log}. */
  public static class Builder {
    private String project;
    private String log;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLog() {
      return log;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLog(String log) {
      this.log = log;
      return this;
    }

    private Builder(LogName logName) {
      Preconditions.checkArgument(
          Objects.equals(logName.pathTemplate, PROJECT_LOG),
          "toBuilder is only supported when LogName has the pattern of projects/{project}/logs/{log}");
      this.project = logName.project;
      this.log = logName.log;
    }

    public LogName build() {
      return new LogName(this);
    }
  }

  /** Builder for organizations/{organization}/logs/{log}. */
  public static class OrganizationLogBuilder {
    private String organization;
    private String log;

    protected OrganizationLogBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLog() {
      return log;
    }

    public OrganizationLogBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLogBuilder setLog(String log) {
      this.log = log;
      return this;
    }

    public LogName build() {
      return new LogName(this);
    }
  }

  /** Builder for folders/{folder}/logs/{log}. */
  public static class FolderLogBuilder {
    private String folder;
    private String log;

    protected FolderLogBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLog() {
      return log;
    }

    public FolderLogBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLogBuilder setLog(String log) {
      this.log = log;
      return this;
    }

    public LogName build() {
      return new LogName(this);
    }
  }

  /** Builder for billingAccounts/{billing_account}/logs/{log}. */
  public static class BillingAccountLogBuilder {
    private String billingAccount;
    private String log;

    protected BillingAccountLogBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLog() {
      return log;
    }

    public BillingAccountLogBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountLogBuilder setLog(String log) {
      this.log = log;
      return this;
    }

    public LogName build() {
      return new LogName(this);
    }
  }
}
