/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.tasks.v2beta3;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class TaskName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/queues/{queue}/tasks/{task}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String queue;
  private final String task;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getQueue() {
    return queue;
  }

  public String getTask() {
    return task;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private TaskName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    queue = Preconditions.checkNotNull(builder.getQueue());
    task = Preconditions.checkNotNull(builder.getTask());
  }

  public static TaskName of(String project, String location, String queue, String task) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setQueue(queue)
      .setTask(task)
      .build();
  }

  public static String format(String project, String location, String queue, String task) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setQueue(queue)
      .setTask(task)
      .build()
      .toString();
  }

  public static TaskName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "TaskName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("queue"), matchMap.get("task"));
  }

  public static List<TaskName> parseList(List<String> formattedStrings) {
    List<TaskName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TaskName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (TaskName value : values) {
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
          fieldMapBuilder.put("queue", queue);
          fieldMapBuilder.put("task", task);
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
    return PATH_TEMPLATE.instantiate("project", project, "location", location, "queue", queue, "task", task);
  }

  /** Builder for TaskName. */
  public static class Builder {

    private String project;
    private String location;
    private String queue;
    private String task;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getQueue() {
      return queue;
    }

    public String getTask() {
      return task;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setQueue(String queue) {
      this.queue = queue;
      return this;
    }

    public Builder setTask(String task) {
      this.task = task;
      return this;
    }

    private Builder() {
    }

    private Builder(TaskName taskName) {
      project = taskName.project;
      location = taskName.location;
      queue = taskName.queue;
      task = taskName.task;
    }

    public TaskName build() {
      return new TaskName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TaskName) {
      TaskName that = (TaskName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.queue.equals(that.queue))
          && (this.task.equals(that.task));
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
    h ^= queue.hashCode();
    h *= 1000003;
    h ^= task.hashCode();
    return h;
  }
}

