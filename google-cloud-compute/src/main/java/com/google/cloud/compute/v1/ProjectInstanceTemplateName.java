/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectInstanceTemplateName implements com.google.api.resourcenames.ResourceName {
  private final String instanceTemplate;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/instanceTemplates/{instanceTemplate}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectInstanceTemplateName(Builder builder) {
    instanceTemplate = Preconditions.checkNotNull(builder.getInstanceTemplate());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectInstanceTemplateName of(
      String instanceTemplate,
      String project
      ) {
    return newBuilder()
    .setInstanceTemplate(instanceTemplate)
    .setProject(project)
      .build();
  }

  public static String format(
      String instanceTemplate,
      String project
      ) {
    return of(
        instanceTemplate,
        project
        )
        .toString();
  }

  public String getInstanceTemplate() {
    return instanceTemplate;
  }

  public String getProject() {
    return project;
  }


  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("instanceTemplate", instanceTemplate);
          fieldMapBuilder.put("project", project);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }


  public static ResourceNameFactory<ProjectInstanceTemplateName> newFactory() {
    return new ResourceNameFactory<ProjectInstanceTemplateName>() {
      public ProjectInstanceTemplateName parse(String formattedString) {return ProjectInstanceTemplateName.parse(formattedString);}
    };
  }

  public static ProjectInstanceTemplateName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectInstanceTemplateName.parse: formattedString not in valid format");
    return of(
      matchMap.get("instanceTemplate"),
      matchMap.get("project")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String instanceTemplate;
    private String project;

    public String getInstanceTemplate() {
      return instanceTemplate;
    }
    public String getProject() {
      return project;
    }

    public Builder setInstanceTemplate(String instanceTemplate) {
      this.instanceTemplate = instanceTemplate;
      return this;
    }
    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder (ProjectInstanceTemplateName projectInstanceTemplateName) {
      instanceTemplate = projectInstanceTemplateName.instanceTemplate;
      project = projectInstanceTemplateName.project;
    }

    public ProjectInstanceTemplateName build() {
      return new ProjectInstanceTemplateName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "instanceTemplate", instanceTemplate,
        "project", project
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectInstanceTemplateName) {
      ProjectInstanceTemplateName that = (ProjectInstanceTemplateName) o;
      return
          Objects.equals(this.instanceTemplate, that.getInstanceTemplate()) &&
          Objects.equals(this.project, that.getProject())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      instanceTemplate,
      project
    );
  }
}
