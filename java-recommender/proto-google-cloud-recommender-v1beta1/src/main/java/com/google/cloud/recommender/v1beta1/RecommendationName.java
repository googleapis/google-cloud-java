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

package com.google.cloud.recommender.v1beta1;

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
public class RecommendationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/recommenders/{recommender}/recommendations/{recommendation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String recommender;
  private final String recommendation;

  @Deprecated
  protected RecommendationName() {
    project = null;
    location = null;
    recommender = null;
    recommendation = null;
  }

  private RecommendationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    recommender = Preconditions.checkNotNull(builder.getRecommender());
    recommendation = Preconditions.checkNotNull(builder.getRecommendation());
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

  public static Builder newBuilder() {
    return new Builder();
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

  public static RecommendationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION.validatedMatch(
            formattedString, "RecommendationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("recommender"),
        matchMap.get("recommendation"));
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
    return PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION.matches(formattedString);
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
    return PROJECT_LOCATION_RECOMMENDER_RECOMMENDATION.instantiate(
        "project",
        project,
        "location",
        location,
        "recommender",
        recommender,
        "recommendation",
        recommendation);
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
          && Objects.equals(this.recommendation, that.recommendation);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(recommender);
    h *= 1000003;
    h ^= Objects.hashCode(recommendation);
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
      project = recommendationName.project;
      location = recommendationName.location;
      recommender = recommendationName.recommender;
      recommendation = recommendationName.recommendation;
    }

    public RecommendationName build() {
      return new RecommendationName(this);
    }
  }
}
