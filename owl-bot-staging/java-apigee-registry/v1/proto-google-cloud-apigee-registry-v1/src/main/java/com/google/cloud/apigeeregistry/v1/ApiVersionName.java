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

package com.google.cloud.apigeeregistry.v1;

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
public class ApiVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_API_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apis/{api}/versions/{version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String api;
  private final String version;

  @Deprecated
  protected ApiVersionName() {
    project = null;
    location = null;
    api = null;
    version = null;
  }

  private ApiVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    api = Preconditions.checkNotNull(builder.getApi());
    version = Preconditions.checkNotNull(builder.getVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApi() {
    return api;
  }

  public String getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApiVersionName of(String project, String location, String api, String version) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setVersion(version)
        .build();
  }

  public static String format(String project, String location, String api, String version) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setVersion(version)
        .build()
        .toString();
  }

  public static ApiVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_API_VERSION.validatedMatch(
            formattedString, "ApiVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("api"),
        matchMap.get("version"));
  }

  public static List<ApiVersionName> parseList(List<String> formattedStrings) {
    List<ApiVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApiVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApiVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_API_VERSION.matches(formattedString);
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
          if (api != null) {
            fieldMapBuilder.put("api", api);
          }
          if (version != null) {
            fieldMapBuilder.put("version", version);
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
    return PROJECT_LOCATION_API_VERSION.instantiate(
        "project", project, "location", location, "api", api, "version", version);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ApiVersionName that = ((ApiVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.api, that.api)
          && Objects.equals(this.version, that.version);
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
    h ^= Objects.hashCode(api);
    h *= 1000003;
    h ^= Objects.hashCode(version);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/apis/{api}/versions/{version}. */
  public static class Builder {
    private String project;
    private String location;
    private String api;
    private String version;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApi() {
      return api;
    }

    public String getVersion() {
      return version;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApi(String api) {
      this.api = api;
      return this;
    }

    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    private Builder(ApiVersionName apiVersionName) {
      this.project = apiVersionName.project;
      this.location = apiVersionName.location;
      this.api = apiVersionName.api;
      this.version = apiVersionName.version;
    }

    public ApiVersionName build() {
      return new ApiVersionName(this);
    }
  }
}
