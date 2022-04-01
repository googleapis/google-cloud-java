/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.baremetalsolution.v2;

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
public class SnapshotSchedulePolicyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SNAPSHOT_SCHEDULE_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/snapshotSchedulePolicies/{snapshot_schedule_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String snapshotSchedulePolicy;

  @Deprecated
  protected SnapshotSchedulePolicyName() {
    project = null;
    location = null;
    snapshotSchedulePolicy = null;
  }

  private SnapshotSchedulePolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    snapshotSchedulePolicy = Preconditions.checkNotNull(builder.getSnapshotSchedulePolicy());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSnapshotSchedulePolicy() {
    return snapshotSchedulePolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SnapshotSchedulePolicyName of(
      String project, String location, String snapshotSchedulePolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSnapshotSchedulePolicy(snapshotSchedulePolicy)
        .build();
  }

  public static String format(String project, String location, String snapshotSchedulePolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSnapshotSchedulePolicy(snapshotSchedulePolicy)
        .build()
        .toString();
  }

  public static SnapshotSchedulePolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SNAPSHOT_SCHEDULE_POLICY.validatedMatch(
            formattedString,
            "SnapshotSchedulePolicyName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("snapshot_schedule_policy"));
  }

  public static List<SnapshotSchedulePolicyName> parseList(List<String> formattedStrings) {
    List<SnapshotSchedulePolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SnapshotSchedulePolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SnapshotSchedulePolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SNAPSHOT_SCHEDULE_POLICY.matches(formattedString);
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
          if (snapshotSchedulePolicy != null) {
            fieldMapBuilder.put("snapshot_schedule_policy", snapshotSchedulePolicy);
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
    return PROJECT_LOCATION_SNAPSHOT_SCHEDULE_POLICY.instantiate(
        "project",
        project,
        "location",
        location,
        "snapshot_schedule_policy",
        snapshotSchedulePolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SnapshotSchedulePolicyName that = ((SnapshotSchedulePolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.snapshotSchedulePolicy, that.snapshotSchedulePolicy);
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
    h ^= Objects.hashCode(snapshotSchedulePolicy);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/snapshotSchedulePolicies/{snapshot_schedule_policy}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String snapshotSchedulePolicy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSnapshotSchedulePolicy() {
      return snapshotSchedulePolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSnapshotSchedulePolicy(String snapshotSchedulePolicy) {
      this.snapshotSchedulePolicy = snapshotSchedulePolicy;
      return this;
    }

    private Builder(SnapshotSchedulePolicyName snapshotSchedulePolicyName) {
      this.project = snapshotSchedulePolicyName.project;
      this.location = snapshotSchedulePolicyName.location;
      this.snapshotSchedulePolicy = snapshotSchedulePolicyName.snapshotSchedulePolicy;
    }

    public SnapshotSchedulePolicyName build() {
      return new SnapshotSchedulePolicyName(this);
    }
  }
}
