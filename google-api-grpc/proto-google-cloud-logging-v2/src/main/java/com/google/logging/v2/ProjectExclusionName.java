/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.logging.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProjectExclusionName extends ExclusionName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/exclusions/{exclusion}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String exclusion;

  public String getProject() {
    return project;
  }

  public String getExclusion() {
    return exclusion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectExclusionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
  }

  public static ProjectExclusionName of(String project, String exclusion) {
    return newBuilder()
      .setProject(project)
      .setExclusion(exclusion)
      .build();
  }

  public static String format(String project, String exclusion) {
    return newBuilder()
      .setProject(project)
      .setExclusion(exclusion)
      .build()
      .toString();
  }

  public static ProjectExclusionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectExclusionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("exclusion"));
  }

  public static List<ProjectExclusionName> parseList(List<String> formattedStrings) {
    List<ProjectExclusionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectExclusionName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectExclusionName value : values) {
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
          fieldMapBuilder.put("exclusion", exclusion);
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
    return PATH_TEMPLATE.instantiate("project", project, "exclusion", exclusion);
  }

  /** Builder for ProjectExclusionName. */
  public static class Builder {

    private String project;
    private String exclusion;

    public String getProject() {
      return project;
    }

    public String getExclusion() {
      return exclusion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    private Builder() {
    }

    private Builder(ProjectExclusionName projectExclusionName) {
      project = projectExclusionName.project;
      exclusion = projectExclusionName.exclusion;
    }

    public ProjectExclusionName build() {
      return new ProjectExclusionName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectExclusionName) {
      ProjectExclusionName that = (ProjectExclusionName) o;
      return (this.project.equals(that.project))
          && (this.exclusion.equals(that.exclusion));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= exclusion.hashCode();
    return h;
  }
}

