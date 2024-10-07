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
public class GiVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GI_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/giVersions/{gi_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String giVersion;

  @Deprecated
  protected GiVersionName() {
    project = null;
    location = null;
    giVersion = null;
  }

  private GiVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    giVersion = Preconditions.checkNotNull(builder.getGiVersion());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GiVersionName of(String project, String location, String giVersion) {
    return newBuilder().setProject(project).setLocation(location).setGiVersion(giVersion).build();
  }

  public static String format(String project, String location, String giVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGiVersion(giVersion)
        .build()
        .toString();
  }

  public static GiVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GI_VERSION.validatedMatch(
            formattedString, "GiVersionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("gi_version"));
  }

  public static List<GiVersionName> parseList(List<String> formattedStrings) {
    List<GiVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GiVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GiVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GI_VERSION.matches(formattedString);
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
    return PROJECT_LOCATION_GI_VERSION.instantiate(
        "project", project, "location", location, "gi_version", giVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GiVersionName that = ((GiVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.giVersion, that.giVersion);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/giVersions/{gi_version}. */
  public static class Builder {
    private String project;
    private String location;
    private String giVersion;

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

    private Builder(GiVersionName giVersionName) {
      this.project = giVersionName.project;
      this.location = giVersionName.location;
      this.giVersion = giVersionName.giVersion;
    }

    public GiVersionName build() {
      return new GiVersionName(this);
    }
  }
}
