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
public class InsightTypeConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSIGHT_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/insightTypes/{insight_type}/config");
  private static final PathTemplate ORGANIZATION_LOCATION_INSIGHT_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/insightTypes/{insight_type}/config");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String insightType;
  private final String organization;

  @Deprecated
  protected InsightTypeConfigName() {
    project = null;
    location = null;
    insightType = null;
    organization = null;
  }

  private InsightTypeConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightType = Preconditions.checkNotNull(builder.getInsightType());
    organization = null;
    pathTemplate = PROJECT_LOCATION_INSIGHT_TYPE;
  }

  private InsightTypeConfigName(OrganizationLocationInsightTypeBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightType = Preconditions.checkNotNull(builder.getInsightType());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_INSIGHT_TYPE;
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

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationInsightTypeBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationInsightTypeBuilder newOrganizationLocationInsightTypeBuilder() {
    return new OrganizationLocationInsightTypeBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InsightTypeConfigName of(String project, String location, String insightType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InsightTypeConfigName ofProjectLocationInsightTypeName(
      String project, String location, String insightType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static InsightTypeConfigName ofOrganizationLocationInsightTypeName(
      String organization, String location, String insightType) {
    return newOrganizationLocationInsightTypeBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setInsightType(insightType)
        .build();
  }

  public static String format(String project, String location, String insightType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationInsightTypeName(
      String project, String location, String insightType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightType(insightType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationInsightTypeName(
      String organization, String location, String insightType) {
    return newOrganizationLocationInsightTypeBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setInsightType(insightType)
        .build()
        .toString();
  }

  public static InsightTypeConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_INSIGHT_TYPE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_INSIGHT_TYPE.match(formattedString);
      return ofProjectLocationInsightTypeName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("insight_type"));
    } else if (ORGANIZATION_LOCATION_INSIGHT_TYPE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_INSIGHT_TYPE.match(formattedString);
      return ofOrganizationLocationInsightTypeName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("insight_type"));
    }
    throw new ValidationException(
        "InsightTypeConfigName.parse: formattedString not in valid format");
  }

  public static List<InsightTypeConfigName> parseList(List<String> formattedStrings) {
    List<InsightTypeConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InsightTypeConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InsightTypeConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSIGHT_TYPE.matches(formattedString)
        || ORGANIZATION_LOCATION_INSIGHT_TYPE.matches(formattedString);
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
      InsightTypeConfigName that = ((InsightTypeConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.insightType, that.insightType)
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
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/insightTypes/{insight_type}/config. */
  public static class Builder {
    private String project;
    private String location;
    private String insightType;

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

    private Builder(InsightTypeConfigName insightTypeConfigName) {
      Preconditions.checkArgument(
          Objects.equals(insightTypeConfigName.pathTemplate, PROJECT_LOCATION_INSIGHT_TYPE),
          "toBuilder is only supported when InsightTypeConfigName has the pattern of projects/{project}/locations/{location}/insightTypes/{insight_type}/config");
      this.project = insightTypeConfigName.project;
      this.location = insightTypeConfigName.location;
      this.insightType = insightTypeConfigName.insightType;
    }

    public InsightTypeConfigName build() {
      return new InsightTypeConfigName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/insightTypes/{insight_type}/config.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationInsightTypeBuilder {
    private String organization;
    private String location;
    private String insightType;

    protected OrganizationLocationInsightTypeBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightType() {
      return insightType;
    }

    public OrganizationLocationInsightTypeBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationInsightTypeBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationInsightTypeBuilder setInsightType(String insightType) {
      this.insightType = insightType;
      return this;
    }

    public InsightTypeConfigName build() {
      return new InsightTypeConfigName(this);
    }
  }
}
