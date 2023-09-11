/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1;

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
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String branch;
  private final String document;
  private final String collection;

  @Deprecated
  protected DocumentName() {
    project = null;
    location = null;
    dataStore = null;
    branch = null;
    document = null;
    collection = null;
  }

  private DocumentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    branch = Preconditions.checkNotNull(builder.getBranch());
    document = Preconditions.checkNotNull(builder.getDocument());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT;
  }

  private DocumentName(ProjectLocationCollectionDataStoreBranchDocumentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    branch = Preconditions.checkNotNull(builder.getBranch());
    document = Preconditions.checkNotNull(builder.getDocument());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataStore() {
    return dataStore;
  }

  public String getBranch() {
    return branch;
  }

  public String getDocument() {
    return document;
  }

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationDataStoreBranchDocumentBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationCollectionDataStoreBranchDocumentBuilder
      newProjectLocationCollectionDataStoreBranchDocumentBuilder() {
    return new ProjectLocationCollectionDataStoreBranchDocumentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DocumentName of(
      String project, String location, String dataStore, String branch, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DocumentName ofProjectLocationDataStoreBranchDocumentName(
      String project, String location, String dataStore, String branch, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DocumentName ofProjectLocationCollectionDataStoreBranchDocumentName(
      String project,
      String location,
      String collection,
      String dataStore,
      String branch,
      String document) {
    return newProjectLocationCollectionDataStoreBranchDocumentBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .build();
  }

  public static String format(
      String project, String location, String dataStore, String branch, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDataStoreBranchDocumentName(
      String project, String location, String dataStore, String branch, String document) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationCollectionDataStoreBranchDocumentName(
      String project,
      String location,
      String collection,
      String dataStore,
      String branch,
      String document) {
    return newProjectLocationCollectionDataStoreBranchDocumentBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .build()
        .toString();
  }

  public static DocumentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT.match(formattedString);
      return ofProjectLocationDataStoreBranchDocumentName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("branch"),
          matchMap.get("document"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT.match(formattedString);
      return ofProjectLocationCollectionDataStoreBranchDocumentName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("branch"),
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
    return PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT.matches(formattedString);
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
          if (dataStore != null) {
            fieldMapBuilder.put("data_store", dataStore);
          }
          if (branch != null) {
            fieldMapBuilder.put("branch", branch);
          }
          if (document != null) {
            fieldMapBuilder.put("document", document);
          }
          if (collection != null) {
            fieldMapBuilder.put("collection", collection);
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
    if (o != null && getClass() == o.getClass()) {
      DocumentName that = ((DocumentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.branch, that.branch)
          && Objects.equals(this.document, that.document)
          && Objects.equals(this.collection, that.collection);
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
    h ^= Objects.hashCode(dataStore);
    h *= 1000003;
    h ^= Objects.hashCode(branch);
    h *= 1000003;
    h ^= Objects.hashCode(document);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String branch;
    private String document;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataStore() {
      return dataStore;
    }

    public String getBranch() {
      return branch;
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

    public Builder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public Builder setBranch(String branch) {
      this.branch = branch;
      return this;
    }

    public Builder setDocument(String document) {
      this.document = document;
      return this;
    }

    private Builder(DocumentName documentName) {
      Preconditions.checkArgument(
          Objects.equals(documentName.pathTemplate, PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT),
          "toBuilder is only supported when DocumentName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}");
      this.project = documentName.project;
      this.location = documentName.location;
      this.dataStore = documentName.dataStore;
      this.branch = documentName.branch;
      this.document = documentName.document;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationCollectionDataStoreBranchDocumentBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String branch;
    private String document;

    protected ProjectLocationCollectionDataStoreBranchDocumentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCollection() {
      return collection;
    }

    public String getDataStore() {
      return dataStore;
    }

    public String getBranch() {
      return branch;
    }

    public String getDocument() {
      return document;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentBuilder setCollection(
        String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentBuilder setBranch(String branch) {
      this.branch = branch;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentBuilder setDocument(String document) {
      this.document = document;
      return this;
    }

    public DocumentName build() {
      return new DocumentName(this);
    }
  }
}
