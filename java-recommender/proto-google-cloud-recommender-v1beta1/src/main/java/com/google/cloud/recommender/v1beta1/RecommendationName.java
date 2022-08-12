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

package com.google.cloud.recommender.v1beta1;

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
public class RecommendationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}");
  private static final PathTemplate BILLING_ACCOUNT_LOCATION_RECOMMENDER_RECOMMENDATION =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}");
  private static final PathTemplate FOLDER_LOCATION_RECOMMENDER_RECOMMENDATION =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}");
  private static final PathTemplate ORGANIZATION_LOCATION_RECOMMENDER_RECOMMENDATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String recommender;
  private final String recommendation;
  private final String billingAccount;
  private final String folder;
  private final String organization;

  @Deprecated
  protected RecommendationName() {
    project = null;
    location = null;
    recommender = null;
    recommendation = null;
    billingAccount = null;
    folder = null;
    organization = null;
  }

  private RecommendationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    recommendation = Preconditions.checkNotNull(builder.getRecommendation());
    billingAccount = null;
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION;
  }

  private RecommendationName(BillingAccountLocationRecommenderRecommendationBuilder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    recommendation = Preconditions.checkNotNull(builder.getRecommendation());
    project = null;
    folder = null;
    organization = null;
    pathTemplate = BILLING_ACCOUNT_LOCATION_RECOMMENDER_RECOMMENDATION;
  }

  private RecommendationName(FolderLocationRecommenderRecommendationBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    recommendation = Preconditions.checkNotNull(builder.getRecommendation());
    project = null;
    billingAccount = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_RECOMMENDER_RECOMMENDATION;
  }

  private RecommendationName(OrganizationLocationRecommenderRecommendationBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    recommendation = Preconditions.checkNotNull(builder.getRecommendation());
    project = null;
    billingAccount = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_RECOMMENDER_RECOMMENDATION;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRecommender() {
    return recommender;
  }

  public String getRecommendation() {
    return recommendation;
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
  public static Builder newProjectLocationRecommenderRecommendationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static BillingAccountLocationRecommenderRecommendationBuilder
      newBillingAccountLocationRecommenderRecommendationBuilder() {
    return new BillingAccountLocationRecommenderRecommendationBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationRecommenderRecommendationBuilder
      newFolderLocationRecommenderRecommendationBuilder() {
    return new FolderLocationRecommenderRecommendationBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationRecommenderRecommendationBuilder
      newOrganizationLocationRecommenderRecommendationBuilder() {
    return new OrganizationLocationRecommenderRecommendationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RecommendationName of(
      String project, String location, String recommender, String recommendation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RecommendationName ofProjectLocationRecommenderRecommendationName(
      String project, String location, String recommender, String recommendation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RecommendationName ofBillingAccountLocationRecommenderRecommendationName(
      String billingAccount, String location, String recommender, String recommendation) {
    return newBillingAccountLocationRecommenderRecommendationBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RecommendationName ofFolderLocationRecommenderRecommendationName(
      String folder, String location, String recommender, String recommendation) {
    return newFolderLocationRecommenderRecommendationBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RecommendationName ofOrganizationLocationRecommenderRecommendationName(
      String organization, String location, String recommender, String recommendation) {
    return newOrganizationLocationRecommenderRecommendationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build();
  }

  public static String format(
      String project, String location, String recommender, String recommendation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationRecommenderRecommendationName(
      String project, String location, String recommender, String recommendation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountLocationRecommenderRecommendationName(
      String billingAccount, String location, String recommender, String recommendation) {
    return newBillingAccountLocationRecommenderRecommendationBuilder()
        .setBillingAccount(billingAccount)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationRecommenderRecommendationName(
      String folder, String location, String recommender, String recommendation) {
    return newFolderLocationRecommenderRecommendationBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationRecommenderRecommendationName(
      String organization, String location, String recommender, String recommendation) {
    return newOrganizationLocationRecommenderRecommendationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setRecommender(recommender)
        .setRecommendation(recommendation)
        .build()
        .toString();
  }

  public static RecommendationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION.match(formattedString);
      return ofProjectLocationRecommenderRecommendationName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("recommender"),
          matchMap.get("recommendation"));
    } else if (BILLING_ACCOUNT_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)) {
      Map<String, String> matchMap =
          BILLING_ACCOUNT_LOCATION_RECOMMENDER_RECOMMENDATION.match(formattedString);
      return ofBillingAccountLocationRecommenderRecommendationName(
          matchMap.get("billing_account"),
          matchMap.get("location"),
          matchMap.get("recommender"),
          matchMap.get("recommendation"));
    } else if (FOLDER_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_RECOMMENDER_RECOMMENDATION.match(formattedString);
      return ofFolderLocationRecommenderRecommendationName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("recommender"),
          matchMap.get("recommendation"));
    } else if (ORGANIZATION_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_RECOMMENDER_RECOMMENDATION.match(formattedString);
      return ofOrganizationLocationRecommenderRecommendationName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("recommender"),
          matchMap.get("recommendation"));
    }
    throw new ValidationException("RecommendationName.parse: formattedString not in valid format");
  }

  public static List<RecommendationName> parseList(List<String> formattedStrings) {
    List<RecommendationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RecommendationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RecommendationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)
        || BILLING_ACCOUNT_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)
        || FOLDER_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString)
        || ORGANIZATION_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString);
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
          if (recommender != null) {
            fieldMapBuilder.put("recommender", recommender);
          }
          if (recommendation != null) {
            fieldMapBuilder.put("recommendation", recommendation);
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
      RecommendationName that = ((RecommendationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.recommender, that.recommender)
          && Objects.equals(this.recommendation, that.recommendation)
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
    h ^= Objects.hashCode(recommender);
    h *= 1000003;
    h ^= Objects.hashCode(recommendation);
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
   * projects/{project}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String recommender;
    private String recommendation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRecommender() {
      return recommender;
    }

    public String getRecommendation() {
      return recommendation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRecommender(String recommender) {
      this.recommender = recommender;
      return this;
    }

    public Builder setRecommendation(String recommendation) {
      this.recommendation = recommendation;
      return this;
    }

    private Builder(RecommendationName recommendationName) {
      Preconditions.checkArgument(
          Objects.equals(
              recommendationName.pathTemplate, PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION),
          "toBuilder is only supported when RecommendationName has the pattern of projects/{project}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}");
      this.project = recommendationName.project;
      this.location = recommendationName.location;
      this.recommender = recommendationName.recommender;
      this.recommendation = recommendationName.recommendation;
    }

    public RecommendationName build() {
      return new RecommendationName(this);
    }
  }

  /**
   * Builder for
   * billingAccounts/{billing_account}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class BillingAccountLocationRecommenderRecommendationBuilder {
    private String billingAccount;
    private String location;
    private String recommender;
    private String recommendation;

    protected BillingAccountLocationRecommenderRecommendationBuilder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLocation() {
      return location;
    }

    public String getRecommender() {
      return recommender;
    }

    public String getRecommendation() {
      return recommendation;
    }

    public BillingAccountLocationRecommenderRecommendationBuilder setBillingAccount(
        String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountLocationRecommenderRecommendationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public BillingAccountLocationRecommenderRecommendationBuilder setRecommender(
        String recommender) {
      this.recommender = recommender;
      return this;
    }

    public BillingAccountLocationRecommenderRecommendationBuilder setRecommendation(
        String recommendation) {
      this.recommendation = recommendation;
      return this;
    }

    public RecommendationName build() {
      return new RecommendationName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationRecommenderRecommendationBuilder {
    private String folder;
    private String location;
    private String recommender;
    private String recommendation;

    protected FolderLocationRecommenderRecommendationBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getRecommender() {
      return recommender;
    }

    public String getRecommendation() {
      return recommendation;
    }

    public FolderLocationRecommenderRecommendationBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationRecommenderRecommendationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationRecommenderRecommendationBuilder setRecommender(String recommender) {
      this.recommender = recommender;
      return this;
    }

    public FolderLocationRecommenderRecommendationBuilder setRecommendation(String recommendation) {
      this.recommendation = recommendation;
      return this;
    }

    public RecommendationName build() {
      return new RecommendationName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationRecommenderRecommendationBuilder {
    private String organization;
    private String location;
    private String recommender;
    private String recommendation;

    protected OrganizationLocationRecommenderRecommendationBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getRecommender() {
      return recommender;
    }

    public String getRecommendation() {
      return recommendation;
    }

    public OrganizationLocationRecommenderRecommendationBuilder setOrganization(
        String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationRecommenderRecommendationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationRecommenderRecommendationBuilder setRecommender(String recommender) {
      this.recommender = recommender;
      return this;
    }

    public OrganizationLocationRecommenderRecommendationBuilder setRecommendation(
        String recommendation) {
      this.recommendation = recommendation;
      return this;
    }

    public RecommendationName build() {
      return new RecommendationName(this);
    }
  }
}
