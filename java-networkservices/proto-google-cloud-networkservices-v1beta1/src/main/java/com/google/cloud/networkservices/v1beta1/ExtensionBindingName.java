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

package com.google.cloud.networkservices.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class ExtensionBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_EXTENSION_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/extensionBindings/{extension_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String extensionBinding;

  @Deprecated
  protected ExtensionBindingName() {
    project = null;
    location = null;
    extensionBinding = null;
  }

  private ExtensionBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    extensionBinding = Preconditions.checkNotNull(builder.getExtensionBinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getExtensionBinding() {
    return extensionBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExtensionBindingName of(String project, String location, String extensionBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExtensionBinding(extensionBinding)
        .build();
  }

  public static String format(String project, String location, String extensionBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExtensionBinding(extensionBinding)
        .build()
        .toString();
  }

  public static @Nullable ExtensionBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_EXTENSION_BINDING.validatedMatch(
            formattedString, "ExtensionBindingName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("extension_binding"));
  }

  public static List<ExtensionBindingName> parseList(List<String> formattedStrings) {
    List<ExtensionBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ExtensionBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExtensionBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_EXTENSION_BINDING.matches(formattedString);
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
          if (extensionBinding != null) {
            fieldMapBuilder.put("extension_binding", extensionBinding);
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
    return PROJECT_LOCATION_EXTENSION_BINDING.instantiate(
        "project", project, "location", location, "extension_binding", extensionBinding);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExtensionBindingName that = ((ExtensionBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.extensionBinding, that.extensionBinding);
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
    h ^= Objects.hashCode(extensionBinding);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/extensionBindings/{extension_binding}. */
  public static class Builder {
    private String project;
    private String location;
    private String extensionBinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getExtensionBinding() {
      return extensionBinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setExtensionBinding(String extensionBinding) {
      this.extensionBinding = extensionBinding;
      return this;
    }

    private Builder(ExtensionBindingName extensionBindingName) {
      this.project = extensionBindingName.project;
      this.location = extensionBindingName.location;
      this.extensionBinding = extensionBindingName.extensionBinding;
    }

    public ExtensionBindingName build() {
      return new ExtensionBindingName(this);
    }
  }
}
