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

package com.google.cloud.eventarc.v1;

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
public class GoogleApiSourceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GOOGLE_API_SOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/googleApiSources/{google_api_source}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String googleApiSource;

  @Deprecated
  protected GoogleApiSourceName() {
    project = null;
    location = null;
    googleApiSource = null;
  }

  private GoogleApiSourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    googleApiSource = Preconditions.checkNotNull(builder.getGoogleApiSource());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGoogleApiSource() {
    return googleApiSource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GoogleApiSourceName of(String project, String location, String googleApiSource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGoogleApiSource(googleApiSource)
        .build();
  }

  public static String format(String project, String location, String googleApiSource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGoogleApiSource(googleApiSource)
        .build()
        .toString();
  }

  public static GoogleApiSourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GOOGLE_API_SOURCE.validatedMatch(
            formattedString, "GoogleApiSourceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("google_api_source"));
  }

  public static List<GoogleApiSourceName> parseList(List<String> formattedStrings) {
    List<GoogleApiSourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GoogleApiSourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GoogleApiSourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GOOGLE_API_SOURCE.matches(formattedString);
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
          if (googleApiSource != null) {
            fieldMapBuilder.put("google_api_source", googleApiSource);
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
    return PROJECT_LOCATION_GOOGLE_API_SOURCE.instantiate(
        "project", project, "location", location, "google_api_source", googleApiSource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GoogleApiSourceName that = ((GoogleApiSourceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.googleApiSource, that.googleApiSource);
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
    h ^= Objects.hashCode(googleApiSource);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/googleApiSources/{google_api_source}. */
  public static class Builder {
    private String project;
    private String location;
    private String googleApiSource;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGoogleApiSource() {
      return googleApiSource;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGoogleApiSource(String googleApiSource) {
      this.googleApiSource = googleApiSource;
      return this;
    }

    private Builder(GoogleApiSourceName googleApiSourceName) {
      this.project = googleApiSourceName.project;
      this.location = googleApiSourceName.location;
      this.googleApiSource = googleApiSourceName.googleApiSource;
    }

    public GoogleApiSourceName build() {
      return new GoogleApiSourceName(this);
    }
  }
}
