/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

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
public class EvaluationResultName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_APP_EVALUATION_EVALUATION_RESULT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apps/{app}/evaluations/{evaluation}/results/{evaluation_result}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String app;
  private final String evaluation;
  private final String evaluationResult;

  @Deprecated
  protected EvaluationResultName() {
    project = null;
    location = null;
    app = null;
    evaluation = null;
    evaluationResult = null;
  }

  private EvaluationResultName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    app = Preconditions.checkNotNull(builder.getApp());
    evaluation = Preconditions.checkNotNull(builder.getEvaluation());
    evaluationResult = Preconditions.checkNotNull(builder.getEvaluationResult());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApp() {
    return app;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public String getEvaluationResult() {
    return evaluationResult;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EvaluationResultName of(
      String project, String location, String app, String evaluation, String evaluationResult) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApp(app)
        .setEvaluation(evaluation)
        .setEvaluationResult(evaluationResult)
        .build();
  }

  public static String format(
      String project, String location, String app, String evaluation, String evaluationResult) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApp(app)
        .setEvaluation(evaluation)
        .setEvaluationResult(evaluationResult)
        .build()
        .toString();
  }

  public static EvaluationResultName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_APP_EVALUATION_EVALUATION_RESULT.validatedMatch(
            formattedString, "EvaluationResultName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("app"),
        matchMap.get("evaluation"),
        matchMap.get("evaluation_result"));
  }

  public static List<EvaluationResultName> parseList(List<String> formattedStrings) {
    List<EvaluationResultName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EvaluationResultName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EvaluationResultName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_APP_EVALUATION_EVALUATION_RESULT.matches(formattedString);
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
          if (app != null) {
            fieldMapBuilder.put("app", app);
          }
          if (evaluation != null) {
            fieldMapBuilder.put("evaluation", evaluation);
          }
          if (evaluationResult != null) {
            fieldMapBuilder.put("evaluation_result", evaluationResult);
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
    return PROJECT_LOCATION_APP_EVALUATION_EVALUATION_RESULT.instantiate(
        "project",
        project,
        "location",
        location,
        "app",
        app,
        "evaluation",
        evaluation,
        "evaluation_result",
        evaluationResult);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EvaluationResultName that = ((EvaluationResultName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.app, that.app)
          && Objects.equals(this.evaluation, that.evaluation)
          && Objects.equals(this.evaluationResult, that.evaluationResult);
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
    h ^= Objects.hashCode(app);
    h *= 1000003;
    h ^= Objects.hashCode(evaluation);
    h *= 1000003;
    h ^= Objects.hashCode(evaluationResult);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apps/{app}/evaluations/{evaluation}/results/{evaluation_result}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String app;
    private String evaluation;
    private String evaluationResult;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApp() {
      return app;
    }

    public String getEvaluation() {
      return evaluation;
    }

    public String getEvaluationResult() {
      return evaluationResult;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApp(String app) {
      this.app = app;
      return this;
    }

    public Builder setEvaluation(String evaluation) {
      this.evaluation = evaluation;
      return this;
    }

    public Builder setEvaluationResult(String evaluationResult) {
      this.evaluationResult = evaluationResult;
      return this;
    }

    private Builder(EvaluationResultName evaluationResultName) {
      this.project = evaluationResultName.project;
      this.location = evaluationResultName.location;
      this.app = evaluationResultName.app;
      this.evaluation = evaluationResultName.evaluation;
      this.evaluationResult = evaluationResultName.evaluationResult;
    }

    public EvaluationResultName build() {
      return new EvaluationResultName(this);
    }
  }
}
