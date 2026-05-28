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

package com.google.cloud.numberregistry.v1alpha;

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
public class RegistryBookName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REGISTRY_BOOK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/registryBooks/{registry_book}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String registryBook;

  @Deprecated
  protected RegistryBookName() {
    project = null;
    location = null;
    registryBook = null;
  }

  private RegistryBookName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    registryBook = Preconditions.checkNotNull(builder.getRegistryBook());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRegistryBook() {
    return registryBook;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RegistryBookName of(String project, String location, String registryBook) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRegistryBook(registryBook)
        .build();
  }

  public static String format(String project, String location, String registryBook) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRegistryBook(registryBook)
        .build()
        .toString();
  }

  public static RegistryBookName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REGISTRY_BOOK.validatedMatch(
            formattedString, "RegistryBookName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("registry_book"));
  }

  public static List<RegistryBookName> parseList(List<String> formattedStrings) {
    List<RegistryBookName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RegistryBookName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RegistryBookName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REGISTRY_BOOK.matches(formattedString);
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
          if (registryBook != null) {
            fieldMapBuilder.put("registry_book", registryBook);
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
    return PROJECT_LOCATION_REGISTRY_BOOK.instantiate(
        "project", project, "location", location, "registry_book", registryBook);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RegistryBookName that = ((RegistryBookName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.registryBook, that.registryBook);
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
    h ^= Objects.hashCode(registryBook);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/registryBooks/{registry_book}. */
  public static class Builder {
    private String project;
    private String location;
    private String registryBook;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRegistryBook() {
      return registryBook;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRegistryBook(String registryBook) {
      this.registryBook = registryBook;
      return this;
    }

    private Builder(RegistryBookName registryBookName) {
      this.project = registryBookName.project;
      this.location = registryBookName.location;
      this.registryBook = registryBookName.registryBook;
    }

    public RegistryBookName build() {
      return new RegistryBookName(this);
    }
  }
}
