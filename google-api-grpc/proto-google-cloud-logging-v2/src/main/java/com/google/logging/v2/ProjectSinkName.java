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
import com.google.api.resourcenames.ResourceNameType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProjectSinkName extends SinkName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/sinks/{sink}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String sink;

  public String getProject() {
    return project;
  }

  public String getSink() {
    return sink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectSinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    sink = Preconditions.checkNotNull(builder.getSink());
  }

  public static ProjectSinkName of(String project, String sink) {
    return newBuilder()
      .setProject(project)
      .setSink(sink)
      .build();
  }

  public static String format(String project, String sink) {
    return newBuilder()
      .setProject(project)
      .setSink(sink)
      .build()
      .toString();
  }

  public static ProjectSinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectSinkName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("sink"));
  }

  public static List<ProjectSinkName> parseList(List<String> formattedStrings) {
    List<ProjectSinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectSinkName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectSinkName value : values) {
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
          fieldMapBuilder.put("sink", sink);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  /**
   * @deprecated This method is only present to satisfy the ResourceName interface.
   */
  @Deprecated
  public ResourceNameType getType() {
    throw new UnsupportedOperationException("ProjectSinkName.getType() not supported");
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate("project", project, "sink", sink);
  }

  /** Builder for ProjectSinkName. */
  public static class Builder {

    private String project;
    private String sink;

    public String getProject() {
      return project;
    }

    public String getSink() {
      return sink;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    private Builder() {
    }

    private Builder(ProjectSinkName projectSinkName) {
      project = projectSinkName.project;
      sink = projectSinkName.sink;
    }

    public ProjectSinkName build() {
      return new ProjectSinkName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectSinkName) {
      ProjectSinkName that = (ProjectSinkName) o;
      return (this.project.equals(that.project))
          && (this.sink.equals(that.sink));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= sink.hashCode();
    return h;
  }
}

