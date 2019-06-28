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

package com.google.cloud.datalabeling.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class EvaluationJobName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/evaluationJobs/{evaluation_job}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String evaluationJob;

  public String getProject() {
    return project;
  }

  public String getEvaluationJob() {
    return evaluationJob;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private EvaluationJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    evaluationJob = Preconditions.checkNotNull(builder.getEvaluationJob());
  }

  public static EvaluationJobName of(String project, String evaluationJob) {
    return newBuilder().setProject(project).setEvaluationJob(evaluationJob).build();
  }

  public static String format(String project, String evaluationJob) {
    return newBuilder().setProject(project).setEvaluationJob(evaluationJob).build().toString();
  }

  public static EvaluationJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "EvaluationJobName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("evaluation_job"));
  }

  public static List<EvaluationJobName> parseList(List<String> formattedStrings) {
    List<EvaluationJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EvaluationJobName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (EvaluationJobName value : values) {
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
          fieldMapBuilder.put("evaluationJob", evaluationJob);
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
    return PATH_TEMPLATE.instantiate("project", project, "evaluation_job", evaluationJob);
  }

  /** Builder for EvaluationJobName. */
  public static class Builder {

    private String project;
    private String evaluationJob;

    public String getProject() {
      return project;
    }

    public String getEvaluationJob() {
      return evaluationJob;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setEvaluationJob(String evaluationJob) {
      this.evaluationJob = evaluationJob;
      return this;
    }

    private Builder() {}

    private Builder(EvaluationJobName evaluationJobName) {
      project = evaluationJobName.project;
      evaluationJob = evaluationJobName.evaluationJob;
    }

    public EvaluationJobName build() {
      return new EvaluationJobName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EvaluationJobName) {
      EvaluationJobName that = (EvaluationJobName) o;
      return (this.project.equals(that.project)) && (this.evaluationJob.equals(that.evaluationJob));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= evaluationJob.hashCode();
    return h;
  }
}
