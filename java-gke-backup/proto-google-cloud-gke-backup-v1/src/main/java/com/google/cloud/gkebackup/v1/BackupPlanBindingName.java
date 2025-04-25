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
public class BackupPlanBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BACKUP_CHANNEL_BACKUP_PLAN_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/backupChannels/{backup_channel}/backupPlanBindings/{backup_plan_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String backupChannel;
  private final String backupPlanBinding;

  @Deprecated
  protected BackupPlanBindingName() {
    project = null;
    location = null;
    backupChannel = null;
    backupPlanBinding = null;
  }

  private BackupPlanBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    backupChannel = Preconditions.checkNotNull(builder.getBackupChannel());
    backupPlanBinding = Preconditions.checkNotNull(builder.getBackupPlanBinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBackupChannel() {
    return backupChannel;
  }

  public String getBackupPlanBinding() {
    return backupPlanBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BackupPlanBindingName of(
      String project, String location, String backupChannel, String backupPlanBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupChannel(backupChannel)
        .setBackupPlanBinding(backupPlanBinding)
        .build();
  }

  public static String format(
      String project, String location, String backupChannel, String backupPlanBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBackupChannel(backupChannel)
        .setBackupPlanBinding(backupPlanBinding)
        .build()
        .toString();
  }

  public static BackupPlanBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_BACKUP_CHANNEL_BACKUP_PLAN_BINDING.validatedMatch(
            formattedString, "BackupPlanBindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("backup_channel"),
        matchMap.get("backup_plan_binding"));
  }

  public static List<BackupPlanBindingName> parseList(List<String> formattedStrings) {
    List<BackupPlanBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BackupPlanBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BackupPlanBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BACKUP_CHANNEL_BACKUP_PLAN_BINDING.matches(formattedString);
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
          if (backupChannel != null) {
            fieldMapBuilder.put("backup_channel", backupChannel);
          }
          if (backupPlanBinding != null) {
            fieldMapBuilder.put("backup_plan_binding", backupPlanBinding);
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
    return PROJECT_LOCATION_BACKUP_CHANNEL_BACKUP_PLAN_BINDING.instantiate(
        "project",
        project,
        "location",
        location,
        "backup_channel",
        backupChannel,
        "backup_plan_binding",
        backupPlanBinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BackupPlanBindingName that = ((BackupPlanBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.backupChannel, that.backupChannel)
          && Objects.equals(this.backupPlanBinding, that.backupPlanBinding);
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
    h ^= Objects.hashCode(backupChannel);
    h *= 1000003;
    h ^= Objects.hashCode(backupPlanBinding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/backupChannels/{backup_channel}/backupPlanBindings/{backup_plan_binding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String backupChannel;
    private String backupPlanBinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBackupChannel() {
      return backupChannel;
    }

    public String getBackupPlanBinding() {
      return backupPlanBinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBackupChannel(String backupChannel) {
      this.backupChannel = backupChannel;
      return this;
    }

    public Builder setBackupPlanBinding(String backupPlanBinding) {
      this.backupPlanBinding = backupPlanBinding;
      return this;
    }

    private Builder(BackupPlanBindingName backupPlanBindingName) {
      this.project = backupPlanBindingName.project;
      this.location = backupPlanBindingName.location;
      this.backupChannel = backupPlanBindingName.backupChannel;
      this.backupPlanBinding = backupPlanBindingName.backupPlanBinding;
    }

    public BackupPlanBindingName build() {
      return new BackupPlanBindingName(this);
    }
  }
}
