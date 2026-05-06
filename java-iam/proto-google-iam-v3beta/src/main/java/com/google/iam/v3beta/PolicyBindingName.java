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

package com.google.iam.v3beta;

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
public class PolicyBindingName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_POLICY_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/policyBindings/{policy_binding}");
  private static final PathTemplate FOLDER_LOCATION_POLICY_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/policyBindings/{policy_binding}");
  private static final PathTemplate PROJECT_LOCATION_POLICY_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/policyBindings/{policy_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String policyBinding;
  private final String folder;
  private final String project;

  @Deprecated
  protected PolicyBindingName() {
    organization = null;
    location = null;
    policyBinding = null;
    folder = null;
    project = null;
  }

  private PolicyBindingName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    policyBinding = Preconditions.checkNotNull(builder.getPolicyBinding());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_POLICY_BINDING;
  }

  private PolicyBindingName(FolderLocationPolicyBindingBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    policyBinding = Preconditions.checkNotNull(builder.getPolicyBinding());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_POLICY_BINDING;
  }

  private PolicyBindingName(ProjectLocationPolicyBindingBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    policyBinding = Preconditions.checkNotNull(builder.getPolicyBinding());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_POLICY_BINDING;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getPolicyBinding() {
    return policyBinding;
  }

  public String getFolder() {
    return folder;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationPolicyBindingBuilder() {
    return new Builder();
  }

  public static FolderLocationPolicyBindingBuilder newFolderLocationPolicyBindingBuilder() {
    return new FolderLocationPolicyBindingBuilder();
  }

  public static ProjectLocationPolicyBindingBuilder newProjectLocationPolicyBindingBuilder() {
    return new ProjectLocationPolicyBindingBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PolicyBindingName of(String organization, String location, String policyBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build();
  }

  public static PolicyBindingName ofOrganizationLocationPolicyBindingName(
      String organization, String location, String policyBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build();
  }

  public static PolicyBindingName ofFolderLocationPolicyBindingName(
      String folder, String location, String policyBinding) {
    return newFolderLocationPolicyBindingBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build();
  }

  public static PolicyBindingName ofProjectLocationPolicyBindingName(
      String project, String location, String policyBinding) {
    return newProjectLocationPolicyBindingBuilder()
        .setProject(project)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build();
  }

  public static String format(String organization, String location, String policyBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationPolicyBindingName(
      String organization, String location, String policyBinding) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build()
        .toString();
  }

  public static String formatFolderLocationPolicyBindingName(
      String folder, String location, String policyBinding) {
    return newFolderLocationPolicyBindingBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build()
        .toString();
  }

  public static String formatProjectLocationPolicyBindingName(
      String project, String location, String policyBinding) {
    return newProjectLocationPolicyBindingBuilder()
        .setProject(project)
        .setLocation(location)
        .setPolicyBinding(policyBinding)
        .build()
        .toString();
  }

  public static PolicyBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_POLICY_BINDING.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_POLICY_BINDING.match(formattedString);
      return ofOrganizationLocationPolicyBindingName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("policy_binding"));
    } else if (FOLDER_LOCATION_POLICY_BINDING.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_POLICY_BINDING.match(formattedString);
      return ofFolderLocationPolicyBindingName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("policy_binding"));
    } else if (PROJECT_LOCATION_POLICY_BINDING.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_POLICY_BINDING.match(formattedString);
      return ofProjectLocationPolicyBindingName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("policy_binding"));
    }
    throw new ValidationException("PolicyBindingName.parse: formattedString not in valid format");
  }

  public static List<PolicyBindingName> parseList(List<String> formattedStrings) {
    List<PolicyBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PolicyBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PolicyBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_POLICY_BINDING.matches(formattedString)
        || FOLDER_LOCATION_POLICY_BINDING.matches(formattedString)
        || PROJECT_LOCATION_POLICY_BINDING.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (policyBinding != null) {
            fieldMapBuilder.put("policy_binding", policyBinding);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
      PolicyBindingName that = ((PolicyBindingName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.policyBinding, that.policyBinding)
          && Objects.equals(this.folder, that.folder)
          && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(policyBinding);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/policyBindings/{policy_binding}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String policyBinding;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getPolicyBinding() {
      return policyBinding;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPolicyBinding(String policyBinding) {
      this.policyBinding = policyBinding;
      return this;
    }

    private Builder(PolicyBindingName policyBindingName) {
      Preconditions.checkArgument(
          Objects.equals(policyBindingName.pathTemplate, ORGANIZATION_LOCATION_POLICY_BINDING),
          "toBuilder is only supported when PolicyBindingName has the pattern of"
              + " organizations/{organization}/locations/{location}/policyBindings/{policy_binding}");
      this.organization = policyBindingName.organization;
      this.location = policyBindingName.location;
      this.policyBinding = policyBindingName.policyBinding;
    }

    public PolicyBindingName build() {
      return new PolicyBindingName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/policyBindings/{policy_binding}. */
  public static class FolderLocationPolicyBindingBuilder {
    private String folder;
    private String location;
    private String policyBinding;

    protected FolderLocationPolicyBindingBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getPolicyBinding() {
      return policyBinding;
    }

    public FolderLocationPolicyBindingBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationPolicyBindingBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationPolicyBindingBuilder setPolicyBinding(String policyBinding) {
      this.policyBinding = policyBinding;
      return this;
    }

    public PolicyBindingName build() {
      return new PolicyBindingName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/policyBindings/{policy_binding}. */
  public static class ProjectLocationPolicyBindingBuilder {
    private String project;
    private String location;
    private String policyBinding;

    protected ProjectLocationPolicyBindingBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPolicyBinding() {
      return policyBinding;
    }

    public ProjectLocationPolicyBindingBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationPolicyBindingBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationPolicyBindingBuilder setPolicyBinding(String policyBinding) {
      this.policyBinding = policyBinding;
      return this;
    }

    public PolicyBindingName build() {
      return new PolicyBindingName(this);
    }
  }
}
