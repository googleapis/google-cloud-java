/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.datacatalog.v1beta1;

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
public class EntryGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENTRY_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryGroups/{entry_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String entryGroup;

  @Deprecated
  protected EntryGroupName() {
    project = null;
    location = null;
    entryGroup = null;
  }

  private EntryGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entryGroup = Preconditions.checkNotNull(builder.getEntryGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getEntryGroup() {
    return entryGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EntryGroupName of(String project, String location, String entryGroup) {
    return newBuilder().setProject(project).setLocation(location).setEntryGroup(entryGroup).build();
  }

  public static String format(String project, String location, String entryGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntryGroup(entryGroup)
        .build()
        .toString();
  }

  public static EntryGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ENTRY_GROUP.validatedMatch(
            formattedString, "EntryGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("entry_group"));
  }

  public static List<EntryGroupName> parseList(List<String> formattedStrings) {
    List<EntryGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntryGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EntryGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENTRY_GROUP.matches(formattedString);
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
          if (entryGroup != null) {
            fieldMapBuilder.put("entry_group", entryGroup);
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
    return PROJECT_LOCATION_ENTRY_GROUP.instantiate(
        "project", project, "location", location, "entry_group", entryGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      EntryGroupName that = ((EntryGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.entryGroup, that.entryGroup);
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
    h ^= Objects.hashCode(entryGroup);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/entryGroups/{entry_group}. */
  public static class Builder {
    private String project;
    private String location;
    private String entryGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEntryGroup() {
      return entryGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEntryGroup(String entryGroup) {
      this.entryGroup = entryGroup;
      return this;
    }

    private Builder(EntryGroupName entryGroupName) {
      project = entryGroupName.project;
      location = entryGroupName.location;
      entryGroup = entryGroupName.entryGroup;
    }

    public EntryGroupName build() {
      return new EntryGroupName(this);
    }
  }
}
