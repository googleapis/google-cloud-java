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

package com.google.cloud.aiplatform.v1beta1;

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
public class FeatureMonitorName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/featureGroups/{feature_group}/featureMonitors/{feature_monitor}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String featureGroup;
  private final String featureMonitor;

  @Deprecated
  protected FeatureMonitorName() {
    project = null;
    location = null;
    featureGroup = null;
    featureMonitor = null;
  }

  private FeatureMonitorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    featureGroup = Preconditions.checkNotNull(builder.getFeatureGroup());
    featureMonitor = Preconditions.checkNotNull(builder.getFeatureMonitor());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFeatureGroup() {
    return featureGroup;
  }

  public String getFeatureMonitor() {
    return featureMonitor;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeatureMonitorName of(
      String project, String location, String featureGroup, String featureMonitor) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureGroup(featureGroup)
        .setFeatureMonitor(featureMonitor)
        .build();
  }

  public static String format(
      String project, String location, String featureGroup, String featureMonitor) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureGroup(featureGroup)
        .setFeatureMonitor(featureMonitor)
        .build()
        .toString();
  }

  public static FeatureMonitorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR.validatedMatch(
            formattedString, "FeatureMonitorName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("feature_group"),
        matchMap.get("feature_monitor"));
  }

  public static List<FeatureMonitorName> parseList(List<String> formattedStrings) {
    List<FeatureMonitorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FeatureMonitorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FeatureMonitorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR.matches(formattedString);
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
          if (featureGroup != null) {
            fieldMapBuilder.put("feature_group", featureGroup);
          }
          if (featureMonitor != null) {
            fieldMapBuilder.put("feature_monitor", featureMonitor);
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
    return PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR.instantiate(
        "project",
        project,
        "location",
        location,
        "feature_group",
        featureGroup,
        "feature_monitor",
        featureMonitor);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FeatureMonitorName that = ((FeatureMonitorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.featureGroup, that.featureGroup)
          && Objects.equals(this.featureMonitor, that.featureMonitor);
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
    h ^= Objects.hashCode(featureGroup);
    h *= 1000003;
    h ^= Objects.hashCode(featureMonitor);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/featureGroups/{feature_group}/featureMonitors/{feature_monitor}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String featureGroup;
    private String featureMonitor;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFeatureGroup() {
      return featureGroup;
    }

    public String getFeatureMonitor() {
      return featureMonitor;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFeatureGroup(String featureGroup) {
      this.featureGroup = featureGroup;
      return this;
    }

    public Builder setFeatureMonitor(String featureMonitor) {
      this.featureMonitor = featureMonitor;
      return this;
    }

    private Builder(FeatureMonitorName featureMonitorName) {
      this.project = featureMonitorName.project;
      this.location = featureMonitorName.location;
      this.featureGroup = featureMonitorName.featureGroup;
      this.featureMonitor = featureMonitorName.featureMonitor;
    }

    public FeatureMonitorName build() {
      return new FeatureMonitorName(this);
    }
  }
}
