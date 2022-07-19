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
public class TensorboardTimeSeriesName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TENSORBOARD_EXPERIMENT_RUN_TIME_SERIES =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String tensorboard;
  private final String experiment;
  private final String run;
  private final String timeSeries;

  @Deprecated
  protected TensorboardTimeSeriesName() {
    project = null;
    location = null;
    tensorboard = null;
    experiment = null;
    run = null;
    timeSeries = null;
  }

  private TensorboardTimeSeriesName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tensorboard = Preconditions.checkNotNull(builder.getTensorboard());
    experiment = Preconditions.checkNotNull(builder.getExperiment());
    run = Preconditions.checkNotNull(builder.getRun());
    timeSeries = Preconditions.checkNotNull(builder.getTimeSeries());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTensorboard() {
    return tensorboard;
  }

  public String getExperiment() {
    return experiment;
  }

  public String getRun() {
    return run;
  }

  public String getTimeSeries() {
    return timeSeries;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TensorboardTimeSeriesName of(
      String project,
      String location,
      String tensorboard,
      String experiment,
      String run,
      String timeSeries) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTensorboard(tensorboard)
        .setExperiment(experiment)
        .setRun(run)
        .setTimeSeries(timeSeries)
        .build();
  }

  public static String format(
      String project,
      String location,
      String tensorboard,
      String experiment,
      String run,
      String timeSeries) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTensorboard(tensorboard)
        .setExperiment(experiment)
        .setRun(run)
        .setTimeSeries(timeSeries)
        .build()
        .toString();
  }

  public static TensorboardTimeSeriesName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TENSORBOARD_EXPERIMENT_RUN_TIME_SERIES.validatedMatch(
            formattedString,
            "TensorboardTimeSeriesName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("tensorboard"),
        matchMap.get("experiment"),
        matchMap.get("run"),
        matchMap.get("time_series"));
  }

  public static List<TensorboardTimeSeriesName> parseList(List<String> formattedStrings) {
    List<TensorboardTimeSeriesName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TensorboardTimeSeriesName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TensorboardTimeSeriesName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TENSORBOARD_EXPERIMENT_RUN_TIME_SERIES.matches(formattedString);
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
          if (tensorboard != null) {
            fieldMapBuilder.put("tensorboard", tensorboard);
          }
          if (experiment != null) {
            fieldMapBuilder.put("experiment", experiment);
          }
          if (run != null) {
            fieldMapBuilder.put("run", run);
          }
          if (timeSeries != null) {
            fieldMapBuilder.put("time_series", timeSeries);
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
    return PROJECT_LOCATION_TENSORBOARD_EXPERIMENT_RUN_TIME_SERIES.instantiate(
        "project",
        project,
        "location",
        location,
        "tensorboard",
        tensorboard,
        "experiment",
        experiment,
        "run",
        run,
        "time_series",
        timeSeries);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TensorboardTimeSeriesName that = ((TensorboardTimeSeriesName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.tensorboard, that.tensorboard)
          && Objects.equals(this.experiment, that.experiment)
          && Objects.equals(this.run, that.run)
          && Objects.equals(this.timeSeries, that.timeSeries);
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
    h ^= Objects.hashCode(tensorboard);
    h *= 1000003;
    h ^= Objects.hashCode(experiment);
    h *= 1000003;
    h ^= Objects.hashCode(run);
    h *= 1000003;
    h ^= Objects.hashCode(timeSeries);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/tensorboards/{tensorboard}/experiments/{experiment}/runs/{run}/timeSeries/{time_series}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String tensorboard;
    private String experiment;
    private String run;
    private String timeSeries;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTensorboard() {
      return tensorboard;
    }

    public String getExperiment() {
      return experiment;
    }

    public String getRun() {
      return run;
    }

    public String getTimeSeries() {
      return timeSeries;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTensorboard(String tensorboard) {
      this.tensorboard = tensorboard;
      return this;
    }

    public Builder setExperiment(String experiment) {
      this.experiment = experiment;
      return this;
    }

    public Builder setRun(String run) {
      this.run = run;
      return this;
    }

    public Builder setTimeSeries(String timeSeries) {
      this.timeSeries = timeSeries;
      return this;
    }

    private Builder(TensorboardTimeSeriesName tensorboardTimeSeriesName) {
      this.project = tensorboardTimeSeriesName.project;
      this.location = tensorboardTimeSeriesName.location;
      this.tensorboard = tensorboardTimeSeriesName.tensorboard;
      this.experiment = tensorboardTimeSeriesName.experiment;
      this.run = tensorboardTimeSeriesName.run;
      this.timeSeries = tensorboardTimeSeriesName.timeSeries;
    }

    public TensorboardTimeSeriesName build() {
      return new TensorboardTimeSeriesName(this);
    }
  }
}
