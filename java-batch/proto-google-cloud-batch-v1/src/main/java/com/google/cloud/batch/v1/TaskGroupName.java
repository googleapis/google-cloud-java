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

package com.google.cloud.batch.v1;

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
public class TaskGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_JOB_TASK_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/jobs/{job}/taskGroups/{task_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String job;
  private final String taskGroup;

  @Deprecated
  protected TaskGroupName() {
    project = null;
    location = null;
    job = null;
    taskGroup = null;
  }

  private TaskGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    job = Preconditions.checkNotNull(builder.getJob());
    taskGroup = Preconditions.checkNotNull(builder.getTaskGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getJob() {
    return job;
  }

  public String getTaskGroup() {
    return taskGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TaskGroupName of(String project, String location, String job, String taskGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJob(job)
        .setTaskGroup(taskGroup)
        .build();
  }

  public static String format(String project, String location, String job, String taskGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJob(job)
        .setTaskGroup(taskGroup)
        .build()
        .toString();
  }

  public static TaskGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_JOB_TASK_GROUP.validatedMatch(
            formattedString, "TaskGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("job"),
        matchMap.get("task_group"));
  }

  public static List<TaskGroupName> parseList(List<String> formattedStrings) {
    List<TaskGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TaskGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TaskGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_JOB_TASK_GROUP.matches(formattedString);
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
          if (job != null) {
            fieldMapBuilder.put("job", job);
          }
          if (taskGroup != null) {
            fieldMapBuilder.put("task_group", taskGroup);
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
    return PROJECT_LOCATION_JOB_TASK_GROUP.instantiate(
        "project", project, "location", location, "job", job, "task_group", taskGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TaskGroupName that = ((TaskGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.job, that.job)
          && Objects.equals(this.taskGroup, that.taskGroup);
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
    h ^= Objects.hashCode(job);
    h *= 1000003;
    h ^= Objects.hashCode(taskGroup);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/jobs/{job}/taskGroups/{task_group}. */
  public static class Builder {
    private String project;
    private String location;
    private String job;
    private String taskGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getJob() {
      return job;
    }

    public String getTaskGroup() {
      return taskGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setJob(String job) {
      this.job = job;
      return this;
    }

    public Builder setTaskGroup(String taskGroup) {
      this.taskGroup = taskGroup;
      return this;
    }

    private Builder(TaskGroupName taskGroupName) {
      this.project = taskGroupName.project;
      this.location = taskGroupName.location;
      this.job = taskGroupName.job;
      this.taskGroup = taskGroupName.taskGroup;
    }

    public TaskGroupName build() {
      return new TaskGroupName(this);
    }
  }
}
