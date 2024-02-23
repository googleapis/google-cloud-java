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
public class SecurityHealthAnalyticsCustomModuleName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}");
  private static final PathTemplate PROJECT_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}");
  private static final PathTemplate FOLDER_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String securityHealthAnalyticsCustomModule;
  private final String project;
  private final String folder;

  @Deprecated
  protected SecurityHealthAnalyticsCustomModuleName() {
    organization = null;
    location = null;
    securityHealthAnalyticsCustomModule = null;
    project = null;
    folder = null;
  }

  private SecurityHealthAnalyticsCustomModuleName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityHealthAnalyticsCustomModule =
        Preconditions.checkNotNull(builder.getSecurityHealthAnalyticsCustomModule());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE;
  }

  private SecurityHealthAnalyticsCustomModuleName(
      ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityHealthAnalyticsCustomModule =
        Preconditions.checkNotNull(builder.getSecurityHealthAnalyticsCustomModule());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE;
  }

  private SecurityHealthAnalyticsCustomModuleName(
      FolderLocationSecurityHealthAnalyticsCustomModuleBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityHealthAnalyticsCustomModule =
        Preconditions.checkNotNull(builder.getSecurityHealthAnalyticsCustomModule());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getSecurityHealthAnalyticsCustomModule() {
    return securityHealthAnalyticsCustomModule;
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
  public static Builder newOrganizationLocationSecurityHealthAnalyticsCustomModuleBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder
      newProjectLocationSecurityHealthAnalyticsCustomModuleBuilder() {
    return new ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationSecurityHealthAnalyticsCustomModuleBuilder
      newFolderLocationSecurityHealthAnalyticsCustomModuleBuilder() {
    return new FolderLocationSecurityHealthAnalyticsCustomModuleBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecurityHealthAnalyticsCustomModuleName of(
      String organization, String location, String securityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsCustomModuleName
      ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
          String organization, String location, String securityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsCustomModuleName
      ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
          String project, String location, String securityHealthAnalyticsCustomModule) {
    return newProjectLocationSecurityHealthAnalyticsCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SecurityHealthAnalyticsCustomModuleName
      ofFolderLocationSecurityHealthAnalyticsCustomModuleName(
          String folder, String location, String securityHealthAnalyticsCustomModule) {
    return newFolderLocationSecurityHealthAnalyticsCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build();
  }

  public static String format(
      String organization, String location, String securityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
      String organization, String location, String securityHealthAnalyticsCustomModule) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationSecurityHealthAnalyticsCustomModuleName(
      String project, String location, String securityHealthAnalyticsCustomModule) {
    return newProjectLocationSecurityHealthAnalyticsCustomModuleBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationSecurityHealthAnalyticsCustomModuleName(
      String folder, String location, String securityHealthAnalyticsCustomModule) {
    return newFolderLocationSecurityHealthAnalyticsCustomModuleBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setSecurityHealthAnalyticsCustomModule(securityHealthAnalyticsCustomModule)
        .build()
        .toString();
  }

  public static SecurityHealthAnalyticsCustomModuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.match(formattedString);
      return ofOrganizationLocationSecurityHealthAnalyticsCustomModuleName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("security_health_analytics_custom_module"));
    } else if (PROJECT_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.match(formattedString);
      return ofProjectLocationSecurityHealthAnalyticsCustomModuleName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("security_health_analytics_custom_module"));
    } else if (FOLDER_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.match(formattedString);
      return ofFolderLocationSecurityHealthAnalyticsCustomModuleName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("security_health_analytics_custom_module"));
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
    return ORGANIZATION_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(formattedString)
        || PROJECT_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(formattedString)
        || FOLDER_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE.matches(formattedString);
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
          if (securityHealthAnalyticsCustomModule != null) {
            fieldMapBuilder.put(
                "security_health_analytics_custom_module", securityHealthAnalyticsCustomModule);
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
      SecurityHealthAnalyticsCustomModuleName that = ((SecurityHealthAnalyticsCustomModuleName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(
              this.securityHealthAnalyticsCustomModule, that.securityHealthAnalyticsCustomModule)
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
    h ^= Objects.hashCode(securityHealthAnalyticsCustomModule);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String securityHealthAnalyticsCustomModule;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityHealthAnalyticsCustomModule() {
      return securityHealthAnalyticsCustomModule;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSecurityHealthAnalyticsCustomModule(
        String securityHealthAnalyticsCustomModule) {
      this.securityHealthAnalyticsCustomModule = securityHealthAnalyticsCustomModule;
      return this;
    }

    private Builder(
        SecurityHealthAnalyticsCustomModuleName securityHealthAnalyticsCustomModuleName) {
      Preconditions.checkArgument(
          Objects.equals(
              securityHealthAnalyticsCustomModuleName.pathTemplate,
              ORGANIZATION_LOCATION_SECURITY_HEALTH_ANALYTICS_CUSTOM_MODULE),
          "toBuilder is only supported when SecurityHealthAnalyticsCustomModuleName has the pattern of organizations/{organization}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}");
      this.organization = securityHealthAnalyticsCustomModuleName.organization;
      this.location = securityHealthAnalyticsCustomModuleName.location;
      this.securityHealthAnalyticsCustomModule =
          securityHealthAnalyticsCustomModuleName.securityHealthAnalyticsCustomModule;
    }

    public SecurityHealthAnalyticsCustomModuleName build() {
      return new SecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder {
    private String project;
    private String location;
    private String securityHealthAnalyticsCustomModule;

    protected ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityHealthAnalyticsCustomModule() {
      return securityHealthAnalyticsCustomModule;
    }

    public ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSecurityHealthAnalyticsCustomModuleBuilder
        setSecurityHealthAnalyticsCustomModule(String securityHealthAnalyticsCustomModule) {
      this.securityHealthAnalyticsCustomModule = securityHealthAnalyticsCustomModule;
      return this;
    }

    public SecurityHealthAnalyticsCustomModuleName build() {
      return new SecurityHealthAnalyticsCustomModuleName(this);
    }
  }

  /**
   * Builder for
   * folders/{folder}/locations/{location}/securityHealthAnalyticsCustomModules/{security_health_analytics_custom_module}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationSecurityHealthAnalyticsCustomModuleBuilder {
    private String folder;
    private String location;
    private String securityHealthAnalyticsCustomModule;

    protected FolderLocationSecurityHealthAnalyticsCustomModuleBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityHealthAnalyticsCustomModule() {
      return securityHealthAnalyticsCustomModule;
    }

    public FolderLocationSecurityHealthAnalyticsCustomModuleBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationSecurityHealthAnalyticsCustomModuleBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationSecurityHealthAnalyticsCustomModuleBuilder
        setSecurityHealthAnalyticsCustomModule(String securityHealthAnalyticsCustomModule) {
      this.securityHealthAnalyticsCustomModule = securityHealthAnalyticsCustomModule;
      return this;
    }

    public SecurityHealthAnalyticsCustomModuleName build() {
      return new SecurityHealthAnalyticsCustomModuleName(this);
    }
  }
}
