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
public class ExtensionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_EXTENSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/extensions/{extension}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String extension;

  @Deprecated
  protected ExtensionName() {
    project = null;
    location = null;
    extension = null;
  }

  private ExtensionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    extension = Preconditions.checkNotNull(builder.getExtension());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getExtension() {
    return extension;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExtensionName of(String project, String location, String extension) {
    return newBuilder().setProject(project).setLocation(location).setExtension(extension).build();
  }

  public static String format(String project, String location, String extension) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExtension(extension)
        .build()
        .toString();
  }

  public static ExtensionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_EXTENSION.validatedMatch(
            formattedString, "ExtensionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("extension"));
  }

  public static List<ExtensionName> parseList(List<String> formattedStrings) {
    List<ExtensionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ExtensionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExtensionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_EXTENSION.matches(formattedString);
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
          if (extension != null) {
            fieldMapBuilder.put("extension", extension);
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
    return PROJECT_LOCATION_EXTENSION.instantiate(
        "project", project, "location", location, "extension", extension);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExtensionName that = ((ExtensionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.extension, that.extension);
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
    h ^= Objects.hashCode(extension);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/extensions/{extension}. */
  public static class Builder {
    private String project;
    private String location;
    private String extension;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getExtension() {
      return extension;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setExtension(String extension) {
      this.extension = extension;
      return this;
    }

    private Builder(ExtensionName extensionName) {
      this.project = extensionName.project;
      this.location = extensionName.location;
      this.extension = extensionName.extension;
    }

    public ExtensionName build() {
      return new ExtensionName(this);
    }
  }
}
