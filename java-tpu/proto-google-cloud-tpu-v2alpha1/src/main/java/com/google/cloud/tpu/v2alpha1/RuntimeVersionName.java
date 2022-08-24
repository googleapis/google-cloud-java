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

package com.google.cloud.tpu.v2alpha1;

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
public class RuntimeVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RUNTIME_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/runtimeVersions/{runtime_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String runtimeVersion;

  @Deprecated
  protected RuntimeVersionName() {
    project = null;
    location = null;
    runtimeVersion = null;
  }

  private RuntimeVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    runtimeVersion = Preconditions.checkNotNull(builder.getRuntimeVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRuntimeVersion() {
    return runtimeVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RuntimeVersionName of(String project, String location, String runtimeVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRuntimeVersion(runtimeVersion)
        .build();
  }

  public static String format(String project, String location, String runtimeVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRuntimeVersion(runtimeVersion)
        .build()
        .toString();
  }

  public static RuntimeVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RUNTIME_VERSION.validatedMatch(
            formattedString, "RuntimeVersionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("runtime_version"));
  }

  public static List<RuntimeVersionName> parseList(List<String> formattedStrings) {
    List<RuntimeVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RuntimeVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RuntimeVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RUNTIME_VERSION.matches(formattedString);
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
          if (runtimeVersion != null) {
            fieldMapBuilder.put("runtime_version", runtimeVersion);
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
    return PROJECT_LOCATION_RUNTIME_VERSION.instantiate(
        "project", project, "location", location, "runtime_version", runtimeVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      RuntimeVersionName that = ((RuntimeVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.runtimeVersion, that.runtimeVersion);
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
    h ^= Objects.hashCode(runtimeVersion);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/runtimeVersions/{runtime_version}. */
  public static class Builder {
    private String project;
    private String location;
    private String runtimeVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRuntimeVersion() {
      return runtimeVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRuntimeVersion(String runtimeVersion) {
      this.runtimeVersion = runtimeVersion;
      return this;
    }

    private Builder(RuntimeVersionName runtimeVersionName) {
      this.project = runtimeVersionName.project;
      this.location = runtimeVersionName.location;
      this.runtimeVersion = runtimeVersionName.runtimeVersion;
    }

    public RuntimeVersionName build() {
      return new RuntimeVersionName(this);
    }
  }
}
