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

package com.google.monitoring.metricsscope.v1;

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
public class MonitoredProjectName implements ResourceName {
  private static final PathTemplate METRICS_SCOPE_PROJECT =
      PathTemplate.createWithoutUrlEncoding(
          "locations/global/metricsScopes/{metrics_scope}/projects/{project}");
  private volatile Map<String, String> fieldValuesMap;
  private final String metricsScope;
  private final String project;

  @Deprecated
  protected MonitoredProjectName() {
    metricsScope = null;
    project = null;
  }

  private MonitoredProjectName(Builder builder) {
    metricsScope = Preconditions.checkNotNull(builder.getMetricsScope());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public String getMetricsScope() {
    return metricsScope;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MonitoredProjectName of(String metricsScope, String project) {
    return newBuilder().setMetricsScope(metricsScope).setProject(project).build();
  }

  public static String format(String metricsScope, String project) {
    return newBuilder().setMetricsScope(metricsScope).setProject(project).build().toString();
  }

  public static MonitoredProjectName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        METRICS_SCOPE_PROJECT.validatedMatch(
            formattedString, "MonitoredProjectName.parse: formattedString not in valid format");
    return of(matchMap.get("metrics_scope"), matchMap.get("project"));
  }

  public static List<MonitoredProjectName> parseList(List<String> formattedStrings) {
    List<MonitoredProjectName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MonitoredProjectName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MonitoredProjectName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return METRICS_SCOPE_PROJECT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (metricsScope != null) {
            fieldMapBuilder.put("metrics_scope", metricsScope);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
    return METRICS_SCOPE_PROJECT.instantiate("metrics_scope", metricsScope, "project", project);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MonitoredProjectName that = ((MonitoredProjectName) o);
      return Objects.equals(this.metricsScope, that.metricsScope)
          && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(metricsScope);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for locations/global/metricsScopes/{metrics_scope}/projects/{project}. */
  public static class Builder {
    private String metricsScope;
    private String project;

    protected Builder() {}

    public String getMetricsScope() {
      return metricsScope;
    }

    public String getProject() {
      return project;
    }

    public Builder setMetricsScope(String metricsScope) {
      this.metricsScope = metricsScope;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder(MonitoredProjectName monitoredProjectName) {
      this.metricsScope = monitoredProjectName.metricsScope;
      this.project = monitoredProjectName.project;
    }

    public MonitoredProjectName build() {
      return new MonitoredProjectName(this);
    }
  }
}
