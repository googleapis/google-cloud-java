/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloudbuild.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class BuildName implements ResourceName {

  @Deprecated
  protected BuildName() {}

  private static final PathTemplate PROJECT_BUILD_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/builds/{build}");
  private static final PathTemplate PROJECT_LOCATION_BUILD_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/builds/{build}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String build;
  private String location;

  public String getProject() {
    return project;
  }

  public String getBuild() {
    return build;
  }

  public String getLocation() {
    return location;
  }

  private BuildName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    build = Preconditions.checkNotNull(builder.getBuild());
    pathTemplate = PROJECT_BUILD_PATH_TEMPLATE;
  }

  private BuildName(ProjectLocationBuildBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    build = Preconditions.checkNotNull(builder.getBuild());
    pathTemplate = PROJECT_LOCATION_BUILD_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectBuildBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationBuildBuilder newProjectLocationBuildBuilder() {
    return new ProjectLocationBuildBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BuildName of(String project, String build) {
    return newProjectBuildBuilder().setProject(project).setBuild(build).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BuildName ofProjectBuildName(String project, String build) {
    return newProjectBuildBuilder().setProject(project).setBuild(build).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BuildName ofProjectLocationBuildName(
      String project, String location, String build) {
    return newProjectLocationBuildBuilder()
        .setProject(project)
        .setLocation(location)
        .setBuild(build)
        .build();
  }

  public static String format(String project, String build) {
    return newBuilder().setProject(project).setBuild(build).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectBuildName(String project, String build) {
    return newBuilder().setProject(project).setBuild(build).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationBuildName(
      String project, String location, String build) {
    return newProjectLocationBuildBuilder()
        .setProject(project)
        .setLocation(location)
        .setBuild(build)
        .build()
        .toString();
  }

  public static BuildName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_BUILD_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_BUILD_PATH_TEMPLATE.match(formattedString);
      return ofProjectBuildName(matchMap.get("project"), matchMap.get("build"));
    } else if (PROJECT_LOCATION_BUILD_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_BUILD_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationBuildName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("build"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<BuildName> parseList(List<String> formattedStrings) {
    List<BuildName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BuildName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BuildName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_BUILD_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_BUILD_PATH_TEMPLATE.matches(formattedString);
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
          if (build != null) {
            fieldMapBuilder.put("build", build);
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

  /** Builder for projects/{project}/builds/{build}. */
  public static class Builder {

    private String project;
    private String build;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getBuild() {
      return build;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setBuild(String build) {
      this.build = build;
      return this;
    }

    private Builder(BuildName buildName) {
      Preconditions.checkArgument(
          buildName.pathTemplate == PROJECT_BUILD_PATH_TEMPLATE,
          "toBuilder is only supported when BuildName has the pattern of "
              + "projects/{project}/builds/{build}.");
      project = buildName.project;
      build = buildName.build;
    }

    public BuildName build() {
      return new BuildName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/builds/{build}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationBuildBuilder {

    private String project;
    private String location;
    private String build;

    private ProjectLocationBuildBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBuild() {
      return build;
    }

    public ProjectLocationBuildBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationBuildBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationBuildBuilder setBuild(String build) {
      this.build = build;
      return this;
    }

    public BuildName build() {
      return new BuildName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      BuildName that = (BuildName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.build, that.build))
          && (Objects.equals(this.location, that.location));
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
    h ^= Objects.hashCode(build);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }
}
