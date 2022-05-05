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

package com.google.cloud.gkehub.v1;

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
public class FeatureName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FEATURE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/features/{feature}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String feature;

  @Deprecated
  protected FeatureName() {
    project = null;
    location = null;
    feature = null;
  }

  private FeatureName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    feature = Preconditions.checkNotNull(builder.getFeature());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFeature() {
    return feature;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeatureName of(String project, String location, String feature) {
    return newBuilder().setProject(project).setLocation(location).setFeature(feature).build();
  }

  public static String format(String project, String location, String feature) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeature(feature)
        .build()
        .toString();
  }

  public static FeatureName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FEATURE.validatedMatch(
            formattedString, "FeatureName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("feature"));
  }

  public static List<FeatureName> parseList(List<String> formattedStrings) {
    List<FeatureName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FeatureName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FeatureName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FEATURE.matches(formattedString);
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
          if (feature != null) {
            fieldMapBuilder.put("feature", feature);
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
    return PROJECT_LOCATION_FEATURE.instantiate(
        "project", project, "location", location, "feature", feature);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      FeatureName that = ((FeatureName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.feature, that.feature);
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
    h ^= Objects.hashCode(feature);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/features/{feature}. */
  public static class Builder {
    private String project;
    private String location;
    private String feature;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFeature() {
      return feature;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFeature(String feature) {
      this.feature = feature;
      return this;
    }

    private Builder(FeatureName featureName) {
      this.project = featureName.project;
      this.location = featureName.location;
      this.feature = featureName.feature;
    }

    public FeatureName build() {
      return new FeatureName(this);
    }
  }
}
