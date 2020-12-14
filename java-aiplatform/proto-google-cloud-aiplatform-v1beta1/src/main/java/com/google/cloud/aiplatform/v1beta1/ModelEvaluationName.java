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

package com.google.cloud.aiplatform.v1beta1;

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
public class ModelEvaluationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MODEL_EVALUATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String model;
  private final String evaluation;

  @Deprecated
  protected ModelEvaluationName() {
    project = null;
    location = null;
    model = null;
    evaluation = null;
  }

  private ModelEvaluationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    model = Preconditions.checkNotNull(builder.getModel());
    evaluation = Preconditions.checkNotNull(builder.getEvaluation());
  }

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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ModelEvaluationName of(
      String project, String location, String model, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setModel(model)
        .setEvaluation(evaluation)
        .build();
  }

  public static String format(String project, String location, String model, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setModel(model)
        .setEvaluation(evaluation)
        .build()
        .toString();
  }

  public static ModelEvaluationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MODEL_EVALUATION.validatedMatch(
            formattedString, "ModelEvaluationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("model"),
        matchMap.get("evaluation"));
  }

  public static List<ModelEvaluationName> parseList(List<String> formattedStrings) {
    List<ModelEvaluationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ModelEvaluationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ModelEvaluationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MODEL_EVALUATION.matches(formattedString);
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
          if (model != null) {
            fieldMapBuilder.put("model", model);
          }
          if (evaluation != null) {
            fieldMapBuilder.put("evaluation", evaluation);
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
    return PROJECT_LOCATION_MODEL_EVALUATION.instantiate(
        "project", project, "location", location, "model", model, "evaluation", evaluation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ModelEvaluationName that = ((ModelEvaluationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.model, that.model)
          && Objects.equals(this.evaluation, that.evaluation);
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
    h ^= Objects.hashCode(model);
    h *= 1000003;
    h ^= Objects.hashCode(evaluation);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/models/{model}/evaluations/{evaluation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String model;
    private String evaluation;

    protected Builder() {}

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

    private Builder(ModelEvaluationName modelEvaluationName) {
      project = modelEvaluationName.project;
      location = modelEvaluationName.location;
      model = modelEvaluationName.model;
      evaluation = modelEvaluationName.evaluation;
    }

    public ModelEvaluationName build() {
      return new ModelEvaluationName(this);
    }
  }
}
