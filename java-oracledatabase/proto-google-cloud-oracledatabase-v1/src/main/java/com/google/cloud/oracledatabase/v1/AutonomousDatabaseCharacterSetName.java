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
public class AutonomousDatabaseCharacterSetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUTONOMOUS_DATABASE_CHARACTER_SET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/autonomousDatabaseCharacterSets/{autonomous_database_character_set}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String autonomousDatabaseCharacterSet;

  @Deprecated
  protected AutonomousDatabaseCharacterSetName() {
    project = null;
    location = null;
    autonomousDatabaseCharacterSet = null;
  }

  private AutonomousDatabaseCharacterSetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    autonomousDatabaseCharacterSet =
        Preconditions.checkNotNull(builder.getAutonomousDatabaseCharacterSet());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAutonomousDatabaseCharacterSet() {
    return autonomousDatabaseCharacterSet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutonomousDatabaseCharacterSetName of(
      String project, String location, String autonomousDatabaseCharacterSet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutonomousDatabaseCharacterSet(autonomousDatabaseCharacterSet)
        .build();
  }

  public static String format(
      String project, String location, String autonomousDatabaseCharacterSet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutonomousDatabaseCharacterSet(autonomousDatabaseCharacterSet)
        .build()
        .toString();
  }

  public static AutonomousDatabaseCharacterSetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AUTONOMOUS_DATABASE_CHARACTER_SET.validatedMatch(
            formattedString,
            "AutonomousDatabaseCharacterSetName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("autonomous_database_character_set"));
  }

  public static List<AutonomousDatabaseCharacterSetName> parseList(List<String> formattedStrings) {
    List<AutonomousDatabaseCharacterSetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutonomousDatabaseCharacterSetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutonomousDatabaseCharacterSetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUTONOMOUS_DATABASE_CHARACTER_SET.matches(formattedString);
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
          if (autonomousDatabaseCharacterSet != null) {
            fieldMapBuilder.put(
                "autonomous_database_character_set", autonomousDatabaseCharacterSet);
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
    return PROJECT_LOCATION_AUTONOMOUS_DATABASE_CHARACTER_SET.instantiate(
        "project",
        project,
        "location",
        location,
        "autonomous_database_character_set",
        autonomousDatabaseCharacterSet);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutonomousDatabaseCharacterSetName that = ((AutonomousDatabaseCharacterSetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.autonomousDatabaseCharacterSet, that.autonomousDatabaseCharacterSet);
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
    h ^= Objects.hashCode(autonomousDatabaseCharacterSet);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/autonomousDatabaseCharacterSets/{autonomous_database_character_set}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String autonomousDatabaseCharacterSet;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAutonomousDatabaseCharacterSet() {
      return autonomousDatabaseCharacterSet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAutonomousDatabaseCharacterSet(String autonomousDatabaseCharacterSet) {
      this.autonomousDatabaseCharacterSet = autonomousDatabaseCharacterSet;
      return this;
    }

    private Builder(AutonomousDatabaseCharacterSetName autonomousDatabaseCharacterSetName) {
      this.project = autonomousDatabaseCharacterSetName.project;
      this.location = autonomousDatabaseCharacterSetName.location;
      this.autonomousDatabaseCharacterSet =
          autonomousDatabaseCharacterSetName.autonomousDatabaseCharacterSet;
    }

    public AutonomousDatabaseCharacterSetName build() {
      return new AutonomousDatabaseCharacterSetName(this);
    }
  }
}
