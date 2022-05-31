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

package com.google.cloud.contactcenterinsights.v1;

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
public class PhraseMatcherName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PHRASE_MATCHER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/phraseMatchers/{phrase_matcher}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String phraseMatcher;

  @Deprecated
  protected PhraseMatcherName() {
    project = null;
    location = null;
    phraseMatcher = null;
  }

  private PhraseMatcherName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    phraseMatcher = Preconditions.checkNotNull(builder.getPhraseMatcher());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPhraseMatcher() {
    return phraseMatcher;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PhraseMatcherName of(String project, String location, String phraseMatcher) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPhraseMatcher(phraseMatcher)
        .build();
  }

  public static String format(String project, String location, String phraseMatcher) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPhraseMatcher(phraseMatcher)
        .build()
        .toString();
  }

  public static PhraseMatcherName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PHRASE_MATCHER.validatedMatch(
            formattedString, "PhraseMatcherName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("phrase_matcher"));
  }

  public static List<PhraseMatcherName> parseList(List<String> formattedStrings) {
    List<PhraseMatcherName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PhraseMatcherName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PhraseMatcherName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PHRASE_MATCHER.matches(formattedString);
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
          if (phraseMatcher != null) {
            fieldMapBuilder.put("phrase_matcher", phraseMatcher);
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
    return PROJECT_LOCATION_PHRASE_MATCHER.instantiate(
        "project", project, "location", location, "phrase_matcher", phraseMatcher);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PhraseMatcherName that = ((PhraseMatcherName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.phraseMatcher, that.phraseMatcher);
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
    h ^= Objects.hashCode(phraseMatcher);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/phraseMatchers/{phrase_matcher}. */
  public static class Builder {
    private String project;
    private String location;
    private String phraseMatcher;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPhraseMatcher() {
      return phraseMatcher;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPhraseMatcher(String phraseMatcher) {
      this.phraseMatcher = phraseMatcher;
      return this;
    }

    private Builder(PhraseMatcherName phraseMatcherName) {
      this.project = phraseMatcherName.project;
      this.location = phraseMatcherName.location;
      this.phraseMatcher = phraseMatcherName.phraseMatcher;
    }

    public PhraseMatcherName build() {
      return new PhraseMatcherName(this);
    }
  }
}
