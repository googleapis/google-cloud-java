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
public class RestorePlanBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RESTORE_CHANNEL_RESTORE_PLAN_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/restoreChannels/{restore_channel}/restorePlanBindings/{restore_plan_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String restoreChannel;
  private final String restorePlanBinding;

  @Deprecated
  protected RestorePlanBindingName() {
    project = null;
    location = null;
    restoreChannel = null;
    restorePlanBinding = null;
  }

  private RestorePlanBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    restoreChannel = Preconditions.checkNotNull(builder.getRestoreChannel());
    restorePlanBinding = Preconditions.checkNotNull(builder.getRestorePlanBinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRestoreChannel() {
    return restoreChannel;
  }

  public String getRestorePlanBinding() {
    return restorePlanBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RestorePlanBindingName of(
      String project, String location, String restoreChannel, String restorePlanBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRestoreChannel(restoreChannel)
        .setRestorePlanBinding(restorePlanBinding)
        .build();
  }

  public static String format(
      String project, String location, String restoreChannel, String restorePlanBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRestoreChannel(restoreChannel)
        .setRestorePlanBinding(restorePlanBinding)
        .build()
        .toString();
  }

  public static RestorePlanBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RESTORE_CHANNEL_RESTORE_PLAN_BINDING.validatedMatch(
            formattedString, "RestorePlanBindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("restore_channel"),
        matchMap.get("restore_plan_binding"));
  }

  public static List<RestorePlanBindingName> parseList(List<String> formattedStrings) {
    List<RestorePlanBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RestorePlanBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RestorePlanBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RESTORE_CHANNEL_RESTORE_PLAN_BINDING.matches(formattedString);
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
          if (restoreChannel != null) {
            fieldMapBuilder.put("restore_channel", restoreChannel);
          }
          if (restorePlanBinding != null) {
            fieldMapBuilder.put("restore_plan_binding", restorePlanBinding);
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
    return PROJECT_LOCATION_RESTORE_CHANNEL_RESTORE_PLAN_BINDING.instantiate(
        "project",
        project,
        "location",
        location,
        "restore_channel",
        restoreChannel,
        "restore_plan_binding",
        restorePlanBinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RestorePlanBindingName that = ((RestorePlanBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.restoreChannel, that.restoreChannel)
          && Objects.equals(this.restorePlanBinding, that.restorePlanBinding);
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
    h ^= Objects.hashCode(restoreChannel);
    h *= 1000003;
    h ^= Objects.hashCode(restorePlanBinding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/restoreChannels/{restore_channel}/restorePlanBindings/{restore_plan_binding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String restoreChannel;
    private String restorePlanBinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRestoreChannel() {
      return restoreChannel;
    }

    public String getRestorePlanBinding() {
      return restorePlanBinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRestoreChannel(String restoreChannel) {
      this.restoreChannel = restoreChannel;
      return this;
    }

    public Builder setRestorePlanBinding(String restorePlanBinding) {
      this.restorePlanBinding = restorePlanBinding;
      return this;
    }

    private Builder(RestorePlanBindingName restorePlanBindingName) {
      this.project = restorePlanBindingName.project;
      this.location = restorePlanBindingName.location;
      this.restoreChannel = restorePlanBindingName.restoreChannel;
      this.restorePlanBinding = restorePlanBindingName.restorePlanBinding;
    }

    public RestorePlanBindingName build() {
      return new RestorePlanBindingName(this);
    }
  }
}
