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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class GoldengateDeploymentEnvironmentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GOLDENGATE_DEPLOYMENT_ENVIRONMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/goldengateDeploymentEnvironments/{goldengate_deployment_environment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String goldengateDeploymentEnvironment;

  @Deprecated
  protected GoldengateDeploymentEnvironmentName() {
    project = null;
    location = null;
    goldengateDeploymentEnvironment = null;
  }

  private GoldengateDeploymentEnvironmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    goldengateDeploymentEnvironment =
        Preconditions.checkNotNull(builder.getGoldengateDeploymentEnvironment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGoldengateDeploymentEnvironment() {
    return goldengateDeploymentEnvironment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GoldengateDeploymentEnvironmentName of(
      String project, String location, String goldengateDeploymentEnvironment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGoldengateDeploymentEnvironment(goldengateDeploymentEnvironment)
        .build();
  }

  public static String format(
      String project, String location, String goldengateDeploymentEnvironment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGoldengateDeploymentEnvironment(goldengateDeploymentEnvironment)
        .build()
        .toString();
  }

  public static GoldengateDeploymentEnvironmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GOLDENGATE_DEPLOYMENT_ENVIRONMENT.validatedMatch(
            formattedString,
            "GoldengateDeploymentEnvironmentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("goldengate_deployment_environment"));
  }

  public static List<GoldengateDeploymentEnvironmentName> parseList(List<String> formattedStrings) {
    List<GoldengateDeploymentEnvironmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GoldengateDeploymentEnvironmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GoldengateDeploymentEnvironmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GOLDENGATE_DEPLOYMENT_ENVIRONMENT.matches(formattedString);
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
          if (goldengateDeploymentEnvironment != null) {
            fieldMapBuilder.put(
                "goldengate_deployment_environment", goldengateDeploymentEnvironment);
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
    return PROJECT_LOCATION_GOLDENGATE_DEPLOYMENT_ENVIRONMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "goldengate_deployment_environment",
        goldengateDeploymentEnvironment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GoldengateDeploymentEnvironmentName that = ((GoldengateDeploymentEnvironmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.goldengateDeploymentEnvironment, that.goldengateDeploymentEnvironment);
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
    h ^= Objects.hashCode(goldengateDeploymentEnvironment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/goldengateDeploymentEnvironments/{goldengate_deployment_environment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String goldengateDeploymentEnvironment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGoldengateDeploymentEnvironment() {
      return goldengateDeploymentEnvironment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGoldengateDeploymentEnvironment(String goldengateDeploymentEnvironment) {
      this.goldengateDeploymentEnvironment = goldengateDeploymentEnvironment;
      return this;
    }

    private Builder(GoldengateDeploymentEnvironmentName goldengateDeploymentEnvironmentName) {
      this.project = goldengateDeploymentEnvironmentName.project;
      this.location = goldengateDeploymentEnvironmentName.location;
      this.goldengateDeploymentEnvironment =
          goldengateDeploymentEnvironmentName.goldengateDeploymentEnvironment;
    }

    public GoldengateDeploymentEnvironmentName build() {
      return new GoldengateDeploymentEnvironmentName(this);
    }
  }
}
