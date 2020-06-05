/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.monitoring.v3;

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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class UptimeCheckConfigName implements ResourceName {

  @Deprecated
  protected UptimeCheckConfigName() {}

  private static final PathTemplate PROJECT_UPTIME_CHECK_CONFIG_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/uptimeCheckConfigs/{uptime_check_config}");
  private static final PathTemplate ORGANIZATION_UPTIME_CHECK_CONFIG_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/uptimeCheckConfigs/{uptime_check_config}");
  private static final PathTemplate FOLDER_UPTIME_CHECK_CONFIG_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/uptimeCheckConfigs/{uptime_check_config}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String uptimeCheckConfig;
  private String organization;
  private String folder;

  public String getProject() {
    return project;
  }

  public String getUptimeCheckConfig() {
    return uptimeCheckConfig;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  private UptimeCheckConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    uptimeCheckConfig = Preconditions.checkNotNull(builder.getUptimeCheckConfig());
    pathTemplate = PROJECT_UPTIME_CHECK_CONFIG_PATH_TEMPLATE;
  }

  private UptimeCheckConfigName(OrganizationUptimeCheckConfigBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    uptimeCheckConfig = Preconditions.checkNotNull(builder.getUptimeCheckConfig());
    pathTemplate = ORGANIZATION_UPTIME_CHECK_CONFIG_PATH_TEMPLATE;
  }

  private UptimeCheckConfigName(FolderUptimeCheckConfigBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    uptimeCheckConfig = Preconditions.checkNotNull(builder.getUptimeCheckConfig());
    pathTemplate = FOLDER_UPTIME_CHECK_CONFIG_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectUptimeCheckConfigBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationUptimeCheckConfigBuilder newOrganizationUptimeCheckConfigBuilder() {
    return new OrganizationUptimeCheckConfigBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderUptimeCheckConfigBuilder newFolderUptimeCheckConfigBuilder() {
    return new FolderUptimeCheckConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UptimeCheckConfigName of(String project, String uptimeCheckConfig) {
    return newProjectUptimeCheckConfigBuilder()
        .setProject(project)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static UptimeCheckConfigName ofProjectUptimeCheckConfigName(
      String project, String uptimeCheckConfig) {
    return newProjectUptimeCheckConfigBuilder()
        .setProject(project)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static UptimeCheckConfigName ofOrganizationUptimeCheckConfigName(
      String organization, String uptimeCheckConfig) {
    return newOrganizationUptimeCheckConfigBuilder()
        .setOrganization(organization)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static UptimeCheckConfigName ofFolderUptimeCheckConfigName(
      String folder, String uptimeCheckConfig) {
    return newFolderUptimeCheckConfigBuilder()
        .setFolder(folder)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build();
  }

  public static String format(String project, String uptimeCheckConfig) {
    return newBuilder()
        .setProject(project)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectUptimeCheckConfigName(
      String project, String uptimeCheckConfig) {
    return newBuilder()
        .setProject(project)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationUptimeCheckConfigName(
      String organization, String uptimeCheckConfig) {
    return newOrganizationUptimeCheckConfigBuilder()
        .setOrganization(organization)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderUptimeCheckConfigName(String folder, String uptimeCheckConfig) {
    return newFolderUptimeCheckConfigBuilder()
        .setFolder(folder)
        .setUptimeCheckConfig(uptimeCheckConfig)
        .build()
        .toString();
  }

  public static UptimeCheckConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.match(formattedString);
      return ofProjectUptimeCheckConfigName(
          matchMap.get("project"), matchMap.get("uptime_check_config"));
    } else if (ORGANIZATION_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationUptimeCheckConfigName(
          matchMap.get("organization"), matchMap.get("uptime_check_config"));
    } else if (FOLDER_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.match(formattedString);
      return ofFolderUptimeCheckConfigName(
          matchMap.get("folder"), matchMap.get("uptime_check_config"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<UptimeCheckConfigName> parseList(List<String> formattedStrings) {
    List<UptimeCheckConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UptimeCheckConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UptimeCheckConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.matches(formattedString)
        || ORGANIZATION_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.matches(formattedString)
        || FOLDER_UPTIME_CHECK_CONFIG_PATH_TEMPLATE.matches(formattedString);
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
          if (uptimeCheckConfig != null) {
            fieldMapBuilder.put("uptime_check_config", uptimeCheckConfig);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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

  /** Builder for projects/{project}/uptimeCheckConfigs/{uptime_check_config}. */
  public static class Builder {

    private String project;
    private String uptimeCheckConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getUptimeCheckConfig() {
      return uptimeCheckConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setUptimeCheckConfig(String uptimeCheckConfig) {
      this.uptimeCheckConfig = uptimeCheckConfig;
      return this;
    }

    private Builder(UptimeCheckConfigName uptimeCheckConfigName) {
      Preconditions.checkArgument(
          uptimeCheckConfigName.pathTemplate == PROJECT_UPTIME_CHECK_CONFIG_PATH_TEMPLATE,
          "toBuilder is only supported when UptimeCheckConfigName has the pattern of "
              + "projects/{project}/uptimeCheckConfigs/{uptime_check_config}.");
      project = uptimeCheckConfigName.project;
      uptimeCheckConfig = uptimeCheckConfigName.uptimeCheckConfig;
    }

    public UptimeCheckConfigName build() {
      return new UptimeCheckConfigName(this);
    }
  }

  /** Builder for organizations/{organization}/uptimeCheckConfigs/{uptime_check_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationUptimeCheckConfigBuilder {

    private String organization;
    private String uptimeCheckConfig;

    private OrganizationUptimeCheckConfigBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getUptimeCheckConfig() {
      return uptimeCheckConfig;
    }

    public OrganizationUptimeCheckConfigBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationUptimeCheckConfigBuilder setUptimeCheckConfig(String uptimeCheckConfig) {
      this.uptimeCheckConfig = uptimeCheckConfig;
      return this;
    }

    public UptimeCheckConfigName build() {
      return new UptimeCheckConfigName(this);
    }
  }

  /** Builder for folders/{folder}/uptimeCheckConfigs/{uptime_check_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderUptimeCheckConfigBuilder {

    private String folder;
    private String uptimeCheckConfig;

    private FolderUptimeCheckConfigBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getUptimeCheckConfig() {
      return uptimeCheckConfig;
    }

    public FolderUptimeCheckConfigBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderUptimeCheckConfigBuilder setUptimeCheckConfig(String uptimeCheckConfig) {
      this.uptimeCheckConfig = uptimeCheckConfig;
      return this;
    }

    public UptimeCheckConfigName build() {
      return new UptimeCheckConfigName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      UptimeCheckConfigName that = (UptimeCheckConfigName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.uptimeCheckConfig, that.uptimeCheckConfig))
          && (Objects.equals(this.organization, that.organization))
          && (Objects.equals(this.folder, that.folder));
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
    h ^= Objects.hashCode(uptimeCheckConfig);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }
}
