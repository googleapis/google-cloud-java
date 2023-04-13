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

package com.google.privacy.dlp.v2;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class DlpJobName implements ResourceName {
  private static final PathTemplate PROJECT_DLP_JOB =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/dlpJobs/{dlp_job}");
  private static final PathTemplate PROJECT_LOCATION_DLP_JOB =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dlpJobs/{dlp_job}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String dlpJob;
  private final String location;

  @Deprecated
  protected DlpJobName() {
    project = null;
    dlpJob = null;
    location = null;
  }

  private DlpJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    dlpJob = Preconditions.checkNotNull(builder.getDlpJob());
    location = null;
    pathTemplate = PROJECT_DLP_JOB;
  }

  private DlpJobName(ProjectLocationDlpJobBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dlpJob = Preconditions.checkNotNull(builder.getDlpJob());
    pathTemplate = PROJECT_LOCATION_DLP_JOB;
  }

  public String getProject() {
    return project;
  }

  public String getDlpJob() {
    return dlpJob;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectDlpJobBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationDlpJobBuilder newProjectLocationDlpJobBuilder() {
    return new ProjectLocationDlpJobBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DlpJobName of(String project, String dlpJob) {
    return newBuilder().setProject(project).setDlpJob(dlpJob).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DlpJobName ofProjectDlpJobName(String project, String dlpJob) {
    return newBuilder().setProject(project).setDlpJob(dlpJob).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static DlpJobName ofProjectLocationDlpJobName(
      String project, String location, String dlpJob) {
    return newProjectLocationDlpJobBuilder()
        .setProject(project)
        .setLocation(location)
        .setDlpJob(dlpJob)
        .build();
  }

  public static String format(String project, String dlpJob) {
    return newBuilder().setProject(project).setDlpJob(dlpJob).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectDlpJobName(String project, String dlpJob) {
    return newBuilder().setProject(project).setDlpJob(dlpJob).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDlpJobName(
      String project, String location, String dlpJob) {
    return newProjectLocationDlpJobBuilder()
        .setProject(project)
        .setLocation(location)
        .setDlpJob(dlpJob)
        .build()
        .toString();
  }

  public static DlpJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_DLP_JOB.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_DLP_JOB.match(formattedString);
      return ofProjectDlpJobName(matchMap.get("project"), matchMap.get("dlp_job"));
    } else if (PROJECT_LOCATION_DLP_JOB.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DLP_JOB.match(formattedString);
      return ofProjectLocationDlpJobName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("dlp_job"));
    }
    throw new ValidationException("DlpJobName.parse: formattedString not in valid format");
  }

  public static List<DlpJobName> parseList(List<String> formattedStrings) {
    List<DlpJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DlpJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DlpJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DLP_JOB.matches(formattedString)
        || PROJECT_LOCATION_DLP_JOB.matches(formattedString);
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
          if (dlpJob != null) {
            fieldMapBuilder.put("dlp_job", dlpJob);
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DlpJobName that = ((DlpJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.dlpJob, that.dlpJob)
          && Objects.equals(this.location, that.location);
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
    h ^= Objects.hashCode(dlpJob);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/dlpJobs/{dlp_job}. */
  public static class Builder {
    private String project;
    private String dlpJob;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDlpJob() {
      return dlpJob;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDlpJob(String dlpJob) {
      this.dlpJob = dlpJob;
      return this;
    }

    private Builder(DlpJobName dlpJobName) {
      Preconditions.checkArgument(
          Objects.equals(dlpJobName.pathTemplate, PROJECT_DLP_JOB),
          "toBuilder is only supported when DlpJobName has the pattern of projects/{project}/dlpJobs/{dlp_job}");
      this.project = dlpJobName.project;
      this.dlpJob = dlpJobName.dlpJob;
    }

    public DlpJobName build() {
      return new DlpJobName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/dlpJobs/{dlp_job}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationDlpJobBuilder {
    private String project;
    private String location;
    private String dlpJob;

    protected ProjectLocationDlpJobBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDlpJob() {
      return dlpJob;
    }

    public ProjectLocationDlpJobBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationDlpJobBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationDlpJobBuilder setDlpJob(String dlpJob) {
      this.dlpJob = dlpJob;
      return this;
    }

    public DlpJobName build() {
      return new DlpJobName(this);
    }
  }
}
