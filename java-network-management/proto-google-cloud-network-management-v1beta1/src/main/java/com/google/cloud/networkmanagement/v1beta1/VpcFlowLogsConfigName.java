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

package com.google.cloud.networkmanagement.v1beta1;

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
public class VpcFlowLogsConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/vpcFlowLogsConfigs/{vpc_flow_logs_config}");
  private static final PathTemplate ORGANIZATION_LOCATION_VPC_FLOW_LOGS_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/vpcFlowLogsConfigs/{vpc_flow_logs_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String vpcFlowLogsConfig;
  private final String organization;

  @Deprecated
  protected VpcFlowLogsConfigName() {
    project = null;
    location = null;
    vpcFlowLogsConfig = null;
    organization = null;
  }

  private VpcFlowLogsConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    vpcFlowLogsConfig = Preconditions.checkNotNull(builder.getVpcFlowLogsConfig());
    organization = null;
    pathTemplate = PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG;
  }

  private VpcFlowLogsConfigName(OrganizationLocationVpcFlowLogsConfigBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    vpcFlowLogsConfig = Preconditions.checkNotNull(builder.getVpcFlowLogsConfig());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_VPC_FLOW_LOGS_CONFIG;
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

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationVpcFlowLogsConfigBuilder() {
    return new Builder();
  }

  public static OrganizationLocationVpcFlowLogsConfigBuilder
      newOrganizationLocationVpcFlowLogsConfigBuilder() {
    return new OrganizationLocationVpcFlowLogsConfigBuilder();
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

  public static VpcFlowLogsConfigName ofProjectLocationVpcFlowLogsConfigName(
      String project, String location, String vpcFlowLogsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVpcFlowLogsConfig(vpcFlowLogsConfig)
        .build();
  }

  public static VpcFlowLogsConfigName ofOrganizationLocationVpcFlowLogsConfigName(
      String organization, String location, String vpcFlowLogsConfig) {
    return newOrganizationLocationVpcFlowLogsConfigBuilder()
        .setOrganization(organization)
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

  public static String formatProjectLocationVpcFlowLogsConfigName(
      String project, String location, String vpcFlowLogsConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVpcFlowLogsConfig(vpcFlowLogsConfig)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationVpcFlowLogsConfigName(
      String organization, String location, String vpcFlowLogsConfig) {
    return newOrganizationLocationVpcFlowLogsConfigBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setVpcFlowLogsConfig(vpcFlowLogsConfig)
        .build()
        .toString();
  }

  public static VpcFlowLogsConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG.match(formattedString);
      return ofProjectLocationVpcFlowLogsConfigName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("vpc_flow_logs_config"));
    } else if (ORGANIZATION_LOCATION_VPC_FLOW_LOGS_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_VPC_FLOW_LOGS_CONFIG.match(formattedString);
      return ofOrganizationLocationVpcFlowLogsConfigName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("vpc_flow_logs_config"));
    }
    throw new ValidationException(
        "VpcFlowLogsConfigName.parse: formattedString not in valid format");
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
    return PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG.matches(formattedString)
        || ORGANIZATION_LOCATION_VPC_FLOW_LOGS_CONFIG.matches(formattedString);
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
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
    if (o != null && getClass() == o.getClass()) {
      VpcFlowLogsConfigName that = ((VpcFlowLogsConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.vpcFlowLogsConfig, that.vpcFlowLogsConfig)
          && Objects.equals(this.organization, that.organization);
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(vpcFlowLogsConfig);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
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
      Preconditions.checkArgument(
          Objects.equals(vpcFlowLogsConfigName.pathTemplate, PROJECT_LOCATION_VPC_FLOW_LOGS_CONFIG),
          "toBuilder is only supported when VpcFlowLogsConfigName has the pattern of"
              + " projects/{project}/locations/{location}/vpcFlowLogsConfigs/{vpc_flow_logs_config}");
      this.project = vpcFlowLogsConfigName.project;
      this.location = vpcFlowLogsConfigName.location;
      this.vpcFlowLogsConfig = vpcFlowLogsConfigName.vpcFlowLogsConfig;
    }

    public VpcFlowLogsConfigName build() {
      return new VpcFlowLogsConfigName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/vpcFlowLogsConfigs/{vpc_flow_logs_config}.
   */
  public static class OrganizationLocationVpcFlowLogsConfigBuilder {
    private String organization;
    private String location;
    private String vpcFlowLogsConfig;

    protected OrganizationLocationVpcFlowLogsConfigBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getVpcFlowLogsConfig() {
      return vpcFlowLogsConfig;
    }

    public OrganizationLocationVpcFlowLogsConfigBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationVpcFlowLogsConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationVpcFlowLogsConfigBuilder setVpcFlowLogsConfig(
        String vpcFlowLogsConfig) {
      this.vpcFlowLogsConfig = vpcFlowLogsConfig;
      return this;
    }

    public VpcFlowLogsConfigName build() {
      return new VpcFlowLogsConfigName(this);
    }
  }
}
