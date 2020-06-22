/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.logging.v2;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class CmekSettingsName implements ResourceName {

  @Deprecated
  protected CmekSettingsName() {}

  private static final PathTemplate PROJECT_CMEK_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/cmekSettings");
  private static final PathTemplate ORGANIZATION_CMEK_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/cmekSettings");
  private static final PathTemplate FOLDER_CMEK_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/cmekSettings");
  private static final PathTemplate BILLING_ACCOUNT_CMEK_SETTINGS_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/cmekSettings");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String organization;
  private String folder;
  private String billingAccount;

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

  private CmekSettingsName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    pathTemplate = PROJECT_CMEK_SETTINGS_PATH_TEMPLATE;
  }

  private CmekSettingsName(OrganizationCmekSettingsBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    pathTemplate = ORGANIZATION_CMEK_SETTINGS_PATH_TEMPLATE;
  }

  private CmekSettingsName(FolderCmekSettingsBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    pathTemplate = FOLDER_CMEK_SETTINGS_PATH_TEMPLATE;
  }

  private CmekSettingsName(BillingAccountCmekSettingsBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    pathTemplate = BILLING_ACCOUNT_CMEK_SETTINGS_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectCmekSettingsBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationCmekSettingsBuilder newOrganizationCmekSettingsBuilder() {
    return new OrganizationCmekSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderCmekSettingsBuilder newFolderCmekSettingsBuilder() {
    return new FolderCmekSettingsBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static BillingAccountCmekSettingsBuilder newBillingAccountCmekSettingsBuilder() {
    return new BillingAccountCmekSettingsBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CmekSettingsName of(String project) {
    return newProjectCmekSettingsBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CmekSettingsName ofProjectCmekSettingsName(String project) {
    return newProjectCmekSettingsBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CmekSettingsName ofOrganizationCmekSettingsName(String organization) {
    return newOrganizationCmekSettingsBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CmekSettingsName ofFolderCmekSettingsName(String folder) {
    return newFolderCmekSettingsBuilder().setFolder(folder).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CmekSettingsName ofBillingAccountCmekSettingsName(String billingAccount) {
    return newBillingAccountCmekSettingsBuilder().setBillingAccount(billingAccount).build();
  }

  public static String format(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectCmekSettingsName(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationCmekSettingsName(String organization) {
    return newOrganizationCmekSettingsBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderCmekSettingsName(String folder) {
    return newFolderCmekSettingsBuilder().setFolder(folder).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountCmekSettingsName(String billingAccount) {
    return newBillingAccountCmekSettingsBuilder()
        .setBillingAccount(billingAccount)
        .build()
        .toString();
  }

  public static CmekSettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CMEK_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofProjectCmekSettingsName(matchMap.get("project"));
    } else if (ORGANIZATION_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_CMEK_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationCmekSettingsName(matchMap.get("organization"));
    } else if (FOLDER_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_CMEK_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofFolderCmekSettingsName(matchMap.get("folder"));
    } else if (BILLING_ACCOUNT_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          BILLING_ACCOUNT_CMEK_SETTINGS_PATH_TEMPLATE.match(formattedString);
      return ofBillingAccountCmekSettingsName(matchMap.get("billing_account"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<CmekSettingsName> parseList(List<String> formattedStrings) {
    List<CmekSettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CmekSettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CmekSettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || ORGANIZATION_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || FOLDER_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString)
        || BILLING_ACCOUNT_CMEK_SETTINGS_PATH_TEMPLATE.matches(formattedString);
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

  /** Builder for projects/{project}/cmekSettings. */
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

    private Builder(CmekSettingsName cmekSettingsName) {
      Preconditions.checkArgument(
          cmekSettingsName.pathTemplate == PROJECT_CMEK_SETTINGS_PATH_TEMPLATE,
          "toBuilder is only supported when CmekSettingsName has the pattern of "
              + "projects/{project}/cmekSettings.");
      project = cmekSettingsName.project;
    }

    public CmekSettingsName build() {
      return new CmekSettingsName(this);
    }
  }

  /** Builder for organizations/{organization}/cmekSettings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationCmekSettingsBuilder {

    private String organization;

    private OrganizationCmekSettingsBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public OrganizationCmekSettingsBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public CmekSettingsName build() {
      return new CmekSettingsName(this);
    }
  }

  /** Builder for folders/{folder}/cmekSettings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderCmekSettingsBuilder {

    private String folder;

    private FolderCmekSettingsBuilder() {}

    public String getFolder() {
      return folder;
    }

    public FolderCmekSettingsBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public CmekSettingsName build() {
      return new CmekSettingsName(this);
    }
  }

  /** Builder for billingAccounts/{billing_account}/cmekSettings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class BillingAccountCmekSettingsBuilder {

    private String billingAccount;

    private BillingAccountCmekSettingsBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public BillingAccountCmekSettingsBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public CmekSettingsName build() {
      return new CmekSettingsName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CmekSettingsName that = (CmekSettingsName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.organization, that.organization))
          && (Objects.equals(this.folder, that.folder))
          && (Objects.equals(this.billingAccount, that.billingAccount));
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
}
