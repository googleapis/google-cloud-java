/*
 * Copyright 2020 Google LLC
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
public class TrialName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_STUDY_TRIAL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/studies/{study}/trials/{trial}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String study;
  private final String trial;

  @Deprecated
  protected TrialName() {
    project = null;
    location = null;
    study = null;
    trial = null;
  }

  private TrialName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    study = Preconditions.checkNotNull(builder.getStudy());
    trial = Preconditions.checkNotNull(builder.getTrial());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getStudy() {
    return study;
  }

  public String getTrial() {
    return trial;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TrialName of(String project, String location, String study, String trial) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStudy(study)
        .setTrial(trial)
        .build();
  }

  public static String format(String project, String location, String study, String trial) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setStudy(study)
        .setTrial(trial)
        .build()
        .toString();
  }

  public static TrialName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_STUDY_TRIAL.validatedMatch(
            formattedString, "TrialName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("study"),
        matchMap.get("trial"));
  }

  public static List<TrialName> parseList(List<String> formattedStrings) {
    List<TrialName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TrialName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TrialName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_STUDY_TRIAL.matches(formattedString);
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
          if (study != null) {
            fieldMapBuilder.put("study", study);
          }
          if (trial != null) {
            fieldMapBuilder.put("trial", trial);
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
    return PROJECT_LOCATION_STUDY_TRIAL.instantiate(
        "project", project, "location", location, "study", study, "trial", trial);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TrialName that = ((TrialName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.study, that.study)
          && Objects.equals(this.trial, that.trial);
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
    h ^= Objects.hashCode(study);
    h *= 1000003;
    h ^= Objects.hashCode(trial);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/studies/{study}/trials/{trial}. */
  public static class Builder {
    private String project;
    private String location;
    private String study;
    private String trial;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getStudy() {
      return study;
    }

    public String getTrial() {
      return trial;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setStudy(String study) {
      this.study = study;
      return this;
    }

    public Builder setTrial(String trial) {
      this.trial = trial;
      return this;
    }

    private Builder(TrialName trialName) {
      project = trialName.project;
      location = trialName.location;
      study = trialName.study;
      trial = trialName.trial;
    }

    public TrialName build() {
      return new TrialName(this);
    }
  }
}
