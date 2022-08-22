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
public class RecommenderConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RECOMMENDER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/recommenders/{recommender}/config");
  private static final PathTemplate ORGANIZATION_LOCATION_RECOMMENDER =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/recommenders/{recommender}/config");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String recommender;
  private final String organization;

  @Deprecated
  protected RecommenderConfigName() {
    project = null;
    location = null;
    recommender = null;
    organization = null;
  }

  private RecommenderConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    organization = null;
    pathTemplate = PROJECT_LOCATION_RECOMMENDER;
  }

  private RecommenderConfigName(OrganizationLocationRecommenderBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_RECOMMENDER;
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

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationRecommenderBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationRecommenderBuilder newOrganizationLocationRecommenderBuilder() {
    return new OrganizationLocationRecommenderBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RecommenderConfigName of(String project, String location, String recommender) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RecommenderConfigName ofProjectLocationRecommenderName(
      String project, String location, String recommender) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RecommenderConfigName ofOrganizationLocationRecommenderName(
      String organization, String location, String recommender) {
    return newOrganizationLocationRecommenderBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setRecommender(recommender)
        .build();
  }

  public static String format(String project, String location, String recommender) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationRecommenderName(
      String project, String location, String recommender) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRecommender(recommender)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationRecommenderName(
      String organization, String location, String recommender) {
    return newOrganizationLocationRecommenderBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setRecommender(recommender)
        .build()
        .toString();
  }

  public static RecommenderConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_RECOMMENDER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_RECOMMENDER.match(formattedString);
      return ofProjectLocationRecommenderName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("recommender"));
    } else if (ORGANIZATION_LOCATION_RECOMMENDER.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_RECOMMENDER.match(formattedString);
      return ofOrganizationLocationRecommenderName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("recommender"));
    }
    throw new ValidationException(
        "RecommenderConfigName.parse: formattedString not in valid format");
  }

  public static List<RecommenderConfigName> parseList(List<String> formattedStrings) {
    List<RecommenderConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RecommenderConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RecommenderConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RECOMMENDER.matches(formattedString)
        || ORGANIZATION_LOCATION_RECOMMENDER.matches(formattedString);
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
      RecommenderConfigName that = ((RecommenderConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.recommender, that.recommender)
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
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/recommenders/{recommender}/config. */
  public static class Builder {
    private String project;
    private String location;
    private String recommender;

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

    private Builder(RecommenderConfigName recommenderConfigName) {
      Preconditions.checkArgument(
          Objects.equals(recommenderConfigName.pathTemplate, PROJECT_LOCATION_RECOMMENDER),
          "toBuilder is only supported when RecommenderConfigName has the pattern of projects/{project}/locations/{location}/recommenders/{recommender}/config");
      this.project = recommenderConfigName.project;
      this.location = recommenderConfigName.location;
      this.recommender = recommenderConfigName.recommender;
    }

    public RecommenderConfigName build() {
      return new RecommenderConfigName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/recommenders/{recommender}/config.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationRecommenderBuilder {
    private String organization;
    private String location;
    private String recommender;

    protected OrganizationLocationRecommenderBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getRecommender() {
      return recommender;
    }

    public OrganizationLocationRecommenderBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationRecommenderBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationRecommenderBuilder setRecommender(String recommender) {
      this.recommender = recommender;
      return this;
    }

    public RecommenderConfigName build() {
      return new RecommenderConfigName(this);
    }
  }
}
