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

package com.google.cloud.speech.v1;

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
public class PhraseSetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PHRASE_SET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/phraseSets/{phrase_set}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String phraseSet;

  @Deprecated
  protected PhraseSetName() {
    project = null;
    location = null;
    phraseSet = null;
  }

  private PhraseSetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    phraseSet = Preconditions.checkNotNull(builder.getPhraseSet());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPhraseSet() {
    return phraseSet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PhraseSetName of(String project, String location, String phraseSet) {
    return newBuilder().setProject(project).setLocation(location).setPhraseSet(phraseSet).build();
  }

  public static String format(String project, String location, String phraseSet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPhraseSet(phraseSet)
        .build()
        .toString();
  }

  public static PhraseSetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PHRASE_SET.validatedMatch(
            formattedString, "PhraseSetName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("phrase_set"));
  }

  public static List<PhraseSetName> parseList(List<String> formattedStrings) {
    List<PhraseSetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PhraseSetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PhraseSetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PHRASE_SET.matches(formattedString);
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
          if (phraseSet != null) {
            fieldMapBuilder.put("phrase_set", phraseSet);
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
    return PROJECT_LOCATION_PHRASE_SET.instantiate(
        "project", project, "location", location, "phrase_set", phraseSet);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PhraseSetName that = ((PhraseSetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.phraseSet, that.phraseSet);
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
    h ^= Objects.hashCode(phraseSet);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/phraseSets/{phrase_set}. */
  public static class Builder {
    private String project;
    private String location;
    private String phraseSet;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPhraseSet() {
      return phraseSet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPhraseSet(String phraseSet) {
      this.phraseSet = phraseSet;
      return this;
    }

    private Builder(PhraseSetName phraseSetName) {
      this.project = phraseSetName.project;
      this.location = phraseSetName.location;
      this.phraseSet = phraseSetName.phraseSet;
    }

    public PhraseSetName build() {
      return new PhraseSetName(this);
    }
  }
}
