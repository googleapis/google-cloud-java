/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.networkmanagement.v1;

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
public class VpcFlowLogsConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/vpcFlowLogsConfigs/{vpc_flow_logs_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String vpcFlowLogsConfig;

  @Deprecated
  protected VpcFlowLogsConfigName() {
    project = null;
    location = null;
    vpcFlowLogsConfig = null;
  }

  private VpcFlowLogsConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    vpcFlowLogsConfig = Preconditions.checkNotNull(builder.getVpcFlowLogsConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getVpcFlowLogsConfig() {
    return vpcFlowLogsConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VpcFlowLogsConfigName of(
      String project, String location, String vpcFlowLogsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVpcFlowLogsConfig(vpcFlowLogsConfig)
        .build();
  }

  public static String format(String project, String location, String vpcFlowLogsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVpcFlowLogsConfig(vpcFlowLogsConfig)
        .build()
        .toString();
  }

  public static VpcFlowLogsConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG.validatedMatch(
            formattedString, "VpcFlowLogsConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("vpc_flow_logs_config"));
  }

  public static List<VpcFlowLogsConfigName> parseList(List<String> formattedStrings) {
    List<VpcFlowLogsConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VpcFlowLogsConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VpcFlowLogsConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG.matches(formattedString);
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
          if (vpcFlowLogsConfig != null) {
            fieldMapBuilder.put("vpc_flow_logs_config", vpcFlowLogsConfig);
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
    return PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG.instantiate(
        "project", project, "location", location, "vpc_flow_logs_config", vpcFlowLogsConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      VpcFlowLogsConfigName that = ((VpcFlowLogsConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.vpcFlowLogsConfig, that.vpcFlowLogsConfig);
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
    h ^= Objects.hashCode(vpcFlowLogsConfig);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/vpcFlowLogsConfigs/{vpc_flow_logs_config}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String vpcFlowLogsConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getVpcFlowLogsConfig() {
      return vpcFlowLogsConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setVpcFlowLogsConfig(String vpcFlowLogsConfig) {
      this.vpcFlowLogsConfig = vpcFlowLogsConfig;
      return this;
    }

    private Builder(VpcFlowLogsConfigName vpcFlowLogsConfigName) {
      this.project = vpcFlowLogsConfigName.project;
      this.location = vpcFlowLogsConfigName.location;
      this.vpcFlowLogsConfig = vpcFlowLogsConfigName.vpcFlowLogsConfig;
    }

    public VpcFlowLogsConfigName build() {
      return new VpcFlowLogsConfigName(this);
    }
  }
}
