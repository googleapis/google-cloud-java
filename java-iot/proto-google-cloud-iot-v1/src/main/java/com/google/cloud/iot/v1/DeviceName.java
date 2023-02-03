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

package com.google.cloud.iot.v1;

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
public class DeviceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REGISTRY_DEVICE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/registries/{registry}/devices/{device}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String registry;
  private final String device;

  @Deprecated
  protected DeviceName() {
    project = null;
    location = null;
    registry = null;
    device = null;
  }

  private DeviceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    registry = Preconditions.checkNotNull(builder.getRegistry());
    device = Preconditions.checkNotNull(builder.getDevice());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRegistry() {
    return registry;
  }

  public String getDevice() {
    return device;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeviceName of(String project, String location, String registry, String device) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRegistry(registry)
        .setDevice(device)
        .build();
  }

  public static String format(String project, String location, String registry, String device) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRegistry(registry)
        .setDevice(device)
        .build()
        .toString();
  }

  public static DeviceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REGISTRY_DEVICE.validatedMatch(
            formattedString, "DeviceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("registry"),
        matchMap.get("device"));
  }

  public static List<DeviceName> parseList(List<String> formattedStrings) {
    List<DeviceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeviceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeviceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REGISTRY_DEVICE.matches(formattedString);
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
          if (registry != null) {
            fieldMapBuilder.put("registry", registry);
          }
          if (device != null) {
            fieldMapBuilder.put("device", device);
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
    return PROJECT_LOCATION_REGISTRY_DEVICE.instantiate(
        "project", project, "location", location, "registry", registry, "device", device);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DeviceName that = ((DeviceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.registry, that.registry)
          && Objects.equals(this.device, that.device);
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
    h ^= Objects.hashCode(registry);
    h *= 1000003;
    h ^= Objects.hashCode(device);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/registries/{registry}/devices/{device}. */
  public static class Builder {
    private String project;
    private String location;
    private String registry;
    private String device;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRegistry() {
      return registry;
    }

    public String getDevice() {
      return device;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRegistry(String registry) {
      this.registry = registry;
      return this;
    }

    public Builder setDevice(String device) {
      this.device = device;
      return this;
    }

    private Builder(DeviceName deviceName) {
      this.project = deviceName.project;
      this.location = deviceName.location;
      this.registry = deviceName.registry;
      this.device = deviceName.device;
    }

    public DeviceName build() {
      return new DeviceName(this);
    }
  }
}
