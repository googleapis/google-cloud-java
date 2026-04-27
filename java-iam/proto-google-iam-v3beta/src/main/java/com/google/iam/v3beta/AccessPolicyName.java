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
public class AccessPolicyName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_ACCESS_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/accessPolicies/{access_policy}");
  private static final PathTemplate FOLDER_LOCATION_ACCESS_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/accessPolicies/{access_policy}");
  private static final PathTemplate PROJECT_LOCATION_ACCESS_POLICY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/accessPolicies/{access_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String accessPolicy;
  private final String folder;
  private final String project;

  @Deprecated
  protected AccessPolicyName() {
    organization = null;
    location = null;
    accessPolicy = null;
    folder = null;
    project = null;
  }

  private AccessPolicyName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    accessPolicy = Preconditions.checkNotNull(builder.getAccessPolicy());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_ACCESS_POLICY;
  }

  private AccessPolicyName(FolderLocationAccessPolicyBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    accessPolicy = Preconditions.checkNotNull(builder.getAccessPolicy());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_ACCESS_POLICY;
  }

  private AccessPolicyName(ProjectLocationAccessPolicyBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    accessPolicy = Preconditions.checkNotNull(builder.getAccessPolicy());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_ACCESS_POLICY;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getAccessPolicy() {
    return accessPolicy;
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

  public static Builder newOrganizationLocationAccessPolicyBuilder() {
    return new Builder();
  }

  public static FolderLocationAccessPolicyBuilder newFolderLocationAccessPolicyBuilder() {
    return new FolderLocationAccessPolicyBuilder();
  }

  public static ProjectLocationAccessPolicyBuilder newProjectLocationAccessPolicyBuilder() {
    return new ProjectLocationAccessPolicyBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccessPolicyName of(String organization, String location, String accessPolicy) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build();
  }

  public static AccessPolicyName ofOrganizationLocationAccessPolicyName(
      String organization, String location, String accessPolicy) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build();
  }

  public static AccessPolicyName ofFolderLocationAccessPolicyName(
      String folder, String location, String accessPolicy) {
    return newFolderLocationAccessPolicyBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build();
  }

  public static AccessPolicyName ofProjectLocationAccessPolicyName(
      String project, String location, String accessPolicy) {
    return newProjectLocationAccessPolicyBuilder()
        .setProject(project)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build();
  }

  public static String format(String organization, String location, String accessPolicy) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationAccessPolicyName(
      String organization, String location, String accessPolicy) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build()
        .toString();
  }

  public static String formatFolderLocationAccessPolicyName(
      String folder, String location, String accessPolicy) {
    return newFolderLocationAccessPolicyBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build()
        .toString();
  }

  public static String formatProjectLocationAccessPolicyName(
      String project, String location, String accessPolicy) {
    return newProjectLocationAccessPolicyBuilder()
        .setProject(project)
        .setLocation(location)
        .setAccessPolicy(accessPolicy)
        .build()
        .toString();
  }

  public static AccessPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_ACCESS_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_ACCESS_POLICY.match(formattedString);
      return ofOrganizationLocationAccessPolicyName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("access_policy"));
    } else if (FOLDER_LOCATION_ACCESS_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_ACCESS_POLICY.match(formattedString);
      return ofFolderLocationAccessPolicyName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("access_policy"));
    } else if (PROJECT_LOCATION_ACCESS_POLICY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ACCESS_POLICY.match(formattedString);
      return ofProjectLocationAccessPolicyName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("access_policy"));
    }
    throw new ValidationException("AccessPolicyName.parse: formattedString not in valid format");
  }

  public static List<AccessPolicyName> parseList(List<String> formattedStrings) {
    List<AccessPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccessPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccessPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_ACCESS_POLICY.matches(formattedString)
        || FOLDER_LOCATION_ACCESS_POLICY.matches(formattedString)
        || PROJECT_LOCATION_ACCESS_POLICY.matches(formattedString);
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
          if (accessPolicy != null) {
            fieldMapBuilder.put("access_policy", accessPolicy);
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
      AccessPolicyName that = ((AccessPolicyName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.accessPolicy, that.accessPolicy)
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
    h ^= Objects.hashCode(accessPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/accessPolicies/{access_policy}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String accessPolicy;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getAccessPolicy() {
      return accessPolicy;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAccessPolicy(String accessPolicy) {
      this.accessPolicy = accessPolicy;
      return this;
    }

    private Builder(AccessPolicyName accessPolicyName) {
      Preconditions.checkArgument(
          Objects.equals(accessPolicyName.pathTemplate, ORGANIZATION_LOCATION_ACCESS_POLICY),
          "toBuilder is only supported when AccessPolicyName has the pattern of"
              + " organizations/{organization}/locations/{location}/accessPolicies/{access_policy}");
      this.organization = accessPolicyName.organization;
      this.location = accessPolicyName.location;
      this.accessPolicy = accessPolicyName.accessPolicy;
    }

    public AccessPolicyName build() {
      return new AccessPolicyName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/accessPolicies/{access_policy}. */
  public static class FolderLocationAccessPolicyBuilder {
    private String folder;
    private String location;
    private String accessPolicy;

    protected FolderLocationAccessPolicyBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getAccessPolicy() {
      return accessPolicy;
    }

    public FolderLocationAccessPolicyBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationAccessPolicyBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationAccessPolicyBuilder setAccessPolicy(String accessPolicy) {
      this.accessPolicy = accessPolicy;
      return this;
    }

    public AccessPolicyName build() {
      return new AccessPolicyName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/accessPolicies/{access_policy}. */
  public static class ProjectLocationAccessPolicyBuilder {
    private String project;
    private String location;
    private String accessPolicy;

    protected ProjectLocationAccessPolicyBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAccessPolicy() {
      return accessPolicy;
    }

    public ProjectLocationAccessPolicyBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAccessPolicyBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAccessPolicyBuilder setAccessPolicy(String accessPolicy) {
      this.accessPolicy = accessPolicy;
      return this;
    }

    public AccessPolicyName build() {
      return new AccessPolicyName(this);
    }
  }
}
