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

package com.google.cloud.bigquery.datatransfer.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * AUTO-GENERATED DOCUMENTATION AND CLASS
 *
 * @deprecated This resource name class will be removed in the next major version.
 */
@javax.annotation.Generated("by GAPIC protoc plugin")
@Deprecated
public class ProjectRunName extends RunName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/transferConfigs/{transfer_config}/runs/{run}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String transferConfig;
  private final String run;

  public String getProject() {
    return project;
  }

  public String getTransferConfig() {
    return transferConfig;
  }

  public String getRun() {
    return run;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRunName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    transferConfig = Preconditions.checkNotNull(builder.getTransferConfig());
    run = Preconditions.checkNotNull(builder.getRun());
  }

  public static ProjectRunName of(String project, String transferConfig, String run) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).setRun(run).build();
  }

  public static String format(String project, String transferConfig, String run) {
    return newBuilder()
        .setProject(project)
        .setTransferConfig(transferConfig)
        .setRun(run)
        .build()
        .toString();
  }

  public static ProjectRunName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ProjectRunName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("transfer_config"), matchMap.get("run"));
  }

  public static List<ProjectRunName> parseList(List<String> formattedStrings) {
    List<ProjectRunName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectRunName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectRunName value : values) {
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
          fieldMapBuilder.put("transferConfig", transferConfig);
          fieldMapBuilder.put("run", run);
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
        "project", project, "transfer_config", transferConfig, "run", run);
  }

  /** Builder for ProjectRunName. */
  public static class Builder extends RunName.Builder {

    private String project;
    private String transferConfig;
    private String run;

    public String getProject() {
      return project;
    }

    public String getTransferConfig() {
      return transferConfig;
    }

    public String getRun() {
      return run;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTransferConfig(String transferConfig) {
      this.transferConfig = transferConfig;
      return this;
    }

    public Builder setRun(String run) {
      this.run = run;
      return this;
    }

    private Builder() {}

    private Builder(ProjectRunName projectRunName) {
      project = projectRunName.project;
      transferConfig = projectRunName.transferConfig;
      run = projectRunName.run;
    }

    public ProjectRunName build() {
      return new ProjectRunName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRunName) {
      ProjectRunName that = (ProjectRunName) o;
      return (this.project.equals(that.project))
          && (this.transferConfig.equals(that.transferConfig))
          && (this.run.equals(that.run));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= transferConfig.hashCode();
    h *= 1000003;
    h ^= run.hashCode();
    return h;
  }
}
