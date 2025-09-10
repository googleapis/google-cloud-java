/*
 * Copyright 2025 Google LLC
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
public class MemoryName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REASONING_ENGINE_MEMORY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reasoningEngine;
  private final String memory;

  @Deprecated
  protected MemoryName() {
    project = null;
    location = null;
    reasoningEngine = null;
    memory = null;
  }

  private MemoryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reasoningEngine = Preconditions.checkNotNull(builder.getReasoningEngine());
    memory = Preconditions.checkNotNull(builder.getMemory());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getReasoningEngine() {
    return reasoningEngine;
  }

  public String getMemory() {
    return memory;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MemoryName of(
      String project, String location, String reasoningEngine, String memory) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setMemory(memory)
        .build();
  }

  public static String format(
      String project, String location, String reasoningEngine, String memory) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setMemory(memory)
        .build()
        .toString();
  }

  public static MemoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REASONING_ENGINE_MEMORY.validatedMatch(
            formattedString, "MemoryName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("reasoning_engine"),
        matchMap.get("memory"));
  }

  public static List<MemoryName> parseList(List<String> formattedStrings) {
    List<MemoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MemoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MemoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REASONING_ENGINE_MEMORY.matches(formattedString);
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
          if (reasoningEngine != null) {
            fieldMapBuilder.put("reasoning_engine", reasoningEngine);
          }
          if (memory != null) {
            fieldMapBuilder.put("memory", memory);
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
    return PROJECT_LOCATION_REASONING_ENGINE_MEMORY.instantiate(
        "project",
        project,
        "location",
        location,
        "reasoning_engine",
        reasoningEngine,
        "memory",
        memory);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MemoryName that = ((MemoryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reasoningEngine, that.reasoningEngine)
          && Objects.equals(this.memory, that.memory);
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
    h ^= Objects.hashCode(reasoningEngine);
    h *= 1000003;
    h ^= Objects.hashCode(memory);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String reasoningEngine;
    private String memory;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReasoningEngine() {
      return reasoningEngine;
    }

    public String getMemory() {
      return memory;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReasoningEngine(String reasoningEngine) {
      this.reasoningEngine = reasoningEngine;
      return this;
    }

    public Builder setMemory(String memory) {
      this.memory = memory;
      return this;
    }

    private Builder(MemoryName memoryName) {
      this.project = memoryName.project;
      this.location = memoryName.location;
      this.reasoningEngine = memoryName.reasoningEngine;
      this.memory = memoryName.memory;
    }

    public MemoryName build() {
      return new MemoryName(this);
    }
  }
}
