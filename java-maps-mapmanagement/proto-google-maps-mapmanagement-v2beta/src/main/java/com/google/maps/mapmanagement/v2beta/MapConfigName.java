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
public class MapConfigName implements ResourceName {
  private static final PathTemplate PROJECT_MAP_CONFIG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/mapConfigs/{map_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String mapConfig;

  @Deprecated
  protected MapConfigName() {
    project = null;
    mapConfig = null;
  }

  private MapConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    mapConfig = Preconditions.checkNotNull(builder.getMapConfig());
  }

  public String getProject() {
    return project;
  }

  public String getMapConfig() {
    return mapConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MapConfigName of(String project, String mapConfig) {
    return newBuilder().setProject(project).setMapConfig(mapConfig).build();
  }

  public static String format(String project, String mapConfig) {
    return newBuilder().setProject(project).setMapConfig(mapConfig).build().toString();
  }

  public static MapConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_MAP_CONFIG.validatedMatch(
            formattedString, "MapConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("map_config"));
  }

  public static List<MapConfigName> parseList(List<String> formattedStrings) {
    List<MapConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MapConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MapConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_MAP_CONFIG.matches(formattedString);
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
    return PROJECT_MAP_CONFIG.instantiate("project", project, "map_config", mapConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MapConfigName that = ((MapConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.mapConfig, that.mapConfig);
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
    return h;
  }

  /** Builder for projects/{project}/mapConfigs/{map_config}. */
  public static class Builder {
    private String project;
    private String mapConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getMapConfig() {
      return mapConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setMapConfig(String mapConfig) {
      this.mapConfig = mapConfig;
      return this;
    }

    private Builder(MapConfigName mapConfigName) {
      this.project = mapConfigName.project;
      this.mapConfig = mapConfigName.mapConfig;
    }

    public MapConfigName build() {
      return new MapConfigName(this);
    }
  }
}
