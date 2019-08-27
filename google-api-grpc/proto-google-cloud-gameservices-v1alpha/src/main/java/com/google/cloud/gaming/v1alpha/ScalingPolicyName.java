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

package com.google.cloud.gaming.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ScalingPolicyName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/scalingPolicies/{scaling_policy}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String scalingPolicy;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getScalingPolicy() {
    return scalingPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ScalingPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    scalingPolicy = Preconditions.checkNotNull(builder.getScalingPolicy());
  }

  public static ScalingPolicyName of(String project, String location, String scalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScalingPolicy(scalingPolicy)
        .build();
  }

  public static String format(String project, String location, String scalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScalingPolicy(scalingPolicy)
        .build()
        .toString();
  }

  public static ScalingPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ScalingPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("scaling_policy"));
  }

  public static List<ScalingPolicyName> parseList(List<String> formattedStrings) {
    List<ScalingPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ScalingPolicyName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ScalingPolicyName value : values) {
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
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("scalingPolicy", scalingPolicy);
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
        "project", project, "location", location, "scaling_policy", scalingPolicy);
  }

  /** Builder for ScalingPolicyName. */
  public static class Builder {

    private String project;
    private String location;
    private String scalingPolicy;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getScalingPolicy() {
      return scalingPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setScalingPolicy(String scalingPolicy) {
      this.scalingPolicy = scalingPolicy;
      return this;
    }

    private Builder() {}

    private Builder(ScalingPolicyName scalingPolicyName) {
      project = scalingPolicyName.project;
      location = scalingPolicyName.location;
      scalingPolicy = scalingPolicyName.scalingPolicy;
    }

    public ScalingPolicyName build() {
      return new ScalingPolicyName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ScalingPolicyName) {
      ScalingPolicyName that = (ScalingPolicyName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.scalingPolicy.equals(that.scalingPolicy));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= scalingPolicy.hashCode();
    return h;
  }
}
