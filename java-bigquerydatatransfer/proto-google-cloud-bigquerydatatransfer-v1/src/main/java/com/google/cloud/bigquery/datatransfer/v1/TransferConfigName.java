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
public class TransferConfigName implements ResourceName {
  private static final PathTemplate PROJECT_TRANSFER_CONFIG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/transferConfigs/{transfer_config}");
  private static final PathTemplate PROJECT_LOCATION_TRANSFER_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/transferConfigs/{transfer_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String transferConfig;
  private final String location;

  @Deprecated
  protected TransferConfigName() {
    project = null;
    transferConfig = null;
    location = null;
  }

  private TransferConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    transferConfig = Preconditions.checkNotNull(builder.getTransferConfig());
    location = null;
    pathTemplate = PROJECT_TRANSFER_CONFIG;
  }

  private TransferConfigName(ProjectLocationTransferConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    transferConfig = Preconditions.checkNotNull(builder.getTransferConfig());
    pathTemplate = PROJECT_LOCATION_TRANSFER_CONFIG;
  }

  public String getProject() {
    return project;
  }

  public String getTransferConfig() {
    return transferConfig;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectTransferConfigBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationTransferConfigBuilder newProjectLocationTransferConfigBuilder() {
    return new ProjectLocationTransferConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TransferConfigName of(String project, String transferConfig) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TransferConfigName ofProjectTransferConfigName(
      String project, String transferConfig) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TransferConfigName ofProjectLocationTransferConfigName(
      String project, String location, String transferConfig) {
    return newProjectLocationTransferConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setTransferConfig(transferConfig)
        .build();
  }

  public static String format(String project, String transferConfig) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectTransferConfigName(String project, String transferConfig) {
    return newBuilder().setProject(project).setTransferConfig(transferConfig).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationTransferConfigName(
      String project, String location, String transferConfig) {
    return newProjectLocationTransferConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setTransferConfig(transferConfig)
        .build()
        .toString();
  }

  public static TransferConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_TRANSFER_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TRANSFER_CONFIG.match(formattedString);
      return ofProjectTransferConfigName(matchMap.get("project"), matchMap.get("transfer_config"));
    } else if (PROJECT_LOCATION_TRANSFER_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_TRANSFER_CONFIG.match(formattedString);
      return ofProjectLocationTransferConfigName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("transfer_config"));
    }
    throw new ValidationException("TransferConfigName.parse: formattedString not in valid format");
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TRANSFER_CONFIG.matches(formattedString)
        || PROJECT_LOCATION_TRANSFER_CONFIG.matches(formattedString);
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
      TransferConfigName that = ((TransferConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.transferConfig, that.transferConfig)
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
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/transferConfigs/{transfer_config}. */
  public static class Builder {
    private String project;
    private String transferConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTransferConfig() {
      return transferConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTransferConfig(String transferConfig) {
      this.transferConfig = transferConfig;
      return this;
    }

    private Builder(TransferConfigName transferConfigName) {
      Preconditions.checkArgument(
          Objects.equals(transferConfigName.pathTemplate, PROJECT_TRANSFER_CONFIG),
          "toBuilder is only supported when TransferConfigName has the pattern of projects/{project}/transferConfigs/{transfer_config}");
      project = transferConfigName.project;
      transferConfig = transferConfigName.transferConfig;
    }

    public TransferConfigName build() {
      return new TransferConfigName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/transferConfigs/{transfer_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationTransferConfigBuilder {
    private String project;
    private String location;
    private String transferConfig;

    protected ProjectLocationTransferConfigBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTransferConfig() {
      return transferConfig;
    }

    public ProjectLocationTransferConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationTransferConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationTransferConfigBuilder setTransferConfig(String transferConfig) {
      this.transferConfig = transferConfig;
      return this;
    }

    public TransferConfigName build() {
      return new TransferConfigName(this);
    }
  }
}
