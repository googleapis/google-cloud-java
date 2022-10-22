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

package com.google.cloud.contentwarehouse.v1;

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
  private static final PathTemplate PROJECT_LOCATION_DOCUMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/documents/{document}");
  private static final PathTemplate PROJECT_LOCATION_REFERENCE_ID =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/documents/referenceId/{reference_id}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String document;
  private final String referenceId;

  @Deprecated
  protected DocumentName() {
    project = null;
    location = null;
    document = null;
    referenceId = null;
  }

  private DocumentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    document = Preconditions.checkNotNull(builder.getDocument());
    referenceId = null;
    pathTemplate = PROJECT_LOCATION_DOCUMENT;
  }

  private DocumentName(ProjectLocationReferenceIdBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    referenceId = Preconditions.checkNotNull(builder.getReferenceId());
    document = null;
    pathTemplate = PROJECT_LOCATION_REFERENCE_ID;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDocument() {
    return document;
  }

  public String getReferenceId() {
    return referenceId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationDocumentBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationReferenceIdBuilder newProjectLocationReferenceIdBuilder() {
    return new ProjectLocationReferenceIdBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DocumentName of(String project, String location, String document) {
    return newBuilder().setProject(project).setLocation(location).setDocument(document).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DocumentName ofProjectLocationDocumentName(
      String project, String location, String document) {
    return newBuilder().setProject(project).setLocation(location).setDocument(document).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DocumentName ofProjectLocationReferenceIdName(
      String project, String location, String referenceId) {
    return newProjectLocationReferenceIdBuilder()
        .setProject(project)
        .setLocation(location)
        .setReferenceId(referenceId)
        .build();
  }

  public static String format(String project, String location, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDocument(document)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDocumentName(
      String project, String location, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDocument(document)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationReferenceIdName(
      String project, String location, String referenceId) {
    return newProjectLocationReferenceIdBuilder()
        .setProject(project)
        .setLocation(location)
        .setReferenceId(referenceId)
        .build()
        .toString();
  }

  public static DocumentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DOCUMENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DOCUMENT.match(formattedString);
      return ofProjectLocationDocumentName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("document"));
    } else if (PROJECT_LOCATION_REFERENCE_ID.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_REFERENCE_ID.match(formattedString);
      return ofProjectLocationReferenceIdName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("reference_id"));
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
    return PROJECT_LOCATION_DOCUMENT.matches(formattedString)
        || PROJECT_LOCATION_REFERENCE_ID.matches(formattedString);
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
          if (document != null) {
            fieldMapBuilder.put("document", document);
          }
          if (referenceId != null) {
            fieldMapBuilder.put("reference_id", referenceId);
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
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.document, that.document)
          && Objects.equals(this.referenceId, that.referenceId);
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(document);
    h *= 1000003;
    h ^= Objects.hashCode(referenceId);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/documents/{document}. */
  public static class Builder {
    private String project;
    private String location;
    private String document;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDocument() {
      return document;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDocument(String document) {
      this.document = document;
      return this;
    }

    private Builder(DocumentName documentName) {
      Preconditions.checkArgument(
          Objects.equals(documentName.pathTemplate, PROJECT_LOCATION_DOCUMENT),
          "toBuilder is only supported when DocumentName has the pattern of projects/{project}/locations/{location}/documents/{document}");
      this.project = documentName.project;
      this.location = documentName.location;
      this.document = documentName.document;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/documents/referenceId/{reference_id}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationReferenceIdBuilder {
    private String project;
    private String location;
    private String referenceId;

    protected ProjectLocationReferenceIdBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReferenceId() {
      return referenceId;
    }

    public ProjectLocationReferenceIdBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationReferenceIdBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationReferenceIdBuilder setReferenceId(String referenceId) {
      this.referenceId = referenceId;
      return this;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }
}
