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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class KnowledgeBaseName implements ResourceName {
  private static final PathTemplate PROJECT_KNOWLEDGE_BASE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/knowledgeBases/{knowledge_base}");
  private static final PathTemplate PROJECT_LOCATION_KNOWLEDGE_BASE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/knowledgeBases/{knowledge_base}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String knowledgeBase;
  private final String location;

  @Deprecated
  protected KnowledgeBaseName() {
    project = null;
    knowledgeBase = null;
    location = null;
  }

  private KnowledgeBaseName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    knowledgeBase = Preconditions.checkNotNull(builder.getKnowledgeBase());
    location = null;
    pathTemplate = PROJECT_KNOWLEDGE_BASE;
  }

  private KnowledgeBaseName(ProjectLocationKnowledgeBaseBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    knowledgeBase = Preconditions.checkNotNull(builder.getKnowledgeBase());
    pathTemplate = PROJECT_LOCATION_KNOWLEDGE_BASE;
  }

  public String getProject() {
    return project;
  }

  public String getKnowledgeBase() {
    return knowledgeBase;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectKnowledgeBaseBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationKnowledgeBaseBuilder newProjectLocationKnowledgeBaseBuilder() {
    return new ProjectLocationKnowledgeBaseBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static KnowledgeBaseName of(String project, String knowledgeBase) {
    return newBuilder().setProject(project).setKnowledgeBase(knowledgeBase).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static KnowledgeBaseName ofProjectKnowledgeBaseName(String project, String knowledgeBase) {
    return newBuilder().setProject(project).setKnowledgeBase(knowledgeBase).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static KnowledgeBaseName ofProjectLocationKnowledgeBaseName(
      String project, String location, String knowledgeBase) {
    return newProjectLocationKnowledgeBaseBuilder()
        .setProject(project)
        .setLocation(location)
        .setKnowledgeBase(knowledgeBase)
        .build();
  }

  public static String format(String project, String knowledgeBase) {
    return newBuilder().setProject(project).setKnowledgeBase(knowledgeBase).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectKnowledgeBaseName(String project, String knowledgeBase) {
    return newBuilder().setProject(project).setKnowledgeBase(knowledgeBase).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationKnowledgeBaseName(
      String project, String location, String knowledgeBase) {
    return newProjectLocationKnowledgeBaseBuilder()
        .setProject(project)
        .setLocation(location)
        .setKnowledgeBase(knowledgeBase)
        .build()
        .toString();
  }

  public static KnowledgeBaseName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_KNOWLEDGE_BASE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_KNOWLEDGE_BASE.match(formattedString);
      return ofProjectKnowledgeBaseName(matchMap.get("project"), matchMap.get("knowledge_base"));
    } else if (PROJECT_LOCATION_KNOWLEDGE_BASE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_KNOWLEDGE_BASE.match(formattedString);
      return ofProjectLocationKnowledgeBaseName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("knowledge_base"));
    }
    throw new ValidationException("KnowledgeBaseName.parse: formattedString not in valid format");
  }

  public static List<KnowledgeBaseName> parseList(List<String> formattedStrings) {
    List<KnowledgeBaseName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<KnowledgeBaseName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (KnowledgeBaseName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_KNOWLEDGE_BASE.matches(formattedString)
        || PROJECT_LOCATION_KNOWLEDGE_BASE.matches(formattedString);
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
          if (knowledgeBase != null) {
            fieldMapBuilder.put("knowledge_base", knowledgeBase);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      KnowledgeBaseName that = ((KnowledgeBaseName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.knowledgeBase, that.knowledgeBase)
          && Objects.equals(this.location, that.location);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(knowledgeBase);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/knowledgeBases/{knowledge_base}. */
  public static class Builder {
    private String project;
    private String knowledgeBase;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getKnowledgeBase() {
      return knowledgeBase;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setKnowledgeBase(String knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
      return this;
    }

    private Builder(KnowledgeBaseName knowledgeBaseName) {
      Preconditions.checkArgument(
          Objects.equals(knowledgeBaseName.pathTemplate, PROJECT_KNOWLEDGE_BASE),
          "toBuilder is only supported when KnowledgeBaseName has the pattern of projects/{project}/knowledgeBases/{knowledge_base}");
      this.project = knowledgeBaseName.project;
      this.knowledgeBase = knowledgeBaseName.knowledgeBase;
    }

    public KnowledgeBaseName build() {
      return new KnowledgeBaseName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/knowledgeBases/{knowledge_base}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationKnowledgeBaseBuilder {
    private String project;
    private String location;
    private String knowledgeBase;

    protected ProjectLocationKnowledgeBaseBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKnowledgeBase() {
      return knowledgeBase;
    }

    public ProjectLocationKnowledgeBaseBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationKnowledgeBaseBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationKnowledgeBaseBuilder setKnowledgeBase(String knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
      return this;
    }

    public KnowledgeBaseName build() {
      return new KnowledgeBaseName(this);
    }
  }
}
