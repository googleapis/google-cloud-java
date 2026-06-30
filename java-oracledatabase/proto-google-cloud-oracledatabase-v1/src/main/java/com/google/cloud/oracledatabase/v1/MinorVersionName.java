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
public class MinorVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GI_VERSION_MINOR_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/giVersions/{gi_version}/minorVersions/{minor_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String giVersion;
  private final String minorVersion;

  @Deprecated
  protected MinorVersionName() {
    project = null;
    location = null;
    giVersion = null;
    minorVersion = null;
  }

  private MinorVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    giVersion = Preconditions.checkNotNull(builder.getGiVersion());
    minorVersion = Preconditions.checkNotNull(builder.getMinorVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGiVersion() {
    return giVersion;
  }

  public String getMinorVersion() {
    return minorVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MinorVersionName of(
      String project, String location, String giVersion, String minorVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGiVersion(giVersion)
        .setMinorVersion(minorVersion)
        .build();
  }

  public static String format(
      String project, String location, String giVersion, String minorVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGiVersion(giVersion)
        .setMinorVersion(minorVersion)
        .build()
        .toString();
  }

  public static MinorVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GI_VERSION_MINOR_VERSION.validatedMatch(
            formattedString, "MinorVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("gi_version"),
        matchMap.get("minor_version"));
  }

  public static List<MinorVersionName> parseList(List<String> formattedStrings) {
    List<MinorVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MinorVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MinorVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GI_VERSION_MINOR_VERSION.matches(formattedString);
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
          if (giVersion != null) {
            fieldMapBuilder.put("gi_version", giVersion);
          }
          if (minorVersion != null) {
            fieldMapBuilder.put("minor_version", minorVersion);
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
    return PROJECT_LOCATION_GI_VERSION_MINOR_VERSION.instantiate(
        "project",
        project,
        "location",
        location,
        "gi_version",
        giVersion,
        "minor_version",
        minorVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MinorVersionName that = ((MinorVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.giVersion, that.giVersion)
          && Objects.equals(this.minorVersion, that.minorVersion);
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
    h ^= Objects.hashCode(giVersion);
    h *= 1000003;
    h ^= Objects.hashCode(minorVersion);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/giVersions/{gi_version}/minorVersions/{minor_version}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String giVersion;
    private String minorVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGiVersion() {
      return giVersion;
    }

    public String getMinorVersion() {
      return minorVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGiVersion(String giVersion) {
      this.giVersion = giVersion;
      return this;
    }

    public Builder setMinorVersion(String minorVersion) {
      this.minorVersion = minorVersion;
      return this;
    }

    private Builder(MinorVersionName minorVersionName) {
      this.project = minorVersionName.project;
      this.location = minorVersionName.location;
      this.giVersion = minorVersionName.giVersion;
      this.minorVersion = minorVersionName.minorVersion;
    }

    public MinorVersionName build() {
      return new MinorVersionName(this);
    }
  }
}
