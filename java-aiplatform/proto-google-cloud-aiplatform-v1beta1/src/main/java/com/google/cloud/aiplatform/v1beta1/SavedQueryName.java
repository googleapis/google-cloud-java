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

package com.google.cloud.aiplatform.v1beta1;

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
public class SavedQueryName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASET_SAVED_QUERY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasets/{dataset}/savedQueries/{saved_query}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataset;
  private final String savedQuery;

  @Deprecated
  protected SavedQueryName() {
    project = null;
    location = null;
    dataset = null;
    savedQuery = null;
  }

  private SavedQueryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    savedQuery = Preconditions.checkNotNull(builder.getSavedQuery());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataset() {
    return dataset;
  }

  public String getSavedQuery() {
    return savedQuery;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SavedQueryName of(
      String project, String location, String dataset, String savedQuery) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setSavedQuery(savedQuery)
        .build();
  }

  public static String format(String project, String location, String dataset, String savedQuery) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setSavedQuery(savedQuery)
        .build()
        .toString();
  }

  public static SavedQueryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASET_SAVED_QUERY.validatedMatch(
            formattedString, "SavedQueryName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataset"),
        matchMap.get("saved_query"));
  }

  public static List<SavedQueryName> parseList(List<String> formattedStrings) {
    List<SavedQueryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SavedQueryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SavedQueryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASET_SAVED_QUERY.matches(formattedString);
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
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
          }
          if (savedQuery != null) {
            fieldMapBuilder.put("saved_query", savedQuery);
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
    return PROJECT_LOCATION_DATASET_SAVED_QUERY.instantiate(
        "project", project, "location", location, "dataset", dataset, "saved_query", savedQuery);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SavedQueryName that = ((SavedQueryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataset, that.dataset)
          && Objects.equals(this.savedQuery, that.savedQuery);
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
    h ^= Objects.hashCode(dataset);
    h *= 1000003;
    h ^= Objects.hashCode(savedQuery);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/datasets/{dataset}/savedQueries/{saved_query}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataset;
    private String savedQuery;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataset() {
      return dataset;
    }

    public String getSavedQuery() {
      return savedQuery;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setSavedQuery(String savedQuery) {
      this.savedQuery = savedQuery;
      return this;
    }

    private Builder(SavedQueryName savedQueryName) {
      this.project = savedQueryName.project;
      this.location = savedQueryName.location;
      this.dataset = savedQueryName.dataset;
      this.savedQuery = savedQueryName.savedQuery;
    }

    public SavedQueryName build() {
      return new SavedQueryName(this);
    }
  }
}
