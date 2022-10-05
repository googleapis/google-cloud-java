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

package com.google.cloud.deploy.v1;

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
public class JobRunName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DELIVERY_PIPELINE_RELEASE_ROLLOUT_JOB_RUN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/releases/{release}/rollouts/{rollout}/jobRuns/{job_run}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String deliveryPipeline;
  private final String release;
  private final String rollout;
  private final String jobRun;

  @Deprecated
  protected JobRunName() {
    project = null;
    location = null;
    deliveryPipeline = null;
    release = null;
    rollout = null;
    jobRun = null;
  }

  private JobRunName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    deliveryPipeline = Preconditions.checkNotNull(builder.getDeliveryPipeline());
    release = Preconditions.checkNotNull(builder.getRelease());
    rollout = Preconditions.checkNotNull(builder.getRollout());
    jobRun = Preconditions.checkNotNull(builder.getJobRun());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDeliveryPipeline() {
    return deliveryPipeline;
  }

  public String getRelease() {
    return release;
  }

  public String getRollout() {
    return rollout;
  }

  public String getJobRun() {
    return jobRun;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static JobRunName of(
      String project,
      String location,
      String deliveryPipeline,
      String release,
      String rollout,
      String jobRun) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeliveryPipeline(deliveryPipeline)
        .setRelease(release)
        .setRollout(rollout)
        .setJobRun(jobRun)
        .build();
  }

  public static String format(
      String project,
      String location,
      String deliveryPipeline,
      String release,
      String rollout,
      String jobRun) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeliveryPipeline(deliveryPipeline)
        .setRelease(release)
        .setRollout(rollout)
        .setJobRun(jobRun)
        .build()
        .toString();
  }

  public static JobRunName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DELIVERY_PIPELINE_RELEASE_ROLLOUT_JOB_RUN.validatedMatch(
            formattedString, "JobRunName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("delivery_pipeline"),
        matchMap.get("release"),
        matchMap.get("rollout"),
        matchMap.get("job_run"));
  }

  public static List<JobRunName> parseList(List<String> formattedStrings) {
    List<JobRunName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<JobRunName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (JobRunName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DELIVERY_PIPELINE_RELEASE_ROLLOUT_JOB_RUN.matches(formattedString);
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
          if (deliveryPipeline != null) {
            fieldMapBuilder.put("delivery_pipeline", deliveryPipeline);
          }
          if (release != null) {
            fieldMapBuilder.put("release", release);
          }
          if (rollout != null) {
            fieldMapBuilder.put("rollout", rollout);
          }
          if (jobRun != null) {
            fieldMapBuilder.put("job_run", jobRun);
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
    return PROJECT_LOCATION_DELIVERY_PIPELINE_RELEASE_ROLLOUT_JOB_RUN.instantiate(
        "project",
        project,
        "location",
        location,
        "delivery_pipeline",
        deliveryPipeline,
        "release",
        release,
        "rollout",
        rollout,
        "job_run",
        jobRun);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      JobRunName that = ((JobRunName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.deliveryPipeline, that.deliveryPipeline)
          && Objects.equals(this.release, that.release)
          && Objects.equals(this.rollout, that.rollout)
          && Objects.equals(this.jobRun, that.jobRun);
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
    h ^= Objects.hashCode(deliveryPipeline);
    h *= 1000003;
    h ^= Objects.hashCode(release);
    h *= 1000003;
    h ^= Objects.hashCode(rollout);
    h *= 1000003;
    h ^= Objects.hashCode(jobRun);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/releases/{release}/rollouts/{rollout}/jobRuns/{job_run}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String deliveryPipeline;
    private String release;
    private String rollout;
    private String jobRun;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDeliveryPipeline() {
      return deliveryPipeline;
    }

    public String getRelease() {
      return release;
    }

    public String getRollout() {
      return rollout;
    }

    public String getJobRun() {
      return jobRun;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDeliveryPipeline(String deliveryPipeline) {
      this.deliveryPipeline = deliveryPipeline;
      return this;
    }

    public Builder setRelease(String release) {
      this.release = release;
      return this;
    }

    public Builder setRollout(String rollout) {
      this.rollout = rollout;
      return this;
    }

    public Builder setJobRun(String jobRun) {
      this.jobRun = jobRun;
      return this;
    }

    private Builder(JobRunName jobRunName) {
      this.project = jobRunName.project;
      this.location = jobRunName.location;
      this.deliveryPipeline = jobRunName.deliveryPipeline;
      this.release = jobRunName.release;
      this.rollout = jobRunName.rollout;
      this.jobRun = jobRunName.jobRun;
    }

    public JobRunName build() {
      return new JobRunName(this);
    }
  }
}
