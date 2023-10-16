/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.securitycenter.v1;

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
public class SecurityHealthAnalyticsSettingsName implements ResourceName {
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/securityHealthAnalyticsSettings");
  private static final PathTemplate FOLDER =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/securityHealthAnalyticsSettings");
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/securityHealthAnalyticsSettings");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String folder;
  private final String project;

  @Deprecated
  protected SecurityHealthAnalyticsSettingsName() {
    organization = null;
    folder = null;
    project = null;
  }

  private SecurityHealthAnalyticsSettingsName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION;
  }

  private SecurityHealthAnalyticsSettingsName(FolderBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    organization = null;
    project = null;
    pathTemplate = FOLDER;
  }

  private SecurityHealthAnalyticsSettingsName(ProjectBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    organization = null;
    folder = null;
    pathTemplate = PROJECT;
  }

  public String getOrganization() {
    return organization;
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

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderBuilder newFolderBuilder() {
    return new FolderBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectBuilder newProjectBuilder() {
    return new ProjectBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecurityHealthAnalyticsSettingsName of(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsSettingsName ofOrganizationName(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsSettingsName ofFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsSettingsName ofProjectName(String project) {
    return newProjectBuilder().setProject(project).build();
  }

  public static String format(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationName(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderName(String folder) {
    return newFolderBuilder().setFolder(folder).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectName(String project) {
    return newProjectBuilder().setProject(project).build().toString();
  }

  public static SecurityHealthAnalyticsSettingsName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION.match(formattedString);
      return ofOrganizationName(matchMap.get("organization"));
    } else if (FOLDER.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER.match(formattedString);
      return ofFolderName(matchMap.get("folder"));
    } else if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    }
    throw new ValidationException(
        "SecurityHealthAnalyticsSettingsName.parse: formattedString not in valid format");
  }

  public static List<SecurityHealthAnalyticsSettingsName> parseList(List<String> formattedStrings) {
    List<SecurityHealthAnalyticsSettingsName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecurityHealthAnalyticsSettingsName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecurityHealthAnalyticsSettingsName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION.matches(formattedString)
        || FOLDER.matches(formattedString)
        || PROJECT.matches(formattedString);
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
      SecurityHealthAnalyticsSettingsName that = ((SecurityHealthAnalyticsSettingsName) o);
      return Objects.equals(this.organization, that.organization)
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/securityHealthAnalyticsSettings. */
  public static class Builder {
    private String organization;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    private Builder(SecurityHealthAnalyticsSettingsName securityHealthAnalyticsSettingsName) {
      Preconditions.checkArgument(
          Objects.equals(securityHealthAnalyticsSettingsName.pathTemplate, ORGANIZATION),
          "toBuilder is only supported when SecurityHealthAnalyticsSettingsName has the pattern of organizations/{organization}/securityHealthAnalyticsSettings");
      this.organization = securityHealthAnalyticsSettingsName.organization;
    }

    public SecurityHealthAnalyticsSettingsName build() {
      return new SecurityHealthAnalyticsSettingsName(this);
    }
  }

  /** Builder for folders/{folder}/securityHealthAnalyticsSettings. */
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

    public SecurityHealthAnalyticsSettingsName build() {
      return new SecurityHealthAnalyticsSettingsName(this);
    }
  }

  /** Builder for projects/{project}/securityHealthAnalyticsSettings. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectBuilder {
    private String project;

    protected ProjectBuilder() {}

    public String getProject() {
      return project;
    }

    public ProjectBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public SecurityHealthAnalyticsSettingsName build() {
      return new SecurityHealthAnalyticsSettingsName(this);
    }
  }
}
