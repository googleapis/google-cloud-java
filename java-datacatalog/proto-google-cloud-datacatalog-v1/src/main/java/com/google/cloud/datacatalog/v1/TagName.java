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

package com.google.cloud.datacatalog.v1;

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
public class TagName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENTRY_GROUP_ENTRY_TAG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}/tags/{tag}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String entryGroup;
  private final String entry;
  private final String tag;

  @Deprecated
  protected TagName() {
    project = null;
    location = null;
    entryGroup = null;
    entry = null;
    tag = null;
  }

  private TagName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entryGroup = Preconditions.checkNotNull(builder.getEntryGroup());
    entry = Preconditions.checkNotNull(builder.getEntry());
    tag = Preconditions.checkNotNull(builder.getTag());
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

  public String getEntry() {
    return entry;
  }

  public String getTag() {
    return tag;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TagName of(
      String project, String location, String entryGroup, String entry, String tag) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntryGroup(entryGroup)
        .setEntry(entry)
        .setTag(tag)
        .build();
  }

  public static String format(
      String project, String location, String entryGroup, String entry, String tag) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntryGroup(entryGroup)
        .setEntry(entry)
        .setTag(tag)
        .build()
        .toString();
  }

  public static TagName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ENTRY_GROUP_ENTRY_TAG.validatedMatch(
            formattedString, "TagName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("entry_group"),
        matchMap.get("entry"),
        matchMap.get("tag"));
  }

  public static List<TagName> parseList(List<String> formattedStrings) {
    List<TagName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TagName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENTRY_GROUP_ENTRY_TAG.matches(formattedString);
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
          if (entry != null) {
            fieldMapBuilder.put("entry", entry);
          }
          if (tag != null) {
            fieldMapBuilder.put("tag", tag);
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
    return PROJECT_LOCATION_ENTRY_GROUP_ENTRY_TAG.instantiate(
        "project",
        project,
        "location",
        location,
        "entry_group",
        entryGroup,
        "entry",
        entry,
        "tag",
        tag);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TagName that = ((TagName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.entryGroup, that.entryGroup)
          && Objects.equals(this.entry, that.entry)
          && Objects.equals(this.tag, that.tag);
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
    h *= 1000003;
    h ^= Objects.hashCode(entry);
    h *= 1000003;
    h ^= Objects.hashCode(tag);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/entryGroups/{entry_group}/entries/{entry}/tags/{tag}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String entryGroup;
    private String entry;
    private String tag;

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

    public String getEntry() {
      return entry;
    }

    public String getTag() {
      return tag;
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

    public Builder setEntry(String entry) {
      this.entry = entry;
      return this;
    }

    public Builder setTag(String tag) {
      this.tag = tag;
      return this;
    }

    private Builder(TagName tagName) {
      project = tagName.project;
      location = tagName.location;
      entryGroup = tagName.entryGroup;
      entry = tagName.entry;
      tag = tagName.tag;
    }

    public TagName build() {
      return new TagName(this);
    }
  }
}
