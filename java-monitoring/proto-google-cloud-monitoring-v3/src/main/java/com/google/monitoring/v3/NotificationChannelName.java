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
public class NotificationChannelName implements ResourceName {

  @Deprecated
  protected NotificationChannelName() {}

  private static final PathTemplate PROJECT_NOTIFICATION_CHANNEL_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/notificationChannels/{notification_channel}");
  private static final PathTemplate ORGANIZATION_NOTIFICATION_CHANNEL_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/notificationChannels/{notification_channel}");
  private static final PathTemplate FOLDER_NOTIFICATION_CHANNEL_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/notificationChannels/{notification_channel}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String notificationChannel;
  private String organization;
  private String folder;

  public String getProject() {
    return project;
  }

  public String getNotificationChannel() {
    return notificationChannel;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  private NotificationChannelName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    notificationChannel = Preconditions.checkNotNull(builder.getNotificationChannel());
    pathTemplate = PROJECT_NOTIFICATION_CHANNEL_PATH_TEMPLATE;
  }

  private NotificationChannelName(OrganizationNotificationChannelBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    notificationChannel = Preconditions.checkNotNull(builder.getNotificationChannel());
    pathTemplate = ORGANIZATION_NOTIFICATION_CHANNEL_PATH_TEMPLATE;
  }

  private NotificationChannelName(FolderNotificationChannelBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    notificationChannel = Preconditions.checkNotNull(builder.getNotificationChannel());
    pathTemplate = FOLDER_NOTIFICATION_CHANNEL_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectNotificationChannelBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationNotificationChannelBuilder newOrganizationNotificationChannelBuilder() {
    return new OrganizationNotificationChannelBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderNotificationChannelBuilder newFolderNotificationChannelBuilder() {
    return new FolderNotificationChannelBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationChannelName of(String project, String notificationChannel) {
    return newProjectNotificationChannelBuilder()
        .setProject(project)
        .setNotificationChannel(notificationChannel)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationChannelName ofProjectNotificationChannelName(
      String project, String notificationChannel) {
    return newProjectNotificationChannelBuilder()
        .setProject(project)
        .setNotificationChannel(notificationChannel)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationChannelName ofOrganizationNotificationChannelName(
      String organization, String notificationChannel) {
    return newOrganizationNotificationChannelBuilder()
        .setOrganization(organization)
        .setNotificationChannel(notificationChannel)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationChannelName ofFolderNotificationChannelName(
      String folder, String notificationChannel) {
    return newFolderNotificationChannelBuilder()
        .setFolder(folder)
        .setNotificationChannel(notificationChannel)
        .build();
  }

  public static String format(String project, String notificationChannel) {
    return newBuilder()
        .setProject(project)
        .setNotificationChannel(notificationChannel)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectNotificationChannelName(
      String project, String notificationChannel) {
    return newBuilder()
        .setProject(project)
        .setNotificationChannel(notificationChannel)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationNotificationChannelName(
      String organization, String notificationChannel) {
    return newOrganizationNotificationChannelBuilder()
        .setOrganization(organization)
        .setNotificationChannel(notificationChannel)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderNotificationChannelName(
      String folder, String notificationChannel) {
    return newFolderNotificationChannelBuilder()
        .setFolder(folder)
        .setNotificationChannel(notificationChannel)
        .build()
        .toString();
  }

  public static NotificationChannelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_NOTIFICATION_CHANNEL_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_NOTIFICATION_CHANNEL_PATH_TEMPLATE.match(formattedString);
      return ofProjectNotificationChannelName(
          matchMap.get("project"), matchMap.get("notification_channel"));
    } else if (ORGANIZATION_NOTIFICATION_CHANNEL_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_NOTIFICATION_CHANNEL_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationNotificationChannelName(
          matchMap.get("organization"), matchMap.get("notification_channel"));
    } else if (FOLDER_NOTIFICATION_CHANNEL_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap =
          FOLDER_NOTIFICATION_CHANNEL_PATH_TEMPLATE.match(formattedString);
      return ofFolderNotificationChannelName(
          matchMap.get("folder"), matchMap.get("notification_channel"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<NotificationChannelName> parseList(List<String> formattedStrings) {
    List<NotificationChannelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationChannelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NotificationChannelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_NOTIFICATION_CHANNEL_PATH_TEMPLATE.matches(formattedString)
        || ORGANIZATION_NOTIFICATION_CHANNEL_PATH_TEMPLATE.matches(formattedString)
        || FOLDER_NOTIFICATION_CHANNEL_PATH_TEMPLATE.matches(formattedString);
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
          if (notificationChannel != null) {
            fieldMapBuilder.put("notification_channel", notificationChannel);
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

  /** Builder for projects/{project}/notificationChannels/{notification_channel}. */
  public static class Builder {

    private String project;
    private String notificationChannel;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getNotificationChannel() {
      return notificationChannel;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setNotificationChannel(String notificationChannel) {
      this.notificationChannel = notificationChannel;
      return this;
    }

    private Builder(NotificationChannelName notificationChannelName) {
      Preconditions.checkArgument(
          notificationChannelName.pathTemplate == PROJECT_NOTIFICATION_CHANNEL_PATH_TEMPLATE,
          "toBuilder is only supported when NotificationChannelName has the pattern of "
              + "projects/{project}/notificationChannels/{notification_channel}.");
      project = notificationChannelName.project;
      notificationChannel = notificationChannelName.notificationChannel;
    }

    public NotificationChannelName build() {
      return new NotificationChannelName(this);
    }
  }

  /** Builder for organizations/{organization}/notificationChannels/{notification_channel}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationNotificationChannelBuilder {

    private String organization;
    private String notificationChannel;

    private OrganizationNotificationChannelBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getNotificationChannel() {
      return notificationChannel;
    }

    public OrganizationNotificationChannelBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationNotificationChannelBuilder setNotificationChannel(
        String notificationChannel) {
      this.notificationChannel = notificationChannel;
      return this;
    }

    public NotificationChannelName build() {
      return new NotificationChannelName(this);
    }
  }

  /** Builder for folders/{folder}/notificationChannels/{notification_channel}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderNotificationChannelBuilder {

    private String folder;
    private String notificationChannel;

    private FolderNotificationChannelBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getNotificationChannel() {
      return notificationChannel;
    }

    public FolderNotificationChannelBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderNotificationChannelBuilder setNotificationChannel(String notificationChannel) {
      this.notificationChannel = notificationChannel;
      return this;
    }

    public NotificationChannelName build() {
      return new NotificationChannelName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      NotificationChannelName that = (NotificationChannelName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.notificationChannel, that.notificationChannel))
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
    h ^= Objects.hashCode(notificationChannel);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }
}
