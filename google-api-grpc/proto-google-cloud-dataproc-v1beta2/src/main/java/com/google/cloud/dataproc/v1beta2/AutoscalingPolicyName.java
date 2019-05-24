/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dataproc.v1beta2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AutoscalingPolicyName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/autoscalingPolicies/{autoscaling_policy}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String region;
  private final String autoscalingPolicy;

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getAutoscalingPolicy() {
    return autoscalingPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private AutoscalingPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    autoscalingPolicy = Preconditions.checkNotNull(builder.getAutoscalingPolicy());
  }

  public static AutoscalingPolicyName of(String project, String region, String autoscalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build();
  }

  public static String format(String project, String region, String autoscalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build()
        .toString();
  }

  public static AutoscalingPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AutoscalingPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("region"), matchMap.get("autoscaling_policy"));
  }

  public static List<AutoscalingPolicyName> parseList(List<String> formattedStrings) {
    List<AutoscalingPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutoscalingPolicyName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (AutoscalingPolicyName value : values) {
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
          fieldMapBuilder.put("region", region);
          fieldMapBuilder.put("autoscalingPolicy", autoscalingPolicy);
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
        "project", project, "region", region, "autoscaling_policy", autoscalingPolicy);
  }

  /** Builder for AutoscalingPolicyName. */
  public static class Builder {

    private String project;
    private String region;
    private String autoscalingPolicy;

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getAutoscalingPolicy() {
      return autoscalingPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public Builder setAutoscalingPolicy(String autoscalingPolicy) {
      this.autoscalingPolicy = autoscalingPolicy;
      return this;
    }

    private Builder() {}

    private Builder(AutoscalingPolicyName autoscalingPolicyName) {
      project = autoscalingPolicyName.project;
      region = autoscalingPolicyName.region;
      autoscalingPolicy = autoscalingPolicyName.autoscalingPolicy;
    }

    public AutoscalingPolicyName build() {
      return new AutoscalingPolicyName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AutoscalingPolicyName) {
      AutoscalingPolicyName that = (AutoscalingPolicyName) o;
      return (this.project.equals(that.project))
          && (this.region.equals(that.region))
          && (this.autoscalingPolicy.equals(that.autoscalingPolicy));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= region.hashCode();
    h *= 1000003;
    h ^= autoscalingPolicy.hashCode();
    return h;
  }
}
