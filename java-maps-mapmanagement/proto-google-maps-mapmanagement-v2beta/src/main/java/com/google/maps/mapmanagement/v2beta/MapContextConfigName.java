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

package com.google.maps.mapmanagement.v2beta;

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
public class MapContextConfigName implements ResourceName {
  private static final PathTemplate PROJECT_MAP_CONFIG_MAP_CONTEXT_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String mapConfig;
  private final String mapContextConfig;

  @Deprecated
  protected MapContextConfigName() {
    project = null;
    mapConfig = null;
    mapContextConfig = null;
  }

  private MapContextConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    mapConfig = Preconditions.checkNotNull(builder.getMapConfig());
    mapContextConfig = Preconditions.checkNotNull(builder.getMapContextConfig());
  }

  public String getProject() {
    return project;
  }

  public String getMapConfig() {
    return mapConfig;
  }

  public String getMapContextConfig() {
    return mapContextConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MapContextConfigName of(String project, String mapConfig, String mapContextConfig) {
    return newBuilder()
        .setProject(project)
        .setMapConfig(mapConfig)
        .setMapContextConfig(mapContextConfig)
        .build();
  }

  public static String format(String project, String mapConfig, String mapContextConfig) {
    return newBuilder()
        .setProject(project)
        .setMapConfig(mapConfig)
        .setMapContextConfig(mapContextConfig)
        .build()
        .toString();
  }

  public static MapContextConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_MAP_CONFIG_MAP_CONTEXT_CONFIG.validatedMatch(
            formattedString, "MapContextConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("map_config"), matchMap.get("map_context_config"));
  }

  public static List<MapContextConfigName> parseList(List<String> formattedStrings) {
    List<MapContextConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MapContextConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MapContextConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_MAP_CONFIG_MAP_CONTEXT_CONFIG.matches(formattedString);
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
          if (mapConfig != null) {
            fieldMapBuilder.put("map_config", mapConfig);
          }
          if (mapContextConfig != null) {
            fieldMapBuilder.put("map_context_config", mapContextConfig);
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
    return PROJECT_MAP_CONFIG_MAP_CONTEXT_CONFIG.instantiate(
        "project", project, "map_config", mapConfig, "map_context_config", mapContextConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MapContextConfigName that = ((MapContextConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.mapConfig, that.mapConfig)
          && Objects.equals(this.mapContextConfig, that.mapContextConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(mapConfig);
    h *= 1000003;
    h ^= Objects.hashCode(mapContextConfig);
    return h;
  }

  /**
   * Builder for projects/{project}/mapConfigs/{map_config}/mapContextConfigs/{map_context_config}.
   */
  public static class Builder {
    private String project;
    private String mapConfig;
    private String mapContextConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getMapConfig() {
      return mapConfig;
    }

    public String getMapContextConfig() {
      return mapContextConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setMapConfig(String mapConfig) {
      this.mapConfig = mapConfig;
      return this;
    }

    public Builder setMapContextConfig(String mapContextConfig) {
      this.mapContextConfig = mapContextConfig;
      return this;
    }

    private Builder(MapContextConfigName mapContextConfigName) {
      this.project = mapContextConfigName.project;
      this.mapConfig = mapContextConfigName.mapConfig;
      this.mapContextConfig = mapContextConfigName.mapContextConfig;
    }

    public MapContextConfigName build() {
      return new MapContextConfigName(this);
    }
  }
}
