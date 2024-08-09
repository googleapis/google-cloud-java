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

package com.google.cloud.translate.v3;

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
public class GlossaryEntryName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GLOSSARY_GLOSSARY_ENTRY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/glossaries/{glossary}/glossaryEntries/{glossary_entry}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String glossary;
  private final String glossaryEntry;

  @Deprecated
  protected GlossaryEntryName() {
    project = null;
    location = null;
    glossary = null;
    glossaryEntry = null;
  }

  private GlossaryEntryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    glossary = Preconditions.checkNotNull(builder.getGlossary());
    glossaryEntry = Preconditions.checkNotNull(builder.getGlossaryEntry());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGlossary() {
    return glossary;
  }

  public String getGlossaryEntry() {
    return glossaryEntry;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GlossaryEntryName of(
      String project, String location, String glossary, String glossaryEntry) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGlossary(glossary)
        .setGlossaryEntry(glossaryEntry)
        .build();
  }

  public static String format(
      String project, String location, String glossary, String glossaryEntry) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGlossary(glossary)
        .setGlossaryEntry(glossaryEntry)
        .build()
        .toString();
  }

  public static GlossaryEntryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GLOSSARY_GLOSSARY_ENTRY.validatedMatch(
            formattedString, "GlossaryEntryName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("glossary"),
        matchMap.get("glossary_entry"));
  }

  public static List<GlossaryEntryName> parseList(List<String> formattedStrings) {
    List<GlossaryEntryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GlossaryEntryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GlossaryEntryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GLOSSARY_GLOSSARY_ENTRY.matches(formattedString);
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
          if (glossary != null) {
            fieldMapBuilder.put("glossary", glossary);
          }
          if (glossaryEntry != null) {
            fieldMapBuilder.put("glossary_entry", glossaryEntry);
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
    return PROJECT_LOCATION_GLOSSARY_GLOSSARY_ENTRY.instantiate(
        "project",
        project,
        "location",
        location,
        "glossary",
        glossary,
        "glossary_entry",
        glossaryEntry);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GlossaryEntryName that = ((GlossaryEntryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.glossary, that.glossary)
          && Objects.equals(this.glossaryEntry, that.glossaryEntry);
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
    h ^= Objects.hashCode(glossary);
    h *= 1000003;
    h ^= Objects.hashCode(glossaryEntry);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/glossaries/{glossary}/glossaryEntries/{glossary_entry}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String glossary;
    private String glossaryEntry;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGlossary() {
      return glossary;
    }

    public String getGlossaryEntry() {
      return glossaryEntry;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGlossary(String glossary) {
      this.glossary = glossary;
      return this;
    }

    public Builder setGlossaryEntry(String glossaryEntry) {
      this.glossaryEntry = glossaryEntry;
      return this;
    }

    private Builder(GlossaryEntryName glossaryEntryName) {
      this.project = glossaryEntryName.project;
      this.location = glossaryEntryName.location;
      this.glossary = glossaryEntryName.glossary;
      this.glossaryEntry = glossaryEntryName.glossaryEntry;
    }

    public GlossaryEntryName build() {
      return new GlossaryEntryName(this);
    }
  }
}
