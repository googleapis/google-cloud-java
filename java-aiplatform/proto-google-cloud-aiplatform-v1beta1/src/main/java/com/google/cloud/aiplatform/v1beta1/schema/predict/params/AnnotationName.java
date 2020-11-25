/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.aiplatform.v1beta1.schema.predict.params;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AnnotationName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}/annotations/{annotation}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String dataset;
  private final String dataItem;
  private final String annotation;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataset() {
    return dataset;
  }

  public String getDataItem() {
    return dataItem;
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

  private AnnotationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    dataItem = Preconditions.checkNotNull(builder.getDataItem());
    annotation = Preconditions.checkNotNull(builder.getAnnotation());
  }

  public static AnnotationName of(
      String project, String location, String dataset, String dataItem, String annotation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setDataItem(dataItem)
        .setAnnotation(annotation)
        .build();
  }

  public static String format(
      String project, String location, String dataset, String dataItem, String annotation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setDataItem(dataItem)
        .setAnnotation(annotation)
        .build()
        .toString();
  }

  public static AnnotationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AnnotationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataset"),
        matchMap.get("data_item"),
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("dataset", dataset);
          fieldMapBuilder.put("dataItem", dataItem);
          fieldMapBuilder.put("annotation", annotation);
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
    return PATH_TEMPLATE.instantiate(
        "project",
        project,
        "location",
        location,
        "dataset",
        dataset,
        "data_item",
        dataItem,
        "annotation",
        annotation);
  }

  /** Builder for AnnotationName. */
  public static class Builder {

    private String project;
    private String location;
    private String dataset;
    private String dataItem;
    private String annotation;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataset() {
      return dataset;
    }

    public String getDataItem() {
      return dataItem;
    }

    public String getAnnotation() {
      return annotation;
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

    public Builder setDataItem(String dataItem) {
      this.dataItem = dataItem;
      return this;
    }

    public Builder setAnnotation(String annotation) {
      this.annotation = annotation;
      return this;
    }

    private Builder() {}

    private Builder(AnnotationName annotationName) {
      project = annotationName.project;
      location = annotationName.location;
      dataset = annotationName.dataset;
      dataItem = annotationName.dataItem;
      annotation = annotationName.annotation;
    }

    public AnnotationName build() {
      return new AnnotationName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AnnotationName) {
      AnnotationName that = (AnnotationName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.dataset.equals(that.dataset))
          && (this.dataItem.equals(that.dataItem))
          && (this.annotation.equals(that.annotation));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= dataset.hashCode();
    h *= 1000003;
    h ^= dataItem.hashCode();
    h *= 1000003;
    h ^= annotation.hashCode();
    return h;
  }
}
