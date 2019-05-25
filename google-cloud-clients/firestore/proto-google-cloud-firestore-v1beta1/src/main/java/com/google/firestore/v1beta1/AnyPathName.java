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

package com.google.firestore.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AnyPathName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/documents/{document}/{any_path=**}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String database;
  private final String document;
  private final String anyPath;

  public String getProject() {
    return project;
  }

  public String getDatabase() {
    return database;
  }

  public String getDocument() {
    return document;
  }

  public String getAnyPath() {
    return anyPath;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private AnyPathName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    database = Preconditions.checkNotNull(builder.getDatabase());
    document = Preconditions.checkNotNull(builder.getDocument());
    anyPath = Preconditions.checkNotNull(builder.getAnyPath());
  }

  public static AnyPathName of(String project, String database, String document, String anyPath) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setDocument(document)
        .setAnyPath(anyPath)
        .build();
  }

  public static String format(String project, String database, String document, String anyPath) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setDocument(document)
        .setAnyPath(anyPath)
        .build()
        .toString();
  }

  public static AnyPathName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AnyPathName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("database"),
        matchMap.get("document"),
        matchMap.get("any_path"));
  }

  public static List<AnyPathName> parseList(List<String> formattedStrings) {
    List<AnyPathName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnyPathName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (AnyPathName value : values) {
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
          fieldMapBuilder.put("document", document);
          fieldMapBuilder.put("anyPath", anyPath);
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
        "project", project, "database", database, "document", document, "any_path", anyPath);
  }

  /** Builder for AnyPathName. */
  public static class Builder {

    private String project;
    private String database;
    private String document;
    private String anyPath;

    public String getProject() {
      return project;
    }

    public String getDatabase() {
      return database;
    }

    public String getDocument() {
      return document;
    }

    public String getAnyPath() {
      return anyPath;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setDocument(String document) {
      this.document = document;
      return this;
    }

    public Builder setAnyPath(String anyPath) {
      this.anyPath = anyPath;
      return this;
    }

    private Builder() {}

    private Builder(AnyPathName anyPathName) {
      project = anyPathName.project;
      database = anyPathName.database;
      document = anyPathName.document;
      anyPath = anyPathName.anyPath;
    }

    public AnyPathName build() {
      return new AnyPathName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AnyPathName) {
      AnyPathName that = (AnyPathName) o;
      return (this.project.equals(that.project))
          && (this.database.equals(that.database))
          && (this.document.equals(that.document))
          && (this.anyPath.equals(that.anyPath));
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
    h ^= document.hashCode();
    h *= 1000003;
    h ^= anyPath.hashCode();
    return h;
  }
}
