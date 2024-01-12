/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1;

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
public class FeatureViewName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FEATURE_ONLINE_STORE_FEATURE_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String featureOnlineStore;
  private final String featureView;

  @Deprecated
  protected FeatureViewName() {
    project = null;
    location = null;
    featureOnlineStore = null;
    featureView = null;
  }

  private FeatureViewName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    featureOnlineStore = Preconditions.checkNotNull(builder.getFeatureOnlineStore());
    featureView = Preconditions.checkNotNull(builder.getFeatureView());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFeatureOnlineStore() {
    return featureOnlineStore;
  }

  public String getFeatureView() {
    return featureView;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeatureViewName of(
      String project, String location, String featureOnlineStore, String featureView) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureOnlineStore(featureOnlineStore)
        .setFeatureView(featureView)
        .build();
  }

  public static String format(
      String project, String location, String featureOnlineStore, String featureView) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureOnlineStore(featureOnlineStore)
        .setFeatureView(featureView)
        .build()
        .toString();
  }

  public static FeatureViewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FEATURE_ONLINE_STORE_FEATURE_VIEW.validatedMatch(
            formattedString, "FeatureViewName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("feature_online_store"),
        matchMap.get("feature_view"));
  }

  public static List<FeatureViewName> parseList(List<String> formattedStrings) {
    List<FeatureViewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FeatureViewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FeatureViewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FEATURE_ONLINE_STORE_FEATURE_VIEW.matches(formattedString);
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
          if (featureOnlineStore != null) {
            fieldMapBuilder.put("feature_online_store", featureOnlineStore);
          }
          if (featureView != null) {
            fieldMapBuilder.put("feature_view", featureView);
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
    return PROJECT_LOCATION_FEATURE_ONLINE_STORE_FEATURE_VIEW.instantiate(
        "project",
        project,
        "location",
        location,
        "feature_online_store",
        featureOnlineStore,
        "feature_view",
        featureView);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FeatureViewName that = ((FeatureViewName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.featureOnlineStore, that.featureOnlineStore)
          && Objects.equals(this.featureView, that.featureView);
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
    h ^= Objects.hashCode(featureOnlineStore);
    h *= 1000003;
    h ^= Objects.hashCode(featureView);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/featureOnlineStores/{feature_online_store}/featureViews/{feature_view}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String featureOnlineStore;
    private String featureView;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFeatureOnlineStore() {
      return featureOnlineStore;
    }

    public String getFeatureView() {
      return featureView;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFeatureOnlineStore(String featureOnlineStore) {
      this.featureOnlineStore = featureOnlineStore;
      return this;
    }

    public Builder setFeatureView(String featureView) {
      this.featureView = featureView;
      return this;
    }

    private Builder(FeatureViewName featureViewName) {
      this.project = featureViewName.project;
      this.location = featureViewName.location;
      this.featureOnlineStore = featureViewName.featureOnlineStore;
      this.featureView = featureViewName.featureView;
    }

    public FeatureViewName build() {
      return new FeatureViewName(this);
    }
  }
}
