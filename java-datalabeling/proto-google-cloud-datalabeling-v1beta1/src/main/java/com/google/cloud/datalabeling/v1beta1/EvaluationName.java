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

package com.google.cloud.datalabeling.v1beta1;

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
public class EvaluationName implements ResourceName {
  private static final PathTemplate PROJECT_DATASET_EVALUATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/datasets/{dataset}/evaluations/{evaluation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String dataset;
  private final String evaluation;

  @Deprecated
  protected EvaluationName() {
    project = null;
    dataset = null;
    evaluation = null;
  }

  private EvaluationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    evaluation = Preconditions.checkNotNull(builder.getEvaluation());
  }

  public String getProject() {
    return project;
  }

  public String getDataset() {
    return dataset;
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

  public static EvaluationName of(String project, String dataset, String evaluation) {
    return newBuilder().setProject(project).setDataset(dataset).setEvaluation(evaluation).build();
  }

  public static String format(String project, String dataset, String evaluation) {
    return newBuilder()
        .setProject(project)
        .setDataset(dataset)
        .setEvaluation(evaluation)
        .build()
        .toString();
  }

  public static EvaluationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DATASET_EVALUATION.validatedMatch(
            formattedString, "EvaluationName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("dataset"), matchMap.get("evaluation"));
  }

  public static List<EvaluationName> parseList(List<String> formattedStrings) {
    List<EvaluationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EvaluationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EvaluationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DATASET_EVALUATION.matches(formattedString);
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
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
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
    return PROJECT_DATASET_EVALUATION.instantiate(
        "project", project, "dataset", dataset, "evaluation", evaluation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      EvaluationName that = ((EvaluationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.dataset, that.dataset)
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
    h ^= Objects.hashCode(dataset);
    h *= 1000003;
    h ^= Objects.hashCode(evaluation);
    return h;
  }

  /** Builder for projects/{project}/datasets/{dataset}/evaluations/{evaluation}. */
  public static class Builder {
    private String project;
    private String dataset;
    private String evaluation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDataset() {
      return dataset;
    }

    public String getEvaluation() {
      return evaluation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setEvaluation(String evaluation) {
      this.evaluation = evaluation;
      return this;
    }

    private Builder(EvaluationName evaluationName) {
      this.project = evaluationName.project;
      this.dataset = evaluationName.dataset;
      this.evaluation = evaluationName.evaluation;
    }

    public EvaluationName build() {
      return new EvaluationName(this);
    }
  }
}
