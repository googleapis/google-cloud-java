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
public class LogExclusionName implements ResourceName {
  private static final PathTemplate PROJECT_EXCLUSION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/exclusions/{exclusion}");
  private static final PathTemplate ORGANIZATION_EXCLUSION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/exclusions/{exclusion}");
  private static final PathTemplate FOLDER_EXCLUSION =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/exclusions/{exclusion}");
  private static final PathTemplate BILLING_ACCOUNT_EXCLUSION =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/exclusions/{exclusion}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String exclusion;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected LogExclusionName() {
    project = null;
    exclusion = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private LogExclusionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT_EXCLUSION;
  }

  private LogExclusionName(OrganizationExclusionBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION_EXCLUSION;
  }

  private LogExclusionName(FolderExclusionBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER_EXCLUSION;
  }

  private LogExclusionName(BillingAccountExclusionBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT_EXCLUSION;
  }

  public String getProject() {
    return project;
  }

  public String getExclusion() {
    return exclusion;
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

  public static Builder newProjectExclusionBuilder() {
    return new Builder();
  }

  public static OrganizationExclusionBuilder newOrganizationExclusionBuilder() {
    return new OrganizationExclusionBuilder();
  }

  public static FolderExclusionBuilder newFolderExclusionBuilder() {
    return new FolderExclusionBuilder();
  }

  public static BillingAccountExclusionBuilder newBillingAccountExclusionBuilder() {
    return new BillingAccountExclusionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LogExclusionName of(String project, String exclusion) {
    return newBuilder().setProject(project).setExclusion(exclusion).build();
  }

  public static LogExclusionName ofProjectExclusionName(String project, String exclusion) {
    return newBuilder().setProject(project).setExclusion(exclusion).build();
  }

  public static LogExclusionName ofOrganizationExclusionName(
      String organization, String exclusion) {
    return newOrganizationExclusionBuilder()
        .setOrganization(organization)
        .setExclusion(exclusion)
        .build();
  }

  public static LogExclusionName ofFolderExclusionName(String folder, String exclusion) {
    return newFolderExclusionBuilder().setFolder(folder).setExclusion(exclusion).build();
  }

  public static LogExclusionName ofBillingAccountExclusionName(
      String billingAccount, String exclusion) {
    return newBillingAccountExclusionBuilder()
        .setBillingAccount(billingAccount)
        .setExclusion(exclusion)
        .build();
  }

  public static String format(String project, String exclusion) {
    return newBuilder().setProject(project).setExclusion(exclusion).build().toString();
  }

  public static String formatProjectExclusionName(String project, String exclusion) {
    return newBuilder().setProject(project).setExclusion(exclusion).build().toString();
  }

  public static String formatOrganizationExclusionName(String organization, String exclusion) {
    return newOrganizationExclusionBuilder()
        .setOrganization(organization)
        .setExclusion(exclusion)
        .build()
        .toString();
  }

  public static String formatFolderExclusionName(String folder, String exclusion) {
    return newFolderExclusionBuilder().setFolder(folder).setExclusion(exclusion).build().toString();
  }

  public static String formatBillingAccountExclusionName(String billingAccount, String exclusion) {
    return newBillingAccountExclusionBuilder()
        .setBillingAccount(billingAccount)
        .setExclusion(exclusion)
        .build()
        .toString();
  }

  public static LogExclusionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_EXCLUSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_EXCLUSION.match(formattedString);
      return ofProjectExclusionName(matchMap.get("project"), matchMap.get("exclusion"));
    } else if (ORGANIZATION_EXCLUSION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_EXCLUSION.match(formattedString);
      return ofOrganizationExclusionName(matchMap.get("organization"), matchMap.get("exclusion"));
    } else if (FOLDER_EXCLUSION.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_EXCLUSION.match(formattedString);
      return ofFolderExclusionName(matchMap.get("folder"), matchMap.get("exclusion"));
    } else if (BILLING_ACCOUNT_EXCLUSION.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT_EXCLUSION.match(formattedString);
      return ofBillingAccountExclusionName(
          matchMap.get("billing_account"), matchMap.get("exclusion"));
    }
    throw new ValidationException("LogExclusionName.parse: formattedString not in valid format");
  }

  public static List<LogExclusionName> parseList(List<String> formattedStrings) {
    List<LogExclusionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LogExclusionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LogExclusionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_EXCLUSION.matches(formattedString)
        || ORGANIZATION_EXCLUSION.matches(formattedString)
        || FOLDER_EXCLUSION.matches(formattedString)
        || BILLING_ACCOUNT_EXCLUSION.matches(formattedString);
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
          if (exclusion != null) {
            fieldMapBuilder.put("exclusion", exclusion);
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
      LogExclusionName that = ((LogExclusionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.exclusion, that.exclusion)
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
    h ^= Objects.hashCode(exclusion);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/exclusions/{exclusion}. */
  public static class Builder {
    private String project;
    private String exclusion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getExclusion() {
      return exclusion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    private Builder(LogExclusionName logExclusionName) {
      Preconditions.checkArgument(
          Objects.equals(logExclusionName.pathTemplate, PROJECT_EXCLUSION),
          "toBuilder is only supported when LogExclusionName has the pattern of projects/{project}/exclusions/{exclusion}");
      this.project = logExclusionName.project;
      this.exclusion = logExclusionName.exclusion;
    }

    public LogExclusionName build() {
      return new LogExclusionName(this);
    }
  }

  /** Builder for organizations/{organization}/exclusions/{exclusion}. */
  public static class OrganizationExclusionBuilder {
    private String organization;
    private String exclusion;

    protected OrganizationExclusionBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getExclusion() {
      return exclusion;
    }

    public OrganizationExclusionBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationExclusionBuilder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    public LogExclusionName build() {
      return new LogExclusionName(this);
    }
  }

  /** Builder for folders/{folder}/exclusions/{exclusion}. */
  public static class FolderExclusionBuilder {
    private String folder;
    private String exclusion;

    protected FolderExclusionBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getExclusion() {
      return exclusion;
    }

    public FolderExclusionBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderExclusionBuilder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    public LogExclusionName build() {
      return new LogExclusionName(this);
    }
  }

  /** Builder for billingAccounts/{billing_account}/exclusions/{exclusion}. */
  public static class BillingAccountExclusionBuilder {
    private String billingAccount;
    private String exclusion;

    protected BillingAccountExclusionBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getExclusion() {
      return exclusion;
    }

    public BillingAccountExclusionBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountExclusionBuilder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    public LogExclusionName build() {
      return new LogExclusionName(this);
    }
  }
}
