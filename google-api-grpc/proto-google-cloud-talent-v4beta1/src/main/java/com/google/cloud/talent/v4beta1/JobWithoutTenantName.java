/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.talent.v4beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class JobWithoutTenantName extends JobName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/jobs/{jobs}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String jobs;

  public String getProject() {
    return project;
  }

  public String getJobs() {
    return jobs;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private JobWithoutTenantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    jobs = Preconditions.checkNotNull(builder.getJobs());
  }

  public static JobWithoutTenantName of(String project, String jobs) {
    return newBuilder().setProject(project).setJobs(jobs).build();
  }

  public static String format(String project, String jobs) {
    return newBuilder().setProject(project).setJobs(jobs).build().toString();
  }

  public static JobWithoutTenantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "JobWithoutTenantName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("jobs"));
  }

  public static List<JobWithoutTenantName> parseList(List<String> formattedStrings) {
    List<JobWithoutTenantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<JobWithoutTenantName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (JobWithoutTenantName value : values) {
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
          fieldMapBuilder.put("jobs", jobs);
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
    return PATH_TEMPLATE.instantiate("project", project, "jobs", jobs);
  }

  /** Builder for JobWithoutTenantName. */
  public static class Builder {

    private String project;
    private String jobs;

    public String getProject() {
      return project;
    }

    public String getJobs() {
      return jobs;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setJobs(String jobs) {
      this.jobs = jobs;
      return this;
    }

    private Builder() {}

    private Builder(JobWithoutTenantName jobWithoutTenantName) {
      project = jobWithoutTenantName.project;
      jobs = jobWithoutTenantName.jobs;
    }

    public JobWithoutTenantName build() {
      return new JobWithoutTenantName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JobWithoutTenantName) {
      JobWithoutTenantName that = (JobWithoutTenantName) o;
      return (this.project.equals(that.project)) && (this.jobs.equals(that.jobs));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= jobs.hashCode();
    return h;
  }
}
