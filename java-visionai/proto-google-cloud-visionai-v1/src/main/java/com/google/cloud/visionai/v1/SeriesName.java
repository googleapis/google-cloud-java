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

package com.google.cloud.visionai.v1;

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
public class SeriesName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CLUSTER_SERIES =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/series/{series}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String cluster;
  private final String series;

  @Deprecated
  protected SeriesName() {
    project = null;
    location = null;
    cluster = null;
    series = null;
  }

  private SeriesName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    series = Preconditions.checkNotNull(builder.getSeries());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCluster() {
    return cluster;
  }

  public String getSeries() {
    return series;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SeriesName of(String project, String location, String cluster, String series) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setSeries(series)
        .build();
  }

  public static String format(String project, String location, String cluster, String series) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setSeries(series)
        .build()
        .toString();
  }

  public static SeriesName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CLUSTER_SERIES.validatedMatch(
            formattedString, "SeriesName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("cluster"),
        matchMap.get("series"));
  }

  public static List<SeriesName> parseList(List<String> formattedStrings) {
    List<SeriesName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SeriesName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SeriesName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CLUSTER_SERIES.matches(formattedString);
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
          if (cluster != null) {
            fieldMapBuilder.put("cluster", cluster);
          }
          if (series != null) {
            fieldMapBuilder.put("series", series);
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
    return PROJECT_LOCATION_CLUSTER_SERIES.instantiate(
        "project", project, "location", location, "cluster", cluster, "series", series);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SeriesName that = ((SeriesName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cluster, that.cluster)
          && Objects.equals(this.series, that.series);
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
    h ^= Objects.hashCode(cluster);
    h *= 1000003;
    h ^= Objects.hashCode(series);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/clusters/{cluster}/series/{series}. */
  public static class Builder {
    private String project;
    private String location;
    private String cluster;
    private String series;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCluster() {
      return cluster;
    }

    public String getSeries() {
      return series;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public Builder setSeries(String series) {
      this.series = series;
      return this;
    }

    private Builder(SeriesName seriesName) {
      this.project = seriesName.project;
      this.location = seriesName.location;
      this.cluster = seriesName.cluster;
      this.series = seriesName.series;
    }

    public SeriesName build() {
      return new SeriesName(this);
    }
  }
}
