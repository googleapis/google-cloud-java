/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.retail.v2;

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
public class BranchName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CATALOG_BRANCH =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/branches/{branch}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String catalog;
  private final String branch;

  @Deprecated
  protected BranchName() {
    project = null;
    location = null;
    catalog = null;
    branch = null;
  }

  private BranchName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    branch = Preconditions.checkNotNull(builder.getBranch());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getBranch() {
    return branch;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BranchName of(String project, String location, String catalog, String branch) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setBranch(branch)
        .build();
  }

  public static String format(String project, String location, String catalog, String branch) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setBranch(branch)
        .build()
        .toString();
  }

  public static BranchName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CATALOG_BRANCH.validatedMatch(
            formattedString, "BranchName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("catalog"),
        matchMap.get("branch"));
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
    return PROJECT_LOCATION_CATALOG_BRANCH.matches(formattedString);
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
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
          }
          if (branch != null) {
            fieldMapBuilder.put("branch", branch);
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
    return PROJECT_LOCATION_CATALOG_BRANCH.instantiate(
        "project", project, "location", location, "catalog", catalog, "branch", branch);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      BranchName that = ((BranchName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.catalog, that.catalog)
          && Objects.equals(this.branch, that.branch);
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
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(branch);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/catalogs/{catalog}/branches/{branch}. */
  public static class Builder {
    private String project;
    private String location;
    private String catalog;
    private String branch;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCatalog() {
      return catalog;
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

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setBranch(String branch) {
      this.branch = branch;
      return this;
    }

    private Builder(BranchName branchName) {
      this.project = branchName.project;
      this.location = branchName.location;
      this.catalog = branchName.catalog;
      this.branch = branchName.branch;
    }

    public BranchName build() {
      return new BranchName(this);
    }
  }
}
