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
public class AnnotationSpecName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASET_ANNOTATION_SPEC =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataset;
  private final String annotationSpec;

  @Deprecated
  protected AnnotationSpecName() {
    project = null;
    location = null;
    dataset = null;
    annotationSpec = null;
  }

  private AnnotationSpecName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    annotationSpec = Preconditions.checkNotNull(builder.getAnnotationSpec());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataset() {
    return dataset;
  }

  public String getAnnotationSpec() {
    return annotationSpec;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnnotationSpecName of(
      String project, String location, String dataset, String annotationSpec) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setAnnotationSpec(annotationSpec)
        .build();
  }

  public static String format(
      String project, String location, String dataset, String annotationSpec) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setAnnotationSpec(annotationSpec)
        .build()
        .toString();
  }

  public static AnnotationSpecName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASET_ANNOTATION_SPEC.validatedMatch(
            formattedString, "AnnotationSpecName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataset"),
        matchMap.get("annotation_spec"));
  }

  public static List<AnnotationSpecName> parseList(List<String> formattedStrings) {
    List<AnnotationSpecName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnnotationSpecName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnnotationSpecName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASET_ANNOTATION_SPEC.matches(formattedString);
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
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
          }
          if (annotationSpec != null) {
            fieldMapBuilder.put("annotation_spec", annotationSpec);
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
    return PROJECT_LOCATION_DATASET_ANNOTATION_SPEC.instantiate(
        "project",
        project,
        "location",
        location,
        "dataset",
        dataset,
        "annotation_spec",
        annotationSpec);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AnnotationSpecName that = ((AnnotationSpecName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataset, that.dataset)
          && Objects.equals(this.annotationSpec, that.annotationSpec);
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
    h ^= Objects.hashCode(dataset);
    h *= 1000003;
    h ^= Objects.hashCode(annotationSpec);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/datasets/{dataset}/annotationSpecs/{annotation_spec}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataset;
    private String annotationSpec;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataset() {
      return dataset;
    }

    public String getAnnotationSpec() {
      return annotationSpec;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setAnnotationSpec(String annotationSpec) {
      this.annotationSpec = annotationSpec;
      return this;
    }

    private Builder(AnnotationSpecName annotationSpecName) {
      project = annotationSpecName.project;
      location = annotationSpecName.location;
      dataset = annotationSpecName.dataset;
      annotationSpec = annotationSpecName.annotationSpec;
    }

    public AnnotationSpecName build() {
      return new AnnotationSpecName(this);
    }
  }
}
