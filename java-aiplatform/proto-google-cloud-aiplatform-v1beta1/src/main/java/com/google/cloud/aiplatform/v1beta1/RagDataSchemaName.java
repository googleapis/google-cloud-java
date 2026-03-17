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
public class RagDataSchemaName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RAG_CORPUS_RAG_DATA_SCHEMA =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragDataSchemas/{rag_data_schema}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String ragCorpus;
  private final String ragDataSchema;

  @Deprecated
  protected RagDataSchemaName() {
    project = null;
    location = null;
    ragCorpus = null;
    ragDataSchema = null;
  }

  private RagDataSchemaName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    ragCorpus = Preconditions.checkNotNull(builder.getRagCorpus());
    ragDataSchema = Preconditions.checkNotNull(builder.getRagDataSchema());
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

  public String getRagDataSchema() {
    return ragDataSchema;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RagDataSchemaName of(
      String project, String location, String ragCorpus, String ragDataSchema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRagCorpus(ragCorpus)
        .setRagDataSchema(ragDataSchema)
        .build();
  }

  public static String format(
      String project, String location, String ragCorpus, String ragDataSchema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRagCorpus(ragCorpus)
        .setRagDataSchema(ragDataSchema)
        .build()
        .toString();
  }

  public static RagDataSchemaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RAG_CORPUS_RAG_DATA_SCHEMA.validatedMatch(
            formattedString, "RagDataSchemaName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("rag_corpus"),
        matchMap.get("rag_data_schema"));
  }

  public static List<RagDataSchemaName> parseList(List<String> formattedStrings) {
    List<RagDataSchemaName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RagDataSchemaName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RagDataSchemaName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RAG_CORPUS_RAG_DATA_SCHEMA.matches(formattedString);
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
          if (ragDataSchema != null) {
            fieldMapBuilder.put("rag_data_schema", ragDataSchema);
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
    return PROJECT_LOCATION_RAG_CORPUS_RAG_DATA_SCHEMA.instantiate(
        "project",
        project,
        "location",
        location,
        "rag_corpus",
        ragCorpus,
        "rag_data_schema",
        ragDataSchema);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RagDataSchemaName that = ((RagDataSchemaName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.ragCorpus, that.ragCorpus)
          && Objects.equals(this.ragDataSchema, that.ragDataSchema);
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
    h ^= Objects.hashCode(ragDataSchema);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/ragCorpora/{rag_corpus}/ragDataSchemas/{rag_data_schema}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String ragCorpus;
    private String ragDataSchema;

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

    public String getRagDataSchema() {
      return ragDataSchema;
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

    public Builder setRagDataSchema(String ragDataSchema) {
      this.ragDataSchema = ragDataSchema;
      return this;
    }

    private Builder(RagDataSchemaName ragDataSchemaName) {
      this.project = ragDataSchemaName.project;
      this.location = ragDataSchemaName.location;
      this.ragCorpus = ragDataSchemaName.ragCorpus;
      this.ragDataSchema = ragDataSchemaName.ragDataSchema;
    }

    public RagDataSchemaName build() {
      return new RagDataSchemaName(this);
    }
  }
}
