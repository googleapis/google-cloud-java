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

package com.google.cloud.bigquery.datatransfer.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class RunName implements ResourceName {
  private static final PathTemplate PROJECT_TRANSFER_CONFIG_RUN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/transferConfigs/{transfer_config}/runs/{run}");
  private static final PathTemplate PROJECT_LOCATION_TRANSFER_CONFIG_RUN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/transferConfigs/{transfer_config}/runs/{run}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String transferConfig;
  private final String run;
  private final String location;

  @Deprecated
  protected RunName() {
    project = null;
    transferConfig = null;
    run = null;
    location = null;
  }

  private RunName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    transferConfig = Preconditions.checkNotNull(builder.getTransferConfig());
    run = Preconditions.checkNotNull(builder.getRun());
    location = null;
    pathTemplate = PROJECT_TRANSFER_CONFIG_RUN;
  }

  private RunName(ProjectLocationTransferConfigRunBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    transferConfig = Preconditions.checkNotNull(builder.getTransferConfig());
    run = Preconditions.checkNotNull(builder.getRun());
    pathTemplate = PROJECT_LOCATION_TRANSFER_CONFIG_RUN;
  }

  public String getProject() {
    return project;
  }

  public String getTransferConfig() {
    return transferConfig;
  }

  public String getRun() {
    return run;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectTransferConfigRunBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationTransferConfigRunBuilder
      newProjectLocationTransferConfigRunBuilder() {
    return new ProjectLocationTransferConfigRunBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RunName of(String project, String transferConfig, String run) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).setRun(run).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RunName ofProjectTransferConfigRunName(
      String project, String transferConfig, String run) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).setRun(run).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static RunName ofProjectLocationTransferConfigRunName(
      String project, String location, String transferConfig, String run) {
    return newProjectLocationTransferConfigRunBuilder()
        .setProject(project)
        .setLocation(location)
        .setTransferConfig(transferConfig)
        .setRun(run)
        .build();
  }

  public static String format(String project, String transferConfig, String run) {
    return newBuilder()
        .setProject(project)
        .setTransferConfig(transferConfig)
        .setRun(run)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectTransferConfigRunName(
      String project, String transferConfig, String run) {
    return newBuilder()
        .setProject(project)
        .setTransferConfig(transferConfig)
        .setRun(run)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationTransferConfigRunName(
      String project, String location, String transferConfig, String run) {
    return newProjectLocationTransferConfigRunBuilder()
        .setProject(project)
        .setLocation(location)
        .setTransferConfig(transferConfig)
        .setRun(run)
        .build()
        .toString();
  }

  public static RunName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_TRANSFER_CONFIG_RUN.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TRANSFER_CONFIG_RUN.match(formattedString);
      return ofProjectTransferConfigRunName(
          matchMap.get("project"), matchMap.get("transfer_config"), matchMap.get("run"));
    } else if (PROJECT_LOCATION_TRANSFER_CONFIG_RUN.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_TRANSFER_CONFIG_RUN.match(formattedString);
      return ofProjectLocationTransferConfigRunName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("transfer_config"),
          matchMap.get("run"));
    }
    throw new ValidationException("RunName.parse: formattedString not in valid format");
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TRANSFER_CONFIG_RUN.matches(formattedString)
        || PROJECT_LOCATION_TRANSFER_CONFIG_RUN.matches(formattedString);
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
          if (transferConfig != null) {
            fieldMapBuilder.put("transfer_config", transferConfig);
          }
          if (run != null) {
            fieldMapBuilder.put("run", run);
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
      RunName that = ((RunName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.transferConfig, that.transferConfig)
          && Objects.equals(this.run, that.run)
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
    h ^= Objects.hashCode(transferConfig);
    h *= 1000003;
    h ^= Objects.hashCode(run);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/transferConfigs/{transfer_config}/runs/{run}. */
  public static class Builder {
    private String project;
    private String transferConfig;
    private String run;

    protected Builder() {}

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

    private Builder(RunName runName) {
      Preconditions.checkArgument(
          Objects.equals(runName.pathTemplate, PROJECT_TRANSFER_CONFIG_RUN),
          "toBuilder is only supported when RunName has the pattern of projects/{project}/transferConfigs/{transfer_config}/runs/{run}");
      this.project = runName.project;
      this.transferConfig = runName.transferConfig;
      this.run = runName.run;
    }

    public RunName build() {
      return new RunName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/transferConfigs/{transfer_config}/runs/{run}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationTransferConfigRunBuilder {
    private String project;
    private String location;
    private String transferConfig;
    private String run;

    protected ProjectLocationTransferConfigRunBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTransferConfig() {
      return transferConfig;
    }

    public String getRun() {
      return run;
    }

    public ProjectLocationTransferConfigRunBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationTransferConfigRunBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationTransferConfigRunBuilder setTransferConfig(String transferConfig) {
      this.transferConfig = transferConfig;
      return this;
    }

    public ProjectLocationTransferConfigRunBuilder setRun(String run) {
      this.run = run;
      return this;
    }

    public RunName build() {
      return new RunName(this);
    }
  }
}
