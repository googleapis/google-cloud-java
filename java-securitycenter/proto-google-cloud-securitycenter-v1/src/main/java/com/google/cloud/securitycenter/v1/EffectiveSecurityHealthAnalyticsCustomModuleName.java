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
public class EffectiveSecurityHealthAnalyticsCustomModuleName implements ResourceName {
  private static final PathTemplate ORGANIZATION_EFFECTIVE_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}");
  private static final PathTemplate FOLDER_EFFECTIVE_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}");
  private static final PathTemplate PROJECT_EFFECTIVE_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String effectiveCustomModule;
  private final String folder;
  private final String project;

  @Deprecated
  protected EffectiveSecurityHealthAnalyticsCustomModuleName() {
    organization = null;
    effectiveCustomModule = null;
    folder = null;
    project = null;
  }

  private EffectiveSecurityHealthAnalyticsCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    effectiveCustomModule = Preconditions.checkNotNull(builder.getEffectiveCustomModule());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_EFFECTIVE_CUSTOM_MODULE;
  }

  private EffectiveSecurityHealthAnalyticsCustomModuleName(
      FolderEffectiveCustomModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    effectiveCustomModule = Preconditions.checkNotNull(builder.getEffectiveCustomModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_EFFECTIVE_CUSTOM_MODULE;
  }

  private EffectiveSecurityHealthAnalyticsCustomModuleName(
      ProjectEffectiveCustomModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    effectiveCustomModule = Preconditions.checkNotNull(builder.getEffectiveCustomModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_EFFECTIVE_CUSTOM_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getEffectiveCustomModule() {
    return effectiveCustomModule;
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
  public static Builder newOrganizationEffectiveCustomModuleBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderEffectiveCustomModuleBuilder newFolderEffectiveCustomModuleBuilder() {
    return new FolderEffectiveCustomModuleBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectEffectiveCustomModuleBuilder newProjectEffectiveCustomModuleBuilder() {
    return new ProjectEffectiveCustomModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EffectiveSecurityHealthAnalyticsCustomModuleName of(
      String organization, String effectiveCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveSecurityHealthAnalyticsCustomModuleName
      ofOrganizationEffectiveCustomModuleName(String organization, String effectiveCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveSecurityHealthAnalyticsCustomModuleName ofFolderEffectiveCustomModuleName(
      String folder, String effectiveCustomModule) {
    return newFolderEffectiveCustomModuleBuilder()
        .setFolder(folder)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveSecurityHealthAnalyticsCustomModuleName ofProjectEffectiveCustomModuleName(
      String project, String effectiveCustomModule) {
    return newProjectEffectiveCustomModuleBuilder()
        .setProject(project)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build();
  }

  public static String format(String organization, String effectiveCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationEffectiveCustomModuleName(
      String organization, String effectiveCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderEffectiveCustomModuleName(
      String folder, String effectiveCustomModule) {
    return newFolderEffectiveCustomModuleBuilder()
        .setFolder(folder)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectEffectiveCustomModuleName(
      String project, String effectiveCustomModule) {
    return newProjectEffectiveCustomModuleBuilder()
        .setProject(project)
        .setEffectiveCustomModule(effectiveCustomModule)
        .build()
        .toString();
  }

  public static EffectiveSecurityHealthAnalyticsCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_EFFECTIVE_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_EFFECTIVE_CUSTOM_MODULE.match(formattedString);
      return ofOrganizationEffectiveCustomModuleName(
          matchMap.get("organization"), matchMap.get("effective_custom_module"));
    } else if (FOLDER_EFFECTIVE_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_EFFECTIVE_CUSTOM_MODULE.match(formattedString);
      return ofFolderEffectiveCustomModuleName(
          matchMap.get("folder"), matchMap.get("effective_custom_module"));
    } else if (PROJECT_EFFECTIVE_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_EFFECTIVE_CUSTOM_MODULE.match(formattedString);
      return ofProjectEffectiveCustomModuleName(
          matchMap.get("project"), matchMap.get("effective_custom_module"));
    }
    throw new ValidationException(
        "EffectiveSecurityHealthAnalyticsCustomModuleName.parse: formattedString not in valid format");
  }

  public static List<EffectiveSecurityHealthAnalyticsCustomModuleName> parseList(
      List<String> formattedStrings) {
    List<EffectiveSecurityHealthAnalyticsCustomModuleName> list =
        new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(
      List<EffectiveSecurityHealthAnalyticsCustomModuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EffectiveSecurityHealthAnalyticsCustomModuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_EFFECTIVE_CUSTOM_MODULE.matches(formattedString)
        || FOLDER_EFFECTIVE_CUSTOM_MODULE.matches(formattedString)
        || PROJECT_EFFECTIVE_CUSTOM_MODULE.matches(formattedString);
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
          if (effectiveCustomModule != null) {
            fieldMapBuilder.put("effective_custom_module", effectiveCustomModule);
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
      EffectiveSecurityHealthAnalyticsCustomModuleName that =
          ((EffectiveSecurityHealthAnalyticsCustomModuleName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.effectiveCustomModule, that.effectiveCustomModule)
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
    h ^= Objects.hashCode(effectiveCustomModule);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}.
   */
  public static class Builder {
    private String organization;
    private String effectiveCustomModule;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getEffectiveCustomModule() {
      return effectiveCustomModule;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setEffectiveCustomModule(String effectiveCustomModule) {
      this.effectiveCustomModule = effectiveCustomModule;
      return this;
    }

    private Builder(
        EffectiveSecurityHealthAnalyticsCustomModuleName
            effectiveSecurityHealthAnalyticsCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              effectiveSecurityHealthAnalyticsCustomModuleName.pathTemplate,
              ORGANIZATION_EFFECTIVE_CUSTOM_MODULE),
          "toBuilder is only supported when EffectiveSecurityHealthAnalyticsCustomModuleName has the pattern of organizations/{organization}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}");
      this.organization = effectiveSecurityHealthAnalyticsCustomModuleName.organization;
      this.effectiveCustomModule =
          effectiveSecurityHealthAnalyticsCustomModuleName.effectiveCustomModule;
    }

    public EffectiveSecurityHealthAnalyticsCustomModuleName build() {
      return new EffectiveSecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderEffectiveCustomModuleBuilder {
    private String folder;
    private String effectiveCustomModule;

    protected FolderEffectiveCustomModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getEffectiveCustomModule() {
      return effectiveCustomModule;
    }

    public FolderEffectiveCustomModuleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderEffectiveCustomModuleBuilder setEffectiveCustomModule(
        String effectiveCustomModule) {
      this.effectiveCustomModule = effectiveCustomModule;
      return this;
    }

    public EffectiveSecurityHealthAnalyticsCustomModuleName build() {
      return new EffectiveSecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/securityHealthAnalyticsSettings/effectiveCustomModules/{effective_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectEffectiveCustomModuleBuilder {
    private String project;
    private String effectiveCustomModule;

    protected ProjectEffectiveCustomModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getEffectiveCustomModule() {
      return effectiveCustomModule;
    }

    public ProjectEffectiveCustomModuleBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectEffectiveCustomModuleBuilder setEffectiveCustomModule(
        String effectiveCustomModule) {
      this.effectiveCustomModule = effectiveCustomModule;
      return this;
    }

    public EffectiveSecurityHealthAnalyticsCustomModuleName build() {
      return new EffectiveSecurityHealthAnalyticsCustomModuleName(this);
    }
  }
}
