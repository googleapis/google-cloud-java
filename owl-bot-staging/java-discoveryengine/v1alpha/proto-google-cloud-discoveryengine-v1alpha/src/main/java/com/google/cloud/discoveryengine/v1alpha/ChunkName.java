/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

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
public class ChunkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT_CHUNK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT_CHUNK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String branch;
  private final String document;
  private final String chunk;
  private final String collection;

  @Deprecated
  protected ChunkName() {
    project = null;
    location = null;
    dataStore = null;
    branch = null;
    document = null;
    chunk = null;
    collection = null;
  }

  private ChunkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    branch = Preconditions.checkNotNull(builder.getBranch());
    document = Preconditions.checkNotNull(builder.getDocument());
    chunk = Preconditions.checkNotNull(builder.getChunk());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT_CHUNK;
  }

  private ChunkName(ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    branch = Preconditions.checkNotNull(builder.getBranch());
    document = Preconditions.checkNotNull(builder.getDocument());
    chunk = Preconditions.checkNotNull(builder.getChunk());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT_CHUNK;
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

  public String getChunk() {
    return chunk;
  }

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationDataStoreBranchDocumentChunkBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder
      newProjectLocationCollectionDataStoreBranchDocumentChunkBuilder() {
    return new ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ChunkName of(
      String project,
      String location,
      String dataStore,
      String branch,
      String document,
      String chunk) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .setChunk(chunk)
        .build();
  }

  public static ChunkName ofProjectLocationDataStoreBranchDocumentChunkName(
      String project,
      String location,
      String dataStore,
      String branch,
      String document,
      String chunk) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .setChunk(chunk)
        .build();
  }

  public static ChunkName ofProjectLocationCollectionDataStoreBranchDocumentChunkName(
      String project,
      String location,
      String collection,
      String dataStore,
      String branch,
      String document,
      String chunk) {
    return newProjectLocationCollectionDataStoreBranchDocumentChunkBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .setChunk(chunk)
        .build();
  }

  public static String format(
      String project,
      String location,
      String dataStore,
      String branch,
      String document,
      String chunk) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .setChunk(chunk)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreBranchDocumentChunkName(
      String project,
      String location,
      String dataStore,
      String branch,
      String document,
      String chunk) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .setChunk(chunk)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreBranchDocumentChunkName(
      String project,
      String location,
      String collection,
      String dataStore,
      String branch,
      String document,
      String chunk) {
    return newProjectLocationCollectionDataStoreBranchDocumentChunkBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setBranch(branch)
        .setDocument(document)
        .setChunk(chunk)
        .build()
        .toString();
  }

  public static ChunkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT_CHUNK.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT_CHUNK.match(formattedString);
      return ofProjectLocationDataStoreBranchDocumentChunkName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("branch"),
          matchMap.get("document"),
          matchMap.get("chunk"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT_CHUNK.matches(
        formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT_CHUNK.match(formattedString);
      return ofProjectLocationCollectionDataStoreBranchDocumentChunkName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("branch"),
          matchMap.get("document"),
          matchMap.get("chunk"));
    }
    throw new ValidationException("ChunkName.parse: formattedString not in valid format");
  }

  public static List<ChunkName> parseList(List<String> formattedStrings) {
    List<ChunkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ChunkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ChunkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT_CHUNK.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH_DOCUMENT_CHUNK.matches(formattedString);
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
          if (chunk != null) {
            fieldMapBuilder.put("chunk", chunk);
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
      ChunkName that = ((ChunkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.branch, that.branch)
          && Objects.equals(this.document, that.document)
          && Objects.equals(this.chunk, that.chunk)
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
    h ^= Objects.hashCode(chunk);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String branch;
    private String document;
    private String chunk;

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

    public String getChunk() {
      return chunk;
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

    public Builder setChunk(String chunk) {
      this.chunk = chunk;
      return this;
    }

    private Builder(ChunkName chunkName) {
      Preconditions.checkArgument(
          Objects.equals(chunkName.pathTemplate, PROJECT_LOCATION_DATA_STORE_BRANCH_DOCUMENT_CHUNK),
          "toBuilder is only supported when ChunkName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}");
      this.project = chunkName.project;
      this.location = chunkName.location;
      this.dataStore = chunkName.dataStore;
      this.branch = chunkName.branch;
      this.document = chunkName.document;
      this.chunk = chunkName.chunk;
    }

    public ChunkName build() {
      return new ChunkName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}.
   */
  public static class ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String branch;
    private String document;
    private String chunk;

    protected ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder() {}

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

    public String getChunk() {
      return chunk;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setCollection(
        String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setDataStore(
        String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setBranch(String branch) {
      this.branch = branch;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setDocument(
        String document) {
      this.document = document;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchDocumentChunkBuilder setChunk(String chunk) {
      this.chunk = chunk;
      return this;
    }

    public ChunkName build() {
      return new ChunkName(this);
    }
  }
}
