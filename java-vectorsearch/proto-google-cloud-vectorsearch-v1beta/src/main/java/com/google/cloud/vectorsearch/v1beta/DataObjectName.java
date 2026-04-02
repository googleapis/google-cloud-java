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

package com.google.cloud.vectorsearch.v1beta;

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
public class DataObjectName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATAOBJECT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataObjects/{dataObject}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String collection;
  private final String dataObject;

  @Deprecated
  protected DataObjectName() {
    project = null;
    location = null;
    collection = null;
    dataObject = null;
  }

  private DataObjectName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataObject = Preconditions.checkNotNull(builder.getDataObject());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCollection() {
    return collection;
  }

  public String getDataObject() {
    return dataObject;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataObjectName of(
      String project, String location, String collection, String dataObject) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataObject(dataObject)
        .build();
  }

  public static String format(
      String project, String location, String collection, String dataObject) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataObject(dataObject)
        .build()
        .toString();
  }

  public static DataObjectName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_COLLECTION_DATAOBJECT.validatedMatch(
            formattedString, "DataObjectName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("collection"),
        matchMap.get("dataObject"));
  }

  public static List<DataObjectName> parseList(List<String> formattedStrings) {
    List<DataObjectName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataObjectName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataObjectName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_COLLECTION_DATAOBJECT.matches(formattedString);
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
          if (collection != null) {
            fieldMapBuilder.put("collection", collection);
          }
          if (dataObject != null) {
            fieldMapBuilder.put("dataObject", dataObject);
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
    return PROJECT_LOCATION_COLLECTION_DATAOBJECT.instantiate(
        "project",
        project,
        "location",
        location,
        "collection",
        collection,
        "dataObject",
        dataObject);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataObjectName that = ((DataObjectName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.collection, that.collection)
          && Objects.equals(this.dataObject, that.dataObject);
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
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(dataObject);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataObjects/{dataObject}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String collection;
    private String dataObject;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCollection() {
      return collection;
    }

    public String getDataObject() {
      return dataObject;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public Builder setDataObject(String dataObject) {
      this.dataObject = dataObject;
      return this;
    }

    private Builder(DataObjectName dataObjectName) {
      this.project = dataObjectName.project;
      this.location = dataObjectName.location;
      this.collection = dataObjectName.collection;
      this.dataObject = dataObjectName.dataObject;
    }

    public DataObjectName build() {
      return new DataObjectName(this);
    }
  }
}
