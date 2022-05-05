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
public class ApiName implements ResourceName {
  private static final PathTemplate PROJECT_API =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/global/apis/{api}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String api;

  @Deprecated
  protected ApiName() {
    project = null;
    api = null;
  }

  private ApiName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    api = Preconditions.checkNotNull(builder.getApi());
  }

  public String getProject() {
    return project;
  }

  public String getApi() {
    return api;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApiName of(String project, String api) {
    return newBuilder().setProject(project).setApi(api).build();
  }

  public static String format(String project, String api) {
    return newBuilder().setProject(project).setApi(api).build().toString();
  }

  public static ApiName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_API.validatedMatch(
            formattedString, "ApiName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("api"));
  }

  public static List<ApiName> parseList(List<String> formattedStrings) {
    List<ApiName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApiName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApiName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_API.matches(formattedString);
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
    return PROJECT_API.instantiate("project", project, "api", api);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ApiName that = ((ApiName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.api, that.api);
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
    return h;
  }

  /** Builder for projects/{project}/locations/global/apis/{api}. */
  public static class Builder {
    private String project;
    private String api;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getApi() {
      return api;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setApi(String api) {
      this.api = api;
      return this;
    }

    private Builder(ApiName apiName) {
      this.project = apiName.project;
      this.api = apiName.api;
    }

    public ApiName build() {
      return new ApiName(this);
    }
  }
}
