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

package com.google.bigtable.admin.v2;

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
  private static final PathTemplate PROJECT_INSTANCE_CLUSTER_BACKUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instance;
  private final String cluster;
  private final String backup;

  @Deprecated
  protected BackupName() {
    project = null;
    instance = null;
    cluster = null;
    backup = null;
  }

  private BackupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    backup = Preconditions.checkNotNull(builder.getBackup());
  }

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getCluster() {
    return cluster;
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

  public static BackupName of(String project, String instance, String cluster, String backup) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setCluster(cluster)
        .setBackup(backup)
        .build();
  }

  public static String format(String project, String instance, String cluster, String backup) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setCluster(cluster)
        .setBackup(backup)
        .build()
        .toString();
  }

  public static BackupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTANCE_CLUSTER_BACKUP.validatedMatch(
            formattedString, "BackupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("instance"),
        matchMap.get("cluster"),
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
    return PROJECT_INSTANCE_CLUSTER_BACKUP.matches(formattedString);
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
          if (cluster != null) {
            fieldMapBuilder.put("cluster", cluster);
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
    return PROJECT_INSTANCE_CLUSTER_BACKUP.instantiate(
        "project", project, "instance", instance, "cluster", cluster, "backup", backup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      BackupName that = ((BackupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.cluster, that.cluster)
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
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(cluster);
    h *= 1000003;
    h ^= Objects.hashCode(backup);
    return h;
  }

  /** Builder for projects/{project}/instances/{instance}/clusters/{cluster}/backups/{backup}. */
  public static class Builder {
    private String project;
    private String instance;
    private String cluster;
    private String backup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getCluster() {
      return cluster;
    }

    public String getBackup() {
      return backup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public Builder setBackup(String backup) {
      this.backup = backup;
      return this;
    }

    private Builder(BackupName backupName) {
      this.project = backupName.project;
      this.instance = backupName.instance;
      this.cluster = backupName.cluster;
      this.backup = backupName.backup;
    }

    public BackupName build() {
      return new BackupName(this);
    }
  }
}
