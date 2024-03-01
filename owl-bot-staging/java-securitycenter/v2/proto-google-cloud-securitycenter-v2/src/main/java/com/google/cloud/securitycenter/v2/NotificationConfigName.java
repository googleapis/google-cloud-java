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

package com.google.cloud.securitycenter.v2;

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
  private static final PathTemplate ORGANIZATION_LOCATION_NOTIFICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/notificationConfigs/{notification_config}");
  private static final PathTemplate FOLDER_LOCATION_NOTIFICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/notificationConfigs/{notification_config}");
  private static final PathTemplate PROJECT_LOCATION_NOTIFICATION_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/notificationConfigs/{notification_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String notificationConfig;
  private final String folder;
  private final String project;

  @Deprecated
  protected NotificationConfigName() {
    organization = null;
    location = null;
    notificationConfig = null;
    folder = null;
    project = null;
  }

  private NotificationConfigName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
    folder = null;
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_NOTIFICATION_CONFIG;
  }

  private NotificationConfigName(FolderLocationNotificationConfigBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
    organization = null;
    project = null;
    pathTemplate = FOLDER_LOCATION_NOTIFICATION_CONFIG;
  }

  private NotificationConfigName(ProjectLocationNotificationConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_LOCATION_NOTIFICATION_CONFIG;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
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

  public static Builder newOrganizationLocationNotificationConfigBuilder() {
    return new Builder();
  }

  public static FolderLocationNotificationConfigBuilder
      newFolderLocationNotificationConfigBuilder() {
    return new FolderLocationNotificationConfigBuilder();
  }

  public static ProjectLocationNotificationConfigBuilder
      newProjectLocationNotificationConfigBuilder() {
    return new ProjectLocationNotificationConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationConfigName of(
      String organization, String location, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  public static NotificationConfigName ofOrganizationLocationNotificationConfigName(
      String organization, String location, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  public static NotificationConfigName ofFolderLocationNotificationConfigName(
      String folder, String location, String notificationConfig) {
    return newFolderLocationNotificationConfigBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  public static NotificationConfigName ofProjectLocationNotificationConfigName(
      String project, String location, String notificationConfig) {
    return newProjectLocationNotificationConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  public static String format(String organization, String location, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationNotificationConfigName(
      String organization, String location, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  public static String formatFolderLocationNotificationConfigName(
      String folder, String location, String notificationConfig) {
    return newFolderLocationNotificationConfigBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  public static String formatProjectLocationNotificationConfigName(
      String project, String location, String notificationConfig) {
    return newProjectLocationNotificationConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  public static NotificationConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_NOTIFICATION_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_NOTIFICATION_CONFIG.match(formattedString);
      return ofOrganizationLocationNotificationConfigName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("notification_config"));
    } else if (FOLDER_LOCATION_NOTIFICATION_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_NOTIFICATION_CONFIG.match(formattedString);
      return ofFolderLocationNotificationConfigName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("notification_config"));
    } else if (PROJECT_LOCATION_NOTIFICATION_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_NOTIFICATION_CONFIG.match(formattedString);
      return ofProjectLocationNotificationConfigName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("notification_config"));
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
    return ORGANIZATION_LOCATION_NOTIFICATION_CONFIG.matches(formattedString)
        || FOLDER_LOCATION_NOTIFICATION_CONFIG.matches(formattedString)
        || PROJECT_LOCATION_NOTIFICATION_CONFIG.matches(formattedString);
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
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NotificationConfigName that = ((NotificationConfigName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(notificationConfig);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/notificationConfigs/{notification_config}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String notificationConfig;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setNotificationConfig(String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    private Builder(NotificationConfigName notificationConfigName) {
      Preconditions.checkArgument(
          Objects.equals(
              notificationConfigName.pathTemplate, ORGANIZATION_LOCATION_NOTIFICATION_CONFIG),
          "toBuilder is only supported when NotificationConfigName has the pattern of organizations/{organization}/locations/{location}/notificationConfigs/{notification_config}");
      this.organization = notificationConfigName.organization;
      this.location = notificationConfigName.location;
      this.notificationConfig = notificationConfigName.notificationConfig;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }

  /**
   * Builder for folders/{folder}/locations/{location}/notificationConfigs/{notification_config}.
   */
  public static class FolderLocationNotificationConfigBuilder {
    private String folder;
    private String location;
    private String notificationConfig;

    protected FolderLocationNotificationConfigBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public FolderLocationNotificationConfigBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationNotificationConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationNotificationConfigBuilder setNotificationConfig(
        String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }

  /**
   * Builder for projects/{project}/locations/{location}/notificationConfigs/{notification_config}.
   */
  public static class ProjectLocationNotificationConfigBuilder {
    private String project;
    private String location;
    private String notificationConfig;

    protected ProjectLocationNotificationConfigBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public ProjectLocationNotificationConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationNotificationConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationNotificationConfigBuilder setNotificationConfig(
        String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }
}
