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

package com.google.cloud.configdelivery.v1;

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
public class ResourceBundleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RESOURCE_BUNDLE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/resourceBundles/{resource_bundle}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String resourceBundle;

  @Deprecated
  protected ResourceBundleName() {
    project = null;
    location = null;
    resourceBundle = null;
  }

  private ResourceBundleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    resourceBundle = Preconditions.checkNotNull(builder.getResourceBundle());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getResourceBundle() {
    return resourceBundle;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ResourceBundleName of(String project, String location, String resourceBundle) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setResourceBundle(resourceBundle)
        .build();
  }

  public static String format(String project, String location, String resourceBundle) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setResourceBundle(resourceBundle)
        .build()
        .toString();
  }

  public static ResourceBundleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RESOURCE_BUNDLE.validatedMatch(
            formattedString, "ResourceBundleName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("resource_bundle"));
  }

  public static List<ResourceBundleName> parseList(List<String> formattedStrings) {
    List<ResourceBundleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ResourceBundleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ResourceBundleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RESOURCE_BUNDLE.matches(formattedString);
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
          if (resourceBundle != null) {
            fieldMapBuilder.put("resource_bundle", resourceBundle);
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
    return PROJECT_LOCATION_RESOURCE_BUNDLE.instantiate(
        "project", project, "location", location, "resource_bundle", resourceBundle);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ResourceBundleName that = ((ResourceBundleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.resourceBundle, that.resourceBundle);
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
    h ^= Objects.hashCode(resourceBundle);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/resourceBundles/{resource_bundle}. */
  public static class Builder {
    private String project;
    private String location;
    private String resourceBundle;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getResourceBundle() {
      return resourceBundle;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setResourceBundle(String resourceBundle) {
      this.resourceBundle = resourceBundle;
      return this;
    }

    private Builder(ResourceBundleName resourceBundleName) {
      this.project = resourceBundleName.project;
      this.location = resourceBundleName.location;
      this.resourceBundle = resourceBundleName.resourceBundle;
    }

    public ResourceBundleName build() {
      return new ResourceBundleName(this);
    }
  }
}
