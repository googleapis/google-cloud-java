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

package com.google.cloud.biglake.v1;

import com.google.api.pathtemplate.PathTemplate;
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
public class CatalogName implements ResourceName {
  private static final PathTemplate PROJECT_CATALOG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/catalogs/{catalog}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String catalog;

  @Deprecated
  protected CatalogName() {
    project = null;
    catalog = null;
  }

  private CatalogName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
  }

  public String getProject() {
    return project;
  }

  public String getCatalog() {
    return catalog;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CatalogName of(String project, String catalog) {
    return newBuilder().setProject(project).setCatalog(catalog).build();
  }

  public static String format(String project, String catalog) {
    return newBuilder().setProject(project).setCatalog(catalog).build().toString();
  }

  public static CatalogName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_CATALOG.validatedMatch(
            formattedString, "CatalogName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("catalog"));
  }

  public static List<CatalogName> parseList(List<String> formattedStrings) {
    List<CatalogName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CatalogName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CatalogName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CATALOG.matches(formattedString);
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
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
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
    return PROJECT_CATALOG.instantiate("project", project, "catalog", catalog);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CatalogName that = ((CatalogName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.catalog, that.catalog);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(catalog);
    return h;
  }

  /** Builder for projects/{project}/catalogs/{catalog}. */
  public static class Builder {
    private String project;
    private String catalog;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getCatalog() {
      return catalog;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    private Builder(CatalogName catalogName) {
      this.project = catalogName.project;
      this.catalog = catalogName.catalog;
    }

    public CatalogName build() {
      return new CatalogName(this);
    }
  }
}
