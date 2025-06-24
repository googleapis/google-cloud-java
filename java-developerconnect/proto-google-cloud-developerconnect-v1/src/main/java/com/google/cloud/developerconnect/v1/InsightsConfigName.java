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

package com.google.cloud.developerconnect.v1;

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
public class InsightsConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSIGHTS_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/insightsConfigs/{insights_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String insightsConfig;

  @Deprecated
  protected InsightsConfigName() {
    project = null;
    location = null;
    insightsConfig = null;
  }

  private InsightsConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    insightsConfig = Preconditions.checkNotNull(builder.getInsightsConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInsightsConfig() {
    return insightsConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InsightsConfigName of(String project, String location, String insightsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightsConfig(insightsConfig)
        .build();
  }

  public static String format(String project, String location, String insightsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInsightsConfig(insightsConfig)
        .build()
        .toString();
  }

  public static InsightsConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSIGHTS_CONFIG.validatedMatch(
            formattedString, "InsightsConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("insights_config"));
  }

  public static List<InsightsConfigName> parseList(List<String> formattedStrings) {
    List<InsightsConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InsightsConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InsightsConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSIGHTS_CONFIG.matches(formattedString);
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
          if (insightsConfig != null) {
            fieldMapBuilder.put("insights_config", insightsConfig);
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
    return PROJECT_LOCATION_INSIGHTS_CONFIG.instantiate(
        "project", project, "location", location, "insights_config", insightsConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      InsightsConfigName that = ((InsightsConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.insightsConfig, that.insightsConfig);
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
    h ^= Objects.hashCode(insightsConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/insightsConfigs/{insights_config}. */
  public static class Builder {
    private String project;
    private String location;
    private String insightsConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInsightsConfig() {
      return insightsConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInsightsConfig(String insightsConfig) {
      this.insightsConfig = insightsConfig;
      return this;
    }

    private Builder(InsightsConfigName insightsConfigName) {
      this.project = insightsConfigName.project;
      this.location = insightsConfigName.location;
      this.insightsConfig = insightsConfigName.insightsConfig;
    }

    public InsightsConfigName build() {
      return new InsightsConfigName(this);
    }
  }
}
