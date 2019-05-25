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

package com.google.firestore.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class DocumentPathName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/documents/{document_path=**}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String database;
  private final String documentPath;

  public String getProject() {
    return project;
  }

  public String getDatabase() {
    return database;
  }

  public String getDocumentPath() {
    return documentPath;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private DocumentPathName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    database = Preconditions.checkNotNull(builder.getDatabase());
    documentPath = Preconditions.checkNotNull(builder.getDocumentPath());
  }

  public static DocumentPathName of(String project, String database, String documentPath) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setDocumentPath(documentPath)
        .build();
  }

  public static String format(String project, String database, String documentPath) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setDocumentPath(documentPath)
        .build()
        .toString();
  }

  public static DocumentPathName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "DocumentPathName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("database"), matchMap.get("document_path"));
  }

  public static List<DocumentPathName> parseList(List<String> formattedStrings) {
    List<DocumentPathName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DocumentPathName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (DocumentPathName value : values) {
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
          fieldMapBuilder.put("database", database);
          fieldMapBuilder.put("documentPath", documentPath);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "database", database, "document_path", documentPath);
  }

  /** Builder for DocumentPathName. */
  public static class Builder {

    private String project;
    private String database;
    private String documentPath;

    public String getProject() {
      return project;
    }

    public String getDatabase() {
      return database;
    }

    public String getDocumentPath() {
      return documentPath;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setDocumentPath(String documentPath) {
      this.documentPath = documentPath;
      return this;
    }

    private Builder() {}

    private Builder(DocumentPathName documentPathName) {
      project = documentPathName.project;
      database = documentPathName.database;
      documentPath = documentPathName.documentPath;
    }

    public DocumentPathName build() {
      return new DocumentPathName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DocumentPathName) {
      DocumentPathName that = (DocumentPathName) o;
      return (this.project.equals(that.project))
          && (this.database.equals(that.database))
          && (this.documentPath.equals(that.documentPath));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= database.hashCode();
    h *= 1000003;
    h ^= documentPath.hashCode();
    return h;
  }
}
