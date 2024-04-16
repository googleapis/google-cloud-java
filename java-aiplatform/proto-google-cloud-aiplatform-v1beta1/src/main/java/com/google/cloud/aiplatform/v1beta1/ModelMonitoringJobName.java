/*
 * Copyright 2024 Google LLC
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
public class ModelMonitoringJobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MODEL_MONITOR_MODEL_MONITORING_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/modelMonitors/{model_monitor}/modelMonitoringJobs/{model_monitoring_job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String modelMonitor;
  private final String modelMonitoringJob;

  @Deprecated
  protected ModelMonitoringJobName() {
    project = null;
    location = null;
    modelMonitor = null;
    modelMonitoringJob = null;
  }

  private ModelMonitoringJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    modelMonitor = Preconditions.checkNotNull(builder.getModelMonitor());
    modelMonitoringJob = Preconditions.checkNotNull(builder.getModelMonitoringJob());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getModelMonitor() {
    return modelMonitor;
  }

  public String getModelMonitoringJob() {
    return modelMonitoringJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ModelMonitoringJobName of(
      String project, String location, String modelMonitor, String modelMonitoringJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setModelMonitor(modelMonitor)
        .setModelMonitoringJob(modelMonitoringJob)
        .build();
  }

  public static String format(
      String project, String location, String modelMonitor, String modelMonitoringJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setModelMonitor(modelMonitor)
        .setModelMonitoringJob(modelMonitoringJob)
        .build()
        .toString();
  }

  public static ModelMonitoringJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MODEL_MONITOR_MODEL_MONITORING_JOB.validatedMatch(
            formattedString, "ModelMonitoringJobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("model_monitor"),
        matchMap.get("model_monitoring_job"));
  }

  public static List<ModelMonitoringJobName> parseList(List<String> formattedStrings) {
    List<ModelMonitoringJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ModelMonitoringJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ModelMonitoringJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MODEL_MONITOR_MODEL_MONITORING_JOB.matches(formattedString);
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
          if (modelMonitor != null) {
            fieldMapBuilder.put("model_monitor", modelMonitor);
          }
          if (modelMonitoringJob != null) {
            fieldMapBuilder.put("model_monitoring_job", modelMonitoringJob);
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
    return PROJECT_LOCATION_MODEL_MONITOR_MODEL_MONITORING_JOB.instantiate(
        "project",
        project,
        "location",
        location,
        "model_monitor",
        modelMonitor,
        "model_monitoring_job",
        modelMonitoringJob);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ModelMonitoringJobName that = ((ModelMonitoringJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.modelMonitor, that.modelMonitor)
          && Objects.equals(this.modelMonitoringJob, that.modelMonitoringJob);
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
    h ^= Objects.hashCode(modelMonitor);
    h *= 1000003;
    h ^= Objects.hashCode(modelMonitoringJob);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/modelMonitors/{model_monitor}/modelMonitoringJobs/{model_monitoring_job}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String modelMonitor;
    private String modelMonitoringJob;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getModelMonitor() {
      return modelMonitor;
    }

    public String getModelMonitoringJob() {
      return modelMonitoringJob;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setModelMonitor(String modelMonitor) {
      this.modelMonitor = modelMonitor;
      return this;
    }

    public Builder setModelMonitoringJob(String modelMonitoringJob) {
      this.modelMonitoringJob = modelMonitoringJob;
      return this;
    }

    private Builder(ModelMonitoringJobName modelMonitoringJobName) {
      this.project = modelMonitoringJobName.project;
      this.location = modelMonitoringJobName.location;
      this.modelMonitor = modelMonitoringJobName.modelMonitor;
      this.modelMonitoringJob = modelMonitoringJobName.modelMonitoringJob;
    }

    public ModelMonitoringJobName build() {
      return new ModelMonitoringJobName(this);
    }
  }
}
