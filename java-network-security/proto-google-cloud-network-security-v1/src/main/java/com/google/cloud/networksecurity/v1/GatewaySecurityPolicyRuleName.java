/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

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
public class GatewaySecurityPolicyRuleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_GATEWAY_SECURITY_POLICY_RULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/gatewaySecurityPolicies/{gateway_security_policy}/rules/{rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String gatewaySecurityPolicy;
  private final String rule;

  @Deprecated
  protected GatewaySecurityPolicyRuleName() {
    project = null;
    location = null;
    gatewaySecurityPolicy = null;
    rule = null;
  }

  private GatewaySecurityPolicyRuleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    gatewaySecurityPolicy = Preconditions.checkNotNull(builder.getGatewaySecurityPolicy());
    rule = Preconditions.checkNotNull(builder.getRule());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGatewaySecurityPolicy() {
    return gatewaySecurityPolicy;
  }

  public String getRule() {
    return rule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GatewaySecurityPolicyRuleName of(
      String project, String location, String gatewaySecurityPolicy, String rule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGatewaySecurityPolicy(gatewaySecurityPolicy)
        .setRule(rule)
        .build();
  }

  public static String format(
      String project, String location, String gatewaySecurityPolicy, String rule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGatewaySecurityPolicy(gatewaySecurityPolicy)
        .setRule(rule)
        .build()
        .toString();
  }

  public static GatewaySecurityPolicyRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_GATEWAY_SECURITY_POLICY_RULE.validatedMatch(
            formattedString,
            "GatewaySecurityPolicyRuleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("gateway_security_policy"),
        matchMap.get("rule"));
  }

  public static List<GatewaySecurityPolicyRuleName> parseList(List<String> formattedStrings) {
    List<GatewaySecurityPolicyRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GatewaySecurityPolicyRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GatewaySecurityPolicyRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_GATEWAY_SECURITY_POLICY_RULE.matches(formattedString);
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
          if (gatewaySecurityPolicy != null) {
            fieldMapBuilder.put("gateway_security_policy", gatewaySecurityPolicy);
          }
          if (rule != null) {
            fieldMapBuilder.put("rule", rule);
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
    return PROJECT_LOCATION_GATEWAY_SECURITY_POLICY_RULE.instantiate(
        "project",
        project,
        "location",
        location,
        "gateway_security_policy",
        gatewaySecurityPolicy,
        "rule",
        rule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GatewaySecurityPolicyRuleName that = ((GatewaySecurityPolicyRuleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.gatewaySecurityPolicy, that.gatewaySecurityPolicy)
          && Objects.equals(this.rule, that.rule);
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
    h ^= Objects.hashCode(gatewaySecurityPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(rule);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/gatewaySecurityPolicies/{gateway_security_policy}/rules/{rule}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String gatewaySecurityPolicy;
    private String rule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGatewaySecurityPolicy() {
      return gatewaySecurityPolicy;
    }

    public String getRule() {
      return rule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGatewaySecurityPolicy(String gatewaySecurityPolicy) {
      this.gatewaySecurityPolicy = gatewaySecurityPolicy;
      return this;
    }

    public Builder setRule(String rule) {
      this.rule = rule;
      return this;
    }

    private Builder(GatewaySecurityPolicyRuleName gatewaySecurityPolicyRuleName) {
      this.project = gatewaySecurityPolicyRuleName.project;
      this.location = gatewaySecurityPolicyRuleName.location;
      this.gatewaySecurityPolicy = gatewaySecurityPolicyRuleName.gatewaySecurityPolicy;
      this.rule = gatewaySecurityPolicyRuleName.rule;
    }

    public GatewaySecurityPolicyRuleName build() {
      return new GatewaySecurityPolicyRuleName(this);
    }
  }
}
