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

package com.google.cloud.dialogflow.v2;

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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class EnvironmentName implements ResourceName {
  private static final PathTemplate PROJECT_ENVIRONMENT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/environments/{environment}");
  private static final PathTemplate PROJECT_LOCATION_ENVIRONMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/environments/{environment}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String environment;
  private final String location;

  @Deprecated
  protected EnvironmentName() {
    project = null;
    environment = null;
    location = null;
  }

  private EnvironmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    location = null;
    pathTemplate = PROJECT_ENVIRONMENT;
  }

  private EnvironmentName(ProjectLocationEnvironmentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    pathTemplate = PROJECT_LOCATION_ENVIRONMENT;
  }

  public String getProject() {
    return project;
  }

  public String getEnvironment() {
    return environment;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectEnvironmentBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationEnvironmentBuilder newProjectLocationEnvironmentBuilder() {
    return new ProjectLocationEnvironmentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EnvironmentName of(String project, String environment) {
    return newBuilder().setProject(project).setEnvironment(environment).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EnvironmentName ofProjectEnvironmentName(String project, String environment) {
    return newBuilder().setProject(project).setEnvironment(environment).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EnvironmentName ofProjectLocationEnvironmentName(
      String project, String location, String environment) {
    return newProjectLocationEnvironmentBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .build();
  }

  public static String format(String project, String environment) {
    return newBuilder().setProject(project).setEnvironment(environment).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectEnvironmentName(String project, String environment) {
    return newBuilder().setProject(project).setEnvironment(environment).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationEnvironmentName(
      String project, String location, String environment) {
    return newProjectLocationEnvironmentBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .build()
        .toString();
  }

  public static EnvironmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_ENVIRONMENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ENVIRONMENT.match(formattedString);
      return ofProjectEnvironmentName(matchMap.get("project"), matchMap.get("environment"));
    } else if (PROJECT_LOCATION_ENVIRONMENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ENVIRONMENT.match(formattedString);
      return ofProjectLocationEnvironmentName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("environment"));
    }
    throw new ValidationException("EnvironmentName.parse: formattedString not in valid format");
  }

  public static List<EnvironmentName> parseList(List<String> formattedStrings) {
    List<EnvironmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EnvironmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EnvironmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_ENVIRONMENT.matches(formattedString)
        || PROJECT_LOCATION_ENVIRONMENT.matches(formattedString);
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
          if (environment != null) {
            fieldMapBuilder.put("environment", environment);
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
    if (o != null || getClass() == o.getClass()) {
      EnvironmentName that = ((EnvironmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.environment, that.environment)
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
    h ^= Objects.hashCode(environment);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/agent/environments/{environment}. */
  public static class Builder {
    private String project;
    private String environment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getEnvironment() {
      return environment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    private Builder(EnvironmentName environmentName) {
      Preconditions.checkArgument(
          Objects.equals(environmentName.pathTemplate, PROJECT_ENVIRONMENT),
          "toBuilder is only supported when EnvironmentName has the pattern of projects/{project}/agent/environments/{environment}");
      this.project = environmentName.project;
      this.environment = environmentName.environment;
    }

    public EnvironmentName build() {
      return new EnvironmentName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/agent/environments/{environment}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationEnvironmentBuilder {
    private String project;
    private String location;
    private String environment;

    protected ProjectLocationEnvironmentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEnvironment() {
      return environment;
    }

    public ProjectLocationEnvironmentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationEnvironmentBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationEnvironmentBuilder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public EnvironmentName build() {
      return new EnvironmentName(this);
    }
  }
}
