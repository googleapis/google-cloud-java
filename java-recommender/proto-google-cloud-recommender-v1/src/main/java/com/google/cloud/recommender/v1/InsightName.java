/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.recommender.v1;

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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class InsightName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSIGHT_TYPE_INSIGHT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/insightTypes/{insight_type}/insights/{insight}");
  private static final PathTemplate BILLING_ACCOUNT_LOCATION_INSIGHT_TYPE_INSIGHT =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/locations/{location}/insightTypes/{insight_type}/insights/{insight}");
  private static final PathTemplate FOLDER_LOCATION_INSIGHT_TYPE_INSIGHT =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/insightTypes/{insight_type}/insights/{insight}");
  private static final PathTemplate ORGANIZATION_LOCATION_INSIGHT_TYPE_INSIGHT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/insightTypes/{insight_type}/insights/{insight}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String insightType;
  private final String insight;
  private final String billingAccount;
  private final String folder;
  private final String organization;

  @Deprecated
  protected InsightName() {
    project = null;
    location = null;
    insightType = null;
    insight = null;
    billingAccount = null;
    folder = null;
    organization = null;
  }

  private InsightName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightType = Preconditions.checkNotNull(builder.getInsightType());
    insight = Preconditions.checkNotNull(builder.getInsight());
    billingAccount = null;
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_INSIGHT_TYPE_INSIGHT;
  }

  private InsightName(BillingAccountLocationInsightTypeInsightBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightType = Preconditions.checkNotNull(builder.getInsightType());
    insight = Preconditions.checkNotNull(builder.getInsight());
    project = null;
    folder = null;
    organization = null;
    pathTemplate = BILLING_ACCOUNT_LOCATION_INSIGHT_TYPE_INSIGHT;
  }

  private InsightName(FolderLocationInsightTypeInsightBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightType = Preconditions.checkNotNull(builder.getInsightType());
    insight = Preconditions.checkNotNull(builder.getInsight());
    project = null;
    billingAccount = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_INSIGHT_TYPE_INSIGHT;
  }

  private InsightName(OrganizationLocationInsightTypeInsightBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightType = Preconditions.checkNotNull(builder.getInsightType());
    insight = Preconditions.checkNotNull(builder.getInsight());
    project = null;
    billingAccount = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_INSIGHT_TYPE_INSIGHT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInsightType() {
    return insightType;
  }

  public String getInsight() {
    return insight;
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationInsightTypeInsightBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static BillingAccountLocationInsightTypeInsightBuilder
      newBillingAccountLocationInsightTypeInsightBuilder() {
    return new BillingAccountLocationInsightTypeInsightBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationInsightTypeInsightBuilder
      newFolderLocationInsightTypeInsightBuilder() {
    return new FolderLocationInsightTypeInsightBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationInsightTypeInsightBuilder
      newOrganizationLocationInsightTypeInsightBuilder() {
    return new OrganizationLocationInsightTypeInsightBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InsightName of(
      String project, String location, String insightType, String insight) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InsightName ofProjectLocationInsightTypeInsightName(
      String project, String location, String insightType, String insight) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InsightName ofBillingAccountLocationInsightTypeInsightName(
      String billingAccount, String location, String insightType, String insight) {
    return newBillingAccountLocationInsightTypeInsightBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InsightName ofFolderLocationInsightTypeInsightName(
      String folder, String location, String insightType, String insight) {
    return newFolderLocationInsightTypeInsightBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InsightName ofOrganizationLocationInsightTypeInsightName(
      String organization, String location, String insightType, String insight) {
    return newOrganizationLocationInsightTypeInsightBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build();
  }

  public static String format(String project, String location, String insightType, String insight) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationInsightTypeInsightName(
      String project, String location, String insightType, String insight) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountLocationInsightTypeInsightName(
      String billingAccount, String location, String insightType, String insight) {
    return newBillingAccountLocationInsightTypeInsightBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationInsightTypeInsightName(
      String folder, String location, String insightType, String insight) {
    return newFolderLocationInsightTypeInsightBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationInsightTypeInsightName(
      String organization, String location, String insightType, String insight) {
    return newOrganizationLocationInsightTypeInsightBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setInsightType(insightType)
        .setInsight(insight)
        .build()
        .toString();
  }

  public static InsightName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_INSIGHT_TYPE_INSIGHT.match(formattedString);
      return ofProjectLocationInsightTypeInsightName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("insight_type"),
          matchMap.get("insight"));
    } else if (BILLING_ACCOUNT_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)) {
      Map<String, String> matchMap =
          BILLING_ACCOUNT_LOCATION_INSIGHT_TYPE_INSIGHT.match(formattedString);
      return ofBillingAccountLocationInsightTypeInsightName(
          matchMap.get("billing_account"),
          matchMap.get("location"),
          matchMap.get("insight_type"),
          matchMap.get("insight"));
    } else if (FOLDER_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_INSIGHT_TYPE_INSIGHT.match(formattedString);
      return ofFolderLocationInsightTypeInsightName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("insight_type"),
          matchMap.get("insight"));
    } else if (ORGANIZATION_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_INSIGHT_TYPE_INSIGHT.match(formattedString);
      return ofOrganizationLocationInsightTypeInsightName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("insight_type"),
          matchMap.get("insight"));
    }
    throw new ValidationException("InsightName.parse: formattedString not in valid format");
  }

  public static List<InsightName> parseList(List<String> formattedStrings) {
    List<InsightName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InsightName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InsightName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)
        || BILLING_ACCOUNT_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)
        || FOLDER_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString)
        || ORGANIZATION_LOCATION_INSIGHT_TYPE_INSIGHT.matches(formattedString);
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
          if (insightType != null) {
            fieldMapBuilder.put("insight_type", insightType);
          }
          if (insight != null) {
            fieldMapBuilder.put("insight", insight);
          }
          if (billingAccount != null) {
            fieldMapBuilder.put("billing_account", billingAccount);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
    if (o != null || getClass() == o.getClass()) {
      InsightName that = ((InsightName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.insightType, that.insightType)
          && Objects.equals(this.insight, that.insight)
          && Objects.equals(this.billingAccount, that.billingAccount)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.organization, that.organization);
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(insightType);
    h *= 1000003;
    h ^= Objects.hashCode(insight);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/insightTypes/{insight_type}/insights/{insight}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String insightType;
    private String insight;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightType() {
      return insightType;
    }

    public String getInsight() {
      return insight;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInsightType(String insightType) {
      this.insightType = insightType;
      return this;
    }

    public Builder setInsight(String insight) {
      this.insight = insight;
      return this;
    }

    private Builder(InsightName insightName) {
      Preconditions.checkArgument(
          Objects.equals(insightName.pathTemplate, PROJECT_LOCATION_INSIGHT_TYPE_INSIGHT),
          "toBuilder is only supported when InsightName has the pattern of projects/{project}/locations/{location}/insightTypes/{insight_type}/insights/{insight}");
      project = insightName.project;
      location = insightName.location;
      insightType = insightName.insightType;
      insight = insightName.insight;
    }

    public InsightName build() {
      return new InsightName(this);
    }
  }

  /**
   * Builder for
   * billingAccounts/{billing_account}/locations/{location}/insightTypes/{insight_type}/insights/{insight}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class BillingAccountLocationInsightTypeInsightBuilder {
    private String billingAccount;
    private String location;
    private String insightType;
    private String insight;

    protected BillingAccountLocationInsightTypeInsightBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightType() {
      return insightType;
    }

    public String getInsight() {
      return insight;
    }

    public BillingAccountLocationInsightTypeInsightBuilder setBillingAccount(
        String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountLocationInsightTypeInsightBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public BillingAccountLocationInsightTypeInsightBuilder setInsightType(String insightType) {
      this.insightType = insightType;
      return this;
    }

    public BillingAccountLocationInsightTypeInsightBuilder setInsight(String insight) {
      this.insight = insight;
      return this;
    }

    public InsightName build() {
      return new InsightName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/insightTypes/{insight_type}/insights/{insight}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationInsightTypeInsightBuilder {
    private String folder;
    private String location;
    private String insightType;
    private String insight;

    protected FolderLocationInsightTypeInsightBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightType() {
      return insightType;
    }

    public String getInsight() {
      return insight;
    }

    public FolderLocationInsightTypeInsightBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationInsightTypeInsightBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationInsightTypeInsightBuilder setInsightType(String insightType) {
      this.insightType = insightType;
      return this;
    }

    public FolderLocationInsightTypeInsightBuilder setInsight(String insight) {
      this.insight = insight;
      return this;
    }

    public InsightName build() {
      return new InsightName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/insightTypes/{insight_type}/insights/{insight}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationInsightTypeInsightBuilder {
    private String organization;
    private String location;
    private String insightType;
    private String insight;

    protected OrganizationLocationInsightTypeInsightBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightType() {
      return insightType;
    }

    public String getInsight() {
      return insight;
    }

    public OrganizationLocationInsightTypeInsightBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationInsightTypeInsightBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationInsightTypeInsightBuilder setInsightType(String insightType) {
      this.insightType = insightType;
      return this;
    }

    public OrganizationLocationInsightTypeInsightBuilder setInsight(String insight) {
      this.insight = insight;
      return this;
    }

    public InsightName build() {
      return new InsightName(this);
    }
  }
}
