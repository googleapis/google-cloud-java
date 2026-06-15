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

package com.google.firestore.admin.v1;

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
  private static final PathTemplate PROJECT_DATABASE_BACKUP_SCHEDULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/backupSchedules/{backup_schedule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String database;
  private final String backupSchedule;

  @Deprecated
  protected BackupScheduleName() {
    project = null;
    database = null;
    backupSchedule = null;
  }

  private BackupScheduleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    database = Preconditions.checkNotNull(builder.getDatabase());
    backupSchedule = Preconditions.checkNotNull(builder.getBackupSchedule());
  }

  public String getProject() {
    return project;
  }

  public String getDatabase() {
    return database;
  }

  public String getBackupSchedule() {
    return backupSchedule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BackupScheduleName of(String project, String database, String backupSchedule) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setBackupSchedule(backupSchedule)
        .build();
  }

  public static String format(String project, String database, String backupSchedule) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setBackupSchedule(backupSchedule)
        .build()
        .toString();
  }

  public static BackupScheduleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DATABASE_BACKUP_SCHEDULE.validatedMatch(
            formattedString, "BackupScheduleName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("database"), matchMap.get("backup_schedule"));
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
    return PROJECT_DATABASE_BACKUP_SCHEDULE.matches(formattedString);
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
          if (database != null) {
            fieldMapBuilder.put("database", database);
          }
          if (backupSchedule != null) {
            fieldMapBuilder.put("backup_schedule", backupSchedule);
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
    return PROJECT_DATABASE_BACKUP_SCHEDULE.instantiate(
        "project", project, "database", database, "backup_schedule", backupSchedule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BackupScheduleName that = ((BackupScheduleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.database, that.database)
          && Objects.equals(this.backupSchedule, that.backupSchedule);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(database);
    h *= 1000003;
    h ^= Objects.hashCode(backupSchedule);
    return h;
  }

  /** Builder for projects/{project}/databases/{database}/backupSchedules/{backup_schedule}. */
  public static class Builder {
    private String project;
    private String database;
    private String backupSchedule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDatabase() {
      return database;
    }

    public String getBackupSchedule() {
      return backupSchedule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setBackupSchedule(String backupSchedule) {
      this.backupSchedule = backupSchedule;
      return this;
    }

    private Builder(BackupScheduleName backupScheduleName) {
      this.project = backupScheduleName.project;
      this.database = backupScheduleName.database;
      this.backupSchedule = backupScheduleName.backupSchedule;
    }

    public BackupScheduleName build() {
      return new BackupScheduleName(this);
    }
  }
}
