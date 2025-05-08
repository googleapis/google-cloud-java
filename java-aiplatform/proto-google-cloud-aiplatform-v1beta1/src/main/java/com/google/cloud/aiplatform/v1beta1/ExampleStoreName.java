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
public class ExampleStoreName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_EXAMPLE_STORE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/exampleStores/{example_store}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String exampleStore;

  @Deprecated
  protected ExampleStoreName() {
    project = null;
    location = null;
    exampleStore = null;
  }

  private ExampleStoreName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    exampleStore = Preconditions.checkNotNull(builder.getExampleStore());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getExampleStore() {
    return exampleStore;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExampleStoreName of(String project, String location, String exampleStore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExampleStore(exampleStore)
        .build();
  }

  public static String format(String project, String location, String exampleStore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExampleStore(exampleStore)
        .build()
        .toString();
  }

  public static ExampleStoreName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_EXAMPLE_STORE.validatedMatch(
            formattedString, "ExampleStoreName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("example_store"));
  }

  public static List<ExampleStoreName> parseList(List<String> formattedStrings) {
    List<ExampleStoreName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ExampleStoreName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExampleStoreName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_EXAMPLE_STORE.matches(formattedString);
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
          if (exampleStore != null) {
            fieldMapBuilder.put("example_store", exampleStore);
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
    return PROJECT_LOCATION_EXAMPLE_STORE.instantiate(
        "project", project, "location", location, "example_store", exampleStore);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExampleStoreName that = ((ExampleStoreName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.exampleStore, that.exampleStore);
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
    h ^= Objects.hashCode(exampleStore);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/exampleStores/{example_store}. */
  public static class Builder {
    private String project;
    private String location;
    private String exampleStore;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getExampleStore() {
      return exampleStore;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setExampleStore(String exampleStore) {
      this.exampleStore = exampleStore;
      return this;
    }

    private Builder(ExampleStoreName exampleStoreName) {
      this.project = exampleStoreName.project;
      this.location = exampleStoreName.location;
      this.exampleStore = exampleStoreName.exampleStore;
    }

    public ExampleStoreName build() {
      return new ExampleStoreName(this);
    }
  }
}
