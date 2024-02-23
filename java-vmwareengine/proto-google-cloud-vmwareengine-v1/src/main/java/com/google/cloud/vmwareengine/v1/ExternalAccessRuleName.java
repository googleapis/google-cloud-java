/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vmwareengine.v1;

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
public class ExternalAccessRuleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_NETWORK_POLICY_EXTERNAL_ACCESS_RULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/networkPolicies/{network_policy}/externalAccessRules/{external_access_rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String networkPolicy;
  private final String externalAccessRule;

  @Deprecated
  protected ExternalAccessRuleName() {
    project = null;
    location = null;
    networkPolicy = null;
    externalAccessRule = null;
  }

  private ExternalAccessRuleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    networkPolicy = Preconditions.checkNotNull(builder.getNetworkPolicy());
    externalAccessRule = Preconditions.checkNotNull(builder.getExternalAccessRule());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getNetworkPolicy() {
    return networkPolicy;
  }

  public String getExternalAccessRule() {
    return externalAccessRule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExternalAccessRuleName of(
      String project, String location, String networkPolicy, String externalAccessRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNetworkPolicy(networkPolicy)
        .setExternalAccessRule(externalAccessRule)
        .build();
  }

  public static String format(
      String project, String location, String networkPolicy, String externalAccessRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setNetworkPolicy(networkPolicy)
        .setExternalAccessRule(externalAccessRule)
        .build()
        .toString();
  }

  public static ExternalAccessRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_NETWORK_POLICY_EXTERNAL_ACCESS_RULE.validatedMatch(
            formattedString, "ExternalAccessRuleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("network_policy"),
        matchMap.get("external_access_rule"));
  }

  public static List<ExternalAccessRuleName> parseList(List<String> formattedStrings) {
    List<ExternalAccessRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ExternalAccessRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExternalAccessRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_NETWORK_POLICY_EXTERNAL_ACCESS_RULE.matches(formattedString);
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
          if (networkPolicy != null) {
            fieldMapBuilder.put("network_policy", networkPolicy);
          }
          if (externalAccessRule != null) {
            fieldMapBuilder.put("external_access_rule", externalAccessRule);
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
    return PROJECT_LOCATION_NETWORK_POLICY_EXTERNAL_ACCESS_RULE.instantiate(
        "project",
        project,
        "location",
        location,
        "network_policy",
        networkPolicy,
        "external_access_rule",
        externalAccessRule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExternalAccessRuleName that = ((ExternalAccessRuleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.networkPolicy, that.networkPolicy)
          && Objects.equals(this.externalAccessRule, that.externalAccessRule);
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
    h ^= Objects.hashCode(networkPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(externalAccessRule);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/networkPolicies/{network_policy}/externalAccessRules/{external_access_rule}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String networkPolicy;
    private String externalAccessRule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getNetworkPolicy() {
      return networkPolicy;
    }

    public String getExternalAccessRule() {
      return externalAccessRule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setNetworkPolicy(String networkPolicy) {
      this.networkPolicy = networkPolicy;
      return this;
    }

    public Builder setExternalAccessRule(String externalAccessRule) {
      this.externalAccessRule = externalAccessRule;
      return this;
    }

    private Builder(ExternalAccessRuleName externalAccessRuleName) {
      this.project = externalAccessRuleName.project;
      this.location = externalAccessRuleName.location;
      this.networkPolicy = externalAccessRuleName.networkPolicy;
      this.externalAccessRule = externalAccessRuleName.externalAccessRule;
    }

    public ExternalAccessRuleName build() {
      return new ExternalAccessRuleName(this);
    }
  }
}
