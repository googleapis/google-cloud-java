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
public class MuteConfigName implements ResourceName {
  private static final PathTemplate ORGANIZATION_MUTE_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/muteConfigs/{mute_config}");
  private static final PathTemplate FOLDER_MUTE_CONFIG =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/muteConfigs/{mute_config}");
  private static final PathTemplate PROJECT_MUTE_CONFIG =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/muteConfigs/{mute_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String muteConfig;
  private final String folder;
  private final String project;

  @Deprecated
  protected MuteConfigName() {
    organization = null;
    muteConfig = null;
    folder = null;
    project = null;
  }

  private MuteConfigName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    muteConfig = Preconditions.checkNotNull(builder.getMuteConfig());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_MUTE_CONFIG;
  }

  private MuteConfigName(FolderMuteConfigBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    muteConfig = Preconditions.checkNotNull(builder.getMuteConfig());
    organization = null;
    project = null;
    pathTemplate = FOLDER_MUTE_CONFIG;
  }

  private MuteConfigName(ProjectMuteConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    muteConfig = Preconditions.checkNotNull(builder.getMuteConfig());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_MUTE_CONFIG;
  }

  public String getOrganization() {
    return organization;
  }

  public String getMuteConfig() {
    return muteConfig;
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
  public static Builder newOrganizationMuteConfigBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderMuteConfigBuilder newFolderMuteConfigBuilder() {
    return new FolderMuteConfigBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectMuteConfigBuilder newProjectMuteConfigBuilder() {
    return new ProjectMuteConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MuteConfigName of(String organization, String muteConfig) {
    return newBuilder().setOrganization(organization).setMuteConfig(muteConfig).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MuteConfigName ofOrganizationMuteConfigName(
      String organization, String muteConfig) {
    return newBuilder().setOrganization(organization).setMuteConfig(muteConfig).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MuteConfigName ofFolderMuteConfigName(String folder, String muteConfig) {
    return newFolderMuteConfigBuilder().setFolder(folder).setMuteConfig(muteConfig).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MuteConfigName ofProjectMuteConfigName(String project, String muteConfig) {
    return newProjectMuteConfigBuilder().setProject(project).setMuteConfig(muteConfig).build();
  }

  public static String format(String organization, String muteConfig) {
    return newBuilder().setOrganization(organization).setMuteConfig(muteConfig).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationMuteConfigName(String organization, String muteConfig) {
    return newBuilder().setOrganization(organization).setMuteConfig(muteConfig).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderMuteConfigName(String folder, String muteConfig) {
    return newFolderMuteConfigBuilder()
        .setFolder(folder)
        .setMuteConfig(muteConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectMuteConfigName(String project, String muteConfig) {
    return newProjectMuteConfigBuilder()
        .setProject(project)
        .setMuteConfig(muteConfig)
        .build()
        .toString();
  }

  public static MuteConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_MUTE_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_MUTE_CONFIG.match(formattedString);
      return ofOrganizationMuteConfigName(
          matchMap.get("organization"), matchMap.get("mute_config"));
    } else if (FOLDER_MUTE_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_MUTE_CONFIG.match(formattedString);
      return ofFolderMuteConfigName(matchMap.get("folder"), matchMap.get("mute_config"));
    } else if (PROJECT_MUTE_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_MUTE_CONFIG.match(formattedString);
      return ofProjectMuteConfigName(matchMap.get("project"), matchMap.get("mute_config"));
    }
    throw new ValidationException("MuteConfigName.parse: formattedString not in valid format");
  }

  public static List<MuteConfigName> parseList(List<String> formattedStrings) {
    List<MuteConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MuteConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MuteConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_MUTE_CONFIG.matches(formattedString)
        || FOLDER_MUTE_CONFIG.matches(formattedString)
        || PROJECT_MUTE_CONFIG.matches(formattedString);
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
          if (muteConfig != null) {
            fieldMapBuilder.put("mute_config", muteConfig);
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
    if (o != null || getClass() == o.getClass()) {
      MuteConfigName that = ((MuteConfigName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.muteConfig, that.muteConfig)
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
    h ^= Objects.hashCode(muteConfig);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/muteConfigs/{mute_config}. */
  public static class Builder {
    private String organization;
    private String muteConfig;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getMuteConfig() {
      return muteConfig;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setMuteConfig(String muteConfig) {
      this.muteConfig = muteConfig;
      return this;
    }

    private Builder(MuteConfigName muteConfigName) {
      Preconditions.checkArgument(
          Objects.equals(muteConfigName.pathTemplate, ORGANIZATION_MUTE_CONFIG),
          "toBuilder is only supported when MuteConfigName has the pattern of organizations/{organization}/muteConfigs/{mute_config}");
      this.organization = muteConfigName.organization;
      this.muteConfig = muteConfigName.muteConfig;
    }

    public MuteConfigName build() {
      return new MuteConfigName(this);
    }
  }

  /** Builder for folders/{folder}/muteConfigs/{mute_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderMuteConfigBuilder {
    private String folder;
    private String muteConfig;

    protected FolderMuteConfigBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getMuteConfig() {
      return muteConfig;
    }

    public FolderMuteConfigBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderMuteConfigBuilder setMuteConfig(String muteConfig) {
      this.muteConfig = muteConfig;
      return this;
    }

    public MuteConfigName build() {
      return new MuteConfigName(this);
    }
  }

  /** Builder for projects/{project}/muteConfigs/{mute_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectMuteConfigBuilder {
    private String project;
    private String muteConfig;

    protected ProjectMuteConfigBuilder() {}

    public String getProject() {
      return project;
    }

    public String getMuteConfig() {
      return muteConfig;
    }

    public ProjectMuteConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectMuteConfigBuilder setMuteConfig(String muteConfig) {
      this.muteConfig = muteConfig;
      return this;
    }

    public MuteConfigName build() {
      return new MuteConfigName(this);
    }
  }
}
