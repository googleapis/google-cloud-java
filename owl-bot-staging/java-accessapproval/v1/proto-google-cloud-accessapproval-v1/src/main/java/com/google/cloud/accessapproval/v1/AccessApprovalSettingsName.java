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

package com.google.cloud.accessapproval.v1;

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
public class AccessApprovalSettingsName implements ResourceName {
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/accessApprovalSettings");
  private static final PathTemplate FOLDER =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/accessApprovalSettings");
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/accessApprovalSettings");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String folder;
  private final String organization;

  @Deprecated
  protected AccessApprovalSettingsName() {
    project = null;
    folder = null;
    organization = null;
  }

  private AccessApprovalSettingsName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    folder = null;
    organization = null;
    pathTemplate = PROJECT;
  }

  private AccessApprovalSettingsName(FolderBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    project = null;
    organization = null;
    pathTemplate = FOLDER;
  }

  private AccessApprovalSettingsName(OrganizationBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION;
  }

  public String getProject() {
    return project;
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
  public static Builder newProjectBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderBuilder newFolderBuilder() {
    return new FolderBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationBuilder newOrganizationBuilder() {
    return new OrganizationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccessApprovalSettingsName of(String project) {
    return newBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AccessApprovalSettingsName ofProjectName(String project) {
    return newBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AccessApprovalSettingsName ofFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static AccessApprovalSettingsName ofOrganizationName(String organization) {
    return newOrganizationBuilder().setOrganization(organization).build();
  }

  public static String format(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectName(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationName(String organization) {
    return newOrganizationBuilder().setOrganization(organization).build().toString();
  }

  public static AccessApprovalSettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    } else if (FOLDER.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER.match(formattedString);
      return ofFolderName(matchMap.get("folder"));
    } else if (ORGANIZATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION.match(formattedString);
      return ofOrganizationName(matchMap.get("organization"));
    }
    throw new ValidationException(
        "AccessApprovalSettingsName.parse: formattedString not in valid format");
  }

  public static List<AccessApprovalSettingsName> parseList(List<String> formattedStrings) {
    List<AccessApprovalSettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccessApprovalSettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccessApprovalSettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT.matches(formattedString)
        || FOLDER.matches(formattedString)
        || ORGANIZATION.matches(formattedString);
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
      AccessApprovalSettingsName that = ((AccessApprovalSettingsName) o);
      return Objects.equals(this.project, that.project)
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/accessApprovalSettings. */
  public static class Builder {
    private String project;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder(AccessApprovalSettingsName accessApprovalSettingsName) {
      Preconditions.checkArgument(
          Objects.equals(accessApprovalSettingsName.pathTemplate, PROJECT),
          "toBuilder is only supported when AccessApprovalSettingsName has the pattern of projects/{project}/accessApprovalSettings");
      this.project = accessApprovalSettingsName.project;
    }

    public AccessApprovalSettingsName build() {
      return new AccessApprovalSettingsName(this);
    }
  }

  /** Builder for folders/{folder}/accessApprovalSettings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderBuilder {
    private String folder;

    protected FolderBuilder() {}

    public String getFolder() {
      return folder;
    }

    public FolderBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public AccessApprovalSettingsName build() {
      return new AccessApprovalSettingsName(this);
    }
  }

  /** Builder for organizations/{organization}/accessApprovalSettings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationBuilder {
    private String organization;

    protected OrganizationBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public OrganizationBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public AccessApprovalSettingsName build() {
      return new AccessApprovalSettingsName(this);
    }
  }
}
