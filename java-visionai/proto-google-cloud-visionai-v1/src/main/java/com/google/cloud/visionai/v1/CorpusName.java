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

package com.google.cloud.visionai.v1;

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
public class CorpusName implements ResourceName {
  private static final PathTemplate PROJECT_NUMBER_LOCATION_CORPUS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project_number}/locations/{location}/corpora/{corpus}");
  private volatile Map<String, String> fieldValuesMap;
  private final String projectNumber;
  private final String location;
  private final String corpus;

  @Deprecated
  protected CorpusName() {
    projectNumber = null;
    location = null;
    corpus = null;
  }

  private CorpusName(Builder builder) {
    projectNumber = Preconditions.checkNotNull(builder.getProjectNumber());
    location = Preconditions.checkNotNull(builder.getLocation());
    corpus = Preconditions.checkNotNull(builder.getCorpus());
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public String getLocation() {
    return location;
  }

  public String getCorpus() {
    return corpus;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CorpusName of(String projectNumber, String location, String corpus) {
    return newBuilder()
        .setProjectNumber(projectNumber)
        .setLocation(location)
        .setCorpus(corpus)
        .build();
  }

  public static String format(String projectNumber, String location, String corpus) {
    return newBuilder()
        .setProjectNumber(projectNumber)
        .setLocation(location)
        .setCorpus(corpus)
        .build()
        .toString();
  }

  public static CorpusName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_NUMBER_LOCATION_CORPUS.validatedMatch(
            formattedString, "CorpusName.parse: formattedString not in valid format");
    return of(matchMap.get("project_number"), matchMap.get("location"), matchMap.get("corpus"));
  }

  public static List<CorpusName> parseList(List<String> formattedStrings) {
    List<CorpusName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CorpusName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CorpusName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_NUMBER_LOCATION_CORPUS.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (projectNumber != null) {
            fieldMapBuilder.put("project_number", projectNumber);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (corpus != null) {
            fieldMapBuilder.put("corpus", corpus);
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
    return PROJECT_NUMBER_LOCATION_CORPUS.instantiate(
        "project_number", projectNumber, "location", location, "corpus", corpus);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CorpusName that = ((CorpusName) o);
      return Objects.equals(this.projectNumber, that.projectNumber)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.corpus, that.corpus);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(projectNumber);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(corpus);
    return h;
  }

  /** Builder for projects/{project_number}/locations/{location}/corpora/{corpus}. */
  public static class Builder {
    private String projectNumber;
    private String location;
    private String corpus;

    protected Builder() {}

    public String getProjectNumber() {
      return projectNumber;
    }

    public String getLocation() {
      return location;
    }

    public String getCorpus() {
      return corpus;
    }

    public Builder setProjectNumber(String projectNumber) {
      this.projectNumber = projectNumber;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCorpus(String corpus) {
      this.corpus = corpus;
      return this;
    }

    private Builder(CorpusName corpusName) {
      this.projectNumber = corpusName.projectNumber;
      this.location = corpusName.location;
      this.corpus = corpusName.corpus;
    }

    public CorpusName build() {
      return new CorpusName(this);
    }
  }
}
