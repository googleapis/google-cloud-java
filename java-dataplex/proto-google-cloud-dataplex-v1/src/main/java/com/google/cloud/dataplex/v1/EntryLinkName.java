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
public class EntryLinkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENTRY_GROUP_ENTRY_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entryGroups/{entry_group}/entryLinks/{entry_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String entryGroup;
  private final String entryLink;

  @Deprecated
  protected EntryLinkName() {
    project = null;
    location = null;
    entryGroup = null;
    entryLink = null;
  }

  private EntryLinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entryGroup = Preconditions.checkNotNull(builder.getEntryGroup());
    entryLink = Preconditions.checkNotNull(builder.getEntryLink());
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

  public String getEntryLink() {
    return entryLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EntryLinkName of(
      String project, String location, String entryGroup, String entryLink) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntryGroup(entryGroup)
        .setEntryLink(entryLink)
        .build();
  }

  public static String format(
      String project, String location, String entryGroup, String entryLink) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntryGroup(entryGroup)
        .setEntryLink(entryLink)
        .build()
        .toString();
  }

  public static EntryLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ENTRY_GROUP_ENTRY_LINK.validatedMatch(
            formattedString, "EntryLinkName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("entry_group"),
        matchMap.get("entry_link"));
  }

  public static List<EntryLinkName> parseList(List<String> formattedStrings) {
    List<EntryLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntryLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EntryLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENTRY_GROUP_ENTRY_LINK.matches(formattedString);
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
          if (entryLink != null) {
            fieldMapBuilder.put("entry_link", entryLink);
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
    return PROJECT_LOCATION_ENTRY_GROUP_ENTRY_LINK.instantiate(
        "project",
        project,
        "location",
        location,
        "entry_group",
        entryGroup,
        "entry_link",
        entryLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EntryLinkName that = ((EntryLinkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.entryGroup, that.entryGroup)
          && Objects.equals(this.entryLink, that.entryLink);
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
    h ^= Objects.hashCode(entryLink);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/entryGroups/{entry_group}/entryLinks/{entry_link}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String entryGroup;
    private String entryLink;

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

    public String getEntryLink() {
      return entryLink;
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

    public Builder setEntryLink(String entryLink) {
      this.entryLink = entryLink;
      return this;
    }

    private Builder(EntryLinkName entryLinkName) {
      this.project = entryLinkName.project;
      this.location = entryLinkName.location;
      this.entryGroup = entryLinkName.entryGroup;
      this.entryLink = entryLinkName.entryLink;
    }

    public EntryLinkName build() {
      return new EntryLinkName(this);
    }
  }
}
