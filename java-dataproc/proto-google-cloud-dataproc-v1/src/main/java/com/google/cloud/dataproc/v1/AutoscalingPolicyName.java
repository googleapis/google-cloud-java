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

package com.google.cloud.dataproc.v1;

import com.google.api.core.BetaApi;
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
public class AutoscalingPolicyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUTOSCALING_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/autoscalingPolicies/{autoscaling_policy}");
  private static final PathTemplate PROJECT_REGION_AUTOSCALING_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/autoscalingPolicies/{autoscaling_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String autoscalingPolicy;
  private final String region;

  @Deprecated
  protected AutoscalingPolicyName() {
    project = null;
    location = null;
    autoscalingPolicy = null;
    region = null;
  }

  private AutoscalingPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    autoscalingPolicy = Preconditions.checkNotNull(builder.getAutoscalingPolicy());
    region = null;
    pathTemplate = PROJECT_LOCATION_AUTOSCALING_POLICY;
  }

  private AutoscalingPolicyName(ProjectRegionAutoscalingPolicyBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    autoscalingPolicy = Preconditions.checkNotNull(builder.getAutoscalingPolicy());
    location = null;
    pathTemplate = PROJECT_REGION_AUTOSCALING_POLICY;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAutoscalingPolicy() {
    return autoscalingPolicy;
  }

  public String getRegion() {
    return region;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationAutoscalingPolicyBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectRegionAutoscalingPolicyBuilder newProjectRegionAutoscalingPolicyBuilder() {
    return new ProjectRegionAutoscalingPolicyBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutoscalingPolicyName of(
      String project, String location, String autoscalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AutoscalingPolicyName ofProjectLocationAutoscalingPolicyName(
      String project, String location, String autoscalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AutoscalingPolicyName ofProjectRegionAutoscalingPolicyName(
      String project, String region, String autoscalingPolicy) {
    return newProjectRegionAutoscalingPolicyBuilder()
        .setProject(project)
        .setRegion(region)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build();
  }

  public static String format(String project, String location, String autoscalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationAutoscalingPolicyName(
      String project, String location, String autoscalingPolicy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutoscalingPolicy(autoscalingPolicy)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectRegionAutoscalingPolicyName(
      String project, String region, String autoscalingPolicy) {
    return newProjectRegionAutoscalingPolicyBuilder()
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
    if (PROJECT_LOCATION_AUTOSCALING_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_AUTOSCALING_POLICY.match(formattedString);
      return ofProjectLocationAutoscalingPolicyName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("autoscaling_policy"));
    } else if (PROJECT_REGION_AUTOSCALING_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_REGION_AUTOSCALING_POLICY.match(formattedString);
      return ofProjectRegionAutoscalingPolicyName(
          matchMap.get("project"), matchMap.get("region"), matchMap.get("autoscaling_policy"));
    }
    throw new ValidationException(
        "AutoscalingPolicyName.parse: formattedString not in valid format");
  }

  public static List<AutoscalingPolicyName> parseList(List<String> formattedStrings) {
    List<AutoscalingPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutoscalingPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_LOCATION_AUTOSCALING_POLICY.matches(formattedString)
        || PROJECT_REGION_AUTOSCALING_POLICY.matches(formattedString);
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
          if (autoscalingPolicy != null) {
            fieldMapBuilder.put("autoscaling_policy", autoscalingPolicy);
          }
          if (region != null) {
            fieldMapBuilder.put("region", region);
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
      AutoscalingPolicyName that = ((AutoscalingPolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.autoscalingPolicy, that.autoscalingPolicy)
          && Objects.equals(this.region, that.region);
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
    h ^= Objects.hashCode(autoscalingPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(region);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/autoscalingPolicies/{autoscaling_policy}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String autoscalingPolicy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAutoscalingPolicy() {
      return autoscalingPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAutoscalingPolicy(String autoscalingPolicy) {
      this.autoscalingPolicy = autoscalingPolicy;
      return this;
    }

    private Builder(AutoscalingPolicyName autoscalingPolicyName) {
      Preconditions.checkArgument(
          Objects.equals(autoscalingPolicyName.pathTemplate, PROJECT_LOCATION_AUTOSCALING_POLICY),
          "toBuilder is only supported when AutoscalingPolicyName has the pattern of projects/{project}/locations/{location}/autoscalingPolicies/{autoscaling_policy}");
      project = autoscalingPolicyName.project;
      location = autoscalingPolicyName.location;
      autoscalingPolicy = autoscalingPolicyName.autoscalingPolicy;
    }

    public AutoscalingPolicyName build() {
      return new AutoscalingPolicyName(this);
    }
  }

  /** Builder for projects/{project}/regions/{region}/autoscalingPolicies/{autoscaling_policy}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectRegionAutoscalingPolicyBuilder {
    private String project;
    private String region;
    private String autoscalingPolicy;

    protected ProjectRegionAutoscalingPolicyBuilder() {}

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getAutoscalingPolicy() {
      return autoscalingPolicy;
    }

    public ProjectRegionAutoscalingPolicyBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectRegionAutoscalingPolicyBuilder setRegion(String region) {
      this.region = region;
      return this;
    }

    public ProjectRegionAutoscalingPolicyBuilder setAutoscalingPolicy(String autoscalingPolicy) {
      this.autoscalingPolicy = autoscalingPolicy;
      return this;
    }

    public AutoscalingPolicyName build() {
      return new AutoscalingPolicyName(this);
    }
  }
}
