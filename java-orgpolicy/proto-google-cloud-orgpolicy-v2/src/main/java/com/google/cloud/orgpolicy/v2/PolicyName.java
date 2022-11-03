/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.orgpolicy.v2;

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
public class PolicyName implements ResourceName {
  private static final PathTemplate PROJECT_POLICY =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/policies/{policy}");
  private static final PathTemplate FOLDER_POLICY =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/policies/{policy}");
  private static final PathTemplate ORGANIZATION_POLICY =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/policies/{policy}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String policy;
  private final String folder;
  private final String organization;

  @Deprecated
  protected PolicyName() {
    project = null;
    policy = null;
    folder = null;
    organization = null;
  }

  private PolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    policy = Preconditions.checkNotNull(builder.getPolicy());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_POLICY;
  }

  private PolicyName(FolderPolicyBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    policy = Preconditions.checkNotNull(builder.getPolicy());
    project = null;
    organization = null;
    pathTemplate = FOLDER_POLICY;
  }

  private PolicyName(OrganizationPolicyBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    policy = Preconditions.checkNotNull(builder.getPolicy());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_POLICY;
  }

  public String getProject() {
    return project;
  }

  public String getPolicy() {
    return policy;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectPolicyBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderPolicyBuilder newFolderPolicyBuilder() {
    return new FolderPolicyBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationPolicyBuilder newOrganizationPolicyBuilder() {
    return new OrganizationPolicyBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PolicyName of(String project, String policy) {
    return newBuilder().setProject(project).setPolicy(policy).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static PolicyName ofProjectPolicyName(String project, String policy) {
    return newBuilder().setProject(project).setPolicy(policy).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static PolicyName ofFolderPolicyName(String folder, String policy) {
    return newFolderPolicyBuilder().setFolder(folder).setPolicy(policy).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static PolicyName ofOrganizationPolicyName(String organization, String policy) {
    return newOrganizationPolicyBuilder().setOrganization(organization).setPolicy(policy).build();
  }

  public static String format(String project, String policy) {
    return newBuilder().setProject(project).setPolicy(policy).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectPolicyName(String project, String policy) {
    return newBuilder().setProject(project).setPolicy(policy).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderPolicyName(String folder, String policy) {
    return newFolderPolicyBuilder().setFolder(folder).setPolicy(policy).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationPolicyName(String organization, String policy) {
    return newOrganizationPolicyBuilder()
        .setOrganization(organization)
        .setPolicy(policy)
        .build()
        .toString();
  }

  public static PolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_POLICY.match(formattedString);
      return ofProjectPolicyName(matchMap.get("project"), matchMap.get("policy"));
    } else if (FOLDER_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_POLICY.match(formattedString);
      return ofFolderPolicyName(matchMap.get("folder"), matchMap.get("policy"));
    } else if (ORGANIZATION_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_POLICY.match(formattedString);
      return ofOrganizationPolicyName(matchMap.get("organization"), matchMap.get("policy"));
    }
    throw new ValidationException("PolicyName.parse: formattedString not in valid format");
  }

  public static List<PolicyName> parseList(List<String> formattedStrings) {
    List<PolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PolicyName> values) {
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
    return PROJECT_POLICY.matches(formattedString)
        || FOLDER_POLICY.matches(formattedString)
        || ORGANIZATION_POLICY.matches(formattedString);
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
          if (policy != null) {
            fieldMapBuilder.put("policy", policy);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
    if (o != null || getClass() == o.getClass()) {
      PolicyName that = ((PolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.policy, that.policy)
          && Objects.equals(this.folder, that.folder)
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
    h ^= Objects.hashCode(policy);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/policies/{policy}. */
  public static class Builder {
    private String project;
    private String policy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getPolicy() {
      return policy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setPolicy(String policy) {
      this.policy = policy;
      return this;
    }

    private Builder(PolicyName policyName) {
      Preconditions.checkArgument(
          Objects.equals(policyName.pathTemplate, PROJECT_POLICY),
          "toBuilder is only supported when PolicyName has the pattern of projects/{project}/policies/{policy}");
      this.project = policyName.project;
      this.policy = policyName.policy;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }

  /** Builder for folders/{folder}/policies/{policy}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderPolicyBuilder {
    private String folder;
    private String policy;

    protected FolderPolicyBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getPolicy() {
      return policy;
    }

    public FolderPolicyBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderPolicyBuilder setPolicy(String policy) {
      this.policy = policy;
      return this;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }

  /** Builder for organizations/{organization}/policies/{policy}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationPolicyBuilder {
    private String organization;
    private String policy;

    protected OrganizationPolicyBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getPolicy() {
      return policy;
    }

    public OrganizationPolicyBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationPolicyBuilder setPolicy(String policy) {
      this.policy = policy;
      return this;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }
}
