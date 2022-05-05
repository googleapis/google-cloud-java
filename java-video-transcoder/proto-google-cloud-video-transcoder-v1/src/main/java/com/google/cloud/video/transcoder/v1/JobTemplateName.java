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

package com.google.cloud.video.transcoder.v1;

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
public class JobTemplateName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_JOB_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/jobTemplates/{job_template}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String jobTemplate;

  @Deprecated
  protected JobTemplateName() {
    project = null;
    location = null;
    jobTemplate = null;
  }

  private JobTemplateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    jobTemplate = Preconditions.checkNotNull(builder.getJobTemplate());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getJobTemplate() {
    return jobTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static JobTemplateName of(String project, String location, String jobTemplate) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJobTemplate(jobTemplate)
        .build();
  }

  public static String format(String project, String location, String jobTemplate) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJobTemplate(jobTemplate)
        .build()
        .toString();
  }

  public static JobTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_JOB_TEMPLATE.validatedMatch(
            formattedString, "JobTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("job_template"));
  }

  public static List<JobTemplateName> parseList(List<String> formattedStrings) {
    List<JobTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<JobTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (JobTemplateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_JOB_TEMPLATE.matches(formattedString);
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
          if (jobTemplate != null) {
            fieldMapBuilder.put("job_template", jobTemplate);
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
    return PROJECT_LOCATION_JOB_TEMPLATE.instantiate(
        "project", project, "location", location, "job_template", jobTemplate);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      JobTemplateName that = ((JobTemplateName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.jobTemplate, that.jobTemplate);
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
    h ^= Objects.hashCode(jobTemplate);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/jobTemplates/{job_template}. */
  public static class Builder {
    private String project;
    private String location;
    private String jobTemplate;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getJobTemplate() {
      return jobTemplate;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setJobTemplate(String jobTemplate) {
      this.jobTemplate = jobTemplate;
      return this;
    }

    private Builder(JobTemplateName jobTemplateName) {
      this.project = jobTemplateName.project;
      this.location = jobTemplateName.location;
      this.jobTemplate = jobTemplateName.jobTemplate;
    }

    public JobTemplateName build() {
      return new JobTemplateName(this);
    }
  }
}
