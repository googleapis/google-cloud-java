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

package com.google.cloud.oracledatabase.v1;

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
public class AutonomousDatabaseBackupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUTONOMOUS_DATABASE_BACKUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/autonomousDatabaseBackups/{autonomous_database_backup}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String autonomousDatabaseBackup;

  @Deprecated
  protected AutonomousDatabaseBackupName() {
    project = null;
    location = null;
    autonomousDatabaseBackup = null;
  }

  private AutonomousDatabaseBackupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    autonomousDatabaseBackup = Preconditions.checkNotNull(builder.getAutonomousDatabaseBackup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAutonomousDatabaseBackup() {
    return autonomousDatabaseBackup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutonomousDatabaseBackupName of(
      String project, String location, String autonomousDatabaseBackup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutonomousDatabaseBackup(autonomousDatabaseBackup)
        .build();
  }

  public static String format(String project, String location, String autonomousDatabaseBackup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutonomousDatabaseBackup(autonomousDatabaseBackup)
        .build()
        .toString();
  }

  public static AutonomousDatabaseBackupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AUTONOMOUS_DATABASE_BACKUP.validatedMatch(
            formattedString,
            "AutonomousDatabaseBackupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("autonomous_database_backup"));
  }

  public static List<AutonomousDatabaseBackupName> parseList(List<String> formattedStrings) {
    List<AutonomousDatabaseBackupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutonomousDatabaseBackupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutonomousDatabaseBackupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUTONOMOUS_DATABASE_BACKUP.matches(formattedString);
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
          if (autonomousDatabaseBackup != null) {
            fieldMapBuilder.put("autonomous_database_backup", autonomousDatabaseBackup);
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
    return PROJECT_LOCATION_AUTONOMOUS_DATABASE_BACKUP.instantiate(
        "project",
        project,
        "location",
        location,
        "autonomous_database_backup",
        autonomousDatabaseBackup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutonomousDatabaseBackupName that = ((AutonomousDatabaseBackupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.autonomousDatabaseBackup, that.autonomousDatabaseBackup);
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
    h ^= Objects.hashCode(autonomousDatabaseBackup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/autonomousDatabaseBackups/{autonomous_database_backup}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String autonomousDatabaseBackup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAutonomousDatabaseBackup() {
      return autonomousDatabaseBackup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAutonomousDatabaseBackup(String autonomousDatabaseBackup) {
      this.autonomousDatabaseBackup = autonomousDatabaseBackup;
      return this;
    }

    private Builder(AutonomousDatabaseBackupName autonomousDatabaseBackupName) {
      this.project = autonomousDatabaseBackupName.project;
      this.location = autonomousDatabaseBackupName.location;
      this.autonomousDatabaseBackup = autonomousDatabaseBackupName.autonomousDatabaseBackup;
    }

    public AutonomousDatabaseBackupName build() {
      return new AutonomousDatabaseBackupName(this);
    }
  }
}
