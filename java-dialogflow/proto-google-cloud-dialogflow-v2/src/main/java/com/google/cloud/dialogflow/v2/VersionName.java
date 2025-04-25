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

package com.google.cloud.dialogflow.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class VersionName implements ResourceName {
  private static final PathTemplate PROJECT_VERSION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/versions/{version}");
  private static final PathTemplate PROJECT_LOCATION_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/versions/{version}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String version;
  private final String location;

  @Deprecated
  protected VersionName() {
    project = null;
    version = null;
    location = null;
  }

  private VersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    version = Preconditions.checkNotNull(builder.getVersion());
    location = null;
    pathTemplate = PROJECT_VERSION;
  }

  private VersionName(ProjectLocationVersionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    version = Preconditions.checkNotNull(builder.getVersion());
    pathTemplate = PROJECT_LOCATION_VERSION;
  }

  public String getProject() {
    return project;
  }

  public String getVersion() {
    return version;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectVersionBuilder() {
    return new Builder();
  }

  public static ProjectLocationVersionBuilder newProjectLocationVersionBuilder() {
    return new ProjectLocationVersionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VersionName of(String project, String version) {
    return newBuilder().setProject(project).setVersion(version).build();
  }

  public static VersionName ofProjectVersionName(String project, String version) {
    return newBuilder().setProject(project).setVersion(version).build();
  }

  public static VersionName ofProjectLocationVersionName(
      String project, String location, String version) {
    return newProjectLocationVersionBuilder()
        .setProject(project)
        .setLocation(location)
        .setVersion(version)
        .build();
  }

  public static String format(String project, String version) {
    return newBuilder().setProject(project).setVersion(version).build().toString();
  }

  public static String formatProjectVersionName(String project, String version) {
    return newBuilder().setProject(project).setVersion(version).build().toString();
  }

  public static String formatProjectLocationVersionName(
      String project, String location, String version) {
    return newProjectLocationVersionBuilder()
        .setProject(project)
        .setLocation(location)
        .setVersion(version)
        .build()
        .toString();
  }

  public static VersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_VERSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_VERSION.match(formattedString);
      return ofProjectVersionName(matchMap.get("project"), matchMap.get("version"));
    } else if (PROJECT_LOCATION_VERSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_VERSION.match(formattedString);
      return ofProjectLocationVersionName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("version"));
    }
    throw new ValidationException("VersionName.parse: formattedString not in valid format");
  }

  public static List<VersionName> parseList(List<String> formattedStrings) {
    List<VersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_VERSION.matches(formattedString)
        || PROJECT_LOCATION_VERSION.matches(formattedString);
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
          if (version != null) {
            fieldMapBuilder.put("version", version);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      VersionName that = ((VersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.version, that.version)
          && Objects.equals(this.location, that.location);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(version);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/agent/versions/{version}. */
  public static class Builder {
    private String project;
    private String version;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getVersion() {
      return version;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    private Builder(VersionName versionName) {
      Preconditions.checkArgument(
          Objects.equals(versionName.pathTemplate, PROJECT_VERSION),
          "toBuilder is only supported when VersionName has the pattern of projects/{project}/agent/versions/{version}");
      this.project = versionName.project;
      this.version = versionName.version;
    }

    public VersionName build() {
      return new VersionName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/agent/versions/{version}. */
  public static class ProjectLocationVersionBuilder {
    private String project;
    private String location;
    private String version;

    protected ProjectLocationVersionBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getVersion() {
      return version;
    }

    public ProjectLocationVersionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationVersionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationVersionBuilder setVersion(String version) {
      this.version = version;
      return this;
    }

    public VersionName build() {
      return new VersionName(this);
    }
  }
}
