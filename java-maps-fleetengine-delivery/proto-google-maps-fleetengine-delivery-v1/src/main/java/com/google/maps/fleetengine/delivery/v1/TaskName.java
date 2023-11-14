/*
 * Copyright 2023 Google LLC
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

package com.google.maps.fleetengine.delivery.v1;

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
public class TaskName implements ResourceName {
  private static final PathTemplate PROVIDER_TASK =
      PathTemplate.createWithoutUrlEncoding("providers/{provider}/tasks/{task}");
  private volatile Map<String, String> fieldValuesMap;
  private final String provider;
  private final String task;

  @Deprecated
  protected TaskName() {
    provider = null;
    task = null;
  }

  private TaskName(Builder builder) {
    provider = Preconditions.checkNotNull(builder.getProvider());
    task = Preconditions.checkNotNull(builder.getTask());
  }

  public String getProvider() {
    return provider;
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

  public static TaskName of(String provider, String task) {
    return newBuilder().setProvider(provider).setTask(task).build();
  }

  public static String format(String provider, String task) {
    return newBuilder().setProvider(provider).setTask(task).build().toString();
  }

  public static TaskName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROVIDER_TASK.validatedMatch(
            formattedString, "TaskName.parse: formattedString not in valid format");
    return of(matchMap.get("provider"), matchMap.get("task"));
  }

  public static List<TaskName> parseList(List<String> formattedStrings) {
    List<TaskName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TaskName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return PROVIDER_TASK.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (provider != null) {
            fieldMapBuilder.put("provider", provider);
          }
          if (task != null) {
            fieldMapBuilder.put("task", task);
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
    return PROVIDER_TASK.instantiate("provider", provider, "task", task);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TaskName that = ((TaskName) o);
      return Objects.equals(this.provider, that.provider) && Objects.equals(this.task, that.task);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(provider);
    h *= 1000003;
    h ^= Objects.hashCode(task);
    return h;
  }

  /** Builder for providers/{provider}/tasks/{task}. */
  public static class Builder {
    private String provider;
    private String task;

    protected Builder() {}

    public String getProvider() {
      return provider;
    }

    public String getTask() {
      return task;
    }

    public Builder setProvider(String provider) {
      this.provider = provider;
      return this;
    }

    public Builder setTask(String task) {
      this.task = task;
      return this;
    }

    private Builder(TaskName taskName) {
      this.provider = taskName.provider;
      this.task = taskName.task;
    }

    public TaskName build() {
      return new TaskName(this);
    }
  }
}
