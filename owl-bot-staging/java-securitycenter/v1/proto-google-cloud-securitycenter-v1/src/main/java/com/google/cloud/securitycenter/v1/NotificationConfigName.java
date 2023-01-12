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
public class NotificationConfigName implements ResourceName {
  private static final PathTemplate ORGANIZATION_NOTIFICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/notificationConfigs/{notification_config}");
  private static final PathTemplate FOLDER_NOTIFICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/notificationConfigs/{notification_config}");
  private static final PathTemplate PROJECT_NOTIFICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/notificationConfigs/{notification_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String notificationConfig;
  private final String folder;
  private final String project;

  @Deprecated
  protected NotificationConfigName() {
    organization = null;
    notificationConfig = null;
    folder = null;
    project = null;
  }

  private NotificationConfigName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_NOTIFICATION_CONFIG;
  }

  private NotificationConfigName(FolderNotificationConfigBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
    organization = null;
    project = null;
    pathTemplate = FOLDER_NOTIFICATION_CONFIG;
  }

  private NotificationConfigName(ProjectNotificationConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_NOTIFICATION_CONFIG;
  }

  public String getOrganization() {
    return organization;
  }

  public String getNotificationConfig() {
    return notificationConfig;
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
  public static Builder newOrganizationNotificationConfigBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderNotificationConfigBuilder newFolderNotificationConfigBuilder() {
    return new FolderNotificationConfigBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectNotificationConfigBuilder newProjectNotificationConfigBuilder() {
    return new ProjectNotificationConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationConfigName of(String organization, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationConfigName ofOrganizationNotificationConfigName(
      String organization, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationConfigName ofFolderNotificationConfigName(
      String folder, String notificationConfig) {
    return newFolderNotificationConfigBuilder()
        .setFolder(folder)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationConfigName ofProjectNotificationConfigName(
      String project, String notificationConfig) {
    return newProjectNotificationConfigBuilder()
        .setProject(project)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  public static String format(String organization, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationNotificationConfigName(
      String organization, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderNotificationConfigName(
      String folder, String notificationConfig) {
    return newFolderNotificationConfigBuilder()
        .setFolder(folder)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectNotificationConfigName(
      String project, String notificationConfig) {
    return newProjectNotificationConfigBuilder()
        .setProject(project)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  public static NotificationConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_NOTIFICATION_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_NOTIFICATION_CONFIG.match(formattedString);
      return ofOrganizationNotificationConfigName(
          matchMap.get("organization"), matchMap.get("notification_config"));
    } else if (FOLDER_NOTIFICATION_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_NOTIFICATION_CONFIG.match(formattedString);
      return ofFolderNotificationConfigName(
          matchMap.get("folder"), matchMap.get("notification_config"));
    } else if (PROJECT_NOTIFICATION_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_NOTIFICATION_CONFIG.match(formattedString);
      return ofProjectNotificationConfigName(
          matchMap.get("project"), matchMap.get("notification_config"));
    }
    throw new ValidationException(
        "NotificationConfigName.parse: formattedString not in valid format");
  }

  public static List<NotificationConfigName> parseList(List<String> formattedStrings) {
    List<NotificationConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NotificationConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_NOTIFICATION_CONFIG.matches(formattedString)
        || FOLDER_NOTIFICATION_CONFIG.matches(formattedString)
        || PROJECT_NOTIFICATION_CONFIG.matches(formattedString);
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
          if (notificationConfig != null) {
            fieldMapBuilder.put("notification_config", notificationConfig);
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
      NotificationConfigName that = ((NotificationConfigName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.notificationConfig, that.notificationConfig)
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
    h ^= Objects.hashCode(notificationConfig);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/notificationConfigs/{notification_config}. */
  public static class Builder {
    private String organization;
    private String notificationConfig;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setNotificationConfig(String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    private Builder(NotificationConfigName notificationConfigName) {
      Preconditions.checkArgument(
          Objects.equals(notificationConfigName.pathTemplate, ORGANIZATION_NOTIFICATION_CONFIG),
          "toBuilder is only supported when NotificationConfigName has the pattern of organizations/{organization}/notificationConfigs/{notification_config}");
      this.organization = notificationConfigName.organization;
      this.notificationConfig = notificationConfigName.notificationConfig;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }

  /** Builder for folders/{folder}/notificationConfigs/{notification_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderNotificationConfigBuilder {
    private String folder;
    private String notificationConfig;

    protected FolderNotificationConfigBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public FolderNotificationConfigBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderNotificationConfigBuilder setNotificationConfig(String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }

  /** Builder for projects/{project}/notificationConfigs/{notification_config}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectNotificationConfigBuilder {
    private String project;
    private String notificationConfig;

    protected ProjectNotificationConfigBuilder() {}

    public String getProject() {
      return project;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public ProjectNotificationConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectNotificationConfigBuilder setNotificationConfig(String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }
}
