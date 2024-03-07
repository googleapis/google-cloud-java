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
public class SettingsName implements ResourceName {
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/settings");
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/settings");
  private static final PathTemplate FOLDER =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/settings");
  private static final PathTemplate BILLING_ACCOUNT =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/settings");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String organization;
  private final String folder;
  private final String billingAccount;

  @Deprecated
  protected SettingsName() {
    project = null;
    organization = null;
    folder = null;
    billingAccount = null;
  }

  private SettingsName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    organization = null;
    folder = null;
    billingAccount = null;
    pathTemplate = PROJECT;
  }

  private SettingsName(OrganizationBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    project = null;
    folder = null;
    billingAccount = null;
    pathTemplate = ORGANIZATION;
  }

  private SettingsName(FolderBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    project = null;
    organization = null;
    billingAccount = null;
    pathTemplate = FOLDER;
  }

  private SettingsName(BillingAccountBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    project = null;
    organization = null;
    folder = null;
    pathTemplate = BILLING_ACCOUNT;
  }

  public String getProject() {
    return project;
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

  public static Builder newProjectBuilder() {
    return new Builder();
  }

  public static OrganizationBuilder newOrganizationBuilder() {
    return new OrganizationBuilder();
  }

  public static FolderBuilder newFolderBuilder() {
    return new FolderBuilder();
  }

  public static BillingAccountBuilder newBillingAccountBuilder() {
    return new BillingAccountBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SettingsName of(String project) {
    return newBuilder().setProject(project).build();
  }

  public static SettingsName ofProjectName(String project) {
    return newBuilder().setProject(project).build();
  }

  public static SettingsName ofOrganizationName(String organization) {
    return newOrganizationBuilder().setOrganization(organization).build();
  }

  public static SettingsName ofFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build();
  }

  public static SettingsName ofBillingAccountName(String billingAccount) {
    return newBillingAccountBuilder().setBillingAccount(billingAccount).build();
  }

  public static String format(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  public static String formatProjectName(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  public static String formatOrganizationName(String organization) {
    return newOrganizationBuilder().setOrganization(organization).build().toString();
  }

  public static String formatFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build().toString();
  }

  public static String formatBillingAccountName(String billingAccount) {
    return newBillingAccountBuilder().setBillingAccount(billingAccount).build().toString();
  }

  public static SettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    } else if (ORGANIZATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION.match(formattedString);
      return ofOrganizationName(matchMap.get("organization"));
    } else if (FOLDER.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER.match(formattedString);
      return ofFolderName(matchMap.get("folder"));
    } else if (BILLING_ACCOUNT.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT.match(formattedString);
      return ofBillingAccountName(matchMap.get("billing_account"));
    }
    throw new ValidationException("SettingsName.parse: formattedString not in valid format");
  }

  public static List<SettingsName> parseList(List<String> formattedStrings) {
    List<SettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT.matches(formattedString)
        || ORGANIZATION.matches(formattedString)
        || FOLDER.matches(formattedString)
        || BILLING_ACCOUNT.matches(formattedString);
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
      SettingsName that = ((SettingsName) o);
      return Objects.equals(this.project, that.project)
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
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    return h;
  }

  /** Builder for projects/{project}/settings. */
  public static class Builder {
    private String project;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder(SettingsName settingsName) {
      Preconditions.checkArgument(
          Objects.equals(settingsName.pathTemplate, PROJECT),
          "toBuilder is only supported when SettingsName has the pattern of projects/{project}/settings");
      this.project = settingsName.project;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for organizations/{organization}/settings. */
  public static class OrganizationBuilder {
    private String organization;

    protected OrganizationBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public OrganizationBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for folders/{folder}/settings. */
  public static class FolderBuilder {
    private String folder;

    protected FolderBuilder() {}

    public String getFolder() {
      return folder;
    }

    public FolderBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }

  /** Builder for billingAccounts/{billing_account}/settings. */
  public static class BillingAccountBuilder {
    private String billingAccount;

    protected BillingAccountBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public BillingAccountBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public SettingsName build() {
      return new SettingsName(this);
    }
  }
}
