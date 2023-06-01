/*
 * Copyright 2022 Google LLC
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
public class DataExchangeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_EXCHANGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataExchanges/{data_exchange}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataExchange;

  @Deprecated
  protected DataExchangeName() {
    project = null;
    location = null;
    dataExchange = null;
  }

  private DataExchangeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataExchange = Preconditions.checkNotNull(builder.getDataExchange());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataExchangeName of(String project, String location, String dataExchange) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataExchange(dataExchange)
        .build();
  }

  public static String format(String project, String location, String dataExchange) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataExchange(dataExchange)
        .build()
        .toString();
  }

  public static DataExchangeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATA_EXCHANGE.validatedMatch(
            formattedString, "DataExchangeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("data_exchange"));
  }

  public static List<DataExchangeName> parseList(List<String> formattedStrings) {
    List<DataExchangeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataExchangeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataExchangeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_EXCHANGE.matches(formattedString);
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
    return PROJECT_LOCATION_DATA_EXCHANGE.instantiate(
        "project", project, "location", location, "data_exchange", dataExchange);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DataExchangeName that = ((DataExchangeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataExchange, that.dataExchange);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/dataExchanges/{data_exchange}. */
  public static class Builder {
    private String project;
    private String location;
    private String dataExchange;

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

    private Builder(DataExchangeName dataExchangeName) {
      this.project = dataExchangeName.project;
      this.location = dataExchangeName.location;
      this.dataExchange = dataExchangeName.dataExchange;
    }

    public DataExchangeName build() {
      return new DataExchangeName(this);
    }
  }
}
