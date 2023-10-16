/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.clouddms.v1;

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
public class ConversionWorkspaceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSION_WORKSPACE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String conversionWorkspace;

  @Deprecated
  protected ConversionWorkspaceName() {
    project = null;
    location = null;
    conversionWorkspace = null;
  }

  private ConversionWorkspaceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversionWorkspace = Preconditions.checkNotNull(builder.getConversionWorkspace());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getConversionWorkspace() {
    return conversionWorkspace;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversionWorkspaceName of(
      String project, String location, String conversionWorkspace) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversionWorkspace(conversionWorkspace)
        .build();
  }

  public static String format(String project, String location, String conversionWorkspace) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversionWorkspace(conversionWorkspace)
        .build()
        .toString();
  }

  public static ConversionWorkspaceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CONVERSION_WORKSPACE.validatedMatch(
            formattedString, "ConversionWorkspaceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("conversion_workspace"));
  }

  public static List<ConversionWorkspaceName> parseList(List<String> formattedStrings) {
    List<ConversionWorkspaceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversionWorkspaceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversionWorkspaceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONVERSION_WORKSPACE.matches(formattedString);
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
          if (conversionWorkspace != null) {
            fieldMapBuilder.put("conversion_workspace", conversionWorkspace);
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
    return PROJECT_LOCATION_CONVERSION_WORKSPACE.instantiate(
        "project", project, "location", location, "conversion_workspace", conversionWorkspace);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ConversionWorkspaceName that = ((ConversionWorkspaceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversionWorkspace, that.conversionWorkspace);
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
    h ^= Objects.hashCode(conversionWorkspace);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String conversionWorkspace;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversionWorkspace() {
      return conversionWorkspace;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setConversionWorkspace(String conversionWorkspace) {
      this.conversionWorkspace = conversionWorkspace;
      return this;
    }

    private Builder(ConversionWorkspaceName conversionWorkspaceName) {
      this.project = conversionWorkspaceName.project;
      this.location = conversionWorkspaceName.location;
      this.conversionWorkspace = conversionWorkspaceName.conversionWorkspace;
    }

    public ConversionWorkspaceName build() {
      return new ConversionWorkspaceName(this);
    }
  }
}
