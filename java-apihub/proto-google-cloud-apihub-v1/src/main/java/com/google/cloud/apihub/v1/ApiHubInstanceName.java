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

package com.google.cloud.apihub.v1;

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
public class ApiHubInstanceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_API_HUB_INSTANCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apiHubInstances/{api_hub_instance}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String apiHubInstance;

  @Deprecated
  protected ApiHubInstanceName() {
    project = null;
    location = null;
    apiHubInstance = null;
  }

  private ApiHubInstanceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    apiHubInstance = Preconditions.checkNotNull(builder.getApiHubInstance());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApiHubInstance() {
    return apiHubInstance;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApiHubInstanceName of(String project, String location, String apiHubInstance) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiHubInstance(apiHubInstance)
        .build();
  }

  public static String format(String project, String location, String apiHubInstance) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiHubInstance(apiHubInstance)
        .build()
        .toString();
  }

  public static ApiHubInstanceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_API_HUB_INSTANCE.validatedMatch(
            formattedString, "ApiHubInstanceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("api_hub_instance"));
  }

  public static List<ApiHubInstanceName> parseList(List<String> formattedStrings) {
    List<ApiHubInstanceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApiHubInstanceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApiHubInstanceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_API_HUB_INSTANCE.matches(formattedString);
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
          if (apiHubInstance != null) {
            fieldMapBuilder.put("api_hub_instance", apiHubInstance);
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
    return PROJECT_LOCATION_API_HUB_INSTANCE.instantiate(
        "project", project, "location", location, "api_hub_instance", apiHubInstance);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ApiHubInstanceName that = ((ApiHubInstanceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.apiHubInstance, that.apiHubInstance);
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
    h ^= Objects.hashCode(apiHubInstance);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/apiHubInstances/{api_hub_instance}. */
  public static class Builder {
    private String project;
    private String location;
    private String apiHubInstance;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApiHubInstance() {
      return apiHubInstance;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApiHubInstance(String apiHubInstance) {
      this.apiHubInstance = apiHubInstance;
      return this;
    }

    private Builder(ApiHubInstanceName apiHubInstanceName) {
      this.project = apiHubInstanceName.project;
      this.location = apiHubInstanceName.location;
      this.apiHubInstance = apiHubInstanceName.apiHubInstance;
    }

    public ApiHubInstanceName build() {
      return new ApiHubInstanceName(this);
    }
  }
}
