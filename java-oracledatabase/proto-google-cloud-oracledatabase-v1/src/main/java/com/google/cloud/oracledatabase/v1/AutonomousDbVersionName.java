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
public class AutonomousDbVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUTONOMOUS_DB_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/autonomousDbVersions/{autonomous_db_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String autonomousDbVersion;

  @Deprecated
  protected AutonomousDbVersionName() {
    project = null;
    location = null;
    autonomousDbVersion = null;
  }

  private AutonomousDbVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    autonomousDbVersion = Preconditions.checkNotNull(builder.getAutonomousDbVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAutonomousDbVersion() {
    return autonomousDbVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutonomousDbVersionName of(
      String project, String location, String autonomousDbVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutonomousDbVersion(autonomousDbVersion)
        .build();
  }

  public static String format(String project, String location, String autonomousDbVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutonomousDbVersion(autonomousDbVersion)
        .build()
        .toString();
  }

  public static AutonomousDbVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AUTONOMOUS_DB_VERSION.validatedMatch(
            formattedString, "AutonomousDbVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("autonomous_db_version"));
  }

  public static List<AutonomousDbVersionName> parseList(List<String> formattedStrings) {
    List<AutonomousDbVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutonomousDbVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutonomousDbVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUTONOMOUS_DB_VERSION.matches(formattedString);
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
          if (autonomousDbVersion != null) {
            fieldMapBuilder.put("autonomous_db_version", autonomousDbVersion);
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
    return PROJECT_LOCATION_AUTONOMOUS_DB_VERSION.instantiate(
        "project", project, "location", location, "autonomous_db_version", autonomousDbVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutonomousDbVersionName that = ((AutonomousDbVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.autonomousDbVersion, that.autonomousDbVersion);
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
    h ^= Objects.hashCode(autonomousDbVersion);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/autonomousDbVersions/{autonomous_db_version}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String autonomousDbVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAutonomousDbVersion() {
      return autonomousDbVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAutonomousDbVersion(String autonomousDbVersion) {
      this.autonomousDbVersion = autonomousDbVersion;
      return this;
    }

    private Builder(AutonomousDbVersionName autonomousDbVersionName) {
      this.project = autonomousDbVersionName.project;
      this.location = autonomousDbVersionName.location;
      this.autonomousDbVersion = autonomousDbVersionName.autonomousDbVersion;
    }

    public AutonomousDbVersionName build() {
      return new AutonomousDbVersionName(this);
    }
  }
}
