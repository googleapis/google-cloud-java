/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

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
public class SitemapName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_SITEMAP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/siteSearchEngine/sitemaps/{sitemap}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_SITEMAP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/sitemaps/{sitemap}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String sitemap;
  private final String collection;

  @Deprecated
  protected SitemapName() {
    project = null;
    location = null;
    dataStore = null;
    sitemap = null;
    collection = null;
  }

  private SitemapName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    sitemap = Preconditions.checkNotNull(builder.getSitemap());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_SITEMAP;
  }

  private SitemapName(ProjectLocationCollectionDataStoreSitemapBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    sitemap = Preconditions.checkNotNull(builder.getSitemap());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_SITEMAP;
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

  public String getSitemap() {
    return sitemap;
  }

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationDataStoreSitemapBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreSitemapBuilder
      newProjectLocationCollectionDataStoreSitemapBuilder() {
    return new ProjectLocationCollectionDataStoreSitemapBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SitemapName of(String project, String location, String dataStore, String sitemap) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSitemap(sitemap)
        .build();
  }

  public static SitemapName ofProjectLocationDataStoreSitemapName(
      String project, String location, String dataStore, String sitemap) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSitemap(sitemap)
        .build();
  }

  public static SitemapName ofProjectLocationCollectionDataStoreSitemapName(
      String project, String location, String collection, String dataStore, String sitemap) {
    return newProjectLocationCollectionDataStoreSitemapBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSitemap(sitemap)
        .build();
  }

  public static String format(String project, String location, String dataStore, String sitemap) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSitemap(sitemap)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreSitemapName(
      String project, String location, String dataStore, String sitemap) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSitemap(sitemap)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreSitemapName(
      String project, String location, String collection, String dataStore, String sitemap) {
    return newProjectLocationCollectionDataStoreSitemapBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSitemap(sitemap)
        .build()
        .toString();
  }

  public static SitemapName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_SITEMAP.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE_SITEMAP.match(formattedString);
      return ofProjectLocationDataStoreSitemapName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("sitemap"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_SITEMAP.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_SITEMAP.match(formattedString);
      return ofProjectLocationCollectionDataStoreSitemapName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("sitemap"));
    }
    throw new ValidationException("SitemapName.parse: formattedString not in valid format");
  }

  public static List<SitemapName> parseList(List<String> formattedStrings) {
    List<SitemapName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SitemapName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SitemapName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_SITEMAP.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_SITEMAP.matches(formattedString);
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
          if (sitemap != null) {
            fieldMapBuilder.put("sitemap", sitemap);
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
      SitemapName that = ((SitemapName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.sitemap, that.sitemap)
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
    h ^= Objects.hashCode(sitemap);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/siteSearchEngine/sitemaps/{sitemap}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String sitemap;

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

    public String getSitemap() {
      return sitemap;
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

    public Builder setSitemap(String sitemap) {
      this.sitemap = sitemap;
      return this;
    }

    private Builder(SitemapName sitemapName) {
      Preconditions.checkArgument(
          Objects.equals(sitemapName.pathTemplate, PROJECT_LOCATION_DATA_STORE_SITEMAP),
          "toBuilder is only supported when SitemapName has the pattern of"
              + " projects/{project}/locations/{location}/dataStores/{data_store}/siteSearchEngine/sitemaps/{sitemap}");
      this.project = sitemapName.project;
      this.location = sitemapName.location;
      this.dataStore = sitemapName.dataStore;
      this.sitemap = sitemapName.sitemap;
    }

    public SitemapName build() {
      return new SitemapName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/siteSearchEngine/sitemaps/{sitemap}.
   */
  public static class ProjectLocationCollectionDataStoreSitemapBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String sitemap;

    protected ProjectLocationCollectionDataStoreSitemapBuilder() {}

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

    public String getSitemap() {
      return sitemap;
    }

    public ProjectLocationCollectionDataStoreSitemapBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreSitemapBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreSitemapBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreSitemapBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreSitemapBuilder setSitemap(String sitemap) {
      this.sitemap = sitemap;
      return this;
    }

    public SitemapName build() {
      return new SitemapName(this);
    }
  }
}
