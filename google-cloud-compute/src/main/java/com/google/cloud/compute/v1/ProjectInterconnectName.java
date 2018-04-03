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
public final class ProjectInterconnectName implements com.google.api.resourcenames.ResourceName {
  private final String interconnect;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/interconnects/{interconnect}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectInterconnectName(Builder builder) {
    interconnect = Preconditions.checkNotNull(builder.getInterconnect());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectInterconnectName of(
      String interconnect,
      String project
      ) {
    return newBuilder()
    .setInterconnect(interconnect)
    .setProject(project)
      .build();
  }

  public static String format(
      String interconnect,
      String project
      ) {
    return of(
        interconnect,
        project
        )
        .toString();
  }

  public String getInterconnect() {
    return interconnect;
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
          fieldMapBuilder.put("interconnect", interconnect);
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


  public static ResourceNameFactory<ProjectInterconnectName> newFactory() {
    return new ResourceNameFactory<ProjectInterconnectName>() {
      public ProjectInterconnectName parse(String formattedString) {return ProjectInterconnectName.parse(formattedString);}
    };
  }

  public static ProjectInterconnectName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectInterconnectName.parse: formattedString not in valid format");
    return of(
      matchMap.get("interconnect"),
      matchMap.get("project")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String interconnect;
    private String project;

    public String getInterconnect() {
      return interconnect;
    }
    public String getProject() {
      return project;
    }

    public Builder setInterconnect(String interconnect) {
      this.interconnect = interconnect;
      return this;
    }
    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder (ProjectInterconnectName projectInterconnectName) {
      interconnect = projectInterconnectName.interconnect;
      project = projectInterconnectName.project;
    }

    public ProjectInterconnectName build() {
      return new ProjectInterconnectName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "interconnect", interconnect,
        "project", project
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectInterconnectName) {
      ProjectInterconnectName that = (ProjectInterconnectName) o;
      return
          Objects.equals(this.interconnect, that.getInterconnect()) &&
          Objects.equals(this.project, that.getProject())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      interconnect,
      project
    );
  }
}
