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

package com.google.cloud.discoveryengine.v1beta;

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
public class SampleQuerySetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SAMPLE_QUERY_SET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String sampleQuerySet;

  @Deprecated
  protected SampleQuerySetName() {
    project = null;
    location = null;
    sampleQuerySet = null;
  }

  private SampleQuerySetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    sampleQuerySet = Preconditions.checkNotNull(builder.getSampleQuerySet());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSampleQuerySet() {
    return sampleQuerySet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SampleQuerySetName of(String project, String location, String sampleQuerySet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSampleQuerySet(sampleQuerySet)
        .build();
  }

  public static String format(String project, String location, String sampleQuerySet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSampleQuerySet(sampleQuerySet)
        .build()
        .toString();
  }

  public static SampleQuerySetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SAMPLE_QUERY_SET.validatedMatch(
            formattedString, "SampleQuerySetName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("sample_query_set"));
  }

  public static List<SampleQuerySetName> parseList(List<String> formattedStrings) {
    List<SampleQuerySetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SampleQuerySetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SampleQuerySetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SAMPLE_QUERY_SET.matches(formattedString);
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
          if (sampleQuerySet != null) {
            fieldMapBuilder.put("sample_query_set", sampleQuerySet);
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
    return PROJECT_LOCATION_SAMPLE_QUERY_SET.instantiate(
        "project", project, "location", location, "sample_query_set", sampleQuerySet);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SampleQuerySetName that = ((SampleQuerySetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.sampleQuerySet, that.sampleQuerySet);
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
    h ^= Objects.hashCode(sampleQuerySet);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sampleQuerySets/{sample_query_set}. */
  public static class Builder {
    private String project;
    private String location;
    private String sampleQuerySet;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSampleQuerySet() {
      return sampleQuerySet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSampleQuerySet(String sampleQuerySet) {
      this.sampleQuerySet = sampleQuerySet;
      return this;
    }

    private Builder(SampleQuerySetName sampleQuerySetName) {
      this.project = sampleQuerySetName.project;
      this.location = sampleQuerySetName.location;
      this.sampleQuerySet = sampleQuerySetName.sampleQuerySet;
    }

    public SampleQuerySetName build() {
      return new SampleQuerySetName(this);
    }
  }
}
