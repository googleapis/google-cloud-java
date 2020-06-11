/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.monitoring.dashboard.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class DashboardName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/dashboards/{dashboard}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String dashboard;

  public String getProject() {
    return project;
  }

  public String getDashboard() {
    return dashboard;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private DashboardName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    dashboard = Preconditions.checkNotNull(builder.getDashboard());
  }

  public static DashboardName of(String project, String dashboard) {
    return newBuilder().setProject(project).setDashboard(dashboard).build();
  }

  public static String format(String project, String dashboard) {
    return newBuilder().setProject(project).setDashboard(dashboard).build().toString();
  }

  public static DashboardName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "DashboardName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("dashboard"));
  }

  public static List<DashboardName> parseList(List<String> formattedStrings) {
    List<DashboardName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DashboardName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (DashboardName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("dashboard", dashboard);
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
    return PATH_TEMPLATE.instantiate("project", project, "dashboard", dashboard);
  }

  /** Builder for DashboardName. */
  public static class Builder {

    private String project;
    private String dashboard;

    public String getProject() {
      return project;
    }

    public String getDashboard() {
      return dashboard;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDashboard(String dashboard) {
      this.dashboard = dashboard;
      return this;
    }

    private Builder() {}

    private Builder(DashboardName dashboardName) {
      project = dashboardName.project;
      dashboard = dashboardName.dashboard;
    }

    public DashboardName build() {
      return new DashboardName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DashboardName) {
      DashboardName that = (DashboardName) o;
      return (this.project.equals(that.project)) && (this.dashboard.equals(that.dashboard));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= dashboard.hashCode();
    return h;
  }
}
