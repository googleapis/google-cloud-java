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

package com.google.cloud.dataplex.v1;

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
public class JobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_LAKE_TASK_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/lakes/{lake}/tasks/{task}/jobs/{job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String lake;
  private final String task;
  private final String job;

  @Deprecated
  protected JobName() {
    project = null;
    location = null;
    lake = null;
    task = null;
    job = null;
  }

  private JobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    lake = Preconditions.checkNotNull(builder.getLake());
    task = Preconditions.checkNotNull(builder.getTask());
    job = Preconditions.checkNotNull(builder.getJob());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getLake() {
    return lake;
  }

  public String getTask() {
    return task;
  }

  public String getJob() {
    return job;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static JobName of(String project, String location, String lake, String task, String job) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setLake(lake)
        .setTask(task)
        .setJob(job)
        .build();
  }

  public static String format(
      String project, String location, String lake, String task, String job) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setLake(lake)
        .setTask(task)
        .setJob(job)
        .build()
        .toString();
  }

  public static JobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_LAKE_TASK_JOB.validatedMatch(
            formattedString, "JobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("lake"),
        matchMap.get("task"),
        matchMap.get("job"));
  }

  public static List<JobName> parseList(List<String> formattedStrings) {
    List<JobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<JobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (JobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_LAKE_TASK_JOB.matches(formattedString);
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
          if (lake != null) {
            fieldMapBuilder.put("lake", lake);
          }
          if (task != null) {
            fieldMapBuilder.put("task", task);
          }
          if (job != null) {
            fieldMapBuilder.put("job", job);
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
    return PROJECT_LOCATION_LAKE_TASK_JOB.instantiate(
        "project", project, "location", location, "lake", lake, "task", task, "job", job);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      JobName that = ((JobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.lake, that.lake)
          && Objects.equals(this.task, that.task)
          && Objects.equals(this.job, that.job);
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
    h ^= Objects.hashCode(lake);
    h *= 1000003;
    h ^= Objects.hashCode(task);
    h *= 1000003;
    h ^= Objects.hashCode(job);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/lakes/{lake}/tasks/{task}/jobs/{job}. */
  public static class Builder {
    private String project;
    private String location;
    private String lake;
    private String task;
    private String job;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getLake() {
      return lake;
    }

    public String getTask() {
      return task;
    }

    public String getJob() {
      return job;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setLake(String lake) {
      this.lake = lake;
      return this;
    }

    public Builder setTask(String task) {
      this.task = task;
      return this;
    }

    public Builder setJob(String job) {
      this.job = job;
      return this;
    }

    private Builder(JobName jobName) {
      this.project = jobName.project;
      this.location = jobName.location;
      this.lake = jobName.lake;
      this.task = jobName.task;
      this.job = jobName.job;
    }

    public JobName build() {
      return new JobName(this);
    }
  }
}
