/*
 * Copyright 2025 Google LLC
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
public class EffectiveEventThreatDetectionCustomModuleName implements ResourceName {
  private static final PathTemplate ORGANIZATION_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/eventThreatDetectionSettings/effectiveCustomModules/{module}");
  private static final PathTemplate FOLDER_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/eventThreatDetectionSettings/effectiveCustomModules/{module}");
  private static final PathTemplate PROJECT_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/eventThreatDetectionSettings/effectiveCustomModules/{module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String module;
  private final String folder;
  private final String project;

  @Deprecated
  protected EffectiveEventThreatDetectionCustomModuleName() {
    organization = null;
    module = null;
    folder = null;
    project = null;
  }

  private EffectiveEventThreatDetectionCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    module = Preconditions.checkNotNull(builder.getModule());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_MODULE;
  }

  private EffectiveEventThreatDetectionCustomModuleName(FolderModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    module = Preconditions.checkNotNull(builder.getModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_MODULE;
  }

  private EffectiveEventThreatDetectionCustomModuleName(ProjectModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    module = Preconditions.checkNotNull(builder.getModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getModule() {
    return module;
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

  public static Builder newOrganizationModuleBuilder() {
    return new Builder();
  }

  public static FolderModuleBuilder newFolderModuleBuilder() {
    return new FolderModuleBuilder();
  }

  public static ProjectModuleBuilder newProjectModuleBuilder() {
    return new ProjectModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EffectiveEventThreatDetectionCustomModuleName of(
      String organization, String module) {
    return newBuilder().setOrganization(organization).setModule(module).build();
  }

  public static EffectiveEventThreatDetectionCustomModuleName ofOrganizationModuleName(
      String organization, String module) {
    return newBuilder().setOrganization(organization).setModule(module).build();
  }

  public static EffectiveEventThreatDetectionCustomModuleName ofFolderModuleName(
      String folder, String module) {
    return newFolderModuleBuilder().setFolder(folder).setModule(module).build();
  }

  public static EffectiveEventThreatDetectionCustomModuleName ofProjectModuleName(
      String project, String module) {
    return newProjectModuleBuilder().setProject(project).setModule(module).build();
  }

  public static String format(String organization, String module) {
    return newBuilder().setOrganization(organization).setModule(module).build().toString();
  }

  public static String formatOrganizationModuleName(String organization, String module) {
    return newBuilder().setOrganization(organization).setModule(module).build().toString();
  }

  public static String formatFolderModuleName(String folder, String module) {
    return newFolderModuleBuilder().setFolder(folder).setModule(module).build().toString();
  }

  public static String formatProjectModuleName(String project, String module) {
    return newProjectModuleBuilder().setProject(project).setModule(module).build().toString();
  }

  public static EffectiveEventThreatDetectionCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_MODULE.match(formattedString);
      return ofOrganizationModuleName(matchMap.get("organization"), matchMap.get("module"));
    } else if (FOLDER_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_MODULE.match(formattedString);
      return ofFolderModuleName(matchMap.get("folder"), matchMap.get("module"));
    } else if (PROJECT_MODULE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_MODULE.match(formattedString);
      return ofProjectModuleName(matchMap.get("project"), matchMap.get("module"));
    }
    throw new ValidationException(
        "EffectiveEventThreatDetectionCustomModuleName.parse: formattedString not in valid format");
  }

  public static List<EffectiveEventThreatDetectionCustomModuleName> parseList(
      List<String> formattedStrings) {
    List<EffectiveEventThreatDetectionCustomModuleName> list =
        new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(
      List<EffectiveEventThreatDetectionCustomModuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EffectiveEventThreatDetectionCustomModuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_MODULE.matches(formattedString)
        || FOLDER_MODULE.matches(formattedString)
        || PROJECT_MODULE.matches(formattedString);
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
          if (module != null) {
            fieldMapBuilder.put("module", module);
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
      EffectiveEventThreatDetectionCustomModuleName that =
          ((EffectiveEventThreatDetectionCustomModuleName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.module, that.module)
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
    h ^= Objects.hashCode(module);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/eventThreatDetectionSettings/effectiveCustomModules/{module}.
   */
  public static class Builder {
    private String organization;
    private String module;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getModule() {
      return module;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setModule(String module) {
      this.module = module;
      return this;
    }

    private Builder(
        EffectiveEventThreatDetectionCustomModuleName
            effectiveEventThreatDetectionCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              effectiveEventThreatDetectionCustomModuleName.pathTemplate, ORGANIZATION_MODULE),
          "toBuilder is only supported when EffectiveEventThreatDetectionCustomModuleName has the pattern of organizations/{organization}/eventThreatDetectionSettings/effectiveCustomModules/{module}");
      this.organization = effectiveEventThreatDetectionCustomModuleName.organization;
      this.module = effectiveEventThreatDetectionCustomModuleName.module;
    }

    public EffectiveEventThreatDetectionCustomModuleName build() {
      return new EffectiveEventThreatDetectionCustomModuleName(this);
    }
  }

  /** Builder for folders/{folder}/eventThreatDetectionSettings/effectiveCustomModules/{module}. */
  public static class FolderModuleBuilder {
    private String folder;
    private String module;

    protected FolderModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getModule() {
      return module;
    }

    public FolderModuleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderModuleBuilder setModule(String module) {
      this.module = module;
      return this;
    }

    public EffectiveEventThreatDetectionCustomModuleName build() {
      return new EffectiveEventThreatDetectionCustomModuleName(this);
    }
  }

  /**
   * Builder for projects/{project}/eventThreatDetectionSettings/effectiveCustomModules/{module}.
   */
  public static class ProjectModuleBuilder {
    private String project;
    private String module;

    protected ProjectModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getModule() {
      return module;
    }

    public ProjectModuleBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectModuleBuilder setModule(String module) {
      this.module = module;
      return this;
    }

    public EffectiveEventThreatDetectionCustomModuleName build() {
      return new EffectiveEventThreatDetectionCustomModuleName(this);
    }
  }
}
