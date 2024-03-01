/*
 * Copyright 2024 Google LLC
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
public class SecurityHealthAnalyticsCustomModuleName implements ResourceName {
  private static final PathTemplate ORGANIZATION_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/securityHealthAnalyticsSettings/customModules/{custom_module}");
  private static final PathTemplate FOLDER_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/securityHealthAnalyticsSettings/customModules/{custom_module}");
  private static final PathTemplate PROJECT_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/securityHealthAnalyticsSettings/customModules/{custom_module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String customModule;
  private final String folder;
  private final String project;

  @Deprecated
  protected SecurityHealthAnalyticsCustomModuleName() {
    organization = null;
    customModule = null;
    folder = null;
    project = null;
  }

  private SecurityHealthAnalyticsCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    customModule = Preconditions.checkNotNull(builder.getCustomModule());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_CUSTOM_MODULE;
  }

  private SecurityHealthAnalyticsCustomModuleName(FolderCustomModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    customModule = Preconditions.checkNotNull(builder.getCustomModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_CUSTOM_MODULE;
  }

  private SecurityHealthAnalyticsCustomModuleName(ProjectCustomModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    customModule = Preconditions.checkNotNull(builder.getCustomModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_CUSTOM_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getCustomModule() {
    return customModule;
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
  public static Builder newOrganizationCustomModuleBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderCustomModuleBuilder newFolderCustomModuleBuilder() {
    return new FolderCustomModuleBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectCustomModuleBuilder newProjectCustomModuleBuilder() {
    return new ProjectCustomModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecurityHealthAnalyticsCustomModuleName of(
      String organization, String customModule) {
    return newBuilder().setOrganization(organization).setCustomModule(customModule).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsCustomModuleName ofOrganizationCustomModuleName(
      String organization, String customModule) {
    return newBuilder().setOrganization(organization).setCustomModule(customModule).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsCustomModuleName ofFolderCustomModuleName(
      String folder, String customModule) {
    return newFolderCustomModuleBuilder().setFolder(folder).setCustomModule(customModule).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsCustomModuleName ofProjectCustomModuleName(
      String project, String customModule) {
    return newProjectCustomModuleBuilder()
        .setProject(project)
        .setCustomModule(customModule)
        .build();
  }

  public static String format(String organization, String customModule) {
    return newBuilder()
        .setOrganization(organization)
        .setCustomModule(customModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationCustomModuleName(
      String organization, String customModule) {
    return newBuilder()
        .setOrganization(organization)
        .setCustomModule(customModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderCustomModuleName(String folder, String customModule) {
    return newFolderCustomModuleBuilder()
        .setFolder(folder)
        .setCustomModule(customModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectCustomModuleName(String project, String customModule) {
    return newProjectCustomModuleBuilder()
        .setProject(project)
        .setCustomModule(customModule)
        .build()
        .toString();
  }

  public static SecurityHealthAnalyticsCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CUSTOM_MODULE.match(formattedString);
      return ofOrganizationCustomModuleName(
          matchMap.get("organization"), matchMap.get("custom_module"));
    } else if (FOLDER_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_CUSTOM_MODULE.match(formattedString);
      return ofFolderCustomModuleName(matchMap.get("folder"), matchMap.get("custom_module"));
    } else if (PROJECT_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CUSTOM_MODULE.match(formattedString);
      return ofProjectCustomModuleName(matchMap.get("project"), matchMap.get("custom_module"));
    }
    throw new ValidationException(
        "SecurityHealthAnalyticsCustomModuleName.parse: formattedString not in valid format");
  }

  public static List<SecurityHealthAnalyticsCustomModuleName> parseList(
      List<String> formattedStrings) {
    List<SecurityHealthAnalyticsCustomModuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecurityHealthAnalyticsCustomModuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecurityHealthAnalyticsCustomModuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_CUSTOM_MODULE.matches(formattedString)
        || FOLDER_CUSTOM_MODULE.matches(formattedString)
        || PROJECT_CUSTOM_MODULE.matches(formattedString);
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
          if (customModule != null) {
            fieldMapBuilder.put("custom_module", customModule);
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
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SecurityHealthAnalyticsCustomModuleName that = ((SecurityHealthAnalyticsCustomModuleName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.customModule, that.customModule)
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
    h ^= Objects.hashCode(customModule);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/securityHealthAnalyticsSettings/customModules/{custom_module}.
   */
  public static class Builder {
    private String organization;
    private String customModule;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getCustomModule() {
      return customModule;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setCustomModule(String customModule) {
      this.customModule = customModule;
      return this;
    }

    private Builder(
        SecurityHealthAnalyticsCustomModuleName securityHealthAnalyticsCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              securityHealthAnalyticsCustomModuleName.pathTemplate, ORGANIZATION_CUSTOM_MODULE),
          "toBuilder is only supported when SecurityHealthAnalyticsCustomModuleName has the pattern of organizations/{organization}/securityHealthAnalyticsSettings/customModules/{custom_module}");
      this.organization = securityHealthAnalyticsCustomModuleName.organization;
      this.customModule = securityHealthAnalyticsCustomModuleName.customModule;
    }

    public SecurityHealthAnalyticsCustomModuleName build() {
      return new SecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /** Builder for folders/{folder}/securityHealthAnalyticsSettings/customModules/{custom_module}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderCustomModuleBuilder {
    private String folder;
    private String customModule;

    protected FolderCustomModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getCustomModule() {
      return customModule;
    }

    public FolderCustomModuleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderCustomModuleBuilder setCustomModule(String customModule) {
      this.customModule = customModule;
      return this;
    }

    public SecurityHealthAnalyticsCustomModuleName build() {
      return new SecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for projects/{project}/securityHealthAnalyticsSettings/customModules/{custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectCustomModuleBuilder {
    private String project;
    private String customModule;

    protected ProjectCustomModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getCustomModule() {
      return customModule;
    }

    public ProjectCustomModuleBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectCustomModuleBuilder setCustomModule(String customModule) {
      this.customModule = customModule;
      return this;
    }

    public SecurityHealthAnalyticsCustomModuleName build() {
      return new SecurityHealthAnalyticsCustomModuleName(this);
    }
  }
}
