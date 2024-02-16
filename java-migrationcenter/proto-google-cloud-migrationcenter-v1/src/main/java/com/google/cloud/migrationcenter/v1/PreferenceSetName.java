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

package com.google.cloud.migrationcenter.v1;

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
public class PreferenceSetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PREFERENCE_SET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/preferenceSets/{preference_set}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String preferenceSet;

  @Deprecated
  protected PreferenceSetName() {
    project = null;
    location = null;
    preferenceSet = null;
  }

  private PreferenceSetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    preferenceSet = Preconditions.checkNotNull(builder.getPreferenceSet());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPreferenceSet() {
    return preferenceSet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PreferenceSetName of(String project, String location, String preferenceSet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPreferenceSet(preferenceSet)
        .build();
  }

  public static String format(String project, String location, String preferenceSet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPreferenceSet(preferenceSet)
        .build()
        .toString();
  }

  public static PreferenceSetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PREFERENCE_SET.validatedMatch(
            formattedString, "PreferenceSetName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("preference_set"));
  }

  public static List<PreferenceSetName> parseList(List<String> formattedStrings) {
    List<PreferenceSetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PreferenceSetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PreferenceSetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PREFERENCE_SET.matches(formattedString);
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
          if (preferenceSet != null) {
            fieldMapBuilder.put("preference_set", preferenceSet);
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
    return PROJECT_LOCATION_PREFERENCE_SET.instantiate(
        "project", project, "location", location, "preference_set", preferenceSet);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PreferenceSetName that = ((PreferenceSetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.preferenceSet, that.preferenceSet);
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
    h ^= Objects.hashCode(preferenceSet);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/preferenceSets/{preference_set}. */
  public static class Builder {
    private String project;
    private String location;
    private String preferenceSet;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPreferenceSet() {
      return preferenceSet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPreferenceSet(String preferenceSet) {
      this.preferenceSet = preferenceSet;
      return this;
    }

    private Builder(PreferenceSetName preferenceSetName) {
      this.project = preferenceSetName.project;
      this.location = preferenceSetName.location;
      this.preferenceSet = preferenceSetName.preferenceSet;
    }

    public PreferenceSetName build() {
      return new PreferenceSetName(this);
    }
  }
}
