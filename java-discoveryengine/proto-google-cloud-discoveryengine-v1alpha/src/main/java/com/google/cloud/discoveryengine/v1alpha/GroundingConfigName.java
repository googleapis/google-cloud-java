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

package com.google.cloud.discoveryengine.v1alpha;

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
public class GroundingConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GROUNDING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/groundingConfigs/{grounding_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String groundingConfig;

  @Deprecated
  protected GroundingConfigName() {
    project = null;
    location = null;
    groundingConfig = null;
  }

  private GroundingConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    groundingConfig = Preconditions.checkNotNull(builder.getGroundingConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGroundingConfig() {
    return groundingConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GroundingConfigName of(String project, String location, String groundingConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGroundingConfig(groundingConfig)
        .build();
  }

  public static String format(String project, String location, String groundingConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGroundingConfig(groundingConfig)
        .build()
        .toString();
  }

  public static GroundingConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GROUNDING_CONFIG.validatedMatch(
            formattedString, "GroundingConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("grounding_config"));
  }

  public static List<GroundingConfigName> parseList(List<String> formattedStrings) {
    List<GroundingConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GroundingConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GroundingConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GROUNDING_CONFIG.matches(formattedString);
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
          if (groundingConfig != null) {
            fieldMapBuilder.put("grounding_config", groundingConfig);
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
    return PROJECT_LOCATION_GROUNDING_CONFIG.instantiate(
        "project", project, "location", location, "grounding_config", groundingConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GroundingConfigName that = ((GroundingConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.groundingConfig, that.groundingConfig);
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
    h ^= Objects.hashCode(groundingConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/groundingConfigs/{grounding_config}. */
  public static class Builder {
    private String project;
    private String location;
    private String groundingConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGroundingConfig() {
      return groundingConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGroundingConfig(String groundingConfig) {
      this.groundingConfig = groundingConfig;
      return this;
    }

    private Builder(GroundingConfigName groundingConfigName) {
      this.project = groundingConfigName.project;
      this.location = groundingConfigName.location;
      this.groundingConfig = groundingConfigName.groundingConfig;
    }

    public GroundingConfigName build() {
      return new GroundingConfigName(this);
    }
  }
}
