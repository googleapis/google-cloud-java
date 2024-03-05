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

package com.google.cloud.aiplatform.v1;

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
public class FeatureName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FEATURESTORE_ENTITY_TYPE_FEATURE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}");
  private static final PathTemplate PROJECT_LOCATION_FEATURE_GROUP_FEATURE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/featureGroups/{feature_group}/features/{feature}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String featurestore;
  private final String entityType;
  private final String feature;
  private final String featureGroup;

  @Deprecated
  protected FeatureName() {
    project = null;
    location = null;
    featurestore = null;
    entityType = null;
    feature = null;
    featureGroup = null;
  }

  private FeatureName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    featurestore = Preconditions.checkNotNull(builder.getFeaturestore());
    entityType = Preconditions.checkNotNull(builder.getEntityType());
    feature = Preconditions.checkNotNull(builder.getFeature());
    featureGroup = null;
    pathTemplate = PROJECT_LOCATION_FEATURESTORE_ENTITY_TYPE_FEATURE;
  }

  private FeatureName(ProjectLocationFeatureGroupFeatureBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    featureGroup = Preconditions.checkNotNull(builder.getFeatureGroup());
    feature = Preconditions.checkNotNull(builder.getFeature());
    featurestore = null;
    entityType = null;
    pathTemplate = PROJECT_LOCATION_FEATURE_GROUP_FEATURE;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFeaturestore() {
    return featurestore;
  }

  public String getEntityType() {
    return entityType;
  }

  public String getFeature() {
    return feature;
  }

  public String getFeatureGroup() {
    return featureGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationFeaturestoreEntityTypeFeatureBuilder() {
    return new Builder();
  }

  public static ProjectLocationFeatureGroupFeatureBuilder
      newProjectLocationFeatureGroupFeatureBuilder() {
    return new ProjectLocationFeatureGroupFeatureBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeatureName of(
      String project, String location, String featurestore, String entityType, String feature) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeaturestore(featurestore)
        .setEntityType(entityType)
        .setFeature(feature)
        .build();
  }

  public static FeatureName ofProjectLocationFeaturestoreEntityTypeFeatureName(
      String project, String location, String featurestore, String entityType, String feature) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeaturestore(featurestore)
        .setEntityType(entityType)
        .setFeature(feature)
        .build();
  }

  public static FeatureName ofProjectLocationFeatureGroupFeatureName(
      String project, String location, String featureGroup, String feature) {
    return newProjectLocationFeatureGroupFeatureBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureGroup(featureGroup)
        .setFeature(feature)
        .build();
  }

  public static String format(
      String project, String location, String featurestore, String entityType, String feature) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeaturestore(featurestore)
        .setEntityType(entityType)
        .setFeature(feature)
        .build()
        .toString();
  }

  public static String formatProjectLocationFeaturestoreEntityTypeFeatureName(
      String project, String location, String featurestore, String entityType, String feature) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeaturestore(featurestore)
        .setEntityType(entityType)
        .setFeature(feature)
        .build()
        .toString();
  }

  public static String formatProjectLocationFeatureGroupFeatureName(
      String project, String location, String featureGroup, String feature) {
    return newProjectLocationFeatureGroupFeatureBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureGroup(featureGroup)
        .setFeature(feature)
        .build()
        .toString();
  }

  public static FeatureName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FEATURESTORE_ENTITY_TYPE_FEATURE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_FEATURESTORE_ENTITY_TYPE_FEATURE.match(formattedString);
      return ofProjectLocationFeaturestoreEntityTypeFeatureName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("featurestore"),
          matchMap.get("entity_type"),
          matchMap.get("feature"));
    } else if (PROJECT_LOCATION_FEATURE_GROUP_FEATURE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_FEATURE_GROUP_FEATURE.match(formattedString);
      return ofProjectLocationFeatureGroupFeatureName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("feature_group"),
          matchMap.get("feature"));
    }
    throw new ValidationException("FeatureName.parse: formattedString not in valid format");
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
    return PROJECT_LOCATION_FEATURESTORE_ENTITY_TYPE_FEATURE.matches(formattedString)
        || PROJECT_LOCATION_FEATURE_GROUP_FEATURE.matches(formattedString);
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
          if (featurestore != null) {
            fieldMapBuilder.put("featurestore", featurestore);
          }
          if (entityType != null) {
            fieldMapBuilder.put("entity_type", entityType);
          }
          if (feature != null) {
            fieldMapBuilder.put("feature", feature);
          }
          if (featureGroup != null) {
            fieldMapBuilder.put("feature_group", featureGroup);
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
      FeatureName that = ((FeatureName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.featurestore, that.featurestore)
          && Objects.equals(this.entityType, that.entityType)
          && Objects.equals(this.feature, that.feature)
          && Objects.equals(this.featureGroup, that.featureGroup);
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
    h ^= Objects.hashCode(featurestore);
    h *= 1000003;
    h ^= Objects.hashCode(entityType);
    h *= 1000003;
    h ^= Objects.hashCode(feature);
    h *= 1000003;
    h ^= Objects.hashCode(featureGroup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String featurestore;
    private String entityType;
    private String feature;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFeaturestore() {
      return featurestore;
    }

    public String getEntityType() {
      return entityType;
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

    public Builder setFeaturestore(String featurestore) {
      this.featurestore = featurestore;
      return this;
    }

    public Builder setEntityType(String entityType) {
      this.entityType = entityType;
      return this;
    }

    public Builder setFeature(String feature) {
      this.feature = feature;
      return this;
    }

    private Builder(FeatureName featureName) {
      Preconditions.checkArgument(
          Objects.equals(
              featureName.pathTemplate, PROJECT_LOCATION_FEATURESTORE_ENTITY_TYPE_FEATURE),
          "toBuilder is only supported when FeatureName has the pattern of projects/{project}/locations/{location}/featurestores/{featurestore}/entityTypes/{entity_type}/features/{feature}");
      this.project = featureName.project;
      this.location = featureName.location;
      this.featurestore = featureName.featurestore;
      this.entityType = featureName.entityType;
      this.feature = featureName.feature;
    }

    public FeatureName build() {
      return new FeatureName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/featureGroups/{feature_group}/features/{feature}.
   */
  public static class ProjectLocationFeatureGroupFeatureBuilder {
    private String project;
    private String location;
    private String featureGroup;
    private String feature;

    protected ProjectLocationFeatureGroupFeatureBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFeatureGroup() {
      return featureGroup;
    }

    public String getFeature() {
      return feature;
    }

    public ProjectLocationFeatureGroupFeatureBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationFeatureGroupFeatureBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationFeatureGroupFeatureBuilder setFeatureGroup(String featureGroup) {
      this.featureGroup = featureGroup;
      return this;
    }

    public ProjectLocationFeatureGroupFeatureBuilder setFeature(String feature) {
      this.feature = feature;
      return this;
    }

    public FeatureName build() {
      return new FeatureName(this);
    }
  }
}
