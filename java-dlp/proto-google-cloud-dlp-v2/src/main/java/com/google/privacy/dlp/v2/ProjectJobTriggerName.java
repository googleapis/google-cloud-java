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

package com.google.privacy.dlp.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProjectJobTriggerName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/jobTriggers/{job_trigger}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String jobTrigger;

  public String getProject() {
    return project;
  }

  public String getJobTrigger() {
    return jobTrigger;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectJobTriggerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    jobTrigger = Preconditions.checkNotNull(builder.getJobTrigger());
  }

  public static ProjectJobTriggerName of(String project, String jobTrigger) {
    return newBuilder().setProject(project).setJobTrigger(jobTrigger).build();
  }

  public static String format(String project, String jobTrigger) {
    return newBuilder().setProject(project).setJobTrigger(jobTrigger).build().toString();
  }

  public static ProjectJobTriggerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ProjectJobTriggerName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("job_trigger"));
  }

  public static List<ProjectJobTriggerName> parseList(List<String> formattedStrings) {
    List<ProjectJobTriggerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectJobTriggerName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectJobTriggerName value : values) {
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
          fieldMapBuilder.put("jobTrigger", jobTrigger);
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
    return PATH_TEMPLATE.instantiate("project", project, "job_trigger", jobTrigger);
  }

  /** Builder for ProjectJobTriggerName. */
  public static class Builder {

    private String project;
    private String jobTrigger;

    public String getProject() {
      return project;
    }

    public String getJobTrigger() {
      return jobTrigger;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setJobTrigger(String jobTrigger) {
      this.jobTrigger = jobTrigger;
      return this;
    }

    private Builder() {}

    private Builder(ProjectJobTriggerName projectJobTriggerName) {
      project = projectJobTriggerName.project;
      jobTrigger = projectJobTriggerName.jobTrigger;
    }

    public ProjectJobTriggerName build() {
      return new ProjectJobTriggerName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectJobTriggerName) {
      ProjectJobTriggerName that = (ProjectJobTriggerName) o;
      return (this.project.equals(that.project)) && (this.jobTrigger.equals(that.jobTrigger));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= jobTrigger.hashCode();
    return h;
  }
}
