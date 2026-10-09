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

package com.google.cloud.backupdr.v1beta;

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
public class AutoProtectionPolicyBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AUTO_PROTECTION_POLICY_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/autoProtectionPolicies/{auto_protection_policy}/bindings/{binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String autoProtectionPolicy;
  private final String binding;

  @Deprecated
  protected AutoProtectionPolicyBindingName() {
    project = null;
    location = null;
    autoProtectionPolicy = null;
    binding = null;
  }

  private AutoProtectionPolicyBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    autoProtectionPolicy = Preconditions.checkNotNull(builder.getAutoProtectionPolicy());
    binding = Preconditions.checkNotNull(builder.getBinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAutoProtectionPolicy() {
    return autoProtectionPolicy;
  }

  public String getBinding() {
    return binding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutoProtectionPolicyBindingName of(
      String project, String location, String autoProtectionPolicy, String binding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutoProtectionPolicy(autoProtectionPolicy)
        .setBinding(binding)
        .build();
  }

  public static String format(
      String project, String location, String autoProtectionPolicy, String binding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAutoProtectionPolicy(autoProtectionPolicy)
        .setBinding(binding)
        .build()
        .toString();
  }

  public static @Nullable AutoProtectionPolicyBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AUTO_PROTECTION_POLICY_BINDING.validatedMatch(
            formattedString,
            "AutoProtectionPolicyBindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("auto_protection_policy"),
        matchMap.get("binding"));
  }

  public static List<AutoProtectionPolicyBindingName> parseList(List<String> formattedStrings) {
    List<AutoProtectionPolicyBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AutoProtectionPolicyBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutoProtectionPolicyBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AUTO_PROTECTION_POLICY_BINDING.matches(formattedString);
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
          if (autoProtectionPolicy != null) {
            fieldMapBuilder.put("auto_protection_policy", autoProtectionPolicy);
          }
          if (binding != null) {
            fieldMapBuilder.put("binding", binding);
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
    return PROJECT_LOCATION_AUTO_PROTECTION_POLICY_BINDING.instantiate(
        "project",
        project,
        "location",
        location,
        "auto_protection_policy",
        autoProtectionPolicy,
        "binding",
        binding);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutoProtectionPolicyBindingName that = ((AutoProtectionPolicyBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.autoProtectionPolicy, that.autoProtectionPolicy)
          && Objects.equals(this.binding, that.binding);
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
    h ^= Objects.hashCode(autoProtectionPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(binding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/autoProtectionPolicies/{auto_protection_policy}/bindings/{binding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String autoProtectionPolicy;
    private String binding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAutoProtectionPolicy() {
      return autoProtectionPolicy;
    }

    public String getBinding() {
      return binding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAutoProtectionPolicy(String autoProtectionPolicy) {
      this.autoProtectionPolicy = autoProtectionPolicy;
      return this;
    }

    public Builder setBinding(String binding) {
      this.binding = binding;
      return this;
    }

    private Builder(AutoProtectionPolicyBindingName autoProtectionPolicyBindingName) {
      this.project = autoProtectionPolicyBindingName.project;
      this.location = autoProtectionPolicyBindingName.location;
      this.autoProtectionPolicy = autoProtectionPolicyBindingName.autoProtectionPolicy;
      this.binding = autoProtectionPolicyBindingName.binding;
    }

    public AutoProtectionPolicyBindingName build() {
      return new AutoProtectionPolicyBindingName(this);
    }
  }
}
