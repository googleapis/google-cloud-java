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
public class TargetSiteName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_TARGET_SITE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_TARGET_SITE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String targetSite;
  private final String collection;

  @Deprecated
  protected TargetSiteName() {
    project = null;
    location = null;
    dataStore = null;
    targetSite = null;
    collection = null;
  }

  private TargetSiteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    targetSite = Preconditions.checkNotNull(builder.getTargetSite());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_TARGET_SITE;
  }

  private TargetSiteName(ProjectLocationCollectionDataStoreTargetSiteBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    targetSite = Preconditions.checkNotNull(builder.getTargetSite());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_TARGET_SITE;
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

  public String getTargetSite() {
    return targetSite;
  }

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationDataStoreTargetSiteBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationCollectionDataStoreTargetSiteBuilder
      newProjectLocationCollectionDataStoreTargetSiteBuilder() {
    return new ProjectLocationCollectionDataStoreTargetSiteBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TargetSiteName of(
      String project, String location, String dataStore, String targetSite) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setTargetSite(targetSite)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TargetSiteName ofProjectLocationDataStoreTargetSiteName(
      String project, String location, String dataStore, String targetSite) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setTargetSite(targetSite)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TargetSiteName ofProjectLocationCollectionDataStoreTargetSiteName(
      String project, String location, String collection, String dataStore, String targetSite) {
    return newProjectLocationCollectionDataStoreTargetSiteBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setTargetSite(targetSite)
        .build();
  }

  public static String format(
      String project, String location, String dataStore, String targetSite) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setTargetSite(targetSite)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDataStoreTargetSiteName(
      String project, String location, String dataStore, String targetSite) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setTargetSite(targetSite)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationCollectionDataStoreTargetSiteName(
      String project, String location, String collection, String dataStore, String targetSite) {
    return newProjectLocationCollectionDataStoreTargetSiteBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setTargetSite(targetSite)
        .build()
        .toString();
  }

  public static TargetSiteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_TARGET_SITE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE_TARGET_SITE.match(formattedString);
      return ofProjectLocationDataStoreTargetSiteName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("target_site"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_TARGET_SITE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_TARGET_SITE.match(formattedString);
      return ofProjectLocationCollectionDataStoreTargetSiteName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("target_site"));
    }
    throw new ValidationException("TargetSiteName.parse: formattedString not in valid format");
  }

  public static List<TargetSiteName> parseList(List<String> formattedStrings) {
    List<TargetSiteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TargetSiteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TargetSiteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_TARGET_SITE.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_TARGET_SITE.matches(formattedString);
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
          if (targetSite != null) {
            fieldMapBuilder.put("target_site", targetSite);
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
      TargetSiteName that = ((TargetSiteName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.targetSite, that.targetSite)
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
    h ^= Objects.hashCode(targetSite);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String targetSite;

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

    public String getTargetSite() {
      return targetSite;
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

    public Builder setTargetSite(String targetSite) {
      this.targetSite = targetSite;
      return this;
    }

    private Builder(TargetSiteName targetSiteName) {
      Preconditions.checkArgument(
          Objects.equals(targetSiteName.pathTemplate, PROJECT_LOCATION_DATA_STORE_TARGET_SITE),
          "toBuilder is only supported when TargetSiteName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}");
      this.project = targetSiteName.project;
      this.location = targetSiteName.location;
      this.dataStore = targetSiteName.dataStore;
      this.targetSite = targetSiteName.targetSite;
    }

    public TargetSiteName build() {
      return new TargetSiteName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/targetSites/{target_site}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationCollectionDataStoreTargetSiteBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String targetSite;

    protected ProjectLocationCollectionDataStoreTargetSiteBuilder() {}

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

    public String getTargetSite() {
      return targetSite;
    }

    public ProjectLocationCollectionDataStoreTargetSiteBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreTargetSiteBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreTargetSiteBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreTargetSiteBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreTargetSiteBuilder setTargetSite(String targetSite) {
      this.targetSite = targetSite;
      return this;
    }

    public TargetSiteName build() {
      return new TargetSiteName(this);
    }
  }
}
