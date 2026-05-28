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

package com.google.cloud.numberregistry.v1alpha;

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
public class DiscoveredRangeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DISCOVERED_RANGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/discoveredRanges/{discovered_range}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String discoveredRange;

  @Deprecated
  protected DiscoveredRangeName() {
    project = null;
    location = null;
    discoveredRange = null;
  }

  private DiscoveredRangeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    discoveredRange = Preconditions.checkNotNull(builder.getDiscoveredRange());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDiscoveredRange() {
    return discoveredRange;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DiscoveredRangeName of(String project, String location, String discoveredRange) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDiscoveredRange(discoveredRange)
        .build();
  }

  public static String format(String project, String location, String discoveredRange) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDiscoveredRange(discoveredRange)
        .build()
        .toString();
  }

  public static DiscoveredRangeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DISCOVERED_RANGE.validatedMatch(
            formattedString, "DiscoveredRangeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("discovered_range"));
  }

  public static List<DiscoveredRangeName> parseList(List<String> formattedStrings) {
    List<DiscoveredRangeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DiscoveredRangeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DiscoveredRangeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DISCOVERED_RANGE.matches(formattedString);
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
          if (discoveredRange != null) {
            fieldMapBuilder.put("discovered_range", discoveredRange);
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
    return PROJECT_LOCATION_DISCOVERED_RANGE.instantiate(
        "project", project, "location", location, "discovered_range", discoveredRange);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DiscoveredRangeName that = ((DiscoveredRangeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.discoveredRange, that.discoveredRange);
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
    h ^= Objects.hashCode(discoveredRange);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/discoveredRanges/{discovered_range}. */
  public static class Builder {
    private String project;
    private String location;
    private String discoveredRange;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDiscoveredRange() {
      return discoveredRange;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDiscoveredRange(String discoveredRange) {
      this.discoveredRange = discoveredRange;
      return this;
    }

    private Builder(DiscoveredRangeName discoveredRangeName) {
      this.project = discoveredRangeName.project;
      this.location = discoveredRangeName.location;
      this.discoveredRange = discoveredRangeName.discoveredRange;
    }

    public DiscoveredRangeName build() {
      return new DiscoveredRangeName(this);
    }
  }
}
