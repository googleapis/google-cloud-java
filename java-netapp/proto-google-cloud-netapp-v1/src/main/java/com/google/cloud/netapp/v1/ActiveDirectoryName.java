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

package com.google.cloud.netapp.v1;

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
public class ActiveDirectoryName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ACTIVE_DIRECTORY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/activeDirectories/{active_directory}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String activeDirectory;

  @Deprecated
  protected ActiveDirectoryName() {
    project = null;
    location = null;
    activeDirectory = null;
  }

  private ActiveDirectoryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    activeDirectory = Preconditions.checkNotNull(builder.getActiveDirectory());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getActiveDirectory() {
    return activeDirectory;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ActiveDirectoryName of(String project, String location, String activeDirectory) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setActiveDirectory(activeDirectory)
        .build();
  }

  public static String format(String project, String location, String activeDirectory) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setActiveDirectory(activeDirectory)
        .build()
        .toString();
  }

  public static ActiveDirectoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ACTIVE_DIRECTORY.validatedMatch(
            formattedString, "ActiveDirectoryName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("active_directory"));
  }

  public static List<ActiveDirectoryName> parseList(List<String> formattedStrings) {
    List<ActiveDirectoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ActiveDirectoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ActiveDirectoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ACTIVE_DIRECTORY.matches(formattedString);
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
          if (activeDirectory != null) {
            fieldMapBuilder.put("active_directory", activeDirectory);
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
    return PROJECT_LOCATION_ACTIVE_DIRECTORY.instantiate(
        "project", project, "location", location, "active_directory", activeDirectory);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ActiveDirectoryName that = ((ActiveDirectoryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.activeDirectory, that.activeDirectory);
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
    h ^= Objects.hashCode(activeDirectory);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/activeDirectories/{active_directory}. */
  public static class Builder {
    private String project;
    private String location;
    private String activeDirectory;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getActiveDirectory() {
      return activeDirectory;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setActiveDirectory(String activeDirectory) {
      this.activeDirectory = activeDirectory;
      return this;
    }

    private Builder(ActiveDirectoryName activeDirectoryName) {
      this.project = activeDirectoryName.project;
      this.location = activeDirectoryName.location;
      this.activeDirectory = activeDirectoryName.activeDirectory;
    }

    public ActiveDirectoryName build() {
      return new ActiveDirectoryName(this);
    }
  }
}
