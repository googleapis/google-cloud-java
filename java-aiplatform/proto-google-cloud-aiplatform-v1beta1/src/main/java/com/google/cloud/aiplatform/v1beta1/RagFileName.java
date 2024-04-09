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

package com.google.cloud.aiplatform.v1beta1;

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
public class RagFileName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RAG_CORPUS_RAG_FILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String ragCorpus;
  private final String ragFile;

  @Deprecated
  protected RagFileName() {
    project = null;
    location = null;
    ragCorpus = null;
    ragFile = null;
  }

  private RagFileName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    ragCorpus = Preconditions.checkNotNull(builder.getRagCorpus());
    ragFile = Preconditions.checkNotNull(builder.getRagFile());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRagCorpus() {
    return ragCorpus;
  }

  public String getRagFile() {
    return ragFile;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RagFileName of(String project, String location, String ragCorpus, String ragFile) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRagCorpus(ragCorpus)
        .setRagFile(ragFile)
        .build();
  }

  public static String format(String project, String location, String ragCorpus, String ragFile) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRagCorpus(ragCorpus)
        .setRagFile(ragFile)
        .build()
        .toString();
  }

  public static RagFileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RAG_CORPUS_RAG_FILE.validatedMatch(
            formattedString, "RagFileName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("rag_corpus"),
        matchMap.get("rag_file"));
  }

  public static List<RagFileName> parseList(List<String> formattedStrings) {
    List<RagFileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RagFileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RagFileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RAG_CORPUS_RAG_FILE.matches(formattedString);
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
          if (ragCorpus != null) {
            fieldMapBuilder.put("rag_corpus", ragCorpus);
          }
          if (ragFile != null) {
            fieldMapBuilder.put("rag_file", ragFile);
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
    return PROJECT_LOCATION_RAG_CORPUS_RAG_FILE.instantiate(
        "project", project, "location", location, "rag_corpus", ragCorpus, "rag_file", ragFile);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RagFileName that = ((RagFileName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.ragCorpus, that.ragCorpus)
          && Objects.equals(this.ragFile, that.ragFile);
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
    h ^= Objects.hashCode(ragCorpus);
    h *= 1000003;
    h ^= Objects.hashCode(ragFile);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String ragCorpus;
    private String ragFile;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRagCorpus() {
      return ragCorpus;
    }

    public String getRagFile() {
      return ragFile;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRagCorpus(String ragCorpus) {
      this.ragCorpus = ragCorpus;
      return this;
    }

    public Builder setRagFile(String ragFile) {
      this.ragFile = ragFile;
      return this;
    }

    private Builder(RagFileName ragFileName) {
      this.project = ragFileName.project;
      this.location = ragFileName.location;
      this.ragCorpus = ragFileName.ragCorpus;
      this.ragFile = ragFileName.ragFile;
    }

    public RagFileName build() {
      return new RagFileName(this);
    }
  }
}
