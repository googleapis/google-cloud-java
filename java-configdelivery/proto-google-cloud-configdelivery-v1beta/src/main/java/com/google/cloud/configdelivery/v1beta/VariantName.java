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

package com.google.cloud.configdelivery.v1beta;

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
public class VariantName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RESOURCE_BUNDLE_RELEASE_VARIANT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/resourceBundles/{resource_bundle}/releases/{release}/variants/{variant}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String resourceBundle;
  private final String release;
  private final String variant;

  @Deprecated
  protected VariantName() {
    project = null;
    location = null;
    resourceBundle = null;
    release = null;
    variant = null;
  }

  private VariantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    resourceBundle = Preconditions.checkNotNull(builder.getResourceBundle());
    release = Preconditions.checkNotNull(builder.getRelease());
    variant = Preconditions.checkNotNull(builder.getVariant());
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

  public String getRelease() {
    return release;
  }

  public String getVariant() {
    return variant;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VariantName of(
      String project, String location, String resourceBundle, String release, String variant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setResourceBundle(resourceBundle)
        .setRelease(release)
        .setVariant(variant)
        .build();
  }

  public static String format(
      String project, String location, String resourceBundle, String release, String variant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setResourceBundle(resourceBundle)
        .setRelease(release)
        .setVariant(variant)
        .build()
        .toString();
  }

  public static VariantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RESOURCE_BUNDLE_RELEASE_VARIANT.validatedMatch(
            formattedString, "VariantName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("resource_bundle"),
        matchMap.get("release"),
        matchMap.get("variant"));
  }

  public static List<VariantName> parseList(List<String> formattedStrings) {
    List<VariantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VariantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VariantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RESOURCE_BUNDLE_RELEASE_VARIANT.matches(formattedString);
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
          if (release != null) {
            fieldMapBuilder.put("release", release);
          }
          if (variant != null) {
            fieldMapBuilder.put("variant", variant);
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
    return PROJECT_LOCATION_RESOURCE_BUNDLE_RELEASE_VARIANT.instantiate(
        "project",
        project,
        "location",
        location,
        "resource_bundle",
        resourceBundle,
        "release",
        release,
        "variant",
        variant);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      VariantName that = ((VariantName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.resourceBundle, that.resourceBundle)
          && Objects.equals(this.release, that.release)
          && Objects.equals(this.variant, that.variant);
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
    h *= 1000003;
    h ^= Objects.hashCode(release);
    h *= 1000003;
    h ^= Objects.hashCode(variant);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/resourceBundles/{resource_bundle}/releases/{release}/variants/{variant}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String resourceBundle;
    private String release;
    private String variant;

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

    public String getRelease() {
      return release;
    }

    public String getVariant() {
      return variant;
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

    public Builder setRelease(String release) {
      this.release = release;
      return this;
    }

    public Builder setVariant(String variant) {
      this.variant = variant;
      return this;
    }

    private Builder(VariantName variantName) {
      this.project = variantName.project;
      this.location = variantName.location;
      this.resourceBundle = variantName.resourceBundle;
      this.release = variantName.release;
      this.variant = variantName.variant;
    }

    public VariantName build() {
      return new VariantName(this);
    }
  }
}
