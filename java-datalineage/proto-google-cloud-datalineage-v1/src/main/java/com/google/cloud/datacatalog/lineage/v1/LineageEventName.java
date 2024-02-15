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
public class LineageEventName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PROCESS_RUN_LINEAGE_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/processes/{process}/runs/{run}/lineageEvents/{lineage_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String process;
  private final String run;
  private final String lineageEvent;

  @Deprecated
  protected LineageEventName() {
    project = null;
    location = null;
    process = null;
    run = null;
    lineageEvent = null;
  }

  private LineageEventName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    process = Preconditions.checkNotNull(builder.getProcess());
    run = Preconditions.checkNotNull(builder.getRun());
    lineageEvent = Preconditions.checkNotNull(builder.getLineageEvent());
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

  public String getRun() {
    return run;
  }

  public String getLineageEvent() {
    return lineageEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LineageEventName of(
      String project, String location, String process, String run, String lineageEvent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProcess(process)
        .setRun(run)
        .setLineageEvent(lineageEvent)
        .build();
  }

  public static String format(
      String project, String location, String process, String run, String lineageEvent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProcess(process)
        .setRun(run)
        .setLineageEvent(lineageEvent)
        .build()
        .toString();
  }

  public static LineageEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PROCESS_RUN_LINEAGE_EVENT.validatedMatch(
            formattedString, "LineageEventName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("process"),
        matchMap.get("run"),
        matchMap.get("lineage_event"));
  }

  public static List<LineageEventName> parseList(List<String> formattedStrings) {
    List<LineageEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LineageEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LineageEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PROCESS_RUN_LINEAGE_EVENT.matches(formattedString);
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
          if (run != null) {
            fieldMapBuilder.put("run", run);
          }
          if (lineageEvent != null) {
            fieldMapBuilder.put("lineage_event", lineageEvent);
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
    return PROJECT_LOCATION_PROCESS_RUN_LINEAGE_EVENT.instantiate(
        "project",
        project,
        "location",
        location,
        "process",
        process,
        "run",
        run,
        "lineage_event",
        lineageEvent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LineageEventName that = ((LineageEventName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.process, that.process)
          && Objects.equals(this.run, that.run)
          && Objects.equals(this.lineageEvent, that.lineageEvent);
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
    h *= 1000003;
    h ^= Objects.hashCode(run);
    h *= 1000003;
    h ^= Objects.hashCode(lineageEvent);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/processes/{process}/runs/{run}/lineageEvents/{lineage_event}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String process;
    private String run;
    private String lineageEvent;

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

    public String getRun() {
      return run;
    }

    public String getLineageEvent() {
      return lineageEvent;
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

    public Builder setRun(String run) {
      this.run = run;
      return this;
    }

    public Builder setLineageEvent(String lineageEvent) {
      this.lineageEvent = lineageEvent;
      return this;
    }

    private Builder(LineageEventName lineageEventName) {
      this.project = lineageEventName.project;
      this.location = lineageEventName.location;
      this.process = lineageEventName.process;
      this.run = lineageEventName.run;
      this.lineageEvent = lineageEventName.lineageEvent;
    }

    public LineageEventName build() {
      return new LineageEventName(this);
    }
  }
}
