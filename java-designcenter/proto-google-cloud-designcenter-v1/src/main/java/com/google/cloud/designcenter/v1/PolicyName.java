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

package com.google.cloud.designcenter.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class PolicyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SPACE_APPLICATION_TEMPLATE_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/spaces/{space}/applicationTemplates/{application_template}/policies/{policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String space;
  private final String applicationTemplate;
  private final String policy;

  @Deprecated
  protected PolicyName() {
    project = null;
    location = null;
    space = null;
    applicationTemplate = null;
    policy = null;
  }

  private PolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    space = Preconditions.checkNotNull(builder.getSpace());
    applicationTemplate = Preconditions.checkNotNull(builder.getApplicationTemplate());
    policy = Preconditions.checkNotNull(builder.getPolicy());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSpace() {
    return space;
  }

  public String getApplicationTemplate() {
    return applicationTemplate;
  }

  public String getPolicy() {
    return policy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PolicyName of(
      String project, String location, String space, String applicationTemplate, String policy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpace(space)
        .setApplicationTemplate(applicationTemplate)
        .setPolicy(policy)
        .build();
  }

  public static String format(
      String project, String location, String space, String applicationTemplate, String policy) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpace(space)
        .setApplicationTemplate(applicationTemplate)
        .setPolicy(policy)
        .build()
        .toString();
  }

  public static @Nullable PolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SPACE_APPLICATION_TEMPLATE_POLICY.validatedMatch(
            formattedString, "PolicyName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("space"),
        matchMap.get("application_template"),
        matchMap.get("policy"));
  }

  public static List<PolicyName> parseList(List<String> formattedStrings) {
    List<PolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable PolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SPACE_APPLICATION_TEMPLATE_POLICY.matches(formattedString);
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
          if (space != null) {
            fieldMapBuilder.put("space", space);
          }
          if (applicationTemplate != null) {
            fieldMapBuilder.put("application_template", applicationTemplate);
          }
          if (policy != null) {
            fieldMapBuilder.put("policy", policy);
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
    return PROJECT_LOCATION_SPACE_APPLICATION_TEMPLATE_POLICY.instantiate(
        "project",
        project,
        "location",
        location,
        "space",
        space,
        "application_template",
        applicationTemplate,
        "policy",
        policy);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PolicyName that = ((PolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.space, that.space)
          && Objects.equals(this.applicationTemplate, that.applicationTemplate)
          && Objects.equals(this.policy, that.policy);
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
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(applicationTemplate);
    h *= 1000003;
    h ^= Objects.hashCode(policy);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/spaces/{space}/applicationTemplates/{application_template}/policies/{policy}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String space;
    private String applicationTemplate;
    private String policy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSpace() {
      return space;
    }

    public String getApplicationTemplate() {
      return applicationTemplate;
    }

    public String getPolicy() {
      return policy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setApplicationTemplate(String applicationTemplate) {
      this.applicationTemplate = applicationTemplate;
      return this;
    }

    public Builder setPolicy(String policy) {
      this.policy = policy;
      return this;
    }

    private Builder(PolicyName policyName) {
      this.project = policyName.project;
      this.location = policyName.location;
      this.space = policyName.space;
      this.applicationTemplate = policyName.applicationTemplate;
      this.policy = policyName.policy;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }
}
