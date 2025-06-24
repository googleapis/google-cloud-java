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

package com.google.cloud.networkservices.v1;

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
public class WasmPluginVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_WASM_PLUGIN_WASM_PLUGIN_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/wasmPlugins/{wasm_plugin}/versions/{wasm_plugin_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String wasmPlugin;
  private final String wasmPluginVersion;

  @Deprecated
  protected WasmPluginVersionName() {
    project = null;
    location = null;
    wasmPlugin = null;
    wasmPluginVersion = null;
  }

  private WasmPluginVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    wasmPlugin = Preconditions.checkNotNull(builder.getWasmPlugin());
    wasmPluginVersion = Preconditions.checkNotNull(builder.getWasmPluginVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getWasmPlugin() {
    return wasmPlugin;
  }

  public String getWasmPluginVersion() {
    return wasmPluginVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WasmPluginVersionName of(
      String project, String location, String wasmPlugin, String wasmPluginVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWasmPlugin(wasmPlugin)
        .setWasmPluginVersion(wasmPluginVersion)
        .build();
  }

  public static String format(
      String project, String location, String wasmPlugin, String wasmPluginVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWasmPlugin(wasmPlugin)
        .setWasmPluginVersion(wasmPluginVersion)
        .build()
        .toString();
  }

  public static WasmPluginVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WASM_PLUGIN_WASM_PLUGIN_VERSION.validatedMatch(
            formattedString, "WasmPluginVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("wasm_plugin"),
        matchMap.get("wasm_plugin_version"));
  }

  public static List<WasmPluginVersionName> parseList(List<String> formattedStrings) {
    List<WasmPluginVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WasmPluginVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WasmPluginVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WASM_PLUGIN_WASM_PLUGIN_VERSION.matches(formattedString);
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
          if (wasmPlugin != null) {
            fieldMapBuilder.put("wasm_plugin", wasmPlugin);
          }
          if (wasmPluginVersion != null) {
            fieldMapBuilder.put("wasm_plugin_version", wasmPluginVersion);
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
    return PROJECT_LOCATION_WASM_PLUGIN_WASM_PLUGIN_VERSION.instantiate(
        "project",
        project,
        "location",
        location,
        "wasm_plugin",
        wasmPlugin,
        "wasm_plugin_version",
        wasmPluginVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WasmPluginVersionName that = ((WasmPluginVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.wasmPlugin, that.wasmPlugin)
          && Objects.equals(this.wasmPluginVersion, that.wasmPluginVersion);
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
    h ^= Objects.hashCode(wasmPlugin);
    h *= 1000003;
    h ^= Objects.hashCode(wasmPluginVersion);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/wasmPlugins/{wasm_plugin}/versions/{wasm_plugin_version}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String wasmPlugin;
    private String wasmPluginVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getWasmPlugin() {
      return wasmPlugin;
    }

    public String getWasmPluginVersion() {
      return wasmPluginVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setWasmPlugin(String wasmPlugin) {
      this.wasmPlugin = wasmPlugin;
      return this;
    }

    public Builder setWasmPluginVersion(String wasmPluginVersion) {
      this.wasmPluginVersion = wasmPluginVersion;
      return this;
    }

    private Builder(WasmPluginVersionName wasmPluginVersionName) {
      this.project = wasmPluginVersionName.project;
      this.location = wasmPluginVersionName.location;
      this.wasmPlugin = wasmPluginVersionName.wasmPlugin;
      this.wasmPluginVersion = wasmPluginVersionName.wasmPluginVersion;
    }

    public WasmPluginVersionName build() {
      return new WasmPluginVersionName(this);
    }
  }
}
