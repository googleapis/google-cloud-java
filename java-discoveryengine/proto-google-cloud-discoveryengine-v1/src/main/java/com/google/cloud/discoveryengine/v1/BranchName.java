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
public class BranchName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_BRANCH =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String branch;
  private final String collection;

  @Deprecated
  protected BranchName() {
    project = null;
    location = null;
    dataStore = null;
    branch = null;
    collection = null;
  }

  private BranchName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    branch = Preconditions.checkNotNull(builder.getBranch());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_BRANCH;
  }

  private BranchName(ProjectLocationCollectionDataStoreBranchBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    branch = Preconditions.checkNotNull(builder.getBranch());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH;
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

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationDataStoreBranchBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationCollectionDataStoreBranchBuilder
      newProjectLocationCollectionDataStoreBranchBuilder() {
    return new ProjectLocationCollectionDataStoreBranchBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BranchName of(String project, String location, String dataStore, String branch) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BranchName ofProjectLocationDataStoreBranchName(
      String project, String location, String dataStore, String branch) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BranchName ofProjectLocationCollectionDataStoreBranchName(
      String project, String location, String collection, String dataStore, String branch) {
    return newProjectLocationCollectionDataStoreBranchBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setBranch(branch)
        .build();
  }

  public static String format(String project, String location, String dataStore, String branch) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDataStoreBranchName(
      String project, String location, String dataStore, String branch) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setBranch(branch)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationCollectionDataStoreBranchName(
      String project, String location, String collection, String dataStore, String branch) {
    return newProjectLocationCollectionDataStoreBranchBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setBranch(branch)
        .build()
        .toString();
  }

  public static BranchName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_BRANCH.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE_BRANCH.match(formattedString);
      return ofProjectLocationDataStoreBranchName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("branch"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH.match(formattedString);
      return ofProjectLocationCollectionDataStoreBranchName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("branch"));
    }
    throw new ValidationException("BranchName.parse: formattedString not in valid format");
  }

  public static List<BranchName> parseList(List<String> formattedStrings) {
    List<BranchName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BranchName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BranchName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_BRANCH.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_BRANCH.matches(formattedString);
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
      BranchName that = ((BranchName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.branch, that.branch)
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
    h ^= Objects.hashCode(collection);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String branch;

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

    private Builder(BranchName branchName) {
      Preconditions.checkArgument(
          Objects.equals(branchName.pathTemplate, PROJECT_LOCATION_DATA_STORE_BRANCH),
          "toBuilder is only supported when BranchName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/branches/{branch}");
      this.project = branchName.project;
      this.location = branchName.location;
      this.dataStore = branchName.dataStore;
      this.branch = branchName.branch;
    }

    public BranchName build() {
      return new BranchName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationCollectionDataStoreBranchBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String branch;

    protected ProjectLocationCollectionDataStoreBranchBuilder() {}

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

    public ProjectLocationCollectionDataStoreBranchBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreBranchBuilder setBranch(String branch) {
      this.branch = branch;
      return this;
    }

    public BranchName build() {
      return new BranchName(this);
    }
  }
}
