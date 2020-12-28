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

package com.google.cloud.dataproc.v1beta2;

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
public class WorkflowTemplateName implements ResourceName {
  private static final PathTemplate PROJECT_REGION_WORKFLOW_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/workflowTemplates/{workflow_template}");
  private static final PathTemplate PROJECT_LOCATION_WORKFLOW_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/workflowTemplates/{workflow_template}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String region;
  private final String workflowTemplate;
  private final String location;

  @Deprecated
  protected WorkflowTemplateName() {
    project = null;
    region = null;
    workflowTemplate = null;
    location = null;
  }

  private WorkflowTemplateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    workflowTemplate = Preconditions.checkNotNull(builder.getWorkflowTemplate());
    location = null;
    pathTemplate = PROJECT_REGION_WORKFLOW_TEMPLATE;
  }

  private WorkflowTemplateName(ProjectLocationWorkflowTemplateBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workflowTemplate = Preconditions.checkNotNull(builder.getWorkflowTemplate());
    region = null;
    pathTemplate = PROJECT_LOCATION_WORKFLOW_TEMPLATE;
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getWorkflowTemplate() {
    return workflowTemplate;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectRegionWorkflowTemplateBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationWorkflowTemplateBuilder newProjectLocationWorkflowTemplateBuilder() {
    return new ProjectLocationWorkflowTemplateBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkflowTemplateName of(String project, String region, String workflowTemplate) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setWorkflowTemplate(workflowTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static WorkflowTemplateName ofProjectRegionWorkflowTemplateName(
      String project, String region, String workflowTemplate) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setWorkflowTemplate(workflowTemplate)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static WorkflowTemplateName ofProjectLocationWorkflowTemplateName(
      String project, String location, String workflowTemplate) {
    return newProjectLocationWorkflowTemplateBuilder()
        .setProject(project)
        .setLocation(location)
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

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectRegionWorkflowTemplateName(
      String project, String region, String workflowTemplate) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setWorkflowTemplate(workflowTemplate)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationWorkflowTemplateName(
      String project, String location, String workflowTemplate) {
    return newProjectLocationWorkflowTemplateBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkflowTemplate(workflowTemplate)
        .build()
        .toString();
  }

  public static WorkflowTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_REGION_WORKFLOW_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_REGION_WORKFLOW_TEMPLATE.match(formattedString);
      return ofProjectRegionWorkflowTemplateName(
          matchMap.get("project"), matchMap.get("region"), matchMap.get("workflow_template"));
    } else if (PROJECT_LOCATION_WORKFLOW_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_WORKFLOW_TEMPLATE.match(formattedString);
      return ofProjectLocationWorkflowTemplateName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("workflow_template"));
    }
    throw new ValidationException(
        "WorkflowTemplateName.parse: formattedString not in valid format");
  }

  public static List<WorkflowTemplateName> parseList(List<String> formattedStrings) {
    List<WorkflowTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkflowTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_REGION_WORKFLOW_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_WORKFLOW_TEMPLATE.matches(formattedString);
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
          if (region != null) {
            fieldMapBuilder.put("region", region);
          }
          if (workflowTemplate != null) {
            fieldMapBuilder.put("workflow_template", workflowTemplate);
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
      WorkflowTemplateName that = ((WorkflowTemplateName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.region, that.region)
          && Objects.equals(this.workflowTemplate, that.workflowTemplate)
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
    h ^= Objects.hashCode(region);
    h *= 1000003;
    h ^= Objects.hashCode(workflowTemplate);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/regions/{region}/workflowTemplates/{workflow_template}. */
  public static class Builder {
    private String project;
    private String region;
    private String workflowTemplate;

    protected Builder() {}

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

    private Builder(WorkflowTemplateName workflowTemplateName) {
      Preconditions.checkArgument(
          Objects.equals(workflowTemplateName.pathTemplate, PROJECT_REGION_WORKFLOW_TEMPLATE),
          "toBuilder is only supported when WorkflowTemplateName has the pattern of projects/{project}/regions/{region}/workflowTemplates/{workflow_template}");
      project = workflowTemplateName.project;
      region = workflowTemplateName.region;
      workflowTemplate = workflowTemplateName.workflowTemplate;
    }

    public WorkflowTemplateName build() {
      return new WorkflowTemplateName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/workflowTemplates/{workflow_template}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationWorkflowTemplateBuilder {
    private String project;
    private String location;
    private String workflowTemplate;

    protected ProjectLocationWorkflowTemplateBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getWorkflowTemplate() {
      return workflowTemplate;
    }

    public ProjectLocationWorkflowTemplateBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationWorkflowTemplateBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationWorkflowTemplateBuilder setWorkflowTemplate(String workflowTemplate) {
      this.workflowTemplate = workflowTemplate;
      return this;
    }

    public WorkflowTemplateName build() {
      return new WorkflowTemplateName(this);
    }
  }
}
