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

package com.google.cloud.discoveryengine.v1;

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
public class CmekConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/cmekConfig");
  private static final PathTemplate PROJECT_LOCATION_CMEK_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/cmekConfigs/{cmek_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String cmekConfig;

  @Deprecated
  protected CmekConfigName() {
    project = null;
    location = null;
    cmekConfig = null;
  }

  private CmekConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cmekConfig = null;
    pathTemplate = PROJECT_LOCATION;
  }

  private CmekConfigName(ProjectLocationCmekConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cmekConfig = Preconditions.checkNotNull(builder.getCmekConfig());
    pathTemplate = PROJECT_LOCATION_CMEK_CONFIG;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCmekConfig() {
    return cmekConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationBuilder() {
    return new Builder();
  }

  public static ProjectLocationCmekConfigBuilder newProjectLocationCmekConfigBuilder() {
    return new ProjectLocationCmekConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CmekConfigName of(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build();
  }

  public static CmekConfigName ofProjectLocationName(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build();
  }

  public static CmekConfigName ofProjectLocationCmekConfigName(
      String project, String location, String cmekConfig) {
    return newProjectLocationCmekConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCmekConfig(cmekConfig)
        .build();
  }

  public static String format(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build().toString();
  }

  public static String formatProjectLocationName(String project, String location) {
    return newBuilder().setProject(project).setLocation(location).build().toString();
  }

  public static String formatProjectLocationCmekConfigName(
      String project, String location, String cmekConfig) {
    return newProjectLocationCmekConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCmekConfig(cmekConfig)
        .build()
        .toString();
  }

  public static CmekConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION.match(formattedString);
      return ofProjectLocationName(matchMap.get("project"), matchMap.get("location"));
    } else if (PROJECT_LOCATION_CMEK_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_CMEK_CONFIG.match(formattedString);
      return ofProjectLocationCmekConfigName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("cmek_config"));
    }
    throw new ValidationException("CmekConfigName.parse: formattedString not in valid format");
  }

  public static List<CmekConfigName> parseList(List<String> formattedStrings) {
    List<CmekConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CmekConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CmekConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION.matches(formattedString)
        || PROJECT_LOCATION_CMEK_CONFIG.matches(formattedString);
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
          if (cmekConfig != null) {
            fieldMapBuilder.put("cmek_config", cmekConfig);
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
      CmekConfigName that = ((CmekConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cmekConfig, that.cmekConfig);
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(cmekConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/cmekConfig. */
  public static class Builder {
    private String project;
    private String location;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    private Builder(CmekConfigName cmekConfigName) {
      Preconditions.checkArgument(
          Objects.equals(cmekConfigName.pathTemplate, PROJECT_LOCATION),
          "toBuilder is only supported when CmekConfigName has the pattern of"
              + " projects/{project}/locations/{location}/cmekConfig");
      this.project = cmekConfigName.project;
      this.location = cmekConfigName.location;
    }

    public CmekConfigName build() {
      return new CmekConfigName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/cmekConfigs/{cmek_config}. */
  public static class ProjectLocationCmekConfigBuilder {
    private String project;
    private String location;
    private String cmekConfig;

    protected ProjectLocationCmekConfigBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCmekConfig() {
      return cmekConfig;
    }

    public ProjectLocationCmekConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCmekConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCmekConfigBuilder setCmekConfig(String cmekConfig) {
      this.cmekConfig = cmekConfig;
      return this;
    }

    public CmekConfigName build() {
      return new CmekConfigName(this);
    }
  }
}
