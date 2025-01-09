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
public class HardwareGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ORDER_HARDWARE_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/orders/{order}/hardwareGroups/{hardware_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String order;
  private final String hardwareGroup;

  @Deprecated
  protected HardwareGroupName() {
    project = null;
    location = null;
    order = null;
    hardwareGroup = null;
  }

  private HardwareGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    order = Preconditions.checkNotNull(builder.getOrder());
    hardwareGroup = Preconditions.checkNotNull(builder.getHardwareGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getOrder() {
    return order;
  }

  public String getHardwareGroup() {
    return hardwareGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HardwareGroupName of(
      String project, String location, String order, String hardwareGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOrder(order)
        .setHardwareGroup(hardwareGroup)
        .build();
  }

  public static String format(String project, String location, String order, String hardwareGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOrder(order)
        .setHardwareGroup(hardwareGroup)
        .build()
        .toString();
  }

  public static HardwareGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ORDER_HARDWARE_GROUP.validatedMatch(
            formattedString, "HardwareGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("order"),
        matchMap.get("hardware_group"));
  }

  public static List<HardwareGroupName> parseList(List<String> formattedStrings) {
    List<HardwareGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HardwareGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HardwareGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ORDER_HARDWARE_GROUP.matches(formattedString);
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
          if (order != null) {
            fieldMapBuilder.put("order", order);
          }
          if (hardwareGroup != null) {
            fieldMapBuilder.put("hardware_group", hardwareGroup);
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
    return PROJECT_LOCATION_ORDER_HARDWARE_GROUP.instantiate(
        "project", project, "location", location, "order", order, "hardware_group", hardwareGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      HardwareGroupName that = ((HardwareGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.order, that.order)
          && Objects.equals(this.hardwareGroup, that.hardwareGroup);
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
    h ^= Objects.hashCode(order);
    h *= 1000003;
    h ^= Objects.hashCode(hardwareGroup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/orders/{order}/hardwareGroups/{hardware_group}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String order;
    private String hardwareGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getOrder() {
      return order;
    }

    public String getHardwareGroup() {
      return hardwareGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOrder(String order) {
      this.order = order;
      return this;
    }

    public Builder setHardwareGroup(String hardwareGroup) {
      this.hardwareGroup = hardwareGroup;
      return this;
    }

    private Builder(HardwareGroupName hardwareGroupName) {
      this.project = hardwareGroupName.project;
      this.location = hardwareGroupName.location;
      this.order = hardwareGroupName.order;
      this.hardwareGroup = hardwareGroupName.hardwareGroup;
    }

    public HardwareGroupName build() {
      return new HardwareGroupName(this);
    }
  }
}
