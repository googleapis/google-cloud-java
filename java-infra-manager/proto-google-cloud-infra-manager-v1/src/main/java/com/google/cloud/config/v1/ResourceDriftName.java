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
public class ResourceDriftName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PREVIEW_RESOURCE_DRIFT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/previews/{preview}/resourceDrifts/{resource_drift}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String preview;
  private final String resourceDrift;

  @Deprecated
  protected ResourceDriftName() {
    project = null;
    location = null;
    preview = null;
    resourceDrift = null;
  }

  private ResourceDriftName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    preview = Preconditions.checkNotNull(builder.getPreview());
    resourceDrift = Preconditions.checkNotNull(builder.getResourceDrift());
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

  public String getResourceDrift() {
    return resourceDrift;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ResourceDriftName of(
      String project, String location, String preview, String resourceDrift) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPreview(preview)
        .setResourceDrift(resourceDrift)
        .build();
  }

  public static String format(
      String project, String location, String preview, String resourceDrift) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPreview(preview)
        .setResourceDrift(resourceDrift)
        .build()
        .toString();
  }

  public static ResourceDriftName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PREVIEW_RESOURCE_DRIFT.validatedMatch(
            formattedString, "ResourceDriftName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("preview"),
        matchMap.get("resource_drift"));
  }

  public static List<ResourceDriftName> parseList(List<String> formattedStrings) {
    List<ResourceDriftName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ResourceDriftName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ResourceDriftName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PREVIEW_RESOURCE_DRIFT.matches(formattedString);
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
          if (resourceDrift != null) {
            fieldMapBuilder.put("resource_drift", resourceDrift);
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
    return PROJECT_LOCATION_PREVIEW_RESOURCE_DRIFT.instantiate(
        "project",
        project,
        "location",
        location,
        "preview",
        preview,
        "resource_drift",
        resourceDrift);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ResourceDriftName that = ((ResourceDriftName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.preview, that.preview)
          && Objects.equals(this.resourceDrift, that.resourceDrift);
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
    h ^= Objects.hashCode(resourceDrift);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/previews/{preview}/resourceDrifts/{resource_drift}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String preview;
    private String resourceDrift;

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

    public String getResourceDrift() {
      return resourceDrift;
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

    public Builder setResourceDrift(String resourceDrift) {
      this.resourceDrift = resourceDrift;
      return this;
    }

    private Builder(ResourceDriftName resourceDriftName) {
      this.project = resourceDriftName.project;
      this.location = resourceDriftName.location;
      this.preview = resourceDriftName.preview;
      this.resourceDrift = resourceDriftName.resourceDrift;
    }

    public ResourceDriftName build() {
      return new ResourceDriftName(this);
    }
  }
}
