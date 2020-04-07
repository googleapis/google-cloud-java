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

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class JobTriggerName implements ResourceName {

  @Deprecated
  protected JobTriggerName() {}

  private static final PathTemplate PROJECT_JOB_TRIGGER_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/jobTriggers/{job_trigger}");
  private static final PathTemplate PROJECT_LOCATION_JOB_TRIGGER_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/jobTriggers/{job_trigger}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String jobTrigger;
  private String location;

  public String getProject() {
    return project;
  }

  public String getJobTrigger() {
    return jobTrigger;
  }

  public String getLocation() {
    return location;
  }

  private JobTriggerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    jobTrigger = Preconditions.checkNotNull(builder.getJobTrigger());
    pathTemplate = PROJECT_JOB_TRIGGER_PATH_TEMPLATE;
  }

  private JobTriggerName(ProjectLocationJobTriggerBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    jobTrigger = Preconditions.checkNotNull(builder.getJobTrigger());
    pathTemplate = PROJECT_LOCATION_JOB_TRIGGER_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectJobTriggerBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationJobTriggerBuilder newProjectLocationJobTriggerBuilder() {
    return new ProjectLocationJobTriggerBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static JobTriggerName of(String project, String jobTrigger) {
    return newProjectJobTriggerBuilder().setProject(project).setJobTrigger(jobTrigger).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static JobTriggerName ofProjectJobTriggerName(String project, String jobTrigger) {
    return newProjectJobTriggerBuilder().setProject(project).setJobTrigger(jobTrigger).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static JobTriggerName ofProjectLocationJobTriggerName(
      String project, String location, String jobTrigger) {
    return newProjectLocationJobTriggerBuilder()
        .setProject(project)
        .setLocation(location)
        .setJobTrigger(jobTrigger)
        .build();
  }

  public static String format(String project, String jobTrigger) {
    return newBuilder().setProject(project).setJobTrigger(jobTrigger).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectJobTriggerName(String project, String jobTrigger) {
    return newBuilder().setProject(project).setJobTrigger(jobTrigger).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationJobTriggerName(
      String project, String location, String jobTrigger) {
    return newProjectLocationJobTriggerBuilder()
        .setProject(project)
        .setLocation(location)
        .setJobTrigger(jobTrigger)
        .build()
        .toString();
  }

  public static JobTriggerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_JOB_TRIGGER_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_JOB_TRIGGER_PATH_TEMPLATE.match(formattedString);
      return ofProjectJobTriggerName(matchMap.get("project"), matchMap.get("job_trigger"));
    } else if (PROJECT_LOCATION_JOB_TRIGGER_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_JOB_TRIGGER_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationJobTriggerName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("job_trigger"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_JOB_TRIGGER_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_JOB_TRIGGER_PATH_TEMPLATE.matches(formattedString);
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
          if (jobTrigger != null) {
            fieldMapBuilder.put("job_trigger", jobTrigger);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  /** Builder for projects/{project}/jobTriggers/{job_trigger}. */
  public static class Builder {

    private String project;
    private String jobTrigger;

    protected Builder() {}

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

    private Builder(JobTriggerName jobTriggerName) {
      Preconditions.checkArgument(
          jobTriggerName.pathTemplate == PROJECT_JOB_TRIGGER_PATH_TEMPLATE,
          "toBuilder is only supported when JobTriggerName has the pattern of "
              + "projects/{project}/jobTriggers/{job_trigger}.");
      project = jobTriggerName.project;
      jobTrigger = jobTriggerName.jobTrigger;
    }

    public JobTriggerName build() {
      return new JobTriggerName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/jobTriggers/{job_trigger}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationJobTriggerBuilder {

    private String project;
    private String location;
    private String jobTrigger;

    private ProjectLocationJobTriggerBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getJobTrigger() {
      return jobTrigger;
    }

    public ProjectLocationJobTriggerBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationJobTriggerBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationJobTriggerBuilder setJobTrigger(String jobTrigger) {
      this.jobTrigger = jobTrigger;
      return this;
    }

    public JobTriggerName build() {
      return new JobTriggerName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      JobTriggerName that = (JobTriggerName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.jobTrigger, that.jobTrigger))
          && (Objects.equals(this.location, that.location));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(jobTrigger);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }
}
