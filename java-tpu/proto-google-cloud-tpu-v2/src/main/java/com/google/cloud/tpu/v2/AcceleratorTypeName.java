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

package com.google.cloud.tpu.v2;

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
public class AcceleratorTypeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ACCELERATOR_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/acceleratorTypes/{accelerator_type}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String acceleratorType;

  @Deprecated
  protected AcceleratorTypeName() {
    project = null;
    location = null;
    acceleratorType = null;
  }

  private AcceleratorTypeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    acceleratorType = Preconditions.checkNotNull(builder.getAcceleratorType());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAcceleratorType() {
    return acceleratorType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AcceleratorTypeName of(String project, String location, String acceleratorType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAcceleratorType(acceleratorType)
        .build();
  }

  public static String format(String project, String location, String acceleratorType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAcceleratorType(acceleratorType)
        .build()
        .toString();
  }

  public static AcceleratorTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ACCELERATOR_TYPE.validatedMatch(
            formattedString, "AcceleratorTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("accelerator_type"));
  }

  public static List<AcceleratorTypeName> parseList(List<String> formattedStrings) {
    List<AcceleratorTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AcceleratorTypeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AcceleratorTypeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ACCELERATOR_TYPE.matches(formattedString);
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
          if (acceleratorType != null) {
            fieldMapBuilder.put("accelerator_type", acceleratorType);
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
    return PROJECT_LOCATION_ACCELERATOR_TYPE.instantiate(
        "project", project, "location", location, "accelerator_type", acceleratorType);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AcceleratorTypeName that = ((AcceleratorTypeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.acceleratorType, that.acceleratorType);
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
    h ^= Objects.hashCode(acceleratorType);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/acceleratorTypes/{accelerator_type}. */
  public static class Builder {
    private String project;
    private String location;
    private String acceleratorType;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAcceleratorType() {
      return acceleratorType;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAcceleratorType(String acceleratorType) {
      this.acceleratorType = acceleratorType;
      return this;
    }

    private Builder(AcceleratorTypeName acceleratorTypeName) {
      this.project = acceleratorTypeName.project;
      this.location = acceleratorTypeName.location;
      this.acceleratorType = acceleratorTypeName.acceleratorType;
    }

    public AcceleratorTypeName build() {
      return new AcceleratorTypeName(this);
    }
  }
}
