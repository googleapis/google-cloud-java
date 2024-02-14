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

package com.google.cloud.datacatalog.lineage.v1;

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
public class ProcessName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PROCESS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/processes/{process}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String process;

  @Deprecated
  protected ProcessName() {
    project = null;
    location = null;
    process = null;
  }

  private ProcessName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    process = Preconditions.checkNotNull(builder.getProcess());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getProcess() {
    return process;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProcessName of(String project, String location, String process) {
    return newBuilder().setProject(project).setLocation(location).setProcess(process).build();
  }

  public static String format(String project, String location, String process) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProcess(process)
        .build()
        .toString();
  }

  public static ProcessName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PROCESS.validatedMatch(
            formattedString, "ProcessName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("process"));
  }

  public static List<ProcessName> parseList(List<String> formattedStrings) {
    List<ProcessName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProcessName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProcessName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PROCESS.matches(formattedString);
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
          if (process != null) {
            fieldMapBuilder.put("process", process);
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
    return PROJECT_LOCATION_PROCESS.instantiate(
        "project", project, "location", location, "process", process);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProcessName that = ((ProcessName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.process, that.process);
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
    h ^= Objects.hashCode(process);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/processes/{process}. */
  public static class Builder {
    private String project;
    private String location;
    private String process;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getProcess() {
      return process;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setProcess(String process) {
      this.process = process;
      return this;
    }

    private Builder(ProcessName processName) {
      this.project = processName.project;
      this.location = processName.location;
      this.process = processName.process;
    }

    public ProcessName build() {
      return new ProcessName(this);
    }
  }
}
