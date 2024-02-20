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

package com.google.cloud.securitycentermanagement.v1;

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
  private static final PathTemplate
      ORGANIZATION_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE =
          PathTemplate.createWithoutUrlEncoding(
              "organizations/{organization}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}");
  private static final PathTemplate
      PROJECT_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}");
  private static final PathTemplate
      FOLDER_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE =
          PathTemplate.createWithoutUrlEncoding(
              "folders/{folder}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String effectiveSecurityHealthAnalyticsCustomModule;
  private final String project;
  private final String folder;

  @Deprecated
  protected EffectiveSecurityHealthAnalyticsCustomModuleName() {
    organization = null;
    location = null;
    effectiveSecurityHealthAnalyticsCustomModule = null;
    project = null;
    folder = null;
  }

  private EffectiveSecurityHealthAnalyticsCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    effectiveSecurityHealthAnalyticsCustomModule =
        Preconditions.checkNotNull(builder.getEffectiveSecurityHealthAnalyticsCustomModule());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE;
  }

  private EffectiveSecurityHealthAnalyticsCustomModuleName(
      ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    effectiveSecurityHealthAnalyticsCustomModule =
        Preconditions.checkNotNull(builder.getEffectiveSecurityHealthAnalyticsCustomModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE;
  }

  private EffectiveSecurityHealthAnalyticsCustomModuleName(
      FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    effectiveSecurityHealthAnalyticsCustomModule =
        Preconditions.checkNotNull(builder.getEffectiveSecurityHealthAnalyticsCustomModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getEffectiveSecurityHealthAnalyticsCustomModule() {
    return effectiveSecurityHealthAnalyticsCustomModule;
  }

  public String getProject() {
    return project;
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder
      newOrganizationLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder
      newProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder() {
    return new ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder
      newFolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder() {
    return new FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EffectiveSecurityHealthAnalyticsCustomModuleName of(
      String organization, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveSecurityHealthAnalyticsCustomModuleName
      ofOrganizationLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
          String organization,
          String location,
          String effectiveSecurityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveSecurityHealthAnalyticsCustomModuleName
      ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
          String project, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EffectiveSecurityHealthAnalyticsCustomModuleName
      ofFolderLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
          String folder, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newFolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build();
  }

  public static String format(
      String organization, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
      String organization, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
      String project, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
      String folder, String location, String effectiveSecurityHealthAnalyticsCustomModule) {
    return newFolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEffectiveSecurityHealthAnalyticsCustomModule(
            effectiveSecurityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  public static EffectiveSecurityHealthAnalyticsCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(
        formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.match(
              formattedString);
      return ofOrganizationLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("effective_security_health_analytics_custom_module"));
    } else if (PROJECT_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(
        formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.match(formattedString);
      return ofProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("effective_security_health_analytics_custom_module"));
    } else if (FOLDER_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(
        formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.match(formattedString);
      return ofFolderLocationEffectiveSecurityHealthAnalyticsCustomModuleName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("effective_security_health_analytics_custom_module"));
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
    return ORGANIZATION_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(
            formattedString)
        || PROJECT_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(
            formattedString)
        || FOLDER_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(
            formattedString);
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
          if (effectiveSecurityHealthAnalyticsCustomModule != null) {
            fieldMapBuilder.put(
                "effective_security_health_analytics_custom_module",
                effectiveSecurityHealthAnalyticsCustomModule);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.effectiveSecurityHealthAnalyticsCustomModule,
              that.effectiveSecurityHealthAnalyticsCustomModule)
          && Objects.equals(this.project, that.project)
          && Objects.equals(this.folder, that.folder);
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
    h ^= Objects.hashCode(effectiveSecurityHealthAnalyticsCustomModule);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String effectiveSecurityHealthAnalyticsCustomModule;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getEffectiveSecurityHealthAnalyticsCustomModule() {
      return effectiveSecurityHealthAnalyticsCustomModule;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEffectiveSecurityHealthAnalyticsCustomModule(
        String effectiveSecurityHealthAnalyticsCustomModule) {
      this.effectiveSecurityHealthAnalyticsCustomModule =
          effectiveSecurityHealthAnalyticsCustomModule;
      return this;
    }

    private Builder(
        EffectiveSecurityHealthAnalyticsCustomModuleName
            effectiveSecurityHealthAnalyticsCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              effectiveSecurityHealthAnalyticsCustomModuleName.pathTemplate,
              ORGANIZATION_LOCATION_EFFECTIVE_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE),
          "toBuilder is only supported when EffectiveSecurityHealthAnalyticsCustomModuleName has the pattern of organizations/{organization}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}");
      this.organization = effectiveSecurityHealthAnalyticsCustomModuleName.organization;
      this.location = effectiveSecurityHealthAnalyticsCustomModuleName.location;
      this.effectiveSecurityHealthAnalyticsCustomModule =
          effectiveSecurityHealthAnalyticsCustomModuleName
              .effectiveSecurityHealthAnalyticsCustomModule;
    }

    public EffectiveSecurityHealthAnalyticsCustomModuleName build() {
      return new EffectiveSecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder {
    private String project;
    private String location;
    private String effectiveSecurityHealthAnalyticsCustomModule;

    protected ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEffectiveSecurityHealthAnalyticsCustomModule() {
      return effectiveSecurityHealthAnalyticsCustomModule;
    }

    public ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder setProject(
        String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder
        setEffectiveSecurityHealthAnalyticsCustomModule(
            String effectiveSecurityHealthAnalyticsCustomModule) {
      this.effectiveSecurityHealthAnalyticsCustomModule =
          effectiveSecurityHealthAnalyticsCustomModule;
      return this;
    }

    public EffectiveSecurityHealthAnalyticsCustomModuleName build() {
      return new EffectiveSecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/effectiveSecurityHealthAnalyticsCustomModules/{effective_security_health_analytics_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder {
    private String folder;
    private String location;
    private String effectiveSecurityHealthAnalyticsCustomModule;

    protected FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getEffectiveSecurityHealthAnalyticsCustomModule() {
      return effectiveSecurityHealthAnalyticsCustomModule;
    }

    public FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder setFolder(
        String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder setLocation(
        String location) {
      this.location = location;
      return this;
    }

    public FolderLocationEffectiveSecurityHealthAnalyticsCustomModuleBuilder
        setEffectiveSecurityHealthAnalyticsCustomModule(
            String effectiveSecurityHealthAnalyticsCustomModule) {
      this.effectiveSecurityHealthAnalyticsCustomModule =
          effectiveSecurityHealthAnalyticsCustomModule;
      return this;
    }

    public EffectiveSecurityHealthAnalyticsCustomModuleName build() {
      return new EffectiveSecurityHealthAnalyticsCustomModuleName(this);
    }
  }
}
