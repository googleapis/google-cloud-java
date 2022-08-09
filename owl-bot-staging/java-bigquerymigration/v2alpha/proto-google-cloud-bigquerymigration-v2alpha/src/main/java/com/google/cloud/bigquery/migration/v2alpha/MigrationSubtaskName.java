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

package com.google.cloud.bigquery.migration.v2alpha;

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
public class MigrationSubtaskName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_WORKFLOW_SUBTASK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/workflows/{workflow}/subtasks/{subtask}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workflow;
  private final String subtask;

  @Deprecated
  protected MigrationSubtaskName() {
    project = null;
    location = null;
    workflow = null;
    subtask = null;
  }

  private MigrationSubtaskName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workflow = Preconditions.checkNotNull(builder.getWorkflow());
    subtask = Preconditions.checkNotNull(builder.getSubtask());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getWorkflow() {
    return workflow;
  }

  public String getSubtask() {
    return subtask;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MigrationSubtaskName of(
      String project, String location, String workflow, String subtask) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkflow(workflow)
        .setSubtask(subtask)
        .build();
  }

  public static String format(String project, String location, String workflow, String subtask) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkflow(workflow)
        .setSubtask(subtask)
        .build()
        .toString();
  }

  public static MigrationSubtaskName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKFLOW_SUBTASK.validatedMatch(
            formattedString, "MigrationSubtaskName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("workflow"),
        matchMap.get("subtask"));
  }

  public static List<MigrationSubtaskName> parseList(List<String> formattedStrings) {
    List<MigrationSubtaskName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MigrationSubtaskName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MigrationSubtaskName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKFLOW_SUBTASK.matches(formattedString);
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
          if (workflow != null) {
            fieldMapBuilder.put("workflow", workflow);
          }
          if (subtask != null) {
            fieldMapBuilder.put("subtask", subtask);
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
    return PROJECT_LOCATION_WORKFLOW_SUBTASK.instantiate(
        "project", project, "location", location, "workflow", workflow, "subtask", subtask);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MigrationSubtaskName that = ((MigrationSubtaskName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workflow, that.workflow)
          && Objects.equals(this.subtask, that.subtask);
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
    h ^= Objects.hashCode(workflow);
    h *= 1000003;
    h ^= Objects.hashCode(subtask);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/workflows/{workflow}/subtasks/{subtask}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String workflow;
    private String subtask;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getWorkflow() {
      return workflow;
    }

    public String getSubtask() {
      return subtask;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setWorkflow(String workflow) {
      this.workflow = workflow;
      return this;
    }

    public Builder setSubtask(String subtask) {
      this.subtask = subtask;
      return this;
    }

    private Builder(MigrationSubtaskName migrationSubtaskName) {
      this.project = migrationSubtaskName.project;
      this.location = migrationSubtaskName.location;
      this.workflow = migrationSubtaskName.workflow;
      this.subtask = migrationSubtaskName.subtask;
    }

    public MigrationSubtaskName build() {
      return new MigrationSubtaskName(this);
    }
  }
}
