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

package com.google.cloud.gdchardwaremanagement.v1alpha;

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
public class HardwareName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_HARDWARE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/hardware/{hardware}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String hardware;

  @Deprecated
  protected HardwareName() {
    project = null;
    location = null;
    hardware = null;
  }

  private HardwareName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    hardware = Preconditions.checkNotNull(builder.getHardware());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getHardware() {
    return hardware;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HardwareName of(String project, String location, String hardware) {
    return newBuilder().setProject(project).setLocation(location).setHardware(hardware).build();
  }

  public static String format(String project, String location, String hardware) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setHardware(hardware)
        .build()
        .toString();
  }

  public static HardwareName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_HARDWARE.validatedMatch(
            formattedString, "HardwareName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("hardware"));
  }

  public static List<HardwareName> parseList(List<String> formattedStrings) {
    List<HardwareName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HardwareName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HardwareName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_HARDWARE.matches(formattedString);
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
          if (hardware != null) {
            fieldMapBuilder.put("hardware", hardware);
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
    return PROJECT_LOCATION_HARDWARE.instantiate(
        "project", project, "location", location, "hardware", hardware);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      HardwareName that = ((HardwareName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.hardware, that.hardware);
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
    h ^= Objects.hashCode(hardware);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/hardware/{hardware}. */
  public static class Builder {
    private String project;
    private String location;
    private String hardware;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getHardware() {
      return hardware;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setHardware(String hardware) {
      this.hardware = hardware;
      return this;
    }

    private Builder(HardwareName hardwareName) {
      this.project = hardwareName.project;
      this.location = hardwareName.location;
      this.hardware = hardwareName.hardware;
    }

    public HardwareName build() {
      return new HardwareName(this);
    }
  }
}
