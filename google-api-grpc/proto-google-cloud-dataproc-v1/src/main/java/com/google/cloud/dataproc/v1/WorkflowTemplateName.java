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

package com.google.cloud.dataproc.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class WorkflowTemplateName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/workflowTemplates/{workflow_template}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String region;
  private final String workflowTemplate;

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getWorkflowTemplate() {
    return workflowTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private WorkflowTemplateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    workflowTemplate = Preconditions.checkNotNull(builder.getWorkflowTemplate());
  }

  public static WorkflowTemplateName of(String project, String region, String workflowTemplate) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setWorkflowTemplate(workflowTemplate)
        .build();
  }

  public static String format(String project, String region, String workflowTemplate) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setWorkflowTemplate(workflowTemplate)
        .build()
        .toString();
  }

  public static WorkflowTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "WorkflowTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("region"), matchMap.get("workflow_template"));
  }

  public static List<WorkflowTemplateName> parseList(List<String> formattedStrings) {
    List<WorkflowTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkflowTemplateName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (WorkflowTemplateName value : values) {
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
          fieldMapBuilder.put("region", region);
          fieldMapBuilder.put("workflowTemplate", workflowTemplate);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "region", region, "workflow_template", workflowTemplate);
  }

  /** Builder for WorkflowTemplateName. */
  public static class Builder {

    private String project;
    private String region;
    private String workflowTemplate;

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getWorkflowTemplate() {
      return workflowTemplate;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public Builder setWorkflowTemplate(String workflowTemplate) {
      this.workflowTemplate = workflowTemplate;
      return this;
    }

    private Builder() {}

    private Builder(WorkflowTemplateName workflowTemplateName) {
      project = workflowTemplateName.project;
      region = workflowTemplateName.region;
      workflowTemplate = workflowTemplateName.workflowTemplate;
    }

    public WorkflowTemplateName build() {
      return new WorkflowTemplateName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof WorkflowTemplateName) {
      WorkflowTemplateName that = (WorkflowTemplateName) o;
      return (this.project.equals(that.project))
          && (this.region.equals(that.region))
          && (this.workflowTemplate.equals(that.workflowTemplate));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= region.hashCode();
    h *= 1000003;
    h ^= workflowTemplate.hashCode();
    return h;
  }
}
