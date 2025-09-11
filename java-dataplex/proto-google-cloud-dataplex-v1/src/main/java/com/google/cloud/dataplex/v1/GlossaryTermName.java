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
public class GlossaryTermName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GLOSSARY_GLOSSARY_TERM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/glossaries/{glossary}/terms/{glossary_term}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String glossary;
  private final String glossaryTerm;

  @Deprecated
  protected GlossaryTermName() {
    project = null;
    location = null;
    glossary = null;
    glossaryTerm = null;
  }

  private GlossaryTermName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    glossary = Preconditions.checkNotNull(builder.getGlossary());
    glossaryTerm = Preconditions.checkNotNull(builder.getGlossaryTerm());
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

  public String getGlossaryTerm() {
    return glossaryTerm;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GlossaryTermName of(
      String project, String location, String glossary, String glossaryTerm) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGlossary(glossary)
        .setGlossaryTerm(glossaryTerm)
        .build();
  }

  public static String format(
      String project, String location, String glossary, String glossaryTerm) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGlossary(glossary)
        .setGlossaryTerm(glossaryTerm)
        .build()
        .toString();
  }

  public static GlossaryTermName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GLOSSARY_GLOSSARY_TERM.validatedMatch(
            formattedString, "GlossaryTermName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("glossary"),
        matchMap.get("glossary_term"));
  }

  public static List<GlossaryTermName> parseList(List<String> formattedStrings) {
    List<GlossaryTermName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GlossaryTermName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GlossaryTermName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GLOSSARY_GLOSSARY_TERM.matches(formattedString);
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
          if (glossaryTerm != null) {
            fieldMapBuilder.put("glossary_term", glossaryTerm);
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
    return PROJECT_LOCATION_GLOSSARY_GLOSSARY_TERM.instantiate(
        "project",
        project,
        "location",
        location,
        "glossary",
        glossary,
        "glossary_term",
        glossaryTerm);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GlossaryTermName that = ((GlossaryTermName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.glossary, that.glossary)
          && Objects.equals(this.glossaryTerm, that.glossaryTerm);
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
    h ^= Objects.hashCode(glossaryTerm);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/glossaries/{glossary}/terms/{glossary_term}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String glossary;
    private String glossaryTerm;

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

    public String getGlossaryTerm() {
      return glossaryTerm;
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

    public Builder setGlossaryTerm(String glossaryTerm) {
      this.glossaryTerm = glossaryTerm;
      return this;
    }

    private Builder(GlossaryTermName glossaryTermName) {
      this.project = glossaryTermName.project;
      this.location = glossaryTermName.location;
      this.glossary = glossaryTermName.glossary;
      this.glossaryTerm = glossaryTermName.glossaryTerm;
    }

    public GlossaryTermName build() {
      return new GlossaryTermName(this);
    }
  }
}
