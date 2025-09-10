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

package com.google.cloud.bigquery.analyticshub.v1;

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
public class QueryTemplateName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_EXCHANGE_QUERY_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataExchanges/{data_exchange}/queryTemplates/{query_template}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataExchange;
  private final String queryTemplate;

  @Deprecated
  protected QueryTemplateName() {
    project = null;
    location = null;
    dataExchange = null;
    queryTemplate = null;
  }

  private QueryTemplateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataExchange = Preconditions.checkNotNull(builder.getDataExchange());
    queryTemplate = Preconditions.checkNotNull(builder.getQueryTemplate());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataExchange() {
    return dataExchange;
  }

  public String getQueryTemplate() {
    return queryTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static QueryTemplateName of(
      String project, String location, String dataExchange, String queryTemplate) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataExchange(dataExchange)
        .setQueryTemplate(queryTemplate)
        .build();
  }

  public static String format(
      String project, String location, String dataExchange, String queryTemplate) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataExchange(dataExchange)
        .setQueryTemplate(queryTemplate)
        .build()
        .toString();
  }

  public static QueryTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATA_EXCHANGE_QUERY_TEMPLATE.validatedMatch(
            formattedString, "QueryTemplateName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("data_exchange"),
        matchMap.get("query_template"));
  }

  public static List<QueryTemplateName> parseList(List<String> formattedStrings) {
    List<QueryTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<QueryTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (QueryTemplateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_EXCHANGE_QUERY_TEMPLATE.matches(formattedString);
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
          if (dataExchange != null) {
            fieldMapBuilder.put("data_exchange", dataExchange);
          }
          if (queryTemplate != null) {
            fieldMapBuilder.put("query_template", queryTemplate);
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
    return PROJECT_LOCATION_DATA_EXCHANGE_QUERY_TEMPLATE.instantiate(
        "project",
        project,
        "location",
        location,
        "data_exchange",
        dataExchange,
        "query_template",
        queryTemplate);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      QueryTemplateName that = ((QueryTemplateName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataExchange, that.dataExchange)
          && Objects.equals(this.queryTemplate, that.queryTemplate);
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
    h ^= Objects.hashCode(dataExchange);
    h *= 1000003;
    h ^= Objects.hashCode(queryTemplate);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataExchanges/{data_exchange}/queryTemplates/{query_template}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataExchange;
    private String queryTemplate;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataExchange() {
      return dataExchange;
    }

    public String getQueryTemplate() {
      return queryTemplate;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataExchange(String dataExchange) {
      this.dataExchange = dataExchange;
      return this;
    }

    public Builder setQueryTemplate(String queryTemplate) {
      this.queryTemplate = queryTemplate;
      return this;
    }

    private Builder(QueryTemplateName queryTemplateName) {
      this.project = queryTemplateName.project;
      this.location = queryTemplateName.location;
      this.dataExchange = queryTemplateName.dataExchange;
      this.queryTemplate = queryTemplateName.queryTemplate;
    }

    public QueryTemplateName build() {
      return new QueryTemplateName(this);
    }
  }
}
