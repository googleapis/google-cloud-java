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
public class EvaluationDatasetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_APP_EVALUATION_DATASET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apps/{app}/evaluationDatasets/{evaluation_dataset}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String app;
  private final String evaluationDataset;

  @Deprecated
  protected EvaluationDatasetName() {
    project = null;
    location = null;
    app = null;
    evaluationDataset = null;
  }

  private EvaluationDatasetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    app = Preconditions.checkNotNull(builder.getApp());
    evaluationDataset = Preconditions.checkNotNull(builder.getEvaluationDataset());
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

  public String getEvaluationDataset() {
    return evaluationDataset;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EvaluationDatasetName of(
      String project, String location, String app, String evaluationDataset) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApp(app)
        .setEvaluationDataset(evaluationDataset)
        .build();
  }

  public static String format(
      String project, String location, String app, String evaluationDataset) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApp(app)
        .setEvaluationDataset(evaluationDataset)
        .build()
        .toString();
  }

  public static EvaluationDatasetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_APP_EVALUATION_DATASET.validatedMatch(
            formattedString, "EvaluationDatasetName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("app"),
        matchMap.get("evaluation_dataset"));
  }

  public static List<EvaluationDatasetName> parseList(List<String> formattedStrings) {
    List<EvaluationDatasetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EvaluationDatasetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EvaluationDatasetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_APP_EVALUATION_DATASET.matches(formattedString);
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
          if (evaluationDataset != null) {
            fieldMapBuilder.put("evaluation_dataset", evaluationDataset);
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
    return PROJECT_LOCATION_APP_EVALUATION_DATASET.instantiate(
        "project",
        project,
        "location",
        location,
        "app",
        app,
        "evaluation_dataset",
        evaluationDataset);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EvaluationDatasetName that = ((EvaluationDatasetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.app, that.app)
          && Objects.equals(this.evaluationDataset, that.evaluationDataset);
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
    h ^= Objects.hashCode(evaluationDataset);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apps/{app}/evaluationDatasets/{evaluation_dataset}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String app;
    private String evaluationDataset;

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

    public String getEvaluationDataset() {
      return evaluationDataset;
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

    public Builder setEvaluationDataset(String evaluationDataset) {
      this.evaluationDataset = evaluationDataset;
      return this;
    }

    private Builder(EvaluationDatasetName evaluationDatasetName) {
      this.project = evaluationDatasetName.project;
      this.location = evaluationDatasetName.location;
      this.app = evaluationDatasetName.app;
      this.evaluationDataset = evaluationDatasetName.evaluationDataset;
    }

    public EvaluationDatasetName build() {
      return new EvaluationDatasetName(this);
    }
  }
}
