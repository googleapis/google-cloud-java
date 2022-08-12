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

package com.google.cloud.notebooks.v1;

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
public class ScheduleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SCHEDULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/location/{location}/schedules/{schedule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String schedule;

  @Deprecated
  protected ScheduleName() {
    project = null;
    location = null;
    schedule = null;
  }

  private ScheduleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    schedule = Preconditions.checkNotNull(builder.getSchedule());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSchedule() {
    return schedule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ScheduleName of(String project, String location, String schedule) {
    return newBuilder().setProject(project).setLocation(location).setSchedule(schedule).build();
  }

  public static String format(String project, String location, String schedule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSchedule(schedule)
        .build()
        .toString();
  }

  public static ScheduleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SCHEDULE.validatedMatch(
            formattedString, "ScheduleName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("schedule"));
  }

  public static List<ScheduleName> parseList(List<String> formattedStrings) {
    List<ScheduleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ScheduleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ScheduleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SCHEDULE.matches(formattedString);
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
          if (schedule != null) {
            fieldMapBuilder.put("schedule", schedule);
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
    return PROJECT_LOCATION_SCHEDULE.instantiate(
        "project", project, "location", location, "schedule", schedule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ScheduleName that = ((ScheduleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.schedule, that.schedule);
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
    h ^= Objects.hashCode(schedule);
    return h;
  }

  /** Builder for projects/{project}/location/{location}/schedules/{schedule}. */
  public static class Builder {
    private String project;
    private String location;
    private String schedule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSchedule() {
      return schedule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSchedule(String schedule) {
      this.schedule = schedule;
      return this;
    }

    private Builder(ScheduleName scheduleName) {
      this.project = scheduleName.project;
      this.location = scheduleName.location;
      this.schedule = scheduleName.schedule;
    }

    public ScheduleName build() {
      return new ScheduleName(this);
    }
  }
}
