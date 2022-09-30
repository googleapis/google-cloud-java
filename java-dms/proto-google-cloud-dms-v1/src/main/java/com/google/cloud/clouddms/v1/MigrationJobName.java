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

package com.google.cloud.clouddms.v1;

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
public class MigrationJobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MIGRATION_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/migrationJobs/{migration_job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String migrationJob;

  @Deprecated
  protected MigrationJobName() {
    project = null;
    location = null;
    migrationJob = null;
  }

  private MigrationJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    migrationJob = Preconditions.checkNotNull(builder.getMigrationJob());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMigrationJob() {
    return migrationJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MigrationJobName of(String project, String location, String migrationJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMigrationJob(migrationJob)
        .build();
  }

  public static String format(String project, String location, String migrationJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMigrationJob(migrationJob)
        .build()
        .toString();
  }

  public static MigrationJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MIGRATION_JOB.validatedMatch(
            formattedString, "MigrationJobName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("migration_job"));
  }

  public static List<MigrationJobName> parseList(List<String> formattedStrings) {
    List<MigrationJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MigrationJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MigrationJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MIGRATION_JOB.matches(formattedString);
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
          if (migrationJob != null) {
            fieldMapBuilder.put("migration_job", migrationJob);
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
    return PROJECT_LOCATION_MIGRATION_JOB.instantiate(
        "project", project, "location", location, "migration_job", migrationJob);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MigrationJobName that = ((MigrationJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.migrationJob, that.migrationJob);
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
    h ^= Objects.hashCode(migrationJob);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/migrationJobs/{migration_job}. */
  public static class Builder {
    private String project;
    private String location;
    private String migrationJob;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMigrationJob() {
      return migrationJob;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMigrationJob(String migrationJob) {
      this.migrationJob = migrationJob;
      return this;
    }

    private Builder(MigrationJobName migrationJobName) {
      this.project = migrationJobName.project;
      this.location = migrationJobName.location;
      this.migrationJob = migrationJobName.migrationJob;
    }

    public MigrationJobName build() {
      return new MigrationJobName(this);
    }
  }
}
