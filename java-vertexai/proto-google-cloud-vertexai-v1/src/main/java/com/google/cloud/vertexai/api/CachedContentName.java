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

package com.google.cloud.vertexai.api;

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
public class CachedContentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CACHED_CONTENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/cachedContents/{cached_content}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String cachedContent;

  @Deprecated
  protected CachedContentName() {
    project = null;
    location = null;
    cachedContent = null;
  }

  private CachedContentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cachedContent = Preconditions.checkNotNull(builder.getCachedContent());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCachedContent() {
    return cachedContent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CachedContentName of(String project, String location, String cachedContent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCachedContent(cachedContent)
        .build();
  }

  public static String format(String project, String location, String cachedContent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCachedContent(cachedContent)
        .build()
        .toString();
  }

  public static CachedContentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CACHED_CONTENT.validatedMatch(
            formattedString, "CachedContentName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("cached_content"));
  }

  public static List<CachedContentName> parseList(List<String> formattedStrings) {
    List<CachedContentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CachedContentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CachedContentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CACHED_CONTENT.matches(formattedString);
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
          if (cachedContent != null) {
            fieldMapBuilder.put("cached_content", cachedContent);
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
    return PROJECT_LOCATION_CACHED_CONTENT.instantiate(
        "project", project, "location", location, "cached_content", cachedContent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CachedContentName that = ((CachedContentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cachedContent, that.cachedContent);
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
    h ^= Objects.hashCode(cachedContent);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/cachedContents/{cached_content}. */
  public static class Builder {
    private String project;
    private String location;
    private String cachedContent;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCachedContent() {
      return cachedContent;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCachedContent(String cachedContent) {
      this.cachedContent = cachedContent;
      return this;
    }

    private Builder(CachedContentName cachedContentName) {
      this.project = cachedContentName.project;
      this.location = cachedContentName.location;
      this.cachedContent = cachedContentName.cachedContent;
    }

    public CachedContentName build() {
      return new CachedContentName(this);
    }
  }
}
