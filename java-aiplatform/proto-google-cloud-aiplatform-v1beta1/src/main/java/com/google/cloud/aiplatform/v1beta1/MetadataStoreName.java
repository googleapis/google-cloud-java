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
public class MetadataStoreName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_METADATA_STORE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/metadataStores/{metadata_store}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String metadataStore;

  @Deprecated
  protected MetadataStoreName() {
    project = null;
    location = null;
    metadataStore = null;
  }

  private MetadataStoreName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    metadataStore = Preconditions.checkNotNull(builder.getMetadataStore());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MetadataStoreName of(String project, String location, String metadataStore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMetadataStore(metadataStore)
        .build();
  }

  public static String format(String project, String location, String metadataStore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMetadataStore(metadataStore)
        .build()
        .toString();
  }

  public static MetadataStoreName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_METADATA_STORE.validatedMatch(
            formattedString, "MetadataStoreName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("metadata_store"));
  }

  public static List<MetadataStoreName> parseList(List<String> formattedStrings) {
    List<MetadataStoreName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetadataStoreName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MetadataStoreName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_METADATA_STORE.matches(formattedString);
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
    return PROJECT_LOCATION_METADATA_STORE.instantiate(
        "project", project, "location", location, "metadata_store", metadataStore);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MetadataStoreName that = ((MetadataStoreName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.metadataStore, that.metadataStore);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/metadataStores/{metadata_store}. */
  public static class Builder {
    private String project;
    private String location;
    private String metadataStore;

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

    private Builder(MetadataStoreName metadataStoreName) {
      this.project = metadataStoreName.project;
      this.location = metadataStoreName.location;
      this.metadataStore = metadataStoreName.metadataStore;
    }

    public MetadataStoreName build() {
      return new MetadataStoreName(this);
    }
  }
}
