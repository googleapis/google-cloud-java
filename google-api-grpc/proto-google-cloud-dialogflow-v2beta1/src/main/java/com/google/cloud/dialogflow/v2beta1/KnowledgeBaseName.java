/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dialogflow.v2beta1;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class KnowledgeBaseName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/knowledgeBases/{knowledge_base}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String knowledgeBase;

  public String getProject() {
    return project;
  }

  public String getKnowledgeBase() {
    return knowledgeBase;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private KnowledgeBaseName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    knowledgeBase = Preconditions.checkNotNull(builder.getKnowledgeBase());
  }

  public static KnowledgeBaseName of(String project, String knowledgeBase) {
    return newBuilder()
      .setProject(project)
      .setKnowledgeBase(knowledgeBase)
      .build();
  }

  public static String format(String project, String knowledgeBase) {
    return newBuilder()
      .setProject(project)
      .setKnowledgeBase(knowledgeBase)
      .build()
      .toString();
  }

  public static KnowledgeBaseName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "KnowledgeBaseName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("knowledge_base"));
  }

  public static List<KnowledgeBaseName> parseList(List<String> formattedStrings) {
    List<KnowledgeBaseName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<KnowledgeBaseName> values) {
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("knowledgeBase", knowledgeBase);
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
    return PATH_TEMPLATE.instantiate("project", project, "knowledge_base", knowledgeBase);
  }

  /** Builder for KnowledgeBaseName. */
  public static class Builder {

    private String project;
    private String knowledgeBase;

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

    private Builder() {
    }

    private Builder(KnowledgeBaseName knowledgeBaseName) {
      project = knowledgeBaseName.project;
      knowledgeBase = knowledgeBaseName.knowledgeBase;
    }

    public KnowledgeBaseName build() {
      return new KnowledgeBaseName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof KnowledgeBaseName) {
      KnowledgeBaseName that = (KnowledgeBaseName) o;
      return (this.project.equals(that.project))
          && (this.knowledgeBase.equals(that.knowledgeBase));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= knowledgeBase.hashCode();
    return h;
  }
}

