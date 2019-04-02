/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.datalabeling.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AnnotatedDatasetName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/datasets/{dataset}/annotatedDatasets/{annotated_dataset}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String dataset;
  private final String annotatedDataset;

  public String getProject() {
    return project;
  }

  public String getDataset() {
    return dataset;
  }

  public String getAnnotatedDataset() {
    return annotatedDataset;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private AnnotatedDatasetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    annotatedDataset = Preconditions.checkNotNull(builder.getAnnotatedDataset());
  }

  public static AnnotatedDatasetName of(String project, String dataset, String annotatedDataset) {
    return newBuilder()
        .setProject(project)
        .setDataset(dataset)
        .setAnnotatedDataset(annotatedDataset)
        .build();
  }

  public static String format(String project, String dataset, String annotatedDataset) {
    return newBuilder()
        .setProject(project)
        .setDataset(dataset)
        .setAnnotatedDataset(annotatedDataset)
        .build()
        .toString();
  }

  public static AnnotatedDatasetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AnnotatedDatasetName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("dataset"), matchMap.get("annotated_dataset"));
  }

  public static List<AnnotatedDatasetName> parseList(List<String> formattedStrings) {
    List<AnnotatedDatasetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnnotatedDatasetName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (AnnotatedDatasetName value : values) {
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
          fieldMapBuilder.put("dataset", dataset);
          fieldMapBuilder.put("annotatedDataset", annotatedDataset);
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
        "project", project, "dataset", dataset, "annotated_dataset", annotatedDataset);
  }

  /** Builder for AnnotatedDatasetName. */
  public static class Builder {

    private String project;
    private String dataset;
    private String annotatedDataset;

    public String getProject() {
      return project;
    }

    public String getDataset() {
      return dataset;
    }

    public String getAnnotatedDataset() {
      return annotatedDataset;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setAnnotatedDataset(String annotatedDataset) {
      this.annotatedDataset = annotatedDataset;
      return this;
    }

    private Builder() {}

    private Builder(AnnotatedDatasetName annotatedDatasetName) {
      project = annotatedDatasetName.project;
      dataset = annotatedDatasetName.dataset;
      annotatedDataset = annotatedDatasetName.annotatedDataset;
    }

    public AnnotatedDatasetName build() {
      return new AnnotatedDatasetName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AnnotatedDatasetName) {
      AnnotatedDatasetName that = (AnnotatedDatasetName) o;
      return (this.project.equals(that.project))
          && (this.dataset.equals(that.dataset))
          && (this.annotatedDataset.equals(that.annotatedDataset));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= dataset.hashCode();
    h *= 1000003;
    h ^= annotatedDataset.hashCode();
    return h;
  }
}
