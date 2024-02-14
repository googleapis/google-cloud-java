/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.netapp.v1;

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
public class StoragePoolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_STORAGE_POOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/storagePools/{storage_pool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String storagePool;

  @Deprecated
  protected StoragePoolName() {
    project = null;
    location = null;
    storagePool = null;
  }

  private StoragePoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    storagePool = Preconditions.checkNotNull(builder.getStoragePool());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getStoragePool() {
    return storagePool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static StoragePoolName of(String project, String location, String storagePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStoragePool(storagePool)
        .build();
  }

  public static String format(String project, String location, String storagePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStoragePool(storagePool)
        .build()
        .toString();
  }

  public static StoragePoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_STORAGE_POOL.validatedMatch(
            formattedString, "StoragePoolName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("storage_pool"));
  }

  public static List<StoragePoolName> parseList(List<String> formattedStrings) {
    List<StoragePoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<StoragePoolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (StoragePoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_STORAGE_POOL.matches(formattedString);
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
          if (storagePool != null) {
            fieldMapBuilder.put("storage_pool", storagePool);
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
    return PROJECT_LOCATION_STORAGE_POOL.instantiate(
        "project", project, "location", location, "storage_pool", storagePool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      StoragePoolName that = ((StoragePoolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.storagePool, that.storagePool);
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
    h ^= Objects.hashCode(storagePool);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/storagePools/{storage_pool}. */
  public static class Builder {
    private String project;
    private String location;
    private String storagePool;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getStoragePool() {
      return storagePool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setStoragePool(String storagePool) {
      this.storagePool = storagePool;
      return this;
    }

    private Builder(StoragePoolName storagePoolName) {
      this.project = storagePoolName.project;
      this.location = storagePoolName.location;
      this.storagePool = storagePoolName.storagePool;
    }

    public StoragePoolName build() {
      return new StoragePoolName(this);
    }
  }
}
