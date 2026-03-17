/*
 * Copyright 2026 Google LLC
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
public class RagMetadataName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RAG_CORPUS_RAG_FILE_RAG_METADATA =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}/ragMetadata/{rag_metadata}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String ragCorpus;
  private final String ragFile;
  private final String ragMetadata;

  @Deprecated
  protected RagMetadataName() {
    project = null;
    location = null;
    ragCorpus = null;
    ragFile = null;
    ragMetadata = null;
  }

  private RagMetadataName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    ragCorpus = Preconditions.checkNotNull(builder.getRagCorpus());
    ragFile = Preconditions.checkNotNull(builder.getRagFile());
    ragMetadata = Preconditions.checkNotNull(builder.getRagMetadata());
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

  public String getRagMetadata() {
    return ragMetadata;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RagMetadataName of(
      String project, String location, String ragCorpus, String ragFile, String ragMetadata) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRagCorpus(ragCorpus)
        .setRagFile(ragFile)
        .setRagMetadata(ragMetadata)
        .build();
  }

  public static String format(
      String project, String location, String ragCorpus, String ragFile, String ragMetadata) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRagCorpus(ragCorpus)
        .setRagFile(ragFile)
        .setRagMetadata(ragMetadata)
        .build()
        .toString();
  }

  public static RagMetadataName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RAG_CORPUS_RAG_FILE_RAG_METADATA.validatedMatch(
            formattedString, "RagMetadataName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("rag_corpus"),
        matchMap.get("rag_file"),
        matchMap.get("rag_metadata"));
  }

  public static List<RagMetadataName> parseList(List<String> formattedStrings) {
    List<RagMetadataName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RagMetadataName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RagMetadataName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RAG_CORPUS_RAG_FILE_RAG_METADATA.matches(formattedString);
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
          if (ragMetadata != null) {
            fieldMapBuilder.put("rag_metadata", ragMetadata);
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
    return PROJECT_LOCATION_RAG_CORPUS_RAG_FILE_RAG_METADATA.instantiate(
        "project",
        project,
        "location",
        location,
        "rag_corpus",
        ragCorpus,
        "rag_file",
        ragFile,
        "rag_metadata",
        ragMetadata);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RagMetadataName that = ((RagMetadataName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.ragCorpus, that.ragCorpus)
          && Objects.equals(this.ragFile, that.ragFile)
          && Objects.equals(this.ragMetadata, that.ragMetadata);
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
    h *= 1000003;
    h ^= Objects.hashCode(ragMetadata);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragFiles/{rag_file}/ragMetadata/{rag_metadata}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String ragCorpus;
    private String ragFile;
    private String ragMetadata;

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

    public String getRagMetadata() {
      return ragMetadata;
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

    public Builder setRagMetadata(String ragMetadata) {
      this.ragMetadata = ragMetadata;
      return this;
    }

    private Builder(RagMetadataName ragMetadataName) {
      this.project = ragMetadataName.project;
      this.location = ragMetadataName.location;
      this.ragCorpus = ragMetadataName.ragCorpus;
      this.ragFile = ragMetadataName.ragFile;
      this.ragMetadata = ragMetadataName.ragMetadata;
    }

    public RagMetadataName build() {
      return new RagMetadataName(this);
    }
  }
}
