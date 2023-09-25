/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1;

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
public class NasTrialDetailName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_NAS_JOB_NAS_TRIAL_DETAIL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/nasJobs/{nas_job}/nasTrialDetails/{nas_trial_detail}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String nasJob;
  private final String nasTrialDetail;

  @Deprecated
  protected NasTrialDetailName() {
    project = null;
    location = null;
    nasJob = null;
    nasTrialDetail = null;
  }

  private NasTrialDetailName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    nasJob = Preconditions.checkNotNull(builder.getNasJob());
    nasTrialDetail = Preconditions.checkNotNull(builder.getNasTrialDetail());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getNasJob() {
    return nasJob;
  }

  public String getNasTrialDetail() {
    return nasTrialDetail;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NasTrialDetailName of(
      String project, String location, String nasJob, String nasTrialDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNasJob(nasJob)
        .setNasTrialDetail(nasTrialDetail)
        .build();
  }

  public static String format(
      String project, String location, String nasJob, String nasTrialDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNasJob(nasJob)
        .setNasTrialDetail(nasTrialDetail)
        .build()
        .toString();
  }

  public static NasTrialDetailName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_NAS_JOB_NAS_TRIAL_DETAIL.validatedMatch(
            formattedString, "NasTrialDetailName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("nas_job"),
        matchMap.get("nas_trial_detail"));
  }

  public static List<NasTrialDetailName> parseList(List<String> formattedStrings) {
    List<NasTrialDetailName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NasTrialDetailName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NasTrialDetailName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_NAS_JOB_NAS_TRIAL_DETAIL.matches(formattedString);
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
          if (nasJob != null) {
            fieldMapBuilder.put("nas_job", nasJob);
          }
          if (nasTrialDetail != null) {
            fieldMapBuilder.put("nas_trial_detail", nasTrialDetail);
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
    return PROJECT_LOCATION_NAS_JOB_NAS_TRIAL_DETAIL.instantiate(
        "project",
        project,
        "location",
        location,
        "nas_job",
        nasJob,
        "nas_trial_detail",
        nasTrialDetail);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NasTrialDetailName that = ((NasTrialDetailName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.nasJob, that.nasJob)
          && Objects.equals(this.nasTrialDetail, that.nasTrialDetail);
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
    h ^= Objects.hashCode(nasJob);
    h *= 1000003;
    h ^= Objects.hashCode(nasTrialDetail);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/nasJobs/{nas_job}/nasTrialDetails/{nas_trial_detail}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String nasJob;
    private String nasTrialDetail;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getNasJob() {
      return nasJob;
    }

    public String getNasTrialDetail() {
      return nasTrialDetail;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setNasJob(String nasJob) {
      this.nasJob = nasJob;
      return this;
    }

    public Builder setNasTrialDetail(String nasTrialDetail) {
      this.nasTrialDetail = nasTrialDetail;
      return this;
    }

    private Builder(NasTrialDetailName nasTrialDetailName) {
      this.project = nasTrialDetailName.project;
      this.location = nasTrialDetailName.location;
      this.nasJob = nasTrialDetailName.nasJob;
      this.nasTrialDetail = nasTrialDetailName.nasTrialDetail;
    }

    public NasTrialDetailName build() {
      return new NasTrialDetailName(this);
    }
  }
}
