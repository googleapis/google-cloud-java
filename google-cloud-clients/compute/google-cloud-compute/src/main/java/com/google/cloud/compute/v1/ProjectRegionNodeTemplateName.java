/*
 * Copyright 2019 Google LLC
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
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectRegionNodeTemplateName implements ResourceName {
  private final String nodeTemplate;
  private final String project;
  private final String region;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "{project}/regions/{region}/nodeTemplates/{nodeTemplate}");

  public static final String SERVICE_ADDRESS =
      "https://compute.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionNodeTemplateName(Builder builder) {
    nodeTemplate = Preconditions.checkNotNull(builder.getNodeTemplate());
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public static ProjectRegionNodeTemplateName of(
      String nodeTemplate, String project, String region) {
    return newBuilder().setNodeTemplate(nodeTemplate).setProject(project).setRegion(region).build();
  }

  public static String format(String nodeTemplate, String project, String region) {
    return of(nodeTemplate, project, region).toString();
  }

  public String getNodeTemplate() {
    return nodeTemplate;
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("nodeTemplate", nodeTemplate);
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("region", region);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectRegionNodeTemplateName> newFactory() {
    return new ResourceNameFactory<ProjectRegionNodeTemplateName>() {
      public ProjectRegionNodeTemplateName parse(String formattedString) {
        return ProjectRegionNodeTemplateName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionNodeTemplateName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath,
            "ProjectRegionNodeTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("nodeTemplate"), matchMap.get("project"), matchMap.get("region"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String nodeTemplate;
    private String project;
    private String region;

    public String getNodeTemplate() {
      return nodeTemplate;
    }

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public Builder setNodeTemplate(String nodeTemplate) {
      this.nodeTemplate = nodeTemplate;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    private Builder() {}

    public Builder(ProjectRegionNodeTemplateName projectRegionNodeTemplateName) {
      nodeTemplate = projectRegionNodeTemplateName.nodeTemplate;
      project = projectRegionNodeTemplateName.project;
      region = projectRegionNodeTemplateName.region;
    }

    public ProjectRegionNodeTemplateName build() {
      return new ProjectRegionNodeTemplateName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "nodeTemplate", nodeTemplate,
            "project", project,
            "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionNodeTemplateName) {
      ProjectRegionNodeTemplateName that = (ProjectRegionNodeTemplateName) o;
      return Objects.equals(this.nodeTemplate, that.getNodeTemplate())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeTemplate, project, region);
  }
}
