/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.recommendationengine.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class CatalogItemPathName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/catalogItems/{catalog_item_path=**}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String catalog;
  private final String catalogItemPath;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getCatalogItemPath() {
    return catalogItemPath;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private CatalogItemPathName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    catalogItemPath = Preconditions.checkNotNull(builder.getCatalogItemPath());
  }

  public static CatalogItemPathName of(
      String project, String location, String catalog, String catalogItemPath) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setCatalogItemPath(catalogItemPath)
        .build();
  }

  public static String format(
      String project, String location, String catalog, String catalogItemPath) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setCatalogItemPath(catalogItemPath)
        .build()
        .toString();
  }

  public static CatalogItemPathName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "CatalogItemPathName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("catalog"),
        matchMap.get("catalog_item_path"));
  }

  public static List<CatalogItemPathName> parseList(List<String> formattedStrings) {
    List<CatalogItemPathName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CatalogItemPathName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (CatalogItemPathName value : values) {
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
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("catalog", catalog);
          fieldMapBuilder.put("catalogItemPath", catalogItemPath);
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
        "project",
        project,
        "location",
        location,
        "catalog",
        catalog,
        "catalog_item_path",
        catalogItemPath);
  }

  /** Builder for CatalogItemPathName. */
  public static class Builder {

    private String project;
    private String location;
    private String catalog;
    private String catalogItemPath;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getCatalogItemPath() {
      return catalogItemPath;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setCatalogItemPath(String catalogItemPath) {
      this.catalogItemPath = catalogItemPath;
      return this;
    }

    private Builder() {}

    private Builder(CatalogItemPathName catalogItemPathName) {
      project = catalogItemPathName.project;
      location = catalogItemPathName.location;
      catalog = catalogItemPathName.catalog;
      catalogItemPath = catalogItemPathName.catalogItemPath;
    }

    public CatalogItemPathName build() {
      return new CatalogItemPathName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CatalogItemPathName) {
      CatalogItemPathName that = (CatalogItemPathName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.catalog.equals(that.catalog))
          && (this.catalogItemPath.equals(that.catalogItemPath));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= catalog.hashCode();
    h *= 1000003;
    h ^= catalogItemPath.hashCode();
    return h;
  }
}
