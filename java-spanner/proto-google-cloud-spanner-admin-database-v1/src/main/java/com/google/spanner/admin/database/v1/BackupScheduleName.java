/*
 * Copyright 2026 Google LLC
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

package com.google.spanner.admin.database.v1;

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
public class BackupScheduleName implements ResourceName {
  private static final PathTemplate PROJECT_INSTANCE_DATABASE_SCHEDULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/instances/{instance}/databases/{database}/backupSchedules/{schedule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instance;
  private final String database;
  private final String schedule;

  @Deprecated
  protected BackupScheduleName() {
    project = null;
    instance = null;
    database = null;
    schedule = null;
  }

  private BackupScheduleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    database = Preconditions.checkNotNull(builder.getDatabase());
    schedule = Preconditions.checkNotNull(builder.getSchedule());
  }

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getDatabase() {
    return database;
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

  public static BackupScheduleName of(
      String project, String instance, String database, String schedule) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setDatabase(database)
        .setSchedule(schedule)
        .build();
  }

  public static String format(String project, String instance, String database, String schedule) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setDatabase(database)
        .setSchedule(schedule)
        .build()
        .toString();
  }

  public static BackupScheduleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTANCE_DATABASE_SCHEDULE.validatedMatch(
            formattedString, "BackupScheduleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("instance"),
        matchMap.get("database"),
        matchMap.get("schedule"));
  }

  public static List<BackupScheduleName> parseList(List<String> formattedStrings) {
    List<BackupScheduleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BackupScheduleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BackupScheduleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INSTANCE_DATABASE_SCHEDULE.matches(formattedString);
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
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (database != null) {
            fieldMapBuilder.put("database", database);
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
    return PROJECT_INSTANCE_DATABASE_SCHEDULE.instantiate(
        "project", project, "instance", instance, "database", database, "schedule", schedule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BackupScheduleName that = ((BackupScheduleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.database, that.database)
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
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(database);
    h *= 1000003;
    h ^= Objects.hashCode(schedule);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/instances/{instance}/databases/{database}/backupSchedules/{schedule}.
   */
  public static class Builder {
    private String project;
    private String instance;
    private String database;
    private String schedule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getDatabase() {
      return database;
    }

    public String getSchedule() {
      return schedule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setSchedule(String schedule) {
      this.schedule = schedule;
      return this;
    }

    private Builder(BackupScheduleName backupScheduleName) {
      this.project = backupScheduleName.project;
      this.instance = backupScheduleName.instance;
      this.database = backupScheduleName.database;
      this.schedule = backupScheduleName.schedule;
    }

    public BackupScheduleName build() {
      return new BackupScheduleName(this);
    }
  }
}
