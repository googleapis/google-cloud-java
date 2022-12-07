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

package com.google.cloud.gkebackup.v1;

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
public class RestoreName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RESTORE_PLAN_RESTORE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/restorePlans/{restore_plan}/restores/{restore}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String restorePlan;
  private final String restore;

  @Deprecated
  protected RestoreName() {
    project = null;
    location = null;
    restorePlan = null;
    restore = null;
  }

  private RestoreName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    restorePlan = Preconditions.checkNotNull(builder.getRestorePlan());
    restore = Preconditions.checkNotNull(builder.getRestore());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRestorePlan() {
    return restorePlan;
  }

  public String getRestore() {
    return restore;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RestoreName of(
      String project, String location, String restorePlan, String restore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRestorePlan(restorePlan)
        .setRestore(restore)
        .build();
  }

  public static String format(String project, String location, String restorePlan, String restore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRestorePlan(restorePlan)
        .setRestore(restore)
        .build()
        .toString();
  }

  public static RestoreName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RESTORE_PLAN_RESTORE.validatedMatch(
            formattedString, "RestoreName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("restore_plan"),
        matchMap.get("restore"));
  }

  public static List<RestoreName> parseList(List<String> formattedStrings) {
    List<RestoreName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RestoreName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RestoreName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RESTORE_PLAN_RESTORE.matches(formattedString);
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
          if (restorePlan != null) {
            fieldMapBuilder.put("restore_plan", restorePlan);
          }
          if (restore != null) {
            fieldMapBuilder.put("restore", restore);
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
    return PROJECT_LOCATION_RESTORE_PLAN_RESTORE.instantiate(
        "project", project, "location", location, "restore_plan", restorePlan, "restore", restore);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      RestoreName that = ((RestoreName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.restorePlan, that.restorePlan)
          && Objects.equals(this.restore, that.restore);
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
    h ^= Objects.hashCode(restorePlan);
    h *= 1000003;
    h ^= Objects.hashCode(restore);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/restorePlans/{restore_plan}/restores/{restore}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String restorePlan;
    private String restore;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRestorePlan() {
      return restorePlan;
    }

    public String getRestore() {
      return restore;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRestorePlan(String restorePlan) {
      this.restorePlan = restorePlan;
      return this;
    }

    public Builder setRestore(String restore) {
      this.restore = restore;
      return this;
    }

    private Builder(RestoreName restoreName) {
      this.project = restoreName.project;
      this.location = restoreName.location;
      this.restorePlan = restoreName.restorePlan;
      this.restore = restoreName.restore;
    }

    public RestoreName build() {
      return new RestoreName(this);
    }
  }
}
