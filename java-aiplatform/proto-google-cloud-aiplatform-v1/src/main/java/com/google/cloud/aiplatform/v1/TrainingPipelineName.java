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
public class TrainingPipelineName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TRAINING_PIPELINE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String trainingPipeline;

  @Deprecated
  protected TrainingPipelineName() {
    project = null;
    location = null;
    trainingPipeline = null;
  }

  private TrainingPipelineName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    trainingPipeline = Preconditions.checkNotNull(builder.getTrainingPipeline());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTrainingPipeline() {
    return trainingPipeline;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TrainingPipelineName of(String project, String location, String trainingPipeline) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTrainingPipeline(trainingPipeline)
        .build();
  }

  public static String format(String project, String location, String trainingPipeline) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTrainingPipeline(trainingPipeline)
        .build()
        .toString();
  }

  public static TrainingPipelineName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TRAINING_PIPELINE.validatedMatch(
            formattedString, "TrainingPipelineName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("training_pipeline"));
  }

  public static List<TrainingPipelineName> parseList(List<String> formattedStrings) {
    List<TrainingPipelineName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TrainingPipelineName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TrainingPipelineName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TRAINING_PIPELINE.matches(formattedString);
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
          if (trainingPipeline != null) {
            fieldMapBuilder.put("training_pipeline", trainingPipeline);
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
    return PROJECT_LOCATION_TRAINING_PIPELINE.instantiate(
        "project", project, "location", location, "training_pipeline", trainingPipeline);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TrainingPipelineName that = ((TrainingPipelineName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.trainingPipeline, that.trainingPipeline);
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
    h ^= Objects.hashCode(trainingPipeline);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/trainingPipelines/{training_pipeline}. */
  public static class Builder {
    private String project;
    private String location;
    private String trainingPipeline;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTrainingPipeline() {
      return trainingPipeline;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTrainingPipeline(String trainingPipeline) {
      this.trainingPipeline = trainingPipeline;
      return this;
    }

    private Builder(TrainingPipelineName trainingPipelineName) {
      project = trainingPipelineName.project;
      location = trainingPipelineName.location;
      trainingPipeline = trainingPipelineName.trainingPipeline;
    }

    public TrainingPipelineName build() {
      return new TrainingPipelineName(this);
    }
  }
}
