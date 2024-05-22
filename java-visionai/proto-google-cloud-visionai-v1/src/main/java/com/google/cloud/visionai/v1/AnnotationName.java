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

package com.google.cloud.visionai.v1;

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
public class AnnotationName implements ResourceName {
  private static final PathTemplate PROJECT_NUMBER_LOCATION_CORPUS_ASSET_ANNOTATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String projectNumber;
  private final String location;
  private final String corpus;
  private final String asset;
  private final String annotation;

  @Deprecated
  protected AnnotationName() {
    projectNumber = null;
    location = null;
    corpus = null;
    asset = null;
    annotation = null;
  }

  private AnnotationName(Builder builder) {
    projectNumber = Preconditions.checkNotNull(builder.getProjectNumber());
    location = Preconditions.checkNotNull(builder.getLocation());
    corpus = Preconditions.checkNotNull(builder.getCorpus());
    asset = Preconditions.checkNotNull(builder.getAsset());
    annotation = Preconditions.checkNotNull(builder.getAnnotation());
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public String getLocation() {
    return location;
  }

  public String getCorpus() {
    return corpus;
  }

  public String getAsset() {
    return asset;
  }

  public String getAnnotation() {
    return annotation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnnotationName of(
      String projectNumber, String location, String corpus, String asset, String annotation) {
    return newBuilder()
        .setProjectNumber(projectNumber)
        .setLocation(location)
        .setCorpus(corpus)
        .setAsset(asset)
        .setAnnotation(annotation)
        .build();
  }

  public static String format(
      String projectNumber, String location, String corpus, String asset, String annotation) {
    return newBuilder()
        .setProjectNumber(projectNumber)
        .setLocation(location)
        .setCorpus(corpus)
        .setAsset(asset)
        .setAnnotation(annotation)
        .build()
        .toString();
  }

  public static AnnotationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_NUMBER_LOCATION_CORPUS_ASSET_ANNOTATION.validatedMatch(
            formattedString, "AnnotationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project_number"),
        matchMap.get("location"),
        matchMap.get("corpus"),
        matchMap.get("asset"),
        matchMap.get("annotation"));
  }

  public static List<AnnotationName> parseList(List<String> formattedStrings) {
    List<AnnotationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnnotationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnnotationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_NUMBER_LOCATION_CORPUS_ASSET_ANNOTATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (projectNumber != null) {
            fieldMapBuilder.put("project_number", projectNumber);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (corpus != null) {
            fieldMapBuilder.put("corpus", corpus);
          }
          if (asset != null) {
            fieldMapBuilder.put("asset", asset);
          }
          if (annotation != null) {
            fieldMapBuilder.put("annotation", annotation);
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
    return PROJECT_NUMBER_LOCATION_CORPUS_ASSET_ANNOTATION.instantiate(
        "project_number",
        projectNumber,
        "location",
        location,
        "corpus",
        corpus,
        "asset",
        asset,
        "annotation",
        annotation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AnnotationName that = ((AnnotationName) o);
      return Objects.equals(this.projectNumber, that.projectNumber)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.corpus, that.corpus)
          && Objects.equals(this.asset, that.asset)
          && Objects.equals(this.annotation, that.annotation);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(projectNumber);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(corpus);
    h *= 1000003;
    h ^= Objects.hashCode(asset);
    h *= 1000003;
    h ^= Objects.hashCode(annotation);
    return h;
  }

  /**
   * Builder for
   * projects/{project_number}/locations/{location}/corpora/{corpus}/assets/{asset}/annotations/{annotation}.
   */
  public static class Builder {
    private String projectNumber;
    private String location;
    private String corpus;
    private String asset;
    private String annotation;

    protected Builder() {}

    public String getProjectNumber() {
      return projectNumber;
    }

    public String getLocation() {
      return location;
    }

    public String getCorpus() {
      return corpus;
    }

    public String getAsset() {
      return asset;
    }

    public String getAnnotation() {
      return annotation;
    }

    public Builder setProjectNumber(String projectNumber) {
      this.projectNumber = projectNumber;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCorpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    public Builder setAsset(String asset) {
      this.asset = asset;
      return this;
    }

    public Builder setAnnotation(String annotation) {
      this.annotation = annotation;
      return this;
    }

    private Builder(AnnotationName annotationName) {
      this.projectNumber = annotationName.projectNumber;
      this.location = annotationName.location;
      this.corpus = annotationName.corpus;
      this.asset = annotationName.asset;
      this.annotation = annotationName.annotation;
    }

    public AnnotationName build() {
      return new AnnotationName(this);
    }
  }
}
