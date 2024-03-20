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

package com.google.cloud.dataplex.v1;

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
public class EntryTypeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENTRY_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryTypes/{entry_type}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String entryType;

  @Deprecated
  protected EntryTypeName() {
    project = null;
    location = null;
    entryType = null;
  }

  private EntryTypeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entryType = Preconditions.checkNotNull(builder.getEntryType());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getEntryType() {
    return entryType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EntryTypeName of(String project, String location, String entryType) {
    return newBuilder().setProject(project).setLocation(location).setEntryType(entryType).build();
  }

  public static String format(String project, String location, String entryType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntryType(entryType)
        .build()
        .toString();
  }

  public static EntryTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ENTRY_TYPE.validatedMatch(
            formattedString, "EntryTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("entry_type"));
  }

  public static List<EntryTypeName> parseList(List<String> formattedStrings) {
    List<EntryTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntryTypeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EntryTypeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENTRY_TYPE.matches(formattedString);
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
          if (entryType != null) {
            fieldMapBuilder.put("entry_type", entryType);
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
    return PROJECT_LOCATION_ENTRY_TYPE.instantiate(
        "project", project, "location", location, "entry_type", entryType);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EntryTypeName that = ((EntryTypeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.entryType, that.entryType);
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
    h ^= Objects.hashCode(entryType);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/entryTypes/{entry_type}. */
  public static class Builder {
    private String project;
    private String location;
    private String entryType;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEntryType() {
      return entryType;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEntryType(String entryType) {
      this.entryType = entryType;
      return this;
    }

    private Builder(EntryTypeName entryTypeName) {
      this.project = entryTypeName.project;
      this.location = entryTypeName.location;
      this.entryType = entryTypeName.entryType;
    }

    public EntryTypeName build() {
      return new EntryTypeName(this);
    }
  }
}
