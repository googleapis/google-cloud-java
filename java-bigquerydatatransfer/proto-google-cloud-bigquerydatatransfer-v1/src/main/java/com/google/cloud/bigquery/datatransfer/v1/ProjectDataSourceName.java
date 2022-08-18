/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.bigquery.datatransfer.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * AUTO-GENERATED DOCUMENTATION AND CLASS
 *
 * @deprecated This resource name class will be removed in the next major version.
 */
@javax.annotation.Generated("by GAPIC protoc plugin")
@Deprecated
public class ProjectDataSourceName extends DataSourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/dataSources/{data_source}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String dataSource;

  public String getProject() {
    return project;
  }

  public String getDataSource() {
    return dataSource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectDataSourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    dataSource = Preconditions.checkNotNull(builder.getDataSource());
  }

  public static ProjectDataSourceName of(String project, String dataSource) {
    return newBuilder().setProject(project).setDataSource(dataSource).build();
  }

  public static String format(String project, String dataSource) {
    return newBuilder().setProject(project).setDataSource(dataSource).build().toString();
  }

  public static ProjectDataSourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ProjectDataSourceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("data_source"));
  }

  public static List<ProjectDataSourceName> parseList(List<String> formattedStrings) {
    List<ProjectDataSourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectDataSourceName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectDataSourceName value : values) {
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
          fieldMapBuilder.put("dataSource", dataSource);
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
    return PATH_TEMPLATE.instantiate("project", project, "data_source", dataSource);
  }

  /** Builder for ProjectDataSourceName. */
  public static class Builder extends DataSourceName.Builder {

    private String project;
    private String dataSource;

    public String getProject() {
      return project;
    }

    public String getDataSource() {
      return dataSource;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDataSource(String dataSource) {
      this.dataSource = dataSource;
      return this;
    }

    private Builder() {}

    private Builder(ProjectDataSourceName projectDataSourceName) {
      project = projectDataSourceName.project;
      dataSource = projectDataSourceName.dataSource;
    }

    public ProjectDataSourceName build() {
      return new ProjectDataSourceName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectDataSourceName) {
      ProjectDataSourceName that = (ProjectDataSourceName) o;
      return (this.project.equals(that.project)) && (this.dataSource.equals(that.dataSource));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= dataSource.hashCode();
    return h;
  }
}
