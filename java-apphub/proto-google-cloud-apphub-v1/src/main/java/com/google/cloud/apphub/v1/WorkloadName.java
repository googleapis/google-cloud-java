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

package com.google.cloud.apphub.v1;

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
public class WorkloadName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_APPLICATION_WORKLOAD =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/applications/{application}/workloads/{workload}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String application;
  private final String workload;

  @Deprecated
  protected WorkloadName() {
    project = null;
    location = null;
    application = null;
    workload = null;
  }

  private WorkloadName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    application = Preconditions.checkNotNull(builder.getApplication());
    workload = Preconditions.checkNotNull(builder.getWorkload());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApplication() {
    return application;
  }

  public String getWorkload() {
    return workload;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkloadName of(
      String project, String location, String application, String workload) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApplication(application)
        .setWorkload(workload)
        .build();
  }

  public static String format(
      String project, String location, String application, String workload) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApplication(application)
        .setWorkload(workload)
        .build()
        .toString();
  }

  public static WorkloadName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_APPLICATION_WORKLOAD.validatedMatch(
            formattedString, "WorkloadName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("application"),
        matchMap.get("workload"));
  }

  public static List<WorkloadName> parseList(List<String> formattedStrings) {
    List<WorkloadName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkloadName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkloadName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_APPLICATION_WORKLOAD.matches(formattedString);
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
          if (application != null) {
            fieldMapBuilder.put("application", application);
          }
          if (workload != null) {
            fieldMapBuilder.put("workload", workload);
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
    return PROJECT_LOCATION_APPLICATION_WORKLOAD.instantiate(
        "project", project, "location", location, "application", application, "workload", workload);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WorkloadName that = ((WorkloadName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.application, that.application)
          && Objects.equals(this.workload, that.workload);
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
    h ^= Objects.hashCode(application);
    h *= 1000003;
    h ^= Objects.hashCode(workload);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/applications/{application}/workloads/{workload}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String application;
    private String workload;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApplication() {
      return application;
    }

    public String getWorkload() {
      return workload;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApplication(String application) {
      this.application = application;
      return this;
    }

    public Builder setWorkload(String workload) {
      this.workload = workload;
      return this;
    }

    private Builder(WorkloadName workloadName) {
      this.project = workloadName.project;
      this.location = workloadName.location;
      this.application = workloadName.application;
      this.workload = workloadName.workload;
    }

    public WorkloadName build() {
      return new WorkloadName(this);
    }
  }
}
