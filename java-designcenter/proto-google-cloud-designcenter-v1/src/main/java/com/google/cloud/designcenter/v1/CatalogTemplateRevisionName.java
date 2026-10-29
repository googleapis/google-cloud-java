/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.designcenter.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class CatalogTemplateRevisionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SPACE_CATALOG_CATALOG_TEMPLATE_REVISION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/spaces/{space}/catalogs/{catalog}/templates/{catalog_template}/revisions/{revision}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String space;
  private final String catalog;
  private final String catalogTemplate;
  private final String revision;

  @Deprecated
  protected CatalogTemplateRevisionName() {
    project = null;
    location = null;
    space = null;
    catalog = null;
    catalogTemplate = null;
    revision = null;
  }

  private CatalogTemplateRevisionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    space = Preconditions.checkNotNull(builder.getSpace());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    catalogTemplate = Preconditions.checkNotNull(builder.getCatalogTemplate());
    revision = Preconditions.checkNotNull(builder.getRevision());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSpace() {
    return space;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getCatalogTemplate() {
    return catalogTemplate;
  }

  public String getRevision() {
    return revision;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CatalogTemplateRevisionName of(
      String project,
      String location,
      String space,
      String catalog,
      String catalogTemplate,
      String revision) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpace(space)
        .setCatalog(catalog)
        .setCatalogTemplate(catalogTemplate)
        .setRevision(revision)
        .build();
  }

  public static String format(
      String project,
      String location,
      String space,
      String catalog,
      String catalogTemplate,
      String revision) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpace(space)
        .setCatalog(catalog)
        .setCatalogTemplate(catalogTemplate)
        .setRevision(revision)
        .build()
        .toString();
  }

  public static @Nullable CatalogTemplateRevisionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SPACE_CATALOG_CATALOG_TEMPLATE_REVISION.validatedMatch(
            formattedString,
            "CatalogTemplateRevisionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("space"),
        matchMap.get("catalog"),
        matchMap.get("catalog_template"),
        matchMap.get("revision"));
  }

  public static List<CatalogTemplateRevisionName> parseList(List<String> formattedStrings) {
    List<CatalogTemplateRevisionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable CatalogTemplateRevisionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CatalogTemplateRevisionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SPACE_CATALOG_CATALOG_TEMPLATE_REVISION.matches(formattedString);
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
          if (space != null) {
            fieldMapBuilder.put("space", space);
          }
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
          }
          if (catalogTemplate != null) {
            fieldMapBuilder.put("catalog_template", catalogTemplate);
          }
          if (revision != null) {
            fieldMapBuilder.put("revision", revision);
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
    return PROJECT_LOCATION_SPACE_CATALOG_CATALOG_TEMPLATE_REVISION.instantiate(
        "project",
        project,
        "location",
        location,
        "space",
        space,
        "catalog",
        catalog,
        "catalog_template",
        catalogTemplate,
        "revision",
        revision);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CatalogTemplateRevisionName that = ((CatalogTemplateRevisionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.space, that.space)
          && Objects.equals(this.catalog, that.catalog)
          && Objects.equals(this.catalogTemplate, that.catalogTemplate)
          && Objects.equals(this.revision, that.revision);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(catalogTemplate);
    h *= 1000003;
    h ^= Objects.hashCode(revision);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/spaces/{space}/catalogs/{catalog}/templates/{catalog_template}/revisions/{revision}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String space;
    private String catalog;
    private String catalogTemplate;
    private String revision;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSpace() {
      return space;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getCatalogTemplate() {
      return catalogTemplate;
    }

    public String getRevision() {
      return revision;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setCatalogTemplate(String catalogTemplate) {
      this.catalogTemplate = catalogTemplate;
      return this;
    }

    public Builder setRevision(String revision) {
      this.revision = revision;
      return this;
    }

    private Builder(CatalogTemplateRevisionName catalogTemplateRevisionName) {
      this.project = catalogTemplateRevisionName.project;
      this.location = catalogTemplateRevisionName.location;
      this.space = catalogTemplateRevisionName.space;
      this.catalog = catalogTemplateRevisionName.catalog;
      this.catalogTemplate = catalogTemplateRevisionName.catalogTemplate;
      this.revision = catalogTemplateRevisionName.revision;
    }

    public CatalogTemplateRevisionName build() {
      return new CatalogTemplateRevisionName(this);
    }
  }
}
