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

package com.google.cloud.telcoautomation.v1alpha1;

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
public class PublicBlueprintName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PUBLIC_LUEPRINT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/publicBlueprints/{public_lueprint}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String publicLueprint;

  @Deprecated
  protected PublicBlueprintName() {
    project = null;
    location = null;
    publicLueprint = null;
  }

  private PublicBlueprintName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    publicLueprint = Preconditions.checkNotNull(builder.getPublicLueprint());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPublicLueprint() {
    return publicLueprint;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PublicBlueprintName of(String project, String location, String publicLueprint) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPublicLueprint(publicLueprint)
        .build();
  }

  public static String format(String project, String location, String publicLueprint) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPublicLueprint(publicLueprint)
        .build()
        .toString();
  }

  public static PublicBlueprintName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PUBLIC_LUEPRINT.validatedMatch(
            formattedString, "PublicBlueprintName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("public_lueprint"));
  }

  public static List<PublicBlueprintName> parseList(List<String> formattedStrings) {
    List<PublicBlueprintName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PublicBlueprintName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PublicBlueprintName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PUBLIC_LUEPRINT.matches(formattedString);
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
          if (publicLueprint != null) {
            fieldMapBuilder.put("public_lueprint", publicLueprint);
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
    return PROJECT_LOCATION_PUBLIC_LUEPRINT.instantiate(
        "project", project, "location", location, "public_lueprint", publicLueprint);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PublicBlueprintName that = ((PublicBlueprintName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.publicLueprint, that.publicLueprint);
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
    h ^= Objects.hashCode(publicLueprint);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/publicBlueprints/{public_lueprint}. */
  public static class Builder {
    private String project;
    private String location;
    private String publicLueprint;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPublicLueprint() {
      return publicLueprint;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPublicLueprint(String publicLueprint) {
      this.publicLueprint = publicLueprint;
      return this;
    }

    private Builder(PublicBlueprintName publicBlueprintName) {
      this.project = publicBlueprintName.project;
      this.location = publicBlueprintName.location;
      this.publicLueprint = publicBlueprintName.publicLueprint;
    }

    public PublicBlueprintName build() {
      return new PublicBlueprintName(this);
    }
  }
}
