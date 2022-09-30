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

package com.google.recaptchaenterprise.v1;

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
public class MetricsName implements ResourceName {
  private static final PathTemplate PROJECT_KEY =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/keys/{key}/metrics");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String key;

  @Deprecated
  protected MetricsName() {
    project = null;
    key = null;
  }

  private MetricsName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    key = Preconditions.checkNotNull(builder.getKey());
  }

  public String getProject() {
    return project;
  }

  public String getKey() {
    return key;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MetricsName of(String project, String key) {
    return newBuilder().setProject(project).setKey(key).build();
  }

  public static String format(String project, String key) {
    return newBuilder().setProject(project).setKey(key).build().toString();
  }

  public static MetricsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_KEY.validatedMatch(
            formattedString, "MetricsName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("key"));
  }

  public static List<MetricsName> parseList(List<String> formattedStrings) {
    List<MetricsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetricsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MetricsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_KEY.matches(formattedString);
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
          if (key != null) {
            fieldMapBuilder.put("key", key);
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
    return PROJECT_KEY.instantiate("project", project, "key", key);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MetricsName that = ((MetricsName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.key, that.key);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(key);
    return h;
  }

  /** Builder for projects/{project}/keys/{key}/metrics. */
  public static class Builder {
    private String project;
    private String key;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getKey() {
      return key;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    private Builder(MetricsName metricsName) {
      this.project = metricsName.project;
      this.key = metricsName.key;
    }

    public MetricsName build() {
      return new MetricsName(this);
    }
  }
}
