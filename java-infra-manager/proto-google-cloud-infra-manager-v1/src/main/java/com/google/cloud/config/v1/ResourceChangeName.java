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

package com.google.cloud.config.v1;

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
public class ResourceChangeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PREVIEW_RESOURCE_CHANGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/previews/{preview}/resourceChanges/{resource_change}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String preview;
  private final String resourceChange;

  @Deprecated
  protected ResourceChangeName() {
    project = null;
    location = null;
    preview = null;
    resourceChange = null;
  }

  private ResourceChangeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    preview = Preconditions.checkNotNull(builder.getPreview());
    resourceChange = Preconditions.checkNotNull(builder.getResourceChange());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPreview() {
    return preview;
  }

  public String getResourceChange() {
    return resourceChange;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ResourceChangeName of(
      String project, String location, String preview, String resourceChange) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPreview(preview)
        .setResourceChange(resourceChange)
        .build();
  }

  public static String format(
      String project, String location, String preview, String resourceChange) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPreview(preview)
        .setResourceChange(resourceChange)
        .build()
        .toString();
  }

  public static ResourceChangeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PREVIEW_RESOURCE_CHANGE.validatedMatch(
            formattedString, "ResourceChangeName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("preview"),
        matchMap.get("resource_change"));
  }

  public static List<ResourceChangeName> parseList(List<String> formattedStrings) {
    List<ResourceChangeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ResourceChangeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ResourceChangeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PREVIEW_RESOURCE_CHANGE.matches(formattedString);
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
          if (preview != null) {
            fieldMapBuilder.put("preview", preview);
          }
          if (resourceChange != null) {
            fieldMapBuilder.put("resource_change", resourceChange);
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
    return PROJECT_LOCATION_PREVIEW_RESOURCE_CHANGE.instantiate(
        "project",
        project,
        "location",
        location,
        "preview",
        preview,
        "resource_change",
        resourceChange);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ResourceChangeName that = ((ResourceChangeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.preview, that.preview)
          && Objects.equals(this.resourceChange, that.resourceChange);
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
    h ^= Objects.hashCode(preview);
    h *= 1000003;
    h ^= Objects.hashCode(resourceChange);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/previews/{preview}/resourceChanges/{resource_change}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String preview;
    private String resourceChange;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPreview() {
      return preview;
    }

    public String getResourceChange() {
      return resourceChange;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPreview(String preview) {
      this.preview = preview;
      return this;
    }

    public Builder setResourceChange(String resourceChange) {
      this.resourceChange = resourceChange;
      return this;
    }

    private Builder(ResourceChangeName resourceChangeName) {
      this.project = resourceChangeName.project;
      this.location = resourceChangeName.location;
      this.preview = resourceChangeName.preview;
      this.resourceChange = resourceChangeName.resourceChange;
    }

    public ResourceChangeName build() {
      return new ResourceChangeName(this);
    }
  }
}
