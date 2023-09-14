/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.baremetalsolution.v2;

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
public class ProvisioningConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PROVISIONING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/provisioningConfigs/{provisioning_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String provisioningConfig;

  @Deprecated
  protected ProvisioningConfigName() {
    project = null;
    location = null;
    provisioningConfig = null;
  }

  private ProvisioningConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    provisioningConfig = Preconditions.checkNotNull(builder.getProvisioningConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getProvisioningConfig() {
    return provisioningConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProvisioningConfigName of(
      String project, String location, String provisioningConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProvisioningConfig(provisioningConfig)
        .build();
  }

  public static String format(String project, String location, String provisioningConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setProvisioningConfig(provisioningConfig)
        .build()
        .toString();
  }

  public static ProvisioningConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PROVISIONING_CONFIG.validatedMatch(
            formattedString, "ProvisioningConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("provisioning_config"));
  }

  public static List<ProvisioningConfigName> parseList(List<String> formattedStrings) {
    List<ProvisioningConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProvisioningConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProvisioningConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PROVISIONING_CONFIG.matches(formattedString);
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
          if (provisioningConfig != null) {
            fieldMapBuilder.put("provisioning_config", provisioningConfig);
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
    return PROJECT_LOCATION_PROVISIONING_CONFIG.instantiate(
        "project", project, "location", location, "provisioning_config", provisioningConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProvisioningConfigName that = ((ProvisioningConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.provisioningConfig, that.provisioningConfig);
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
    h ^= Objects.hashCode(provisioningConfig);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/provisioningConfigs/{provisioning_config}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String provisioningConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getProvisioningConfig() {
      return provisioningConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setProvisioningConfig(String provisioningConfig) {
      this.provisioningConfig = provisioningConfig;
      return this;
    }

    private Builder(ProvisioningConfigName provisioningConfigName) {
      this.project = provisioningConfigName.project;
      this.location = provisioningConfigName.location;
      this.provisioningConfig = provisioningConfigName.provisioningConfig;
    }

    public ProvisioningConfigName build() {
      return new ProvisioningConfigName(this);
    }
  }
}
