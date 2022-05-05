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
public class DocumentName implements ResourceName {
  private static final PathTemplate PROJECT_KNOWLEDGE_BASE_DOCUMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/knowledgeBases/{knowledge_base}/documents/{document}");
  private static final PathTemplate PROJECT_LOCATION_KNOWLEDGE_BASE_DOCUMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/knowledgeBases/{knowledge_base}/documents/{document}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String knowledgeBase;
  private final String document;
  private final String location;

  @Deprecated
  protected DocumentName() {
    project = null;
    knowledgeBase = null;
    document = null;
    location = null;
  }

  private DocumentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    knowledgeBase = Preconditions.checkNotNull(builder.getKnowledgeBase());
    document = Preconditions.checkNotNull(builder.getDocument());
    location = null;
    pathTemplate = PROJECT_KNOWLEDGE_BASE_DOCUMENT;
  }

  private DocumentName(ProjectLocationKnowledgeBaseDocumentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    knowledgeBase = Preconditions.checkNotNull(builder.getKnowledgeBase());
    document = Preconditions.checkNotNull(builder.getDocument());
    pathTemplate = PROJECT_LOCATION_KNOWLEDGE_BASE_DOCUMENT;
  }

  public String getProject() {
    return project;
  }

  public String getKnowledgeBase() {
    return knowledgeBase;
  }

  public String getDocument() {
    return document;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectKnowledgeBaseDocumentBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationKnowledgeBaseDocumentBuilder
      newProjectLocationKnowledgeBaseDocumentBuilder() {
    return new ProjectLocationKnowledgeBaseDocumentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DocumentName of(String project, String knowledgeBase, String document) {
    return newBuilder()
        .setProject(project)
        .setKnowledgeBase(knowledgeBase)
        .setDocument(document)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DocumentName ofProjectKnowledgeBaseDocumentName(
      String project, String knowledgeBase, String document) {
    return newBuilder()
        .setProject(project)
        .setKnowledgeBase(knowledgeBase)
        .setDocument(document)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DocumentName ofProjectLocationKnowledgeBaseDocumentName(
      String project, String location, String knowledgeBase, String document) {
    return newProjectLocationKnowledgeBaseDocumentBuilder()
        .setProject(project)
        .setLocation(location)
        .setKnowledgeBase(knowledgeBase)
        .setDocument(document)
        .build();
  }

  public static String format(String project, String knowledgeBase, String document) {
    return newBuilder()
        .setProject(project)
        .setKnowledgeBase(knowledgeBase)
        .setDocument(document)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectKnowledgeBaseDocumentName(
      String project, String knowledgeBase, String document) {
    return newBuilder()
        .setProject(project)
        .setKnowledgeBase(knowledgeBase)
        .setDocument(document)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationKnowledgeBaseDocumentName(
      String project, String location, String knowledgeBase, String document) {
    return newProjectLocationKnowledgeBaseDocumentBuilder()
        .setProject(project)
        .setLocation(location)
        .setKnowledgeBase(knowledgeBase)
        .setDocument(document)
        .build()
        .toString();
  }

  public static DocumentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_KNOWLEDGE_BASE_DOCUMENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_KNOWLEDGE_BASE_DOCUMENT.match(formattedString);
      return ofProjectKnowledgeBaseDocumentName(
          matchMap.get("project"), matchMap.get("knowledge_base"), matchMap.get("document"));
    } else if (PROJECT_LOCATION_KNOWLEDGE_BASE_DOCUMENT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_KNOWLEDGE_BASE_DOCUMENT.match(formattedString);
      return ofProjectLocationKnowledgeBaseDocumentName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("knowledge_base"),
          matchMap.get("document"));
    }
    throw new ValidationException("DocumentName.parse: formattedString not in valid format");
  }

  public static List<DocumentName> parseList(List<String> formattedStrings) {
    List<DocumentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DocumentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DocumentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_KNOWLEDGE_BASE_DOCUMENT.matches(formattedString)
        || PROJECT_LOCATION_KNOWLEDGE_BASE_DOCUMENT.matches(formattedString);
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
          if (document != null) {
            fieldMapBuilder.put("document", document);
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
      DocumentName that = ((DocumentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.knowledgeBase, that.knowledgeBase)
          && Objects.equals(this.document, that.document)
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
    h ^= Objects.hashCode(document);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/knowledgeBases/{knowledge_base}/documents/{document}. */
  public static class Builder {
    private String project;
    private String knowledgeBase;
    private String document;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getKnowledgeBase() {
      return knowledgeBase;
    }

    public String getDocument() {
      return document;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setKnowledgeBase(String knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
      return this;
    }

    public Builder setDocument(String document) {
      this.document = document;
      return this;
    }

    private Builder(DocumentName documentName) {
      Preconditions.checkArgument(
          Objects.equals(documentName.pathTemplate, PROJECT_KNOWLEDGE_BASE_DOCUMENT),
          "toBuilder is only supported when DocumentName has the pattern of projects/{project}/knowledgeBases/{knowledge_base}/documents/{document}");
      this.project = documentName.project;
      this.knowledgeBase = documentName.knowledgeBase;
      this.document = documentName.document;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/knowledgeBases/{knowledge_base}/documents/{document}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationKnowledgeBaseDocumentBuilder {
    private String project;
    private String location;
    private String knowledgeBase;
    private String document;

    protected ProjectLocationKnowledgeBaseDocumentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKnowledgeBase() {
      return knowledgeBase;
    }

    public String getDocument() {
      return document;
    }

    public ProjectLocationKnowledgeBaseDocumentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationKnowledgeBaseDocumentBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationKnowledgeBaseDocumentBuilder setKnowledgeBase(String knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
      return this;
    }

    public ProjectLocationKnowledgeBaseDocumentBuilder setDocument(String document) {
      this.document = document;
      return this;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }
}
