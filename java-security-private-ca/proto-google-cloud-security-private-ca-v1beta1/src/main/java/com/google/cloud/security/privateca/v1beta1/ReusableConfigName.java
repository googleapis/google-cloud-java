/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.security.privateca.v1beta1;

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
public class ReusableConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REUSABLE_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reusableConfigs/{reusable_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reusableConfig;

  @Deprecated
  protected ReusableConfigName() {
    project = null;
    location = null;
    reusableConfig = null;
  }

  private ReusableConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reusableConfig = Preconditions.checkNotNull(builder.getReusableConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getReusableConfig() {
    return reusableConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReusableConfigName of(String project, String location, String reusableConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReusableConfig(reusableConfig)
        .build();
  }

  public static String format(String project, String location, String reusableConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReusableConfig(reusableConfig)
        .build()
        .toString();
  }

  public static ReusableConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REUSABLE_CONFIG.validatedMatch(
            formattedString, "ReusableConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("reusable_config"));
  }

  public static List<ReusableConfigName> parseList(List<String> formattedStrings) {
    List<ReusableConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReusableConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReusableConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REUSABLE_CONFIG.matches(formattedString);
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
          if (reusableConfig != null) {
            fieldMapBuilder.put("reusable_config", reusableConfig);
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
    return PROJECT_LOCATION_REUSABLE_CONFIG.instantiate(
        "project", project, "location", location, "reusable_config", reusableConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ReusableConfigName that = ((ReusableConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reusableConfig, that.reusableConfig);
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
    h ^= Objects.hashCode(reusableConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/reusableConfigs/{reusable_config}. */
  public static class Builder {
    private String project;
    private String location;
    private String reusableConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReusableConfig() {
      return reusableConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReusableConfig(String reusableConfig) {
      this.reusableConfig = reusableConfig;
      return this;
    }

    private Builder(ReusableConfigName reusableConfigName) {
      project = reusableConfigName.project;
      location = reusableConfigName.location;
      reusableConfig = reusableConfigName.reusableConfig;
    }

    public ReusableConfigName build() {
      return new ReusableConfigName(this);
    }
  }
}
