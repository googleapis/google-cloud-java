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
public class FeatureMonitorJobName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR_FEATURE_MONITOR_JOB =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/featureGroups/{feature_group}/featureMonitors/{feature_monitor}/featureMonitorJobs/{feature_monitor_job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String featureGroup;
  private final String featureMonitor;
  private final String featureMonitorJob;

  @Deprecated
  protected FeatureMonitorJobName() {
    project = null;
    location = null;
    featureGroup = null;
    featureMonitor = null;
    featureMonitorJob = null;
  }

  private FeatureMonitorJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    featureGroup = Preconditions.checkNotNull(builder.getFeatureGroup());
    featureMonitor = Preconditions.checkNotNull(builder.getFeatureMonitor());
    featureMonitorJob = Preconditions.checkNotNull(builder.getFeatureMonitorJob());
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

  public String getFeatureMonitorJob() {
    return featureMonitorJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeatureMonitorJobName of(
      String project,
      String location,
      String featureGroup,
      String featureMonitor,
      String featureMonitorJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureGroup(featureGroup)
        .setFeatureMonitor(featureMonitor)
        .setFeatureMonitorJob(featureMonitorJob)
        .build();
  }

  public static String format(
      String project,
      String location,
      String featureGroup,
      String featureMonitor,
      String featureMonitorJob) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFeatureGroup(featureGroup)
        .setFeatureMonitor(featureMonitor)
        .setFeatureMonitorJob(featureMonitorJob)
        .build()
        .toString();
  }

  public static FeatureMonitorJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR_FEATURE_MONITOR_JOB.validatedMatch(
            formattedString, "FeatureMonitorJobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("feature_group"),
        matchMap.get("feature_monitor"),
        matchMap.get("feature_monitor_job"));
  }

  public static List<FeatureMonitorJobName> parseList(List<String> formattedStrings) {
    List<FeatureMonitorJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FeatureMonitorJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FeatureMonitorJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR_FEATURE_MONITOR_JOB.matches(
        formattedString);
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
          if (featureMonitorJob != null) {
            fieldMapBuilder.put("feature_monitor_job", featureMonitorJob);
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
    return PROJECT_LOCATION_FEATURE_GROUP_FEATURE_MONITOR_FEATURE_MONITOR_JOB.instantiate(
        "project",
        project,
        "location",
        location,
        "feature_group",
        featureGroup,
        "feature_monitor",
        featureMonitor,
        "feature_monitor_job",
        featureMonitorJob);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FeatureMonitorJobName that = ((FeatureMonitorJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.featureGroup, that.featureGroup)
          && Objects.equals(this.featureMonitor, that.featureMonitor)
          && Objects.equals(this.featureMonitorJob, that.featureMonitorJob);
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
    h *= 1000003;
    h ^= Objects.hashCode(featureMonitorJob);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/featureGroups/{feature_group}/featureMonitors/{feature_monitor}/featureMonitorJobs/{feature_monitor_job}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String featureGroup;
    private String featureMonitor;
    private String featureMonitorJob;

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

    public String getFeatureMonitorJob() {
      return featureMonitorJob;
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

    public Builder setFeatureMonitorJob(String featureMonitorJob) {
      this.featureMonitorJob = featureMonitorJob;
      return this;
    }

    private Builder(FeatureMonitorJobName featureMonitorJobName) {
      this.project = featureMonitorJobName.project;
      this.location = featureMonitorJobName.location;
      this.featureGroup = featureMonitorJobName.featureGroup;
      this.featureMonitor = featureMonitorJobName.featureMonitor;
      this.featureMonitorJob = featureMonitorJobName.featureMonitorJob;
    }

    public FeatureMonitorJobName build() {
      return new FeatureMonitorJobName(this);
    }
  }
}
