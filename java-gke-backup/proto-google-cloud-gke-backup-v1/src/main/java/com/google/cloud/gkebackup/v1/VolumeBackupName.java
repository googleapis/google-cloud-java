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

package com.google.cloud.gkebackup.v1;

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
public class VolumeBackupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BACKUP_PLAN_BACKUP_VOLUME_BACKUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/backupPlans/{backup_plan}/backups/{backup}/volumeBackups/{volume_backup}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String backupPlan;
  private final String backup;
  private final String volumeBackup;

  @Deprecated
  protected VolumeBackupName() {
    project = null;
    location = null;
    backupPlan = null;
    backup = null;
    volumeBackup = null;
  }

  private VolumeBackupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    backupPlan = Preconditions.checkNotNull(builder.getBackupPlan());
    backup = Preconditions.checkNotNull(builder.getBackup());
    volumeBackup = Preconditions.checkNotNull(builder.getVolumeBackup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBackupPlan() {
    return backupPlan;
  }

  public String getBackup() {
    return backup;
  }

  public String getVolumeBackup() {
    return volumeBackup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VolumeBackupName of(
      String project, String location, String backupPlan, String backup, String volumeBackup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupPlan(backupPlan)
        .setBackup(backup)
        .setVolumeBackup(volumeBackup)
        .build();
  }

  public static String format(
      String project, String location, String backupPlan, String backup, String volumeBackup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupPlan(backupPlan)
        .setBackup(backup)
        .setVolumeBackup(volumeBackup)
        .build()
        .toString();
  }

  public static VolumeBackupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_BACKUP_PLAN_BACKUP_VOLUME_BACKUP.validatedMatch(
            formattedString, "VolumeBackupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("backup_plan"),
        matchMap.get("backup"),
        matchMap.get("volume_backup"));
  }

  public static List<VolumeBackupName> parseList(List<String> formattedStrings) {
    List<VolumeBackupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VolumeBackupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VolumeBackupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BACKUP_PLAN_BACKUP_VOLUME_BACKUP.matches(formattedString);
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
          if (backupPlan != null) {
            fieldMapBuilder.put("backup_plan", backupPlan);
          }
          if (backup != null) {
            fieldMapBuilder.put("backup", backup);
          }
          if (volumeBackup != null) {
            fieldMapBuilder.put("volume_backup", volumeBackup);
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
    return PROJECT_LOCATION_BACKUP_PLAN_BACKUP_VOLUME_BACKUP.instantiate(
        "project",
        project,
        "location",
        location,
        "backup_plan",
        backupPlan,
        "backup",
        backup,
        "volume_backup",
        volumeBackup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      VolumeBackupName that = ((VolumeBackupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.backupPlan, that.backupPlan)
          && Objects.equals(this.backup, that.backup)
          && Objects.equals(this.volumeBackup, that.volumeBackup);
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
    h ^= Objects.hashCode(backupPlan);
    h *= 1000003;
    h ^= Objects.hashCode(backup);
    h *= 1000003;
    h ^= Objects.hashCode(volumeBackup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/backupPlans/{backup_plan}/backups/{backup}/volumeBackups/{volume_backup}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String backupPlan;
    private String backup;
    private String volumeBackup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBackupPlan() {
      return backupPlan;
    }

    public String getBackup() {
      return backup;
    }

    public String getVolumeBackup() {
      return volumeBackup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBackupPlan(String backupPlan) {
      this.backupPlan = backupPlan;
      return this;
    }

    public Builder setBackup(String backup) {
      this.backup = backup;
      return this;
    }

    public Builder setVolumeBackup(String volumeBackup) {
      this.volumeBackup = volumeBackup;
      return this;
    }

    private Builder(VolumeBackupName volumeBackupName) {
      this.project = volumeBackupName.project;
      this.location = volumeBackupName.location;
      this.backupPlan = volumeBackupName.backupPlan;
      this.backup = volumeBackupName.backup;
      this.volumeBackup = volumeBackupName.volumeBackup;
    }

    public VolumeBackupName build() {
      return new VolumeBackupName(this);
    }
  }
}
