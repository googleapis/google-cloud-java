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

package com.google.cloud.enterpriseknowledgegraph.v1;

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
public class PublicKnowledgeGraphEntityName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PUBLIC_KNOWLEDGE_GRAPH_ENTITY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/publicKnowledgeGraphEntities/{public_knowledge_graph_entity}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String publicKnowledgeGraphEntity;

  @Deprecated
  protected PublicKnowledgeGraphEntityName() {
    project = null;
    location = null;
    publicKnowledgeGraphEntity = null;
  }

  private PublicKnowledgeGraphEntityName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    publicKnowledgeGraphEntity =
        Preconditions.checkNotNull(builder.getPublicKnowledgeGraphEntity());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPublicKnowledgeGraphEntity() {
    return publicKnowledgeGraphEntity;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PublicKnowledgeGraphEntityName of(
      String project, String location, String publicKnowledgeGraphEntity) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPublicKnowledgeGraphEntity(publicKnowledgeGraphEntity)
        .build();
  }

  public static String format(String project, String location, String publicKnowledgeGraphEntity) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPublicKnowledgeGraphEntity(publicKnowledgeGraphEntity)
        .build()
        .toString();
  }

  public static PublicKnowledgeGraphEntityName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PUBLIC_KNOWLEDGE_GRAPH_ENTITY.validatedMatch(
            formattedString,
            "PublicKnowledgeGraphEntityName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("public_knowledge_graph_entity"));
  }

  public static List<PublicKnowledgeGraphEntityName> parseList(List<String> formattedStrings) {
    List<PublicKnowledgeGraphEntityName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PublicKnowledgeGraphEntityName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PublicKnowledgeGraphEntityName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PUBLIC_KNOWLEDGE_GRAPH_ENTITY.matches(formattedString);
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
          if (publicKnowledgeGraphEntity != null) {
            fieldMapBuilder.put("public_knowledge_graph_entity", publicKnowledgeGraphEntity);
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
    return PROJECT_LOCATION_PUBLIC_KNOWLEDGE_GRAPH_ENTITY.instantiate(
        "project",
        project,
        "location",
        location,
        "public_knowledge_graph_entity",
        publicKnowledgeGraphEntity);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PublicKnowledgeGraphEntityName that = ((PublicKnowledgeGraphEntityName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.publicKnowledgeGraphEntity, that.publicKnowledgeGraphEntity);
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
    h ^= Objects.hashCode(publicKnowledgeGraphEntity);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/publicKnowledgeGraphEntities/{public_knowledge_graph_entity}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String publicKnowledgeGraphEntity;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPublicKnowledgeGraphEntity() {
      return publicKnowledgeGraphEntity;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPublicKnowledgeGraphEntity(String publicKnowledgeGraphEntity) {
      this.publicKnowledgeGraphEntity = publicKnowledgeGraphEntity;
      return this;
    }

    private Builder(PublicKnowledgeGraphEntityName publicKnowledgeGraphEntityName) {
      this.project = publicKnowledgeGraphEntityName.project;
      this.location = publicKnowledgeGraphEntityName.location;
      this.publicKnowledgeGraphEntity = publicKnowledgeGraphEntityName.publicKnowledgeGraphEntity;
    }

    public PublicKnowledgeGraphEntityName build() {
      return new PublicKnowledgeGraphEntityName(this);
    }
  }
}
