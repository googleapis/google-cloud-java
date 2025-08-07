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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

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
public class RolloutKindName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ROLLOUT_KIND_ID =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/rolloutKinds/{rollout_kind_id}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String rolloutKindId;

  @Deprecated
  protected RolloutKindName() {
    project = null;
    location = null;
    rolloutKindId = null;
  }

  private RolloutKindName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    rolloutKindId = Preconditions.checkNotNull(builder.getRolloutKindId());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRolloutKindId() {
    return rolloutKindId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RolloutKindName of(String project, String location, String rolloutKindId) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRolloutKindId(rolloutKindId)
        .build();
  }

  public static String format(String project, String location, String rolloutKindId) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRolloutKindId(rolloutKindId)
        .build()
        .toString();
  }

  public static RolloutKindName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ROLLOUT_KIND_ID.validatedMatch(
            formattedString, "RolloutKindName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("rollout_kind_id"));
  }

  public static List<RolloutKindName> parseList(List<String> formattedStrings) {
    List<RolloutKindName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RolloutKindName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RolloutKindName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ROLLOUT_KIND_ID.matches(formattedString);
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
          if (rolloutKindId != null) {
            fieldMapBuilder.put("rollout_kind_id", rolloutKindId);
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
    return PROJECT_LOCATION_ROLLOUT_KIND_ID.instantiate(
        "project", project, "location", location, "rollout_kind_id", rolloutKindId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RolloutKindName that = ((RolloutKindName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.rolloutKindId, that.rolloutKindId);
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
    h ^= Objects.hashCode(rolloutKindId);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/rolloutKinds/{rollout_kind_id}. */
  public static class Builder {
    private String project;
    private String location;
    private String rolloutKindId;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRolloutKindId() {
      return rolloutKindId;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRolloutKindId(String rolloutKindId) {
      this.rolloutKindId = rolloutKindId;
      return this;
    }

    private Builder(RolloutKindName rolloutKindName) {
      this.project = rolloutKindName.project;
      this.location = rolloutKindName.location;
      this.rolloutKindId = rolloutKindName.rolloutKindId;
    }

    public RolloutKindName build() {
      return new RolloutKindName(this);
    }
  }
}
