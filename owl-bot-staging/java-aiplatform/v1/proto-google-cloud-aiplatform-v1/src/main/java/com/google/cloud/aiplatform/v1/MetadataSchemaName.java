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

package com.google.cloud.aiplatform.v1;

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
public class MetadataSchemaName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_METADATA_STORE_METADATA_SCHEMA =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/metadataStores/{metadata_store}/metadataSchemas/{metadata_schema}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String metadataStore;
  private final String metadataSchema;

  @Deprecated
  protected MetadataSchemaName() {
    project = null;
    location = null;
    metadataStore = null;
    metadataSchema = null;
  }

  private MetadataSchemaName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    metadataStore = Preconditions.checkNotNull(builder.getMetadataStore());
    metadataSchema = Preconditions.checkNotNull(builder.getMetadataSchema());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMetadataStore() {
    return metadataStore;
  }

  public String getMetadataSchema() {
    return metadataSchema;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MetadataSchemaName of(
      String project, String location, String metadataStore, String metadataSchema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMetadataStore(metadataStore)
        .setMetadataSchema(metadataSchema)
        .build();
  }

  public static String format(
      String project, String location, String metadataStore, String metadataSchema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMetadataStore(metadataStore)
        .setMetadataSchema(metadataSchema)
        .build()
        .toString();
  }

  public static MetadataSchemaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_METADATA_STORE_METADATA_SCHEMA.validatedMatch(
            formattedString, "MetadataSchemaName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("metadata_store"),
        matchMap.get("metadata_schema"));
  }

  public static List<MetadataSchemaName> parseList(List<String> formattedStrings) {
    List<MetadataSchemaName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetadataSchemaName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MetadataSchemaName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_METADATA_STORE_METADATA_SCHEMA.matches(formattedString);
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
          if (metadataStore != null) {
            fieldMapBuilder.put("metadata_store", metadataStore);
          }
          if (metadataSchema != null) {
            fieldMapBuilder.put("metadata_schema", metadataSchema);
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
    return PROJECT_LOCATION_METADATA_STORE_METADATA_SCHEMA.instantiate(
        "project",
        project,
        "location",
        location,
        "metadata_store",
        metadataStore,
        "metadata_schema",
        metadataSchema);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MetadataSchemaName that = ((MetadataSchemaName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.metadataStore, that.metadataStore)
          && Objects.equals(this.metadataSchema, that.metadataSchema);
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
    h ^= Objects.hashCode(metadataStore);
    h *= 1000003;
    h ^= Objects.hashCode(metadataSchema);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/metadataStores/{metadata_store}/metadataSchemas/{metadata_schema}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String metadataStore;
    private String metadataSchema;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMetadataStore() {
      return metadataStore;
    }

    public String getMetadataSchema() {
      return metadataSchema;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMetadataStore(String metadataStore) {
      this.metadataStore = metadataStore;
      return this;
    }

    public Builder setMetadataSchema(String metadataSchema) {
      this.metadataSchema = metadataSchema;
      return this;
    }

    private Builder(MetadataSchemaName metadataSchemaName) {
      this.project = metadataSchemaName.project;
      this.location = metadataSchemaName.location;
      this.metadataStore = metadataSchemaName.metadataStore;
      this.metadataSchema = metadataSchemaName.metadataSchema;
    }

    public MetadataSchemaName build() {
      return new MetadataSchemaName(this);
    }
  }
}
