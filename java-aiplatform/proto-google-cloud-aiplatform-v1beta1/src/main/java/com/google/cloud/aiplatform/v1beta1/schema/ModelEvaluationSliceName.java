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

package com.google.cloud.aiplatform.v1beta1.schema;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ModelEvaluationSliceName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}/slices/{slice}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String model;
  private final String evaluation;
  private final String slice;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getModel() {
    return model;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public String getSlice() {
    return slice;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ModelEvaluationSliceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    model = Preconditions.checkNotNull(builder.getModel());
    evaluation = Preconditions.checkNotNull(builder.getEvaluation());
    slice = Preconditions.checkNotNull(builder.getSlice());
  }

  public static ModelEvaluationSliceName of(
      String project, String location, String model, String evaluation, String slice) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setModel(model)
        .setEvaluation(evaluation)
        .setSlice(slice)
        .build();
  }

  public static String format(
      String project, String location, String model, String evaluation, String slice) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setModel(model)
        .setEvaluation(evaluation)
        .setSlice(slice)
        .build()
        .toString();
  }

  public static ModelEvaluationSliceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ModelEvaluationSliceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("model"),
        matchMap.get("evaluation"),
        matchMap.get("slice"));
  }

  public static List<ModelEvaluationSliceName> parseList(List<String> formattedStrings) {
    List<ModelEvaluationSliceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ModelEvaluationSliceName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ModelEvaluationSliceName value : values) {
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
          fieldMapBuilder.put("model", model);
          fieldMapBuilder.put("evaluation", evaluation);
          fieldMapBuilder.put("slice", slice);
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
        "model",
        model,
        "evaluation",
        evaluation,
        "slice",
        slice);
  }

  /** Builder for ModelEvaluationSliceName. */
  public static class Builder {

    private String project;
    private String location;
    private String model;
    private String evaluation;
    private String slice;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getModel() {
      return model;
    }

    public String getEvaluation() {
      return evaluation;
    }

    public String getSlice() {
      return slice;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setModel(String model) {
      this.model = model;
      return this;
    }

    public Builder setEvaluation(String evaluation) {
      this.evaluation = evaluation;
      return this;
    }

    public Builder setSlice(String slice) {
      this.slice = slice;
      return this;
    }

    private Builder() {}

    private Builder(ModelEvaluationSliceName modelEvaluationSliceName) {
      project = modelEvaluationSliceName.project;
      location = modelEvaluationSliceName.location;
      model = modelEvaluationSliceName.model;
      evaluation = modelEvaluationSliceName.evaluation;
      slice = modelEvaluationSliceName.slice;
    }

    public ModelEvaluationSliceName build() {
      return new ModelEvaluationSliceName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ModelEvaluationSliceName) {
      ModelEvaluationSliceName that = (ModelEvaluationSliceName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.model.equals(that.model))
          && (this.evaluation.equals(that.evaluation))
          && (this.slice.equals(that.slice));
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
    h ^= model.hashCode();
    h *= 1000003;
    h ^= evaluation.hashCode();
    h *= 1000003;
    h ^= slice.hashCode();
    return h;
  }
}
