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

package com.google.cloud.apigateway.v1;

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
public class ApiConfigName implements ResourceName {
  private static final PathTemplate PROJECT_API_API_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/global/apis/{api}/configs/{api_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String api;
  private final String apiConfig;

  @Deprecated
  protected ApiConfigName() {
    project = null;
    api = null;
    apiConfig = null;
  }

  private ApiConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    api = Preconditions.checkNotNull(builder.getApi());
    apiConfig = Preconditions.checkNotNull(builder.getApiConfig());
  }

  public String getProject() {
    return project;
  }

  public String getApi() {
    return api;
  }

  public String getApiConfig() {
    return apiConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApiConfigName of(String project, String api, String apiConfig) {
    return newBuilder().setProject(project).setApi(api).setApiConfig(apiConfig).build();
  }

  public static String format(String project, String api, String apiConfig) {
    return newBuilder().setProject(project).setApi(api).setApiConfig(apiConfig).build().toString();
  }

  public static ApiConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_API_API_CONFIG.validatedMatch(
            formattedString, "ApiConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("api"), matchMap.get("api_config"));
  }

  public static List<ApiConfigName> parseList(List<String> formattedStrings) {
    List<ApiConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApiConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApiConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_API_API_CONFIG.matches(formattedString);
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
          if (api != null) {
            fieldMapBuilder.put("api", api);
          }
          if (apiConfig != null) {
            fieldMapBuilder.put("api_config", apiConfig);
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
    return PROJECT_API_API_CONFIG.instantiate(
        "project", project, "api", api, "api_config", apiConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ApiConfigName that = ((ApiConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.api, that.api)
          && Objects.equals(this.apiConfig, that.apiConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(api);
    h *= 1000003;
    h ^= Objects.hashCode(apiConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/global/apis/{api}/configs/{api_config}. */
  public static class Builder {
    private String project;
    private String api;
    private String apiConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getApi() {
      return api;
    }

    public String getApiConfig() {
      return apiConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setApi(String api) {
      this.api = api;
      return this;
    }

    public Builder setApiConfig(String apiConfig) {
      this.apiConfig = apiConfig;
      return this;
    }

    private Builder(ApiConfigName apiConfigName) {
      this.project = apiConfigName.project;
      this.api = apiConfigName.api;
      this.apiConfig = apiConfigName.apiConfig;
    }

    public ApiConfigName build() {
      return new ApiConfigName(this);
    }
  }
}
