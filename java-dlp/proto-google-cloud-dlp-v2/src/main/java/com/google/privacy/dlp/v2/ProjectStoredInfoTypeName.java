/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.privacy.dlp.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProjectStoredInfoTypeName extends StoredInfoTypeName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/storedInfoTypes/{stored_info_type}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String storedInfoType;

  public String getProject() {
    return project;
  }

  public String getStoredInfoType() {
    return storedInfoType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectStoredInfoTypeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    storedInfoType = Preconditions.checkNotNull(builder.getStoredInfoType());
  }

  public static ProjectStoredInfoTypeName of(String project, String storedInfoType) {
    return newBuilder().setProject(project).setStoredInfoType(storedInfoType).build();
  }

  public static String format(String project, String storedInfoType) {
    return newBuilder().setProject(project).setStoredInfoType(storedInfoType).build().toString();
  }

  public static ProjectStoredInfoTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectStoredInfoTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("stored_info_type"));
  }

  public static List<ProjectStoredInfoTypeName> parseList(List<String> formattedStrings) {
    List<ProjectStoredInfoTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectStoredInfoTypeName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectStoredInfoTypeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("storedInfoType", storedInfoType);
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
    return PATH_TEMPLATE.instantiate("project", project, "stored_info_type", storedInfoType);
  }

  /** Builder for ProjectStoredInfoTypeName. */
  public static class Builder extends StoredInfoTypeName.Builder {

    private String project;
    private String storedInfoType;

    public String getProject() {
      return project;
    }

    public String getStoredInfoType() {
      return storedInfoType;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setStoredInfoType(String storedInfoType) {
      this.storedInfoType = storedInfoType;
      return this;
    }

    private Builder() {}

    private Builder(ProjectStoredInfoTypeName projectStoredInfoTypeName) {
      project = projectStoredInfoTypeName.project;
      storedInfoType = projectStoredInfoTypeName.storedInfoType;
    }

    public ProjectStoredInfoTypeName build() {
      return new ProjectStoredInfoTypeName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectStoredInfoTypeName) {
      ProjectStoredInfoTypeName that = (ProjectStoredInfoTypeName) o;
      return (this.project.equals(that.project))
          && (this.storedInfoType.equals(that.storedInfoType));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= storedInfoType.hashCode();
    return h;
  }
}
