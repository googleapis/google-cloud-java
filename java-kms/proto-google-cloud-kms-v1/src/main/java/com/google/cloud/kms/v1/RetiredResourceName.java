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

package com.google.cloud.kms.v1;

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
public class RetiredResourceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RETIRED_RESOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/retiredResources/{retired_resource}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String retiredResource;

  @Deprecated
  protected RetiredResourceName() {
    project = null;
    location = null;
    retiredResource = null;
  }

  private RetiredResourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    retiredResource = Preconditions.checkNotNull(builder.getRetiredResource());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRetiredResource() {
    return retiredResource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RetiredResourceName of(String project, String location, String retiredResource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRetiredResource(retiredResource)
        .build();
  }

  public static String format(String project, String location, String retiredResource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRetiredResource(retiredResource)
        .build()
        .toString();
  }

  public static RetiredResourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RETIRED_RESOURCE.validatedMatch(
            formattedString, "RetiredResourceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("retired_resource"));
  }

  public static List<RetiredResourceName> parseList(List<String> formattedStrings) {
    List<RetiredResourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RetiredResourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RetiredResourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RETIRED_RESOURCE.matches(formattedString);
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
          if (retiredResource != null) {
            fieldMapBuilder.put("retired_resource", retiredResource);
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
    return PROJECT_LOCATION_RETIRED_RESOURCE.instantiate(
        "project", project, "location", location, "retired_resource", retiredResource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RetiredResourceName that = ((RetiredResourceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.retiredResource, that.retiredResource);
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
    h ^= Objects.hashCode(retiredResource);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/retiredResources/{retired_resource}. */
  public static class Builder {
    private String project;
    private String location;
    private String retiredResource;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRetiredResource() {
      return retiredResource;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRetiredResource(String retiredResource) {
      this.retiredResource = retiredResource;
      return this;
    }

    private Builder(RetiredResourceName retiredResourceName) {
      this.project = retiredResourceName.project;
      this.location = retiredResourceName.location;
      this.retiredResource = retiredResourceName.retiredResource;
    }

    public RetiredResourceName build() {
      return new RetiredResourceName(this);
    }
  }
}
