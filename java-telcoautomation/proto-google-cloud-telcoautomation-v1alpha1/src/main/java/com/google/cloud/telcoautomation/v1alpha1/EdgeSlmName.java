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

package com.google.cloud.telcoautomation.v1alpha1;

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
public class EdgeSlmName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_EDGE_SLM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/edgeSlms/{edge_slm}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String edgeSlm;

  @Deprecated
  protected EdgeSlmName() {
    project = null;
    location = null;
    edgeSlm = null;
  }

  private EdgeSlmName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    edgeSlm = Preconditions.checkNotNull(builder.getEdgeSlm());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getEdgeSlm() {
    return edgeSlm;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EdgeSlmName of(String project, String location, String edgeSlm) {
    return newBuilder().setProject(project).setLocation(location).setEdgeSlm(edgeSlm).build();
  }

  public static String format(String project, String location, String edgeSlm) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEdgeSlm(edgeSlm)
        .build()
        .toString();
  }

  public static EdgeSlmName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_EDGE_SLM.validatedMatch(
            formattedString, "EdgeSlmName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("edge_slm"));
  }

  public static List<EdgeSlmName> parseList(List<String> formattedStrings) {
    List<EdgeSlmName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EdgeSlmName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EdgeSlmName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_EDGE_SLM.matches(formattedString);
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
          if (edgeSlm != null) {
            fieldMapBuilder.put("edge_slm", edgeSlm);
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
    return PROJECT_LOCATION_EDGE_SLM.instantiate(
        "project", project, "location", location, "edge_slm", edgeSlm);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EdgeSlmName that = ((EdgeSlmName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.edgeSlm, that.edgeSlm);
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
    h ^= Objects.hashCode(edgeSlm);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/edgeSlms/{edge_slm}. */
  public static class Builder {
    private String project;
    private String location;
    private String edgeSlm;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEdgeSlm() {
      return edgeSlm;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEdgeSlm(String edgeSlm) {
      this.edgeSlm = edgeSlm;
      return this;
    }

    private Builder(EdgeSlmName edgeSlmName) {
      this.project = edgeSlmName.project;
      this.location = edgeSlmName.location;
      this.edgeSlm = edgeSlmName.edgeSlm;
    }

    public EdgeSlmName build() {
      return new EdgeSlmName(this);
    }
  }
}
