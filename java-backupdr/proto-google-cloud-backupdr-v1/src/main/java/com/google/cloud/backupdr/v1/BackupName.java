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

package com.google.cloud.backupdr.v1;

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
public class BackupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BACKUPVAULT_DATASOURCE_BACKUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/backupVaults/{backupvault}/dataSources/{datasource}/backups/{backup}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String backupvault;
  private final String datasource;
  private final String backup;

  @Deprecated
  protected BackupName() {
    project = null;
    location = null;
    backupvault = null;
    datasource = null;
    backup = null;
  }

  private BackupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    backupvault = Preconditions.checkNotNull(builder.getBackupvault());
    datasource = Preconditions.checkNotNull(builder.getDatasource());
    backup = Preconditions.checkNotNull(builder.getBackup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBackupvault() {
    return backupvault;
  }

  public String getDatasource() {
    return datasource;
  }

  public String getBackup() {
    return backup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BackupName of(
      String project, String location, String backupvault, String datasource, String backup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupvault(backupvault)
        .setDatasource(datasource)
        .setBackup(backup)
        .build();
  }

  public static String format(
      String project, String location, String backupvault, String datasource, String backup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupvault(backupvault)
        .setDatasource(datasource)
        .setBackup(backup)
        .build()
        .toString();
  }

  public static BackupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_BACKUPVAULT_DATASOURCE_BACKUP.validatedMatch(
            formattedString, "BackupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("backupvault"),
        matchMap.get("datasource"),
        matchMap.get("backup"));
  }

  public static List<BackupName> parseList(List<String> formattedStrings) {
    List<BackupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BackupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BackupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BACKUPVAULT_DATASOURCE_BACKUP.matches(formattedString);
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
          if (backupvault != null) {
            fieldMapBuilder.put("backupvault", backupvault);
          }
          if (datasource != null) {
            fieldMapBuilder.put("datasource", datasource);
          }
          if (backup != null) {
            fieldMapBuilder.put("backup", backup);
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
    return PROJECT_LOCATION_BACKUPVAULT_DATASOURCE_BACKUP.instantiate(
        "project",
        project,
        "location",
        location,
        "backupvault",
        backupvault,
        "datasource",
        datasource,
        "backup",
        backup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BackupName that = ((BackupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.backupvault, that.backupvault)
          && Objects.equals(this.datasource, that.datasource)
          && Objects.equals(this.backup, that.backup);
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
    h ^= Objects.hashCode(backupvault);
    h *= 1000003;
    h ^= Objects.hashCode(datasource);
    h *= 1000003;
    h ^= Objects.hashCode(backup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/backupVaults/{backupvault}/dataSources/{datasource}/backups/{backup}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String backupvault;
    private String datasource;
    private String backup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBackupvault() {
      return backupvault;
    }

    public String getDatasource() {
      return datasource;
    }

    public String getBackup() {
      return backup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBackupvault(String backupvault) {
      this.backupvault = backupvault;
      return this;
    }

    public Builder setDatasource(String datasource) {
      this.datasource = datasource;
      return this;
    }

    public Builder setBackup(String backup) {
      this.backup = backup;
      return this;
    }

    private Builder(BackupName backupName) {
      this.project = backupName.project;
      this.location = backupName.location;
      this.backupvault = backupName.backupvault;
      this.datasource = backupName.datasource;
      this.backup = backupName.backup;
    }

    public BackupName build() {
      return new BackupName(this);
    }
  }
}
